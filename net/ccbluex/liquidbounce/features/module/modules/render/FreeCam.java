/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateRotationStateEvent;
import net.ccbluex.liquidbounce.event.events.tick.TickInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.handler.combat.IFakeEntity;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.ListenerBaseUtils;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.utils.math.MathUtils;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "flyModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "horizontalSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "verticalSpeedValue", "inventoryMoveValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "relativeValue", "oldPersonView", "", "getOldPersonView", "()I", "setOldPersonView", "(I)V", "camera", "Lnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam$FakeCamera;", "getCamera", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam$FakeCamera;", "setCamera", "(Lnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam$FakeCamera;)V", "onEnable", "", "onDisable", "ENTITY_ID", "FakeCamera", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFreeCam.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FreeCam.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,199:1\n12#2,3:200\n13#2,2:203\n12#2,3:205\n12#2,3:208\n12#2,3:211\n*S KotlinDebug\n*F\n+ 1 FreeCam.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam\n*L\n88#1:200,3\n91#1:203,2\n99#1:205,3\n103#1:208,3\n107#1:211,3\n*E\n"})
public final class FreeCam
extends Module {
    @NotNull
    public static final FreeCam INSTANCE;
    @JvmField
    @NotNull
    public static final ListValue flyModeValue;
    @JvmField
    @NotNull
    public static final FloatValue horizontalSpeedValue;
    @JvmField
    @NotNull
    public static final FloatValue verticalSpeedValue;
    @JvmField
    @NotNull
    public static final BoolValue inventoryMoveValue;
    @JvmField
    @NotNull
    public static final BoolValue relativeValue;
    private static int oldPersonView;
    public static FakeCamera camera;
    public static final int ENTITY_ID = -114514;

    private FreeCam() {
        super("FreeCam", ModuleCategory.RENDER, null, null, 12, null);
    }

    public final int getOldPersonView() {
        return oldPersonView;
    }

    public final void setOldPersonView(int n2) {
        oldPersonView = n2;
    }

    @NotNull
    public final FakeCamera getCamera() {
        FakeCamera fakeCamera = camera;
        if (fakeCamera != null) {
            return fakeCamera;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camera");
        return null;
    }

    public final void setCamera(@NotNull FakeCamera fakeCamera) {
        Intrinsics.checkNotNullParameter(fakeCamera, "<set-?>");
        camera = fakeCamera;
    }

    @Override
    public void onEnable() {
        ListenerBaseUtils.INSTANCE.safeExecute(FreeCam::onEnable$lambda$1);
    }

    @Override
    public void onDisable() {
        ListenerBaseUtils.INSTANCE.safeExecute(FreeCam::onDisable$lambda$2);
    }

    private static final Unit onEnable$lambda$1(SafeListenerBase $this$safeExecute) {
        FakeCamera fakeCamera;
        Intrinsics.checkNotNullParameter($this$safeExecute, "$this$safeExecute");
        FakeCamera $this$onEnable_u24lambda_u241_u24lambda_u240 = fakeCamera = new FakeCamera($this$safeExecute.getWorld(), $this$safeExecute.getPlayer());
        boolean bl2 = false;
        oldPersonView = $this$safeExecute.getMc().field_71474_y.field_74320_O;
        $this$safeExecute.getMc().field_71474_y.field_74320_O = 0;
        $this$safeExecute.getWorld().func_73027_a(-114514, (Entity)$this$onEnable_u24lambda_u241_u24lambda_u240);
        $this$safeExecute.getMc().func_175607_a((Entity)$this$onEnable_u24lambda_u241_u24lambda_u240);
        INSTANCE.setCamera($this$onEnable_u24lambda_u241_u24lambda_u240);
        return Unit.INSTANCE;
    }

    private static final Unit onDisable$lambda$2(SafeListenerBase $this$safeExecute) {
        Intrinsics.checkNotNullParameter($this$safeExecute, "$this$safeExecute");
        $this$safeExecute.getMc().field_175612_E = true;
        $this$safeExecute.getMc().func_175607_a((Entity)$this$safeExecute.getPlayer());
        $this$safeExecute.getWorld().func_72900_e((Entity)INSTANCE.getCamera());
        $this$safeExecute.getMc().field_71474_y.field_74320_O = oldPersonView;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.setState(false);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(ListenerBase $this$listener, MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        event.setKeyStateForward(false);
        event.setKeyStateBack(false);
        event.setKeyStateLeft(false);
        event.setKeyStateRight(false);
        event.setKeyStateJump(false);
        event.setKeyStateSneak(false);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(ListenerBase $this$listener, UpdateRotationStateEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        INSTANCE.getCamera().func_70082_c(event.getYaw(), event.getPitch());
        event.cancelEvent();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(ListenerBase $this$listener, TickInputEvent.UpdateKeyboard event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        event.getGameSettings().field_74320_O = 0;
        KeyBinding keyBinding = event.getGameSettings().field_151457_aa;
        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindTogglePerspective");
        ExtendKeyBinding.INSTANCE.unPressKey(keyBinding);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(ListenerBase $this$listener, ControllerUseEntityAttackEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getTarget() instanceof EntityPlayerSP || event.getTarget() instanceof FakeCamera) {
            event.cancelEvent();
        }
        return Unit.INSTANCE;
    }

    static {
        ListenableOwner $this$listener$iv;
        ListenableOwner $receiver$iv;
        INSTANCE = new FreeCam();
        Object object = new String[]{"Creative", "3D"};
        flyModeValue = new ListValue("FlyMode", (String[])object, "Creative");
        horizontalSpeedValue = new FloatValue("SpeedHorizontal", 20.0f, 1.0f, 50.0f);
        verticalSpeedValue = new FloatValue("SpeedVertical", 20.0f, 1.0f, 50.0f);
        inventoryMoveValue = new BoolValue("InventoryMove", true);
        relativeValue = new BoolValue("Relative", false);
        object = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = INSTANCE;
        Function2<ListenerBase, Event, Unit> function$iv = FreeCam::_init_$lambda$3;
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = INSTANCE;
        priority$iv = 2500;
        function$iv = FreeCam::_init_$lambda$4;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$listener$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), $this$listener$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$listener$iv = INSTANCE;
        function$iv = FreeCam::_init_$lambda$5;
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(UpdateRotationStateEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = INSTANCE;
        function$iv = FreeCam::_init_$lambda$6;
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(TickInputEvent.UpdateKeyboard.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = INSTANCE;
        function$iv = FreeCam::_init_$lambda$7;
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerUseEntityAttackEvent.class), $receiver$iv));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0013H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam$FakeCamera;", "Lnet/minecraft/client/entity/EntityOtherPlayerMP;", "Lnet/ccbluex/liquidbounce/handler/combat/IFakeEntity;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "<init>", "(Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/client/entity/EntityPlayerSP;)V", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "onLivingUpdate", "", "getEyeHeight", "", "isSpectator", "", "isInvisible", "isInvisibleToPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "DarkMeow"})
    public static final class FakeCamera
    extends EntityOtherPlayerMP
    implements IFakeEntity {
        @NotNull
        private final EntityPlayerSP player;

        public FakeCamera(@NotNull WorldClient world, @NotNull EntityPlayerSP player) {
            Intrinsics.checkNotNullParameter(world, "world");
            Intrinsics.checkNotNullParameter(player, "player");
            super((World)world, player.func_146103_bH());
            this.player = player;
            this.func_82149_j((Entity)this.player);
            this.field_71075_bZ.field_75101_c = true;
            this.field_71075_bZ.field_75100_b = true;
        }

        @NotNull
        public final EntityPlayerSP getPlayer() {
            return this.player;
        }

        public void func_70636_d() {
            block9: {
                Vec3d movementInput;
                block8: {
                    this.func_70050_g(this.player.func_70086_ai());
                    this.field_71100_bB = this.player.func_71024_bL();
                    this.func_70606_j(this.player.func_110143_aJ());
                    this.func_110149_m(this.player.func_110139_bj());
                    this.func_193076_bZ().clear();
                    Map map = this.func_193076_bZ();
                    Map map2 = this.player.func_193076_bZ();
                    Intrinsics.checkNotNullExpressionValue(map2, "getActivePotionMap(...)");
                    map.putAll(map2);
                    this.field_71071_by.func_70455_b(this.player.field_71071_by);
                    this.func_70626_be();
                    KeyBinding keyBinding = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71474_y.field_74351_w;
                    Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindForward");
                    boolean bl2 = KeyUtils.INSTANCE.isKeyDownSystem(keyBinding);
                    KeyBinding keyBinding2 = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71474_y.field_74368_y;
                    Intrinsics.checkNotNullExpressionValue(keyBinding2, "keyBindBack");
                    boolean bl3 = KeyUtils.INSTANCE.isKeyDownSystem(keyBinding2);
                    KeyBinding keyBinding3 = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71474_y.field_74370_x;
                    Intrinsics.checkNotNullExpressionValue(keyBinding3, "keyBindLeft");
                    boolean bl4 = KeyUtils.INSTANCE.isKeyDownSystem(keyBinding3);
                    KeyBinding keyBinding4 = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71474_y.field_74366_z;
                    Intrinsics.checkNotNullExpressionValue(keyBinding4, "keyBindRight");
                    boolean bl5 = KeyUtils.INSTANCE.isKeyDownSystem(keyBinding4);
                    KeyBinding keyBinding5 = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71474_y.field_74314_A;
                    Intrinsics.checkNotNullExpressionValue(keyBinding5, "keyBindJump");
                    boolean bl6 = KeyUtils.INSTANCE.isKeyDownSystem(keyBinding5);
                    KeyBinding keyBinding6 = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71474_y.field_74311_E;
                    Intrinsics.checkNotNullExpressionValue(keyBinding6, "keyBindSneak");
                    movementInput = MovementUtils.INSTANCE.calcMovementInput(bl2, bl3, bl4, bl5, bl6, KeyUtils.INSTANCE.isKeyDownSystem(keyBinding6));
                    if (((Boolean)inventoryMoveValue.get()).booleanValue()) break block8;
                    GuiScreen guiScreen = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71462_r;
                    if (guiScreen != null ? !guiScreen.field_146291_p : false) break block9;
                }
                this.field_191988_bg = (float)movementInput.field_72449_c;
                this.field_70702_br = (float)movementInput.field_72450_a;
                this.field_70701_bs = (float)movementInput.field_72448_b;
            }
            KeyBinding keyBinding = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)this.player).field_71474_y.field_151444_V;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindSprint");
            this.func_70031_b(KeyUtils.INSTANCE.isKeyDownSystem(keyBinding));
            double yawRad = MovementUtils.INSTANCE.calcMoveYaw(this.field_70177_z, this.field_191988_bg, this.field_70702_br);
            float speed = ((Number)horizontalSpeedValue.get()).floatValue() / 20.0f * Math.min(Math.abs(this.field_191988_bg) + Math.abs(this.field_70702_br), 1.0f);
            String string = (String)flyModeValue.get();
            if (Intrinsics.areEqual(string, "Creative")) {
                this.field_70159_w = -Math.sin(yawRad) * (double)speed;
                this.field_70181_x = (double)this.field_70701_bs * (double)(((Number)verticalSpeedValue.get()).floatValue() / 20.0f);
                this.field_70179_y = Math.cos(yawRad) * (double)speed;
            } else if (Intrinsics.areEqual(string, "3D")) {
                double pitchRad = MathUtils.INSTANCE.toRadians((double)this.field_70125_A) * (double)this.field_191988_bg;
                this.field_70159_w = -Math.sin(yawRad) * Math.cos(pitchRad) * (double)speed;
                this.field_70181_x = -Math.sin(pitchRad) * (double)speed;
                this.field_70179_y = Math.cos(yawRad) * Math.cos(pitchRad) * (double)speed;
            }
            if (this.func_70051_ag()) {
                this.field_70159_w *= 1.5;
                this.field_70181_x *= 1.5;
                this.field_70179_y *= 1.5;
            }
            if (((Boolean)relativeValue.get()).booleanValue()) {
                this.field_70159_w += this.player.field_70165_t - this.player.field_70169_q;
                this.field_70181_x += this.player.field_70163_u - this.player.field_70167_r;
                this.field_70179_y += this.player.field_70161_v - this.player.field_70166_s;
            }
            this.func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
        }

        public float func_70047_e() {
            return 1.65f;
        }

        public boolean func_175149_v() {
            return true;
        }

        public boolean func_82150_aj() {
            return true;
        }

        public boolean func_98034_c(@NotNull EntityPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            return true;
        }
    }
}

