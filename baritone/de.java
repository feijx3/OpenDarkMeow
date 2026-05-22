/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aec
 *  aip
 *  air
 *  aow
 *  aox
 *  arq
 *  axj
 *  bhe
 *  et
 *  fa
 *  fq
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.ca;
import baritone.cb;
import baritone.cc;
import baritone.db;
import baritone.fw;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class de
extends ca {
    private static final aip a = new aip(air.aA);
    private static final aip b = new aip(air.az);

    public de(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2, de.a(betterBlockPos, betterBlockPos2));
    }

    @Override
    public final double a(bz bz2) {
        fw fw2 = new fw();
        db.a(bz2, this.a.a, this.a.b, this.a.c, this.b.a, this.b.c, fw2);
        if (fw2.b != this.b.b) {
            return 1000000.0;
        }
        return fw2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        HashSet<BetterBlockPos> hashSet = new HashSet<BetterBlockPos>();
        hashSet.add((BetterBlockPos)this.a);
        for (int i2 = this.a.b - this.b.b; i2 >= 0; --i2) {
            hashSet.add(this.b.up(i2));
        }
        return hashSet;
    }

    @Override
    public final cc a(cc object) {
        fa fa2;
        Rotation rotation;
        Rotation rotation2;
        Object object2;
        block23: {
            fw fw2;
            de de2;
            super.a((cc)object);
            if (((cc)object).a != MovementStatus.RUNNING) {
                return object;
            }
            object2 = this.a.playerFeet();
            rotation2 = RotationUtils.calcRotationFromVec3d(this.a.playerHead(), VecUtils.getBlockPosCenter((et)this.b), this.a.playerRotations());
            rotation = null;
            aow aow2 = this.a.world().o((et)this.b).u();
            boolean bl2 = aow2 == aox.j || aow2 == aox.i;
            if (!bl2) {
                de2 = this;
                bz bz2 = new bz((IBaritone)de2.a);
                fw2 = new fw();
                if (db.a(bz2, de2.a.b, de2.b.a, de2.b.c, 0.0, bz2.a(de2.b.a, de2.a.b - 2, de2.b.c), fw2) && !object2.equals(this.b)) {
                    if (!aec.e((int)this.a.player().bv.b(a)) || this.a.world().s.n()) {
                        Object object3 = object;
                        object = MovementStatus.UNREACHABLE;
                        object2 = object3;
                        ((cc)object3).a = object;
                        return object2;
                    }
                    if (this.a.player().q - (double)this.b.q() < this.a.playerController().getBlockReachDistance() && !this.a.player().z) {
                        this.a.player().bv.d = this.a.player().bv.b(a);
                        rotation = new Rotation(rotation2.getYaw(), 90.0f);
                        if (this.a.isLookingAt((et)this.b) || this.a.isLookingAt(this.b.down())) {
                            ((cc)object).a(Input.CLICK_RIGHT, true);
                        }
                    }
                }
            }
            if (rotation != null) {
                ((cc)object).a(new cc.a(rotation, true));
            } else {
                ((cc)object).a(new cc.a(rotation2, false));
            }
            if (object2.equals(this.b) && (this.a.player().q - (double)object2.q() < 0.094 || bl2)) {
                if (bl2) {
                    if (aec.e((int)this.a.player().bv.b(b))) {
                        this.a.player().bv.d = this.a.player().bv.b(b);
                        if (this.a.player().t >= 0.0) {
                            return ((cc)object).a(Input.CLICK_RIGHT, true);
                        }
                        return object;
                    }
                    if (this.a.player().t >= 0.0) {
                        Object object4 = object;
                        object = MovementStatus.SUCCESS;
                        object2 = object4;
                        ((cc)object4).a = object;
                        return object2;
                    }
                } else {
                    cc cc2 = object;
                    object = MovementStatus.SUCCESS;
                    object2 = cc2;
                    cc2.a = object;
                    return object2;
                }
            }
            object2 = VecUtils.getBlockPosCenter((et)this.b);
            if (Math.abs(this.a.player().p + this.a.player().s - ((bhe)object2).b) > 0.1 || Math.abs(this.a.player().r + this.a.player().u - ((bhe)object2).d) > 0.1) {
                if (!this.a.player().z && Math.abs(this.a.player().t) > 0.4) {
                    ((cc)object).a(Input.SNEAK, true);
                }
                ((cc)object).a(Input.MOVE_FORWARD, true);
            }
            de2 = this;
            for (int i2 = 0; i2 < 15; ++i2) {
                fw2 = de2.a.world().o((et)de2.a.playerFeet().down(i2));
                if (fw2.u() != aox.au) continue;
                fa2 = (fa)fw2.c((axj)arq.a);
                break block23;
            }
            fa2 = null;
        }
        rotation2 = Optional.ofNullable(fa2).map(fa::n).orElse(null);
        if (rotation2 == null) {
            rotation2 = this.a.b((fq)this.b);
        } else if (Math.abs((double)rotation2.p() * (((bhe)object2).b - (double)rotation2.p() / 2.0 - this.a.player().p)) + Math.abs((double)rotation2.r() * (((bhe)object2).d - (double)rotation2.r() / 2.0 - this.a.player().r)) < 0.6) {
            ((cc)object).a(Input.MOVE_FORWARD, true);
        } else if (!this.a.player().z) {
            ((cc)object).a(Input.SNEAK, false);
        }
        if (rotation == null) {
            object2 = new bhe(((bhe)object2).b + 0.125 * (double)rotation2.p(), ((bhe)object2).c, ((bhe)object2).d + 0.125 * (double)rotation2.r());
            ((cc)object).a(new cc.a(RotationUtils.calcRotationFromVec3d(this.a.playerHead(), (bhe)object2, this.a.playerRotations()), false));
        }
        return object;
    }

    @Override
    public final boolean b(cc cc2) {
        return this.a.playerFeet().equals(this.a) || cc2.a != MovementStatus.RUNNING;
    }

    private static BetterBlockPos[] a(BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPosArray) {
        int n2 = betterBlockPos.p() - betterBlockPosArray.p();
        int n3 = betterBlockPos.r() - betterBlockPosArray.r();
        betterBlockPosArray = new BetterBlockPos[betterBlockPos.q() - betterBlockPosArray.q() + 2];
        for (int i2 = 0; i2 < betterBlockPosArray.length; ++i2) {
            betterBlockPosArray[i2] = new BetterBlockPos(betterBlockPos.p() - n2, betterBlockPos.q() + 1 - i2, betterBlockPos.r() - n3);
        }
        return betterBlockPosArray;
    }

    @Override
    public final boolean a(cc cc2) {
        if (cc2.a == MovementStatus.WAITING) {
            return true;
        }
        for (int i2 = 0; i2 < 4 && i2 < ((aip)this.a).length; ++i2) {
            if (cb.a((IPlayerContext)this.a, (BetterBlockPos)this.a[i2])) continue;
            return super.a(cc2);
        }
        return true;
    }
}

