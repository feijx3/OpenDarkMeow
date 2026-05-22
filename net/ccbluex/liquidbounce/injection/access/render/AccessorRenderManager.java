/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 */
package net.ccbluex.liquidbounce.injection.access.render;

import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderManager.class})
public interface AccessorRenderManager {
    @Accessor(value="renderPosX")
    public double getRenderPosX();

    @Accessor(value="renderPosX")
    public void setRenderPosX(double var1);

    @Accessor(value="renderPosY")
    public double getRenderPosY();

    @Accessor(value="renderPosY")
    public void setRenderPosY(double var1);

    @Accessor(value="renderPosZ")
    public double getRenderPosZ();

    @Accessor(value="renderPosZ")
    public void setRenderPosZ(double var1);

    @Accessor(value="renderOutlines")
    public boolean getRenderOutlines();

    @Accessor(value="renderOutlines")
    public void func_178632_c(boolean var1);
}

