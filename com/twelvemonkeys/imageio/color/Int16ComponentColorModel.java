/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.color;

import java.awt.color.ColorSpace;
import java.awt.image.ComponentColorModel;

public final class Int16ComponentColorModel
extends ComponentColorModel {
    private final ComponentColorModel delegate;

    public Int16ComponentColorModel(ColorSpace colorSpace, boolean bl2, boolean bl3) {
        super(colorSpace, bl2, bl3, bl2 ? 3 : 1, 2);
        this.delegate = new ComponentColorModel(colorSpace, bl2, bl3, bl2 ? 3 : 1, 1);
    }

    private void remap(short[] sArray, int n2) {
        short s2 = sArray[n2];
        sArray[n2] = s2 < 0 ? (short)(s2 - Short.MIN_VALUE) : (short)(s2 + Short.MIN_VALUE);
    }

    @Override
    public int getRed(Object object) {
        this.remap((short[])object, 0);
        return this.delegate.getRed(object);
    }

    @Override
    public int getGreen(Object object) {
        this.remap((short[])object, 1);
        return this.delegate.getGreen(object);
    }

    @Override
    public int getBlue(Object object) {
        this.remap((short[])object, 2);
        return this.delegate.getBlue(object);
    }
}

