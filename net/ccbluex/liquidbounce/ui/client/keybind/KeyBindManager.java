/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.ui.client.keybind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.ui.client.keybind.KeyInfo;
import net.ccbluex.liquidbounce.ui.client.keybind.PopUI;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ \u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0014J\b\u0010$\u001a\u00020\u001bH\u0016J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0014J\b\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006+"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyBindManager;", "Lnet/minecraft/client/gui/GuiScreen;", "<init>", "()V", "baseHeight", "", "baseWidth", "keys", "Ljava/util/ArrayList;", "Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyInfo;", "Lkotlin/collections/ArrayList;", "nowDisplayKey", "getNowDisplayKey", "()Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyInfo;", "setNowDisplayKey", "(Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyInfo;)V", "popUI", "Lnet/ccbluex/liquidbounce/ui/client/keybind/PopUI;", "getPopUI", "()Lnet/ccbluex/liquidbounce/ui/client/keybind/PopUI;", "setPopUI", "(Lnet/ccbluex/liquidbounce/ui/client/keybind/PopUI;)V", "font", "Lnet/minecraft/client/gui/FontRenderer;", "getFont", "()Lnet/minecraft/client/gui/FontRenderer;", "initGui", "", "updateAllKeys", "drawScreen", "mouseX", "mouseY", "partialTicks", "", "mouseClicked", "mouseButton", "onGuiClosed", "keyTyped", "typedChar", "", "keyCode", "doesGuiPauseGame", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nKeyBindManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KeyBindManager.kt\nnet/ccbluex/liquidbounce/ui/client/keybind/KeyBindManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,196:1\n1869#2,2:197\n*S KotlinDebug\n*F\n+ 1 KeyBindManager.kt\nnet/ccbluex/liquidbounce/ui/client/keybind/KeyBindManager\n*L\n52#1:197,2\n*E\n"})
public final class KeyBindManager
extends GuiScreen {
    private final int baseHeight;
    private final int baseWidth;
    @NotNull
    private final ArrayList<KeyInfo> keys = new ArrayList();
    @Nullable
    private KeyInfo nowDisplayKey;
    @Nullable
    private PopUI popUI;
    @NotNull
    private final FontRenderer font = Fonts.minecraftFont;

    public KeyBindManager() {
        this.baseHeight = 205;
        this.baseWidth = 500;
        this.keys.add(new KeyInfo(this.font, 12.0f, 12.0f, 27.0f, 32.0f, 41, "`"));
        this.keys.add(new KeyInfo(this.font, 44.0f, 12.0f, 27.0f, 32.0f, 2, "1"));
        this.keys.add(new KeyInfo(this.font, 76.0f, 12.0f, 27.0f, 32.0f, 3, "2"));
        this.keys.add(new KeyInfo(this.font, 108.0f, 12.0f, 27.0f, 32.0f, 4, "3"));
        this.keys.add(new KeyInfo(this.font, 140.0f, 12.0f, 27.0f, 32.0f, 5, "4"));
        this.keys.add(new KeyInfo(this.font, 172.0f, 12.0f, 27.0f, 32.0f, 6, "5"));
        this.keys.add(new KeyInfo(this.font, 204.0f, 12.0f, 27.0f, 32.0f, 7, "6"));
        this.keys.add(new KeyInfo(this.font, 236.0f, 12.0f, 27.0f, 32.0f, 8, "7"));
        this.keys.add(new KeyInfo(this.font, 268.0f, 12.0f, 27.0f, 32.0f, 9, "8"));
        this.keys.add(new KeyInfo(this.font, 300.0f, 12.0f, 27.0f, 32.0f, 10, "9"));
        this.keys.add(new KeyInfo(this.font, 332.0f, 12.0f, 27.0f, 32.0f, 11, "0"));
        this.keys.add(new KeyInfo(this.font, 364.0f, 12.0f, 27.0f, 32.0f, 12, "-"));
        this.keys.add(new KeyInfo(this.font, 396.0f, 12.0f, 27.0f, 32.0f, 13, "="));
        this.keys.add(new KeyInfo(this.font, 428.0f, 12.0f, 59.0f, 32.0f, 14, "<--"));
        this.keys.add(new KeyInfo(this.font, 12.0f, 49.0f, 43.0f, 32.0f, 15, "Tab"));
        this.keys.add(new KeyInfo(this.font, 60.0f, 49.0f, 27.0f, 32.0f, 16, "Q"));
        this.keys.add(new KeyInfo(this.font, 92.0f, 49.0f, 27.0f, 32.0f, 17, "W"));
        this.keys.add(new KeyInfo(this.font, 124.0f, 49.0f, 27.0f, 32.0f, 18, "E"));
        this.keys.add(new KeyInfo(this.font, 156.0f, 49.0f, 27.0f, 32.0f, 19, "R"));
        this.keys.add(new KeyInfo(this.font, 188.0f, 49.0f, 27.0f, 32.0f, 20, "T"));
        this.keys.add(new KeyInfo(this.font, 220.0f, 49.0f, 27.0f, 32.0f, 21, "Y"));
        this.keys.add(new KeyInfo(this.font, 252.0f, 49.0f, 27.0f, 32.0f, 22, "U"));
        this.keys.add(new KeyInfo(this.font, 284.0f, 49.0f, 27.0f, 32.0f, 23, "I"));
        this.keys.add(new KeyInfo(this.font, 316.0f, 49.0f, 27.0f, 32.0f, 24, "O"));
        this.keys.add(new KeyInfo(this.font, 348.0f, 49.0f, 27.0f, 32.0f, 25, "P"));
        this.keys.add(new KeyInfo(this.font, 380.0f, 49.0f, 27.0f, 32.0f, 26, "["));
        this.keys.add(new KeyInfo(this.font, 412.0f, 49.0f, 27.0f, 32.0f, 27, "]"));
        this.keys.add(new KeyInfo(this.font, 444.0f, 49.0f, 43.0f, 32.0f, 43, "\\"));
        this.keys.add(new KeyInfo(this.font, 12.0f, 86.0f, 59.0f, 32.0f, 15, "Caps"));
        this.keys.add(new KeyInfo(this.font, 76.0f, 86.0f, 27.0f, 32.0f, 30, "A"));
        this.keys.add(new KeyInfo(this.font, 108.0f, 86.0f, 27.0f, 32.0f, 31, "S"));
        this.keys.add(new KeyInfo(this.font, 140.0f, 86.0f, 27.0f, 32.0f, 32, "D"));
        this.keys.add(new KeyInfo(this.font, 172.0f, 86.0f, 27.0f, 32.0f, 33, "F"));
        this.keys.add(new KeyInfo(this.font, 204.0f, 86.0f, 27.0f, 32.0f, 34, "G"));
        this.keys.add(new KeyInfo(this.font, 236.0f, 86.0f, 27.0f, 32.0f, 35, "H"));
        this.keys.add(new KeyInfo(this.font, 268.0f, 86.0f, 27.0f, 32.0f, 36, "J"));
        this.keys.add(new KeyInfo(this.font, 300.0f, 86.0f, 27.0f, 32.0f, 37, "K"));
        this.keys.add(new KeyInfo(this.font, 332.0f, 86.0f, 27.0f, 32.0f, 38, "L"));
        this.keys.add(new KeyInfo(this.font, 364.0f, 86.0f, 27.0f, 32.0f, 39, ";"));
        this.keys.add(new KeyInfo(this.font, 396.0f, 86.0f, 27.0f, 32.0f, 40, "'"));
        this.keys.add(new KeyInfo(this.font, 428.0f, 86.0f, 59.0f, 32.0f, 28, "Enter"));
        this.keys.add(new KeyInfo(this.font, 12.0f, 123.0f, 75.0f, 32.0f, 42, "Shift", "LShift"));
        this.keys.add(new KeyInfo(this.font, 92.0f, 123.0f, 27.0f, 32.0f, 44, "Z"));
        this.keys.add(new KeyInfo(this.font, 124.0f, 123.0f, 27.0f, 32.0f, 45, "X"));
        this.keys.add(new KeyInfo(this.font, 156.0f, 123.0f, 27.0f, 32.0f, 46, "C"));
        this.keys.add(new KeyInfo(this.font, 188.0f, 123.0f, 27.0f, 32.0f, 47, "V"));
        this.keys.add(new KeyInfo(this.font, 220.0f, 123.0f, 27.0f, 32.0f, 48, "B"));
        this.keys.add(new KeyInfo(this.font, 252.0f, 123.0f, 27.0f, 32.0f, 49, "N"));
        this.keys.add(new KeyInfo(this.font, 284.0f, 123.0f, 27.0f, 32.0f, 50, "M"));
        this.keys.add(new KeyInfo(this.font, 316.0f, 123.0f, 27.0f, 32.0f, 51, ","));
        this.keys.add(new KeyInfo(this.font, 348.0f, 123.0f, 27.0f, 32.0f, 52, "."));
        this.keys.add(new KeyInfo(this.font, 380.0f, 123.0f, 27.0f, 32.0f, 53, "/"));
        this.keys.add(new KeyInfo(this.font, 412.0f, 123.0f, 75.0f, 32.0f, 54, "Shift", "RShift"));
        this.keys.add(new KeyInfo(this.font, 12.0f, 160.0f, 43.0f, 32.0f, 29, "Ctrl", "LCtrl"));
        this.keys.add(new KeyInfo(this.font, 60.0f, 160.0f, 43.0f, 32.0f, 56, "Alt", "LAlt"));
        this.keys.add(new KeyInfo(this.font, 108.0f, 160.0f, 251.0f, 32.0f, 57, " ", "Space"));
        this.keys.add(new KeyInfo(this.font, 364.0f, 160.0f, 43.0f, 32.0f, 184, "Alt", "RAlt"));
        this.keys.add(new KeyInfo(this.font, 412.0f, 160.0f, 27.0f, 32.0f, 199, "\u00d8", "Home"));
        this.keys.add(new KeyInfo(this.font, 444.0f, 160.0f, 43.0f, 32.0f, 157, "Ctrl", "RCtrl"));
    }

    @Nullable
    public final KeyInfo getNowDisplayKey() {
        return this.nowDisplayKey;
    }

    public final void setNowDisplayKey(@Nullable KeyInfo keyInfo) {
        this.nowDisplayKey = keyInfo;
    }

    @Nullable
    public final PopUI getPopUI() {
        return this.popUI;
    }

    public final void setPopUI(@Nullable PopUI popUI) {
        this.popUI = popUI;
    }

    @NotNull
    public final FontRenderer getFont() {
        return this.font;
    }

    public void func_73866_w_() {
        this.nowDisplayKey = null;
        this.popUI = null;
        this.updateAllKeys();
    }

    public final void updateAllKeys() {
        new Thread(() -> KeyBindManager.updateAllKeys$lambda$0(this)).start();
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        block6: {
            int wheel;
            DarkMeow.INSTANCE.getClickGuiManager().getCui().drawBackground();
            int mcWidth = (int)((float)this.field_146294_l * 0.8f - (float)this.field_146294_l * 0.2f);
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b((float)((float)this.field_146294_l * 0.2f), (float)((float)this.field_146295_m * 0.2f + (float)this.font.field_78288_b * 2.3f), (float)0.0f);
            float scale = (float)mcWidth / (float)this.baseWidth;
            GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
            RenderUtils.drawRect(0.0f, 0.0f, (float)this.baseWidth, (float)this.baseHeight, new Color(120, 120, 120, 120));
            Iterable $this$forEach$iv = this.keys;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                KeyInfo it = (KeyInfo)element$iv;
                boolean bl2 = false;
                it.render();
            }
            KeyInfo keyInfo = this.nowDisplayKey;
            if (keyInfo != null) {
                keyInfo.renderTab();
            }
            GlStateManager.func_179121_F();
            if (Mouse.hasWheel() && (wheel = Mouse.getDWheel()) != 0) {
                if (this.popUI != null) {
                    PopUI popUI = this.popUI;
                    Intrinsics.checkNotNull(popUI);
                    popUI.onStroll(this.field_146294_l, this.field_146295_m, mouseX, mouseY, wheel);
                } else if (this.nowDisplayKey != null) {
                    float scaledMouseX = ((float)mouseX - (float)this.field_146294_l * 0.2f) / scale;
                    float scaledMouseY = ((float)mouseY - ((float)this.field_146295_m * 0.2f + (float)this.font.field_78288_b * 2.3f)) / scale;
                    KeyInfo keyInfo2 = this.nowDisplayKey;
                    Intrinsics.checkNotNull(keyInfo2);
                    keyInfo2.stroll(scaledMouseX, scaledMouseY, wheel);
                }
            }
            PopUI popUI = this.popUI;
            if (popUI == null) break block6;
            popUI.onRender(this.field_146294_l, this.field_146295_m);
        }
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
        if (this.popUI == null) {
            float scale = ((float)this.field_146294_l * 0.8f - (float)this.field_146294_l * 0.2f) / (float)this.baseWidth;
            float scaledMouseX = ((float)mouseX - (float)this.field_146294_l * 0.2f) / scale;
            float scaledMouseY = ((float)mouseY - ((float)this.field_146295_m * 0.2f + (float)this.font.field_78288_b * 2.3f)) / scale;
            if (this.nowDisplayKey == null) {
                if (scaledMouseX < 0.0f || scaledMouseY < 0.0f || scaledMouseX > (float)this.baseWidth || scaledMouseY > (float)this.baseHeight) {
                    this.field_146297_k.func_147108_a(null);
                    return;
                }
                Iterator<KeyInfo> iterator2 = this.keys.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator2, "iterator(...)");
                Iterator<KeyInfo> iterator3 = iterator2;
                while (iterator3.hasNext()) {
                    KeyInfo key;
                    Intrinsics.checkNotNullExpressionValue(iterator3.next(), "next(...)");
                    if (!(scaledMouseX > key.getPosX()) || !(scaledMouseY > key.getPosY()) || !(scaledMouseX < key.getPosX() + key.getWidth()) || !(scaledMouseY < key.getPosY() + key.getHeight())) continue;
                    key.click(scaledMouseX, scaledMouseY);
                    break;
                }
            } else {
                KeyInfo keyInfo = this.nowDisplayKey;
                Intrinsics.checkNotNull(keyInfo);
                keyInfo.click(scaledMouseX, scaledMouseY);
            }
        } else {
            PopUI popUI = this.popUI;
            Intrinsics.checkNotNull(popUI);
            popUI.onClick(this.field_146294_l, this.field_146295_m, mouseX, mouseY);
        }
    }

    public void func_146281_b() {
        DarkMeow.INSTANCE.getConfigManager().smartSave();
    }

    protected void func_73869_a(char typedChar, int keyCode) {
        block5: {
            if (1 == keyCode) {
                if (this.popUI != null) {
                    this.popUI = null;
                } else if (this.nowDisplayKey != null) {
                    this.nowDisplayKey = null;
                } else {
                    this.field_146297_k.func_147108_a(null);
                }
                return;
            }
            PopUI popUI = this.popUI;
            if (popUI == null) break block5;
            popUI.onKey(typedChar, keyCode);
        }
    }

    public boolean func_73868_f() {
        return false;
    }

    private static final void updateAllKeys$lambda$0(KeyBindManager this$0) {
        Iterator<KeyInfo> iterator2 = this$0.keys.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, "iterator(...)");
        Iterator<KeyInfo> iterator3 = iterator2;
        while (iterator3.hasNext()) {
            KeyInfo key;
            Intrinsics.checkNotNullExpressionValue(iterator3.next(), "next(...)");
            key.update();
        }
    }
}

