/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afw
 *  aip
 *  air
 *  aow
 *  aox
 *  awt
 *  axw
 *  bhe
 *  et
 *  et$a
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  vg
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.Settings;
import baritone.api.event.events.BlockChangeEvent;
import baritone.api.event.events.ChunkEvent;
import baritone.api.event.events.PacketEvent;
import baritone.api.event.events.RenderEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.event.events.WorldEvent;
import baritone.api.event.events.type.EventState;
import baritone.api.event.listener.AbstractGameEventListener;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.pathing.goals.GoalYLevel;
import baritone.api.pathing.movement.IMovement;
import baritone.api.process.IBaritoneProcess;
import baritone.api.process.IElytraProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Pair;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.de;
import baritone.ek;
import baritone.el;
import baritone.em;
import baritone.en;
import baritone.eu;
import baritone.ex;
import baritone.fa;
import baritone.fc;
import baritone.fd;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.awt.Color;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dw
extends eu
implements AbstractGameEventListener,
IBaritoneProcess,
IElytraProcess {
    public a a;
    private boolean a;
    private BetterBlockPos a;
    private boolean b;
    private Goal a;
    private ek a;
    private boolean c;
    private Set<BetterBlockPos> a = new HashSet();

    private dw(baritone.a a2) {
        super(a2);
        a2.getGameEventHandler().registerEventListener(this);
    }

    public static <T extends IElytraProcess> T a(baritone.a a2) {
        return (T)((IElytraProcess)((Object)(em.a() ? new dw(a2) : new en(a2))));
    }

    @Override
    public final boolean isActive() {
        return this.a != null;
    }

    @Override
    public final void resetState() {
        et et2 = this.currentDestination();
        this.onLostControl();
        if (et2 != null) {
            this.pathTo(et2);
            this.repackChunks();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        Object object;
        el el2;
        Object object2;
        Object object3;
        if ((Long)baritone.a.a().elytraNetherSeed.value != this.a.a.b) {
            this.logDirect("Nether seed changed, recalculating path");
            this.resetState();
        }
        if (this.c != (Boolean)baritone.a.a().elytraPredictTerrain.value) {
            this.logDirect("elytraPredictTerrain setting changed, recalculating path");
            this.c = (Boolean)baritone.a.a().elytraPredictTerrain.value;
            this.resetState();
        }
        Object object4 = this.a;
        Object object5 = ((ek)object4).a.a;
        synchronized (object5) {
            object3 = object4;
            ((ek)object4).a = null;
            if (object3.a != null) {
                try {
                    object3.a = (ek.g)object3.a.get();
                }
                catch (Exception exception) {
                }
                finally {
                    object3.a = null;
                }
            }
            Object object6 = object3;
            if (((ek)object6).d <= 0 && (object2 = (Runnable)((ek)object6).a.poll()) != null) {
                object2.run();
                ((ek)object6).d = (Integer)baritone.a.a().ticksBetweenInventoryMoves.value;
            }
            if (((ek)object6).d > 0) {
                --((ek)object6).d;
            }
            if (object3.a > 0) {
                --object3.a;
            }
            if (object3.b > 0) {
                --object3.b;
            }
            if (!object3.a().isPresent()) {
                object3.c = 0;
            }
            ek.d.a();
            object3.a.clear();
            object3.b.clear();
            object3.d = null;
            object3.c = null;
            object3.a = null;
            el2 = object3.a.a;
            if (!el2.isEmpty()) {
                if (object3.b == null) {
                    object3.a.a();
                } else {
                    object3.a = new ex(object3.a);
                    object6 = object3.a;
                    ((ek.e)object6).c();
                    int n2 = ((ek.e)object6).a;
                    ((ek.e)object6).a = Math.max(((ek.e)object6).a, ((ek.e)object6).c);
                    ((ek.e)object6).b = ((ek.e)object6).a == n2 && ((ek.e)object6).a.a.player().cP() ? ++((ek.e)object6).b : 0;
                    ((ek.e)object6).b();
                    if (!((ek.e)object6).b) {
                        n2 = ((ek.e)object6).a.size() - 1;
                        if (!((ek.e)object6).a && ((ek.e)object6).a.a.world().a((et)((ek.e)object6).a.a(n2), false)) {
                            ((ek.e)object6).a(n2);
                        }
                    }
                    int n3 = object3.a.c;
                    object3.d = el2.subList(Math.max(n3 - 30, 0), Math.min(n3 + 100, el2.size()));
                }
            }
        }
        long l2 = System.currentTimeMillis();
        if ((l2 - ((ek)object4).a) / 1000L > (Long)baritone.a.a().elytraTimeBetweenCacheCullSecs.value) {
            ((ek)object4).a.a(((ek)object4).a.player().ab, ((ek)object4).a.player().ad, (int)((Integer)baritone.a.a().elytraCacheCullDistance.value), ((ek)object4).a);
            ((ek)object4).a = l2;
        }
        if (bl2) {
            this.onLostControl();
            this.logDirect("Failed to compute a walking path to a spot to jump off from. Consider starting from a higher location, near an overhang. Or, you can disable elytraAutoJump and just manually begin gliding.");
            return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
        }
        bl2 = false;
        if (this.a.player().cP() && this.a()) {
            if (((Boolean)baritone.a.a().elytraAllowEmergencyLand.value).booleanValue()) {
                this.logDirect("Emergency landing - almost out of elytra durability or fireworks");
                bl2 = true;
            } else {
                this.logDirect("almost out of elytra durability or fireworks, but I'm going to continue since elytraAllowEmergencyLand is false");
            }
        }
        if (this.a.player().cP() && this.a != baritone.dw$a.f && (this.a.a.a || bl2)) {
            object3 = this.a.a.a.a();
            if (object3 != null && (this.a.player().d((et)object3) < 2304.0 || bl2) && (!this.a || bl2 && this.a == null)) {
                Object object7;
                HashSet<BetterBlockPos> hashSet;
                block69: {
                    this.logDirect("Path complete, picking a nearby safe landing spot...");
                    dw dw2 = this;
                    BetterBlockPos betterBlockPos3 = dw2.a.playerFeet();
                    object4 = dw2;
                    object = new PriorityQueue<BetterBlockPos>(Comparator.comparingInt(betterBlockPos2 -> (betterBlockPos2.a - betterBlockPos.a) * (betterBlockPos2.a - betterBlockPos.a) + (betterBlockPos2.c - betterBlockPos.c) * (betterBlockPos2.c - betterBlockPos.c)).thenComparingInt(betterBlockPos -> -betterBlockPos.b));
                    hashSet = new HashSet<BetterBlockPos>();
                    el2 = new LongOpenHashSet();
                    object.add((BetterBlockPos)betterBlockPos3);
                    while (!object.isEmpty()) {
                        BetterBlockPos betterBlockPos4 = (BetterBlockPos)((Object)object.poll());
                        if (!((dw)object4).a.world().a((et)betterBlockPos4, false) || !((object2 = betterBlockPos4).q() >= 0 && object2.q() < 128) || ((dw)object4).a.world().o((et)betterBlockPos4).u() != aox.a) continue;
                        object2 = super.a((et)betterBlockPos4, (LongOpenHashSet)el2);
                        if (object2 != null && super.b((et)object2) && super.c(((BetterBlockPos)((Object)object2)).up(15)) && !((dw)object4).a.contains((Object)((BetterBlockPos)((Object)object2)).up(15))) {
                            object7 = ((BetterBlockPos)((Object)object2)).up(15);
                            break block69;
                        }
                        if (hashSet.add(betterBlockPos4.north())) {
                            object.add(betterBlockPos4.north());
                        }
                        if (hashSet.add(betterBlockPos4.east())) {
                            object.add(betterBlockPos4.east());
                        }
                        if (hashSet.add(betterBlockPos4.south())) {
                            object.add(betterBlockPos4.south());
                        }
                        if (hashSet.add(betterBlockPos4.west())) {
                            object.add(betterBlockPos4.west());
                        }
                        if (hashSet.add(betterBlockPos4.up())) {
                            object.add(betterBlockPos4.up());
                        }
                        if (!hashSet.add(betterBlockPos4.down())) continue;
                        object.add(betterBlockPos4.down());
                    }
                    object7 = hashSet = null;
                }
                if (object7 != null) {
                    this.a((et)hashSet, true);
                    this.a = hashSet;
                }
                this.a = true;
            }
            if (object3 != null && this.a.player().d((et)object3) < 1.0) {
                if (((Boolean)baritone.a.a().notificationOnPathComplete.value).booleanValue() && !this.b) {
                    this.logNotification("Pathing complete", false);
                }
                if (((Boolean)baritone.a.a().disconnectOnArrival.value).booleanValue() && !this.b) {
                    this.onLostControl();
                    this.a.world().O();
                    return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
                }
                this.b = true;
                if (this.a) {
                    this.a = baritone.dw$a.f;
                    this.logDirect("Above the landing spot, landing...");
                }
            }
        }
        if (this.a == baritone.dw$a.f) {
            Object object8 = object3 = this.a != null ? this.a : this.a.a.a.a();
            if (this.a.player().cP() && object3 != null) {
                Object object9 = this.a.player().d();
                object4 = new bhe((double)((BetterBlockPos)((Object)object3)).a + 0.5, ((bhe)object9).c, (double)((BetterBlockPos)((Object)object3)).c + 0.5);
                object9 = RotationUtils.calcRotationFromVec3d((bhe)object9, (bhe)object4, this.a.playerRotations());
                ((baritone.a)((Object)this.a)).a.updateTarget(new Rotation(((Rotation)object9).getYaw(), 0.0f), false);
                if (this.a.player().q < (double)(((BetterBlockPos)((Object)object3)).b - 15)) {
                    this.logDirect("bad landing spot, trying again...");
                    this.a((BetterBlockPos)((Object)object3));
                }
            }
        }
        if (this.a.player().cP()) {
            this.a.a = this.a == baritone.dw$a.f;
            this.a = null;
            ((baritone.a)((Object)this.a)).a.clearAllKeys();
            object4 = this.a;
            if (!((ek)object4).a.a.isEmpty()) {
                int n4;
                ek ek2 = object4;
                if (((Boolean)baritone.a.a().elytraAutoSwap.value).booleanValue() && ek2.a.isEmpty() && (el2 = (aip)ek2.a.player().bv.b.get(2)).c() == air.cS && el2.c().l() - el2.i() <= (Integer)baritone.a.a().elytraMinimumDurability.value && (n4 = ek2.a()) != -1) {
                    int n5 = n4 < 9 ? n4 + 36 : n4;
                    ek ek3 = ek2;
                    ek3.a(ek3.a.player().bx.d, n5, afw.a);
                    ek ek4 = ek2;
                    ek4.a(ek4.a.player().bx.d, 6, afw.a);
                    ek ek5 = ek2;
                    ek5.a(ek5.a.player().bx.d, n5, afw.a);
                }
                if (((ek)object4).a.player().A) {
                    object4.logDirect("hbonk");
                }
                if (((ek)object4).a.player().B) {
                    object4.logDirect("vbonk");
                }
                ek.h h2 = new ek.h((ek)object4, false);
                ((ek)object4).c = true;
                object = ((ek)object4).a == null || !((ek)object4).a.a.equals(h2) ? ((ek)object4).a(h2) : ((ek)object4).a;
                if (((ek)object4).b) {
                    int[] nArray = ((ek)object4).a;
                    int n6 = h2.a.a() ? 1 : 0;
                    nArray[n6] = nArray[n6] + 1;
                    ((ek)object4).b = false;
                }
                if (object == null) {
                    object4.logDirect("no solution");
                } else {
                    ((ek)object4).a.a.updateTarget(((ek.g)object).a, false);
                    if (!((ek.g)object).a) {
                        object4.logDirect("no pitch solution, probably gonna crash in a few ticks LOL!!!");
                    } else {
                        ((ek)object4).a = new BetterBlockPos(((ek.g)object).a.b, ((ek.g)object).a.c, ((ek.g)object).a.d);
                        ((ek)object4).a(((ek.g)object).a.a, ((ek.g)object).a, ((ek.g)object).a.a.a(), ((ek.g)object).b);
                    }
                }
            }
            return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
        }
        if (this.a == baritone.dw$a.f) {
            if (Math.sqrt(this.a.player().s * this.a.player().s + this.a.player().u * this.a.player().u) > 0.001) {
                this.logDirect("Landed, but still moving, waiting for velocity to die down... ");
                ((baritone.a)((Object)this.a)).a.setInputForceState(Input.SNEAK, true);
                return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            }
            this.logDirect("Done :)");
            ((baritone.a)((Object)this.a)).a.clearAllKeys();
            this.onLostControl();
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        if (this.a == baritone.dw$a.e || this.a == baritone.dw$a.d) {
            a a2 = this.a = this.a.player().z && (Boolean)baritone.a.a().elytraAutoJump.value != false ? baritone.dw$a.a : baritone.dw$a.d;
        }
        if (this.a == baritone.dw$a.a) {
            if (this.a()) {
                this.logDirect("Not taking off, because elytra durability or fireworks are so low that I would immediately emergency land anyway.");
                this.onLostControl();
                return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
            }
            if (this.a == null) {
                this.a = new GoalYLevel(31);
            }
            if ((object3 = ((baritone.a)((Object)this.a)).a.a) != null && object3.getPath().getGoal() == this.a) {
                IMovement iMovement2 = object3.getPath().movements().stream().filter(iMovement -> iMovement instanceof de).findFirst().orElse(null);
                if (iMovement2 != null) {
                    object4 = new BetterBlockPos((iMovement2.getSrc().a + iMovement2.getDest().a) / 2, (iMovement2.getSrc().b + iMovement2.getDest().b) / 2, (iMovement2.getSrc().c + iMovement2.getDest().c) / 2);
                    this.a.a.a((et)object4).whenComplete((void_, throwable) -> {
                        if (throwable == null) {
                            this.a = baritone.dw$a.c;
                            return;
                        }
                        this.onLostControl();
                    });
                    this.a = baritone.dw$a.b;
                } else {
                    this.onLostControl();
                    this.logDirect("Failed to compute a walking path to a spot to jump off from. Consider starting from a higher location, near an overhang. Or, you can disable elytraAutoJump and just manually begin gliding.");
                    return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
                }
            }
            return new fd(this.a, PathingCommandType.SET_GOAL_AND_PAUSE, new b((IBaritone)((Object)this.a)));
        }
        if (this.a == baritone.dw$a.b) {
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        if (this.a == baritone.dw$a.c) {
            object3 = ((baritone.a)((Object)this.a)).a.a;
            if (this.a.player().L > 1.0f && !bl3 && object3 != null && object3.getPath().movements().get(object3.getPosition()) instanceof de) {
                this.a = baritone.dw$a.d;
            } else {
                return new PathingCommand(null, PathingCommandType.SET_GOAL_AND_PATH);
            }
        }
        if (this.a == baritone.dw$a.d) {
            if (!bl3) {
                ((baritone.a)((Object)this.a)).a.b();
            }
            ((baritone.a)((Object)this.a)).a.clearAllKeys();
            if (this.a.player().L > 1.0f) {
                ((baritone.a)((Object)this.a)).a.setInputForceState(Input.JUMP, true);
            }
        }
        return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
    }

    public final void a(BetterBlockPos betterBlockPos) {
        this.a.add(betterBlockPos);
        this.a = false;
        this.a = null;
        this.a = baritone.dw$a.e;
    }

    @Override
    public final void onLostControl() {
        this.a = null;
        this.a = false;
        this.a = null;
        this.b = false;
        this.a = baritone.dw$a.d;
        this.a();
    }

    private void a() {
        ek ek2 = this.a;
        if (ek2 != null) {
            this.a = null;
            baritone.a.a().execute(ek2::b);
        }
    }

    @Override
    public final double priority() {
        return 0.0;
    }

    @Override
    public final String displayName0() {
        return "Elytra - " + this.a.a;
    }

    @Override
    public final void repackChunks() {
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override
    public final et currentDestination() {
        if (this.a != null) {
            return this.a.b;
        }
        return null;
    }

    @Override
    public final void pathTo(et et2) {
        this.a(et2, false);
    }

    private void a(et et2, boolean bl2) {
        if (this.a.player() == null || this.a.player().am != -1) {
            return;
        }
        this.onLostControl();
        this.c = (Boolean)baritone.a.a().elytraPredictTerrain.value;
        this.a = new ek((baritone.a)((Object)this.a), this, et2, bl2);
        if (this.a.world() != null) {
            this.a.c();
        }
        this.a.a();
    }

    @Override
    public final void pathTo(Goal goal) {
        int n2;
        int n3;
        int n4;
        if (goal instanceof GoalXZ) {
            GoalXZ goalXZ = (GoalXZ)goal;
            n4 = goalXZ.getX();
            n3 = 64;
            n2 = goalXZ.getZ();
        } else if (goal instanceof GoalBlock) {
            GoalBlock goalBlock = (GoalBlock)goal;
            n4 = goalBlock.x;
            n3 = goalBlock.y;
            n2 = goalBlock.z;
        } else {
            throw new IllegalArgumentException("The goal must be a GoalXZ or GoalBlock");
        }
        if (n3 <= 0 || n3 >= 128) {
            throw new IllegalArgumentException("The y of the goal is not between 0 and 128");
        }
        this.pathTo(new et(n4, n3, n2));
    }

    private boolean a() {
        aip aip2 = (aip)this.a.player().bv.b.get(2);
        if (aip2.c() != air.cS || aip2.c().l() - aip2.i() < (Integer)baritone.a.a().elytraMinimumDurability.value) {
            return true;
        }
        aip2 = this.a.player().bv.a;
        int n2 = 0;
        for (int i2 = 0; i2 < 36; ++i2) {
            if (!ek.a((aip)aip2.get(i2))) continue;
            n2 += ((aip)aip2.get(i2)).E();
        }
        return n2 <= (Integer)baritone.a.a().elytraMinFireworksBeforeLanding.value;
    }

    @Override
    public final boolean isLoaded() {
        return true;
    }

    @Override
    public final boolean isSafeToCancel() {
        return !this.isActive() || this.a != baritone.dw$a.e && this.a != baritone.dw$a.d;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onRenderPass(RenderEvent object) {
        if (this.a != null) {
            Iterator<Object> iterator2;
            Object renderEvent = object;
            object = this.a;
            Settings settings = baritone.a.a();
            if (((ek)object).d != null) {
                fc.a(((ek)object).d, 0, Color.RED, false, 0, 0, 0.0);
            }
            if (((ek)object).a != null) {
                fc.a((vg)((ek)object).a.player(), new GoalBlock(((ek)object).a), ((RenderEvent)renderEvent).getPartialTicks(), Color.GREEN);
            }
            if (!((ek)object).a.isEmpty() && ((Boolean)settings.elytraRenderRaytraces.value).booleanValue()) {
                fa.a(Color.GREEN, ((Float)settings.pathRenderLineWidthPixels.value).floatValue(), (Boolean)settings.renderPathIgnoreDepth.value);
                iterator2 = ((ek)object).a.iterator();
                while (iterator2.hasNext()) {
                    Pair pair = (Pair)iterator2.next();
                    fa.a((bhe)pair.first(), (bhe)pair.second());
                }
                fa.a((Boolean)settings.renderPathIgnoreDepth.value);
            }
            if (!((ek)object).b.isEmpty() && ((Boolean)baritone.a.a().elytraRenderRaytraces.value).booleanValue()) {
                fa.a(Color.BLUE, ((Float)settings.pathRenderLineWidthPixels.value).floatValue(), (Boolean)settings.renderPathIgnoreDepth.value);
                for (Pair pair : ((ek)object).b) {
                    fa.a((bhe)pair.first(), (bhe)pair.second());
                }
                fa.a((Boolean)settings.renderPathIgnoreDepth.value);
            }
            if (((ek)object).c != null && ((Boolean)baritone.a.a().elytraRenderSimulation.value).booleanValue()) {
                void var5_9;
                fa.a(new Color(3591388), ((Float)settings.pathRenderLineWidthPixels.value).floatValue(), (Boolean)settings.renderPathIgnoreDepth.value);
                iterator2 = new bhe(((ek)object).a.player().m + (((ek)object).a.player().p - ((ek)object).a.player().m) * (double)((RenderEvent)renderEvent).getPartialTicks(), ((ek)object).a.player().n + (((ek)object).a.player().q - ((ek)object).a.player().n) * (double)((RenderEvent)renderEvent).getPartialTicks(), ((ek)object).a.player().o + (((ek)object).a.player().r - ((ek)object).a.player().o) * (double)((RenderEvent)renderEvent).getPartialTicks());
                boolean bl2 = false;
                while (var5_9 < ((ek)object).c.size() - 1) {
                    renderEvent = ((ek)object).c.get((int)var5_9).e(iterator2);
                    bhe bhe2 = ((ek)object).c.get((int)(var5_9 + true)).e(iterator2);
                    fa.a((bhe)renderEvent, bhe2);
                    ++var5_9;
                }
                fa.a((Boolean)settings.renderPathIgnoreDepth.value);
            }
        }
    }

    @Override
    public final void onWorldEvent(WorldEvent worldEvent) {
        if (worldEvent.getWorld() != null && worldEvent.getState() == EventState.POST) {
            this.a();
        }
    }

    @Override
    public final void onChunkEvent(ChunkEvent object) {
        if (this.a != null) {
            ChunkEvent chunkEvent = object;
            object = this.a;
            if (chunkEvent.isPostPopulate()) {
                chunkEvent = ((ek)object).a.world().a(chunkEvent.getX(), chunkEvent.getZ());
                ((ek)object).a.a((axw)chunkEvent);
            }
        }
    }

    @Override
    public final void onBlockChange(BlockChangeEvent blockChangeEvent) {
        if (this.a != null) {
            this.a.a.a(blockChangeEvent);
        }
    }

    @Override
    public final void onReceivePacket(PacketEvent packetEvent) {
        if (this.a != null) {
            this.a.a(packetEvent);
        }
    }

    @Override
    public final void onPostTick(TickEvent tickEvent) {
        IBaritoneProcess iBaritoneProcess = ((baritone.a)((Object)this.a)).a.mostRecentInControl().orElse(null);
        if (this.a != null && iBaritoneProcess == this) {
            this.a.a(tickEvent);
        }
    }

    private static boolean a(aow aow2) {
        return aow2 == aox.aV || aow2 == aox.n || aow2 == aox.by && (Boolean)baritone.a.a().elytraAllowLandOnNetherFortress.value != false;
    }

    private boolean a(et et2) {
        return dw.a(this.a.world().o(et2).u());
    }

    private boolean b(et et2) {
        et2 = new et.a(et2);
        int n2 = et2.q() + 15;
        for (int i2 = et2.q() + 1; i2 <= n2; ++i2) {
            et et3 = et2;
            et3.c(et3.p(), i2, et2.r());
            if (this.a.world().d(et2)) continue;
            return false;
        }
        return true;
    }

    private boolean c(et et2) {
        et.a a2 = new et.a();
        for (int i2 = -4; i2 <= 4; ++i2) {
            for (int i3 = -4; i3 <= 4; ++i3) {
                for (int i4 = -4; i4 <= 4; ++i4) {
                    a2.c(et2.p() + i2, et2.q() + i3, et2.r() + i4);
                    if (this.a.world().d((et)a2)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    private BetterBlockPos a(et et2, LongOpenHashSet object) {
        et2 = new et.a(et2);
        while (et2.q() >= 0) {
            if (object.contains(et2.g())) {
                return null;
            }
            object.add(et2.g());
            aow aow2 = this.a.world().o(et2).u();
            if (dw.a(aow2)) {
                object = this;
                aow2 = et2;
                if (!(!((dw)object).a(aow2.c()) || !super.a(aow2.d()) || !super.a(aow2.f()) || !super.a(aow2.e()) || !super.a(aow2.c().e()) || !super.a(aow2.c().f()) || !super.a(aow2.d().e()) || !super.a(aow2.d().f()))) {
                    return new BetterBlockPos(et2);
                }
                return null;
            }
            if (aow2 != aox.a) {
                return null;
            }
            et et3 = et2;
            et3.c(et3.p(), et2.q() - 1, et2.r());
        }
        return null;
    }

    public static final class b
    extends bz {
        public b(IBaritone iBaritone) {
            super(iBaritone, true);
            this.k = true;
            this.b = 8;
            this.c = 10000;
        }

        @Override
        public final double a(int n2, int n3, int n4, awt awt2) {
            return 1000000.0;
        }

        @Override
        public final double b(int n2, int n3, int n4, awt awt2) {
            return 1000000.0;
        }

        @Override
        public final double a() {
            return 1000000.0;
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("Finding spot to jump off");
        public static final /* enum */ a b = new a("Waiting for elytra path");
        public static final /* enum */ a c = new a("Walking to takeoff");
        public static final /* enum */ a d = new a("Begin flying");
        public static final /* enum */ a e = new a("Flying");
        public static final /* enum */ a f = new a("Landing");
        public final String a;
        private static final /* synthetic */ a[] a;

        public static a[] values() {
            return (a[])a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        private a(String string2) {
            this.a = string2;
        }

        static {
            a = new a[]{a, b, c, d, e, f};
        }
    }
}

