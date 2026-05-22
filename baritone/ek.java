/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aed
 *  aem
 *  afw
 *  aip
 *  air
 *  bcz
 *  bhb
 *  bhe
 *  bib
 *  et
 *  fi
 *  fq
 *  it.unimi.dsi.fastutil.floats.FloatArrayList
 *  it.unimi.dsi.fastutil.floats.FloatListIterator
 *  it.unimi.dsi.fastutil.longs.Long2ReferenceOpenHashMap
 *  jq
 *  rk
 *  ub
 */
package baritone;

import baritone.api.behavior.look.IAimProcessor;
import baritone.api.behavior.look.ITickableAimProcessor;
import baritone.api.event.events.PacketEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Pair;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.SettingsUtil;
import baritone.dw;
import baritone.e;
import baritone.ej;
import baritone.el;
import baritone.em;
import baritone.eo;
import baritone.ep;
import baritone.ex;
import baritone.fm;
import baritone.fo;
import dev.babbaj.pathfinder.NetherPathfinder;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.floats.FloatListIterator;
import it.unimi.dsi.fastutil.longs.Long2ReferenceOpenHashMap;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ek
implements Helper {
    public final baritone.a a;
    public final IPlayerContext a;
    public final List<Pair<bhe, bhe>> a;
    public final List<Pair<bhe, bhe>> b;
    public List<bhe> c;
    public et a;
    public List<BetterBlockPos> d;
    public final em a;
    public final e a;
    private final dw a;
    public int a;
    public int b;
    public boolean a;
    public int c;
    public boolean b;
    public final int[] a;
    public ex a;
    public final ej a;
    public final et b;
    private final boolean d;
    private final ExecutorService a;
    public Future<g> a;
    public g a;
    public boolean c;
    public long a;
    public int d = 0;
    public final Queue<Runnable> a = new LinkedList();

    public ek(baritone.a a2, dw dw2, et et2, boolean bl2) {
        this.a = a2;
        this.a = a2.getPlayerContext();
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList<Pair<bhe, bhe>>();
        this.a = new e(this);
        this.a = dw2;
        this.b = et2;
        this.d = bl2;
        this.a = Executors.newSingleThreadExecutor();
        this.a = new int[2];
        this.a = new em((Long)baritone.a.a().elytraNetherSeed.value);
        this.a = new ej(this.a);
    }

    public final void a(PacketEvent packetEvent) {
        if (packetEvent.getPacket() instanceof jq) {
            this.a.minecraft().a(() -> {
                this.b = (Integer)baritone.a.a().elytraFireworkSetbackUseDelay.value;
            });
        }
    }

    public final void a() {
        if (!((Boolean)baritone.a.a().elytraAutoJump.value).booleanValue() || this.a.player().cP()) {
            this.a.a();
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.cancel(true);
        }
        this.a.shutdown();
        try {
            while (!this.a.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        em em2 = this.a;
        NetherPathfinder.cancel(em2.a);
        em2.a.shutdownNow();
        try {
            while (!em2.a.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        NetherPathfinder.freeContext(em2.a);
    }

    public final void c() {
        ((fm)this.a.world().B()).loadedChunks().values().forEach(this.a::a);
    }

    public final void a(TickEvent object) {
        if (((TickEvent)object).getType() == TickEvent.Type.IN && this.c) {
            this.a.c();
            object = new h(this, true);
            this.a = this.a.submit(() -> this.b((h)object));
            this.c = false;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final g a(h var1_1) {
        var2_2 = var1_1.a;
        var3_3 = this.a != false ? var2_2.size() - 1 : var1_1.a;
        var4_4 = var1_1.a;
        var5_5 = null;
        for (var6_7 = 0; var6_7 < 3; ++var6_7) {
            if (var1_1.a.a()) {
                v0 = new int[4];
                v0[0] = 20;
                v0[1] = 10;
                v0[2] = 5;
                v1 = v0;
                v0[3] = 0;
            } else {
                v2 = new int[1];
                v1 = v2;
                v2[0] = 0;
            }
            var7_8 = v1;
            var8_9 = var6_7 == 0 ? 2 : 3;
            var9_10 = var3_3;
            for (var10_11 = Math.min(var3_3 + 20, var2_2.size() - 1); var10_11 >= var9_10; --var10_11) {
                var11_12 = new ArrayList<Pair<bhe, Integer>>();
                var12_13 = var7_8;
                var13_14 = var7_8.length;
                for (var14_16 = 0; var14_16 < var13_14; ++var14_16) {
                    var15_20 = var12_13[var14_16];
                    if (var6_7 == 0 || var10_11 == var9_10) {
                        var11_12.add(new Pair<bhe, Integer>(var2_2.a(var10_11), var15_20));
                        continue;
                    }
                    if (var6_7 == 1) {
                        var17_26 = new double[]{1.0, 0.75, 0.5, 0.25};
                        for (var18_31 = 0; var18_31 < 4; ++var18_31) {
                            var19_34 = var17_26[var18_31];
                            var16_22 = var19_34 == 1.0 ? var2_2.a(var10_11) : var2_2.a(var10_11).a(var19_34).e(var2_2.a(var10_11 - 1).a(1.0 - var19_34));
                            var11_12.add(new Pair<bhe, Integer>(var16_22, var15_20));
                        }
                        continue;
                    }
                    var16_22 = var2_2.a(var10_11).d(var2_2.a(var10_11 - 1));
                    var17_27 = e.c.a(var16_22.b());
                    var16_22 = var16_22.a();
                    var18_32 = var2_2.a(var10_11);
                    for (var19_35 = 0; var19_35 < var17_27; ++var19_35) {
                        var11_12.add(new Pair<bhe, Integer>(var18_32, var15_20));
                        var18_32 = var18_32.d(var16_22);
                    }
                }
                var12_13 = var11_12.iterator();
                while (var12_13.hasNext()) {
                    block20: {
                        block19: {
                            var13_15 = (Pair)var12_13.next();
                            var14_17 = (Integer)var13_15.second();
                            var15_21 = ((bhe)var13_15.first()).b(0.0, (double)var14_17.intValue(), 0.0);
                            if (this.a) {
                                var15_21 = var15_21.b(0.5, 0.5, 0.5);
                            }
                            if (var14_17 != 0 && (var10_11 + var8_9 >= var2_2.size() || (!(var4_4.f(var15_21) < 40.0) ? this.a(var15_21, var2_2.a(var10_11), false) == false : this.a(var15_21, var2_2.a(var10_11 + var8_9).b(0.0, (double)var14_17.intValue(), 0.0), false) == false || this.a(var15_21, var2_2.a(var10_11 + var8_9), false) == false))) continue;
                            var16_23 = (Double)baritone.a.a().elytraMinimumAvoidance.value;
                            var16_24 = var6_7 == 2 ? null : Double.valueOf(var6_7 == 0 ? var16_23 * 2.0 : var16_23);
                            if (!this.a(var1_1, var15_21, var16_24)) continue;
                            var18_33 = RotationUtils.calcRotationFromVec3d(var4_4, var15_21, this.a.playerRotations()).getYaw();
                            var14_18 = var6_7;
                            var13_15 = var15_21;
                            var11_12 = var1_1;
                            var5_5 = this;
                            var16_25 = var14_18 == 2;
                            var17_28 = ek.a(RotationUtils.calcRotationFromVec3d(var11_12.a, (bhe)var13_15, var5_5.a.playerRotations()).getPitch(), var16_25);
                            var13_15 = (b<f>)LambdaMetafactory.metafactory(null, null, null, (III)Ljava/lang/Object;, a(baritone.ek$h bhe int it.unimi.dsi.fastutil.floats.FloatArrayList int int int ), (III)Lbaritone/ek$f;)((ek)var5_5, (h)var11_12, (bhe)var13_15, (int)var14_18, (FloatArrayList)var17_28);
                            var14_19 = new ArrayList<c>();
                            if (var11_12.a.a()) {
                                var17_29 = var11_12.a.a();
                                if (var17_29 == 0) {
                                    var5_5 = var11_12.a;
                                    var5_6 = Math.max(4, 10 - (var5_5.a() != false ? Math.max(0, var5_5.a - var5_5.a) : 0));
                                    var14_19.add(new c(var5_6, 1, 0));
                                } else if (var17_29 <= 5) {
                                    var14_19.add(new c(var17_29 + 5, var17_29, 0));
                                } else {
                                    var14_19.add(new c(var17_29 + 1, var17_29, 0));
                                }
                            }
                            var17_30 = var16_25 != false ? 3 : (var11_12.a.a() != false ? Math.max(5, var11_12.a.a()) : (Integer)baritone.a.a().elytraSimulationTicks.value);
                            var14_19.add(new c(var17_30, var11_12.a.a() != false ? var17_30 : 0, 0));
                            var5_5 = var14_19.stream().map((Function<c, f>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, b(baritone.ek$b baritone.ek$c ), (Lbaritone/ek$c;)Lbaritone/ek$f;)((b)var13_15)).filter((Predicate<f>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, nonNull(java.lang.Object ), (Lbaritone/ek$f;)Z)()).findFirst();
                            if (!var5_5.isPresent()) break block19;
                            v3 = new Pair<Float, Boolean>(Float.valueOf(var5_5.get().a), Boolean.FALSE);
                            break block20;
                        }
                        if (!var16_25) ** GOTO lbl-1000
                        var11_12 = new ArrayList<c>();
                        var11_12.add(new c(var17_30, 10, 3));
                        var11_12.add(new c(var17_30, 10, 2));
                        var11_12.add(new c(var17_30, 10, 1));
                        var11_12 = var11_12.stream().map((Function<c, f>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(baritone.ek$b baritone.ek$c ), (Lbaritone/ek$c;)Lbaritone/ek$f;)((b)var13_15)).filter((Predicate<f>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, nonNull(java.lang.Object ), (Lbaritone/ek$f;)Z)()).findFirst();
                        if (var11_12.isPresent()) {
                            v3 = new Pair<Float, Boolean>(Float.valueOf(((f)var11_12.get()).a), Boolean.TRUE);
                        } else lbl-1000:
                        // 2 sources

                        {
                            v3 = var19_36 = null;
                        }
                    }
                    if (v3 == null) {
                        var5_5 = new g(var1_1, new Rotation(var18_33, this.a.playerRotations().getPitch()), null, false, false);
                        continue;
                    }
                    return new g(var1_1, new Rotation(var18_33, var19_36.first().floatValue()), var15_21, true, var19_36.second());
                }
            }
        }
        return var5_5;
    }

    public final void a(bhe bhe2, bhe bhe3, boolean bl2, boolean bl3) {
        block6: {
            block7: {
                double d2;
                double d3;
                block8: {
                    if (this.b > 0) {
                        this.logDebug("waiting for elytraFireworkSetbackUseDelay: " + this.b);
                        return;
                    }
                    if (this.a) {
                        return;
                    }
                    boolean bl4 = (Boolean)baritone.a.a().elytraConserveFireworks.value == false || this.a.player().q < bhe3.c + 5.0;
                    d3 = new bhe(this.a.player().s, this.a.player().q < bhe3.c ? Math.max(0.0, this.a.player().t) : this.a.player().t, this.a.player().u).c();
                    d2 = (Double)baritone.a.a().elytraFireworkSpeed.value;
                    if (this.a > 0) break block6;
                    if (bl3) break block7;
                    if (bl2 || !bl4) break block6;
                    if (this.a.player().q < bhe3.c - 5.0) break block8;
                    bhe bhe4 = new bhe(bhe3.b + 0.5, this.a.player().q, bhe3.d + 0.5);
                    if (!(bhe2.f(bhe4) > 5.0)) break block6;
                }
                double d4 = d2;
                if (!(d3 < d4 * d4)) break block6;
            }
            if (!this.a.a.a(true, ek::b) && !this.a.a.a(true, ek::a)) {
                this.logDirect("no fireworks");
                return;
            }
            this.logDirect("attempting to use firework" + (bl3 ? " (forced)" : ""));
            this.a.playerController().processRightClick(this.a.player(), this.a.world(), ub.a);
            this.c = 10 * (1 + ek.a(this.a.player().co()).orElse(0));
            this.a = 10;
            this.b = true;
        }
    }

    public static boolean a(aip aip2) {
        if (aip2.c() != air.cm) {
            return false;
        }
        return (aip2 = aip2.d("Fireworks")) == null || !aip2.e("Explosions");
    }

    private static boolean b(aip aip2) {
        return ek.a(aip2).isPresent();
    }

    private static OptionalInt a(aip aip2) {
        if (ek.a(aip2) && (aip2 = aip2.d("Fireworks")) != null && aip2.e("Flight")) {
            return OptionalInt.of(aip2.f("Flight"));
        }
        return OptionalInt.empty();
    }

    public final Optional<aem> a() {
        return this.a.world().e.stream().filter(vg2 -> vg2 instanceof aem).filter(vg2 -> Objects.equals(((fo)vg2).getBoostedEntity(), this.a.player())).map(vg2 -> (aem)vg2).findFirst();
    }

    private boolean a(h object, bhe object2, Double object3) {
        bhe bhe2 = ((h)object).a;
        boolean bl2 = ((h)object).a;
        if (!this.a(bhe2, (bhe)object2, bl2)) {
            return false;
        }
        if (object3 == null) {
            return true;
        }
        object = ((h)object).a.g(((Double)object3).doubleValue());
        double d2 = object2.b - bhe2.b;
        double d3 = object2.c - bhe2.c;
        double d4 = object2.d - bhe2.d;
        object2 = new double[]{((bhb)object).a, ((bhb)object).b, ((bhb)object).c, ((bhb)object).a, ((bhb)object).b, ((bhb)object).f, ((bhb)object).a, ((bhb)object).e, ((bhb)object).c, ((bhb)object).a, ((bhb)object).e, ((bhb)object).f, ((bhb)object).d, ((bhb)object).b, ((bhb)object).c, ((bhb)object).d, ((bhb)object).b, ((bhb)object).f, ((bhb)object).d, ((bhb)object).e, ((bhb)object).c, ((bhb)object).d, ((bhb)object).e, ((bhb)object).f};
        object = new double[]{((bhb)object).a + d2, ((bhb)object).b + d3, ((bhb)object).c + d4, ((bhb)object).a + d2, ((bhb)object).b + d3, ((bhb)object).f + d4, ((bhb)object).a + d2, ((bhb)object).e + d3, ((bhb)object).c + d4, ((bhb)object).a + d2, ((bhb)object).e + d3, ((bhb)object).f + d4, ((bhb)object).d + d2, ((bhb)object).b + d3, ((bhb)object).c + d4, ((bhb)object).d + d2, ((bhb)object).b + d3, ((bhb)object).f + d4, ((bhb)object).d + d2, ((bhb)object).e + d3, ((bhb)object).c + d4, ((bhb)object).d + d2, ((bhb)object).e + d3, ((bhb)object).f + d4};
        if (((Boolean)baritone.a.a().elytraRenderHitboxRaytraces.value).booleanValue()) {
            boolean bl3 = true;
            for (int i2 = 0; i2 < 8; ++i2) {
                bhe bhe3 = new bhe((double)object2[i2 * 3], (double)object2[i2 * 3 + 1], (double)object2[i2 * 3 + 2]);
                bhe bhe4 = new bhe((double)object[i2 * 3], (double)object[i2 * 3 + 1], (double)object[i2 * 3 + 2]);
                if (this.a(bhe3, bhe4, false)) continue;
                bl3 = false;
            }
            return bl3;
        }
        object3 = object;
        return NetherPathfinder.isVisibleMulti(this.a.a, NetherPathfinder.CACHE_MISS_SOLID, 8, (double[])object2, (double[])object3, false) == -1;
    }

    public final boolean a(bhe bhe2, bhe bhe3, boolean bl2) {
        if (!bl2) {
            bl2 = bhe2.equals((Object)bhe3) || this.a.a(bhe2, bhe3);
        } else {
            boolean bl3 = bl2 = this.a.world().a(bhe2, bhe3, false, false, false) == null;
        }
        if (((Boolean)baritone.a.a().elytraRenderRaytraces.value).booleanValue()) {
            (bl2 ? this.a : this.b).add(new Pair<bhe, bhe>(bhe2, bhe3));
        }
        return bl2;
    }

    private static FloatArrayList a(float f2, boolean bl2) {
        float f3;
        float f4 = bl2 ? -90.0f : Math.max(f2 - (float)((Integer)baritone.a.a().elytraPitchRange.value).intValue(), -89.0f);
        float f5 = bl2 ? 90.0f : Math.min(f2 + (float)((Integer)baritone.a.a().elytraPitchRange.value).intValue(), 89.0f);
        FloatArrayList floatArrayList = new FloatArrayList(e.c.b(f5 - f4) + 1);
        for (f3 = f2; f3 <= f5; f3 += 1.0f) {
            floatArrayList.add(f3);
        }
        for (f3 = f2 - 1.0f; f3 >= f4; f3 -= 1.0f) {
            floatArrayList.add(f3);
        }
        return floatArrayList;
    }

    private List<bhe> a(h h2, bhe bhe2, float f2, int n2, int n3, int n4) {
        ITickableAimProcessor iTickableAimProcessor = h2.a.fork();
        bhe bhe3 = h2.b;
        bhb bhb2 = h2.a;
        ArrayList<bhe> arrayList = new ArrayList<bhe>(n2 + 1);
        arrayList.add(bhe.a);
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2;
            double d3;
            double d4 = bhb2.a + (bhb2.d - bhb2.a) * 0.5;
            double d5 = bhb2.c + (bhb2.f - bhb2.c) * 0.5;
            if (baritone.ek$d.a(this.a, d4, bhb2.b, d5)) {
                return null;
            }
            if (bhe2.c() < 1.0) break;
            Rotation rotation = iTickableAimProcessor.nextRotation(RotationUtils.calcRotationFromVec3d(bhe.a, bhe2, this.a.playerRotations()).withPitch(f2));
            bhe bhe4 = RotationUtils.calcLookDirectionFromRotation(rotation);
            float f3 = rotation.getPitch();
            rotation = bhe4;
            double d6 = bhe3.b;
            double d7 = bhe3.c;
            double d8 = bhe3.d;
            float f4 = f3 * ((float)Math.PI / 180);
            double d9 = Math.sqrt(((bhe)rotation).b * ((bhe)rotation).b + ((bhe)rotation).d * ((bhe)rotation).d);
            double d10 = d6;
            double d11 = d8;
            double d12 = Math.sqrt(d10 * d10 + d11 * d11);
            double d13 = rotation.b();
            f3 = rk.b((float)f4);
            f3 = (float)((double)f3 * (double)f3 * Math.min(1.0, d13 / 0.4));
            d7 += -0.08 + (double)f3 * 0.06;
            if (d3 < 0.0 && d9 > 0.0) {
                d2 = d7 * -0.1 * (double)f3;
                d7 += d2;
                d6 += ((bhe)rotation).b * d2 / d9;
                d8 += ((bhe)rotation).d * d2 / d9;
            }
            if (f4 < 0.0f) {
                d2 = d12 * (double)(-rk.a((float)f4)) * 0.04;
                d7 += d2 * 3.2;
                d6 -= ((bhe)rotation).b * d2 / d9;
                d8 -= ((bhe)rotation).d * d2 / d9;
            }
            if (d9 > 0.0) {
                d6 += (((bhe)rotation).b / d9 * d12 - d6) * 0.1;
                d8 += (((bhe)rotation).d / d9 * d12 - d8) * 0.1;
            }
            bhe3 = new bhe(d6 *= (double)0.99f, d7 *= (double)0.98f, d8 *= (double)0.99f);
            bhe2 = bhe2.d(bhe3);
            rotation = bhb2.b(bhe3.b, bhe3.c, bhe3.d).g(0.01);
            int n5 = e.c.b(((bhb)rotation).d);
            int n6 = e.c.a(((bhb)rotation).b);
            int n7 = e.c.b(((bhb)rotation).e);
            int n8 = e.c.a(((bhb)rotation).c);
            int n9 = e.c.b(((bhb)rotation).f);
            for (int i3 = e.c.a(((bhb)rotation).a); i3 < n5; ++i3) {
                for (int i4 = n6; i4 < n7; ++i4) {
                    for (int i5 = n8; i5 < n9; ++i5) {
                        if (this.a(i3, i4, i5, h2.a)) continue;
                        return null;
                    }
                }
            }
            bhb2 = bhb2.a(bhe3);
            ArrayList<bhe> arrayList2 = arrayList;
            arrayList2.add(((bhe)arrayList2.get(arrayList.size() - 1)).e(bhe3));
            if (i2 < n4 || n3-- <= 0) continue;
            bhe3 = bhe3.b(bhe4.b * 0.1 + (bhe4.b * 1.5 - bhe3.b) * 0.5, bhe4.c * 0.1 + (bhe4.c * 1.5 - bhe3.c) * 0.5, bhe4.d * 0.1 + (bhe4.d * 1.5 - bhe3.d) * 0.5);
        }
        return arrayList;
    }

    private boolean a(int n2, int n3, int n4, boolean bl2) {
        if (bl2) {
            bcz bcz2 = this.a.a(n2, n3, n4).a();
            return bcz2 == bcz.a || bcz2 == bcz.i;
        }
        return !this.a.a(n2, n3, n4);
    }

    public final void a(int n2, int n3, afw afw2) {
        this.a.add(() -> this.a(n2, n3, 0, afw2));
    }

    public final int a() {
        fi fi2 = this.a.player().bv.a;
        for (int i2 = 0; i2 < fi2.size(); ++i2) {
            aip aip2 = (aip)fi2.get(i2);
            if (aip2.c() != air.cS || aip2.c().l() - aip2.i() <= (Integer)baritone.a.a().elytraMinimumDurability.value) continue;
            return i2;
        }
        return -1;
    }

    private /* synthetic */ void a(int n2, int n3, int n4, afw afw2) {
        this.a.playerController().windowClick(n2, n3, n4, afw2, (aed)this.a.player());
    }

    private static /* synthetic */ f a(b b2, c c2) {
        return (f)b2.apply(c2.a, c2.b, c2.c);
    }

    private static /* synthetic */ f b(b b2, c c2) {
        return (f)b2.apply(c2.a, c2.b, c2.c);
    }

    private /* synthetic */ f a(h object, bhe object2, int n2, FloatArrayList floatArrayList, int n3, int n4, int n5) {
        int n6 = n5;
        n5 = n4;
        n4 = n3;
        FloatListIterator floatListIterator = floatArrayList.iterator();
        int n7 = n2;
        Object bhe2 = object2;
        object2 = object;
        object = this;
        bhe bhe3 = bhe2.d(((h)object2).a);
        bhe bhe4 = bhe3.a();
        ArrayDeque<f> arrayDeque = new ArrayDeque<f>();
        while (floatListIterator.hasNext()) {
            float f2 = floatListIterator.nextFloat();
            List<bhe> list = super.a((h)object2, bhe3, f2, n4, n5, n6);
            if (list == null) continue;
            List<bhe> list2 = list;
            Object i2 = list2.get(list2.size() - 1);
            double d2 = bhe4.b(i2.a());
            if (((ek)object).a) {
                d2 = -bhe3.d(i2).b();
            }
            if ((i2 = (f)arrayDeque.peek()) != null && !(d2 > i2.a)) continue;
            arrayDeque.push(new f(f2, d2, list));
        }
        block1: for (f f2 : arrayDeque) {
            if (n7 < 2) {
                for (int i2 = f2.a.size() - 1; i2 > 0; --i2) {
                    if (!((ek)object).a(((h)object2).a.e((bhe)f2.a.get(i2)), (bhe)bhe2, ((h)object2).a)) continue block1;
                }
            } else if (!((ek)object).a(((h)object2).a.e((bhe)f2.a.get(f2.a.size() - 1)), (bhe)bhe2, ((h)object2).a)) continue;
            ((ek)object).c = (List<bhe>)f2.a;
            return f2;
        }
        return null;
    }

    private /* synthetic */ g b(h h2) {
        return this.a(h2);
    }

    public static final class d {
        private static final Long2ReferenceOpenHashMap<Boolean> a = new Long2ReferenceOpenHashMap();
        private static final Long2ReferenceOpenHashMap<Boolean> b = new Long2ReferenceOpenHashMap();

        public static void a() {
            if (a.size() > 4096) {
                a.clear();
            }
            if (b.size() > 4096) {
                b.clear();
            }
        }

        public static boolean a(ex ex2, double d2, double d3, double d4) {
            int n2 = e.c.a(d3 + 0.5);
            int n3 = e.c.a(d2 - 0.21000000834465027);
            int n4 = e.c.a(d4 - 0.21000000834465027);
            int n5 = e.c.a(d2 + 0.21000000834465027);
            int n6 = e.c.a(d4 + 0.21000000834465027);
            if (n3 == n5 && n4 == n6) {
                return baritone.ek$d.a(ex2, n3, n2, n4);
            }
            if (n3 == n5) {
                return baritone.ek$d.a(ex2, n3, n2, n4) || baritone.ek$d.a(ex2, n3, n2, n6);
            }
            if (n4 == n6) {
                return baritone.ek$d.a(ex2, n3, n2, n4) || baritone.ek$d.a(ex2, n5, n2, n4);
            }
            return baritone.ek$d.a(ex2, n3, n2, n6) || baritone.ek$d.a(ex2, n3, n2, n4) || baritone.ek$d.a(ex2, n5, n2, n4) || baritone.ek$d.a(ex2, n5, n2, n6);
        }

        private static boolean a(ex ex2, int n2, int n3, int n4) {
            long l2 = BetterBlockPos.serializeToLong(n2, n3, n4);
            Boolean bl2 = (Boolean)a.get(l2);
            if (bl2 == null) {
                bl2 = !baritone.ek$d.b(ex2, n2, n3, n4) && (baritone.ek$d.b(ex2, n2 - 1, n3, n4) || baritone.ek$d.b(ex2, n2 + 1, n3, n4) || baritone.ek$d.b(ex2, n2, n3, n4 - 1) || baritone.ek$d.b(ex2, n2, n3, n4 + 1));
                a.put(l2, (Object)bl2);
            }
            return bl2;
        }

        private static boolean b(ex ex2, int n2, int n3, int n4) {
            long l2 = BetterBlockPos.serializeToLong(n2, n3, n4);
            Boolean bl2 = (Boolean)b.get(l2);
            if (bl2 == null) {
                bl2 = !ex2.a(n2, n3, n4).l() && !ex2.a(n2, n3 + 1, n4).l();
                b.put(l2, (Object)bl2);
            }
            return bl2;
        }
    }

    static final class c {
        public final int a;
        public final int b;
        public final int c;

        public c(int n2, int n3, int n4) {
            this.a = n2;
            this.b = n3;
            this.c = n4;
        }
    }

    @FunctionalInterface
    static interface b<T> {
        public T apply(int var1, int var2, int var3);
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class g {
        public final h a;
        public final Rotation a;
        public final bhe a;
        public final boolean a;
        public final boolean b;

        public g(h h2, Rotation rotation, bhe bhe2, boolean bl2, boolean bl3) {
            this.a = h2;
            this.a = rotation;
            this.a = bhe2;
            this.a = bl2;
            this.b = bl3;
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static final class f {
        public final float a;
        public final double a;
        public final List<bhe> a;

        public f(float f2, double d2, List<bhe> list) {
            this.a = f2;
            this.a = d2;
            this.a = (float)list;
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class a {
        final Integer a;
        private final int b;
        final int a;

        public a(Integer n2, int n3) {
            this.a = n2;
            this.b = n3;
            this.a = n3 + 11;
        }

        public final boolean a() {
            return this.a != null;
        }

        public final int a() {
            if (this.a()) {
                return Math.max(0, this.b - this.a);
            }
            return 0;
        }

        public final boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || object.getClass() != a.class) {
                return false;
            }
            object = (a)object;
            if (!this.a() && !((a)object).a()) {
                return true;
            }
            return Objects.equals(this.a, ((a)object).a) && this.b == ((a)object).b && this.a == ((a)object).a;
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public final class h {
        public final el a;
        public final int a;
        public final bhe a;
        public final bhe b;
        public final bhb a;
        public final boolean a;
        public final a a;
        public final IAimProcessor a;
        private /* synthetic */ ek a;

        public h(ek ek2, boolean bl2) {
            Object object;
            this.a = ek2;
            this.a = ek2.a.a;
            this.a = ek2.a.c;
            this.a = ek2.a.playerFeetAsVec();
            this.b = ek2.a.playerMotion();
            this.a = ek2.a.player().bw();
            this.a = ek2.a.player().au();
            object = bl2 && ek2.b ? (Object)((object = ek2.a)[1] > object[0] ? Integer.valueOf(0) : null) : (Object)ek2.a().map(aem2 -> aem2.T).orElse(null);
            this.a = new a((Integer)object, ek2.c);
            object = ((ek)ek2).a.a.getAimProcessor().fork();
            if (bl2) {
                object.advance(1);
            }
            this.a = object;
        }

        public final boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || object.getClass() != h.class) {
                return false;
            }
            object = (h)object;
            return this.a == ((h)object).a && this.a == ((h)object).a && Objects.equals(this.a, ((h)object).a) && Objects.equals(this.b, ((h)object).b) && Objects.equals(this.a, ((h)object).a) && this.a == ((h)object).a && Objects.equals(this.a, ((h)object).a);
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public final class e {
        public el a;
        public boolean a;
        public boolean b;
        public int a;
        public int b;
        public int c;
        public /* synthetic */ ek a;

        public e(ek ek2) {
            this.a = ek2;
            this.a();
        }

        public final CompletableFuture<Void> a() {
            e e2 = this;
            return e2.a(e2.a.a.playerFeet());
        }

        public final CompletableFuture<Void> a(et et2) {
            long l2 = System.nanoTime();
            return ((CompletableFuture)this.a(et2, this.a.b, UnaryOperator.identity()).thenRun(() -> {
                double d2 = this.a.a(0).distanceTo(this.a.a(this.a.size() - 1));
                if (this.a) {
                    this.a.logDirect(String.format("Computed path (%.1f blocks in %.4f seconds)", d2, (double)(System.nanoTime() - l2) / 1.0E9));
                    return;
                }
                this.a.logDirect(String.format("Computed segment (Next %.1f blocks in %.4f seconds)", d2, (double)(System.nanoTime() - l2) / 1.0E9));
            })).whenComplete((object, throwable) -> {
                this.b = false;
                if (throwable != null) {
                    object = throwable.getCause();
                    if (object instanceof eo) {
                        this.a.logDirect("Failed to compute path to destination");
                        return;
                    }
                    this.a.logUnhandledException((Throwable)object);
                }
            });
        }

        private CompletableFuture<Void> a(int n2) {
            if (this.b) {
                throw new IllegalStateException("already recalculating");
            }
            this.b = true;
            List list = this.a.subList(n2 + 1, this.a.size());
            boolean bl2 = this.a;
            e e2 = this;
            return e2.a((et)e2.a.a.playerFeet(), this.a.a(n2), ep2 -> {
                boolean bl3 = bl2;
                Stream stream = list.stream();
                list = ep2;
                return new ep(Stream.concat(((ep)object).a, stream), bl3);
            }).whenComplete((object, throwable) -> {
                this.b = false;
                if (throwable != null) {
                    object = throwable.getCause();
                    if (object instanceof eo) {
                        this.a.logDirect("Failed to recompute segment");
                        return;
                    }
                    this.a.logUnhandledException((Throwable)object);
                }
            });
        }

        public final void a(int n2) {
            if (this.b) {
                return;
            }
            this.b = true;
            List list = this.a.subList(0, n2 + 1);
            long l2 = System.nanoTime();
            BetterBlockPos betterBlockPos = this.a.a(n2);
            ((CompletableFuture)this.a((et)betterBlockPos, this.a.b, object2 -> {
                ep ep2 = object2;
                object2 = list.stream();
                list = ep2;
                return new ep(Stream.concat(object2, ((ep)object).a), ((ep)object).a);
            }).thenRun(() -> {
                int n2 = this.a.size() - list.size() - 1;
                double d2 = this.a.a(0).distanceTo(this.a.a(n2));
                if (this.a) {
                    this.a.logDirect(String.format("Computed path (%.1f blocks in %.4f seconds)", d2, (double)(System.nanoTime() - l2) / 1.0E9));
                    return;
                }
                this.a.logDirect(String.format("Computed segment (Next %.1f blocks in %.4f seconds)", d2, (double)(System.nanoTime() - l2) / 1.0E9));
            })).whenComplete((object, throwable) -> {
                this.b = false;
                if (throwable != null) {
                    object = throwable.getCause();
                    if (object instanceof eo) {
                        this.a.logDirect("Failed to compute next segment");
                        if (this.a.a.player().c((et)betterBlockPos) < 256.0) {
                            this.a.logDirect("Player is near the segment start, therefore repeating this calculation is pointless. Marking as complete");
                            this.a = true;
                            return;
                        }
                    } else {
                        this.a.logUnhandledException((Throwable)object);
                    }
                }
            });
        }

        public final void a() {
            this.a = el.a();
            this.a = true;
            this.b = false;
            this.c = 0;
            this.b = 0;
            this.a = 0;
        }

        private void a(ep ep2) {
            List<BetterBlockPos> list = ep2.a.collect(Collectors.toList());
            et et2 = new HashMap();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                BetterBlockPos betterBlockPos = (BetterBlockPos)((Object)list.get(i2));
                if (et2.containsKey((Object)betterBlockPos)) {
                    int n2 = (Integer)et2.get((Object)betterBlockPos);
                    while (i2 > n2) {
                        list.remove(i2);
                        --i2;
                    }
                    continue;
                }
                et2.put(betterBlockPos, i2);
            }
            if (this.a.d) {
                et et3;
                et et4;
                et2 = this.a.b;
                if (!list.isEmpty()) {
                    List<BetterBlockPos> list2 = list;
                    et4 = list2.get(list2.size() - 1);
                } else {
                    et4 = et3 = null;
                }
                if (et4 != null && this.a.a(new bhe((fq)et2), new bhe((fq)et3), false)) {
                    list.add(new BetterBlockPos(et2));
                } else {
                    this.a.logDirect("unable to land at " + this.a.b);
                    this.a.a.a(new BetterBlockPos(this.a.b));
                }
            }
            this.a = new el(list);
            this.a = ep2.a;
            this.c = 0;
            this.b = 0;
            this.a = 0;
        }

        private CompletableFuture<Void> a(et et2, et et3, UnaryOperator<ep> unaryOperator) {
            return ((CompletableFuture)((CompletableFuture)this.a.a.a(et2, et3).thenApply(ep::a)).thenApply(unaryOperator)).thenAcceptAsync(this::a, arg_0 -> ((bib)this.a.a.minecraft()).a(arg_0));
        }

        public final void b() {
            int n2;
            if (this.b) {
                return;
            }
            int n3 = this.c;
            for (n2 = this.c; n2 < this.a.size() && this.a.a.world().a((et)this.a.a(n2), false); ++n2) {
            }
            if (n3 >= n2) {
                return;
            }
            BetterBlockPos betterBlockPos = this.a.a(n3);
            if (!this.a.a(betterBlockPos.a, betterBlockPos.b, betterBlockPos.c, false)) {
                return;
            }
            if (((ek)this.a).a.a != dw.a.f && this.b > 100) {
                this.a(n2 - 1).thenRun(() -> this.a.logDirect("Recalculating segment, no progress in last 100 ticks"));
                this.b = 0;
                return;
            }
            boolean bl2 = false;
            for (int i2 = n3; i2 < n2 - 1; ++i2) {
                if (this.a.a(this.a.a.playerFeetAsVec(), this.a.a(i2), false) || this.a.a(this.a.a.playerHead(), this.a.a(i2), false)) {
                    bl2 = true;
                }
                if (this.a.a(this.a.a(i2), this.a.a(i2 + 1), false)) continue;
                BetterBlockPos betterBlockPos2 = this.a.a(i2);
                double d2 = this.a.a.playerFeet().distanceTo(this.a.a(n2 - 1));
                long l2 = System.nanoTime();
                this.a(n2 - 1).thenRun(() -> this.a.logDirect(String.format("Recalculated segment around path blockage near %s %s %s (next %.1f blocks in %.4f seconds)", SettingsUtil.maybeCensor(betterBlockPos.a), SettingsUtil.maybeCensor(betterBlockPos.b), SettingsUtil.maybeCensor(betterBlockPos.c), d2, (double)(System.nanoTime() - l2) / 1.0E9)));
                return;
            }
            if (!bl2 && n3 < n2 - 2 && ((ek)this.a).a.a != dw.a.c) {
                this.a(n2 - 1).thenRun(() -> this.a.logDirect("Recalculated segment since no path points were visible"));
            }
        }

        public final void c() {
            int n2;
            if (this.a.isEmpty()) {
                return;
            }
            int n3 = this.c;
            BetterBlockPos betterBlockPos = this.a.a.playerFeet();
            for (n2 = n3; n2 >= Math.max(n3 - 1000, 0); n2 -= 10) {
                if (!(this.a.a(n2).distanceSq(betterBlockPos) < this.a.a(n3).distanceSq(betterBlockPos))) continue;
                n3 = n2;
            }
            for (n2 = n3; n2 < Math.min(n3 + 1000, this.a.size()); n2 += 10) {
                if (!(this.a.a(n2).distanceSq(betterBlockPos) < this.a.a(n3).distanceSq(betterBlockPos))) continue;
                n3 = n2;
            }
            for (n2 = n3; n2 >= Math.max(n3 - 50, 0); --n2) {
                if (!(this.a.a(n2).distanceSq(betterBlockPos) < this.a.a(n3).distanceSq(betterBlockPos))) continue;
                n3 = n2;
            }
            for (n2 = n3; n2 < Math.min(n3 + 50, this.a.size()); ++n2) {
                if (!(this.a.a(n2).distanceSq(betterBlockPos) < this.a.a(n3).distanceSq(betterBlockPos))) continue;
                n3 = n2;
            }
            this.c = n3;
        }
    }
}

