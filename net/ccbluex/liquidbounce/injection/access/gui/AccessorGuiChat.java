/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiTextField
 */
package net.ccbluex.liquidbounce.injection.access.gui;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiChat.class})
public interface AccessorGuiChat {
    @Accessor(value="inputField")
    public GuiTextField getInputField();

    @Accessor(value="historyBuffer")
    public String getHistoryBuffer();

    @Accessor(value="historyBuffer")
    public void setHistoryBuffer(String var1);

    @Accessor(value="sentHistoryCursor")
    public int getSentHistoryCursor();

    @Accessor(value="sentHistoryCursor")
    public void setSentHistoryCursor(int var1);
}

