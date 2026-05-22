/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.value.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.elements.impl.ListBodyElement;
import net.ccbluex.liquidbounce.value.elements.impl.ListHeaderElement;
import net.ccbluex.liquidbounce.value.elements.impl.SelectionElement;
import net.ccbluex.liquidbounce.value.elements.impl.SingleSeekBarElement;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u001a\u001b\u001c\u001d\u001e\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "Lnet/ccbluex/liquidbounce/value/impl/FontValue$FontInfo;", "valueName", "", "value", "<init>", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/value/impl/FontValue$FontInfo;)V", "fontCache", "Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "isMinecraft", "", "updateIsMinecraft", "", "clickGuiElement", "", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "()Ljava/util/List;", "isOpenList", "toJson", "Lcom/google/gson/JsonElement;", "fromJson", "element", "getFont", "Lnet/minecraft/client/gui/FontRenderer;", "FontInfo", "ListHeaderElementInner", "SelectionElementInner", "ListBodyElementInner", "SingleSeekBarElementInner", "Companion", "DarkMeow"})
public class FontValue
extends Value<FontInfo> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private GameFontRenderer fontCache;
    private boolean isMinecraft;
    @NotNull
    private final List<Element> clickGuiElement;
    private boolean isOpenList;

    public FontValue(@NotNull String valueName, @NotNull FontInfo value) {
        Intrinsics.checkNotNullParameter(valueName, "valueName");
        Intrinsics.checkNotNullParameter(value, "value");
        super(valueName, value, false, null, null, null, 60, null);
        this.updateIsMinecraft();
        Element[] elementArray = new Element[]{new ListHeaderElementInner(), new SelectionElementInner(), new ListBodyElementInner(), new SingleSeekBarElementInner()};
        this.clickGuiElement = CollectionsKt.mutableListOf(elementArray);
    }

    private final void updateIsMinecraft() {
        this.isMinecraft = Intrinsics.areEqual(((FontInfo)this.getValue()).getName(), "Minecraft");
    }

    @Override
    @NotNull
    public List<Element> getClickGuiElement() {
        return this.clickGuiElement;
    }

    @Override
    @NotNull
    public JsonElement toJson() {
        JsonObject valueObject = new JsonObject();
        valueObject.addProperty("name", this.isMinecraft ? "Minecraft" : ((FontInfo)this.getValue()).getName());
        valueObject.addProperty("size", (Number)((FontInfo)this.getValue()).getSize());
        return (JsonElement)valueObject;
    }

    @Override
    public void fromJson(@NotNull JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        try {
            if (!element.isJsonObject()) {
                return;
            }
            JsonObject valueObject = element.getAsJsonObject();
            FontInfo fontInfo = (FontInfo)this.getValue();
            String string = valueObject.get("name").getAsString();
            Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
            fontInfo.setName(string);
            ((FontInfo)this.getValue()).setSize(valueObject.get("size").getAsInt());
        }
        catch (Throwable e2) {
            this.setValue(this.getDefault());
        }
        this.updateIsMinecraft();
    }

    @NotNull
    public final FontRenderer getFont() {
        block6: {
            block5: {
                if (this.isMinecraft) {
                    return Fonts.minecraftFont;
                }
                Object object = this.fontCache;
                if (object == null || (object = object.getName()) == null) {
                    object = "null";
                }
                if (!Intrinsics.areEqual(object, ((FontInfo)this.getValue()).getName())) break block5;
                GameFontRenderer gameFontRenderer = this.fontCache;
                if (Intrinsics.areEqual(gameFontRenderer != null ? Integer.valueOf(gameFontRenderer.getSize()) : "null", (Object)((FontInfo)this.getValue()).getSize())) break block6;
            }
            this.fontCache = Companion.getFont((FontInfo)this.getValue());
        }
        GameFontRenderer gameFontRenderer = this.fontCache;
        return gameFontRenderer != null ? (FontRenderer)gameFontRenderer : Fonts.minecraftFont;
    }

    @JvmStatic
    @Nullable
    public static final GameFontRenderer getFont(@NotNull FontInfo value) {
        return Companion.getFont(value);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FontValue$Companion;", "", "<init>", "()V", "getFont", "Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "value", "Lnet/ccbluex/liquidbounce/value/impl/FontValue$FontInfo;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @Nullable
        public final GameFontRenderer getFont(@NotNull FontInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            GameFontRenderer gameFontRenderer = Fonts.INSTANCE.getFont(value.getName());
            return gameFontRenderer != null ? gameFontRenderer.deriveFont(value.getSize()) : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Deprecated(message="\u653e\u5f03\u7ef4\u62a4, \u53cd\u9988 = ban")
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FontValue$FontInfo;", "", "name", "", "size", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSize", "()I", "setSize", "(I)V", "DarkMeow"})
    public static final class FontInfo {
        @NotNull
        private String name;
        private int size;

        public FontInfo(@NotNull String name, int size) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.size = size;
        }

        public /* synthetic */ FontInfo(String string, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 1) != 0) {
                string = "Minecraft";
            }
            if ((n3 & 2) != 0) {
                n2 = 30;
            }
            this(string, n2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final void setName(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<set-?>");
            this.name = string;
        }

        public final int getSize() {
            return this.size;
        }

        public final void setSize(int n2) {
            this.size = n2;
        }

        public FontInfo() {
            this(null, 0, 3, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FontValue$ListBodyElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/ListBodyElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/FontValue;)V", "isDisplayable", "", "getList", "", "", "()[Ljava/lang/String;", "getSelected", "onClicked", "", "value", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nFontValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontValue.kt\nnet/ccbluex/liquidbounce/value/impl/FontValue$ListBodyElementInner\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,115:1\n1869#2,2:116\n37#3:118\n36#3,3:119\n*S KotlinDebug\n*F\n+ 1 FontValue.kt\nnet/ccbluex/liquidbounce/value/impl/FontValue$ListBodyElementInner\n*L\n62#1:116,2\n63#1:118\n63#1:119,3\n*E\n"})
    public final class ListBodyElementInner
    extends ListBodyElement {
        @Override
        public boolean isDisplayable() {
            return FontValue.this.isOpenList && !FontValue.this.isMinecraft;
        }

        @Override
        @NotNull
        public String[] getList() {
            List list = new ArrayList();
            Iterable $this$forEach$iv = Fonts.fonts;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                GameFontRenderer it = (GameFontRenderer)((Object)element$iv);
                boolean bl2 = false;
                list.add(it.getName());
            }
            Collection $this$toTypedArray$iv = CollectionsKt.sorted(list);
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            return thisCollection$iv.toArray(new String[0]);
        }

        @Override
        @NotNull
        public String getSelected() {
            return ((FontInfo)FontValue.this.getValue()).getName();
        }

        @Override
        public void onClicked(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Value.set$default(FontValue.this, new FontInfo(value, ((FontInfo)FontValue.this.getValue()).getSize()), false, 2, null);
            FontValue.this.updateIsMinecraft();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FontValue$ListHeaderElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/ListHeaderElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/FontValue;)V", "getTitle", "", "isOpenList", "", "onClicked", "", "value", "DarkMeow"})
    public final class ListHeaderElementInner
    extends ListHeaderElement {
        @Override
        @NotNull
        public String getTitle() {
            return FontValue.this.getName();
        }

        @Override
        public boolean isOpenList() {
            return FontValue.this.isOpenList;
        }

        @Override
        public void onClicked(boolean value) {
            FontValue.this.isOpenList = !value;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FontValue$SelectionElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SelectionElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/FontValue;)V", "isDisplayable", "", "getTitle", "", "getIsActive", "onClicked", "", "value", "DarkMeow"})
    public final class SelectionElementInner
    extends SelectionElement {
        @Override
        public boolean isDisplayable() {
            return FontValue.this.isOpenList;
        }

        @Override
        @NotNull
        public String getTitle() {
            return "MinecraftFont";
        }

        @Override
        public boolean getIsActive() {
            return FontValue.this.isMinecraft;
        }

        @Override
        public void onClicked(boolean value) {
            if (value) {
                FontValue.this.isMinecraft = false;
                if (Intrinsics.areEqual(((FontInfo)FontValue.this.getValue()).getName(), "Minecraft")) {
                    Element element = FontValue.this.getClickGuiElement().get(2);
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type net.ccbluex.liquidbounce.value.impl.FontValue.ListBodyElementInner");
                    ((ListBodyElementInner)element).onClicked(Fonts.fonts.get(0).getName());
                }
            } else {
                FontValue.this.isMinecraft = true;
                Value.set$default(FontValue.this, new FontInfo("Minecraft", 30), false, 2, null);
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/FontValue$SingleSeekBarElementInner;", "Lnet/ccbluex/liquidbounce/value/elements/impl/SingleSeekBarElement;", "<init>", "(Lnet/ccbluex/liquidbounce/value/impl/FontValue;)V", "isDisplayable", "", "getTitle", "", "getLength", "", "getIsInt", "getOffset", "getValue", "onClicked", "", "value", "DarkMeow"})
    public final class SingleSeekBarElementInner
    extends SingleSeekBarElement {
        @Override
        public boolean isDisplayable() {
            return FontValue.this.isOpenList && !FontValue.this.isMinecraft;
        }

        @Override
        @NotNull
        public String getTitle() {
            return "Size\u00a7f: \u00a7c" + ((FontInfo)FontValue.this.getValue()).getSize();
        }

        @Override
        public float getLength() {
            return 128.0f;
        }

        @Override
        public boolean getIsInt() {
            return false;
        }

        @Override
        public float getOffset() {
            return 0.0f;
        }

        @Override
        public float getValue() {
            return ((FontInfo)FontValue.this.getValue()).getSize();
        }

        @Override
        public void onClicked(float value) {
            Value.set$default(FontValue.this, new FontInfo(((FontInfo)FontValue.this.getValue()).getName(), (int)value), false, 2, null);
            FontValue.this.updateIsMinecraft();
        }
    }
}

