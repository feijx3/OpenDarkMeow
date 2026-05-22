/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MpmcArrayQueueL3Pad;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.UnsafeLongArrayAccess;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

public class MpmcArrayQueue<E>
extends MpmcArrayQueueL3Pad<E> {
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.mpmc.max.lookahead.step", 4096);
    private final int lookAheadStep = Math.max(2, Math.min(this.capacity() / 4, MAX_LOOK_AHEAD_STEP));

    public MpmcArrayQueue(int capacity) {
        super(RangeUtil.checkGreaterThanOrEqual(capacity, 2, "capacity"));
    }

    @Override
    public boolean offer(E e2) {
        long seqOffset;
        long pIndex;
        long seq;
        if (null == e2) {
            throw new NullPointerException();
        }
        long mask = this.mask;
        long capacity = mask + 1L;
        long[] sBuffer = this.sequenceBuffer;
        long cIndex = Long.MIN_VALUE;
        do {
            if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(pIndex = this.lvProducerIndex(), mask))) >= pIndex) continue;
            if (pIndex - capacity >= cIndex && pIndex - capacity >= (cIndex = this.lvConsumerIndex())) {
                return false;
            }
            seq = pIndex + 1L;
        } while (seq > pIndex || !this.casProducerIndex(pIndex, pIndex + 1L));
        UnsafeRefArrayAccess.spRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex, mask), e2);
        UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, pIndex + 1L);
        return true;
    }

    @Override
    public E poll() {
        long seqOffset;
        long cIndex;
        long expectedSeq;
        long seq;
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        long pIndex = -1L;
        do {
            if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex = this.lvConsumerIndex(), mask))) >= (expectedSeq = cIndex + 1L)) continue;
            if (cIndex >= pIndex && cIndex == (pIndex = this.lvProducerIndex())) {
                return null;
            }
            seq = expectedSeq + 1L;
        } while (seq > expectedSeq || !this.casConsumerIndex(cIndex, cIndex + 1L));
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask);
        Object e2 = UnsafeRefArrayAccess.lpRefElement(this.buffer, offset);
        UnsafeRefArrayAccess.spRefElement(this.buffer, offset, null);
        UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, cIndex + mask + 1L);
        return (E)e2;
    }

    @Override
    public E peek() {
        Object e2;
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        long pIndex = -1L;
        while (true) {
            long expectedSeq;
            long cIndex;
            long seqOffset;
            long seq;
            if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex = this.lvConsumerIndex(), mask))) < (expectedSeq = cIndex + 1L)) {
                if (cIndex < pIndex || cIndex != (pIndex = this.lvProducerIndex())) continue;
                return null;
            }
            if (seq != expectedSeq) continue;
            long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask);
            e2 = UnsafeRefArrayAccess.lvRefElement(this.buffer, offset);
            if (this.lvConsumerIndex() == cIndex) break;
        }
        return (E)e2;
    }

    @Override
    public boolean relaxedOffer(E e2) {
        long seqOffset;
        long pIndex;
        long seq;
        if (null == e2) {
            throw new NullPointerException();
        }
        long mask = this.mask;
        long[] sBuffer = this.sequenceBuffer;
        do {
            if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(pIndex = this.lvProducerIndex(), mask))) >= pIndex) continue;
            return false;
        } while (seq > pIndex || !this.casProducerIndex(pIndex, pIndex + 1L));
        UnsafeRefArrayAccess.spRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex, mask), e2);
        UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, pIndex + 1L);
        return true;
    }

    @Override
    public E relaxedPoll() {
        long seqOffset;
        long cIndex;
        long expectedSeq;
        long seq;
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        do {
            if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex = this.lvConsumerIndex(), mask))) >= (expectedSeq = cIndex + 1L)) continue;
            return null;
        } while (seq > expectedSeq || !this.casConsumerIndex(cIndex, cIndex + 1L));
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask);
        Object e2 = UnsafeRefArrayAccess.lpRefElement(this.buffer, offset);
        UnsafeRefArrayAccess.spRefElement(this.buffer, offset, null);
        UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, cIndex + mask + 1L);
        return (E)e2;
    }

    @Override
    public E relaxedPeek() {
        Object e2;
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        while (true) {
            long expectedSeq;
            long cIndex;
            long seqOffset;
            long seq;
            if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex = this.lvConsumerIndex(), mask))) < (expectedSeq = cIndex + 1L)) {
                return null;
            }
            if (seq != expectedSeq) continue;
            long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask);
            e2 = UnsafeRefArrayAccess.lvRefElement(this.buffer, offset);
            if (this.lvConsumerIndex() == cIndex) break;
        }
        return (E)e2;
    }

    @Override
    public int drain(MessagePassingQueue.Consumer<E> c2, int limit) {
        int lookAheadStep;
        if (null == c2) {
            throw new IllegalArgumentException("c is null");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("limit is negative: " + limit);
        }
        if (limit == 0) {
            return 0;
        }
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        Object[] buffer = this.buffer;
        int maxLookAheadStep = Math.min(this.lookAheadStep, limit);
        for (int consumed = 0; consumed < limit; consumed += lookAheadStep) {
            long expectedLookAheadSeq;
            int remaining = limit - consumed;
            lookAheadStep = Math.min(remaining, maxLookAheadStep);
            long cIndex = this.lvConsumerIndex();
            long lookAheadIndex = cIndex + (long)lookAheadStep - 1L;
            long lookAheadSeqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(lookAheadIndex, mask);
            long lookAheadSeq = UnsafeLongArrayAccess.lvLongElement(sBuffer, lookAheadSeqOffset);
            if (lookAheadSeq == (expectedLookAheadSeq = lookAheadIndex + 1L) && this.casConsumerIndex(cIndex, expectedLookAheadSeq)) {
                for (int i2 = 0; i2 < lookAheadStep; ++i2) {
                    long index = cIndex + (long)i2;
                    long seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(index, mask);
                    long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(index, mask);
                    long expectedSeq = index + 1L;
                    while (UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset) != expectedSeq) {
                    }
                    Object e2 = UnsafeRefArrayAccess.lpRefElement(buffer, offset);
                    UnsafeRefArrayAccess.spRefElement(buffer, offset, null);
                    UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, index + mask + 1L);
                    c2.accept(e2);
                }
                continue;
            }
            if (lookAheadSeq < expectedLookAheadSeq && this.notAvailable(cIndex, mask, sBuffer, cIndex + 1L)) {
                return consumed;
            }
            return consumed + this.drainOneByOne(c2, remaining);
        }
        return limit;
    }

    private int drainOneByOne(MessagePassingQueue.Consumer<E> c2, int limit) {
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        Object[] buffer = this.buffer;
        for (int i2 = 0; i2 < limit; ++i2) {
            long seqOffset;
            long cIndex;
            long expectedSeq;
            long seq;
            do {
                if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex = this.lvConsumerIndex(), mask))) >= (expectedSeq = cIndex + 1L)) continue;
                return i2;
            } while (seq > expectedSeq || !this.casConsumerIndex(cIndex, cIndex + 1L));
            long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask);
            Object e2 = UnsafeRefArrayAccess.lpRefElement(buffer, offset);
            UnsafeRefArrayAccess.spRefElement(buffer, offset, null);
            UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, cIndex + mask + 1L);
            c2.accept(e2);
        }
        return limit;
    }

    @Override
    public int fill(MessagePassingQueue.Supplier<E> s2, int limit) {
        int lookAheadStep;
        if (null == s2) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("limit is negative:" + limit);
        }
        if (limit == 0) {
            return 0;
        }
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        Object[] buffer = this.buffer;
        int maxLookAheadStep = Math.min(this.lookAheadStep, limit);
        for (int produced = 0; produced < limit; produced += lookAheadStep) {
            long expectedLookAheadSeq;
            int remaining = limit - produced;
            lookAheadStep = Math.min(remaining, maxLookAheadStep);
            long pIndex = this.lvProducerIndex();
            long lookAheadIndex = pIndex + (long)lookAheadStep - 1L;
            long lookAheadSeqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(lookAheadIndex, mask);
            long lookAheadSeq = UnsafeLongArrayAccess.lvLongElement(sBuffer, lookAheadSeqOffset);
            if (lookAheadSeq == (expectedLookAheadSeq = lookAheadIndex) && this.casProducerIndex(pIndex, expectedLookAheadSeq + 1L)) {
                for (int i2 = 0; i2 < lookAheadStep; ++i2) {
                    long index = pIndex + (long)i2;
                    long seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(index, mask);
                    long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(index, mask);
                    while (UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset) != index) {
                    }
                    UnsafeRefArrayAccess.soRefElement(buffer, offset, s2.get());
                    UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, index + 1L);
                }
                continue;
            }
            if (lookAheadSeq < expectedLookAheadSeq && this.notAvailable(pIndex, mask, sBuffer, pIndex)) {
                return produced;
            }
            return produced + this.fillOneByOne(s2, remaining);
        }
        return limit;
    }

    private boolean notAvailable(long index, long mask, long[] sBuffer, long expectedSeq) {
        long seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(index, mask);
        long seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset);
        return seq < expectedSeq;
    }

    private int fillOneByOne(MessagePassingQueue.Supplier<E> s2, int limit) {
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        Object[] buffer = this.buffer;
        for (int i2 = 0; i2 < limit; ++i2) {
            long seqOffset;
            long pIndex;
            long seq;
            do {
                if ((seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(pIndex = this.lvProducerIndex(), mask))) >= pIndex) continue;
                return i2;
            } while (seq > pIndex || !this.casProducerIndex(pIndex, pIndex + 1L));
            UnsafeRefArrayAccess.soRefElement(buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex, mask), s2.get());
            UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, pIndex + 1L);
        }
        return limit;
    }

    @Override
    public int drain(MessagePassingQueue.Consumer<E> c2) {
        return MessagePassingQueueUtil.drain(this, c2);
    }

    @Override
    public int fill(MessagePassingQueue.Supplier<E> s2) {
        return MessagePassingQueueUtil.fillBounded(this, s2);
    }

    @Override
    public void drain(MessagePassingQueue.Consumer<E> c2, MessagePassingQueue.WaitStrategy w2, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c2, w2, exit);
    }

    @Override
    public void fill(MessagePassingQueue.Supplier<E> s2, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s2, wait, exit);
    }
}

