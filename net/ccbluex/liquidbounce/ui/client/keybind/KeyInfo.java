/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.keybind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.keybind.KeyBindManager;
import net.ccbluex.liquidbounce.ui.client.keybind.KeySelectUI;
import net.ccbluex.liquidbounce.utils.extensions.RendererExtensionKt;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fBA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u0010J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u001e\u0010&\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\nJ\u0006\u0010.\u001a\u00020)J\u0016\u0010/\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyInfo;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "font", "Lnet/minecraft/client/gui/FontRenderer;", "posX", "", "posY", "width", "height", "key", "", "keyName", "", "keyDisplayName", "<init>", "(Lnet/minecraft/client/gui/FontRenderer;FFFFILjava/lang/String;Ljava/lang/String;)V", "(Lnet/minecraft/client/gui/FontRenderer;FFFFILjava/lang/String;)V", "getFont", "()Lnet/minecraft/client/gui/FontRenderer;", "getPosX", "()F", "getPosY", "getWidth", "getHeight", "getKey", "()I", "getKeyName", "()Ljava/lang/String;", "getKeyDisplayName", "baseTabHeight", "baseTabWidth", "direction", "", "modules", "Ljava/util/ArrayList;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "Lkotlin/collections/ArrayList;", "hasKeyBind", "stroll", "maxStroll", "render", "", "renderTab", "mouseX", "mouseY", "wheel", "update", "click", "DarkMeow"})
public final class KeyInfo
extends MinecraftInstance {
    @NotNull
    private final FontRenderer font;
    private final float posX;
    private final float posY;
    private final float width;
    private final float height;
    private final int key;
    @NotNull
    private final String keyName;
    @NotNull
    private final String keyDisplayName;
    private final int baseTabHeight;
    private final int baseTabWidth;
    private final boolean direction;
    @NotNull
    private ArrayList<Module> modules;
    private boolean hasKeyBind;
    private int stroll;
    private int maxStroll;

    public KeyInfo(@NotNull FontRenderer font, float posX, float posY, float width, float height, int key, @NotNull String keyName, @NotNull String keyDisplayName) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(keyDisplayName, "keyDisplayName");
        this.font = font;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.key = key;
        this.keyName = keyName;
        this.keyDisplayName = keyDisplayName;
        this.baseTabHeight = 150;
        this.baseTabWidth = 100;
        this.direction = this.posY >= 100.0f;
        this.modules = new ArrayList();
    }

    @NotNull
    public final FontRenderer getFont() {
        return this.font;
    }

    public final float getPosX() {
        return this.posX;
    }

    public final float getPosY() {
        return this.posY;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final int getKey() {
        return this.key;
    }

    @NotNull
    public final String getKeyName() {
        return this.keyName;
    }

    @NotNull
    public final String getKeyDisplayName() {
        return this.keyDisplayName;
    }

    public KeyInfo(@NotNull FontRenderer font, float posX, float posY, float width, float height, int key, @NotNull String keyName) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        this(font, posX, posY, width, height, key, keyName, keyName);
    }

    public final void render() {
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)this.posX, (float)this.posY, (float)0.0f);
        GlStateManager.func_179117_G();
        RenderUtils.drawBorderedRect(0.0f, 0.0f, this.width, this.height, 3.0f, new Color(20, 20, 20, 200).getRGB(), new Color(20, 20, 20, 200).getRGB());
        RenderUtils.drawBorderedRect(0.0f, this.height * 0.9f, this.width, this.height, 3.0f, new Color(40, 40, 40, 200).getRGB(), new Color(40, 40, 40, 200).getRGB());
        RendererExtensionKt.drawCenteredString(this.font, this.keyName, this.width * 0.5f, this.height * 0.9f * 0.5f - (float)this.font.field_78288_b * 0.5f + 3.0f, this.hasKeyBind ? new Color(240, 240, 240).getRGB() : new Color(160, 160, 160).getRGB(), false);
        GlStateManager.func_179121_F();
    }

    public final void renderTab() {
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)(this.posX + this.width * 0.5f - (float)this.baseTabWidth * 0.5f), (float)(this.direction ? this.posY - (float)this.baseTabHeight : this.posY + this.height), (float)0.0f);
        RenderUtils.drawBorderedRect(0.0f, 0.0f, this.baseTabWidth, this.baseTabHeight, 3.0f, new Color(40, 40, 40, 200).getRGB(), new Color(40, 40, 40, 200).getRGB());
        float fontHeight = 10.0f - (float)this.font.field_78288_b * 0.5f;
        float yOffset = 12.0f + (float)this.font.field_78288_b + 10.0f - (float)this.stroll;
        Iterator<Module> iterator2 = this.modules.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, "iterator(...)");
        Iterator<Module> iterator3 = iterator2;
        while (iterator3.hasNext()) {
            Intrinsics.checkNotNullExpressionValue(iterator3.next(), "next(...)");
            if (yOffset > 0.0f && yOffset - (float)20 < 100.0f) {
                Module module;
                GlStateManager.func_179094_E();
                GlStateManager.func_179109_b((float)0.0f, (float)yOffset, (float)0.0f);
                this.font.func_175065_a(module.getName(), 12.0f, fontHeight, Color.WHITE.getRGB(), false);
                this.font.func_175065_a("-", (float)this.baseTabWidth - 12.0f - (float)this.font.func_78256_a("-"), fontHeight, Color.RED.getRGB(), false);
                GlStateManager.func_179117_G();
                GlStateManager.func_179121_F();
            }
            yOffset += (float)20;
        }
        RenderUtils.drawBorderedRect(0.0f, 0.0f, this.baseTabWidth, 12.0f + (float)this.font.field_78288_b + 10.0f, 3.0f, new Color(40, 40, 40, 200).getRGB(), new Color(40, 40, 40, 200).getRGB());
        RenderUtils.drawBorderedRect(0.0f, (float)this.baseTabHeight - 22.0f - (float)this.font.field_78288_b, this.baseTabWidth, this.baseTabHeight, 3.0f, new Color(40, 40, 40, 200).getRGB(), new Color(40, 40, 40, 200).getRGB());
        this.font.func_78276_b(this.keyDisplayName + " Key", 12, 12, Color.WHITE.getRGB());
        this.font.func_78276_b("+ Add", this.baseTabWidth - 12 - this.font.func_78256_a("+ Add"), this.baseTabHeight - 12 - this.font.field_78288_b, new Color(0, 191, 255).getRGB());
        GlStateManager.func_179121_F();
    }

    public final void stroll(float mouseX, float mouseY, int wheel) {
        float scaledMouseX = mouseX - (this.posX + this.width * 0.5f - (float)this.baseTabWidth * 0.5f);
        float scaledMouseY = mouseY - (this.direction ? this.posY - (float)this.baseTabHeight : this.posY + this.height);
        if (scaledMouseX < 0.0f || scaledMouseY < 0.0f || scaledMouseX > (float)this.baseTabWidth || scaledMouseY > (float)this.baseTabHeight) {
            return;
        }
        int afterStroll = this.stroll - wheel / 40;
        if (afterStroll > 0 && afterStroll < this.maxStroll - 150) {
            this.stroll = afterStroll;
        }
    }

    public final void update() {
        List<Module> list = DarkMeow.INSTANCE.getModuleManager().getKeyBind(this.key);
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<net.ccbluex.liquidbounce.features.module.Module>");
        this.modules = (ArrayList)list;
        this.hasKeyBind = this.modules.size() > 0;
        this.stroll = 0;
        this.maxStroll = this.modules.size() * 30;
    }

    public final void click(float mouseX, float mouseY) {
        KeyBindManager keyBindMgr = DarkMeow.INSTANCE.getKeyBindManager();
        if (keyBindMgr.getNowDisplayKey() == null) {
            keyBindMgr.setNowDisplayKey(this);
        } else {
            float scaledMouseX = mouseX - (this.posX + this.width * 0.5f - (float)this.baseTabWidth * 0.5f);
            float scaledMouseY = mouseY - (this.direction ? this.posY - (float)this.baseTabHeight : this.posY + this.height);
            if (scaledMouseX < 0.0f || scaledMouseY < 0.0f || scaledMouseX > (float)this.baseTabWidth || scaledMouseY > (float)this.baseTabHeight) {
                keyBindMgr.setNowDisplayKey(null);
                return;
            }
            if (scaledMouseY > 22.0f + (float)this.font.field_78288_b && scaledMouseX > (float)this.baseTabWidth - 12.0f - (float)this.font.func_78256_a("%ui.keybind.add%")) {
                if (scaledMouseY > (float)this.baseTabHeight - 22.0f - (float)this.font.field_78288_b) {
                    keyBindMgr.setPopUI(new KeySelectUI(this.font, this));
                } else {
                    float yOffset = 12.0f + (float)this.font.field_78288_b + 10.0f - (float)this.stroll;
                    Iterator<Module> iterator2 = this.modules.iterator();
                    Intrinsics.checkNotNullExpressionValue(iterator2, "iterator(...)");
                    Iterator<Module> iterator3 = iterator2;
                    while (iterator3.hasNext()) {
                        Intrinsics.checkNotNullExpressionValue(iterator3.next(), "next(...)");
                        if (scaledMouseY > yOffset + (float)5 && scaledMouseY < yOffset + (float)15) {
                            Module module;
                            module.setKeyBind(0);
                            this.update();
                            break;
                        }
                        yOffset += (float)20;
                    }
                }
            }
        }
    }
}

