/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$2;
import kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$3;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u001dH\u0000\u00a2\u0006\u0002\b$J\u0013\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001a\u00a8\u0006,\u00b2\u0006\u0010\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017X\u008a\u0084\u0002"}, d2={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "convert", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "isMarkedNullable", "", "()Z", "annotations", "", "getAnnotations", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection", "parameterizedTypeArguments"})
@SourceDebugExtension(value={"SMAP\nKTypeImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypeImpl.kt\nkotlin/reflect/jvm/internal/KTypeImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n1#2:137\n1573#3:138\n1604#3,4:139\n*S KotlinDebug\n*F\n+ 1 KTypeImpl.kt\nkotlin/reflect/jvm/internal/KTypeImpl\n*L\n81#1:138\n81#1:139,4\n*E\n"})
public final class KTypeImpl
implements KTypeBase {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final KotlinType type;
    @Nullable
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;
    @NotNull
    private final ReflectProperties.LazySoftVal classifier$delegate;
    @NotNull
    private final ReflectProperties.LazySoftVal arguments$delegate;

    /*
     * WARNING - void declaration
     */
    public KTypeImpl(@NotNull KotlinType type, @Nullable Function0<? extends Type> computeJavaType) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        KTypeImpl kTypeImpl = this;
        ReflectProperties.LazySoftVal lazySoftVal = computeJavaType instanceof ReflectProperties.LazySoftVal ? (ReflectProperties.LazySoftVal)computeJavaType : null;
        if (lazySoftVal == null) {
            Function0<? extends Type> function0 = computeJavaType;
            if (function0 != null) {
                void p0;
                Function0<? extends Type> function02 = function0;
                KTypeImpl kTypeImpl2 = kTypeImpl;
                boolean bl2 = false;
                lazySoftVal = ReflectProperties.lazySoft(p0);
                kTypeImpl = kTypeImpl2;
            } else {
                lazySoftVal = null;
            }
        }
        kTypeImpl.computeJavaType = lazySoftVal;
        Object object = this;
        this.classifier$delegate = ReflectProperties.lazySoft(new KTypeImpl$$Lambda$0((KTypeImpl)object));
        object = computeJavaType;
        KTypeImpl kTypeImpl3 = this;
        this.arguments$delegate = ReflectProperties.lazySoft(new KTypeImpl$$Lambda$1(kTypeImpl3, (Function0)object));
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            function0 = null;
        }
        this(kotlinType, function0);
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }

    @Override
    @Nullable
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.computeJavaType;
        return lazySoftVal != null ? lazySoftVal.invoke() : null;
    }

    @Override
    @Nullable
    public KClassifier getClassifier() {
        return (KClassifier)this.classifier$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final KClassifier convert(KotlinType type) {
        ClassifierDescriptor descriptor2 = type.getConstructor().getDeclarationDescriptor();
        if (descriptor2 instanceof ClassDescriptor) {
            Class<?> clazz = UtilKt.toJavaClass((ClassDescriptor)descriptor2);
            if (clazz == null) {
                return null;
            }
            Class<?> jClass = clazz;
            if (jClass.isArray()) {
                Object object = CollectionsKt.singleOrNull(type.getArguments());
                if (object == null || (object = object.getType()) == null) {
                    return new KClassImpl(jClass);
                }
                Object argument = object;
                KClassifier kClassifier = this.convert((KotlinType)argument);
                if (kClassifier == null) {
                    throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                }
                KClassifier elementClassifier = kClassifier;
                return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(elementClassifier))));
            }
            if (!TypeUtils.isNullableType(type)) {
                Class<?> clazz2 = ReflectClassUtilKt.getPrimitiveByWrapper(jClass);
                if (clazz2 == null) {
                    clazz2 = jClass;
                }
                return new KClassImpl(clazz2);
            }
            return new KClassImpl(jClass);
        }
        if (descriptor2 instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor)descriptor2);
        }
        if (descriptor2 instanceof TypeAliasDescriptor) {
            String string = "Type alias classifiers are not yet supported";
            throw new NotImplementedError("An operation is not implemented: " + string);
        }
        return null;
    }

    @Override
    @NotNull
    public List<KTypeProjection> getArguments() {
        Object t2 = this.arguments$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
        return (List)t2;
    }

    @Override
    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    @NotNull
    public final KTypeImpl makeNullableAsSpecified$kotlin_reflection(boolean nullable) {
        if (!FlexibleTypesKt.isFlexible(this.type) && this.isMarkedNullable() == nullable) {
            return this;
        }
        KotlinType kotlinType = TypeUtils.makeNullableAsSpecified(this.type, nullable);
        Intrinsics.checkNotNullExpressionValue(kotlinType, "makeNullableAsSpecified(...)");
        return new KTypeImpl(kotlinType, (Function0<? extends Type>)this.computeJavaType);
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KTypeImpl && Intrinsics.areEqual(this.type, ((KTypeImpl)other).type) && Intrinsics.areEqual(this.getClassifier(), ((KTypeImpl)other).getClassifier()) && Intrinsics.areEqual(this.getArguments(), ((KTypeImpl)other).getArguments());
    }

    public int hashCode() {
        KClassifier kClassifier = this.getClassifier();
        return 31 * (31 * this.type.hashCode() + (kClassifier != null ? kClassifier.hashCode() : 0)) + ((Object)this.getArguments()).hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.type);
    }

    private static final KClassifier classifier_delegate$lambda$0(KTypeImpl this$0) {
        return this$0.convert(this$0.type);
    }

    private static final List arguments_delegate$lambda$5$lambda$1(KTypeImpl this$0) {
        Type type = this$0.getJavaType();
        Intrinsics.checkNotNull(type);
        return ReflectClassUtilKt.getParameterizedTypeArguments(type);
    }

    private static final List<Type> arguments_delegate$lambda$5$lambda$2(Lazy<? extends List<? extends Type>> $parameterizedTypeArguments$delegate) {
        Lazy<? extends List<? extends Type>> lazy = $parameterizedTypeArguments$delegate;
        return lazy.getValue();
    }

    private static final Type arguments_delegate$lambda$5$lambda$4$lambda$3(KTypeImpl this$0, int $i, Lazy<? extends List<? extends Type>> parameterizedTypeArguments$delegate) {
        Type type;
        Type javaType = this$0.getJavaType();
        if (javaType instanceof Class) {
            Class<Object> clazz = ((Class)javaType).isArray() ? ((Class)javaType).getComponentType() : Object.class;
            Intrinsics.checkNotNull(clazz);
            type = (Type)((Object)clazz);
        } else if (javaType instanceof GenericArrayType) {
            if ($i != 0) {
                throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this$0);
            }
            Type type2 = ((GenericArrayType)javaType).getGenericComponentType();
            Intrinsics.checkNotNull(type2);
            type = type2;
        } else if (javaType instanceof ParameterizedType) {
            Type argument = KTypeImpl.arguments_delegate$lambda$5$lambda$2(parameterizedTypeArguments$delegate).get($i);
            if (!(argument instanceof WildcardType)) {
                type = argument;
            } else {
                Type[] typeArray = ((WildcardType)argument).getLowerBounds();
                Intrinsics.checkNotNullExpressionValue(typeArray, "getLowerBounds(...)");
                Type type3 = (Type)ArraysKt.firstOrNull((Object[])typeArray);
                if (type3 == null) {
                    Type[] typeArray2 = ((WildcardType)argument).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(typeArray2, "getUpperBounds(...)");
                    type3 = (Type)ArraysKt.first((Object[])typeArray2);
                }
                Type type4 = type3;
                Intrinsics.checkNotNull(type4);
                type = type4;
            }
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this$0);
        }
        return type;
    }

    /*
     * WARNING - void declaration
     */
    private static final List arguments_delegate$lambda$5(KTypeImpl this$0, Function0 $computeJavaType) {
        void $this$mapIndexedTo$iv$iv;
        List<TypeProjection> typeArguments = this$0.type.getArguments();
        if (typeArguments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        Object object = this$0;
        Lazy parameterizedTypeArguments$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KTypeImpl$$Lambda$2((KTypeImpl)object));
        Iterable $this$mapIndexed$iv = typeArguments;
        boolean $i$f$mapIndexed = false;
        Iterable iterable = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            KTypeProjection kTypeProjection;
            void typeProjection;
            int n2;
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection2 = (TypeProjection)item$iv$iv;
            int n3 = n2;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            if (typeProjection.isStarProjection()) {
                kTypeProjection = KTypeProjection.Companion.getSTAR();
            } else {
                KTypeImpl$$Lambda$3 kTypeImpl$$Lambda$3;
                KotlinType kotlinType = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                if ($computeJavaType == null) {
                    kTypeImpl$$Lambda$3 = null;
                } else {
                    void i2;
                    object = parameterizedTypeArguments$delegate;
                    void var19_19 = i2;
                    KTypeImpl kTypeImpl = this$0;
                    kTypeImpl$$Lambda$3 = new KTypeImpl$$Lambda$3(kTypeImpl, (int)var19_19, (Lazy)object);
                }
                KTypeImpl type = new KTypeImpl(kotlinType, kTypeImpl$$Lambda$3);
                switch (WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()]) {
                    case 1: {
                        kTypeProjection = KTypeProjection.Companion.invariant(type);
                        break;
                    }
                    case 2: {
                        kTypeProjection = KTypeProjection.Companion.contravariant(type);
                        break;
                    }
                    case 3: {
                        kTypeProjection = KTypeProjection.Companion.covariant(type);
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            collection.add(kTypeProjection);
        }
        return (List)destination$iv$iv;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "arguments", "getArguments()Ljava/util/List;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ KClassifier accessor$KTypeImpl$lambda0(KTypeImpl kTypeImpl) {
        return KTypeImpl.classifier_delegate$lambda$0(kTypeImpl);
    }

    static /* synthetic */ List accessor$KTypeImpl$lambda1(KTypeImpl kTypeImpl, Function0 function0) {
        return KTypeImpl.arguments_delegate$lambda$5(kTypeImpl, function0);
    }

    static /* synthetic */ List accessor$KTypeImpl$lambda2(KTypeImpl kTypeImpl) {
        return KTypeImpl.arguments_delegate$lambda$5$lambda$1(kTypeImpl);
    }

    static /* synthetic */ Type accessor$KTypeImpl$lambda3(KTypeImpl kTypeImpl, int n2, Lazy lazy) {
        return KTypeImpl.arguments_delegate$lambda$5$lambda$4$lambda$3(kTypeImpl, n2, lazy);
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

