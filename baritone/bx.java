/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  fq
 */
package baritone;

import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.movement.IMovement;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.bz;
import baritone.ca;
import baritone.cd;
import baritone.dj;
import baritone.fx;
import baritone.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class bx
extends fx {
    private final BetterBlockPos a;
    private final BetterBlockPos b;
    private final List<BetterBlockPos> a;
    private final List<ca> b;
    private final List<o> c;
    private final Goal a;
    private final int a;
    private final bz a;
    private volatile boolean a;

    bx(o o2, o object, int n2, Goal goal, bz bz2) {
        this.a = new BetterBlockPos(o2.a, o2.b, o2.c);
        this.b = new BetterBlockPos(((o)object).a, ((o)object).b, ((o)object).c);
        this.a = n2;
        this.b = new ArrayList();
        this.a = goal;
        this.a = bz2;
        o2 = object;
        object = new LinkedList();
        LinkedList<o> linkedList = new LinkedList<o>();
        while (o2 != null) {
            linkedList.addFirst(o2);
            ((LinkedList)object).addFirst(new BetterBlockPos(o2.a, o2.b, o2.c));
            o2 = o2.a;
        }
        this.a = new ArrayList(object);
        this.c = new ArrayList<o>(linkedList);
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    private boolean a() {
        if (this.a.isEmpty() || !this.b.isEmpty()) {
            throw new IllegalStateException();
        }
        for (int i2 = 0; i2 < this.a.size() - 1; ++i2) {
            double d2 = this.c.get((int)(i2 + 1)).b - this.c.get((int)i2).b;
            bx bx2 = this;
            ca ca2 = bx2.a((BetterBlockPos)((Object)bx2.a.get(i2)), (BetterBlockPos)((Object)this.a.get(i2 + 1)), d2);
            if (ca2 == null) {
                return true;
            }
            this.b.add(ca2);
        }
        return false;
    }

    private ca a(BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2, double d2) {
        cd[] cdArray = cd.values();
        int n2 = cdArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            ca ca2 = cdArray[i2].a(this.a, betterBlockPos);
            if (!ca2.getDest().equals((Object)betterBlockPos2)) continue;
            ca2.a = Math.min(ca2.a(this.a), d2);
            return ca2;
        }
        Helper.HELPER.logDebug("Movement became impossible during calculation " + (Object)((Object)betterBlockPos) + " " + (Object)((Object)betterBlockPos2) + " " + betterBlockPos2.b((fq)betterBlockPos));
        return null;
    }

    @Override
    public final IPath postProcess() {
        if (this.a) {
            throw new IllegalStateException();
        }
        this.a = true;
        boolean bl2 = this.a();
        this.b.forEach(ca2 -> ca2.a(this.a));
        if (bl2) {
            bx bx2 = this;
            dj dj2 = new dj(bx2, bx2.movements().size());
            if (dj2.movements().size() != this.b.size()) {
                throw new IllegalStateException();
            }
            return dj2;
        }
        this.sanityCheck();
        return this;
    }

    @Override
    public final List<IMovement> movements() {
        if (!this.a) {
            throw new IllegalStateException();
        }
        return Collections.unmodifiableList(this.b);
    }

    @Override
    public final List<BetterBlockPos> positions() {
        return Collections.unmodifiableList(this.a);
    }

    @Override
    public final int getNumNodesConsidered() {
        return this.a;
    }

    @Override
    public final BetterBlockPos getSrc() {
        return this.a;
    }

    @Override
    public final BetterBlockPos getDest() {
        return this.b;
    }
}

