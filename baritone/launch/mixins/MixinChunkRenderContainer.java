/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bib
 *  bun
 *  bus
 *  bxr
 *  et
 *  org.lwjgl.opengl.GL14
 */
package baritone.launch.mixins;

import baritone.a;
import org.lwjgl.opengl.GL14;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={bun.class})
public class MixinChunkRenderContainer {
    @Redirect(method={"preRenderChunk"}, at=@At(value="INVOKE", target="net/minecraft/client/renderer/chunk/RenderChunk.getPosition()Lnet/minecraft/util/math/BlockPos;"))
    private et getPosition(bxr bxr2) {
        if (((Boolean)a.a().renderCachedChunks.value).booleanValue() && !bib.z().E() && bib.z().f.f(bxr2.k()).f()) {
            bus.e();
            bus.m();
            GL14.glBlendColor((float)0.0f, (float)0.0f, (float)0.0f, (float)((Float)a.a().cachedChunksOpacity.value).floatValue());
            bus.a((int)32771, (int)32772, (int)1, (int)0);
        }
        return bxr2.k();
    }
}

