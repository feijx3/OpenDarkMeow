/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin._Assertions;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependenciesImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nModuleDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ModuleDescriptorImpl\n+ 2 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n19#2:181\n19#2:185\n19#2:186\n19#2:188\n774#3:182\n865#3,2:183\n1869#3,2:189\n1563#3:191\n1634#3,3:192\n1#4:187\n*S KotlinDebug\n*F\n+ 1 ModuleDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ModuleDescriptorImpl\n*L\n72#1:181\n75#1:185\n78#1:186\n91#1:188\n72#1:182\n72#1:183,2\n95#1:189,2\n101#1:191\n101#1:192,3\n*E\n"})
public final class ModuleDescriptorImpl
extends DeclarationDescriptorImpl
implements ModuleDescriptor {
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final KotlinBuiltIns builtIns;
    @Nullable
    private final TargetPlatform platform;
    @Nullable
    private final Name stableName;
    @NotNull
    private final Map<ModuleCapability<?>, Object> capabilities;
    @NotNull
    private final PackageViewDescriptorFactory packageViewDescriptorFactory;
    @Nullable
    private ModuleDependencies dependencies;
    @Nullable
    private PackageFragmentProvider packageFragmentProviderForModuleContent;
    private boolean isValid;
    @NotNull
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    @NotNull
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;

    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns, @Nullable TargetPlatform platform, @NotNull Map<ModuleCapability<?>, ? extends Object> capabilities, @Nullable Name stableName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        super(Annotations.Companion.getEMPTY(), moduleName);
        this.storageManager = storageManager;
        this.builtIns = builtIns;
        this.platform = platform;
        this.stableName = stableName;
        if (!moduleName.isSpecial()) {
            throw new IllegalArgumentException("Module name must be special: " + moduleName);
        }
        this.capabilities = capabilities;
        PackageViewDescriptorFactory packageViewDescriptorFactory = this.getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
        if (packageViewDescriptorFactory == null) {
            packageViewDescriptorFactory = PackageViewDescriptorFactory.Default.INSTANCE;
        }
        this.packageViewDescriptorFactory = packageViewDescriptorFactory;
        this.isValid = true;
        ModuleDescriptorImpl moduleDescriptorImpl = this;
        this.packages = this.storageManager.createMemoizedFunction(new ModuleDescriptorImpl$$Lambda$0(moduleDescriptorImpl));
        moduleDescriptorImpl = this;
        this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy(new ModuleDescriptorImpl$$Lambda$1(moduleDescriptorImpl));
    }

    public /* synthetic */ ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            targetPlatform = null;
        }
        if ((n2 & 0x10) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((n2 & 0x20) != 0) {
            name2 = null;
        }
        this(name, storageManager, kotlinBuiltIns, targetPlatform, map, name2);
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void assertValid() {
        if (!this.isValid()) {
            InvalidModuleExceptionKt.moduleInvalidated(this);
        }
    }

    @Override
    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies $this$sure$iv = this.dependencies;
        boolean $i$f$sure = false;
        ModuleDependencies moduleDependencies = $this$sure$iv;
        if (moduleDependencies == null) {
            boolean bl2 = false;
            String string = "Dependencies of module " + this.getId() + " were not set";
            throw new AssertionError((Object)string);
        }
        return moduleDependencies.getDirectExpectedByDependencies();
    }

    @Override
    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.assertValid();
        return (PackageViewDescriptor)this.packages.invoke(fqName);
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        this.assertValid();
        return this.getPackageFragmentProvider().getSubPackagesOf(fqName, nameFilter);
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        Lazy lazy = this.packageFragmentProviderForWholeModuleWithDependencies$delegate;
        return (CompositePackageFragmentProvider)lazy.getValue();
    }

    private final boolean isInitialized() {
        return this.packageFragmentProviderForModuleContent != null;
    }

    public final void setDependencies(@NotNull ModuleDependencies dependencies) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        boolean bl3 = bl2 = this.dependencies == null;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Dependencies of " + this.getId() + " were already set";
            throw new AssertionError((Object)string);
        }
        this.dependencies = dependencies;
    }

    public final void setDependencies(ModuleDescriptorImpl ... descriptors) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        this.setDependencies(ArraysKt.toList(descriptors));
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> descriptors) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        this.setDependencies(descriptors, SetsKt.<ModuleDescriptorImpl>emptySet());
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> descriptors, @NotNull Set<ModuleDescriptorImpl> friends) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        Intrinsics.checkNotNullParameter(friends, "friends");
        this.setDependencies(new ModuleDependenciesImpl(descriptors, friends, CollectionsKt.<ModuleDescriptorImpl>emptyList(), SetsKt.<ModuleDescriptorImpl>emptySet()));
    }

    @Override
    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor targetModule) {
        Intrinsics.checkNotNullParameter(targetModule, "targetModule");
        if (Intrinsics.areEqual(this, targetModule)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        Intrinsics.checkNotNull(moduleDependencies);
        if (CollectionsKt.contains((Iterable)moduleDependencies.getModulesWhoseInternalsAreVisible(), targetModule)) {
            return true;
        }
        if (this.getExpectedByModules().contains(targetModule)) {
            return true;
        }
        return targetModule.getExpectedByModules().contains(this);
    }

    private final String getId() {
        String string = this.getName().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void initialize(@NotNull PackageFragmentProvider providerForModuleContent) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(providerForModuleContent, "providerForModuleContent");
        boolean bl3 = bl2 = !this.isInitialized();
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Attempt to initialize module " + this.getId() + " twice";
            throw new AssertionError((Object)string);
        }
        this.packageFragmentProviderForModuleContent = providerForModuleContent;
    }

    @NotNull
    public final PackageFragmentProvider getPackageFragmentProvider() {
        this.assertValid();
        return this.getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override
    @Nullable
    public <T> T getCapability(@NotNull ModuleCapability<T> capability) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        Object object = this.capabilities.get(capability);
        if (object == null) {
            object = null;
        }
        return (T)object;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder $this$toString_u24lambda_u2413 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        $this$toString_u24lambda_u2413.append(super.toString());
        if (!this.isValid()) {
            $this$toString_u24lambda_u2413.append(" !isValid");
        }
        $this$toString_u24lambda_u2413.append(" packageFragmentProvider: ");
        Object object = this.packageFragmentProviderForModuleContent;
        $this$toString_u24lambda_u2413.append(object != null && (object = object.getClass()) != null ? ((Class)object).getSimpleName() : null);
        return stringBuilder.toString();
    }

    @Override
    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override
    @Nullable
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        return ModuleDescriptor.DefaultImpls.accept(this, visitor2, data);
    }

    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns, @Nullable TargetPlatform platform) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        this(moduleName, storageManager, builtIns, platform, null, null, 48, null);
    }

    private static final PackageViewDescriptor packages$lambda$0(ModuleDescriptorImpl this$0, FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this$0.packageViewDescriptorFactory.compute(this$0, fqName, this$0.storageManager);
    }

    /*
     * WARNING - void declaration
     */
    private static final CompositePackageFragmentProvider packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(ModuleDescriptorImpl this$0) {
        void $this$mapTo$iv$iv;
        ModuleDependencies $this$sure$iv = this$0.dependencies;
        boolean $i$f$sure = false;
        ModuleDependencies moduleDependencies = $this$sure$iv;
        if (moduleDependencies == null) {
            boolean bl2 = false;
            String string = "Dependencies of module " + this$0.getId() + " were not set before querying module content";
            throw new AssertionError((Object)string);
        }
        ModuleDependencies moduleDependencies2 = moduleDependencies;
        List<ModuleDescriptorImpl> dependenciesDescriptors = moduleDependencies2.getAllDependencies();
        this$0.assertValid();
        $i$f$sure = dependenciesDescriptors.contains(this$0);
        if (_Assertions.ENABLED && !$i$f$sure) {
            boolean $i$a$-assert-ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2$22 = false;
            String $i$a$-assert-ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2$22 = "Module " + this$0.getId() + " is not contained in its own dependencies, this is probably a misconfiguration";
            throw new AssertionError((Object)$i$a$-assert-ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2$22);
        }
        Iterable $this$forEach$iv = dependenciesDescriptors;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ModuleDescriptorImpl dependency = (ModuleDescriptorImpl)element$iv;
            boolean bl3 = false;
            boolean bl4 = dependency.isInitialized();
            if (!_Assertions.ENABLED || bl4) continue;
            boolean $i$a$-assert-ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2$2$22 = false;
            String $i$a$-assert-ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2$2$22 = "Dependency module " + dependency.getId() + " was not initialized by the time contents of dependent module " + this$0.getId() + " were queried";
            throw new AssertionError((Object)$i$a$-assert-ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2$2$22);
        }
        Iterable $this$map$iv = dependenciesDescriptors;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ModuleDescriptorImpl $i$a$-assert-ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2$2$22 = (ModuleDescriptorImpl)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl5 = false;
            PackageFragmentProvider packageFragmentProvider = it.packageFragmentProviderForModuleContent;
            Intrinsics.checkNotNull(packageFragmentProvider);
            collection.add(packageFragmentProvider);
        }
        String string = "CompositeProvider@ModuleDescriptor for " + this$0.getName();
        List list = (List)destination$iv$iv;
        return new CompositePackageFragmentProvider(list, string);
    }

    static /* synthetic */ PackageViewDescriptor accessor$ModuleDescriptorImpl$lambda0(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName) {
        return ModuleDescriptorImpl.packages$lambda$0(moduleDescriptorImpl, fqName);
    }

    static /* synthetic */ CompositePackageFragmentProvider accessor$ModuleDescriptorImpl$lambda1(ModuleDescriptorImpl moduleDescriptorImpl) {
        return ModuleDescriptorImpl.packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(moduleDescriptorImpl);
    }
}

