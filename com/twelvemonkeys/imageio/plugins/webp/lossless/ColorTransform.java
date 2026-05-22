/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.lossless.Transform;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

final class ColorTransform
implements Transform {
    private final Raster data;
    private final byte bits;

    public ColorTransform(Raster raster, byte by2) {
        this.data = raster;
        this.bits = by2;
    }

    @Override
    public void applyInverse(WritableRaster writableRaster) {
        int n2 = writableRaster.getWidth();
        int n3 = writableRaster.getHeight();
        byte[] byArray = new byte[4];
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                this.data.getDataElements(i3 >> this.bits, i2 >> this.bits, byArray);
                ColorTransformElement colorTransformElement = new ColorTransformElement(byArray);
                writableRaster.getDataElements(i3, i2, byArray);
                colorTransformElement.inverseTransform(byArray);
                writableRaster.setDataElements(i3, i2, byArray);
            }
        }
    }

    private static void colorTransform(int n2, int n3, int n4, ColorTransformElement colorTransformElement, int[] nArray) {
        int n5 = n2;
        int n6 = n3;
        n6 += ColorTransform.colorTransformDelta((byte)colorTransformElement.green_to_blue, (byte)n4);
        nArray[0] = (n5 += ColorTransform.colorTransformDelta((byte)colorTransformElement.green_to_red, (byte)n4)) & 0xFF;
        nArray[1] = (n6 += ColorTransform.colorTransformDelta((byte)colorTransformElement.red_to_blue, (byte)n2)) & 0xFF;
    }

    private static byte colorTransformDelta(byte by2, byte by3) {
        return (byte)(by2 * by3 >> 5);
    }

    private static final class ColorTransformElement {
        final int green_to_red;
        final int green_to_blue;
        final int red_to_blue;

        ColorTransformElement(byte[] byArray) {
            this.green_to_red = byArray[2];
            this.green_to_blue = byArray[1];
            this.red_to_blue = byArray[0];
        }

        private void inverseTransform(byte[] byArray) {
            int n2 = byArray[0];
            int n3 = byArray[2];
            n3 += ColorTransform.colorTransformDelta((byte)this.green_to_blue, byArray[1]);
            byArray[0] = (byte)(n2 & 0xFF);
            byArray[2] = (byte)((n3 += ColorTransform.colorTransformDelta((byte)this.red_to_blue, (byte)(n2 += ColorTransform.colorTransformDelta((byte)this.green_to_red, byArray[1])))) & 0xFF);
        }
    }
}

