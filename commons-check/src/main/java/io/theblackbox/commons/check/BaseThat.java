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
package io.theblackbox.commons.check;

import lombok.NonNull;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class BaseThat<E, T extends BaseThat<E,T>> extends AbstractThat<E, T> {

    BaseThat(E subject) {
        super(subject);
    }

    public BooleanThat on(@NonNull Predicate<E> predicate) {
        return Check.that(predicate.test(subject()));
    }

    /* conformsTo */
    T conformsTo(@NonNull Predicate<E> rule, String checkNameOverride, Optional<Supplier<String>> message) {
        return evaluate(() -> rule.test(subject()), checkNameOverride, message);
    }

    T conformsTo(@NonNull Predicate<E> rule, Optional<Supplier<String>> message) {
        return conformsTo(rule, "conformsTo", message);
    }
    public T conformsTo(@NonNull Predicate<E> rule, Supplier<String> message) {
        return conformsTo(rule, Optional.of(message));
    }
    public T conformsTo(@NonNull Predicate<E> rule, String message) {
        return conformsTo(rule, () -> message);
    }
    public T conformsTo(@NonNull Predicate<E> rule) {
        return conformsTo(rule, Optional.empty());
    }

    /* doesNotConformsTo */
    T doesNotConformsTo(@NonNull Predicate<E> rule, Optional<Supplier<String>> message) {
        return conformsTo((s) -> !rule.test(s), "doesNotConformsTo", message);
    }
    public T doesNotConformsTo(@NonNull Predicate<E> rule, Supplier<String> message) {
        return doesNotConformsTo(rule, Optional.of(message));
    }
    public T doesNotConformsTo(@NonNull Predicate<E> rule, String message) {
        return doesNotConformsTo(rule, () -> message);
    }
    public T doesNotConformsTo(@NonNull Predicate<E> rule) {
        return doesNotConformsTo(rule, Optional.empty());
    }

    /* equalsTo */
    T equalsTo(@NonNull E other, Optional<Supplier<String>> message) {
        return conformsTo(other::equals, "equalsTo", message);
    }
    public T equalsTo(@NonNull E other, Supplier<String> message) {
        return equalsTo(other, Optional.of(message));
    }
    public T equalsTo(@NonNull E other, String message) {
        return equalsTo(other, Optional.of(() -> message));
    }
    public T equalsTo(@NonNull E other) {
        return equalsTo(other, Optional.empty());
    }

    /* notEqualsTo */
    T notEqualsTo(@NonNull E other, Optional<Supplier<String>> message) {
        return conformsTo((s) -> !other.equals(s), "notEqualsTo", message);
    }
    public T notEqualsTo(@NonNull E other, Supplier<String> message) {
        return notEqualsTo(other, Optional.of(message));
    }
    public T notEqualsTo(@NonNull E other, String message) {
        return notEqualsTo(other, Optional.of(() -> message));
    }
    public T notEqualsTo(@NonNull E other) {
        return notEqualsTo(other, Optional.empty());
    }


}
