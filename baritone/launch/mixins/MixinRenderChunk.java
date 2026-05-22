/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  and
 *  awt
 *  bib
 *  bxr
 *  et
 */
package baritone.launch.mixins;

import baritone.a;
import baritone.api.BaritoneAPI;
import baritone.api.utils.IPlayerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={bxr.class})
public class MixinRenderChunk {
    @Redirect(method={"rebuildChunk"}, at=@At(value="INVOKE", target="net/minecraft/world/ChunkCache.isEmpty()Z"))
    private boolean isEmpty(and object) {
        IPlayerContext iPlayerContext;
        if (!object.ac()) {
            return false;
        }
        if (((Boolean)a.a().renderCachedChunks.value).booleanValue() && !bib.z().E() && (iPlayerContext = (object = (a)BaritoneAPI.getProvider().getPrimaryBaritone()).getPlayerContext()).player() != null && iPlayerContext.world() != null && object.a != null) {
            iPlayerContext = ((bxr)this).k();
            for (int i2 = -1; i2 <= 1; ++i2) {
                for (int i3 = -1; i3 <= 1; ++i3) {
                    if (!object.a.b((i2 << 4) + iPlayerContext.p(), (i3 << 4) + iPlayerContext.r())) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Redirect(method={"rebuildChunk"}, at=@At(value="INVOKE", target="net/minecraft/world/ChunkCache.getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/state/IBlockState;"))
    private awt getBlockState(and and2, et et2) {
        a a2;
        IPlayerContext iPlayerContext;
        if (((Boolean)a.a().renderCachedChunks.value).booleanValue() && !bib.z().E() && (iPlayerContext = (a2 = (a)BaritoneAPI.getProvider().getPrimaryBaritone()).getPlayerContext()).player() != null && iPlayerContext.world() != null && a2.a != null) {
            return a2.a.a(et2);
        }
        return and2.o(et2);
    }
}

