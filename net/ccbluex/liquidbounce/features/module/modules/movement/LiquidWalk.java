/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.JumpEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.block.BlockUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="LiquidWalk", description="Allows you to walk on water.", category=ModuleCategory.MOVEMENT, keyBind=36)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/LiquidWalk;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "noJumpValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onJump", "", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMovementInputPre", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
public final class LiquidWalk
extends Module {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final BoolValue noJumpValue;

    public LiquidWalk() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Legit"};
        this.modeValue = new ListValue("Mode", stringArray, "Legit");
        this.noJumpValue = new BoolValue("NoJump", false);
    }

    @NotNull
    public final ListValue getModeValue() {
        return this.modeValue;
    }

    @EventTarget
    public final void onJump(@NotNull JumpEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Block block = BlockUtils.getBlock(new BlockPos(player.field_70165_t, player.field_70163_u - 0.01, player.field_70161_v));
        if (((Boolean)this.noJumpValue.get()).booleanValue() && block instanceof BlockLiquid) {
            event.cancelEvent();
        }
    }

    @EventTarget(priority=0)
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP player = MinecraftInstance.mc.getPlayer();
        if (player == null || player.func_70093_af()) {
            return;
        }
        if (Intrinsics.areEqual((String)this.modeValue.get(), "Legit") && player.func_70090_H()) {
            event.setKeyStateJump(true);
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)this.modeValue.get();
    }
}

