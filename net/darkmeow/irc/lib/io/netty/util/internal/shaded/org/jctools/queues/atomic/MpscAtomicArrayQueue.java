/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueueL3Pad;

public class MpscAtomicArrayQueue<E>
extends MpscAtomicArrayQueueL3Pad<E> {
    public MpscAtomicArrayQueue(int capacity) {
        super(capacity);
    }

    public boolean offerIfBelowThreshold(E e2, int threshold) {
        long pIndex;
        if (null == e2) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long capacity = mask + 1;
        long producerLimit = this.lvProducerLimit();
        do {
            long available;
            long size;
            if ((size = capacity - (available = producerLimit - (pIndex = this.lvProducerIndex()))) < (long)threshold) continue;
            long cIndex = this.lvConsumerIndex();
            size = pIndex - cIndex;
            if (size >= (long)threshold) {
                return false;
            }
            producerLimit = cIndex + capacity;
            this.soProducerLimit(producerLimit);
        } while (!this.casProducerIndex(pIndex, pIndex + 1L));
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(pIndex, mask);
        AtomicQueueUtil.soRefElement(this.buffer, offset, e2);
        return true;
    }

    @Override
    public boolean offer(E e2) {
        long pIndex;
        if (null == e2) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long producerLimit = this.lvProducerLimit();
        do {
            if ((pIndex = this.lvProducerIndex()) < producerLimit) continue;
            long cIndex = this.lvConsumerIndex();
            producerLimit = cIndex + (long)mask + 1L;
            if (pIndex >= producerLimit) {
                return false;
            }
            this.soProducerLimit(producerLimit);
        } while (!this.casProducerIndex(pIndex, pIndex + 1L));
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(pIndex, mask);
        AtomicQueueUtil.soRefElement(this.buffer, offset, e2);
        return true;
    }

    public final int failFastOffer(E e2) {
        long producerLimit;
        if (null == e2) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long capacity = mask + 1;
        long pIndex = this.lvProducerIndex();
        if (pIndex >= (producerLimit = this.lvProducerLimit())) {
            long cIndex = this.lvConsumerIndex();
            producerLimit = cIndex + capacity;
            if (pIndex >= producerLimit) {
                return 1;
            }
            this.soProducerLimit(producerLimit);
        }
        if (!this.casProducerIndex(pIndex, pIndex + 1L)) {
            return -1;
        }
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(pIndex, mask);
        AtomicQueueUtil.soRefElement(this.buffer, offset, e2);
        return 0;
    }

    @Override
    public E poll() {
        AtomicReferenceArray buffer = this.buffer;
        long cIndex = this.lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, this.mask);
        Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null == e2) {
            if (cIndex != this.lvProducerIndex()) {
                while ((e2 = AtomicQueueUtil.lvRefElement(buffer, offset)) == null) {
                }
            } else {
                return null;
            }
        }
        AtomicQueueUtil.spRefElement(buffer, offset, null);
        this.soConsumerIndex(cIndex + 1L);
        return e2;
    }

    @Override
    public E peek() {
        AtomicReferenceArray buffer = this.buffer;
        long cIndex = this.lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, this.mask);
        Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null == e2) {
            if (cIndex != this.lvProducerIndex()) {
                while ((e2 = AtomicQueueUtil.lvRefElement(buffer, offset)) == null) {
                }
            } else {
                return null;
            }
        }
        return e2;
    }

    @Override
    public boolean relaxedOffer(E e2) {
        return this.offer(e2);
    }

    @Override
    public E relaxedPoll() {
        AtomicReferenceArray buffer = this.buffer;
        long cIndex = this.lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, this.mask);
        Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null == e2) {
            return null;
        }
        AtomicQueueUtil.spRefElement(buffer, offset, null);
        this.soConsumerIndex(cIndex + 1L);
        return e2;
    }

    @Override
    public E relaxedPeek() {
        AtomicReferenceArray buffer = this.buffer;
        int mask = this.mask;
        long cIndex = this.lpConsumerIndex();
        return AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(cIndex, mask));
    }

    @Override
    public int drain(MessagePassingQueue.Consumer<E> c2, int limit) {
        if (null == c2) {
            throw new IllegalArgumentException("c is null");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("limit is negative: " + limit);
        }
        if (limit == 0) {
            return 0;
        }
        AtomicReferenceArray buffer = this.buffer;
        int mask = this.mask;
        long cIndex = this.lpConsumerIndex();
        for (int i2 = 0; i2 < limit; ++i2) {
            long index = cIndex + (long)i2;
            int offset = AtomicQueueUtil.calcCircularRefElementOffset(index, mask);
            Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
            if (null == e2) {
                return i2;
            }
            AtomicQueueUtil.spRefElement(buffer, offset, null);
            this.soConsumerIndex(index + 1L);
            c2.accept(e2);
        }
        return limit;
    }

    @Override
    public int fill(MessagePassingQueue.Supplier<E> s2, int limit) {
        long available;
        int actualLimit;
        long pIndex;
        if (null == s2) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("limit is negative:" + limit);
        }
        if (limit == 0) {
            return 0;
        }
        int mask = this.mask;
        long capacity = mask + 1;
        long producerLimit = this.lvProducerLimit();
        do {
            if ((available = producerLimit - (pIndex = this.lvProducerIndex())) > 0L) continue;
            long cIndex = this.lvConsumerIndex();
            producerLimit = cIndex + capacity;
            available = producerLimit - pIndex;
            if (available <= 0L) {
                return 0;
            }
            this.soProducerLimit(producerLimit);
        } while (!this.casProducerIndex(pIndex, pIndex + (long)(actualLimit = Math.min((int)available, limit))));
        AtomicReferenceArray buffer = this.buffer;
        for (int i2 = 0; i2 < actualLimit; ++i2) {
            int offset = AtomicQueueUtil.calcCircularRefElementOffset(pIndex + (long)i2, mask);
            AtomicQueueUtil.soRefElement(buffer, offset, s2.get());
        }
        return actualLimit;
    }

    @Override
    public int drain(MessagePassingQueue.Consumer<E> c2) {
        return this.drain(c2, this.capacity());
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

    @Deprecated
    public int weakOffer(E e2) {
        return this.failFastOffer(e2);
    }
}

