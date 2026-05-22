/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.value.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.color.ColorValueManager;
import net.ccbluex.liquidbounce.value.color.mode.ColorValueMode;
import net.ccbluex.liquidbounce.value.color.mode.ColorValueModeSelectCount;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.ListBodyElement;
import net.ccbluex.liquidbounce.value.elements.impl.ListHeaderElement;
import net.ccbluex.liquidbounce.value.elements.impl.RectElement;
import net.ccbluex.liquidbounce.value.elements.impl.SelectionElement;
import net.ccbluex.liquidbounce.value.elements.impl.SingleSeekBarElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007%&'()*+B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0014J\u0012\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;", "name", "", "value", "noAlpha", "", "<init>", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;Z)V", "getNoAlpha", "()Z", "setNoAlpha", "(Z)V", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "isOpenList", "displayNoOffset", "displaySpeed", "displayColorSeekBarCount", "Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueModeSelectCount;", "onUpdateMode", "", "toJson", "Lcom/google/gson/JsonElement;", "fromJson", "element", "onChanged", "oldValue", "newValue", "getColor", "Ljava/awt/Color;", "offset", "", "ListBodyElementInner", "ListHeaderElementInner", "ColorRGBSeekBarInner", "ColorAlphaSeekBarInner", "NoOffsetElementInner", "SpeedSeekBarInner", "RectElementInner", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nColorValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorValue.kt\nnet/ccbluex/liquidbounce/value/impl/ColorValue\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,242:1\n785#2:243\n796#2:244\n1878#2,2:245\n797#2,2:247\n1880#2:249\n799#2:250\n1869#2,2:251\n1869#2,2:253\n*S KotlinDebug\n*F\n+ 1 ColorValue.kt\nnet/ccbluex/liquidbounce/value/impl/ColorValue\n*L\n188#1:243\n188#1:244\n188#1:245,2\n188#1:247,2\n188#1:249\n188#1:250\n191#1:251,2\n213#1:253,2\n*E\n"})
public class ColorValue
extends Value<ColorValueInfo> {
    private boolean noAlpha;
    @NotNull
    private final List<Element> clickGuiElement;
    private boolean isOpenList;
    private boolean displayNoOffset;
    private boolean displaySpeed;
    @NotNull
    private ColorValueModeSelectCount displayColorSeekBarCount;

    public ColorValue(@NotNull String name, @NotNull ColorValueInfo value, boolean noAlpha) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        super(name, value, false, null, null, null, 60, null);
        this.noAlpha = noAlpha;
        Element[] elementArray = new Element[]{new ListHeaderElementInner(), new ListBodyElementInner(), new ColorRGBSeekBarInner(0, 0), new ColorRGBSeekBarInner(0, 1), new ColorRGBSeekBarInner(0, 2), new ColorRGBSeekBarInner(1, 0), new ColorRGBSeekBarInner(1, 1), new ColorRGBSeekBarInner(1, 2), new ColorAlphaSeekBarInner(), new NoOffsetElementInner(), new SpeedSeekBarInner(), new RectElementInner()};
        this.clickGuiElement = CollectionsKt.mutableListOf(elementArray);
        this.displayColorSeekBarCount = ColorValueModeSelectCount.NONE;
        this.setValue(value);
        this.onUpdateMode();
    }

    public /* synthetic */ ColorValue(String string, ColorValueInfo colorValueInfo, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            colorValueInfo = ColorValueManager.Companion.getDEFAULT_NORMAL();
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        this(string, colorValueInfo, bl2);
    }

    public final boolean getNoAlpha() {
        return this.noAlpha;
    }

    public final void setNoAlpha(boolean bl2) {
        this.noAlpha = bl2;
    }

    @Override
    @NotNull
    public List<Element> getClickGuiElement() {
        return this.clickGuiElement;
    }

    private final void onUpdateMode() {
        ColorValueMode colorValueMode = DarkMeow.INSTANCE.getVisualManager().colorValueManager.colorModes.get(((ColorValueInfo)this.getValue()).getMode());
        if (colorValueMode != null) {
            ColorValueMode colorValueMode2;
            ColorValueMode it = colorValueMode2 = colorValueMode;
            boolean bl2 = false;
            this.displayColorSeekBarCount = it.getCount();
            this.displayNoOffset = it.getHasOffset();
            this.displaySpeed = it.getHasSpeed();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.displayColorSeekBarCount.ordinal()]) {
            case 1: {
                if (!((ColorValueInfo)this.getValue()).getColors().isEmpty()) break;
                ((ColorValueInfo)this.getValue()).getColors().add(new ColorValueInfo.ColorValueInfoColor(0, 0, 0, 7, null));
                break;
            }
            case 2: {
                if (((ColorValueInfo)this.getValue()).getColors().isEmpty()) {
                    ((ColorValueInfo)this.getValue()).getColors().add(new ColorValueInfo.ColorValueInfoColor(0, 0, 0, 7, null));
                }
                if (((ColorValueInfo)this.getValue()).getColors().size() != 1) break;
                ((ColorValueInfo)this.getValue()).getColors().add(new ColorValueInfo.ColorValueInfoColor(0, 0, 0, 7, null));
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public JsonElement toJson() {
        void $this$forEach$iv;
        void $this$filterIndexedTo$iv$iv;
        Iterable $this$filterIndexed$iv;
        JsonArray jsonArray;
        JsonObject jsonObject;
        JsonObject $this$toJson_u24lambda_u245 = jsonObject = new JsonObject();
        boolean bl2 = false;
        $this$toJson_u24lambda_u245.addProperty("mode", ((ColorValueInfo)this.getValue()).getMode());
        JsonArray jsonArray2 = jsonArray = new JsonArray();
        String string = "colors";
        JsonObject jsonObject2 = $this$toJson_u24lambda_u245;
        boolean bl3 = false;
        Iterable iterable = ((ColorValueInfo)this.getValue()).getColors();
        boolean $i$f$filterIndexed = false;
        Iterator iterator2 = $this$filterIndexed$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIndexedTo = false;
        void $this$forEachIndexed$iv$iv$iv = $this$filterIndexedTo$iv$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv$iv$iv2 = 0;
        for (Object item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
            void element$iv$iv;
            int n2;
            if ((n2 = index$iv$iv$iv2++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object t2 = item$iv$iv$iv;
            int index$iv$iv = n2;
            boolean bl4 = false;
            ColorValueInfo.ColorValueInfoColor cfr_ignored_0 = (ColorValueInfo.ColorValueInfoColor)element$iv$iv;
            int index = index$iv$iv;
            boolean bl5 = false;
            if (!(index < this.displayColorSeekBarCount.getColorCount())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filterIndexed$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            void $this$toJson_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242;
            void $this$toJson_u24lambda_u245_u24lambda_u244;
            JsonObject jsonObject3;
            ColorValueInfo.ColorValueInfoColor color = (ColorValueInfo.ColorValueInfoColor)element$iv;
            boolean bl6 = false;
            JsonObject index$iv$iv$iv2 = jsonObject3 = new JsonObject();
            Iterator iterator3 = $this$toJson_u24lambda_u245_u24lambda_u244;
            boolean bl7 = false;
            $this$toJson_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242.addProperty("red", (Number)color.getRed());
            $this$toJson_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242.addProperty("green", (Number)color.getGreen());
            $this$toJson_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242.addProperty("blue", (Number)color.getBlue());
            iterator3.add((JsonElement)jsonObject3);
        }
        Unit unit = Unit.INSTANCE;
        jsonObject2.add(string, (JsonElement)jsonArray);
        $this$toJson_u24lambda_u245.addProperty("alpha", (Number)(this.noAlpha ? 255 : ((ColorValueInfo)this.getValue()).getAlpha()));
        $this$toJson_u24lambda_u245.addProperty("no_offset", Boolean.valueOf(((ColorValueInfo)this.getValue()).getNoOffset()));
        $this$toJson_u24lambda_u245.addProperty("speed", (Number)((ColorValueInfo)this.getValue()).getSpeed());
        return (JsonElement)jsonObject;
    }

    @Override
    public void fromJson(@NotNull JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        try {
            JsonObject rootObject = element.getAsJsonObject();
            ColorValueInfo colorValueInfo = (ColorValueInfo)this.getValue();
            String string = rootObject.get("mode").getAsString();
            Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
            colorValueInfo.setMode(string);
            ((ColorValueInfo)this.getValue()).getColors().clear();
            JsonArray jsonArray = rootObject.get("colors").getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(jsonArray, "getAsJsonArray(...)");
            Iterable $this$forEach$iv = (Iterable)jsonArray;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                JsonElement it = (JsonElement)element$iv;
                boolean bl2 = false;
                try {
                    JsonObject jsonObject;
                    JsonObject colorObject = jsonObject = it.getAsJsonObject();
                    boolean bl3 = false;
                    ((ColorValueInfo)this.getValue()).getColors().add(new ColorValueInfo.ColorValueInfoColor(colorObject.get("red").getAsInt(), colorObject.get("green").getAsInt(), colorObject.get("blue").getAsInt()));
                }
                catch (Throwable throwable) {
                }
            }
            ((ColorValueInfo)this.getValue()).setAlpha(this.noAlpha ? 255 : rootObject.get("alpha").getAsInt());
            ((ColorValueInfo)this.getValue()).setNoOffset(rootObject.get("no_offset").getAsBoolean());
            ((ColorValueInfo)this.getValue()).setSpeed(rootObject.get("speed").getAsInt());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.onUpdateMode();
    }

    @Override
    protected void onChanged(@NotNull ColorValueInfo oldValue, @NotNull ColorValueInfo newValue) {
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        this.onUpdateMode();
    }

    @JvmOverloads
    @NotNull
    public Color getColor(@NotNull Number offset) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        return DarkMeow.INSTANCE.getVisualManager().colorValueManager.getColor((ColorValueInfo)this.getValue(), offset.intValue());
    }

    public static /* synthetic */ Color getColor$default(ColorValue colorValue, Number number, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getColor");
        }
        if ((n2 & 1) != 0) {
            number = 0;
        }
        return colorValue.getColor(number);
    }

    @JvmOverloads
    @NotNull
    public final Color getColor() {
        return ColorValue.getColor$default(this, null, 1, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue$ColorAlphaSeekBarInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SingleSeekBarElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ColorValue;)V", "isDisplayable", "", "getTitle", "", "getLength", "", "getValue", "getOffset", "getIsInt", "onClicked", "", "value", "DarkMeow"})
    public final class ColorAlphaSeekBarInner
    extends SingleSeekBarElement {
        @Override
        public boolean isDisplayable() {
            return ColorValue.this.isOpenList && !ColorValue.this.getNoAlpha();
        }

        @Override
        @NotNull
        public String getTitle() {
            return "\u00a7fAlpha: \u00a77" + (int)this.getValue();
        }

        @Override
        public float getLength() {
            return 255.0f;
        }

        @Override
        public float getValue() {
            return ((ColorValueInfo)ColorValue.this.getValue()).getAlpha();
        }

        @Override
        public float getOffset() {
            return 0.0f;
        }

        @Override
        public boolean getIsInt() {
            return true;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void onClicked(float value) {
            void $this$onClicked_u24lambda_u240;
            ColorValueInfo colorValueInfo;
            ColorValueInfo colorValueInfo2 = colorValueInfo = ((ColorValueInfo)ColorValue.this.getValue()).copy();
            Value value2 = ColorValue.this;
            boolean bl2 = false;
            $this$onClicked_u24lambda_u240.setAlpha((int)value);
            Value.set$default(value2, colorValueInfo, false, 2, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue$ColorRGBSeekBarInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SingleSeekBarElement;", "index", "", "colorId", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ColorValue;II)V", "isDisplayable", "", "getTitle", "", "getTitleId", "", "getLength", "", "getValue", "getOffset", "getIsInt", "onClicked", "", "value", "DarkMeow"})
    public final class ColorRGBSeekBarInner
    extends SingleSeekBarElement {
        private final int index;
        private final int colorId;

        public ColorRGBSeekBarInner(int index, int colorId) {
            this.index = index;
            this.colorId = colorId;
        }

        @Override
        public boolean isDisplayable() {
            return ColorValue.this.isOpenList && ColorValue.this.displayColorSeekBarCount.getColorCount() > this.index;
        }

        @Override
        @NotNull
        public String getTitle() {
            String string;
            StringBuilder stringBuilder = new StringBuilder();
            switch (this.colorId) {
                case 0: {
                    string = "\u00a7fRed" + this.getTitleId() + ": \u00a7d";
                    break;
                }
                case 1: {
                    string = "\u00a7fGreen" + this.getTitleId() + ": \u00a7a";
                    break;
                }
                case 2: {
                    string = "\u00a7fBlue" + this.getTitleId() + ": \u00a7b";
                    break;
                }
                default: {
                    string = "";
                }
            }
            return stringBuilder.append(string).append((int)this.getValue()).toString();
        }

        private final Object getTitleId() {
            return ColorValue.this.displayColorSeekBarCount.getColorCount() == 1 ? "" : Integer.valueOf(this.index + 1);
        }

        @Override
        public float getLength() {
            return 255.0f;
        }

        @Override
        public float getValue() {
            int n2;
            try {
                int n3;
                switch (this.colorId) {
                    case 0: {
                        n3 = ((ColorValueInfo)ColorValue.this.getValue()).getColors().get(this.index).getRed();
                        break;
                    }
                    case 1: {
                        n3 = ((ColorValueInfo)ColorValue.this.getValue()).getColors().get(this.index).getGreen();
                        break;
                    }
                    case 2: {
                        n3 = ((ColorValueInfo)ColorValue.this.getValue()).getColors().get(this.index).getBlue();
                        break;
                    }
                    default: {
                        n3 = 0;
                    }
                }
                n2 = n3;
            }
            catch (Throwable throwable) {
                n2 = 0;
            }
            return n2;
        }

        @Override
        public float getOffset() {
            return 0.0f;
        }

        @Override
        public boolean getIsInt() {
            return true;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void onClicked(float value) {
            ColorValueInfo colorValueInfo;
            ColorValueInfo colorValueInfo2 = colorValueInfo = ((ColorValueInfo)ColorValue.this.getValue()).copy();
            Value value2 = ColorValue.this;
            boolean bl2 = false;
            try {
                int n2 = this.colorId;
                switch (n2) {
                    case 0: {
                        void $this$onClicked_u24lambda_u240;
                        $this$onClicked_u24lambda_u240.getColors().get(this.index).setRed((int)value);
                        break;
                    }
                    case 1: {
                        void $this$onClicked_u24lambda_u240;
                        $this$onClicked_u24lambda_u240.getColors().get(this.index).setGreen((int)value);
                        break;
                    }
                    case 2: {
                        void $this$onClicked_u24lambda_u240;
                        $this$onClicked_u24lambda_u240.getColors().get(this.index).setBlue((int)value);
                    }
                }
            }
            catch (Throwable throwable) {
            }
            Value.set$default(value2, colorValueInfo, false, 2, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\r\u0012\t\u0012\u00070\b\u00a2\u0006\u0002\b\t0\u0007H\u0016\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue$ListBodyElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/ListBodyElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ColorValue;)V", "isDisplayable", "", "getList", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "()[Ljava/lang/String;", "getSelected", "onClicked", "", "value", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nColorValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorValue.kt\nnet/ccbluex/liquidbounce/value/impl/ColorValue$ListBodyElementInner\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,242:1\n37#2:243\n36#2,3:244\n*S KotlinDebug\n*F\n+ 1 ColorValue.kt\nnet/ccbluex/liquidbounce/value/impl/ColorValue$ListBodyElementInner\n*L\n47#1:243\n47#1:244,3\n*E\n"})
    public final class ListBodyElementInner
    extends ListBodyElement {
        @Override
        public boolean isDisplayable() {
            return ColorValue.this.isOpenList;
        }

        @Override
        @NotNull
        public String[] getList() {
            Set<String> set = DarkMeow.INSTANCE.getVisualManager().colorValueManager.colorModes.keySet();
            Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
            Collection $this$toTypedArray$iv = set;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            return thisCollection$iv.toArray(new String[0]);
        }

        @Override
        @NotNull
        public String getSelected() {
            return ((ColorValueInfo)ColorValue.this.getValue()).getMode();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void onClicked(@NotNull String value) {
            void $this$onClicked_u24lambda_u240;
            ColorValueInfo colorValueInfo;
            Intrinsics.checkNotNullParameter(value, "value");
            ColorValueInfo colorValueInfo2 = colorValueInfo = ((ColorValueInfo)ColorValue.this.getValue()).copy();
            Value value2 = ColorValue.this;
            boolean bl2 = false;
            $this$onClicked_u24lambda_u240.setMode(value);
            Value.set$default(value2, colorValueInfo, false, 2, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue$ListHeaderElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/ListHeaderElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ColorValue;)V", "getTitle", "", "isOpenList", "", "getDisplayColor", "Ljava/awt/Color;", "onClicked", "", "value", "getExpandWidth", "", "DarkMeow"})
    public final class ListHeaderElementInner
    extends ListHeaderElement {
        @Override
        @NotNull
        public String getTitle() {
            return ColorValue.this.getName();
        }

        @Override
        public boolean isOpenList() {
            return ColorValue.this.isOpenList;
        }

        @Override
        @NotNull
        public Color getDisplayColor() {
            return ColorValue.getColor$default(ColorValue.this, null, 1, null);
        }

        @Override
        public void onClicked(boolean value) {
            ColorValue.this.isOpenList = !value;
        }

        @Override
        public int getExpandWidth() {
            return 40;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue$NoOffsetElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SelectionElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ColorValue;)V", "isDisplayable", "", "getTitle", "", "getIsActive", "onClicked", "", "value", "DarkMeow"})
    public final class NoOffsetElementInner
    extends SelectionElement {
        @Override
        public boolean isDisplayable() {
            return ColorValue.this.isOpenList && ColorValue.this.displayNoOffset;
        }

        @Override
        @NotNull
        public String getTitle() {
            return "NoOffset";
        }

        @Override
        public boolean getIsActive() {
            return ((ColorValueInfo)ColorValue.this.getValue()).getNoOffset();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void onClicked(boolean value) {
            void $this$onClicked_u24lambda_u240;
            ColorValueInfo colorValueInfo;
            ColorValueInfo colorValueInfo2 = colorValueInfo = ((ColorValueInfo)ColorValue.this.getValue()).copy();
            Value value2 = ColorValue.this;
            boolean bl2 = false;
            $this$onClicked_u24lambda_u240.setNoOffset(!value);
            Value.set$default(value2, colorValueInfo, false, 2, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue$RectElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/RectElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ColorValue;)V", "getHeight", "", "isDisplayable", "", "DarkMeow"})
    public final class RectElementInner
    extends RectElement {
        @Override
        public int getHeight() {
            return 4;
        }

        @Override
        public boolean isDisplayable() {
            return ColorValue.this.isOpenList && ColorValue.this.displayColorSeekBarCount != ColorValueModeSelectCount.NONE;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ColorValue$SpeedSeekBarInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SingleSeekBarElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ColorValue;)V", "isDisplayable", "", "getTitle", "", "getLength", "", "getValue", "getOffset", "getIsInt", "onClicked", "", "value", "DarkMeow"})
    public final class SpeedSeekBarInner
    extends SingleSeekBarElement {
        @Override
        public boolean isDisplayable() {
            return ColorValue.this.isOpenList && ColorValue.this.displaySpeed;
        }

        @Override
        @NotNull
        public String getTitle() {
            return "\u00a7fSpeed: \u00a77" + (int)this.getValue();
        }

        @Override
        public float getLength() {
            return 1000.0f;
        }

        @Override
        public float getValue() {
            return ((ColorValueInfo)ColorValue.this.getValue()).getSpeed();
        }

        @Override
        public float getOffset() {
            return 0.0f;
        }

        @Override
        public boolean getIsInt() {
            return true;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void onClicked(float value) {
            void $this$onClicked_u24lambda_u240;
            ColorValueInfo colorValueInfo;
            ColorValueInfo colorValueInfo2 = colorValueInfo = ((ColorValueInfo)ColorValue.this.getValue()).copy();
            Value value2 = ColorValue.this;
            boolean bl2 = false;
            $this$onClicked_u24lambda_u240.setSpeed((int)value);
            Value.set$default(value2, colorValueInfo, false, 2, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ColorValueModeSelectCount.values().length];
            try {
                nArray[ColorValueModeSelectCount.SINGLE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ColorValueModeSelectCount.DOUBLE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

