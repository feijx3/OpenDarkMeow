/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.irc.ui.component;

import java.awt.Graphics;
import javax.swing.JTextField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.irc.ui.component.JFieldPlaceholderUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\r"}, d2={"Lnet/darkmeow/darkmeow/irc/ui/component/JTextFieldPlaceholder;", "Ljavax/swing/JTextField;", "placeholder", "", "<init>", "(Ljava/lang/String;)V", "getPlaceholder", "()Ljava/lang/String;", "setPlaceholder", "paintComponent", "", "g", "Ljava/awt/Graphics;", "DarkMeow"})
public final class JTextFieldPlaceholder
extends JTextField {
    @NotNull
    private String placeholder;

    public JTextFieldPlaceholder(@NotNull String placeholder) {
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
        String string = this.getText();
        Intrinsics.checkNotNullExpressionValue(string, "getText(...)");
        if (((CharSequence)string).length() == 0 && !this.hasFocus()) {
            JFieldPlaceholderUtils.INSTANCE.drawPlaceholder(this, g2, this.placeholder);
        }
    }
}

