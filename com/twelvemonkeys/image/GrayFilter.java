/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import java.awt.image.RGBImageFilter;

public class GrayFilter
extends RGBImageFilter {
    private int low;
    private float range;

    public GrayFilter() {
        this.canFilterIndexColorModel = true;
        this.low = 0;
        this.range = 1.0f;
    }

    public GrayFilter(float f2, float f3) {
        this.canFilterIndexColorModel = true;
        this.low = 0;
        this.range = 1.0f;
        if (f2 > f3) {
            f2 = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.low = (int)(f2 * 255.0f);
        this.range = f3 - f2;
    }

    public GrayFilter(int n2, int n3) {
        this((float)n2 / 255.0f, (float)n3 / 255.0f);
    }

    @Override
    public int filterRGB(int n2, int n3, int n4) {
        int n5 = n4 >> 16 & 0xFF;
        int n6 = n4 >> 8 & 0xFF;
        int n7 = n4 & 0xFF;
        int n8 = (222 * n5 + 707 * n6 + 71 * n7) / 1000;
        if (this.range != 1.0f) {
            n8 = this.low + (int)((float)n8 * this.range);
        }
        return n4 & 0xFF000000 | n8 << 16 | n8 << 8 | n8;
    }
}

