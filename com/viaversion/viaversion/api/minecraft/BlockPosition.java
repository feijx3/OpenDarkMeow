/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;

public class BlockPosition {
    protected final int x;
    protected final int y;
    protected final int z;

    public BlockPosition(int x2, int y2, int z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    public BlockPosition getRelative(BlockFace face) {
        return new BlockPosition(this.x + face.modX(), this.y + face.modY(), this.z + face.modZ());
    }

    public double distanceFromCenterSquared(double x2, double y2, double z2) {
        double dx2 = (double)this.x + 0.5 - x2;
        double dy2 = (double)this.y + 0.5 - y2;
        double dz2 = (double)this.z + 0.5 - z2;
        return dx2 * dx2 + dy2 * dy2 + dz2 * dz2;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public int z() {
        return this.z;
    }

    public GlobalBlockPosition withDimension(String dimension) {
        return new GlobalBlockPosition(dimension, this.x, this.y, this.z);
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        BlockPosition position = (BlockPosition)o2;
        if (this.x != position.x) {
            return false;
        }
        if (this.y != position.y) {
            return false;
        }
        return this.z == position.z;
    }

    public int hashCode() {
        int result = this.x;
        result = 31 * result + this.y;
        result = 31 * result + this.z;
        return result;
    }

    public String toString() {
        return BlockPosition.jvmdowngrader$concat$toString$1(this.x, this.y, this.z);
    }

    private static String jvmdowngrader$concat$toString$1(int n2, int n3, int n4) {
        return "BlockPosition{x=" + n2 + ", y=" + n3 + ", z=" + n4 + "}";
    }
}

