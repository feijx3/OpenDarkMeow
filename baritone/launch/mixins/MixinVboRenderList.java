/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bib
 *  bus
 *  bvf
 */
package baritone.launch.mixins;

import baritone.a;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={bvf.class})
public class MixinVboRenderList {
    @Redirect(method={"renderChunkLayer"}, at=@At(value="INVOKE", target="net/minecraft/client/renderer/GlStateManager.popMatrix()V"))
    private void popMatrix() {
        if (((Boolean)a.a().renderCachedChunks.value).booleanValue() && !bib.z().E()) {
            bus.a((int)770, (int)771, (int)1, (int)0);
        }
        bus.H();
    }
}

