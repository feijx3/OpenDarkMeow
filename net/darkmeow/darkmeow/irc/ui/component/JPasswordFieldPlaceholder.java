/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.irc.ui.component;

import java.awt.Graphics;
import javax.swing.JPasswordField;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.irc.ui.component.JFieldPlaceholderUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/irc/ui/component/JPasswordFieldPlaceholder;", "Ljavax/swing/JPasswordField;", "placeholder", "", "<init>", "(Ljava/lang/String;)V", "getPlaceholder", "()Ljava/lang/String;", "setPlaceholder", "paintComponent", "", "g", "Ljava/awt/Graphics;", "getPasswordText", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nJPasswordFieldPlaceholder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JPasswordFieldPlaceholder.kt\nnet/darkmeow/darkmeow/irc/ui/component/JPasswordFieldPlaceholder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,32:1\n1#2:33\n*E\n"})
public final class JPasswordFieldPlaceholder
extends JPasswordField {
    @NotNull
    private String placeholder;

    public JPasswordFieldPlaceholder(@NotNull String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.placeholder = placeholder;
        JFieldPlaceholderUtils.INSTANCE.addRepaintListener(this);
    }

    @NotNull
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.placeholder = string;
    }

    @Override
    protected void paintComponent(@NotNull Graphics g2) {
        Intrinsics.checkNotNullParameter(g2, "g");
        super.paintComponent(g2);
        char[] cArray = this.getPassword();
        Intrinsics.checkNotNullExpressionValue(cArray, "getPassword(...)");
        if (cArray.length == 0 && !this.hasFocus()) {
            JFieldPlaceholderUtils.INSTANCE.drawPlaceholder(this, g2, this.placeholder);
        }
    }

    @Nullable
    public final String getPasswordText() {
        String string;
        char[] cArray = this.getPassword();
        Intrinsics.checkNotNullExpressionValue(cArray, "getPassword(...)");
        String it = string = ArraysKt.joinToString$default(cArray, (CharSequence)"", null, null, 0, null, null, 62, null);
        boolean bl2 = false;
        return !Intrinsics.areEqual(it, "********") ? string : null;
    }
}

