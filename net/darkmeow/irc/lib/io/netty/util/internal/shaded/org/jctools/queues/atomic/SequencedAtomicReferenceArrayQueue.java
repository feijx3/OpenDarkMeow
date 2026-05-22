/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue;

public abstract class SequencedAtomicReferenceArrayQueue<E>
extends AtomicReferenceArrayQueue<E> {
    protected final AtomicLongArray sequenceBuffer;

    public SequencedAtomicReferenceArrayQueue(int capacity) {
        super(capacity);
        int actualCapacity = this.mask + 1;
        this.sequenceBuffer = new AtomicLongArray(actualCapacity);
        for (int i2 = 0; i2 < actualCapacity; ++i2) {
            this.soSequence(this.sequenceBuffer, i2, i2);
        }
    }

    protected final long calcSequenceOffset(long index) {
        return SequencedAtomicReferenceArrayQueue.calcSequenceOffset(index, this.mask);
    }

    protected static int calcSequenceOffset(long index, int mask) {
        return (int)index & mask;
    }

    protected final void soSequence(AtomicLongArray buffer, int offset, long e2) {
        buffer.lazySet(offset, e2);
    }

    protected final long lvSequence(AtomicLongArray buffer, int offset) {
        return buffer.get(offset);
    }
}

