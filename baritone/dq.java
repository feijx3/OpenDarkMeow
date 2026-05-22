/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ahb
 *  aip
 *  amy
 *  aom
 *  aox
 *  arm
 *  aru
 *  arv
 *  atl
 *  aud
 *  auo
 *  aur
 *  auu
 *  awt
 *  axj
 *  bhc
 *  bhc$a
 *  bhe
 *  com.google.common.collect.ImmutableSet
 *  et
 *  fa
 *  fq
 *  gi
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  rr
 *  vg
 *  vp
 */
package baritone;

import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalComposite;
import baritone.api.pathing.goals.GoalGetToBlock;
import baritone.api.process.IBuilderProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.schematic.FillSchematic;
import baritone.api.schematic.ISchematic;
import baritone.api.schematic.IStaticSchematic;
import baritone.api.schematic.SubstituteSchematic;
import baritone.api.schematic.format.ISchematicFormat;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.ca;
import baritone.cb;
import baritone.dr;
import baritone.ds;
import baritone.dt;
import baritone.eu;
import baritone.ex;
import baritone.fd;
import baritone.fu;
import baritone.gb;
import baritone.gc;
import baritone.gd;
import baritone.gj;
import baritone.utils.schematic.litematica.LitematicaHelper;
import baritone.utils.schematic.schematica.SchematicaHelper;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dq
extends eu
implements IBuilderProcess {
    private HashSet<BetterBlockPos> a;
    private LongOpenHashSet a;
    private String a;
    private ISchematic b;
    public ISchematic a;
    public fq a;
    private int a;
    private boolean a;
    private int b;
    private int c;
    public List<awt> a;
    private int d = 0;
    private static Set<axj<?>> a;

    public dq(baritone.a a2) {
        super(a2);
    }

    @Override
    public final void build(String string, ISchematic iSchematic, fq fq2) {
        this.a = string;
        this.a = iSchematic;
        this.b = null;
        boolean bl2 = iSchematic instanceof gd;
        if (!((Map)baritone.a.a().buildSubstitutes.value).isEmpty()) {
            this.a = new SubstituteSchematic(this.a, (Map)baritone.a.a().buildSubstitutes.value);
        }
        int n2 = fq2.p();
        int n3 = fq2.q();
        int n4 = fq2.r();
        if (((Boolean)baritone.a.a().schematicOrientationX.value).booleanValue()) {
            n2 += iSchematic.widthX();
        }
        if (((Boolean)baritone.a.a().schematicOrientationY.value).booleanValue()) {
            n3 += iSchematic.heightY();
        }
        if (((Boolean)baritone.a.a().schematicOrientationZ.value).booleanValue()) {
            n4 += iSchematic.lengthZ();
        }
        this.a = new fq(n2, n3, n4);
        this.a = false;
        this.b = (Integer)baritone.a.a().startAtLayer.value;
        this.d = iSchematic.heightY();
        if (((Boolean)baritone.a.a().buildOnlySelection.value).booleanValue() && bl2) {
            if (((baritone.a)((Object)this.a)).a.getSelections().length == 0) {
                this.logDirect("Poor little kitten forgot to set a selection while BuildOnlySelection is true");
                this.d = 0;
            } else if (((Boolean)baritone.a.a().buildInLayers.value).booleanValue()) {
                OptionalInt optionalInt = Stream.of(((baritone.a)((Object)this.a)).a.getSelections()).mapToInt(iSelection -> iSelection.min().b).min();
                OptionalInt optionalInt2 = Stream.of(((baritone.a)((Object)this.a)).a.getSelections()).mapToInt(iSelection -> iSelection.max().b).max();
                if (optionalInt.isPresent() && optionalInt2.isPresent()) {
                    n2 = (Boolean)baritone.a.a().layerOrder.value != false ? n3 + iSchematic.heightY() - optionalInt2.getAsInt() : optionalInt.getAsInt() - n3;
                    this.d = ((Boolean)baritone.a.a().layerOrder.value != false ? n3 + iSchematic.heightY() - optionalInt.getAsInt() : optionalInt2.getAsInt() - n3) + 1;
                    this.b = Math.max(this.b, n2 / (Integer)baritone.a.a().layerHeight.value);
                    this.logDebug(String.format("Schematic starts at y=%s with height %s", n3, iSchematic.heightY()));
                    this.logDebug(String.format("Selection starts at y=%s and ends at y=%s", optionalInt.getAsInt(), optionalInt2.getAsInt()));
                    this.logDebug(String.format("Considering relevant height %s - %s", n2, this.d));
                }
            }
        }
        this.c = 0;
        this.a = new LongOpenHashSet();
        this.a = null;
    }

    @Override
    public final void resume() {
        this.a = false;
    }

    @Override
    public final void pause() {
        this.a = true;
    }

    @Override
    public final boolean isPaused() {
        return this.a;
    }

    @Override
    public final boolean build(String string, File object, fq fq2) {
        Optional<ISchematicFormat> optional = gc.a.getByFile((File)object);
        if (!optional.isPresent()) {
            return false;
        }
        try {
            object = optional.get().parse(new FileInputStream((File)object));
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        object = this.a(fq2, (IStaticSchematic)object);
        this.build(string, (ISchematic)object, fq2);
        return true;
    }

    private ISchematic a(fq fq2, IStaticSchematic iStaticSchematic) {
        ISchematic iSchematic = iStaticSchematic;
        if (((Boolean)baritone.a.a().mapArtMode.value).booleanValue()) {
            iSchematic = new gb(iStaticSchematic);
        }
        if (((Boolean)baritone.a.a().buildOnlySelection.value).booleanValue()) {
            iSchematic = new gd(iSchematic, fq2, ((baritone.a)((Object)this.a)).a.getSelections());
        }
        return iSchematic;
    }

    @Override
    public final void buildOpenSchematic() {
        if (SchematicaHelper.a()) {
            Optional<rr<IStaticSchematic, et>> optional = SchematicaHelper.a();
            if (optional.isPresent()) {
                ISchematic iSchematic = (IStaticSchematic)optional.get().a();
                et et2 = (et)optional.get().b();
                ISchematic iSchematic2 = iSchematic = (Boolean)baritone.a.a().mapArtMode.value != false ? new gb((IStaticSchematic)iSchematic) : iSchematic;
                if (((Boolean)baritone.a.a().buildOnlySelection.value).booleanValue()) {
                    iSchematic = new gd(iSchematic, (fq)et2, ((baritone.a)((Object)this.a)).a.getSelections());
                }
                this.build(((IStaticSchematic)optional.get().a()).toString(), iSchematic, (fq)et2);
                return;
            }
            this.logDirect("No schematic currently open");
            return;
        }
        this.logDirect("Schematica is not present");
    }

    @Override
    public final void buildOpenLitematic(int n2) {
        if (LitematicaHelper.a()) {
            if (LitematicaHelper.b()) {
                String string = LitematicaHelper.a(n2);
                try {
                    gj gj2 = new gj(gi.a((InputStream)Files.newInputStream(LitematicaHelper.a(n2).toPath(), new OpenOption[0])), false);
                    fq fq2 = LitematicaHelper.a(gj2, n2);
                    ISchematic iSchematic = LitematicaHelper.a(gj2, n2);
                    dq dq2 = this;
                    iSchematic = dq2.a(dq2.a, (IStaticSchematic)iSchematic);
                    this.build(string, iSchematic, fq2);
                    return;
                }
                catch (IOException iOException) {
                    this.logDirect("Schematic File could not be loaded.");
                    return;
                }
            }
            this.logDirect("No schematic currently loaded");
            return;
        }
        this.logDirect("Litematica is not present");
    }

    @Override
    public final void clearArea(et et2, et et3) {
        et et4 = new et(Math.min(et2.p(), et3.p()), Math.min(et2.q(), et3.q()), Math.min(et2.r(), et3.r()));
        int n2 = Math.abs(et2.p() - et3.p()) + 1;
        int n3 = Math.abs(et2.q() - et3.q()) + 1;
        int n4 = Math.abs(et2.r() - et3.r()) + 1;
        this.build("clear area", new FillSchematic(n2, n3, n4, aox.a.t()), (fq)et4);
    }

    @Override
    public final List<awt> getApproxPlaceable() {
        return new ArrayList<BetterBlockPos>(this.a);
    }

    @Override
    public final boolean isActive() {
        return this.a != null;
    }

    private Optional<rr<BetterBlockPos, Rotation>> a(a a2) {
        BetterBlockPos betterBlockPos = this.a.playerFeet();
        BetterBlockPos betterBlockPos2 = ((baritone.a)((Object)this.a)).a.a();
        for (int i2 = -5; i2 <= 5; ++i2) {
            int n2;
            int n3 = n2 = (Boolean)baritone.a.a().breakFromAbove.value != false ? -1 : 0;
            while (n2 <= 5) {
                for (int i3 = -5; i3 <= 5; ++i3) {
                    BetterBlockPos betterBlockPos3;
                    Optional<Rotation> optional;
                    awt awt2;
                    awt awt3;
                    int n4 = betterBlockPos.a + i2;
                    int n5 = betterBlockPos.b + n2;
                    int n6 = betterBlockPos.c + i3;
                    if (n2 == -1 && n4 == betterBlockPos2.a && n6 == betterBlockPos2.c || (awt3 = a2.a(n4, n5, n6, ((ex)((Object)a2.a)).a(n4, n5, n6))) == null || (awt2 = ((ex)((Object)a2.a)).a(n4, n5, n6)).u() == aox.a || awt2.u() instanceof aru || dq.a(awt2, awt3, false) || !(optional = RotationUtils.reachable(this.a, (et)(betterBlockPos3 = new BetterBlockPos(n4, n5, n6)), this.a.playerController().getBlockReachDistance())).isPresent()) continue;
                    return Optional.of(new rr((Object)betterBlockPos3, (Object)optional.get()));
                }
                ++n2;
            }
        }
        return Optional.empty();
    }

    private Optional<f> a(a a2, List<awt> list) {
        BetterBlockPos betterBlockPos = this.a.playerFeet();
        for (int i2 = -5; i2 <= 5; ++i2) {
            for (int i3 = -5; i3 <= 1; ++i3) {
                for (int i4 = -5; i4 <= 5; ++i4) {
                    Object object;
                    Object object2;
                    block10: {
                        awt awt2;
                        int n2 = betterBlockPos.a + i2;
                        int n3 = betterBlockPos.b + i3;
                        int n4 = betterBlockPos.c + i4;
                        awt awt3 = a2.a(n2, n3, n4, ((ex)((Object)a2.a)).a(n2, n3, n4));
                        if (awt3 == null || !cb.a(n2, n4, awt2 = ((ex)((Object)a2.a)).a(n2, n3, n4), (ex)((Object)a2.a)) || dq.a(awt2, awt3, false) || i3 == 1 && ((ex)((Object)a2.a)).a(n2, n3 + 1, n4).u() == aox.a) continue;
                        list.add(awt3);
                        ISchematic iSchematic = a2.a;
                        int n5 = n4;
                        int n6 = n3;
                        n4 = n2;
                        awt awt4 = awt3;
                        object2 = this;
                        for (bhe[] bheArray : fa.values()) {
                            bhe[] bheArray2;
                            BetterBlockPos betterBlockPos2 = new BetterBlockPos(n4, n6, n5).offset((fa)bheArray);
                            awt awt5 = ((ex)((Object)iSchematic)).a(betterBlockPos2);
                            if (cb.a(betterBlockPos2.a, betterBlockPos2.c, awt5, (ex)((Object)iSchematic)) || !((dq)object2).a.world().a(awt4.u(), (et)new BetterBlockPos(n4, n6, n5), false, (fa)bheArray, null)) continue;
                            awt5 = awt5.e((amy)((dq)object2).a.world(), (et)betterBlockPos2);
                            bhe[] bheArray3 = bheArray;
                            switch (dt.a[bheArray3.ordinal()]) {
                                case 1: {
                                    bhe[] bheArray4 = new bhe[5];
                                    bheArray4[0] = new bhe(0.5, 1.0, 0.5);
                                    bheArray4[1] = new bhe(0.1, 1.0, 0.5);
                                    bheArray4[2] = new bhe(0.9, 1.0, 0.5);
                                    bheArray4[3] = new bhe(0.5, 1.0, 0.1);
                                    bheArray2 = bheArray4;
                                    bheArray4[4] = new bhe(0.5, 1.0, 0.9);
                                    break;
                                }
                                case 2: {
                                    bhe[] bheArray5 = new bhe[5];
                                    bheArray5[0] = new bhe(0.5, 0.0, 0.5);
                                    bheArray5[1] = new bhe(0.1, 0.0, 0.5);
                                    bheArray5[2] = new bhe(0.9, 0.0, 0.5);
                                    bheArray5[3] = new bhe(0.5, 0.0, 0.1);
                                    bheArray2 = bheArray5;
                                    bheArray5[4] = new bhe(0.5, 0.0, 0.9);
                                    break;
                                }
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: {
                                    double d2 = bheArray3.g() == 0 ? 0.5 : (double)(1 + bheArray3.g()) / 2.0;
                                    double d3 = bheArray3.i() == 0 ? 0.5 : (double)(1 + bheArray3.i()) / 2.0;
                                    bhe[] bheArray6 = new bhe[2];
                                    bheArray6[0] = new bhe(d2, 0.25, d3);
                                    bheArray2 = bheArray6;
                                    bheArray6[1] = new bhe(d2, 0.75, d3);
                                    break;
                                }
                                default: {
                                    throw new IllegalStateException();
                                }
                            }
                            bheArray3 = bheArray2;
                            int n7 = bheArray2.length;
                            for (int i5 = 0; i5 < n7; ++i5) {
                                Object object3 = bheArray3[i5];
                                double d4 = (double)betterBlockPos2.a + awt5.a * object3.b + awt5.d * (1.0 - object3.b);
                                double d5 = (double)betterBlockPos2.b + awt5.b * object3.c + awt5.e * (1.0 - object3.c);
                                double d6 = (double)betterBlockPos2.c + awt5.c * object3.d + awt5.f * (1.0 - object3.d);
                                object3 = RotationUtils.calcRotationFromVec3d(RayTraceUtils.inferSneakingEyePosition((vg)((dq)object2).a.player()), new bhe(d4, d5, d6), ((dq)object2).a.playerRotations());
                                Object object4 = ((baritone.a)((Object)((dq)object2).a)).a.getAimProcessor().peekRotation((Rotation)object3);
                                bhc bhc2 = RayTraceUtils.rayTraceTowards((vg)((dq)object2).a.player(), (Rotation)object4, ((dq)object2).a.playerController().getBlockReachDistance(), true);
                                if (bhc2 == null || bhc2.a != bhc.a.b || !bhc2.a().equals((Object)betterBlockPos2) || bhc2.b != bheArray.d() || !((OptionalInt)(object4 = super.a(awt4, bhc2, (Rotation)object4))).isPresent()) continue;
                                object = Optional.of(new f(((OptionalInt)object4).getAsInt(), betterBlockPos2, bheArray.d(), (Rotation)object3));
                                break block10;
                            }
                        }
                        object = object2 = Optional.empty();
                    }
                    if (!((Optional)object).isPresent()) continue;
                    return object2;
                }
            }
        }
        return Optional.empty();
    }

    private OptionalInt a(awt awt2, bhc bhc2, Rotation rotation) {
        for (int i2 = 0; i2 < 9; ++i2) {
            aip aip2 = (aip)this.a.player().bv.a.get(i2);
            if (aip2.b() || !(aip2.c() instanceof ahb)) continue;
            float f2 = this.a.player().v;
            float f3 = this.a.player().w;
            this.a.player().v = rotation.getYaw();
            this.a.player().w = rotation.getPitch();
            aip2 = ((ahb)aip2.c()).d().a(this.a.world(), bhc2.a().a(bhc2.b), bhc2.b, (float)bhc2.c.b - (float)bhc2.a().p(), (float)bhc2.c.c - (float)bhc2.a().q(), (float)bhc2.c.d - (float)bhc2.a().r(), aip2.c().a(aip2.j()), (vp)this.a.player());
            this.a.player().v = f2;
            this.a.player().w = f3;
            if (!dq.a((awt)aip2, awt2, true)) continue;
            return OptionalInt.of(i2);
        }
        return OptionalInt.empty();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public final PathingCommand onTick(boolean var1_1, boolean var2_3) {
        block27: {
            var3_4 = 0;
            var1_2 = this;
            while (true) {
                block28: {
                    if (var3_4 > 1000) {
                        return new PathingCommand(null, PathingCommandType.SET_GOAL_AND_PATH);
                    }
                    var1_2.a = var1_2.a(36);
                    var1_2.a = var1_2.a.a.isInputForcedDown(Input.CLICK_LEFT) ? 5 : --var1_2.a;
                    var1_2.a.a.clearAllKeys();
                    if (var1_2.a) {
                        return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
                    }
                    if (((Boolean)baritone.a.a().buildInLayers.value).booleanValue()) {
                        if (var1_2.b == null) {
                            var1_2.b = var1_2.a;
                        }
                        var4_5 = var1_2.b;
                        if (((Boolean)baritone.a.a().layerOrder.value).booleanValue()) {
                            var6_8 = var4_5.heightY() - 1;
                            var5_7 = var4_5.heightY() - var1_2.b * (Integer)baritone.a.a().layerHeight.value;
                        } else {
                            var6_8 = var1_2.b * (Integer)baritone.a.a().layerHeight.value - 1;
                            var5_7 = 0;
                        }
                        var1_2.a = new dr(var1_2, (ISchematic)var4_5, var5_7, var6_8);
                    }
                    var4_5 = new a(var1_2);
                    var6_9 = var4_5;
                    var5_6 = var1_2;
                    if (var5_6.a != null) break block28;
                    var5_6.a = new HashSet<E>();
                    var5_6.b((a)var6_9);
                    if (var5_6.a.isEmpty()) ** GOTO lbl-1000
                }
                var5_6.a((a)var6_9);
                if (var5_6.a.isEmpty()) {
                    var5_6.b((a)var6_9);
                }
                if (!var5_6.a.isEmpty()) {
                    v0 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v0 = false;
                }
                if (!v0) {
                    if (((Boolean)baritone.a.a().buildInLayers.value).booleanValue() && var1_2.b * (Integer)baritone.a.a().layerHeight.value < var1_2.d) {
                        var1_2.logDirect("Starting layer " + var1_2.b);
                        ++var1_2.b;
                        ++var3_4;
                        continue;
                    }
                    var5_6 = (fq)baritone.a.a().buildRepeat.value;
                    var6_10 = (Integer)baritone.a.a().buildRepeatCount.value;
                    ++var1_2.c;
                    if (var5_6.equals((Object)new fq(0, 0, 0)) || var6_10 != -1 && var1_2.c >= var6_10) {
                        var1_2.logDirect("Done building");
                        if (((Boolean)baritone.a.a().notificationOnBuildFinished.value).booleanValue()) {
                            var1_2.logNotification("Done building", false);
                        }
                        var1_2.onLostControl();
                        return null;
                    }
                    var1_2.b = 0;
                    var1_2.a = new et(var1_2.a).a((fq)var5_6);
                    if (!((Boolean)baritone.a.a().buildRepeatSneaky.value).booleanValue()) {
                        var1_2.a.reset();
                    }
                    var1_2.logDirect("Repeating build in vector " + var5_6 + ", new origin is " + var1_2.a);
                    ++var3_4;
                    continue;
                }
                if (((Boolean)baritone.a.a().distanceTrim.value).booleanValue()) {
                    var5_6 = var1_2;
                    var6_9 = new HashSet<BetterBlockPos>(var5_6.a);
                    var6_9.removeIf((Predicate<BetterBlockPos>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(baritone.api.utils.BetterBlockPos ), (Lbaritone/api/utils/BetterBlockPos;)Z)((dq)var5_6));
                    if (!var6_9.isEmpty()) {
                        var5_6.a = var6_9;
                    }
                }
                if ((var5_6 = var1_2.a((a)var4_5)).isPresent() && var2_3 && var1_2.a.player().z) {
                    var6_9 = (Rotation)((rr)var5_6.get()).b();
                    var5_6 = (BetterBlockPos)((rr)var5_6.get()).a();
                    var1_2.a.a.updateTarget((Rotation)var6_9, true);
                    cb.a(var1_2.a, var4_5.a((et)var5_6));
                    if (var1_2.a.player().aU()) {
                        var1_2.a.a.setInputForceState(Input.SNEAK, true);
                    }
                    if (var1_2.a.isLookingAt((et)var5_6) || var1_2.a.playerRotations().isReallyCloseTo((Rotation)var6_9)) {
                        var1_2.a.a.setInputForceState(Input.CLICK_LEFT, true);
                    }
                    return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
                }
                var6_9 = new ArrayList<E>();
                var5_6 = var1_2.a((a)var4_5, (List<awt>)var6_9);
                if (var5_6.isPresent() && var2_3 && var1_2.a.player().z && var1_2.a <= 0) {
                    var7_12 = ((f)var5_6.get()).a;
                    var1_2.a.a.updateTarget((Rotation)var7_12, true);
                    var1_2.a.player().bv.d = ((f)var5_6.get()).a;
                    var1_2.a.a.setInputForceState(Input.SNEAK, true);
                    if (var1_2.a.isLookingAt(((f)var5_6.get()).a) && var1_2.a.objectMouseOver().b.equals((Object)((f)var5_6.get()).a) || var1_2.a.playerRotations().isReallyCloseTo((Rotation)var7_12)) {
                        var1_2.a.a.setInputForceState(Input.CLICK_RIGHT, true);
                    }
                    return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
                }
                if (((Boolean)baritone.a.a().allowInventory.value).booleanValue()) {
                    var7_12 = new ArrayList<E>();
                    var5_6 = new ArrayList<E>();
                    var6_9 = var6_9.iterator();
                    block1: while (var6_9.hasNext()) {
                        var8_13 = (awt)var6_9.next();
                        for (var9_14 = 0; var9_14 < 9; ++var9_14) {
                            if (!dq.a((awt)var1_2.a.get(var9_14), (awt)var8_13, true)) continue;
                            var7_12.add(var9_14);
                            continue block1;
                        }
                        var5_6.add(var8_13);
                    }
                    block3: for (var6_11 = 9; var6_11 < 36; ++var6_11) {
                        var8_13 = var5_6.iterator();
                        while (var8_13.hasNext()) {
                            var9_15 = (awt)var8_13.next();
                            if (!dq.a((awt)var1_2.a.get(var6_11), var9_15, true)) continue;
                            if (var1_2.a.a.a(var6_11, (Predicate<Integer>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, contains(java.lang.Object ), (Ljava/lang/Integer;)Z)((ArrayList)var7_12))) break block3;
                            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
                        }
                    }
                }
                if ((var7_12 = var1_2.a((a)var4_5, var1_2.a.subList(0, 9), false)) != null || (var7_12 = var1_2.a((a)var4_5, (List<awt>)var1_2.a, true)) != null) break block27;
                if (!((Boolean)baritone.a.a().skipFailedLayers.value).booleanValue() || !((Boolean)baritone.a.a().buildInLayers.value).booleanValue() || var1_2.b * (Integer)baritone.a.a().layerHeight.value >= var1_2.b.heightY()) break;
                var1_2.logDirect("Skipping layer that I cannot construct! Layer #" + var1_2.b);
                ++var1_2.b;
                ++var3_4;
            }
            var1_2.logDirect("Unable to do it. Pausing. resume to resume, cancel to cancel");
            var1_2.a = true;
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        return new fd((Goal)var7_12, PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH, (bz)var4_5);
    }

    private void a(a a2) {
        BetterBlockPos betterBlockPos = this.a.playerFeet();
        int n2 = (Integer)baritone.a.a().builderTickScanRadius.value;
        for (int i2 = -n2; i2 <= n2; ++i2) {
            for (int i3 = -n2; i3 <= n2; ++i3) {
                for (int i4 = -n2; i4 <= n2; ++i4) {
                    int n3 = betterBlockPos.a + i2;
                    int n4 = betterBlockPos.b + i3;
                    int n5 = betterBlockPos.c + i4;
                    awt awt2 = a2.a(n3, n4, n5, ((ex)((Object)a2.a)).a(n3, n4, n5));
                    if (awt2 == null) continue;
                    BetterBlockPos betterBlockPos2 = new BetterBlockPos(n3, n4, n5);
                    if (dq.a(((ex)((Object)a2.a)).a(n3, n4, n5), awt2, false)) {
                        this.a.remove((Object)betterBlockPos2);
                        this.a.add(BetterBlockPos.longHash(betterBlockPos2));
                        continue;
                    }
                    this.a.add(betterBlockPos2);
                    this.a.remove(BetterBlockPos.longHash(betterBlockPos2));
                }
            }
        }
    }

    private void b(a a2) {
        this.a = new HashSet();
        for (int i2 = 0; i2 < this.a.heightY(); ++i2) {
            for (int i3 = 0; i3 < this.a.lengthZ(); ++i3) {
                for (int i4 = 0; i4 < this.a.widthX(); ++i4) {
                    int n2;
                    int n3;
                    int n4 = i4 + this.a.p();
                    awt awt2 = ((ex)((Object)a2.a)).a(n4, n3 = i2 + this.a.q(), n2 = i3 + this.a.r());
                    if (!this.a.inSchematic(i4, i2, i3, awt2)) continue;
                    if (((ex)((Object)a2.a)).a(n4, n2)) {
                        if (dq.a(((ex)((Object)a2.a)).a(n4, n3, n2), this.a.desiredState(i4, i2, i3, awt2, (List<awt>)((Object)this.a)), false)) {
                            this.a.add(BetterBlockPos.longHash(n4, n3, n2));
                            continue;
                        }
                        this.a.add(new BetterBlockPos(n4, n3, n2));
                        this.a.remove(BetterBlockPos.longHash(n4, n3, n2));
                        if (this.a.size() <= (Integer)baritone.a.a().incorrectSize.value) continue;
                        return;
                    }
                    if (this.a.contains(BetterBlockPos.longHash(n4, n3, n2)) || ((List)baritone.a.a().buildSkipBlocks.value).contains(this.a.desiredState(i4, i2, i3, awt2, (List<awt>)((Object)this.a)).u())) continue;
                    this.a.add(new BetterBlockPos(n4, n3, n2));
                    if (this.a.size() <= (Integer)baritone.a.a().incorrectSize.value) continue;
                    return;
                }
            }
        }
    }

    private Goal a(a a2, List<awt> list, boolean bl2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap = new HashMap();
        this.a.forEach(betterBlockPos -> {
            awt awt2 = ((ex)((Object)a2.a)).a((et)betterBlockPos);
            if (awt2.u() instanceof aom) {
                boolean bl2;
                block5: {
                    arrayList4 = a2.a(betterBlockPos.a, betterBlockPos.b, betterBlockPos.c, awt2);
                    list = list.iterator();
                    while (list.hasNext()) {
                        if (!dq.b((awt)list.next(), (awt)arrayList4)) continue;
                        bl2 = true;
                        break block5;
                    }
                    bl2 = false;
                }
                if (bl2) {
                    arrayList.add(betterBlockPos);
                    return;
                }
                a2 = a2.a(betterBlockPos.a, betterBlockPos.b, betterBlockPos.c, awt2);
                hashMap.put(a2, 1 + hashMap.getOrDefault(a2, 0));
                return;
            }
            if (awt2.u() instanceof aru) {
                if (!cb.b(awt2)) {
                    arrayList3.add(betterBlockPos);
                    return;
                }
                arrayList4.add(betterBlockPos);
                return;
            }
            arrayList2.add(betterBlockPos);
        });
        list = new ArrayList<awt>();
        arrayList2.forEach(object3 -> {
            List list = list;
            BetterBlockPos betterBlockPos = object3;
            object3 = a2;
            a2 = betterBlockPos;
            list = this;
            list.add((Boolean)baritone.a.a().goalBreakFromAbove.value != false && ((ex)((Object)((a)object3).a)).a(a2.a()).u() instanceof aom && ((ex)((Object)((a)object3).a)).a(a2.b(2)).u() instanceof aom ? new e(new c((et)a2), new ds((dq)((Object)list), a2.a())) : new c((et)a2));
        });
        arrayList2 = new ArrayList();
        arrayList.forEach(betterBlockPos -> {
            if (!arrayList.contains((Object)betterBlockPos.down()) && !arrayList.contains((Object)betterBlockPos.down(2))) {
                Goal goal;
                List list;
                block4: {
                    list = arrayList2;
                    arrayList2 = betterBlockPos;
                    arrayList = this;
                    if (((dq)object).a.world().o((et)arrayList2).u() != aox.a) {
                        goal = new d((et)arrayList2);
                    } else {
                        boolean bl2 = ((dq)object).a.world().o(arrayList2.a()).u() != aox.a;
                        awt awt2 = ((dq)object).a.world().o((et)arrayList2);
                        fa[] faArray = ca.a;
                        for (int i2 = 0; i2 < 5; ++i2) {
                            fa fa2 = faArray[i2];
                            if (!cb.d(((dq)object).a, arrayList2.a(fa2)) || !((dq)object).a.world().a(a2.a(arrayList2.p(), arrayList2.q(), arrayList2.r(), awt2).u(), (et)arrayList2, false, fa2, null)) continue;
                            Object object3 = arrayList2;
                            goal = new b((et)object3, object3.a(fa2), bl2);
                            break block4;
                        }
                        goal = new d((et)arrayList2);
                    }
                }
                list.add(goal);
            }
        });
        arrayList3.forEach(betterBlockPos -> arrayList2.add(new GoalBlock(betterBlockPos.up())));
        if (!arrayList2.isEmpty()) {
            return new e(new GoalComposite(arrayList2.toArray(new Goal[0])), new GoalComposite(list.toArray(new Goal[0])));
        }
        if (list.isEmpty()) {
            if (bl2 && !hashMap.isEmpty()) {
                this.logDirect("Missing materials for at least:");
                this.logDirect(hashMap.entrySet().stream().map(entry -> String.format("%sx %s", entry.getValue(), entry.getKey())).collect(Collectors.joining("\n")));
            }
            if (bl2 && !arrayList4.isEmpty()) {
                this.logDirect("Unreplaceable liquids at at least:");
                this.logDirect(arrayList4.stream().map(betterBlockPos -> String.format("%s %s %s", betterBlockPos.a, betterBlockPos.b, betterBlockPos.c)).collect(Collectors.joining("\n")));
            }
            return null;
        }
        return new GoalComposite(list.toArray(new Goal[0]));
    }

    @Override
    public final void onLostControl() {
        this.a = null;
        this.a = null;
        this.a = null;
        this.b = null;
        this.b = (Integer)baritone.a.a().startAtLayer.value;
        this.c = 0;
        this.a = false;
        this.a = null;
    }

    @Override
    public final String displayName0() {
        if (this.a) {
            return "Builder Paused";
        }
        return "Building " + this.a;
    }

    private List<awt> a(int n2) {
        ArrayList<awt> arrayList = new ArrayList<awt>();
        for (int i2 = 0; i2 < n2; ++i2) {
            aip aip2 = (aip)this.a.player().bv.a.get(i2);
            if (aip2.b() || !(aip2.c() instanceof ahb)) {
                arrayList.add(aox.a.t());
                continue;
            }
            arrayList.add(((ahb)aip2.c()).d().a(this.a.world(), (et)this.a.playerFeet(), fa.b, (float)this.a.player().p, (float)this.a.player().q, (float)this.a.player().r, aip2.c().a(aip2.j()), (vp)this.a.player()));
        }
        return arrayList;
    }

    private static boolean b(awt awt2, awt awt3) {
        if (awt2.u() != awt3.u()) {
            return false;
        }
        boolean bl2 = (Boolean)baritone.a.a().buildIgnoreDirection.value;
        List list = (List)baritone.a.a().buildIgnoreProperties.value;
        if (!bl2 && list.isEmpty()) {
            return awt2.equals(awt3);
        }
        awt2 = awt2.t();
        awt3 = awt3.t();
        for (axj axj2 : awt2.keySet()) {
            if (awt2.get((Object)axj2) == awt3.get((Object)axj2) || bl2 && a.contains(axj2) || list.contains(axj2.a())) continue;
            return false;
        }
        return true;
    }

    private static boolean a(awt awt2, awt awt3, boolean bl2) {
        if (awt3 == null) {
            return true;
        }
        if (awt2.u() instanceof aru && ((Boolean)baritone.a.a().okIfWater.value).booleanValue()) {
            return true;
        }
        if (awt2.u() instanceof aom && ((List)baritone.a.a().okIfAir.value).contains(awt3.u())) {
            return true;
        }
        if (awt3.u() instanceof aom && ((List)baritone.a.a().buildIgnoreBlocks.value).contains(awt2.u())) {
            return true;
        }
        if (!(awt2.u() instanceof aom) && ((Boolean)baritone.a.a().buildIgnoreExisting.value).booleanValue() && !bl2) {
            return true;
        }
        if (((List)baritone.a.a().buildSkipBlocks.value).contains(awt3.u()) && !bl2) {
            return true;
        }
        if (((Map)baritone.a.a().buildValidSubstitutes.value).getOrDefault(awt3.u(), Collections.emptyList()).contains(awt2.u()) && !bl2) {
            return true;
        }
        if (awt2.equals(awt3)) {
            return true;
        }
        return dq.b(awt2, awt3);
    }

    private /* synthetic */ boolean a(BetterBlockPos betterBlockPos) {
        return betterBlockPos.f(this.a.player().p, this.a.player().q, this.a.player().r) > 200.0;
    }

    static {
        a = ImmutableSet.of((Object)atl.c, (Object)arv.a, (Object)arm.D, (Object)aud.a, (Object)aud.b, (Object)aud.c, (Object[])new axj[]{auo.b, auo.c, auo.d, auo.e, auu.a, aur.b, aur.c});
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public final class a
    extends bz {
        private final List<awt> b;
        private final ISchematic a;
        private final int e;
        private final int f;
        private final int g;
        private /* synthetic */ dq a;

        public a(dq dq2) {
            this.a = dq2;
            super(dq2.a, true);
            this.b = dq2.a(9);
            this.a = dq2.a;
            this.e = dq2.a.p();
            this.f = dq2.a.q();
            this.g = dq2.a.r();
            this.e += 10.0;
            this.d = 1.0;
        }

        private awt a(int n2, int n3, int n4, awt awt2) {
            if (this.a.inSchematic(n2 - this.e, n3 - this.f, n4 - this.g, awt2)) {
                return this.a.desiredState(n2 - this.e, n3 - this.f, n4 - this.g, awt2, this.a.a);
            }
            return null;
        }

        @Override
        public final double a(int n2, int n3, int n4, awt awt2) {
            if (!((fu)((Object)this.a)).b(n2, n4)) {
                return 1000000.0;
            }
            awt awt3 = this.a(n2, n3, n4, awt2);
            if (awt3 != null && !((List)baritone.a.a().buildSkipBlocks.value).contains(awt3.u())) {
                if (awt3.u() == aox.a) {
                    return (double)(this.a * 2.0);
                }
                if (this.b.contains(awt3)) {
                    return 0.0;
                }
                if (!this.c) {
                    return 1000000.0;
                }
                return (double)(this.a * 3.0);
            }
            if (this.c) {
                return (double)this.a;
            }
            return 1000000.0;
        }

        @Override
        public final double b(int n2, int n3, int n4, awt awt2) {
            if (this.e == 0 && !this.a.contains(awt2.u())) {
                return 1000000.0;
            }
            awt2 = this.a(n2, n3, n4, awt2);
            if (awt2 != null && !((List)baritone.a.a().buildSkipBlocks.value).contains(awt2.u())) {
                if (awt2.u() == aox.a) {
                    return 1.0;
                }
                if (dq.a(((ex)((Object)this.a)).a(n2, n3, n4), awt2, false)) {
                    return (Double)baritone.a.a().breakCorrectBlockPenaltyMultiplier.value;
                }
                return 1.0;
            }
            return 1.0;
        }
    }

    public static final class d
    extends GoalBlock {
        public d(et et2) {
            super(et2.a());
        }

        @Override
        public final double heuristic(int n2, int n3, int n4) {
            return (double)(this.y * 100) + super.heuristic(n2, n3, n4);
        }

        @Override
        public final int hashCode() {
            return super.hashCode() * 1910811835;
        }

        @Override
        public final String toString() {
            return String.format("GoalPlace{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class b
    extends GoalGetToBlock {
        private boolean a;
        private et a;

        public b(et et2, et et3, boolean bl2) {
            super(et2);
            this.a = et3;
            this.a = bl2;
        }

        @Override
        public final boolean isInGoal(int n2, int n3, int n4) {
            if (n2 == this.x && n3 == this.y && n4 == this.z) {
                return false;
            }
            if (n2 == this.a.p() && n3 == this.a.q() && n4 == this.a.r()) {
                return false;
            }
            if (!this.a && n3 == this.y - 1) {
                return false;
            }
            if (n3 < this.y - 1) {
                return false;
            }
            return super.isInGoal(n2, n3, n4);
        }

        @Override
        public final double heuristic(int n2, int n3, int n4) {
            return (double)(this.y * 100) + super.heuristic(n2, n3, n4);
        }

        @Override
        public final boolean equals(Object object) {
            if (!super.equals(object)) {
                return false;
            }
            object = (b)object;
            return this.a == ((b)object).a && Objects.equals(this.a, ((b)object).a);
        }

        @Override
        public final int hashCode() {
            return ((-2112107180 + super.hashCode()) * 1730799370 + (int)BetterBlockPos.longHash(this.a.p(), this.a.q(), this.a.r())) * 260592149 + (this.a ? -1314802005 : 1565710265);
        }

        @Override
        public final String toString() {
            return String.format("GoalAdjacent{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
        }
    }

    public static final class c
    extends GoalGetToBlock {
        public c(et et2) {
            super(et2);
        }

        @Override
        public final boolean isInGoal(int n2, int n3, int n4) {
            if (n3 > this.y) {
                return false;
            }
            return super.isInGoal(n2, n3, n4);
        }

        @Override
        public final String toString() {
            return String.format("GoalBreak{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
        }

        @Override
        public final int hashCode() {
            return super.hashCode() * 1636324008;
        }
    }

    public static final class e
    implements Goal {
        private final Goal a;
        private final Goal b;

        public e(Goal goal, Goal goal2) {
            this.a = goal;
            this.b = goal2;
        }

        @Override
        public final boolean isInGoal(int n2, int n3, int n4) {
            return this.a.isInGoal(n2, n3, n4) || this.b.isInGoal(n2, n3, n4);
        }

        @Override
        public final double heuristic(int n2, int n3, int n4) {
            return this.a.heuristic(n2, n3, n4);
        }

        public final boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            object = (e)object;
            return Objects.equals(this.a, ((e)object).a) && Objects.equals(this.b, ((e)object).b);
        }

        public final int hashCode() {
            return (1544707182 + this.a.hashCode()) * -80327868 + this.b.hashCode();
        }

        public final String toString() {
            return "JankyComposite Primary: " + this.a + " Fallback: " + this.b;
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class f {
        final int a;
        final et a;
        final fa a;
        final Rotation a;

        public f(int n2, et et2, fa fa2, Rotation rotation) {
            this.a = n2;
            this.a = et2;
            this.a = fa2;
            this.a = rotation;
        }
    }
}

