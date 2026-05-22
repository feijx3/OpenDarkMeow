/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.unpadded;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.unpadded.MpscAtomicUnpaddedArrayQueueProducerIndexField;

abstract class MpscAtomicUnpaddedArrayQueueMidPad<E>
extends MpscAtomicUnpaddedArrayQueueProducerIndexField<E> {
    MpscAtomicUnpaddedArrayQueueMidPad(int capacity) {
        super(capacity);
    }
}

