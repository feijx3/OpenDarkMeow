/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$$Lambda$0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReturnsCheck
implements Check {
    @NotNull
    private final String name;
    @NotNull
    private final Function1<KotlinBuiltIns, KotlinType> type;
    @NotNull
    private final String description;

    private ReturnsCheck(String name, Function1<? super KotlinBuiltIns, ? extends KotlinType> type) {
        this.name = name;
        this.type = type;
        this.description = "must return " + this.name;
    }

    @Override
    @NotNull
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public /* synthetic */ ReturnsCheck(String name, Function1 type, DefaultConstructorMarker $constructor_marker) {
        this(name, type);
    }

    public static final class ReturnsBoolean
    extends ReturnsCheck {
        @NotNull
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", ReturnsCheck$ReturnsBoolean$$Lambda$0.INSTANCE, null);
        }

        private static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType simpleType = kotlinBuiltIns.getBooleanType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getBooleanType(...)");
            return simpleType;
        }

        static /* synthetic */ KotlinType accessor$ReturnsCheck$ReturnsBoolean$lambda0(KotlinBuiltIns kotlinBuiltIns) {
            return ReturnsBoolean._init_$lambda$0(kotlinBuiltIns);
        }
    }

    public static final class ReturnsInt
    extends ReturnsCheck {
        @NotNull
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", ReturnsCheck$ReturnsInt$$Lambda$0.INSTANCE, null);
        }

        private static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType simpleType = kotlinBuiltIns.getIntType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getIntType(...)");
            return simpleType;
        }

        static /* synthetic */ KotlinType accessor$ReturnsCheck$ReturnsInt$lambda0(KotlinBuiltIns kotlinBuiltIns) {
            return ReturnsInt._init_$lambda$0(kotlinBuiltIns);
        }
    }

    public static final class ReturnsUnit
    extends ReturnsCheck {
        @NotNull
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", ReturnsCheck$ReturnsUnit$$Lambda$0.INSTANCE, null);
        }

        private static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType simpleType = kotlinBuiltIns.getUnitType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getUnitType(...)");
            return simpleType;
        }

        static /* synthetic */ KotlinType accessor$ReturnsCheck$ReturnsUnit$lambda0(KotlinBuiltIns kotlinBuiltIns) {
            return ReturnsUnit._init_$lambda$0(kotlinBuiltIns);
        }
    }
}

