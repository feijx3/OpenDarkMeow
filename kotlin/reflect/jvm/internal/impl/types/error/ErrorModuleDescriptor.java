/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorModuleDescriptor$$Lambda$0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErrorModuleDescriptor
implements ModuleDescriptor {
    @NotNull
    public static final ErrorModuleDescriptor INSTANCE = new ErrorModuleDescriptor();
    @NotNull
    private static final Name stableName;
    @NotNull
    private static final List<ModuleDescriptor> allDependencyModules;
    @NotNull
    private static final List<ModuleDescriptor> expectedByModules;
    @NotNull
    private static final Set<ModuleDescriptor> allExpectedByModules;
    @NotNull
    private static final Lazy builtIns$delegate;

    private ErrorModuleDescriptor() {
    }

    @NotNull
    public Name getStableName() {
        return stableName;
    }

    @Override
    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        return expectedByModules;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        Lazy lazy = builtIns$delegate;
        return (KotlinBuiltIns)lazy.getValue();
    }

    @Override
    @Nullable
    public <T> T getCapability(@NotNull ModuleCapability<T> capability) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        return null;
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Name getName() {
        return this.getStableName();
    }

    @Override
    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override
    @NotNull
    public DeclarationDescriptor getOriginal() {
        return this;
    }

    @Override
    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return null;
    }

    @Override
    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor targetModule) {
        Intrinsics.checkNotNullParameter(targetModule, "targetModule");
        return false;
    }

    @Override
    @Nullable
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        Intrinsics.checkNotNullParameter(visitor2, "visitor");
        return null;
    }

    private static final DefaultBuiltIns builtIns_delegate$lambda$0() {
        return DefaultBuiltIns.Companion.getInstance();
    }

    static {
        Name name = Name.special(ErrorEntity.ERROR_MODULE.getDebugText());
        Intrinsics.checkNotNullExpressionValue(name, "special(...)");
        stableName = name;
        allDependencyModules = CollectionsKt.emptyList();
        expectedByModules = CollectionsKt.emptyList();
        allExpectedByModules = SetsKt.emptySet();
        builtIns$delegate = LazyKt.lazy(ErrorModuleDescriptor$$Lambda$0.INSTANCE);
    }

    static /* synthetic */ DefaultBuiltIns accessor$ErrorModuleDescriptor$lambda0() {
        return ErrorModuleDescriptor.builtIns_delegate$lambda$0();
    }
}

