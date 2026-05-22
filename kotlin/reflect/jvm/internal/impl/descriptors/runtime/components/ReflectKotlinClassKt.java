/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;

public final class ReflectKotlinClassKt {
    @NotNull
    private static final Set<Class<?>> TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;

    public static final /* synthetic */ Set access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p() {
        return TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
    }

    static {
        Class[] classArray = new Class[]{Integer.class, Character.class, Byte.class, Long.class, Short.class, Boolean.class, Double.class, Float.class, int[].class, char[].class, byte[].class, long[].class, short[].class, boolean[].class, double[].class, float[].class, Class.class, String.class};
        TYPES_ELIGIBLE_FOR_SIMPLE_VISIT = SetsKt.setOf(classArray);
    }
}

