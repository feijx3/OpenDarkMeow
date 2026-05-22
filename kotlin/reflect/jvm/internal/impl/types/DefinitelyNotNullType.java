/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin._Assertions;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DefinitelyNotNullType
extends DelegatingSimpleType
implements CustomTypeParameter,
DefinitelyNotNullTypeMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    private DefinitelyNotNullType(SimpleType original, boolean useCorrectedNullabilityForTypeParameters) {
        this.original = original;
        this.useCorrectedNullabilityForTypeParameters = useCorrectedNullabilityForTypeParameters;
    }

    @NotNull
    public final SimpleType getOriginal() {
        return this.original;
    }

    @Override
    @NotNull
    protected SimpleType getDelegate() {
        return this.original;
    }

    @Override
    public boolean isMarkedNullable() {
        return false;
    }

    @Override
    public boolean isTypeParameter() {
        return this.getDelegate().getConstructor() instanceof NewTypeVariableConstructor || this.getDelegate().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor;
    }

    @Override
    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType replacement) {
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(replacement.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new DefinitelyNotNullType(this.getDelegate().replaceAttributes(newAttributes), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean newNullability) {
        return newNullability ? this.getDelegate().makeNullableAsSpecified(newNullability) : (SimpleType)this;
    }

    @Override
    @NotNull
    public String toString() {
        return this.getDelegate() + " & Any";
    }

    @Override
    @NotNull
    public DefinitelyNotNullType replaceDelegate(@NotNull SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new DefinitelyNotNullType(delegate, this.useCorrectedNullabilityForTypeParameters);
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType original, boolean useCorrectedNullabilityForTypeParameters, DefaultConstructorMarker $constructor_marker) {
        this(original, useCorrectedNullabilityForTypeParameters);
    }

    public static final class Companion {
        private Companion() {
        }

        @JvmOverloads
        @Nullable
        public final DefinitelyNotNullType makeDefinitelyNotNull(@NotNull UnwrappedType type, boolean useCorrectedNullabilityForTypeParameters, boolean avoidCheckingActualTypeNullability) {
            DefinitelyNotNullType definitelyNotNullType;
            Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof DefinitelyNotNullType) {
                definitelyNotNullType = (DefinitelyNotNullType)type;
            } else if (avoidCheckingActualTypeNullability || this.makesSenseToBeDefinitelyNotNull(type, useCorrectedNullabilityForTypeParameters)) {
                if (type instanceof FlexibleType) {
                    boolean bl2 = Intrinsics.areEqual(((FlexibleType)type).getLowerBound().getConstructor(), ((FlexibleType)type).getUpperBound().getConstructor());
                    if (_Assertions.ENABLED && !bl2) {
                        boolean bl3 = false;
                        String string = "DefinitelyNotNullType for flexible type (" + type + ") can be created only from type variable with the same constructor for bounds";
                        throw new AssertionError((Object)string);
                    }
                }
                definitelyNotNullType = new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(type).makeNullableAsSpecified(false), useCorrectedNullabilityForTypeParameters, null);
            } else {
                definitelyNotNullType = null;
            }
            return definitelyNotNullType;
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion companion, UnwrappedType unwrappedType, boolean bl2, boolean bl3, int n2, Object object) {
            if ((n2 & 2) != 0) {
                bl2 = false;
            }
            if ((n2 & 4) != 0) {
                bl3 = false;
            }
            return companion.makeDefinitelyNotNull(unwrappedType, bl2, bl3);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType type, boolean useCorrectedNullabilityForFlexibleTypeParameters) {
            if (!this.canHaveUndefinedNullability(type)) {
                return false;
            }
            if (type instanceof StubTypeForBuilderInference) {
                return TypeUtils.isNullableType(type);
            }
            ClassifierDescriptor classifierDescriptor = type.getConstructor().getDeclarationDescriptor();
            TypeParameterDescriptorImpl typeParameterDescriptorImpl = classifierDescriptor instanceof TypeParameterDescriptorImpl ? (TypeParameterDescriptorImpl)classifierDescriptor : null;
            boolean bl2 = typeParameterDescriptorImpl != null ? !typeParameterDescriptorImpl.isInitialized() : false;
            if (bl2) {
                return true;
            }
            if (useCorrectedNullabilityForFlexibleTypeParameters && type.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
                return TypeUtils.isNullableType(type);
            }
            return !NullabilityChecker.INSTANCE.isSubtypeOfAny(type);
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType $this$canHaveUndefinedNullability) {
            return $this$canHaveUndefinedNullability.getConstructor() instanceof NewTypeVariableConstructor || $this$canHaveUndefinedNullability.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor || $this$canHaveUndefinedNullability instanceof NewCapturedType || $this$canHaveUndefinedNullability instanceof StubTypeForBuilderInference;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

