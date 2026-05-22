/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

public interface MessageSizeEstimator {
    public Handle newHandle();

    public static interface Handle {
        public int size(Object var1);
    }
}

