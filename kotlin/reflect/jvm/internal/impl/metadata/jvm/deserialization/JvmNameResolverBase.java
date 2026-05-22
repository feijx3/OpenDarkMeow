/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nJvmNameResolverBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n1222#2,2:107\n1252#2,4:109\n*S KotlinDebug\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n*L\n101#1:107,2\n101#1:109,4\n*E\n"})
public class JvmNameResolverBase
implements NameResolver {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String[] strings;
    @NotNull
    private final Set<Integer> localNameIndices;
    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    @NotNull
    private static final String kotlin;
    @NotNull
    private static final List<String> PREDEFINED_STRINGS;
    @NotNull
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    public JvmNameResolverBase(@NotNull String[] strings, @NotNull Set<Integer> localNameIndices, @NotNull List<JvmProtoBuf.StringTableTypes.Record> records) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(localNameIndices, "localNameIndices");
        Intrinsics.checkNotNullParameter(records, "records");
        this.strings = strings;
        this.localNameIndices = localNameIndices;
        this.records = records;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @NotNull
    public String getString(int index) {
        block13: {
            block12: {
                record = this.records.get(index);
                if (!record.hasString()) break block12;
                v0 = record.getString();
                break block13;
            }
            if (!record.hasPredefinedIndex()) ** GOTO lbl-1000
            var4_3 = ((Collection)JvmNameResolverBase.PREDEFINED_STRINGS).size();
            var5_7 = record.getPredefinedIndex();
            v1 = 0 <= var5_7 ? var5_7 < var4_3 : false;
            if (v1) {
                v0 = JvmNameResolverBase.PREDEFINED_STRINGS.get(record.getPredefinedIndex());
            } else lbl-1000:
            // 2 sources

            {
                v0 = string = this.strings[index];
            }
        }
        if (record.getSubstringIndexCount() >= 2) {
            var4_4 = record.getSubstringIndexList();
            Intrinsics.checkNotNull(var4_4);
            begin = var4_4.get(0);
            end = var4_4.get(1);
            if (0 <= begin && begin <= end && end <= string.length()) {
                var7_12 = string;
                Intrinsics.checkNotNull(var7_12);
                Intrinsics.checkNotNull(begin);
                var8_14 = begin;
                Intrinsics.checkNotNull(end);
                var9_15 = end;
                v2 = var7_12.substring(var8_14, var9_15);
                Intrinsics.checkNotNullExpressionValue(v2, "substring(...)");
                string = v2;
            }
        }
        if (record.getReplaceCharCount() >= 2) {
            var4_5 = record.getReplaceCharList();
            Intrinsics.checkNotNull(var4_5);
            from = var4_5.get(0);
            to = var4_5.get(1);
            var7_12 = string;
            Intrinsics.checkNotNull(var7_12);
            string = StringsKt.replace$default(var7_12, (char)from.intValue(), (char)to.intValue(), false, 4, null);
        }
        if ((v3 = record.getOperation()) == null) {
            v3 = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[v3.ordinal()]) {
            case 1: {
                break;
            }
            case 2: {
                var6_11 = string;
                Intrinsics.checkNotNull(var6_11);
                string = StringsKt.replace$default(var6_11, '$', '.', false, 4, null);
                break;
            }
            case 3: {
                if (string.length() >= 2) {
                    var6_11 = string;
                    Intrinsics.checkNotNull(var6_11);
                    var7_13 = 1;
                    var8_14 = string.length() - 1;
                    v4 = var6_11.substring(var7_13, var8_14);
                    Intrinsics.checkNotNullExpressionValue(v4, "substring(...)");
                    string = v4;
                }
                var6_11 = string;
                Intrinsics.checkNotNull(var6_11);
                string = StringsKt.replace$default(var6_11, '$', '.', false, 4, null);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        var4_6 = string;
        Intrinsics.checkNotNull(var4_6);
        return var4_6;
    }

    @Override
    @NotNull
    public String getQualifiedClassName(int index) {
        return this.getString(index);
    }

    @Override
    public boolean isLocalClassName(int index) {
        return this.localNameIndices.contains(index);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $this$associateByTo$iv$iv;
        Companion = new Companion(null);
        Object[] objectArray = new Character[]{Character.valueOf('k'), Character.valueOf('o'), Character.valueOf('t'), Character.valueOf('l'), Character.valueOf('i'), Character.valueOf('n')};
        kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf(objectArray), "", null, null, 0, null, null, 62, null);
        objectArray = new String[]{kotlin + "/Any", kotlin + "/Nothing", kotlin + "/Unit", kotlin + "/Throwable", kotlin + "/Number", kotlin + "/Byte", kotlin + "/Double", kotlin + "/Float", kotlin + "/Int", kotlin + "/Long", kotlin + "/Short", kotlin + "/Boolean", kotlin + "/Char", kotlin + "/CharSequence", kotlin + "/String", kotlin + "/Comparable", kotlin + "/Enum", kotlin + "/Array", kotlin + "/ByteArray", kotlin + "/DoubleArray", kotlin + "/FloatArray", kotlin + "/IntArray", kotlin + "/LongArray", kotlin + "/ShortArray", kotlin + "/BooleanArray", kotlin + "/CharArray", kotlin + "/Cloneable", kotlin + "/Annotation", kotlin + "/collections/Iterable", kotlin + "/collections/MutableIterable", kotlin + "/collections/Collection", kotlin + "/collections/MutableCollection", kotlin + "/collections/List", kotlin + "/collections/MutableList", kotlin + "/collections/Set", kotlin + "/collections/MutableSet", kotlin + "/collections/Map", kotlin + "/collections/MutableMap", kotlin + "/collections/Map.Entry", kotlin + "/collections/MutableMap.MutableEntry", kotlin + "/collections/Iterator", kotlin + "/collections/MutableIterator", kotlin + "/collections/ListIterator", kotlin + "/collections/MutableListIterator"};
        PREDEFINED_STRINGS = CollectionsKt.listOf(objectArray);
        Iterable $this$associateBy$iv = CollectionsKt.withIndex((Iterable)PREDEFINED_STRINGS);
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Iterable iterable = $this$associateBy$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            IndexedValue indexedValue = (IndexedValue)element$iv$iv;
            Map map = destination$iv$iv;
            boolean bl2 = false;
            IndexedValue it = (IndexedValue)element$iv$iv;
            String string = (String)it.getValue();
            boolean bl3 = false;
            Integer n2 = it.getIndex();
            map.put(string, n2);
        }
        PREDEFINED_STRINGS_MAP = destination$iv$iv;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                nArray[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

