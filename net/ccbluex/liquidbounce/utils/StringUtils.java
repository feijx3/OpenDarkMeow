/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/utils/StringUtils;", "", "<init>", "()V", "isBlank", "", "s", "", "isEmojiCharacter", "codePoint", "", "filterEmoji", "source", "DarkMeow"})
public final class StringUtils {
    @NotNull
    public static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public final boolean isBlank(@Nullable String s2) {
        if (s2 == null) {
            return true;
        }
        for (int i2 = 0; i2 < ((CharSequence)s2).length(); ++i2) {
            char element = ((CharSequence)s2).charAt(i2);
            if (Character.isWhitespace(element)) continue;
            return false;
        }
        return true;
    }

    private final boolean isEmojiCharacter(char codePoint) {
        return codePoint == '\u0000' || codePoint == '\t' || codePoint == '\n' || codePoint == '\r' || Intrinsics.compare(codePoint, 32) >= 0 && Intrinsics.compare(codePoint, 55295) <= 0 || Intrinsics.compare(codePoint, 57344) >= 0 && Intrinsics.compare(codePoint, 65533) <= 0 || codePoint >= '\u10000' && codePoint <= '\u10ffff';
    }

    @NotNull
    public final String filterEmoji(@NotNull String source) {
        String string;
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.isBlank(source)) {
            return source;
        }
        StringBuilder buf = null;
        int len = source.length();
        for (int i2 = 0; i2 < len; ++i2) {
            char codePoint = source.charAt(i2);
            if (!this.isEmojiCharacter(codePoint)) continue;
            if (buf == null) {
                buf = new StringBuilder(source.length());
            }
            buf.append(codePoint);
        }
        if (buf == null) {
            string = source;
        } else if (buf.length() == len) {
            string = source;
        } else {
            String string2 = buf.toString();
            Intrinsics.checkNotNull(string2);
            string = string2;
        }
        return string;
    }
}

