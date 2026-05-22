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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rJ&\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ.\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rJ\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rJ\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006%"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/keybind/PopUI;", "", "font", "Lnet/minecraft/client/gui/FontRenderer;", "title", "", "<init>", "(Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;)V", "getFont", "()Lnet/minecraft/client/gui/FontRenderer;", "getTitle", "()Ljava/lang/String;", "baseWidth", "", "getBaseWidth", "()I", "baseHeight", "getBaseHeight", "onRender", "", "width", "height", "onClick", "mouseX", "mouseY", "onStroll", "wheel", "onKey", "typedChar", "", "keyCode", "render", "key", "close", "click", "", "stroll", "DarkMeow"})
public class PopUI {
    @NotNull
    private final FontRenderer font;
    @NotNull
    private final String title;
    private final int baseWidth;
    private final int baseHeight;

    public PopUI(@NotNull FontRenderer font, @NotNull String title) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(title, "title");
        this.font = font;
        this.title = title;
        this.baseWidth = 150;
        this.baseHeight = 210;
    }

    @NotNull
    public FontRenderer getFont() {
        return this.font;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getBaseWidth() {
        return this.baseWidth;
    }

    public final int getBaseHeight() {
        return this.baseHeight;
    }

    public final void onRender(int width, int height) {
        GlStateManager.func_179094_E();
        RenderUtils.drawRect(0.0f, 0.0f, (float)width, (float)height, new Color(0, 0, 0, 50).getRGB());
        float scale = (float)width * 0.2f / (float)this.baseWidth;
        GlStateManager.func_179109_b((float)((float)width * 0.4f), (float)((float)height * 0.3f), (float)0.0f);
        GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
        RenderUtils.drawRect(0.0f, 0.0f, (float)this.baseWidth, (float)this.baseHeight, new Color(40, 40, 40, 200));
        this.getFont().func_78276_b(this.title, 8, 4, Color.WHITE.getRGB());
        this.render();
        GlStateManager.func_179121_F();
    }

    public final void onClick(int width, int height, int mouseX, int mouseY) {
        float scale = (float)width * 0.2f / (float)this.baseWidth;
        float scaledMouseX = ((float)mouseX - (float)width * 0.4f) / scale;
        float scaledMouseY = ((float)mouseY - (float)height * 0.3f) / scale;
        if (scaledMouseX > 0.0f && scaledMouseY > 0.0f && scaledMouseX < (float)this.baseWidth && scaledMouseY < (float)this.baseHeight) {
            this.click(scaledMouseX, scaledMouseY);
        } else {
            this.close();
        }
    }

    public final void onStroll(int width, int height, int mouseX, int mouseY, int wheel) {
        float scale = (float)width * 0.2f / (float)this.baseWidth;
        float scaledMouseX = ((float)mouseX - (float)width * 0.4f) / scale;
        float scaledMouseY = ((float)mouseY - (float)height * 0.3f) / scale;
        if (scaledMouseX > 0.0f && scaledMouseY > 0.0f && scaledMouseX < (float)this.baseWidth && scaledMouseY < (float)this.baseHeight) {
            this.stroll(scaledMouseX, scaledMouseY, wheel);
        }
    }

    public final void onKey(char typedChar, int keyCode) {
        this.key(typedChar, keyCode);
    }

    public void render() {
    }

    public void key(char typedChar, int keyCode) {
    }

    public void close() {
    }

    public void click(float mouseX, float mouseY) {
    }

    public void stroll(float mouseX, float mouseY, int wheel) {
    }
}

