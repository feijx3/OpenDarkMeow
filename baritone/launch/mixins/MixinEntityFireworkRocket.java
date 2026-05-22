/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aem
 *  amu
 *  my
 *  vg
 *  vp
 */
package baritone.launch.mixins;

import baritone.fo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={aem.class})
public abstract class MixinEntityFireworkRocket
extends vg
implements fo {
    @Shadow
    @Final
    private static my<Integer> b;
    @Shadow
    private vp e;

    @Shadow
    public abstract boolean j();

    private MixinEntityFireworkRocket(amu amu2) {
        super(amu2);
    }

    @Override
    public vp getBoostedEntity() {
        vg vg2;
        if (this.j() && this.e == null && (vg2 = this.l.a(((Integer)this.Y.a(b)).intValue())) instanceof vp) {
            this.e = (vp)vg2;
        }
        return this.e;
    }
}

