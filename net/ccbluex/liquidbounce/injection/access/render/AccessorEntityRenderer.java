/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.EntityRenderer
 */
package net.ccbluex.liquidbounce.injection.access.render;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={EntityRenderer.class})
public interface AccessorEntityRenderer {
    @Invoker(value="getFOVModifier")
    public float darkMeow_getFOVModifier(float var1, boolean var2);
}

