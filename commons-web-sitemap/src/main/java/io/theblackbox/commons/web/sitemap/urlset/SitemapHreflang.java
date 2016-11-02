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
package io.theblackbox.commons.web.sitemap.urlset;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class SitemapHreflang {
    private
    @NonNull
    final String countryIsoCode2;
    private
    @NonNull
    final String languageIsoCode2;

    public String asHreflang() {
        return languageIsoCode2.toLowerCase() + "-" + countryIsoCode2.toLowerCase();
    }

}
