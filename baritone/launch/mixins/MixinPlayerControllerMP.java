/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bsa
 *  et
 */
package baritone.launch.mixins;

import baritone.fs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={bsa.class})
public abstract class MixinPlayerControllerMP
implements fs {
    @Override
    @Accessor
    public abstract void setIsHittingBlock(boolean var1);

    @Override
    @Accessor
    public abstract et getCurrentBlock();

    @Override
    @Invoker
    public abstract void callSyncCurrentPlayItem();
}

