/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amu
 *  bib
 *  bxn
 *  et
 */
package baritone.launch.mixins;

import baritone.a;
import baritone.api.BaritoneAPI;
import baritone.api.utils.IPlayerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={bxn.class})
public abstract class MixinChunkRenderWorker {
    @Shadow
    protected abstract boolean a(et var1, amu var2);

    @Redirect(method={"processTask"}, at=@At(value="INVOKE", target="net/minecraft/client/renderer/chunk/ChunkRenderWorker.isChunkExisting(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/World;)Z"))
    private boolean isChunkExisting(bxn object, et et2, amu amu2) {
        IPlayerContext iPlayerContext;
        if (((Boolean)a.a().renderCachedChunks.value).booleanValue() && !bib.z().E() && (iPlayerContext = (object = (a)BaritoneAPI.getProvider().getPrimaryBaritone()).getPlayerContext()).player() != null && iPlayerContext.world() != null && object.a != null) {
            return object.a.b(et2.p(), et2.r()) || this.a(et2, amu2);
        }
        return this.a(et2, amu2);
    }
}

