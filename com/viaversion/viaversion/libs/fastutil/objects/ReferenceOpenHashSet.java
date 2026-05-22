/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Hash;
import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractReferenceSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArrays;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceArrayList;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceCollections;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collector;

public class ReferenceOpenHashSet<K>
extends AbstractReferenceSet<K>
implements Serializable,
Cloneable,
Hash {
    private static final long serialVersionUID = 0L;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected transient int n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;
    protected final float f;
    private static final Collector<Object, ?, ReferenceOpenHashSet<Object>> TO_SET_COLLECTOR = Collector.of(ReferenceOpenHashSet::new, ReferenceOpenHashSet::add, ReferenceOpenHashSet::combine, Collector.Characteristics.UNORDERED);

    public ReferenceOpenHashSet(int expected, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        }
        if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = f2;
        this.minN = this.n = HashCommon.arraySize(expected, f2);
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, f2);
        this.key = new Object[this.n + 1];
    }

    public ReferenceOpenHashSet(int expected) {
        this(expected, 0.75f);
    }

    public ReferenceOpenHashSet() {
        this(16, 0.75f);
    }

    public ReferenceOpenHashSet(Collection<? extends K> c2, float f2) {
        this(c2.size(), f2);
        this.addAll(c2);
    }

    public ReferenceOpenHashSet(Collection<? extends K> c2) {
        this(c2, 0.75f);
    }

    public ReferenceOpenHashSet(ReferenceCollection<? extends K> c2, float f2) {
        this(c2.size(), f2);
        this.addAll(c2);
    }

    public ReferenceOpenHashSet(ReferenceCollection<? extends K> c2) {
        this(c2, 0.75f);
    }

    public ReferenceOpenHashSet(Iterator<? extends K> i2, float f2) {
        this(16, f2);
        while (i2.hasNext()) {
            this.add(i2.next());
        }
    }

    public ReferenceOpenHashSet(Iterator<? extends K> i2) {
        this(i2, 0.75f);
    }

    public ReferenceOpenHashSet(K[] a2, int offset, int length, float f2) {
        this(length < 0 ? 0 : length, f2);
        ObjectArrays.ensureOffsetLength(a2, offset, length);
        for (int i2 = 0; i2 < length; ++i2) {
            this.add(a2[offset + i2]);
        }
    }

    public ReferenceOpenHashSet(K[] a2, int offset, int length) {
        this(a2, offset, length, 0.75f);
    }

    public ReferenceOpenHashSet(K[] a2, float f2) {
        this(a2, 0, a2.length, f2);
    }

    public ReferenceOpenHashSet(K[] a2) {
        this(a2, 0.75f);
    }

    public static <K> ReferenceOpenHashSet<K> of() {
        return new ReferenceOpenHashSet<K>();
    }

    public static <K> ReferenceOpenHashSet<K> of(K e2) {
        ReferenceOpenHashSet<K> result = new ReferenceOpenHashSet<K>(1, 0.75f);
        result.add(e2);
        return result;
    }

    public static <K> ReferenceOpenHashSet<K> of(K e0, K e1) {
        ReferenceOpenHashSet<K> result = new ReferenceOpenHashSet<K>(2, 0.75f);
        result.add(e0);
        if (!result.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        }
        return result;
    }

    public static <K> ReferenceOpenHashSet<K> of(K e0, K e1, K e2) {
        ReferenceOpenHashSet<K> result = new ReferenceOpenHashSet<K>(3, 0.75f);
        result.add(e0);
        if (!result.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        }
        if (!result.add(e2)) {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
        return result;
    }

    @SafeVarargs
    public static <K> ReferenceOpenHashSet<K> of(K ... a2) {
        ReferenceOpenHashSet<K> result = new ReferenceOpenHashSet<K>(a2.length, 0.75f);
        for (K element : a2) {
            if (result.add(element)) continue;
            throw new IllegalArgumentException("Duplicate element " + element);
        }
        return result;
    }

    private ReferenceOpenHashSet<K> combine(ReferenceOpenHashSet<? extends K> toAddFrom) {
        this.addAll((Collection<? extends K>)toAddFrom);
        return this;
    }

    public static <K> Collector<K, ?, ReferenceOpenHashSet<K>> toSet() {
        return TO_SET_COLLECTOR;
    }

    public static <K> Collector<K, ?, ReferenceOpenHashSet<K>> toSetWithExpectedSize(int expectedSize) {
        if (expectedSize <= 16) {
            return ReferenceOpenHashSet.toSet();
        }
        return Collector.of(new ReferenceCollections.SizeDecreasingSupplier(expectedSize, size -> size <= 16 ? new ReferenceOpenHashSet() : new ReferenceOpenHashSet(size)), ReferenceOpenHashSet::add, ReferenceOpenHashSet::combine, Collector.Characteristics.UNORDERED);
    }

    private int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    public void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f);
        if (needed > this.n) {
            this.rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int)Math.min(0x40000000L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil((float)capacity / this.f))));
        if (needed > this.n) {
            this.rehash(needed);
        }
    }

    @Override
    public boolean addAll(Collection<? extends K> c2) {
        if ((double)this.f <= 0.5) {
            this.ensureCapacity(c2.size());
        } else {
            this.tryCapacity(this.size() + c2.size());
        }
        return super.addAll(c2);
    }

    @Override
    public boolean add(K k2) {
        if (k2 == null) {
            if (this.containsNull) {
                return false;
            }
            this.containsNull = true;
        } else {
            K[] key = this.key;
            int pos = HashCommon.mix(System.identityHashCode(k2)) & this.mask;
            K curr = key[pos];
            if (curr != null) {
                if (curr == k2) {
                    return false;
                }
                while ((curr = key[pos = pos + 1 & this.mask]) != null) {
                    if (curr != k2) continue;
                    return false;
                }
            }
            key[pos] = k2;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return true;
    }

    protected final void shiftKeys(int pos) {
        K[] key = this.key;
        while (true) {
            K curr;
            int last = pos;
            pos = last + 1 & this.mask;
            while (true) {
                if ((curr = key[pos]) == null) {
                    key[last] = null;
                    return;
                }
                int slot = HashCommon.mix(System.identityHashCode(curr)) & this.mask;
                if (last <= pos ? last >= slot || slot > pos : last >= slot && slot > pos) break;
                pos = pos + 1 & this.mask;
            }
            key[last] = curr;
        }
    }

    private boolean removeEntry(int pos) {
        --this.size;
        this.shiftKeys(pos);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.n] = null;
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }

    @Override
    public boolean remove(Object k2) {
        if (k2 == null) {
            if (this.containsNull) {
                return this.removeNullEntry();
            }
            return false;
        }
        K[] key = this.key;
        int pos = HashCommon.mix(System.identityHashCode(k2)) & this.mask;
        K curr = key[pos];
        if (curr == null) {
            return false;
        }
        if (k2 == curr) {
            return this.removeEntry(pos);
        }
        do {
            if ((curr = key[pos = pos + 1 & this.mask]) != null) continue;
            return false;
        } while (k2 != curr);
        return this.removeEntry(pos);
    }

    @Override
    public boolean contains(Object k2) {
        if (k2 == null) {
            return this.containsNull;
        }
        K[] key = this.key;
        int pos = HashCommon.mix(System.identityHashCode(k2)) & this.mask;
        K curr = key[pos];
        if (curr == null) {
            return false;
        }
        if (k2 == curr) {
            return true;
        }
        do {
            if ((curr = key[pos = pos + 1 & this.mask]) != null) continue;
            return false;
        } while (k2 != curr);
        return true;
    }

    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNull = false;
        Arrays.fill(this.key, null);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public ObjectIterator<K> iterator() {
        return new SetIterator();
    }

    @Override
    public ObjectSpliterator<K> spliterator() {
        return new SetSpliterator();
    }

    @Override
    public void forEach(Consumer<? super K> action) {
        K[] key = this.key;
        if (this.containsNull) {
            action.accept(key[this.n]);
        }
        int pos = this.n;
        while (pos-- != 0) {
            if (key[pos] == null) continue;
            action.accept(key[pos]);
        }
    }

    public boolean trim() {
        return this.trim(this.size);
    }

    public boolean trim(int n2) {
        int l2 = HashCommon.nextPowerOfTwo((int)Math.ceil((float)n2 / this.f));
        if (l2 >= this.n || this.size > HashCommon.maxFill(l2, this.f)) {
            return true;
        }
        try {
            this.rehash(l2);
        }
        catch (OutOfMemoryError cantDoIt) {
            return false;
        }
        return true;
    }

    protected void rehash(int newN) {
        K[] key = this.key;
        int mask = newN - 1;
        Object[] newKey = new Object[newN + 1];
        int i2 = this.n;
        int j2 = this.realSize();
        while (j2-- != 0) {
            while (key[--i2] == null) {
            }
            int pos = HashCommon.mix(System.identityHashCode(key[i2])) & mask;
            if (newKey[pos] != null) {
                while (newKey[pos = pos + 1 & mask] != null) {
                }
            }
            newKey[pos] = key[i2];
        }
        this.n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = newKey;
    }

    public ReferenceOpenHashSet<K> clone() {
        ReferenceOpenHashSet c2;
        try {
            c2 = (ReferenceOpenHashSet)super.clone();
        }
        catch (CloneNotSupportedException cantHappen) {
            throw new InternalError();
        }
        c2.key = (Object[])this.key.clone();
        c2.containsNull = this.containsNull;
        return c2;
    }

    @Override
    public int hashCode() {
        int h2 = 0;
        K[] key = this.key;
        int j2 = this.realSize();
        int i2 = 0;
        while (j2-- != 0) {
            while (key[i2] == null) {
                ++i2;
            }
            if (this != key[i2]) {
                h2 += System.identityHashCode(key[i2]);
            }
            ++i2;
        }
        return h2;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        Iterator i2 = this.iterator();
        s2.defaultWriteObject();
        int j2 = this.size;
        while (j2-- != 0) {
            s2.writeObject(i2.next());
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        this.key = new Object[this.n + 1];
        Object[] key = this.key;
        int i2 = this.size;
        while (i2-- != 0) {
            int pos;
            Object k2 = s2.readObject();
            if (k2 == null) {
                pos = this.n;
                this.containsNull = true;
            } else {
                pos = HashCommon.mix(System.identityHashCode(k2)) & this.mask;
                if (key[pos] != null) {
                    while (key[pos = pos + 1 & this.mask] != null) {
                    }
                }
            }
            key[pos] = k2;
        }
    }

    private void checkTable() {
    }

    private final class SetIterator
    implements ObjectIterator<K> {
        int pos;
        int last;
        int c;
        boolean mustReturnNull;
        ReferenceArrayList<K> wrapped;

        private SetIterator() {
            this.pos = ReferenceOpenHashSet.this.n;
            this.last = -1;
            this.c = ReferenceOpenHashSet.this.size;
            this.mustReturnNull = ReferenceOpenHashSet.this.containsNull;
        }

        @Override
        public boolean hasNext() {
            return this.c != 0;
        }

        @Override
        public K next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            K[] key = ReferenceOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ReferenceOpenHashSet.this.n;
                return key[ReferenceOpenHashSet.this.n];
            }
            do {
                if (--this.pos >= 0) continue;
                this.last = Integer.MIN_VALUE;
                return this.wrapped.get(-this.pos - 1);
            } while (key[this.pos] == null);
            this.last = this.pos;
            return key[this.last];
        }

        private final void shiftKeys(int pos) {
            K[] key = ReferenceOpenHashSet.this.key;
            while (true) {
                Object curr;
                int last = pos;
                pos = last + 1 & ReferenceOpenHashSet.this.mask;
                while (true) {
                    if ((curr = key[pos]) == null) {
                        key[last] = null;
                        return;
                    }
                    int slot = HashCommon.mix(System.identityHashCode(curr)) & ReferenceOpenHashSet.this.mask;
                    if (last <= pos ? last >= slot || slot > pos : last >= slot && slot > pos) break;
                    pos = pos + 1 & ReferenceOpenHashSet.this.mask;
                }
                if (pos < last) {
                    if (this.wrapped == null) {
                        this.wrapped = new ReferenceArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[last] = curr;
            }
        }

        @Override
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == ReferenceOpenHashSet.this.n) {
                ReferenceOpenHashSet.this.containsNull = false;
                ReferenceOpenHashSet.this.key[ReferenceOpenHashSet.this.n] = null;
            } else if (this.pos >= 0) {
                this.shiftKeys(this.last);
            } else {
                ReferenceOpenHashSet.this.remove(this.wrapped.set(-this.pos - 1, (Object)null));
                this.last = -1;
                return;
            }
            --ReferenceOpenHashSet.this.size;
            this.last = -1;
        }

        @Override
        public void forEachRemaining(Consumer<? super K> action) {
            K[] key = ReferenceOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ReferenceOpenHashSet.this.n;
                action.accept(key[ReferenceOpenHashSet.this.n]);
                --this.c;
            }
            while (this.c != 0) {
                if (--this.pos < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept(this.wrapped.get(-this.pos - 1));
                    --this.c;
                    continue;
                }
                if (key[this.pos] == null) continue;
                this.last = this.pos;
                action.accept(key[this.last]);
                --this.c;
            }
        }
    }

    private final class SetSpliterator
    implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;
        int pos = 0;
        int max;
        int c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.max = ReferenceOpenHashSet.this.n;
            this.c = 0;
            this.mustReturnNull = ReferenceOpenHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.max = ReferenceOpenHashSet.this.n;
            this.c = 0;
            this.mustReturnNull = ReferenceOpenHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        @Override
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                ++this.c;
                action.accept(ReferenceOpenHashSet.this.key[ReferenceOpenHashSet.this.n]);
                return true;
            }
            K[] key = ReferenceOpenHashSet.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    ++this.c;
                    action.accept(key[this.pos++]);
                    return true;
                }
                ++this.pos;
            }
            return false;
        }

        @Override
        public void forEachRemaining(Consumer<? super K> action) {
            K[] key = ReferenceOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(key[ReferenceOpenHashSet.this.n]);
                ++this.c;
            }
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    action.accept(key[this.pos]);
                    ++this.c;
                }
                ++this.pos;
            }
        }

        @Override
        public int characteristics() {
            return this.hasSplit ? 1 : 65;
        }

        @Override
        public long estimateSize() {
            if (!this.hasSplit) {
                return ReferenceOpenHashSet.this.size - this.c;
            }
            return Math.min((long)(ReferenceOpenHashSet.this.size - this.c), (long)((double)ReferenceOpenHashSet.this.realSize() / (double)ReferenceOpenHashSet.this.n * (double)(this.max - this.pos)) + (long)(this.mustReturnNull ? 1 : 0));
        }

        @Override
        public SetSpliterator trySplit() {
            if (this.pos >= this.max - 1) {
                return null;
            }
            int retLen = this.max - this.pos >> 1;
            if (retLen <= 1) {
                return null;
            }
            int myNewPos = this.pos + retLen;
            int retPos = this.pos;
            int retMax = myNewPos;
            SetSpliterator split = new SetSpliterator(retPos, retMax, this.mustReturnNull, true);
            this.pos = myNewPos;
            this.mustReturnNull = false;
            this.hasSplit = true;
            return split;
        }

        @Override
        public long skip(long n2) {
            if (n2 < 0L) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n2);
            }
            if (n2 == 0L) {
                return 0L;
            }
            long skipped = 0L;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                ++skipped;
                --n2;
            }
            K[] key = ReferenceOpenHashSet.this.key;
            while (this.pos < this.max && n2 > 0L) {
                if (key[this.pos++] == null) continue;
                ++skipped;
                --n2;
            }
            return skipped;
        }
    }
}

