/*
 * Decompiled with CFR 0.152.
 */
package dev.babbaj.pathfinder.xz;

import dev.babbaj.pathfinder.xz.an;
import dev.babbaj.pathfinder.xz.ar;
import java.util.Arrays;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class ao {
    public final short[] a = new short[768];
    private /* synthetic */ an a;

    ao(ar ar2) {
        this.a = ar2;
    }

    final void a() {
        Arrays.fill(this.a, (short)1024);
    }
}

