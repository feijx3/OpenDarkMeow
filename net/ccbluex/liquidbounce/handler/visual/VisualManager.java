/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.visual;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.Render2DEvent;
import net.ccbluex.liquidbounce.value.color.ColorValueManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/handler/visual/VisualManager;", "", "<init>", "()V", "colorValueManager", "Lnet/ccbluex/liquidbounce/value/color/ColorValueManager;", "callRender2DEvent", "", "partialTicks", "", "DarkMeow"})
public final class VisualManager {
    @JvmField
    @NotNull
    public final ColorValueManager colorValueManager = new ColorValueManager();

    public final void callRender2DEvent(float partialTicks) {
        EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), new Render2DEvent(partialTicks), null, 2, null);
    }
}

