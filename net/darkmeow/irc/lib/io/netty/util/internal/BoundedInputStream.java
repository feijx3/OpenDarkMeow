/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import org.jetbrains.annotations.NotNull;

public final class BoundedInputStream
extends FilterInputStream {
    private final int maxBytesRead;
    private int numRead;

    public BoundedInputStream(@NotNull InputStream in, int maxBytesRead) {
        super(in);
        this.maxBytesRead = ObjectUtil.checkPositive(maxBytesRead, "maxRead");
    }

    public BoundedInputStream(@NotNull InputStream in) {
        this(in, 8192);
    }

    @Override
    public int read() throws IOException {
        this.checkMaxBytesRead();
        int b2 = super.read();
        if (b2 != -1) {
            ++this.numRead;
        }
        return b2;
    }

    @Override
    public int read(byte[] buf, int off, int len) throws IOException {
        this.checkMaxBytesRead();
        int num = Math.min(len, this.maxBytesRead - this.numRead + 1);
        int b2 = super.read(buf, off, num);
        if (b2 != -1) {
            this.numRead += b2;
        }
        return b2;
    }

    private void checkMaxBytesRead() throws IOException {
        if (this.numRead > this.maxBytesRead) {
            throw new IOException("Maximum number of bytes read: " + this.numRead);
        }
    }
}

