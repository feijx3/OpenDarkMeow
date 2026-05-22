/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.CreateKCallableVisitor;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e*\u00020\u001fH\u0002J\u0010\u0010 \u001a\u0006\u0012\u0002\b\u00030!*\u00020\"H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "<init>", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "isReified", "", "()Z", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKTypeParameterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypeParameterImpl.kt\nkotlin/reflect/jvm/internal/KTypeParameterImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1563#2:92\n1634#2,3:93\n*S KotlinDebug\n*F\n+ 1 KTypeParameterImpl.kt\nkotlin/reflect/jvm/internal/KTypeParameterImpl\n*L\n38#1:92\n38#1:93,3\n*E\n"})
public final class KTypeParameterImpl
implements KTypeParameter,
KClassifierImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final TypeParameterDescriptor descriptor;
    @NotNull
    private final ReflectProperties.LazySoftVal upperBounds$delegate;
    @NotNull
    private final KTypeParameterOwnerImpl container;

    /*
     * WARNING - void declaration
     */
    public KTypeParameterImpl(@Nullable KTypeParameterOwnerImpl container, @NotNull TypeParameterDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        this.descriptor = descriptor2;
        KTypeParameterImpl kTypeParameterImpl = this;
        this.upperBounds$delegate = ReflectProperties.lazySoft(new KTypeParameterImpl$$Lambda$0(kTypeParameterImpl));
        KTypeParameterImpl kTypeParameterImpl2 = this;
        KTypeParameterOwnerImpl kTypeParameterOwnerImpl = container;
        if (kTypeParameterOwnerImpl == null) {
            KClassImpl<Object> kClassImpl;
            void $this$container_u24lambda_u242;
            KTypeParameterImpl kTypeParameterImpl3 = this;
            KTypeParameterImpl kTypeParameterImpl4 = kTypeParameterImpl2;
            boolean bl2 = false;
            DeclarationDescriptor declarationDescriptor = $this$container_u24lambda_u242.getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
            DeclarationDescriptor declaration = declarationDescriptor;
            if (declaration instanceof ClassDescriptor) {
                kClassImpl = super.toKClassImpl((ClassDescriptor)declaration);
            } else if (declaration instanceof CallableMemberDescriptor) {
                KClassImpl kClassImpl2;
                DeclarationDescriptor declarationDescriptor2 = ((CallableMemberDescriptor)declaration).getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(declarationDescriptor2, "getContainingDeclaration(...)");
                DeclarationDescriptor callableContainer = declarationDescriptor2;
                if (callableContainer instanceof ClassDescriptor) {
                    kClassImpl2 = super.toKClassImpl((ClassDescriptor)callableContainer);
                } else {
                    DeclarationDescriptor declarationDescriptor3 = declaration;
                    DeserializedMemberDescriptor deserializedMemberDescriptor = declarationDescriptor3 instanceof DeserializedMemberDescriptor ? (DeserializedMemberDescriptor)declarationDescriptor3 : null;
                    if (deserializedMemberDescriptor == null) {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + declaration);
                    }
                    DeserializedMemberDescriptor deserializedMember = deserializedMemberDescriptor;
                    KClass<?> kClass = JvmClassMappingKt.getKotlinClass(super.getContainerClass(deserializedMember));
                    Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    kClassImpl2 = (KClassImpl)kClass;
                }
                KClassImpl callableContainerClass = kClassImpl2;
                kClassImpl = declaration.accept(new CreateKCallableVisitor(callableContainerClass), Unit.INSTANCE);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + declaration);
            }
            kTypeParameterOwnerImpl = kClassImpl;
            kTypeParameterImpl2 = kTypeParameterImpl4;
        }
        kTypeParameterImpl2.container = kTypeParameterOwnerImpl;
    }

    @Override
    @NotNull
    public TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    @NotNull
    public String getName() {
        String string = this.getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        return string;
    }

    @Override
    @NotNull
    public List<KType> getUpperBounds() {
        Object t2 = this.upperBounds$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
        return (List)t2;
    }

    @Override
    @NotNull
    public KVariance getVariance() {
        KVariance kVariance;
        switch (WhenMappings.$EnumSwitchMapping$0[this.getDescriptor().getVariance().ordinal()]) {
            case 1: {
                kVariance = KVariance.INVARIANT;
                break;
            }
            case 2: {
                kVariance = KVariance.IN;
                break;
            }
            case 3: {
                kVariance = KVariance.OUT;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return kVariance;
    }

    @Override
    public boolean isReified() {
        return this.getDescriptor().isReified();
    }

    private final KClassImpl<?> toKClassImpl(ClassDescriptor $this$toKClassImpl) {
        Class<?> clazz = UtilKt.toJavaClass($this$toKClassImpl);
        KClassImpl kClassImpl = (KClassImpl)(clazz != null ? JvmClassMappingKt.getKotlinClass(clazz) : null);
        if (kClassImpl == null) {
            throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + $this$toKClassImpl.getContainingDeclaration());
        }
        return kClassImpl;
    }

    private final Class<?> getContainerClass(DeserializedMemberDescriptor $this$getContainerClass) {
        JvmPackagePartSource jvmPackagePartSource;
        DeserializedContainerSource deserializedContainerSource = $this$getContainerClass.getContainerSource();
        JvmPackagePartSource jvmPackagePartSource2 = jvmPackagePartSource = deserializedContainerSource instanceof JvmPackagePartSource ? (JvmPackagePartSource)deserializedContainerSource : null;
        KotlinJvmBinaryClass kotlinJvmBinaryClass = jvmPackagePartSource2 != null ? jvmPackagePartSource2.getKnownJvmBinaryClass() : null;
        Object object = kotlinJvmBinaryClass instanceof ReflectKotlinClass ? (ReflectKotlinClass)kotlinJvmBinaryClass : null;
        if (object == null || (object = ((ReflectKotlinClass)object).getKlass()) == null) {
            throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + $this$getContainerClass);
        }
        return object;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KTypeParameterImpl && Intrinsics.areEqual(this.container, ((KTypeParameterImpl)other).container) && Intrinsics.areEqual(this.getName(), ((KTypeParameterImpl)other).getName());
    }

    public int hashCode() {
        return this.container.hashCode() * 31 + this.getName().hashCode();
    }

    @NotNull
    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }

    /*
     * WARNING - void declaration
     */
    private static final List upperBounds_delegate$lambda$1(KTypeParameterImpl this$0) {
        void $this$mapTo$iv$iv;
        List<KotlinType> list = this$0.getDescriptor().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            KotlinType kotlinType = (KotlinType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(new KTypeImpl((KotlinType)p0, null, 2, null));
        }
        return (List)destination$iv$iv;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KTypeParameterImpl.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ List accessor$KTypeParameterImpl$lambda0(KTypeParameterImpl kTypeParameterImpl) {
        return KTypeParameterImpl.upperBounds_delegate$lambda$1(kTypeParameterImpl);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Variance.values().length];
            try {
                nArray[Variance.INVARIANT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.IN_VARIANCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.OUT_VARIANCE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

