/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.client.shader.Shader
 *  net.minecraft.client.shader.ShaderGroup
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.ccbluex.liquidbounce.injection.access.render;

import java.util.List;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@SideOnly(value=Side.CLIENT)
@Mixin(value={ShaderGroup.class})
public interface AccessorShaderGroup {
    @Accessor(value="listShaders")
    public List<Shader> getListShaders();

    @Accessor(value="listFramebuffers")
    public List<Framebuffer> getListFramebuffers();

    @Accessor(value="mainFramebuffer")
    public Framebuffer getMainFramebuffer();

    @Invoker(value="render")
    public void darkMeow_Render(float var1);
}

