/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.util;

import com.twelvemonkeys.lang.Validate;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import javax.imageio.ImageTypeSpecifier;

final class IndexedImageTypeSpecifier
extends ImageTypeSpecifier {
    IndexedImageTypeSpecifier(ColorModel colorModel) {
        super(Validate.notNull(colorModel, "colorModel"), colorModel.createCompatibleSampleModel(1, 1));
    }

    @Override
    public BufferedImage createBufferedImage(int n2, int n3) {
        try {
            WritableRaster writableRaster = this.colorModel.createCompatibleWritableRaster(n2, n3);
            return new BufferedImage(this.colorModel, writableRaster, this.colorModel.isAlphaPremultiplied(), null);
        }
        catch (NegativeArraySizeException negativeArraySizeException) {
            throw new IllegalArgumentException("Array size > Integer.MAX_VALUE!");
        }
    }
}

