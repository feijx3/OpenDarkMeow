/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.util;

import com.twelvemonkeys.imageio.color.Int16ComponentColorModel;
import java.awt.color.ColorSpace;
import java.awt.image.PixelInterleavedSampleModel;
import javax.imageio.ImageTypeSpecifier;

final class Int16ImageTypeSpecifier
extends ImageTypeSpecifier {
    Int16ImageTypeSpecifier(ColorSpace colorSpace, int[] nArray, boolean bl2, boolean bl3) {
        super(new Int16ComponentColorModel(colorSpace, bl2, bl3), new PixelInterleavedSampleModel(2, 1, 1, colorSpace.getNumComponents() + (bl2 ? 1 : 0), colorSpace.getNumComponents() + (bl2 ? 1 : 0), nArray));
    }
}

