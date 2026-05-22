/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import java.awt.image.ReplicateScaleFilter;

public class SubsamplingFilter
extends ReplicateScaleFilter {
    private int xSub;
    private int ySub;

    public SubsamplingFilter(int n2, int n3) {
        super(1, 1);
        if (n2 < 1 || n3 < 1) {
            throw new IllegalArgumentException("Subsampling factors must be positive.");
        }
        this.xSub = n2;
        this.ySub = n3;
    }

    @Override
    public void setDimensions(int n2, int n3) {
        this.destWidth = (n2 + this.xSub - 1) / this.xSub;
        this.destHeight = (n3 + this.ySub - 1) / this.ySub;
        super.setDimensions(n2, n3);
    }
}

