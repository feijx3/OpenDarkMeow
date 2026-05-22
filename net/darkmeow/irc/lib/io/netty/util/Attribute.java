/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util;

import net.darkmeow.irc.lib.io.netty.util.AttributeKey;

public interface Attribute<T> {
    public AttributeKey<T> key();

    public T get();

    public void set(T var1);

    public T getAndSet(T var1);

    public T setIfAbsent(T var1);

    @Deprecated
    public T getAndRemove();

    public boolean compareAndSet(T var1, T var2);

    @Deprecated
    public void remove();
}

