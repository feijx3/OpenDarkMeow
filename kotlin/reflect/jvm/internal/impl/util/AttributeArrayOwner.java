/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl;
import kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap;
import kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nAttributeArrayOwner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttributeArrayOwner.kt\norg/jetbrains/kotlin/util/AttributeArrayOwner\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1573#2:104\n1604#2,3:105\n295#2,2:108\n1607#2:110\n*S KotlinDebug\n*F\n+ 1 AttributeArrayOwner.kt\norg/jetbrains/kotlin/util/AttributeArrayOwner\n*L\n76#1:104\n76#1:105,3\n77#1:108,2\n76#1:110\n*E\n"})
public abstract class AttributeArrayOwner<K, T>
extends AbstractArrayMapOwner<K, T> {
    @NotNull
    private ArrayMap<T> arrayMap;

    protected AttributeArrayOwner(@NotNull ArrayMap<T> arrayMap) {
        Intrinsics.checkNotNullParameter(arrayMap, "arrayMap");
        this.arrayMap = arrayMap;
    }

    @Override
    @NotNull
    protected final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    public AttributeArrayOwner() {
        EmptyArrayMap emptyArrayMap = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(emptyArrayMap, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(emptyArrayMap);
    }

    @Override
    protected final void registerComponent(@NotNull String keyQualifiedName, @NotNull T value) {
        Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        Intrinsics.checkNotNullParameter(value, "value");
        int id = this.getTypeRegistry().getId(keyQualifiedName);
        switch (this.arrayMap.getSize()) {
            case 0: {
                ArrayMap<T> map = this.arrayMap;
                if (!(map instanceof EmptyArrayMap)) {
                    throw new IllegalStateException(this.buildDiagnosticMessage(map, 0, "EmptyArrayMap"));
                }
                this.arrayMap = new OneElementArrayMap<T>(value, id);
                return;
            }
            case 1: {
                OneElementArrayMap oneElementArrayMap;
                ArrayMap<T> mapSnapshot = this.arrayMap;
                try {
                    Intrinsics.checkNotNull(mapSnapshot, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                    oneElementArrayMap = (OneElementArrayMap)mapSnapshot;
                }
                catch (ClassCastException e2) {
                    throw new IllegalStateException(this.buildDiagnosticMessage(mapSnapshot, 1, "OneElementArrayMap"), e2);
                }
                OneElementArrayMap map = oneElementArrayMap;
                if (map.getIndex() == id) {
                    this.arrayMap = new OneElementArrayMap<T>(value, id);
                    return;
                }
                ArrayMapImpl newMap = new ArrayMapImpl();
                newMap.set(map.getIndex(), map.getValue());
                this.arrayMap = newMap;
            }
        }
        this.arrayMap.set(id, value);
    }

    /*
     * WARNING - void declaration
     */
    private final String buildDiagnosticMessage(ArrayMap<T> map, int expectedSize, String expectedImplementation) {
        void $this$mapIndexedTo$iv$iv;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        StringBuilder $this$buildDiagnosticMessage_u24lambda_u243 = stringBuilder2 = new StringBuilder();
        boolean bl2 = false;
        $this$buildDiagnosticMessage_u24lambda_u243.append("Race condition happened, the size of ArrayMap is " + expectedSize + " but it isn't an `" + expectedImplementation + '`').append('\n');
        $this$buildDiagnosticMessage_u24lambda_u243.append("Type: " + map.getClass()).append('\n');
        StringBuilder $this$buildDiagnosticMessage_u24lambda_u243_u24lambda_u242 = stringBuilder = new StringBuilder();
        boolean bl3 = false;
        Map<String, Integer> services = this.getTypeRegistry().allValuesThreadUnsafeForRendering();
        $this$buildDiagnosticMessage_u24lambda_u243_u24lambda_u242.append("[").append('\n');
        Iterable $this$mapIndexed$iv = map;
        boolean $i$f$mapIndexed = false;
        Iterable iterable = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            void value;
            Object v0;
            void index;
            Collection collection;
            block3: {
                int n2;
                if ((n2 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object t2 = item$iv$iv;
                int n3 = n2;
                collection = destination$iv$iv;
                boolean bl4 = false;
                Iterable $this$firstOrNull$iv = services.entrySet();
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Map.Entry it = (Map.Entry)element$iv;
                    boolean bl5 = false;
                    if (!(((Number)it.getValue()).intValue() == index)) continue;
                    v0 = element$iv;
                    break block3;
                }
                v0 = null;
            }
            Map.Entry service = v0;
            collection.add($this$buildDiagnosticMessage_u24lambda_u243_u24lambda_u242.append("  " + service + '[' + (int)index + "]: " + value).append('\n'));
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        $this$buildDiagnosticMessage_u24lambda_u243_u24lambda_u242.append("]").append('\n');
        String content = stringBuilder.toString();
        $this$buildDiagnosticMessage_u24lambda_u243.append("Content: " + content).append('\n');
        return stringBuilder2.toString();
    }
}

