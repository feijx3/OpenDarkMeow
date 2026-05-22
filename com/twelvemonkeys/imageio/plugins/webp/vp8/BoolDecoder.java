/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

import com.twelvemonkeys.imageio.plugins.webp.vp8.Globals;
import java.io.IOException;
import javax.imageio.stream.ImageInputStream;

final class BoolDecoder {
    private int bitCount;
    ImageInputStream data;
    private long offset;
    private int range;
    private int value;

    BoolDecoder(ImageInputStream imageInputStream, long l2) throws IOException {
        this.data = imageInputStream;
        this.offset = l2;
        this.initBoolDecoder();
    }

    private void initBoolDecoder() throws IOException {
        this.value = 0;
        this.data.seek(this.offset);
        this.value = this.data.readUnsignedByte() << 8;
        ++this.offset;
        this.range = 255;
        this.bitCount = 0;
    }

    public int readBit() throws IOException {
        return this.readBool(128);
    }

    public int readBool(int n2) throws IOException {
        int n3 = 0;
        int n4 = this.range;
        int n5 = this.value;
        int n6 = 1 + ((n4 - 1) * n2 >> 8);
        int n7 = n6 << 8;
        n4 = n6;
        if (n5 >= n7) {
            n4 = this.range - n6;
            n5 -= n7;
            n3 = 1;
        }
        int n8 = this.bitCount;
        int n9 = Globals.vp8dxBitreaderNorm[n4];
        n4 <<= n9;
        n5 <<= n9;
        if ((n8 -= n9) <= 0) {
            n5 |= this.data.readUnsignedByte() << -n8;
            ++this.offset;
            n8 += 8;
        }
        this.bitCount = n8;
        this.value = n5;
        this.range = n4;
        return n3;
    }

    public int readLiteral(int n2) throws IOException {
        int n3 = 0;
        while (n2-- > 0) {
            n3 = (n3 << 1) + this.readBool(128);
        }
        return n3;
    }

    int readTree(int[] nArray, int[] nArray2, int n2) throws IOException {
        int n3 = n2 * 2;
        while ((n3 = nArray[n3 + this.readBool(nArray2[n3 >> 1])]) > 0) {
        }
        return -n3;
    }

    public void seek() throws IOException {
        this.data.seek(this.offset);
    }

    public String toString() {
        return "bc: " + this.value;
    }
}

