/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class RawProjectionComputer
extends ErasureProjectionComputer {
    @Override
    @NotNull
    public TypeProjection computeProjection(@NotNull TypeParameterDescriptor parameter, @NotNull ErasureTypeAttributes typeAttr, @NotNull TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, @NotNull KotlinType erasedUpperBound) {
        TypeProjection typeProjection;
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        Intrinsics.checkNotNullParameter(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(erasedUpperBound, "erasedUpperBound");
        if (!(typeAttr instanceof JavaTypeAttributes)) {
            return super.computeProjection(parameter, typeAttr, typeParameterUpperBoundEraser, erasedUpperBound);
        }
        JavaTypeAttributes newTypeAttr = ((JavaTypeAttributes)typeAttr).isRaw() ? (JavaTypeAttributes)typeAttr : ((JavaTypeAttributes)typeAttr).withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
        switch (WhenMappings.$EnumSwitchMapping$0[newTypeAttr.getFlexibility().ordinal()]) {
            case 1: {
                typeProjection = new TypeProjectionImpl(Variance.INVARIANT, erasedUpperBound);
                break;
            }
            case 2: 
            case 3: {
                if (!parameter.getVariance().getAllowsOutPosition()) {
                    typeProjection = new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(parameter).getNothingType());
                    break;
                }
                List<TypeParameterDescriptor> list = erasedUpperBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
                if (!((Collection)list).isEmpty()) {
                    typeProjection = new TypeProjectionImpl(Variance.OUT_VARIANCE, erasedUpperBound);
                    break;
                }
                TypeProjection typeProjection2 = TypeUtils.makeStarProjection(parameter, newTypeAttr);
                Intrinsics.checkNotNull(typeProjection2);
                typeProjection = typeProjection2;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return typeProjection;
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[JavaTypeFlexibility.values().length];
            try {
                nArray[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

