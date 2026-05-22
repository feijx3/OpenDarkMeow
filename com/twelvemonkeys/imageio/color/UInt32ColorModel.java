/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.color;

import java.awt.color.ColorSpace;
import java.awt.image.ComponentColorModel;

public final class UInt32ColorModel
extends ComponentColorModel {
    public UInt32ColorModel(ColorSpace colorSpace, boolean bl2, boolean bl3) {
        super(colorSpace, bl2, bl3, bl2 ? 3 : 1, 3);
    }

    @Override
    public float[] getNormalizedComponents(Object object, float[] fArray, int n2) {
        float f2;
        int n3 = this.getNumComponents();
        if (fArray == null) {
            fArray = new float[n3 + n2];
        }
        int[] nArray = (int[])object;
        int n4 = 0;
        int n5 = n2;
        while (n4 < n3) {
            fArray[n5] = (float)((long)nArray[n4] & 0xFFFFFFFFL) / (float)((1L << this.getComponentSize(n4)) - 1L);
            ++n4;
            ++n5;
        }
        n4 = this.getNumColorComponents();
        if (this.hasAlpha() && this.isAlphaPremultiplied() && (f2 = fArray[n4 + n2]) != 0.0f) {
            float f3 = 1.0f / f2;
            int n6 = n2;
            while (n6 < n4 + n2) {
                int n7 = n6++;
                fArray[n7] = fArray[n7] * f3;
            }
        }
        return fArray;
    }
}

