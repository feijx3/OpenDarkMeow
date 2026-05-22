/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.ui.component;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.theme.Theme;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.impl.WindowBlurShader;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lnet/darkmeow/darkmeow/ui/component/ComponentRenderUtils;", "", "<init>", "()V", "drawBoardRect", "", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "theme", "Lnet/darkmeow/darkmeow/ui/theme/Theme;", "active", "", "DarkMeow"})
public final class ComponentRenderUtils {
    @NotNull
    public static final ComponentRenderUtils INSTANCE = new ComponentRenderUtils();

    private ComponentRenderUtils() {
    }

    public final void drawBoardRect(@NotNull AbstractComponent $this$drawBoardRect, @NotNull Theme theme, boolean active) {
        Intrinsics.checkNotNullParameter($this$drawBoardRect, "<this>");
        Intrinsics.checkNotNullParameter(theme, "theme");
        WindowBlurShader.render$default(WindowBlurShader.INSTANCE, 0, 0, $this$drawBoardRect.getWidth(), $this$drawBoardRect.getHeight(), theme.getBlurPass(), 0.0f, 32, null);
        Color rectColor = active ? theme.getColorRectActive() : theme.getColorRectNormal();
        RenderUtils.INSTANCE.drawRect(0, 0, 1, $this$drawBoardRect.getHeight(), rectColor);
        RenderUtils.INSTANCE.drawRect($this$drawBoardRect.getWidth() - 1, 0, $this$drawBoardRect.getWidth(), $this$drawBoardRect.getHeight(), rectColor);
        RenderUtils.INSTANCE.drawRect(0, 0, $this$drawBoardRect.getWidth(), 1, rectColor);
        RenderUtils.INSTANCE.drawRect(0, $this$drawBoardRect.getHeight() - 1, $this$drawBoardRect.getWidth(), $this$drawBoardRect.getHeight(), rectColor);
        RenderUtils.INSTANCE.drawRect(0, 0, $this$drawBoardRect.getWidth(), $this$drawBoardRect.getHeight(), theme.getColorBackground());
    }
}

