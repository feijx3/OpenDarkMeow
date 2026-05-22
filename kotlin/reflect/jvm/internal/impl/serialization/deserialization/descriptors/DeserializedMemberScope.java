/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Named;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$7;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$8;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$$Lambda$9;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DeserializedMemberScope
extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final DeserializationContext c;
    @NotNull
    private final Implementation impl;
    @NotNull
    private final NotNullLazyValue classNames$delegate;
    @NotNull
    private final NullableLazyValue classifierNamesLazy$delegate;

    protected DeserializedMemberScope(@NotNull DeserializationContext c2, @NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, @NotNull List<ProtoBuf.TypeAlias> typeAliasList, @NotNull Function0<? extends Collection<Name>> classNames) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(functionList, "functionList");
        Intrinsics.checkNotNullParameter(propertyList, "propertyList");
        Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
        Intrinsics.checkNotNullParameter(classNames, "classNames");
        this.c = c2;
        this.impl = this.createImplementation(functionList, propertyList, typeAliasList);
        Object object = classNames;
        this.classNames$delegate = this.c.getStorageManager().createLazyValue(new DeserializedMemberScope$$Lambda$0((Function0)object));
        object = this;
        this.classifierNamesLazy$delegate = this.c.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$$Lambda$1((DeserializedMemberScope)object));
    }

    @NotNull
    protected final DeserializationContext getC() {
        return this.c;
    }

    @NotNull
    public final Set<Name> getClassNames$deserialization() {
        return (Set)StorageKt.getValue(this.classNames$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set)StorageKt.getValue(this.classifierNamesLazy$delegate, (Object)this, $$delegatedProperties[1]);
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    @Override
    @Nullable
    public Set<Name> getClassifierNames() {
        return this.getClassifierNamesLazy();
    }

    protected boolean isDeclaredFunctionAvailable(@NotNull SimpleFunctionDescriptor function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return true;
    }

    protected void computeNonDeclaredFunctions(@NotNull Name name, @NotNull List<SimpleFunctionDescriptor> functions) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(functions, "functions");
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return this.impl.getContributedFunctions(name, location);
    }

    protected void computeNonDeclaredProperties(@NotNull Name name, @NotNull List<PropertyDescriptor> descriptors) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name name) {
        return this.impl.getTypeAliasByName(name);
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return this.impl.getContributedVariables(name, location);
    }

    @NotNull
    protected final Collection<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        Intrinsics.checkNotNullParameter(location, "location");
        ArrayList result = new ArrayList(0);
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            this.addEnumEntryDescriptors(result, nameFilter);
        }
        this.impl.addFunctionsAndPropertiesTo(result, kindFilter, nameFilter, location);
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name className : this.getClassNames$deserialization()) {
                if (!nameFilter.invoke(className).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, this.deserializeClass(className));
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name typeAliasName : this.impl.getTypeAliasNames()) {
                if (!nameFilter.invoke(typeAliasName).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, this.impl.getTypeAliasByName(typeAliasName));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(result);
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return this.hasClass(name) ? (ClassifierDescriptor)this.deserializeClass(name) : (this.impl.getTypeAliasNames().contains(name) ? (ClassifierDescriptor)this.getTypeAliasByName(name) : null);
    }

    private final ClassDescriptor deserializeClass(Name name) {
        return this.c.getComponents().deserializeClass(this.createClassId(name));
    }

    protected boolean hasClass(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.getClassNames$deserialization().contains(name);
    }

    @NotNull
    protected abstract ClassId createClassId(@NotNull Name var1);

    @NotNull
    protected abstract Set<Name> getNonDeclaredFunctionNames();

    @NotNull
    protected abstract Set<Name> getNonDeclaredVariableNames();

    @Nullable
    protected abstract Set<Name> getNonDeclaredClassifierNames();

    protected abstract void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> var1, @NotNull Function1<? super Name, Boolean> var2);

    private final Implementation createImplementation(List<ProtoBuf.Function> functionList, List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
        return this.c.getComponents().getConfiguration().getPreserveDeclarationsOrdering() ? (Implementation)new NoReorderImplementation(functionList, propertyList, typeAliasList) : (Implementation)new OptimizedImplementation(functionList, propertyList, typeAliasList);
    }

    private static final Set classNames_delegate$lambda$0(Function0 $classNames) {
        return CollectionsKt.toSet((Iterable)$classNames.invoke());
    }

    private static final Set classifierNamesLazy_delegate$lambda$1(DeserializedMemberScope this$0) {
        Set<Name> set = this$0.getNonDeclaredClassifierNames();
        if (set == null) {
            return null;
        }
        Set<Name> nonDeclaredNames = set;
        return SetsKt.plus(SetsKt.plus(this$0.getClassNames$deserialization(), (Iterable)this$0.impl.getTypeAliasNames()), (Iterable)nonDeclaredNames);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(DeserializedMemberScope.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(DeserializedMemberScope.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ Set accessor$DeserializedMemberScope$lambda0(Function0 function0) {
        return DeserializedMemberScope.classNames_delegate$lambda$0(function0);
    }

    static /* synthetic */ Set accessor$DeserializedMemberScope$lambda1(DeserializedMemberScope deserializedMemberScope) {
        return DeserializedMemberScope.classifierNamesLazy_delegate$lambda$1(deserializedMemberScope);
    }

    private static interface Implementation {
        @NotNull
        public Set<Name> getFunctionNames();

        @NotNull
        public Set<Name> getVariableNames();

        @NotNull
        public Set<Name> getTypeAliasNames();

        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name var1, @NotNull LookupLocation var2);

        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name var1, @NotNull LookupLocation var2);

        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull Name var1);

        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> var1, @NotNull DescriptorKindFilter var2, @NotNull Function1<? super Name, Boolean> var3, @NotNull LookupLocation var4);
    }

    @SourceDebugExtension(value={"SMAP\nDeserializedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$NoReorderImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,512:1\n502#1:513\n508#1:517\n508#1:532\n508#1:546\n492#1:572\n493#1,5:575\n492#1:580\n493#1,5:583\n502#1:644\n502#1:648\n1634#2,3:514\n1617#2,9:518\n1869#2:527\n1870#2:530\n1626#2:531\n1617#2,9:533\n1869#2:542\n1870#2:544\n1626#2:545\n1617#2,9:547\n1869#2:556\n1870#2:558\n1626#2:559\n1374#2:560\n1460#2,5:561\n1374#2:566\n1460#2,5:567\n865#2,2:573\n865#2,2:581\n865#2,2:588\n865#2,2:590\n865#2,2:592\n1634#2,3:594\n1617#2,9:597\n1869#2:606\n1870#2:608\n1626#2:609\n1208#2,2:610\n1236#2,4:612\n1491#2:616\n1516#2,3:617\n1519#2,3:627\n1491#2:630\n1516#2,3:631\n1519#2,3:641\n1634#2,3:645\n1634#2,3:649\n1#3:528\n1#3:529\n1#3:543\n1#3:557\n1#3:607\n382#4,7:620\n382#4,7:634\n*S KotlinDebug\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$NoReorderImplementation\n*L\n429#1:513\n432#1:517\n435#1:532\n438#1:546\n447#1:572\n447#1:575,5\n450#1:580\n450#1:583,5\n421#1:644\n425#1:648\n429#1:514,3\n432#1:518,9\n432#1:527\n432#1:530\n432#1:531\n435#1:533,9\n435#1:542\n435#1:544\n435#1:545\n438#1:547,9\n438#1:556\n438#1:558\n438#1:559\n441#1:560\n441#1:561,5\n444#1:566\n444#1:567,5\n447#1:573,2\n450#1:581,2\n473#1:588,2\n477#1:590,2\n492#1:592,2\n502#1:594,3\n508#1:597,9\n508#1:606\n508#1:608\n508#1:609\n412#1:610,2\n412#1:612,4\n415#1:616\n415#1:617,3\n415#1:627,3\n418#1:630\n418#1:631,3\n418#1:641,3\n421#1:645,3\n425#1:649,3\n432#1:529\n435#1:543\n438#1:557\n508#1:607\n415#1:620,7\n418#1:634,7\n*E\n"})
    private final class NoReorderImplementation
    implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final List<ProtoBuf.Function> functionList;
        @NotNull
        private final List<ProtoBuf.Property> propertyList;
        @NotNull
        private final List<ProtoBuf.TypeAlias> typeAliasList;
        @NotNull
        private final NotNullLazyValue declaredFunctions$delegate;
        @NotNull
        private final NotNullLazyValue declaredProperties$delegate;
        @NotNull
        private final NotNullLazyValue allTypeAliases$delegate;
        @NotNull
        private final NotNullLazyValue allFunctions$delegate;
        @NotNull
        private final NotNullLazyValue allProperties$delegate;
        @NotNull
        private final NotNullLazyValue typeAliasesByName$delegate;
        @NotNull
        private final NotNullLazyValue functionsByName$delegate;
        @NotNull
        private final NotNullLazyValue propertiesByName$delegate;
        @NotNull
        private final NotNullLazyValue functionNames$delegate;
        @NotNull
        private final NotNullLazyValue variableNames$delegate;

        public NoReorderImplementation(@NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            Intrinsics.checkNotNullParameter(functionList, "functionList");
            Intrinsics.checkNotNullParameter(propertyList, "propertyList");
            Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
            this.functionList = functionList;
            this.propertyList = propertyList;
            this.typeAliasList = DeserializedMemberScope.this.getC().getComponents().getConfiguration().getTypeAliasesAllowed() ? typeAliasList : CollectionsKt.emptyList();
            Object object = this;
            this.declaredFunctions$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$0((NoReorderImplementation)object));
            object = this;
            this.declaredProperties$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$1((NoReorderImplementation)object));
            object = this;
            this.allTypeAliases$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$2((NoReorderImplementation)object));
            object = this;
            this.allFunctions$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$3((NoReorderImplementation)object));
            object = this;
            this.allProperties$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$4((NoReorderImplementation)object));
            object = this;
            this.typeAliasesByName$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$5((NoReorderImplementation)object));
            object = this;
            this.functionsByName$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$6((NoReorderImplementation)object));
            object = this;
            this.propertiesByName$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$7((NoReorderImplementation)object));
            object = DeserializedMemberScope.this;
            NoReorderImplementation noReorderImplementation = this;
            this.functionNames$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$8(noReorderImplementation, (DeserializedMemberScope)object));
            object = DeserializedMemberScope.this;
            noReorderImplementation = this;
            this.variableNames$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$$Lambda$9(noReorderImplementation, (DeserializedMemberScope)object));
        }

        private final List<SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (List)StorageKt.getValue(this.declaredFunctions$delegate, (Object)this, $$delegatedProperties[0]);
        }

        private final List<PropertyDescriptor> getDeclaredProperties() {
            return (List)StorageKt.getValue(this.declaredProperties$delegate, (Object)this, $$delegatedProperties[1]);
        }

        private final List<TypeAliasDescriptor> getAllTypeAliases() {
            return (List)StorageKt.getValue(this.allTypeAliases$delegate, (Object)this, $$delegatedProperties[2]);
        }

        private final List<SimpleFunctionDescriptor> getAllFunctions() {
            return (List)StorageKt.getValue(this.allFunctions$delegate, (Object)this, $$delegatedProperties[3]);
        }

        private final List<PropertyDescriptor> getAllProperties() {
            return (List)StorageKt.getValue(this.allProperties$delegate, (Object)this, $$delegatedProperties[4]);
        }

        private final Map<Name, TypeAliasDescriptor> getTypeAliasesByName() {
            return (Map)StorageKt.getValue(this.typeAliasesByName$delegate, (Object)this, $$delegatedProperties[5]);
        }

        private final Map<Name, Collection<SimpleFunctionDescriptor>> getFunctionsByName() {
            return (Map)StorageKt.getValue(this.functionsByName$delegate, (Object)this, $$delegatedProperties[6]);
        }

        private final Map<Name, Collection<PropertyDescriptor>> getPropertiesByName() {
            return (Map)StorageKt.getValue(this.propertiesByName$delegate, (Object)this, $$delegatedProperties[7]);
        }

        @Override
        @NotNull
        public Set<Name> getFunctionNames() {
            return (Set)StorageKt.getValue(this.functionNames$delegate, (Object)this, $$delegatedProperties[8]);
        }

        @Override
        @NotNull
        public Set<Name> getVariableNames() {
            return (Set)StorageKt.getValue(this.variableNames$delegate, (Object)this, $$delegatedProperties[9]);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        public Set<Name> getTypeAliasNames() {
            void destination$iv$iv;
            void $this$mapTo$iv$iv;
            void this_$iv;
            NoReorderImplementation noReorderImplementation = this;
            List<ProtoBuf.TypeAlias> $this$mapToNames$iv = this.typeAliasList;
            boolean $i$f$mapToNames = false;
            Iterable iterable = $this$mapToNames$iv;
            Collection collection = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                void it$iv;
                MessageLite messageLite = (MessageLite)item$iv$iv;
                void var11_11 = destination$iv$iv;
                boolean bl2 = false;
                ProtoBuf.TypeAlias typeAlias = (ProtoBuf.TypeAlias)it$iv;
                NameResolver nameResolver = deserializedMemberScope.getC().getNameResolver();
                boolean bl3 = false;
                int n2 = it.getName();
                var11_11.add(NameResolverUtilKt.getName(nameResolver, n2));
            }
            return (Set)destination$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private final List<SimpleFunctionDescriptor> computeFunctions() {
            void $this$mapNotNullTo$iv$iv$iv;
            void $this$mapNotNull$iv$iv;
            void this_$iv;
            void $this$mapWithDeserializer$iv;
            NoReorderImplementation noReorderImplementation = this;
            List<ProtoBuf.Function> list = this.functionList;
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            boolean $i$f$mapWithDeserializer = false;
            Iterable iterable = (Iterable)$this$mapWithDeserializer$iv;
            DeserializedMemberScope deserializedMemberScope2 = this_$iv.DeserializedMemberScope.this;
            boolean $i$f$mapNotNull = false;
            void var8_8 = $this$mapNotNull$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv$iv = $this$mapNotNullTo$iv$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                MemberDescriptor it$iv$iv$iv;
                void it;
                SimpleFunctionDescriptor simpleFunctionDescriptor;
                Object element$iv$iv$iv$iv;
                Object element$iv$iv$iv = element$iv$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                MessageLite it$iv = (MessageLite)element$iv$iv$iv;
                boolean bl3 = false;
                ProtoBuf.Function function = (ProtoBuf.Function)it$iv;
                MemberDeserializer $this$computeFunctions_u24lambda_u2416 = deserializedMemberScope2.getC().getMemberDeserializer();
                boolean bl4 = false;
                SimpleFunctionDescriptor p0 = simpleFunctionDescriptor = $this$computeFunctions_u24lambda_u2416.loadFunction((ProtoBuf.Function)it);
                boolean bl5 = false;
                if ((MemberDescriptor)(deserializedMemberScope.isDeclaredFunctionAvailable(p0) ? simpleFunctionDescriptor : null) == null) continue;
                boolean bl6 = false;
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            return (List)destination$iv$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private final List<PropertyDescriptor> computeProperties() {
            void $this$mapNotNullTo$iv$iv$iv;
            void $this$mapNotNull$iv$iv;
            void this_$iv;
            NoReorderImplementation noReorderImplementation = this;
            List<ProtoBuf.Property> $this$mapWithDeserializer$iv = this.propertyList;
            boolean $i$f$mapWithDeserializer = false;
            Iterable iterable = $this$mapWithDeserializer$iv;
            DeserializedMemberScope deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
            boolean $i$f$mapNotNull = false;
            void var7_7 = $this$mapNotNull$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv$iv = $this$mapNotNullTo$iv$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                MemberDescriptor it$iv$iv$iv;
                void it;
                Object element$iv$iv$iv$iv;
                Object element$iv$iv$iv = element$iv$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                MessageLite it$iv = (MessageLite)element$iv$iv$iv;
                boolean bl3 = false;
                ProtoBuf.Property property = (ProtoBuf.Property)it$iv;
                MemberDeserializer $this$computeProperties_u24lambda_u2417 = deserializedMemberScope.getC().getMemberDeserializer();
                boolean bl4 = false;
                if ((MemberDescriptor)MemberDeserializer.loadProperty$default($this$computeProperties_u24lambda_u2417, (ProtoBuf.Property)it, false, 2, null) == null) continue;
                boolean bl5 = false;
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            return (List)destination$iv$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private final List<TypeAliasDescriptor> computeTypeAliases() {
            void $this$mapNotNullTo$iv$iv$iv;
            void $this$mapNotNull$iv$iv;
            void this_$iv;
            NoReorderImplementation noReorderImplementation = this;
            List<ProtoBuf.TypeAlias> $this$mapWithDeserializer$iv = this.typeAliasList;
            boolean $i$f$mapWithDeserializer = false;
            Iterable iterable = $this$mapWithDeserializer$iv;
            DeserializedMemberScope deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
            boolean $i$f$mapNotNull = false;
            void var7_7 = $this$mapNotNull$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv$iv = $this$mapNotNullTo$iv$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                MemberDescriptor it$iv$iv$iv;
                void it;
                Object element$iv$iv$iv$iv;
                Object element$iv$iv$iv = element$iv$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                MessageLite it$iv = (MessageLite)element$iv$iv$iv;
                boolean bl3 = false;
                ProtoBuf.TypeAlias typeAlias = (ProtoBuf.TypeAlias)it$iv;
                MemberDeserializer $this$computeTypeAliases_u24lambda_u2418 = deserializedMemberScope.getC().getMemberDeserializer();
                boolean bl4 = false;
                if ((MemberDescriptor)$this$computeTypeAliases_u24lambda_u2418.loadTypeAlias((ProtoBuf.TypeAlias)it) == null) continue;
                boolean bl5 = false;
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            return (List)destination$iv$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            void $this$flatMapTo$iv$iv;
            Iterable $this$flatMap$iv = DeserializedMemberScope.this.getNonDeclaredFunctionNames();
            boolean $i$f$flatMap = false;
            Iterable iterable = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                Name it = (Name)element$iv$iv;
                boolean bl2 = false;
                Iterable list$iv$iv = this.computeNonDeclaredFunctionsForName(it);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List)destination$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            void $this$flatMapTo$iv$iv;
            Iterable $this$flatMap$iv = DeserializedMemberScope.this.getNonDeclaredVariableNames();
            boolean $i$f$flatMap = false;
            Iterable iterable = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                Name it = (Name)element$iv$iv;
                boolean bl2 = false;
                Iterable list$iv$iv = this.computeNonDeclaredPropertiesForName(it);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List)destination$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name name) {
            void p1;
            void destination$iv$iv;
            void $this$filterTo$iv$iv;
            void declaredDescriptors$iv;
            NoReorderImplementation noReorderImplementation = this;
            List<SimpleFunctionDescriptor> list = this.getDeclaredFunctions();
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            boolean $i$f$computeNonDeclaredDescriptors = false;
            Iterable iterable = (Iterable)declaredDescriptors$iv;
            Collection collection = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                DeclarationDescriptor it$iv = (DeclarationDescriptor)element$iv$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual(((Named)it$iv).getName(), name)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List declaredDescriptorsWithSameName$iv = (List)destination$iv$iv;
            int nonDeclaredPropertiesStartIndex$iv = declaredDescriptorsWithSameName$iv.size();
            List list2 = declaredDescriptorsWithSameName$iv;
            Name p0 = name;
            boolean bl3 = false;
            deserializedMemberScope.computeNonDeclaredFunctions(p0, (List<SimpleFunctionDescriptor>)p1);
            return declaredDescriptorsWithSameName$iv.subList(nonDeclaredPropertiesStartIndex$iv, declaredDescriptorsWithSameName$iv.size());
        }

        /*
         * WARNING - void declaration
         */
        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name name) {
            void p1;
            void destination$iv$iv;
            void $this$filterTo$iv$iv;
            void declaredDescriptors$iv;
            NoReorderImplementation noReorderImplementation = this;
            List<PropertyDescriptor> list = this.getDeclaredProperties();
            DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
            boolean $i$f$computeNonDeclaredDescriptors = false;
            Iterable iterable = (Iterable)declaredDescriptors$iv;
            Collection collection = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                DeclarationDescriptor it$iv = (DeclarationDescriptor)element$iv$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual(((Named)it$iv).getName(), name)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List declaredDescriptorsWithSameName$iv = (List)destination$iv$iv;
            int nonDeclaredPropertiesStartIndex$iv = declaredDescriptorsWithSameName$iv.size();
            List list2 = declaredDescriptorsWithSameName$iv;
            Name p0 = name;
            boolean bl3 = false;
            deserializedMemberScope.computeNonDeclaredProperties(p0, (List<PropertyDescriptor>)p1);
            return declaredDescriptorsWithSameName$iv.subList(nonDeclaredPropertiesStartIndex$iv, declaredDescriptorsWithSameName$iv.size());
        }

        @Override
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            if (!this.getFunctionNames().contains(name)) {
                return CollectionsKt.emptyList();
            }
            Collection collection = this.getFunctionsByName().get(name);
            if (collection == null) {
                collection = CollectionsKt.emptyList();
            }
            return collection;
        }

        @Override
        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.getTypeAliasesByName().get(name);
        }

        @Override
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            if (!this.getVariableNames().contains(name)) {
                return CollectionsKt.emptyList();
            }
            Collection collection = this.getPropertiesByName().get(name);
            if (collection == null) {
                collection = CollectionsKt.emptyList();
            }
            return collection;
        }

        @Override
        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> result, @NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter, @NotNull LookupLocation location) {
            CallableMemberDescriptor it;
            boolean $i$f$filterTo;
            Iterable $this$filterTo$iv;
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            Intrinsics.checkNotNullParameter(location, "location");
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                $this$filterTo$iv = this.getAllProperties();
                $i$f$filterTo = false;
                for (Object element$iv : $this$filterTo$iv) {
                    it = (PropertyDescriptor)element$iv;
                    boolean bl2 = false;
                    Name name = it.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (!nameFilter.invoke(name).booleanValue()) continue;
                    result.add((DeclarationDescriptor)element$iv);
                }
            }
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                $this$filterTo$iv = this.getAllFunctions();
                $i$f$filterTo = false;
                for (Object element$iv : $this$filterTo$iv) {
                    it = (SimpleFunctionDescriptor)element$iv;
                    boolean bl3 = false;
                    Name name = it.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (!nameFilter.invoke(name).booleanValue()) continue;
                    result.add((DeclarationDescriptor)element$iv);
                }
            }
        }

        private static final List declaredFunctions_delegate$lambda$0(NoReorderImplementation this$0) {
            return this$0.computeFunctions();
        }

        private static final List declaredProperties_delegate$lambda$1(NoReorderImplementation this$0) {
            return this$0.computeProperties();
        }

        private static final List allTypeAliases_delegate$lambda$2(NoReorderImplementation this$0) {
            return this$0.computeTypeAliases();
        }

        private static final List allFunctions_delegate$lambda$3(NoReorderImplementation this$0) {
            return CollectionsKt.plus((Collection)this$0.getDeclaredFunctions(), (Iterable)this$0.computeAllNonDeclaredFunctions());
        }

        private static final List allProperties_delegate$lambda$4(NoReorderImplementation this$0) {
            return CollectionsKt.plus((Collection)this$0.getDeclaredProperties(), (Iterable)this$0.computeAllNonDeclaredProperties());
        }

        /*
         * WARNING - void declaration
         */
        private static final Map typeAliasesByName_delegate$lambda$6(NoReorderImplementation this$0) {
            void $this$associateByTo$iv$iv;
            Iterable $this$associateBy$iv = this$0.getAllTypeAliases();
            boolean $i$f$associateBy = false;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Iterable iterable = $this$associateBy$iv;
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateByTo = false;
            for (Object element$iv$iv : $this$associateByTo$iv$iv) {
                void it;
                TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor)element$iv$iv;
                Map map = destination$iv$iv;
                boolean bl2 = false;
                Name name = it.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                map.put(name, element$iv$iv);
            }
            return destination$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private static final Map functionsByName_delegate$lambda$8(NoReorderImplementation this$0) {
            void $this$groupByTo$iv$iv;
            Iterable $this$groupBy$iv = this$0.getAllFunctions();
            boolean $i$f$groupBy = false;
            Iterable iterable = $this$groupBy$iv;
            Map destination$iv$iv = new LinkedHashMap();
            boolean $i$f$groupByTo = false;
            for (Object element$iv$iv : $this$groupByTo$iv$iv) {
                Object object;
                Name key$iv$iv;
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                boolean bl2 = false;
                Intrinsics.checkNotNullExpressionValue(it.getName(), "getName(...)");
                Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
                boolean $i$f$getOrPut = false;
                Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    boolean bl3 = false;
                    List answer$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(element$iv$iv);
            }
            return destination$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private static final Map propertiesByName_delegate$lambda$10(NoReorderImplementation this$0) {
            void $this$groupByTo$iv$iv;
            Iterable $this$groupBy$iv = this$0.getAllProperties();
            boolean $i$f$groupBy = false;
            Iterable iterable = $this$groupBy$iv;
            Map destination$iv$iv = new LinkedHashMap();
            boolean $i$f$groupByTo = false;
            for (Object element$iv$iv : $this$groupByTo$iv$iv) {
                Object object;
                Name key$iv$iv;
                PropertyDescriptor it = (PropertyDescriptor)element$iv$iv;
                boolean bl2 = false;
                Intrinsics.checkNotNullExpressionValue(it.getName(), "getName(...)");
                Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
                boolean $i$f$getOrPut = false;
                Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    boolean bl3 = false;
                    List answer$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(element$iv$iv);
            }
            return destination$iv$iv;
        }

        /*
         * WARNING - void declaration
         */
        private static final Set functionNames_delegate$lambda$12(NoReorderImplementation this$0, DeserializedMemberScope this$1) {
            void destination$iv$iv;
            void $this$mapTo$iv$iv;
            void this_$iv;
            NoReorderImplementation noReorderImplementation = this$0;
            List<ProtoBuf.Function> $this$mapToNames$iv = this$0.functionList;
            boolean $i$f$mapToNames = false;
            Iterable iterable = $this$mapToNames$iv;
            Collection collection = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                void it$iv;
                MessageLite messageLite = (MessageLite)item$iv$iv;
                void var12_12 = destination$iv$iv;
                boolean bl2 = false;
                ProtoBuf.Function function = (ProtoBuf.Function)it$iv;
                NameResolver nameResolver = deserializedMemberScope.getC().getNameResolver();
                boolean bl3 = false;
                int n2 = it.getName();
                var12_12.add(NameResolverUtilKt.getName(nameResolver, n2));
            }
            return SetsKt.plus((Set)destination$iv$iv, (Iterable)this$1.getNonDeclaredFunctionNames());
        }

        /*
         * WARNING - void declaration
         */
        private static final Set variableNames_delegate$lambda$14(NoReorderImplementation this$0, DeserializedMemberScope this$1) {
            void destination$iv$iv;
            void $this$mapTo$iv$iv;
            void this_$iv;
            NoReorderImplementation noReorderImplementation = this$0;
            List<ProtoBuf.Property> $this$mapToNames$iv = this$0.propertyList;
            boolean $i$f$mapToNames = false;
            Iterable iterable = $this$mapToNames$iv;
            Collection collection = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                void it$iv;
                MessageLite messageLite = (MessageLite)item$iv$iv;
                void var12_12 = destination$iv$iv;
                boolean bl2 = false;
                ProtoBuf.Property property = (ProtoBuf.Property)it$iv;
                NameResolver nameResolver = deserializedMemberScope.getC().getNameResolver();
                boolean bl3 = false;
                int n2 = it.getName();
                var12_12.add(NameResolverUtilKt.getName(nameResolver, n2));
            }
            return SetsKt.plus((Set)destination$iv$iv, (Iterable)this$1.getNonDeclaredVariableNames());
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "declaredProperties", "getDeclaredProperties()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "allTypeAliases", "getAllTypeAliases()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "allFunctions", "getAllFunctions()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "allProperties", "getAllProperties()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "functionsByName", "getFunctionsByName()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "propertiesByName", "getPropertiesByName()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(NoReorderImplementation.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};
            $$delegatedProperties = kPropertyArray;
        }

        static /* synthetic */ List accessor$DeserializedMemberScope$NoReorderImplementation$lambda0(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.declaredFunctions_delegate$lambda$0(noReorderImplementation);
        }

        static /* synthetic */ List accessor$DeserializedMemberScope$NoReorderImplementation$lambda1(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.declaredProperties_delegate$lambda$1(noReorderImplementation);
        }

        static /* synthetic */ List accessor$DeserializedMemberScope$NoReorderImplementation$lambda2(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.allTypeAliases_delegate$lambda$2(noReorderImplementation);
        }

        static /* synthetic */ List accessor$DeserializedMemberScope$NoReorderImplementation$lambda3(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.allFunctions_delegate$lambda$3(noReorderImplementation);
        }

        static /* synthetic */ List accessor$DeserializedMemberScope$NoReorderImplementation$lambda4(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.allProperties_delegate$lambda$4(noReorderImplementation);
        }

        static /* synthetic */ Map accessor$DeserializedMemberScope$NoReorderImplementation$lambda5(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.typeAliasesByName_delegate$lambda$6(noReorderImplementation);
        }

        static /* synthetic */ Map accessor$DeserializedMemberScope$NoReorderImplementation$lambda6(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.functionsByName_delegate$lambda$8(noReorderImplementation);
        }

        static /* synthetic */ Map accessor$DeserializedMemberScope$NoReorderImplementation$lambda7(NoReorderImplementation noReorderImplementation) {
            return NoReorderImplementation.propertiesByName_delegate$lambda$10(noReorderImplementation);
        }

        static /* synthetic */ Set accessor$DeserializedMemberScope$NoReorderImplementation$lambda8(NoReorderImplementation noReorderImplementation, DeserializedMemberScope deserializedMemberScope) {
            return NoReorderImplementation.functionNames_delegate$lambda$12(noReorderImplementation, deserializedMemberScope);
        }

        static /* synthetic */ Set accessor$DeserializedMemberScope$NoReorderImplementation$lambda9(NoReorderImplementation noReorderImplementation, DeserializedMemberScope deserializedMemberScope) {
            return NoReorderImplementation.variableNames_delegate$lambda$14(noReorderImplementation, deserializedMemberScope);
        }
    }

    @SourceDebugExtension(value={"SMAP\nDeserializedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$OptimizedImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,512:1\n269#1:513\n269#1:528\n269#1:543\n287#1,17:581\n305#1,2:604\n296#1:606\n303#1:607\n305#1,2:613\n287#1,17:620\n305#1,2:642\n296#1:644\n370#1,11:645\n370#1,11:656\n1491#2:514\n1516#2,3:515\n1519#2,3:525\n1491#2:529\n1516#2,3:530\n1519#2,3:540\n1491#2:544\n1516#2,3:545\n1519#2,3:555\n1252#2,2:560\n1563#2:562\n1634#2,3:563\n1255#2:566\n1491#2:567\n1516#2,3:568\n1519#2,3:578\n1625#2:598\n1869#2:599\n1870#2:602\n1626#2:603\n1625#2:608\n1869#2:609\n1870#2:611\n1626#2:612\n1625#2:615\n1869#2:616\n1870#2:618\n1626#2:619\n1625#2:637\n1869#2:638\n1870#2:640\n1626#2:641\n382#3,7:518\n382#3,7:533\n382#3,7:548\n463#3:558\n413#3:559\n382#3,7:571\n1#4:600\n1#4:601\n1#4:610\n1#4:617\n1#4:639\n*S KotlinDebug\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$OptimizedImplementation\n*L\n233#1:513\n235#1:528\n239#1:543\n272#1:581,17\n272#1:604,2\n272#1:606\n287#1:607\n287#1:613,2\n310#1:620,17\n310#1:642,2\n310#1:644\n348#1:645,11\n356#1:656,11\n233#1:514\n233#1:515,3\n233#1:525,3\n235#1:529\n235#1:530,3\n235#1:540,3\n239#1:544\n239#1:545,3\n239#1:555,3\n244#1:560,2\n246#1:562\n246#1:563,3\n244#1:566\n269#1:567\n269#1:568,3\n269#1:578,3\n272#1:598\n272#1:599\n272#1:602\n272#1:603\n287#1:608\n287#1:609\n287#1:611\n287#1:612\n303#1:615\n303#1:616\n303#1:618\n303#1:619\n310#1:637\n310#1:638\n310#1:640\n310#1:641\n233#1:518,7\n235#1:533,7\n239#1:548,7\n244#1:558\n244#1:559\n269#1:571,7\n272#1:601\n287#1:610\n303#1:617\n310#1:639\n*E\n"})
    private final class OptimizedImplementation
    implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final Map<Name, byte[]> functionProtosBytes;
        @NotNull
        private final Map<Name, byte[]> propertyProtosBytes;
        @NotNull
        private final Map<Name, byte[]> typeAliasBytes;
        @NotNull
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        @NotNull
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        @NotNull
        private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        @NotNull
        private final NotNullLazyValue functionNames$delegate;
        @NotNull
        private final NotNullLazyValue variableNames$delegate;

        /*
         * WARNING - void declaration
         */
        public OptimizedImplementation(@NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            Map<Object, Object> map;
            Object list$iv$iv$iv;
            List answer$iv$iv$iv$iv;
            Object value$iv$iv$iv$iv;
            boolean $i$f$getOrPut;
            Map $this$getOrPut$iv$iv$iv$iv;
            Name key$iv$iv$iv;
            int n2;
            void it;
            Object object;
            boolean bl2;
            MessageLite it$iv;
            Iterable $this$groupByTo$iv$iv$iv;
            Iterable $this$groupBy$iv$iv;
            OptimizedImplementation this_$iv;
            Collection $this$groupByName$iv;
            Intrinsics.checkNotNullParameter(functionList, "functionList");
            Intrinsics.checkNotNullParameter(propertyList, "propertyList");
            Intrinsics.checkNotNullParameter(typeAliasList, "typeAliasList");
            OptimizedImplementation optimizedImplementation = this;
            Collection collection = functionList;
            OptimizedImplementation optimizedImplementation2 = this;
            OptimizedImplementation optimizedImplementation3 = this;
            boolean $i$f$groupByName = false;
            Iterable iterable = $this$groupByName$iv;
            DeserializedMemberScope deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
            boolean $i$f$groupBy = false;
            void var11_13 = $this$groupBy$iv$iv;
            Map destination$iv$iv$iv = new LinkedHashMap();
            boolean $i$f$groupByTo = false;
            for (Object element$iv$iv$iv : $this$groupByTo$iv$iv$iv) {
                Object object2;
                it$iv = (MessageLite)element$iv$iv$iv;
                bl2 = false;
                ProtoBuf.Function function = (ProtoBuf.Function)it$iv;
                object = deserializedMemberScope.getC().getNameResolver();
                boolean bl3 = false;
                n2 = it.getName();
                key$iv$iv$iv = NameResolverUtilKt.getName((NameResolver)object, n2);
                $this$getOrPut$iv$iv$iv$iv = destination$iv$iv$iv;
                $i$f$getOrPut = false;
                value$iv$iv$iv$iv = $this$getOrPut$iv$iv$iv$iv.get(key$iv$iv$iv);
                if (value$iv$iv$iv$iv == null) {
                    boolean bl4 = false;
                    answer$iv$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv$iv.put(key$iv$iv$iv, answer$iv$iv$iv$iv);
                    object2 = answer$iv$iv$iv$iv;
                } else {
                    object2 = value$iv$iv$iv$iv;
                }
                list$iv$iv$iv = (List)object2;
                list$iv$iv$iv.add(element$iv$iv$iv);
            }
            object = destination$iv$iv$iv;
            optimizedImplementation3.functionProtosBytes = optimizedImplementation2.packToByteArray((Map<Name, ? extends Collection<? extends AbstractMessageLite>>)object);
            this_$iv = this;
            $this$groupByName$iv = propertyList;
            optimizedImplementation2 = this;
            optimizedImplementation3 = this;
            $i$f$groupByName = false;
            $this$groupBy$iv$iv = $this$groupByName$iv;
            deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
            $i$f$groupBy = false;
            $this$groupByTo$iv$iv$iv = $this$groupBy$iv$iv;
            destination$iv$iv$iv = new LinkedHashMap();
            $i$f$groupByTo = false;
            for (Object element$iv$iv$iv : $this$groupByTo$iv$iv$iv) {
                Object object3;
                it$iv = (MessageLite)element$iv$iv$iv;
                bl2 = false;
                list$iv$iv$iv = (ProtoBuf.Property)it$iv;
                object = deserializedMemberScope.getC().getNameResolver();
                boolean bl5 = false;
                n2 = it.getName();
                key$iv$iv$iv = NameResolverUtilKt.getName((NameResolver)object, n2);
                $this$getOrPut$iv$iv$iv$iv = destination$iv$iv$iv;
                $i$f$getOrPut = false;
                value$iv$iv$iv$iv = $this$getOrPut$iv$iv$iv$iv.get(key$iv$iv$iv);
                if (value$iv$iv$iv$iv == null) {
                    boolean bl6 = false;
                    answer$iv$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv$iv.put(key$iv$iv$iv, answer$iv$iv$iv$iv);
                    object3 = answer$iv$iv$iv$iv;
                } else {
                    object3 = value$iv$iv$iv$iv;
                }
                list$iv$iv$iv = (List)object3;
                list$iv$iv$iv.add(element$iv$iv$iv);
            }
            object = destination$iv$iv$iv;
            optimizedImplementation3.propertyProtosBytes = optimizedImplementation2.packToByteArray((Map<Name, ? extends Collection<? extends AbstractMessageLite>>)object);
            OptimizedImplementation optimizedImplementation4 = this;
            if (DeserializedMemberScope.this.getC().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                this_$iv = this;
                $this$groupByName$iv = typeAliasList;
                optimizedImplementation2 = this;
                optimizedImplementation3 = optimizedImplementation4;
                $i$f$groupByName = false;
                $this$groupBy$iv$iv = $this$groupByName$iv;
                deserializedMemberScope = this_$iv.DeserializedMemberScope.this;
                $i$f$groupBy = false;
                $this$groupByTo$iv$iv$iv = $this$groupBy$iv$iv;
                destination$iv$iv$iv = new LinkedHashMap();
                $i$f$groupByTo = false;
                for (Object element$iv$iv$iv : $this$groupByTo$iv$iv$iv) {
                    Object object4;
                    it$iv = (MessageLite)element$iv$iv$iv;
                    bl2 = false;
                    list$iv$iv$iv = (ProtoBuf.TypeAlias)it$iv;
                    object = deserializedMemberScope.getC().getNameResolver();
                    boolean bl7 = false;
                    n2 = it.getName();
                    key$iv$iv$iv = NameResolverUtilKt.getName((NameResolver)object, n2);
                    $this$getOrPut$iv$iv$iv$iv = destination$iv$iv$iv;
                    $i$f$getOrPut = false;
                    value$iv$iv$iv$iv = $this$getOrPut$iv$iv$iv$iv.get(key$iv$iv$iv);
                    if (value$iv$iv$iv$iv == null) {
                        boolean bl8 = false;
                        answer$iv$iv$iv$iv = new ArrayList();
                        $this$getOrPut$iv$iv$iv$iv.put(key$iv$iv$iv, answer$iv$iv$iv$iv);
                        object4 = answer$iv$iv$iv$iv;
                    } else {
                        object4 = value$iv$iv$iv$iv;
                    }
                    list$iv$iv$iv = (List)object4;
                    list$iv$iv$iv.add(element$iv$iv$iv);
                }
                object = destination$iv$iv$iv;
                optimizedImplementation4 = optimizedImplementation3;
                map = optimizedImplementation2.packToByteArray((Map<Name, ? extends Collection<? extends AbstractMessageLite>>)object);
            } else {
                map = MapsKt.emptyMap();
            }
            optimizedImplementation4.typeAliasBytes = map;
            Object object5 = this;
            this.functions = DeserializedMemberScope.this.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$$Lambda$0((OptimizedImplementation)object5));
            object5 = this;
            this.properties = DeserializedMemberScope.this.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$$Lambda$1((OptimizedImplementation)object5));
            object5 = this;
            this.typeAliasByName = DeserializedMemberScope.this.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$$Lambda$2((OptimizedImplementation)object5));
            object5 = DeserializedMemberScope.this;
            OptimizedImplementation optimizedImplementation5 = this;
            this.functionNames$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$$Lambda$3(optimizedImplementation5, (DeserializedMemberScope)object5));
            object5 = DeserializedMemberScope.this;
            optimizedImplementation5 = this;
            this.variableNames$delegate = DeserializedMemberScope.this.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$$Lambda$4(optimizedImplementation5, (DeserializedMemberScope)object5));
        }

        /*
         * WARNING - void declaration
         */
        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> $this$packToByteArray) {
            void $this$mapValuesTo$iv$iv;
            Map<Name, ? extends Collection<? extends AbstractMessageLite>> $this$mapValues$iv = $this$packToByteArray;
            boolean $i$f$mapValues = false;
            Map<Name, ? extends Collection<? extends AbstractMessageLite>> map = $this$mapValues$iv;
            Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
            boolean $i$f$mapValuesTo = false;
            Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
            boolean $i$f$associateByTo = false;
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                void $this$mapTo$iv$iv;
                void entry;
                void it$iv$iv;
                Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
                Map map2 = destination$iv$iv;
                boolean bl2 = false;
                Map.Entry entry3 = (Map.Entry)element$iv$iv$iv;
                Object k2 = it$iv$iv.getKey();
                Map map3 = map2;
                boolean bl3 = false;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable $this$map$iv = (Iterable)entry.getValue();
                boolean $i$f$map = false;
                Iterable iterable = $this$map$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void proto;
                    AbstractMessageLite abstractMessageLite = (AbstractMessageLite)item$iv$iv;
                    Collection collection = destination$iv$iv2;
                    boolean bl4 = false;
                    proto.writeDelimitedTo(byteArrayOutputStream);
                    collection.add(Unit.INSTANCE);
                }
                List cfr_ignored_0 = (List)destination$iv$iv2;
                byte[] byArray = byteArrayOutputStream.toByteArray();
                map3.put(k2, byArray);
            }
            return destination$iv$iv;
        }

        @Override
        @NotNull
        public Set<Name> getFunctionNames() {
            return (Set)StorageKt.getValue(this.functionNames$delegate, (Object)this, $$delegatedProperties[0]);
        }

        @Override
        @NotNull
        public Set<Name> getVariableNames() {
            return (Set)StorageKt.getValue(this.variableNames$delegate, (Object)this, $$delegatedProperties[1]);
        }

        @Override
        @NotNull
        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        private final Collection<SimpleFunctionDescriptor> computeFunctions(Name name) {
            var2_2 = this;
            var3_3 = this.functionProtosBytes;
            v0 = ProtoBuf.Function.PARSER;
            Intrinsics.checkNotNullExpressionValue(v0, "PARSER");
            var4_4 = v0;
            var5_5 = DeserializedMemberScope.this;
            var6_6 = DeserializedMemberScope.this;
            $i$f$computeDescriptors = false;
            var8_8 = this_$iv;
            v1 /* !! */  = (byte[])bytesByName$iv.get(name);
            if (v1 /* !! */  == null) ** GOTO lbl-1000
            var9_9 /* !! */  = v1 /* !! */ ;
            var10_10 = this_$iv.DeserializedMemberScope.this;
            it$iv = var9_9 /* !! */ ;
            $i$a$-let-DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$iv = false;
            inputStream$iv = new ByteArrayInputStream(it$iv);
            v2 = SequencesKt.toList(SequencesKt.generateSequence((Function0)new Function0<M>(parser$iv, inputStream$iv, var10_10){
                final /* synthetic */ Parser<M> $parser;
                final /* synthetic */ ByteArrayInputStream $inputStream;
                final /* synthetic */ DeserializedMemberScope this$0;
                {
                    this.$parser = $parser;
                    this.$inputStream = $inputStream;
                    this.this$0 = $receiver;
                }

                public final M invoke() {
                    return (M)((MessageLite)this.$parser.parseDelimitedFrom(this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite()));
                }
            }));
            v1 /* !! */  = (byte[])v2;
            if (v2 != null) {
                v3 = (Collection)v1 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                v3 = CollectionsKt.emptyList();
            }
            var14_17 = v3;
            $i$f$computeDescriptors = false;
            var9_9 /* !! */  = (byte[])((Iterable)protos$iv$iv);
            destination$iv$iv$iv = new ArrayList<E>(protos$iv$iv.size());
            $i$f$mapNotNullTo = false;
            $this$forEach$iv$iv$iv$iv = $this$mapNotNullTo$iv$iv$iv;
            $i$f$forEach = false;
            var16_19 = $this$forEach$iv$iv$iv$iv.iterator();
            while (var16_19.hasNext()) {
                element$iv$iv$iv = element$iv$iv$iv$iv = var16_19.next();
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv$iv = false;
                it = (ProtoBuf.Function)element$iv$iv$iv;
                $i$a$-computeDescriptors-DeserializedMemberScope$OptimizedImplementation$computeFunctions$1 = false;
                v4 = var5_5.getC().getMemberDeserializer();
                Intrinsics.checkNotNull(it);
                p0 = var22_25 = v4.loadFunction((ProtoBuf.Function)it);
                $i$a$-takeIf-DeserializedMemberScope$OptimizedImplementation$computeFunctions$1$1 = false;
                if ((var5_5.isDeclaredFunctionAvailable(p0) ? var22_25 : null) == null) continue;
                it$iv$iv$iv = it$iv$iv$iv;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = false;
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            descriptors$iv$iv = (ArrayList)destination$iv$iv$iv;
            it = descriptors$iv$iv;
            $i$a$-computeDescriptors-DeserializedMemberScope$OptimizedImplementation$computeFunctions$2 = false;
            var6_6.computeNonDeclaredFunctions(name, (List<SimpleFunctionDescriptor>)it);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(descriptors$iv$iv);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        private final Collection<PropertyDescriptor> computeProperties(Name name) {
            var2_2 = this;
            var3_3 = this.propertyProtosBytes;
            v0 = ProtoBuf.Property.PARSER;
            Intrinsics.checkNotNullExpressionValue(v0, "PARSER");
            var4_4 = v0;
            var5_5 = DeserializedMemberScope.this;
            var6_6 = DeserializedMemberScope.this;
            $i$f$computeDescriptors = false;
            var8_8 = this_$iv;
            v1 /* !! */  = (byte[])bytesByName$iv.get(name);
            if (v1 /* !! */  == null) ** GOTO lbl-1000
            var9_9 /* !! */  = v1 /* !! */ ;
            var10_10 = this_$iv.DeserializedMemberScope.this;
            it$iv = var9_9 /* !! */ ;
            $i$a$-let-DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$iv = false;
            inputStream$iv = new ByteArrayInputStream(it$iv);
            v2 = SequencesKt.toList(SequencesKt.generateSequence((Function0)new /* invalid duplicate definition of identical inner class */));
            v1 /* !! */  = (byte[])v2;
            if (v2 != null) {
                v3 = (Collection)v1 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                v3 = CollectionsKt.emptyList();
            }
            var14_17 = v3;
            $i$f$computeDescriptors = false;
            var9_9 /* !! */  = (byte[])((Iterable)protos$iv$iv);
            destination$iv$iv$iv = new ArrayList<E>(protos$iv$iv.size());
            $i$f$mapNotNullTo = false;
            $this$forEach$iv$iv$iv$iv = $this$mapNotNullTo$iv$iv$iv;
            $i$f$forEach = false;
            var16_19 = $this$forEach$iv$iv$iv$iv.iterator();
            while (var16_19.hasNext()) {
                element$iv$iv$iv = element$iv$iv$iv$iv = var16_19.next();
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv$iv = false;
                it = (ProtoBuf.Property)element$iv$iv$iv;
                $i$a$-computeDescriptors-DeserializedMemberScope$OptimizedImplementation$computeProperties$1 = false;
                v4 = var5_5.getC().getMemberDeserializer();
                Intrinsics.checkNotNull(it);
                if (MemberDeserializer.loadProperty$default(v4, (ProtoBuf.Property)it, false, 2, null) == null) continue;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv$iv = false;
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            descriptors$iv$iv = (ArrayList)destination$iv$iv$iv;
            it = descriptors$iv$iv;
            $i$a$-computeDescriptors-DeserializedMemberScope$OptimizedImplementation$computeProperties$2 = false;
            var6_6.computeNonDeclaredProperties(name, (List<PropertyDescriptor>)it);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(descriptors$iv$iv);
        }

        private final TypeAliasDescriptor createTypeAlias(Name name) {
            byte[] byArray = this.typeAliasBytes.get(name);
            if (byArray == null) {
                return null;
            }
            byte[] byteArray = byArray;
            ProtoBuf.TypeAlias typeAlias = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(byteArray), DeserializedMemberScope.this.getC().getComponents().getExtensionRegistryLite());
            if (typeAlias == null) {
                return null;
            }
            ProtoBuf.TypeAlias proto = typeAlias;
            return DeserializedMemberScope.this.getC().getMemberDeserializer().loadTypeAlias(proto);
        }

        @Override
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            if (!this.getFunctionNames().contains(name)) {
                return CollectionsKt.emptyList();
            }
            return (Collection)this.functions.invoke(name);
        }

        @Override
        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (TypeAliasDescriptor)this.typeAliasByName.invoke(name);
        }

        @Override
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            if (!this.getVariableNames().contains(name)) {
                return CollectionsKt.emptyList();
            }
            return (Collection)this.properties.invoke(name);
        }

        @Override
        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> result, @NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter, @NotNull LookupLocation location) {
            Name it;
            ArrayList<CallableMemberDescriptor> arrayList;
            Collection names$iv;
            ArrayList<CallableMemberDescriptor> subResult$iv;
            boolean $i$f$addMembers;
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            Intrinsics.checkNotNullParameter(location, "location");
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                OptimizedImplementation optimizedImplementation = this;
                Collection collection = this.getVariableNames();
                $i$f$addMembers = false;
                subResult$iv = new ArrayList<CallableMemberDescriptor>();
                for (Name name$iv : names$iv) {
                    if (!nameFilter.invoke(name$iv).booleanValue()) continue;
                    Name name = name$iv;
                    arrayList = subResult$iv;
                    boolean bl2 = false;
                    arrayList.addAll(this.getContributedVariables(it, location));
                }
                List list = subResult$iv;
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator, "INSTANCE");
                CollectionsKt.sortWith(list, nameAndTypeMemberComparator);
                result.addAll((Collection<DeclarationDescriptor>)subResult$iv);
            }
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                OptimizedImplementation this_$iv = this;
                names$iv = this.getFunctionNames();
                $i$f$addMembers = false;
                subResult$iv = new ArrayList();
                for (Name name$iv : names$iv) {
                    if (!nameFilter.invoke(name$iv).booleanValue()) continue;
                    it = name$iv;
                    arrayList = subResult$iv;
                    boolean bl3 = false;
                    arrayList.addAll(this.getContributedFunctions(it, location));
                }
                List list = subResult$iv;
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator, "INSTANCE");
                CollectionsKt.sortWith(list, nameAndTypeMemberComparator);
                result.addAll((Collection<DeclarationDescriptor>)subResult$iv);
            }
        }

        private static final Collection functions$lambda$5(OptimizedImplementation this$0, Name it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.computeFunctions(it);
        }

        private static final Collection properties$lambda$6(OptimizedImplementation this$0, Name it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.computeProperties(it);
        }

        private static final TypeAliasDescriptor typeAliasByName$lambda$7(OptimizedImplementation this$0, Name it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.createTypeAlias(it);
        }

        private static final Set functionNames_delegate$lambda$8(OptimizedImplementation this$0, DeserializedMemberScope this$1) {
            return SetsKt.plus(this$0.functionProtosBytes.keySet(), (Iterable)this$1.getNonDeclaredFunctionNames());
        }

        private static final Set variableNames_delegate$lambda$9(OptimizedImplementation this$0, DeserializedMemberScope this$1) {
            return SetsKt.plus(this$0.propertyProtosBytes.keySet(), (Iterable)this$1.getNonDeclaredVariableNames());
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(OptimizedImplementation.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(OptimizedImplementation.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};
            $$delegatedProperties = kPropertyArray;
        }

        static /* synthetic */ Collection accessor$DeserializedMemberScope$OptimizedImplementation$lambda0(OptimizedImplementation optimizedImplementation, Name name) {
            return OptimizedImplementation.functions$lambda$5(optimizedImplementation, name);
        }

        static /* synthetic */ Collection accessor$DeserializedMemberScope$OptimizedImplementation$lambda1(OptimizedImplementation optimizedImplementation, Name name) {
            return OptimizedImplementation.properties$lambda$6(optimizedImplementation, name);
        }

        static /* synthetic */ TypeAliasDescriptor accessor$DeserializedMemberScope$OptimizedImplementation$lambda2(OptimizedImplementation optimizedImplementation, Name name) {
            return OptimizedImplementation.typeAliasByName$lambda$7(optimizedImplementation, name);
        }

        static /* synthetic */ Set accessor$DeserializedMemberScope$OptimizedImplementation$lambda3(OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
            return OptimizedImplementation.functionNames_delegate$lambda$8(optimizedImplementation, deserializedMemberScope);
        }

        static /* synthetic */ Set accessor$DeserializedMemberScope$OptimizedImplementation$lambda4(OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
            return OptimizedImplementation.variableNames_delegate$lambda$9(optimizedImplementation, deserializedMemberScope);
        }
    }
}

