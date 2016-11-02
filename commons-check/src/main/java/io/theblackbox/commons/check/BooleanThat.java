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

public class BooleanThat extends BaseThat<Boolean, BooleanThat> {

    public BooleanThat(Boolean subject) {
        super(subject);
    }

    /* is */
    BooleanThat is(boolean value, String overrideCheckName, Optional<Supplier<String>> message) {
        return conformsTo((x) -> x == value, overrideCheckName, message);
    }
    BooleanThat is(boolean value, Optional<Supplier<String>> message) {
        return is(value, "is (" + value + ")", message);
    }
    public BooleanThat is(boolean value, Supplier<String> message) {
        return is(value, Optional.of(message));
    }
    public BooleanThat is(boolean value, String message) {
        return is(value, () -> message);
    }
    public BooleanThat is(boolean value) {
        return is(value, Optional.empty());
    }

    /* isTrue */
    BooleanThat isTrue(String overrideCheckName, Optional<Supplier<String>> message) {
        return is(true, overrideCheckName, message);
    }
    BooleanThat isTrue(Optional<Supplier<String>> message) {
        return isTrue("isTrue", message);
    }
    public BooleanThat isTrue(Supplier<String> message) {
        return isTrue(Optional.of(message));
    }
    public BooleanThat isTrue(String message) {
        return isTrue(() -> message);
    }
    public BooleanThat isTrue() {
        return isTrue(Optional.empty());
    }

    /* isFalse */
    BooleanThat isFalse(String overrideCheckName, Optional<Supplier<String>> message) {
        return is(false, overrideCheckName, message);
    }
    BooleanThat isFalse(Optional<Supplier<String>> message) {
        return isFalse("isFalse", message);
    }
    public BooleanThat isFalse(Supplier<String> message) {
        return isFalse(Optional.of(message));
    }
    public BooleanThat isFalse(String message) {
        return isFalse(() -> message);
    }
    public BooleanThat isFalse() {
        return isFalse(Optional.empty());
    }

}
