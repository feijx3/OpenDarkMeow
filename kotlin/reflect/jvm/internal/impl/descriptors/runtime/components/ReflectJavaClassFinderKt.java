/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassFinderKt {
    @Nullable
    public static final Class<?> tryLoadClass(@NotNull ClassLoader $this$tryLoadClass, @NotNull String fqName) {
        Class<?> clazz;
        Intrinsics.checkNotNullParameter($this$tryLoadClass, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        try {
            clazz = Class.forName(fqName, false, $this$tryLoadClass);
        }
        catch (ClassNotFoundException e2) {
            clazz = null;
        }
        return clazz;
    }
}

