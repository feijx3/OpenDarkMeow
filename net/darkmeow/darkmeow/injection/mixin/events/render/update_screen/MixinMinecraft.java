/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.render.update_screen;

import java.util.List;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.render.gui.RenderUpdateScreenEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Shadow
    public GameSettings field_71474_y;
    @Unique
    public List<Runnable> darkMeow$event$postTasks;

    @Inject(method={"displayGuiScreen"}, at={@At(value="HEAD")}, cancellable=true)
    private void displayGuiScreen$callEvent(GuiScreen guiScreenIn, CallbackInfo ci2) {
        try {
            RenderUpdateScreenEvent event = new RenderUpdateScreenEvent(guiScreenIn, this.field_71474_y);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            } else {
                this.darkMeow$event$postTasks = event.getPostTasks();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"displayGuiScreen"}, at={@At(value="RETURN")})
    private void displayGuiScreen$handlePostTasks(GuiScreen guiScreenIn, CallbackInfo ci2) {
        try {
            this.darkMeow$event$postTasks.forEach(Runnable::run);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

