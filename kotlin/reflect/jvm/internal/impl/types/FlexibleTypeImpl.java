/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nflexibleTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypeImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,174:1\n1#2:175\n*E\n"})
public final class FlexibleTypeImpl
extends FlexibleType
implements CustomTypeParameter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean assertionsDone;
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    public FlexibleTypeImpl(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        super(lowerBound, upperBound);
    }

    private final void runAssertions() {
        boolean bl2;
        if (!RUN_SLOW_ASSERTIONS || this.assertionsDone) {
            return;
        }
        this.assertionsDone = true;
        boolean bl3 = bl2 = !FlexibleTypesKt.isFlexible(this.getLowerBound());
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-FlexibleTypeImpl$runAssertions$52 = false;
            String $i$a$-assert-FlexibleTypeImpl$runAssertions$52 = "Lower bound of a flexible type can not be flexible: " + this.getLowerBound();
            throw new AssertionError((Object)$i$a$-assert-FlexibleTypeImpl$runAssertions$52);
        }
        boolean bl4 = bl2 = !FlexibleTypesKt.isFlexible(this.getUpperBound());
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-FlexibleTypeImpl$runAssertions$62 = false;
            String $i$a$-assert-FlexibleTypeImpl$runAssertions$62 = "Upper bound of a flexible type can not be flexible: " + this.getUpperBound();
            throw new AssertionError((Object)$i$a$-assert-FlexibleTypeImpl$runAssertions$62);
        }
        boolean bl5 = bl2 = !Intrinsics.areEqual(this.getLowerBound(), this.getUpperBound());
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-FlexibleTypeImpl$runAssertions$72 = false;
            String $i$a$-assert-FlexibleTypeImpl$runAssertions$72 = "Lower and upper bounds are equal: " + this.getLowerBound() + " == " + this.getUpperBound();
            throw new AssertionError((Object)$i$a$-assert-FlexibleTypeImpl$runAssertions$72);
        }
        bl2 = KotlinTypeChecker.DEFAULT.isSubtypeOf(this.getLowerBound(), this.getUpperBound());
        if (_Assertions.ENABLED && !bl2) {
            boolean bl6 = false;
            String string = "Lower bound " + this.getLowerBound() + " of a flexible type must be a subtype of the upper bound " + this.getUpperBound();
            throw new AssertionError((Object)string);
        }
    }

    @Override
    @NotNull
    public SimpleType getDelegate() {
        this.runAssertions();
        return this.getLowerBound();
    }

    @Override
    public boolean isTypeParameter() {
        return this.getLowerBound().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor && Intrinsics.areEqual(this.getLowerBound().getConstructor(), this.getUpperBound().getConstructor());
    }

    @Override
    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType replacement) {
        UnwrappedType unwrappedType;
        UnwrappedType unwrapped;
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        UnwrappedType unwrappedType2 = unwrapped = replacement.unwrap();
        if (unwrappedType2 instanceof FlexibleType) {
            unwrappedType = unwrapped;
        } else if (unwrappedType2 instanceof SimpleType) {
            unwrappedType = KotlinTypeFactory.flexibleType((SimpleType)unwrapped, ((SimpleType)unwrapped).makeNullableAsSpecified(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrapped);
    }

    @Override
    @NotNull
    public UnwrappedType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return KotlinTypeFactory.flexibleType(this.getLowerBound().replaceAttributes(newAttributes), this.getUpperBound().replaceAttributes(newAttributes));
    }

    @Override
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(options, "options");
        if (options.getDebugMode()) {
            return '(' + renderer.renderType(this.getLowerBound()) + ".." + renderer.renderType(this.getUpperBound()) + ')';
        }
        return renderer.renderFlexibleType(renderer.renderType(this.getLowerBound()), renderer.renderType(this.getUpperBound()), TypeUtilsKt.getBuiltIns(this));
    }

    @Override
    @NotNull
    public String toString() {
        return "" + '(' + this.getLowerBound() + ".." + this.getUpperBound() + ')';
    }

    @Override
    @NotNull
    public UnwrappedType makeNullableAsSpecified(boolean newNullability) {
        return KotlinTypeFactory.flexibleType(this.getLowerBound().makeNullableAsSpecified(newNullability), this.getUpperBound().makeNullableAsSpecified(newNullability));
    }

    @Override
    @NotNull
    public FlexibleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType kotlinType = kotlinTypeRefiner.refineType(this.getLowerBound());
        Intrinsics.checkNotNull(kotlinType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        SimpleType simpleType = (SimpleType)kotlinType;
        KotlinType kotlinType2 = kotlinTypeRefiner.refineType(this.getUpperBound());
        Intrinsics.checkNotNull(kotlinType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new FlexibleTypeImpl(simpleType, (SimpleType)kotlinType2);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

