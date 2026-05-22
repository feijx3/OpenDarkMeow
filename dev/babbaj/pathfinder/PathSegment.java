/*
 * Decompiled with CFR 0.152.
 */
package dev.babbaj.pathfinder;

public class PathSegment {
    public final boolean finished;
    public final long[] packed;

    public PathSegment(boolean bl2, long[] lArray) {
        this.finished = bl2;
        this.packed = lArray;
    }
}

