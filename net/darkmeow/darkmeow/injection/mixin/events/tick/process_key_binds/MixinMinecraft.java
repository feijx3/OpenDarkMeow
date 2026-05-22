/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.tick.process_key_binds;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.tick.TickProcessKeyBindsEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Shadow
    public GameSettings field_71474_y;
    @Shadow
    private int field_71467_ac;
    @Shadow
    public EntityPlayerSP field_71439_g;
    @Unique
    public TickProcessKeyBindsEvent darkMeow_event;
    @Unique
    public int darkMeow_hotBarIndex = -1;

    @Inject(method={"processKeyBinds"}, at={@At(value="HEAD")}, cancellable=true)
    private void processKeyBinds$callEvent(CallbackInfo ci2) {
        EntityPlayerSP playerSP = this.field_71439_g;
        if (playerSP != null) {
            TickProcessKeyBindsEvent event = new TickProcessKeyBindsEvent(this.field_71474_y, playerSP);
            DarkMeow.eventManager.callEvent(event);
            if (event.isCancelled()) {
                ci2.cancel();
            } else {
                this.darkMeow_hotBarIndex = -1;
                this.darkMeow_event = event;
            }
        } else {
            ci2.cancel();
        }
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=0))
    private boolean processKeyBinds$redirct$keyBindTogglePerspective(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindTogglePerspectivePressed();
        this.darkMeow_event.setKeyBindTogglePerspectivePressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=1))
    private boolean processKeyBinds$redirect$keyBindSmoothCamera(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindSmoothCameraPressed();
        this.darkMeow_event.setKeyBindSmoothCameraPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=0))
    private boolean processKeyBinds$redirect$keyBindSaveToolbar(KeyBinding instance) {
        return this.darkMeow_event.getKeyBindSaveToolbarKeyDown();
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=1))
    private boolean processKeyBinds$redirect$keyBindLoadToolbar(KeyBinding instance) {
        return this.darkMeow_event.getKeyBindLoadToolbarKeyDown();
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=2))
    private boolean processKeyBinds$redirect$keyBindsHotbar(KeyBinding instance) {
        try {
            ++this.darkMeow_hotBarIndex;
            boolean flag = this.darkMeow_event.getKeyBindsHotBarPressed().get(this.darkMeow_hotBarIndex);
            this.darkMeow_event.getKeyBindsHotBarPressed().set(this.darkMeow_hotBarIndex, false);
            return flag;
        }
        catch (Throwable e2) {
            return instance.func_151468_f();
        }
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=3))
    private boolean processKeyBinds$redirect$keyBindInventory(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindInventoryPressed();
        this.darkMeow_event.setKeyBindInventoryPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=4))
    private boolean processKeyBinds$redirect$keyBindAdvancements(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindAdvancementsPressed();
        this.darkMeow_event.setKeyBindAdvancementsPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=5))
    private boolean processKeyBinds$redirect$keyBindSwapHands(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindSwapHandsPressed();
        this.darkMeow_event.setKeyBindSwapHandsPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=6))
    private boolean processKeyBinds$redirect$keyBindDrop(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindDropPressed();
        this.darkMeow_event.setKeyBindDropPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiScreen;isCtrlKeyDown()Z"))
    private boolean processKeyBinds$redirect$keyBindDropWithCtrl() {
        return this.darkMeow_event.getKeyBindDropPressedWithCtrl();
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=7))
    private boolean processKeyBinds$redirect$keyBindChat(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindChatPressed();
        this.darkMeow_event.setKeyBindChatPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=8))
    private boolean processKeyBinds$redirect$keyBindCommand(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindCommandPressed();
        this.darkMeow_event.setKeyBindCommandPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isHandActive()Z", ordinal=0))
    private boolean processKeyBinds$redirect$isHandAactive(EntityPlayerSP instance) {
        return this.darkMeow_event.isHandActive();
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=10))
    private boolean processKeyBinds$redirect$keyBindUseItemA(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindUseItemPressed();
        this.darkMeow_event.setKeyBindUseItemPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=13))
    private boolean processKeyBinds$redirect$keyBindUseItemB(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindUseItemPressed();
        this.darkMeow_event.setKeyBindUseItemPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=9))
    private boolean processKeyBinds$redirect$keyBindAttackA(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindAttackPressed();
        this.darkMeow_event.setKeyBindAttackPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=12))
    private boolean processKeyBinds$redirect$keyBindAttackB(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindAttackPressed();
        this.darkMeow_event.setKeyBindAttackPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=11))
    private boolean processKeyBinds$redirect$keyBindPickBlockA(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindPickBlockPressed();
        this.darkMeow_event.setKeyBindPickBlockPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal=14))
    private boolean processKeyBinds$redirect$keyBindPickBlockB(KeyBinding instance) {
        boolean flag = this.darkMeow_event.getKeyBindPickBlockPressed();
        this.darkMeow_event.setKeyBindPickBlockPressed(false);
        return flag;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;rightClickDelayTimer:I"))
    private int processKeyBinds$redirect$ignoreDelay(Minecraft instance) {
        return this.darkMeow_event.getAllowProcessRightClickBypassDelay() ? 0 : this.field_71467_ac;
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=3))
    private boolean processKeyBinds$redirect$keyBindUseItemKeyDown(KeyBinding instance) {
        return this.darkMeow_event.getKeyBindUseItemKeyDown();
    }

    @Redirect(method={"processKeyBinds"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z", ordinal=4))
    private boolean processKeyBinds$redirect$keyBindAttackKeyDown(KeyBinding instance) {
        return this.darkMeow_event.getKeyBindAttackKeyDown();
    }
}

