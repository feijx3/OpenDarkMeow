/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ahq
 *  ain$a
 */
package baritone.launch.mixins;

import baritone.fq;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={ahq.class})
public class MixinItemTool
implements fq {
    @Shadow
    protected ain.a d;

    @Override
    public int getHarvestLevel() {
        return this.d.d();
    }
}

