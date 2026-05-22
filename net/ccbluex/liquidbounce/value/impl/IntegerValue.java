/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.SingleSeekBarElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006!"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "", "value", "range", "Lkotlin/ranges/ClosedRange;", "<init>", "(Ljava/lang/String;ILkotlin/ranges/ClosedRange;)V", "minimum", "maximum", "(Ljava/lang/String;III)V", "getRange", "()Lkotlin/ranges/ClosedRange;", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "getMinimum", "()I", "getMaximum", "set", "", "newValue", "", "toJson", "Lcom/google/gson/JsonPrimitive;", "fromJson", "element", "Lcom/google/gson/JsonElement;", "SingleSeekBarElementInner", "DarkMeow"})
public class IntegerValue
extends Value<Integer> {
    @NotNull
    private final ClosedRange<Integer> range;
    @NotNull
    private final List<Element> clickGuiElement;
    private final int minimum;
    private final int maximum;

    public IntegerValue(@NotNull String name, int value, @NotNull ClosedRange<Integer> range) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(range, "range");
        super(name, value, false, null, null, null, 60, null);
        this.range = range;
        Element[] elementArray = new Element[]{new SingleSeekBarElementInner()};
        this.clickGuiElement = CollectionsKt.mutableListOf(elementArray);
        this.minimum = ((Number)this.range.getStart()).intValue();
        this.maximum = ((Number)this.range.getEndInclusive()).intValue();
    }

    public /* synthetic */ IntegerValue(String string, int n2, ClosedRange closedRange, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            closedRange = new IntRange(0, Integer.MAX_VALUE);
        }
        this(string, n2, closedRange);
    }

    @NotNull
    public final ClosedRange<Integer> getRange() {
        return this.range;
    }

    public IntegerValue(@NotNull String name, int value, int minimum, int maximum) {
        Intrinsics.checkNotNullParameter(name, "name");
        this(name, value, new IntRange(minimum, maximum));
    }

    public /* synthetic */ IntegerValue(String string, int n2, int n3, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 4) != 0) {
            n3 = 0;
        }
        if ((n5 & 8) != 0) {
            n4 = Integer.MAX_VALUE;
        }
        this(string, n2, n3, n4);
    }

    @Override
    @NotNull
    public List<Element> getClickGuiElement() {
        return this.clickGuiElement;
    }

    public final int getMinimum() {
        return this.minimum;
    }

    public final int getMaximum() {
        return this.maximum;
    }

    public final void set(@NotNull Number newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Value.set$default(this, newValue.intValue(), false, 2, null);
    }

    @NotNull
    public JsonPrimitive toJson() {
        return new JsonPrimitive((Number)this.getValue());
    }

    @Override
    public void fromJson(@NotNull JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.isJsonPrimitive()) {
            this.setValue(element.getAsInt());
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/IntegerValue$SingleSeekBarElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SingleSeekBarElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;)V", "getTitle", "", "getLength", "", "getValue", "getOffset", "getIsInt", "", "onClicked", "", "value", "DarkMeow"})
    public final class SingleSeekBarElementInner
    extends SingleSeekBarElement {
        @Override
        @NotNull
        public String getTitle() {
            return IntegerValue.this.getName() + "\u00a7f: \u00a7c" + ((Number)IntegerValue.this.getValue()).intValue();
        }

        @Override
        public float getLength() {
            return ((Number)IntegerValue.this.getRange().getEndInclusive()).intValue() - ((Number)IntegerValue.this.getRange().getStart()).intValue();
        }

        @Override
        public float getValue() {
            return ((Number)IntegerValue.this.getValue()).intValue() - ((Number)IntegerValue.this.getRange().getStart()).intValue();
        }

        @Override
        public float getOffset() {
            return ((Number)IntegerValue.this.getRange().getStart()).intValue();
        }

        @Override
        public boolean getIsInt() {
            return true;
        }

        @Override
        public void onClicked(float value) {
            Value.set$default(IntegerValue.this, (int)(value + ((Number)IntegerValue.this.getRange().getStart()).floatValue()), false, 2, null);
        }
    }
}

