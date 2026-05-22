/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aed
 *  afw
 *  ahb
 *  ain
 *  aip
 *  ajb
 *  aow
 *  aox
 *  awt
 *  bud
 *  et
 *  fa
 *  fi
 *  vp
 */
package baritone;

import baritone.a;
import baritone.api.event.events.TickEvent;
import baritone.api.utils.Helper;
import baritone.c;
import baritone.dq;
import baritone.fi;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Predicate;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class d
extends c
implements Helper {
    private int a;
    private int[] a;

    public d(a a2) {
        super(a2);
    }

    @Override
    public final void onTick(TickEvent tickEvent) {
        if (!((Boolean)baritone.a.a().allowInventory.value).booleanValue()) {
            return;
        }
        if (tickEvent.getType() == TickEvent.Type.OUT) {
            return;
        }
        if (this.a.player().by != this.a.player().bx) {
            return;
        }
        ++this.a;
        if (this.a() >= 9) {
            d d2 = this;
            d2.a(d2.a(), 8);
        }
        Class<ajb> clazz = ajb.class;
        aow aow2 = aox.b;
        tickEvent = this.a.player().bv.a;
        int n2 = -1;
        double d3 = -1.0;
        for (int i2 = 0; i2 < tickEvent.size(); ++i2) {
            double d4;
            aip aip2 = (aip)tickEvent.get(i2);
            if (aip2.b() || ((Boolean)baritone.a.a().itemSaver.value).booleanValue() && aip2.i() + (Integer)baritone.a.a().itemSaverThreshold.value >= aip2.k() && aip2.k() > 1 || !clazz.isInstance(aip2.c())) continue;
            double d5 = fi.a(aip2, aow2.t());
            if (!(d4 > d3)) continue;
            d3 = d5;
            n2 = i2;
        }
        int n3 = n2;
        if (n3 >= 9) {
            this.a(n3, 0);
        }
        if (this.a != null) {
            this.logDebug("Remembering to move " + this.a[0] + " " + this.a[1] + " from a previous tick");
            d d6 = this;
            d6.a(d6.a[0], this.a[1]);
        }
    }

    public final boolean a(int n2, Predicate<Integer> object) {
        int n3;
        Predicate<Integer> predicate = object;
        object = this;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n3 = 1; n3 < 8; ++n3) {
            if (!((aip)((d)object).a.player().bv.a.get(n3)).b() || predicate.test(n3)) continue;
            arrayList.add(n3);
        }
        if (arrayList.isEmpty()) {
            for (n3 = 1; n3 < 8; ++n3) {
                if (predicate.test(n3)) continue;
                arrayList.add(n3);
            }
        }
        return !((OptionalInt)(object = arrayList.isEmpty() ? OptionalInt.empty() : OptionalInt.of((Integer)arrayList.get(new Random().nextInt(arrayList.size()))))).isPresent() || this.a(n2, ((OptionalInt)object).getAsInt());
    }

    private boolean a(int n2, int n3) {
        this.a = new int[]{n2, n3};
        if (this.a < (Integer)baritone.a.a().ticksBetweenInventoryMoves.value) {
            this.logDebug("Inventory move requested but delaying " + this.a + " " + baritone.a.a().ticksBetweenInventoryMoves.value);
            return false;
        }
        if (((Boolean)baritone.a.a().inventoryMoveOnlyIfStationary.value).booleanValue() && !this.a.a.a()) {
            this.logDebug("Inventory move requested but delaying until stationary");
            return false;
        }
        this.a.playerController().windowClick(this.a.player().bx.d, n2 < 9 ? n2 + 36 : n2, n3, afw.c, (aed)this.a.player());
        this.a = 0;
        this.a = null;
        return true;
    }

    private int a() {
        fi fi2 = this.a.player().bv.a;
        for (int i2 = 0; i2 < fi2.size(); ++i2) {
            if (!((List)baritone.a.a().acceptableThrowawayItems.value).contains(((aip)fi2.get(i2)).c())) continue;
            return i2;
        }
        return -1;
    }

    public final boolean a() {
        for (ain ain2 : (List)baritone.a.a().acceptableThrowawayItems.value) {
            if (!this.a(false, (? super aip aip2) -> ain2.equals(aip2.c()))) continue;
            return true;
        }
        return false;
    }

    public final boolean a(boolean bl2, int n2, int n3, int n4) {
        awt awt2 = this.a.a.a(n2, n3, n4);
        int n5 = n4;
        n4 = n3;
        n3 = n2;
        Object object = this.a.a;
        if ((!((dq)object).isActive() ? null : (!((dq)object).a.inSchematic(n3 - ((dq)object).a.p(), n4 - ((dq)object).a.q(), n5 - ((dq)object).a.r(), awt2) ? null : (object = (object = ((dq)object).a.desiredState(n3 - ((dq)object).a.p(), n4 - ((dq)object).a.q(), n5 - ((dq)object).a.r(), awt2, (List<awt>)((Object)((dq)object).a))).u() == aox.a ? null : object))) != null && this.a(bl2, arg_0 -> this.b((awt)object, arg_0))) {
            return true;
        }
        if (object != null && this.a(bl2, arg_0 -> d.a((awt)object, arg_0))) {
            return true;
        }
        for (ain ain2 : (List)baritone.a.a().acceptableThrowawayItems.value) {
            if (!this.a(bl2, (? super aip aip2) -> ain2.equals(aip2.c()))) continue;
            return true;
        }
        return false;
    }

    public final boolean a(boolean bl2, Predicate<? super aip> predicate) {
        return this.a(bl2, predicate, (Boolean)baritone.a.a().allowInventory.value);
    }

    private boolean a(boolean bl2, Predicate<? super aip> predicate, boolean bl3) {
        aip aip2;
        int n2;
        bud bud2 = this.a.player();
        fi fi2 = bud2.bv.a;
        for (n2 = 0; n2 < 9; ++n2) {
            aip2 = (aip)fi2.get(n2);
            if (!predicate.test((aip)aip2)) continue;
            if (bl2) {
                bud2.bv.d = n2;
            }
            return true;
        }
        if (predicate.test((aip)bud2.bv.c.get(0))) {
            for (n2 = 0; n2 < 9; ++n2) {
                aip2 = (aip)fi2.get(n2);
                if (!aip2.b() && !(aip2.c() instanceof ajb)) continue;
                if (bl2) {
                    bud2.bv.d = n2;
                }
                return true;
            }
        }
        if (bl3) {
            for (n2 = 9; n2 < 36; ++n2) {
                if (!predicate.test((aip)fi2.get(n2))) continue;
                if (bl2) {
                    this.a(n2, 7);
                    bud2.bv.d = 7;
                }
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ boolean a(awt awt2, aip aip2) {
        return aip2.c() instanceof ahb && ((ahb)aip2.c()).d().equals(awt2.u());
    }

    private /* synthetic */ boolean b(awt awt2, aip aip2) {
        return aip2.c() instanceof ahb && awt2.equals(((ahb)aip2.c()).d().a(this.a.world(), (et)this.a.playerFeet(), fa.b, (float)this.a.player().p, (float)this.a.player().q, (float)this.a.player().r, aip2.c().a(aip2.j()), (vp)this.a.player()));
    }
}

