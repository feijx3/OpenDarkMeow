/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nValueClassUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n1563#2:56\n1634#2,3:57\n1563#2:60\n1634#2,3:61\n1563#2:64\n1634#2,3:65\n*S KotlinDebug\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n*L\n26#1:56\n26#1:57,3\n44#1:60\n44#1:61,3\n48#1:64\n48#1:65,3\n*E\n"})
public final class ValueClassUtilKt {
    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final <T extends RigidTypeMarker> ValueClassRepresentation<T> loadValueClassRepresentation(@NotNull ProtoBuf.Class $this$loadValueClassRepresentation, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull Function1<? super ProtoBuf.Type, ? extends T> typeDeserializer, @NotNull Function1<? super Name, ? extends T> typeOfPublicProperty) {
        Intrinsics.checkNotNullParameter($this$loadValueClassRepresentation, "<this>");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(typeDeserializer, "typeDeserializer");
        Intrinsics.checkNotNullParameter(typeOfPublicProperty, "typeOfPublicProperty");
        if ($this$loadValueClassRepresentation.getMultiFieldValueClassUnderlyingNameCount() > 0) {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Pair<List<Name>, List<ProtoBuf.Type>> pair = ValueClassUtilKt.loadMultiFieldValueClassRepresentation($this$loadValueClassRepresentation, nameResolver, typeTable);
            List<Name> names = pair.component1();
            List<ProtoBuf.Type> types = pair.component2();
            Iterable iterable = types;
            Iterable iterable2 = names;
            boolean $i$f$map = false;
            void var10_13 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                destination$iv$iv.add(typeDeserializer.invoke((ProtoBuf.Type)item$iv$iv));
            }
            List list = CollectionsKt.zip(iterable2, (List)destination$iv$iv);
            return new MultiFieldValueClassRepresentation(list);
        }
        if ($this$loadValueClassRepresentation.hasInlineClassUnderlyingPropertyName()) {
            Name propertyName = NameResolverUtilKt.getName(nameResolver, $this$loadValueClassRepresentation.getInlineClassUnderlyingPropertyName());
            Object object = ProtoTypeTableUtilKt.inlineClassUnderlyingType($this$loadValueClassRepresentation, typeTable);
            if ((object == null || (object = (RigidTypeMarker)typeDeserializer.invoke((ProtoBuf.Type)object)) == null) && (object = (RigidTypeMarker)typeOfPublicProperty.invoke(propertyName)) == null) {
                String string = "cannot determine underlying type for value class " + NameResolverUtilKt.getName(nameResolver, $this$loadValueClassRepresentation.getFqName()) + " with property " + propertyName;
                throw new IllegalStateException(string.toString());
            }
            Object propertyType = object;
            return new InlineClassRepresentation<Object>(propertyName, propertyType);
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Pair<List<Name>, List<ProtoBuf.Type>> loadMultiFieldValueClassRepresentation(@NotNull ProtoBuf.Class $this$loadMultiFieldValueClassRepresentation, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        List list;
        Collection collection;
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$loadMultiFieldValueClassRepresentation, "<this>");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<Integer> list2 = $this$loadMultiFieldValueClassRepresentation.getMultiFieldValueClassUnderlyingNameList();
        Intrinsics.checkNotNullExpressionValue(list2, "getMultiFieldValueClassUnderlyingNameList(...)");
        Iterable $this$map$iv = list2;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Integer n2 = (Integer)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(NameResolverUtilKt.getName(nameResolver, it.intValue()));
        }
        List names = (List)destination$iv$iv;
        int typeIdCount = $this$loadMultiFieldValueClassRepresentation.getMultiFieldValueClassUnderlyingTypeIdCount();
        int typeCount = $this$loadMultiFieldValueClassRepresentation.getMultiFieldValueClassUnderlyingTypeCount();
        Pair<Integer, Integer> pair = TuplesKt.to(typeIdCount, typeCount);
        if (Intrinsics.areEqual(pair, TuplesKt.to(names.size(), 0))) {
            void $this$mapTo$iv$iv2;
            Object item$iv$iv;
            List<Integer> list3 = $this$loadMultiFieldValueClassRepresentation.getMultiFieldValueClassUnderlyingTypeIdList();
            Intrinsics.checkNotNullExpressionValue(list3, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
            Iterable $this$map$iv2 = list3;
            boolean $i$f$map2 = false;
            item$iv$iv = $this$map$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            boolean $i$f$mapTo2 = false;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                void it;
                Integer n3 = (Integer)item$iv$iv2;
                collection = destination$iv$iv2;
                boolean bl3 = false;
                Intrinsics.checkNotNull(it);
                collection.add(typeTable.get(it.intValue()));
            }
            list = (List)destination$iv$iv2;
        } else if (Intrinsics.areEqual(pair, TuplesKt.to(0, names.size()))) {
            list = $this$loadMultiFieldValueClassRepresentation.getMultiFieldValueClassUnderlyingTypeList();
        } else {
            throw new IllegalStateException(("class " + NameResolverUtilKt.getName(nameResolver, $this$loadMultiFieldValueClassRepresentation.getFqName()) + " has illegal multi-field value class representation").toString());
        }
        List types = list;
        return TuplesKt.to(names, types);
    }
}

