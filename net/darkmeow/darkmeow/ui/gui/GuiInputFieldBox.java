/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.ui.gui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.AbstractDarkGui;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.base.DarkGuiBaseUtils;
import net.darkmeow.darkmeow.ui.component.impl.ComponentButton;
import net.darkmeow.darkmeow.ui.component.impl.ComponentGroup;
import net.darkmeow.darkmeow.ui.component.impl.ComponentInputField;
import net.darkmeow.darkmeow.ui.component.impl.ComponentText;
import net.darkmeow.darkmeow.ui.theme.DefaultTheme;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2={"Lnet/darkmeow/darkmeow/ui/gui/GuiInputFieldBox;", "Lnet/darkmeow/darkmeow/ui/AbstractDarkGui;", "prevGui", "Lnet/minecraft/client/gui/GuiScreen;", "title", "", "defaultText", "maxStringLength", "", "doneCallback", "Lkotlin/Function1;", "", "<init>", "(Lnet/minecraft/client/gui/GuiScreen;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "getDefaultText", "getMaxStringLength", "()I", "getDoneCallback", "()Lkotlin/jvm/functions/Function1;", "componentInputField", "Lnet/darkmeow/darkmeow/ui/component/impl/ComponentInputField;", "getComponentInputField", "()Lnet/darkmeow/darkmeow/ui/component/impl/ComponentInputField;", "setComponentInputField", "(Lnet/darkmeow/darkmeow/ui/component/impl/ComponentInputField;)V", "init", "DarkMeow"})
public final class GuiInputFieldBox
extends AbstractDarkGui {
    @NotNull
    private final String title;
    @NotNull
    private final String defaultText;
    private final int maxStringLength;
    @NotNull
    private final Function1<String, Unit> doneCallback;
    public ComponentInputField componentInputField;

    public GuiInputFieldBox(@Nullable GuiScreen prevGui, @NotNull String title, @NotNull String defaultText, int maxStringLength, @NotNull Function1<? super String, Unit> doneCallback) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        Intrinsics.checkNotNullParameter(doneCallback, "doneCallback");
        super(prevGui, DefaultTheme.INSTANCE.getDEFAULT());
        this.title = title;
        this.defaultText = defaultText;
        this.maxStringLength = maxStringLength;
        this.doneCallback = doneCallback;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getDefaultText() {
        return this.defaultText;
    }

    public final int getMaxStringLength() {
        return this.maxStringLength;
    }

    @NotNull
    public final Function1<String, Unit> getDoneCallback() {
        return this.doneCallback;
    }

    @NotNull
    public final ComponentInputField getComponentInputField() {
        ComponentInputField componentInputField = this.componentInputField;
        if (componentInputField != null) {
            return componentInputField;
        }
        Intrinsics.throwUninitializedPropertyAccessException("componentInputField");
        return null;
    }

    public final void setComponentInputField(@NotNull ComponentInputField componentInputField) {
        Intrinsics.checkNotNullParameter(componentInputField, "<set-?>");
        this.componentInputField = componentInputField;
    }

    @Override
    public void init() {
        DarkGuiBaseUtils.INSTANCE.addComponent(this, (AbstractComponent)new ComponentGroup(this.field_146294_l / 2 - 150, this.field_146295_m / 2 - 32, 300, 64, false, 16, null), arg_0 -> GuiInputFieldBox.init$lambda$3(this, arg_0));
    }

    private static final Unit init$lambda$3$lambda$0(GuiInputFieldBox this$0, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this$0.closeGui();
        this$0.doneCallback.invoke(text);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$3$lambda$2(GuiInputFieldBox this$0) {
        this$0.closeGui();
        this$0.doneCallback.invoke(this$0.getComponentInputField().getText());
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit init$lambda$3(GuiInputFieldBox this$0, ComponentGroup group) {
        void it;
        ComponentInputField componentInputField;
        Intrinsics.checkNotNullParameter(group, "group");
        group.addComponent(new ComponentText(0, 0, group.getWidth(), 16, this$0.title, null, true, false, 160, null));
        ComponentInputField componentInputField2 = componentInputField = new ComponentInputField(4, 16, group.getWidth() - 8, 20, this$0.defaultText, this$0.maxStringLength, false, null, null, arg_0 -> GuiInputFieldBox.init$lambda$3$lambda$0(this$0, arg_0), 448, null);
        ComponentGroup componentGroup = group;
        boolean bl2 = false;
        this$0.setComponentInputField((ComponentInputField)it);
        group.setFocus((AbstractComponent)it);
        componentGroup.addComponent(componentInputField);
        group.addComponent(new ComponentButton(group.getWidth() - 64, group.getHeight() - 24, 60, 20, "Save", false, () -> GuiInputFieldBox.init$lambda$3$lambda$2(this$0), 32, null));
        this$0.setFocus(group);
        return Unit.INSTANCE;
    }
}

