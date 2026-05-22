/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.Iterator;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueuePad2;
import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedQueueAtomicNode;

abstract class BaseLinkedAtomicQueue<E>
extends BaseLinkedAtomicQueuePad2<E> {
    BaseLinkedAtomicQueue() {
    }

    @Override
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    protected final LinkedQueueAtomicNode<E> newNode() {
        return new LinkedQueueAtomicNode();
    }

    protected final LinkedQueueAtomicNode<E> newNode(E e2) {
        return new LinkedQueueAtomicNode<E>(e2);
    }

    @Override
    public final int size() {
        int size;
        LinkedQueueAtomicNode chaserNode = this.lvConsumerNode();
        LinkedQueueAtomicNode producerNode = this.lvProducerNode();
        for (size = 0; chaserNode != producerNode && chaserNode != null && size < Integer.MAX_VALUE; ++size) {
            LinkedQueueAtomicNode next = chaserNode.lvNext();
            if (next == chaserNode) {
                return size;
            }
            chaserNode = next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        LinkedQueueAtomicNode producerNode;
        LinkedQueueAtomicNode consumerNode = this.lvConsumerNode();
        return consumerNode == (producerNode = this.lvProducerNode());
    }

    protected E getSingleConsumerNodeValue(LinkedQueueAtomicNode<E> currConsumerNode, LinkedQueueAtomicNode<E> nextNode) {
        E nextValue = nextNode.getAndNullValue();
        currConsumerNode.soNext(currConsumerNode);
        this.spConsumerNode(nextNode);
        return nextValue;
    }

    @Override
    public E poll() {
        LinkedQueueAtomicNode currConsumerNode = this.lpConsumerNode();
        LinkedQueueAtomicNode nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return this.getSingleConsumerNodeValue(currConsumerNode, nextNode);
        }
        if (currConsumerNode != this.lvProducerNode()) {
            nextNode = this.spinWaitForNextNode(currConsumerNode);
            return this.getSingleConsumerNodeValue(currConsumerNode, nextNode);
        }
        return null;
    }

    @Override
    public E peek() {
        LinkedQueueAtomicNode currConsumerNode = this.lpConsumerNode();
        LinkedQueueAtomicNode nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return nextNode.lpValue();
        }
        if (currConsumerNode != this.lvProducerNode()) {
            nextNode = this.spinWaitForNextNode(currConsumerNode);
            return nextNode.lpValue();
        }
        return null;
    }

    LinkedQueueAtomicNode<E> spinWaitForNextNode(LinkedQueueAtomicNode<E> currNode) {
        LinkedQueueAtomicNode<E> nextNode;
        while ((nextNode = currNode.lvNext()) == null) {
        }
        return nextNode;
    }

    @Override
    public E relaxedPoll() {
        LinkedQueueAtomicNode currConsumerNode = this.lpConsumerNode();
        LinkedQueueAtomicNode nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return this.getSingleConsumerNodeValue(currConsumerNode, nextNode);
        }
        return null;
    }

    @Override
    public E relaxedPeek() {
        LinkedQueueAtomicNode nextNode = this.lpConsumerNode().lvNext();
        if (nextNode != null) {
            return nextNode.lpValue();
        }
        return null;
    }

    @Override
    public boolean relaxedOffer(E e2) {
        return this.offer(e2);
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
        LinkedQueueAtomicNode chaserNode = this.lpConsumerNode();
        for (int i2 = 0; i2 < limit; ++i2) {
            LinkedQueueAtomicNode nextNode = chaserNode.lvNext();
            if (nextNode == null) {
                return i2;
            }
            Object nextValue = this.getSingleConsumerNodeValue(chaserNode, nextNode);
            chaserNode = nextNode;
            c2.accept(nextValue);
        }
        return limit;
    }

    @Override
    public int drain(MessagePassingQueue.Consumer<E> c2) {
        return MessagePassingQueueUtil.drain(this, c2);
    }

    @Override
    public void drain(MessagePassingQueue.Consumer<E> c2, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c2, wait, exit);
    }

    @Override
    public int capacity() {
        return -1;
    }
}

