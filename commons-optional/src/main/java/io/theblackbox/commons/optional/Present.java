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

import lombok.NonNull;

import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/*
 * This code was partially taken from Optional implementation of Google Guava library
 */
final class Present<T> extends Optional<T> {
    private final T reference;

    Present(T reference) {
        this.reference = reference;
    }

    @Override
    public boolean isPresent() {
        return true;
    }

    @Override
    public T get() {
        return reference;
    }

    @Override
    public T or(@NonNull T defaultValue) {
        return reference;
    }

    @Override
    public Optional<T> or(@NonNull Optional<? extends T> secondChoice) {
        return this;
    }

    @Override
    public T or(@NonNull Supplier<? extends T> supplier) {
        return reference;
    }

    @Override
    public T orNull() {
        return reference;
    }

    @Override
    public Set<T> asSet() {
        return Collections.singleton(reference);
    }

    @Override
    public <V> Optional<V> transform(@NonNull Function<? super T, V> function) {
        return new Present<>(function.apply(reference));
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Present) {
            Present<?> other = (Present<?>) object;
            return reference.equals(other.reference);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0x598df91c + reference.hashCode();
    }

    @Override
    public String toString() {
        return "Optional.of(" + reference + ")";
    }

    private static final long serialVersionUID = 0;
}
