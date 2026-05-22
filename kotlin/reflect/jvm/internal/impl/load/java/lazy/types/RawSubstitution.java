/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nRawSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawSubstitution.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawSubstitution\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1563#2:96\n1634#2,3:97\n*S KotlinDebug\n*F\n+ 1 RawSubstitution.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawSubstitution\n*L\n73#1:96\n73#1:97,3\n*E\n"})
public final class RawSubstitution
extends TypeSubstitution {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final RawProjectionComputer projectionComputer;
    @NotNull
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;
    @NotNull
    private static final JavaTypeAttributes lowerTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    @NotNull
    private static final JavaTypeAttributes upperTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);

    public RawSubstitution(@Nullable TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        this.projectionComputer = new RawProjectionComputer();
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser2 = typeParameterUpperBoundEraser;
        if (typeParameterUpperBoundEraser2 == null) {
            typeParameterUpperBoundEraser2 = new TypeParameterUpperBoundEraser(this.projectionComputer, null, 2, null);
        }
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser2;
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            typeParameterUpperBoundEraser = null;
        }
        this(typeParameterUpperBoundEraser);
    }

    @Override
    @NotNull
    public TypeProjectionImpl get(@NotNull KotlinType key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new TypeProjectionImpl(RawSubstitution.eraseType$default(this, key, null, 2, null));
    }

    private final KotlinType eraseType(KotlinType type, JavaTypeAttributes attr) {
        KotlinType kotlinType;
        ClassifierDescriptor declaration = type.getConstructor().getDeclarationDescriptor();
        if (declaration instanceof TypeParameterDescriptor) {
            kotlinType = this.eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((TypeParameterDescriptor)declaration, attr.markIsRaw(true)), attr);
        } else if (declaration instanceof ClassDescriptor) {
            ClassifierDescriptor declarationForUpper = FlexibleTypesKt.upperIfFlexible(type).getConstructor().getDeclarationDescriptor();
            if (!(declarationForUpper instanceof ClassDescriptor)) {
                boolean $i$a$-check-RawSubstitution$eraseType$22 = false;
                String $i$a$-check-RawSubstitution$eraseType$22 = "For some reason declaration for upper bound is not a class but \"" + declarationForUpper + "\" while for lower it's \"" + declaration + '\"';
                throw new IllegalStateException($i$a$-check-RawSubstitution$eraseType$22.toString());
            }
            Pair<SimpleType, Boolean> pair = this.eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(type), (ClassDescriptor)declaration, lowerTypeAttr);
            SimpleType lower = pair.component1();
            boolean isRawL = pair.component2();
            Pair<SimpleType, Boolean> pair2 = this.eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(type), (ClassDescriptor)declarationForUpper, upperTypeAttr);
            SimpleType upper = pair2.component1();
            boolean isRawU = pair2.component2();
            kotlinType = isRawL || isRawU ? (UnwrappedType)new RawTypeImpl(lower, upper) : KotlinTypeFactory.flexibleType(lower, upper);
        } else {
            throw new IllegalStateException(("Unexpected declaration kind: " + declaration).toString());
        }
        return kotlinType;
    }

    static /* synthetic */ KotlinType eraseType$default(RawSubstitution rawSubstitution, KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes, int n2, Object object) {
        if ((n2 & 2) != 0) {
            javaTypeAttributes = new JavaTypeAttributes(TypeUsage.COMMON, null, false, false, null, null, 62, null);
        }
        return rawSubstitution.eraseType(kotlinType, javaTypeAttributes);
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(SimpleType type, ClassDescriptor declaration, JavaTypeAttributes attr) {
        Collection<TypeProjection> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        if (type.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(type, false);
        }
        if (KotlinBuiltIns.isArray(type)) {
            TypeProjection componentTypeProjection = type.getArguments().get(0);
            Variance variance = componentTypeProjection.getProjectionKind();
            KotlinType kotlinType = componentTypeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            List<TypeProjectionImpl> arguments = CollectionsKt.listOf(new TypeProjectionImpl(variance, this.eraseType(kotlinType, attr)));
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(type.getAttributes(), type.getConstructor(), arguments, type.isMarkedNullable(), null, 16, null), false);
        }
        if (KotlinTypeKt.isError(type)) {
            String[] componentTypeProjection = new String[]{type.getConstructor().toString()};
            return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, componentTypeProjection), false);
        }
        MemberScope memberScope = declaration.getMemberScope(this);
        Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
        MemberScope memberScope2 = memberScope;
        TypeAttributes typeAttributes = type.getAttributes();
        TypeConstructor typeConstructor2 = declaration.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        List<TypeParameterDescriptor> list = declaration.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
        Iterable arguments = list;
        TypeConstructor typeConstructor3 = typeConstructor2;
        TypeAttributes typeAttributes2 = typeAttributes;
        boolean $i$f$map = false;
        void var7_12 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void parameter;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            ErasureProjectionComputer erasureProjectionComputer = this.projectionComputer;
            Intrinsics.checkNotNull(parameter);
            collection.add(ErasureProjectionComputer.computeProjection$default(erasureProjectionComputer, (TypeParameterDescriptor)parameter, attr, this.typeParameterUpperBoundEraser, null, 8, null));
        }
        collection = (List)destination$iv$iv;
        JavaTypeAttributes javaTypeAttributes = attr;
        SimpleType simpleType = type;
        RawSubstitution rawSubstitution = this;
        ClassDescriptor classDescriptor = declaration;
        return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(typeAttributes2, typeConstructor3, (List<? extends TypeProjection>)collection, type.isMarkedNullable(), memberScope2, new RawSubstitution$$Lambda$0(classDescriptor, rawSubstitution, simpleType, javaTypeAttributes)), true);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static final SimpleType eraseInflexibleBasedOnClassDescriptor$lambda$2(ClassDescriptor $declaration, RawSubstitution this$0, SimpleType $type, JavaTypeAttributes $attr, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ClassId classId = DescriptorUtilsKt.getClassId($declaration);
        if (classId == null) {
            return null;
        }
        ClassId classId2 = classId;
        ClassDescriptor classDescriptor = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId2);
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor refinedClassDescriptor = classDescriptor;
        if (Intrinsics.areEqual(refinedClassDescriptor, $declaration)) {
            return null;
        }
        return this$0.eraseInflexibleBasedOnClassDescriptor($type, refinedClassDescriptor, $attr).getFirst();
    }

    public RawSubstitution() {
        this(null, 1, null);
    }

    static /* synthetic */ SimpleType accessor$RawSubstitution$lambda0(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes, KotlinTypeRefiner kotlinTypeRefiner) {
        return RawSubstitution.eraseInflexibleBasedOnClassDescriptor$lambda$2(classDescriptor, rawSubstitution, simpleType, javaTypeAttributes, kotlinTypeRefiner);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

