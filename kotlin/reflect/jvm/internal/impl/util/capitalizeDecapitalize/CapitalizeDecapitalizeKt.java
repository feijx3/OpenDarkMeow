/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\ncapitalizeDecapitalize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 capitalizeDecapitalize.kt\norg/jetbrains/kotlin/util/capitalizeDecapitalize/CapitalizeDecapitalizeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n1#2:148\n295#3,2:149\n295#3,2:151\n774#3:153\n865#3,2:154\n1878#3,3:156\n*S KotlinDebug\n*F\n+ 1 capitalizeDecapitalize.kt\norg/jetbrains/kotlin/util/capitalizeDecapitalize/CapitalizeDecapitalizeKt\n*L\n34#1:149,2\n57#1:151,2\n72#1:153\n72#1:154,2\n78#1:156,3\n*E\n"})
public final class CapitalizeDecapitalizeKt {
    @NotNull
    public static final String decapitalizeSmartForCompiler(@NotNull String $this$decapitalizeSmartForCompiler, boolean asciiOnly) {
        Object v2;
        block8: {
            Intrinsics.checkNotNullParameter($this$decapitalizeSmartForCompiler, "<this>");
            if (((CharSequence)$this$decapitalizeSmartForCompiler).length() == 0 || !CapitalizeDecapitalizeKt.isUpperCaseCharAt($this$decapitalizeSmartForCompiler, 0, asciiOnly)) {
                return $this$decapitalizeSmartForCompiler;
            }
            if ($this$decapitalizeSmartForCompiler.length() == 1 || !CapitalizeDecapitalizeKt.isUpperCaseCharAt($this$decapitalizeSmartForCompiler, 1, asciiOnly)) {
                String string;
                if (asciiOnly) {
                    string = CapitalizeDecapitalizeKt.decapitalizeAsciiOnly($this$decapitalizeSmartForCompiler);
                } else {
                    String string2 = $this$decapitalizeSmartForCompiler;
                    if (((CharSequence)string2).length() > 0) {
                        char p0 = string2.charAt(0);
                        boolean $i$a$-replaceFirstCharWithChar-CapitalizeDecapitalizeKt$decapitalizeSmartForCompiler$22 = false;
                        char c2 = Character.toLowerCase(p0);
                        String $i$a$-replaceFirstCharWithChar-CapitalizeDecapitalizeKt$decapitalizeSmartForCompiler$22 = string2;
                        int n2 = 1;
                        String string3 = $i$a$-replaceFirstCharWithChar-CapitalizeDecapitalizeKt$decapitalizeSmartForCompiler$22.substring(n2);
                        Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
                        $i$a$-replaceFirstCharWithChar-CapitalizeDecapitalizeKt$decapitalizeSmartForCompiler$22 = string3;
                        string = c2 + $i$a$-replaceFirstCharWithChar-CapitalizeDecapitalizeKt$decapitalizeSmartForCompiler$22;
                    } else {
                        string = string2;
                    }
                }
                return string;
            }
            Iterable $this$firstOrNull$iv = StringsKt.getIndices($this$decapitalizeSmartForCompiler);
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                int it = ((Number)element$iv).intValue();
                boolean bl2 = false;
                if (!(!CapitalizeDecapitalizeKt.isUpperCaseCharAt($this$decapitalizeSmartForCompiler, it, asciiOnly))) continue;
                v2 = element$iv;
                break block8;
            }
            v2 = null;
        }
        Integer n3 = v2;
        if (n3 == null) {
            return CapitalizeDecapitalizeKt.toLowerCase($this$decapitalizeSmartForCompiler, asciiOnly);
        }
        int secondWordStart = n3 - 1;
        StringBuilder stringBuilder = new StringBuilder();
        String string = $this$decapitalizeSmartForCompiler.substring(0, secondWordStart);
        Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        StringBuilder stringBuilder2 = stringBuilder.append(CapitalizeDecapitalizeKt.toLowerCase(string, asciiOnly));
        String string4 = $this$decapitalizeSmartForCompiler.substring(secondWordStart);
        Intrinsics.checkNotNullExpressionValue(string4, "substring(...)");
        return stringBuilder2.append(string4).toString();
    }

    private static final boolean isUpperCaseCharAt(String $this$isUpperCaseCharAt, int index, boolean asciiOnly) {
        char c2 = $this$isUpperCaseCharAt.charAt(index);
        return asciiOnly ? ('A' <= c2 ? c2 < '[' : false) : Character.isUpperCase(c2);
    }

    private static final String toLowerCase(String string, boolean asciiOnly) {
        String string2;
        if (asciiOnly) {
            string2 = CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(string);
        } else {
            String string3 = string.toLowerCase(Locale.ROOT);
            string2 = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "toLowerCase(...)");
        }
        return string2;
    }

    @NotNull
    public static final String capitalizeAsciiOnly(@NotNull String $this$capitalizeAsciiOnly) {
        String string;
        Intrinsics.checkNotNullParameter($this$capitalizeAsciiOnly, "<this>");
        if (((CharSequence)$this$capitalizeAsciiOnly).length() == 0) {
            return $this$capitalizeAsciiOnly;
        }
        char c2 = $this$capitalizeAsciiOnly.charAt(0);
        boolean bl2 = 'a' <= c2 ? c2 < '{' : false;
        if (bl2) {
            StringBuilder stringBuilder;
            int n2 = $this$capitalizeAsciiOnly.length();
            StringBuilder $this$capitalizeAsciiOnly_u24lambda_u244 = stringBuilder = new StringBuilder(n2);
            boolean bl3 = false;
            $this$capitalizeAsciiOnly_u24lambda_u244.append(Character.toUpperCase(c2));
            $this$capitalizeAsciiOnly_u24lambda_u244.append($this$capitalizeAsciiOnly, 1, $this$capitalizeAsciiOnly.length());
            string = stringBuilder.toString();
        } else {
            string = $this$capitalizeAsciiOnly;
        }
        return string;
    }

    @NotNull
    public static final String decapitalizeAsciiOnly(@NotNull String $this$decapitalizeAsciiOnly) {
        String string;
        Intrinsics.checkNotNullParameter($this$decapitalizeAsciiOnly, "<this>");
        if (((CharSequence)$this$decapitalizeAsciiOnly).length() == 0) {
            return $this$decapitalizeAsciiOnly;
        }
        char c2 = $this$decapitalizeAsciiOnly.charAt(0);
        boolean bl2 = 'A' <= c2 ? c2 < '[' : false;
        if (bl2) {
            char c3 = Character.toLowerCase(c2);
            String string2 = $this$decapitalizeAsciiOnly.substring(1);
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
            String string3 = string2;
            string = c3 + string3;
        } else {
            string = $this$decapitalizeAsciiOnly;
        }
        return string;
    }

    @NotNull
    public static final String toLowerCaseAsciiOnly(@NotNull String $this$toLowerCaseAsciiOnly) {
        Intrinsics.checkNotNullParameter($this$toLowerCaseAsciiOnly, "<this>");
        StringBuilder builder = new StringBuilder($this$toLowerCaseAsciiOnly.length());
        int n2 = $this$toLowerCaseAsciiOnly.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = $this$toLowerCaseAsciiOnly.charAt(i2);
            builder.append(('A' <= c2 ? c2 < '[' : false) ? Character.toLowerCase(c2) : c2);
        }
        String string = builder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}

