/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpander;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nKotlinTypeFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypeFactory.kt\norg/jetbrains/kotlin/types/KotlinTypeFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,276:1\n1#2:277\n*E\n"})
public final class KotlinTypeFactory {
    @NotNull
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();
    @NotNull
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = EMPTY_REFINED_TYPE_FACTORY.1.INSTANCE;

    private KotlinTypeFactory() {
    }

    private final MemberScope computeMemberScope(TypeConstructor constructor, List<? extends TypeProjection> arguments, KotlinTypeRefiner kotlinTypeRefiner) {
        MemberScope memberScope;
        ClassifierDescriptor descriptor2 = constructor.getDeclarationDescriptor();
        ClassifierDescriptor classifierDescriptor = descriptor2;
        if (classifierDescriptor instanceof TypeParameterDescriptor) {
            memberScope = ((TypeParameterDescriptor)descriptor2).getDefaultType().getMemberScope();
        } else if (classifierDescriptor instanceof ClassDescriptor) {
            KotlinTypeRefiner refinerToUse;
            KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
            if (kotlinTypeRefiner2 == null) {
                kotlinTypeRefiner2 = refinerToUse = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(descriptor2));
            }
            memberScope = arguments.isEmpty() ? ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor)descriptor2, refinerToUse) : ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor)descriptor2, TypeConstructorSubstitution.Companion.create(constructor, arguments), refinerToUse);
        } else if (classifierDescriptor instanceof TypeAliasDescriptor) {
            String[] stringArray = new String[]{((TypeAliasDescriptor)descriptor2).getName().toString()};
            memberScope = ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE, true, stringArray);
        } else {
            if (constructor instanceof IntersectionTypeConstructor) {
                return ((IntersectionTypeConstructor)constructor).createScopeForKotlinType();
            }
            throw new IllegalStateException("Unsupported classifier: " + descriptor2 + " for constructor: " + constructor);
        }
        return memberScope;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final SimpleType simpleType(@NotNull TypeAttributes attributes, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean nullable, @Nullable KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (attributes.isEmpty() && arguments.isEmpty() && !nullable && constructor.getDeclarationDescriptor() != null) {
            ClassifierDescriptor classifierDescriptor = constructor.getDeclarationDescriptor();
            Intrinsics.checkNotNull(classifierDescriptor);
            SimpleType simpleType = classifierDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
            return simpleType;
        }
        boolean bl2 = nullable;
        TypeAttributes typeAttributes = attributes;
        List<? extends TypeProjection> list = arguments;
        TypeConstructor typeConstructor2 = constructor;
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, constructor, arguments, nullable, INSTANCE.computeMemberScope(constructor, arguments, kotlinTypeRefiner), new KotlinTypeFactory$$Lambda$0(typeConstructor2, list, typeAttributes, bl2));
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes typeAttributes, TypeConstructor typeConstructor2, List list, boolean bl2, KotlinTypeRefiner kotlinTypeRefiner, int n2, Object object) {
        if ((n2 & 0x10) != 0) {
            kotlinTypeRefiner = null;
        }
        return KotlinTypeFactory.simpleType(typeAttributes, typeConstructor2, list, bl2, kotlinTypeRefiner);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType computeExpandedType(@NotNull TypeAliasDescriptor $this$computeExpandedType, @NotNull List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter($this$computeExpandedType, "<this>");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, $this$computeExpandedType, arguments), TypeAttributes.Companion.getEmpty());
    }

    private final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor constructor, KotlinTypeRefiner kotlinTypeRefiner, List<? extends TypeProjection> arguments) {
        ClassifierDescriptor classifierDescriptor;
        block5: {
            block4: {
                ClassifierDescriptor basicDescriptor = constructor.getDeclarationDescriptor();
                classifierDescriptor = basicDescriptor;
                if (classifierDescriptor == null) break block4;
                ClassifierDescriptor it = classifierDescriptor;
                boolean bl2 = false;
                ClassifierDescriptor classifierDescriptor2 = kotlinTypeRefiner.refineDescriptor(it);
                classifierDescriptor = classifierDescriptor2;
                if (classifierDescriptor2 != null) break block5;
            }
            return null;
        }
        ClassifierDescriptor descriptor2 = classifierDescriptor;
        if (descriptor2 instanceof TypeAliasDescriptor) {
            return new ExpandedTypeOrRefinedConstructor(KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor)descriptor2, arguments), null);
        }
        TypeConstructor typeConstructor2 = descriptor2.getTypeConstructor().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "refine(...)");
        TypeConstructor refinedConstructor = typeConstructor2;
        return new ExpandedTypeOrRefinedConstructor(null, refinedConstructor);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull TypeAttributes attributes, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean nullable, @NotNull MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        MemberScope memberScope2 = memberScope;
        boolean bl2 = nullable;
        TypeAttributes typeAttributes = attributes;
        List<? extends TypeProjection> list = arguments;
        TypeConstructor typeConstructor2 = constructor;
        SimpleTypeImpl it = new SimpleTypeImpl(constructor, arguments, nullable, memberScope, new KotlinTypeFactory$$Lambda$1(typeConstructor2, list, typeAttributes, bl2, memberScope2));
        boolean bl3 = false;
        return attributes.isEmpty() ? (SimpleType)it : (SimpleType)new SimpleTypeWithAttributes(it, attributes);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull TypeAttributes attributes, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean nullable, @NotNull MemberScope memberScope, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> refinedTypeFactory) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(refinedTypeFactory, "refinedTypeFactory");
        SimpleTypeImpl it = new SimpleTypeImpl(constructor, arguments, nullable, memberScope, refinedTypeFactory);
        boolean bl2 = false;
        return attributes.isEmpty() ? (SimpleType)it : (SimpleType)new SimpleTypeWithAttributes(it, attributes);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleNotNullType(@NotNull TypeAttributes attributes, @NotNull ClassDescriptor descriptor2, @NotNull List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        TypeConstructor typeConstructor2 = descriptor2.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        return KotlinTypeFactory.simpleType$default(attributes, typeConstructor2, arguments, false, null, 16, null);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleType(@NotNull SimpleType baseType, @NotNull TypeAttributes annotations, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean nullable) {
        Intrinsics.checkNotNullParameter(baseType, "baseType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return KotlinTypeFactory.simpleType$default(annotations, constructor, arguments, nullable, null, 16, null);
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType simpleType, TypeAttributes typeAttributes, TypeConstructor typeConstructor2, List list, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        if ((n2 & 4) != 0) {
            typeConstructor2 = simpleType.getConstructor();
        }
        if ((n2 & 8) != 0) {
            list = simpleType.getArguments();
        }
        if ((n2 & 0x10) != 0) {
            bl2 = simpleType.isMarkedNullable();
        }
        return KotlinTypeFactory.simpleType(simpleType, typeAttributes, typeConstructor2, list, bl2);
    }

    @JvmStatic
    @NotNull
    public static final UnwrappedType flexibleType(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        if (Intrinsics.areEqual(lowerBound, upperBound)) {
            return lowerBound;
        }
        return new FlexibleTypeImpl(lowerBound, upperBound);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType integerLiteralType(@NotNull TypeAttributes attributes, @NotNull IntegerLiteralTypeConstructor constructor, boolean nullable) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        String[] stringArray = new String[]{"unknown integer literal type"};
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, constructor, CollectionsKt.emptyList(), nullable, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, stringArray));
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final SimpleType simpleType(@NotNull TypeAttributes attributes, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean nullable) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return KotlinTypeFactory.simpleType$default(attributes, constructor, arguments, nullable, null, 16, null);
    }

    private static final SimpleType simpleType$lambda$1(TypeConstructor $constructor, List $arguments, TypeAttributes $attributes, boolean $nullable, KotlinTypeRefiner refiner) {
        Intrinsics.checkNotNullParameter(refiner, "refiner");
        ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructor = INSTANCE.refineConstructor($constructor, refiner, $arguments);
        if (expandedTypeOrRefinedConstructor == null) {
            return null;
        }
        ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructor2 = expandedTypeOrRefinedConstructor;
        SimpleType simpleType = expandedTypeOrRefinedConstructor2.getExpandedType();
        if (simpleType != null) {
            SimpleType it = simpleType;
            boolean bl2 = false;
            return it;
        }
        TypeConstructor typeConstructor2 = expandedTypeOrRefinedConstructor2.getRefinedConstructor();
        Intrinsics.checkNotNull(typeConstructor2);
        return KotlinTypeFactory.simpleType($attributes, typeConstructor2, $arguments, $nullable, refiner);
    }

    private static final SimpleType simpleTypeWithNonTrivialMemberScope$lambda$4(TypeConstructor $constructor, List $arguments, TypeAttributes $attributes, boolean $nullable, MemberScope $memberScope, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructor = INSTANCE.refineConstructor($constructor, kotlinTypeRefiner, $arguments);
        if (expandedTypeOrRefinedConstructor == null) {
            return null;
        }
        ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructor2 = expandedTypeOrRefinedConstructor;
        SimpleType simpleType = expandedTypeOrRefinedConstructor2.getExpandedType();
        if (simpleType != null) {
            SimpleType it = simpleType;
            boolean bl2 = false;
            return it;
        }
        TypeConstructor typeConstructor2 = expandedTypeOrRefinedConstructor2.getRefinedConstructor();
        Intrinsics.checkNotNull(typeConstructor2);
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope($attributes, typeConstructor2, $arguments, $nullable, $memberScope);
    }

    static /* synthetic */ SimpleType accessor$KotlinTypeFactory$lambda0(TypeConstructor typeConstructor2, List list, TypeAttributes typeAttributes, boolean bl2, KotlinTypeRefiner kotlinTypeRefiner) {
        return KotlinTypeFactory.simpleType$lambda$1(typeConstructor2, list, typeAttributes, bl2, kotlinTypeRefiner);
    }

    static /* synthetic */ SimpleType accessor$KotlinTypeFactory$lambda1(TypeConstructor typeConstructor2, List list, TypeAttributes typeAttributes, boolean bl2, MemberScope memberScope, KotlinTypeRefiner kotlinTypeRefiner) {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope$lambda$4(typeConstructor2, list, typeAttributes, bl2, memberScope, kotlinTypeRefiner);
    }

    private static final class ExpandedTypeOrRefinedConstructor {
        @Nullable
        private final SimpleType expandedType;
        @Nullable
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(@Nullable SimpleType expandedType, @Nullable TypeConstructor refinedConstructor) {
            this.expandedType = expandedType;
            this.refinedConstructor = refinedConstructor;
        }

        @Nullable
        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        @Nullable
        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }
}

