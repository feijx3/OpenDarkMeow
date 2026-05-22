/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="GuiTweaks", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u0005H\u0007J\b\u0010\u001e\u001a\u00020\u0005H\u0007J\b\u0010\u001f\u001a\u00020\u0005H\u0007J\b\u0010 \u001a\u00020\u0005H\u0007J\b\u0010!\u001a\u00020\u0005H\u0007J\b\u0010\"\u001a\u00020\u0005H\u0007J\b\u0010#\u001a\u00020\u0005H\u0007J\b\u0010$\u001a\u00020\u0005H\u0007J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/GuiTweaks;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "status", "", "getStatus", "()Z", "setStatus", "(Z)V", "guiTextValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "guiTextComponentOnHoverValue", "Lnet/ccbluex/liquidbounce/value/Value;", "guiContainerValue", "guiContainerButtonDisconnectValue", "guiContainerButtonReconnectValue", "guiContainerAnimationValue", "", "guiContainerRemoveBackgroundValue", "guiChatValue", "guiChatFadeValue", "guiChatRemoveInputLengthLimitValue", "guiTabPlayerListValue", "guiTabPlayerListAnimationsValue", "guiConnectingValue", "guiConnectingRemoveDownloadTerrainValue", "guiConnectingTipsValue", "guiConnectingReconnectButtonValue", "isGuiTextActive", "isGuiTextComponentOnHoverActive", "isGuiContainerActive", "isGuiChatActive", "isGuiChatFadeActive", "isGuiChatRemoveInputLengthLimitActive", "isGuiTabPlayerListActive", "isGuiConnectingActive", "onEnable", "", "onDisable", "DarkMeow"})
public final class GuiTweaks
extends Module {
    @NotNull
    public static final GuiTweaks INSTANCE = new GuiTweaks();
    private static boolean status;
    @JvmField
    @NotNull
    public static final BoolValue guiTextValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiTextComponentOnHoverValue;
    @JvmField
    @NotNull
    public static final BoolValue guiContainerValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiContainerButtonDisconnectValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiContainerButtonReconnectValue;
    @JvmField
    @NotNull
    public static final Value<String> guiContainerAnimationValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiContainerRemoveBackgroundValue;
    @JvmField
    @NotNull
    public static final BoolValue guiChatValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiChatFadeValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiChatRemoveInputLengthLimitValue;
    @JvmField
    @NotNull
    public static final BoolValue guiTabPlayerListValue;
    @JvmField
    @NotNull
    public static final Value<String> guiTabPlayerListAnimationsValue;
    @JvmField
    @NotNull
    public static final BoolValue guiConnectingValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiConnectingRemoveDownloadTerrainValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiConnectingTipsValue;
    @JvmField
    @NotNull
    public static final Value<Boolean> guiConnectingReconnectButtonValue;

    private GuiTweaks() {
        super(null, null, null, null, 15, null);
    }

    public final boolean getStatus() {
        return status;
    }

    public final void setStatus(boolean bl2) {
        status = bl2;
    }

    @JvmStatic
    public static final boolean isGuiTextActive() {
        return status && (Boolean)guiTextValue.get() != false;
    }

    @JvmStatic
    public static final boolean isGuiTextComponentOnHoverActive() {
        return INSTANCE.isGuiTextActive() && guiTextComponentOnHoverValue.get() != false;
    }

    @JvmStatic
    public static final boolean isGuiContainerActive() {
        return status && (Boolean)guiContainerValue.get() != false;
    }

    @JvmStatic
    public static final boolean isGuiChatActive() {
        return status && (Boolean)guiChatValue.get() != false;
    }

    @JvmStatic
    public static final boolean isGuiChatFadeActive() {
        return INSTANCE.isGuiChatActive() && guiChatFadeValue.get() != false;
    }

    @JvmStatic
    public static final boolean isGuiChatRemoveInputLengthLimitActive() {
        return INSTANCE.isGuiChatActive() && guiChatRemoveInputLengthLimitValue.get() != false;
    }

    @JvmStatic
    public static final boolean isGuiTabPlayerListActive() {
        return status && (Boolean)guiTabPlayerListValue.get() != false;
    }

    @JvmStatic
    public static final boolean isGuiConnectingActive() {
        return status && (Boolean)guiConnectingValue.get() != false;
    }

    @Override
    public void onEnable() {
        status = true;
    }

    @Override
    public void onDisable() {
        status = false;
    }

    private static final boolean guiTextComponentOnHoverValue$lambda$0() {
        return (Boolean)guiTextValue.get();
    }

    private static final boolean guiContainerButtonDisconnectValue$lambda$1() {
        return (Boolean)guiContainerValue.get();
    }

    private static final boolean guiContainerButtonReconnectValue$lambda$2() {
        return (Boolean)guiContainerValue.get();
    }

    private static final boolean guiContainerAnimationValue$lambda$3() {
        return (Boolean)guiContainerValue.get();
    }

    private static final boolean guiContainerRemoveBackgroundValue$lambda$4() {
        return (Boolean)guiContainerValue.get();
    }

    private static final boolean guiChatFadeValue$lambda$5() {
        return (Boolean)guiChatValue.get();
    }

    private static final boolean guiChatRemoveInputLengthLimitValue$lambda$6() {
        return (Boolean)guiChatValue.get();
    }

    private static final boolean guiTabPlayerListAnimationsValue$lambda$7() {
        return (Boolean)guiTabPlayerListValue.get();
    }

    private static final boolean guiConnectingRemoveDownloadTerrainValue$lambda$8() {
        return (Boolean)guiConnectingValue.get();
    }

    private static final boolean guiConnectingTipsValue$lambda$9() {
        return (Boolean)guiConnectingValue.get();
    }

    private static final boolean guiConnectingReconnectButtonValue$lambda$10() {
        return (Boolean)guiConnectingValue.get();
    }

    static {
        guiTextValue = new BoolValue("GuiText", true);
        guiTextComponentOnHoverValue = new BoolValue("GuiTextComponentOnHover", true).displayable(GuiTweaks::guiTextComponentOnHoverValue$lambda$0);
        guiContainerValue = new BoolValue("GuiContainer", true);
        guiContainerButtonDisconnectValue = new BoolValue("GuiContainerButtonDisconnect", true).displayable(GuiTweaks::guiContainerButtonDisconnectValue$lambda$1);
        guiContainerButtonReconnectValue = new BoolValue("GuiContainerButtonReconnect", true).displayable(GuiTweaks::guiContainerButtonReconnectValue$lambda$2);
        String[] stringArray = new String[]{"None", "Zoom", "VSlide", "HSlide", "HVSlide"};
        guiContainerAnimationValue = new ListValue("GuiContainerAnimation", stringArray, "Zoom").displayable(GuiTweaks::guiContainerAnimationValue$lambda$3);
        guiContainerRemoveBackgroundValue = new BoolValue("GuiContainerRemoveBackground", false).displayable(GuiTweaks::guiContainerRemoveBackgroundValue$lambda$4);
        guiChatValue = new BoolValue("GuiChat", true);
        guiChatFadeValue = new BoolValue("GuiChatFade", true).displayable(GuiTweaks::guiChatFadeValue$lambda$5);
        guiChatRemoveInputLengthLimitValue = new BoolValue("GuiChatRemoveInputLengthLimit", true).displayable(GuiTweaks::guiChatRemoveInputLengthLimitValue$lambda$6);
        guiTabPlayerListValue = new BoolValue("GuiTabPlayerList", true);
        stringArray = new String[]{"None", "Zoom", "Slide"};
        guiTabPlayerListAnimationsValue = new ListValue("GuiTabPlayerListAnimations", stringArray, "Zoom").displayable(GuiTweaks::guiTabPlayerListAnimationsValue$lambda$7);
        guiConnectingValue = new BoolValue("GuiConnecting", true);
        guiConnectingRemoveDownloadTerrainValue = new BoolValue("GuiConnectingRemoveDownloadTerrain", true).displayable(GuiTweaks::guiConnectingRemoveDownloadTerrainValue$lambda$8);
        guiConnectingTipsValue = new BoolValue("GuiConnectingTips", false).displayable(GuiTweaks::guiConnectingTipsValue$lambda$9);
        guiConnectingReconnectButtonValue = new BoolValue("GuiConnectingReconnectButton", true).displayable(GuiTweaks::guiConnectingReconnectButtonValue$lambda$10);
    }
}

