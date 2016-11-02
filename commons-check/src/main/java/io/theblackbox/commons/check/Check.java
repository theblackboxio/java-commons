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

import java.util.Collection;
import java.util.function.Predicate;

/**
 * Simple and fluent check library. Its purpose is to check the state of objects, and if conditions are not match then throw exceptions.
 */
public class Check {

    private Check() { }

    public static <E> CollectionThat<E> thatCollectionOf(@NonNull Collection<? extends E> collection) {
        return new CollectionThat<>(collection);
    }

    public static BooleanThat that(boolean booleanCondition) {
        return new BooleanThat(booleanCondition);
    }

    public static void thatIsFalse(boolean booleanCondition) {
        new BooleanThat(booleanCondition).isFalse();
    }

    public static void thatIsTrue(boolean booleanCondition) {
        new BooleanThat(booleanCondition).isTrue();
    }

    public static IntegerThat that(long number) {
        return new IntegerThat(number);
    }

    public static <E> GenericThat<E> that(@NonNull E object) {
        return new GenericThat<>(object);
    }

    public static <E> RuleThat<E> thatRule(@NonNull Predicate<E> rule) {
        return new RuleThat<>(rule);
    }

}
