/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nprotoTypeTableUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 protoTypeTableUtil.kt\norg/jetbrains/kotlin/metadata/deserialization/ProtoTypeTableUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,125:1\n1#2:126\n1563#3:127\n1634#3,3:128\n1563#3:131\n1634#3,3:132\n1563#3:135\n1634#3,3:136\n1563#3:139\n1634#3,3:140\n1563#3:143\n1634#3,3:144\n*S KotlinDebug\n*F\n+ 1 protoTypeTableUtil.kt\norg/jetbrains/kotlin/metadata/deserialization/ProtoTypeTableUtilKt\n*L\n24#1:127\n24#1:128,3\n45#1:131\n45#1:132,3\n118#1:135\n118#1:136,3\n121#1:139\n121#1:140,3\n124#1:143\n124#1:144,3\n*E\n"})
public final class ProtoTypeTableUtilKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ProtoBuf.Type> supertypes(@NotNull ProtoBuf.Class $this$supertypes, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$supertypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List list = $this$supertypes.getSupertypeList();
        Collection p0 = list;
        boolean bl22 = false;
        List list2 = !p0.isEmpty() ? list : null;
        if (list2 == null) {
            void $this$mapTo$iv$iv;
            List<Integer> list3 = $this$supertypes.getSupertypeIdList();
            Intrinsics.checkNotNullExpressionValue(list3, "getSupertypeIdList(...)");
            Iterable $this$map$iv = list3;
            boolean $i$f$map = false;
            Iterable bl22 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Integer n2 = (Integer)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull(it);
                collection.add(typeTable.get(it.intValue()));
            }
            list2 = (List)destination$iv$iv;
        }
        return list2;
    }

    @Nullable
    public static final ProtoBuf.Type inlineClassUnderlyingType(@NotNull ProtoBuf.Class $this$inlineClassUnderlyingType, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$inlineClassUnderlyingType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$inlineClassUnderlyingType.hasInlineClassUnderlyingType() ? $this$inlineClassUnderlyingType.getInlineClassUnderlyingType() : ($this$inlineClassUnderlyingType.hasInlineClassUnderlyingTypeId() ? typeTable.get($this$inlineClassUnderlyingType.getInlineClassUnderlyingTypeId()) : null);
    }

    @Nullable
    public static final ProtoBuf.Type type(@NotNull ProtoBuf.Type.Argument $this$type, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$type.hasType() ? $this$type.getType() : ($this$type.hasTypeId() ? typeTable.get($this$type.getTypeId()) : null);
    }

    @Nullable
    public static final ProtoBuf.Type flexibleUpperBound(@NotNull ProtoBuf.Type $this$flexibleUpperBound, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$flexibleUpperBound, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$flexibleUpperBound.hasFlexibleUpperBound() ? $this$flexibleUpperBound.getFlexibleUpperBound() : ($this$flexibleUpperBound.hasFlexibleUpperBoundId() ? typeTable.get($this$flexibleUpperBound.getFlexibleUpperBoundId()) : null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ProtoBuf.Type> upperBounds(@NotNull ProtoBuf.TypeParameter $this$upperBounds, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$upperBounds, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List list = $this$upperBounds.getUpperBoundList();
        Collection p0 = list;
        boolean bl22 = false;
        List list2 = !p0.isEmpty() ? list : null;
        if (list2 == null) {
            void $this$mapTo$iv$iv;
            List<Integer> list3 = $this$upperBounds.getUpperBoundIdList();
            Intrinsics.checkNotNullExpressionValue(list3, "getUpperBoundIdList(...)");
            Iterable $this$map$iv = list3;
            boolean $i$f$map = false;
            Iterable bl22 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Integer n2 = (Integer)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull(it);
                collection.add(typeTable.get(it.intValue()));
            }
            list2 = (List)destination$iv$iv;
        }
        return list2;
    }

    @NotNull
    public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Function $this$returnType, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type;
        Intrinsics.checkNotNullParameter($this$returnType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$returnType.hasReturnType()) {
            ProtoBuf.Type type2 = $this$returnType.getReturnType();
            type = type2;
            Intrinsics.checkNotNullExpressionValue(type2, "getReturnType(...)");
        } else if ($this$returnType.hasReturnTypeId()) {
            type = typeTable.get($this$returnType.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
        return type;
    }

    public static final boolean hasReceiver(@NotNull ProtoBuf.Function $this$hasReceiver) {
        Intrinsics.checkNotNullParameter($this$hasReceiver, "<this>");
        return $this$hasReceiver.hasReceiverType() || $this$hasReceiver.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Function $this$receiverType, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$receiverType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$receiverType.hasReceiverType() ? $this$receiverType.getReceiverType() : ($this$receiverType.hasReceiverTypeId() ? typeTable.get($this$receiverType.getReceiverTypeId()) : null);
    }

    @NotNull
    public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Property $this$returnType, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type;
        Intrinsics.checkNotNullParameter($this$returnType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$returnType.hasReturnType()) {
            ProtoBuf.Type type2 = $this$returnType.getReturnType();
            type = type2;
            Intrinsics.checkNotNullExpressionValue(type2, "getReturnType(...)");
        } else if ($this$returnType.hasReturnTypeId()) {
            type = typeTable.get($this$returnType.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
        return type;
    }

    public static final boolean hasReceiver(@NotNull ProtoBuf.Property $this$hasReceiver) {
        Intrinsics.checkNotNullParameter($this$hasReceiver, "<this>");
        return $this$hasReceiver.hasReceiverType() || $this$hasReceiver.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Property $this$receiverType, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$receiverType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$receiverType.hasReceiverType() ? $this$receiverType.getReceiverType() : ($this$receiverType.hasReceiverTypeId() ? typeTable.get($this$receiverType.getReceiverTypeId()) : null);
    }

    @NotNull
    public static final ProtoBuf.Type type(@NotNull ProtoBuf.ValueParameter $this$type, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type;
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$type.hasType()) {
            ProtoBuf.Type type2 = $this$type.getType();
            type = type2;
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
        } else if ($this$type.hasTypeId()) {
            type = typeTable.get($this$type.getTypeId());
        } else {
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
        return type;
    }

    @Nullable
    public static final ProtoBuf.Type varargElementType(@NotNull ProtoBuf.ValueParameter $this$varargElementType, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$varargElementType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$varargElementType.hasVarargElementType() ? $this$varargElementType.getVarargElementType() : ($this$varargElementType.hasVarargElementTypeId() ? typeTable.get($this$varargElementType.getVarargElementTypeId()) : null);
    }

    @Nullable
    public static final ProtoBuf.Type outerType(@NotNull ProtoBuf.Type $this$outerType, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$outerType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$outerType.hasOuterType() ? $this$outerType.getOuterType() : ($this$outerType.hasOuterTypeId() ? typeTable.get($this$outerType.getOuterTypeId()) : null);
    }

    @Nullable
    public static final ProtoBuf.Type abbreviatedType(@NotNull ProtoBuf.Type $this$abbreviatedType, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$abbreviatedType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$abbreviatedType.hasAbbreviatedType() ? $this$abbreviatedType.getAbbreviatedType() : ($this$abbreviatedType.hasAbbreviatedTypeId() ? typeTable.get($this$abbreviatedType.getAbbreviatedTypeId()) : null);
    }

    @NotNull
    public static final ProtoBuf.Type underlyingType(@NotNull ProtoBuf.TypeAlias $this$underlyingType, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type;
        Intrinsics.checkNotNullParameter($this$underlyingType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$underlyingType.hasUnderlyingType()) {
            ProtoBuf.Type type2 = $this$underlyingType.getUnderlyingType();
            type = type2;
            Intrinsics.checkNotNullExpressionValue(type2, "getUnderlyingType(...)");
        } else if ($this$underlyingType.hasUnderlyingTypeId()) {
            type = typeTable.get($this$underlyingType.getUnderlyingTypeId());
        } else {
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
        return type;
    }

    @NotNull
    public static final ProtoBuf.Type expandedType(@NotNull ProtoBuf.TypeAlias $this$expandedType, @NotNull TypeTable typeTable) {
        ProtoBuf.Type type;
        Intrinsics.checkNotNullParameter($this$expandedType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if ($this$expandedType.hasExpandedType()) {
            ProtoBuf.Type type2 = $this$expandedType.getExpandedType();
            type = type2;
            Intrinsics.checkNotNullExpressionValue(type2, "getExpandedType(...)");
        } else if ($this$expandedType.hasExpandedTypeId()) {
            type = typeTable.get($this$expandedType.getExpandedTypeId());
        } else {
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
        return type;
    }

    @Nullable
    public static final ProtoBuf.Type isInstanceType(@NotNull ProtoBuf.Expression $this$isInstanceType, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$isInstanceType, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        return $this$isInstanceType.hasIsInstanceType() ? $this$isInstanceType.getIsInstanceType() : ($this$isInstanceType.hasIsInstanceTypeId() ? typeTable.get($this$isInstanceType.getIsInstanceTypeId()) : null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ProtoBuf.Type> contextReceiverTypes(@NotNull ProtoBuf.Class $this$contextReceiverTypes, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$contextReceiverTypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List list = $this$contextReceiverTypes.getContextReceiverTypeList();
        Collection p0 = list;
        boolean bl22 = false;
        List list2 = !p0.isEmpty() ? list : null;
        if (list2 == null) {
            void $this$mapTo$iv$iv;
            List<Integer> list3 = $this$contextReceiverTypes.getContextReceiverTypeIdList();
            Intrinsics.checkNotNullExpressionValue(list3, "getContextReceiverTypeIdList(...)");
            Iterable $this$map$iv = list3;
            boolean $i$f$map = false;
            Iterable bl22 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Integer n2 = (Integer)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull(it);
                collection.add(typeTable.get(it.intValue()));
            }
            list2 = (List)destination$iv$iv;
        }
        return list2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ProtoBuf.Type> contextReceiverTypes(@NotNull ProtoBuf.Function $this$contextReceiverTypes, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$contextReceiverTypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List list = $this$contextReceiverTypes.getContextReceiverTypeList();
        Collection p0 = list;
        boolean bl22 = false;
        List list2 = !p0.isEmpty() ? list : null;
        if (list2 == null) {
            void $this$mapTo$iv$iv;
            List<Integer> list3 = $this$contextReceiverTypes.getContextReceiverTypeIdList();
            Intrinsics.checkNotNullExpressionValue(list3, "getContextReceiverTypeIdList(...)");
            Iterable $this$map$iv = list3;
            boolean $i$f$map = false;
            Iterable bl22 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Integer n2 = (Integer)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull(it);
                collection.add(typeTable.get(it.intValue()));
            }
            list2 = (List)destination$iv$iv;
        }
        return list2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ProtoBuf.Type> contextReceiverTypes(@NotNull ProtoBuf.Property $this$contextReceiverTypes, @NotNull TypeTable typeTable) {
        Intrinsics.checkNotNullParameter($this$contextReceiverTypes, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List list = $this$contextReceiverTypes.getContextReceiverTypeList();
        Collection p0 = list;
        boolean bl22 = false;
        List list2 = !p0.isEmpty() ? list : null;
        if (list2 == null) {
            void $this$mapTo$iv$iv;
            List<Integer> list3 = $this$contextReceiverTypes.getContextReceiverTypeIdList();
            Intrinsics.checkNotNullExpressionValue(list3, "getContextReceiverTypeIdList(...)");
            Iterable $this$map$iv = list3;
            boolean $i$f$map = false;
            Iterable bl22 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Integer n2 = (Integer)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull(it);
                collection.add(typeTable.get(it.intValue()));
            }
            list2 = (List)destination$iv$iv;
        }
        return list2;
    }
}

