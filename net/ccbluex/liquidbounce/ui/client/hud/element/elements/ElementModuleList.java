/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.utils.render.AnimationUtils;
import net.ccbluex.liquidbounce.value.color.ColorValueManager;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.FontValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementModuleList;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "colorTextValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "colorBackgroundValue", "animationHorizontalValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "animationVerticalValue", "animationSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "moduleNameValue", "moduleTagValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "moduleTagStyleValue", "moduleTagKeepColorValue", "rectValue", "textHeightValue", "textYValue", "fontValue", "Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "x2", "", "y2", "", "modules", "", "Lnet/ccbluex/liquidbounce/features/module/Module;", "sortedModules", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "updateElement", "", "getModName", "", "module", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElementModuleList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementModuleList.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementModuleList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,291:1\n1#2:292\n1878#3,3:293\n1869#3,2:296\n774#3:298\n865#3,2:299\n1056#3:301\n1056#3:302\n*S KotlinDebug\n*F\n+ 1 ElementModuleList.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementModuleList\n*L\n139#1:293,3\n178#1:296,2\n249#1:298\n249#1:299,2\n250#1:301\n251#1:302\n*E\n"})
public final class ElementModuleList
extends Element {
    @NotNull
    private final ColorValue colorTextValue = new ColorValue("ColorText", ColorValueManager.Companion.getDEFAULT_NORMAL(), false, 4, null);
    @NotNull
    private final ColorValue colorBackgroundValue = new ColorValue("ColorBackground", ColorValueManager.Companion.getDEFAULT_BACKGROUND(), false, 4, null);
    @NotNull
    private final ListValue animationHorizontalValue;
    @NotNull
    private final ListValue animationVerticalValue;
    @NotNull
    private final FloatValue animationSpeedValue;
    @NotNull
    private final ListValue moduleNameValue;
    @NotNull
    private final BoolValue moduleTagValue;
    @NotNull
    private final ListValue moduleTagStyleValue;
    @NotNull
    private final BoolValue moduleTagKeepColorValue;
    @NotNull
    private final BoolValue rectValue;
    @NotNull
    private final FloatValue textHeightValue;
    @NotNull
    private final FloatValue textYValue;
    @NotNull
    private final FontValue fontValue;
    private int x2;
    private float y2;
    @NotNull
    private List<? extends Module> modules;
    @NotNull
    private List<? extends Module> sortedModules;

    /*
     * WARNING - void declaration
     */
    public ElementModuleList() {
        super("ModuleList", 0.0, 1.0, 0.0f, new ElementSide(ElementSide.Horizontal.RIGHT, ElementSide.Vertical.UP), 0, 40, null);
        void $this$moduleTagKeepColorValue_u24lambda_u241;
        Object $this$moduleTagStyleValue_u24lambda_u240;
        Object object = new String[]{"None", "Slide", "Astolfo"};
        this.animationHorizontalValue = new ListValue("AnimationHorizontal", (String[])object, "Slide");
        object = new String[]{"None", "Slide", "Rise", "Astolfo"};
        this.animationVerticalValue = new ListValue("AnimationVertical", (String[])object, "Slide");
        this.animationSpeedValue = new FloatValue("AnimationSpeed", 0.25f, 0.01f, 1.0f);
        object = new String[]{"Normal", "Translated"};
        this.moduleNameValue = new ListValue("ModuleName", (String[])object, "Translated");
        this.moduleTagValue = new BoolValue("ModuleTag", true);
        object = new String[]{"-", "|", "Space"};
        Object object2 = object = new ListValue("ModuleTagStyle", (String[])object, "-");
        ElementModuleList elementModuleList = this;
        boolean bl2 = false;
        $this$moduleTagStyleValue_u24lambda_u240.setSuperValue(this.moduleTagValue);
        elementModuleList.moduleTagStyleValue = object;
        $this$moduleTagStyleValue_u24lambda_u240 = object = new BoolValue("ModuleTagKeepColor", false);
        elementModuleList = this;
        boolean bl3 = false;
        $this$moduleTagKeepColorValue_u24lambda_u241.setSuperValue(this.moduleTagValue);
        elementModuleList.moduleTagKeepColorValue = object;
        this.rectValue = new BoolValue("Rect", false);
        this.textHeightValue = new FloatValue("TextHeight", 11.0f, 1.0f, 20.0f);
        this.textYValue = new FloatValue("TextY", 0.0f, 0.0f, 20.0f);
        this.fontValue = new FontValue("Font", new FontValue.FontInfo(null, 0, 3, null));
        this.modules = CollectionsKt.emptyList();
        this.sortedModules = CollectionsKt.emptyList();
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        fontRenderer = this.fontValue.getFont();
        delta = net.ccbluex.liquidbounce.utils.render.RenderUtils.deltaTime;
        textHeight = ((Number)this.textHeightValue.get()).floatValue();
        textY = ((Number)this.textYValue.get()).floatValue();
        backgroundCustomColor = ColorValue.getColor$default(this.colorBackgroundValue, null, 1, null);
        textSpacer = textHeight;
        inx = 0;
        for (Module module : this.sortedModules) {
            block38: {
                block39: {
                    if (module.getArray() && (module.getState() || !(module.getSlide() == 0.0f))) {
                        displayString = this.getModName(module);
                        width = fontRenderer.func_78256_a(displayString);
                        var13_17 = (String)this.animationHorizontalValue.get();
                        if (Intrinsics.areEqual(var13_17, "Astolfo")) {
                            if (module.getState()) {
                                if (module.getSlide() < (float)width) {
                                    module.setSlide(module.getSlide() + ((Number)this.animationSpeedValue.get()).floatValue() * (float)delta);
                                    module.setSlideStep((float)delta / 1.0f);
                                }
                            } else if (module.getSlide() > 0.0f) {
                                module.setSlide(module.getSlide() - ((Number)this.animationSpeedValue.get()).floatValue() * (float)delta);
                                module.setSlideStep(0.0f);
                            }
                            if (module.getSlide() > (float)width) {
                                module.setSlide(width);
                            }
                        } else if (Intrinsics.areEqual(var13_17, "Slide")) {
                            if (module.getState()) {
                                if (module.getSlide() < (float)width) {
                                    module.setSlide((float)AnimationUtils.animate((double)width, (double)module.getSlide(), (double)((Number)this.animationSpeedValue.get()).floatValue() * 0.025 * (double)delta));
                                    module.setSlideStep((float)delta / 1.0f);
                                }
                            } else if (module.getSlide() > 0.0f) {
                                module.setSlide((float)AnimationUtils.animate(-((double)width), (double)module.getSlide(), (double)((Number)this.animationSpeedValue.get()).floatValue() * 0.025 * (double)delta));
                                module.setSlideStep(0.0f);
                            }
                        } else {
                            module.setSlide(module.getState() != false ? (float)width : 0.0f);
                            module.setSlideStep(module.getSlideStep() + (float)(module.getState() != false ? delta : -delta));
                        }
                        module.setSlide(RangesKt.coerceIn(module.getSlide(), 0.0f, (float)width));
                        module.setSlideStep(RangesKt.coerceIn(module.getSlideStep(), 0.0f, (float)width));
                    }
                    yPos = (this.getSide().getVertical() == ElementSide.Vertical.DOWN ? -textSpacer : textSpacer) * (float)(this.getSide().getVertical() == ElementSide.Vertical.DOWN ? inx + 1 : inx);
                    if (!module.getArray() || !(module.getSlide() > 0.0f)) break block38;
                    if (StringsKt.equals((String)this.animationVerticalValue.get(), "Rise", true) && !module.getState()) {
                        yPos = (float)(-fontRenderer.field_78288_b) - textY;
                    }
                    width = (String)this.animationVerticalValue.get();
                    switch (width.hashCode()) {
                        case 961091784: {
                            if (width.equals("Astolfo")) break;
                            ** break;
                        }
                        case 79973777: {
                            if (!width.equals("Slide")) {
                                ** break;
                            }
                            ** GOTO lbl54
                        }
                        case 2547433: {
                            if (!width.equals("Rise")) ** break;
lbl54:
                            // 2 sources

                            module.setHigt((float)AnimationUtils.animate((double)yPos, (double)module.getHigt(), (double)((Number)this.animationSpeedValue.get()).floatValue() * 0.025 * (double)delta));
                            break block39;
                        }
                    }
                    if (module.getHigt() < yPos) {
                        module.setHigt(module.getHigt() + ((Number)this.animationSpeedValue.get()).floatValue() / 2.0f * (float)delta);
                        module.setHigt(RangesKt.coerceAtMost(yPos, module.getHigt()));
                    } else {
                        module.setHigt(module.getHigt() - ((Number)this.animationSpeedValue.get()).floatValue() / 2.0f * (float)delta);
                        module.setHigt(RangesKt.coerceAtLeast(module.getHigt(), yPos));
                    }
                    break block39;
lbl63:
                    // 4 sources

                    module.setHigt(yPos);
                }
                ++inx;
                continue;
            }
            if (StringsKt.equals((String)this.animationVerticalValue.get(), "rise", true)) continue;
            module.setHigt(yPos);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.getSide().getHorizontal().ordinal()]) {
            case 1: 
            case 2: {
                $this$forEachIndexed$iv = this.modules;
                $i$f$forEachIndexed = false;
                index$iv = 0;
                for (T item$iv : $this$forEachIndexed$iv) {
                    if ((var16_23 = index$iv++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    var17_24 = (Module)item$iv;
                    index = var16_23;
                    $i$a$-forEachIndexed-ElementModuleList$drawElement$1 = false;
                    displayString = this.getModName((Module)module);
                    xPos = -module.getSlide() - (float)2;
                    RenderUtils.INSTANCE.drawRect((Number)Float.valueOf(xPos - (float)((Boolean)this.rectValue.get() != false ? 3 : 2)), (Number)Float.valueOf(module.getHigt()), (Number)Float.valueOf((Boolean)this.rectValue.get() != false ? -1.0f : 0.0f), (Number)Float.valueOf(module.getHigt() + textHeight), backgroundCustomColor);
                    FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, fontRenderer, displayString, Float.valueOf(xPos - (float)((Boolean)this.rectValue.get() != false)), Float.valueOf(module.getHigt() + textY), this.colorTextValue.getColor(Float.valueOf(module.getHigt() / (float)fontRenderer.field_78288_b)), false, 16, null);
                    var22_32 /* !! */  = this.rectValue.get();
                    it = (Boolean)var22_32 /* !! */ ;
                    $i$a$-takeIf-ElementModuleList$drawElement$1$1 = false;
                    var25_42 = (Boolean)(it != false ? var22_32 /* !! */  : null);
                    if (var25_42 == null) continue;
                    it = var25_42;
                    $i$a$-let-ElementModuleList$drawElement$1$2 = false;
                    var22_32 /* !! */  = this.colorTextValue.getColor(Float.valueOf(module.getHigt() / (float)fontRenderer.field_78288_b));
                    if (var22_32 /* !! */  == null) continue;
                    rectColor /* !! */  = var23_37 /* !! */  = var22_32 /* !! */ ;
                    $i$a$-also-ElementModuleList$drawElement$1$3 = false;
                    RenderUtils.INSTANCE.drawRect((Number)Float.valueOf(-1.0f), (Number)Float.valueOf(module.getHigt()), (Number)Float.valueOf(0.0f), (Number)Float.valueOf(module.getHigt() + textHeight), (Color)rectColor /* !! */ );
                }
                break;
            }
            case 3: {
                $this$forEach$iv = this.modules;
                $i$f$forEach = false;
                for (T element$iv : $this$forEach$iv) {
                    module = (Module)element$iv;
                    $i$a$-forEach-ElementModuleList$drawElement$2 = false;
                    displayString = this.getModName(module);
                    width = fontRenderer.func_78256_a(displayString);
                    xPos = -((float)width - module.getSlide()) + (float)((Boolean)this.rectValue.get() != false ? 3 : 2);
                    RenderUtils.INSTANCE.drawRect((Number)Float.valueOf(0.0f), (Number)Float.valueOf(module.getHigt()), (Number)Float.valueOf(xPos + (float)width + (float)2), (Number)Float.valueOf(module.getHigt() + textHeight), backgroundCustomColor);
                    fontRenderer.func_175065_a(displayString, xPos, module.getHigt() + textY, this.colorTextValue.getColor(Float.valueOf(module.getHigt() / (float)fontRenderer.field_78288_b)).getRGB(), true);
                    var20_28 /* !! */  = this.rectValue.get();
                    it = (Boolean)var20_28 /* !! */ ;
                    $i$a$-takeIf-ElementModuleList$drawElement$2$1 = false;
                    var23_38 = (Boolean)(it != false ? var20_28 /* !! */  : null);
                    if (var23_38 == null) continue;
                    it = var23_38;
                    $i$a$-let-ElementModuleList$drawElement$2$2 = false;
                    var20_28 /* !! */  = this.colorTextValue.getColor(Float.valueOf(module.getHigt() / (float)fontRenderer.field_78288_b));
                    if (var20_28 /* !! */  == null) continue;
                    rectColor /* !! */  = var21_31 /* !! */  = var20_28 /* !! */ ;
                    $i$a$-also-ElementModuleList$drawElement$2$3 = false;
                    RenderUtils.INSTANCE.drawRect((Number)Float.valueOf(0.0f), (Number)Float.valueOf(module.getHigt() - (float)true), (Number)Float.valueOf(1.0f), (Number)Float.valueOf(module.getHigt() + textHeight), (Color)rectColor /* !! */ );
                }
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (MinecraftInstance.mc.getCurrentScreen() instanceof GuiHudDesigner) {
            this.x2 = -2147483648;
            if (this.modules.isEmpty()) {
                return this.getSide().getHorizontal() == ElementSide.Horizontal.LEFT ? new ElementBorder(0.0f, -1.0f, 20.0f, 20.0f) : new ElementBorder(0.0f, -1.0f, -20.0f, 20.0f);
            }
            block16: for (Module module : this.modules) {
                switch (WhenMappings.$EnumSwitchMapping$0[this.getSide().getHorizontal().ordinal()]) {
                    case 1: 
                    case 2: {
                        xPos = -((int)module.getSlide()) - 2;
                        if (this.x2 != -2147483648 && xPos >= this.x2) continue block16;
                        this.x2 = xPos;
                        continue block16;
                    }
                    case 3: {
                        xPos = (int)module.getSlide() + 14;
                        if (this.x2 != -2147483648 && xPos <= this.x2) continue block16;
                        this.x2 = xPos;
                        continue block16;
                    }
                }
                throw new NoWhenBranchMatchedException();
            }
            this.y2 = (this.getSide().getVertical() == ElementSide.Vertical.DOWN ? -textSpacer : textSpacer) * (float)this.modules.size();
            return new ElementBorder(0.0f, 0.0f, (float)this.x2 - 7.0f, this.y2 - (this.getSide().getVertical() == ElementSide.Vertical.DOWN ? 1.0f : 0.0f));
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void updateElement() {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        Iterable iterable = DarkMeow.INSTANCE.getModuleManager().getModules();
        ElementModuleList elementModuleList = this;
        boolean $i$f$filter = false;
        void var3_4 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Module it = (Module)element$iv$iv;
            boolean bl2 = false;
            if (!(it.getArray() && (StringsKt.equals((String)this.animationHorizontalValue.get(), "none", true) ? it.getState() : it.getSlide() > 0.0f))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        elementModuleList.modules = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(this){
            final /* synthetic */ ElementModuleList this$0;
            {
                this.this$0 = elementModuleList;
            }

            public final int compare(T a2, T b2) {
                Module it = (Module)a2;
                boolean bl2 = false;
                Comparable comparable = Integer.valueOf(-ElementModuleList.access$getFontValue$p(this.this$0).getFont().func_78256_a(ElementModuleList.access$getModName(this.this$0, it)));
                it = (Module)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, -ElementModuleList.access$getFontValue$p(this.this$0).getFont().func_78256_a(ElementModuleList.access$getModName(this.this$0, it)));
            }
        });
        $this$sortedBy$iv = DarkMeow.INSTANCE.getModuleManager().getModules();
        $i$f$sortedBy = false;
        this.sortedModules = CollectionsKt.toList(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(this){
            final /* synthetic */ ElementModuleList this$0;
            {
                this.this$0 = elementModuleList;
            }

            public final int compare(T a2, T b2) {
                Module it = (Module)a2;
                boolean bl2 = false;
                Comparable comparable = Integer.valueOf(-ElementModuleList.access$getFontValue$p(this.this$0).getFont().func_78256_a(ElementModuleList.access$getModName(this.this$0, it)));
                it = (Module)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, -ElementModuleList.access$getFontValue$p(this.this$0).getFont().func_78256_a(ElementModuleList.access$getModName(this.this$0, it)));
            }
        }));
    }

    /*
     * Unable to fully structure code
     */
    private final String getModName(Module module) {
        block12: {
            var3_2 = module;
            var16_3 = new StringBuilder();
            $i$a$-let-ElementModuleList$getModName$1 = false;
            var5_6 = (String)this.moduleNameValue.get();
            v0 = var16_3.append(Intrinsics.areEqual(var5_6, "Normal") ? it.getName() : (Intrinsics.areEqual(var5_6, "Translated") ? it.getModuleDisplayName() : "null"));
            var2_7 = module.getTag();
            if (var2_7 == null) ** GOTO lbl-1000
            var5_6 = var4_5 = var2_7;
            var16_3 = v0;
            $i$a$-takeIf-ElementModuleList$getModName$2 = false;
            var17_10 = (Boolean)this.moduleTagValue.get();
            v0 = var16_3;
            v1 = var3_2 = var17_10 != false ? var4_5 : null;
            if (var3_2 == null) ** GOTO lbl-1000
            $i$a$-takeIf-ElementModuleList$getModName$2 = var3_2;
            var16_3 = v0;
            $i$a$-let-ElementModuleList$getModName$3 = false;
            var8_12 = new String[4];
            var9_13 = (Boolean)this.moduleTagKeepColorValue.get();
            if (var9_13) {
                v2 = "";
            } else if (!var9_13) {
                v2 = "\u00a77";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            var8_12[0] = v2;
            var10_14 = (String)this.moduleTagStyleValue.get();
            var11_15 = 1;
            var12_16 = var8_12;
            $i$a$-let-ElementModuleList$getModName$3$1 = false;
            var14_18 = style;
            switch (var14_18.hashCode()) {
                case 80085222: {
                    if (var14_18.equals("Space")) break;
                    ** break;
                }
                case 124: {
                    if (!var14_18.equals("|")) {
                        ** break;
                    }
                    ** GOTO lbl43
                }
                case 45: {
                    if (!var14_18.equals("-")) ** break;
lbl43:
                    // 2 sources

                    v3 = ' ' + (String)style + ' ';
                    break block12;
                }
            }
            v3 = " ";
            break block12;
lbl47:
            // 4 sources

            v3 = "";
        }
        var12_16[var11_15] = var15_19 = v3;
        var8_12[2] = it;
        var8_12[3] = " ";
        v0 = var16_3;
        var4_5 = ArraysKt.joinToString$default(var8_12, (CharSequence)"", null, null, 0, null, null, 62, null);
        if (var4_5 != null) {
            v4 = var4_5;
        } else lbl-1000:
        // 3 sources

        {
            v4 = "";
        }
        return v0.append(v4).toString();
    }

    public static final /* synthetic */ FontValue access$getFontValue$p(ElementModuleList $this) {
        return $this.fontValue;
    }

    public static final /* synthetic */ String access$getModName(ElementModuleList $this, Module module) {
        return $this.getModName(module);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ElementSide.Horizontal.values().length];
            try {
                nArray[ElementSide.Horizontal.RIGHT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Horizontal.MIDDLE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Horizontal.LEFT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

