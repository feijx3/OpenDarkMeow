/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 *  axp
 *  aya
 *  qw
 */
package baritone.launch.mixins;

import baritone.fk;
import baritone.fl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={axp.class})
public abstract class MixinBlockStateContainer
implements fl {
    @Shadow
    protected qw b;
    @Shadow
    protected aya c;

    @Override
    public aya getPalette() {
        return this.c;
    }

    @Override
    public qw getStorage() {
        return this.b;
    }

    public awt getAtPalette(int n2) {
        return this.c.a(n2);
    }

    public int[] storageArray() {
        return ((fk)this.b).toArray();
    }
}

