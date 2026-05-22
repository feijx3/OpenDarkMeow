/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import org.jetbrains.annotations.NotNull;

public final class TypeComponentPositionKt {
    public static final boolean shouldEnhance(@NotNull TypeComponentPosition $this$shouldEnhance) {
        Intrinsics.checkNotNullParameter((Object)$this$shouldEnhance, "<this>");
        return $this$shouldEnhance != TypeComponentPosition.INFLEXIBLE;
    }
}

