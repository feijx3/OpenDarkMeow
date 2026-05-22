/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.irc.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.irc.config.IRCGlobalConfigManager;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigRoot;
import net.darkmeow.darkmeow.irc.ui.IRCVerifyAdvanceSettings;
import net.darkmeow.darkmeow.irc.ui.component.JPasswordFieldPlaceholder;
import net.darkmeow.darkmeow.irc.ui.component.JTextFieldPlaceholder;
import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.interfaces.IRCClientProvider;
import net.darkmeow.irc.client.interfaces.data.IRCDataSelfSessionInfo;
import net.darkmeow.irc.client.listener.IRCClientListenableSimple;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u00070\u0013\u00a2\u0006\u0002\b\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2={"Lnet/darkmeow/darkmeow/irc/ui/IRCVerifyMainMenu;", "Ljavax/swing/JFrame;", "<init>", "()V", "isClosed", "", "()Z", "setClosed", "(Z)V", "isAccept", "usernameField", "Lnet/darkmeow/darkmeow/irc/ui/component/JTextFieldPlaceholder;", "passwordField", "Lnet/darkmeow/darkmeow/irc/ui/component/JPasswordFieldPlaceholder;", "loginButton", "Ljavax/swing/JButton;", "advanceSettingsButton", "waitForClose", "irc", "Lnet/darkmeow/irc/client/interfaces/IRCClientProvider;", "Lorg/jetbrains/annotations/NotNull;", "getIrc", "()Lnet/darkmeow/irc/client/interfaces/IRCClientProvider;", "login", "", "DarkMeow"})
public final class IRCVerifyMainMenu
extends JFrame {
    private boolean isClosed;
    @JvmField
    public boolean isAccept;
    @NotNull
    private JTextFieldPlaceholder usernameField;
    @NotNull
    private JPasswordFieldPlaceholder passwordField;
    @NotNull
    private final JButton loginButton;
    @NotNull
    private final JButton advanceSettingsButton;
    @NotNull
    private final IRCClientProvider irc;

    /*
     * WARNING - void declaration
     */
    public IRCVerifyMainMenu() {
        super("Async Loli Protection");
        void $this$advanceSettingsButton_u24lambda_u246;
        JComponent $this$loginButton_u24lambda_u244;
        JComponent $this$passwordField_u24lambda_u241;
        JTextField $this$usernameField_u24lambda_u240;
        JComponent jComponent;
        JTextFieldPlaceholder jTextFieldPlaceholder = jComponent = new JTextFieldPlaceholder("\u7528\u6237\u540d");
        IRCVerifyMainMenu iRCVerifyMainMenu = this;
        boolean bl2 = false;
        $this$usernameField_u24lambda_u240.setBounds(50, 50, 300, 30);
        this.add($this$usernameField_u24lambda_u240);
        $this$usernameField_u24lambda_u240.setText(IRCGlobalConfigManager.INSTANCE.getConfig().getUser());
        iRCVerifyMainMenu.usernameField = jComponent;
        $this$usernameField_u24lambda_u240 = jComponent = new JPasswordFieldPlaceholder("\u5bc6\u7801");
        iRCVerifyMainMenu = this;
        boolean bl3 = false;
        $this$passwordField_u24lambda_u241.setBounds(50, 100, 300, 30);
        this.add($this$passwordField_u24lambda_u241);
        $this$passwordField_u24lambda_u241.setText(IRCGlobalConfigManager.INSTANCE.getConfig().getPassword().length() == 128 ? "********" : IRCGlobalConfigManager.INSTANCE.getConfig().getPassword());
        iRCVerifyMainMenu.passwordField = jComponent;
        $this$passwordField_u24lambda_u241 = jComponent = new JButton("\u767b\u5f55");
        iRCVerifyMainMenu = this;
        boolean bl4 = false;
        $this$loginButton_u24lambda_u244.setBounds(150, 160, 100, 30);
        this.add($this$loginButton_u24lambda_u244);
        ((AbstractButton)$this$loginButton_u24lambda_u244).addActionListener(arg_0 -> IRCVerifyMainMenu.loginButton$lambda$4$lambda$3(this, arg_0));
        iRCVerifyMainMenu.loginButton = jComponent;
        $this$loginButton_u24lambda_u244 = jComponent = new JButton("E");
        iRCVerifyMainMenu = this;
        boolean bl5 = false;
        $this$advanceSettingsButton_u24lambda_u246.setBounds(360, 4, 20, 20);
        this.add((Component)$this$advanceSettingsButton_u24lambda_u246);
        $this$advanceSettingsButton_u24lambda_u246.addActionListener(IRCVerifyMainMenu::advanceSettingsButton$lambda$6$lambda$5);
        iRCVerifyMainMenu.advanceSettingsButton = jComponent;
        this.irc = IRCGlobalConfigManager.INSTANCE.newClientInstance(new IRCClientListenableSimple(this){
            public IRCClientProvider client;
            final /* synthetic */ IRCVerifyMainMenu this$0;
            {
                this.this$0 = $receiver;
            }

            public final IRCClientProvider getClient() {
                IRCClientProvider iRCClientProvider = this.client;
                if (iRCClientProvider != null) {
                    return iRCClientProvider;
                }
                Intrinsics.throwUninitializedPropertyAccessException("client");
                return null;
            }

            public final void setClient(IRCClientProvider iRCClientProvider) {
                Intrinsics.checkNotNullParameter(iRCClientProvider, "<set-?>");
                this.client = iRCClientProvider;
            }

            /*
             * WARNING - void declaration
             */
            public void onReadyLogin(IRCClientProvider client) {
                void it;
                String string;
                Intrinsics.checkNotNullParameter(client, "client");
                this.setClient(client);
                String string2 = string = IRCVerifyMainMenu.access$getPasswordField$p(this.this$0).getPasswordText();
                String string3 = IRCVerifyMainMenu.access$getUsernameField$p(this.this$0).getText();
                IRCClientProvider iRCClientProvider = client;
                boolean bl2 = false;
                boolean bl3 = !Intrinsics.areEqual(it, "********");
                String string4 = bl3 ? string : null;
                if (string4 == null) {
                    string4 = IRCGlobalConfigManager.INSTANCE.getConfig().getPassword();
                }
                iRCClientProvider.login(string3, string4, true);
            }

            public void onUpdateSession(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                IRCGlobalConfigManager.INSTANCE.read();
                IRCGlobalConfigRoot iRCGlobalConfigRoot = IRCGlobalConfigManager.INSTANCE.getConfig();
                String string = IRCVerifyMainMenu.access$getUsernameField$p(this.this$0).getText();
                Intrinsics.checkNotNullExpressionValue(string, "getText(...)");
                iRCGlobalConfigRoot.setUser(string);
                IRCGlobalConfigManager.INSTANCE.getConfig().setPassword(token);
                IRCGlobalConfigManager.INSTANCE.save();
            }

            public void onUpdateUserInfo(IRCDataSelfSessionInfo info, boolean isFirstLogin) {
                Intrinsics.checkNotNullParameter(info, "info");
                this.this$0.isAccept = true;
                this.this$0.setClosed(true);
                this.getClient().disconnect(false);
                this.this$0.dispose();
            }

            public void onMessageSystem(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                DarkMeow.INSTANCE.getMessageManager().displayChatMessage(message);
            }

            public void onDisconnect(EnumDisconnectType type, String reason, boolean logout) {
                Intrinsics.checkNotNullParameter((Object)((Object)type), "type");
                if (type != EnumDisconnectType.DISCONNECT_BY_USER) {
                    JOptionPane.showMessageDialog(this.this$0, "\u767b\u5f55\u5931\u8d25: " + reason);
                }
                IRCVerifyMainMenu.access$getUsernameField$p(this.this$0).setEnabled(true);
                IRCVerifyMainMenu.access$getPasswordField$p(this.this$0).setEnabled(true);
                IRCVerifyMainMenu.access$getLoginButton$p(this.this$0).setEnabled(true);
            }
        });
        this.setSize(400, 250);
        this.setLayout(null);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e2) {
                block0: {
                    Integer n2;
                    Intrinsics.checkNotNullParameter(e2, "e");
                    super.windowClosing(e2);
                    Integer n3 = JOptionPane.showConfirmDialog(this, "\u662f\u5426\u786e\u8ba4\u5173\u95ed\u9a8c\u8bc1\u7a97\u53e3, \u786e\u8ba4\u540e\u5ba2\u6237\u7aef\u5c06\u4e0d\u4f1a\u88ab\u52a0\u8f7d", this.getTitle(), 0);
                    int it = ((Number)n3).intValue();
                    boolean bl2 = false;
                    Integer n4 = n2 = it == 0 ? n3 : null;
                    if (n2 == null) break block0;
                    n3 = n2;
                    IRCVerifyMainMenu iRCVerifyMainMenu = this;
                    int it2 = ((Number)n3).intValue();
                    boolean bl3 = false;
                    iRCVerifyMainMenu.dispose();
                }
            }

            @Override
            public void windowClosed(WindowEvent e2) {
                Intrinsics.checkNotNullParameter(e2, "e");
                this.getIrc().disconnect(false);
                this.setClosed(true);
            }
        });
        if (IRCGlobalConfigManager.INSTANCE.getConfig().isToken()) {
            this.login();
        }
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        if (!this.isAccept) {
            this.setVisible(true);
        }
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final void setClosed(boolean bl2) {
        this.isClosed = bl2;
    }

    public final boolean waitForClose() {
        while (!this.isClosed) {
            Thread.sleep(1000L);
        }
        return this.isAccept;
    }

    @NotNull
    public final IRCClientProvider getIrc() {
        return this.irc;
    }

    public final void login() {
        block2: {
            Object object;
            this.usernameField.setEnabled(false);
            this.passwordField.setEnabled(false);
            this.loginButton.setEnabled(false);
            Object object2 = this;
            try {
                IRCVerifyMainMenu $this$login_u24lambda_u247 = object2;
                boolean bl2 = false;
                $this$login_u24lambda_u247.irc.connect();
                object = Result.constructor-impl(Unit.INSTANCE);
            }
            catch (Throwable bl2) {
                object = Result.constructor-impl(ResultKt.createFailure(bl2));
            }
            object2 = object;
            Throwable throwable = Result.exceptionOrNull-impl(object2);
            if (throwable == null) break block2;
            Object e2 = object = throwable;
            boolean bl3 = false;
            JOptionPane.showMessageDialog(this, "\u8fde\u63a5\u670d\u52a1\u5668\u5931\u8d25");
            this.usernameField.setEnabled(true);
            this.passwordField.setEnabled(true);
            this.loginButton.setEnabled(true);
        }
    }

    private static final void loginButton$lambda$4$lambda$3$lambda$2(IRCVerifyMainMenu this$0) {
        this$0.login();
    }

    private static final void loginButton$lambda$4$lambda$3(IRCVerifyMainMenu this$0, ActionEvent it) {
        new Thread(() -> IRCVerifyMainMenu.loginButton$lambda$4$lambda$3$lambda$2(this$0)).start();
    }

    private static final void advanceSettingsButton$lambda$6$lambda$5(ActionEvent it) {
        new IRCVerifyAdvanceSettings();
    }

    public static final /* synthetic */ JTextFieldPlaceholder access$getUsernameField$p(IRCVerifyMainMenu $this) {
        return $this.usernameField;
    }

    public static final /* synthetic */ JPasswordFieldPlaceholder access$getPasswordField$p(IRCVerifyMainMenu $this) {
        return $this.passwordField;
    }

    public static final /* synthetic */ JButton access$getLoginButton$p(IRCVerifyMainMenu $this) {
        return $this.loginButton;
    }
}

