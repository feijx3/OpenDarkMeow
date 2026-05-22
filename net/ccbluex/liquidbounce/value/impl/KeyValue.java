/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Keyboard
 */
package net.ccbluex.liquidbounce.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.KeySelectionElement;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/KeyValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "toJson", "Lcom/google/gson/JsonPrimitive;", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "changeValue", "", "isKeyDown", "isBindKey", "KeySelectionElementInner", "DarkMeow"})
public class KeyValue
extends Value<String> {
    @NotNull
    private final List<Element> clickGuiElement;

    public KeyValue(@NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        super(name, value, false, null, null, null, 60, null);
        Element[] elementArray = new Element[]{new KeySelectionElementInner()};
        this.clickGuiElement = CollectionsKt.mutableListOf(elementArray);
    }

    @Override
    @NotNull
    public List<Element> getClickGuiElement() {
        return this.clickGuiElement;
    }

    @NotNull
    public JsonPrimitive toJson() {
        return new JsonPrimitive((String)this.getValue());
    }

    @Override
    public void fromJson(@NotNull JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.isJsonPrimitive()) {
            String string = element.getAsString();
            Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
            this.setValue(string);
        }
    }

    @Override
    public boolean changeValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.setValue(Keyboard.getKeyIndex((String)value) == 0 || Intrinsics.areEqual(value, "ESCAPE") ? "NONE" : value);
        return true;
    }

    public boolean isKeyDown() {
        return KeyUtils.INSTANCE.isSystemKeyDown((String)this.getValue());
    }

    public boolean isBindKey() {
        return Intrinsics.areEqual(this.getName(), "NONE") || Keyboard.getKeyIndex((String)((String)this.getValue())) == 0;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/KeyValue$KeySelectionElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/KeySelectionElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/KeyValue;)V", "getTitle", "", "getSelected", "onClicked", "", "value", "DarkMeow"})
    public final class KeySelectionElementInner
    extends KeySelectionElement {
        @Override
        @NotNull
        public String getTitle() {
            return KeyValue.this.getName();
        }

        @Override
        @NotNull
        public String getSelected() {
            return Keyboard.getKeyIndex((String)((String)KeyValue.this.getValue())) == 0 ? "NONE" : (String)KeyValue.this.getValue();
        }

        @Override
        public void onClicked(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Value.set$default(KeyValue.this, value, false, 2, null);
        }
    }
}

