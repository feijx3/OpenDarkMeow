/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aox
 *  bhb
 *  bus
 *  bwv
 *  et
 *  rk
 *  vg
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.event.events.RenderEvent;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalComposite;
import baritone.api.pathing.goals.GoalGetToBlock;
import baritone.api.pathing.goals.GoalInverted;
import baritone.api.pathing.goals.GoalTwoBlocks;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.pathing.goals.GoalYLevel;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.interfaces.IGoalRenderPos;
import baritone.bw;
import baritone.dk;
import baritone.ex;
import baritone.ez;
import baritone.fa;
import baritone.h;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class fc
implements fa {
    public static void a(RenderEvent renderEvent, h h2) {
        int n2;
        dk dk2 = h2.a;
        if (dk2.world() == null) {
            return;
        }
        if (dk2.minecraft().m instanceof ez) {
            ((ez)dk2.minecraft().m).a();
        }
        float f2 = renderEvent.getPartialTicks();
        Object object = h2.getGoal();
        int n3 = dk2.world().s.q().a();
        if (n3 != (n2 = BaritoneAPI.getProvider().getPrimaryBaritone().getPlayerContext().world().s.q().a())) {
            return;
        }
        if (object != null && ((Boolean)fc.a.renderGoal.value).booleanValue()) {
            fc.a((vg)dk2.player(), (Goal)object, f2, (Color)fc.a.colorGoalBox.value);
        }
        if (!((Boolean)fc.a.renderPath.value).booleanValue()) {
            return;
        }
        dk dk3 = h2.a;
        object = h2.b;
        if (dk3 != null && ((Boolean)fc.a.renderSelectionBoxes.value).booleanValue()) {
            fc.a((vg)dk2.player(), Collections.unmodifiableSet(dk3.a), (Color)fc.a.colorBlocksToBreak.value);
            fc.a((vg)dk2.player(), Collections.unmodifiableSet(dk3.b), (Color)fc.a.colorBlocksToPlace.value);
            fc.a((vg)dk2.player(), Collections.unmodifiableSet(dk3.c), (Color)fc.a.colorBlocksToWalkInto.value);
        }
        if (dk3 != null && dk3.getPath() != null) {
            n3 = Math.max(dk3.getPosition() - 3, 0);
            fc.a(dk3.getPath().positions(), n3, (Color)fc.a.colorCurrentPath.value, (boolean)((Boolean)fc.a.fadePath.value));
        }
        if (object != null && ((dk)object).getPath() != null) {
            fc.a(((dk)object).getPath().positions(), 0, (Color)fc.a.colorNextPath.value, (boolean)((Boolean)fc.a.fadePath.value));
        }
        h2.getInProgress().ifPresent(arg_0 -> fc.a((IPlayerContext)((Object)dk2), arg_0));
    }

    private static void a(List<BetterBlockPos> list, int n2, Color color, boolean bl2) {
        fc.a(list, n2, color, bl2, 10, 20, 0.5);
    }

    public static void a(List<BetterBlockPos> list, int n2, Color color, boolean bl2, int n3, int n4, double d2) {
        fa.a(color, ((Float)fc.a.pathRenderLineWidthPixels.value).floatValue(), (Boolean)fc.a.renderPathIgnoreDepth.value);
        n3 += n2;
        n4 += n2;
        while (n2 < list.size() - 1) {
            BetterBlockPos betterBlockPos = list.get(n2);
            int n5 = n2 + 1;
            BetterBlockPos betterBlockPos2 = list.get(n5);
            int n6 = betterBlockPos2.a - betterBlockPos.a;
            int n7 = betterBlockPos2.b - betterBlockPos.b;
            int n8 = betterBlockPos2.c - betterBlockPos.c;
            while (!(n5 + 1 >= list.size() || bl2 && n5 + 1 >= n3 || n6 != list.get((int)(n5 + 1)).a - betterBlockPos2.a || n7 != list.get((int)(n5 + 1)).b - betterBlockPos2.b || n8 != list.get((int)(n5 + 1)).c - betterBlockPos2.c)) {
                betterBlockPos2 = list.get(++n5);
            }
            if (bl2) {
                float f2;
                if (n2 <= n3) {
                    f2 = 0.4f;
                } else {
                    if (n2 > n4) break;
                    f2 = 0.4f * (1.0f - (float)(n2 - n3) / (float)(n4 - n3));
                }
                fa.a(color, f2);
            }
            fc.a(betterBlockPos.a, (double)betterBlockPos.b, betterBlockPos.c, betterBlockPos2.a, (double)betterBlockPos2.b, (double)betterBlockPos2.c, d2);
            n2 = n5;
        }
        fa.a((Boolean)fc.a.renderPathIgnoreDepth.value);
    }

    private static void a(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d8 + 0.03;
        double d10 = fc.a.h;
        double d11 = fc.a.i;
        double d12 = fc.a.j;
        boolean bl2 = (Boolean)fc.a.renderPathAsLine.value == false;
        a.b(d2 + d8 - d10, d3 + d8 - d11, d4 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
        a.b(d5 + d8 - d10, d6 + d8 - d11, d7 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
        if (bl2) {
            a.b(d5 + d8 - d10, d6 + d8 - d11, d7 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
            a.b(d5 + d8 - d10, d6 + d9 - d11, d7 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
            a.b(d5 + d8 - d10, d6 + d9 - d11, d7 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
            a.b(d2 + d8 - d10, d3 + d9 - d11, d4 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
            a.b(d2 + d8 - d10, d3 + d9 - d11, d4 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
            a.b(d2 + d8 - d10, d3 + d8 - d11, d4 + d8 - d12).a(a[0], a[1], a[2], a[3]).d();
        }
    }

    public static void a(vg vg2, Collection<et> collection, Color object) {
        fa.a((Color)object, ((Float)fc.a.pathRenderLineWidthPixels.value).floatValue(), (Boolean)fc.a.renderSelectionBoxesIgnoreDepth.value);
        object = new ex(BaritoneAPI.getProvider().getPrimaryBaritone().getPlayerContext());
        collection.forEach(arg_0 -> fc.a((ex)object, vg2, arg_0));
        fa.a((Boolean)fc.a.renderSelectionBoxesIgnoreDepth.value);
    }

    public static void a(vg vg2, Goal goal, float f2, Color color) {
        fc.a(vg2, goal, f2, color, true);
    }

    private static void a(vg vg2, Goal goalArray, float f2, Color color, boolean n2) {
        double d2 = fc.a.h;
        double d3 = fc.a.i;
        double d4 = fc.a.j;
        double d5 = (Boolean)fc.a.renderGoalAnimated.value == false ? (double)0.999f : (double)rk.b((float)((float)((double)((float)(System.nanoTime() / 100000L % 20000L) / 20000.0f) * Math.PI * 2.0)));
        if (goalArray instanceof IGoalRenderPos) {
            et et2 = ((IGoalRenderPos)goalArray).getGoalPos();
            double d6 = (double)et2.p() + 0.002 - d2;
            double d7 = (double)(et2.p() + 1) - 0.002 - d2;
            double d8 = (double)et2.r() + 0.002 - d4;
            double d9 = (double)(et2.r() + 1) - 0.002 - d4;
            if (goalArray instanceof GoalGetToBlock || goalArray instanceof GoalTwoBlocks) {
                d5 /= 2.0;
            }
            double d10 = d5 + 1.0 + (double)et2.q() - d3;
            double d11 = 1.0 - d5 + (double)et2.q() - d3;
            double d12 = (double)et2.q() - d3;
            double d13 = d12 + 2.0;
            if (goalArray instanceof GoalGetToBlock || goalArray instanceof GoalTwoBlocks) {
                d10 -= 0.5;
                d11 -= 0.5;
                d13 -= 1.0;
            }
            fc.a(color, d6, d7, d8, d9, d12, d13, d10, d11, n2 != 0);
            return;
        }
        if (goalArray instanceof GoalXZ) {
            GoalXZ goalXZ = (GoalXZ)goalArray;
            if (((Boolean)fc.a.renderGoalXZBeacon.value).booleanValue()) {
                a.a(bwv.a);
                if (((Boolean)fc.a.renderGoalIgnoreDepth.value).booleanValue()) {
                    bus.j();
                }
                bwv.a((double)((double)goalXZ.getX() - d2), (double)(-d3), (double)((double)goalXZ.getZ() - d4), (double)((Boolean)fc.a.renderGoalAnimated.value != false ? (double)f2 : 0.0), (double)1.0, (double)((Boolean)fc.a.renderGoalAnimated.value != false ? (double)vg2.l.R() : 0.0), (int)0, (int)256, (float[])color.getColorComponents(null));
                if (((Boolean)fc.a.renderGoalIgnoreDepth.value).booleanValue()) {
                    bus.k();
                }
                return;
            }
            double d14 = (double)goalXZ.getX() + 0.002 - d2;
            double d15 = (double)(goalXZ.getX() + 1) - 0.002 - d2;
            double d16 = (double)goalXZ.getZ() + 0.002 - d4;
            double d17 = (double)(goalXZ.getZ() + 1) - 0.002 - d4;
            double d18 = 0.0 - d3;
            double d19 = 256.0 - d3;
            fc.a(color, d14, d15, d16, d17, d18, d19, 0.0, 0.0, n2 != 0);
            return;
        }
        if (goalArray instanceof GoalComposite) {
            boolean bl2 = Arrays.stream(((GoalComposite)goalArray).goals()).allMatch(IGoalRenderPos.class::isInstance);
            if (bl2) {
                fa.a(color, ((Float)fc.a.goalRenderLineWidthPixels.value).floatValue(), (Boolean)fc.a.renderGoalIgnoreDepth.value);
            }
            for (Goal goal : ((GoalComposite)goalArray).goals()) {
                fc.a(vg2, goal, f2, color, !bl2);
            }
            if (bl2) {
                fa.a((Boolean)fc.a.renderGoalIgnoreDepth.value);
            }
            return;
        }
        if (goalArray instanceof GoalInverted) {
            fc.a(vg2, ((GoalInverted)goalArray).origin, f2, (Color)fc.a.colorInvertedGoalBox.value);
            return;
        }
        if (goalArray instanceof GoalYLevel) {
            GoalYLevel goalYLevel = (GoalYLevel)goalArray;
            double d20 = vg2.p - (Double)fc.a.yLevelBoxSize.value - d2;
            double d21 = vg2.r - (Double)fc.a.yLevelBoxSize.value - d4;
            double d22 = vg2.p + (Double)fc.a.yLevelBoxSize.value - d2;
            double d23 = vg2.r + (Double)fc.a.yLevelBoxSize.value - d4;
            double d24 = (double)((GoalYLevel)goalArray).level - d3;
            double d25 = d24 + 2.0;
            double d26 = d5 + 1.0 + (double)goalYLevel.level - d3;
            double d27 = 1.0 - d5 + (double)goalYLevel.level - d3;
            fc.a(color, d20, d22, d21, d23, d24, d25, d26, d27, n2 != 0);
        }
    }

    private static void a(Color color, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, boolean bl2) {
        if (bl2) {
            fa.a(color, ((Float)fc.a.goalRenderLineWidthPixels.value).floatValue(), (Boolean)fc.a.renderGoalIgnoreDepth.value);
        }
        fc.a(d2, d3, d4, d5, d8);
        fc.a(d2, d3, d4, d5, d9);
        a.b(d2, d6, d4).a(a[0], a[1], a[2], a[3]).d();
        a.b(d2, d7, d4).a(a[0], a[1], a[2], a[3]).d();
        a.b(d3, d6, d4).a(a[0], a[1], a[2], a[3]).d();
        a.b(d3, d7, d4).a(a[0], a[1], a[2], a[3]).d();
        a.b(d3, d6, d5).a(a[0], a[1], a[2], a[3]).d();
        a.b(d3, d7, d5).a(a[0], a[1], a[2], a[3]).d();
        a.b(d2, d6, d5).a(a[0], a[1], a[2], a[3]).d();
        a.b(d2, d7, d5).a(a[0], a[1], a[2], a[3]).d();
        if (bl2) {
            fa.a((Boolean)fc.a.renderGoalIgnoreDepth.value);
        }
    }

    private static void a(double d2, double d3, double d4, double d5, double d6) {
        if (d6 != 0.0) {
            a.b(d2, d6, d4).a(a[0], a[1], a[2], a[3]).d();
            a.b(d3, d6, d4).a(a[0], a[1], a[2], a[3]).d();
            a.b(d3, d6, d4).a(a[0], a[1], a[2], a[3]).d();
            a.b(d3, d6, d5).a(a[0], a[1], a[2], a[3]).d();
            a.b(d3, d6, d5).a(a[0], a[1], a[2], a[3]).d();
            a.b(d2, d6, d5).a(a[0], a[1], a[2], a[3]).d();
            a.b(d2, d6, d5).a(a[0], a[1], a[2], a[3]).d();
            a.b(d2, d6, d4).a(a[0], a[1], a[2], a[3]).d();
        }
    }

    private static /* synthetic */ void a(ex ex2, vg vg2, et et2) {
        ex2 = (ex2 = ex2.a(et2)).u().equals(aox.a) ? aox.d.t().c(vg2.l, et2) : ex2.c(vg2.l, et2);
        fa.a((bhb)ex2, 0.002);
    }

    private static /* synthetic */ void a(IPlayerContext iPlayerContext, bw bw2) {
        bw2.bestPathSoFar().ifPresent(iPath -> fc.a(iPath.positions(), 0, (Color)fc.a.colorBestPathSoFar.value, (boolean)((Boolean)fc.a.fadePath.value)));
        bw2.pathToMostRecentNodeConsidered().ifPresent(iPath -> {
            fc.a(iPath.positions(), 0, (Color)fc.a.colorMostRecentConsidered.value, (boolean)((Boolean)fc.a.fadePath.value));
            fc.a((vg)iPlayerContext.player(), Collections.singletonList(iPath.getDest()), (Color)fc.a.colorMostRecentConsidered.value);
        });
    }
}

