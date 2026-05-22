/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KClassValue
extends ConstantValue<Value> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public KClassValue(@NotNull Value value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super(value);
    }

    public KClassValue(@NotNull ClassLiteralValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this(new Value.NormalClass(value));
    }

    public KClassValue(@NotNull ClassId classId, int arrayDimensions) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        this(new ClassLiteralValue(classId, arrayDimensions));
    }

    @Override
    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        TypeAttributes typeAttributes = TypeAttributes.Companion.getEmpty();
        ClassDescriptor classDescriptor = module.getBuiltIns().getKClass();
        Intrinsics.checkNotNullExpressionValue(classDescriptor, "getKClass(...)");
        return KotlinTypeFactory.simpleNotNullType(typeAttributes, classDescriptor, CollectionsKt.listOf(new TypeProjectionImpl(this.getArgumentType(module))));
    }

    @NotNull
    public final KotlinType getArgumentType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        Value value = (Value)this.getValue();
        if (value instanceof Value.LocalClass) {
            return ((Value.LocalClass)this.getValue()).getType();
        }
        if (value instanceof Value.NormalClass) {
            ClassLiteralValue classLiteralValue = ((Value.NormalClass)this.getValue()).getValue();
            ClassId classId = classLiteralValue.component1();
            int arrayDimensions = classLiteralValue.component2();
            ClassDescriptor classDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(module, classId);
            if (classDescriptor == null) {
                String[] stringArray = new String[]{classId.toString(), String.valueOf(arrayDimensions)};
                return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE, stringArray);
            }
            ClassDescriptor descriptor2 = classDescriptor;
            KotlinType type = null;
            SimpleType simpleType = descriptor2.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
            type = TypeUtilsKt.replaceArgumentsWithStarProjections(simpleType);
            int n2 = 0;
            while (n2 < arrayDimensions) {
                int it = n2++;
                boolean bl2 = false;
                Intrinsics.checkNotNullExpressionValue(module.getBuiltIns().getArrayType(Variance.INVARIANT, type), "getArrayType(...)");
            }
            return type;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final ConstantValue<?> create(@NotNull KotlinType argumentType) {
            ConstantValue constantValue;
            Intrinsics.checkNotNullParameter(argumentType, "argumentType");
            if (KotlinTypeKt.isError(argumentType)) {
                return null;
            }
            KotlinType type = argumentType;
            int arrayDimensions = 0;
            while (KotlinBuiltIns.isArray(type)) {
                Intrinsics.checkNotNullExpressionValue(CollectionsKt.single(type.getArguments()).getType(), "getType(...)");
                ++arrayDimensions;
            }
            ClassifierDescriptor descriptor2 = type.getConstructor().getDeclarationDescriptor();
            if (descriptor2 instanceof ClassDescriptor) {
                ClassId classId = DescriptorUtilsKt.getClassId(descriptor2);
                if (classId == null) {
                    return new KClassValue(new Value.LocalClass(argumentType));
                }
                ClassId classId2 = classId;
                constantValue = new KClassValue(classId2, arrayDimensions);
            } else {
                constantValue = descriptor2 instanceof TypeParameterDescriptor ? (ConstantValue)new KClassValue(ClassId.Companion.topLevel(StandardNames.FqNames.any.toSafe()), 0) : null;
            }
            return constantValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public static abstract class Value {
        private Value() {
        }

        public /* synthetic */ Value(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class LocalClass
        extends Value {
            @NotNull
            private final KotlinType type;

            public LocalClass(@NotNull KotlinType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                super(null);
                this.type = type;
            }

            @NotNull
            public final KotlinType getType() {
                return this.type;
            }

            @NotNull
            public String toString() {
                return "LocalClass(type=" + this.type + ')';
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LocalClass)) {
                    return false;
                }
                LocalClass localClass = (LocalClass)other;
                return Intrinsics.areEqual(this.type, localClass.type);
            }
        }

        public static final class NormalClass
        extends Value {
            @NotNull
            private final ClassLiteralValue value;

            public NormalClass(@NotNull ClassLiteralValue value) {
                Intrinsics.checkNotNullParameter(value, "value");
                super(null);
                this.value = value;
            }

            @NotNull
            public final ClassLiteralValue getValue() {
                return this.value;
            }

            @NotNull
            public final ClassId getClassId() {
                return this.value.getClassId();
            }

            public final int getArrayDimensions() {
                return this.value.getArrayNestedness();
            }

            @NotNull
            public String toString() {
                return "NormalClass(value=" + this.value + ')';
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NormalClass)) {
                    return false;
                }
                NormalClass normalClass = (NormalClass)other;
                return Intrinsics.areEqual(this.value, normalClass.value);
            }
        }
    }
}

