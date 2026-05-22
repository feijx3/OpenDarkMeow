/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.lang.Validate;

final class ColorCache {
    private final int[] colors;
    private final int hashShift;
    private static final long K_HASH_MUL = 506832829L;

    private static int hashPix(int n2, int n3) {
        return (int)(((long)n2 * 506832829L & 0xFFFFFFFFL) >> n3);
    }

    ColorCache(int n2) {
        Validate.isTrue(n2 > 0, "hasBits must > 0");
        int n3 = 1 << n2;
        this.colors = new int[n3];
        this.hashShift = 32 - n2;
    }

    int lookup(int n2) {
        return this.colors[n2];
    }

    void set(int n2, int n3) {
        this.colors[n2] = n3;
    }

    void insert(int n2) {
        this.colors[this.index((int)n2)] = n2;
    }

    int index(int n2) {
        return ColorCache.hashPix(n2, this.hashShift);
    }

    int contains(int n2) {
        int n3 = this.index(n2);
        return this.colors[n3] == n2 ? n3 : -1;
    }
}

