/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SubpackagesScope;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyPackageViewDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyPackageViewDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/LazyPackageViewDescriptorImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n1563#2:72\n1634#2,3:73\n*S KotlinDebug\n*F\n+ 1 LazyPackageViewDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/LazyPackageViewDescriptorImpl\n*L\n49#1:72\n49#1:73,3\n*E\n"})
public class LazyPackageViewDescriptorImpl
extends DeclarationDescriptorImpl
implements PackageViewDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ModuleDescriptorImpl module;
    @NotNull
    private final FqName fqName;
    @NotNull
    private final NotNullLazyValue fragments$delegate;
    @NotNull
    private final NotNullLazyValue empty$delegate;
    @NotNull
    private final MemberScope memberScope;

    public LazyPackageViewDescriptorImpl(@NotNull ModuleDescriptorImpl module, @NotNull FqName fqName, @NotNull StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        super(Annotations.Companion.getEMPTY(), fqName.shortNameOrSpecial());
        this.module = module;
        this.fqName = fqName;
        LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl = this;
        this.fragments$delegate = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$$Lambda$0(lazyPackageViewDescriptorImpl));
        lazyPackageViewDescriptorImpl = this;
        this.empty$delegate = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$$Lambda$1(lazyPackageViewDescriptorImpl));
        lazyPackageViewDescriptorImpl = this;
        this.memberScope = new LazyScopeAdapter(storageManager, new LazyPackageViewDescriptorImpl$$Lambda$2(lazyPackageViewDescriptorImpl));
    }

    @Override
    @NotNull
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }

    @Override
    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    @Override
    @NotNull
    public List<PackageFragmentDescriptor> getFragments() {
        return (List)StorageKt.getValue(this.fragments$delegate, (Object)this, $$delegatedProperties[0]);
    }

    protected final boolean getEmpty() {
        return (Boolean)StorageKt.getValue(this.empty$delegate, (Object)this, $$delegatedProperties[1]);
    }

    @Override
    public boolean isEmpty() {
        return this.getEmpty();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override
    @Nullable
    public PackageViewDescriptor getContainingDeclaration() {
        return this.getFqName().isRoot() ? null : this.getModule().getPackage(this.getFqName().parent());
    }

    public boolean equals(@Nullable Object other) {
        PackageViewDescriptor packageViewDescriptor = other instanceof PackageViewDescriptor ? (PackageViewDescriptor)other : null;
        if (packageViewDescriptor == null) {
            return false;
        }
        PackageViewDescriptor that = packageViewDescriptor;
        return Intrinsics.areEqual(this.getFqName(), that.getFqName()) && Intrinsics.areEqual(this.getModule(), that.getModule());
    }

    public int hashCode() {
        int result = this.getModule().hashCode();
        result = 31 * result + this.getFqName().hashCode();
        return result;
    }

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        Intrinsics.checkNotNullParameter(visitor2, "visitor");
        return visitor2.visitPackageViewDescriptor(this, data);
    }

    private static final List fragments_delegate$lambda$0(LazyPackageViewDescriptorImpl this$0) {
        return PackageFragmentProviderKt.packageFragments(this$0.getModule().getPackageFragmentProvider(), this$0.getFqName());
    }

    private static final boolean empty_delegate$lambda$1(LazyPackageViewDescriptorImpl this$0) {
        return PackageFragmentProviderKt.isEmpty(this$0.getModule().getPackageFragmentProvider(), this$0.getFqName());
    }

    /*
     * WARNING - void declaration
     */
    private static final MemberScope memberScope$lambda$3(LazyPackageViewDescriptorImpl this$0) {
        MemberScope memberScope;
        if (this$0.isEmpty()) {
            memberScope = MemberScope.Empty.INSTANCE;
        } else {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = this$0.getFragments();
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(it.getMemberScope());
            }
            List<SubpackagesScope> scopes = CollectionsKt.plus((Collection)((List)destination$iv$iv), new SubpackagesScope(this$0.getModule(), this$0.getFqName()));
            memberScope = ChainedMemberScope.Companion.create("package view scope for " + this$0.getFqName() + " in " + this$0.getModule().getName(), (Iterable<? extends MemberScope>)scopes);
        }
        return memberScope;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LazyPackageViewDescriptorImpl.class, "fragments", "getFragments()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(LazyPackageViewDescriptorImpl.class, "empty", "getEmpty()Z", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ List accessor$LazyPackageViewDescriptorImpl$lambda0(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        return LazyPackageViewDescriptorImpl.fragments_delegate$lambda$0(lazyPackageViewDescriptorImpl);
    }

    static /* synthetic */ boolean accessor$LazyPackageViewDescriptorImpl$lambda1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        return LazyPackageViewDescriptorImpl.empty_delegate$lambda$1(lazyPackageViewDescriptorImpl);
    }

    static /* synthetic */ MemberScope accessor$LazyPackageViewDescriptorImpl$lambda2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        return LazyPackageViewDescriptorImpl.memberScope$lambda$3(lazyPackageViewDescriptorImpl);
    }
}

