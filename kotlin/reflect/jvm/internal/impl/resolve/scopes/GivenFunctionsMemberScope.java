/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nGivenFunctionsMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GivenFunctionsMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/GivenFunctionsMemberScope\n+ 2 CollectionUtil.kt\norg/jetbrains/kotlin/utils/CollectionUtilKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,91:1\n32#2,2:92\n9#2,6:94\n32#2,2:100\n9#2,6:102\n1374#3:108\n1460#3,5:109\n808#3,11:114\n1491#3:125\n1516#3,3:126\n1519#3,3:136\n1491#3:139\n1516#3,3:140\n1519#3,3:150\n774#3:153\n865#3,2:154\n382#4,7:129\n382#4,7:143\n*S KotlinDebug\n*F\n+ 1 GivenFunctionsMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/GivenFunctionsMemberScope\n*L\n51#1:92,2\n51#1:94,6\n55#1:100,2\n55#1:102,6\n61#1:108\n61#1:109,5\n62#1:114,11\n63#1:125\n63#1:126,3\n63#1:136,3\n64#1:139\n64#1:140,3\n64#1:150,3\n68#1:153\n68#1:154,2\n63#1:129,7\n64#1:143,7\n*E\n"})
public abstract class GivenFunctionsMemberScope
extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ClassDescriptor containingClass;
    @NotNull
    private final NotNullLazyValue allDescriptors$delegate;

    public GivenFunctionsMemberScope(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        this.containingClass = containingClass;
        GivenFunctionsMemberScope givenFunctionsMemberScope = this;
        this.allDescriptors$delegate = storageManager.createLazyValue(new GivenFunctionsMemberScope$$Lambda$0(givenFunctionsMemberScope));
    }

    @NotNull
    protected final ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    private final List<DeclarationDescriptor> getAllDescriptors() {
        return (List)StorageKt.getValue(this.allDescriptors$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    protected abstract List<FunctionDescriptor> computeDeclaredFunctions();

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask())) {
            return CollectionsKt.emptyList();
        }
        return this.getAllDescriptors();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        List list;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        Collection $this$filterIsInstanceAnd$iv = this.getAllDescriptors();
        boolean $i$f$filterIsInstanceAnd = false;
        if ($this$filterIsInstanceAnd$iv.isEmpty()) {
            list = CollectionsKt.emptyList();
        } else {
            void $this$filterIsInstanceAndTo$iv$iv;
            Iterable iterable = $this$filterIsInstanceAnd$iv;
            Collection destination$iv$iv = new SmartList();
            boolean $i$f$filterIsInstanceAndTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceAndTo$iv$iv) {
                if (!(element$iv$iv instanceof SimpleFunctionDescriptor)) continue;
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual(it.getName(), name)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list = (List)destination$iv$iv;
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        List list;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        Collection $this$filterIsInstanceAnd$iv = this.getAllDescriptors();
        boolean $i$f$filterIsInstanceAnd = false;
        if ($this$filterIsInstanceAnd$iv.isEmpty()) {
            list = CollectionsKt.emptyList();
        } else {
            void $this$filterIsInstanceAndTo$iv$iv;
            Iterable iterable = $this$filterIsInstanceAnd$iv;
            Collection destination$iv$iv = new SmartList();
            boolean $i$f$filterIsInstanceAndTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceAndTo$iv$iv) {
                if (!(element$iv$iv instanceof PropertyDescriptor)) continue;
                PropertyDescriptor it = (PropertyDescriptor)element$iv$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual(it.getName(), name)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list = (List)destination$iv$iv;
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    private final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> functionsFromCurrent) {
        Object key$iv$iv;
        void $this$groupByTo$iv$iv;
        void $this$filterIsInstanceTo$iv$iv;
        void $this$filterIsInstance$iv;
        void $this$flatMapTo$iv$iv;
        Iterable $this$flatMap$iv;
        ArrayList<DeclarationDescriptor> result = new ArrayList<DeclarationDescriptor>(3);
        Collection<KotlinType> collection = this.containingClass.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
        Iterable iterable = collection;
        boolean bl2 = false;
        void var6_9 = $this$flatMap$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            KotlinType it = (KotlinType)element$iv$iv;
            boolean bl22 = false;
            Iterable list$iv$iv = ResolutionScope.DefaultImpls.getContributedDescriptors$default(it.getMemberScope(), null, null, 3, null);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        $this$flatMap$iv = (List)destination$iv$iv;
        boolean entry = false;
        $this$flatMapTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof CallableMemberDescriptor)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List allSuperDescriptors = (List)destination$iv$iv;
        Iterable iterable2 = allSuperDescriptors;
        boolean $i$f$groupBy = false;
        destination$iv$iv = iterable2;
        Map destination$iv$iv2 = new LinkedHashMap();
        boolean $i$f$groupByTo = false;
        for (Object element$iv$iv : $this$groupByTo$iv$iv) {
            Object object;
            CallableMemberDescriptor it = (CallableMemberDescriptor)element$iv$iv;
            boolean bl3 = false;
            key$iv$iv = it.getName();
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv2;
            boolean $i$f$getOrPut = false;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                boolean bl4 = false;
                List answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object = answer$iv$iv$iv;
            } else {
                object = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object;
            list$iv$iv.add(element$iv$iv);
        }
        for (Map.Entry entry2 : destination$iv$iv2.entrySet()) {
            void $this$groupByTo$iv$iv2;
            Object element$iv$iv;
            Object k2 = entry2.getKey();
            Intrinsics.checkNotNullExpressionValue(k2, "component1(...)");
            Name name = (Name)k2;
            List group = (List)entry2.getValue();
            Iterable $this$groupBy$iv2 = group;
            boolean $i$f$groupBy2 = false;
            element$iv$iv = $this$groupBy$iv2;
            Object destination$iv$iv3 = new LinkedHashMap();
            boolean $i$f$groupByTo2 = false;
            for (Object element$iv$iv2 : $this$groupByTo$iv$iv2) {
                Object object;
                CallableMemberDescriptor it = (CallableMemberDescriptor)element$iv$iv2;
                boolean bl5 = false;
                Boolean key$iv$iv2 = it instanceof FunctionDescriptor;
                Map $this$getOrPut$iv$iv$iv = destination$iv$iv3;
                boolean $i$f$getOrPut = false;
                Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv2);
                if (value$iv$iv$iv == null) {
                    boolean bl6 = false;
                    List answer$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv.put(key$iv$iv2, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(element$iv$iv2);
            }
            for (Map.Entry entry3 : destination$iv$iv3.entrySet()) {
                List list;
                boolean isFunction = (Boolean)entry3.getKey();
                List descriptors = (List)entry3.getValue();
                OverridingUtil overridingUtil = OverridingUtil.DEFAULT;
                Name name2 = name;
                Collection collection2 = descriptors;
                if (isFunction) {
                    void $this$filterTo$iv$iv;
                    void $this$filter$iv;
                    destination$iv$iv3 = functionsFromCurrent;
                    Collection collection3 = collection2;
                    Name name3 = name2;
                    OverridingUtil overridingUtil2 = overridingUtil;
                    boolean $i$f$filter = false;
                    key$iv$iv = $this$filter$iv;
                    Collection destination$iv$iv4 = new ArrayList();
                    boolean $i$f$filterTo = false;
                    for (Object element$iv$iv3 : $this$filterTo$iv$iv) {
                        FunctionDescriptor it = (FunctionDescriptor)element$iv$iv3;
                        boolean bl7 = false;
                        if (!Intrinsics.areEqual(it.getName(), name)) continue;
                        destination$iv$iv4.add(element$iv$iv3);
                    }
                    List list2 = (List)destination$iv$iv4;
                    overridingUtil = overridingUtil2;
                    name2 = name3;
                    collection2 = collection3;
                    list = list2;
                } else {
                    list = CollectionsKt.emptyList();
                }
                overridingUtil.generateOverridesInFunctionGroup(name2, collection2, list, this.containingClass, new NonReportingOverrideStrategy(result, this){
                    final /* synthetic */ ArrayList<DeclarationDescriptor> $result;
                    final /* synthetic */ GivenFunctionsMemberScope this$0;
                    {
                        this.$result = $result;
                        this.this$0 = $receiver;
                    }

                    public void addFakeOverride(CallableMemberDescriptor fakeOverride) {
                        Intrinsics.checkNotNullParameter(fakeOverride, "fakeOverride");
                        OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                        this.$result.add(fakeOverride);
                    }

                    protected void conflict(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
                        Intrinsics.checkNotNullParameter(fromSuper, "fromSuper");
                        Intrinsics.checkNotNullParameter(fromCurrent, "fromCurrent");
                        throw new IllegalStateException(("Conflict in scope of " + this.this$0.getContainingClass() + ": " + fromSuper + " vs " + fromCurrent).toString());
                    }
                });
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(result);
    }

    private static final List allDescriptors_delegate$lambda$0(GivenFunctionsMemberScope this$0) {
        List<FunctionDescriptor> fromCurrent = this$0.computeDeclaredFunctions();
        return CollectionsKt.plus((Collection)fromCurrent, (Iterable)this$0.createFakeOverrides(fromCurrent));
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GivenFunctionsMemberScope.class, "allDescriptors", "getAllDescriptors()Ljava/util/List;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ List accessor$GivenFunctionsMemberScope$lambda0(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        return GivenFunctionsMemberScope.allDescriptors_delegate$lambda$0(givenFunctionsMemberScope);
    }
}

