/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJvmPackageScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/JvmPackageScope\n+ 2 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,109:1\n92#2,14:110\n60#2,5:124\n60#2,5:129\n60#2,5:134\n10557#3,5:139\n10557#3,5:144\n1617#4,9:149\n1869#4:158\n1870#4:160\n1626#4:161\n1#5:159\n37#6:162\n36#6,3:163\n*S KotlinDebug\n*F\n+ 1 JvmPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/JvmPackageScope\n*L\n58#1:110,14\n63#1:124,5\n68#1:129,5\n74#1:134,5\n76#1:139,5\n80#1:144,5\n46#1:149,9\n46#1:158\n46#1:160\n46#1:161\n46#1:159\n49#1:162\n49#1:163,3\n*E\n"})
public final class JvmPackageScope
implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final LazyJavaPackageFragment packageFragment;
    @NotNull
    private final LazyJavaPackageScope javaScope;
    @NotNull
    private final NotNullLazyValue kotlinScopes$delegate;

    public JvmPackageScope(@NotNull LazyJavaResolverContext c2, @NotNull JavaPackage jPackage, @NotNull LazyJavaPackageFragment packageFragment) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        Intrinsics.checkNotNullParameter(packageFragment, "packageFragment");
        this.c = c2;
        this.packageFragment = packageFragment;
        this.javaScope = new LazyJavaPackageScope(this.c, jPackage, this.packageFragment);
        JvmPackageScope jvmPackageScope = this;
        this.kotlinScopes$delegate = this.c.getStorageManager().createLazyValue(new JvmPackageScope$$Lambda$0(jvmPackageScope));
    }

    @NotNull
    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[])StorageKt.getValue(this.kotlinScopes$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        ClassifierDescriptor classifierDescriptor;
        block3: {
            ClassDescriptor javaClassifier;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            this.recordLookup(name, location);
            ClassDescriptor classDescriptor = javaClassifier = this.javaScope.getContributedClassifier(name, location);
            if (classDescriptor != null) {
                return classDescriptor;
            }
            MemberScope[] scopes$iv = this.getKotlinScopes();
            boolean $i$f$getFirstClassifierDiscriminateHeaders = false;
            ClassifierDescriptor result$iv = null;
            int n2 = scopes$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                MemberScope scope$iv;
                MemberScope it = scope$iv = scopes$iv[i2];
                boolean bl2 = false;
                ClassifierDescriptor newResult$iv = it.getContributedClassifier(name, location);
                if (newResult$iv == null) continue;
                if (newResult$iv instanceof ClassifierDescriptorWithTypeParameters && ((MemberDescriptor)((Object)newResult$iv)).isExpect()) {
                    if (result$iv != null) continue;
                    result$iv = newResult$iv;
                    continue;
                }
                classifierDescriptor = newResult$iv;
                break block3;
            }
            classifierDescriptor = result$iv;
        }
        return classifierDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        void firstScope$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        this.recordLookup(name, location);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] restScopes$iv = this.getKotlinScopes();
        boolean $i$f$getFromAllScopes = false;
        MemberScope it = (MemberScope)firstScope$iv;
        boolean bl2 = false;
        Collection<? extends PropertyDescriptor> result$iv = it.getContributedVariables(name, location);
        int n2 = restScopes$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it2;
            MemberScope scope$iv;
            MemberScope memberScope = scope$iv = restScopes$iv[i2];
            Collection<? extends PropertyDescriptor> collection = result$iv;
            $i$a$-getFromAllScopes-JvmPackageScope$getContributedVariables$1 = false;
            result$iv = ScopeUtilsKt.concat(collection, it2.getContributedVariables(name, location));
        }
        Collection<? extends PropertyDescriptor> collection = result$iv;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        void firstScope$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        this.recordLookup(name, location);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] restScopes$iv = this.getKotlinScopes();
        boolean $i$f$getFromAllScopes = false;
        MemberScope it = (MemberScope)firstScope$iv;
        boolean bl2 = false;
        Collection<? extends SimpleFunctionDescriptor> result$iv = it.getContributedFunctions(name, location);
        int n2 = restScopes$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it2;
            MemberScope scope$iv;
            MemberScope memberScope = scope$iv = restScopes$iv[i2];
            Collection<? extends SimpleFunctionDescriptor> collection = result$iv;
            $i$a$-getFromAllScopes-JvmPackageScope$getContributedFunctions$1 = false;
            result$iv = ScopeUtilsKt.concat(collection, it2.getContributedFunctions(name, location));
        }
        Collection<? extends SimpleFunctionDescriptor> collection = result$iv;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        void firstScope$iv;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] restScopes$iv = this.getKotlinScopes();
        boolean $i$f$getFromAllScopes = false;
        MemberScope it = (MemberScope)firstScope$iv;
        boolean bl2 = false;
        Collection<DeclarationDescriptor> result$iv = it.getContributedDescriptors(kindFilter, nameFilter);
        int n2 = restScopes$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it2;
            MemberScope scope$iv;
            MemberScope memberScope = scope$iv = restScopes$iv[i2];
            Collection<DeclarationDescriptor> collection = result$iv;
            $i$a$-getFromAllScopes-JvmPackageScope$getContributedDescriptors$1 = false;
            result$iv = ScopeUtilsKt.concat(collection, it2.getContributedDescriptors(kindFilter, nameFilter));
        }
        Collection<DeclarationDescriptor> collection = result$iv;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        void $this$flatMapTo$iv;
        Object object = this.getKotlinScopes();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$flatMapTo = false;
        int n2 = ((void)$this$flatMapTo$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void element$iv;
            void it = element$iv = $this$flatMapTo$iv[i2];
            boolean bl2 = false;
            Iterable list$iv = it.getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        object = destination$iv;
        Set $this$getFunctionNames_u24lambda_u247 = (Set)object;
        boolean bl3 = false;
        $this$getFunctionNames_u24lambda_u247.addAll((Collection)this.javaScope.getFunctionNames());
        return (Set)object;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        void $this$flatMapTo$iv;
        Object object = this.getKotlinScopes();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$flatMapTo = false;
        int n2 = ((void)$this$flatMapTo$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void element$iv;
            void it = element$iv = $this$flatMapTo$iv[i2];
            boolean bl2 = false;
            Iterable list$iv = it.getVariableNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        object = destination$iv;
        Set $this$getVariableNames_u24lambda_u249 = (Set)object;
        boolean bl3 = false;
        $this$getVariableNames_u24lambda_u249.addAll((Collection)this.javaScope.getVariableNames());
        return (Set)object;
    }

    @Override
    @Nullable
    public Set<Name> getClassifierNames() {
        Set<Name> set;
        Set<Name> set2 = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.getKotlinScopes()));
        if (set2 != null) {
            Set<Name> set3;
            Set<Name> $this$getClassifierNames_u24lambda_u2410 = set3 = set2;
            boolean bl2 = false;
            $this$getClassifierNames_u24lambda_u2410.addAll((Collection<Name>)this.javaScope.getClassifierNames());
            set = set3;
        } else {
            set = null;
        }
        return set;
    }

    @Override
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        UtilsKt.record(this.c.getComponents().getLookupTracker(), location, this.packageFragment, name);
    }

    @NotNull
    public String toString() {
        return "scope for " + this.packageFragment;
    }

    /*
     * WARNING - void declaration
     */
    private static final MemberScope[] kotlinScopes_delegate$lambda$1(JvmPackageScope this$0) {
        void $this$mapNotNullTo$iv$iv;
        Iterable $this$mapNotNull$iv = this$0.packageFragment.getBinaryClasses$descriptors_jvm().values();
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            MemberScope it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            KotlinJvmBinaryClass partClass = (KotlinJvmBinaryClass)element$iv$iv;
            boolean bl3 = false;
            if (this$0.c.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(this$0.packageFragment, partClass) == null) continue;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        Collection $this$toTypedArray$iv = ScopeUtilsKt.listOfNonEmptyScopes((List)destination$iv$iv);
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        return thisCollection$iv.toArray(new MemberScope[0]);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(JvmPackageScope.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ MemberScope[] accessor$JvmPackageScope$lambda0(JvmPackageScope jvmPackageScope) {
        return JvmPackageScope.kotlinScopes_delegate$lambda$1(jvmPackageScope);
    }
}

