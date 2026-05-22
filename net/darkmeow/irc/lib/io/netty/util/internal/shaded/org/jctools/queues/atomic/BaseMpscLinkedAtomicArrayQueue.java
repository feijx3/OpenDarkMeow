/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueueColdProducerFields;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.Pow2;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

abstract class BaseMpscLinkedAtomicArrayQueue<E>
extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E>
implements MessagePassingQueue<E>,
QueueProgressIndicators {
    private static final Object JUMP = new Object();
    private static final Object BUFFER_CONSUMED = new Object();
    private static final int CONTINUE_TO_P_INDEX_CAS = 0;
    private static final int RETRY = 1;
    private static final int QUEUE_FULL = 2;
    private static final int QUEUE_RESIZE = 3;

    public BaseMpscLinkedAtomicArrayQueue(int initialCapacity) {
        AtomicReferenceArray buffer;
        RangeUtil.checkGreaterThanOrEqual(initialCapacity, 2, "initialCapacity");
        int p2capacity = Pow2.roundToPowerOfTwo(initialCapacity);
        long mask = p2capacity - 1 << 1;
        this.producerBuffer = buffer = AtomicQueueUtil.allocateRefArray(p2capacity + 1);
        this.producerMask = mask;
        this.consumerBuffer = buffer;
        this.consumerMask = mask;
        this.soProducerLimit(mask);
    }

    @Override
    public int size() {
        return IndexedQueueSizeUtil.size(this, 2);
    }

    @Override
    public boolean isEmpty() {
        return (this.lvConsumerIndex() - this.lvProducerIndex()) / 2L == 0L;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public boolean offer(E e2) {
        AtomicReferenceArray buffer;
        long mask;
        long pIndex;
        if (null == e2) {
            throw new NullPointerException();
        }
        block6: while (true) {
            long producerLimit = this.lvProducerLimit();
            pIndex = this.lvProducerIndex();
            if ((pIndex & 1L) == 1L) continue;
            mask = this.producerMask;
            buffer = this.producerBuffer;
            if (producerLimit <= pIndex) {
                int result = this.offerSlowPath(mask, pIndex, producerLimit);
                switch (result) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        continue block6;
                    }
                    case 2: {
                        return false;
                    }
                    case 3: {
                        this.resize(mask, buffer, pIndex, e2, null);
                        return true;
                    }
                }
            }
            if (this.casProducerIndex(pIndex, pIndex + 2L)) break;
        }
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, mask);
        AtomicQueueUtil.soRefElement(buffer, offset, e2);
        return true;
    }

    @Override
    public E poll() {
        long mask;
        AtomicReferenceArray buffer = this.consumerBuffer;
        long cIndex = this.lpConsumerIndex();
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, mask = this.consumerMask);
        Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
        if (e2 == null) {
            long pIndex = this.lvProducerIndex();
            if ((cIndex - pIndex) / 2L == 0L) {
                return null;
            }
            while ((e2 = AtomicQueueUtil.lvRefElement(buffer, offset)) == null) {
            }
        }
        if (e2 == JUMP) {
            AtomicReferenceArray<E> nextBuffer = this.nextBuffer(buffer, mask);
            return this.newBufferPoll(nextBuffer, cIndex);
        }
        AtomicQueueUtil.soRefElement(buffer, offset, null);
        this.soConsumerIndex(cIndex + 2L);
        return e2;
    }

    @Override
    public E peek() {
        long mask;
        AtomicReferenceArray buffer = this.consumerBuffer;
        long cIndex = this.lpConsumerIndex();
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, mask = this.consumerMask);
        Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
        if (e2 == null) {
            long pIndex = this.lvProducerIndex();
            if ((cIndex - pIndex) / 2L == 0L) {
                return null;
            }
            while ((e2 = AtomicQueueUtil.lvRefElement(buffer, offset)) == null) {
            }
        }
        if (e2 == JUMP) {
            return this.newBufferPeek(this.nextBuffer(buffer, mask), cIndex);
        }
        return e2;
    }

    private int offerSlowPath(long mask, long pIndex, long producerLimit) {
        long bufferCapacity;
        long cIndex = this.lvConsumerIndex();
        if (cIndex + (bufferCapacity = this.getCurrentBufferCapacity(mask)) > pIndex) {
            if (!this.casProducerLimit(producerLimit, cIndex + bufferCapacity)) {
                return 1;
            }
            return 0;
        }
        if (this.availableInQueue(pIndex, cIndex) <= 0L) {
            return 2;
        }
        if (this.casProducerIndex(pIndex, pIndex + 1L)) {
            return 3;
        }
        return 1;
    }

    protected abstract long availableInQueue(long var1, long var3);

    private AtomicReferenceArray<E> nextBuffer(AtomicReferenceArray<E> buffer, long mask) {
        AtomicReferenceArray nextBuffer;
        int offset = BaseMpscLinkedAtomicArrayQueue.nextArrayOffset(mask);
        this.consumerBuffer = nextBuffer = (AtomicReferenceArray)AtomicQueueUtil.lvRefElement(buffer, offset);
        this.consumerMask = AtomicQueueUtil.length(nextBuffer) - 2 << 1;
        AtomicQueueUtil.soRefElement(buffer, offset, BUFFER_CONSUMED);
        return nextBuffer;
    }

    private static int nextArrayOffset(long mask) {
        return AtomicQueueUtil.modifiedCalcCircularRefElementOffset(mask + 2L, Long.MAX_VALUE);
    }

    private E newBufferPoll(AtomicReferenceArray<E> nextBuffer, long cIndex) {
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, this.consumerMask);
        E n2 = AtomicQueueUtil.lvRefElement(nextBuffer, offset);
        if (n2 == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        AtomicQueueUtil.soRefElement(nextBuffer, offset, null);
        this.soConsumerIndex(cIndex + 2L);
        return n2;
    }

    private E newBufferPeek(AtomicReferenceArray<E> nextBuffer, long cIndex) {
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, this.consumerMask);
        E n2 = AtomicQueueUtil.lvRefElement(nextBuffer, offset);
        if (null == n2) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        return n2;
    }

    @Override
    public long currentProducerIndex() {
        return this.lvProducerIndex() / 2L;
    }

    @Override
    public long currentConsumerIndex() {
        return this.lvConsumerIndex() / 2L;
    }

    @Override
    public abstract int capacity();

    @Override
    public boolean relaxedOffer(E e2) {
        return this.offer(e2);
    }

    @Override
    public E relaxedPoll() {
        long mask;
        AtomicReferenceArray buffer = this.consumerBuffer;
        long cIndex = this.lpConsumerIndex();
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, mask = this.consumerMask);
        Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
        if (e2 == null) {
            return null;
        }
        if (e2 == JUMP) {
            AtomicReferenceArray<E> nextBuffer = this.nextBuffer(buffer, mask);
            return this.newBufferPoll(nextBuffer, cIndex);
        }
        AtomicQueueUtil.soRefElement(buffer, offset, null);
        this.soConsumerIndex(cIndex + 2L);
        return e2;
    }

    @Override
    public E relaxedPeek() {
        long mask;
        AtomicReferenceArray buffer = this.consumerBuffer;
        long cIndex = this.lpConsumerIndex();
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, mask = this.consumerMask);
        Object e2 = AtomicQueueUtil.lvRefElement(buffer, offset);
        if (e2 == JUMP) {
            return this.newBufferPeek(this.nextBuffer(buffer, mask), cIndex);
        }
        return e2;
    }

    @Override
    public int fill(MessagePassingQueue.Supplier<E> s2) {
        int filled;
        long result = 0L;
        int capacity = this.capacity();
        do {
            if ((filled = this.fill(s2, PortableJvmInfo.RECOMENDED_OFFER_BATCH)) != 0) continue;
            return (int)result;
        } while ((result += (long)filled) <= (long)capacity);
        return (int)result;
    }

    @Override
    public int fill(MessagePassingQueue.Supplier<E> s2, int limit) {
        long batchIndex;
        AtomicReferenceArray buffer;
        long mask;
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
        block5: while (true) {
            long producerLimit = this.lvProducerLimit();
            pIndex = this.lvProducerIndex();
            if ((pIndex & 1L) == 1L) continue;
            mask = this.producerMask;
            buffer = this.producerBuffer;
            batchIndex = Math.min(producerLimit, pIndex + 2L * (long)limit);
            if (pIndex >= producerLimit) {
                int result = this.offerSlowPath(mask, pIndex, producerLimit);
                switch (result) {
                    case 0: 
                    case 1: {
                        continue block5;
                    }
                    case 2: {
                        return 0;
                    }
                    case 3: {
                        this.resize(mask, buffer, pIndex, null, s2);
                        return 1;
                    }
                }
            }
            if (this.casProducerIndex(pIndex, batchIndex)) break;
        }
        int claimedSlots = (int)((batchIndex - pIndex) / 2L);
        for (int i2 = 0; i2 < claimedSlots; ++i2) {
            int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex + 2L * (long)i2, mask);
            AtomicQueueUtil.soRefElement(buffer, offset, s2.get());
        }
        return claimedSlots;
    }

    @Override
    public void fill(MessagePassingQueue.Supplier<E> s2, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s2, wait, exit);
    }

    @Override
    public int drain(MessagePassingQueue.Consumer<E> c2) {
        return this.drain(c2, this.capacity());
    }

    @Override
    public int drain(MessagePassingQueue.Consumer<E> c2, int limit) {
        return MessagePassingQueueUtil.drain(this, c2, limit);
    }

    @Override
    public void drain(MessagePassingQueue.Consumer<E> c2, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c2, wait, exit);
    }

    @Override
    public Iterator<E> iterator() {
        return new WeakIterator(this.consumerBuffer, this.lvConsumerIndex(), this.lvProducerIndex());
    }

    private void resize(long oldMask, AtomicReferenceArray<E> oldBuffer, long pIndex, E e2, MessagePassingQueue.Supplier<E> s2) {
        AtomicReferenceArray newBuffer;
        assert (e2 != null && s2 == null || e2 == null || s2 != null);
        int newBufferLength = this.getNextBufferSize(oldBuffer);
        try {
            newBuffer = AtomicQueueUtil.allocateRefArray(newBufferLength);
        }
        catch (OutOfMemoryError oom) {
            assert (this.lvProducerIndex() == pIndex + 1L);
            this.soProducerIndex(pIndex);
            throw oom;
        }
        this.producerBuffer = newBuffer;
        int newMask = newBufferLength - 2 << 1;
        this.producerMask = newMask;
        int offsetInOld = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, oldMask);
        int offsetInNew = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, newMask);
        AtomicQueueUtil.soRefElement(newBuffer, offsetInNew, e2 == null ? s2.get() : e2);
        AtomicQueueUtil.soRefElement(oldBuffer, BaseMpscLinkedAtomicArrayQueue.nextArrayOffset(oldMask), newBuffer);
        long cIndex = this.lvConsumerIndex();
        long availableInQueue = this.availableInQueue(pIndex, cIndex);
        RangeUtil.checkPositive(availableInQueue, "availableInQueue");
        this.soProducerLimit(pIndex + Math.min((long)newMask, availableInQueue));
        this.soProducerIndex(pIndex + 2L);
        AtomicQueueUtil.soRefElement(oldBuffer, offsetInOld, JUMP);
    }

    protected abstract int getNextBufferSize(AtomicReferenceArray<E> var1);

    protected abstract long getCurrentBufferCapacity(long var1);

    private static class WeakIterator<E>
    implements Iterator<E> {
        private final long pIndex;
        private long nextIndex;
        private E nextElement;
        private AtomicReferenceArray<E> currentBuffer;
        private int mask;

        WeakIterator(AtomicReferenceArray<E> currentBuffer, long cIndex, long pIndex) {
            this.pIndex = pIndex >> 1;
            this.nextIndex = cIndex >> 1;
            this.setBuffer(currentBuffer);
            this.nextElement = this.getNext();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override
        public boolean hasNext() {
            return this.nextElement != null;
        }

        @Override
        public E next() {
            E e2 = this.nextElement;
            if (e2 == null) {
                throw new NoSuchElementException();
            }
            this.nextElement = this.getNext();
            return e2;
        }

        private void setBuffer(AtomicReferenceArray<E> buffer) {
            this.currentBuffer = buffer;
            this.mask = AtomicQueueUtil.length(buffer) - 2;
        }

        private E getNext() {
            while (this.nextIndex < this.pIndex) {
                long index;
                ++this.nextIndex;
                E e2 = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(index, this.mask));
                if (e2 == null) continue;
                if (e2 != JUMP) {
                    return e2;
                }
                int nextBufferIndex = this.mask + 1;
                E nextBuffer = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcRefElementOffset(nextBufferIndex));
                if (nextBuffer == BUFFER_CONSUMED || nextBuffer == null) {
                    return null;
                }
                this.setBuffer((AtomicReferenceArray)nextBuffer);
                e2 = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(index, this.mask));
                if (e2 == null) continue;
                return e2;
            }
            return null;
        }
    }
}

