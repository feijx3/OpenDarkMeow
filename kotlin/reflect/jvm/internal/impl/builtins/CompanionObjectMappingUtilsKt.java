/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class CompanionObjectMappingUtilsKt {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isMappedIntrinsicCompanionObject(@NotNull CompanionObjectMapping $this$isMappedIntrinsicCompanionObject, @NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter($this$isMappedIntrinsicCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!DescriptorUtils.isCompanionObject(classDescriptor)) return false;
        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
        if (!CollectionsKt.contains((Iterable)$this$isMappedIntrinsicCompanionObject.getClassIds(), classId != null ? classId.getOuterClassId() : null)) return false;
        return true;
    }
}

