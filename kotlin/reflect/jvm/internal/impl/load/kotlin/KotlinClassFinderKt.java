/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinClassFinderKt {
    @Nullable
    public static final KotlinJvmBinaryClass findKotlinClass(@NotNull KotlinClassFinder $this$findKotlinClass, @NotNull ClassId classId, @NotNull MetadataVersion metadataVersion) {
        Intrinsics.checkNotNullParameter($this$findKotlinClass, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        KotlinClassFinder.Result result = $this$findKotlinClass.findKotlinClassOrContent(classId, metadataVersion);
        return result != null ? result.toKotlinJvmBinaryClass() : null;
    }

    @Nullable
    public static final KotlinJvmBinaryClass findKotlinClass(@NotNull KotlinClassFinder $this$findKotlinClass, @NotNull JavaClass javaClass, @NotNull MetadataVersion metadataVersion) {
        Intrinsics.checkNotNullParameter($this$findKotlinClass, "<this>");
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        KotlinClassFinder.Result result = $this$findKotlinClass.findKotlinClassOrContent(javaClass, metadataVersion);
        return result != null ? result.toKotlinJvmBinaryClass() : null;
    }
}

