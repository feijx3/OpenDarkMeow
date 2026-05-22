/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import org.jetbrains.annotations.NotNull;

public final class ExtensionNodesKt {
    @NotNull
    public static final KmClassExtension getExtension(@NotNull KmClass $this$getExtension, @NotNull KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmClassExtension)ExtensionNodesKt.singleOfType((Collection)$this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    @NotNull
    public static final KmPackageExtension getExtension(@NotNull KmPackage $this$getExtension, @NotNull KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmPackageExtension)ExtensionNodesKt.singleOfType((Collection)$this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    @NotNull
    public static final KmFunctionExtension getExtension(@NotNull KmFunction $this$getExtension, @NotNull KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmFunctionExtension)ExtensionNodesKt.singleOfType((Collection)$this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    @NotNull
    public static final KmPropertyExtension getExtension(@NotNull KmProperty $this$getExtension, @NotNull KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmPropertyExtension)ExtensionNodesKt.singleOfType((Collection)$this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    @NotNull
    public static final KmConstructorExtension getExtension(@NotNull KmConstructor $this$getExtension, @NotNull KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmConstructorExtension)ExtensionNodesKt.singleOfType((Collection)$this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    @NotNull
    public static final KmTypeParameterExtension getExtension(@NotNull KmTypeParameter $this$getExtension, @NotNull KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmTypeParameterExtension)ExtensionNodesKt.singleOfType((Collection)$this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    @NotNull
    public static final KmTypeExtension getExtension(@NotNull KmType $this$getExtension, @NotNull KmExtensionType type) {
        Intrinsics.checkNotNullParameter($this$getExtension, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmTypeExtension)ExtensionNodesKt.singleOfType((Collection)$this$getExtension.getExtensions$kotlin_metadata(), type);
    }

    private static final <N extends KmExtension> N singleOfType(Collection<? extends N> $this$singleOfType, KmExtensionType type) {
        KmExtension result = null;
        for (KmExtension node : $this$singleOfType) {
            if (!Intrinsics.areEqual(node.getType(), type)) continue;
            if (result != null) {
                throw new IllegalStateException("Multiple extensions handle the same extension type: " + type);
            }
            result = node;
        }
        if (result == null) {
            throw new IllegalStateException("No extensions handle the extension type: " + type);
        }
        return (N)result;
    }
}

