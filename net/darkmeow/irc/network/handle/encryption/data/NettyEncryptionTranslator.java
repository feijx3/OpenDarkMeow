/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.handle.encryption.data;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import org.jetbrains.annotations.NotNull;

public class NettyEncryptionTranslator {
    @NotNull
    private final Cipher cipher;
    private byte[] inputBuffer = new byte[0];
    private byte[] outputBuffer = new byte[0];

    public NettyEncryptionTranslator(@NotNull Cipher cipherIn) {
        this.cipher = cipherIn;
    }

    private byte[] bufToBytes(ByteBuf buf) {
        int i2 = buf.readableBytes();
        if (this.inputBuffer.length < i2) {
            this.inputBuffer = new byte[i2];
        }
        buf.readBytes(this.inputBuffer, 0, i2);
        return this.inputBuffer;
    }

    public ByteBuf decipher(ChannelHandlerContext ctx, ByteBuf buffer) throws ShortBufferException {
        int i2 = buffer.readableBytes();
        byte[] source = this.bufToBytes(buffer);
        ByteBuf bytebuf = ctx.alloc().heapBuffer(this.cipher.getOutputSize(i2));
        bytebuf.writerIndex(this.cipher.update(source, 0, i2, bytebuf.array(), bytebuf.arrayOffset()));
        return bytebuf;
    }

    public void cipher(ByteBuf in, ByteBuf out) throws ShortBufferException {
        int i2 = in.readableBytes();
        byte[] source = this.bufToBytes(in);
        int j2 = this.cipher.getOutputSize(i2);
        if (this.outputBuffer.length < j2) {
            this.outputBuffer = new byte[j2];
        }
        out.writeBytes(this.outputBuffer, 0, this.cipher.update(source, 0, i2, this.outputBuffer));
    }
}

