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

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

public class CollectionThat<E> extends BaseThat<Collection<? extends E>, CollectionThat<E>> {
    public CollectionThat(Collection<? extends E> subject) {
        super(subject);
    }

    /* isNotEmpty */
    public CollectionThat<E> isNotEmpty(Optional<Supplier<String>> message) {
        return evaluate(() -> !subject().isEmpty(), "isNotEmpty", message);
    }
    public CollectionThat<E> isNotEmpty(Supplier<String> message) {
        return isNotEmpty(Optional.of(message));
    }
    public CollectionThat<E> isNotEmpty(String message) {
        return isNotEmpty(() -> message);
    }
    public CollectionThat<E> isNotEmpty() {
        return isNotEmpty(Optional.empty());
    }

    /* isEmpty */
    public CollectionThat<E> isEmpty(Optional<Supplier<String>> message) {
        return evaluate(() -> subject().isEmpty(), "isEmpty", message);
    }
    public CollectionThat<E> isEmpty(Supplier<String> message) {
        return isEmpty(Optional.of(message));
    }
    public CollectionThat<E> isEmpty(String message) {
        return isEmpty(() -> message);
    }
    public CollectionThat<E> isEmpty() {
        return isEmpty(Optional.empty());
    }
    
    /* hasSize */
    public CollectionThat<E> hasSize(int size, Optional<Supplier<String>> message) {
        return evaluate(() -> subject().size() == size, "hasSize", message);
    }
    public CollectionThat<E> hasSize(int size, Supplier<String> message) {
        return hasSize(size, Optional.of(message));
    }
    public CollectionThat<E> hasSize(int size, String message) {
        return hasSize(size, () -> message);
    }
    public CollectionThat<E> hasSize(int size) {
        return hasSize(size, Optional.empty());
    }

    /* contains */
    public CollectionThat<E> contains(E element, Optional<Supplier<String>> message) {
        return evaluate(() -> subject().contains(element), "contains", message);
    }
    public CollectionThat<E> contains(E element, Supplier<String> message) {
        return contains(element, Optional.of(message));
    }
    public CollectionThat<E> contains(E element, String message) {
        return contains(element, () -> message);
    }
    public CollectionThat<E> contains(E element) {
        return contains(element, Optional.empty());
    }
    
    /* containsAll */
    public CollectionThat<E> containsAll(Collection<E> elements, Optional<Supplier<String>> message) {
        return evaluate(() -> subject().containsAll(elements), "containsAll", message);
    }
    public CollectionThat<E> containsAll(Collection<E> elements, Supplier<String> message) {
        return containsAll(elements, Optional.of(message));
    }
    public CollectionThat<E> containsAll(Collection<E> elements, String message) {
        return containsAll(elements, () -> message);
    }
    public CollectionThat<E> containsAll(Collection<E> elements) {
        return containsAll(elements, Optional.empty());
    }
    @SafeVarargs
    public final CollectionThat<E> containsAll(E... elements) {
        return containsAll(Arrays.asList(elements), Optional.empty());
    }

    /* isContainedBy */
    public CollectionThat<E> isContainedBy(Collection<E> elements, Optional<Supplier<String>> message) {
        return evaluate(() -> elements.containsAll(subject()), "isContainedBy", message);
    }
    public CollectionThat<E> isContainedBy(Collection<E> elements, Supplier<String> message) {
        return isContainedBy(elements, Optional.of(message));
    }
    public CollectionThat<E> isContainedBy(Collection<E> elements, String message) {
        return isContainedBy(elements, () -> message);
    }
    public CollectionThat<E> isContainedBy(Collection<E> elements) {
        return isContainedBy(elements, Optional.empty());
    }
    @SafeVarargs
    public final CollectionThat<E> isContainedBy(E... elements) {
        return isContainedBy(Arrays.asList(elements), Optional.empty());
    }

}
