/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.DestroyBlockProgress
 */
package net.ccbluex.liquidbounce.injection.access.render;

import net.minecraft.client.renderer.DestroyBlockProgress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={DestroyBlockProgress.class})
public interface AccessorDestroyBlockProgress {
    @Accessor(value="miningPlayerEntId")
    public int trollGetEntityID();
}

