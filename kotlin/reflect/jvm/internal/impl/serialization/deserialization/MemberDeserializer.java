/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$7;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.SuspendFunctionTypeUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nMemberDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/MemberDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1563#2:376\n1634#2,3:377\n1573#2:381\n1604#2,4:382\n1583#2,11:386\n1878#2,2:397\n1880#2:400\n1594#2:401\n1563#2:402\n1634#2,3:403\n1573#2:406\n1604#2,4:407\n1#3:380\n1#3:399\n*S KotlinDebug\n*F\n+ 1 MemberDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/MemberDeserializer\n*L\n29#1:376\n29#1:377,3\n67#1:381\n67#1:382,4\n219#1:386,11\n219#1:397,2\n219#1:400\n219#1:401\n247#1:402\n247#1:403,3\n331#1:406\n331#1:407,4\n219#1:399\n*E\n"})
public final class MemberDeserializer {
    @NotNull
    private final DeserializationContext c;
    @NotNull
    private final AnnotationDeserializer annotationDeserializer;

    public MemberDeserializer(@NotNull DeserializationContext c2) {
        Intrinsics.checkNotNullParameter(c2, "c");
        this.c = c2;
        this.annotationDeserializer = new AnnotationDeserializer(this.c.getComponents().getModuleDescriptor(), this.c.getComponents().getNotFoundClasses());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @NotNull
    public final PropertyDescriptor loadProperty(@NotNull ProtoBuf.Property proto, boolean loadAnnotationsFromMetadata) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        v0 = flags = proto.hasFlags() != false ? proto.getFlags() : this.loadOldFlags(proto.getOldFlags());
        if (loadAnnotationsFromMetadata) {
            v1 = proto.getAnnotationList();
            Intrinsics.checkNotNullExpressionValue(v1, "getAnnotationList(...)");
            var5_4 = v1;
            var21_5 = Annotations.Companion;
            $i$f$map = false;
            var7_8 = $this$map$iv;
            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (T item$iv$iv : $this$mapTo$iv$iv) {
                var12_20 = (ProtoBuf.Annotation)item$iv$iv /* !! */ ;
                var22_28 = destination$iv$iv;
                $i$a$-map-MemberDeserializer$loadProperty$annotationsFromMetadata$1 = false;
                Intrinsics.checkNotNull(it);
                var22_28.add(this.annotationDeserializer.deserializeAnnotation((ProtoBuf.Annotation)it, this.c.getNameResolver()));
            }
            v2 = var21_5.create((List)destination$iv$iv);
        } else {
            v2 = null;
        }
        annotationsFromMetadata = v2;
        v3 = this.c.getContainingDeclaration();
        v4 = annotationsFromMetadata;
        if (v4 == null) {
            v4 = this.getAnnotations(proto, flags, AnnotatedCallableKind.PROPERTY);
        }
        v5 = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags));
        v6 = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(flags));
        v7 = Flags.IS_VAR.get(flags);
        Intrinsics.checkNotNullExpressionValue(v7, "get(...)");
        v8 = v7;
        v9 = NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName());
        v10 = ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(flags));
        v11 = Flags.IS_LATEINIT.get(flags);
        Intrinsics.checkNotNullExpressionValue(v11, "get(...)");
        v12 = v11;
        v13 = Flags.IS_CONST.get(flags);
        Intrinsics.checkNotNullExpressionValue(v13, "get(...)");
        v14 = v13;
        v15 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(v15, "get(...)");
        v16 = v15;
        v17 = Flags.IS_DELEGATED.get(flags);
        Intrinsics.checkNotNullExpressionValue(v17, "get(...)");
        v18 = v17;
        v19 = Flags.IS_EXPECT_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(v19, "get(...)");
        property = new DeserializedPropertyDescriptor(v3, null, v4, v5, v6, v8, v9, v10, v12, v14, v16, v18, v19, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        v20 = property;
        v21 = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(v21, "getTypeParameterList(...)");
        local = DeserializationContext.childContext$default(this.c, v20, v21, null, null, null, null, 60, null);
        v22 = Flags.HAS_GETTER.get(flags);
        Intrinsics.checkNotNullExpressionValue(v22, "get(...)");
        hasGetter = v22;
        receiverAnnotations = hasGetter != false && ProtoTypeTableUtilKt.hasReceiver(proto) != false ? this.getReceiverParameterAnnotations(proto, AnnotatedCallableKind.PROPERTY_GETTER) : Annotations.Companion.getEMPTY();
        v23 = property;
        v24 = local.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()));
        v25 = local.getTypeDeserializer().getOwnTypeParameters();
        v26 = this.getDispatchReceiverParameter();
        v27 = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        if (v27 == null) ** GOTO lbl-1000
        item$iv$iv /* !! */  = v27;
        it = local.getTypeDeserializer();
        $i$a$-map-MemberDeserializer$loadProperty$annotationsFromMetadata$1 /* !! */  = item$iv$iv /* !! */ ;
        var24_30 = v26;
        var23_31 = v25;
        var22_28 = v24;
        var21_5 = v23;
        $i$a$-let-MemberDeserializer$loadProperty$1 = false;
        var25_33 /* !! */  = it.type((ProtoBuf.Type)p0);
        v23 = var21_5;
        v24 = var22_28;
        v25 = var23_31;
        v26 = var24_30;
        v28 = var25_33 /* !! */ ;
        v27 = v28;
        if (v28 != null) {
            it = v27;
            var24_30 = v26;
            var23_31 = v25;
            var22_28 = v24;
            var21_5 = v23;
            $i$a$-let-MemberDeserializer$loadProperty$2 = false;
            var25_33 /* !! */  = DescriptorFactory.createExtensionReceiverParameterForCallable(property, (KotlinType)receiverType, receiverAnnotations);
            v23 = var21_5;
            v24 = var22_28;
            v25 = var23_31;
            v26 = var24_30;
            v29 = var25_33 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            v29 = null;
        }
        $i$f$mapTo = ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.c.getTypeTable());
        var25_33 /* !! */  = v29;
        var24_30 = v26;
        var23_31 = v25;
        var22_28 = v24;
        var21_5 = v23;
        $i$f$mapIndexed = false;
        item$iv$iv /* !! */  = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        for (T item$iv$iv : $this$mapIndexedTo$iv$iv) {
            if ((var17_37 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            var18_41 = (ProtoBuf.Type)item$iv$iv;
            var19_42 = var17_37;
            var26_45 = destination$iv$iv;
            $i$a$-mapIndexed-MemberDeserializer$loadProperty$3 = false;
            var26_45.add(this.toContextReceiver((ProtoBuf.Type)type, local, property, (int)index));
        }
        var26_45 = (List)destination$iv$iv;
        var21_5.setType((KotlinType)var22_28, var23_31, var24_30, (ReceiverParameterDescriptor)var25_33 /* !! */ , (List<ReceiverParameterDescriptor>)var26_45);
        v30 = Flags.HAS_ANNOTATIONS.get(flags);
        Intrinsics.checkNotNullExpressionValue(v30, "get(...)");
        defaultAccessorFlags = Flags.getAccessorFlags(v30, Flags.VISIBILITY.get(flags), Flags.MODALITY.get(flags), false, false, false);
        if (hasGetter) {
            getterFlags = proto.hasGetterFlags() != false ? proto.getGetterFlags() : defaultAccessorFlags;
            v31 = Flags.IS_NOT_DEFAULT.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(v31, "get(...)");
            isNotDefault = v31;
            v32 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(v32, "get(...)");
            isExternal = v32;
            v33 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(v33, "get(...)");
            isInline = v33;
            annotations = this.getAnnotations(proto, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (isNotDefault) {
                v34 = new PropertyGetterDescriptorImpl(property, annotations, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(getterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(getterFlags)), isNotDefault == false, isExternal, isInline, property.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                var17_38 = DescriptorFactory.createDefaultGetter(property, annotations);
                Intrinsics.checkNotNull(var17_38);
                v34 = var17_38;
            }
            getter = v34;
            getter.initialize(property.getReturnType());
            v35 = getter;
        } else {
            v35 = getter = null;
        }
        if (Flags.HAS_SETTER.get(flags).booleanValue()) {
            setterFlags = proto.hasSetterFlags() != false ? proto.getSetterFlags() : defaultAccessorFlags;
            v36 = Flags.IS_NOT_DEFAULT.get(setterFlags);
            Intrinsics.checkNotNullExpressionValue(v36, "get(...)");
            isNotDefault = v36;
            v37 = Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags);
            Intrinsics.checkNotNullExpressionValue(v37, "get(...)");
            isExternal = v37;
            v38 = Flags.IS_INLINE_ACCESSOR.get(setterFlags);
            Intrinsics.checkNotNullExpressionValue(v38, "get(...)");
            isInline = v38;
            annotations = this.getAnnotations(proto, setterFlags, AnnotatedCallableKind.PROPERTY_SETTER);
            if (isNotDefault) {
                setter = new PropertySetterDescriptorImpl(property, annotations, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(setterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(setterFlags)), isNotDefault == false, isExternal, isInline, property.getKind(), null, SourceElement.NO_SOURCE);
                setterLocal = DeserializationContext.childContext$default(local, setter, CollectionsKt.<T>emptyList(), null, null, null, null, 60, null);
                valueParameters = setterLocal.getMemberDeserializer().valueParameters(CollectionsKt.listOf(proto.getSetterValueParameter()), proto, AnnotatedCallableKind.PROPERTY_SETTER);
                setter.initialize(CollectionsKt.single(valueParameters));
                v39 = setter;
            } else {
                var17_40 = DescriptorFactory.createDefaultSetter(property, annotations, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNull(var17_40);
                v39 = var17_40;
            }
        } else {
            v39 = setter = null;
        }
        if (Flags.HAS_CONSTANT.get(flags).booleanValue()) {
            var27_46 = property;
            var28_47 = proto;
            var29_48 = this;
            property.setCompileTimeInitializerFactory(new MemberDeserializer$$Lambda$0(var29_48, var28_47, var27_46));
        }
        v40 = (var13_27 = this.c.getContainingDeclaration()) instanceof ClassDescriptor != false ? (ClassDescriptor)var13_27 : null;
        if ((v40 != null ? v40.getKind() : null) == ClassKind.ANNOTATION_CLASS) {
            var27_46 = property;
            var28_47 = proto;
            var29_48 = this;
            property.setCompileTimeInitializerFactory(new MemberDeserializer$$Lambda$1(var29_48, var28_47, var27_46));
        }
        property.initialize(getter, setter, new FieldDescriptorImpl(this.getPropertyFieldAnnotations(proto, false), property), new FieldDescriptorImpl(this.getPropertyFieldAnnotations(proto, true), property));
        return property;
    }

    public static /* synthetic */ PropertyDescriptor loadProperty$default(MemberDeserializer memberDeserializer, ProtoBuf.Property property, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return memberDeserializer.loadProperty(property, bl2);
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor $this$initializeWithCoroutinesExperimentalityStatus, ReceiverParameterDescriptor extensionReceiverParameter, ReceiverParameterDescriptor dispatchReceiverParameter, List<? extends ReceiverParameterDescriptor> contextReceiverParameters, List<? extends TypeParameterDescriptor> typeParameters, List<? extends ValueParameterDescriptor> unsubstitutedValueParameters, KotlinType unsubstitutedReturnType, Modality modality2, DescriptorVisibility visibility2, Map<? extends CallableDescriptor.UserDataKey<?>, ?> userDataMap) {
        $this$initializeWithCoroutinesExperimentalityStatus.initialize(extensionReceiverParameter, dispatchReceiverParameter, contextReceiverParameters, typeParameters, unsubstitutedValueParameters, unsubstitutedReturnType, modality2, visibility2, userDataMap);
    }

    private final int loadOldFlags(int oldFlags) {
        int lowSixBits = oldFlags & 0x3F;
        int rest = oldFlags >> 8 << 6;
        return lowSixBits + rest;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @NotNull
    public final SimpleFunctionDescriptor loadFunction(@NotNull ProtoBuf.Function proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        flags = proto.hasFlags() != false ? proto.getFlags() : this.loadOldFlags(proto.getOldFlags());
        annotations = this.getAnnotations(proto, flags, AnnotatedCallableKind.FUNCTION);
        receiverAnnotations = ProtoTypeTableUtilKt.hasReceiver(proto) != false ? this.getReceiverParameterAnnotations(proto, AnnotatedCallableKind.FUNCTION) : Annotations.Companion.getEMPTY();
        versionRequirementTable = Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) != false ? VersionRequirementTable.Companion.getEMPTY() : this.c.getVersionRequirementTable();
        function = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, annotations, NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(flags)), proto, this.c.getNameResolver(), this.c.getTypeTable(), versionRequirementTable, this.c.getContainerSource(), null, 1024, null);
        v0 = function;
        v1 = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(v1, "getTypeParameterList(...)");
        local = DeserializationContext.childContext$default(this.c, v0, v1, null, null, null, null, 60, null);
        v2 = this;
        v3 = function;
        v4 = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        if (v4 == null) ** GOTO lbl-1000
        var10_8 = v4;
        var11_9 = local.getTypeDeserializer();
        var12_10 = var10_8;
        var28_13 = v3;
        var27_14 = v2;
        $i$a$-let-MemberDeserializer$loadFunction$1 = false;
        var29_17 /* !! */  = var11_9.type((ProtoBuf.Type)p0);
        v2 = var27_14;
        v3 = var28_13;
        v5 = var29_17 /* !! */ ;
        v4 = v5;
        if (v5 != null) {
            var11_9 = v4;
            var28_13 = v3;
            var27_14 = v2;
            $i$a$-let-MemberDeserializer$loadFunction$2 = false;
            var29_17 /* !! */  = DescriptorFactory.createExtensionReceiverParameterForCallable(function, (KotlinType)receiverType, receiverAnnotations);
            v2 = var27_14;
            v3 = var28_13;
            v6 = var29_17 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            v6 = null;
        }
        var8_18 = ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.c.getTypeTable());
        var30_19 = this.getDispatchReceiverParameter();
        var29_17 /* !! */  = v6;
        var28_13 = v3;
        var27_14 = v2;
        $i$f$mapIndexedNotNull = false;
        var10_8 = $this$mapIndexedNotNull$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$mapIndexedNotNullTo = false;
        $this$forEachIndexed$iv$iv$iv = $this$mapIndexedNotNullTo$iv$iv;
        $i$f$forEachIndexed = false;
        index$iv$iv$iv = 0;
        for (T item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
            if ((var18_25 = index$iv$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            var19_26 = item$iv$iv$iv;
            index$iv$iv = var18_25;
            $i$a$-forEachIndexed-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$iv$iv = false;
            var22_29 = (ProtoBuf.Type)element$iv$iv;
            index = index$iv$iv;
            $i$a$-mapIndexedNotNull-MemberDeserializer$loadFunction$3 = false;
            if (this.toContextReceiver((ProtoBuf.Type)type, local, function, index) == null) continue;
            $i$a$-let-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$1$iv$iv = false;
            destination$iv$iv.add(it$iv$iv);
        }
        var31_34 = (List)destination$iv$iv;
        v7 = local.getTypeDeserializer().getOwnTypeParameters();
        v8 = local.getMemberDeserializer();
        v9 = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(v9, "getValueParameterList(...)");
        var27_14.initializeWithCoroutinesExperimentalityStatus(var28_13, (ReceiverParameterDescriptor)var29_17 /* !! */ , var30_19, var31_34, v7, v8.valueParameters(v9, proto, AnnotatedCallableKind.FUNCTION), local.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable())), ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(flags)), MapsKt.<K, V>emptyMap());
        v10 = Flags.IS_OPERATOR.get(flags);
        Intrinsics.checkNotNullExpressionValue(v10, "get(...)");
        function.setOperator(v10);
        v11 = Flags.IS_INFIX.get(flags);
        Intrinsics.checkNotNullExpressionValue(v11, "get(...)");
        function.setInfix(v11);
        v12 = Flags.IS_EXTERNAL_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(v12, "get(...)");
        function.setExternal(v12);
        v13 = Flags.IS_INLINE.get(flags);
        Intrinsics.checkNotNullExpressionValue(v13, "get(...)");
        function.setInline(v13);
        v14 = Flags.IS_TAILREC.get(flags);
        Intrinsics.checkNotNullExpressionValue(v14, "get(...)");
        function.setTailrec(v14);
        v15 = Flags.IS_SUSPEND.get(flags);
        Intrinsics.checkNotNullExpressionValue(v15, "get(...)");
        function.setSuspend(v15);
        v16 = Flags.IS_EXPECT_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(v16, "get(...)");
        function.setExpect(v16);
        function.setHasStableParameterNames(Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(flags) == false);
        mapValueForContract = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(proto, function, this.c.getTypeTable(), local.getTypeDeserializer());
        if (mapValueForContract != null) {
            function.putInUserDataMap(mapValueForContract.getFirst(), mapValueForContract.getSecond());
        }
        return function;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final TypeAliasDescriptor loadTypeAlias(@NotNull ProtoBuf.TypeAlias proto) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(proto, "proto");
        List<ProtoBuf.Annotation> list = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list, "getAnnotationList(...)");
        Iterable iterable = list;
        Annotations.Companion companion = Annotations.Companion;
        boolean $i$f$map = false;
        void var5_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(this.annotationDeserializer.deserializeAnnotation((ProtoBuf.Annotation)it, this.c.getNameResolver()));
        }
        Annotations annotations = companion.create((List)destination$iv$iv);
        DescriptorVisibility visibility2 = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags()));
        DeserializedTypeAliasDescriptor typeAlias = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), annotations, NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), visibility2, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeclarationDescriptor declarationDescriptor = typeAlias;
        List<ProtoBuf.TypeParameter> list2 = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list2, "getTypeParameterList(...)");
        DeserializationContext local = DeserializationContext.childContext$default(this.c, declarationDescriptor, list2, null, null, null, null, 60, null);
        typeAlias.initialize(local.getTypeDeserializer().getOwnTypeParameters(), local.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(proto, this.c.getTypeTable()), false), local.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(proto, this.c.getTypeTable()), false));
        return typeAlias;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor)declarationDescriptor : null;
        return classDescriptor != null ? classDescriptor.getThisAsReceiverParameter() : null;
    }

    @NotNull
    public final ClassConstructorDescriptor loadConstructor(@NotNull ProtoBuf.Constructor proto, boolean isPrimary) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
        DeserializedClassConstructorDescriptor descriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, null, this.getAnnotations(proto, proto.getFlags(), AnnotatedCallableKind.FUNCTION), isPrimary, CallableMemberDescriptor.Kind.DECLARATION, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, 1024, null);
        DeserializationContext local = DeserializationContext.childContext$default(this.c, descriptor2, CollectionsKt.emptyList(), null, null, null, null, 60, null);
        MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> list = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameterList(...)");
        descriptor2.initialize(memberDeserializer.valueParameters(list, proto, AnnotatedCallableKind.FUNCTION), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())));
        descriptor2.setReturnType(classDescriptor.getDefaultType());
        descriptor2.setExpect(classDescriptor.isExpect());
        descriptor2.setHasStableParameterNames(Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(proto.getFlags()) == false);
        return descriptor2;
    }

    private final Annotations getAnnotations(MessageLite proto, int flags, AnnotatedCallableKind kind2) {
        if (!Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        AnnotatedCallableKind annotatedCallableKind = kind2;
        MessageLite messageLite = proto;
        MemberDeserializer memberDeserializer = this;
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$$Lambda$2(memberDeserializer, messageLite, annotatedCallableKind));
    }

    private final Annotations getPropertyFieldAnnotations(ProtoBuf.Property proto, boolean isDelegate) {
        if (!Flags.HAS_ANNOTATIONS.get(proto.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        ProtoBuf.Property property = proto;
        boolean bl2 = isDelegate;
        MemberDeserializer memberDeserializer = this;
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$$Lambda$3(memberDeserializer, bl2, property));
    }

    private final Annotations getReceiverParameterAnnotations(MessageLite proto, AnnotatedCallableKind kind2) {
        AnnotatedCallableKind annotatedCallableKind = kind2;
        MessageLite messageLite = proto;
        MemberDeserializer memberDeserializer = this;
        return new DeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$$Lambda$4(memberDeserializer, messageLite, annotatedCallableKind));
    }

    /*
     * WARNING - void declaration
     */
    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> valueParameters, MessageLite callable, AnnotatedCallableKind kind2) {
        void $this$mapIndexedTo$iv$iv;
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor)declarationDescriptor;
        DeclarationDescriptor declarationDescriptor2 = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor2, "getContainingDeclaration(...)");
        ProtoContainer containerOfCallable = this.asProtoContainer(declarationDescriptor2);
        Iterable $this$mapIndexed$iv = valueParameters;
        boolean $i$f$mapIndexed = false;
        Iterable iterable = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            SourceElement sourceElement;
            KotlinType kotlinType;
            Annotations annotations;
            void i2;
            void proto;
            int flags;
            int n2;
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter)item$iv$iv;
            int n3 = n2;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            int n4 = flags = proto.hasFlags() ? proto.getFlags() : 0;
            if (containerOfCallable != null && Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
                void var44_44 = proto;
                void var45_45 = i2;
                AnnotatedCallableKind annotatedCallableKind = kind2;
                MessageLite messageLite = callable;
                ProtoContainer protoContainer = containerOfCallable;
                MemberDeserializer memberDeserializer = this;
                annotations = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$$Lambda$5(memberDeserializer, protoContainer, messageLite, annotatedCallableKind, (int)var45_45, (ProtoBuf.ValueParameter)var44_44));
            } else {
                annotations = Annotations.Companion.getEMPTY();
            }
            Annotations annotations2 = annotations;
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            ValueParameterDescriptor valueParameterDescriptor = null;
            void v6 = i2;
            Annotations annotations3 = annotations2;
            Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName());
            KotlinType kotlinType2 = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter)proto, this.c.getTypeTable()));
            Boolean bl3 = Flags.DECLARES_DEFAULT_VALUE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bl3, "get(...)");
            boolean bl4 = bl3;
            Boolean bl5 = Flags.IS_CROSSINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bl5, "get(...)");
            boolean bl6 = bl5;
            Boolean bl7 = Flags.IS_NOINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bl7, "get(...)");
            boolean bl8 = bl7;
            if (ProtoTypeTableUtilKt.varargElementType((ProtoBuf.ValueParameter)proto, this.c.getTypeTable()) != null) {
                void it;
                boolean bl9 = bl8;
                boolean bl10 = bl6;
                boolean bl11 = bl4;
                KotlinType kotlinType3 = kotlinType2;
                Name name2 = name;
                Annotations annotations4 = annotations3;
                void var27_27 = v6;
                ValueParameterDescriptor valueParameterDescriptor2 = valueParameterDescriptor;
                CallableDescriptor callableDescriptor3 = callableDescriptor2;
                boolean bl12 = false;
                KotlinType kotlinType4 = this.c.getTypeDeserializer().type((ProtoBuf.Type)it);
                callableDescriptor2 = callableDescriptor3;
                valueParameterDescriptor = valueParameterDescriptor2;
                v6 = var27_27;
                annotations3 = annotations4;
                name = name2;
                kotlinType2 = kotlinType3;
                bl4 = bl11;
                bl6 = bl10;
                bl8 = bl9;
                kotlinType = kotlinType4;
            } else {
                kotlinType = null;
            }
            Intrinsics.checkNotNullExpressionValue(SourceElement.NO_SOURCE, "NO_SOURCE");
            KotlinType kotlinType5 = kotlinType;
            boolean bl13 = bl8;
            boolean bl14 = bl6;
            boolean bl15 = bl4;
            KotlinType kotlinType6 = kotlinType2;
            Name name3 = name;
            Annotations annotations5 = annotations3;
            void var41_41 = v6;
            ValueParameterDescriptor valueParameterDescriptor3 = valueParameterDescriptor;
            CallableDescriptor callableDescriptor4 = callableDescriptor2;
            collection.add(new ValueParameterDescriptorImpl(callableDescriptor4, valueParameterDescriptor3, (int)var41_41, annotations5, name3, kotlinType6, bl15, bl14, bl13, kotlinType5, sourceElement));
        }
        return CollectionsKt.toList((List)destination$iv$iv);
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor $this$asProtoContainer) {
        DeclarationDescriptor declarationDescriptor = $this$asProtoContainer;
        return declarationDescriptor instanceof PackageFragmentDescriptor ? (ProtoContainer)new ProtoContainer.Package(((PackageFragmentDescriptor)$this$asProtoContainer).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource()) : (declarationDescriptor instanceof DeserializedClassDescriptor ? (ProtoContainer)((DeserializedClassDescriptor)$this$asProtoContainer).getThisAsProtoContainer$deserialization() : null);
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf.Type $this$toContextReceiver, DeserializationContext deserializationContext, CallableDescriptor callableDescriptor, int index) {
        KotlinType contextReceiverType = deserializationContext.getTypeDeserializer().type($this$toContextReceiver);
        return DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, contextReceiverType, null, Annotations.Companion.getEMPTY(), index);
    }

    private static final ConstantValue loadProperty$lambda$4$lambda$3(MemberDeserializer this$0, ProtoBuf.Property $proto, DeserializedPropertyDescriptor $property) {
        ProtoContainer protoContainer = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        Intrinsics.checkNotNull(protoContainer);
        ProtoContainer container = protoContainer;
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = this$0.c.getComponents().getAnnotationAndConstantLoader();
        KotlinType kotlinType = $property.getReturnType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getReturnType(...)");
        return annotationAndConstantLoader.loadPropertyConstant(container, $proto, kotlinType);
    }

    private static final NullableLazyValue loadProperty$lambda$4(MemberDeserializer this$0, ProtoBuf.Property $proto, DeserializedPropertyDescriptor $property) {
        DeserializedPropertyDescriptor deserializedPropertyDescriptor = $property;
        ProtoBuf.Property property = $proto;
        MemberDeserializer memberDeserializer = this$0;
        return this$0.c.getStorageManager().createNullableLazyValue(new MemberDeserializer$$Lambda$6(memberDeserializer, property, deserializedPropertyDescriptor));
    }

    private static final ConstantValue loadProperty$lambda$6$lambda$5(MemberDeserializer this$0, ProtoBuf.Property $proto, DeserializedPropertyDescriptor $property) {
        ProtoContainer protoContainer = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        Intrinsics.checkNotNull(protoContainer);
        ProtoContainer container = protoContainer;
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = this$0.c.getComponents().getAnnotationAndConstantLoader();
        KotlinType kotlinType = $property.getReturnType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getReturnType(...)");
        return annotationAndConstantLoader.loadAnnotationDefaultValue(container, $proto, kotlinType);
    }

    private static final NullableLazyValue loadProperty$lambda$6(MemberDeserializer this$0, ProtoBuf.Property $proto, DeserializedPropertyDescriptor $property) {
        DeserializedPropertyDescriptor deserializedPropertyDescriptor = $property;
        ProtoBuf.Property property = $proto;
        MemberDeserializer memberDeserializer = this$0;
        return this$0.c.getStorageManager().createNullableLazyValue(new MemberDeserializer$$Lambda$7(memberDeserializer, property, deserializedPropertyDescriptor));
    }

    private static final List getAnnotations$lambda$12(MemberDeserializer this$0, MessageLite $proto, AnnotatedCallableKind $kind) {
        List list;
        List list2;
        ProtoContainer protoContainer = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        if (protoContainer != null) {
            ProtoContainer it = protoContainer;
            boolean bl2 = false;
            list2 = CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(it, $proto, $kind));
        } else {
            list2 = list = null;
        }
        if (list2 == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    private static final List getPropertyFieldAnnotations$lambda$14(MemberDeserializer this$0, boolean $isDelegate, ProtoBuf.Property $proto) {
        List list;
        List list2;
        ProtoContainer protoContainer = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        if (protoContainer != null) {
            ProtoContainer it = protoContainer;
            boolean bl2 = false;
            list2 = $isDelegate ? CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(it, $proto)) : CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(it, $proto));
        } else {
            list2 = list = null;
        }
        if (list2 == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    private static final List getReceiverParameterAnnotations$lambda$16(MemberDeserializer this$0, MessageLite $proto, AnnotatedCallableKind $kind) {
        List list;
        List<Object> list2;
        ProtoContainer protoContainer = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        if (protoContainer != null) {
            ProtoContainer it = protoContainer;
            boolean bl2 = false;
            list2 = this$0.c.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(it, $proto, $kind);
        } else {
            list2 = list = null;
        }
        if (list2 == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    private static final List valueParameters$lambda$19$lambda$17(MemberDeserializer this$0, ProtoContainer $containerOfCallable, MessageLite $callable, AnnotatedCallableKind $kind, int $i, ProtoBuf.ValueParameter $proto) {
        return CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations($containerOfCallable, $callable, $kind, $i, $proto));
    }

    static /* synthetic */ NullableLazyValue accessor$MemberDeserializer$lambda0(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return MemberDeserializer.loadProperty$lambda$4(memberDeserializer, property, deserializedPropertyDescriptor);
    }

    static /* synthetic */ NullableLazyValue accessor$MemberDeserializer$lambda1(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return MemberDeserializer.loadProperty$lambda$6(memberDeserializer, property, deserializedPropertyDescriptor);
    }

    static /* synthetic */ List accessor$MemberDeserializer$lambda2(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        return MemberDeserializer.getAnnotations$lambda$12(memberDeserializer, messageLite, annotatedCallableKind);
    }

    static /* synthetic */ List accessor$MemberDeserializer$lambda3(MemberDeserializer memberDeserializer, boolean bl2, ProtoBuf.Property property) {
        return MemberDeserializer.getPropertyFieldAnnotations$lambda$14(memberDeserializer, bl2, property);
    }

    static /* synthetic */ List accessor$MemberDeserializer$lambda4(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        return MemberDeserializer.getReceiverParameterAnnotations$lambda$16(memberDeserializer, messageLite, annotatedCallableKind);
    }

    static /* synthetic */ List accessor$MemberDeserializer$lambda5(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int n2, ProtoBuf.ValueParameter valueParameter) {
        return MemberDeserializer.valueParameters$lambda$19$lambda$17(memberDeserializer, protoContainer, messageLite, annotatedCallableKind, n2, valueParameter);
    }

    static /* synthetic */ ConstantValue accessor$MemberDeserializer$lambda6(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return MemberDeserializer.loadProperty$lambda$4$lambda$3(memberDeserializer, property, deserializedPropertyDescriptor);
    }

    static /* synthetic */ ConstantValue accessor$MemberDeserializer$lambda7(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return MemberDeserializer.loadProperty$lambda$6$lambda$5(memberDeserializer, property, deserializedPropertyDescriptor);
    }
}

