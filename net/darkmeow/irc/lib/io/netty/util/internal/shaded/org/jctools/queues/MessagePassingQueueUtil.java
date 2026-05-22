/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

public final class MessagePassingQueueUtil {
    public static <E> int drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c2, int limit) {
        E e2;
        int i2;
        if (null == c2) {
            throw new IllegalArgumentException("c is null");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("limit is negative: " + limit);
        }
        if (limit == 0) {
            return 0;
        }
        for (i2 = 0; i2 < limit && (e2 = queue.relaxedPoll()) != null; ++i2) {
            c2.accept(e2);
        }
        return i2;
    }

    public static <E> int drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c2) {
        E e2;
        if (null == c2) {
            throw new IllegalArgumentException("c is null");
        }
        int i2 = 0;
        while ((e2 = queue.relaxedPoll()) != null) {
            ++i2;
            c2.accept(e2);
        }
        return i2;
    }

    public static <E> void drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c2, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        if (null == c2) {
            throw new IllegalArgumentException("c is null");
        }
        if (null == wait) {
            throw new IllegalArgumentException("wait is null");
        }
        if (null == exit) {
            throw new IllegalArgumentException("exit condition is null");
        }
        int idleCounter = 0;
        while (exit.keepRunning()) {
            E e2 = queue.relaxedPoll();
            if (e2 == null) {
                idleCounter = wait.idle(idleCounter);
                continue;
            }
            idleCounter = 0;
            c2.accept(e2);
        }
    }

    public static <E> void fill(MessagePassingQueue<E> q2, MessagePassingQueue.Supplier<E> s2, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        if (null == wait) {
            throw new IllegalArgumentException("waiter is null");
        }
        if (null == exit) {
            throw new IllegalArgumentException("exit condition is null");
        }
        int idleCounter = 0;
        while (exit.keepRunning()) {
            if (q2.fill(s2, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                idleCounter = wait.idle(idleCounter);
                continue;
            }
            idleCounter = 0;
        }
    }

    public static <E> int fillBounded(MessagePassingQueue<E> q2, MessagePassingQueue.Supplier<E> s2) {
        return MessagePassingQueueUtil.fillInBatchesToLimit(q2, s2, PortableJvmInfo.RECOMENDED_OFFER_BATCH, q2.capacity());
    }

    public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> q2, MessagePassingQueue.Supplier<E> s2, int batch, int limit) {
        int filled;
        long result = 0L;
        do {
            if ((filled = q2.fill(s2, batch)) != 0) continue;
            return (int)result;
        } while ((result += (long)filled) <= (long)limit);
        return (int)result;
    }

    public static <E> int fillUnbounded(MessagePassingQueue<E> q2, MessagePassingQueue.Supplier<E> s2) {
        return MessagePassingQueueUtil.fillInBatchesToLimit(q2, s2, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
    }
}

