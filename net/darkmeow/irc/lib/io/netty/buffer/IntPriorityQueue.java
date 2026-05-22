/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import java.util.Arrays;

final class IntPriorityQueue {
    public static final int NO_VALUE = -1;
    private int[] array = new int[9];
    private int size;

    IntPriorityQueue() {
    }

    public void offer(int handle) {
        if (handle == -1) {
            throw new IllegalArgumentException("The NO_VALUE (-1) cannot be added to the queue.");
        }
        ++this.size;
        if (this.size == this.array.length) {
            this.array = Arrays.copyOf(this.array, 1 + (this.array.length - 1) * 2);
        }
        this.array[this.size] = handle;
        this.lift(this.size);
    }

    public void remove(int value) {
        for (int i2 = 1; i2 <= this.size; ++i2) {
            if (this.array[i2] != value) continue;
            this.array[i2] = this.array[this.size--];
            this.lift(i2);
            this.sink(i2);
            return;
        }
    }

    public int peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.array[1];
    }

    public int poll() {
        if (this.size == 0) {
            return -1;
        }
        int val = this.array[1];
        this.array[1] = this.array[this.size];
        this.array[this.size] = 0;
        --this.size;
        this.sink(1);
        return val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void lift(int index) {
        int parentIndex;
        while (index > 1 && this.subord(parentIndex = index >> 1, index)) {
            this.swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void sink(int index) {
        int child;
        while ((child = index << 1) <= this.size) {
            if (child < this.size && this.subord(child, child + 1)) {
                ++child;
            }
            if (!this.subord(index, child)) break;
            this.swap(index, child);
            index = child;
        }
    }

    private boolean subord(int a2, int b2) {
        return this.array[a2] > this.array[b2];
    }

    private void swap(int a2, int b2) {
        int value = this.array[a2];
        this.array[a2] = this.array[b2];
        this.array[b2] = value;
    }
}

