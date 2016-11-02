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
package io.theblackbox.commons.web.sitemap.index;

import io.theblackbox.commons.web.sitemap.xml.SitemapUrlLocalDateXmlAdapter;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Sitemap {

    @XmlElement(name = "loc")
    private
    @NonNull
    String loc = "/";
    @XmlElement(name = "lastmod")
    @XmlJavaTypeAdapter(SitemapUrlLocalDateXmlAdapter.class)
    private
    @NonNull
    LocalDate lastModificationDate = LocalDate.now();

    public Sitemap() {
    }


}
