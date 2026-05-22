/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.stream;

import com.twelvemonkeys.lang.Validate;
import java.io.IOException;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;

public final class SubImageInputStream
extends ImageInputStreamImpl {
    private final ImageInputStream stream;
    private final long startPos;
    private final long length;

    public SubImageInputStream(ImageInputStream imageInputStream, long l2) throws IOException {
        Validate.notNull(imageInputStream, "stream");
        Validate.isTrue(l2 >= 0L, l2, "length < 0: %d");
        this.stream = imageInputStream;
        this.startPos = imageInputStream.getStreamPosition();
        this.length = l2;
    }

    @Override
    public int read() throws IOException {
        if (this.streamPos >= this.length) {
            return -1;
        }
        int n2 = this.stream.read();
        if (n2 >= 0) {
            ++this.streamPos;
        }
        return n2;
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) throws IOException {
        if (this.streamPos >= this.length) {
            return -1;
        }
        int n4 = (int)Math.min((long)n3, this.length - this.streamPos);
        int n5 = this.stream.read(byArray, n2, n4);
        if (n5 >= 0) {
            this.streamPos += (long)n5;
        }
        return n5;
    }

    @Override
    public long length() {
        try {
            long l2 = this.stream.length();
            return l2 < 0L ? -1L : Math.min(l2 - this.startPos, this.length);
        }
        catch (IOException iOException) {
            return -1L;
        }
    }

    @Override
    public void seek(long l2) throws IOException {
        if (l2 < this.getFlushedPosition()) {
            throw new IndexOutOfBoundsException("pos < flushedPosition");
        }
        this.stream.seek(this.startPos + l2);
        this.streamPos = l2;
    }

    @Override
    protected void finalize() {
    }
}

