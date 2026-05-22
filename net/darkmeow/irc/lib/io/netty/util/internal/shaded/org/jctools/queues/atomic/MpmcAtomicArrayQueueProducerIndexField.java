/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.MpmcAtomicArrayQueueL1Pad;

abstract class MpmcAtomicArrayQueueProducerIndexField<E>
extends MpmcAtomicArrayQueueL1Pad<E> {
    private static final AtomicLongFieldUpdater<MpmcAtomicArrayQueueProducerIndexField> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpmcAtomicArrayQueueProducerIndexField.class, "producerIndex");
    private volatile long producerIndex;

    MpmcAtomicArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final boolean casProducerIndex(long expect, long newValue) {
        return P_INDEX_UPDATER.compareAndSet(this, expect, newValue);
    }
}

