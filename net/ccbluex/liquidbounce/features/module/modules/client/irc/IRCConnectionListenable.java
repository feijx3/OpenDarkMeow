/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc;

import java.io.File;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.IRC;
import net.darkmeow.darkmeow.irc.config.IRCGlobalConfigManager;
import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.interfaces.IRCClientProvider;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataSelfSessionInfo;
import net.darkmeow.irc.client.listener.IRCClientListenableProvide;
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.network.FriendBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J$\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u000e2\u0006\u0010+\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCConnectionListenable;", "Lnet/darkmeow/irc/client/listener/IRCClientListenableProvide;", "irc", "Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;", "mc", "Lnet/minecraft/client/Minecraft;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;Lnet/minecraft/client/Minecraft;)V", "onReadyLogin", "", "client", "Lnet/darkmeow/irc/client/interfaces/IRCClientProvider;", "onUpdateSession", "token", "", "onUpdateUserInfo", "info", "Lnet/darkmeow/irc/client/interfaces/data/IRCDataSelfSessionInfo;", "isFirstLogin", "", "onUpdateSessionSkin", "Lnet/darkmeow/irc/client/interfaces/data/IRCDataOtherSessionInfo;", "onMessagePublic", "session", "message", "onMessagePrivate", "onUpdateOtherInputs", "public", "", "Ljava/util/UUID;", "private", "onPrivateMessageSendSuccess", "receiver", "onPrivateMessageSendFailed", "onMessageSystem", "onCustomPayload", "channel", "data", "Lnet/darkmeow/irc/network/FriendBuffer;", "onDisconnect", "type", "Lnet/darkmeow/irc/client/enums/EnumDisconnectType;", "reason", "logout", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRCConnectionListenable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRCConnectionListenable.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCConnectionListenable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n1#2:202\n*E\n"})
public final class IRCConnectionListenable
implements IRCClientListenableProvide {
    @NotNull
    private final IRC irc;
    @NotNull
    private final Minecraft mc;

    public IRCConnectionListenable(@NotNull IRC irc2, @NotNull Minecraft mc) {
        Intrinsics.checkNotNullParameter(irc2, "irc");
        Intrinsics.checkNotNullParameter(mc, "mc");
        this.irc = irc2;
        this.mc = mc;
    }

    @Override
    public void onReadyLogin(@NotNull IRCClientProvider client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.login(IRCGlobalConfigManager.INSTANCE.getConfig().getUser(), IRCGlobalConfigManager.INSTANCE.getConfig().getPassword(), (Boolean)this.irc.loginInvisibleValue.get());
    }

    @Override
    public void onUpdateSession(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        IRCGlobalConfigManager.INSTANCE.read();
        IRCGlobalConfigManager.INSTANCE.getConfig().setPassword(token);
        IRCGlobalConfigManager.INSTANCE.save();
    }

    @Override
    public void onUpdateUserInfo(@NotNull IRCDataSelfSessionInfo info, boolean isFirstLogin) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.irc.getState()) {
            if (isFirstLogin) {
                DarkMeow.INSTANCE.getMessageManager().display.displaySuccess("IRC\u767b\u5f55\u6210\u529f");
                this.irc.irc.queryOnlineSessions();
                if (((Boolean)this.irc.shareMySkinValue.get()).booleanValue()) {
                    Object object;
                    Object $this$onUpdateUserInfo_u24lambda_u242;
                    Object object2;
                    Object $this$onUpdateUserInfo_u24lambda_u240;
                    Object object3 = this;
                    IRCClientProvider iRCClientProvider = this.irc.irc;
                    try {
                        $this$onUpdateUserInfo_u24lambda_u240 = object3;
                        boolean bl2 = false;
                        $this$onUpdateUserInfo_u24lambda_u240 = Result.constructor-impl(FilesKt.readBytes(new File(((IRCConnectionListenable)$this$onUpdateUserInfo_u24lambda_u240).irc.fileDir, "skin.png")));
                    }
                    catch (Throwable bl2) {
                        $this$onUpdateUserInfo_u24lambda_u240 = Result.constructor-impl(ResultKt.createFailure(bl2));
                    }
                    IRCClientProvider iRCClientProvider2 = iRCClientProvider;
                    object3 = $this$onUpdateUserInfo_u24lambda_u240;
                    Throwable throwable = Result.exceptionOrNull-impl(object3);
                    if (throwable == null) {
                        object2 = object3;
                    } else {
                        $this$onUpdateUserInfo_u24lambda_u240 = throwable;
                        iRCClientProvider = iRCClientProvider2;
                        boolean bl3 = false;
                        object2 = new byte[0];
                        iRCClientProvider2 = iRCClientProvider;
                    }
                    object3 = this;
                    byte[] byArray = (byte[])object2;
                    iRCClientProvider = iRCClientProvider2;
                    try {
                        $this$onUpdateUserInfo_u24lambda_u242 = (IRCConnectionListenable)object3;
                        boolean bl4 = false;
                        $this$onUpdateUserInfo_u24lambda_u242 = Result.constructor-impl(FilesKt.readBytes(new File(((IRCConnectionListenable)$this$onUpdateUserInfo_u24lambda_u242).irc.fileDir, "cape.png")));
                    }
                    catch (Throwable bl4) {
                        $this$onUpdateUserInfo_u24lambda_u242 = Result.constructor-impl(ResultKt.createFailure(bl4));
                    }
                    Object object4 = $this$onUpdateUserInfo_u24lambda_u242;
                    IRCClientProvider iRCClientProvider3 = iRCClientProvider;
                    byte[] byArray2 = byArray;
                    object3 = object4;
                    Throwable throwable2 = Result.exceptionOrNull-impl(object3);
                    if (throwable2 == null) {
                        object = object3;
                    } else {
                        $this$onUpdateUserInfo_u24lambda_u242 = throwable2;
                        byArray = byArray2;
                        iRCClientProvider = iRCClientProvider3;
                        boolean bl5 = false;
                        object4 = new byte[0];
                        iRCClientProvider3 = iRCClientProvider;
                        byArray2 = byArray;
                        object = object4;
                    }
                    boolean bl6 = (Boolean)this.irc.shareMySkinUserSlimValue.get();
                    byte[] byArray3 = (byte[])object;
                    byte[] byArray4 = byArray2;
                    iRCClientProvider3.uploadSkin(new DataSkin(byArray4, byArray3, bl6));
                }
                this.mc.func_152344_a(() -> IRCConnectionListenable.onUpdateUserInfo$lambda$4(this));
            }
        } else {
            this.irc.irc.disconnect(false);
        }
    }

    @Override
    public void onUpdateSessionSkin(@NotNull IRCDataOtherSessionInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.irc.getPluginSkin().onUpdateOtherSkin(info);
    }

    @Override
    public void onMessagePublic(@NotNull IRCDataOtherSessionInfo session, @NotNull String message) {
        TextComponentString textComponentString;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(message, "message");
        TextComponentString $this$onMessagePublic_u24lambda_u245 = textComponentString = new TextComponentString("\u00a77[\u00a7eIRC\u00a77]" + session.getInfo().getName() + " \u00a77 >> \u00a7f" + message);
        boolean bl2 = false;
        Object[] objectArray = new String[]{"\u00a7f\u7528\u6237\u540d: " + session.getInfo().getName(), "\u00a7f\u6e38\u620f\u5185ID: " + session.getInfo().getState().getProfile().getName(), "", "\u00a7f\u70b9\u51fb\u4ee5\u53d1\u8d77\u79c1\u804a"};
        $this$onMessagePublic_u24lambda_u245.func_150255_a($this$onMessagePublic_u24lambda_u245.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString(ArraysKt.joinToString$default(objectArray, (CharSequence)"\n", null, null, 0, null, null, 62, null)))));
        $this$onMessagePublic_u24lambda_u245.func_150255_a($this$onMessagePublic_u24lambda_u245.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/irc:private " + session.getInfo().getName() + ' ')));
        TextComponentString c2 = textComponentString;
        boolean bl3 = false;
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage((ITextComponent)c2);
    }

    @Override
    public void onMessagePrivate(@NotNull IRCDataOtherSessionInfo session, @NotNull String message) {
        TextComponentString textComponentString;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(message, "message");
        TextComponentString $this$onMessagePrivate_u24lambda_u247 = textComponentString = new TextComponentString("\u00a77[\u00a7eIRC\u00a77][\u00a7f" + session.getInfo().getName() + " \u00a7b-> \u00a7f\u6211\u00a77] \u00a7f" + message);
        boolean bl2 = false;
        Object[] objectArray = new String[]{"\u00a7f\u7528\u6237\u540d: " + session.getInfo().getName(), "\u00a7f\u6e38\u620f\u5185ID: " + session.getInfo().getState().getProfile().getName(), "", "\u00a7f\u70b9\u51fb\u4ee5\u56de\u590d"};
        $this$onMessagePrivate_u24lambda_u247.func_150255_a($this$onMessagePrivate_u24lambda_u247.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString(ArraysKt.joinToString$default(objectArray, (CharSequence)"\n", null, null, 0, null, null, 62, null)))));
        $this$onMessagePrivate_u24lambda_u247.func_150255_a($this$onMessagePrivate_u24lambda_u247.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/irc:private " + session.getInfo().getName() + ' ')));
        TextComponentString c2 = textComponentString;
        boolean bl3 = false;
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage((ITextComponent)c2);
    }

    @Override
    public void onUpdateOtherInputs(@NotNull Set<UUID> set, @NotNull Set<UUID> set2) {
        Intrinsics.checkNotNullParameter(set, "public");
        Intrinsics.checkNotNullParameter(set2, "private");
        this.irc.setOtherTypingUsersPublic(set);
        this.irc.setOtherTypingUsersPrivate(set2);
    }

    @Override
    public void onPrivateMessageSendSuccess(@NotNull String receiver, @NotNull String message) {
        TextComponentString textComponentString;
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(message, "message");
        TextComponentString $this$onPrivateMessageSendSuccess_u24lambda_u249 = textComponentString = new TextComponentString("\u00a77[\u00a7eIRC\u00a77][\u00a7f\u6211 \u00a7b-> \u00a7f" + receiver + "\u00a77] \u00a7f" + message);
        boolean bl2 = false;
        Object[] objectArray = new String[]{"\u00a7f\u70b9\u51fb\u4ee5\u7ee7\u7eed\u53d1\u751f\u79c1\u804a"};
        $this$onPrivateMessageSendSuccess_u24lambda_u249.func_150255_a($this$onPrivateMessageSendSuccess_u24lambda_u249.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString(ArraysKt.joinToString$default(objectArray, (CharSequence)"\n", null, null, 0, null, null, 62, null)))));
        $this$onPrivateMessageSendSuccess_u24lambda_u249.func_150255_a($this$onPrivateMessageSendSuccess_u24lambda_u249.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/irc:private " + receiver + ' ')));
        TextComponentString c2 = textComponentString;
        boolean bl3 = false;
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage((ITextComponent)c2);
    }

    @Override
    public void onPrivateMessageSendFailed(@NotNull String receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage("\u00a7e\u79c1\u804a\u7528\u6237(" + receiver + ")\u4e0d\u5728\u7ebf\u6216\u4e0d\u5b58\u5728");
    }

    @Override
    public void onMessageSystem(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage(message);
    }

    @Override
    public void onCustomPayload(@NotNull String channel, @NotNull FriendBuffer data) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override
    public void onDisconnect(@NotNull EnumDisconnectType type, @Nullable String reason, boolean logout) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        if (this.irc.getState()) {
            if (logout) {
                IRCGlobalConfigManager.INSTANCE.read();
                IRCGlobalConfigManager.INSTANCE.getConfig().setPassword("");
                IRCGlobalConfigManager.INSTANCE.save();
            }
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1: {
                    DarkMeow.INSTANCE.getMessageManager().display.displayError("IRC\u670d\u52a1\u5668\u610f\u5916\u65ad\u5f00\u8fde\u63a5,\u5c06\u5728 5s \u540e\u91cd\u65b0\u8fde\u63a5...");
                    new Thread(() -> IRCConnectionListenable.onDisconnect$lambda$13(this)).start();
                    break;
                }
                case 2: {
                    DarkMeow.INSTANCE.getMessageManager().display.displayError("\u767b\u5f55\u5931\u8d25: " + reason);
                    this.irc.setState(false);
                    break;
                }
                case 3: {
                    DarkMeow.INSTANCE.getMessageManager().display.displayError("IRC\u670d\u52a1\u5668\u8fde\u63a5\u5df2\u65ad\u5f00: " + reason);
                    this.irc.setState(false);
                }
            }
        }
    }

    private static final void onUpdateUserInfo$lambda$4(IRCConnectionListenable this$0) {
        if (this$0.mc.field_71441_e != null) {
            this$0.irc.postGameInfo();
        }
    }

    private static final void onDisconnect$lambda$13$lambda$12(IRCConnectionListenable this$0) {
        this$0.irc.setState(false);
        this$0.irc.setState(true);
    }

    private static final void onDisconnect$lambda$13(IRCConnectionListenable this$0) {
        int n2 = 5;
        int n3 = 0;
        while (n3 < n2) {
            int it = n3++;
            boolean bl2 = false;
            if (!this$0.irc.getState() || this$0.irc.irc.isConnected()) {
                return;
            }
            Thread.sleep(1000L);
        }
        this$0.mc.func_152344_a(() -> IRCConnectionListenable.onDisconnect$lambda$13$lambda$12(this$0));
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumDisconnectType.values().length];
            try {
                nArray[EnumDisconnectType.OTHER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumDisconnectType.FAILED_TO_LOGIN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumDisconnectType.KICK_BY_SERVER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

