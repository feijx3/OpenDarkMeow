/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPositionKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\ntypeEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,261:1\n1#2:262\n3544#3,7:263\n1740#3,3:270\n3544#3,7:273\n*S KotlinDebug\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n*L\n117#1:263,7\n143#1:270,3\n155#1:273,7\n*E\n"})
public final class JavaTypeEnhancement {
    @NotNull
    private final JavaResolverSettings javaResolverSettings;

    public JavaTypeEnhancement(@NotNull JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    @Nullable
    public final KotlinType enhance(@NotNull KotlinType $this$enhance, @NotNull Function1<? super Integer, JavaTypeQualifiers> qualifiers, boolean isSuperTypesEnhancement) {
        Intrinsics.checkNotNullParameter($this$enhance, "<this>");
        Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return this.enhancePossiblyFlexible($this$enhance.unwrap(), qualifiers, 0, isSuperTypesEnhancement).getType();
    }

    private final Result enhancePossiblyFlexible(UnwrappedType $this$enhancePossiblyFlexible, Function1<? super Integer, JavaTypeQualifiers> qualifiers, int index, boolean isSuperTypesEnhancement) {
        Result result;
        block20: {
            UnwrappedType unwrappedType;
            block14: {
                UnwrappedType unwrappedType2;
                SimpleResult lowerResult;
                block16: {
                    SimpleResult upperResult;
                    boolean isRawType;
                    block17: {
                        UnwrappedType unwrappedType3;
                        block19: {
                            block18: {
                                block15: {
                                    boolean bl2;
                                    if (KotlinTypeKt.isError($this$enhancePossiblyFlexible)) {
                                        return new Result(null, 1);
                                    }
                                    unwrappedType = $this$enhancePossiblyFlexible;
                                    if (!(unwrappedType instanceof FlexibleType)) break block14;
                                    isRawType = $this$enhancePossiblyFlexible instanceof RawType;
                                    lowerResult = this.enhanceInflexible(((FlexibleType)$this$enhancePossiblyFlexible).getLowerBound(), qualifiers, index, TypeComponentPosition.FLEXIBLE_LOWER, isRawType, isSuperTypesEnhancement);
                                    upperResult = this.enhanceInflexible(((FlexibleType)$this$enhancePossiblyFlexible).getUpperBound(), qualifiers, index, TypeComponentPosition.FLEXIBLE_UPPER, isRawType, isSuperTypesEnhancement);
                                    boolean bl3 = bl2 = lowerResult.getSubtreeSize() == upperResult.getSubtreeSize();
                                    if (_Assertions.ENABLED && !bl2) {
                                        boolean $i$a$-assert-JavaTypeEnhancement$enhancePossiblyFlexible$22 = false;
                                        String $i$a$-assert-JavaTypeEnhancement$enhancePossiblyFlexible$22 = "Different tree sizes of bounds: lower = (" + ((FlexibleType)$this$enhancePossiblyFlexible).getLowerBound() + ", " + lowerResult.getSubtreeSize() + "), upper = (" + ((FlexibleType)$this$enhancePossiblyFlexible).getUpperBound() + ", " + upperResult.getSubtreeSize() + ')';
                                        throw new AssertionError((Object)$i$a$-assert-JavaTypeEnhancement$enhancePossiblyFlexible$22);
                                    }
                                    if (lowerResult.getType() != null || upperResult.getType() != null) break block15;
                                    unwrappedType2 = null;
                                    break block16;
                                }
                                if (!lowerResult.getForWarnings() && !upperResult.getForWarnings()) break block17;
                                unwrappedType3 = upperResult.getType();
                                if (unwrappedType3 == null) break block18;
                                SimpleType it = unwrappedType3;
                                boolean bl4 = false;
                                SimpleType simpleType = lowerResult.getType();
                                if (simpleType == null) {
                                    simpleType = it;
                                }
                                UnwrappedType unwrappedType4 = KotlinTypeFactory.flexibleType(simpleType, it);
                                unwrappedType3 = unwrappedType4;
                                if (unwrappedType4 != null) break block19;
                            }
                            SimpleType simpleType = lowerResult.getType();
                            Intrinsics.checkNotNull(simpleType);
                            unwrappedType3 = simpleType;
                        }
                        UnwrappedType enhancement = unwrappedType3;
                        unwrappedType2 = TypeWithEnhancementKt.wrapEnhancement($this$enhancePossiblyFlexible, enhancement);
                        break block16;
                    }
                    if (isRawType) {
                        SimpleType simpleType;
                        SimpleType simpleType2 = lowerResult.getType();
                        if (simpleType2 == null) {
                            simpleType2 = ((FlexibleType)$this$enhancePossiblyFlexible).getLowerBound();
                        }
                        if ((simpleType = upperResult.getType()) == null) {
                            simpleType = ((FlexibleType)$this$enhancePossiblyFlexible).getUpperBound();
                        }
                        unwrappedType2 = new RawTypeImpl(simpleType2, simpleType);
                    } else {
                        SimpleType simpleType;
                        SimpleType simpleType3 = lowerResult.getType();
                        if (simpleType3 == null) {
                            simpleType3 = ((FlexibleType)$this$enhancePossiblyFlexible).getLowerBound();
                        }
                        if ((simpleType = upperResult.getType()) == null) {
                            simpleType = ((FlexibleType)$this$enhancePossiblyFlexible).getUpperBound();
                        }
                        unwrappedType2 = KotlinTypeFactory.flexibleType(simpleType3, simpleType);
                    }
                }
                UnwrappedType type = unwrappedType2;
                result = new Result(type, lowerResult.getSubtreeSize());
                break block20;
            }
            if (unwrappedType instanceof SimpleType) {
                SimpleResult result2 = JavaTypeEnhancement.enhanceInflexible$default(this, (SimpleType)$this$enhancePossiblyFlexible, qualifiers, index, TypeComponentPosition.INFLEXIBLE, false, isSuperTypesEnhancement, 8, null);
                result = new Result(result2.getForWarnings() ? TypeWithEnhancementKt.wrapEnhancement($this$enhancePossiblyFlexible, result2.getType()) : (UnwrappedType)result2.getType(), result2.getSubtreeSize());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return result;
    }

    /*
     * WARNING - void declaration
     */
    private final SimpleResult enhanceInflexible(SimpleType $this$enhanceInflexible, Function1<? super Integer, JavaTypeQualifiers> qualifiers, int index, TypeComponentPosition position, boolean isBoundOfRawType, boolean isSuperTypesEnhancement) {
        void other$iv;
        void $this$zip$iv;
        Iterator element$iv2;
        Object it;
        Object object;
        void $this$zip$iv2;
        boolean shouldEnhanceArguments;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(position);
        boolean bl2 = shouldEnhanceArguments = !isSuperTypesEnhancement || !isBoundOfRawType;
        if (!shouldEnhance && $this$enhanceInflexible.getArguments().isEmpty()) {
            return new SimpleResult(null, 1, false);
        }
        ClassifierDescriptor classifierDescriptor = $this$enhanceInflexible.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            return new SimpleResult(null, 1, false);
        }
        ClassifierDescriptor originalClass = classifierDescriptor;
        JavaTypeQualifiers effectiveQualifiers = qualifiers.invoke((Integer)index);
        ClassifierDescriptor enhancedClassifier = TypeEnhancementKt.access$enhanceMutability(originalClass, effectiveQualifiers, position);
        Boolean enhancedNullability = TypeEnhancementKt.access$getEnhancedNullability(effectiveQualifiers, position);
        Object object2 = enhancedClassifier;
        if (object2 == null || (object2 = object2.getTypeConstructor()) == null) {
            object2 = $this$enhanceInflexible.getConstructor();
        }
        Object typeConstructor2 = object2;
        int globalArgIndex = 0;
        globalArgIndex = index + 1;
        Iterable iterable = $this$enhanceInflexible.getArguments();
        List<TypeParameterDescriptor> list = typeConstructor2.getParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
        Iterable other$iv2 = list;
        boolean $i$f$zip = false;
        Object first$iv = $this$zip$iv2.iterator();
        Iterator second$iv = other$iv2.iterator();
        Annotations[] list$iv = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault($this$zip$iv2, 10), CollectionsKt.collectionSizeOrDefault(other$iv2, 10)));
        while (first$iv.hasNext() && second$iv.hasNext()) {
            TypeProjection typeProjection;
            void parameter;
            void arg;
            Result result;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)second$iv.next();
            TypeProjection typeProjection2 = (TypeProjection)first$iv.next();
            object = list$iv;
            boolean bl3 = false;
            if (!shouldEnhanceArguments) {
                result = new Result(null, 0);
            } else if (!arg.isStarProjection()) {
                result = this.enhancePossiblyFlexible(arg.getType().unwrap(), qualifiers, globalArgIndex, isSuperTypesEnhancement);
            } else if (qualifiers.invoke((Integer)globalArgIndex).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                it = arg.getType().unwrap();
                boolean bl4 = false;
                result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible((KotlinType)it).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible((KotlinType)it).makeNullableAsSpecified(true)), 1);
            } else {
                result = new Result(null, 1);
            }
            Result enhanced = result;
            globalArgIndex += enhanced.getSubtreeSize();
            if (enhanced.getType() != null) {
                KotlinType kotlinType = enhanced.getType();
                Variance variance = arg.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue((Object)variance, "getProjectionKind(...)");
                typeProjection = TypeUtilsKt.createProjection(kotlinType, variance, (TypeParameterDescriptor)parameter);
            } else if (enhancedClassifier != null && !arg.isStarProjection()) {
                KotlinType kotlinType = arg.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                Variance variance = arg.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue((Object)variance, "getProjectionKind(...)");
                typeProjection = TypeUtilsKt.createProjection(kotlinType, variance, (TypeParameterDescriptor)parameter);
            } else {
                typeProjection = enhancedClassifier != null ? TypeUtils.makeStarProjection((TypeParameterDescriptor)parameter) : null;
            }
            object.add(typeProjection);
        }
        List enhancedArguments = (List)list$iv;
        int subtreeSize = globalArgIndex - index;
        if (enhancedClassifier == null && enhancedNullability == null) {
            boolean bl5;
            block21: {
                Iterable $this$all$iv = enhancedArguments;
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl5 = true;
                } else {
                    for (Iterator element$iv2 : $this$all$iv) {
                        TypeProjection it2 = (TypeProjection)((Object)element$iv2);
                        boolean bl6 = false;
                        if (it2 == null) continue;
                        bl5 = false;
                        break block21;
                    }
                    bl5 = true;
                }
            }
            if (bl5) {
                return new SimpleResult(null, subtreeSize, false);
            }
        }
        Annotations[] $i$f$all = new Annotations[3];
        $i$f$all[0] = $this$enhanceInflexible.getAnnotations();
        first$iv = TypeEnhancementKt.access$getENHANCED_MUTABILITY_ANNOTATIONS$p();
        element$iv2 = first$iv;
        int n2 = 1;
        object = $i$f$all;
        boolean bl7 = false;
        boolean bl8 = enhancedClassifier != null;
        object[n2] = bl8 ? first$iv : null;
        Object it3 = first$iv = TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS();
        n2 = 2;
        object = $i$f$all;
        boolean bl9 = false;
        bl8 = enhancedNullability != null;
        object[n2] = bl8 ? first$iv : null;
        Annotations newAnnotations = TypeEnhancementKt.access$compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull($i$f$all));
        first$iv = enhancedArguments;
        it3 = $this$enhanceInflexible.getArguments();
        Object object3 = typeConstructor2;
        object = TypeAttributesKt.toDefaultAttributes(newAnnotations);
        boolean $i$f$zip2 = false;
        Iterator first$iv2 = $this$zip$iv.iterator();
        Iterator second$iv2 = other$iv.iterator();
        ArrayList<void> list$iv2 = new ArrayList<void>(Math.min(CollectionsKt.collectionSizeOrDefault($this$zip$iv, 10), CollectionsKt.collectionSizeOrDefault(other$iv, 10)));
        while (first$iv2.hasNext() && second$iv2.hasNext()) {
            void enhanced;
            it = (TypeProjection)second$iv2.next();
            TypeProjection bl4 = (TypeProjection)first$iv2.next();
            ArrayList<void> arrayList = list$iv2;
            boolean bl10 = false;
            void v11 = enhanced;
            if (v11 == null) {
                void original;
                v11 = original;
            }
            arrayList.add(v11);
        }
        List list2 = list$iv2;
        Boolean bl11 = enhancedNullability;
        SimpleType enhancedType = KotlinTypeFactory.simpleType$default((TypeAttributes)object, (TypeConstructor)object3, list2, bl11 != null ? bl11.booleanValue() : $this$enhanceInflexible.isMarkedNullable(), null, 16, null);
        SimpleType enhancement = effectiveQualifiers.getDefinitelyNotNull() ? this.notNullTypeParameter(enhancedType) : enhancedType;
        boolean nullabilityForWarning = enhancedNullability != null && effectiveQualifiers.isNullabilityQualifierForWarning();
        return new SimpleResult(enhancement, subtreeSize, nullabilityForWarning);
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int n2, TypeComponentPosition typeComponentPosition, boolean bl2, boolean bl3, int n3, Object object) {
        if ((n3 & 8) != 0) {
            bl2 = false;
        }
        if ((n3 & 0x10) != 0) {
            bl3 = false;
        }
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, n2, typeComponentPosition, bl2, bl3);
    }

    private final SimpleType notNullTypeParameter(SimpleType enhancedType) {
        return this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() ? SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(enhancedType, true) : (SimpleType)new NotNullTypeParameterImpl(enhancedType);
    }

    private static final class Result {
        @Nullable
        private final KotlinType type;
        private final int subtreeSize;

        public Result(@Nullable KotlinType type, int subtreeSize) {
            this.type = type;
            this.subtreeSize = subtreeSize;
        }

        @Nullable
        public final KotlinType getType() {
            return this.type;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }
    }

    private static final class SimpleResult {
        @Nullable
        private final SimpleType type;
        private final int subtreeSize;
        private final boolean forWarnings;

        public SimpleResult(@Nullable SimpleType type, int subtreeSize, boolean forWarnings) {
            this.type = type;
            this.subtreeSize = subtreeSize;
            this.forWarnings = forWarnings;
        }

        @Nullable
        public final SimpleType getType() {
            return this.type;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }
    }
}

