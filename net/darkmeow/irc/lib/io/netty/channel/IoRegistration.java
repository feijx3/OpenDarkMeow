/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.IoOps;

public interface IoRegistration {
    public <T> T attachment();

    public long submit(IoOps var1);

    public boolean isValid();

    public boolean cancel();
}

