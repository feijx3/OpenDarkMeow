/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.UnsafeLongArrayAccess;

public abstract class ConcurrentSequencedCircularArrayQueue<E>
extends ConcurrentCircularArrayQueue<E> {
    protected final long[] sequenceBuffer;

    public ConcurrentSequencedCircularArrayQueue(int capacity) {
        super(capacity);
        int actualCapacity = (int)(this.mask + 1L);
        this.sequenceBuffer = UnsafeLongArrayAccess.allocateLongArray(actualCapacity);
        for (long i2 = 0L; i2 < (long)actualCapacity; ++i2) {
            UnsafeLongArrayAccess.soLongElement(this.sequenceBuffer, UnsafeLongArrayAccess.calcCircularLongElementOffset(i2, this.mask), i2);
        }
    }
}

