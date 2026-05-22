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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.SelectionElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0006\u0010\u0017\u001a\u00020\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "", "value", "<init>", "(Ljava/lang/String;Z)V", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "displayable", "getDisplayable", "()Z", "toJson", "Lcom/google/gson/JsonPrimitive;", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "toggle", "getState", "SelectionElementInner", "DarkMeow"})
public class BoolValue
extends Value<Boolean> {
    @NotNull
    private final List<Element> clickGuiElement;

    public BoolValue(@NotNull String name, boolean value) {
        Intrinsics.checkNotNullParameter(name, "name");
        super(name, value, false, null, null, null, 60, null);
        Element[] elementArray = new Element[]{new SelectionElementInner()};
        this.clickGuiElement = CollectionsKt.mutableListOf(elementArray);
    }

    @Override
    @NotNull
    public List<Element> getClickGuiElement() {
        return this.clickGuiElement;
    }

    @Override
    public boolean getDisplayable() {
        Value<?> value = this.getSuperValue();
        BoolValue boolValue = value instanceof BoolValue ? (BoolValue)value : null;
        return (boolValue != null ? boolValue.getState() : true) && super.getDisplayable();
    }

    @NotNull
    public JsonPrimitive toJson() {
        return new JsonPrimitive((Boolean)this.getValue());
    }

    @Override
    public void fromJson(@NotNull JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.isJsonPrimitive()) {
            this.setValue(element.getAsBoolean() || StringsKt.equals(element.getAsString(), "true", true));
        }
    }

    public void toggle() {
        this.setValue((Boolean)this.getValue() == false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean getState() {
        if ((Boolean)this.getValue() == false) return false;
        if (!this.getDisplayable()) return false;
        Value<?> value = this.getSuperValue();
        if (!(value instanceof BoolValue)) return true;
        BoolValue boolValue = (BoolValue)value;
        if (boolValue == null) return true;
        boolean bl2 = boolValue.getState();
        if (!bl2) return false;
        return true;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/BoolValue$SelectionElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SelectionElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/BoolValue;)V", "getTitle", "", "getIsActive", "", "onClicked", "", "value", "DarkMeow"})
    public final class SelectionElementInner
    extends SelectionElement {
        @Override
        @NotNull
        public String getTitle() {
            return BoolValue.this.getName();
        }

        @Override
        public boolean getIsActive() {
            return (Boolean)BoolValue.this.getValue();
        }

        @Override
        public void onClicked(boolean value) {
            Value.set$default(BoolValue.this, !value, false, 2, null);
        }
    }
}

