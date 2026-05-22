/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KPackageImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$0;
import kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$1;
import kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$2;
import kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$3;
import kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$4;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001)B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006*"}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "data", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "equals", "", "other", "", "hashCode", "toString", "", "Data", "kotlin-reflection"})
public final class KPackageImpl
extends KDeclarationContainerImpl {
    @NotNull
    private final Class<?> jClass;
    @NotNull
    private final Lazy<Data> data;

    public KPackageImpl(@NotNull Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        KPackageImpl kPackageImpl = this;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPackageImpl$$Lambda$0(kPackageImpl));
    }

    @Override
    @NotNull
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override
    @NotNull
    protected Class<?> getMethodOwner() {
        Class<?> clazz = this.data.getValue().getMultifileFacade();
        if (clazz == null) {
            clazz = this.getJClass();
        }
        return clazz;
    }

    private final MemberScope getScope() {
        return this.data.getValue().getScope();
    }

    @Override
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.data.getValue().getMembers();
    }

    @Override
    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.getScope().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override
    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.getScope().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override
    @Nullable
    public PropertyDescriptor getLocalProperty(int index) {
        PropertyDescriptor propertyDescriptor;
        Triple<JvmNameResolver, ProtoBuf.Package, MetadataVersion> triple = this.data.getValue().getMetadata();
        if (triple != null) {
            Triple<JvmNameResolver, ProtoBuf.Package, MetadataVersion> triple2 = triple;
            boolean bl2 = false;
            JvmNameResolver nameResolver = triple2.component1();
            ProtoBuf.Package packageProto = triple2.component2();
            MetadataVersion metadataVersion = triple2.component3();
            GeneratedMessageLite.ExtendableMessage extendableMessage = packageProto;
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.packageLocalVariable;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "packageLocalVariable");
            ProtoBuf.Property property = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension, index);
            if (property != null) {
                ProtoBuf.Property proto = property;
                boolean bl3 = false;
                Class<?> clazz = this.getJClass();
                MessageLite messageLite = proto;
                NameResolver nameResolver2 = nameResolver;
                ProtoBuf.TypeTable typeTable = packageProto.getTypeTable();
                Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
                propertyDescriptor = (PropertyDescriptor)UtilKt.deserializeToDescriptor(clazz, messageLite, nameResolver2, new TypeTable(typeTable), metadataVersion, KPackageImpl$$Lambda$1.INSTANCE);
            } else {
                propertyDescriptor = null;
            }
        } else {
            propertyDescriptor = null;
        }
        return propertyDescriptor;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KPackageImpl && Intrinsics.areEqual(this.getJClass(), ((KPackageImpl)other).getJClass());
    }

    public int hashCode() {
        return this.getJClass().hashCode();
    }

    @NotNull
    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(this.getJClass()).asSingleFqName();
    }

    private static final Data data$lambda$0(KPackageImpl this$0) {
        return this$0.new Data();
    }

    private static final PropertyDescriptor getLocalProperty$lambda$3$lambda$2$lambda$1(MemberDeserializer $this$deserializeToDescriptor, ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter($this$deserializeToDescriptor, "$this$deserializeToDescriptor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        return $this$deserializeToDescriptor.loadProperty(proto, true);
    }

    static /* synthetic */ Data accessor$KPackageImpl$lambda0(KPackageImpl kPackageImpl) {
        return KPackageImpl.data$lambda$0(kPackageImpl);
    }

    static /* synthetic */ PropertyDescriptor accessor$KPackageImpl$lambda1(MemberDeserializer memberDeserializer, ProtoBuf.Property property) {
        return KPackageImpl.getLocalProperty$lambda$3$lambda$2$lambda$1(memberDeserializer, property);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR%\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u001f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"\u00a8\u0006$"}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "Lkotlin/Lazy;", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/MetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "kotlin-reflection"})
    private final class Data
    extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final ReflectProperties.LazySoftVal kotlinClass$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal scope$delegate;
        @NotNull
        private final Lazy multifileFacade$delegate;
        @NotNull
        private final Lazy metadata$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal members$delegate;

        public Data() {
            Object object = KPackageImpl.this;
            this.kotlinClass$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$$Lambda$0((KPackageImpl)object));
            object = this;
            this.scope$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$$Lambda$1((Data)object));
            object = KPackageImpl.this;
            Object object2 = this;
            this.multifileFacade$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPackageImpl$Data$$Lambda$2((Data)object2, (KPackageImpl)object));
            object = this;
            this.metadata$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPackageImpl$Data$$Lambda$3((Data)object));
            object = this;
            object2 = KPackageImpl.this;
            this.members$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$$Lambda$4((KPackageImpl)object2, (Data)object));
        }

        private final ReflectKotlinClass getKotlinClass() {
            return (ReflectKotlinClass)this.kotlinClass$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @NotNull
        public final MemberScope getScope() {
            Object t2 = this.scope$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (MemberScope)t2;
        }

        @Nullable
        public final Class<?> getMultifileFacade() {
            Lazy lazy = this.multifileFacade$delegate;
            return (Class)lazy.getValue();
        }

        @Nullable
        public final Triple<JvmNameResolver, ProtoBuf.Package, MetadataVersion> getMetadata() {
            Lazy lazy = this.metadata$delegate;
            return (Triple)lazy.getValue();
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getMembers() {
            Object t2 = this.members$delegate.getValue(this, $$delegatedProperties[2]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (Collection)t2;
        }

        private static final ReflectKotlinClass kotlinClass_delegate$lambda$0(KPackageImpl this$0) {
            return ReflectKotlinClass.Factory.create(this$0.getJClass());
        }

        private static final MemberScope scope_delegate$lambda$1(Data this$0) {
            ReflectKotlinClass klass = this$0.getKotlinClass();
            return klass != null ? this$0.getModuleData().getPackagePartScopeCache().getPackagePartScope(klass) : (MemberScope)MemberScope.Empty.INSTANCE;
        }

        private static final Class multifileFacade_delegate$lambda$2(Data this$0, KPackageImpl this$1) {
            String facadeName;
            Object object = this$0.getKotlinClass();
            String string = object != null && (object = ((ReflectKotlinClass)object).getClassHeader()) != null ? ((KotlinClassHeader)object).getMultifileClassName() : (facadeName = null);
            return facadeName != null && ((CharSequence)facadeName).length() > 0 ? this$1.getJClass().getClassLoader().loadClass(StringsKt.replace$default(facadeName, '/', '.', false, 4, null)) : null;
        }

        private static final Triple metadata_delegate$lambda$4(Data this$0) {
            Triple<JvmNameResolver, ProtoBuf.Package, MetadataVersion> triple;
            Object object = this$0.getKotlinClass();
            if (object != null && (object = ((ReflectKotlinClass)object).getClassHeader()) != null) {
                Object header = object;
                boolean bl2 = false;
                String[] data = ((KotlinClassHeader)header).getData();
                String[] strings = ((KotlinClassHeader)header).getStrings();
                if (data != null && strings != null) {
                    Pair<JvmNameResolver, ProtoBuf.Package> pair = JvmProtoBufUtil.readPackageDataFrom(data, strings);
                    JvmNameResolver nameResolver = pair.component1();
                    ProtoBuf.Package proto = pair.component2();
                    triple = new Triple<JvmNameResolver, ProtoBuf.Package, MetadataVersion>(nameResolver, proto, ((KotlinClassHeader)header).getMetadataVersion());
                } else {
                    triple = null;
                }
            } else {
                triple = null;
            }
            return triple;
        }

        private static final Collection members_delegate$lambda$5(KPackageImpl this$0, Data this$1) {
            return this$0.getMembers(this$1.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Data.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "members", "getMembers()Ljava/util/Collection;", 0))};
            $$delegatedProperties = kPropertyArray;
        }

        static /* synthetic */ ReflectKotlinClass accessor$KPackageImpl$Data$lambda0(KPackageImpl kPackageImpl) {
            return Data.kotlinClass_delegate$lambda$0(kPackageImpl);
        }

        static /* synthetic */ MemberScope accessor$KPackageImpl$Data$lambda1(Data data) {
            return Data.scope_delegate$lambda$1(data);
        }

        static /* synthetic */ Class accessor$KPackageImpl$Data$lambda2(Data data, KPackageImpl kPackageImpl) {
            return Data.multifileFacade_delegate$lambda$2(data, kPackageImpl);
        }

        static /* synthetic */ Triple accessor$KPackageImpl$Data$lambda3(Data data) {
            return Data.metadata_delegate$lambda$4(data);
        }

        static /* synthetic */ Collection accessor$KPackageImpl$Data$lambda4(KPackageImpl kPackageImpl, Data data) {
            return Data.members_delegate$lambda$5(kPackageImpl, data);
        }
    }
}

