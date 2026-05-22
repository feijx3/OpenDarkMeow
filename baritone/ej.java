/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.em;
import dev.babbaj.pathfinder.NetherPathfinder;
import dev.babbaj.pathfinder.Octree;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ej {
    private final em a;
    private final long b;
    transient long a;
    private int a = Integer.MAX_VALUE;
    private int b = Integer.MAX_VALUE;

    public ej(em em2) {
        this.a = em2;
        this.b = em2.a;
    }

    public final boolean a(int n2, int n3, int n4) {
        int n5;
        int n6;
        if ((n3 | 127 - n3) < 0) {
            return false;
        }
        if (this.a == 0L | ((n6 = n2 >> 4) ^ this.a | (n5 = n4 >> 4) ^ this.b) != 0) {
            this.a = n6;
            this.b = n5;
            this.a = NetherPathfinder.getOrCreateChunk(this.b, n6, n5);
        }
        return Octree.getBlock(this.a, n2 & 0xF, n3 & 0x7F, n4 & 0xF);
    }
}

