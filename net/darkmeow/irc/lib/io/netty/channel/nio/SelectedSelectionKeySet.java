/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class SelectedSelectionKeySet
extends AbstractSet<SelectionKey> {
    SelectionKey[] keys = new SelectionKey[1024];
    int size;

    SelectedSelectionKeySet() {
    }

    @Override
    public boolean add(SelectionKey o2) {
        if (o2 == null) {
            return false;
        }
        if (this.size == this.keys.length) {
            this.increaseCapacity();
        }
        this.keys[this.size++] = o2;
        return true;
    }

    @Override
    public boolean remove(Object o2) {
        return false;
    }

    @Override
    public boolean contains(Object o2) {
        SelectionKey[] array = this.keys;
        int s2 = this.size;
        for (int i2 = 0; i2 < s2; ++i2) {
            SelectionKey k2 = array[i2];
            if (!k2.equals(o2)) continue;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<SelectionKey> iterator() {
        return new Iterator<SelectionKey>(){
            private int idx;

            @Override
            public boolean hasNext() {
                return this.idx < SelectedSelectionKeySet.this.size;
            }

            @Override
            public SelectionKey next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return SelectedSelectionKeySet.this.keys[this.idx++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    void reset() {
        this.reset(0);
    }

    void reset(int start) {
        Arrays.fill(this.keys, start, this.size, null);
        this.size = 0;
    }

    private void increaseCapacity() {
        SelectionKey[] newKeys = new SelectionKey[this.keys.length << 1];
        System.arraycopy(this.keys, 0, newKeys, 0, this.size);
        this.keys = newKeys;
    }
}

