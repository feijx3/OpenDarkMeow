/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.irc.ui.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\f"}, d2={"Lnet/darkmeow/darkmeow/irc/ui/component/JFieldPlaceholderUtils;", "", "<init>", "()V", "addRepaintListener", "", "Ljavax/swing/JTextField;", "drawPlaceholder", "g", "Ljava/awt/Graphics;", "placeholder", "", "DarkMeow"})
public final class JFieldPlaceholderUtils {
    @NotNull
    public static final JFieldPlaceholderUtils INSTANCE = new JFieldPlaceholderUtils();

    private JFieldPlaceholderUtils() {
    }

    public final void addRepaintListener(@NotNull JTextField $this$addRepaintListener) {
        Intrinsics.checkNotNullParameter($this$addRepaintListener, "<this>");
        $this$addRepaintListener.getDocument().addDocumentListener(new DocumentListener($this$addRepaintListener){
            final /* synthetic */ JTextField $this_addRepaintListener;
            {
                this.$this_addRepaintListener = $receiver;
            }

            public void insertUpdate(DocumentEvent e2) {
                Intrinsics.checkNotNullParameter(e2, "e");
                this.$this_addRepaintListener.repaint();
            }

            public void removeUpdate(DocumentEvent e2) {
                Intrinsics.checkNotNullParameter(e2, "e");
                this.$this_addRepaintListener.repaint();
            }

            public void changedUpdate(DocumentEvent e2) {
                Intrinsics.checkNotNullParameter(e2, "e");
                this.$this_addRepaintListener.repaint();
            }
        });
        $this$addRepaintListener.addFocusListener(new FocusListener($this$addRepaintListener){
            final /* synthetic */ JTextField $this_addRepaintListener;
            {
                this.$this_addRepaintListener = $receiver;
            }

            public void focusGained(FocusEvent e2) {
                this.$this_addRepaintListener.repaint();
            }

            public void focusLost(FocusEvent e2) {
                this.$this_addRepaintListener.repaint();
            }
        });
    }

    public final void drawPlaceholder(@NotNull JTextField $this$drawPlaceholder, @NotNull Graphics g2, @NotNull String placeholder) {
        Graphics graphics;
        Intrinsics.checkNotNullParameter($this$drawPlaceholder, "<this>");
        Intrinsics.checkNotNullParameter(g2, "g");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Graphics $this$drawPlaceholder_u24lambda_u240 = graphics = g2.create();
        boolean bl2 = false;
        $this$drawPlaceholder_u24lambda_u240.setColor(Color.GRAY);
        $this$drawPlaceholder_u24lambda_u240.drawString(placeholder, $this$drawPlaceholder.getInsets().left + 2, $this$drawPlaceholder.getHeight() / 2 + 5);
        $this$drawPlaceholder_u24lambda_u240.dispose();
    }
}

