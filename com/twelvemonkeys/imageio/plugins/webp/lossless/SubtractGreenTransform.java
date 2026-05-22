/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.lossless.Transform;
import java.awt.image.WritableRaster;

final class SubtractGreenTransform
implements Transform {
    SubtractGreenTransform() {
    }

    private static void addGreenToBlueAndRed(byte[] byArray) {
        byArray[0] = (byte)(byArray[0] + byArray[1] & 0xFF);
        byArray[2] = (byte)(byArray[2] + byArray[1] & 0xFF);
    }

    @Override
    public void applyInverse(WritableRaster writableRaster) {
        int n2 = writableRaster.getWidth();
        int n3 = writableRaster.getHeight();
        byte[] byArray = new byte[4];
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                writableRaster.getDataElements(i3, i2, byArray);
                SubtractGreenTransform.addGreenToBlueAndRed(byArray);
                writableRaster.setDataElements(i3, i2, byArray);
            }
        }
    }
}

