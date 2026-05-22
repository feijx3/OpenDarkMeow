/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

public final class LinkedQueueNode<E> {
    private static final long NEXT_OFFSET = UnsafeAccess.fieldOffset(LinkedQueueNode.class, "next");
    private E value;
    private volatile LinkedQueueNode<E> next;

    public LinkedQueueNode() {
        this(null);
    }

    public LinkedQueueNode(E val) {
        this.spValue(val);
    }

    public E getAndNullValue() {
        E temp = this.lpValue();
        this.spValue(null);
        return temp;
    }

    public E lpValue() {
        return this.value;
    }

    public void spValue(E newValue) {
        this.value = newValue;
    }

    public void soNext(LinkedQueueNode<E> n2) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, NEXT_OFFSET, n2);
    }

    public void spNext(LinkedQueueNode<E> n2) {
        UnsafeAccess.UNSAFE.putObject((Object)this, NEXT_OFFSET, n2);
    }

    public LinkedQueueNode<E> lvNext() {
        return this.next;
    }
}

