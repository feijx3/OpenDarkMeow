/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.color;

import java.awt.color.ColorSpace;

final class CMYKColorSpace
extends ColorSpace {
    static final ColorSpace INSTANCE = new CMYKColorSpace();
    final ColorSpace sRGB = CMYKColorSpace.getInstance(1000);

    private CMYKColorSpace() {
        super(9, 4);
    }

    public static ColorSpace getInstance() {
        return INSTANCE;
    }

    @Override
    public float[] toRGB(float[] fArray) {
        return new float[]{(1.0f - fArray[0]) * (1.0f - fArray[3]), (1.0f - fArray[1]) * (1.0f - fArray[3]), (1.0f - fArray[2]) * (1.0f - fArray[3])};
    }

    @Override
    public float[] fromRGB(float[] fArray) {
        float f2 = 1.0f - fArray[0];
        float f3 = 1.0f - fArray[1];
        float f4 = 1.0f - fArray[2];
        float f5 = Math.min(f2, Math.min(f3, f4));
        return new float[]{f2 - f5, f3 - f5, f4 - f5, f5};
    }

    @Override
    public float[] toCIEXYZ(float[] fArray) {
        return this.sRGB.toCIEXYZ(this.toRGB(fArray));
    }

    @Override
    public float[] fromCIEXYZ(float[] fArray) {
        return this.sRGB.fromCIEXYZ(this.fromRGB(fArray));
    }
}

