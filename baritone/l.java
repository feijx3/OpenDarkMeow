/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  aox
 *  awt
 *  com.google.common.collect.ImmutableSet
 *  et
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 */
package baritone;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class l {
    public static final ImmutableSet<aow> a = ImmutableSet.of((Object)aox.ah, (Object)aox.cA, (Object)aox.S, (Object)aox.R, (Object)aox.bP, (Object)aox.bT, (Object[])new aow[]{aox.bQ, aox.al, aox.ae, aox.cg, aox.bF, aox.bG, aox.ac, aox.cv, aox.dk, aox.dl, aox.dm, aox.dn, aox.do, aox.dp, aox.dq, aox.dr, aox.ds, aox.dt, aox.du, aox.dv, aox.dw, aox.dx, aox.dy, aox.dz, aox.dA, aox.aY, aox.cp, aox.bY, aox.bD, aox.ce, aox.bC, aox.cf, aox.am, aox.C, aox.bI, aox.aN, aox.db, aox.G, aox.bB, aox.au, aox.bn});
    public final int a;
    public final int b;
    final BitSet a;
    final Int2ObjectOpenHashMap<String> a;
    final awt[] a;
    final int[] a;
    final Map<String, List<et>> a;
    public final long a;

    l(int n2, int n3, BitSet bitSet, awt[] awtArray, Map<String, List<et>> map, long l2) {
        if (bitSet.size() > 131072) {
            throw new IllegalArgumentException("BitSet of invalid length provided");
        }
        this.a = n2;
        this.b = n3;
        this.a = bitSet;
        this.a = awtArray;
        this.a = new int[256];
        this.a = map;
        this.a = l2;
        if (map.isEmpty()) {
            this.a = null;
        } else {
            this.a = new Int2ObjectOpenHashMap();
            this.a();
        }
        this.b();
    }

    private final void a() {
        for (Map.Entry entry : this.a.entrySet()) {
            for (et et2 : (List)entry.getValue()) {
                this.a.put(l.a(et2.p(), et2.q(), et2.r()), entry.getKey());
            }
        }
    }

    private void b() {
        for (int i2 = 0; i2 < 16; ++i2) {
            block1: for (int i3 = 0; i3 < 16; ++i3) {
                int n2 = i2 << 4 | i3;
                this.a[n2] = 0;
                for (int i4 = 256; i4 >= 0; --i4) {
                    int n3 = l.a(i3, i4, i2);
                    if (!this.a.get(n3) && !this.a.get(n3 + 1)) continue;
                    this.a[n2] = i4;
                    continue block1;
                }
            }
        }
    }

    public final ArrayList<et> a(String object) {
        if (this.a.get(object) == null) {
            return null;
        }
        ArrayList<et> arrayList = new ArrayList<et>();
        for (et et2 : (List)this.a.get(object)) {
            arrayList.add(new et(et2.p() + (this.a << 4), et2.q(), et2.r() + (this.b << 4)));
        }
        return arrayList;
    }

    public static int a(int n2, int n3, int n4) {
        return n2 << 1 | n4 << 5 | n3 << 9;
    }
}

