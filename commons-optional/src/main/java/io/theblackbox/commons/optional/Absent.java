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
final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = new Absent<Object>();

    @SuppressWarnings("unchecked")
    static <T> Optional<T> withType() {
        return (Optional<T>) INSTANCE;
    }

    private Absent() {}

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override
    public T or(T defaultValue) {
        return defaultValue;
    }

    @SuppressWarnings("unchecked") // safe covariant cast
    @Override
    public Optional<T> or(@NonNull Optional<? extends T> secondChoice) {
        return (Optional<T>) secondChoice;
    }

    @Override
    public T or(@NonNull Supplier<? extends T> supplier) {
        return supplier.get();
    }

    @Override
    public T orNull() {
        return null;
    }

    @Override
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override
    public <V> Optional<V> transform(@NonNull Function<? super T, V> function) {
        return Optional.absent();
    }

    @Override
    public boolean equals(Object object) {
        return object == this;
    }

    @Override
    public int hashCode() {
        return 0x79a31aac;
    }

    @Override
    public String toString() {
        return "Optional.absent()";
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private static final long serialVersionUID = 0;
}
