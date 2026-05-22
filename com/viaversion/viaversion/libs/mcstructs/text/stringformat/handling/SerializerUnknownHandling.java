/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;

@FunctionalInterface
public interface SerializerUnknownHandling {
    public static final SerializerUnknownHandling IGNORE = (formatting, output) -> null;
    public static final SerializerUnknownHandling THROW = (formatting, output) -> {
        throw new IllegalArgumentException("Unknown formatting: " + formatting);
    };

    public TextFormatting handle(TextFormatting var1, StringBuilder var2);
}

