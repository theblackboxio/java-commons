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
package io.theblackbox.commons.xml;

import io.theblackbox.commons.check.Check;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.function.Function;

public class XmlFunctionalAdapter<V, B>
        extends XmlAdapter<V, B> {

    private final Function<V,B> unmarshallFunction;
    private final Function<B,V> marshallFunction;

    protected XmlFunctionalAdapter(Function<V, B> unmarshallFunction, Function<B, V> marshallFunction) {
        Check.that(unmarshallFunction);
        Check.that(marshallFunction);
        this.unmarshallFunction = unmarshallFunction;
        this.marshallFunction = marshallFunction;
    }

    @Override
    public B unmarshal(V v) throws Exception {
        return unmarshallFunction.apply(v);
    }

    @Override
    public V marshal(B b) throws Exception {
        return marshallFunction.apply(b);
    }

    public static <V,B> XmlFunctionalAdapter<V,B> marshalling(Function<B,V> function) {
        return of(notImplementedFunction(), function);
    }

    public static <V,B> XmlFunctionalAdapter<V,B> unmarshalling(Function<V,B> function) {
        return of(function, notImplementedFunction());
    }

    public static <V,B> XmlFunctionalAdapter<V,B> of(Function<V,B> unmarshallFunction,
                                                     Function<B,V> marshallFunction) {
        return new XmlFunctionalAdapter<>(unmarshallFunction, marshallFunction);
    }

    static <E1,E2> Function<E1,E2> notImplementedFunction() {
        return (e) -> {
            throw new UnsupportedOperationException("This xml marshall/unmarshall operation has not been implemented");
        };
    }
}
