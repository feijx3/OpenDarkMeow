/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.irc.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.darkmeow.darkmeow.irc.config.IRCGlobalConfigManager;
import net.darkmeow.darkmeow.irc.config.IRCStaticConfigs;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigProxy;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigRedirectServer;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigRoot;
import net.darkmeow.darkmeow.irc.ui.component.JTextFieldPlaceholder;
import net.darkmeow.irc.client.IRCClient;
import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.interfaces.IRCClientProvider;
import net.darkmeow.irc.client.listener.IRCClientListenableProvide;
import net.darkmeow.irc.client.listener.IRCClientListenableSimple;
import net.darkmeow.irc.client.options.IRCClientOptions;
import net.darkmeow.irc.client.options.IRCClientRemoteVerify;
import net.darkmeow.irc.client.options.IRCClientSignatureKey;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxy;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/darkmeow/darkmeow/irc/ui/IRCVerifyAdvanceSettings;", "Ljavax/swing/JFrame;", "<init>", "()V", "proxyCheckBox", "Ljavax/swing/JCheckBox;", "updateProxyFieldState", "", "state", "", "proxyTypeComboBox", "Ljavax/swing/JComboBox;", "Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigProxy$ProxyType;", "kotlin.jvm.PlatformType", "proxyHostField", "Lnet/darkmeow/darkmeow/irc/ui/component/JTextFieldPlaceholder;", "proxyPortField", "proxyUserField", "proxyPassField", "redirectCheckBox", "updateRedirectServerState", "redirectHostField", "redirectPortField", "testButton", "Ljavax/swing/JButton;", "saveButton", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRCVerifyAdvanceSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRCVerifyAdvanceSettings.kt\nnet/darkmeow/darkmeow/irc/ui/IRCVerifyAdvanceSettings\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n37#2:241\n36#2,3:242\n1#3:245\n*S KotlinDebug\n*F\n+ 1 IRCVerifyAdvanceSettings.kt\nnet/darkmeow/darkmeow/irc/ui/IRCVerifyAdvanceSettings\n*L\n42#1:241\n42#1:242,3\n*E\n"})
public final class IRCVerifyAdvanceSettings
extends JFrame {
    @NotNull
    private final JCheckBox proxyCheckBox;
    @NotNull
    private final JComboBox<IRCGlobalConfigProxy.ProxyType> proxyTypeComboBox;
    @NotNull
    private final JTextFieldPlaceholder proxyHostField;
    @NotNull
    private final JTextFieldPlaceholder proxyPortField;
    @NotNull
    private final JTextFieldPlaceholder proxyUserField;
    @NotNull
    private final JTextFieldPlaceholder proxyPassField;
    @NotNull
    private final JCheckBox redirectCheckBox;
    @NotNull
    private final JTextFieldPlaceholder redirectHostField;
    @NotNull
    private final JTextFieldPlaceholder redirectPortField;
    @NotNull
    private final JButton testButton;
    @NotNull
    private final JButton saveButton;

    /*
     * WARNING - void declaration
     */
    public IRCVerifyAdvanceSettings() {
        super("\u9ad8\u7ea7\u9009\u9879");
        Object object;
        JTextFieldPlaceholder jTextFieldPlaceholder;
        Object object2;
        Object object3;
        void $this$saveButton_u24lambda_u2426;
        JComponent $this$testButton_u24lambda_u2417;
        JComponent $this$redirectPortField_u24lambda_u2411;
        JComponent $this$redirectHostField_u24lambda_u2410;
        JComponent $this$redirectCheckBox_u24lambda_u249;
        JComponent $this$proxyPassField_u24lambda_u247;
        JComponent $this$proxyUserField_u24lambda_u246;
        JComponent $this$proxyPortField_u24lambda_u245;
        JComponent $this$proxyHostField_u24lambda_u244;
        JComponent $this$proxyTypeComboBox_u24lambda_u243;
        void $this$proxyCheckBox_u24lambda_u241;
        Object object4 = new JCheckBox("\u901a\u8fc7\u4ee3\u7406\u8fde\u63a5");
        JCheckBox jCheckBox = object4;
        IRCVerifyAdvanceSettings iRCVerifyAdvanceSettings = this;
        boolean bl2 = false;
        $this$proxyCheckBox_u24lambda_u241.setBounds(10, 10, 200, 25);
        this.add((Component)$this$proxyCheckBox_u24lambda_u241);
        $this$proxyCheckBox_u24lambda_u241.addActionListener(arg_0 -> IRCVerifyAdvanceSettings.proxyCheckBox$lambda$1$lambda$0(this, (JCheckBox)$this$proxyCheckBox_u24lambda_u241, arg_0));
        iRCVerifyAdvanceSettings.proxyCheckBox = object4;
        Collection $this$toTypedArray$iv = IRCGlobalConfigProxy.ProxyType.getEntries();
        boolean $i$f$toTypedArray22 = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        object4 = new JComboBox<IRCGlobalConfigProxy.ProxyType>(thisCollection$iv.toArray(new IRCGlobalConfigProxy.ProxyType[0]));
        JComponent $i$f$toTypedArray22 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl3 = false;
        $this$proxyTypeComboBox_u24lambda_u243.setBounds(280, 12, 90, 20);
        this.add($this$proxyTypeComboBox_u24lambda_u243);
        ((JComboBox)$this$proxyTypeComboBox_u24lambda_u243).addActionListener(arg_0 -> IRCVerifyAdvanceSettings.proxyTypeComboBox$lambda$3$lambda$2(this, arg_0));
        iRCVerifyAdvanceSettings.proxyTypeComboBox = object4;
        object4 = new JTextFieldPlaceholder("\u5730\u5740");
        $this$proxyTypeComboBox_u24lambda_u243 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl4 = false;
        $this$proxyHostField_u24lambda_u244.setBounds(30, 35, 290, 25);
        this.add($this$proxyHostField_u24lambda_u244);
        iRCVerifyAdvanceSettings.proxyHostField = object4;
        object4 = new JTextFieldPlaceholder("\u7aef\u53e3");
        $this$proxyHostField_u24lambda_u244 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl5 = false;
        $this$proxyPortField_u24lambda_u245.setBounds(320, 35, 50, 25);
        this.add($this$proxyPortField_u24lambda_u245);
        iRCVerifyAdvanceSettings.proxyPortField = object4;
        object4 = new JTextFieldPlaceholder("\u7528\u6237\u540d (\u9009\u586b)");
        $this$proxyPortField_u24lambda_u245 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl6 = false;
        $this$proxyUserField_u24lambda_u246.setBounds(30, 65, 180, 25);
        this.add($this$proxyUserField_u24lambda_u246);
        iRCVerifyAdvanceSettings.proxyUserField = object4;
        object4 = new JTextFieldPlaceholder("\u5bc6\u7801 (\u9009\u586b)");
        $this$proxyUserField_u24lambda_u246 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl7 = false;
        $this$proxyPassField_u24lambda_u247.setBounds(210, 65, 160, 25);
        this.add($this$proxyPassField_u24lambda_u247);
        iRCVerifyAdvanceSettings.proxyPassField = object4;
        object4 = new JCheckBox("\u81ea\u5b9a\u4e49\u767b\u5f55\u670d\u52a1\u5668");
        $this$proxyPassField_u24lambda_u247 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl8 = false;
        $this$redirectCheckBox_u24lambda_u249.setBounds(10, 90, 200, 25);
        this.add($this$redirectCheckBox_u24lambda_u249);
        $this$redirectCheckBox_u24lambda_u249.addActionListener(arg_0 -> IRCVerifyAdvanceSettings.redirectCheckBox$lambda$9$lambda$8(this, (JCheckBox)$this$redirectCheckBox_u24lambda_u249, arg_0));
        iRCVerifyAdvanceSettings.redirectCheckBox = object4;
        object4 = new JTextFieldPlaceholder("\u5730\u5740");
        $this$redirectCheckBox_u24lambda_u249 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl9 = false;
        $this$redirectHostField_u24lambda_u2410.setBounds(30, 115, 290, 25);
        this.add($this$redirectHostField_u24lambda_u2410);
        iRCVerifyAdvanceSettings.redirectHostField = object4;
        object4 = new JTextFieldPlaceholder("\u7aef\u53e3");
        $this$redirectHostField_u24lambda_u2410 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl10 = false;
        $this$redirectPortField_u24lambda_u2411.setBounds(320, 115, 50, 25);
        this.add($this$redirectPortField_u24lambda_u2411);
        iRCVerifyAdvanceSettings.redirectPortField = object4;
        object4 = new JButton("\u6d4b\u8bd5\u8fde\u63a5");
        $this$redirectPortField_u24lambda_u2411 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl11 = false;
        $this$testButton_u24lambda_u2417.setBounds(185, 145, 90, 30);
        this.add($this$testButton_u24lambda_u2417);
        $this$testButton_u24lambda_u2417.addActionListener(arg_0 -> IRCVerifyAdvanceSettings.testButton$lambda$17$lambda$16((JButton)$this$testButton_u24lambda_u2417, this, arg_0));
        iRCVerifyAdvanceSettings.testButton = object4;
        object4 = new JButton("\u4fdd\u5b58\u914d\u7f6e");
        $this$testButton_u24lambda_u2417 = object4;
        iRCVerifyAdvanceSettings = this;
        boolean bl12 = false;
        $this$saveButton_u24lambda_u2426.setBounds(280, 145, 90, 30);
        this.add((Component)$this$saveButton_u24lambda_u2426);
        $this$saveButton_u24lambda_u2426.addActionListener(arg_0 -> IRCVerifyAdvanceSettings.saveButton$lambda$26$lambda$25(this, arg_0));
        iRCVerifyAdvanceSettings.saveButton = object4;
        this.setLayout(null);
        this.setSize(new Dimension(400, 220));
        this.setResizable(false);
        this.updateProxyFieldState(false);
        this.updateRedirectServerState(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        Object config = object4 = IRCGlobalConfigManager.INSTANCE.getConfig();
        boolean bl13 = false;
        IRCGlobalConfigProxy iRCGlobalConfigProxy = ((IRCGlobalConfigRoot)config).getProxy();
        if (iRCGlobalConfigProxy != null) {
            void it22;
            object3 = iRCGlobalConfigProxy;
            IRCGlobalConfigProxy proxy = object3;
            boolean bl14 = false;
            this.proxyCheckBox.setSelected(true);
            this.proxyTypeComboBox.setSelectedItem((Object)proxy.getType());
            this.proxyHostField.setText(proxy.getHost());
            object2 = proxy.getPort();
            int n2 = ((Number)object2).intValue();
            jTextFieldPlaceholder = this.proxyPortField;
            boolean bl15 = false;
            object = Boolean.valueOf(it22 != false) != false ? object2 : null;
            jTextFieldPlaceholder.setText((String)(object != null && (object2 = ((Integer)object).toString()) != null ? object2 : ""));
            Object it22 = object2 = proxy;
            jTextFieldPlaceholder = this.proxyUserField;
            boolean bl16 = false;
            object = Boolean.valueOf(((IRCGlobalConfigProxy)it22).getType().getAllowUsername()) != false ? object2 : null;
            jTextFieldPlaceholder.setText((String)(object != null && (object2 = ((IRCGlobalConfigProxy)object).getUsername()) != null ? object2 : ""));
            it22 = object2 = proxy;
            jTextFieldPlaceholder = this.proxyPassField;
            boolean bl17 = false;
            object = Boolean.valueOf(((IRCGlobalConfigProxy)it22).getType().getAllowPassword()) != false ? object2 : null;
            jTextFieldPlaceholder.setText((String)(object != null && (object2 = ((IRCGlobalConfigProxy)object).getPassword()) != null ? object2 : ""));
            this.updateProxyFieldState(true);
        }
        IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer = ((IRCGlobalConfigRoot)config).getRedirectServer();
        if (iRCGlobalConfigRedirectServer != null) {
            Object redirectServer = object3 = iRCGlobalConfigRedirectServer;
            boolean bl18 = false;
            this.redirectCheckBox.setSelected(true);
            this.redirectHostField.setText(((IRCGlobalConfigRedirectServer)redirectServer).getHost());
            object2 = ((IRCGlobalConfigRedirectServer)redirectServer).getPort();
            int it = ((Number)object2).intValue();
            jTextFieldPlaceholder = this.redirectPortField;
            boolean bl19 = false;
            object = Boolean.valueOf(it != 0) != false ? object2 : null;
            jTextFieldPlaceholder.setText((String)(object != null && (object2 = ((Integer)object).toString()) != null ? object2 : ""));
            this.updateRedirectServerState(true);
        }
        this.setVisible(true);
    }

    /*
     * Unable to fully structure code
     */
    public final void updateProxyFieldState(boolean state) {
        this.proxyTypeComboBox.setEnabled(state);
        this.proxyHostField.setEnabled(state);
        this.proxyPortField.setEnabled(state);
        if (!state) ** GOTO lbl-1000
        v0 = this.proxyTypeComboBox.getSelectedItem();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigProxy.ProxyType");
        if (((IRCGlobalConfigProxy.ProxyType)v0).getAllowUsername()) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
        this.proxyUserField.setEnabled(v1);
        if (!state) ** GOTO lbl-1000
        v2 = this.proxyTypeComboBox.getSelectedItem();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigProxy.ProxyType");
        if (((IRCGlobalConfigProxy.ProxyType)v2).getAllowPassword()) {
            v3 = true;
        } else lbl-1000:
        // 2 sources

        {
            v3 = false;
        }
        this.proxyPassField.setEnabled(v3);
    }

    public final void updateRedirectServerState(boolean state) {
        this.redirectHostField.setEnabled(state);
        this.redirectPortField.setEnabled(state);
    }

    private static final void proxyCheckBox$lambda$1$lambda$0(IRCVerifyAdvanceSettings this$0, JCheckBox $this_apply, ActionEvent it) {
        this$0.updateProxyFieldState($this_apply.isSelected());
    }

    private static final void proxyTypeComboBox$lambda$3$lambda$2(IRCVerifyAdvanceSettings this$0, ActionEvent it) {
        this$0.updateProxyFieldState(this$0.proxyCheckBox.isSelected());
    }

    private static final void redirectCheckBox$lambda$9$lambda$8(IRCVerifyAdvanceSettings this$0, JCheckBox $this_apply, ActionEvent it) {
        this$0.updateRedirectServerState($this_apply.isSelected());
    }

    /*
     * WARNING - void declaration
     */
    private static final void testButton$lambda$17$lambda$16(JButton $this_apply, IRCVerifyAdvanceSettings this$0, ActionEvent it) {
        block6: {
            Object object;
            Object object2 = $this_apply;
            try {
                IRCOptionsProxy iRCOptionsProxy;
                Object object3;
                Object object4;
                int n2;
                JButton $this$testButton_u24lambda_u2417_u24lambda_u2416_u24lambda_u2414 = object2;
                boolean bl2 = false;
                IRCClientListenableProvide iRCClientListenableProvide = new IRCClientListenableSimple(this$0){
                    private boolean allowFailDialog;
                    final /* synthetic */ IRCVerifyAdvanceSettings this$0;
                    {
                        this.this$0 = $receiver;
                        this.allowFailDialog = true;
                    }

                    public final boolean getAllowFailDialog() {
                        return this.allowFailDialog;
                    }

                    public final void setAllowFailDialog(boolean bl2) {
                        this.allowFailDialog = bl2;
                    }

                    public void onDisconnect(EnumDisconnectType type, String reason, boolean logout) {
                        Intrinsics.checkNotNullParameter((Object)((Object)type), "type");
                        if (this.allowFailDialog) {
                            this.allowFailDialog = false;
                            JOptionPane.showMessageDialog(this.this$0, "\u8fde\u63a5\u5931\u8d25: " + reason);
                        }
                    }

                    public void onReadyLogin(IRCClientProvider client) {
                        Intrinsics.checkNotNullParameter(client, "client");
                        this.allowFailDialog = false;
                        client.disconnect(false);
                        JOptionPane.showMessageDialog(this.this$0, "\u8fde\u63a5\u6210\u529f");
                    }
                };
                IRCClientOptions.IRCClientOptionsBuilder iRCClientOptionsBuilder = IRCClientOptions.builder().host(this$0.redirectCheckBox.isSelected() ? this$0.redirectHostField.getText() : "irc.nekocurit.asia");
                if (this$0.redirectCheckBox.isSelected()) {
                    String string = this$0.redirectPortField.getText();
                    Intrinsics.checkNotNullExpressionValue(string, "getText(...)");
                    n2 = Integer.parseInt(string);
                } else {
                    n2 = 45020;
                }
                Object object5 = object4 = this$0.proxyTypeComboBox.getSelectedItem();
                IRCClientOptions.IRCClientOptionsBuilder iRCClientOptionsBuilder2 = iRCClientOptionsBuilder.port(n2);
                IRCClientListenableProvide iRCClientListenableProvide2 = iRCClientListenableProvide;
                boolean bl32 = false;
                boolean bl4 = this$0.proxyCheckBox.isSelected();
                IRCClientListenableProvide iRCClientListenableProvide3 = iRCClientListenableProvide2;
                IRCClientOptions.IRCClientOptionsBuilder iRCClientOptionsBuilder3 = iRCClientOptionsBuilder2;
                Object object6 = object3 = bl4 ? object4 : null;
                if (object3 != null) {
                    void it2;
                    Object bl32 = object3;
                    iRCClientOptionsBuilder2 = iRCClientOptionsBuilder3;
                    iRCClientListenableProvide2 = iRCClientListenableProvide3;
                    boolean bl5 = false;
                    IRCGlobalConfigProxy.ProxyType proxyType = (IRCGlobalConfigProxy.ProxyType)it2;
                    iRCClientListenableProvide3 = iRCClientListenableProvide2;
                    iRCClientOptionsBuilder3 = iRCClientOptionsBuilder2;
                    Function4<String, Integer, String, String, IRCOptionsProxy> function4 = proxyType.getExec();
                    String string = this$0.proxyHostField.getText();
                    Intrinsics.checkNotNullExpressionValue(string, "getText(...)");
                    String string2 = this$0.proxyPortField.getText();
                    Intrinsics.checkNotNullExpressionValue(string2, "getText(...)");
                    iRCOptionsProxy = function4.invoke(string, Integer.parseInt(string2), this$0.proxyUserField.getText(), this$0.proxyPassField.getText());
                } else {
                    iRCOptionsProxy = null;
                }
                IRCClient.newInstance(iRCClientListenableProvide3, iRCClientOptionsBuilder3.proxy(iRCOptionsProxy).brand(IRCStaticConfigs.INSTANCE.getCLIENT_BRAND()).clientKey(new IRCClientSignatureKey(IRCStaticConfigs.INSTANCE.getKEY_SIGNATURE_CLIENT())).remoteVerify(new IRCClientRemoteVerify(IRCStaticConfigs.INSTANCE.getKEY_REMOTE_VERIFY())).build()).connect();
                object = Result.constructor-impl(Unit.INSTANCE);
            }
            catch (Throwable bl2) {
                object = Result.constructor-impl(ResultKt.createFailure(bl2));
            }
            object2 = object;
            Throwable throwable = Result.exceptionOrNull-impl(object2);
            if (throwable == null) break block6;
            Object e2 = object = throwable;
            boolean bl6 = false;
            JOptionPane.showMessageDialog(this$0, "\u8fde\u63a5\u5931\u8d25: " + e2);
        }
    }

    private static final void saveButton$lambda$26$lambda$25(IRCVerifyAdvanceSettings this$0, ActionEvent it) {
        IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer;
        IRCGlobalConfigProxy iRCGlobalConfigProxy;
        JCheckBox it2;
        JCheckBox jCheckBox;
        JCheckBox jCheckBox2;
        IRCGlobalConfigManager iRCGlobalConfigManager;
        IRCGlobalConfigManager $this$saveButton_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424 = iRCGlobalConfigManager = IRCGlobalConfigManager.INSTANCE;
        boolean bl2 = false;
        JCheckBox jCheckBox3 = jCheckBox2 = this$0.proxyCheckBox;
        IRCGlobalConfigRoot iRCGlobalConfigRoot = $this$saveButton_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424.getConfig();
        boolean bl3 = false;
        IRCGlobalConfigRoot iRCGlobalConfigRoot2 = iRCGlobalConfigRoot;
        JCheckBox jCheckBox4 = jCheckBox = Boolean.valueOf(it2.isSelected()) != false ? jCheckBox2 : null;
        if (jCheckBox != null) {
            JTextFieldPlaceholder jTextFieldPlaceholder;
            it2 = jCheckBox;
            iRCGlobalConfigRoot = iRCGlobalConfigRoot2;
            boolean bl4 = false;
            Object object = this$0.proxyTypeComboBox.getSelectedItem();
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigProxy.ProxyType");
            IRCGlobalConfigProxy.ProxyType type = (IRCGlobalConfigProxy.ProxyType)((Object)object);
            String string = this$0.proxyHostField.getText();
            Intrinsics.checkNotNullExpressionValue(string, "getText(...)");
            String string2 = this$0.proxyPortField.getText();
            Intrinsics.checkNotNullExpressionValue(string2, "getText(...)");
            Integer n2 = StringsKt.toIntOrNull(string2);
            JTextFieldPlaceholder jTextFieldPlaceholder2 = jTextFieldPlaceholder = this$0.proxyUserField;
            int n3 = n2 != null ? n2 : 0;
            String string3 = string;
            IRCGlobalConfigProxy.ProxyType proxyType = type;
            boolean bl5 = false;
            boolean bl6 = type.getAllowUsername();
            JTextFieldPlaceholder jTextFieldPlaceholder3 = bl6 ? jTextFieldPlaceholder : null;
            String string4 = jTextFieldPlaceholder3 != null ? jTextFieldPlaceholder3.getText() : null;
            JTextFieldPlaceholder it3 = jTextFieldPlaceholder = this$0.proxyPassField;
            String string5 = string4;
            boolean bl7 = false;
            boolean bl8 = type.getAllowPassword();
            jTextFieldPlaceholder3 = bl8 ? jTextFieldPlaceholder : null;
            String string6 = jTextFieldPlaceholder3 != null ? jTextFieldPlaceholder3.getText() : null;
            String string7 = string5;
            int n4 = n3;
            String string8 = string3;
            IRCGlobalConfigProxy.ProxyType proxyType2 = proxyType;
            iRCGlobalConfigProxy = new IRCGlobalConfigProxy(proxyType2, string8, n4, string7, string6);
            iRCGlobalConfigRoot2 = iRCGlobalConfigRoot;
        } else {
            iRCGlobalConfigProxy = null;
        }
        iRCGlobalConfigRoot2.setProxy(iRCGlobalConfigProxy);
        it2 = jCheckBox2 = this$0.redirectCheckBox;
        iRCGlobalConfigRoot = $this$saveButton_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424.getConfig();
        boolean bl9 = false;
        IRCGlobalConfigRoot iRCGlobalConfigRoot3 = iRCGlobalConfigRoot;
        JCheckBox jCheckBox5 = jCheckBox = Boolean.valueOf(it2.isSelected()) != false ? jCheckBox2 : null;
        if (jCheckBox != null) {
            it2 = jCheckBox;
            iRCGlobalConfigRoot = iRCGlobalConfigRoot3;
            boolean bl10 = false;
            String string = this$0.redirectHostField.getText();
            Intrinsics.checkNotNullExpressionValue(string, "getText(...)");
            String string9 = this$0.redirectPortField.getText();
            Intrinsics.checkNotNullExpressionValue(string9, "getText(...)");
            Integer n5 = StringsKt.toIntOrNull(string9);
            iRCGlobalConfigRedirectServer = new IRCGlobalConfigRedirectServer(string, n5 != null ? n5 : 0);
            iRCGlobalConfigRoot3 = iRCGlobalConfigRoot;
        } else {
            iRCGlobalConfigRedirectServer = null;
        }
        iRCGlobalConfigRoot3.setRedirectServer(iRCGlobalConfigRedirectServer);
        IRCGlobalConfigManager.INSTANCE.save();
    }
}

