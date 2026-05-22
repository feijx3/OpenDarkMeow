/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import java.awt.image.RGBImageFilter;

public class BrightnessContrastFilter
extends RGBImageFilter {
    private final int[] LUT;

    public BrightnessContrastFilter() {
        this(0.3f, 0.3f);
    }

    public BrightnessContrastFilter(float f2, float f3) {
        this.canFilterIndexColorModel = true;
        this.LUT = BrightnessContrastFilter.createLUT(f2, f3);
    }

    private static int[] createLUT(float f2, float f3) {
        int[] nArray = new int[256];
        double d2 = f3 > 0.0f ? Math.pow(f3, 7.0) * 127.0 : (double)f3;
        double d3 = (double)f2 + 1.0;
        for (int i2 = 0; i2 < 256; ++i2) {
            nArray[i2] = BrightnessContrastFilter.clamp((int)(127.5 * d3 + (double)(i2 - 127) * (d2 + 1.0)));
        }
        if (f3 == 1.0f) {
            nArray[127] = nArray[126];
        }
        return nArray;
    }

    private static int clamp(int n2) {
        if (n2 < 0) {
            return 0;
        }
        if (n2 > 255) {
            return 255;
        }
        return n2;
    }

    @Override
    public int filterRGB(int n2, int n3, int n4) {
        int n5 = n4 >> 16 & 0xFF;
        int n6 = n4 >> 8 & 0xFF;
        int n7 = n4 & 0xFF;
        n5 = this.LUT[n5];
        n6 = this.LUT[n6];
        n7 = this.LUT[n7];
        return n4 & 0xFF000000 | n5 << 16 | n6 << 8 | n7;
    }
}

