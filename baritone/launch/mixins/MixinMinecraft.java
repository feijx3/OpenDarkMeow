/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aip
 *  bib
 *  blk
 *  bsb
 *  bud
 *  et
 *  ub
 *  ud
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.BlockInteractEvent;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.event.events.WorldEvent;
import baritone.api.event.events.type.EventState;
import java.util.function.BiFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={bib.class})
public class MixinMinecraft {
    @Shadow
    public bud h;
    @Shadow
    public bsb f;
    @Unique
    private BiFunction<EventState, TickEvent.Type, TickEvent> tickProvider;

    @Inject(method={"init"}, at={@At(value="RETURN")})
    private void postInit(CallbackInfo callbackInfo) {
        BaritoneAPI.getProvider().getPrimaryBaritone();
    }

    @Inject(method={"runTick"}, at={@At(value="FIELD", opcode=180, target="net/minecraft/client/Minecraft.currentScreen:Lnet/minecraft/client/gui/GuiScreen;", ordinal=0, shift=At.Shift.BEFORE)}, slice={@Slice(from=@At(value="FIELD", opcode=181, target="net/minecraft/client/Minecraft.leftClickCounter:I"))})
    private void runTick(CallbackInfo object) {
        this.tickProvider = TickEvent.createNextProvider();
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            TickEvent.Type type = iBaritone.getPlayerContext().player() != null && iBaritone.getPlayerContext().world() != null ? TickEvent.Type.IN : TickEvent.Type.OUT;
            iBaritone.getGameEventHandler().onTick(this.tickProvider.apply(EventState.PRE, type));
        }
    }

    @Inject(method={"runTick"}, at={@At(value="RETURN")})
    private void postRunTick(CallbackInfo object) {
        if (this.tickProvider == null) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            TickEvent.Type type = iBaritone.getPlayerContext().player() != null && iBaritone.getPlayerContext().world() != null ? TickEvent.Type.IN : TickEvent.Type.OUT;
            iBaritone.getGameEventHandler().onPostTick(this.tickProvider.apply(EventState.POST, type));
        }
        this.tickProvider = null;
    }

    @Inject(method={"runTick"}, at={@At(value="INVOKE", target="net/minecraft/client/multiplayer/WorldClient.updateEntities()V", shift=At.Shift.AFTER)})
    private void postUpdateEntities(CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForPlayer(this.h);
        if (object != null) {
            object.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.POST));
        }
    }

    @Inject(method={"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"}, at={@At(value="HEAD")})
    private void preLoadWorld(bsb bsb2, String string, CallbackInfo callbackInfo) {
        if (this.f == null && bsb2 == null) {
            return;
        }
        BaritoneAPI.getProvider().getPrimaryBaritone().getGameEventHandler().onWorldEvent(new WorldEvent(bsb2, EventState.PRE));
    }

    @Inject(method={"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"}, at={@At(value="RETURN")})
    private void postLoadWorld(bsb bsb2, String string, CallbackInfo callbackInfo) {
        BaritoneAPI.getProvider().getPrimaryBaritone().getGameEventHandler().onWorldEvent(new WorldEvent(bsb2, EventState.POST));
    }

    @Redirect(method={"runTick"}, at=@At(value="FIELD", opcode=180, target="net/minecraft/client/gui/GuiScreen.allowUserInput:Z"))
    private boolean isAllowUserInput(blk blk2) {
        return BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing() && this.h != null || blk2.p;
    }

    @Inject(method={"clickMouse"}, at={@At(value="INVOKE", target="net/minecraft/client/multiplayer/PlayerControllerMP.clickBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)Z")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void onBlockBreak(CallbackInfo callbackInfo, et et2) {
        BaritoneAPI.getProvider().getPrimaryBaritone().getGameEventHandler().onBlockInteract(new BlockInteractEvent(et2, BlockInteractEvent.Type.START_BREAK));
    }

    @Inject(method={"rightClickMouse"}, at={@At(value="INVOKE", target="net/minecraft/client/entity/EntityPlayerSP.swingArm(Lnet/minecraft/util/EnumHand;)V")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void onBlockUse(CallbackInfo callbackInfo, ub[] ubArray, int n2, int n3, ub ub2, aip aip2, et et2, int n4, ud ud2) {
        BaritoneAPI.getProvider().getPrimaryBaritone().getGameEventHandler().onBlockInteract(new BlockInteractEvent(et2, BlockInteractEvent.Type.USE));
    }
}

