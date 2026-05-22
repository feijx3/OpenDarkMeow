/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

final class IDCT {
    private static final int cospi8sqrt2minus1 = 20091;
    private static final int sinpi8sqrt2 = 35468;

    IDCT() {
    }

    public static int[][] idct4x4llm(int[] nArray) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int[] nArray2 = new int[16];
        int n9 = 0;
        for (n8 = 0; n8 < 4; ++n8) {
            n7 = nArray[n9] + nArray[n9 + 8];
            n6 = nArray[n9] - nArray[n9 + 8];
            n5 = nArray[n9 + 4] * 35468 >> 16;
            n4 = nArray[n9 + 12] + (nArray[n9 + 12] * 20091 >> 16);
            n3 = n5 - n4;
            n5 = nArray[n9 + 4] + (nArray[n9 + 4] * 20091 >> 16);
            n4 = nArray[n9 + 12] * 35468 >> 16;
            n2 = n5 + n4;
            nArray2[n9] = n7 + n2;
            nArray2[n9 + 12] = n7 - n2;
            nArray2[n9 + 4] = n6 + n3;
            nArray2[n9 + 8] = n6 - n3;
            ++n9;
        }
        n8 = 0;
        int[][] nArray3 = new int[4][4];
        int n10 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            n7 = nArray2[n10 * 4] + nArray2[n10 * 4 + 2];
            n6 = nArray2[n10 * 4] - nArray2[n10 * 4 + 2];
            n5 = nArray2[n10 * 4 + 1] * 35468 >> 16;
            n4 = nArray2[n10 * 4 + 3] + (nArray2[n10 * 4 + 3] * 20091 >> 16);
            n3 = n5 - n4;
            n5 = nArray2[n10 * 4 + 1] + (nArray2[n10 * 4 + 1] * 20091 >> 16);
            n4 = nArray2[n10 * 4 + 3] * 35468 >> 16;
            n2 = n5 + n4;
            nArray2[n10 * 4] = n7 + n2 + 4 >> 3;
            nArray2[n10 * 4 + 3] = n7 - n2 + 4 >> 3;
            nArray2[n10 * 4 + 1] = n6 + n3 + 4 >> 3;
            nArray2[n10 * 4 + 2] = n6 - n3 + 4 >> 3;
            nArray3[0][n8] = n7 + n2 + 4 >> 3;
            nArray3[3][n8] = n7 - n2 + 4 >> 3;
            nArray3[1][n8] = n6 + n3 + 4 >> 3;
            nArray3[2][n8] = n6 - n3 + 4 >> 3;
            ++n10;
            ++n8;
        }
        return nArray3;
    }

    public static int[][] iwalsh4x4(int[] nArray) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int[] nArray2 = new int[16];
        int[][] nArray3 = new int[4][4];
        int n7 = 0;
        for (n6 = 0; n6 < 4; ++n6) {
            n5 = nArray[n7] + nArray[n7 + 12];
            n4 = nArray[n7 + 4] + nArray[n7 + 8];
            n3 = nArray[n7 + 4] - nArray[n7 + 8];
            n2 = nArray[n7] - nArray[n7 + 12];
            nArray2[n7] = n5 + n4;
            nArray2[n7 + 4] = n3 + n2;
            nArray2[n7 + 8] = n5 - n4;
            nArray2[n7 + 12] = n2 - n3;
            ++n7;
        }
        n7 = 0;
        for (n6 = 0; n6 < 4; ++n6) {
            n5 = nArray2[n7] + nArray2[n7 + 3];
            n4 = nArray2[n7 + 1] + nArray2[n7 + 2];
            n3 = nArray2[n7 + 1] - nArray2[n7 + 2];
            n2 = nArray2[n7] - nArray2[n7 + 3];
            int n8 = n5 + n4;
            int n9 = n3 + n2;
            int n10 = n5 - n4;
            int n11 = n2 - n3;
            nArray2[n7] = n8 + 3 >> 3;
            nArray2[n7 + 1] = n9 + 3 >> 3;
            nArray2[n7 + 2] = n10 + 3 >> 3;
            nArray2[n7 + 3] = n11 + 3 >> 3;
            nArray3[0][n6] = n8 + 3 >> 3;
            nArray3[1][n6] = n9 + 3 >> 3;
            nArray3[2][n6] = n10 + 3 >> 3;
            nArray3[3][n6] = n11 + 3 >> 3;
            n7 += 4;
        }
        return nArray3;
    }
}

