/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import org.jetbrains.annotations.NotNull;

public final class FunctionClassKind
extends Enum<FunctionClassKind> {
    @NotNull
    public static final Companion Companion;
    public static final /* enum */ FunctionClassKind Function;
    public static final /* enum */ FunctionClassKind SuspendFunction;
    public static final /* enum */ FunctionClassKind KFunction;
    public static final /* enum */ FunctionClassKind KSuspendFunction;
    public static final /* enum */ FunctionClassKind UNKNOWN;
    private static final /* synthetic */ FunctionClassKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[])$VALUES.clone();
    }

    public static FunctionClassKind valueOf(String value) {
        return Enum.valueOf(FunctionClassKind.class, value);
    }

    static {
        Function = new FunctionClassKind();
        SuspendFunction = new FunctionClassKind();
        KFunction = new FunctionClassKind();
        KSuspendFunction = new FunctionClassKind();
        UNKNOWN = new FunctionClassKind();
        $VALUES = functionClassKindArray = new FunctionClassKind[]{FunctionClassKind.Function, FunctionClassKind.SuspendFunction, FunctionClassKind.KFunction, FunctionClassKind.KSuspendFunction, FunctionClassKind.UNKNOWN};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final FunctionClassKind getFunctionClassKind(@NotNull FunctionTypeKind functionTypeKind) {
            Intrinsics.checkNotNullParameter(functionTypeKind, "functionTypeKind");
            FunctionTypeKind functionTypeKind2 = functionTypeKind;
            return Intrinsics.areEqual(functionTypeKind2, FunctionTypeKind.Function.INSTANCE) ? Function : (Intrinsics.areEqual(functionTypeKind2, FunctionTypeKind.SuspendFunction.INSTANCE) ? SuspendFunction : (Intrinsics.areEqual(functionTypeKind2, FunctionTypeKind.KFunction.INSTANCE) ? KFunction : (Intrinsics.areEqual(functionTypeKind2, FunctionTypeKind.KSuspendFunction.INSTANCE) ? KSuspendFunction : UNKNOWN)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

