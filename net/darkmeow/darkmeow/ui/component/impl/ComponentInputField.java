/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$LogicOp
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ChatAllowedCharacters
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.ui.component.impl;

import java.awt.Color;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.ComponentRenderUtils;
import net.darkmeow.darkmeow.ui.component.event.ComponentKeyTypedEvent;
import net.darkmeow.darkmeow.ui.component.event.ComponentMouseClickedEvent;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b;\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 V2\u00020\u0001:\u0001VB\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012#\b\u0002\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000e\u0012#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00120\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0003J\u000e\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0003J\u0006\u0010>\u001a\u00020\u0012J\u0006\u0010?\u001a\u00020\u0012J\u0006\u0010@\u001a\u00020\bJ$\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u00032\b\b\u0002\u0010D\u001a\u00020\u000bH\u0007J\u000e\u0010E\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0003J\u000e\u0010F\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0003J(\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020SH\u0016J\b\u0010T\u001a\u00020\u0012H\u0016J\b\u0010U\u001a\u00020\u0012H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R5\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00120\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010+\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001a\u0010.\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR$\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0003@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u00105\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u0014\u0010G\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010 \u00a8\u0006W"}, d2={"Lnet/darkmeow/darkmeow/ui/component/impl/ComponentInputField;", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "posX", "", "posY", "width", "height", "text", "", "maxStringLength", "readOnly", "", "tip", "onUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "new", "", "onPressEnter", "current", "<init>", "(IIIILjava/lang/String;IZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getMaxStringLength", "()I", "setMaxStringLength", "(I)V", "getReadOnly", "()Z", "setReadOnly", "(Z)V", "getTip", "setTip", "getOnUpdate", "()Lkotlin/jvm/functions/Function1;", "setOnUpdate", "(Lkotlin/jvm/functions/Function1;)V", "getOnPressEnter", "setOnPressEnter", "typing", "getTyping", "setTyping", "lineScrollOffset", "getLineScrollOffset", "setLineScrollOffset", "value", "cursorPosition", "getCursorPosition", "setCursorPosition", "selectionEnd", "getSelectionEnd", "setSelectionEnd", "writeText", "input", "moveCursorBy", "num", "setSelectionPos", "position", "setCursorPositionZero", "setCursorPositionEnd", "getSelectedText", "getNthWord", "n", "startPos", "skipWs", "deleteWords", "deleteFromCursor", "allowFocus", "getAllowFocus", "drawComponent", "mouseX", "mouseY", "isFocused", "partialTicks", "", "onKeyTyped", "event", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentKeyTypedEvent;", "onMouseClick", "Lnet/darkmeow/darkmeow/ui/component/event/ComponentMouseClickedEvent;", "onUnfocus", "onInit", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nComponentInputField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentInputField.kt\nnet/darkmeow/darkmeow/ui/component/impl/ComponentInputField\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,430:1\n1#2:431\n*E\n"})
public final class ComponentInputField
extends AbstractComponent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private String text;
    private int maxStringLength;
    private boolean readOnly;
    @NotNull
    private String tip;
    @NotNull
    private Function1<? super String, Unit> onUpdate;
    @NotNull
    private Function1<? super String, Unit> onPressEnter;
    private boolean typing;
    private int lineScrollOffset;
    private int cursorPosition;
    private int selectionEnd;
    private final boolean allowFocus;

    public ComponentInputField(int posX, int posY, int width, int height, @NotNull String text, int maxStringLength, boolean readOnly, @NotNull String tip, @NotNull Function1<? super String, Unit> onUpdate2, @NotNull Function1<? super String, Unit> onPressEnter) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(onUpdate2, "onUpdate");
        Intrinsics.checkNotNullParameter(onPressEnter, "onPressEnter");
        super(posX, posY, width, height);
        this.text = text;
        this.maxStringLength = maxStringLength;
        this.readOnly = readOnly;
        this.tip = tip;
        this.onUpdate = onUpdate2;
        this.onPressEnter = onPressEnter;
        this.allowFocus = true;
    }

    public /* synthetic */ ComponentInputField(int n2, int n3, int n4, int n5, String string, int n6, boolean bl2, String string2, Function1 function1, Function1 function12, int n7, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n7 & 0x20) != 0) {
            n6 = 100;
        }
        if ((n7 & 0x40) != 0) {
            bl2 = false;
        }
        if ((n7 & 0x80) != 0) {
            string2 = "";
        }
        if ((n7 & 0x100) != 0) {
            function1 = ComponentInputField::_init_$lambda$0;
        }
        if ((n7 & 0x200) != 0) {
            function12 = ComponentInputField::_init_$lambda$1;
        }
        this(n2, n3, n4, n5, string, n6, bl2, string2, function1, function12);
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final void setText(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.text = string;
    }

    public final int getMaxStringLength() {
        return this.maxStringLength;
    }

    public final void setMaxStringLength(int n2) {
        this.maxStringLength = n2;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final void setReadOnly(boolean bl2) {
        this.readOnly = bl2;
    }

    @NotNull
    public final String getTip() {
        return this.tip;
    }

    public final void setTip(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.tip = string;
    }

    @NotNull
    public final Function1<String, Unit> getOnUpdate() {
        return this.onUpdate;
    }

    public final void setOnUpdate(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onUpdate = function1;
    }

    @NotNull
    public final Function1<String, Unit> getOnPressEnter() {
        return this.onPressEnter;
    }

    public final void setOnPressEnter(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onPressEnter = function1;
    }

    public final boolean getTyping() {
        return this.typing;
    }

    public final void setTyping(boolean bl2) {
        this.typing = bl2;
    }

    public final int getLineScrollOffset() {
        return this.lineScrollOffset;
    }

    public final void setLineScrollOffset(int n2) {
        this.lineScrollOffset = n2;
    }

    public final int getCursorPosition() {
        return this.cursorPosition;
    }

    public final void setCursorPosition(int value) {
        this.cursorPosition = MathHelper.func_76125_a((int)value, (int)0, (int)this.text.length());
        this.setSelectionPos(this.cursorPosition);
    }

    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    public final void setSelectionEnd(int n2) {
        this.selectionEnd = n2;
    }

    public final void writeText(@NotNull String input) {
        String result;
        Intrinsics.checkNotNullParameter(input, "input");
        String filtered = ChatAllowedCharacters.func_71565_a((String)input);
        Integer[] integerArray = new Integer[]{this.cursorPosition, this.selectionEnd};
        List list = CollectionsKt.sorted((Iterable)CollectionsKt.listOf(integerArray));
        int start = ((Number)list.get(0)).intValue();
        int end = ((Number)list.get(1)).intValue();
        int allowedLength = this.maxStringLength - (this.text.length() - (end - start));
        String prefix = StringsKt.take(this.text, start);
        Intrinsics.checkNotNull(filtered);
        String insert = StringsKt.take(filtered, allowedLength);
        String suffix = StringsKt.drop(this.text, end);
        this.text = result = prefix + insert + suffix;
        this.moveCursorBy(start - this.selectionEnd + insert.length());
        this.onUpdate.invoke(this.text);
    }

    public final void moveCursorBy(int num) {
        this.setCursorPosition(this.selectionEnd + num);
    }

    public final void setSelectionPos(int position) {
        FontRenderer fontRenderer;
        int pos;
        this.selectionEnd = pos = RangesKt.coerceIn(position, 0, this.text.length());
        FontRenderer renderer = fontRenderer = this.getBase().getTheme().getFont();
        boolean bl2 = false;
        int maxOffset = this.text.length();
        this.lineScrollOffset = RangesKt.coerceAtMost(this.lineScrollOffset, maxOffset);
        int visibleWidth = this.getWidth() - 8;
        String string = this.text.substring(this.lineScrollOffset);
        Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        String visibleText = renderer.func_78269_a(string, visibleWidth);
        int visibleEnd = this.lineScrollOffset + visibleText.length();
        if (pos == this.lineScrollOffset) {
            int reverseWidth = renderer.func_78262_a(this.text, visibleWidth, true).length();
            this.lineScrollOffset -= reverseWidth;
        } else if (pos > visibleEnd) {
            this.lineScrollOffset += pos - visibleEnd;
        } else if (pos < this.lineScrollOffset) {
            this.lineScrollOffset -= this.lineScrollOffset - pos;
        }
        this.lineScrollOffset = RangesKt.coerceIn(this.lineScrollOffset, 0, maxOffset);
    }

    public final void setCursorPositionZero() {
        this.setCursorPosition(0);
    }

    public final void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }

    @NotNull
    public final String getSelectedText() {
        int startIndex = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
        int endIndex = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
        String string = this.text.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        return string;
    }

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    public final int getNthWord(int n2, int startPos, boolean skipWs) {
        Ref.IntRef index = new Ref.IntRef();
        index.element = startPos;
        boolean movingBackward = n2 < 0;
        int steps = Math.abs(n2);
        int length = this.text.length();
        for (int i2 = 0; i2 < steps; ++i2) {
            void it;
            int n3;
            int it2 = i2;
            boolean bl2 = false;
            if (movingBackward) {
                while (skipWs && index.element > 0 && this.text.charAt(index.element - 1) == ' ') {
                    n3 = index.element;
                    index.element = n3 + -1;
                }
                while (index.element > 0 && this.text.charAt(index.element - 1) != ' ') {
                    n3 = index.element;
                    index.element = n3 + -1;
                }
                continue;
            }
            int n4 = StringsKt.indexOf$default((CharSequence)this.text, ' ', index.element, false, 4, null);
            Ref.IntRef intRef = index;
            boolean bl3 = false;
            intRef.element = ((Number)(it == -1 ? length : it)).intValue();
            while (skipWs && index.element < length && this.text.charAt(index.element) == ' ') {
                n3 = index.element;
                index.element = n3 + 1;
            }
        }
        return index.element;
    }

    public static /* synthetic */ int getNthWord$default(ComponentInputField componentInputField, int n2, int n3, boolean bl2, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n3 = componentInputField.cursorPosition;
        }
        if ((n4 & 4) != 0) {
            bl2 = true;
        }
        return componentInputField.getNthWord(n2, n3, bl2);
    }

    public final void deleteWords(int num) {
        if (!(((CharSequence)this.text).length() == 0)) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            } else {
                this.deleteFromCursor(ComponentInputField.getNthWord$default(this, num, 0, false, 6, null) - this.cursorPosition);
            }
        }
    }

    public final void deleteFromCursor(int num) {
        if (!(((CharSequence)this.text).length() == 0)) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            } else {
                boolean flag = num < 0;
                int i2 = flag ? this.cursorPosition + num : this.cursorPosition;
                int j2 = flag ? this.cursorPosition : this.cursorPosition + num;
                String s2 = "";
                if (i2 >= 0) {
                    String string = this.text.substring(0, i2);
                    Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                    s2 = string;
                }
                if (j2 < this.text.length()) {
                    StringBuilder stringBuilder = new StringBuilder().append(s2);
                    String string = this.text.substring(j2);
                    Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                    s2 = stringBuilder.append(string).toString();
                }
                this.text = s2;
                if (flag) {
                    this.moveCursorBy(num);
                }
                this.onUpdate.invoke(this.text);
            }
        }
    }

    @Override
    public boolean getAllowFocus() {
        return this.allowFocus;
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean isFocused, float partialTicks) {
        ComponentRenderUtils.INSTANCE.drawBoardRect(this, this.getBase().getTheme(), isFocused);
        Color fontColor = this.readOnly ? this.getBase().getTheme().getColorFontReadOnly() : this.getBase().getTheme().getColorFont();
        int baseY = this.getHeight() / 2 - this.getBase().getTheme().getFont().field_78288_b / 2;
        FontRenderer fontRenderer = this.getBase().getTheme().getFont();
        FontRenderer fontRenderer2 = this.getBase().getTheme().getFont();
        String string = this.text.substring(this.lineScrollOffset);
        Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        String string2 = fontRenderer2.func_78269_a(string, this.getWidth() - 8);
        Intrinsics.checkNotNullExpressionValue(string2, "trimStringToWidth(...)");
        FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, fontRenderer, string2, 4, baseY, fontColor, false, 16, null);
        if (this.getBase().getFocus() != this && ((CharSequence)this.text).length() == 0) {
            FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, this.getBase().getTheme().getFont(), this.tip, 4, baseY, this.getBase().getTheme().getColorFontTip(), false, 16, null);
        }
        if (Companion.shouldDisplayCursor() && this.getBase().getFocus() == this && this.typing) {
            FontRenderer fontRenderer3 = this.getBase().getTheme().getFont();
            String string3 = this.text.substring(0, this.cursorPosition - this.lineScrollOffset);
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
            int cursorX = 4 + fontRenderer3.func_78256_a(string3);
            if (this.cursorPosition < this.text.length() || this.text.length() >= this.maxStringLength) {
                RenderUtils.INSTANCE.drawRect(cursorX, baseY, cursorX + 1, baseY + this.getBase().getTheme().getFont().field_78288_b, fontColor);
            } else if (!this.readOnly) {
                FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, this.getBase().getTheme().getFont(), "_", cursorX, baseY, fontColor, false, 16, null);
            }
        }
        if (this.selectionEnd - this.lineScrollOffset != this.cursorPosition - this.lineScrollOffset) {
            FontRenderer fontRenderer4 = this.getBase().getTheme().getFont();
            String string4 = this.text.substring(0, this.cursorPosition - this.lineScrollOffset);
            Intrinsics.checkNotNullExpressionValue(string4, "substring(...)");
            int n2 = 4 + fontRenderer4.func_78256_a(string4);
            FontRenderer fontRenderer5 = this.getBase().getTheme().getFont();
            String string5 = this.text.substring(0, this.selectionEnd - this.lineScrollOffset);
            Intrinsics.checkNotNullExpressionValue(string5, "substring(...)");
            Companion.drawSelectionBox(n2, baseY, 4 + fontRenderer5.func_78256_a(string5), baseY + this.getBase().getTheme().getFont().field_78288_b);
        }
    }

    @Override
    public void onKeyTyped(@NotNull ComponentKeyTypedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.typing) {
            if (GuiScreen.func_175278_g((int)event.getCode())) {
                this.setCursorPositionEnd();
                this.setSelectionPos(0);
                event.cancelNext();
                return;
            }
            if (GuiScreen.func_175280_f((int)event.getCode())) {
                GuiScreen.func_146275_d((String)this.getSelectedText());
                event.cancelNext();
                return;
            }
            if (GuiScreen.func_175279_e((int)event.getCode())) {
                if (!this.readOnly) {
                    String string = GuiScreen.func_146277_j();
                    Intrinsics.checkNotNullExpressionValue(string, "getClipboardString(...)");
                    this.writeText(string);
                }
                event.cancelNext();
                return;
            }
            if (GuiScreen.func_175277_d((int)event.getCode())) {
                GuiScreen.func_146275_d((String)this.getSelectedText());
                if (!this.readOnly) {
                    this.writeText("");
                }
                event.cancelNext();
                return;
            }
            switch (event.getCode()) {
                case 1: 
                case 28: {
                    if (event.getCode() == 28) {
                        this.onPressEnter.invoke(this.text);
                    }
                    this.typing = false;
                    event.cancelNext();
                    return;
                }
                case 14: {
                    if (!this.readOnly) {
                        if (GuiScreen.func_146271_m()) {
                            this.deleteWords(-1);
                        } else {
                            this.deleteFromCursor(-1);
                        }
                    }
                    event.cancelNext();
                    return;
                }
                case 211: {
                    if (!this.readOnly) {
                        if (GuiScreen.func_146271_m()) {
                            this.deleteWords(1);
                        } else {
                            this.deleteFromCursor(1);
                        }
                    }
                    event.cancelNext();
                    return;
                }
                case 199: {
                    if (GuiScreen.func_146272_n()) {
                        this.setSelectionPos(0);
                    } else {
                        this.setCursorPositionZero();
                    }
                    event.cancelNext();
                    return;
                }
                case 207: {
                    if (GuiScreen.func_146272_n()) {
                        this.setSelectionPos(this.text.length());
                    } else {
                        this.setCursorPositionEnd();
                    }
                    event.cancelNext();
                    return;
                }
                case 203: {
                    if (GuiScreen.func_146272_n()) {
                        if (GuiScreen.func_146271_m()) {
                            this.setSelectionPos(ComponentInputField.getNthWord$default(this, -1, this.selectionEnd, false, 4, null));
                        } else {
                            this.setSelectionPos(this.selectionEnd - 1);
                        }
                    } else if (GuiScreen.func_146271_m()) {
                        this.setCursorPosition(ComponentInputField.getNthWord$default(this, -1, 0, false, 6, null));
                    } else {
                        this.moveCursorBy(-1);
                    }
                    event.cancelNext();
                    return;
                }
                case 205: {
                    if (GuiScreen.func_146272_n()) {
                        if (GuiScreen.func_146271_m()) {
                            this.setSelectionPos(ComponentInputField.getNthWord$default(this, 1, this.selectionEnd, false, 4, null));
                        } else {
                            this.setSelectionPos(this.selectionEnd + 1);
                        }
                    } else if (GuiScreen.func_146271_m()) {
                        this.setCursorPosition(ComponentInputField.getNthWord$default(this, 1, 0, false, 6, null));
                    } else {
                        this.moveCursorBy(1);
                    }
                    event.cancelNext();
                    return;
                }
            }
            if (!this.readOnly && ChatAllowedCharacters.func_71566_a((char)event.getChar())) {
                this.writeText(String.valueOf(event.getChar()));
            }
            event.cancelNext();
            return;
        }
        switch (event.getCode()) {
            case 1: 
            case 15: 
            case 200: 
            case 203: 
            case 205: 
            case 208: {
                break;
            }
            default: {
                this.typing = true;
                this.onKeyTyped(event);
            }
        }
    }

    @Override
    public void onMouseClick(@NotNull ComponentMouseClickedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getButton() == 0) {
            FontRenderer fontRenderer;
            this.typing = true;
            FontRenderer renderer = fontRenderer = this.getBase().getTheme().getFont();
            boolean bl2 = false;
            String string = this.text.substring(this.lineScrollOffset);
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
            String s2 = renderer.func_78269_a(string, this.getWidth() - 8);
            this.setCursorPosition(renderer.func_78269_a(s2, event.getClickX() - 4).length() + this.lineScrollOffset);
        }
    }

    @Override
    public void onUnfocus() {
        this.typing = false;
    }

    @Override
    public void onInit() {
        this.setCursorPositionEnd();
    }

    @JvmOverloads
    public final int getNthWord(int n2, int startPos) {
        return ComponentInputField.getNthWord$default(this, n2, startPos, false, 4, null);
    }

    @JvmOverloads
    public final int getNthWord(int n2) {
        return ComponentInputField.getNthWord$default(this, n2, 0, false, 6, null);
    }

    private static final Unit _init_$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u00a8\u0006\r"}, d2={"Lnet/darkmeow/darkmeow/ui/component/impl/ComponentInputField$Companion;", "", "<init>", "()V", "shouldDisplayCursor", "", "drawSelectionBox", "", "x", "", "y", "x2", "y2", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean shouldDisplayCursor() {
            return System.currentTimeMillis() % (long)1000 < 500L;
        }

        public final void drawSelectionBox(int x2, int y2, int x22, int y22) {
            BufferBuilder bufferBuilder;
            Tessellator tessellator;
            double minX = Math.min(x2, x22);
            double maxX = Math.max(x2, x22);
            double minY = Math.min(y2, y22);
            double maxY = Math.max(y2, y22);
            GlStateManager.func_179131_c((float)0.0f, (float)0.0f, (float)255.0f, (float)255.0f);
            GlStateManager.func_179090_x();
            GlStateManager.func_179115_u();
            GlStateManager.func_187422_a((GlStateManager.LogicOp)GlStateManager.LogicOp.OR_REVERSE);
            Tessellator it = tessellator = Tessellator.func_178181_a();
            boolean bl2 = false;
            BufferBuilder $this$drawSelectionBox_u24lambda_u241_u24lambda_u240 = bufferBuilder = it.func_178180_c();
            boolean bl3 = false;
            $this$drawSelectionBox_u24lambda_u241_u24lambda_u240.func_181668_a(7, DefaultVertexFormats.field_181705_e);
            $this$drawSelectionBox_u24lambda_u241_u24lambda_u240.func_181662_b(minX, maxY, 0.0).func_181675_d();
            $this$drawSelectionBox_u24lambda_u241_u24lambda_u240.func_181662_b(maxX, maxY, 0.0).func_181675_d();
            $this$drawSelectionBox_u24lambda_u241_u24lambda_u240.func_181662_b(maxX, minY, 0.0).func_181675_d();
            $this$drawSelectionBox_u24lambda_u241_u24lambda_u240.func_181662_b(minX, minY, 0.0).func_181675_d();
            tessellator.func_78381_a();
            GlStateManager.func_179134_v();
            GlStateManager.func_179098_w();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

