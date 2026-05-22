/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.minecraft.gui.screen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.client.GuiTweaks;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.minecraft.gui.screen.GuiRenderer;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.utils.extensions.RendererExtensionKt;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/minecraft/gui/screen/GuiRendererConnecting;", "Lnet/ccbluex/liquidbounce/ui/client/minecraft/gui/screen/GuiRenderer;", "<init>", "()V", "font", "Lnet/minecraft/client/gui/FontRenderer;", "getFont", "()Lnet/minecraft/client/gui/FontRenderer;", "render", "", "mouseX", "", "mouseY", "partialTicks", "", "sr", "Lnet/minecraft/client/gui/ScaledResolution;", "drawOldTip", "DarkMeow"})
public final class GuiRendererConnecting
extends GuiRenderer {
    @NotNull
    public static final GuiRendererConnecting INSTANCE = new GuiRendererConnecting();
    @NotNull
    private static final FontRenderer font = Fonts.minecraftFont;

    private GuiRendererConnecting() {
    }

    @NotNull
    public final FontRenderer getFont() {
        return font;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks, @NotNull ScaledResolution sr) {
        Intrinsics.checkNotNullParameter(sr, "sr");
        this.drawOldTip(sr);
    }

    private final void drawOldTip(ScaledResolution sr) {
        if (!GuiTweaks.guiConnectingTipsValue.get().booleanValue()) {
            return;
        }
        int width = sr.func_78326_a();
        int height = sr.func_78328_b();
        Object object = MinecraftInstance.mc.getCurrentServerData();
        if (object == null || (object = object.field_78845_b) == null) {
            object = "Unknown";
        }
        Object ip = object;
        RenderUtils.drawLoadingCircle(width / 2, height / 4 + 70);
        RendererExtensionKt.drawCenteredString(font, "Connecting to", width / 2, height / 4 + 110, 0xFFFFFF, true);
        RendererExtensionKt.drawCenteredString(font, (String)ip, width / 2, height / 4 + 120, 5407227, true);
    }
}

