/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.DestroyBlockProgress
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.client.shader.ShaderGroup
 */
package net.ccbluex.liquidbounce.injection.access.render;

import java.util.Map;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderGlobal.class})
public interface AccessorRenderGlobal {
    @Accessor(value="entityOutlineShader")
    public ShaderGroup getEntityOutlineShader();

    @Accessor(value="damagedBlocks")
    public Map<Integer, DestroyBlockProgress> trollGetDamagedBlocks();

    @Accessor(value="renderEntitiesStartupCounter")
    public int trollGetRenderEntitiesStartupCounter();

    @Accessor(value="renderEntitiesStartupCounter")
    public void trollSetRenderEntitiesStartupCounter(int var1);

    @Accessor(value="countEntitiesTotal")
    public int trollGetCountEntitiesTotal();

    @Accessor(value="countEntitiesTotal")
    public void trollSetCountEntitiesTotal(int var1);

    @Accessor(value="countEntitiesRendered")
    public int trollGetCountEntitiesRendered();

    @Accessor(value="countEntitiesRendered")
    public void trollSetCountEntitiesRendered(int var1);

    @Accessor(value="countEntitiesHidden")
    public int trollGetCountEntitiesHidden();

    @Accessor(value="countEntitiesHidden")
    public void trollSetCountEntitiesHidden(int var1);

    @Accessor(value="entityOutlineFramebuffer")
    public Framebuffer trollGetEntityOutlineFramebuffer();
}

