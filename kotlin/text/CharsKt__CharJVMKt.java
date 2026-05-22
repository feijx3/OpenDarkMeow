/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecatedSinceKotlin
 *  kotlin.PublishedApi
 *  kotlin.ReplaceWith
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharCategory;
import kotlin.text.CharDirectionality;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\r\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0002\u001a\r\u0010\u000f\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\u001a\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u001c\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\"\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010#\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020%H\u0000\u001a\u0010\u0010(\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u001f*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006)"}, d2={"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "isDefined", "", "isLetter", "isLetterOrDigit", "isDigit", "isIdentifierIgnorable", "isISOControl", "isJavaIdentifierPart", "isJavaIdentifierStart", "isWhitespace", "isUpperCase", "isLowerCase", "toUpperCase", "uppercaseChar", "uppercase", "", "locale", "Ljava/util/Locale;", "toLowerCase", "lowercaseChar", "lowercase", "isTitleCase", "toTitleCase", "titlecaseChar", "titlecase", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "isHighSurrogate", "isLowSurrogate", "digitOf", "", "char", "radix", "checkRadix", "kotlin-stdlib"}, xs="kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    @NotNull
    public static final CharCategory getCategory(char $this$category) {
        return CharCategory.Companion.valueOf(Character.getType($this$category));
    }

    @InlineOnly
    private static final boolean isDefined(char $this$isDefined) {
        return Character.isDefined($this$isDefined);
    }

    @InlineOnly
    private static final boolean isLetter(char $this$isLetter) {
        return Character.isLetter($this$isLetter);
    }

    @InlineOnly
    private static final boolean isLetterOrDigit(char $this$isLetterOrDigit) {
        return Character.isLetterOrDigit($this$isLetterOrDigit);
    }

    @InlineOnly
    private static final boolean isDigit(char $this$isDigit) {
        return Character.isDigit($this$isDigit);
    }

    @InlineOnly
    private static final boolean isIdentifierIgnorable(char $this$isIdentifierIgnorable) {
        return Character.isIdentifierIgnorable($this$isIdentifierIgnorable);
    }

    @InlineOnly
    private static final boolean isISOControl(char $this$isISOControl) {
        return Character.isISOControl($this$isISOControl);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierPart(char $this$isJavaIdentifierPart) {
        return Character.isJavaIdentifierPart($this$isJavaIdentifierPart);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierStart(char $this$isJavaIdentifierStart) {
        return Character.isJavaIdentifierStart($this$isJavaIdentifierStart);
    }

    public static final boolean isWhitespace(char $this$isWhitespace) {
        return Character.isWhitespace($this$isWhitespace) || Character.isSpaceChar($this$isWhitespace);
    }

    @InlineOnly
    private static final boolean isUpperCase(char $this$isUpperCase) {
        return Character.isUpperCase($this$isUpperCase);
    }

    @InlineOnly
    private static final boolean isLowerCase(char $this$isLowerCase) {
        return Character.isLowerCase($this$isLowerCase);
    }

    @Deprecated(message="Use uppercaseChar() instead.", replaceWith=@ReplaceWith(expression="uppercaseChar()", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.5", errorSince="2.1")
    @InlineOnly
    private static final char toUpperCase(char $this$toUpperCase) {
        return Character.toUpperCase($this$toUpperCase);
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final char uppercaseChar(char $this$uppercaseChar) {
        return Character.toUpperCase($this$uppercaseChar);
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final String uppercase(char $this$uppercase) {
        String string = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
        String string2 = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string2, "toUpperCase(...)");
        return string2;
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final String uppercase(char $this$uppercase, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String string = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
        String string2 = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(string2, "toUpperCase(...)");
        return string2;
    }

    @Deprecated(message="Use lowercaseChar() instead.", replaceWith=@ReplaceWith(expression="lowercaseChar()", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.5", errorSince="2.1")
    @InlineOnly
    private static final char toLowerCase(char $this$toLowerCase) {
        return Character.toLowerCase($this$toLowerCase);
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final char lowercaseChar(char $this$lowercaseChar) {
        return Character.toLowerCase($this$lowercaseChar);
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final String lowercase(char $this$lowercase) {
        String string = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
        String string2 = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
        return string2;
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final String lowercase(char $this$lowercase, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String string = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
        String string2 = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
        return string2;
    }

    @InlineOnly
    private static final boolean isTitleCase(char $this$isTitleCase) {
        return Character.isTitleCase($this$isTitleCase);
    }

    @Deprecated(message="Use titlecaseChar() instead.", replaceWith=@ReplaceWith(expression="titlecaseChar()", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.5", errorSince="2.1")
    @InlineOnly
    private static final char toTitleCase(char $this$toTitleCase) {
        return Character.toTitleCase($this$toTitleCase);
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final char titlecaseChar(char $this$titlecaseChar) {
        return Character.toTitleCase($this$titlecaseChar);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final String titlecase(char $this$titlecase, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String localizedUppercase = CharsKt.uppercase($this$titlecase, locale);
        if (localizedUppercase.length() > 1) {
            String string;
            if ($this$titlecase == '\u0149') {
                string = localizedUppercase;
            } else {
                char c2 = localizedUppercase.charAt(0);
                String string2 = localizedUppercase;
                int n2 = 1;
                Intrinsics.checkNotNull(string2, "null cannot be cast to non-null type java.lang.String");
                String string3 = string2.substring(n2);
                Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
                string2 = string3;
                Intrinsics.checkNotNull(string2, "null cannot be cast to non-null type java.lang.String");
                String string4 = string2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(string4, "toLowerCase(...)");
                string2 = string4;
                string = c2 + string2;
            }
            return string;
        }
        String string = String.valueOf($this$titlecase);
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type java.lang.String");
        String string5 = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string5, "toUpperCase(...)");
        if (!Intrinsics.areEqual(localizedUppercase, string5)) {
            return localizedUppercase;
        }
        return String.valueOf(Character.toTitleCase($this$titlecase));
    }

    @NotNull
    public static final CharDirectionality getDirectionality(char $this$directionality) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality($this$directionality));
    }

    @InlineOnly
    private static final boolean isHighSurrogate(char $this$isHighSurrogate) {
        return Character.isHighSurrogate($this$isHighSurrogate);
    }

    @InlineOnly
    private static final boolean isLowSurrogate(char $this$isLowSurrogate) {
        return Character.isLowSurrogate($this$isLowSurrogate);
    }

    public static final int digitOf(char c2, int radix) {
        return Character.digit((int)c2, radix);
    }

    @PublishedApi
    public static final int checkRadix(int radix) {
        if (!(2 <= radix ? radix < 37 : false)) {
            throw new IllegalArgumentException("radix " + radix + " was not in valid range " + new IntRange(2, 36));
        }
        return radix;
    }
}

