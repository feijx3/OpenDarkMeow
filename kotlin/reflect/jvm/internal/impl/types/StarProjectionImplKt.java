/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nStarProjectionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarProjectionImpl.kt\norg/jetbrains/kotlin/types/StarProjectionImplKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n1563#2:102\n1634#2,3:103\n1563#2:106\n1634#2,3:107\n*S KotlinDebug\n*F\n+ 1 StarProjectionImpl.kt\norg/jetbrains/kotlin/types/StarProjectionImplKt\n*L\n66#1:102\n66#1:103,3\n73#1:106\n73#1:107,3\n*E\n"})
public final class StarProjectionImplKt {
    private static final KotlinType buildStarProjectionTypeByTypeParameters(List<? extends TypeConstructor> typeParameters, List<? extends KotlinType> upperBounds, KotlinBuiltIns builtIns) {
        KotlinType kotlinType = TypeSubstitutor.create(new TypeConstructorSubstitution(typeParameters){
            final /* synthetic */ List<TypeConstructor> $typeParameters;
            {
                this.$typeParameters = $typeParameters;
            }

            public TypeProjection get(TypeConstructor key) {
                TypeProjection typeProjection;
                Intrinsics.checkNotNullParameter(key, "key");
                if (this.$typeParameters.contains(key)) {
                    ClassifierDescriptor classifierDescriptor = key.getDeclarationDescriptor();
                    Intrinsics.checkNotNull(classifierDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    typeProjection = TypeUtils.makeStarProjection((TypeParameterDescriptor)classifierDescriptor);
                } else {
                    typeProjection = null;
                }
                return typeProjection;
            }
        }).substitute(CollectionsKt.first(upperBounds), Variance.OUT_VARIANCE);
        if (kotlinType == null) {
            SimpleType simpleType = builtIns.getDefaultBound();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultBound(...)");
            kotlinType = simpleType;
        }
        return kotlinType;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final KotlinType starProjectionType(@NotNull TypeParameterDescriptor $this$starProjectionType) {
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter($this$starProjectionType, "<this>");
        DeclarationDescriptor declarationDescriptor = $this$starProjectionType.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
        DeclarationDescriptor descriptor2 = declarationDescriptor;
        if (descriptor2 instanceof ClassifierDescriptorWithTypeParameters) {
            void $this$mapTo$iv$iv;
            List<TypeParameterDescriptor> list = ((ClassifierDescriptorWithTypeParameters)descriptor2).getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                TypeConstructor typeConstructor2 = it.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
                collection.add(typeConstructor2);
            }
            List list2 = (List)destination$iv$iv;
            List<KotlinType> list3 = $this$starProjectionType.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list3, "getUpperBounds(...)");
            kotlinType = StarProjectionImplKt.buildStarProjectionTypeByTypeParameters(list2, list3, DescriptorUtilsKt.getBuiltIns($this$starProjectionType));
        } else if (descriptor2 instanceof FunctionDescriptor) {
            List<TypeParameterDescriptor> list = ((FunctionDescriptor)descriptor2).getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable $this$mapTo$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                TypeParameterDescriptor it = (TypeParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                TypeConstructor typeConstructor3 = it.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor3, "getTypeConstructor(...)");
                collection.add(typeConstructor3);
            }
            List list4 = (List)destination$iv$iv;
            List<KotlinType> list5 = $this$starProjectionType.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list5, "getUpperBounds(...)");
            kotlinType = StarProjectionImplKt.buildStarProjectionTypeByTypeParameters(list4, list5, DescriptorUtilsKt.getBuiltIns($this$starProjectionType));
        } else {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        return kotlinType;
    }
}

