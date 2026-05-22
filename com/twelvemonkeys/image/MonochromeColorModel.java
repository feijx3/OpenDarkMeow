/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import java.awt.image.IndexColorModel;

public class MonochromeColorModel
extends IndexColorModel {
    private static final int[] MONO_PALETTE = new int[]{0, 0xFFFFFF};
    private static MonochromeColorModel sInstance = new MonochromeColorModel();

    private MonochromeColorModel() {
        super(1, 2, MONO_PALETTE, 0, false, -1, 0);
    }

    public static IndexColorModel getInstance() {
        return sInstance;
    }

    @Override
    public synchronized Object getDataElements(int n2, Object object) {
        int n3 = n2 >> 16 & 0xFF;
        int n4 = n2 >> 8 & 0xFF;
        int n5 = n2 & 0xFF;
        int n6 = (222 * n3 + 707 * n4 + 71 * n5) / 1000;
        byte[] byArray = object != null ? (byte[])object : new byte[1];
        byArray[0] = n6 <= 128 ? (byte)0 : 1;
        return byArray;
    }
}

