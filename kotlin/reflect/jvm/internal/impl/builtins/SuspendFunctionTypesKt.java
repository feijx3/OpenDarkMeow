/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nsuspendFunctionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 suspendFunctionTypes.kt\norg/jetbrains/kotlin/builtins/SuspendFunctionTypesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1563#2:66\n1634#2,3:67\n1#3:70\n*S KotlinDebug\n*F\n+ 1 suspendFunctionTypes.kt\norg/jetbrains/kotlin/builtins/SuspendFunctionTypesKt\n*L\n54#1:66\n54#1:67,3\n*E\n"})
public final class SuspendFunctionTypesKt {
    @NotNull
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR;

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(@NotNull KotlinType suspendFunType) {
        Collection<KotlinType> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(suspendFunType, "suspendFunType");
        boolean bl2 = FunctionTypesKt.isSuspendFunctionType(suspendFunType);
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-SuspendFunctionTypesKt$transformSuspendFunctionToRuntimeFunctionType$22 = false;
            String $i$a$-assert-SuspendFunctionTypesKt$transformSuspendFunctionToRuntimeFunctionType$22 = "This type should be suspend function type: " + suspendFunType;
            throw new AssertionError((Object)$i$a$-assert-SuspendFunctionTypesKt$transformSuspendFunctionToRuntimeFunctionType$22);
        }
        Iterable iterable = FunctionTypesKt.getValueParameterTypesFromFunctionType(suspendFunType);
        List<KotlinType> list = FunctionTypesKt.getContextReceiverTypesFromFunctionType(suspendFunType);
        KotlinType kotlinType = FunctionTypesKt.getReceiverTypeFromFunctionType(suspendFunType);
        Annotations annotations = suspendFunType.getAnnotations();
        KotlinBuiltIns kotlinBuiltIns = TypeUtilsKt.getBuiltIns(suspendFunType);
        boolean $i$f$map = false;
        void var3_10 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(p0.getType());
        }
        collection = (List)destination$iv$iv;
        Collection collection2 = collection;
        TypeAttributes typeAttributes = TypeAttributes.Companion.getEmpty();
        TypeConstructor typeConstructor2 = FAKE_CONTINUATION_CLASS_DESCRIPTOR.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        List<SimpleType> list2 = CollectionsKt.plus(collection2, KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor2, CollectionsKt.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(suspendFunType))), false, null, 16, null));
        SimpleType simpleType = TypeUtilsKt.getBuiltIns(suspendFunType).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getNullableAnyType(...)");
        return FunctionTypesKt.createFunctionType$default(kotlinBuiltIns, annotations, kotlinType, list, list2, null, simpleType, false, 128, null).makeNullableAsSpecified(suspendFunType.isMarkedNullable());
    }

    /*
     * WARNING - void declaration
     */
    static {
        void p0;
        MutableClassDescriptor mutableClassDescriptor;
        MutableClassDescriptor $this$FAKE_CONTINUATION_CLASS_DESCRIPTOR_u24lambda_u240 = mutableClassDescriptor = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(ErrorUtils.INSTANCE.getErrorModule(), StandardNames.COROUTINES_PACKAGE_FQ_NAME), ClassKind.INTERFACE, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME.shortName(), SourceElement.NO_SOURCE, LockBasedStorageManager.NO_LOCKS);
        boolean bl2 = false;
        $this$FAKE_CONTINUATION_CLASS_DESCRIPTOR_u24lambda_u240.setModality(Modality.ABSTRACT);
        $this$FAKE_CONTINUATION_CLASS_DESCRIPTOR_u24lambda_u240.setVisibility(DescriptorVisibilities.PUBLIC);
        TypeParameterDescriptor typeParameterDescriptor = TypeParameterDescriptorImpl.createWithDefaultBound($this$FAKE_CONTINUATION_CLASS_DESCRIPTOR_u24lambda_u240, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier("T"), 0, LockBasedStorageManager.NO_LOCKS);
        MutableClassDescriptor mutableClassDescriptor2 = $this$FAKE_CONTINUATION_CLASS_DESCRIPTOR_u24lambda_u240;
        boolean bl3 = false;
        mutableClassDescriptor2.setTypeParameterDescriptors(CollectionsKt.listOf(p0));
        $this$FAKE_CONTINUATION_CLASS_DESCRIPTOR_u24lambda_u240.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR = mutableClassDescriptor;
    }
}

