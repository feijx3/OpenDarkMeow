/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.color;

import com.twelvemonkeys.imageio.color.ColorSpaces;

public final class YCbCrConverter {
    private static final int SCALEBITS = 16;
    private static final int MAXJSAMPLE = 255;
    private static final int CENTERJSAMPLE = 128;
    private static final int ONE_HALF = 32768;

    public static void convertYCbCr2RGB(byte[] byArray, byte[] byArray2, double[] dArray, double[] dArray2, int n2) {
        double d2;
        double d3;
        double d4;
        if (dArray2 == null) {
            d4 = byArray[n2] & 0xFF;
            d3 = (byArray[n2 + 1] & 0xFF) - 128;
            d2 = (byArray[n2 + 2] & 0xFF) - 128;
        } else {
            d4 = ((double)(byArray[n2] & 0xFF) - dArray2[0]) * 255.0 / (dArray2[1] - dArray2[0]);
            d3 = ((double)(byArray[n2 + 1] & 0xFF) - dArray2[2]) * 127.0 / (dArray2[3] - dArray2[2]);
            d2 = ((double)(byArray[n2 + 2] & 0xFF) - dArray2[4]) * 127.0 / (dArray2[5] - dArray2[4]);
        }
        double d5 = dArray[0];
        double d6 = dArray[1];
        double d7 = dArray[2];
        int n3 = (int)Math.round(d2 * (2.0 - 2.0 * d5) + d4);
        int n4 = (int)Math.round(d3 * (2.0 - 2.0 * d7) + d4);
        int n5 = (int)Math.round((d4 - d5 * (double)n3 - d7 * (double)n4) / d6);
        byArray2[n2] = YCbCrConverter.clamp(n3);
        byArray2[n2 + 2] = YCbCrConverter.clamp(n4);
        byArray2[n2 + 1] = YCbCrConverter.clamp(n5);
    }

    public static void convertJPEGYCbCr2RGB(byte[] byArray, byte[] byArray2, int n2) {
        int n3 = byArray[n2] & 0xFF;
        int n4 = byArray[n2 + 1] & 0xFF;
        int n5 = byArray[n2 + 2] & 0xFF;
        byArray2[n2] = YCbCrConverter.clamp(n3 + JPEG.Cr_R_LUT[n5]);
        byArray2[n2 + 1] = YCbCrConverter.clamp(n3 + (JPEG.Cb_G_LUT[n4] + JPEG.Cr_G_LUT[n5] >> 16));
        byArray2[n2 + 2] = YCbCrConverter.clamp(n3 + JPEG.Cb_B_LUT[n4]);
    }

    public static void convertRec601YCbCr2RGB(byte[] byArray, byte[] byArray2, int n2) {
        int n3 = byArray[n2] & 0xFF;
        int n4 = byArray[n2 + 1] & 0xFF;
        int n5 = byArray[n2 + 2] & 0xFF;
        byArray2[n2] = YCbCrConverter.clamp(ITU_R_601.Y_LUT[n3] + ITU_R_601.Cr_R_LUT[n5]);
        byArray2[n2 + 1] = YCbCrConverter.clamp(ITU_R_601.Y_LUT[n3] + (ITU_R_601.Cr_G_LUT[n5] + ITU_R_601.Cb_G_LUT[n4] >> 16));
        byArray2[n2 + 2] = YCbCrConverter.clamp(ITU_R_601.Y_LUT[n3] + ITU_R_601.Cb_B_LUT[n4]);
    }

    private static byte clamp(int n2) {
        return (byte)Math.max(0, Math.min(255, n2));
    }

    private static final class ITU_R_601 {
        private static final int[] Cr_R_LUT = new int[256];
        private static final int[] Cb_B_LUT = new int[256];
        private static final int[] Cr_G_LUT = new int[256];
        private static final int[] Cb_G_LUT = new int[256];
        private static final int[] Y_LUT = new int[256];

        private ITU_R_601() {
        }

        private static void buildYCCtoRGBtable() {
            if (ColorSpaces.DEBUG) {
                System.err.println("Building ITU-R REC.601 YCbCr conversion table");
            }
            int n2 = 0;
            int n3 = -128;
            while (n2 <= 255) {
                ITU_R_601.Cr_R_LUT[n2] = 104597 * n3 + 32768 >> 16;
                ITU_R_601.Cb_B_LUT[n2] = 132201 * n3 + 32768 >> 16;
                ITU_R_601.Cr_G_LUT[n2] = -53279 * n3;
                ITU_R_601.Cb_G_LUT[n2] = -25674 * n3 + 32768;
                ITU_R_601.Y_LUT[n2] = 76309 * (n2 - 16) + 32768 >> 16;
                ++n2;
                ++n3;
            }
        }

        static {
            ITU_R_601.buildYCCtoRGBtable();
        }
    }

    private static final class JPEG {
        private static final int[] Cr_R_LUT = new int[256];
        private static final int[] Cb_B_LUT = new int[256];
        private static final int[] Cr_G_LUT = new int[256];
        private static final int[] Cb_G_LUT = new int[256];

        private JPEG() {
        }

        private static void buildYCCtoRGBtable() {
            if (ColorSpaces.DEBUG) {
                System.err.println("Building JPEG YCbCr conversion table");
            }
            int n2 = 0;
            int n3 = -128;
            while (n2 <= 255) {
                JPEG.Cr_R_LUT[n2] = (int)(91881.972 * (double)n3 + 32768.0) >> 16;
                JPEG.Cb_B_LUT[n2] = (int)(116130.292 * (double)n3 + 32768.0) >> 16;
                JPEG.Cr_G_LUT[n2] = -46802 * n3;
                JPEG.Cb_G_LUT[n2] = -22554 * n3 + 32768;
                ++n2;
                ++n3;
            }
        }

        static {
            JPEG.buildYCCtoRGBtable();
        }
    }
}

