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
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.TextElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "toJson", "Lcom/google/gson/JsonPrimitive;", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "TextElementInner", "DarkMeow"})
public class TextValue
extends Value<String> {
    @NotNull
    private final List<Element> clickGuiElement;

    public TextValue(@NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        super(name, value, false, null, null, null, 60, null);
        Element[] elementArray = new Element[]{new TextElementInner()};
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

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/TextValue$TextElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/TextElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/TextValue;)V", "getTitle", "", "getValue", "onClicked", "", "value", "DarkMeow"})
    public final class TextElementInner
    extends TextElement {
        @Override
        @NotNull
        public String getTitle() {
            return TextValue.this.getName();
        }

        @Override
        @NotNull
        public String getValue() {
            return (String)TextValue.this.getValue();
        }

        @Override
        public void onClicked(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Value.set$default(TextValue.this, value, false, 2, null);
        }
    }
}

