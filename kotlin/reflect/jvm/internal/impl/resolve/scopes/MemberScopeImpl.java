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
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nMemberScopeImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScopeImpl.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeImpl\n+ 2 CollectionUtil.kt\norg/jetbrains/kotlin/utils/CollectionUtilKt\n*L\n1#1,56:1\n18#2,6:57\n18#2,6:63\n*S KotlinDebug\n*F\n+ 1 MemberScopeImpl.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeImpl\n*L\n44#1:57,6\n49#1:63,6\n*E\n"})
public abstract class MemberScopeImpl
implements MemberScope {
    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return null;
    }

    @Override
    @NotNull
    public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        void var2_2;
        void $this$filterIsInstanceMapTo$iv;
        Iterable iterable = this.getContributedDescriptors(DescriptorKindFilter.FUNCTIONS, FunctionsKt.alwaysTrue());
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterIsInstanceMapTo = false;
        for (Object element$iv : $this$filterIsInstanceMapTo$iv) {
            void it;
            if (!(element$iv instanceof SimpleFunctionDescriptor)) continue;
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)element$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            Name name = it.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            collection.add(name);
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
        void $this$filterIsInstanceMapTo$iv;
        Iterable iterable = this.getContributedDescriptors(DescriptorKindFilter.VARIABLES, FunctionsKt.alwaysTrue());
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterIsInstanceMapTo = false;
        for (Object element$iv : $this$filterIsInstanceMapTo$iv) {
            void it;
            if (!(element$iv instanceof SimpleFunctionDescriptor)) continue;
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)element$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            Name name = it.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            collection.add(name);
        }
        return (Set)var2_2;
    }

    @Override
    @Nullable
    public Set<Name> getClassifierNames() {
        return null;
    }

    @Override
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        MemberScope.DefaultImpls.recordLookup(this, name, location);
    }
}

