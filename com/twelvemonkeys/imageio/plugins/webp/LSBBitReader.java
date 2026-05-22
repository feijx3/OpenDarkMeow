/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp;

import com.twelvemonkeys.lang.Validate;
import java.io.EOFException;
import java.io.IOException;
import javax.imageio.stream.ImageInputStream;

public final class LSBBitReader {
    private final ImageInputStream imageInput;
    private int bitOffset = 64;
    private long streamPosition = -1L;
    private long buffer;

    public LSBBitReader(ImageInputStream imageInputStream) {
        this.imageInput = Validate.notNull(imageInputStream);
    }

    public long readBits(int n2) throws IOException {
        return this.readBits(n2, false);
    }

    public long peekBits(int n2) throws IOException {
        if (n2 > 56) {
            throw new IllegalArgumentException("Tried peeking over 56");
        }
        return this.readBits(n2, true);
    }

    private long readBits(int n2, boolean bl2) throws IOException {
        if (n2 <= 56) {
            if (this.streamPosition != this.imageInput.getStreamPosition()) {
                this.resetBuffer();
            }
            long l2 = this.buffer >>> this.bitOffset & (1L << n2) - 1L;
            if (!bl2) {
                this.bitOffset += n2;
                if (this.bitOffset >= 8) {
                    this.refillBuffer();
                }
            }
            return l2;
        }
        long l3 = this.readBits(56);
        return this.readBits(n2 - 56) << 56 | l3;
    }

    private void refillBuffer() throws IOException {
        this.imageInput.readLong();
        while (this.bitOffset >= 8) {
            try {
                byte by2 = this.imageInput.readByte();
                this.buffer = (long)by2 << 56 | this.buffer >>> 8;
                ++this.streamPosition;
            }
            catch (EOFException eOFException) {
                this.imageInput.seek(this.streamPosition);
                return;
            }
            this.bitOffset -= 8;
        }
        this.imageInput.seek(this.streamPosition);
    }

    private void resetBuffer() throws IOException {
        long l2 = this.imageInput.getStreamPosition();
        try {
            this.buffer = this.imageInput.readLong();
            this.bitOffset = 0;
            this.streamPosition = l2;
            this.imageInput.seek(l2);
        }
        catch (EOFException eOFException) {
            this.streamPosition = l2 - 8L;
            this.bitOffset = 64;
            this.refillBuffer();
        }
    }

    public int readBit() throws IOException {
        return (int)this.readBits(1);
    }
}

