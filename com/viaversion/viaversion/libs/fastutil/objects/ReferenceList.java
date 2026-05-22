/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractReferenceList;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArrays;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectListIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceImmutableList;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceLists;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public interface ReferenceList<K>
extends List<K>,
ReferenceCollection<K> {
    @Override
    public ObjectListIterator<K> iterator();

    @Override
    default public ObjectSpliterator<K> spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractReferenceList.IndexBasedSpliterator(this, 0);
        }
        return ObjectSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(this), 16464);
    }

    @Override
    public ObjectListIterator<K> listIterator();

    @Override
    public ObjectListIterator<K> listIterator(int var1);

    @Override
    public ReferenceList<K> subList(int var1, int var2);

    public void size(int var1);

    public void getElements(int var1, Object[] var2, int var3, int var4);

    public void removeElements(int var1, int var2);

    public void addElements(int var1, K[] var2);

    public void addElements(int var1, K[] var2, int var3, int var4);

    default public void setElements(K[] a2) {
        this.setElements(0, a2);
    }

    default public void setElements(int index, K[] a2) {
        this.setElements(index, a2, 0, a2.length);
    }

    default public void setElements(int index, K[] a2, int offset, int length) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        }
        if (index > this.size()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than list size (" + this.size() + ")");
        }
        ObjectArrays.ensureOffsetLength(a2, offset, length);
        if (index + length > this.size()) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size() + ")");
        }
        ListIterator iter = this.listIterator(index);
        int i2 = 0;
        while (i2 < length) {
            iter.next();
            iter.set(a2[offset + i2++]);
        }
    }

    @Override
    default public boolean addAll(int index, ReferenceList<? extends K> l2) {
        return this.addAll(index, l2);
    }

    @Override
    default public boolean addAll(ReferenceList<? extends K> l2) {
        return this.addAll(this.size(), l2);
    }

    public static <K> ReferenceList<K> of() {
        return ReferenceImmutableList.of();
    }

    public static <K> ReferenceList<K> of(K e2) {
        return ReferenceLists.singleton(e2);
    }

    public static <K> ReferenceList<K> of(K e0, K e1) {
        return ReferenceImmutableList.of(new Object[]{e0, e1});
    }

    public static <K> ReferenceList<K> of(K e0, K e1, K e2) {
        return ReferenceImmutableList.of(new Object[]{e0, e1, e2});
    }

    @SafeVarargs
    public static <K> ReferenceList<K> of(K ... a2) {
        switch (a2.length) {
            case 0: {
                return ReferenceList.of();
            }
            case 1: {
                return ReferenceList.of(a2[0]);
            }
        }
        return ReferenceImmutableList.of(a2);
    }

    @Override
    default public void sort(Comparator<? super K> comparator) {
        Object[] elements = this.toArray();
        if (comparator == null) {
            ObjectArrays.stableSort(elements);
        } else {
            ObjectArrays.stableSort(elements, comparator);
        }
        this.setElements(elements);
    }

    default public void unstableSort(Comparator<? super K> comparator) {
        Object[] elements = this.toArray();
        if (comparator == null) {
            ObjectArrays.unstableSort(elements);
        } else {
            ObjectArrays.unstableSort(elements, comparator);
        }
        this.setElements(elements);
    }
}

