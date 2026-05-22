/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.LSBBitReader;
import com.twelvemonkeys.imageio.plugins.webp.lossless.HuffmanTable;
import java.io.IOException;

final class HuffmanCodeGroup {
    public final HuffmanTable mainCode;
    public final HuffmanTable redCode;
    public final HuffmanTable blueCode;
    public final HuffmanTable alphaCode;
    public final HuffmanTable distanceCode;

    public HuffmanCodeGroup(LSBBitReader lSBBitReader, int n2) throws IOException {
        this.mainCode = new HuffmanTable(lSBBitReader, 280 + (n2 > 0 ? 1 << n2 : 0));
        this.redCode = new HuffmanTable(lSBBitReader, 256);
        this.blueCode = new HuffmanTable(lSBBitReader, 256);
        this.alphaCode = new HuffmanTable(lSBBitReader, 256);
        this.distanceCode = new HuffmanTable(lSBBitReader, 40);
    }
}

