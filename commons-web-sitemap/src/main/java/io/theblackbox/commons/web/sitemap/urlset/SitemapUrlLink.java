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

import io.theblackbox.commons.web.sitemap.xml.SitemapUrlSitemapHreflangXmlAdapter;
import lombok.Builder;
import lombok.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Value
@Builder
@XmlAccessorType(value = XmlAccessType.FIELD)
public class SitemapUrlLink {

    public static final String ALTERNATE_REL = "alternate";

    @XmlAttribute(name = "rel")
    private final String rel;

    @XmlJavaTypeAdapter(SitemapUrlSitemapHreflangXmlAdapter.class)
    @XmlAttribute(name = "hreflang")
    private final SitemapHreflang hreflang;

    @XmlAttribute(name = "href")
    private final String href;

}
