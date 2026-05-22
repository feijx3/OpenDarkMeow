/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  axw
 *  brx
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 */
package baritone.launch.mixins;

import baritone.fm;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={brx.class})
public class MixinChunkProviderClient
implements fm {
    @Shadow
    @Final
    private Long2ObjectMap<axw> c;

    @Override
    public Long2ObjectMap<axw> loadedChunks() {
        return this.c;
    }
}

