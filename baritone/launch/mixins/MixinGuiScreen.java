/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  blk
 */
package baritone.launch.mixins;

import baritone.fp;
import java.net.URI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={blk.class})
public abstract class MixinGuiScreen
implements fp {
    @Override
    @Invoker(value="openWebLink")
    public abstract void openLink(URI var1);
}

