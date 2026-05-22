/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.lossless.HuffmanCodeGroup;
import java.awt.image.Raster;

final class HuffmanInfo {
    public final Raster huffmanMetaCodes;
    public final int metaCodeBits;
    public final HuffmanCodeGroup[] huffmanGroups;

    public HuffmanInfo(Raster raster, int n2, HuffmanCodeGroup[] huffmanCodeGroupArray) {
        this.huffmanMetaCodes = raster;
        this.metaCodeBits = n2;
        this.huffmanGroups = huffmanCodeGroupArray;
    }
}

