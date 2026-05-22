/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.codec.hash.HashFunction;
import java.util.Arrays;

public final class HashBuilder {
    private static final byte[] EMPTY_BYTES = new byte[0];
    private final HashFunction hashFunction;
    private byte[] bytes = EMPTY_BYTES;
    private int index;

    public HashBuilder(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }

    public HashBuilder writeByte(byte b2) {
        this.ensureSize(1);
        this.bytes[this.index++] = b2;
        return this;
    }

    public HashBuilder writeBytes(byte[] bytes) {
        this.ensureSize(bytes.length);
        System.arraycopy(bytes, 0, this.bytes, this.index, bytes.length);
        this.index += bytes.length;
        return this;
    }

    public void writeBytesDirect(byte[] bytes) {
        if (this.bytes.length == 0) {
            this.bytes = bytes;
            this.index = bytes.length;
        } else {
            this.writeBytes(bytes);
        }
    }

    public HashBuilder writeBoolean(boolean value) {
        this.ensureSize(1);
        this.bytes[this.index++] = (byte)(value ? 1 : 0);
        return this;
    }

    public HashBuilder writeShort(short s2) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)s2;
        this.bytes[this.index++] = (byte)(s2 >> 8);
        return this;
    }

    public HashBuilder writeChar(char c2) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)c2;
        this.bytes[this.index++] = (byte)(c2 >> 8);
        return this;
    }

    public HashBuilder writeString(CharSequence sequence) {
        int length = sequence.length();
        this.ensureSize(length);
        for (int i2 = 0; i2 < length; ++i2) {
            this.writeChar(sequence.charAt(i2));
        }
        return this;
    }

    public HashBuilder writeInt(int i2) {
        this.ensureSize(4);
        this.bytes[this.index++] = (byte)i2;
        this.bytes[this.index++] = (byte)(i2 >> 8);
        this.bytes[this.index++] = (byte)(i2 >> 16);
        this.bytes[this.index++] = (byte)(i2 >> 24);
        return this;
    }

    public HashBuilder writeLong(long l2) {
        this.ensureSize(8);
        this.bytes[this.index++] = (byte)l2;
        this.bytes[this.index++] = (byte)(l2 >> 8);
        this.bytes[this.index++] = (byte)(l2 >> 16);
        this.bytes[this.index++] = (byte)(l2 >> 24);
        this.bytes[this.index++] = (byte)(l2 >> 32);
        this.bytes[this.index++] = (byte)(l2 >> 40);
        this.bytes[this.index++] = (byte)(l2 >> 48);
        this.bytes[this.index++] = (byte)(l2 >> 56);
        return this;
    }

    public HashBuilder writeFloat(float f2) {
        this.writeInt(Float.floatToIntBits(f2));
        return this;
    }

    public HashBuilder writeDouble(double d2) {
        this.writeLong(Double.doubleToLongBits(d2));
        return this;
    }

    public HashBuilder preSize(int bytes) {
        if (this.bytes.length == 0) {
            this.bytes = new byte[bytes];
        } else {
            this.ensureSize(bytes);
        }
        return this;
    }

    private void ensureSize(int bytes) {
        int length = this.bytes.length;
        if (this.index + bytes > length) {
            int newLength = Math.max(length * 2, this.index + bytes);
            this.bytes = Arrays.copyOf(this.bytes, newLength);
        }
    }

    public int hash() {
        return this.hashFunction.hashBytes(this.bytes, this.index);
    }

    public void reset() {
        this.index = 0;
        this.bytes = EMPTY_BYTES;
    }

    public HashFunction function() {
        return this.hashFunction;
    }
}

