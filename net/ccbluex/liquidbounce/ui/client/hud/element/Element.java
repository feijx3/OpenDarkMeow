/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.value.Value;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010F\u001a\u000206H\u0016J\b\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u0004\u0018\u0001002\u0006\u0010J\u001a\u00020\tH&J\b\u0010K\u001a\u00020HH\u0016J\u0018\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0016J\u0018\u0010P\u001a\u0002062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010Q\u001a\u00020H2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\rH\u0016J\u0018\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\rH\u0016J\b\u0010W\u001a\u000206H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0011R$\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R$\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR\u001a\u0010>\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010\u001dR\u001e\u0010A\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030C0B8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006X"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "baseName", "", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide;", "priority", "", "<init>", "(Ljava/lang/String;DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide;I)V", "getBaseName", "()Ljava/lang/String;", "setBaseName", "(Ljava/lang/String;)V", "getX", "()D", "setX", "(D)V", "getY", "setY", "getScale", "()F", "setScale", "(F)V", "getSide", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide;", "setSide", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide;)V", "getPriority", "()I", "setPriority", "(I)V", "name", "getName", "value", "renderX", "getRenderX", "setRenderX", "renderY", "getRenderY", "setRenderY", "border", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "getBorder", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "setBorder", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;)V", "drag", "", "getDrag", "()Z", "setDrag", "(Z)V", "prevMouseX", "getPrevMouseX", "setPrevMouseX", "prevMouseY", "getPrevMouseY", "setPrevMouseY", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "createElement", "destroyElement", "", "drawElement", "partialTicks", "updateElement", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "updateId", "", "isInBorder", "handleMouseClick", "mouseButton", "handleKey", "c", "", "keyCode", "handleEvents", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Element.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/Element\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,129:1\n11228#2:130\n11563#2,3:131\n808#3,11:134\n*S KotlinDebug\n*F\n+ 1 Element.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/Element\n*L\n72#1:130\n72#1:131,3\n75#1:134,11\n*E\n"})
public abstract class Element
extends MinecraftInstance
implements Listenable {
    @NotNull
    private String baseName;
    private double x;
    private double y;
    private float scale;
    @NotNull
    private ElementSide side;
    private int priority;
    @Nullable
    private ElementBorder border;
    private boolean drag;
    private float prevMouseX;
    private float prevMouseY;

    public Element(@NotNull String baseName, double x2, double y2, float scale, @NotNull ElementSide side, int priority) {
        Intrinsics.checkNotNullParameter(baseName, "baseName");
        Intrinsics.checkNotNullParameter(side, "side");
        this.baseName = baseName;
        this.x = x2;
        this.y = y2;
        this.scale = scale;
        this.side = side;
        this.priority = priority;
    }

    public /* synthetic */ Element(String string, double d2, double d3, float f2, ElementSide elementSide, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            d2 = 2.0;
        }
        if ((n3 & 4) != 0) {
            d3 = 2.0;
        }
        if ((n3 & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n3 & 0x10) != 0) {
            elementSide = ElementSide.Companion.getDEFAULT();
        }
        if ((n3 & 0x20) != 0) {
            n2 = 100;
        }
        this(string, d2, d3, f2, elementSide, n2);
    }

    @NotNull
    public final String getBaseName() {
        return this.baseName;
    }

    public final void setBaseName(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.baseName = string;
    }

    public final double getX() {
        return this.x;
    }

    public final void setX(double d2) {
        this.x = d2;
    }

    public final double getY() {
        return this.y;
    }

    public final void setY(double d2) {
        this.y = d2;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f2) {
        this.scale = f2;
    }

    @NotNull
    public final ElementSide getSide() {
        return this.side;
    }

    public final void setSide(@NotNull ElementSide elementSide) {
        Intrinsics.checkNotNullParameter(elementSide, "<set-?>");
        this.side = elementSide;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int n2) {
        this.priority = n2;
    }

    @NotNull
    public final String getName() {
        return this.baseName;
    }

    public final double getRenderX() {
        double d2;
        switch (WhenMappings.$EnumSwitchMapping$0[this.side.getHorizontal().ordinal()]) {
            case 1: {
                d2 = this.x;
                break;
            }
            case 2: {
                d2 = (double)(new ScaledResolution(MinecraftInstance.mc_nowarp).func_78326_a() / 2) - this.x;
                break;
            }
            case 3: {
                d2 = (double)new ScaledResolution(MinecraftInstance.mc_nowarp).func_78326_a() - this.x;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return d2;
    }

    public final void setRenderX(double value) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.side.getHorizontal().ordinal()]) {
            case 1: {
                this.x += value;
                break;
            }
            case 2: 
            case 3: {
                this.x -= value;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final double getRenderY() {
        double d2;
        switch (WhenMappings.$EnumSwitchMapping$1[this.side.getVertical().ordinal()]) {
            case 1: {
                d2 = this.y;
                break;
            }
            case 2: {
                d2 = (double)(new ScaledResolution(MinecraftInstance.mc_nowarp).func_78328_b() / 2) - this.y;
                break;
            }
            case 3: {
                d2 = (double)new ScaledResolution(MinecraftInstance.mc_nowarp).func_78328_b() - this.y;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return d2;
    }

    public final void setRenderY(double value) {
        switch (WhenMappings.$EnumSwitchMapping$1[this.side.getVertical().ordinal()]) {
            case 1: {
                this.y += value;
                break;
            }
            case 2: 
            case 3: {
                this.y -= value;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Nullable
    public final ElementBorder getBorder() {
        return this.border;
    }

    public final void setBorder(@Nullable ElementBorder elementBorder) {
        this.border = elementBorder;
    }

    public final boolean getDrag() {
        return this.drag;
    }

    public final void setDrag(boolean bl2) {
        this.drag = bl2;
    }

    public final float getPrevMouseX() {
        return this.prevMouseX;
    }

    public final void setPrevMouseX(float f2) {
        this.prevMouseX = f2;
    }

    public final float getPrevMouseY() {
        return this.prevMouseY;
    }

    public final void setPrevMouseY(float f2) {
        this.prevMouseY = f2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<Value<?>> getValues() {
        void $this$filterIsInstanceTo$iv$iv;
        Iterable $this$mapTo$iv$iv;
        Field[] fieldArray = this.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
        Object[] $this$map$iv = fieldArray;
        boolean $i$f$map = false;
        Object[] objectArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (void item$iv$iv : $this$mapTo$iv$iv) {
            void valueField;
            Field field = (Field)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            valueField.setAccessible(true);
            collection.add(valueField.get(this));
        }
        Iterable $this$filterIsInstance$iv = (List)destination$iv$iv;
        boolean $i$f$filterIsInstance = false;
        $this$mapTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof Value)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    public boolean createElement() {
        return true;
    }

    public void destroyElement() {
    }

    @Nullable
    public abstract ElementBorder drawElement(float var1);

    public void updateElement() {
    }

    public void updateElement(@NotNull EntityPlayerSP player, long updateId) {
        Intrinsics.checkNotNullParameter(player, "player");
    }

    public boolean isInBorder(double x2, double y2) {
        ElementBorder elementBorder = this.border;
        if (elementBorder == null) {
            return false;
        }
        ElementBorder border = elementBorder;
        float minX = Math.min(border.getX(), border.getX2());
        float minY = Math.min(border.getY(), border.getY2());
        float maxX = Math.max(border.getX(), border.getX2());
        float maxY = Math.max(border.getY(), border.getY2());
        return (double)minX <= x2 && (double)minY <= y2 && (double)maxX >= x2 && (double)maxY >= y2;
    }

    public void handleMouseClick(double x2, double y2, int mouseButton) {
    }

    public void handleKey(char c2, int keyCode) {
    }

    @Override
    public boolean handleEvents() {
        return true;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[ElementSide.Horizontal.values().length];
            try {
                nArray[ElementSide.Horizontal.LEFT.ordinal()] = 1;
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
                nArray[ElementSide.Horizontal.RIGHT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[ElementSide.Vertical.values().length];
            try {
                nArray[ElementSide.Vertical.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Vertical.MIDDLE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ElementSide.Vertical.DOWN.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

