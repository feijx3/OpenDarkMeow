/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amn
 *  awt
 *  brz
 *  et
 *  ij
 *  io
 *  je
 *  jo
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.event.events.BlockChangeEvent;
import baritone.api.event.events.ChunkEvent;
import baritone.api.event.events.type.EventState;
import baritone.api.utils.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={brz.class})
public class MixinNetHandlerPlayClient {
    @Inject(method={"handleChunkData"}, at={@At(value="INVOKE", target="net/minecraft/world/chunk/Chunk.read(Lnet/minecraft/network/PacketBuffer;IZ)V")})
    private void preRead(je je2, CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForConnection((brz)this);
        if (object == null) {
            return;
        }
        object.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.PRE, je2.e() ? ChunkEvent.Type.POPULATE_FULL : ChunkEvent.Type.POPULATE_PARTIAL, je2.b(), je2.c()));
    }

    @Inject(method={"handleChunkData"}, at={@At(value="RETURN")})
    private void postHandleChunkData(je je2, CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForConnection((brz)this);
        if (object == null) {
            return;
        }
        object.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.POST, je2.e() ? ChunkEvent.Type.POPULATE_FULL : ChunkEvent.Type.POPULATE_PARTIAL, je2.b(), je2.c()));
    }

    @Inject(method={"handleBlockChange"}, at={@At(value="RETURN")})
    private void postHandleBlockChange(ij object, CallbackInfo object2) {
        object2 = BaritoneAPI.getProvider().getBaritoneForConnection((brz)this);
        if (object2 == null) {
            return;
        }
        amn amn2 = new amn(object.b().p() >> 4, object.b().r() >> 4);
        object = new Pair<et, awt>(object.b(), object.a());
        object2.getGameEventHandler().onBlockChange(new BlockChangeEvent(amn2, Collections.singletonList(object)));
    }

    @Inject(method={"handleMultiBlockChange"}, at={@At(value="RETURN")})
    private void postHandleMultiBlockChange(io io2, CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForConnection((brz)this);
        if (object == null) {
            return;
        }
        amn amn2 = new amn(io2.a()[0].a());
        object.getGameEventHandler().onBlockChange(new BlockChangeEvent(amn2, Arrays.stream(io2.a()).map(a2 -> new Pair<et, awt>(a2.a(), a2.c())).collect(Collectors.toList())));
    }

    @Inject(method={"handleCombatEvent"}, at={@At(value="INVOKE", target="net/minecraft/client/Minecraft.displayGuiScreen(Lnet/minecraft/client/gui/GuiScreen;)V")})
    private void onPlayerDeath(jo object, CallbackInfo callbackInfo) {
        object = BaritoneAPI.getProvider().getBaritoneForConnection((brz)this);
        if (object == null) {
            return;
        }
        object.getGameEventHandler().onPlayerDeath();
    }
}

