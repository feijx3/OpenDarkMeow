/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.data.entity;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viaversion.api.data.entity.DimensionData;

public final class DimensionDataImpl
implements DimensionData {
    private final int id;
    private final int minY;
    private final int height;

    public DimensionDataImpl(int id, int minY, int height) {
        this.id = id;
        this.minY = minY;
        this.height = height;
    }

    public DimensionDataImpl(int id, CompoundTag dimensionData) {
        this.id = id;
        NumberTag height = dimensionData.getNumberTag("height");
        if (height == null) {
            throw new IllegalArgumentException(DimensionDataImpl.jvmdowngrader$concat$$init$$1(String.valueOf(dimensionData)));
        }
        this.height = height.asInt();
        NumberTag minY = dimensionData.getNumberTag("min_y");
        if (minY == null) {
            throw new IllegalArgumentException(DimensionDataImpl.jvmdowngrader$concat$$init$$2(String.valueOf(dimensionData)));
        }
        this.minY = minY.asInt();
    }

    public static DimensionData withDefaultsFor(String key, int id) {
        DimensionDataImpl dimensionDataImpl;
        switch (key) {
            case "overworld": 
            case "overworld_caves": {
                dimensionDataImpl = new DimensionDataImpl(id, -64, 384);
                break;
            }
            case "the_nether": 
            case "the_end": {
                dimensionDataImpl = new DimensionDataImpl(id, 0, 256);
                break;
            }
            default: {
                throw new IllegalArgumentException(DimensionDataImpl.jvmdowngrader$concat$withDefaultsFor$1(key));
            }
        }
        return dimensionDataImpl;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public int minY() {
        return this.minY;
    }

    @Override
    public int height() {
        return this.height;
    }

    public String toString() {
        return DimensionDataImpl.jvmdowngrader$concat$toString$1(this.id, this.minY, this.height);
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "height missing in dimension data: " + string;
    }

    private static String jvmdowngrader$concat$$init$$2(String string) {
        return "min_y missing in dimension data: " + string;
    }

    private static String jvmdowngrader$concat$withDefaultsFor$1(String string) {
        return "Missing registry data for unknown dimension: " + string;
    }

    private static String jvmdowngrader$concat$toString$1(int n2, int n3, int n4) {
        return "DimensionDataImpl{id=" + n2 + ", minY=" + n3 + ", height=" + n4 + "}";
    }
}

