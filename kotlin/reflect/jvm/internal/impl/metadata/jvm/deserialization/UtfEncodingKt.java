/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nutfEncoding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utfEncoding.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/UtfEncodingKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n37#2:74\n36#2,3:75\n1#3:78\n*S KotlinDebug\n*F\n+ 1 utfEncoding.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/UtfEncodingKt\n*L\n55#1:74\n55#1:75,3\n*E\n"})
public final class UtfEncodingKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final byte[] stringsToBytes(@NotNull String[] strings) {
        int n2;
        Intrinsics.checkNotNullParameter(strings, "strings");
        String[] stringArray = strings;
        int n3 = 0;
        int n4 = stringArray.length;
        for (n2 = 0; n2 < n4; ++n2) {
            void it;
            String string;
            String string2 = string = stringArray[n2];
            int n5 = n3;
            boolean bl2 = false;
            int n6 = it.length();
            n3 = n5 + n6;
        }
        int resultLength = n3;
        byte[] result = new byte[resultLength];
        int i2 = 0;
        n4 = strings.length;
        for (n2 = 0; n2 < n4; ++n2) {
            String s2 = strings[n2];
            int n7 = s2.length();
            for (int si = 0; si < n7; ++si) {
                result[i2++] = (byte)s2.charAt(si);
            }
        }
        int n8 = n2 = i2 == result.length ? 1 : 0;
        if (_Assertions.ENABLED && n2 == 0) {
            boolean bl3 = false;
            String string = "Should have reached the end";
            throw new AssertionError((Object)string);
        }
        return result;
    }
}

