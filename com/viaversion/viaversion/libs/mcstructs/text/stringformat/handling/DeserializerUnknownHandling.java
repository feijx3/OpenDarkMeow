/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.ResolvedFormatting;

@FunctionalInterface
public interface DeserializerUnknownHandling {
    public static final DeserializerUnknownHandling WHITE = (resolved, currentText) -> TextFormatting.WHITE;
    public static final DeserializerUnknownHandling IGNORE = (resolved, currentText) -> null;
    public static final DeserializerUnknownHandling RESET = (resolved, currentText) -> TextFormatting.RESET;
    public static final DeserializerUnknownHandling TEXT = (resolved, currentText) -> {
        currentText.append(resolved.raw());
        return null;
    };
    public static final DeserializerUnknownHandling THROW = (resolved, currentText) -> {
        throw new IllegalArgumentException("Unknown formatting code: " + resolved.raw());
    };

    public TextFormatting handle(ResolvedFormatting var1, StringBuilder var2);
}

