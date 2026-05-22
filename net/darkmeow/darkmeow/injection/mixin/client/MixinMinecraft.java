/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.Util
 *  net.minecraft.util.Util$EnumOS
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.Sys
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.Display
 */
package net.darkmeow.darkmeow.injection.mixin.client;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.KeyEvent;
import net.ccbluex.liquidbounce.event.TickEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.input.LeftClickMouseEvent;
import net.ccbluex.liquidbounce.event.events.input.MiddleClickMouseEvent;
import net.ccbluex.liquidbounce.event.events.input.RightClickMouseEvent;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.injection.forge.StaticStorage;
import net.ccbluex.liquidbounce.ui.client.GuiMainMenu;
import net.ccbluex.liquidbounce.utils.file.ClientInfoUtils;
import net.ccbluex.liquidbounce.utils.render.IconUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.buffer.PersistentMappedVBO;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.ShaderUpdateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Shadow
    public EntityPlayerSP field_71439_g;
    @Shadow
    public GuiScreen field_71462_r;
    @Shadow
    public boolean field_71454_w;
    @Shadow
    public RayTraceResult field_71476_x;
    @Shadow
    public WorldClient field_71441_e;
    @Shadow
    public PlayerControllerMP field_71442_b;
    @Shadow
    private int field_71467_ac;
    @Shadow
    public GameSettings field_71474_y;
    @Shadow
    private int field_71429_W;
    private long lastFrame = this.getTime();

    @Shadow
    @Nullable
    public abstract NetHandlerPlayClient func_147114_u();

    @Inject(method={"init"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;checkGLError(Ljava/lang/String;)V", ordinal=1, shift=At.Shift.AFTER)})
    public void step1(CallbackInfo ci2) {
        ClientInfoUtils.INSTANCE.reload();
    }

    @Inject(method={"init"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;checkGLError(Ljava/lang/String;)V", ordinal=2, shift=At.Shift.AFTER)})
    private void startGame(CallbackInfo callbackInfo) {
        DarkMeow.INSTANCE.startClient();
    }

    @Inject(method={"createDisplay"}, at={@At(value="INVOKE", target="Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V", shift=At.Shift.AFTER, remap=false)})
    private void createDisplay(CallbackInfo callbackInfo) {
        Display.setTitle((String)(DarkMeow.INSTANCE.getCLIENT_NAME() + " " + DarkMeow.INSTANCE.getCLIENT_VERSION()));
    }

    @Inject(method={"displayGuiScreen"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;currentScreen:Lnet/minecraft/client/gui/GuiScreen;", shift=At.Shift.AFTER)})
    private void displayGuiScreen(CallbackInfo callbackInfo) {
        if (this.field_71462_r instanceof net.minecraft.client.gui.GuiMainMenu && !DarkMeow.isDestroy) {
            this.field_71462_r = new GuiMainMenu();
            ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
            this.field_71462_r.func_146280_a(Minecraft.func_71410_x(), scaledResolution.func_78326_a(), scaledResolution.func_78328_b());
            this.field_71454_w = false;
        }
    }

    @Inject(method={"runGameLoop"}, at={@At(value="HEAD")})
    private void runGameLoop(CallbackInfo callbackInfo) {
        long currentTime = this.getTime();
        int deltaTime = (int)(currentTime - this.lastFrame);
        this.lastFrame = currentTime;
        RenderUtils.deltaTime = deltaTime;
    }

    public long getTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    @Inject(method={"runTick"}, at={@At(value="HEAD")})
    private void runTick(CallbackInfo callbackInfo) {
        StaticStorage.scaledResolution = new ScaledResolution((Minecraft)this);
    }

    @Inject(method={"runTick"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;joinPlayerCounter:I", shift=At.Shift.BEFORE)})
    private void onTick(CallbackInfo callbackInfo) {
        DarkMeow.eventManager.callEvent(new TickEvent());
    }

    @Inject(method={"runTickKeyboard"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift=At.Shift.AFTER)})
    private void onKey(CallbackInfo callbackInfo) {
        if (Keyboard.getEventKeyState() && this.field_71462_r == null) {
            DarkMeow.eventManager.callEvent(new KeyEvent(Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey()));
        }
    }

    @Inject(method={"setWindowIcon"}, at={@At(value="HEAD")}, cancellable=true)
    private void setWindowIcon(CallbackInfo ci2) {
        ByteBuffer[] liquidBounceFavicon;
        if (DarkMeow.isDestroy) {
            return;
        }
        if (Util.func_110647_a() != Util.EnumOS.OSX && (liquidBounceFavicon = IconUtils.getFavicon()) != null) {
            Display.setIcon((ByteBuffer[])liquidBounceFavicon);
            ci2.cancel();
        }
    }

    @Inject(method={"shutdown"}, at={@At(value="HEAD")})
    private void shutdown(CallbackInfo callbackInfo) {
        DarkMeow.INSTANCE.stopClient();
    }

    @Inject(method={"clickMouse"}, at={@At(value="HEAD")}, cancellable=true)
    private void clickMouse(CallbackInfo ci2) {
        LeftClickMouseEvent event = new LeftClickMouseEvent(this.field_71429_W);
        DarkMeow.eventManager.callEvent(event);
        this.field_71429_W = event.clickCounter;
        if (event.isCancelled()) {
            ci2.cancel();
        }
    }

    @Inject(method={"middleClickMouse"}, at={@At(value="HEAD")}, cancellable=true)
    private void middleClickMouse(CallbackInfo ci2) {
        MiddleClickMouseEvent event = new MiddleClickMouseEvent();
        DarkMeow.eventManager.callEvent(event);
        if (event.isCancelled()) {
            ci2.cancel();
        }
    }

    @Inject(method={"rightClickMouse"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;rightClickDelayTimer:I", shift=At.Shift.AFTER)}, cancellable=true)
    private void rightClickMouse(CallbackInfo ci2) {
        RightClickMouseEvent event = new RightClickMouseEvent(this.field_71467_ac);
        DarkMeow.eventManager.callEvent(event);
        this.field_71467_ac = event.rightClickDelayTimer;
        if (event.isCancelled()) {
            ci2.cancel();
        }
    }

    @Inject(method={"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"}, at={@At(value="HEAD")})
    private void loadWorld(WorldClient p_loadWorld_1_, String p_loadWorld_2_, CallbackInfo callbackInfo) {
        DarkMeow.eventManager.callEvent(new WorldEvent(p_loadWorld_1_));
    }

    @Inject(method={"getRenderViewEntity"}, at={@At(value="HEAD")})
    public void getRenderViewEntity(CallbackInfoReturnable<Entity> cir) {
        try {
            if (DarkMeow.isDestroy) {
                return;
            }
            Rotation sr = DarkMeow.rotationManager.serverRotation;
            if (!DarkMeow.rotationManager.pauseRotationVisualFix) {
                this.field_71439_g.field_70759_as = sr.yaw;
                this.field_71439_g.field_70761_aq = DarkMeow.movementManager.isMoving(false) && !DarkMeow.movementManager.getStuckManager().isInStuck() ? sr.yaw : MathHelper.func_76131_a((float)this.field_71439_g.field_70761_aq, (float)(sr.yaw - 45.0f), (float)(sr.yaw + 45.0f));
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @ModifyConstant(method={"getLimitFramerate"}, constant={@Constant(intValue=30)})
    private int removeLimitFramerate(int constant) {
        return 60;
    }

    @Inject(method={"runGameLoop"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;isFramerateLimitBelowMax()Z", shift=At.Shift.BEFORE)})
    public void runGameLoop$Inject$INVOKE$isFramerateLimitBelowMax(CallbackInfo ci2) {
        if (!ShaderUpdateManager.disable) {
            PersistentMappedVBO.INSTANCE.onRunGameLoopEnd();
        }
    }
}

