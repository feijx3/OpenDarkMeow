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
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nStaticScopeForKotlinEnum.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticScopeForKotlinEnum.kt\norg/jetbrains/kotlin/resolve/scopes/StaticScopeForKotlinEnum\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1#2:69\n865#3,2:70\n865#3,2:72\n*S KotlinDebug\n*F\n+ 1 StaticScopeForKotlinEnum.kt\norg/jetbrains/kotlin/resolve/scopes/StaticScopeForKotlinEnum\n*L\n59#1:70,2\n62#1:72,2\n*E\n"})
public final class StaticScopeForKotlinEnum
extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ClassDescriptor containingClass;
    private final boolean enumEntriesCanBeUsed;
    @NotNull
    private final NotNullLazyValue functions$delegate;
    @NotNull
    private final NotNullLazyValue properties$delegate;

    public StaticScopeForKotlinEnum(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass, boolean enumEntriesCanBeUsed) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        this.containingClass = containingClass;
        this.enumEntriesCanBeUsed = enumEntriesCanBeUsed;
        boolean bl3 = bl2 = this.containingClass.getKind() == ClassKind.ENUM_CLASS;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Class should be an enum: " + this.containingClass;
            throw new AssertionError((Object)string);
        }
        StaticScopeForKotlinEnum staticScopeForKotlinEnum = this;
        this.functions$delegate = storageManager.createLazyValue(new StaticScopeForKotlinEnum$$Lambda$0(staticScopeForKotlinEnum));
        staticScopeForKotlinEnum = this;
        this.properties$delegate = storageManager.createLazyValue(new StaticScopeForKotlinEnum$$Lambda$1(staticScopeForKotlinEnum));
    }

    @Nullable
    public Void getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return null;
    }

    private final List<SimpleFunctionDescriptor> getFunctions() {
        return (List)StorageKt.getValue(this.functions$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private final List<PropertyDescriptor> getProperties() {
        return (List)StorageKt.getValue(this.properties$delegate, (Object)this, $$delegatedProperties[1]);
    }

    @NotNull
    public List<CallableMemberDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return CollectionsKt.plus((Collection)this.getFunctions(), (Iterable)this.getProperties());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        void $this$filterTo$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        Iterable iterable = this.getFunctions();
        Collection destination$iv = new SmartList();
        boolean $i$f$filterTo = false;
        for (Object element$iv : $this$filterTo$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
            boolean bl2 = false;
            if (!Intrinsics.areEqual(it.getName(), name)) continue;
            destination$iv.add(element$iv);
        }
        return (SmartList)destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        void $this$filterTo$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        Iterable iterable = this.getProperties();
        Collection destination$iv = new SmartList();
        boolean $i$f$filterTo = false;
        for (Object element$iv : $this$filterTo$iv) {
            PropertyDescriptor it = (PropertyDescriptor)element$iv;
            boolean bl2 = false;
            if (!Intrinsics.areEqual(it.getName(), name)) continue;
            destination$iv.add(element$iv);
        }
        return destination$iv;
    }

    private static final List functions_delegate$lambda$1(StaticScopeForKotlinEnum this$0) {
        SimpleFunctionDescriptor[] simpleFunctionDescriptorArray = new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(this$0.containingClass), DescriptorFactory.createEnumValuesMethod(this$0.containingClass)};
        return CollectionsKt.listOf(simpleFunctionDescriptorArray);
    }

    private static final List properties_delegate$lambda$2(StaticScopeForKotlinEnum this$0) {
        return this$0.enumEntriesCanBeUsed ? CollectionsKt.listOfNotNull(DescriptorFactory.createEnumEntriesProperty(this$0.containingClass)) : CollectionsKt.emptyList();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StaticScopeForKotlinEnum.class, "functions", "getFunctions()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(StaticScopeForKotlinEnum.class, "properties", "getProperties()Ljava/util/List;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ List accessor$StaticScopeForKotlinEnum$lambda0(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        return StaticScopeForKotlinEnum.functions_delegate$lambda$1(staticScopeForKotlinEnum);
    }

    static /* synthetic */ List accessor$StaticScopeForKotlinEnum$lambda1(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        return StaticScopeForKotlinEnum.properties_delegate$lambda$2(staticScopeForKotlinEnum);
    }
}

