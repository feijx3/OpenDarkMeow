/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.contracts.ExperimentalContracts
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmConstantValue;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmContract;
import kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.km.KmEffect;
import kotlin.reflect.jvm.internal.impl.km.KmEffectExpression;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.KmVersion;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadContext;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nReaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Readers.kt\nkotlin/metadata/internal/ReadersKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,424:1\n1634#2,3:425\n1634#2,3:428\n1634#2,3:431\n1634#2,3:434\n1634#2,3:437\n1634#2,3:440\n1634#2,3:443\n1869#2,2:446\n1869#2,2:448\n669#2,11:450\n1869#2,2:461\n1634#2,3:463\n1869#2,2:466\n1634#2,3:468\n1634#2,3:471\n1634#2,3:474\n1634#2,3:477\n1634#2,3:480\n1869#2,2:483\n1634#2,3:485\n1634#2,3:488\n1634#2,3:491\n1634#2,3:494\n1869#2,2:497\n1634#2,3:499\n1634#2,3:502\n1634#2,3:505\n1869#2,2:508\n1634#2,3:510\n1634#2,3:513\n1634#2,3:516\n1869#2,2:519\n1869#2,2:521\n1634#2,3:523\n1869#2,2:526\n1869#2,2:528\n1634#2,3:530\n1634#2,3:533\n1634#2,3:536\n*S KotlinDebug\n*F\n+ 1 Readers.kt\nkotlin/metadata/internal/ReadersKt\n*L\n68#1:425,3\n69#1:428,3\n70#1:431,3\n76#1:434,3\n83#1:437,3\n89#1:440,3\n90#1:443,3\n92#1:446,2\n100#1:448,2\n113#1:450,11\n133#1:461,2\n152#1:463,3\n154#1:466,2\n165#1:468,3\n166#1:471,3\n167#1:474,3\n179#1:477,3\n180#1:480,3\n182#1:483,2\n192#1:485,3\n194#1:488,3\n195#1:491,3\n203#1:494,3\n205#1:497,2\n215#1:499,3\n217#1:502,3\n222#1:505,3\n224#1:508,2\n234#1:510,3\n237#1:513,3\n239#1:516,3\n241#1:519,2\n256#1:521,2\n271#1:523,3\n273#1:526,2\n316#1:528,2\n376#1:530,3\n403#1:533,3\n404#1:536,3\n*E\n"})
public final class ReadersKt {
    @NotNull
    public static final KmClass toKmClass(@NotNull ProtoBuf.Class $this$toKmClass, @NotNull NameResolver strings, boolean ignoreUnknownVersionRequirements, @NotNull List<? extends Object> contextExtensions) {
        Serializable it;
        Collection collection;
        Object item$iv;
        Object $this$mapTo$iv;
        Intrinsics.checkNotNullParameter($this$toKmClass, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        KmClass v2 = new KmClass();
        ProtoBuf.TypeTable typeTable = $this$toKmClass.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        TypeTable typeTable2 = new TypeTable(typeTable);
        ProtoBuf.VersionRequirementTable versionRequirementTable = $this$toKmClass.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
        ReadContext readContext = new ReadContext(strings, typeTable2, VersionRequirementTable.Companion.create(versionRequirementTable), ignoreUnknownVersionRequirements, null, contextExtensions, 16, null);
        List<ProtoBuf.TypeParameter> list = $this$toKmClass.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameterList(...)");
        ReadContext c2 = readContext.withTypeParameters$kotlin_metadata(list);
        v2.setFlags$kotlin_metadata($this$toKmClass.getFlags());
        v2.setName(c2.className$kotlin_metadata($this$toKmClass.getFqName()));
        List<ProtoBuf.TypeParameter> list2 = $this$toKmClass.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list2, "getTypeParameterList(...)");
        Iterable iterable = list2;
        Collection destination$iv = v2.getTypeParameters();
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv = iterator2.next();
            ProtoBuf.TypeParameter typeParameter = (ProtoBuf.TypeParameter)item$iv;
            collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmTypeParameter((ProtoBuf.TypeParameter)it, c2));
        }
        $this$mapTo$iv = ProtoTypeTableUtilKt.supertypes($this$toKmClass, c2.getTypes());
        destination$iv = v2.getSupertypes();
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv = iterator2.next();
            it = (ProtoBuf.Type)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            collection.add(ReadersKt.toKmType((ProtoBuf.Type)it, c2));
        }
        List<ProtoBuf.Constructor> list3 = $this$toKmClass.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(list3, "getConstructorList(...)");
        $this$mapTo$iv = list3;
        destination$iv = v2.getConstructors();
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv = iterator2.next();
            it = (ProtoBuf.Constructor)item$iv;
            collection = destination$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmConstructor((ProtoBuf.Constructor)it, c2));
        }
        KmDeclarationContainer kmDeclarationContainer = v2;
        List<ProtoBuf.Function> list4 = $this$toKmClass.getFunctionList();
        Intrinsics.checkNotNullExpressionValue(list4, "getFunctionList(...)");
        List<ProtoBuf.Property> list5 = $this$toKmClass.getPropertyList();
        Intrinsics.checkNotNullExpressionValue(list5, "getPropertyList(...)");
        List<ProtoBuf.TypeAlias> list6 = $this$toKmClass.getTypeAliasList();
        Intrinsics.checkNotNullExpressionValue(list6, "getTypeAliasList(...)");
        ReadersKt.visitDeclarations(kmDeclarationContainer, list4, list5, list6, c2);
        if ($this$toKmClass.hasCompanionObjectName()) {
            v2.setCompanionObject(c2.get($this$toKmClass.getCompanionObjectName()));
        }
        List<Integer> list7 = $this$toKmClass.getNestedClassNameList();
        Intrinsics.checkNotNullExpressionValue(list7, "getNestedClassNameList(...)");
        $this$mapTo$iv = list7;
        destination$iv = v2.getNestedClasses();
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv = iterator2.next();
            it = (Integer)item$iv;
            collection = destination$iv;
            boolean bl5 = false;
            Intrinsics.checkNotNull(it);
            collection.add(c2.get((Integer)it));
        }
        for (ProtoBuf.EnumEntry enumEntry : $this$toKmClass.getEnumEntryList()) {
            if (!enumEntry.hasName()) {
                throw new InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
            }
            v2.getEnumEntries().add(c2.get(enumEntry.getName()));
            List<KmEnumEntry> list8 = v2.getKmEnumEntries();
            Intrinsics.checkNotNull(enumEntry);
            list8.add(ReadersKt.toKmEnumEntry(enumEntry, c2));
        }
        List<Integer> list9 = $this$toKmClass.getSealedSubclassFqNameList();
        Intrinsics.checkNotNullExpressionValue(list9, "getSealedSubclassFqNameList(...)");
        $this$mapTo$iv = list9;
        destination$iv = v2.getSealedSubclasses();
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv = iterator2.next();
            it = (Integer)item$iv;
            collection = destination$iv;
            boolean bl6 = false;
            Intrinsics.checkNotNull(it);
            collection.add(c2.className$kotlin_metadata((Integer)it));
        }
        if ($this$toKmClass.hasInlineClassUnderlyingPropertyName()) {
            v2.setInlineClassUnderlyingPropertyName(c2.get($this$toKmClass.getInlineClassUnderlyingPropertyName()));
        }
        ProtoBuf.Type type = ReadersKt.loadInlineClassUnderlyingType($this$toKmClass, c2);
        v2.setInlineClassUnderlyingType(type != null ? ReadersKt.toKmType(type, c2) : null);
        $this$mapTo$iv = ProtoTypeTableUtilKt.contextReceiverTypes($this$toKmClass, c2.getTypes());
        destination$iv = v2.getContextReceiverTypes();
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv = iterator2.next();
            it = (ProtoBuf.Type)item$iv;
            collection = destination$iv;
            boolean bl7 = false;
            collection.add(ReadersKt.toKmType((ProtoBuf.Type)it, c2));
        }
        List<Integer> list10 = $this$toKmClass.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(list10, "getVersionRequirementList(...)");
        $this$mapTo$iv = list10;
        destination$iv = v2.getVersionRequirements();
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv = iterator2.next();
            it = (Integer)item$iv;
            collection = destination$iv;
            boolean bl8 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.readVersionRequirement((Integer)it, c2));
        }
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it2 = (MetadataExtensions)element$iv;
            boolean bl9 = false;
            it2.readClassExtensions(v2, $this$toKmClass, c2);
        }
        return v2;
    }

    public static /* synthetic */ KmClass toKmClass$default(ProtoBuf.Class clazz, NameResolver nameResolver, boolean bl2, List list, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return ReadersKt.toKmClass(clazz, nameResolver, bl2, list);
    }

    private static final KmEnumEntry toKmEnumEntry(ProtoBuf.EnumEntry $this$toKmEnumEntry, ReadContext c2) {
        KmEnumEntry v2 = new KmEnumEntry(c2.get($this$toKmEnumEntry.getName()));
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it = (MetadataExtensions)element$iv;
            boolean bl2 = false;
            it.readEnumEntryExtensions(v2, $this$toKmEnumEntry, c2);
        }
        return v2;
    }

    /*
     * WARNING - void declaration
     */
    private static final ProtoBuf.Type loadInlineClassUnderlyingType(ProtoBuf.Class $this$loadInlineClassUnderlyingType, ReadContext c2) {
        Object v2;
        block4: {
            void $this$singleOrNull$iv;
            ProtoBuf.Type type;
            ProtoBuf.Type type2 = type = ProtoTypeTableUtilKt.inlineClassUnderlyingType($this$loadInlineClassUnderlyingType, c2.getTypes());
            if (type2 != null) {
                return type2;
            }
            if (!$this$loadInlineClassUnderlyingType.hasInlineClassUnderlyingPropertyName()) {
                return null;
            }
            List<ProtoBuf.Property> list = $this$loadInlineClassUnderlyingType.getPropertyList();
            Intrinsics.checkNotNullExpressionValue(list, "getPropertyList(...)");
            Iterable iterable = list;
            boolean $i$f$singleOrNull = false;
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $this$singleOrNull$iv) {
                ProtoBuf.Property it = (ProtoBuf.Property)element$iv;
                boolean bl2 = false;
                Intrinsics.checkNotNull(it);
                if (!(ProtoTypeTableUtilKt.receiverType(it, c2.getTypes()) == null && Intrinsics.areEqual(c2.get(it.getName()), c2.get($this$loadInlineClassUnderlyingType.getInlineClassUnderlyingPropertyName())))) continue;
                if (found$iv) {
                    v2 = null;
                    break block4;
                }
                single$iv = element$iv;
                found$iv = true;
            }
            v2 = !found$iv ? null : single$iv;
        }
        ProtoBuf.Property property = v2;
        return property != null ? ProtoTypeTableUtilKt.returnType(property, c2.getTypes()) : null;
    }

    private static final void visitDeclarations(KmDeclarationContainer $this$visitDeclarations, List<ProtoBuf.Function> protoFunctions, List<ProtoBuf.Property> protoProperties, List<ProtoBuf.TypeAlias> protoTypeAliases, ReadContext c2) {
        GeneratedMessageLite.ExtendableMessage it;
        Collection collection;
        Iterable $this$mapTo$iv;
        Iterable iterable = protoFunctions;
        Collection destination$iv = $this$visitDeclarations.getFunctions();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Function function = (ProtoBuf.Function)item$iv;
            collection = destination$iv;
            boolean bl2 = false;
            collection.add(ReadersKt.toKmFunction((ProtoBuf.Function)it, c2));
        }
        $this$mapTo$iv = protoProperties;
        destination$iv = $this$visitDeclarations.getProperties();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Property)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            collection.add(ReadersKt.toKmProperty(it, c2));
        }
        $this$mapTo$iv = protoTypeAliases;
        destination$iv = $this$visitDeclarations.getTypeAliases();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.TypeAlias)item$iv;
            collection = destination$iv;
            boolean bl4 = false;
            collection.add(ReadersKt.toKmTypeAlias((ProtoBuf.TypeAlias)it, c2));
        }
    }

    private static final KmConstructor toKmConstructor(ProtoBuf.Constructor $this$toKmConstructor, ReadContext c2) {
        Integer it;
        Collection collection;
        Iterable $this$mapTo$iv;
        KmConstructor v2 = new KmConstructor($this$toKmConstructor.getFlags());
        List<ProtoBuf.ValueParameter> list = $this$toKmConstructor.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameterList(...)");
        Iterable iterable = list;
        Collection destination$iv = v2.getValueParameters();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter)item$iv;
            collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmValueParameter((ProtoBuf.ValueParameter)((Object)it), c2));
        }
        List<Integer> list2 = $this$toKmConstructor.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(list2, "getVersionRequirementList(...)");
        $this$mapTo$iv = list2;
        destination$iv = v2.getVersionRequirements();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (Integer)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.readVersionRequirement(it, c2));
        }
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it2 = (MetadataExtensions)element$iv;
            boolean bl4 = false;
            it2.readConstructorExtensions(v2, $this$toKmConstructor, c2);
        }
        return v2;
    }

    private static final KmFunction toKmFunction(ProtoBuf.Function $this$toKmFunction, ReadContext outer) {
        Serializable it;
        Collection collection;
        Iterable $this$mapTo$iv;
        KmFunction v2 = new KmFunction($this$toKmFunction.getFlags(), outer.get($this$toKmFunction.getName()));
        List<ProtoBuf.TypeParameter> list = $this$toKmFunction.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameterList(...)");
        ReadContext c2 = outer.withTypeParameters$kotlin_metadata(list);
        List<ProtoBuf.TypeParameter> list2 = $this$toKmFunction.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list2, "getTypeParameterList(...)");
        Iterable iterable = list2;
        Collection destination$iv = v2.getTypeParameters();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.TypeParameter typeParameter = (ProtoBuf.TypeParameter)item$iv;
            collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmTypeParameter((ProtoBuf.TypeParameter)it, c2));
        }
        ProtoBuf.Type type = ProtoTypeTableUtilKt.receiverType($this$toKmFunction, c2.getTypes());
        v2.setReceiverParameterType(type != null ? ReadersKt.toKmType(type, c2) : null);
        $this$mapTo$iv = ProtoTypeTableUtilKt.contextReceiverTypes($this$toKmFunction, c2.getTypes());
        destination$iv = v2.getContextReceiverTypes();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Type)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            collection.add(ReadersKt.toKmType((ProtoBuf.Type)it, c2));
        }
        List<ProtoBuf.ValueParameter> list3 = $this$toKmFunction.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(list3, "getValueParameterList(...)");
        $this$mapTo$iv = list3;
        destination$iv = v2.getValueParameters();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.ValueParameter)item$iv;
            collection = destination$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmValueParameter((ProtoBuf.ValueParameter)it, c2));
        }
        v2.setReturnType(ReadersKt.toKmType(ProtoTypeTableUtilKt.returnType($this$toKmFunction, c2.getTypes()), c2));
        if ($this$toKmFunction.hasContract()) {
            ProtoBuf.Contract contract = $this$toKmFunction.getContract();
            Intrinsics.checkNotNullExpressionValue(contract, "getContract(...)");
            v2.setContract(ReadersKt.toKmContract(contract, c2));
        }
        List<Integer> list4 = $this$toKmFunction.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(list4, "getVersionRequirementList(...)");
        $this$mapTo$iv = list4;
        destination$iv = v2.getVersionRequirements();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (Integer)item$iv;
            collection = destination$iv;
            boolean bl5 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.readVersionRequirement((Integer)it, c2));
        }
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it2 = (MetadataExtensions)element$iv;
            boolean bl6 = false;
            it2.readFunctionExtensions(v2, $this$toKmFunction, c2);
        }
        return v2;
    }

    @NotNull
    public static final KmProperty toKmProperty(@NotNull ProtoBuf.Property $this$toKmProperty, @NotNull ReadContext outer) {
        Serializable it;
        Collection collection;
        Iterable $this$mapTo$iv;
        Intrinsics.checkNotNullParameter($this$toKmProperty, "<this>");
        Intrinsics.checkNotNullParameter(outer, "outer");
        KmProperty v2 = new KmProperty($this$toKmProperty.getFlags(), outer.get($this$toKmProperty.getName()), ReadersKt.getPropertyGetterFlags($this$toKmProperty), ReadersKt.getPropertySetterFlags($this$toKmProperty));
        List<ProtoBuf.TypeParameter> list = $this$toKmProperty.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameterList(...)");
        ReadContext c2 = outer.withTypeParameters$kotlin_metadata(list);
        List<ProtoBuf.TypeParameter> list2 = $this$toKmProperty.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list2, "getTypeParameterList(...)");
        Iterable iterable = list2;
        Collection destination$iv = v2.getTypeParameters();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.TypeParameter typeParameter = (ProtoBuf.TypeParameter)item$iv;
            collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmTypeParameter((ProtoBuf.TypeParameter)it, c2));
        }
        ProtoBuf.Type type = ProtoTypeTableUtilKt.receiverType($this$toKmProperty, c2.getTypes());
        v2.setReceiverParameterType(type != null ? ReadersKt.toKmType(type, c2) : null);
        $this$mapTo$iv = ProtoTypeTableUtilKt.contextReceiverTypes($this$toKmProperty, c2.getTypes());
        destination$iv = v2.getContextReceiverTypes();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Type)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            collection.add(ReadersKt.toKmType((ProtoBuf.Type)it, c2));
        }
        if ($this$toKmProperty.hasSetterValueParameter()) {
            ProtoBuf.ValueParameter valueParameter = $this$toKmProperty.getSetterValueParameter();
            Intrinsics.checkNotNullExpressionValue(valueParameter, "getSetterValueParameter(...)");
            v2.setSetterParameter(ReadersKt.toKmValueParameter(valueParameter, c2));
        }
        v2.setReturnType(ReadersKt.toKmType(ProtoTypeTableUtilKt.returnType($this$toKmProperty, c2.getTypes()), c2));
        List<Integer> list3 = $this$toKmProperty.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(list3, "getVersionRequirementList(...)");
        $this$mapTo$iv = list3;
        destination$iv = v2.getVersionRequirements();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (Integer)item$iv;
            collection = destination$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.readVersionRequirement((Integer)it, c2));
        }
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it2 = (MetadataExtensions)element$iv;
            boolean bl5 = false;
            it2.readPropertyExtensions(v2, $this$toKmProperty, c2);
        }
        return v2;
    }

    private static final KmTypeAlias toKmTypeAlias(ProtoBuf.TypeAlias $this$toKmTypeAlias, ReadContext outer) {
        Serializable it;
        Collection collection;
        Iterable $this$mapTo$iv;
        KmTypeAlias v2 = new KmTypeAlias($this$toKmTypeAlias.getFlags(), outer.get($this$toKmTypeAlias.getName()));
        List<ProtoBuf.TypeParameter> list = $this$toKmTypeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameterList(...)");
        ReadContext c2 = outer.withTypeParameters$kotlin_metadata(list);
        List<ProtoBuf.TypeParameter> list2 = $this$toKmTypeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list2, "getTypeParameterList(...)");
        Iterable iterable = list2;
        Collection destination$iv = v2.getTypeParameters();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.TypeParameter typeParameter = (ProtoBuf.TypeParameter)item$iv;
            collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmTypeParameter((ProtoBuf.TypeParameter)it, c2));
        }
        v2.setUnderlyingType(ReadersKt.toKmType(ProtoTypeTableUtilKt.underlyingType($this$toKmTypeAlias, c2.getTypes()), c2));
        v2.setExpandedType(ReadersKt.toKmType(ProtoTypeTableUtilKt.expandedType($this$toKmTypeAlias, c2.getTypes()), c2));
        List<ProtoBuf.Annotation> list3 = $this$toKmTypeAlias.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list3, "getAnnotationList(...)");
        $this$mapTo$iv = list3;
        destination$iv = v2.getAnnotations();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Annotation)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadUtilsKt.readAnnotation((ProtoBuf.Annotation)it, c2.getStrings()));
        }
        List<Integer> list4 = $this$toKmTypeAlias.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(list4, "getVersionRequirementList(...)");
        $this$mapTo$iv = list4;
        destination$iv = v2.getVersionRequirements();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (Integer)item$iv;
            collection = destination$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.readVersionRequirement((Integer)it, c2));
        }
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it2 = (MetadataExtensions)element$iv;
            boolean bl5 = false;
            it2.readTypeAliasExtensions(v2, $this$toKmTypeAlias, c2);
        }
        return v2;
    }

    private static final KmValueParameter toKmValueParameter(ProtoBuf.ValueParameter $this$toKmValueParameter, ReadContext c2) {
        KmValueParameter v2 = new KmValueParameter($this$toKmValueParameter.getFlags(), c2.get($this$toKmValueParameter.getName()));
        v2.setType(ReadersKt.toKmType(ProtoTypeTableUtilKt.type($this$toKmValueParameter, c2.getTypes()), c2));
        ProtoBuf.Type type = ProtoTypeTableUtilKt.varargElementType($this$toKmValueParameter, c2.getTypes());
        v2.setVarargElementType(type != null ? ReadersKt.toKmType(type, c2) : null);
        if ($this$toKmValueParameter.hasAnnotationParameterDefaultValue()) {
            ProtoBuf.Annotation.Argument.Value value = $this$toKmValueParameter.getAnnotationParameterDefaultValue();
            Intrinsics.checkNotNullExpressionValue(value, "getAnnotationParameterDefaultValue(...)");
            v2.setAnnotationParameterDefaultValue(ReadUtilsKt.readAnnotationArgument(value, c2.getStrings()));
        }
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it = (MetadataExtensions)element$iv;
            boolean bl2 = false;
            it.readValueParameterExtensions(v2, $this$toKmValueParameter, c2);
        }
        return v2;
    }

    /*
     * WARNING - void declaration
     */
    private static final KmTypeParameter toKmTypeParameter(ProtoBuf.TypeParameter $this$toKmTypeParameter, ReadContext c2) {
        void $this$mapTo$iv;
        KmVariance kmVariance;
        ProtoBuf.TypeParameter.Variance variance = $this$toKmTypeParameter.getVariance();
        if (variance == null) {
            String string = "Required value was null.";
            throw new IllegalArgumentException(string.toString());
        }
        switch (WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
            case 1: {
                kmVariance = KmVariance.IN;
                break;
            }
            case 2: {
                kmVariance = KmVariance.OUT;
                break;
            }
            case 3: {
                kmVariance = KmVariance.INVARIANT;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        KmVariance variance2 = kmVariance;
        KmTypeParameter ktp = new KmTypeParameter(ReadersKt.getTypeParameterFlags($this$toKmTypeParameter), c2.get($this$toKmTypeParameter.getName()), $this$toKmTypeParameter.getId(), variance2);
        Iterable iterable = ProtoTypeTableUtilKt.upperBounds($this$toKmTypeParameter, c2.getTypes());
        Collection destination$iv = ktp.getUpperBounds();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            ProtoBuf.Type type = (ProtoBuf.Type)item$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            collection.add(ReadersKt.toKmType((ProtoBuf.Type)it, c2));
        }
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it = (MetadataExtensions)element$iv;
            boolean bl3 = false;
            it.readTypeParameterExtensions(ktp, $this$toKmTypeParameter, c2);
        }
        return ktp;
    }

    /*
     * WARNING - void declaration
     */
    private static final KmType toKmType(ProtoBuf.Type $this$toKmType, ReadContext c2) {
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound;
        Object argumentType;
        KmClassifier kmClassifier;
        KmType v2 = new KmType(ReadersKt.getTypeFlags($this$toKmType));
        if ($this$toKmType.hasClassName()) {
            kmClassifier = new KmClassifier.Class(c2.className$kotlin_metadata($this$toKmType.getClassName()));
        } else if ($this$toKmType.hasTypeAliasName()) {
            kmClassifier = new KmClassifier.TypeAlias(c2.className$kotlin_metadata($this$toKmType.getTypeAliasName()));
        } else if ($this$toKmType.hasTypeParameter()) {
            kmClassifier = new KmClassifier.TypeParameter($this$toKmType.getTypeParameter());
        } else if ($this$toKmType.hasTypeParameterName()) {
            Integer n2 = c2.getTypeParameterId$kotlin_metadata($this$toKmType.getTypeParameterName());
            if (n2 == null) {
                throw new InconsistentKotlinMetadataException("No type parameter id for " + c2.get($this$toKmType.getTypeParameterName()), null, 2, null);
            }
            int id = n2;
            kmClassifier = new KmClassifier.TypeParameter(id);
        } else {
            throw new InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
        }
        v2.setClassifier(kmClassifier);
        for (ProtoBuf.Type.Argument argument : $this$toKmType.getArgumentList()) {
            boolean bl2;
            KmVariance kmVariance;
            ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
            if (projection == null) {
                String string = "Required value was null.";
                throw new IllegalArgumentException(string.toString());
            }
            switch (WhenMappings.$EnumSwitchMapping$1[projection.ordinal()]) {
                case 1: {
                    kmVariance = KmVariance.IN;
                    break;
                }
                case 2: {
                    kmVariance = KmVariance.OUT;
                    break;
                }
                case 3: {
                    kmVariance = KmVariance.INVARIANT;
                    break;
                }
                case 4: {
                    kmVariance = null;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            KmVariance variance = kmVariance;
            if (variance != null) {
                Intrinsics.checkNotNull(argument);
                if (ProtoTypeTableUtilKt.type(argument, c2.getTypes()) == null) {
                    throw new InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
                }
                bl2 = v2.getArguments().add(new KmTypeProjection(variance, ReadersKt.toKmType((ProtoBuf.Type)argumentType, c2)));
                continue;
            }
            bl2 = v2.getArguments().add(KmTypeProjection.STAR);
        }
        ProtoBuf.Type type = ProtoTypeTableUtilKt.abbreviatedType($this$toKmType, c2.getTypes());
        v2.setAbbreviatedType(type != null ? ReadersKt.toKmType(type, c2) : null);
        ProtoBuf.Type type2 = ProtoTypeTableUtilKt.outerType($this$toKmType, c2.getTypes());
        v2.setOuterType(type2 != null ? ReadersKt.toKmType(type2, c2) : null);
        KmType kmType = v2;
        Object object = ProtoTypeTableUtilKt.flexibleUpperBound($this$toKmType, c2.getTypes());
        if (object != null && (object = ReadersKt.toKmType((ProtoBuf.Type)object, c2)) != null) {
            void it;
            argumentType = object;
            KmType kmType2 = kmType;
            boolean bl3 = false;
            kmFlexibleTypeUpperBound = new KmFlexibleTypeUpperBound((KmType)it, $this$toKmType.hasFlexibleTypeCapabilitiesId() ? c2.get($this$toKmType.getFlexibleTypeCapabilitiesId()) : null);
            kmType = kmType2;
        } else {
            kmFlexibleTypeUpperBound = null;
        }
        kmType.setFlexibleTypeUpperBound(kmFlexibleTypeUpperBound);
        Iterable $this$forEach$iv = c2.getExtensions$kotlin_metadata();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MetadataExtensions it = (MetadataExtensions)element$iv;
            boolean bl4 = false;
            it.readTypeExtensions(v2, $this$toKmType, c2);
        }
        return v2;
    }

    private static final KmVersionRequirement readVersionRequirement(int id, ReadContext c2) {
        KmVersionRequirementLevel kmVersionRequirementLevel;
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind;
        KmVersionRequirement v2 = new KmVersionRequirement();
        VersionRequirement message = VersionRequirement.Companion.create(id, c2.getStrings(), c2.getVersionRequirements$kotlin_metadata());
        if (message == null && !c2.getIgnoreUnknownVersionRequirements$kotlin_metadata()) {
            throw new InconsistentKotlinMetadataException("No VersionRequirement with the given id in the table", null, 2, null);
        }
        VersionRequirement versionRequirement = message;
        ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement != null ? versionRequirement.getKind() : null;
        switch (versionKind == null ? -1 : WhenMappings.$EnumSwitchMapping$2[versionKind.ordinal()]) {
            case 1: {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.LANGUAGE_VERSION;
                break;
            }
            case 2: {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.COMPILER_VERSION;
                break;
            }
            case 3: {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.API_VERSION;
                break;
            }
            case -1: {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.UNKNOWN;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        KmVersionRequirementVersionKind kind2 = kmVersionRequirementVersionKind;
        VersionRequirement versionRequirement2 = message;
        DeprecationLevel deprecationLevel = versionRequirement2 != null ? versionRequirement2.getLevel() : null;
        switch (deprecationLevel == null ? -1 : WhenMappings.$EnumSwitchMapping$3[deprecationLevel.ordinal()]) {
            case 1: {
                kmVersionRequirementLevel = KmVersionRequirementLevel.WARNING;
                break;
            }
            case 2: {
                kmVersionRequirementLevel = KmVersionRequirementLevel.ERROR;
                break;
            }
            case -1: 
            case 3: {
                kmVersionRequirementLevel = KmVersionRequirementLevel.HIDDEN;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        KmVersionRequirementLevel level = kmVersionRequirementLevel;
        v2.setKind(kind2);
        v2.setLevel(level);
        VersionRequirement versionRequirement3 = message;
        v2.setErrorCode(versionRequirement3 != null ? versionRequirement3.getErrorCode() : null);
        VersionRequirement versionRequirement4 = message;
        v2.setMessage(versionRequirement4 != null ? versionRequirement4.getMessage() : null);
        Object object = message;
        if (object == null || (object = ((VersionRequirement)object).getVersion()) == null) {
            object = VersionRequirement.Version.INFINITY;
        }
        Object object2 = object;
        int major = ((VersionRequirement.Version)object2).component1();
        int minor = ((VersionRequirement.Version)object2).component2();
        int patch = ((VersionRequirement.Version)object2).component3();
        v2.setVersion(new KmVersion(major, minor, patch));
        return v2;
    }

    @ExperimentalContracts
    private static final KmContract toKmContract(ProtoBuf.Contract $this$toKmContract, ReadContext c2) {
        KmContract v2 = new KmContract();
        for (ProtoBuf.Effect effect : $this$toKmContract.getEffectList()) {
            KmEffectInvocationKind kmEffectInvocationKind;
            KmEffectType kmEffectType;
            if (!effect.hasEffectType()) continue;
            ProtoBuf.Effect.EffectType effectType = effect.getEffectType();
            if (effectType == null) {
                String string = "Required value was null.";
                throw new IllegalArgumentException(string.toString());
            }
            switch (WhenMappings.$EnumSwitchMapping$4[effectType.ordinal()]) {
                case 1: {
                    kmEffectType = KmEffectType.RETURNS_CONSTANT;
                    break;
                }
                case 2: {
                    kmEffectType = KmEffectType.CALLS;
                    break;
                }
                case 3: {
                    kmEffectType = KmEffectType.RETURNS_NOT_NULL;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            KmEffectType effectType2 = kmEffectType;
            if (!effect.hasKind()) {
                kmEffectInvocationKind = null;
            } else {
                ProtoBuf.Effect.InvocationKind invocationKind = effect.getKind();
                if (invocationKind == null) {
                    String string = "Required value was null.";
                    throw new IllegalArgumentException(string.toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$5[invocationKind.ordinal()]) {
                    case 1: {
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_MOST_ONCE;
                        break;
                    }
                    case 2: {
                        kmEffectInvocationKind = KmEffectInvocationKind.EXACTLY_ONCE;
                        break;
                    }
                    case 3: {
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_LEAST_ONCE;
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            KmEffectInvocationKind effectKind = kmEffectInvocationKind;
            List<KmEffect> list = v2.getEffects();
            Intrinsics.checkNotNull(effect);
            list.add(ReadersKt.toKmEffect(effect, effectType2, effectKind, c2));
        }
        return v2;
    }

    /*
     * WARNING - void declaration
     */
    @ExperimentalContracts
    private static final KmEffect toKmEffect(ProtoBuf.Effect $this$toKmEffect, KmEffectType type, KmEffectInvocationKind kind2, ReadContext c2) {
        void $this$mapTo$iv;
        KmEffect v2 = new KmEffect(type, kind2);
        List<ProtoBuf.Expression> list = $this$toKmEffect.getEffectConstructorArgumentList();
        Intrinsics.checkNotNullExpressionValue(list, "getEffectConstructorArgumentList(...)");
        Iterable iterable = list;
        Collection destination$iv = v2.getConstructorArguments();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            ProtoBuf.Expression expression = (ProtoBuf.Expression)item$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmEffectExpression((ProtoBuf.Expression)it, c2));
        }
        if ($this$toKmEffect.hasConclusionOfConditionalEffect()) {
            ProtoBuf.Expression expression = $this$toKmEffect.getConclusionOfConditionalEffect();
            Intrinsics.checkNotNullExpressionValue(expression, "getConclusionOfConditionalEffect(...)");
            v2.setConclusion(ReadersKt.toKmEffectExpression(expression, c2));
        }
        return v2;
    }

    @ExperimentalContracts
    private static final KmEffectExpression toKmEffectExpression(ProtoBuf.Expression $this$toKmEffectExpression, ReadContext c2) {
        ProtoBuf.Expression it;
        Collection collection;
        Iterable $this$mapTo$iv;
        KmEffectExpression v2 = new KmEffectExpression();
        v2.setFlags$kotlin_metadata($this$toKmEffectExpression.getFlags());
        v2.setParameterIndex($this$toKmEffectExpression.hasValueParameterReference() ? Integer.valueOf($this$toKmEffectExpression.getValueParameterReference()) : null);
        if ($this$toKmEffectExpression.hasConstantValue()) {
            Boolean bl2;
            ProtoBuf.Expression.ConstantValue constantValue = $this$toKmEffectExpression.getConstantValue();
            if (constantValue == null) {
                String string = "Required value was null.";
                throw new IllegalArgumentException(string.toString());
            }
            switch (WhenMappings.$EnumSwitchMapping$6[constantValue.ordinal()]) {
                case 1: {
                    bl2 = true;
                    break;
                }
                case 2: {
                    bl2 = false;
                    break;
                }
                case 3: {
                    bl2 = null;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            v2.setConstantValue(new KmConstantValue(bl2));
        }
        ProtoBuf.Type type = ProtoTypeTableUtilKt.isInstanceType($this$toKmEffectExpression, c2.getTypes());
        v2.setInstanceType(type != null ? ReadersKt.toKmType(type, c2) : null);
        List<ProtoBuf.Expression> list = $this$toKmEffectExpression.getAndArgumentList();
        Intrinsics.checkNotNullExpressionValue(list, "getAndArgumentList(...)");
        Iterable iterable = list;
        Collection destination$iv = v2.getAndArguments();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Expression expression = (ProtoBuf.Expression)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmEffectExpression(it, c2));
        }
        List<ProtoBuf.Expression> list2 = $this$toKmEffectExpression.getOrArgumentList();
        Intrinsics.checkNotNullExpressionValue(list2, "getOrArgumentList(...)");
        $this$mapTo$iv = list2;
        destination$iv = v2.getOrArguments();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Expression)item$iv;
            collection = destination$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadersKt.toKmEffectExpression(it, c2));
        }
        return v2;
    }

    private static final int getTypeFlags(ProtoBuf.Type $this$typeFlags) {
        return ($this$typeFlags.getNullable() ? 1 : 0) + ($this$typeFlags.getFlags() << 1);
    }

    private static final int getTypeParameterFlags(ProtoBuf.TypeParameter $this$typeParameterFlags) {
        return $this$typeParameterFlags.getReified() ? 1 : 0;
    }

    public static final int getPropertyGetterFlags(@NotNull ProtoBuf.Property $this$getPropertyGetterFlags) {
        Intrinsics.checkNotNullParameter($this$getPropertyGetterFlags, "<this>");
        return $this$getPropertyGetterFlags.hasGetterFlags() ? $this$getPropertyGetterFlags.getGetterFlags() : ReadersKt.getDefaultPropertyAccessorFlags($this$getPropertyGetterFlags.getFlags());
    }

    public static final int getPropertySetterFlags(@NotNull ProtoBuf.Property $this$getPropertySetterFlags) {
        Intrinsics.checkNotNullParameter($this$getPropertySetterFlags, "<this>");
        return $this$getPropertySetterFlags.hasSetterFlags() ? $this$getPropertySetterFlags.getSetterFlags() : ReadersKt.getDefaultPropertyAccessorFlags($this$getPropertySetterFlags.getFlags());
    }

    public static final int getDefaultPropertyAccessorFlags(int flags) {
        Boolean bl2 = Flags.HAS_ANNOTATIONS.get(flags);
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        return Flags.getAccessorFlags(bl2, Flags.VISIBILITY.get(flags), Flags.MODALITY.get(flags), false, false, false);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] nArray = new int[ProtoBuf.TypeParameter.Variance.values().length];
            try {
                nArray[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[ProtoBuf.Type.Argument.Projection.values().length];
            try {
                nArray[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
            nArray = new int[ProtoBuf.VersionRequirement.VersionKind.values().length];
            try {
                nArray[ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$2 = nArray;
            nArray = new int[DeprecationLevel.values().length];
            try {
                nArray[DeprecationLevel.WARNING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[DeprecationLevel.ERROR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[DeprecationLevel.HIDDEN.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$3 = nArray;
            nArray = new int[ProtoBuf.Effect.EffectType.values().length];
            try {
                nArray[ProtoBuf.Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Effect.EffectType.CALLS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$4 = nArray;
            nArray = new int[ProtoBuf.Effect.InvocationKind.values().length];
            try {
                nArray[ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$5 = nArray;
            nArray = new int[ProtoBuf.Expression.ConstantValue.values().length];
            try {
                nArray[ProtoBuf.Expression.ConstantValue.TRUE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Expression.ConstantValue.FALSE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Expression.ConstantValue.NULL.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$6 = nArray;
        }
    }
}

