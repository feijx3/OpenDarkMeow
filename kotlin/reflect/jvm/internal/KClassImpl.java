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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KClassImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$0;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$1;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$10;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$11;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$12;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$13;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$14;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$15;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$16;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$17;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$18;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$19;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$2;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$20;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$3;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$4;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$5;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$6;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$7;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$8;
import kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$9;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.MetadataUtilKt;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 n*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0002mnB\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020*2\u0006\u00103\u001a\u000204H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060*2\u0006\u00103\u001a\u000204H\u0016J\u0012\u00107\u001a\u0004\u0018\u0001022\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010e\u001a\u00020I2\b\u0010f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010g\u001a\u000209H\u0016J\b\u0010h\u001a\u00020;H\u0016J\u0018\u0010i\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010j\u001a\u00020kH\u0002J\u0018\u0010l\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010j\u001a\u00020kH\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\u000fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010&R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010-R\u0016\u0010:\u001a\u0004\u0018\u00010;8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u0004\u0018\u00010;8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010=R \u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000A0*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010-R\u001e\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010-R\u0016\u0010E\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010\u001eR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010\u001eR\"\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010\u001eR\u0016\u0010S\u001a\u0004\u0018\u00010T8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020X8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010\\R\u0014\u0010^\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010\\R\u0014\u0010_\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b_\u0010\\R\u0014\u0010`\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010\\R\u0014\u0010a\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\ba\u0010\\R\u0014\u0010b\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010\\R\u0014\u0010c\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bc\u0010\\R\u0014\u0010d\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010\\\u00a8\u0006o"}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "data", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "getData", "()Lkotlin/Lazy;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "kmClass", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "getKmClass", "()Lkotlin/metadata/KmClass;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "staticScope", "getStaticScope$kotlin_reflection", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "sealedSubclasses", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "modality", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "isFinal", "()Z", "isOpen", "isAbstract", "isSealed", "isData", "isInner", "isCompanion", "isFun", "isValue", "equals", "other", "hashCode", "toString", "createSyntheticClassOrFail", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "createSyntheticClass", "Data", "Companion", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKClassImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n1634#2,3:415\n*S KotlinDebug\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl\n*L\n409#1:415,3\n*E\n"})
public final class KClassImpl<T>
extends KDeclarationContainerImpl
implements KClass<T>,
KClassifierImpl,
KTypeParameterOwnerImpl {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Class<T> jClass;
    @NotNull
    private final Lazy<Data> data;
    @NotNull
    private static final Set<String> SPECIAL_JVM_ANNOTATION_NAMES;

    public KClassImpl(@NotNull Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        KClassImpl kClassImpl = this;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KClassImpl$$Lambda$0(kClassImpl));
    }

    @NotNull
    public Class<T> getJClass() {
        return this.jClass;
    }

    @NotNull
    public final Lazy<Data> getData() {
        return this.data;
    }

    @Override
    @NotNull
    public ClassDescriptor getDescriptor() {
        return this.data.getValue().getDescriptor();
    }

    private final KmClass getKmClass() {
        return this.data.getValue().getKmClass();
    }

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.data.getValue().getAnnotations();
    }

    private final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(this.getJClass());
    }

    @NotNull
    public final MemberScope getMemberScope$kotlin_reflection() {
        return this.getDescriptor().getDefaultType().getMemberScope();
    }

    @NotNull
    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope memberScope = this.getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(memberScope, "getStaticScope(...)");
        return memberScope;
    }

    @Override
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.data.getValue().getAllMembers();
    }

    @Override
    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor2 = this.getDescriptor();
        if (descriptor2.getKind() == ClassKind.INTERFACE || descriptor2.getKind() == ClassKind.OBJECT) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        Collection<ConstructorDescriptor> collection = descriptor2.getConstructors();
        Intrinsics.checkNotNullExpressionValue(collection, "getConstructors(...)");
        return collection;
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.collections.CollectionsKt.plus(this.getMemberScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION), (Iterable)this.getStaticScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override
    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.collections.CollectionsKt.plus(this.getMemberScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION), (Iterable)this.getStaticScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override
    @Nullable
    public PropertyDescriptor getLocalProperty(int index) {
        PropertyDescriptor propertyDescriptor;
        ClassDescriptor classDescriptor;
        if (Intrinsics.areEqual(this.getJClass().getSimpleName(), "DefaultImpls")) {
            Class<?> clazz = this.getJClass().getDeclaringClass();
            if (clazz != null) {
                Class<?> interfaceClass = clazz;
                boolean bl2 = false;
                if (interfaceClass.isInterface()) {
                    KClass<?> kClass = JvmClassMappingKt.getKotlinClass(interfaceClass);
                    Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    return ((KClassImpl)kClass).getLocalProperty(index);
                }
            }
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (classDescriptor = this.getDescriptor()) instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor)classDescriptor : null;
        if (deserializedClassDescriptor != null) {
            DeserializedClassDescriptor descriptor2 = deserializedClassDescriptor;
            boolean bl3 = false;
            GeneratedMessageLite.ExtendableMessage extendableMessage = descriptor2.getClassProto();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.classLocalVariable;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "classLocalVariable");
            ProtoBuf.Property property = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension, index);
            if (property != null) {
                ProtoBuf.Property proto = property;
                boolean bl4 = false;
                propertyDescriptor = (PropertyDescriptor)UtilKt.deserializeToDescriptor(this.getJClass(), (MessageLite)proto, descriptor2.getC().getNameResolver(), descriptor2.getC().getTypeTable(), descriptor2.getMetadataVersion(), KClassImpl$$Lambda$1.INSTANCE);
            } else {
                propertyDescriptor = null;
            }
        } else {
            propertyDescriptor = null;
        }
        return propertyDescriptor;
    }

    @Override
    @Nullable
    public String getSimpleName() {
        return this.data.getValue().getSimpleName();
    }

    @Override
    @Nullable
    public String getQualifiedName() {
        return this.data.getValue().getQualifiedName();
    }

    @Override
    @NotNull
    public Collection<KFunction<T>> getConstructors() {
        return this.data.getValue().getConstructors();
    }

    @Override
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        return this.data.getValue().getNestedClasses();
    }

    @Override
    @Nullable
    public T getObjectInstance() {
        return this.data.getValue().getObjectInstance();
    }

    @Override
    public boolean isInstance(@Nullable Object value) {
        Integer n2 = ReflectClassUtilKt.getFunctionClassArity(this.getJClass());
        if (n2 != null) {
            int arity = ((Number)n2).intValue();
            boolean bl2 = false;
            return TypeIntrinsics.isFunctionOfArity(value, arity);
        }
        Class<?> clazz = ReflectClassUtilKt.getWrapperByPrimitive(this.getJClass());
        if (clazz == null) {
            clazz = this.getJClass();
        }
        return clazz.isInstance(value);
    }

    @Override
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        return this.data.getValue().getTypeParameters();
    }

    @Override
    @NotNull
    public List<KType> getSupertypes() {
        return this.data.getValue().getSupertypes();
    }

    @Override
    @NotNull
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.data.getValue().getSealedSubclasses();
    }

    @Override
    @Nullable
    public KVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
        return UtilKt.toKVisibility(descriptorVisibility);
    }

    private final kotlin.reflect.jvm.internal.impl.km.Modality getModality() {
        Object object = this.getKmClass();
        if (object == null || (object = Attributes.getModality(object)) == null) {
            object = this.getJClass().isAnnotation() || this.getJClass().isEnum() ? kotlin.reflect.jvm.internal.impl.km.Modality.FINAL : (Intrinsics.areEqual(Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.getJClass()), true) ? kotlin.reflect.jvm.internal.impl.km.Modality.SEALED : (Modifier.isAbstract(this.getJClass().getModifiers()) ? kotlin.reflect.jvm.internal.impl.km.Modality.ABSTRACT : (!Modifier.isFinal(this.getJClass().getModifiers()) ? kotlin.reflect.jvm.internal.impl.km.Modality.OPEN : kotlin.reflect.jvm.internal.impl.km.Modality.FINAL)));
        }
        return object;
    }

    @Override
    public boolean isFinal() {
        return this.getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.FINAL;
    }

    @Override
    public boolean isOpen() {
        return this.getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.OPEN;
    }

    @Override
    public boolean isAbstract() {
        return this.getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.ABSTRACT;
    }

    @Override
    public boolean isSealed() {
        return this.getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.SEALED;
    }

    @Override
    public boolean isData() {
        KmClass kmClass = this.getKmClass();
        return kmClass != null ? Attributes.isData(kmClass) : false;
    }

    @Override
    public boolean isInner() {
        KmClass kmClass = this.getKmClass();
        return kmClass == null ? this.getJClass().getDeclaringClass() != null && !Modifier.isStatic(this.getJClass().getModifiers()) : Attributes.isInner(kmClass);
    }

    @Override
    public boolean isCompanion() {
        KmClass kmClass = this.getKmClass();
        return (kmClass != null ? Attributes.getKind(kmClass) : null) == kotlin.reflect.jvm.internal.impl.km.ClassKind.COMPANION_OBJECT;
    }

    @Override
    public boolean isFun() {
        KmClass kmClass = this.getKmClass();
        return kmClass != null ? Attributes.isFunInterface(kmClass) : false;
    }

    @Override
    public boolean isValue() {
        KmClass kmClass = this.getKmClass();
        return kmClass != null ? Attributes.isValue(kmClass) : false;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return other instanceof KClassImpl && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass)other));
    }

    @Override
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public String toString() {
        void classId;
        ClassId classId2 = this.getClassId();
        StringBuilder stringBuilder = new StringBuilder().append("class ");
        boolean bl2 = false;
        FqName packageFqName = classId.getPackageFqName();
        String packagePrefix = packageFqName.isRoot() ? "" : packageFqName.asString() + '.';
        String classSuffix = StringsKt.replace$default(classId.getRelativeClassName().asString(), '.', '$', false, 4, null);
        return stringBuilder.append(packagePrefix + classSuffix).toString();
    }

    private final ClassDescriptor createSyntheticClassOrFail(ClassId classId, RuntimeModuleData moduleData) {
        KotlinClassHeader.Kind kind2;
        if (this.getJClass().isSynthetic()) {
            return this.createSyntheticClass(classId, moduleData);
        }
        Object object = ReflectKotlinClass.Factory.create(this.getJClass());
        KotlinClassHeader.Kind kind3 = kind2 = object != null && (object = ((ReflectKotlinClass)object).getClassHeader()) != null ? ((KotlinClassHeader)object).getKind() : null;
        switch (kind3 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind3.ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return this.createSyntheticClass(classId, moduleData);
            }
            case 5: {
                throw new KotlinReflectionInternalError("Unknown class: " + this.getJClass() + " (kind = " + (Object)((Object)kind2) + ')');
            }
            case -1: 
            case 6: {
                throw new KotlinReflectionInternalError("Unresolved class: " + this.getJClass() + " (kind = " + (Object)((Object)kind2) + ')');
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ClassDescriptor createSyntheticClass(ClassId classId, RuntimeModuleData moduleData) {
        ClassDescriptorImpl classDescriptorImpl;
        ClassDescriptorImpl descriptor2 = classDescriptorImpl = new ClassDescriptorImpl(new EmptyPackageFragmentDescriptor(moduleData.getModule(), classId.getPackageFqName()), classId.getShortClassName(), Modality.FINAL, ClassKind.CLASS, (Collection<KotlinType>)kotlin.collections.CollectionsKt.listOf(moduleData.getModule().getBuiltIns().getAny().getDefaultType()), SourceElement.NO_SOURCE, false, moduleData.getDeserialization().getStorageManager());
        boolean bl2 = false;
        StorageManager storageManager = moduleData.getDeserialization().getStorageManager();
        descriptor2.initialize(new GivenFunctionsMemberScope(descriptor2, storageManager){

            protected List<FunctionDescriptor> computeDeclaredFunctions() {
                return kotlin.collections.CollectionsKt.emptyList();
            }
        }, SetsKt.<ClassConstructorDescriptor>emptySet(), null);
        return classDescriptorImpl;
    }

    private static final Data data$lambda$0(KClassImpl this$0) {
        return this$0.new Data();
    }

    private static final PropertyDescriptor getLocalProperty$lambda$4$lambda$3$lambda$2(MemberDeserializer $this$deserializeToDescriptor, ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter($this$deserializeToDescriptor, "$this$deserializeToDescriptor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        return $this$deserializeToDescriptor.loadProperty(proto, true);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var1_1;
        void $this$mapTo$iv;
        Companion = new Companion(null);
        Iterable iterable = SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS();
        Collection destination$iv = new HashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            ClassId classId = (ClassId)item$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            collection.add(it.asSingleFqName().toString());
        }
        SPECIAL_JVM_ANNOTATION_NAMES = (Set)var1_1;
    }

    static /* synthetic */ Data accessor$KClassImpl$lambda0(KClassImpl kClassImpl) {
        return KClassImpl.data$lambda$0(kClassImpl);
    }

    static /* synthetic */ PropertyDescriptor accessor$KClassImpl$lambda1(MemberDeserializer memberDeserializer, ProtoBuf.Property property) {
        return KClassImpl.getLocalProperty$lambda$4$lambda$3$lambda$2(memberDeserializer, property);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl$Companion;", "", "<init>", "()V", "SPECIAL_JVM_ANNOTATION_NAMES", "", "", "kotlin-reflection"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u001f\u001a\u00020\u00182\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR-\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0#8FX\u0086\u0084\u0002\u00a2\u0006\u0012\n\u0004\b)\u0010\u0010\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(R%\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b,\u0010(R#\u0010.\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002\u00a2\u0006\u0012\n\u0004\b2\u0010\n\u0012\u0004\b/\u0010&\u001a\u0004\b0\u00101R!\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b5\u0010\u0015R!\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b9\u0010\u0015R)\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000+0\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b<\u0010\u0015R%\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\b@\u0010(R%\u0010B\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010\u0010\u001a\u0004\bC\u0010(R%\u0010E\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bF\u0010(R%\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bI\u0010(R%\u0010K\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bL\u0010(R%\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010\u0010\u001a\u0004\bO\u0010(R%\u0010Q\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010\u0010\u001a\u0004\bR\u0010(R%\u0010T\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010\u0010\u001a\u0004\bU\u0010(\u00a8\u0006W"}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "kmClass", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "getKmClass", "()Lkotlin/metadata/KmClass;", "kmClass$delegate", "Lkotlin/Lazy;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "simpleName$delegate", "qualifiedName", "getQualifiedName", "qualifiedName$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "()Ljava/util/Collection;", "constructors$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "declaredNonStaticMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "allMembers", "getAllMembers", "allMembers$delegate", "kotlin-reflection"})
    @SourceDebugExtension(value={"SMAP\nKClassImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl$Data\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n4154#2:415\n4254#2,2:416\n11546#2,9:435\n13472#2:444\n13473#2:446\n11555#2:447\n11228#2:471\n11563#2,3:472\n1563#3:418\n1634#3,3:419\n1617#3,9:422\n1869#3:431\n1870#3:433\n1626#3:434\n1563#3:448\n1634#3,3:449\n1634#3,3:452\n1740#3,3:455\n1617#3,9:458\n1869#3:467\n1870#3:469\n1626#3:470\n1#4:432\n1#4:445\n1#4:468\n*S KotlinDebug\n*F\n+ 1 KClassImpl.kt\nkotlin/reflect/jvm/internal/KClassImpl$Data\n*L\n85#1:415\n85#1:416,2\n136#1:435,9\n136#1:444\n136#1:446\n136#1:447\n198#1:471\n198#1:472,3\n121#1:418\n121#1:419,3\n132#1:422,9\n132#1:431\n132#1:433\n132#1:434\n159#1:448\n159#1:449,3\n165#1:452,3\n182#1:455,3\n196#1:458,9\n196#1:467\n196#1:469\n196#1:470\n132#1:432\n136#1:445\n196#1:468\n*E\n"})
    public final class Data
    extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final Lazy kmClass$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal annotations$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal simpleName$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal qualifiedName$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal constructors$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal nestedClasses$delegate;
        @NotNull
        private final Lazy objectInstance$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal typeParameters$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal supertypes$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal sealedSubclasses$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal allStaticMembers$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal declaredMembers$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal allMembers$delegate;

        public Data() {
            super(KClassImpl.this);
            Object object = this;
            this.kmClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KClassImpl$Data$$Lambda$0((Data)object));
            object = KClassImpl.this;
            this.descriptor$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$1((KClassImpl)object));
            object = KClassImpl.this;
            this.annotations$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$2((KClassImpl)object));
            object = this;
            KClassImpl kClassImpl = KClassImpl.this;
            this.simpleName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$3(kClassImpl, (Data)object));
            object = KClassImpl.this;
            this.qualifiedName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$4((KClassImpl)object));
            object = KClassImpl.this;
            this.constructors$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$5((KClassImpl)object));
            object = KClassImpl.this;
            kClassImpl = this;
            this.nestedClasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$6((Data)((Object)kClassImpl), (KClassImpl)object));
            object = KClassImpl.this;
            kClassImpl = this;
            this.objectInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KClassImpl$Data$$Lambda$7((Data)((Object)kClassImpl), (KClassImpl)object));
            object = KClassImpl.this;
            kClassImpl = this;
            this.typeParameters$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$8((Data)((Object)kClassImpl), (KClassImpl)object));
            object = KClassImpl.this;
            kClassImpl = this;
            this.supertypes$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$9((Data)((Object)kClassImpl), (KClassImpl)object));
            object = this;
            kClassImpl = KClassImpl.this;
            this.sealedSubclasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$10(kClassImpl, (Data)object));
            object = KClassImpl.this;
            this.declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$11((KClassImpl)object));
            object = KClassImpl.this;
            this.declaredStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$12((KClassImpl)object));
            object = KClassImpl.this;
            this.inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$13((KClassImpl)object));
            object = KClassImpl.this;
            this.inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$14((KClassImpl)object));
            object = this;
            this.allNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$15((Data)object));
            object = this;
            this.allStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$16((Data)object));
            object = this;
            this.declaredMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$17((Data)object));
            object = this;
            this.allMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$18((Data)object));
        }

        @Nullable
        public final KmClass getKmClass() {
            Lazy lazy = this.kmClass$delegate;
            return (KmClass)lazy.getValue();
        }

        @NotNull
        public final ClassDescriptor getDescriptor() {
            Object t2 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (ClassDescriptor)t2;
        }

        @NotNull
        public final List<Annotation> getAnnotations() {
            Object t2 = this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (List)t2;
        }

        @Nullable
        public final String getSimpleName() {
            return (String)this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        @Nullable
        public final String getQualifiedName() {
            return (String)this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        private final String calculateLocalClassName(Class<?> jClass) {
            String name = jClass.getSimpleName();
            Method method = jClass.getEnclosingMethod();
            if (method != null) {
                Method method2 = method;
                boolean bl2 = false;
                Intrinsics.checkNotNull(name);
                return StringsKt.substringAfter$default(name, method2.getName() + '$', null, 2, null);
            }
            Constructor<?> constructor = jClass.getEnclosingConstructor();
            if (constructor != null) {
                Constructor<?> constructor2 = constructor;
                boolean bl3 = false;
                Intrinsics.checkNotNull(name);
                return StringsKt.substringAfter$default(name, constructor2.getName() + '$', null, 2, null);
            }
            Intrinsics.checkNotNull(name);
            return StringsKt.substringAfter$default(name, '$', null, 2, null);
        }

        @NotNull
        public final Collection<KFunction<T>> getConstructors() {
            Object t2 = this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        @NotNull
        public final Collection<KClass<?>> getNestedClasses() {
            Object t2 = this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        @Nullable
        public final T getObjectInstance() {
            Lazy lazy = this.objectInstance$delegate;
            return lazy.getValue();
        }

        @NotNull
        public final List<KTypeParameter> getTypeParameters() {
            Object t2 = this.typeParameters$delegate.getValue(this, $$delegatedProperties[6]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (List)t2;
        }

        @NotNull
        public final List<KType> getSupertypes() {
            Object t2 = this.supertypes$delegate.getValue(this, $$delegatedProperties[7]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (List)t2;
        }

        @NotNull
        public final List<KClass<? extends T>> getSealedSubclasses() {
            Object t2 = this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[8]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (List)t2;
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            Object t2 = this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[9]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        private final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            Object t2 = this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        private final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            Object t2 = this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        private final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            Object t2 = this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            Object t2 = this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            Object t2 = this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            Object t2 = this.declaredMembers$delegate.getValue(this, $$delegatedProperties[15]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllMembers() {
            Object t2 = this.allMembers$delegate.getValue(this, $$delegatedProperties[16]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        private static final KmClass kmClass_delegate$lambda$1(Data this$0) {
            KmClass kmClass;
            ClassDescriptor classDescriptor = this$0.getDescriptor();
            DeserializedClassDescriptor deserializedClassDescriptor = classDescriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor)classDescriptor : null;
            if (deserializedClassDescriptor != null) {
                DeserializedClassDescriptor descriptor2 = deserializedClassDescriptor;
                boolean bl2 = false;
                kmClass = ReadersKt.toKmClass$default(descriptor2.getClassProto(), descriptor2.getC().getNameResolver(), false, null, 6, null);
            } else {
                kmClass = null;
            }
            return kmClass;
        }

        private static final ClassDescriptor descriptor_delegate$lambda$2(KClassImpl this$0) {
            ClassId classId = this$0.getClassId();
            RuntimeModuleData moduleData = this$0.getData().getValue().getModuleData();
            ModuleDescriptor module = moduleData.getModule();
            ClassDescriptor descriptor2 = classId.isLocal() && this$0.getJClass().isAnnotationPresent(Metadata.class) ? moduleData.getDeserialization().deserializeClass(classId) : FindClassInModuleKt.findClassAcrossModuleDependencies(module, classId);
            ClassDescriptor classDescriptor = descriptor2;
            if (classDescriptor == null) {
                classDescriptor = this$0.createSyntheticClassOrFail(classId, moduleData);
            }
            return classDescriptor;
        }

        /*
         * WARNING - void declaration
         */
        private static final List annotations_delegate$lambda$4(KClassImpl this$0) {
            void $this$filterNotTo$iv$iv;
            Annotation[] annotationArray = this$0.getJClass().getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotationArray, "getAnnotations(...)");
            Object[] $this$filterNot$iv = annotationArray;
            boolean $i$f$filterNot = false;
            Object[] objectArray = $this$filterNot$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterNotTo = false;
            for (void element$iv$iv : $this$filterNotTo$iv$iv) {
                Annotation it = (Annotation)element$iv$iv;
                boolean bl2 = false;
                if (SPECIAL_JVM_ANNOTATION_NAMES.contains(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it)).getName())) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            return UtilKt.unwrapRepeatableAnnotations((List)destination$iv$iv);
        }

        private static final String simpleName_delegate$lambda$5(KClassImpl this$0, Data this$1) {
            String string;
            if (this$0.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = this$0.getClassId();
            if (classId.isLocal()) {
                string = this$1.calculateLocalClassName(this$0.getJClass());
            } else {
                String string2 = classId.getShortClassName().asString();
                string = string2;
                Intrinsics.checkNotNullExpressionValue(string2, "asString(...)");
            }
            return string;
        }

        private static final String qualifiedName_delegate$lambda$6(KClassImpl this$0) {
            if (this$0.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = this$0.getClassId();
            return classId.isLocal() ? null : classId.asSingleFqName().asString();
        }

        /*
         * WARNING - void declaration
         */
        private static final List constructors_delegate$lambda$10(KClassImpl this$0) {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = this$0.getConstructorDescriptors();
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void descriptor2;
                ConstructorDescriptor constructorDescriptor = (ConstructorDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add((KFunction)new KFunctionImpl(this$0, (FunctionDescriptor)descriptor2));
            }
            return (List)destination$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private static final List nestedClasses_delegate$lambda$13(Data this$0, KClassImpl this$1) {
            List list;
            KmClass kmClass = this$0.getKmClass();
            if (kmClass != null) {
                void $this$mapNotNullTo$iv$iv;
                ClassId classId = MetadataUtilKt.toClassId(kmClass.getName());
                ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader(this$1.getJClass());
                Iterable $this$mapNotNull$iv2 = kmClass.getNestedClasses();
                boolean $i$f$mapNotNull = false;
                Iterable iterable = $this$mapNotNull$iv2;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    KClass it$iv$iv;
                    Object element$iv$iv$iv;
                    Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                    boolean bl2 = false;
                    String name = (String)element$iv$iv;
                    boolean bl3 = false;
                    Name name2 = Name.identifier(name);
                    Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
                    Class clazz = UtilKt.loadClass$default(classLoader, classId.createNestedClassId(name2), 0, 2, null);
                    if ((clazz != null ? JvmClassMappingKt.getKotlinClass(clazz) : null) == null) continue;
                    it$iv$iv = it$iv$iv;
                    boolean bl4 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                list = (List)destination$iv$iv;
            } else {
                void $this$mapNotNullTo$iv$iv;
                Class<?>[] classArray = this$1.getJClass().getDeclaredClasses();
                Intrinsics.checkNotNullExpressionValue(classArray, "getDeclaredClasses(...)");
                Object[] $this$mapNotNull$iv = classArray;
                boolean $i$f$mapNotNull = false;
                Object[] $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                int n2 = ((void)$this$forEach$iv$iv$iv).length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    KClass it$iv$iv;
                    void element$iv$iv$iv;
                    void element$iv$iv = element$iv$iv$iv = $this$forEach$iv$iv$iv[i2];
                    boolean bl5 = false;
                    Class it = (Class)element$iv$iv;
                    boolean bl6 = false;
                    Intrinsics.checkNotNull(it);
                    if (JvmClassMappingKt.getKotlinClass(it) == null) continue;
                    boolean bl7 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                list = (List)destination$iv$iv;
            }
            return list;
        }

        private static final Object objectInstance_delegate$lambda$14(Data this$0, KClassImpl this$1) {
            KmClass kmClass = this$0.getKmClass();
            if (kmClass == null || Attributes.getKind(kmClass) != kotlin.reflect.jvm.internal.impl.km.ClassKind.OBJECT && Attributes.getKind(kmClass) != kotlin.reflect.jvm.internal.impl.km.ClassKind.COMPANION_OBJECT) {
                return null;
            }
            Field field = Attributes.getKind(kmClass) == kotlin.reflect.jvm.internal.impl.km.ClassKind.COMPANION_OBJECT && !kotlin.collections.CollectionsKt.contains((Iterable)CompanionObjectMapping.INSTANCE.getClassIds(), MetadataUtilKt.toClassId(kmClass.getName()).getOuterClassId()) ? this$1.getJClass().getEnclosingClass().getDeclaredField(MetadataUtilKt.toNonLocalSimpleName(kmClass.getName())) : this$1.getJClass().getDeclaredField("INSTANCE");
            Object object = field.get(null);
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            return object;
        }

        /*
         * WARNING - void declaration
         */
        private static final List typeParameters_delegate$lambda$16(Data this$0, KClassImpl this$1) {
            void $this$mapTo$iv$iv;
            List<TypeParameterDescriptor> list = this$0.getDescriptor().getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getDeclaredTypeParameters(...)");
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void descriptor2;
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                KTypeParameterOwnerImpl kTypeParameterOwnerImpl = this$1;
                Intrinsics.checkNotNull(descriptor2);
                collection.add(new KTypeParameterImpl(kTypeParameterOwnerImpl, (TypeParameterDescriptor)descriptor2));
            }
            return (List)destination$iv$iv;
        }

        private static final Type supertypes_delegate$lambda$21$lambda$18$lambda$17(KotlinType $kotlinType, Data this$0, KClassImpl this$1) {
            Type type;
            ClassifierDescriptor superClass = $kotlinType.getConstructor().getDeclarationDescriptor();
            if (!(superClass instanceof ClassDescriptor)) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + superClass);
            }
            Class<?> clazz = UtilKt.toJavaClass((ClassDescriptor)superClass);
            if (clazz == null) {
                throw new KotlinReflectionInternalError("Unsupported superclass of " + this$0 + ": " + superClass);
            }
            Class<?> superJavaClass = clazz;
            if (Intrinsics.areEqual(this$1.getJClass().getSuperclass(), superJavaClass)) {
                Type type2 = this$1.getJClass().getGenericSuperclass();
                Intrinsics.checkNotNull(type2);
                type = type2;
            } else {
                Class<?>[] classArray = this$1.getJClass().getInterfaces();
                Intrinsics.checkNotNullExpressionValue(classArray, "getInterfaces(...)");
                int index = ArraysKt.indexOf((Object[])classArray, superJavaClass);
                if (index < 0) {
                    throw new KotlinReflectionInternalError("No superclass of " + this$0 + " in Java reflection for " + superClass);
                }
                Type type3 = this$1.getJClass().getGenericInterfaces()[index];
                Intrinsics.checkNotNull(type3);
                type = type3;
            }
            return type;
        }

        private static final Type supertypes_delegate$lambda$21$lambda$20() {
            return (Type)((Object)Object.class);
        }

        /*
         * WARNING - void declaration
         */
        private static final List supertypes_delegate$lambda$21(Data this$0, KClassImpl this$1) {
            Collection<KotlinType> collection = this$0.getDescriptor().getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
            Collection<KotlinType> kotlinTypes = collection;
            ArrayList result = new ArrayList(kotlinTypes.size());
            Iterable $this$mapTo$iv = kotlinTypes;
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                void kotlinType;
                KotlinType kotlinType2 = (KotlinType)item$iv;
                Collection collection2 = result;
                boolean bl2 = false;
                Intrinsics.checkNotNull(kotlinType);
                KClassImpl kClassImpl = this$1;
                Data data = this$0;
                void var14_13 = kotlinType;
                collection2.add(new KTypeImpl((KotlinType)kotlinType, new KClassImpl$Data$$Lambda$19((KotlinType)var14_13, data, kClassImpl)));
            }
            if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this$0.getDescriptor())) {
                boolean bl3;
                block6: {
                    Iterable $this$all$iv = result;
                    boolean $i$f$all = false;
                    if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                        bl3 = true;
                    } else {
                        for (Object element$iv : $this$all$iv) {
                            ClassKind classKind;
                            KTypeImpl it = (KTypeImpl)element$iv;
                            boolean bl4 = false;
                            Intrinsics.checkNotNullExpressionValue((Object)DescriptorUtils.getClassDescriptorForType(it.getType()).getKind(), "getKind(...)");
                            if (classKind == ClassKind.INTERFACE || classKind == ClassKind.ANNOTATION_CLASS) continue;
                            bl3 = false;
                            break block6;
                        }
                        bl3 = true;
                    }
                }
                if (bl3) {
                    Collection collection3 = result;
                    SimpleType simpleType = DescriptorUtilsKt.getBuiltIns(this$0.getDescriptor()).getAnyType();
                    Intrinsics.checkNotNullExpressionValue(simpleType, "getAnyType(...)");
                    collection3.add(new KTypeImpl(simpleType, KClassImpl$Data$$Lambda$20.INSTANCE));
                }
            }
            return CollectionsKt.compact(result);
        }

        /*
         * WARNING - void declaration
         */
        private static final List sealedSubclasses_delegate$lambda$23(KClassImpl this$0, Data this$1) {
            List list;
            Object element$iv$iv;
            Class<?>[] destination$iv$iv;
            ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader(this$0.getJClass());
            KmClass kmClass = this$1.getKmClass();
            if (kmClass != null) {
                void $this$mapNotNullTo$iv$iv;
                Iterable $this$mapNotNull$iv = kmClass.getSealedSubclasses();
                boolean $i$f$mapNotNull = false;
                Iterable iterable = $this$mapNotNull$iv;
                destination$iv$iv = (Class<?>[])new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    KClass<?> it$iv$iv;
                    Object element$iv$iv$iv;
                    element$iv$iv = element$iv$iv$iv = iterator2.next();
                    boolean bl2 = false;
                    String p0 = (String)element$iv$iv;
                    boolean bl3 = false;
                    if (MetadataUtilKt.loadKClass(classLoader, p0) == null) continue;
                    boolean bl4 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                list = (List)destination$iv$iv;
            } else if (Intrinsics.areEqual(Java16SealedRecordLoader.INSTANCE.loadIsSealed(this$0.getJClass()), true)) {
                List list2;
                Class<?>[] classArray = Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(this$0.getJClass());
                if (classArray != null) {
                    void $this$mapTo$iv$iv;
                    Class<?>[] $this$map$iv = classArray;
                    boolean $i$f$map = false;
                    destination$iv$iv = $this$map$iv;
                    Collection destination$iv$iv2 = new ArrayList($this$map$iv.length);
                    boolean $i$f$mapTo = false;
                    for (void item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        element$iv$iv = item$iv$iv;
                        Collection collection = destination$iv$iv2;
                        boolean bl5 = false;
                        collection.add(JvmClassMappingKt.getKotlinClass(it));
                    }
                    list2 = (List)destination$iv$iv2;
                } else {
                    list2 = list = null;
                }
                if (list2 == null) {
                    list = kotlin.collections.CollectionsKt.emptyList();
                }
            } else {
                list = kotlin.collections.CollectionsKt.emptyList();
            }
            List result = list;
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.collections.List<kotlin.reflect.KClass<out T of kotlin.reflect.jvm.internal.KClassImpl>>");
            return result;
        }

        private static final Collection declaredNonStaticMembers_delegate$lambda$24(KClassImpl this$0) {
            return this$0.getMembers(this$0.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        private static final Collection declaredStaticMembers_delegate$lambda$25(KClassImpl this$0) {
            return this$0.getMembers(this$0.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        private static final Collection inheritedNonStaticMembers_delegate$lambda$26(KClassImpl this$0) {
            return this$0.getMembers(this$0.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        private static final Collection inheritedStaticMembers_delegate$lambda$27(KClassImpl this$0) {
            return this$0.getMembers(this$0.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        private static final List allNonStaticMembers_delegate$lambda$28(Data this$0) {
            return kotlin.collections.CollectionsKt.plus(this$0.getDeclaredNonStaticMembers(), (Iterable)this$0.getInheritedNonStaticMembers());
        }

        private static final List allStaticMembers_delegate$lambda$29(Data this$0) {
            return kotlin.collections.CollectionsKt.plus(this$0.getDeclaredStaticMembers(), (Iterable)this$0.getInheritedStaticMembers());
        }

        private static final List declaredMembers_delegate$lambda$30(Data this$0) {
            return kotlin.collections.CollectionsKt.plus(this$0.getDeclaredNonStaticMembers(), (Iterable)this$0.getDeclaredStaticMembers());
        }

        private static final List allMembers_delegate$lambda$31(Data this$0) {
            return kotlin.collections.CollectionsKt.plus(this$0.getAllNonStaticMembers(), (Iterable)this$0.getAllStaticMembers());
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Data.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "annotations", "getAnnotations()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "constructors", "getConstructors()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "supertypes", "getSupertypes()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0))};
            $$delegatedProperties = kPropertyArray;
        }

        static /* synthetic */ KmClass accessor$KClassImpl$Data$lambda0(Data data) {
            return Data.kmClass_delegate$lambda$1(data);
        }

        static /* synthetic */ ClassDescriptor accessor$KClassImpl$Data$lambda1(KClassImpl kClassImpl) {
            return Data.descriptor_delegate$lambda$2(kClassImpl);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda2(KClassImpl kClassImpl) {
            return Data.annotations_delegate$lambda$4(kClassImpl);
        }

        static /* synthetic */ String accessor$KClassImpl$Data$lambda3(KClassImpl kClassImpl, Data data) {
            return Data.simpleName_delegate$lambda$5(kClassImpl, data);
        }

        static /* synthetic */ String accessor$KClassImpl$Data$lambda4(KClassImpl kClassImpl) {
            return Data.qualifiedName_delegate$lambda$6(kClassImpl);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda5(KClassImpl kClassImpl) {
            return Data.constructors_delegate$lambda$10(kClassImpl);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda6(Data data, KClassImpl kClassImpl) {
            return Data.nestedClasses_delegate$lambda$13(data, kClassImpl);
        }

        static /* synthetic */ Object accessor$KClassImpl$Data$lambda7(Data data, KClassImpl kClassImpl) {
            return Data.objectInstance_delegate$lambda$14(data, kClassImpl);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda8(Data data, KClassImpl kClassImpl) {
            return Data.typeParameters_delegate$lambda$16(data, kClassImpl);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda9(Data data, KClassImpl kClassImpl) {
            return Data.supertypes_delegate$lambda$21(data, kClassImpl);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda10(KClassImpl kClassImpl, Data data) {
            return Data.sealedSubclasses_delegate$lambda$23(kClassImpl, data);
        }

        static /* synthetic */ Collection accessor$KClassImpl$Data$lambda11(KClassImpl kClassImpl) {
            return Data.declaredNonStaticMembers_delegate$lambda$24(kClassImpl);
        }

        static /* synthetic */ Collection accessor$KClassImpl$Data$lambda12(KClassImpl kClassImpl) {
            return Data.declaredStaticMembers_delegate$lambda$25(kClassImpl);
        }

        static /* synthetic */ Collection accessor$KClassImpl$Data$lambda13(KClassImpl kClassImpl) {
            return Data.inheritedNonStaticMembers_delegate$lambda$26(kClassImpl);
        }

        static /* synthetic */ Collection accessor$KClassImpl$Data$lambda14(KClassImpl kClassImpl) {
            return Data.inheritedStaticMembers_delegate$lambda$27(kClassImpl);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda15(Data data) {
            return Data.allNonStaticMembers_delegate$lambda$28(data);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda16(Data data) {
            return Data.allStaticMembers_delegate$lambda$29(data);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda17(Data data) {
            return Data.declaredMembers_delegate$lambda$30(data);
        }

        static /* synthetic */ List accessor$KClassImpl$Data$lambda18(Data data) {
            return Data.allMembers_delegate$lambda$31(data);
        }

        static /* synthetic */ Type accessor$KClassImpl$Data$lambda19(KotlinType kotlinType, Data data, KClassImpl kClassImpl) {
            return Data.supertypes_delegate$lambda$21$lambda$18$lambda$17(kotlinType, data, kClassImpl);
        }

        static /* synthetic */ Type accessor$KClassImpl$Data$lambda20() {
            return Data.supertypes_delegate$lambda$21$lambda$20();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[KotlinClassHeader.Kind.values().length];
            try {
                nArray[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

