/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaDescriptorResolver {
    @NotNull
    private final LazyJavaPackageFragmentProvider packageFragmentProvider;
    @NotNull
    private final JavaResolverCache javaResolverCache;

    public JavaDescriptorResolver(@NotNull LazyJavaPackageFragmentProvider packageFragmentProvider, @NotNull JavaResolverCache javaResolverCache) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        this.packageFragmentProvider = packageFragmentProvider;
        this.javaResolverCache = javaResolverCache;
    }

    @NotNull
    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    @Nullable
    public final ClassDescriptor resolveClass(@NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        FqName fqName = javaClass.getFqName();
        if (fqName != null && javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE) {
            return this.javaResolverCache.getClassResolvedFromSource(fqName);
        }
        JavaClass javaClass2 = javaClass.getOuterClass();
        if (javaClass2 != null) {
            MemberScope outerClassScope;
            JavaClass outerClass = javaClass2;
            boolean bl2 = false;
            ClassDescriptor classDescriptor = this.resolveClass(outerClass);
            MemberScope memberScope = outerClassScope = classDescriptor != null ? classDescriptor.getUnsubstitutedInnerClassesScope() : null;
            ClassifierDescriptor classifierDescriptor = memberScope != null ? memberScope.getContributedClassifier(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER) : null;
            return classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
        }
        if (fqName == null) {
            return null;
        }
        LazyJavaPackageFragment lazyJavaPackageFragment = CollectionsKt.firstOrNull(this.packageFragmentProvider.getPackageFragments(fqName.parent()));
        return lazyJavaPackageFragment != null ? lazyJavaPackageFragment.findClassifierByJavaClass$descriptors_jvm(javaClass) : null;
    }
}

