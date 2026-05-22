/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketCloseWindow
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import java.awt.Color;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseConfig;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseState;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.clickgui.ClickGui;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.FontValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketCloseWindow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000fR\u0011\u0010\"\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010$\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010&\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010(\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010*\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000f\u00a8\u00061"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/ClickGUI;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "styleValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getStyleValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "scaleValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "getScaleValue", "()Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "maxElementsValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "getMaxElementsValue", "()Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "getFontValue", "()Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "colorBackgroundValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "getColorBackgroundValue", "()Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "colorFontValue", "getColorFontValue", "animationValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getAnimationValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "animationModeValue", "getAnimationModeValue", "animationSpeedValue", "getAnimationSpeedValue", "scrollValue", "getScrollValue", "scrollUseMouseWheelValue", "getScrollUseMouseWheelValue", "scrollUseKeyValue", "getScrollUseKeyValue", "scrollResetOnClickGuiOpenValue", "getScrollResetOnClickGuiOpenValue", "scrollSpeedValue", "getScrollSpeedValue", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nClickGUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClickGUI.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/ClickGUI\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n37#2:72\n36#2,3:73\n1#3:76\n*S KotlinDebug\n*F\n+ 1 ClickGUI.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/ClickGUI\n*L\n32#1:72\n32#1:73,3\n*E\n"})
public final class ClickGUI
extends Module {
    @NotNull
    private final ListValue styleValue;
    @NotNull
    private final FloatValue scaleValue;
    @NotNull
    private final IntegerValue maxElementsValue;
    @NotNull
    private final FontValue fontValue;
    @NotNull
    private final ColorValue colorBackgroundValue;
    @NotNull
    private final ColorValue colorFontValue;
    @NotNull
    private final BoolValue animationValue;
    @NotNull
    private final ListValue animationModeValue;
    @NotNull
    private final IntegerValue animationSpeedValue;
    @NotNull
    private final BoolValue scrollValue;
    @NotNull
    private final BoolValue scrollUseMouseWheelValue;
    @NotNull
    private final BoolValue scrollUseKeyValue;
    @NotNull
    private final BoolValue scrollResetOnClickGuiOpenValue;
    @NotNull
    private final IntegerValue scrollSpeedValue;

    /*
     * WARNING - void declaration
     */
    public ClickGUI() {
        super("ClickGUI", ModuleCategory.CLIENT, new ModuleBaseConfig(54, null, false, false, 14, null), new ModuleBaseState(false, true, 1, null));
        void $this$scrollSpeedValue_u24lambda_u245;
        Object $this$scrollResetOnClickGuiOpenValue_u24lambda_u244;
        Object $this$scrollUseKeyValue_u24lambda_u243;
        Object $this$scrollUseMouseWheelValue_u24lambda_u242;
        Object $this$animationSpeedValue_u24lambda_u241;
        Object $this$animationModeValue_u24lambda_u240;
        DarkMeow.INSTANCE.getClickGuiManager().setConfig(this);
        Set<String> set = DarkMeow.INSTANCE.getClickGuiManager().getStyles().keySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
        Collection $this$toTypedArray$iv = set;
        boolean $i$f$toTypedArray22 = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        this.styleValue = new ListValue("Style", thisCollection$iv.toArray(new String[0]), "DarkMeow");
        this.scaleValue = new FloatValue("Scale", 0.7f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 2.0f));
        this.maxElementsValue = new IntegerValue("MaxElements", 20, new IntRange(1, 20));
        this.fontValue = new FontValue("Font", new FontValue.FontInfo("SF UI Display Regular", 16));
        this.colorBackgroundValue = new ColorValue("ColorBackground", new ColorValueInfo(new Color(0, 0, 0, 40)), false, 4, null);
        this.colorFontValue = new ColorValue("ColorFont", new ColorValueInfo("Rainbow", null, 0, false, 0, 30, null), true);
        this.animationValue = new BoolValue("Animation", true);
        Object object = new String[]{"Azura", "Slide", "SlideBounce", "Zoom", "ZoomBounce"};
        Object $i$f$toTypedArray22 = object = new ListValue("AnimationMode", (String[])object, "ZoomBounce");
        ClickGUI clickGUI = this;
        boolean bl2 = false;
        $this$animationModeValue_u24lambda_u240.setSuperValue(this.animationValue);
        clickGUI.animationModeValue = object;
        $this$animationModeValue_u24lambda_u240 = object = new IntegerValue("AnimationSpeed", 500, new IntRange(100, 1000));
        clickGUI = this;
        boolean bl3 = false;
        $this$animationSpeedValue_u24lambda_u241.setSuperValue(this.animationValue);
        clickGUI.animationSpeedValue = object;
        this.scrollValue = new BoolValue("Scroll", true);
        $this$animationSpeedValue_u24lambda_u241 = object = new BoolValue("ScrollUseMouseWheel", true);
        clickGUI = this;
        boolean bl4 = false;
        $this$scrollUseMouseWheelValue_u24lambda_u242.setSuperValue(this.scrollValue);
        clickGUI.scrollUseMouseWheelValue = object;
        $this$scrollUseMouseWheelValue_u24lambda_u242 = object = new BoolValue("ScrollUseKey", true);
        clickGUI = this;
        boolean bl5 = false;
        $this$scrollUseKeyValue_u24lambda_u243.setSuperValue(this.scrollValue);
        clickGUI.scrollUseKeyValue = object;
        $this$scrollUseKeyValue_u24lambda_u243 = object = new BoolValue("ScrollResetOnClickGuiOpen", true);
        clickGUI = this;
        boolean bl6 = false;
        $this$scrollResetOnClickGuiOpenValue_u24lambda_u244.setSuperValue(this.scrollValue);
        clickGUI.scrollResetOnClickGuiOpenValue = object;
        $this$scrollResetOnClickGuiOpenValue_u24lambda_u244 = object = new IntegerValue("ScrollSpeed", 15, new IntRange(1, 30));
        clickGUI = this;
        boolean bl7 = false;
        $this$scrollSpeedValue_u24lambda_u245.setSuperValue(this.scrollValue);
        clickGUI.scrollSpeedValue = object;
    }

    @NotNull
    public final ListValue getStyleValue() {
        return this.styleValue;
    }

    @NotNull
    public final FloatValue getScaleValue() {
        return this.scaleValue;
    }

    @NotNull
    public final IntegerValue getMaxElementsValue() {
        return this.maxElementsValue;
    }

    @NotNull
    public final FontValue getFontValue() {
        return this.fontValue;
    }

    @NotNull
    public final ColorValue getColorBackgroundValue() {
        return this.colorBackgroundValue;
    }

    @NotNull
    public final ColorValue getColorFontValue() {
        return this.colorFontValue;
    }

    @NotNull
    public final BoolValue getAnimationValue() {
        return this.animationValue;
    }

    @NotNull
    public final ListValue getAnimationModeValue() {
        return this.animationModeValue;
    }

    @NotNull
    public final IntegerValue getAnimationSpeedValue() {
        return this.animationSpeedValue;
    }

    @NotNull
    public final BoolValue getScrollValue() {
        return this.scrollValue;
    }

    @NotNull
    public final BoolValue getScrollUseMouseWheelValue() {
        return this.scrollUseMouseWheelValue;
    }

    @NotNull
    public final BoolValue getScrollUseKeyValue() {
        return this.scrollUseKeyValue;
    }

    @NotNull
    public final BoolValue getScrollResetOnClickGuiOpenValue() {
        return this.scrollResetOnClickGuiOpenValue;
    }

    @NotNull
    public final IntegerValue getScrollSpeedValue() {
        return this.scrollSpeedValue;
    }

    @Override
    public void onEnable() {
        DarkMeow.INSTANCE.getClickGuiManager().display();
    }

    @EventTarget(ignoreCondition=true)
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketCloseWindow && MinecraftInstance.mc_nowarp.field_71462_r instanceof ClickGui) {
            event.cancelEvent();
        }
    }
}

