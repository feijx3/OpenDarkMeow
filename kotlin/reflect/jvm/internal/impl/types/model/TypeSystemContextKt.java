/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;

public final class TypeSystemContextKt {
    @NotNull
    public static final TypeVariance convertVariance(@NotNull Variance $this$convertVariance) {
        TypeVariance typeVariance;
        Intrinsics.checkNotNullParameter((Object)$this$convertVariance, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$convertVariance.ordinal()]) {
            case 1: {
                typeVariance = TypeVariance.INV;
                break;
            }
            case 2: {
                typeVariance = TypeVariance.IN;
                break;
            }
            case 3: {
                typeVariance = TypeVariance.OUT;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return typeVariance;
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Variance.values().length];
            try {
                nArray[Variance.INVARIANT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.IN_VARIANCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.OUT_VARIANCE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

