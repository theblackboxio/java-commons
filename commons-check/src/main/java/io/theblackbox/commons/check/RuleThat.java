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

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class RuleThat<E> extends BaseThat<Predicate<E>, RuleThat<E>> {


    RuleThat(Predicate<E> subject) {
        super(subject);
    }

    public RuleThat<E> appliesTo(@NonNull E subject) {
        if (!subject().test(subject)) {
            throw new IllegalArgumentException("Subject " + subject + " does not conform to " + subject());
        }
        return this;
    }

    @SafeVarargs
    public final RuleThat<E> appliesToAll(@NonNull E subject1, E... subjects) {
        appliesTo(subject1);
        Arrays.asList(subjects)
                .stream()
                .forEach(this::appliesTo);
        return this;
    }

    public final RuleThat<E> appliesToAll(@NonNull Collection<E> subjects) {
        subjects
                .stream()
                .forEach(this::appliesTo);
        return this;
    }
}
