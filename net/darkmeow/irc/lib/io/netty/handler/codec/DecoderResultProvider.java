/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec;

import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResult;

public interface DecoderResultProvider {
    public DecoderResult decoderResult();

    public void setDecoderResult(DecoderResult var1);
}

