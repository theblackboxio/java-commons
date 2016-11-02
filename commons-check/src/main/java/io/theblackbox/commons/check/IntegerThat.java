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

import java.util.Optional;
import java.util.function.Supplier;

public class IntegerThat extends BaseThat<Long, IntegerThat> {

    IntegerThat(long number) {
        super(number);
    }

    /* isGreaterThan */
    public IntegerThat isGreaterThan(long value, Optional<Supplier<String>> message) {
        return evaluate(() -> subject() > value, "isGreaterThan (" + value + ")", message);
    }
    public IntegerThat isGreaterThan(long value, Supplier<String> message) {
        return isGreaterThan(value, Optional.of(message));
    }
    public IntegerThat isGreaterThan(long value, String message) {
        return isGreaterThan(value, () -> message);
    }
    public IntegerThat isGreaterThan(long value) {
        return isGreaterThan(value, Optional.empty());
    }

    /* isGreaterOrEqualsThan */
    public IntegerThat isGreaterOrEqualsThan(long value, Optional<Supplier<String>> message) {
        return evaluate(() -> subject() >= value, "isGreaterOrEqualsThan (" + value + ")", message);
    }
    public IntegerThat isGreaterOrEqualsThan(long value, Supplier<String> message) {
        return isGreaterOrEqualsThan(value, Optional.of(message));
    }
    public IntegerThat isGreaterOrEqualsThan(long value, String message) {
        return isGreaterOrEqualsThan(value, () -> message);
    }
    public IntegerThat isGreaterOrEqualsThan(long value) {
        return isGreaterOrEqualsThan(value, Optional.empty());
    }
    
    /* isZero */
    public IntegerThat isZero(Optional<Supplier<String>> message) {
        return evaluate(() -> subject() == 0L, "isZero", message);
    }
    public IntegerThat isZero(Supplier<String> message) {
        return isZero(Optional.of(message));
    }
    public IntegerThat isZero(String message) {
        return isZero(() -> message);
    }
    public IntegerThat isZero() {
        return isZero(Optional.empty());
    }

    /* isPositive */
    public IntegerThat isPositive(Optional<Supplier<String>> message) {
        return evaluate(() -> subject() > 0L, "isPositive", message);
    }
    public IntegerThat isPositive(Supplier<String> message) {
        return isPositive(Optional.of(message));
    }
    public IntegerThat isPositive(String message) {
        return isPositive(() -> message);
    }
    public IntegerThat isPositive() {
        return isPositive(Optional.empty());
    }

    /* isPositiveOrZero */
    public IntegerThat isPositiveOrZero(Optional<Supplier<String>> message) {
        return evaluate(() -> subject() >= 0L, "isPositiveOrZero", message);
    }
    public IntegerThat isPositiveOrZero(Supplier<String> message) {
        return isPositiveOrZero(Optional.of(message));
    }
    public IntegerThat isPositiveOrZero(String message) {
        return isPositiveOrZero(() -> message);
    }
    public IntegerThat isPositiveOrZero() {
        return isPositiveOrZero(Optional.empty());
    }


    /* isNegative */
    public IntegerThat isNegative(Optional<Supplier<String>> message) {
        return evaluate(() -> subject() < 0L, "isNegative", message);
    }
    public IntegerThat isNegative(Supplier<String> message) {
        return isNegative(Optional.of(message));
    }
    public IntegerThat isNegative(String message) {
        return isNegative(() -> message);
    }
    public IntegerThat isNegative() {
        return isNegative(Optional.empty());
    }

    /* isNegativeOrZero */
    public IntegerThat isNegativeOrZero(Optional<Supplier<String>> message) {
        return evaluate(() -> subject() <= 0L, "isNegativeOrZero", message);
    }
    public IntegerThat isNegativeOrZero(Supplier<String> message) {
        return isNegativeOrZero(Optional.of(message));
    }
    public IntegerThat isNegativeOrZero(String message) {
        return isNegativeOrZero(() -> message);
    }
    public IntegerThat isNegativeOrZero() {
        return isNegativeOrZero(Optional.empty());
    }



}
