/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public final class FastByteArrayOutputStream
extends ByteArrayOutputStream {
    public FastByteArrayOutputStream(int n2) {
        super(n2);
    }

    public FastByteArrayOutputStream(byte[] byArray) {
        super(0);
        this.buf = byArray;
        this.count = byArray.length;
    }

    @Override
    public void write(byte[] byArray, int n2, int n3) {
        if (n2 < 0 || n2 > byArray.length || n3 < 0 || n2 + n3 > byArray.length || n2 + n3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n3 == 0) {
            return;
        }
        int n4 = this.count + n3;
        this.growIfNeeded(n4);
        System.arraycopy(byArray, n2, this.buf, this.count, n3);
        this.count = n4;
    }

    @Override
    public void write(int n2) {
        int n3 = this.count + 1;
        this.growIfNeeded(n3);
        this.buf[this.count] = (byte)n2;
        this.count = n3;
    }

    private void growIfNeeded(int n2) {
        if (n2 > this.buf.length) {
            int n3 = Math.max(this.buf.length << 1, n2);
            this.buf = Arrays.copyOf(this.buf, n3);
        }
    }

    @Override
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.count);
    }

    @Override
    public byte[] toByteArray() {
        return Arrays.copyOf(this.buf, this.count);
    }

    public ByteArrayInputStream createInputStream() {
        return new ByteArrayInputStream(this.buf, 0, this.count);
    }
}

