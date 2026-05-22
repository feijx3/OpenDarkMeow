/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmName
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@JvmName(name="ClassNameKt")
public final class ClassNameKt {
    public static final boolean isLocalClassName(@NotNull String $this$isLocalClassName) {
        Intrinsics.checkNotNullParameter($this$isLocalClassName, "<this>");
        return StringsKt.startsWith$default($this$isLocalClassName, ".", false, 2, null);
    }
}

