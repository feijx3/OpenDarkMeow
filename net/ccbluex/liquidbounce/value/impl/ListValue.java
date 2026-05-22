/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.ListBodyElement;
import net.ccbluex.liquidbounce.value.elements.impl.ListHeaderElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "values", "", "value", "<init>", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "getValues", "()[Ljava/lang/String;", "setValues", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "isOpenList", "", "changeValue", "getSelectedId", "", "getInputId", "toJson", "Lcom/google/gson/JsonPrimitive;", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "ListHeaderElementInner", "ListBodyElementInner", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nListValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListValue.kt\nnet/ccbluex/liquidbounce/value/impl/ListValue\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,65:1\n13472#2,2:66\n*S KotlinDebug\n*F\n+ 1 ListValue.kt\nnet/ccbluex/liquidbounce/value/impl/ListValue\n*L\n38#1:66,2\n*E\n"})
public class ListValue
extends Value<String> {
    @NotNull
    private String[] values;
    @NotNull
    private final List<Element> clickGuiElement;
    private boolean isOpenList;

    public ListValue(@NotNull String name, @NotNull String[] values, @NotNull String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(value, "value");
        super(name, value, false, null, null, null, 60, null);
        this.values = values;
        Element[] elementArray = new Element[]{new ListHeaderElementInner(), new ListBodyElementInner()};
        this.clickGuiElement = CollectionsKt.mutableListOf(elementArray);
        this.setValue(value);
    }

    public /* synthetic */ ListValue(String string, String[] stringArray, String string2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            stringArray = new String[]{};
        }
        if ((n2 & 4) != 0) {
            string2 = "";
        }
        this(string, stringArray, string2);
    }

    @NotNull
    public final String[] getValues() {
        return this.values;
    }

    public final void setValues(@NotNull String[] stringArray) {
        Intrinsics.checkNotNullParameter(stringArray, "<set-?>");
        this.values = stringArray;
    }

    @Override
    @NotNull
    public List<Element> getClickGuiElement() {
        return this.clickGuiElement;
    }

    @Override
    public boolean changeValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String[] $this$forEach$iv = this.values;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String element$iv;
            String valueSingle = element$iv = $this$forEach$iv[i2];
            boolean bl2 = false;
            if (!StringsKt.equals(valueSingle, value, true)) continue;
            this.setValue(valueSingle);
            return true;
        }
        return false;
    }

    public final int getSelectedId() {
        return ArraysKt.indexOf(this.values, this.getValue());
    }

    public final int getInputId(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ArraysKt.indexOf(this.values, value);
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
            this.changeValue(string);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ListValue$ListBodyElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/ListBodyElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ListValue;)V", "isDisplayable", "", "getList", "", "", "()[Ljava/lang/String;", "getSelected", "onClicked", "", "value", "DarkMeow"})
    public final class ListBodyElementInner
    extends ListBodyElement {
        @Override
        public boolean isDisplayable() {
            return ListValue.this.isOpenList;
        }

        @Override
        @NotNull
        public String[] getList() {
            return ListValue.this.getValues();
        }

        @Override
        @NotNull
        public String getSelected() {
            return (String)ListValue.this.getValue();
        }

        @Override
        public void onClicked(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Value.set$default(ListValue.this, value, false, 2, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/ListValue$ListHeaderElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/ListHeaderElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/ListValue;)V", "getTitle", "", "isOpenList", "", "onClicked", "", "value", "DarkMeow"})
    public final class ListHeaderElementInner
    extends ListHeaderElement {
        @Override
        @NotNull
        public String getTitle() {
            return ListValue.this.getName();
        }

        @Override
        public boolean isOpenList() {
            return ListValue.this.isOpenList;
        }

        @Override
        public void onClicked(boolean value) {
            ListValue.this.isOpenList = !value;
        }
    }
}

