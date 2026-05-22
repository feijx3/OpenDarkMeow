/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap
 */
package baritone;

import baritone.api.pathing.calc.IPath;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.bz;
import baritone.ft;
import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;

public final class fv {
    public final Long2DoubleOpenHashMap a = new Long2DoubleOpenHashMap();

    public fv(IPlayerContext object, IPath object2, bz bz2) {
        this((IPath)object2, bz2);
        object = ft.a((IPlayerContext)object).iterator();
        while (object.hasNext()) {
            bz2 = this.a;
            object2 = (ft)object.next();
            for (int i2 = -((ft)object2).d; i2 <= ((ft)object2).d; ++i2) {
                for (int i3 = -((ft)object2).d; i3 <= ((ft)object2).d; ++i3) {
                    for (int i4 = -((ft)object2).d; i4 <= ((ft)object2).d; ++i4) {
                        int n2 = i2;
                        int n3 = i3;
                        int n4 = i4;
                        if (n2 * n2 + n3 * n3 + n4 * n4 > ((ft)object2).d * ((ft)object2).d) continue;
                        long l2 = BetterBlockPos.longHash(((ft)object2).a + i2, ((ft)object2).b + i3, ((ft)object2).c + i4);
                        bz2.put(l2, bz2.get(l2) * ((ft)object2).a);
                    }
                }
            }
        }
        Helper.HELPER.logDebug("Favoring size: " + this.a.size());
    }

    private fv(IPath iPath, bz bz2) {
        this.a.defaultReturnValue(1.0);
        double d2 = bz2.d;
        if (d2 != 1.0 && iPath != null) {
            iPath.positions().forEach(betterBlockPos -> this.a.put(BetterBlockPos.longHash(betterBlockPos), d2));
        }
    }
}

