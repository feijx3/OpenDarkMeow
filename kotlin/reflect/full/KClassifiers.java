/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007\u001a.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"createType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "annotations", "", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "attributes", "Lkotlin/reflect/jvm/internal/impl/types/TypeAttributes;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "starProjectedType", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "kotlin-reflection"})
@JvmName(name="KClassifiers")
@SourceDebugExtension(value={"SMAP\nKClassifiers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassifiers.kt\nkotlin/reflect/full/KClassifiers\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1573#2:98\n1604#2,4:99\n1563#2:103\n1634#2,3:104\n*S KotlinDebug\n*F\n+ 1 KClassifiers.kt\nkotlin/reflect/full/KClassifiers\n*L\n69#1:98\n69#1:99,4\n95#1:103\n95#1:104,3\n*E\n"})
public final class KClassifiers {
    @SinceKotlin(version="1.1")
    @NotNull
    public static final KType createType(@NotNull KClassifier $this$createType, @NotNull List<KTypeProjection> arguments, boolean nullable, @NotNull List<? extends Annotation> annotations) {
        Intrinsics.checkNotNullParameter($this$createType, "<this>");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Object object = $this$createType instanceof KClassifierImpl ? (KClassifierImpl)((Object)$this$createType) : null;
        if (object == null || (object = object.getDescriptor()) == null) {
            throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + $this$createType + " (" + $this$createType.getClass() + ')');
        }
        Object descriptor2 = object;
        TypeConstructor typeConstructor2 = descriptor2.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        TypeConstructor typeConstructor3 = typeConstructor2;
        List<TypeParameterDescriptor> list = typeConstructor3.getParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
        List<TypeParameterDescriptor> parameters = list;
        if (parameters.size() != arguments.size()) {
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
        }
        TypeAttributes typeAttributes = annotations.isEmpty() ? TypeAttributes.Companion.getEmpty() : TypeAttributes.Companion.getEmpty();
        return new KTypeImpl(KClassifiers.createKotlinType(typeAttributes, typeConstructor3, arguments, nullable), null, 2, null);
    }

    public static /* synthetic */ KType createType$default(KClassifier kClassifier, List list, boolean bl2, List list2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return KClassifiers.createType(kClassifier, list, bl2, list2);
    }

    /*
     * WARNING - void declaration
     */
    private static final SimpleType createKotlinType(TypeAttributes attributes, TypeConstructor typeConstructor2, List<KTypeProjection> arguments, boolean nullable) {
        Collection<TypeProjectionBase> collection;
        void $this$mapIndexedTo$iv$iv;
        void $this$mapIndexed$iv;
        List<TypeParameterDescriptor> list = typeConstructor2.getParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
        List<TypeParameterDescriptor> parameters = list;
        Iterable iterable = arguments;
        TypeConstructor typeConstructor3 = typeConstructor2;
        TypeAttributes typeAttributes = attributes;
        boolean $i$f$mapIndexed = false;
        void var7_9 = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            TypeProjectionBase typeProjectionBase;
            void typeProjection;
            int n2;
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KTypeProjection kTypeProjection = (KTypeProjection)item$iv$iv;
            int n3 = n2;
            collection = destination$iv$iv;
            boolean bl2 = false;
            KTypeImpl kTypeImpl = (KTypeImpl)typeProjection.getType();
            KotlinType type = kTypeImpl != null ? kTypeImpl.getType() : null;
            KVariance kVariance = typeProjection.getVariance();
            switch (kVariance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()]) {
                case 1: {
                    KotlinType kotlinType = type;
                    Intrinsics.checkNotNull(kotlinType);
                    typeProjectionBase = new TypeProjectionImpl(Variance.INVARIANT, kotlinType);
                    break;
                }
                case 2: {
                    KotlinType kotlinType = type;
                    Intrinsics.checkNotNull(kotlinType);
                    typeProjectionBase = new TypeProjectionImpl(Variance.IN_VARIANCE, kotlinType);
                    break;
                }
                case 3: {
                    KotlinType kotlinType = type;
                    Intrinsics.checkNotNull(kotlinType);
                    typeProjectionBase = new TypeProjectionImpl(Variance.OUT_VARIANCE, kotlinType);
                    break;
                }
                case -1: {
                    void index;
                    TypeParameterDescriptor typeParameterDescriptor = parameters.get((int)index);
                    Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "get(...)");
                    typeProjectionBase = new StarProjectionImpl(typeParameterDescriptor);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            collection.add(typeProjectionBase);
        }
        collection = (List)destination$iv$iv;
        return KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor3, (List)collection, nullable, null, 16, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final KType getStarProjectedType(@NotNull KClassifier $this$starProjectedType) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter($this$starProjectedType, "<this>");
        Object object = $this$starProjectedType instanceof KClassifierImpl ? (KClassifierImpl)((Object)$this$starProjectedType) : null;
        if (object == null || (object = object.getDescriptor()) == null) {
            return KClassifiers.createType$default($this$starProjectedType, null, false, null, 7, null);
        }
        Object descriptor2 = object;
        List<TypeParameterDescriptor> list = descriptor2.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
        List<TypeParameterDescriptor> typeParameters = list;
        if (typeParameters.isEmpty()) {
            return KClassifiers.createType$default($this$starProjectedType, null, false, null, 7, null);
        }
        Iterable iterable = typeParameters;
        KClassifier kClassifier = $this$starProjectedType;
        boolean $i$f$map = false;
        void var5_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(KTypeProjection.Companion.getSTAR());
        }
        return KClassifiers.createType$default(kClassifier, (List)destination$iv$iv, false, null, 6, null);
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getStarProjectedType$annotations(KClassifier kClassifier) {
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[KVariance.values().length];
            try {
                nArray[KVariance.INVARIANT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KVariance.IN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KVariance.OUT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

