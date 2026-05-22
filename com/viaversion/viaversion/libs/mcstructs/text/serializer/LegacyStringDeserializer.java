/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer;

import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import java.util.function.Function;
import java.util.function.Supplier;

@Deprecated
public class LegacyStringDeserializer {
    @Deprecated
    public static TextComponent parse(String s2, boolean unknownWhite) {
        return LegacyStringDeserializer.parse(s2, '\u00a7', unknownWhite);
    }

    @Deprecated
    public static TextComponent parse(String s2, char colorChar, boolean unknownWhite) {
        return LegacyStringDeserializer.parse(s2, colorChar, c2 -> {
            TextFormatting formatting = TextFormatting.getByCode(c2.charValue());
            if (formatting == null) {
                if (unknownWhite) {
                    return TextFormatting.WHITE;
                }
                return null;
            }
            return formatting;
        });
    }

    @Deprecated
    public static TextComponent parse(String s2, char colorChar, Function<Character, TextFormatting> formattingResolver) {
        return LegacyStringDeserializer.parse(s2, colorChar, Style::new, formattingResolver);
    }

    @Deprecated
    public static TextComponent parse(String s2, char colorChar, Supplier<Style> styleSupplier, Function<Character, TextFormatting> formattingResolver) {
        char[] chars = s2.toCharArray();
        Style style = styleSupplier.get();
        StringBuilder currentPart = new StringBuilder();
        StringComponent out = new StringComponent("");
        for (int i2 = 0; i2 < chars.length; ++i2) {
            char c2 = chars[i2];
            if (c2 == colorChar) {
                char format;
                TextFormatting formatting;
                if (i2 + 1 >= chars.length || (formatting = formattingResolver.apply(Character.valueOf(format = chars[++i2]))) == null) continue;
                if (currentPart.length() != 0) {
                    out.append(new StringComponent(currentPart.toString()).setStyle(style.copy()));
                    currentPart = new StringBuilder();
                    if (formatting.isColor() || TextFormatting.RESET.equals(formatting)) {
                        style = styleSupplier.get();
                    }
                }
                style.setFormatting(formatting);
                continue;
            }
            currentPart.append(c2);
        }
        if (currentPart.length() != 0) {
            out.append(new StringComponent(currentPart.toString()).setStyle(style));
        }
        if (out.getSiblings().size() == 1) {
            return out.getSiblings().get(0);
        }
        return out;
    }
}

