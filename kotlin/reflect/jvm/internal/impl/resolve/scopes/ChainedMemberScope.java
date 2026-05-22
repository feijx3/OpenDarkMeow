/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nChainedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope\n+ 2 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,91:1\n92#2,14:92\n47#2,11:106\n47#2,11:117\n47#2,11:128\n10557#3,5:139\n10557#3,5:144\n13472#3,2:149\n*S KotlinDebug\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope\n*L\n35#1:92,14\n38#1:106,11\n41#1:117,11\n44#1:128,11\n46#1:139,5\n47#1:144,5\n51#1:149,2\n*E\n"})
public final class ChainedMemberScope
implements MemberScope {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String debugName;
    @NotNull
    private final MemberScope[] scopes;

    private ChainedMemberScope(String debugName, MemberScope[] scopes) {
        this.debugName = debugName;
        this.scopes = scopes;
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        ClassifierDescriptor classifierDescriptor;
        block2: {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            MemberScope[] scopes$iv = this.scopes;
            boolean $i$f$getFirstClassifierDiscriminateHeaders = false;
            ClassifierDescriptor result$iv = null;
            int n2 = scopes$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                MemberScope scope$iv;
                MemberScope it = scope$iv = scopes$iv[i2];
                boolean bl2 = false;
                ClassifierDescriptor newResult$iv = ((ResolutionScope)it).getContributedClassifier(name, location);
                if (newResult$iv == null) continue;
                if (newResult$iv instanceof ClassifierDescriptorWithTypeParameters && ((MemberDescriptor)((Object)newResult$iv)).isExpect()) {
                    if (result$iv != null) continue;
                    result$iv = newResult$iv;
                    continue;
                }
                classifierDescriptor = newResult$iv;
                break block2;
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
        Collection collection;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        MemberScope[] scopes$iv = this.scopes;
        boolean $i$f$getFromAllScopes = false;
        switch (scopes$iv.length) {
            case 0: {
                collection = CollectionsKt.emptyList();
                break;
            }
            case 1: {
                MemberScope it = scopes$iv[0];
                boolean bl2 = false;
                collection = it.getContributedVariables(name, location);
                break;
            }
            default: {
                Collection result$iv = null;
                int n2 = scopes$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void it;
                    MemberScope scope$iv;
                    MemberScope memberScope = scope$iv = scopes$iv[i2];
                    Collection collection2 = result$iv;
                    boolean bl3 = false;
                    result$iv = ScopeUtilsKt.concat(collection2, it.getContributedVariables(name, location));
                }
                collection = result$iv;
                if (collection != null) break;
                collection = SetsKt.emptySet();
            }
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Collection collection;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        MemberScope[] scopes$iv = this.scopes;
        boolean $i$f$getFromAllScopes = false;
        switch (scopes$iv.length) {
            case 0: {
                collection = CollectionsKt.emptyList();
                break;
            }
            case 1: {
                MemberScope it = scopes$iv[0];
                boolean bl2 = false;
                collection = it.getContributedFunctions(name, location);
                break;
            }
            default: {
                Collection result$iv = null;
                int n2 = scopes$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void it;
                    MemberScope scope$iv;
                    MemberScope memberScope = scope$iv = scopes$iv[i2];
                    Collection collection2 = result$iv;
                    boolean bl3 = false;
                    result$iv = ScopeUtilsKt.concat(collection2, it.getContributedFunctions(name, location));
                }
                collection = result$iv;
                if (collection != null) break;
                collection = SetsKt.emptySet();
            }
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Collection collection;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        MemberScope[] scopes$iv = this.scopes;
        boolean $i$f$getFromAllScopes = false;
        switch (scopes$iv.length) {
            case 0: {
                collection = CollectionsKt.emptyList();
                break;
            }
            case 1: {
                MemberScope it = scopes$iv[0];
                boolean bl2 = false;
                collection = ((ResolutionScope)it).getContributedDescriptors(kindFilter, nameFilter);
                break;
            }
            default: {
                Collection result$iv = null;
                int n2 = scopes$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void it;
                    MemberScope scope$iv;
                    MemberScope memberScope = scope$iv = scopes$iv[i2];
                    Collection collection2 = result$iv;
                    boolean bl3 = false;
                    result$iv = ScopeUtilsKt.concat(collection2, ((ResolutionScope)it).getContributedDescriptors(kindFilter, nameFilter));
                }
                collection = result$iv;
                if (collection != null) break;
                collection = SetsKt.emptySet();
            }
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        void var2_2;
        void $this$flatMapTo$iv;
        MemberScope[] memberScopeArray = this.scopes;
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
        return (Set)var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        void var2_2;
        void $this$flatMapTo$iv;
        MemberScope[] memberScopeArray = this.scopes;
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
        return (Set)var2_2;
    }

    @Override
    @Nullable
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.scopes));
    }

    @Override
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        MemberScope[] $this$forEach$iv = this.scopes;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            MemberScope element$iv;
            MemberScope it = element$iv = $this$forEach$iv[i2];
            boolean bl2 = false;
            it.recordLookup(name, location);
        }
    }

    @NotNull
    public String toString() {
        return this.debugName;
    }

    public /* synthetic */ ChainedMemberScope(String debugName, MemberScope[] scopes, DefaultConstructorMarker $constructor_marker) {
        this(debugName, scopes);
    }

    @SourceDebugExtension(value={"SMAP\nChainedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,91:1\n37#2:92\n36#2,3:93\n*S KotlinDebug\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope$Companion\n*L\n87#1:92\n87#1:93,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MemberScope create(@NotNull String debugName, @NotNull Iterable<? extends MemberScope> scopes) {
            Intrinsics.checkNotNullParameter(debugName, "debugName");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            SmartList<MemberScope> flattenedNonEmptyScopes = new SmartList<MemberScope>();
            for (MemberScope memberScope : scopes) {
                if (memberScope == MemberScope.Empty.INSTANCE) continue;
                if (memberScope instanceof ChainedMemberScope) {
                    CollectionsKt.addAll((Collection)flattenedNonEmptyScopes, ((ChainedMemberScope)memberScope).scopes);
                    continue;
                }
                flattenedNonEmptyScopes.add(memberScope);
            }
            return this.createOrSingle$descriptors(debugName, (List<? extends MemberScope>)flattenedNonEmptyScopes);
        }

        @NotNull
        public final MemberScope createOrSingle$descriptors(@NotNull String debugName, @NotNull List<? extends MemberScope> scopes) {
            MemberScope memberScope;
            Intrinsics.checkNotNullParameter(debugName, "debugName");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            switch (scopes.size()) {
                case 0: {
                    memberScope = MemberScope.Empty.INSTANCE;
                    break;
                }
                case 1: {
                    memberScope = scopes.get(0);
                    break;
                }
                default: {
                    Collection $this$toTypedArray$iv = scopes;
                    boolean $i$f$toTypedArray = false;
                    Collection thisCollection$iv = $this$toTypedArray$iv;
                    memberScope = new ChainedMemberScope(debugName, thisCollection$iv.toArray(new MemberScope[0]), null);
                }
            }
            return memberScope;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

