/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import java.util.concurrent.locks.ReentrantLock;
import net.darkmeow.irc.lib.io.netty.buffer.PoolChunk;
import net.darkmeow.irc.lib.io.netty.buffer.PoolSubpageMetric;

final class PoolSubpage<T>
implements PoolSubpageMetric {
    final PoolChunk<T> chunk;
    final int elemSize;
    private final int pageShifts;
    private final int runOffset;
    private final int runSize;
    private final long[] bitmap;
    private final int bitmapLength;
    private final int maxNumElems;
    final int headIndex;
    PoolSubpage<T> prev;
    PoolSubpage<T> next;
    boolean doNotDestroy;
    private int nextAvail;
    private int numAvail;
    final ReentrantLock lock;

    PoolSubpage(int headIndex) {
        this.chunk = null;
        this.lock = new ReentrantLock();
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
        this.bitmapLength = -1;
        this.maxNumElems = 0;
        this.headIndex = headIndex;
    }

    PoolSubpage(PoolSubpage<T> head, PoolChunk<T> chunk, int pageShifts, int runOffset, int runSize, int elemSize) {
        this.headIndex = head.headIndex;
        this.chunk = chunk;
        this.pageShifts = pageShifts;
        this.runOffset = runOffset;
        this.runSize = runSize;
        this.elemSize = elemSize;
        this.doNotDestroy = true;
        this.maxNumElems = this.numAvail = runSize / elemSize;
        int bitmapLength = this.maxNumElems >>> 6;
        if ((this.maxNumElems & 0x3F) != 0) {
            ++bitmapLength;
        }
        this.bitmapLength = bitmapLength;
        this.bitmap = new long[bitmapLength];
        this.nextAvail = 0;
        this.lock = null;
        this.addToPool(head);
    }

    long allocate() {
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1L;
        }
        int bitmapIdx = this.getNextAvail();
        if (bitmapIdx < 0) {
            this.removeFromPool();
            throw new AssertionError((Object)("No next available bitmap index found (bitmapIdx = " + bitmapIdx + "), even though there are supposed to be (numAvail = " + this.numAvail + ") out of (maxNumElems = " + this.maxNumElems + ") available indexes."));
        }
        int q2 = bitmapIdx >>> 6;
        int r2 = bitmapIdx & 0x3F;
        assert ((this.bitmap[q2] >>> r2 & 1L) == 0L);
        int n2 = q2;
        this.bitmap[n2] = this.bitmap[n2] | 1L << r2;
        if (--this.numAvail == 0) {
            this.removeFromPool();
        }
        return this.toHandle(bitmapIdx);
    }

    boolean free(PoolSubpage<T> head, int bitmapIdx) {
        int q2 = bitmapIdx >>> 6;
        int r2 = bitmapIdx & 0x3F;
        assert ((this.bitmap[q2] >>> r2 & 1L) != 0L);
        int n2 = q2;
        this.bitmap[n2] = this.bitmap[n2] ^ 1L << r2;
        this.setNextAvail(bitmapIdx);
        if (this.numAvail++ == 0) {
            this.addToPool(head);
            if (this.maxNumElems > 1) {
                return true;
            }
        }
        if (this.numAvail != this.maxNumElems) {
            return true;
        }
        if (this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        this.removeFromPool();
        return false;
    }

    private void addToPool(PoolSubpage<T> head) {
        assert (this.prev == null && this.next == null);
        this.prev = head;
        this.next = head.next;
        this.next.prev = this;
        head.next = this;
    }

    private void removeFromPool() {
        assert (this.prev != null && this.next != null);
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int bitmapIdx) {
        this.nextAvail = bitmapIdx;
    }

    private int getNextAvail() {
        int nextAvail = this.nextAvail;
        if (nextAvail >= 0) {
            this.nextAvail = -1;
            return nextAvail;
        }
        return this.findNextAvail();
    }

    private int findNextAvail() {
        for (int i2 = 0; i2 < this.bitmapLength; ++i2) {
            long bits = this.bitmap[i2];
            if ((bits ^ 0xFFFFFFFFFFFFFFFFL) == 0L) continue;
            return this.findNextAvail0(i2, bits);
        }
        return -1;
    }

    private int findNextAvail0(int i2, long bits) {
        int baseVal = i2 << 6;
        for (int j2 = 0; j2 < 64; ++j2) {
            if ((bits & 1L) == 0L) {
                int val = baseVal | j2;
                if (val >= this.maxNumElems) break;
                return val;
            }
            bits >>>= 1;
        }
        return -1;
    }

    private long toHandle(int bitmapIdx) {
        int pages = this.runSize >> this.pageShifts;
        return (long)this.runOffset << 49 | (long)pages << 34 | 0x200000000L | 0x100000000L | (long)bitmapIdx;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        int numAvail;
        if (this.chunk == null) {
            numAvail = 0;
        } else {
            boolean doNotDestroy;
            PoolSubpage head = this.chunk.arena.smallSubpagePools[this.headIndex];
            head.lock();
            try {
                doNotDestroy = this.doNotDestroy;
                numAvail = this.numAvail;
            }
            finally {
                head.unlock();
            }
            if (!doNotDestroy) {
                return "(" + this.runOffset + ": not in use)";
            }
        }
        return "(" + this.runOffset + ": " + (this.maxNumElems - numAvail) + '/' + this.maxNumElems + ", offset: " + this.runOffset + ", length: " + this.runSize + ", elemSize: " + this.elemSize + ')';
    }

    @Override
    public int maxNumElements() {
        return this.maxNumElems;
    }

    @Override
    public int numAvailable() {
        if (this.chunk == null) {
            return 0;
        }
        PoolSubpage head = this.chunk.arena.smallSubpagePools[this.headIndex];
        head.lock();
        try {
            int n2 = this.numAvail;
            return n2;
        }
        finally {
            head.unlock();
        }
    }

    @Override
    public int elementSize() {
        return this.elemSize;
    }

    @Override
    public int pageSize() {
        return 1 << this.pageShifts;
    }

    boolean isDoNotDestroy() {
        if (this.chunk == null) {
            return true;
        }
        PoolSubpage head = this.chunk.arena.smallSubpagePools[this.headIndex];
        head.lock();
        try {
            boolean bl2 = this.doNotDestroy;
            return bl2;
        }
        finally {
            head.unlock();
        }
    }

    void destroy() {
        if (this.chunk != null) {
            this.chunk.destroy();
        }
    }

    void lock() {
        this.lock.lock();
    }

    void unlock() {
        this.lock.unlock();
    }
}

