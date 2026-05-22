/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectPool;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public final class RecyclableArrayList
extends ArrayList<Object> {
    private static final long serialVersionUID = -8605125654176467947L;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private static final ObjectPool<RecyclableArrayList> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<RecyclableArrayList>(){

        @Override
        public RecyclableArrayList newObject(ObjectPool.Handle<RecyclableArrayList> handle) {
            return new RecyclableArrayList(handle);
        }
    });
    private boolean insertSinceRecycled;
    private final ObjectPool.Handle<RecyclableArrayList> handle;

    public static RecyclableArrayList newInstance() {
        return RecyclableArrayList.newInstance(8);
    }

    public static RecyclableArrayList newInstance(int minCapacity) {
        RecyclableArrayList ret = RECYCLER.get();
        ret.ensureCapacity(minCapacity);
        return ret;
    }

    private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> handle) {
        this(handle, 8);
    }

    private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> handle, int initialCapacity) {
        super(initialCapacity);
        this.handle = handle;
    }

    @Override
    public boolean addAll(Collection<?> c2) {
        RecyclableArrayList.checkNullElements(c2);
        if (super.addAll(c2)) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<?> c2) {
        RecyclableArrayList.checkNullElements(c2);
        if (super.addAll(index, c2)) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }

    private static void checkNullElements(Collection<?> c2) {
        if (c2 instanceof RandomAccess && c2 instanceof List) {
            List list = (List)c2;
            int size = list.size();
            for (int i2 = 0; i2 < size; ++i2) {
                if (list.get(i2) != null) continue;
                throw new IllegalArgumentException("c contains null values");
            }
        } else {
            for (Object element : c2) {
                if (element != null) continue;
                throw new IllegalArgumentException("c contains null values");
            }
        }
    }

    @Override
    public boolean add(Object element) {
        if (super.add(ObjectUtil.checkNotNull(element, "element"))) {
            this.insertSinceRecycled = true;
            return true;
        }
        return false;
    }

    @Override
    public void add(int index, Object element) {
        super.add(index, ObjectUtil.checkNotNull(element, "element"));
        this.insertSinceRecycled = true;
    }

    @Override
    public Object set(int index, Object element) {
        Object old = super.set(index, ObjectUtil.checkNotNull(element, "element"));
        this.insertSinceRecycled = true;
        return old;
    }

    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    public boolean recycle() {
        this.clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
        return true;
    }
}

