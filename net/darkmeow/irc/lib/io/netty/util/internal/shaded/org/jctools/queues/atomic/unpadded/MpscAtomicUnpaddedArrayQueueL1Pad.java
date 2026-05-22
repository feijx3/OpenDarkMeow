/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.unpadded;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue;

abstract class MpscAtomicUnpaddedArrayQueueL1Pad<E>
extends AtomicReferenceArrayQueue<E> {
    MpscAtomicUnpaddedArrayQueueL1Pad(int capacity) {
        super(capacity);
    }
}

