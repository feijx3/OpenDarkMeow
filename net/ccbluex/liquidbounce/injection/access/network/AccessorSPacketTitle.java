/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketTitle
 *  net.minecraft.network.play.server.SPacketTitle$Type
 *  net.minecraft.util.text.ITextComponent
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketTitle.class})
public interface AccessorSPacketTitle {
    @Accessor(value="type")
    public SPacketTitle.Type func_179807_a();

    @Accessor(value="type")
    public void setType(SPacketTitle.Type var1);

    @Accessor(value="message")
    public ITextComponent func_179805_b();

    @Accessor(value="message")
    public void setMessage(ITextComponent var1);

    @Accessor(value="fadeInTime")
    public int func_179806_c();

    @Accessor(value="fadeInTime")
    public void setFadeInTime(int var1);

    @Accessor(value="displayTime")
    public int func_179804_d();

    @Accessor(value="displayTime")
    public void setDisplayTime(int var1);

    @Accessor(value="fadeOutTime")
    public int func_179803_e();

    @Accessor(value="fadeOutTime")
    public void setFadeOutTime(int var1);
}

