/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

class InverseColorMap {
    static final int QUANTBITS = 5;
    static final int TRUNCBITS = 3;
    static final int QUANTMASK_BLUE = 31;
    static final int QUANTMASK_GREEN = 992;
    static final int QUANTMASK_RED = 31744;
    static final int MAXQUANTVAL = 32;
    byte[] rgbMapByte;
    int[] rgbMapInt;
    int numColors;
    int maxColor;
    byte[] inverseRGB;
    int transparentIndex = -1;

    InverseColorMap(byte[] byArray) {
        this(byArray, -1);
    }

    InverseColorMap(int[] nArray) {
        this(nArray, -1);
    }

    InverseColorMap(byte[] byArray, int n2) {
        this.rgbMapByte = byArray;
        this.numColors = this.rgbMapByte.length / 4;
        this.transparentIndex = n2;
        this.inverseRGB = new byte[32768];
        this.initIRGB(new int[32768]);
    }

    InverseColorMap(int[] nArray, int n2) {
        this.rgbMapInt = nArray;
        this.numColors = this.rgbMapInt.length;
        this.transparentIndex = n2;
        this.inverseRGB = new byte[32768];
        this.initIRGB(new int[32768]);
    }

    void initIRGB(int[] nArray) {
        for (int i2 = 0; i2 < this.numColors; ++i2) {
            int n2;
            int n3;
            int n4;
            if (i2 == this.transparentIndex) continue;
            if (this.rgbMapByte != null) {
                n4 = this.rgbMapByte[i2 * 4] & 0xFF;
                n3 = this.rgbMapByte[i2 * 4 + 1] & 0xFF;
                n2 = this.rgbMapByte[i2 * 4 + 2] & 0xFF;
            } else if (this.rgbMapInt != null) {
                n4 = this.rgbMapInt[i2] >> 16 & 0xFF;
                n3 = this.rgbMapInt[i2] >> 8 & 0xFF;
                n2 = this.rgbMapInt[i2] & 0xFF;
            } else {
                throw new IllegalStateException("colormap == null");
            }
            int n5 = n4 - 4;
            int n6 = n3 - 4;
            int n7 = n2 - 4;
            n5 = n5 * n5 + n6 * n6 + n7 * n7;
            int n8 = 2 * (64 - (n4 << 3));
            int n9 = 2 * (64 - (n3 << 3));
            int n10 = 2 * (64 - (n2 << 3));
            int n11 = 0;
            int n12 = 0;
            int n13 = n8;
            while (n12 < 32) {
                int n14 = 0;
                n6 = n5;
                int n15 = n9;
                while (n14 < 32) {
                    int n16 = 0;
                    n7 = n6;
                    int n17 = n10;
                    while (n16 < 32) {
                        if (i2 == 0 || nArray[n11] > n7) {
                            nArray[n11] = n7;
                            this.inverseRGB[n11] = (byte)i2;
                        }
                        n7 += n17;
                        ++n16;
                        ++n11;
                        n17 += 128;
                    }
                    n6 += n15;
                    ++n14;
                    n15 += 128;
                }
                n5 += n13;
                ++n12;
                n13 += 128;
            }
        }
    }

    public final int getIndexNearest(int n2) {
        return this.inverseRGB[(n2 >> 9 & 0x7C00) + (n2 >> 6 & 0x3E0) + (n2 >> 3 & 0x1F)] & 0xFF;
    }

    public final int getIndexNearest(int n2, int n3, int n4) {
        return this.inverseRGB[(n2 << 7 & 0x7C00) + (n3 << 2 & 0x3E0) + (n4 >> 3 & 0x1F)] & 0xFF;
    }
}

