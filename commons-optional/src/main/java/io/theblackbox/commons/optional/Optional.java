/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.theblackbox.commons.optional;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * This code was partially taken from Optional implementation of Google Guava library
 */
public abstract class Optional<T> implements Serializable {


    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> of(@NonNull java.util.Optional<T> javaOptional) {
        if (javaOptional.isPresent()) {
            return of(javaOptional.get());
        } else {
            return absent();
        }
    }

    public static <T> Optional<T> of(@NonNull T reference) {
        return new Present<>(reference);
    }

    public static<T> Optional<T> empty() {
        return absent();
    }


    public static <T> Optional<T> fromNullable(T nullableReference) {
        return (nullableReference == null)
                ? Optional.<T>absent()
                : new Present<T>(nullableReference);
    }

    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public static <T> Optional<T> fromList(@NonNull List<T> list) {
        if (list.size() > 1) {
            throw new IllegalArgumentException("List should have 0 or 1 element to be transformed to an optional of instead found " + String.valueOf(list.size()));
        }
        if (list.isEmpty()) {
            return Optional.absent();
        } else {
            return Optional.of(list.get(0));
        }
    }

    Optional() {}


    public abstract boolean isPresent();

    public boolean isNotPresent() {
        return ! isPresent();
    }
    public boolean isAbsent() {
        return isNotPresent();
    }

    public abstract T get();

    @JsonValue
    public T getValue(){
        return this.orNull();
    }

    public Optional<T> ifPresent(@NonNull Consumer<? super T> consumer) {
        if (isPresent()) {
            consumer.accept(get());
        }
        return this;
    }

    public Optional<T> then(@NonNull Consumer<Optional<T>> consumer) {
        consumer.accept(this);
        return this;
    }

    public Optional<T> ifNotPresent(@NonNull Runnable runnable) {
        if (!isPresent()) {
            runnable.run();
        }
        return this;
    }

    public Optional<T> filter(@NonNull Predicate<? super T> predicate) {
        if (!isPresent())
            return this;
        else
            return predicate.test(get()) ? this : empty();
    }

    public Optional<T> filterNot(@NonNull Predicate<? super T> predicate) {
        if (!isPresent())
            return this;
        else
            return !predicate.test(get()) ? this : empty();
    }

    public<U> Optional<U> map(@NonNull Function<? super T, ? extends U> mapper) {
        if (!isPresent())
            return empty();
        else {
            return Optional.ofNullable(mapper.apply(get()));
        }
    }

    public<U> Optional<U> flatMap(@NonNull Function<? super T, Optional<U>> mapper) {
        if (!isPresent())
            return empty();
        else {
            return Objects.requireNonNull(mapper.apply(get()));
        }
    }

    public T orElse(T other) {
        return isPresent() ? get() : other;
    }

    public T orElseGet(@NonNull Supplier<? extends T> other) {
        return isPresent() ? get() : other.get();
    }


    public <X extends Throwable> T orElseThrow(@NonNull Supplier<? extends X> exceptionSupplier) throws X {
        if (isPresent()) {
            return get();
        } else {
            throw exceptionSupplier.get();
        }
    }



    public abstract T or(T defaultValue);


    public abstract Optional<T> or(Optional<? extends T> secondChoice);


    public abstract T or(Supplier<? extends T> supplier);


    public abstract T orNull();


    public abstract Set<T> asSet();


    public abstract <V> Optional<V> transform(Function<? super T, V> function);


    @Override
    public abstract boolean equals(Object object);


    @Override
    public abstract int hashCode();


    @Override
    public abstract String toString();

    private static final long serialVersionUID = 0;

}
