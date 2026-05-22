/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.lossless.Transform;
import java.awt.image.WritableRaster;

final class ColorIndexingTransform
implements Transform {
    private final byte[] colorTable;
    private final byte bits;

    public ColorIndexingTransform(byte[] byArray, byte by2) {
        this.colorTable = byArray;
        this.bits = by2;
    }

    @Override
    public void applyInverse(WritableRaster writableRaster) {
        int n2 = writableRaster.getWidth();
        int n3 = writableRaster.getHeight();
        byte[] byArray = new byte[4];
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = n2 - 1; i3 >= 0; --i3) {
                int n4 = 8 >> this.bits;
                int n5 = 1 << this.bits;
                int n6 = i3 / n5;
                int n7 = n4 * (i3 % n5);
                int n8 = writableRaster.getSample(n6, i2, 1);
                int n9 = n8 >> n7 & (1 << n4) - 1;
                System.arraycopy(this.colorTable, n9 * 4, byArray, 0, 4);
                writableRaster.setDataElements(i3, i2, byArray);
            }
        }
    }
}

