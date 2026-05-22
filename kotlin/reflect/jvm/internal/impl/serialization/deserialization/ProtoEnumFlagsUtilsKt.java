/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoEnumFlagsUtilsKt {
    @NotNull
    public static final CallableMemberDescriptor.Kind memberKind(@NotNull ProtoEnumFlags $this$memberKind, @Nullable ProtoBuf.MemberKind memberKind) {
        CallableMemberDescriptor.Kind kind2;
        Intrinsics.checkNotNullParameter($this$memberKind, "<this>");
        ProtoBuf.MemberKind memberKind2 = memberKind;
        switch (memberKind2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[memberKind2.ordinal()]) {
            case 1: {
                kind2 = CallableMemberDescriptor.Kind.DECLARATION;
                break;
            }
            case 2: {
                kind2 = CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
                break;
            }
            case 3: {
                kind2 = CallableMemberDescriptor.Kind.DELEGATION;
                break;
            }
            case 4: {
                kind2 = CallableMemberDescriptor.Kind.SYNTHESIZED;
                break;
            }
            default: {
                kind2 = CallableMemberDescriptor.Kind.DECLARATION;
            }
        }
        return kind2;
    }

    @NotNull
    public static final DescriptorVisibility descriptorVisibility(@NotNull ProtoEnumFlags $this$descriptorVisibility, @Nullable ProtoBuf.Visibility visibility2) {
        DescriptorVisibility descriptorVisibility;
        Intrinsics.checkNotNullParameter($this$descriptorVisibility, "<this>");
        ProtoBuf.Visibility visibility3 = visibility2;
        switch (visibility3 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[visibility3.ordinal()]) {
            case 1: {
                DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.INTERNAL;
                descriptorVisibility = descriptorVisibility2;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility2, "INTERNAL");
                break;
            }
            case 2: {
                DescriptorVisibility descriptorVisibility3 = DescriptorVisibilities.PRIVATE;
                descriptorVisibility = descriptorVisibility3;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility3, "PRIVATE");
                break;
            }
            case 3: {
                DescriptorVisibility descriptorVisibility4 = DescriptorVisibilities.PRIVATE_TO_THIS;
                descriptorVisibility = descriptorVisibility4;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility4, "PRIVATE_TO_THIS");
                break;
            }
            case 4: {
                DescriptorVisibility descriptorVisibility5 = DescriptorVisibilities.PROTECTED;
                descriptorVisibility = descriptorVisibility5;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility5, "PROTECTED");
                break;
            }
            case 5: {
                DescriptorVisibility descriptorVisibility6 = DescriptorVisibilities.PUBLIC;
                descriptorVisibility = descriptorVisibility6;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility6, "PUBLIC");
                break;
            }
            case 6: {
                DescriptorVisibility descriptorVisibility7 = DescriptorVisibilities.LOCAL;
                descriptorVisibility = descriptorVisibility7;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility7, "LOCAL");
                break;
            }
            default: {
                DescriptorVisibility descriptorVisibility8 = DescriptorVisibilities.PRIVATE;
                descriptorVisibility = descriptorVisibility8;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility8, "PRIVATE");
            }
        }
        return descriptorVisibility;
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] nArray = new int[ProtoBuf.MemberKind.values().length];
            try {
                nArray[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[CallableMemberDescriptor.Kind.values().length];
            try {
                nArray[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
            nArray = new int[ProtoBuf.Visibility.values().length];
            try {
                nArray[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$2 = nArray;
        }
    }
}

