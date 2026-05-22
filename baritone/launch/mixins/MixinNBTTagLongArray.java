/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  gf
 */
package baritone.launch.mixins;

import baritone.fr;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={gf.class})
public abstract class MixinNBTTagLongArray
implements fr {
    @Override
    @Accessor(value="data")
    public abstract long[] getLongArray();
}

