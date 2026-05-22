/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufHolder;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpObject;

public interface HttpContent
extends HttpObject,
ByteBufHolder {
    @Override
    public HttpContent copy();

    @Override
    public HttpContent duplicate();

    @Override
    public HttpContent retainedDuplicate();

    @Override
    public HttpContent replace(ByteBuf var1);

    @Override
    public HttpContent retain();

    @Override
    public HttpContent retain(int var1);

    @Override
    public HttpContent touch();

    @Override
    public HttpContent touch(Object var1);
}

