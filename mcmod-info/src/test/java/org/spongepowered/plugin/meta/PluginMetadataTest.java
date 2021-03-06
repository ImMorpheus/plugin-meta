/*
 * This file is part of plugin-meta, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.plugin.meta;

import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.spongepowered.plugin.meta.PluginMetadata.ID_PATTERN;

class PluginMetadataTest {
    @Test
    void testIdPattern() {
        // must be at least 2 characters
        assertFalse(ID_PATTERN.matcher("a").matches());

        assertTrue(ID_PATTERN.matcher("ab").matches());
        assertTrue(ID_PATTERN.matcher("a0").matches());

        // must start with a-z
        assertFalse(ID_PATTERN.matcher("0a").matches());

        // cannot contain uppercase characters
        assertFalse(ID_PATTERN.matcher("Ab").matches());
        assertFalse(ID_PATTERN.matcher("aB").matches());

        // up to 64 characters
        assertTrue(ID_PATTERN.matcher(Strings.repeat("a", 64)).matches());
        // but no longer
        assertFalse(ID_PATTERN.matcher(Strings.repeat("a", 65)).matches());
    }
}
