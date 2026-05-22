/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.util.text.ChatType
 *  net.minecraft.util.text.ITextComponent
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketChat.class})
public interface AccessorSPacketChat {
    @Accessor(value="chatComponent")
    public ITextComponent func_148915_c();

    @Accessor(value="chatComponent")
    public void setChatComponent(ITextComponent var1);

    @Accessor(value="type")
    public ChatType func_192590_c();

    @Accessor(value="type")
    public void setType(ChatType var1);
}

