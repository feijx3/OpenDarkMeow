/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CapturedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\ntypeParameterUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeParameterUtils.kt\norg/jetbrains/kotlin/descriptors/TypeParameterUtilsKt\n+ 2 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n16#2,2:101\n1563#3:103\n1634#3,3:104\n*S KotlinDebug\n*F\n+ 1 typeParameterUtils.kt\norg/jetbrains/kotlin/descriptors/TypeParameterUtilsKt\n*L\n37#1:101,2\n42#1:103\n42#1:104,3\n*E\n"})
public final class TypeParameterUtilsKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(@NotNull ClassifierDescriptorWithTypeParameters $this$computeConstructorTypeParameters) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        List<TypeParameterDescriptor> containingClassTypeConstructorParameters;
        List<TypeParameterDescriptor> list;
        Object object;
        DeclarationDescriptor declarationDescriptor;
        Iterator<DeclarationDescriptor> iterator2;
        Object $this$firstIsInstanceOrNull$iv;
        List parametersFromContainingFunctions;
        List<TypeParameterDescriptor> declaredParameters;
        block5: {
            Intrinsics.checkNotNullParameter($this$computeConstructorTypeParameters, "<this>");
            List<TypeParameterDescriptor> list2 = $this$computeConstructorTypeParameters.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(list2, "getDeclaredTypeParameters(...)");
            declaredParameters = list2;
            if (!$this$computeConstructorTypeParameters.isInner() && !($this$computeConstructorTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
                return declaredParameters;
            }
            parametersFromContainingFunctions = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents($this$computeConstructorTypeParameters), TypeParameterUtilsKt$$Lambda$0.INSTANCE), TypeParameterUtilsKt$$Lambda$1.INSTANCE), TypeParameterUtilsKt$$Lambda$2.INSTANCE));
            $this$firstIsInstanceOrNull$iv = DescriptorUtilsKt.getParents($this$computeConstructorTypeParameters);
            boolean $i$f$firstIsInstanceOrNull = false;
            iterator2 = $this$firstIsInstanceOrNull$iv.iterator();
            while (iterator2.hasNext()) {
                DeclarationDescriptor element$iv = iterator2.next();
                if (!(element$iv instanceof ClassDescriptor)) continue;
                declarationDescriptor = element$iv;
                break block5;
            }
            declarationDescriptor = null;
        }
        if (((object = (ClassDescriptor)declarationDescriptor) != null && (object = object.getTypeConstructor()) != null ? object.getParameters() : (list = null)) == null) {
            list = containingClassTypeConstructorParameters = CollectionsKt.emptyList();
        }
        if (parametersFromContainingFunctions.isEmpty() && containingClassTypeConstructorParameters.isEmpty()) {
            List<TypeParameterDescriptor> list3 = $this$computeConstructorTypeParameters.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(list3, "getDeclaredTypeParameters(...)");
            return list3;
        }
        $this$firstIsInstanceOrNull$iv = CollectionsKt.plus((Collection)parametersFromContainingFunctions, (Iterable)containingClassTypeConstructorParameters);
        boolean $i$f$map = false;
        iterator2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(TypeParameterUtilsKt.capturedCopyForInnerDeclaration((TypeParameterDescriptor)it, $this$computeConstructorTypeParameters, declaredParameters.size()));
        }
        List additional = (List)destination$iv$iv;
        return CollectionsKt.plus((Collection)declaredParameters, (Iterable)additional);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor $this$capturedCopyForInnerDeclaration, DeclarationDescriptor declarationDescriptor, int declaredTypeParametersCount) {
        return new CapturedTypeParameterDescriptor($this$capturedCopyForInnerDeclaration, declarationDescriptor, declaredTypeParametersCount);
    }

    @Nullable
    public static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType $this$buildPossiblyInnerType) {
        Intrinsics.checkNotNullParameter($this$buildPossiblyInnerType, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$buildPossiblyInnerType.getConstructor().getDeclarationDescriptor();
        return TypeParameterUtilsKt.buildPossiblyInnerType($this$buildPossiblyInnerType, classifierDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters)classifierDescriptor : null, 0);
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType $this$buildPossiblyInnerType, ClassifierDescriptorWithTypeParameters classifierDescriptor, int index) {
        if (classifierDescriptor == null || ErrorUtils.isError(classifierDescriptor)) {
            return null;
        }
        int toIndex = classifierDescriptor.getDeclaredTypeParameters().size() + index;
        if (!classifierDescriptor.isInner()) {
            boolean bl2;
            boolean bl3 = bl2 = toIndex == $this$buildPossiblyInnerType.getArguments().size() || DescriptorUtils.isLocal(classifierDescriptor);
            if (_Assertions.ENABLED && !bl2) {
                boolean bl4 = false;
                String string = $this$buildPossiblyInnerType.getArguments().size() - toIndex + " trailing arguments were found in " + $this$buildPossiblyInnerType + " type";
                throw new AssertionError((Object)string);
            }
            return new PossiblyInnerType(classifierDescriptor, $this$buildPossiblyInnerType.getArguments().subList(index, $this$buildPossiblyInnerType.getArguments().size()), null);
        }
        List<TypeProjection> argumentsSubList = $this$buildPossiblyInnerType.getArguments().subList(index, toIndex);
        DeclarationDescriptor declarationDescriptor = classifierDescriptor.getContainingDeclaration();
        return new PossiblyInnerType(classifierDescriptor, argumentsSubList, TypeParameterUtilsKt.buildPossiblyInnerType($this$buildPossiblyInnerType, declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters)declarationDescriptor : null, toIndex));
    }

    private static final boolean computeConstructorTypeParameters$lambda$0(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof CallableDescriptor;
    }

    private static final boolean computeConstructorTypeParameters$lambda$1(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it instanceof ConstructorDescriptor);
    }

    private static final Sequence computeConstructorTypeParameters$lambda$2(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List<TypeParameterDescriptor> list = ((CallableDescriptor)it).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
        return CollectionsKt.asSequence((Iterable)list);
    }

    static /* synthetic */ boolean accessor$TypeParameterUtilsKt$lambda0(DeclarationDescriptor declarationDescriptor) {
        return TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$0(declarationDescriptor);
    }

    static /* synthetic */ boolean accessor$TypeParameterUtilsKt$lambda1(DeclarationDescriptor declarationDescriptor) {
        return TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$1(declarationDescriptor);
    }

    static /* synthetic */ Sequence accessor$TypeParameterUtilsKt$lambda2(DeclarationDescriptor declarationDescriptor) {
        return TypeParameterUtilsKt.computeConstructorTypeParameters$lambda$2(declarationDescriptor);
    }
}

