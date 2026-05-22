/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.UnmodifiableLazyStringList;

public class LazyStringArrayList
extends AbstractList<String>
implements RandomAccess,
LazyStringList {
    public static final LazyStringList EMPTY = new LazyStringArrayList().getUnmodifiableView();
    private final List<Object> list;

    public LazyStringArrayList() {
        this.list = new ArrayList<Object>();
    }

    public LazyStringArrayList(LazyStringList from) {
        this.list = new ArrayList<Object>(from.size());
        this.addAll(from);
    }

    @Override
    public String get(int index) {
        Object o2 = this.list.get(index);
        if (o2 instanceof String) {
            return (String)o2;
        }
        if (o2 instanceof ByteString) {
            ByteString bs2 = (ByteString)o2;
            String s2 = bs2.toStringUtf8();
            if (bs2.isValidUtf8()) {
                this.list.set(index, s2);
            }
            return s2;
        }
        byte[] ba2 = (byte[])o2;
        String s3 = Internal.toStringUtf8(ba2);
        if (Internal.isValidUtf8(ba2)) {
            this.list.set(index, s3);
        }
        return s3;
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public String set(int index, String s2) {
        Object o2 = this.list.set(index, s2);
        return LazyStringArrayList.asString(o2);
    }

    @Override
    public void add(int index, String element) {
        this.list.add(index, element);
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection<? extends String> c2) {
        return this.addAll(this.size(), c2);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c2) {
        Collection<? extends String> collection = c2 instanceof LazyStringList ? ((LazyStringList)c2).getUnderlyingElements() : c2;
        boolean ret = this.list.addAll(index, collection);
        ++this.modCount;
        return ret;
    }

    @Override
    public String remove(int index) {
        Object o2 = this.list.remove(index);
        ++this.modCount;
        return LazyStringArrayList.asString(o2);
    }

    @Override
    public void clear() {
        this.list.clear();
        ++this.modCount;
    }

    @Override
    public void add(ByteString element) {
        this.list.add(element);
        ++this.modCount;
    }

    @Override
    public ByteString getByteString(int index) {
        Object o2 = this.list.get(index);
        ByteString b2 = LazyStringArrayList.asByteString(o2);
        if (b2 != o2) {
            this.list.set(index, b2);
        }
        return b2;
    }

    private static String asString(Object o2) {
        if (o2 instanceof String) {
            return (String)o2;
        }
        if (o2 instanceof ByteString) {
            return ((ByteString)o2).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[])o2);
    }

    private static ByteString asByteString(Object o2) {
        if (o2 instanceof ByteString) {
            return (ByteString)o2;
        }
        if (o2 instanceof String) {
            return ByteString.copyFromUtf8((String)o2);
        }
        return ByteString.copyFrom((byte[])o2);
    }

    @Override
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }
}

