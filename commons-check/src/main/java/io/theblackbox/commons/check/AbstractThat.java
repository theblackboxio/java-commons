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
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class AbstractThat<E, T extends AbstractThat<E,T>> {

    private final E subject;

    AbstractThat(E subject) {
        if (subject == null) {
            throw new NullPointerException("Subject to check is null");
        }
        this.subject = subject;
    }

    protected E subject() {
        return subject;
    }

    protected T evaluate(Supplier<Boolean> conditionToCheck, String checkName, Optional<Supplier<String>> message) {
        return  evaluate(conditionToCheck, IllegalArgumentException::new, checkName, message);
    }
    protected T evaluate(Supplier<Boolean> conditionToCheck, String checkName, Supplier<String> message) {
        return evaluate(conditionToCheck, IllegalArgumentException::new, checkName, Optional.of(message));
    }

    protected T evaluate(Supplier<Boolean> conditionToCheck, String checkName) {
        return evaluate(conditionToCheck, IllegalArgumentException::new, checkName, Optional.empty());
    }

    protected T evaluate(Supplier<Boolean> conditionToCheck, Function<String, ? extends RuntimeException> exceptionFactory, String checkName, Optional<Supplier<String>> message) {
        if (!conditionToCheck.get()) {
            String exceptionMessage =  "Check \"" + checkName + "\" failed on subject \"" + String.valueOf(subject()) + "\"" + message.map((m) -> " with message: " + m).orElse("");
            throw exceptionFactory.apply(exceptionMessage);
        }
        return (T) this;
    }
    protected T evaluate(Supplier<Boolean> conditionToCheck, Function<String, ? extends RuntimeException> exceptionFactory, String checkName, Supplier<String> message) {
        return evaluate(conditionToCheck, exceptionFactory, checkName, Optional.of(message));
    }

    protected T evaluate(Supplier<Boolean> conditionToCheck, Function<String, ? extends RuntimeException> exceptionFactory, String checkName) {
        return evaluate(conditionToCheck, exceptionFactory, checkName, Optional.empty());
    }

}
