/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.scoreboard.Team
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.client.UpdateSelectTargetStatusEvent;
import net.ccbluex.liquidbounce.event.events.player.CompleteMessageEvent;
import net.ccbluex.liquidbounce.event.events.player.SendMessageEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityNameEvent;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DPlayerTabOverlayEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCCommandManager;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCConnectionListenable;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.plugins.IRCPluginSkin;
import net.ccbluex.liquidbounce.injection.extend.gui.ExtendGuiChat;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.irc.config.IRCGlobalConfigManager;
import net.darkmeow.irc.client.interfaces.IRCClientProvider;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataSelfSessionInfo;
import net.darkmeow.irc.data.DataPlayInGameProfile;
import net.darkmeow.irc.data.DataUserState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u000208H\u0007J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020:H\u0007J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020<H\u0007J\b\u0010=\u001a\u00020\u001dH\u0016J\b\u0010>\u001a\u00020\u001dH\u0016J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020@H\u0007J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020BH\u0007J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020DH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0011\u001a\u00070\u0012\u00a2\u0006\u0002\b\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010E\u001a\u0004\u0018\u00010,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010.\u00a8\u0006G"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/IRC;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "commandManager", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommandManager;", "getCommandManager", "()Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommandManager;", "loginInvisibleValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "shareMySkinValue", "shareMySkinUserSlimValue", "ircFriendValue", "quickSendPrefixValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "fileDir", "Ljava/io/File;", "irc", "Lnet/darkmeow/irc/client/interfaces/IRCClientProvider;", "Lorg/jetbrains/annotations/NotNull;", "pluginSkin", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/plugins/IRCPluginSkin;", "getPluginSkin", "()Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/plugins/IRCPluginSkin;", "infoDelay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getInfoDelay", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "postGameInfo", "", "onWorld", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "otherTypingUsersPublic", "", "Ljava/util/UUID;", "getOtherTypingUsersPublic", "()Ljava/util/Set;", "setOtherTypingUsersPublic", "(Ljava/util/Set;)V", "otherTypingUsersPrivate", "getOtherTypingUsersPrivate", "setOtherTypingUsersPrivate", "lastChatText", "", "getLastChatText", "()Ljava/lang/String;", "setLastChatText", "(Ljava/lang/String;)V", "lastChatUpdate", "", "getLastChatUpdate", "()Z", "setLastChatUpdate", "(Z)V", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onSendMessage", "Lnet/ccbluex/liquidbounce/event/events/player/SendMessageEvent;", "onCompleteMessage", "Lnet/ccbluex/liquidbounce/event/events/player/CompleteMessageEvent;", "onEnable", "onDisable", "onRender2DPlayerTabOverlayPre", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DPlayerTabOverlayEvent$PRE;", "onUpdateAllowTargets", "Lnet/ccbluex/liquidbounce/event/events/client/UpdateSelectTargetStatusEvent;", "onRenderEntityName", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityNameEvent;", "tag", "getTag", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRC.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/IRC\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,248:1\n1#2:249\n1#2:255\n37#3:250\n36#3,3:251\n2756#4:254\n295#4,2:256\n1761#4,3:258\n295#4,2:261\n*S KotlinDebug\n*F\n+ 1 IRC.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/IRC\n*L\n211#1:255\n171#1:250\n171#1:251,3\n211#1:254\n213#1:256,2\n228#1:258,3\n239#1:261,2\n*E\n"})
public final class IRC
extends Module {
    @NotNull
    private final IRCCommandManager commandManager = new IRCCommandManager(this);
    @JvmField
    @NotNull
    public final BoolValue loginInvisibleValue = new BoolValue("LoginInvisible", false);
    @JvmField
    @NotNull
    public final BoolValue shareMySkinValue = new BoolValue("ShareMySkin", true);
    @JvmField
    @NotNull
    public final BoolValue shareMySkinUserSlimValue;
    @JvmField
    @NotNull
    public final BoolValue ircFriendValue;
    @JvmField
    @NotNull
    public final ListValue quickSendPrefixValue;
    @JvmField
    @NotNull
    public final File fileDir;
    @JvmField
    @NotNull
    public final IRCClientProvider irc;
    @NotNull
    private final IRCPluginSkin pluginSkin;
    @NotNull
    private final MSDelay infoDelay;
    @NotNull
    private Set<UUID> otherTypingUsersPublic;
    @NotNull
    private Set<UUID> otherTypingUsersPrivate;
    @NotNull
    private String lastChatText;
    private boolean lastChatUpdate;

    /*
     * WARNING - void declaration
     */
    public IRC() {
        super("IRC", ModuleCategory.CLIENT, null, null, 12, null);
        void $this$shareMySkinUserSlimValue_u24lambda_u240;
        String[] stringArray;
        String[] stringArray2 = stringArray = new BoolValue("ShareMySkinUseSlim", true);
        IRC iRC = this;
        boolean bl2 = false;
        $this$shareMySkinUserSlimValue_u24lambda_u240.setSuperValue(this.shareMySkinValue);
        iRC.shareMySkinUserSlimValue = stringArray;
        this.ircFriendValue = new BoolValue("IRCFriend", true);
        stringArray = new String[]{"#", "$", "%", "^", "None"};
        this.quickSendPrefixValue = new ListValue("QuickSendPrefix", stringArray, "#");
        this.fileDir = new File(DarkMeow.INSTANCE.getFileManager().getDir(), "irc");
        this.irc = IRCGlobalConfigManager.INSTANCE.newClientInstance(new IRCConnectionListenable(this, MinecraftInstance.mc.getWrapped()));
        this.pluginSkin = new IRCPluginSkin();
        this.pluginSkin.setInstance(this);
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), this.pluginSkin, false, false, 6, null);
        this.infoDelay = new MSDelay();
        this.otherTypingUsersPublic = new LinkedHashSet();
        this.otherTypingUsersPrivate = new LinkedHashSet();
        this.lastChatText = "";
    }

    @NotNull
    public final IRCCommandManager getCommandManager() {
        return this.commandManager;
    }

    @NotNull
    public final IRCPluginSkin getPluginSkin() {
        return this.pluginSkin;
    }

    @NotNull
    public final MSDelay getInfoDelay() {
        return this.infoDelay;
    }

    public final void postGameInfo() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        this.infoDelay.reset(15000);
        DataPlayInGameProfile dataPlayInGameProfile = new DataPlayInGameProfile(player.func_70005_c_(), player.func_110124_au());
        Object object = DarkMeow.INSTANCE.getNetworkManager().latestServer;
        if (object == null || (object = object.field_78845_b) == null) {
            object = "Disconnected";
        }
        String string = MinecraftInstance.mc.getWrapped().field_71426_K;
        Intrinsics.checkNotNullExpressionValue(string, "debug");
        String[] stringArray = new String[]{" "};
        Object object2 = (String)CollectionsKt.getOrNull(StringsKt.split$default((CharSequence)string, stringArray, false, 0, 6, null), 0);
        this.irc.uploadState(new DataUserState(dataPlayInGameProfile, (String)object, object2 != null && (object2 = StringsKt.toIntOrNull((String)object2)) != null ? (Integer)object2 : 0, (Boolean)this.ircFriendValue.get()));
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        new Thread(() -> IRC.onWorld$lambda$1(this)).start();
    }

    @NotNull
    public final Set<UUID> getOtherTypingUsersPublic() {
        return this.otherTypingUsersPublic;
    }

    public final void setOtherTypingUsersPublic(@NotNull Set<UUID> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.otherTypingUsersPublic = set;
    }

    @NotNull
    public final Set<UUID> getOtherTypingUsersPrivate() {
        return this.otherTypingUsersPrivate;
    }

    public final void setOtherTypingUsersPrivate(@NotNull Set<UUID> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.otherTypingUsersPrivate = set;
    }

    @NotNull
    public final String getLastChatText() {
        return this.lastChatText;
    }

    public final void setLastChatText(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.lastChatText = string;
    }

    public final boolean getLastChatUpdate() {
        return this.lastChatUpdate;
    }

    public final void setLastChatUpdate(boolean bl2) {
        this.lastChatUpdate = bl2;
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        block9: {
            String[] stringArray;
            String[] stringArray2;
            Intrinsics.checkNotNullParameter(event, "event");
            GuiScreen gui = MinecraftInstance.mc.getCurrentScreen();
            if (gui instanceof GuiChat) {
                if (!Intrinsics.areEqual(ExtendGuiChat.INSTANCE.getInputField((GuiChat)gui).func_146179_b(), this.lastChatText)) {
                    String string = ExtendGuiChat.INSTANCE.getInputField((GuiChat)gui).func_146179_b();
                    Intrinsics.checkNotNullExpressionValue(string, "getText(...)");
                    this.lastChatText = string;
                    this.lastChatUpdate = true;
                }
            } else if (!Intrinsics.areEqual(this.lastChatText, "")) {
                this.lastChatText = "";
                this.lastChatUpdate = true;
            }
            if (this.lastChatUpdate) {
                this.lastChatUpdate = false;
                if (StringsKt.startsWith$default(this.lastChatText, (String)this.quickSendPrefixValue.get(), false, 2, null)) {
                    this.irc.updateInputStatus(StringsKt.removePrefix(this.lastChatText, (CharSequence)this.quickSendPrefixValue.get()));
                } else if (StringsKt.startsWith$default(this.lastChatText, "/irc:private ", false, 2, null)) {
                    stringArray2 = new String[]{" "};
                    List args = StringsKt.split$default((CharSequence)StringsKt.removePrefix(this.lastChatText, (CharSequence)"/irc:private "), stringArray2, false, 0, 6, null);
                    this.irc.updateInputStatus((String)args.get(0), CollectionsKt.joinToString$default(CollectionsKt.drop(args, 1), " ", null, null, 0, null, null, 62, null));
                } else {
                    this.irc.updateInputStatus();
                }
            }
            String[] it = stringArray2 = this.infoDelay;
            boolean bl2 = false;
            Object object = stringArray = MSDelay.hasPassed$default((MSDelay)it, 0L, 1, null) ? stringArray2 : null;
            if (stringArray == null) break block9;
            it = stringArray2 = stringArray;
            boolean bl3 = false;
            this.postGameInfo();
        }
    }

    @EventTarget(ignoreCondition=true)
    public final void onSendMessage(@NotNull SendMessageEvent event) {
        block5: {
            Object object;
            Object object2;
            List list;
            String string;
            String string2;
            Intrinsics.checkNotNullParameter(event, "event");
            String string3 = (String)event.getReturnValue();
            if (string3 == null) {
                return;
            }
            String message = string3;
            if (StringsKt.startsWith$default(message, (String)this.quickSendPrefixValue.get(), false, 2, null) && !Intrinsics.areEqual(this.quickSendPrefixValue.get(), "None")) {
                if (this.getState()) {
                    this.irc.sendMessageToPublic(StringsKt.replaceFirst$default(message, (String)this.quickSendPrefixValue.get(), "", false, 4, null));
                } else {
                    DarkMeow.INSTANCE.getMessageManager().display.displayWarn("\u8bf7\u5148\u5f00\u542f IRC \u529f\u80fd");
                }
                event.cancelEvent();
                return;
            }
            String it = string2 = message;
            boolean bl2 = false;
            String string4 = string = StringsKt.startsWith$default(it, "/irc:", false, 2, null) ? string2 : null;
            if (string == null || (string2 = StringsKt.replaceFirst$default(string, "/irc:", "", false, 4, null)) == null || (list = StringsKt.split$default((CharSequence)string2, object2 = new String[]{" "}, false, 0, 6, null)) == null) break block5;
            Object it2 = object = list;
            boolean bl3 = false;
            Object object3 = object2 = !((Collection)it2).isEmpty() ? object : null;
            if (object2 != null) {
                it2 = object = object2;
                boolean bl4 = false;
                this.commandManager.execute((String)CollectionsKt.first(it2), CollectionsKt.drop((Iterable)it2, 1));
                event.cancelEvent();
            }
        }
    }

    @EventTarget(ignoreCondition=true)
    public final void onCompleteMessage(@NotNull CompleteMessageEvent event) {
        block1: {
            Object object;
            Object object2;
            List list;
            String string;
            String string2;
            Intrinsics.checkNotNullParameter(event, "event");
            String it = string2 = event.getMessage();
            boolean bl2 = false;
            String string3 = string = StringsKt.startsWith$default(it, "/irc:", false, 2, null) ? string2 : null;
            if (string == null || (string2 = StringsKt.replaceFirst$default(string, "/irc:", "", false, 4, null)) == null || (list = StringsKt.split$default((CharSequence)string2, object2 = new String[]{" "}, false, 0, 6, null)) == null) break block1;
            Object it2 = object = list;
            boolean bl3 = false;
            Object object3 = object2 = !((Collection)it2).isEmpty() ? object : null;
            if (object2 != null) {
                it2 = object = object2;
                boolean bl4 = false;
                Collection $this$toTypedArray$iv = this.commandManager.complete((String)CollectionsKt.first(it2), CollectionsKt.drop((Iterable)it2, 1));
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                event.setReturnValue(thisCollection$iv.toArray(new String[0]));
            }
        }
    }

    @Override
    public void onEnable() {
        IRCGlobalConfigManager.INSTANCE.read();
        if (((CharSequence)IRCGlobalConfigManager.INSTANCE.getConfig().getPassword()).length() == 0) {
            DarkMeow.INSTANCE.getMessageManager().displayChatMessage("\u521d\u6b21\u4f7f\u7528 IRC \u8bf7\u901a\u8fc7\u6307\u4ee4 '/irc:login <\u7528\u6237\u540d> <\u5bc6\u7801>' \u767b\u5f55");
            this.setState(false);
        } else {
            new Thread(() -> IRC.onEnable$lambda$12(this)).start();
        }
    }

    @Override
    public void onDisable() {
        this.pluginSkin.onDisable();
        this.irc.disconnect(false);
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onRender2DPlayerTabOverlayPre(@NotNull Render2DPlayerTabOverlayEvent.PRE event) {
        Iterable iterable;
        Intrinsics.checkNotNullParameter(event, "event");
        Iterable $this$onEach$iv = event.getList();
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl2 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            IRCDataOtherSessionInfo iRCDataOtherSessionInfo;
            Object v1;
            Object object;
            NetworkPlayerInfo it;
            block2: {
                void $this$firstOrNull$iv;
                it = (NetworkPlayerInfo)element$iv;
                boolean bl3 = false;
                Collection<? extends IRCDataOtherSessionInfo> collection = this.irc.getSessionManager().getSessions().values();
                Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
                object = collection;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv2 : $this$firstOrNull$iv) {
                    IRCDataOtherSessionInfo irc2 = (IRCDataOtherSessionInfo)element$iv2;
                    boolean bl4 = false;
                    if (!Intrinsics.areEqual(irc2.getInfo().getState().getProfile().getName(), it.func_178845_a().getName())) continue;
                    v1 = element$iv2;
                    break block2;
                }
                v1 = null;
            }
            if ((iRCDataOtherSessionInfo = (IRCDataOtherSessionInfo)v1) == null) continue;
            Object irc3 = object = iRCDataOtherSessionInfo;
            boolean bl5 = false;
            ((Map)event.getOverwriteNames()).put(it, IRC.onRender2DPlayerTabOverlayPre$getPlayerName(it) + " \u00a7b(" + irc3.getInfo().getName() + ')');
        }
    }

    @EventTarget(priority=0)
    public final void onUpdateAllowTargets(@NotNull UpdateSelectTargetStatusEvent event) {
        block8: {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!((Boolean)this.ircFriendValue.get()).booleanValue()) break block8;
            IRCDataSelfSessionInfo iRCDataSelfSessionInfo = this.irc.getSessionManager().getSelfSession();
            boolean bl2 = iRCDataSelfSessionInfo != null ? !iRCDataSelfSessionInfo.getIsInvisible() : false;
            if (bl2) {
                EntityPlayer entityPlayer;
                EntityLivingBase entityLivingBase = event.getTarget();
                EntityPlayer entityPlayer2 = entityPlayer = entityLivingBase instanceof EntityPlayer ? (EntityPlayer)entityLivingBase : null;
                if (entityPlayer != null) {
                    EntityPlayer entityPlayer3;
                    EntityPlayer it = entityPlayer3 = entityPlayer;
                    boolean bl3 = false;
                    Object object = entityLivingBase = !event.isFriendEntity() ? entityPlayer3 : null;
                    if (entityLivingBase != null) {
                        boolean bl4;
                        EntityLivingBase it2;
                        EntityLivingBase entityLivingBase2;
                        block7: {
                            it2 = entityLivingBase2 = entityLivingBase;
                            boolean bl5 = false;
                            Collection<? extends IRCDataOtherSessionInfo> collection = this.irc.getSessionManager().getSessions().values();
                            Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
                            Iterable $this$any$iv = collection;
                            boolean $i$f$any = false;
                            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                bl4 = false;
                            } else {
                                for (Object element$iv : $this$any$iv) {
                                    IRCDataOtherSessionInfo session = (IRCDataOtherSessionInfo)element$iv;
                                    boolean bl6 = false;
                                    if (!(Intrinsics.areEqual(session.getInfo().getState().getProfile().getName(), it2.func_70005_c_()) && session.getInfo().getState().isFriend())) continue;
                                    bl4 = true;
                                    break block7;
                                }
                                bl4 = false;
                            }
                        }
                        Object object2 = entityPlayer3 = bl4 ? entityLivingBase2 : null;
                        if (entityPlayer3 != null) {
                            it2 = entityLivingBase2 = entityPlayer3;
                            boolean bl7 = false;
                            event.setFriendEntity();
                        }
                    }
                }
            }
        }
    }

    @EventTarget
    public final void onRenderEntityName(@NotNull RenderEntityNameEvent event) {
        block2: {
            IRCDataOtherSessionInfo iRCDataOtherSessionInfo;
            Object v2;
            block1: {
                Intrinsics.checkNotNullParameter(event, "event");
                Collection<? extends IRCDataOtherSessionInfo> collection = this.irc.getSessionManager().getSessions().values();
                Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
                Iterable $this$firstOrNull$iv = collection;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    EntityLivingBase entityLivingBase;
                    EntityPlayer entityPlayer;
                    IRCDataOtherSessionInfo session = (IRCDataOtherSessionInfo)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual(session.getInfo().getState().getProfile().getName(), (entityPlayer = (entityLivingBase = event.getEntity()) instanceof EntityPlayer ? (EntityPlayer)entityLivingBase : null) != null && (entityPlayer = entityPlayer.func_146103_bH()) != null ? entityPlayer.getName() : null)) continue;
                    v2 = element$iv;
                    break block1;
                }
                v2 = null;
            }
            IRCDataOtherSessionInfo iRCDataOtherSessionInfo2 = v2;
            if (iRCDataOtherSessionInfo2 == null) break block2;
            IRCDataOtherSessionInfo session = iRCDataOtherSessionInfo = iRCDataOtherSessionInfo2;
            boolean bl3 = false;
            event.setDisplayName(event.getDisplayName() + " \u00a7b(" + session.getInfo().getName() + ')');
        }
    }

    @Override
    @Nullable
    public String getTag() {
        Integer n2 = this.irc.getSessionManager().getSessions().size();
        int it = ((Number)n2).intValue();
        boolean bl2 = false;
        Integer n3 = it > 0 ? n2 : null;
        return n3 != null ? n3.toString() : null;
    }

    private static final void onWorld$lambda$1(IRC this$0) {
        this$0.postGameInfo();
    }

    private static final void onEnable$lambda$12(IRC this$0) {
        block2: {
            Object object;
            Object object2 = this$0;
            try {
                IRC $this$onEnable_u24lambda_u2412_u24lambda_u2410 = object2;
                boolean bl2 = false;
                DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u8fde\u63a5IRC\u670d\u52a1\u5668\u4e2d...");
                $this$onEnable_u24lambda_u2412_u24lambda_u2410.irc.connect();
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
            DarkMeow.INSTANCE.getMessageManager().display.displayWarn("IRC\u8fde\u63a5\u5931\u8d25 (" + e2.getClass().getSimpleName() + ": " + ((Throwable)e2).getMessage() + ')');
            this$0.setState(false);
        }
    }

    private static final String onRender2DPlayerTabOverlayPre$getPlayerName(NetworkPlayerInfo networkPlayerInfoIn) {
        Object object = networkPlayerInfoIn.func_178854_k();
        if (object == null || (object = object.func_150254_d()) == null) {
            String string = ScorePlayerTeam.func_96667_a((Team)((Team)networkPlayerInfoIn.func_178850_i()), (String)networkPlayerInfoIn.func_178845_a().getName());
            object = string;
            Intrinsics.checkNotNullExpressionValue(string, "formatPlayerName(...)");
        }
        return object;
    }
}

