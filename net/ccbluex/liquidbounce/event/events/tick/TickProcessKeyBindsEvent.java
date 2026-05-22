/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.settings.GameSettings
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.tick;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001B\u00b5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u0019\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\"\"\u0004\b;\u0010$R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\"\"\u0004\bC\u0010$R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\"\"\u0004\bG\u0010$R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$\u00a8\u0006J"}, d2={"Lnet/ccbluex/liquidbounce/event/events/tick/TickProcessKeyBindsEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "keyBindTogglePerspectivePressed", "", "keyBindSmoothCameraPressed", "keyBindSaveToolbarKeyDown", "keyBindLoadToolbarKeyDown", "keyBindsHotBarPressed", "", "keyBindInventoryPressed", "keyBindAdvancementsPressed", "keyBindSwapHandsPressed", "keyBindDropPressed", "keyBindDropPressedWithCtrl", "keyBindChatPressed", "keyBindCommandPressed", "isHandActive", "keyBindAttackPressed", "keyBindUseItemPressed", "keyBindPickBlockPressed", "allowProcessRightClick", "allowProcessRightClickBypassDelay", "keyBindUseItemKeyDown", "keyBindAttackKeyDown", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;ZZZZLjava/util/List;ZZZZZZZZZZZZZZZ)V", "gameSettings", "Lnet/minecraft/client/settings/GameSettings;", "(Lnet/minecraft/client/settings/GameSettings;Lnet/minecraft/client/entity/EntityPlayerSP;)V", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "getKeyBindTogglePerspectivePressed", "()Z", "setKeyBindTogglePerspectivePressed", "(Z)V", "getKeyBindSmoothCameraPressed", "setKeyBindSmoothCameraPressed", "getKeyBindSaveToolbarKeyDown", "setKeyBindSaveToolbarKeyDown", "getKeyBindLoadToolbarKeyDown", "setKeyBindLoadToolbarKeyDown", "getKeyBindsHotBarPressed", "()Ljava/util/List;", "getKeyBindInventoryPressed", "setKeyBindInventoryPressed", "getKeyBindAdvancementsPressed", "setKeyBindAdvancementsPressed", "getKeyBindSwapHandsPressed", "setKeyBindSwapHandsPressed", "getKeyBindDropPressed", "setKeyBindDropPressed", "getKeyBindDropPressedWithCtrl", "setKeyBindDropPressedWithCtrl", "getKeyBindChatPressed", "setKeyBindChatPressed", "getKeyBindCommandPressed", "setKeyBindCommandPressed", "setHandActive", "getKeyBindAttackPressed", "setKeyBindAttackPressed", "getKeyBindUseItemPressed", "setKeyBindUseItemPressed", "getKeyBindPickBlockPressed", "setKeyBindPickBlockPressed", "getAllowProcessRightClick", "setAllowProcessRightClick", "getAllowProcessRightClickBypassDelay", "setAllowProcessRightClickBypassDelay", "getKeyBindUseItemKeyDown", "setKeyBindUseItemKeyDown", "getKeyBindAttackKeyDown", "setKeyBindAttackKeyDown", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nTickProcessKeyBindsEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickProcessKeyBindsEvent.kt\nnet/ccbluex/liquidbounce/event/events/tick/TickProcessKeyBindsEvent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class TickProcessKeyBindsEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayerSP player;
    private boolean keyBindTogglePerspectivePressed;
    private boolean keyBindSmoothCameraPressed;
    private boolean keyBindSaveToolbarKeyDown;
    private boolean keyBindLoadToolbarKeyDown;
    @NotNull
    private final List<Boolean> keyBindsHotBarPressed;
    private boolean keyBindInventoryPressed;
    private boolean keyBindAdvancementsPressed;
    private boolean keyBindSwapHandsPressed;
    private boolean keyBindDropPressed;
    private boolean keyBindDropPressedWithCtrl;
    private boolean keyBindChatPressed;
    private boolean keyBindCommandPressed;
    private boolean isHandActive;
    private boolean keyBindAttackPressed;
    private boolean keyBindUseItemPressed;
    private boolean keyBindPickBlockPressed;
    private boolean allowProcessRightClick;
    private boolean allowProcessRightClickBypassDelay;
    private boolean keyBindUseItemKeyDown;
    private boolean keyBindAttackKeyDown;

    public TickProcessKeyBindsEvent(@NotNull EntityPlayerSP player, boolean keyBindTogglePerspectivePressed, boolean keyBindSmoothCameraPressed, boolean keyBindSaveToolbarKeyDown, boolean keyBindLoadToolbarKeyDown, @NotNull List<Boolean> keyBindsHotBarPressed, boolean keyBindInventoryPressed, boolean keyBindAdvancementsPressed, boolean keyBindSwapHandsPressed, boolean keyBindDropPressed, boolean keyBindDropPressedWithCtrl, boolean keyBindChatPressed, boolean keyBindCommandPressed, boolean isHandActive, boolean keyBindAttackPressed, boolean keyBindUseItemPressed, boolean keyBindPickBlockPressed, boolean allowProcessRightClick, boolean allowProcessRightClickBypassDelay, boolean keyBindUseItemKeyDown, boolean keyBindAttackKeyDown) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(keyBindsHotBarPressed, "keyBindsHotBarPressed");
        this.player = player;
        this.keyBindTogglePerspectivePressed = keyBindTogglePerspectivePressed;
        this.keyBindSmoothCameraPressed = keyBindSmoothCameraPressed;
        this.keyBindSaveToolbarKeyDown = keyBindSaveToolbarKeyDown;
        this.keyBindLoadToolbarKeyDown = keyBindLoadToolbarKeyDown;
        this.keyBindsHotBarPressed = keyBindsHotBarPressed;
        this.keyBindInventoryPressed = keyBindInventoryPressed;
        this.keyBindAdvancementsPressed = keyBindAdvancementsPressed;
        this.keyBindSwapHandsPressed = keyBindSwapHandsPressed;
        this.keyBindDropPressed = keyBindDropPressed;
        this.keyBindDropPressedWithCtrl = keyBindDropPressedWithCtrl;
        this.keyBindChatPressed = keyBindChatPressed;
        this.keyBindCommandPressed = keyBindCommandPressed;
        this.isHandActive = isHandActive;
        this.keyBindAttackPressed = keyBindAttackPressed;
        this.keyBindUseItemPressed = keyBindUseItemPressed;
        this.keyBindPickBlockPressed = keyBindPickBlockPressed;
        this.allowProcessRightClick = allowProcessRightClick;
        this.allowProcessRightClickBypassDelay = allowProcessRightClickBypassDelay;
        this.keyBindUseItemKeyDown = keyBindUseItemKeyDown;
        this.keyBindAttackKeyDown = keyBindAttackKeyDown;
    }

    @NotNull
    public final EntityPlayerSP getPlayer() {
        return this.player;
    }

    public final boolean getKeyBindTogglePerspectivePressed() {
        return this.keyBindTogglePerspectivePressed;
    }

    public final void setKeyBindTogglePerspectivePressed(boolean bl2) {
        this.keyBindTogglePerspectivePressed = bl2;
    }

    public final boolean getKeyBindSmoothCameraPressed() {
        return this.keyBindSmoothCameraPressed;
    }

    public final void setKeyBindSmoothCameraPressed(boolean bl2) {
        this.keyBindSmoothCameraPressed = bl2;
    }

    public final boolean getKeyBindSaveToolbarKeyDown() {
        return this.keyBindSaveToolbarKeyDown;
    }

    public final void setKeyBindSaveToolbarKeyDown(boolean bl2) {
        this.keyBindSaveToolbarKeyDown = bl2;
    }

    public final boolean getKeyBindLoadToolbarKeyDown() {
        return this.keyBindLoadToolbarKeyDown;
    }

    public final void setKeyBindLoadToolbarKeyDown(boolean bl2) {
        this.keyBindLoadToolbarKeyDown = bl2;
    }

    @NotNull
    public final List<Boolean> getKeyBindsHotBarPressed() {
        return this.keyBindsHotBarPressed;
    }

    public final boolean getKeyBindInventoryPressed() {
        return this.keyBindInventoryPressed;
    }

    public final void setKeyBindInventoryPressed(boolean bl2) {
        this.keyBindInventoryPressed = bl2;
    }

    public final boolean getKeyBindAdvancementsPressed() {
        return this.keyBindAdvancementsPressed;
    }

    public final void setKeyBindAdvancementsPressed(boolean bl2) {
        this.keyBindAdvancementsPressed = bl2;
    }

    public final boolean getKeyBindSwapHandsPressed() {
        return this.keyBindSwapHandsPressed;
    }

    public final void setKeyBindSwapHandsPressed(boolean bl2) {
        this.keyBindSwapHandsPressed = bl2;
    }

    public final boolean getKeyBindDropPressed() {
        return this.keyBindDropPressed;
    }

    public final void setKeyBindDropPressed(boolean bl2) {
        this.keyBindDropPressed = bl2;
    }

    public final boolean getKeyBindDropPressedWithCtrl() {
        return this.keyBindDropPressedWithCtrl;
    }

    public final void setKeyBindDropPressedWithCtrl(boolean bl2) {
        this.keyBindDropPressedWithCtrl = bl2;
    }

    public final boolean getKeyBindChatPressed() {
        return this.keyBindChatPressed;
    }

    public final void setKeyBindChatPressed(boolean bl2) {
        this.keyBindChatPressed = bl2;
    }

    public final boolean getKeyBindCommandPressed() {
        return this.keyBindCommandPressed;
    }

    public final void setKeyBindCommandPressed(boolean bl2) {
        this.keyBindCommandPressed = bl2;
    }

    public final boolean isHandActive() {
        return this.isHandActive;
    }

    public final void setHandActive(boolean bl2) {
        this.isHandActive = bl2;
    }

    public final boolean getKeyBindAttackPressed() {
        return this.keyBindAttackPressed;
    }

    public final void setKeyBindAttackPressed(boolean bl2) {
        this.keyBindAttackPressed = bl2;
    }

    public final boolean getKeyBindUseItemPressed() {
        return this.keyBindUseItemPressed;
    }

    public final void setKeyBindUseItemPressed(boolean bl2) {
        this.keyBindUseItemPressed = bl2;
    }

    public final boolean getKeyBindPickBlockPressed() {
        return this.keyBindPickBlockPressed;
    }

    public final void setKeyBindPickBlockPressed(boolean bl2) {
        this.keyBindPickBlockPressed = bl2;
    }

    public final boolean getAllowProcessRightClick() {
        return this.allowProcessRightClick;
    }

    public final void setAllowProcessRightClick(boolean bl2) {
        this.allowProcessRightClick = bl2;
    }

    public final boolean getAllowProcessRightClickBypassDelay() {
        return this.allowProcessRightClickBypassDelay;
    }

    public final void setAllowProcessRightClickBypassDelay(boolean bl2) {
        this.allowProcessRightClickBypassDelay = bl2;
    }

    public final boolean getKeyBindUseItemKeyDown() {
        return this.keyBindUseItemKeyDown;
    }

    public final void setKeyBindUseItemKeyDown(boolean bl2) {
        this.keyBindUseItemKeyDown = bl2;
    }

    public final boolean getKeyBindAttackKeyDown() {
        return this.keyBindAttackKeyDown;
    }

    public final void setKeyBindAttackKeyDown(boolean bl2) {
        this.keyBindAttackKeyDown = bl2;
    }

    /*
     * WARNING - void declaration
     */
    public TickProcessKeyBindsEvent(@NotNull GameSettings gameSettings, @NotNull EntityPlayerSP player) {
        ArrayList<Boolean> arrayList;
        Intrinsics.checkNotNullParameter(gameSettings, "gameSettings");
        Intrinsics.checkNotNullParameter(player, "player");
        int n2 = 9;
        boolean bl2 = gameSettings.field_193630_aq.func_151470_d();
        boolean bl3 = gameSettings.field_193629_ap.func_151470_d();
        boolean bl4 = gameSettings.field_151458_ab.func_151468_f();
        boolean bl5 = gameSettings.field_151457_aa.func_151468_f();
        EntityPlayerSP entityPlayerSP = player;
        TickProcessKeyBindsEvent tickProcessKeyBindsEvent = this;
        ArrayList<Boolean> arrayList2 = new ArrayList<Boolean>(n2);
        int n3 = 0;
        while (n3 < n2) {
            void index;
            int n4;
            int n5 = n4 = n3++;
            arrayList = arrayList2;
            boolean bl6 = false;
            arrayList.add(gameSettings.field_151456_ac[index].func_151468_f());
        }
        arrayList = arrayList2;
        tickProcessKeyBindsEvent(entityPlayerSP, bl5, bl4, bl3, bl2, arrayList, gameSettings.field_151445_Q.func_151468_f(), gameSettings.field_194146_ao.func_151468_f(), gameSettings.field_186718_X.func_151468_f(), gameSettings.field_74316_C.func_151468_f(), GuiScreen.func_146271_m(), gameSettings.field_74310_D.func_151468_f(), gameSettings.field_74323_J.func_151468_f(), player.func_184587_cr(), gameSettings.field_74312_F.func_151468_f(), gameSettings.field_74313_G.func_151468_f(), gameSettings.field_74322_I.func_151468_f(), !player.func_184587_cr(), false, gameSettings.field_74313_G.func_151470_d(), gameSettings.field_74312_F.func_151470_d());
    }
}

