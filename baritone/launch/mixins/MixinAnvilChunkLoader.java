/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aye
 */
package baritone.launch.mixins;

import baritone.fj;
import java.io.File;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={aye.class})
public class MixinAnvilChunkLoader
implements fj {
    @Shadow
    @Final
    private File d;

    @Override
    public File getChunkSaveLocation() {
        return this.d;
    }
}

