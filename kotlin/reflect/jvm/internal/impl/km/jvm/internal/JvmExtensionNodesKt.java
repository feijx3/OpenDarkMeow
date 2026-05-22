/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.ExtensionNodesKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeParameterExtension;
import org.jetbrains.annotations.NotNull;

public final class JvmExtensionNodesKt {
    @NotNull
    public static final JvmClassExtension getJvm(@NotNull KmClass $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmClassExtension kmClassExtension = ExtensionNodesKt.getExtension($this$jvm, JvmClassExtension.Companion.getTYPE());
        Intrinsics.checkNotNull(kmClassExtension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmClassExtension");
        return (JvmClassExtension)kmClassExtension;
    }

    @NotNull
    public static final JvmPackageExtension getJvm(@NotNull KmPackage $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmPackageExtension kmPackageExtension = ExtensionNodesKt.getExtension($this$jvm, JvmPackageExtension.TYPE);
        Intrinsics.checkNotNull(kmPackageExtension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmPackageExtension");
        return (JvmPackageExtension)kmPackageExtension;
    }

    @NotNull
    public static final JvmFunctionExtension getJvm(@NotNull KmFunction $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmFunctionExtension kmFunctionExtension = ExtensionNodesKt.getExtension($this$jvm, JvmFunctionExtension.TYPE);
        Intrinsics.checkNotNull(kmFunctionExtension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmFunctionExtension");
        return (JvmFunctionExtension)kmFunctionExtension;
    }

    @NotNull
    public static final JvmPropertyExtension getJvm(@NotNull KmProperty $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmPropertyExtension kmPropertyExtension = ExtensionNodesKt.getExtension($this$jvm, JvmPropertyExtension.TYPE);
        Intrinsics.checkNotNull(kmPropertyExtension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmPropertyExtension");
        return (JvmPropertyExtension)kmPropertyExtension;
    }

    @NotNull
    public static final JvmConstructorExtension getJvm(@NotNull KmConstructor $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmConstructorExtension kmConstructorExtension = ExtensionNodesKt.getExtension($this$jvm, JvmConstructorExtension.TYPE);
        Intrinsics.checkNotNull(kmConstructorExtension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmConstructorExtension");
        return (JvmConstructorExtension)kmConstructorExtension;
    }

    @NotNull
    public static final JvmTypeParameterExtension getJvm(@NotNull KmTypeParameter $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmTypeParameterExtension kmTypeParameterExtension = ExtensionNodesKt.getExtension($this$jvm, JvmTypeParameterExtension.TYPE);
        Intrinsics.checkNotNull(kmTypeParameterExtension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeParameterExtension");
        return (JvmTypeParameterExtension)kmTypeParameterExtension;
    }

    @NotNull
    public static final JvmTypeExtension getJvm(@NotNull KmType $this$jvm) {
        Intrinsics.checkNotNullParameter($this$jvm, "<this>");
        KmTypeExtension kmTypeExtension = ExtensionNodesKt.getExtension($this$jvm, JvmTypeExtension.TYPE);
        Intrinsics.checkNotNull(kmTypeExtension, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
        return (JvmTypeExtension)kmTypeExtension;
    }
}

