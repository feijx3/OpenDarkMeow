/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.ui.theme;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.darkmeow.darkmeow.ui.theme.Theme;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/darkmeow/darkmeow/ui/theme/DefaultTheme;", "", "<init>", "()V", "DEFAULT", "Lnet/darkmeow/darkmeow/ui/theme/Theme;", "getDEFAULT", "()Lnet/darkmeow/darkmeow/ui/theme/Theme;", "DarkMeow"})
public final class DefaultTheme {
    @NotNull
    public static final DefaultTheme INSTANCE = new DefaultTheme();
    @NotNull
    private static final Theme DEFAULT;

    private DefaultTheme() {
    }

    @NotNull
    public final Theme getDEFAULT() {
        return DEFAULT;
    }

    static {
        Color color = new Color(255, 200, 210);
        Color color2 = new Color(255, 140, 160);
        Color color3 = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color3, "WHITE");
        DEFAULT = new Theme(color, color2, color3, new Color(80, 80, 80), new Color(120, 120, 120), new Color(40, 40, 40, 100), 4, MinecraftInstance.mc.getFontRenderer());
    }
}

