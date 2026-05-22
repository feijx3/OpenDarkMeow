/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter.ScaffoldCounterData;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter.ScaffoldCounterMode;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/impl/ScaffoldCounterModeInfo;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterMode;", "<init>", "()V", "render", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "data", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData;", "getColorByCount", "", "count", "", "DarkMeow"})
public final class ScaffoldCounterModeInfo
extends ScaffoldCounterMode {
    public ScaffoldCounterModeInfo() {
        super("Info");
    }

    @Override
    @NotNull
    public ElementBorder render(@NotNull ScaffoldCounterData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String info = this.getColorByCount(data.getCountHotBar()) + data.getCountHotBar() + " (Bar) \u00a7r/ " + this.getColorByCount(data.getCountInventory()) + data.getCountInventory() + " (Inv)";
        RenderUtils.drawInGUIItem$default(-8, 0, data.getHeldBlock(), null, true, 0.0f, 40, null);
        FontRendererUtils.drawStringCentered$default(FontRendererUtils.INSTANCE, Fonts.minecraftFont, info, 0, 30, null, false, false, 56, null);
        float it = (float)Fonts.minecraftFont.func_78256_a(info) / 2.0f;
        boolean bl2 = false;
        return new ElementBorder(-it - (float)4, 0.0f, it + (float)4, 44.0f);
    }

    private final String getColorByCount(int count) {
        int n2 = count;
        return (0 <= n2 ? n2 < 17 : false) ? "\u00a7c" : ((17 <= n2 ? n2 < 65 : false) ? "\u00a7e" : "\u00a7a");
    }
}

