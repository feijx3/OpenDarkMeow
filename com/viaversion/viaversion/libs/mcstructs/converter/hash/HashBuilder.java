/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.hash;

import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashCode;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashFunction;
import java.util.Arrays;

public class HashBuilder {
    private final HashFunction hashFunction;
    private byte[] bytes;
    private int index = 0;

    public HashBuilder(HashFunction hashFunction) {
        this(hashFunction, 16);
    }

    public HashBuilder(HashFunction hashFunction, int initialSize) {
        this.hashFunction = hashFunction;
        this.bytes = new byte[initialSize];
    }

    public HashBuilder addByte(byte b2) {
        this.ensureSize(1);
        this.bytes[this.index++] = b2;
        return this;
    }

    public HashBuilder addBytes(byte[] bytes) {
        this.ensureSize(bytes.length);
        System.arraycopy(bytes, 0, this.bytes, this.index, bytes.length);
        this.index += bytes.length;
        return this;
    }

    public HashBuilder addShort(short s2) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)s2;
        this.bytes[this.index++] = (byte)(s2 >> 8);
        return this;
    }

    public HashBuilder addChar(char c2) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)c2;
        this.bytes[this.index++] = (byte)(c2 >> 8);
        return this;
    }

    public HashBuilder addCharSequence(CharSequence sequence) {
        this.ensureSize(sequence.length());
        for (int i2 = 0; i2 < sequence.length(); ++i2) {
            this.addChar(sequence.charAt(i2));
        }
        return this;
    }

    public HashBuilder addInt(int i2) {
        this.ensureSize(4);
        this.bytes[this.index++] = (byte)i2;
        this.bytes[this.index++] = (byte)(i2 >> 8);
        this.bytes[this.index++] = (byte)(i2 >> 16);
        this.bytes[this.index++] = (byte)(i2 >> 24);
        return this;
    }

    public HashBuilder addLong(long l2) {
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

    public HashBuilder addFloat(float f2) {
        return this.addInt(Float.floatToIntBits(f2));
    }

    public HashBuilder addDouble(double d2) {
        return this.addLong(Double.doubleToLongBits(d2));
    }

    public HashCode hash() {
        return this.hashFunction.hash(Arrays.copyOf(this.bytes, this.index));
    }

    private void ensureSize(int extra) {
        if (this.index + extra > this.bytes.length) {
            this.bytes = Arrays.copyOf(this.bytes, this.bytes.length * 2 + extra);
        }
    }
}

