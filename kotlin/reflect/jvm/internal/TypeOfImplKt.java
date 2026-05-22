/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u00a8\u0006\t"}, d2={"createPlatformKType", "Lkotlin/reflect/KType;", "lowerBound", "upperBound", "createMutableCollectionKType", "type", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "createNothingType", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\ntypeOfImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeOfImpl.kt\nkotlin/reflect/jvm/internal/TypeOfImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class TypeOfImplKt {
    @NotNull
    public static final KType createPlatformKType(@NotNull KType lowerBound, @NotNull KType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        KotlinType kotlinType = ((KTypeImpl)lowerBound).getType();
        Intrinsics.checkNotNull(kotlinType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        SimpleType simpleType = (SimpleType)kotlinType;
        KotlinType kotlinType2 = ((KTypeImpl)upperBound).getType();
        Intrinsics.checkNotNull(kotlinType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new KTypeImpl(KotlinTypeFactory.flexibleType(simpleType, (SimpleType)kotlinType2), null, 2, null);
    }

    @NotNull
    public static final KType createMutableCollectionKType(@NotNull KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType kotlinType = ((KTypeImpl)type).getType();
        if (!(kotlinType instanceof SimpleType)) {
            boolean bl2 = false;
            String string = "Non-simple type cannot be a mutable collection type: " + type;
            throw new IllegalArgumentException(string.toString());
        }
        ClassifierDescriptor classifierDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
        if (classDescriptor == null) {
            throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + type);
        }
        ClassDescriptor classifier = classDescriptor;
        SimpleType simpleType = (SimpleType)kotlinType;
        TypeConstructor typeConstructor2 = TypeOfImplKt.readOnlyToMutable(classifier).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, null, typeConstructor2, null, false, 26, null), null, 2, null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor $this$readOnlyToMutable) {
        FqName fqName = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe($this$readOnlyToMutable));
        if (fqName == null) {
            throw new IllegalArgumentException("Not a readonly collection: " + $this$readOnlyToMutable);
        }
        FqName fqName2 = fqName;
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getBuiltIns($this$readOnlyToMutable).getBuiltInClassByFqName(fqName2);
        Intrinsics.checkNotNullExpressionValue(classDescriptor, "getBuiltInClassByFqName(...)");
        return classDescriptor;
    }

    @NotNull
    public static final KType createNothingType(@NotNull KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType kotlinType = ((KTypeImpl)type).getType();
        if (!(kotlinType instanceof SimpleType)) {
            boolean bl2 = false;
            String string = "Non-simple type cannot be a Nothing type: " + type;
            throw new IllegalArgumentException(string.toString());
        }
        SimpleType simpleType = (SimpleType)kotlinType;
        TypeConstructor typeConstructor2 = TypeUtilsKt.getBuiltIns(kotlinType).getNothing().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, null, typeConstructor2, null, false, 26, null), null, 2, null);
    }
}

