/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

public final class ClassicTypeSystemContextKt {
    private static final UnwrappedType makeDefinitelyNotNullOrNotNullInternal(UnwrappedType type) {
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default(type, false, 1, null);
    }

    public static final /* synthetic */ UnwrappedType access$makeDefinitelyNotNullOrNotNullInternal(UnwrappedType type) {
        return ClassicTypeSystemContextKt.makeDefinitelyNotNullOrNotNullInternal(type);
    }
}

