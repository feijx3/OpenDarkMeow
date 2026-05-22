/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp;

import com.twelvemonkeys.imageio.plugins.webp.WebPImageReader;

abstract class RIFFChunk {
    final int fourCC;
    final long length;
    final long offset;

    RIFFChunk(int n2, long l2, long l3) {
        this.fourCC = n2;
        this.length = l2;
        this.offset = l3;
    }

    public String toString() {
        return WebPImageReader.fourCC(this.fourCC).replace(' ', '_') + "Chunk@" + this.offset + "|" + this.length;
    }
}

