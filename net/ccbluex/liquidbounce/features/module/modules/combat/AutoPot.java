/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.potion.PotionUtils
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventState;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.MotionEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.value.MovementModeValue;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.InventoryUtils;
import net.ccbluex.liquidbounce.utils.misc.FallingPlayer;
import net.ccbluex.liquidbounce.utils.timer.MSTimer;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AutoPot", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0002\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006\""}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoPot;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "healthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "rotationStrafe", "Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "rotationKeepTick", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "groundDistance", "useFireResistance", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "useSpeed", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "potionSlot", "", "onMotion", "", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "findPotion", "startSlot", "endSlot", "(II)Ljava/lang/Integer;", "canThrow", "", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoPot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoPot.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoPot\n+ 2 BackendExtentions.kt\nnet/ccbluex/liquidbounce/utils/extensions/BackendExtentionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n12#2,9:139\n26#2:148\n1761#3,3:149\n1761#3,3:152\n1761#3,3:155\n*S KotlinDebug\n*F\n+ 1 AutoPot.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoPot\n*L\n69#1:139,9\n103#1:148\n105#1:149,3\n107#1:152,3\n109#1:155,3\n*E\n"})
public final class AutoPot
extends Module {
    @NotNull
    private final FloatValue healthValue = new FloatValue("Health", 15.0f, 1.0f, 20.0f);
    @NotNull
    private final IntegerRangeValue delayValue = new IntegerRangeValue("Delay", new IntRange(200, 300), new IntRange(0, 1000));
    @NotNull
    private final MovementModeValue rotationStrafe = new MovementModeValue("RotationStrafe", null, 2, null);
    @NotNull
    private final IntegerValue rotationKeepTick = new IntegerValue("RotationKeepTick", 0, new IntRange(0, 20));
    @NotNull
    private final FloatValue groundDistance = new FloatValue("GroundDistance", 2.0f, 0.0f, 5.0f);
    @NotNull
    private final BoolValue useFireResistance = new BoolValue("UseFireResistance", true);
    @NotNull
    private final BoolValue useSpeed = new BoolValue("UseSpeed", true);
    @NotNull
    private final MSTimer msTimer = new MSTimer();
    private int potionSlot = -1;

    public AutoPot() {
        super(null, null, null, null, 15, null);
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onMotion(@NotNull MotionEvent event) {
        EntityPlayerSP player;
        NetHandlerPlayClient connection;
        block29: {
            block28: {
                Intrinsics.checkNotNullParameter(event, "event");
                NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                if (netHandlerPlayClient == null) {
                    return;
                }
                connection = netHandlerPlayClient;
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                if (entityPlayerSP == null) {
                    return;
                }
                player = entityPlayerSP;
                if (MinecraftInstance.mc.getPlayerController().func_78758_h() || !this.msTimer.hasTimePassed(this.delayValue.random()) || DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck()) break block28;
                KillAura killAura = DarkMeow.INSTANCE.getModuleManager().getModule(KillAura.class);
                Intrinsics.checkNotNull(killAura);
                if (killAura.getTargetManager().getPrevTarget() != null) break block28;
                Scaffold scaffold = DarkMeow.INSTANCE.getModuleManager().getModule(Scaffold.class);
                Intrinsics.checkNotNull(scaffold);
                if (!scaffold.getState()) break block29;
            }
            return;
        }
        if (event.getEventState() == EventState.PRE) {
            int n2;
            AutoPot autoPot = this;
            Integer n3 = this.findPotion(36, 45);
            if (n3 != null) {
                n2 = n3;
            } else {
                Integer n4;
                Integer n5 = this.findPotion(9, 36);
                if (n5 != null) {
                    Integer n6;
                    int n7 = ((Number)n5).intValue();
                    AutoPot autoPot2 = autoPot;
                    boolean bl2 = false;
                    if (!InventoryUtils.hasSpaceHotbar()) {
                        n6 = null;
                    } else {
                        void it;
                        ClickType clickType;
                        if (!(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory)) {
                            connection.func_147297_a((Packet)new CPacketEntityAction((Entity)player, CPacketEntityAction.Action.OPEN_INVENTORY));
                        }
                        PlayerControllerMP playerControllerMP = MinecraftInstance.mc.getPlayerController();
                        int $this$toClickType$iv = 1;
                        boolean $i$f$toClickType = false;
                        switch ($this$toClickType$iv) {
                            case 0: {
                                clickType = ClickType.PICKUP;
                                break;
                            }
                            case 1: {
                                clickType = ClickType.QUICK_MOVE;
                                break;
                            }
                            case 2: {
                                clickType = ClickType.SWAP;
                                break;
                            }
                            case 3: {
                                clickType = ClickType.CLONE;
                                break;
                            }
                            case 4: {
                                clickType = ClickType.THROW;
                                break;
                            }
                            case 5: {
                                clickType = ClickType.QUICK_CRAFT;
                                break;
                            }
                            case 6: {
                                clickType = ClickType.PICKUP_ALL;
                                break;
                            }
                            default: {
                                throw new IllegalArgumentException("Invalid mode " + $this$toClickType$iv);
                            }
                        }
                        playerControllerMP.func_187098_a(0, (int)it, 0, clickType, (EntityPlayer)player);
                        if (!(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory)) {
                            connection.func_147297_a((Packet)new CPacketCloseWindow());
                        }
                        this.msTimer.reset();
                        n6 = this.findPotion(36, 45);
                    }
                    n4 = n6;
                    autoPot = autoPot2;
                } else {
                    n4 = null;
                }
                if (n4 != null) {
                    n2 = n4;
                } else {
                    return;
                }
            }
            autoPot.potionSlot = n2;
            if (!this.canThrow()) {
                return;
            }
            Rotation rotation = new Rotation(player.field_70759_as, MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null) ? 80.0f : 90.0f);
            DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask("AutoPot", rotation, this.rotationStrafe.getMovementMode(), ((Number)this.rotationKeepTick.get()).intValue()));
        } else if (event.getEventState() == EventState.POST && this.potionSlot >= 0 && DarkMeow.INSTANCE.getRotationManager().serverRotation.pitch >= 75.0f) {
            connection.func_147297_a((Packet)new CPacketHeldItemChange(this.potionSlot - 36));
            connection.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            connection.func_147297_a((Packet)new CPacketHeldItemChange(player.field_71071_by.field_70461_c));
            this.msTimer.reset();
            this.potionSlot = -1;
        }
    }

    private final Integer findPotion(int startSlot, int endSlot) {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return null;
        }
        EntityPlayerSP player = entityPlayerSP;
        for (int slot = startSlot; slot < endSlot; ++slot) {
            boolean bl2;
            block16: {
                PotionEffect it;
                boolean bl3;
                boolean $i$f$any;
                Iterable $this$any$iv;
                List effects;
                block14: {
                    EntityPlayerSP stack;
                    EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
                    if (entityPlayerSP2 == null || (entityPlayerSP2 = entityPlayerSP2.field_71069_bz) == null || (entityPlayerSP2 = entityPlayerSP2.func_75139_a(slot)) == null) continue;
                    if ((entityPlayerSP2 = entityPlayerSP2.func_75211_c()) == null || !((stack = entityPlayerSP2).func_77973_b() instanceof ItemPotion)) continue;
                    EntityPlayerSP entityPlayerSP3 = stack;
                    EntityPlayerSP item$iv = stack;
                    boolean $i$f$isSplash = false;
                    if (!Intrinsics.areEqual(item$iv.func_77973_b(), Items.field_185155_bH)) continue;
                    effects = PotionUtils.func_185189_a((ItemStack)stack);
                    Intrinsics.checkNotNull(effects);
                    $this$any$iv = effects;
                    $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl3 = false;
                    } else {
                        for (Object element$iv : $this$any$iv) {
                            it = (PotionEffect)element$iv;
                            boolean bl4 = false;
                            if (!Intrinsics.areEqual(it.func_188419_a(), MobEffects.field_76432_h)) continue;
                            bl3 = true;
                            break block14;
                        }
                        bl3 = false;
                    }
                }
                if (bl3) {
                    if (!(player.func_110143_aJ() <= ((Number)this.healthValue.get()).floatValue())) continue;
                    return slot;
                }
                if (((Boolean)this.useFireResistance.get()).booleanValue() && !player.func_70644_a(MobEffects.field_76426_n)) {
                    boolean bl5;
                    block15: {
                        $this$any$iv = effects;
                        $i$f$any = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            bl5 = false;
                        } else {
                            for (Object element$iv : $this$any$iv) {
                                it = (PotionEffect)element$iv;
                                boolean bl6 = false;
                                if (!Intrinsics.areEqual(it.func_188419_a(), MobEffects.field_76426_n)) continue;
                                bl5 = true;
                                break block15;
                            }
                            bl5 = false;
                        }
                    }
                    if (bl5) {
                        return slot;
                    }
                }
                if (!((Boolean)this.useSpeed.get()).booleanValue() || player.func_70644_a(MobEffects.field_76424_c)) continue;
                $this$any$iv = effects;
                $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl2 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        it = (PotionEffect)element$iv;
                        boolean bl7 = false;
                        if (!Intrinsics.areEqual(it.func_188419_a(), MobEffects.field_76424_c)) continue;
                        bl2 = true;
                        break block16;
                    }
                    bl2 = false;
                }
            }
            if (!bl2) continue;
            return slot;
        }
        return null;
    }

    private final boolean canThrow() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        FallingPlayer fallingPlayer = new FallingPlayer(player.field_70165_t, player.field_70163_u, player.field_70161_v, player.field_70159_w, player.field_70181_x, player.field_70179_y, player.field_70177_z, player.field_70702_br, player.field_191988_bg);
        FallingPlayer.CollisionResult collisionResult = fallingPlayer.findCollision(20);
        BlockPos collisionBlock = collisionResult != null ? collisionResult.getPos() : null;
        BlockPos blockPos = collisionBlock;
        return player.field_70163_u - (double)(blockPos != null ? blockPos.func_177956_o() : 0) < (double)((Number)this.groundDistance.get()).floatValue();
    }

    @Override
    @NotNull
    public String getTag() {
        StringBuilder stringBuilder = new StringBuilder().append(((Number)this.healthValue.get()).floatValue()).append('/');
        String string = "%.2f";
        Object[] objectArray = new Object[1];
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        objectArray[0] = Float.valueOf(entityPlayerSP != null ? entityPlayerSP.func_110143_aJ() : 0.0f);
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(...)");
        return stringBuilder.append(string2).toString();
    }
}

