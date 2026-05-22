/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KmExtensionType {
    @NotNull
    private final KClass<? extends KmExtension> klass;

    public KmExtensionType(@NotNull KClass<? extends KmExtension> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KmExtensionType && Intrinsics.areEqual(this.klass, ((KmExtensionType)other).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @NotNull
    public String toString() {
        String string = JvmClassMappingKt.getJavaClass(this.klass).getName();
        Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
        return string;
    }
}

