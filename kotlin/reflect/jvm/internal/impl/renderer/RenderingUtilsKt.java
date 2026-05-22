/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nRenderingUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,78:1\n1088#2,2:79\n*S KotlinDebug\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n*L\n30#1:79,2\n*E\n"})
public final class RenderingUtilsKt {
    @NotNull
    public static final String render(@NotNull Name $this$render) {
        String string;
        Intrinsics.checkNotNullParameter($this$render, "<this>");
        if (RenderingUtilsKt.shouldBeEscaped($this$render)) {
            StringBuilder stringBuilder = new StringBuilder();
            char c2 = '`';
            String string2 = $this$render.asString();
            Intrinsics.checkNotNullExpressionValue(string2, "asString(...)");
            String string3 = string2;
            string = stringBuilder.append(c2 + string3).append('`').toString();
        } else {
            String string4 = $this$render.asString();
            string = string4;
            Intrinsics.checkNotNullExpressionValue(string4, "asString(...)");
        }
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean shouldBeEscaped(Name $this$shouldBeEscaped) {
        String string = $this$shouldBeEscaped.asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        String string2 = string;
        if (KeywordStringsGenerated.KEYWORDS.contains(string2)) return true;
        CharSequence $this$any$iv = string2;
        boolean $i$f$any = false;
        for (int i2 = 0; i2 < $this$any$iv.length(); ++i2) {
            char element$iv;
            char it = element$iv = $this$any$iv.charAt(i2);
            boolean bl2 = false;
            if (!Character.isLetterOrDigit(it) && it != '_') {
                return true;
            }
            boolean bl3 = false;
            if (!bl3) continue;
            return true;
        }
        boolean bl4 = false;
        if (bl4) return true;
        if (((CharSequence)string2).length() == 0) {
            return true;
        }
        boolean bl5 = false;
        if (bl5) return true;
        if (Character.isJavaIdentifierStart(string2.codePointAt(0))) return false;
        return true;
    }

    @NotNull
    public static final String render(@NotNull FqNameUnsafe $this$render) {
        Intrinsics.checkNotNullParameter($this$render, "<this>");
        return RenderingUtilsKt.renderFqName($this$render.pathSegments());
    }

    @NotNull
    public static final String renderFqName(@NotNull List<Name> pathSegments) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        StringBuilder $this$renderFqName_u24lambda_u241 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        for (Name element : pathSegments) {
            if ($this$renderFqName_u24lambda_u241.length() > 0) {
                $this$renderFqName_u24lambda_u241.append(".");
            }
            $this$renderFqName_u24lambda_u241.append(RenderingUtilsKt.render(element));
        }
        return stringBuilder.toString();
    }

    @Nullable
    public static final String replacePrefixesInTypeRepresentations(@NotNull String lowerRendered, @NotNull String lowerPrefix, @NotNull String upperRendered, @NotNull String upperPrefix, @NotNull String foldedPrefix) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(lowerPrefix, "lowerPrefix");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(upperPrefix, "upperPrefix");
        Intrinsics.checkNotNullParameter(foldedPrefix, "foldedPrefix");
        if (StringsKt.startsWith$default(lowerRendered, lowerPrefix, false, 2, null) && StringsKt.startsWith$default(upperRendered, upperPrefix, false, 2, null)) {
            String string = lowerRendered.substring(lowerPrefix.length());
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
            String lowerWithoutPrefix = string;
            String string2 = upperRendered.substring(upperPrefix.length());
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
            String upperWithoutPrefix = string2;
            String flexibleCollectionName = foldedPrefix + lowerWithoutPrefix;
            if (Intrinsics.areEqual(lowerWithoutPrefix, upperWithoutPrefix)) {
                return flexibleCollectionName;
            }
            if (RenderingUtilsKt.typeStringsDifferOnlyInNullability(lowerWithoutPrefix, upperWithoutPrefix)) {
                return flexibleCollectionName + '!';
            }
        }
        return null;
    }

    public static final boolean typeStringsDifferOnlyInNullability(@NotNull String lower, @NotNull String upper) {
        Intrinsics.checkNotNullParameter(lower, "lower");
        Intrinsics.checkNotNullParameter(upper, "upper");
        return Intrinsics.areEqual(lower, StringsKt.replace$default(upper, "?", "", false, 4, null)) || StringsKt.endsWith$default(upper, "?", false, 2, null) && Intrinsics.areEqual(lower + '?', upper) || Intrinsics.areEqual('(' + lower + ")?", upper);
    }
}

