/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nTypeTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeTable.kt\norg/jetbrains/kotlin/metadata/deserialization/TypeTable\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1573#2:37\n1604#2,4:38\n*S KotlinDebug\n*F\n+ 1 TypeTable.kt\norg/jetbrains/kotlin/metadata/deserialization/TypeTable\n*L\n26#1:37\n26#1:38,4\n*E\n"})
public final class TypeTable {
    @NotNull
    private final List<ProtoBuf.Type> types;

    /*
     * WARNING - void declaration
     */
    public TypeTable(@NotNull ProtoBuf.TypeTable typeTable) {
        List list;
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        TypeTable typeTable2 = this;
        TypeTable typeTable3 = this;
        boolean bl2 = false;
        List originalTypes = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            void $this$mapIndexedTo$iv$iv;
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> list2 = typeTable.getTypeList();
            Intrinsics.checkNotNullExpressionValue(list2, "getTypeList(...)");
            Iterable $this$mapIndexed$iv = list2;
            boolean $i$f$mapIndexed = false;
            Iterable iterable = $this$mapIndexed$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void type;
                void i2;
                int n2;
                if ((n2 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf.Type type2 = (ProtoBuf.Type)item$iv$iv;
                int n3 = n2;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add(i2 >= firstNullable ? type.toBuilder().setNullable(true).build() : type);
            }
            list = (List)destination$iv$iv;
        } else {
            list = originalTypes;
        }
        Intrinsics.checkNotNullExpressionValue(list, "run(...)");
        typeTable3.types = list;
    }

    @NotNull
    public final ProtoBuf.Type get(int index) {
        return this.types.get(index);
    }
}

