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
package io.theblackbox.commons.version;

import io.theblackbox.commons.check.Check;
import io.theblackbox.commons.optional.Optional;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;

@EqualsAndHashCode
public class Version implements Comparable<Version>, Serializable {
    private static final String SEPARATOR = ".";
    private static final String SEPARATOR_REGEXP = "\\.";

    private final int generation;
    private final int major;
    private final int minor;
    private final Optional<String> modifier;

    public Version(int generation, int major, int minor, Optional<String> modifier) {
        Check.that(generation).isPositiveOrZero();
        Check.that(major).isPositiveOrZero();
        Check.that(minor).isPositiveOrZero();
        this.generation = generation;
        this.major = major;
        this.minor = minor;
        this.modifier = modifier;
    }

    public static Version fromText(@NonNull String versionText) {
        int dashIndex = versionText.indexOf("-");
        Optional<String> modifier = Optional.absent();
        if (dashIndex >= 0) {
            modifier = Optional.of(versionText.substring(dashIndex+1, versionText.length()));
            versionText = versionText.substring(0, dashIndex);
        }
        String[] parts = versionText.split(SEPARATOR_REGEXP);
        if (parts.length != 3) {
            throw new IllegalArgumentException("Version should have 3 parts, found " + String.valueOf(parts.length));
        }
        String generationText = parts[0];
        String majorText = parts[1];
        String minorText = parts[2];

        int generation = Integer.parseInt(generationText);
        int major = Integer.parseInt(majorText);
        int minor = Integer.parseInt(minorText);

        return new Version(generation, major, minor, modifier);
    }

    public int getGeneration() {
        return generation;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public Optional<String> getModifier() {
        return modifier;
    }

    @Override
    public String toString() {
        return asText();
    }

    public String asText() {
        return generation + SEPARATOR + major + SEPARATOR + minor + modifier.map(m -> "-" + m).orElse("");
    }

    @Override
    public int compareTo(Version o) {
        int cmp = Integer.compare(this.generation, o.generation);
        if (cmp == 0) {
            cmp = Integer.compare(this.major, o.major);
            if (cmp == 0) {
                cmp = Integer.compare(this.minor, o.minor);
                if (cmp == 0) {
                    if (this.modifier.isAbsent() && o.modifier.isAbsent()) {
                        cmp = 0;
                    } else if (this.modifier.isAbsent() && o.modifier.isPresent()) {
                        cmp = -1;
                    } else if (this.modifier.isPresent() && o.modifier.isAbsent()) {
                        cmp = 1;
                    } else {
                        cmp = this.modifier.get().compareTo(o.modifier.get());
                    }
                }
            }
        }
        return cmp;
    }
}