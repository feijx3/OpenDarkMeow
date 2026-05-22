/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.builders.ListBuilderKt;
import kotlin.collections.builders.MapBuilderEntries;
import kotlin.collections.builders.MapBuilderKeys;
import kotlin.collections.builders.MapBuilderValues;
import kotlin.collections.builders.SerializedMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0084\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\f\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001BG\b\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0013J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020!H\u0016J\u0015\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00100J\u0015\u00101\u001a\u00020!2\u0006\u0010\u0017\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u00100J\u0018\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u00103J\u001f\u00104\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u00105J\u001e\u00106\u001a\u00020*2\u0014\u00107\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&H\u0016J\u0017\u00108\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00103J\b\u00109\u001a\u00020*H\u0016J\u0013\u0010E\u001a\u00020!2\b\u0010F\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010G\u001a\u00020\rH\u0016J\b\u0010H\u001a\u00020IH\u0016J\b\u0010N\u001a\u00020*H\u0002J\r\u0010O\u001a\u00020*H\u0000\u00a2\u0006\u0002\bPJ\u0010\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020\rH\u0002J\u0010\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020\rH\u0002J\u0010\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020\rH\u0002J\u0013\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0002\u00a2\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020\r2\u0006\u0010/\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020!H\u0002J\u0010\u0010]\u001a\u00020*2\u0006\u0010^\u001a\u00020\rH\u0002J\u0010\u0010_\u001a\u00020!2\u0006\u0010`\u001a\u00020\rH\u0002J\u0015\u0010a\u001a\u00020\r2\u0006\u0010/\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010ZJ\u0015\u0010b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u0001H\u0002\u00a2\u0006\u0002\u0010ZJ\u0017\u0010c\u001a\u00020\r2\u0006\u0010/\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\bd\u0010ZJ\u0017\u0010e\u001a\u00020!2\u0006\u0010/\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\bf\u00100J\u0010\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020\rH\u0002J\u0010\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\rH\u0002J!\u0010k\u001a\u00020!2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0000\u00a2\u0006\u0002\bnJ\u0018\u0010o\u001a\u00020!2\u000e\u0010F\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030&H\u0002J\u0019\u0010p\u001a\u00020!2\n\u0010q\u001a\u0006\u0012\u0002\b\u00030rH\u0000\u00a2\u0006\u0002\bsJ\u001c\u0010t\u001a\u00020!2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0002J\"\u0010u\u001a\u00020!2\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010m0rH\u0002J!\u0010v\u001a\u00020!2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0000\u00a2\u0006\u0002\bwJ\u0017\u0010x\u001a\u00020!2\u0006\u0010y\u001a\u00028\u0001H\u0000\u00a2\u0006\u0004\bz\u00100J\u0019\u0010{\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010|H\u0000\u00a2\u0006\u0002\b}J\u001a\u0010~\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u007fH\u0000\u00a2\u0006\u0003\b\u0080\u0001J\u001c\u0010\u0081\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001H\u0000\u00a2\u0006\u0003\b\u0083\u0001R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010?8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR&\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0;8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010=R\u0014\u0010J\u001a\u00020\r8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010\u001aR\u0014\u0010L\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010\u001a\u00a8\u0006\u008a\u0001"}, d2={"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "", "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "[Ljava/lang/Object;", "hashShift", "modCount", "value", "size", "getSize", "()I", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "build", "", "writeReplace", "", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "isEmpty", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "clear", "keys", "", "getKeys", "()Ljava/util/Set;", "values", "", "getValues", "()Ljava/util/Collection;", "entries", "", "getEntries", "equals", "other", "hashCode", "toString", "", "capacity", "getCapacity$kotlin_stdlib", "hashSize", "getHashSize", "registerModification", "checkIsMutable", "checkIsMutable$kotlin_stdlib", "ensureExtraCapacity", "n", "shouldCompact", "extraCapacity", "ensureCapacity", "minCapacity", "allocateValuesArray", "()[Ljava/lang/Object;", "hash", "(Ljava/lang/Object;)I", "compact", "updateHashArray", "rehash", "newHashSize", "putRehash", "i", "findKey", "findValue", "addKey", "addKey$kotlin_stdlib", "removeKey", "removeKey$kotlin_stdlib", "removeEntryAt", "index", "removeHashAt", "removedHash", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "contentEquals", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "putEntry", "putAllEntries", "removeEntry", "removeEntry$kotlin_stdlib", "removeValue", "element", "removeValue$kotlin_stdlib", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "Companion", "Itr", "KeysItr", "ValuesItr", "EntriesItr", "EntryRef", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,751:1\n1#2:752\n*E\n"})
public final class MapBuilder<K, V>
implements Map<K, V>,
Serializable,
KMutableMap {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private K[] keysArray;
    @Nullable
    private V[] valuesArray;
    @NotNull
    private int[] presenceArray;
    @NotNull
    private int[] hashArray;
    private int maxProbeDistance;
    private int length;
    private int hashShift;
    private int modCount;
    private int size;
    @Nullable
    private MapBuilderKeys<K> keysView;
    @Nullable
    private MapBuilderValues<V> valuesView;
    @Nullable
    private MapBuilderEntries<K, V> entriesView;
    private boolean isReadOnly;
    private static final int MAGIC = -1640531527;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int TOMBSTONE = -1;
    @NotNull
    private static final MapBuilder Empty;

    private MapBuilder(K[] keysArray, V[] valuesArray, int[] presenceArray, int[] hashArray, int maxProbeDistance, int length) {
        this.keysArray = keysArray;
        this.valuesArray = valuesArray;
        this.presenceArray = presenceArray;
        this.hashArray = hashArray;
        this.maxProbeDistance = maxProbeDistance;
        this.length = length;
        this.hashShift = MapBuilder.Companion.computeShift(this.getHashSize());
    }

    public int getSize() {
        return this.size;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int initialCapacity) {
        this(ListBuilderKt.arrayOfUninitializedElements(initialCapacity), null, new int[initialCapacity], new int[MapBuilder.Companion.computeHashSize(initialCapacity)], 2, 0);
    }

    @NotNull
    public final Map<K, V> build() {
        Map map;
        this.checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (this.size() > 0) {
            map = this;
        } else {
            MapBuilder mapBuilder = Empty;
            Intrinsics.checkNotNull(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
            map = mapBuilder;
        }
        return map;
    }

    private final Object writeReplace() {
        if (!this.isReadOnly) {
            throw new NotSerializableException("The map cannot be serialized while it is being built.");
        }
        return new SerializedMap(this);
    }

    private final void readObject(ObjectInputStream input) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return this.findKey(key) >= 0;
    }

    @Override
    public boolean containsValue(Object value) {
        return this.findValue(value) >= 0;
    }

    @Override
    @Nullable
    public V get(Object key) {
        int index = this.findKey(key);
        if (index < 0) {
            return null;
        }
        Intrinsics.checkNotNull(this.valuesArray);
        return this.valuesArray[index];
    }

    @Override
    @Nullable
    public V put(K key, V value) {
        this.checkIsMutable$kotlin_stdlib();
        int index = this.addKey$kotlin_stdlib(key);
        V[] valuesArray = this.allocateValuesArray();
        if (index < 0) {
            V oldValue = valuesArray[-index - 1];
            valuesArray[-index - 1] = value;
            return oldValue;
        }
        valuesArray[index] = value;
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.checkIsMutable$kotlin_stdlib();
        this.putAllEntries((Collection)from.entrySet());
    }

    @Override
    @Nullable
    public V remove(Object key) {
        this.checkIsMutable$kotlin_stdlib();
        int index = this.findKey(key);
        if (index < 0) {
            return null;
        }
        Intrinsics.checkNotNull(this.valuesArray);
        V oldValue = this.valuesArray[index];
        this.removeEntryAt(index);
        return oldValue;
    }

    @Override
    public void clear() {
        this.checkIsMutable$kotlin_stdlib();
        int i2 = 0;
        int n2 = this.length - 1;
        if (i2 <= n2) {
            while (true) {
                int hash;
                if ((hash = this.presenceArray[i2]) >= 0) {
                    this.hashArray[hash] = 0;
                    this.presenceArray[i2] = -1;
                }
                if (i2 == n2) break;
                ++i2;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        if (this.valuesArray != null) {
            ListBuilderKt.resetRange(this.valuesArray, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        this.registerModification();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Set<K> getKeys() {
        Set set;
        MapBuilderKeys<K> cur = this.keysView;
        if (cur == null) {
            void var2_2;
            MapBuilderKeys mapBuilderKeys = new MapBuilderKeys(this);
            this.keysView = mapBuilderKeys;
            set = (Set)var2_2;
        } else {
            set = cur;
        }
        return set;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<V> getValues() {
        Collection collection;
        MapBuilderValues<V> cur = this.valuesView;
        if (cur == null) {
            void var2_2;
            MapBuilderValues mapBuilderValues = new MapBuilderValues(this);
            this.valuesView = mapBuilderValues;
            collection = (Collection)var2_2;
        } else {
            collection = cur;
        }
        return collection;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> cur = this.entriesView;
        if (cur == null) {
            MapBuilderEntries mapBuilderEntries = new MapBuilderEntries(this);
            this.entriesView = mapBuilderEntries;
            return mapBuilderEntries;
        }
        return cur;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return other == this || other instanceof Map && this.contentEquals((Map)other);
    }

    @Override
    public int hashCode() {
        int result = 0;
        EntriesItr<K, V> it = this.entriesIterator$kotlin_stdlib();
        while (it.hasNext()) {
            result += it.nextHashCode$kotlin_stdlib();
        }
        return result;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder(2 + this.size() * 3);
        sb.append("{");
        int i2 = 0;
        EntriesItr<K, V> it = this.entriesIterator$kotlin_stdlib();
        while (it.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            it.nextAppendString(sb);
            ++i2;
        }
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final void registerModification() {
        ++this.modCount;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final void ensureExtraCapacity(int n2) {
        if (this.shouldCompact(n2)) {
            this.compact(true);
        } else {
            this.ensureCapacity(this.length + n2);
        }
    }

    private final boolean shouldCompact(int extraCapacity) {
        int spareCapacity = this.getCapacity$kotlin_stdlib() - this.length;
        int gaps = this.length - this.size();
        return spareCapacity < extraCapacity && gaps + spareCapacity >= extraCapacity && gaps >= this.getCapacity$kotlin_stdlib() / 4;
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > this.getCapacity$kotlin_stdlib()) {
            int newSize = AbstractList.Companion.newCapacity$kotlin_stdlib(this.getCapacity$kotlin_stdlib(), minCapacity);
            this.keysArray = ListBuilderKt.copyOfUninitializedElements(this.keysArray, newSize);
            this.valuesArray = this.valuesArray != null ? ListBuilderKt.copyOfUninitializedElements(this.valuesArray, newSize) : null;
            int[] nArray = Arrays.copyOf(this.presenceArray, newSize);
            Intrinsics.checkNotNullExpressionValue(nArray, "copyOf(...)");
            this.presenceArray = nArray;
            int newHashSize = MapBuilder.Companion.computeHashSize(newSize);
            if (newHashSize > this.getHashSize()) {
                this.rehash(newHashSize);
            }
        }
    }

    private final V[] allocateValuesArray() {
        V[] curValuesArray = this.valuesArray;
        if (curValuesArray != null) {
            return curValuesArray;
        }
        E[] newValuesArray = ListBuilderKt.arrayOfUninitializedElements(this.getCapacity$kotlin_stdlib());
        this.valuesArray = newValuesArray;
        return newValuesArray;
    }

    private final int hash(K key) {
        K k2 = key;
        return (k2 != null ? k2.hashCode() : 0) * -1640531527 >>> this.hashShift;
    }

    private final void compact(boolean updateHashArray) {
        int j2 = 0;
        V[] valuesArray = this.valuesArray;
        for (int i2 = 0; i2 < this.length; ++i2) {
            int hash = this.presenceArray[i2];
            if (hash < 0) continue;
            this.keysArray[j2] = this.keysArray[i2];
            if (valuesArray != null) {
                valuesArray[j2] = valuesArray[i2];
            }
            if (updateHashArray) {
                this.presenceArray[j2] = hash;
                this.hashArray[hash] = j2 + 1;
            }
            ++j2;
        }
        ListBuilderKt.resetRange(this.keysArray, j2, this.length);
        if (valuesArray != null) {
            ListBuilderKt.resetRange(valuesArray, j2, this.length);
        }
        this.length = j2;
    }

    private final void rehash(int newHashSize) {
        this.registerModification();
        if (this.length > this.size()) {
            this.compact(false);
        }
        this.hashArray = new int[newHashSize];
        this.hashShift = MapBuilder.Companion.computeShift(newHashSize);
        int i2 = 0;
        while (i2 < this.length) {
            if (this.putRehash(i2++)) continue;
            throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
        }
    }

    private final boolean putRehash(int i2) {
        int hash = this.hash(this.keysArray[i2]);
        int probesLeft = this.maxProbeDistance;
        while (true) {
            int index;
            if ((index = this.hashArray[hash]) == 0) {
                this.hashArray[hash] = i2 + 1;
                this.presenceArray[i2] = hash;
                return true;
            }
            if (--probesLeft < 0) {
                return false;
            }
            if (hash-- != 0) continue;
            hash = this.getHashSize() - 1;
        }
    }

    private final int findKey(K key) {
        int hash = this.hash(key);
        int probesLeft = this.maxProbeDistance;
        int index;
        while ((index = this.hashArray[hash]) != 0) {
            if (index > 0 && Intrinsics.areEqual(this.keysArray[index - 1], key)) {
                return index - 1;
            }
            if (--probesLeft < 0) {
                return -1;
            }
            if (hash-- != 0) continue;
            hash = this.getHashSize() - 1;
        }
        return -1;
    }

    private final int findValue(V value) {
        int i2 = this.length;
        while (--i2 >= 0) {
            if (this.presenceArray[i2] < 0) continue;
            Intrinsics.checkNotNull(this.valuesArray);
            if (!Intrinsics.areEqual(this.valuesArray[i2], value)) continue;
            return i2;
        }
        return -1;
    }

    public final int addKey$kotlin_stdlib(K key) {
        this.checkIsMutable$kotlin_stdlib();
        block0: while (true) {
            int hash = this.hash(key);
            int tentativeMaxProbeDistance = RangesKt.coerceAtMost(this.maxProbeDistance * 2, this.getHashSize() / 2);
            int probeDistance = 0;
            while (true) {
                int index;
                if ((index = this.hashArray[hash]) <= 0) {
                    if (this.length >= this.getCapacity$kotlin_stdlib()) {
                        this.ensureExtraCapacity(1);
                        continue block0;
                    }
                    int n2 = this.length;
                    this.length = n2 + 1;
                    int putIndex = n2;
                    this.keysArray[putIndex] = key;
                    this.presenceArray[putIndex] = hash;
                    this.hashArray[hash] = putIndex + 1;
                    n2 = this.size();
                    this.size = n2 + 1;
                    this.registerModification();
                    if (probeDistance > this.maxProbeDistance) {
                        this.maxProbeDistance = probeDistance;
                    }
                    return putIndex;
                }
                if (Intrinsics.areEqual(this.keysArray[index - 1], key)) {
                    return -index;
                }
                if (++probeDistance > tentativeMaxProbeDistance) {
                    this.rehash(this.getHashSize() * 2);
                    continue block0;
                }
                if (hash-- != 0) continue;
                hash = this.getHashSize() - 1;
            }
            break;
        }
    }

    public final boolean removeKey$kotlin_stdlib(K key) {
        this.checkIsMutable$kotlin_stdlib();
        int index = this.findKey(key);
        if (index < 0) {
            return false;
        }
        this.removeEntryAt(index);
        return true;
    }

    private final void removeEntryAt(int index) {
        ListBuilderKt.resetAt(this.keysArray, index);
        if (this.valuesArray != null) {
            ListBuilderKt.resetAt(this.valuesArray, index);
        }
        this.removeHashAt(this.presenceArray[index]);
        this.presenceArray[index] = -1;
        int n2 = this.size();
        this.size = n2 + -1;
        this.registerModification();
    }

    private final void removeHashAt(int removedHash) {
        int hash = removedHash;
        int hole = removedHash;
        int probeDistance = 0;
        int patchAttemptsLeft = RangesKt.coerceAtMost(this.maxProbeDistance * 2, this.getHashSize() / 2);
        do {
            if (hash-- == 0) {
                hash = this.getHashSize() - 1;
            }
            if (++probeDistance > this.maxProbeDistance) {
                this.hashArray[hole] = 0;
                return;
            }
            int index = this.hashArray[hash];
            if (index == 0) {
                this.hashArray[hole] = 0;
                return;
            }
            if (index < 0) {
                this.hashArray[hole] = -1;
                hole = hash;
                probeDistance = 0;
                continue;
            }
            int otherHash = this.hash(this.keysArray[index - 1]);
            if ((otherHash - hash & this.getHashSize() - 1) < probeDistance) continue;
            this.hashArray[hole] = index;
            this.presenceArray[index - 1] = hole;
            hole = hash;
            probeDistance = 0;
        } while (--patchAttemptsLeft >= 0);
        this.hashArray[hole] = -1;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int index = this.findKey(entry.getKey());
        if (index < 0) {
            return false;
        }
        Intrinsics.checkNotNull(this.valuesArray);
        return Intrinsics.areEqual(this.valuesArray[index], entry.getValue());
    }

    private final boolean contentEquals(Map<?, ?> other) {
        return this.size() == other.size() && this.containsAllEntries$kotlin_stdlib((Collection)other.entrySet());
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> m2) {
        Intrinsics.checkNotNullParameter(m2, "m");
        for (Object entry : m2) {
            try {
                if (entry != null && this.containsEntry$kotlin_stdlib((Map.Entry)entry)) continue;
                return false;
            }
            catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int index = this.addKey$kotlin_stdlib(entry.getKey());
        V[] valuesArray = this.allocateValuesArray();
        if (index >= 0) {
            valuesArray[index] = entry.getValue();
            return true;
        }
        V oldValue = valuesArray[-index - 1];
        if (!Intrinsics.areEqual(entry.getValue(), oldValue)) {
            valuesArray[-index - 1] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        if (from.isEmpty()) {
            return false;
        }
        this.ensureExtraCapacity(from.size());
        Iterator<Map.Entry<K, V>> it = from.iterator();
        boolean updated = false;
        while (it.hasNext()) {
            if (!this.putEntry(it.next())) continue;
            updated = true;
        }
        return updated;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.checkIsMutable$kotlin_stdlib();
        int index = this.findKey(entry.getKey());
        if (index < 0) {
            return false;
        }
        Intrinsics.checkNotNull(this.valuesArray);
        if (!Intrinsics.areEqual(this.valuesArray[index], entry.getValue())) {
            return false;
        }
        this.removeEntryAt(index);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V element) {
        this.checkIsMutable$kotlin_stdlib();
        int index = this.findValue(element);
        if (index < 0) {
            return false;
        }
        this.removeEntryAt(index);
        return true;
    }

    @NotNull
    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr(this);
    }

    @NotNull
    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr(this);
    }

    @NotNull
    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr(this);
    }

    static {
        MapBuilder mapBuilder;
        Companion = new Companion(null);
        MapBuilder it = mapBuilder = new MapBuilder(0);
        boolean bl2 = false;
        it.isReadOnly = true;
        Empty = mapBuilder;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2={"Lkotlin/collections/builders/MapBuilder$Companion;", "", "<init>", "()V", "MAGIC", "", "INITIAL_CAPACITY", "INITIAL_MAX_PROBE_DISTANCE", "TOMBSTONE", "Empty", "Lkotlin/collections/builders/MapBuilder;", "", "getEmpty$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapBuilder getEmpty$kotlin_stdlib() {
            return Empty;
        }

        private final int computeHashSize(int capacity) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(capacity, 1) * 3);
        }

        private final int computeShift(int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000bH\u0096\u0002J\r\u0010\f\u001a\u00020\rH\u0000\u00a2\u0006\u0002\b\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013\u00a8\u0006\u0014"}, d2={"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "kotlin-stdlib"})
    public static final class EntriesItr<K, V>
    extends Itr<K, V>
    implements Iterator<Map.Entry<K, V>>,
    KMutableIterator {
        public EntriesItr(@NotNull MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }

        @Override
        @NotNull
        public EntryRef<K, V> next() {
            this.checkForComodification$kotlin_stdlib();
            if (this.getIndex$kotlin_stdlib() >= this.getMap$kotlin_stdlib().length) {
                throw new NoSuchElementException();
            }
            int n2 = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(n2 + 1);
            this.setLastIndex$kotlin_stdlib(n2);
            EntryRef result = new EntryRef(this.getMap$kotlin_stdlib(), this.getLastIndex$kotlin_stdlib());
            this.initNext$kotlin_stdlib();
            return result;
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (this.getIndex$kotlin_stdlib() >= this.getMap$kotlin_stdlib().length) {
                throw new NoSuchElementException();
            }
            int n2 = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(n2 + 1);
            this.setLastIndex$kotlin_stdlib(n2);
            Object object = this.getMap$kotlin_stdlib().keysArray[this.getLastIndex$kotlin_stdlib()];
            int n3 = object != null ? object.hashCode() : 0;
            Object[] objectArray = this.getMap$kotlin_stdlib().valuesArray;
            Intrinsics.checkNotNull(objectArray);
            Object object2 = objectArray[this.getLastIndex$kotlin_stdlib()];
            int result = n3 ^ (object2 != null ? object2.hashCode() : 0);
            this.initNext$kotlin_stdlib();
            return result;
        }

        public final void nextAppendString(@NotNull StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (this.getIndex$kotlin_stdlib() >= this.getMap$kotlin_stdlib().length) {
                throw new NoSuchElementException();
            }
            int n2 = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(n2 + 1);
            this.setLastIndex$kotlin_stdlib(n2);
            Object key = this.getMap$kotlin_stdlib().keysArray[this.getLastIndex$kotlin_stdlib()];
            StringBuilder stringBuilder = key == this.getMap$kotlin_stdlib() ? sb.append("(this Map)") : sb.append(key);
            sb.append('=');
            Object[] objectArray = this.getMap$kotlin_stdlib().valuesArray;
            Intrinsics.checkNotNull(objectArray);
            Object value = objectArray[this.getLastIndex$kotlin_stdlib()];
            StringBuilder stringBuilder2 = value == this.getMap$kotlin_stdlib() ? sb.append("(this Map)") : sb.append(value);
            this.initNext$kotlin_stdlib();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0010\u001a\u00028\u00032\u0006\u0010\u0011\u001a\u00028\u0003H\u0016\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00028\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001c"}, d2={"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "expectedModCount", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "toString", "", "checkForComodification", "", "kotlin-stdlib"})
    public static final class EntryRef<K, V>
    implements Map.Entry<K, V>,
    KMutableMap.Entry {
        @NotNull
        private final MapBuilder<K, V> map;
        private final int index;
        private final int expectedModCount;

        public EntryRef(@NotNull MapBuilder<K, V> map, int index) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.index = index;
            this.expectedModCount = ((MapBuilder)this.map).modCount;
        }

        @Override
        public K getKey() {
            this.checkForComodification();
            return (K)((MapBuilder)this.map).keysArray[this.index];
        }

        @Override
        public V getValue() {
            this.checkForComodification();
            Object[] objectArray = ((MapBuilder)this.map).valuesArray;
            Intrinsics.checkNotNull(objectArray);
            return (V)objectArray[this.index];
        }

        @Override
        public V setValue(V newValue) {
            this.checkForComodification();
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] valuesArray = ((MapBuilder)this.map).allocateValuesArray();
            Object oldValue = valuesArray[this.index];
            valuesArray[this.index] = newValue;
            return (V)oldValue;
        }

        @Override
        public boolean equals(@Nullable Object other) {
            return other instanceof Map.Entry && Intrinsics.areEqual(((Map.Entry)other).getKey(), this.getKey()) && Intrinsics.areEqual(((Map.Entry)other).getValue(), this.getValue());
        }

        @Override
        public int hashCode() {
            K k2 = this.getKey();
            V v2 = this.getValue();
            return (k2 != null ? k2.hashCode() : 0) ^ (v2 != null ? v2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "" + this.getKey() + '=' + this.getValue();
        }

        private final void checkForComodification() {
            if (((MapBuilder)this.map).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0014\u001a\u00020\u0015H\u0000\u00a2\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0015J\r\u0010\u001a\u001a\u00020\u0015H\u0000\u00a2\u0006\u0002\b\u001bR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "expectedModCount", "initNext", "", "initNext$kotlin_stdlib", "hasNext", "", "remove", "checkForComodification", "checkForComodification$kotlin_stdlib", "kotlin-stdlib"})
    @SourceDebugExtension(value={"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,751:1\n1#2:752\n*E\n"})
    public static class Itr<K, V> {
        @NotNull
        private final MapBuilder<K, V> map;
        private int index;
        private int lastIndex;
        private int expectedModCount;

        public Itr(@NotNull MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.lastIndex = -1;
            this.expectedModCount = ((MapBuilder)this.map).modCount;
            this.initNext$kotlin_stdlib();
        }

        @NotNull
        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final void setIndex$kotlin_stdlib(int n2) {
            this.index = n2;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final void setLastIndex$kotlin_stdlib(int n2) {
            this.lastIndex = n2;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < ((MapBuilder)this.map).length && ((MapBuilder)this.map).presenceArray[this.index] < 0) {
                int n2 = this.index;
                this.index = n2 + 1;
            }
        }

        public final boolean hasNext() {
            return this.index < ((MapBuilder)this.map).length;
        }

        public final void remove() {
            this.checkForComodification$kotlin_stdlib();
            if (!(this.lastIndex != -1)) {
                boolean bl2 = false;
                String string = "Call next() before removing element from the iterator.";
                throw new IllegalStateException(string.toString());
            }
            this.map.checkIsMutable$kotlin_stdlib();
            ((MapBuilder)this.map).removeEntryAt(this.lastIndex);
            this.lastIndex = -1;
            this.expectedModCount = ((MapBuilder)this.map).modCount;
        }

        public final void checkForComodification$kotlin_stdlib() {
            if (((MapBuilder)this.map).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class KeysItr<K, V>
    extends Itr<K, V>
    implements Iterator<K>,
    KMutableIterator {
        public KeysItr(@NotNull MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }

        @Override
        public K next() {
            this.checkForComodification$kotlin_stdlib();
            if (this.getIndex$kotlin_stdlib() >= this.getMap$kotlin_stdlib().length) {
                throw new NoSuchElementException();
            }
            int n2 = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(n2 + 1);
            this.setLastIndex$kotlin_stdlib(n2);
            Object result = this.getMap$kotlin_stdlib().keysArray[this.getLastIndex$kotlin_stdlib()];
            this.initNext$kotlin_stdlib();
            return (K)result;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00028\u0003H\u0096\u0002\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class ValuesItr<K, V>
    extends Itr<K, V>
    implements Iterator<V>,
    KMutableIterator {
        public ValuesItr(@NotNull MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }

        @Override
        public V next() {
            this.checkForComodification$kotlin_stdlib();
            if (this.getIndex$kotlin_stdlib() >= this.getMap$kotlin_stdlib().length) {
                throw new NoSuchElementException();
            }
            int n2 = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(n2 + 1);
            this.setLastIndex$kotlin_stdlib(n2);
            Object[] objectArray = this.getMap$kotlin_stdlib().valuesArray;
            Intrinsics.checkNotNull(objectArray);
            Object result = objectArray[this.getLastIndex$kotlin_stdlib()];
            this.initNext$kotlin_stdlib();
            return (V)result;
        }
    }
}

