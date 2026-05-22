/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nfunctionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 functionTypes.kt\norg/jetbrains/kotlin/builtins/FunctionTypesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n1#2:302\n1563#3:303\n1634#3,3:304\n230#3,2:307\n1563#3:309\n1634#3,3:310\n1563#3:313\n1634#3,3:314\n1604#3,4:317\n*S KotlinDebug\n*F\n+ 1 functionTypes.kt\norg/jetbrains/kotlin/builtins/FunctionTypesKt\n*L\n160#1:303\n160#1:304,3\n195#1:307,2\n200#1:309\n200#1:310,3\n222#1:313\n222#1:314,3\n225#1:317,4\n*E\n"})
public final class FunctionTypesKt {
    @Nullable
    public static final FunctionTypeKind getFunctionTypeKind(@NotNull KotlinType $this$functionTypeKind) {
        Intrinsics.checkNotNullParameter($this$functionTypeKind, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$functionTypeKind.getConstructor().getDeclarationDescriptor();
        return classifierDescriptor != null ? FunctionTypesKt.getFunctionTypeKind(classifierDescriptor) : null;
    }

    public static final boolean isFunctionType(@NotNull KotlinType $this$isFunctionType) {
        Intrinsics.checkNotNullParameter($this$isFunctionType, "<this>");
        return Intrinsics.areEqual(FunctionTypesKt.getFunctionTypeKind($this$isFunctionType), FunctionTypeKind.Function.INSTANCE);
    }

    public static final boolean isSuspendFunctionType(@NotNull KotlinType $this$isSuspendFunctionType) {
        Intrinsics.checkNotNullParameter($this$isSuspendFunctionType, "<this>");
        return Intrinsics.areEqual(FunctionTypesKt.getFunctionTypeKind($this$isSuspendFunctionType), FunctionTypeKind.SuspendFunction.INSTANCE);
    }

    public static final boolean isBuiltinFunctionalType(@NotNull KotlinType $this$isBuiltinFunctionalType) {
        Intrinsics.checkNotNullParameter($this$isBuiltinFunctionalType, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$isBuiltinFunctionalType.getConstructor().getDeclarationDescriptor();
        return classifierDescriptor != null ? FunctionTypesKt.isBuiltinFunctionalClassDescriptor(classifierDescriptor) : false;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(@NotNull DeclarationDescriptor $this$isBuiltinFunctionalClassDescriptor) {
        Intrinsics.checkNotNullParameter($this$isBuiltinFunctionalClassDescriptor, "<this>");
        FunctionTypeKind functionalClassKind = FunctionTypesKt.getFunctionTypeKind($this$isBuiltinFunctionalClassDescriptor);
        return Intrinsics.areEqual(functionalClassKind, FunctionTypeKind.Function.INSTANCE) || Intrinsics.areEqual(functionalClassKind, FunctionTypeKind.SuspendFunction.INSTANCE);
    }

    public static final boolean isBuiltinExtensionFunctionalType(@NotNull KotlinType $this$isBuiltinExtensionFunctionalType) {
        Intrinsics.checkNotNullParameter($this$isBuiltinExtensionFunctionalType, "<this>");
        return FunctionTypesKt.isBuiltinFunctionalType($this$isBuiltinExtensionFunctionalType) && FunctionTypesKt.isTypeAnnotatedWithExtensionFunctionType($this$isBuiltinExtensionFunctionalType);
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType $this$isTypeAnnotatedWithExtensionFunctionType) {
        return $this$isTypeAnnotatedWithExtensionFunctionType.getAnnotations().findAnnotation(StandardNames.FqNames.extensionFunctionType) != null;
    }

    @Nullable
    public static final FunctionTypeKind getFunctionTypeKind(@NotNull DeclarationDescriptor $this$getFunctionTypeKind) {
        Intrinsics.checkNotNullParameter($this$getFunctionTypeKind, "<this>");
        if (!($this$getFunctionTypeKind instanceof ClassDescriptor)) {
            return null;
        }
        if (!KotlinBuiltIns.isUnderKotlinPackage($this$getFunctionTypeKind)) {
            return null;
        }
        return FunctionTypesKt.getFunctionTypeKind(DescriptorUtilsKt.getFqNameUnsafe($this$getFunctionTypeKind));
    }

    private static final FunctionTypeKind getFunctionTypeKind(FqNameUnsafe $this$getFunctionTypeKind) {
        if (!$this$getFunctionTypeKind.isSafe() || $this$getFunctionTypeKind.isRoot()) {
            return null;
        }
        FunctionTypeKindExtractor functionTypeKindExtractor = FunctionTypeKindExtractor.Companion.getDefault();
        FqName fqName = $this$getFunctionTypeKind.toSafe().parent();
        String string = $this$getFunctionTypeKind.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        return functionTypeKindExtractor.getFunctionalClassKind(fqName, string);
    }

    public static final int contextFunctionTypeParamsCount(@NotNull KotlinType $this$contextFunctionTypeParamsCount) {
        Intrinsics.checkNotNullParameter($this$contextFunctionTypeParamsCount, "<this>");
        AnnotationDescriptor annotationDescriptor = $this$contextFunctionTypeParamsCount.getAnnotations().findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (annotationDescriptor == null) {
            return 0;
        }
        AnnotationDescriptor annotationDescriptor2 = annotationDescriptor;
        ConstantValue<?> constantValue = MapsKt.getValue(annotationDescriptor2.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        Intrinsics.checkNotNull(constantValue, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((Number)((IntValue)constantValue).getValue()).intValue();
    }

    @Nullable
    public static final KotlinType getReceiverTypeFromFunctionType(@NotNull KotlinType $this$getReceiverTypeFromFunctionType) {
        Intrinsics.checkNotNullParameter($this$getReceiverTypeFromFunctionType, "<this>");
        boolean bl2 = FunctionTypesKt.isBuiltinFunctionalType($this$getReceiverTypeFromFunctionType);
        if (_Assertions.ENABLED && !bl2) {
            boolean bl3 = false;
            String string = "Not a function type: " + $this$getReceiverTypeFromFunctionType;
            throw new AssertionError((Object)string);
        }
        if (!FunctionTypesKt.isTypeAnnotatedWithExtensionFunctionType($this$getReceiverTypeFromFunctionType)) {
            return null;
        }
        int index = FunctionTypesKt.contextFunctionTypeParamsCount($this$getReceiverTypeFromFunctionType);
        return $this$getReceiverTypeFromFunctionType.getArguments().get(index).getType();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(@NotNull KotlinType $this$getContextReceiverTypesFromFunctionType) {
        List list;
        Intrinsics.checkNotNullParameter($this$getContextReceiverTypesFromFunctionType, "<this>");
        boolean bl2 = FunctionTypesKt.isBuiltinFunctionalType($this$getContextReceiverTypesFromFunctionType);
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-FunctionTypesKt$getContextReceiverTypesFromFunctionType$22 = false;
            String $i$a$-assert-FunctionTypesKt$getContextReceiverTypesFromFunctionType$22 = "Not a function type: " + $this$getContextReceiverTypesFromFunctionType;
            throw new AssertionError((Object)$i$a$-assert-FunctionTypesKt$getContextReceiverTypesFromFunctionType$22);
        }
        int contextReceiversCount = FunctionTypesKt.contextFunctionTypeParamsCount($this$getContextReceiverTypesFromFunctionType);
        if (contextReceiversCount == 0) {
            list = CollectionsKt.emptyList();
        } else {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = $this$getContextReceiverTypesFromFunctionType.getArguments().subList(0, contextReceiversCount);
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                TypeProjection typeProjection = (TypeProjection)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add(it.getType());
            }
            list = (List)destination$iv$iv;
        }
        return list;
    }

    @NotNull
    public static final KotlinType getReturnTypeFromFunctionType(@NotNull KotlinType $this$getReturnTypeFromFunctionType) {
        Intrinsics.checkNotNullParameter($this$getReturnTypeFromFunctionType, "<this>");
        boolean bl2 = FunctionTypesKt.isBuiltinFunctionalType($this$getReturnTypeFromFunctionType);
        if (_Assertions.ENABLED && !bl2) {
            boolean bl3 = false;
            String string = "Not a function type: " + $this$getReturnTypeFromFunctionType;
            throw new AssertionError((Object)string);
        }
        KotlinType kotlinType = CollectionsKt.last($this$getReturnTypeFromFunctionType.getArguments()).getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return kotlinType;
    }

    @NotNull
    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(@NotNull KotlinType $this$getValueParameterTypesFromFunctionType) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$getValueParameterTypesFromFunctionType, "<this>");
        boolean bl3 = FunctionTypesKt.isBuiltinFunctionalType($this$getValueParameterTypesFromFunctionType);
        if (_Assertions.ENABLED && !bl3) {
            boolean $i$a$-assert-FunctionTypesKt$getValueParameterTypesFromFunctionType$32 = false;
            String $i$a$-assert-FunctionTypesKt$getValueParameterTypesFromFunctionType$32 = "Not a function type: " + $this$getValueParameterTypesFromFunctionType;
            throw new AssertionError((Object)$i$a$-assert-FunctionTypesKt$getValueParameterTypesFromFunctionType$32);
        }
        List<TypeProjection> arguments = $this$getValueParameterTypesFromFunctionType.getArguments();
        int first = FunctionTypesKt.contextFunctionTypeParamsCount($this$getValueParameterTypesFromFunctionType) + (FunctionTypesKt.isBuiltinExtensionFunctionalType($this$getValueParameterTypesFromFunctionType) ? 1 : 0);
        int last = arguments.size() - 1;
        boolean bl4 = bl2 = first <= last;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl5 = false;
            String string = "Not an exact function type: " + $this$getValueParameterTypesFromFunctionType;
            throw new AssertionError((Object)string);
        }
        return arguments.subList(first, last);
    }

    @Nullable
    public static final Name extractParameterNameFromFunctionTypeArgument(@NotNull KotlinType $this$extractParameterNameFromFunctionTypeArgument) {
        Object object;
        block5: {
            block4: {
                Object object2;
                StringValue stringValue;
                Intrinsics.checkNotNullParameter($this$extractParameterNameFromFunctionTypeArgument, "<this>");
                AnnotationDescriptor annotationDescriptor = $this$extractParameterNameFromFunctionTypeArgument.getAnnotations().findAnnotation(StandardNames.FqNames.parameterName);
                if (annotationDescriptor == null) {
                    return null;
                }
                AnnotationDescriptor annotation = annotationDescriptor;
                Object object3 = CollectionsKt.singleOrNull((Iterable)annotation.getAllValueArguments().values());
                StringValue stringValue2 = stringValue = object3 instanceof StringValue ? (StringValue)object3 : null;
                if (stringValue == null || (object3 = (String)stringValue.getValue()) == null) break block4;
                Object it = object2 = object3;
                boolean bl2 = false;
                Object object4 = object = Name.isValidIdentifier(it) ? object2 : null;
                if (object != null) break block5;
            }
            return null;
        }
        Object name = object;
        return Name.identifier(name);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<TypeProjection> getFunctionTypeArgumentProjections(@Nullable KotlinType receiverType, @NotNull List<? extends KotlinType> contextReceiverTypes, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> parameterNames, @NotNull KotlinType returnType, @NotNull KotlinBuiltIns builtIns) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ArrayList<TypeProjection> arguments = new ArrayList<TypeProjection>(parameterTypes.size() + contextReceiverTypes.size() + (receiverType != null ? 1 : 0) + 1);
        Iterable iterable = contextReceiverTypes;
        Collection<TypeProjection> collection = arguments;
        boolean $i$f$map = false;
        void var9_10 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            KotlinType kotlinType = (KotlinType)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl2 = false;
            collection2.add(TypeUtilsKt.asTypeProjection((KotlinType)it));
        }
        ((ArrayList)collection).addAll((List)destination$iv$iv);
        KotlinType kotlinType = receiverType;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)arguments, kotlinType != null ? TypeUtilsKt.asTypeProjection(kotlinType) : null);
        Iterable $this$mapIndexedTo$iv = parameterTypes;
        boolean $i$f$mapIndexedTo = false;
        int index$iv = 0;
        for (Object item$iv : $this$mapIndexedTo$iv) {
            KotlinType kotlinType2;
            void type;
            List<Name> name;
            List<Name> list;
            void index;
            int n2;
            Object item$iv$iv;
            Collection collection3 = arguments;
            if ((n2 = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            item$iv$iv = (KotlinType)item$iv;
            int it = n2;
            collection = collection3;
            boolean bl3 = false;
            List<Name> list2 = parameterNames;
            if (list2 != null && (list2 = list2.get((int)index)) != null) {
                List<Name> list3;
                List<Name> it2 = list3 = list2;
                boolean bl4 = false;
                list = !((Name)((Object)it2)).isSpecial() ? list3 : null;
            } else {
                list = name = null;
            }
            if (name != null) {
                String string = ((Name)((Object)name)).asString();
                Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
                BuiltInAnnotationDescriptor parameterNameAnnotation = new BuiltInAnnotationDescriptor(builtIns, StandardNames.FqNames.parameterName, MapsKt.mapOf(TuplesKt.to(StandardNames.NAME, new StringValue(string))), false, 8, null);
                kotlinType2 = TypeUtilsKt.replaceAnnotations((KotlinType)type, Annotations.Companion.create(CollectionsKt.plus((Iterable)type.getAnnotations(), parameterNameAnnotation)));
            } else {
                kotlinType2 = type;
            }
            void typeToUse = kotlinType2;
            collection.add(TypeUtilsKt.asTypeProjection((KotlinType)typeToUse));
        }
        arguments.add(TypeUtilsKt.asTypeProjection(returnType));
        return arguments;
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType createFunctionType(@NotNull KotlinBuiltIns builtIns, @NotNull Annotations annotations, @Nullable KotlinType receiverType, @NotNull List<? extends KotlinType> contextReceiverTypes, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> parameterNames, @NotNull KotlinType returnType, boolean suspendFunction) {
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        List<TypeProjection> arguments = FunctionTypesKt.getFunctionTypeArgumentProjections(receiverType, contextReceiverTypes, parameterTypes, parameterNames, returnType, builtIns);
        int parameterCount = parameterTypes.size() + contextReceiverTypes.size() + (receiverType == null ? 0 : 1);
        ClassDescriptor classDescriptor = FunctionTypesKt.getFunctionDescriptor(builtIns, parameterCount, suspendFunction);
        Annotations typeAnnotations = annotations;
        if (receiverType != null) {
            typeAnnotations = FunctionTypesKt.withExtensionFunctionAnnotation(typeAnnotations, builtIns);
        }
        if (!((Collection)contextReceiverTypes).isEmpty()) {
            typeAnnotations = FunctionTypesKt.withContextReceiversFunctionAnnotation(typeAnnotations, builtIns, contextReceiverTypes.size());
        }
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(typeAnnotations), classDescriptor, arguments);
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List list, List list2, List list3, KotlinType kotlinType2, boolean bl2, int n2, Object object) {
        if ((n2 & 0x80) != 0) {
            bl2 = false;
        }
        return FunctionTypesKt.createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, list2, list3, kotlinType2, bl2);
    }

    @NotNull
    public static final Annotations withExtensionFunctionAnnotation(@NotNull Annotations $this$withExtensionFunctionAnnotation, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkNotNullParameter($this$withExtensionFunctionAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        return $this$withExtensionFunctionAnnotation.hasAnnotation(StandardNames.FqNames.extensionFunctionType) ? $this$withExtensionFunctionAnnotation : Annotations.Companion.create(CollectionsKt.plus((Iterable)$this$withExtensionFunctionAnnotation, new BuiltInAnnotationDescriptor(builtIns, StandardNames.FqNames.extensionFunctionType, MapsKt.emptyMap(), false, 8, null)));
    }

    @NotNull
    public static final Annotations withContextReceiversFunctionAnnotation(@NotNull Annotations $this$withContextReceiversFunctionAnnotation, @NotNull KotlinBuiltIns builtIns, int contextReceiversCount) {
        Intrinsics.checkNotNullParameter($this$withContextReceiversFunctionAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        return $this$withContextReceiversFunctionAnnotation.hasAnnotation(StandardNames.FqNames.contextFunctionTypeParams) ? $this$withContextReceiversFunctionAnnotation : Annotations.Companion.create(CollectionsKt.plus((Iterable)$this$withContextReceiversFunctionAnnotation, new BuiltInAnnotationDescriptor(builtIns, StandardNames.FqNames.contextFunctionTypeParams, MapsKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(contextReceiversCount))), false, 8, null)));
    }

    @NotNull
    public static final ClassDescriptor getFunctionDescriptor(@NotNull KotlinBuiltIns builtIns, int parameterCount, boolean isSuspendFunction) {
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ClassDescriptor classDescriptor = isSuspendFunction ? builtIns.getSuspendFunction(parameterCount) : builtIns.getFunction(parameterCount);
        Intrinsics.checkNotNull(classDescriptor);
        return classDescriptor;
    }
}

