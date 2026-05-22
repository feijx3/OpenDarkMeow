/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$7;
import org.jetbrains.annotations.NotNull;

public final class FunctionsKt {
    @NotNull
    private static final Function1<Object, Object> IDENTITY = FunctionsKt$$Lambda$3.INSTANCE;
    @NotNull
    private static final Function1<Object, Boolean> ALWAYS_TRUE = FunctionsKt$$Lambda$4.INSTANCE;
    @NotNull
    private static final Function1<Object, Object> ALWAYS_NULL = ALWAYS_NULL.1.INSTANCE;
    @NotNull
    private static final Function1<Object, Unit> DO_NOTHING = FunctionsKt$$Lambda$5.INSTANCE;
    @NotNull
    private static final Function2<Object, Object, Unit> DO_NOTHING_2 = FunctionsKt$$Lambda$6.INSTANCE;
    @NotNull
    private static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = FunctionsKt$$Lambda$7.INSTANCE;

    @NotNull
    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return ALWAYS_TRUE;
    }

    @NotNull
    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }

    private static final Object IDENTITY$lambda$0(Object it) {
        return it;
    }

    private static final boolean ALWAYS_TRUE$lambda$1(Object it) {
        return true;
    }

    private static final Unit DO_NOTHING$lambda$2(Object it) {
        return Unit.INSTANCE;
    }

    private static final Unit DO_NOTHING_2$lambda$3(Object object, Object object2) {
        return Unit.INSTANCE;
    }

    private static final Unit DO_NOTHING_3$lambda$4(Object object, Object object2, Object object3) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object accessor$FunctionsKt$lambda3(Object object) {
        return FunctionsKt.IDENTITY$lambda$0(object);
    }

    static /* synthetic */ boolean accessor$FunctionsKt$lambda4(Object object) {
        return FunctionsKt.ALWAYS_TRUE$lambda$1(object);
    }

    static /* synthetic */ Unit accessor$FunctionsKt$lambda5(Object object) {
        return FunctionsKt.DO_NOTHING$lambda$2(object);
    }

    static /* synthetic */ Unit accessor$FunctionsKt$lambda6(Object object, Object object2) {
        return FunctionsKt.DO_NOTHING_2$lambda$3(object, object2);
    }

    static /* synthetic */ Unit accessor$FunctionsKt$lambda7(Object object, Object object2, Object object3) {
        return FunctionsKt.DO_NOTHING_3$lambda$4(object, object2, object3);
    }
}

