/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.util;

import com.twelvemonkeys.lang.Validate;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.stream.ImageInputStream;

class IIOInputStreamAdapter
extends InputStream {
    private ImageInputStream input;
    private final boolean hasLength;
    private long left;
    private long markPosition;

    public IIOInputStreamAdapter(ImageInputStream imageInputStream) {
        this(imageInputStream, -1L, false);
    }

    public IIOInputStreamAdapter(ImageInputStream imageInputStream, long l2) {
        this(imageInputStream, l2, true);
    }

    private IIOInputStreamAdapter(ImageInputStream imageInputStream, long l2, boolean bl2) {
        Validate.notNull(imageInputStream, "stream");
        Validate.isTrue(!bl2 || l2 >= 0L, l2, "length < 0: %d");
        this.input = imageInputStream;
        this.left = l2;
        this.hasLength = bl2;
    }

    @Override
    public void close() throws IOException {
        if (this.hasLength) {
            this.input.seek(this.input.getStreamPosition() + this.left);
        }
        this.left = 0L;
        this.input = null;
    }

    @Override
    public int available() throws IOException {
        if (this.hasLength) {
            return this.left > 0L ? (int)Math.min(Integer.MAX_VALUE, this.left) : 0;
        }
        return 0;
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public void mark(int n2) {
        try {
            this.markPosition = this.input.getStreamPosition();
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Could not read stream position: " + iOException.getMessage(), iOException);
        }
    }

    @Override
    public void reset() throws IOException {
        long l2 = this.input.getStreamPosition() - this.markPosition;
        this.input.seek(this.markPosition);
        this.left += l2;
    }

    @Override
    public int read() throws IOException {
        if (this.hasLength && this.left-- <= 0L) {
            this.left = 0L;
            return -1;
        }
        return this.input.read();
    }

    @Override
    public final int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) throws IOException {
        if (this.hasLength && this.left <= 0L) {
            return -1;
        }
        int n4 = this.input.read(byArray, n2, (int)this.findMaxLen(n3));
        if (this.hasLength) {
            this.left = n4 < 0 ? 0L : this.left - (long)n4;
        }
        return n4;
    }

    private long findMaxLen(long l2) {
        if (this.hasLength && this.left < l2) {
            return Math.max(this.left, 0L);
        }
        return Math.max(l2, 0L);
    }

    @Override
    public long skip(long l2) throws IOException {
        long l3 = this.input.skipBytes(this.findMaxLen(l2));
        this.left -= l3;
        return l3;
    }
}

