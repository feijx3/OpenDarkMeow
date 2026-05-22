/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoBasedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDeserializedPackageFragmentImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedPackageFragmentImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/DeserializedPackageFragmentImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n774#2:64\n865#2,2:65\n1563#2:67\n1634#2,3:68\n*S KotlinDebug\n*F\n+ 1 DeserializedPackageFragmentImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/DeserializedPackageFragmentImpl\n*L\n54#1:64\n54#1:65,2\n56#1:67\n56#1:68,3\n*E\n"})
public abstract class DeserializedPackageFragmentImpl
extends DeserializedPackageFragment {
    @NotNull
    private final BinaryVersion metadataVersion;
    @Nullable
    private final DeserializedContainerSource containerSource;
    @NotNull
    private final NameResolverImpl nameResolver;
    @NotNull
    private final ProtoBasedClassDataFinder classDataFinder;
    @Nullable
    private ProtoBuf.PackageFragment _proto;
    private MemberScope _memberScope;

    public DeserializedPackageFragmentImpl(@NotNull FqName fqName, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor module, @NotNull ProtoBuf.PackageFragment proto, @NotNull BinaryVersion metadataVersion, @Nullable DeserializedContainerSource containerSource) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        super(fqName, storageManager, module);
        this.metadataVersion = metadataVersion;
        this.containerSource = containerSource;
        ProtoBuf.StringTable stringTable = proto.getStrings();
        Intrinsics.checkNotNullExpressionValue(stringTable, "getStrings(...)");
        ProtoBuf.QualifiedNameTable qualifiedNameTable = proto.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(qualifiedNameTable, "getQualifiedNames(...)");
        this.nameResolver = new NameResolverImpl(stringTable, qualifiedNameTable);
        DeserializedPackageFragmentImpl deserializedPackageFragmentImpl = this;
        this.classDataFinder = new ProtoBasedClassDataFinder(proto, this.nameResolver, this.metadataVersion, new DeserializedPackageFragmentImpl$$Lambda$0(deserializedPackageFragmentImpl));
        this._proto = proto;
    }

    @Override
    @NotNull
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    @Override
    public void initialize(@NotNull DeserializationComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        ProtoBuf.PackageFragment packageFragment = this._proto;
        if (packageFragment == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        ProtoBuf.PackageFragment proto = packageFragment;
        this._proto = null;
        PackageFragmentDescriptor packageFragmentDescriptor = this;
        ProtoBuf.Package package_ = proto.getPackage();
        Intrinsics.checkNotNullExpressionValue(package_, "getPackage(...)");
        DeserializedPackageFragmentImpl deserializedPackageFragmentImpl = this;
        this._memberScope = new DeserializedPackageMemberScope(packageFragmentDescriptor, package_, this.nameResolver, this.metadataVersion, this.containerSource, components, "scope of " + this, new DeserializedPackageFragmentImpl$$Lambda$1(deserializedPackageFragmentImpl));
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope memberScope = this._memberScope;
        if (memberScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
            memberScope = null;
        }
        return memberScope;
    }

    private static final SourceElement classDataFinder$lambda$0(DeserializedPackageFragmentImpl this$0, ClassId it) {
        SourceElement sourceElement;
        Intrinsics.checkNotNullParameter(it, "it");
        DeserializedContainerSource deserializedContainerSource = this$0.containerSource;
        if (deserializedContainerSource != null) {
            sourceElement = deserializedContainerSource;
        } else {
            SourceElement sourceElement2 = SourceElement.NO_SOURCE;
            sourceElement = sourceElement2;
            Intrinsics.checkNotNullExpressionValue(sourceElement2, "NO_SOURCE");
        }
        return sourceElement;
    }

    /*
     * WARNING - void declaration
     */
    private static final Collection initialize$lambda$3(DeserializedPackageFragmentImpl this$0) {
        void $this$mapTo$iv$iv;
        ClassId classId;
        Iterable $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.getClassDataFinder().getAllClassIds();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            classId = (ClassId)element$iv$iv;
            boolean bl2 = false;
            if (!(!classId.isNestedClass() && !ClassDeserializer.Companion.getBLACK_LIST().contains(classId))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            classId = (ClassId)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(it.getShortClassName());
        }
        return (List)destination$iv$iv;
    }

    static /* synthetic */ SourceElement accessor$DeserializedPackageFragmentImpl$lambda0(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl, ClassId classId) {
        return DeserializedPackageFragmentImpl.classDataFinder$lambda$0(deserializedPackageFragmentImpl, classId);
    }

    static /* synthetic */ Collection accessor$DeserializedPackageFragmentImpl$lambda1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        return DeserializedPackageFragmentImpl.initialize$lambda$3(deserializedPackageFragmentImpl);
    }
}

