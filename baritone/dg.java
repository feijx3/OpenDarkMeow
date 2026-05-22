/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aom
 *  aow
 *  aox
 *  aqm
 *  aqp
 *  arf
 *  arf$a
 *  arq
 *  aru
 *  awt
 *  axj
 *  bhe
 *  com.google.common.collect.ImmutableSet
 *  et
 *  fa
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.ca;
import baritone.cb;
import baritone.cc;
import baritone.ex;
import com.google.common.collect.ImmutableSet;
import java.util.Objects;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dg
extends ca {
    public dg(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2, new BetterBlockPos[]{betterBlockPos.up(2)}, betterBlockPos);
    }

    @Override
    public final double a(bz bz2) {
        return dg.a(bz2, this.a.a, this.a.b, this.a.c);
    }

    @Override
    public final Set<BetterBlockPos> a() {
        return ImmutableSet.of((Object)((Object)this.a), (Object)((Object)this.b));
    }

    public static double a(bz bz2, int n2, int n3, int n4) {
        double d2;
        awt awt2 = bz2.a(n2, n3, n4);
        aow aow2 = awt2.u();
        boolean bl2 = aow2 == aox.au || aow2 == aox.bn;
        awt awt3 = bz2.a(n2, n3 - 1, n4);
        if (!bl2) {
            if (awt3.u() == aox.au || awt3.u() == aox.bn) {
                return 1000000.0;
            }
            if (awt3.u() instanceof arf && !((arf)awt3.u()).e() && awt3.c((axj)arf.a) == arf.a.b) {
                return 1000000.0;
            }
        }
        if (aow2 == aox.bn && !dg.d(bz2, n2, n3, n4)) {
            return 1000000.0;
        }
        awt awt4 = bz2.a(n2, n3 + 2, n4);
        aow aow3 = awt4.u();
        if (aow3 instanceof aqp) {
            return 1000000.0;
        }
        aow aow4 = null;
        if (cb.b(aow3) && cb.b(aow2) && cb.b(aow4 = bz2.a(n2, n3 + 1, n4).u())) {
            return 8.51063829787234;
        }
        double d3 = 0.0;
        if (!bl2) {
            double d4;
            d3 = bz2.a(n2, n3, n4, awt2);
            if (d4 >= 1000000.0) {
                return 1000000.0;
            }
            if (awt3.u() == aox.a) {
                d3 += 0.1;
            }
        }
        if (aow2 instanceof aru || awt3.u() instanceof aru && bz2.j) {
            return 1000000.0;
        }
        if ((aow2 == aox.bx || aow2 == aox.cy) && awt3.u() instanceof aru) {
            return 1000000.0;
        }
        double d5 = cb.a(bz2, n2, n3 + 2, n4, awt4, true);
        if (d2 >= 1000000.0) {
            return 1000000.0;
        }
        if (d5 != 0.0) {
            if (aow3 == aox.au || aow3 == aox.bn) {
                d5 = 0.0;
            } else if (bz2.a(n2, n3 + 3, n4).u() instanceof aqm) {
                if (aow4 == null) {
                    aow4 = bz2.a(n2, n3 + 1, n4).u();
                }
                if (!(aow3 instanceof aqm) || !(aow4 instanceof aqm)) {
                    return 1000000.0;
                }
            }
        }
        if (bl2) {
            return 8.51063829787234 + d5 * 5.0;
        }
        return JUMP_ONE_BLOCK_COST + d3 + bz2.e + d5;
    }

    private static boolean d(bz bz2, int n2, int n3, int n4) {
        return bz2.a(n2 + 1, n3, n4).k() || bz2.a(n2 - 1, n3, n4).k() || bz2.a(n2, n3, n4 + 1).k() || bz2.a(n2, n3, n4 - 1).k();
    }

    public static et a(bz bz2, BetterBlockPos betterBlockPos) {
        if (bz2.a(betterBlockPos.north()).k()) {
            return betterBlockPos.north();
        }
        if (bz2.a(betterBlockPos.south()).k()) {
            return betterBlockPos.south();
        }
        if (bz2.a(betterBlockPos.east()).k()) {
            return betterBlockPos.east();
        }
        if (bz2.a(betterBlockPos.west()).k()) {
            return betterBlockPos.west();
        }
        return null;
    }

    @Override
    public final cc a(cc object) {
        boolean bl2;
        super.a((cc)object);
        if (((cc)object).a != MovementStatus.RUNNING) {
            return object;
        }
        if (this.a.playerFeet().b < this.a.b) {
            cc cc2 = object;
            object = MovementStatus.UNREACHABLE;
            cc cc3 = cc2;
            cc2.a = object;
            return cc3;
        }
        Object object2 = ex.a(this.a, this.a);
        if (cb.b(object2.u()) && cb.e(this.a, this.b)) {
            ((cc)object).a(new cc.a(RotationUtils.calcRotationFromVec3d(this.a.playerHead(), VecUtils.getBlockPosCenter(this.b), this.a.playerRotations()), false));
            bhe bhe2 = VecUtils.getBlockPosCenter(this.b);
            if (Math.abs(this.a.player().p - bhe2.b) > 0.2 || Math.abs(this.a.player().r - bhe2.d) > 0.2) {
                ((cc)object).a(Input.MOVE_FORWARD, true);
            }
            if (this.a.playerFeet().equals((Object)this.b)) {
                Object object3 = object;
                object = MovementStatus.SUCCESS;
                object2 = object3;
                ((cc)object3).a = object;
                return object2;
            }
            return object;
        }
        boolean bl3 = object2.u() == aox.au || object2.u() == aox.bn;
        boolean bl4 = object2.u() == aox.bn;
        Rotation rotation2 = RotationUtils.calcRotationFromVec3d(this.a.playerHead(), VecUtils.getBlockPosCenter(this.c), this.a.playerRotations());
        if (!bl3) {
            ((cc)object).a(new cc.a(this.a.playerRotations().withPitch(rotation2.getPitch()), true));
        }
        boolean bl5 = bl2 = cb.b(this.a, this.a) || bl3;
        if (bl3) {
            Object object4 = bl4 ? dg.a(new bz(this.a), this.a) : this.a.offset(((fa)object2.c((axj)arq.a)).d());
            if (object4 == null) {
                this.logDirect("Unable to climb vines. Consider disabling allowVines.");
                Object object5 = object;
                object = MovementStatus.UNREACHABLE;
                object2 = object5;
                ((cc)object5).a = object;
                return object2;
            }
            if (this.a.playerFeet().equals(object4.a()) || this.a.playerFeet().equals((Object)this.b)) {
                Object object6 = object;
                object = MovementStatus.SUCCESS;
                object2 = object6;
                object6.a = object;
                return object2;
            }
            if (cb.a(ex.a(this.a, this.a.down()))) {
                ((cc)object).a(Input.JUMP, true);
            }
            cb.a(this.a, (cc)object, object4);
            return object;
        }
        if (!((a)this.a).a.a(true, this.a.a, this.a.b, this.a.c)) {
            Object object7 = object;
            object = MovementStatus.UNREACHABLE;
            object2 = object7;
            ((cc)object7).a = object;
            return object2;
        }
        ((cc)object).a(Input.SNEAK, this.a.player().q > (double)this.b.q() || this.a.player().q < (double)this.a.q() + 0.2);
        double d2 = this.a.player().p - ((double)this.b.p() + 0.5);
        double d3 = this.a.player().r - ((double)this.b.r() + 0.5);
        double d4 = d2;
        double d5 = d3;
        double d6 = Math.sqrt(d4 * d4 + d5 * d5);
        double d7 = Math.sqrt(this.a.player().s * this.a.player().s + this.a.player().u * this.a.player().u);
        if (d6 > 0.17) {
            ((cc)object).a(Input.MOVE_FORWARD, true);
            ((cc)object).a(new cc.a(rotation2, true));
        } else if (d7 < 0.05) {
            ((cc)object).a(Input.JUMP, this.a.player().q < (double)this.b.q());
        }
        if (!bl2) {
            object2 = ex.a(this.a, this.a);
            if (!(object2.u() instanceof aom) && !object2.a().j()) {
                RotationUtils.reachable(this.a, (et)this.a, this.a.playerController().getBlockReachDistance()).map(rotation -> new cc.a((Rotation)rotation, true)).ifPresent(((cc)object)::a);
                ((cc)object).a(Input.JUMP, false);
                ((cc)object).a(Input.CLICK_LEFT, true);
                bl2 = false;
            } else if (this.a.player().aU() && (Objects.equals((Object)this.a.down(), this.a.objectMouseOver().a()) || Objects.equals((Object)this.a, this.a.objectMouseOver().a())) && this.a.player().q > (double)this.b.q() + 0.1) {
                ((cc)object).a(Input.CLICK_RIGHT, true);
            }
        }
        if (this.a.playerFeet().equals((Object)this.b) && bl2) {
            Object object8 = object;
            object = MovementStatus.SUCCESS;
            object2 = object8;
            ((cc)object8).a = object;
            return object2;
        }
        return object;
    }

    @Override
    public final boolean a(cc cc2) {
        aow aow2;
        if ((this.a.playerFeet().equals((Object)this.a) || this.a.playerFeet().equals((Object)this.a.down())) && ((aow2 = ex.a(this.a, this.a.down())) == aox.au || aow2 == aox.bn)) {
            cc2.a(Input.SNEAK, true);
        }
        if (cb.e(this.a, this.b.up())) {
            return true;
        }
        return super.a(cc2);
    }
}

