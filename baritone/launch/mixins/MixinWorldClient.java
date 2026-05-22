/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bsb
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.ChunkEvent;
import baritone.api.event.events.type.EventState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={bsb.class})
public class MixinWorldClient {
    @Inject(method={"doPreChunk"}, at={@At(value="HEAD")})
    private void preDoPreChunk(int n2, int n3, boolean bl2, CallbackInfo object) {
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().world() != (bsb)this) continue;
            iBaritone.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.PRE, bl2 ? ChunkEvent.Type.LOAD : ChunkEvent.Type.UNLOAD, n2, n3));
        }
    }

    @Inject(method={"doPreChunk"}, at={@At(value="RETURN")})
    private void postDoPreChunk(int n2, int n3, boolean bl2, CallbackInfo object) {
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().world() != (bsb)this) continue;
            iBaritone.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.POST, bl2 ? ChunkEvent.Type.LOAD : ChunkEvent.Type.UNLOAD, n2, n3));
        }
    }
}

