/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoEnumFlags {
    @NotNull
    public static final ProtoEnumFlags INSTANCE = new ProtoEnumFlags();

    private ProtoEnumFlags() {
    }

    @NotNull
    public final Modality modality(@Nullable ProtoBuf.Modality modality2) {
        Modality modality3;
        ProtoBuf.Modality modality4 = modality2;
        switch (modality4 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[modality4.ordinal()]) {
            case 1: {
                modality3 = Modality.FINAL;
                break;
            }
            case 2: {
                modality3 = Modality.OPEN;
                break;
            }
            case 3: {
                modality3 = Modality.ABSTRACT;
                break;
            }
            case 4: {
                modality3 = Modality.SEALED;
                break;
            }
            default: {
                modality3 = Modality.FINAL;
            }
        }
        return modality3;
    }

    @NotNull
    public final ClassKind classKind(@Nullable ProtoBuf.Class.Kind kind2) {
        ClassKind classKind;
        ProtoBuf.Class.Kind kind3 = kind2;
        switch (kind3 == null ? -1 : WhenMappings.$EnumSwitchMapping$3[kind3.ordinal()]) {
            case 1: {
                classKind = ClassKind.CLASS;
                break;
            }
            case 2: {
                classKind = ClassKind.INTERFACE;
                break;
            }
            case 3: {
                classKind = ClassKind.ENUM_CLASS;
                break;
            }
            case 4: {
                classKind = ClassKind.ENUM_ENTRY;
                break;
            }
            case 5: {
                classKind = ClassKind.ANNOTATION_CLASS;
                break;
            }
            case 6: 
            case 7: {
                classKind = ClassKind.OBJECT;
                break;
            }
            default: {
                classKind = ClassKind.CLASS;
            }
        }
        return classKind;
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.TypeParameter.Variance variance) {
        Variance variance2;
        Intrinsics.checkNotNullParameter(variance, "variance");
        switch (WhenMappings.$EnumSwitchMapping$5[variance.ordinal()]) {
            case 1: {
                variance2 = Variance.IN_VARIANCE;
                break;
            }
            case 2: {
                variance2 = Variance.OUT_VARIANCE;
                break;
            }
            case 3: {
                variance2 = Variance.INVARIANT;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return variance2;
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.Type.Argument.Projection projection) {
        Variance variance;
        Intrinsics.checkNotNullParameter(projection, "projection");
        switch (WhenMappings.$EnumSwitchMapping$6[projection.ordinal()]) {
            case 1: {
                variance = Variance.IN_VARIANCE;
                break;
            }
            case 2: {
                variance = Variance.OUT_VARIANCE;
                break;
            }
            case 3: {
                variance = Variance.INVARIANT;
                break;
            }
            case 4: {
                throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + projection);
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return variance;
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;

        static {
            int[] nArray = new int[ProtoBuf.Modality.values().length];
            try {
                nArray[ProtoBuf.Modality.FINAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Modality.OPEN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Modality.ABSTRACT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Modality.SEALED.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[Modality.values().length];
            try {
                nArray[Modality.FINAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Modality.OPEN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Modality.ABSTRACT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Modality.SEALED.ordinal()] = 4;
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
            nArray = new int[ProtoBuf.Class.Kind.values().length];
            try {
                nArray[ProtoBuf.Class.Kind.CLASS.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Class.Kind.INTERFACE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Class.Kind.ENUM_CLASS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Class.Kind.ENUM_ENTRY.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Class.Kind.OBJECT.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$3 = nArray;
            nArray = new int[ClassKind.values().length];
            try {
                nArray[ClassKind.CLASS.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ClassKind.INTERFACE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ClassKind.ENUM_CLASS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ClassKind.ENUM_ENTRY.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ClassKind.OBJECT.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$4 = nArray;
            nArray = new int[ProtoBuf.TypeParameter.Variance.values().length];
            try {
                nArray[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$5 = nArray;
            nArray = new int[ProtoBuf.Type.Argument.Projection.values().length];
            try {
                nArray[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$6 = nArray;
            nArray = new int[Variance.values().length];
            try {
                nArray[Variance.IN_VARIANCE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.OUT_VARIANCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.INVARIANT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$7 = nArray;
        }
    }
}

