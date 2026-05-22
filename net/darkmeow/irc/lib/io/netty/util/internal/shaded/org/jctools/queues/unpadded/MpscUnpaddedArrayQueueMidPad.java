/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.unpadded;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.unpadded.MpscUnpaddedArrayQueueProducerIndexField;

abstract class MpscUnpaddedArrayQueueMidPad<E>
extends MpscUnpaddedArrayQueueProducerIndexField<E> {
    MpscUnpaddedArrayQueueMidPad(int capacity) {
        super(capacity);
    }
}

