/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ayf
 *  on
 */
package baritone.launch.mixins;

import baritone.fn;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={on.class})
public class MixinChunkProviderServer
implements fn {
    @Shadow
    @Final
    private ayf d;

    @Override
    public ayf getChunkLoader() {
        return this.d;
    }
}

