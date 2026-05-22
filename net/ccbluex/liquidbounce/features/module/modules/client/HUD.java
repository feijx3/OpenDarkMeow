/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.KeyEvent;
import net.ccbluex.liquidbounce.event.Render2DEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseConfig;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseState;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.impl.WindowBlurShader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0007JE\u0010\u000e\u001a\u00020\u0007\"\b\b\u0000\u0010\u000f*\u00020\u0010\"\b\b\u0001\u0010\u0011*\u00020\u00102\u0006\u0010\u0012\u001a\u0002H\u000f2\u0006\u0010\u0013\u001a\u0002H\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u0018Ji\u0010\u000e\u001a\u00020\u0007\"\b\b\u0000\u0010\u0019*\u00020\u0010\"\b\b\u0001\u0010\u001a*\u00020\u0010\"\b\b\u0002\u0010\u000f*\u00020\u0010\"\b\b\u0003\u0010\u0011*\u00020\u00102\u0006\u0010\u001b\u001a\u0002H\u00192\u0006\u0010\u001c\u001a\u0002H\u001a2\u0006\u0010\u0012\u001a\u0002H\u000f2\u0006\u0010\u0013\u001a\u0002H\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u001dR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/HUD;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "blurValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onRender2D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onKey", "Lnet/ccbluex/liquidbounce/event/KeyEvent;", "drawBackground", "X2", "", "Y2", "x2", "y2", "color", "Ljava/awt/Color;", "radius", "", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;F)V", "X1", "Y1", "x1", "y1", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/awt/Color;F)V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nHUD.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HUD.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/HUD\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,63:1\n1#2:64\n*E\n"})
public final class HUD
extends Module {
    @NotNull
    public static final HUD INSTANCE = new HUD();
    @JvmField
    @NotNull
    public static final BoolValue blurValue = new BoolValue("Blur", true);

    private HUD() {
        super("HUD", ModuleCategory.CLIENT, new ModuleBaseConfig(0, null, true, false, 11, null), new ModuleBaseState(true, false));
    }

    @EventTarget(priority=2000)
    public final void onRender2D(@NotNull Render2DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (MinecraftInstance.mc.getCurrentScreen() instanceof GuiHudDesigner) {
            return;
        }
        DarkMeow.INSTANCE.getHudManager().render(event.getPartialTicks(), false);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        DarkMeow.INSTANCE.getHudManager().update(event.getPlayer(), event.getUpdateId());
    }

    @EventTarget
    public final void onKey(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        DarkMeow.INSTANCE.getHudManager().handleKey('a', event.getKey());
    }

    public final <X2 extends Number, Y2 extends Number> void drawBackground(@NotNull X2 x2, @NotNull Y2 y2, @Nullable Color color, float radius) {
        Intrinsics.checkNotNullParameter(x2, "x2");
        Intrinsics.checkNotNullParameter(y2, "y2");
        this.drawBackground((Number)Float.valueOf(0.0f), (Number)Float.valueOf(0.0f), x2, y2, color, radius);
    }

    public static /* synthetic */ void drawBackground$default(HUD hUD, Number number, Number number2, Color color, float f2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            color = new Color(0, 0, 0, 120);
        }
        if ((n2 & 8) != 0) {
            f2 = 0.0f;
        }
        hUD.drawBackground(number, number2, color, f2);
    }

    public final <X1 extends Number, Y1 extends Number, X2 extends Number, Y2 extends Number> void drawBackground(@NotNull X1 x1, @NotNull Y1 y1, @NotNull X2 x2, @NotNull Y2 y2, @Nullable Color color, float radius) {
        block1: {
            Color color2;
            Intrinsics.checkNotNullParameter(x1, "x1");
            Intrinsics.checkNotNullParameter(y1, "y1");
            Intrinsics.checkNotNullParameter(x2, "x2");
            Intrinsics.checkNotNullParameter(y2, "y2");
            if (((Boolean)blurValue.get()).booleanValue()) {
                WindowBlurShader.INSTANCE.render(x1.floatValue(), y1.floatValue(), x2.floatValue(), y2.floatValue(), 1, 0.0f);
            }
            Color color3 = color;
            if (color3 == null) break block1;
            Color c2 = color2 = color3;
            boolean bl2 = false;
            RenderUtils.INSTANCE.drawRoundedRect(x1, y1, x2, y2, radius, c2);
        }
    }

    public static /* synthetic */ void drawBackground$default(HUD hUD, Number number, Number number2, Number number3, Number number4, Color color, float f2, int n2, Object object) {
        if ((n2 & 0x10) != 0) {
            color = new Color(0, 0, 0, 120);
        }
        if ((n2 & 0x20) != 0) {
            f2 = 0.0f;
        }
        hUD.drawBackground(number, number2, number3, number4, color, f2);
    }
}

