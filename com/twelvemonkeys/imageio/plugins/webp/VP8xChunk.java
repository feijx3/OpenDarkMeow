/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp;

import com.twelvemonkeys.imageio.plugins.webp.RIFFChunk;

final class VP8xChunk
extends RIFFChunk {
    int width;
    int height;
    boolean isLossless;
    boolean containsICCP;
    boolean containsALPH;
    boolean containsEXIF;
    boolean containsXMP_;
    boolean containsANIM;

    VP8xChunk(int n2, long l2, long l3) {
        super(n2, l2, l3);
    }

    @Override
    public String toString() {
        return super.toString() + "[width=" + this.width + ", height=" + this.height + ", lossless=" + (this.isLossless ? "RGB" : "") + (this.containsALPH ? "A" : (this.isLossless ? "" : "false")) + ", flags=" + (this.containsICCP ? "I" : "") + (this.containsALPH ? "L" : "") + (this.containsEXIF ? "E" : "") + (this.containsXMP_ ? "X" : "") + (this.containsANIM ? "A" : "") + ']';
    }
}

