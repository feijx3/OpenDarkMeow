/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Deprecated
public class LegacyStringUtils {
    @Deprecated
    public static LegacyStyle getStyleAt(String s2, int position, boolean unknownWhite) {
        return LegacyStringUtils.getStyleAt(s2, position, c2 -> {
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
    public static LegacyStyle getStyleAt(String s2, int position, Function<Character, TextFormatting> formattingResolver) {
        char[] chars = s2.toCharArray();
        LegacyStyle legacyStyle = new LegacyStyle();
        for (int i2 = 0; i2 < Math.min(chars.length, position); ++i2) {
            char code;
            TextFormatting formatting;
            char c2 = chars[i2];
            if (c2 != '\u00a7' || i2 + 1 >= chars.length || (formatting = formattingResolver.apply(Character.valueOf(code = chars[++i2]))) == null) continue;
            if (TextFormatting.RESET.equals(formatting)) {
                legacyStyle.setColor(null);
                legacyStyle.getStyles().clear();
                continue;
            }
            if (formatting.isColor()) {
                legacyStyle.setColor(formatting);
                legacyStyle.getStyles().clear();
                continue;
            }
            legacyStyle.getStyles().add(formatting);
        }
        return legacyStyle;
    }

    @Deprecated
    public static String[] split(String s2, String split, boolean unknownWhite) {
        return LegacyStringUtils.split(s2, split, c2 -> {
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
    public static String[] split(String s2, String split, Function<Character, TextFormatting> formattingResolver) {
        String[] parts = s2.split(Pattern.quote(split));
        for (int i2 = 1; i2 < parts.length; ++i2) {
            String prev = parts[i2 - 1];
            LegacyStyle style = LegacyStringUtils.getStyleAt(prev, prev.length(), formattingResolver);
            parts[i2] = style.toLegacy() + parts[i2];
        }
        return parts;
    }

    @Deprecated
    public static class LegacyStyle {
        private TextFormatting color = null;
        private final Set<TextFormatting> styles = new HashSet<TextFormatting>();

        private LegacyStyle() {
        }

        public void setColor(@Nullable TextFormatting color) {
            this.color = color;
        }

        @Nullable
        public TextFormatting getColor() {
            return this.color;
        }

        @Nonnull
        public Set<TextFormatting> getStyles() {
            return this.styles;
        }

        public String toLegacy() {
            StringBuilder out = new StringBuilder();
            if (this.color != null) {
                out.append(this.color.toLegacy());
            }
            for (TextFormatting style : this.styles) {
                out.append(style.toLegacy());
            }
            return out.toString();
        }

        public boolean equals(Object o2) {
            if (this == o2) {
                return true;
            }
            if (o2 == null || this.getClass() != o2.getClass()) {
                return false;
            }
            LegacyStyle that = (LegacyStyle)o2;
            return Objects.equals(this.color, that.color) && Objects.equals(this.styles, that.styles);
        }

        public int hashCode() {
            return Objects.hash(this.color, this.styles);
        }

        public String toString() {
            return ToString.of(this).add("color", this.color).add("styles", this.styles).toString();
        }
    }
}

