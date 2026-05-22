/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.utils.math.ClosedRangeUtils;
import net.ccbluex.liquidbounce.utils.math.RandomUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.DoubleSeekBarElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tB3\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "Lkotlin/ranges/ClosedRange;", "", "name", "", "value", "range", "<init>", "(Ljava/lang/String;Lkotlin/ranges/ClosedRange;Lkotlin/ranges/ClosedRange;)V", "minimum", "maximum", "(Ljava/lang/String;Lkotlin/ranges/ClosedRange;FF)V", "getRange", "()Lkotlin/ranges/ClosedRange;", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "random", "toJson", "Lcom/google/gson/JsonElement;", "fromJson", "", "element", "DoubleSeekBarElementInner", "DarkMeow"})
public class FloatRangeValue
extends Value<ClosedRange<Float>> {
    @NotNull
    private final ClosedRange<Float> range;
    @NotNull
    private final List<Element> clickGuiElement;

    public FloatRangeValue(@NotNull String name, @NotNull ClosedRange<Float> value, @NotNull ClosedRange<Float> range) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(range, "range");
        super(name, value, false, null, null, null, 60, null);
        this.range = range;
        Element[] elementArray = new Element[]{new DoubleSeekBarElementInner()};
        this.clickGuiElement = CollectionsKt.mutableListOf(elementArray);
    }

    public /* synthetic */ FloatRangeValue(String string, ClosedRange closedRange, ClosedRange closedRange2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            closedRange2 = RangesKt.rangeTo(0.0f, Float.MAX_VALUE);
        }
        this(string, closedRange, closedRange2);
    }

    @NotNull
    public final ClosedRange<Float> getRange() {
        return this.range;
    }

    public FloatRangeValue(@NotNull String name, @NotNull ClosedRange<Float> value, float minimum, float maximum) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this(name, value, (ClosedRange<Float>)RangesKt.rangeTo(minimum, maximum));
    }

    public /* synthetic */ FloatRangeValue(String string, ClosedRange closedRange, float f2, float f3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            f2 = 0.0f;
        }
        if ((n2 & 8) != 0) {
            f3 = Float.MAX_VALUE;
        }
        this(string, closedRange, f2, f3);
    }

    @Override
    @NotNull
    public List<Element> getClickGuiElement() {
        return this.clickGuiElement;
    }

    public final float random() {
        return RandomUtils.INSTANCE.random(((Number)((ClosedRange)this.getValue()).getStart()).floatValue(), ((Number)((ClosedRange)this.getValue()).getEndInclusive()).floatValue());
    }

    @Override
    @NotNull
    public JsonElement toJson() {
        JsonObject jsonObject;
        JsonObject $this$toJson_u24lambda_u240 = jsonObject = new JsonObject();
        boolean bl2 = false;
        $this$toJson_u24lambda_u240.addProperty("min", (Number)((ClosedRange)this.getValue()).getStart());
        $this$toJson_u24lambda_u240.addProperty("max", (Number)((ClosedRange)this.getValue()).getEndInclusive());
        return (JsonElement)jsonObject;
    }

    @Override
    public void fromJson(@NotNull JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            JsonElement jsonElement = jsonObject.get("min");
            float minValue = jsonElement != null ? jsonElement.getAsFloat() : ((Number)((ClosedRange)this.getValue()).getStart()).floatValue();
            JsonElement jsonElement2 = jsonObject.get("max");
            float maxValue = jsonElement2 != null ? jsonElement2.getAsFloat() : ((Number)((ClosedRange)this.getValue()).getEndInclusive()).floatValue();
            this.setValue(ClosedRangeUtils.INSTANCE.smartCreate((Comparable)Float.valueOf(minValue), (Comparable)Float.valueOf(maxValue)));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue$DoubleSeekBarElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/DoubleSeekBarElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue;)V", "getTitle", "", "getLength", "", "getValue", "Lkotlin/ranges/ClosedRange;", "getIsInt", "", "getOffset", "onClicked", "", "value", "round", "Ljava/math/BigDecimal;", "f", "DarkMeow"})
    public final class DoubleSeekBarElementInner
    extends DoubleSeekBarElement {
        @Override
        @NotNull
        public String getTitle() {
            return FloatRangeValue.this.getName() + "\u00a7f: \u00a7c" + this.round(((Number)((ClosedRange)FloatRangeValue.this.getValue()).getStart()).floatValue()) + " ~ " + this.round(((Number)((ClosedRange)FloatRangeValue.this.getValue()).getEndInclusive()).floatValue());
        }

        @Override
        public float getLength() {
            return ((Number)FloatRangeValue.this.getRange().getEndInclusive()).floatValue() - ((Number)FloatRangeValue.this.getRange().getStart()).floatValue();
        }

        @Override
        @NotNull
        public ClosedRange<Float> getValue() {
            return ClosedRangeUtils.INSTANCE.smartCreate((Comparable)Float.valueOf(((Number)((ClosedRange)FloatRangeValue.this.getValue()).getStart()).floatValue() - ((Number)FloatRangeValue.this.getRange().getStart()).floatValue()), (Comparable)Float.valueOf(((Number)((ClosedRange)FloatRangeValue.this.getValue()).getEndInclusive()).floatValue() - ((Number)FloatRangeValue.this.getRange().getStart()).floatValue()));
        }

        @Override
        public boolean getIsInt() {
            return false;
        }

        @Override
        public float getOffset() {
            return ((Number)FloatRangeValue.this.getRange().getStart()).floatValue();
        }

        @Override
        public void onClicked(@NotNull ClosedRange<Float> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Value.set$default(FloatRangeValue.this, RangesKt.rangeTo(((Number)value.getStart()).floatValue() + ((Number)FloatRangeValue.this.getRange().getStart()).floatValue(), ((Number)value.getEndInclusive()).floatValue() + ((Number)FloatRangeValue.this.getRange().getStart()).floatValue()), false, 2, null);
        }

        private final BigDecimal round(float f2) {
            BigDecimal bd2 = new BigDecimal(String.valueOf(f2));
            BigDecimal bigDecimal = bd2.setScale(2, RoundingMode.valueOf(4));
            Intrinsics.checkNotNullExpressionValue(bigDecimal, "setScale(...)");
            bd2 = bigDecimal;
            return bd2;
        }
    }
}

