/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.MoveEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="ElytraFly", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/ElytraFly;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "noGravityValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "speedBoosterValue", "speedCushionValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "upSpeedValue", "upSpeedBoosterValue", "upSpeedCushionValue", "downSpeedValue", "downSpeedBoosterValue", "downSpeedCushionValue", "cushionCheckValue", "cushionCheckXZValue", "", "cushionCheckYValue", "playerState", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/ElytraFly$PlayerState;", "onMove", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/MoveEvent;", "updateState", "doCushionCheck", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "checkXZMode", "PlayerState", "DarkMeow"})
public final class ElytraFly
extends Module {
    @NotNull
    private final BoolValue noGravityValue = new BoolValue("NoGravity", true);
    @NotNull
    private final FloatValue speedValue = new FloatValue("Speed", 3.0f, 0.1f, 20.0f);
    @NotNull
    private final FloatValue speedBoosterValue = new FloatValue("SpeedBooster", 5.0f, 0.1f, 20.0f);
    @NotNull
    private final Value<Float> speedCushionValue = new FloatValue("SpeedCushion", 0.3f, 0.1f, 1.0f).displayable(() -> ElytraFly.speedCushionValue$lambda$0(this));
    @NotNull
    private final FloatValue upSpeedValue = new FloatValue("UpSpeed", 0.2f, 0.1f, 10.0f);
    @NotNull
    private final FloatValue upSpeedBoosterValue = new FloatValue("UpSpeedBooster", 0.5f, 0.1f, 10.0f);
    @NotNull
    private final Value<Float> upSpeedCushionValue = new FloatValue("UpSpeedCushion", 0.3f, 0.1f, 1.0f).displayable(() -> ElytraFly.upSpeedCushionValue$lambda$1(this));
    @NotNull
    private final FloatValue downSpeedValue = new FloatValue("DownSpeed", 0.2f, 0.1f, 10.0f);
    @NotNull
    private final FloatValue downSpeedBoosterValue = new FloatValue("DownSpeedBooster", 0.5f, 0.1f, 10.0f);
    @NotNull
    private final Value<Float> downSpeedCushionValue = new FloatValue("DownSpeedCushion", 0.3f, 0.1f, 1.0f).displayable(() -> ElytraFly.downSpeedCushionValue$lambda$2(this));
    @NotNull
    private final BoolValue cushionCheckValue = new BoolValue("CushionCheck", true);
    @NotNull
    private final Value<Integer> cushionCheckXZValue = new IntegerValue("CushionCheckXZ", 2, 1, 10).displayable(() -> ElytraFly.cushionCheckXZValue$lambda$3(this));
    @NotNull
    private final Value<Integer> cushionCheckYValue = new IntegerValue("CushionCheckY", 2, 1, 10).displayable(() -> ElytraFly.cushionCheckYValue$lambda$4(this));
    @NotNull
    private PlayerState playerState = PlayerState.ON_GROUND;

    public ElytraFly() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onMove(@NotNull MoveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        if (netHandlerPlayClient == null) {
            return;
        }
        NetHandlerPlayClient connection = netHandlerPlayClient;
        if (WhenMappings.$EnumSwitchMapping$1[event.getType().ordinal()] == 1) {
            this.updateState();
            switch (WhenMappings.$EnumSwitchMapping$0[this.playerState.ordinal()]) {
                case 1: {
                    ExtendEntity.INSTANCE.setFlag((Entity)player, 7, false);
                    break;
                }
                case 2: {
                    if (player.field_70122_E) break;
                    connection.func_147297_a((Packet)new CPacketEntityAction((Entity)player, CPacketEntityAction.Action.START_FALL_FLYING));
                    break;
                }
                case 3: {
                    Number number;
                    if (((Boolean)this.noGravityValue.get()).booleanValue()) {
                        event.setY(0.0);
                    }
                    boolean sprint = MinecraftInstance.mc.getGameSettings().field_151444_V.func_151470_d();
                    if (MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null)) {
                        double yaw = MovementUtils.INSTANCE.calcMoveYaw(player);
                        float speed = this.doCushionCheck(player, true) ? ((Number)this.speedCushionValue.get()).floatValue() : (sprint ? ((Number)this.speedBoosterValue.get()).floatValue() : ((Number)this.speedValue.get()).floatValue());
                        event.setX(-Math.sin(yaw) * (double)speed);
                        event.setZ(Math.cos(yaw) * (double)speed);
                    } else {
                        event.setX(0.0);
                        event.setZ(0.0);
                    }
                    if (player.field_71158_b.field_78901_c) {
                        float vSpeed = sprint ? ((Number)this.upSpeedBoosterValue.get()).floatValue() : ((Number)this.upSpeedValue.get()).floatValue();
                        number = Float.valueOf(this.doCushionCheck(player, false) ? Math.min(((Number)this.upSpeedCushionValue.get()).floatValue(), vSpeed) : vSpeed);
                    } else if (player.field_71158_b.field_78899_d) {
                        float vSpeed = sprint ? ((Number)this.downSpeedBoosterValue.get()).floatValue() : ((Number)this.downSpeedValue.get()).floatValue();
                        number = Float.valueOf(-(this.doCushionCheck(player, false) ? Math.min(((Number)this.downSpeedCushionValue.get()).floatValue(), vSpeed) : vSpeed));
                    } else {
                        number = event.getY();
                    }
                    event.setY(((Number)number).doubleValue());
                    player.field_70159_w = 0.0;
                    player.field_70181_x = 0.0;
                    player.field_70179_y = 0.0;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    private final void updateState() {
        block0: {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) break block0;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            this.playerState = player.field_70122_E || !Intrinsics.areEqual(PlayerExtensionKt.getChestSlot((EntityPlayer)player).func_75211_c().func_77973_b(), Items.field_185160_cR) ? PlayerState.ON_GROUND : (player.func_184613_cA() ? PlayerState.FLYING : PlayerState.TAKEOFF);
        }
    }

    private final boolean doCushionCheck(EntityPlayerSP player, boolean checkXZMode) {
        boolean bl2;
        block10: {
            if (!((Boolean)this.cushionCheckValue.get()).booleanValue()) {
                return false;
            }
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            if (worldClient != null) {
                WorldClient it = worldClient;
                boolean bl3 = false;
                int xz = checkXZMode ? ((Number)this.cushionCheckXZValue.get()).intValue() : 1;
                int yc = checkXZMode ? 1 : ((Number)this.cushionCheckYValue.get()).intValue();
                int x2 = -xz;
                if (x2 <= xz) {
                    while (true) {
                        int y2;
                        if ((y2 = -yc) <= yc) {
                            while (true) {
                                int z2;
                                if ((z2 = -xz) <= xz) {
                                    while (true) {
                                        Block block = it.func_180495_p(new BlockPos((int)player.field_70165_t + x2, (int)player.field_70163_u + y2, (int)player.field_70161_v + z2)).func_177230_c();
                                        Intrinsics.checkNotNullExpressionValue(block, "getBlock(...)");
                                        if (ElytraFly.doCushionCheck$isDamageBlock(block)) {
                                            bl2 = true;
                                            break block10;
                                        }
                                        if (z2 == xz) break;
                                        ++z2;
                                    }
                                }
                                if (y2 == yc) break;
                                ++y2;
                            }
                        }
                        if (x2 == xz) break;
                        ++x2;
                    }
                }
                bl2 = false;
            } else {
                bl2 = false;
            }
        }
        return bl2;
    }

    private static final boolean speedCushionValue$lambda$0(ElytraFly this$0) {
        return (Boolean)this$0.cushionCheckValue.get();
    }

    private static final boolean upSpeedCushionValue$lambda$1(ElytraFly this$0) {
        return (Boolean)this$0.cushionCheckValue.get();
    }

    private static final boolean downSpeedCushionValue$lambda$2(ElytraFly this$0) {
        return (Boolean)this$0.cushionCheckValue.get();
    }

    private static final boolean cushionCheckXZValue$lambda$3(ElytraFly this$0) {
        return (Boolean)this$0.cushionCheckValue.get();
    }

    private static final boolean cushionCheckYValue$lambda$4(ElytraFly this$0) {
        return (Boolean)this$0.cushionCheckValue.get();
    }

    private static final boolean doCushionCheck$isDamageBlock(Block block) {
        return !Intrinsics.areEqual(block, Blocks.field_150350_a) && !Intrinsics.areEqual(block, Blocks.field_150355_j) && !Intrinsics.areEqual(block, Blocks.field_150358_i);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/ElytraFly$PlayerState;", "", "<init>", "(Ljava/lang/String;I)V", "ON_GROUND", "TAKEOFF", "FLYING", "DarkMeow"})
    private static final class PlayerState
    extends Enum<PlayerState> {
        public static final /* enum */ PlayerState ON_GROUND = new PlayerState();
        public static final /* enum */ PlayerState TAKEOFF = new PlayerState();
        public static final /* enum */ PlayerState FLYING = new PlayerState();
        private static final /* synthetic */ PlayerState[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static PlayerState[] values() {
            return (PlayerState[])$VALUES.clone();
        }

        public static PlayerState valueOf(String value) {
            return Enum.valueOf(PlayerState.class, value);
        }

        @NotNull
        public static EnumEntries<PlayerState> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = playerStateArray = new PlayerState[]{PlayerState.ON_GROUND, PlayerState.TAKEOFF, PlayerState.FLYING};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[PlayerState.values().length];
            try {
                nArray[PlayerState.ON_GROUND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PlayerState.TAKEOFF.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PlayerState.FLYING.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[MoverType.values().length];
            try {
                nArray[MoverType.SELF.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

