/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhe
 */
package baritone;

import baritone.api.utils.BetterBlockPos;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class el
extends AbstractList<BetterBlockPos> {
    private static final el a = new el(Collections.emptyList());
    private final List<BetterBlockPos> a;

    el(List<BetterBlockPos> list) {
        this.a = list;
    }

    public final BetterBlockPos a(int n2) {
        return (BetterBlockPos)((Object)this.a.get(n2));
    }

    @Override
    public final int size() {
        return this.a.size();
    }

    public final BetterBlockPos a() {
        if (this.isEmpty()) {
            return null;
        }
        return (BetterBlockPos)((Object)this.a.get(this.a.size() - 1));
    }

    public final bhe a(int n2) {
        BetterBlockPos betterBlockPos = this.a(n2);
        return new bhe((double)betterBlockPos.a, (double)betterBlockPos.b, (double)betterBlockPos.c);
    }

    public static el a() {
        return a;
    }

    @Override
    public final /* synthetic */ Object get(int n2) {
        return this.a(n2);
    }
}

