/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFStatic;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUser;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketMessage;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.utils.kotlin.StringBuilderUtils;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendMessage;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "<init>", "()V", "otherUserValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onlineStatusValue", "serverLogValue", "serverSayValue", "broadCastValue", "onConnected", "", "channel", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "Handle", "DarkMeow"})
public final class SFExtendMessage
extends SFExtend {
    @JvmField
    @NotNull
    public final BoolValue otherUserValue = new BoolValue("OtherUser", true);
    @JvmField
    @NotNull
    public final BoolValue onlineStatusValue = new BoolValue("OnlineStatus", true);
    @JvmField
    @NotNull
    public final BoolValue serverLogValue = new BoolValue("SeverLog", true);
    @JvmField
    @NotNull
    public final BoolValue serverSayValue = new BoolValue("SeverSay", true);
    @JvmField
    @NotNull
    public final BoolValue broadCastValue = new BoolValue("BroadCast", false);

    public SFExtendMessage() {
        super("Message", false, true, 2, null);
    }

    @Override
    public void onConnected(@NotNull SFConnection channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        channel.addPipeLineToLast("plugin_" + this.getName(), new Handle(this));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendMessage$Handle;", "Lnet/darkmeow/irc/lib/io/netty/channel/SimpleChannelInboundHandler;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketMessage;", "module", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendMessage;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendMessage;)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendMessage;", "channelRead0", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "packet", "DarkMeow"})
    public static final class Handle
    extends SimpleChannelInboundHandler<SFS2CPacketMessage> {
        @NotNull
        private final SFExtendMessage module;

        public Handle(@NotNull SFExtendMessage module) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.module = module;
        }

        @NotNull
        public final SFExtendMessage getModule() {
            return this.module;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull SFS2CPacketMessage packet) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(packet, "packet");
            switch (WhenMappings.$EnumSwitchMapping$0[packet.getChannel().ordinal()]) {
                case 1: {
                    void $this$channelRead0_u24lambda_u241_u24lambda_u240;
                    void $this$channelRead0_u24lambda_u241;
                    StringBuilder stringBuilder;
                    ITextComponent iTextComponent;
                    if (!((Boolean)this.module.otherUserValue.get()).booleanValue()) break;
                    SFUser sender = packet.getSender();
                    String mcName = packet.getPublicSenderMCName();
                    ITextComponent iTextComponent2 = iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a(sender.getName() + " \u00a77(" + sender.getRank() + "\u00a77)\u00a7f: ").func_150258_a("\u00a7f" + packet.getMessage());
                    MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
                    boolean bl2 = false;
                    StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
                    StringBuilderUtils stringBuilderUtils = StringBuilderUtils.INSTANCE;
                    HoverEvent.Action action = HoverEvent.Action.SHOW_TEXT;
                    Style style = $this$channelRead0_u24lambda_u241.func_150256_b();
                    void var17_36 = $this$channelRead0_u24lambda_u241;
                    boolean bl3 = false;
                    $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7f\u7528\u6237\u540d: " + sender.getName()).append('\n');
                    $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7f\u7b49\u7ea7: " + sender.getRank()).append('\n');
                    $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7f\u6e38\u620f\u540d: " + mcName).append('\n');
                    $this$channelRead0_u24lambda_u241_u24lambda_u240.append('\n');
                    $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7f\u70b9\u51fb\u4ee5\u590d\u5236\u7528\u6237\u540d\u548c\u6e38\u620f\u540d").append('\n');
                    Unit unit = Unit.INSTANCE;
                    String string = stringBuilderUtils.toTrimString(stringBuilder);
                    ITextComponent iTextComponent3 = (ITextComponent)new TextComponentString(string);
                    HoverEvent.Action action2 = action;
                    var17_36.func_150255_a(style.func_150209_a(new HoverEvent(action2, iTextComponent3)));
                    $this$channelRead0_u24lambda_u241.func_150255_a($this$channelRead0_u24lambda_u241.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, sender.getName() + ' ' + mcName)));
                    ITextComponent iTextComponent4 = iTextComponent;
                    Intrinsics.checkNotNullExpressionValue(iTextComponent4, "apply(...)");
                    messageManager.displayChatMessage(iTextComponent4);
                    break;
                }
                case 2: {
                    if (!((Boolean)this.module.onlineStatusValue.get()).booleanValue()) break;
                    SFUser sender = packet.getConnectionExecutor();
                    MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
                    ITextComponent iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a(sender.getName() + "\u00a77(" + sender.getRank() + "\u00a77) ").func_150258_a(packet.getConnectionStatus() ? "\u00a7f\u52a0\u5165\u4e86IRC" : "\u00a7f\u79bb\u5f00\u4e86IRC");
                    Intrinsics.checkNotNullExpressionValue(iTextComponent, "appendText(...)");
                    messageManager.displayChatMessage(iTextComponent);
                    break;
                }
                case 3: {
                    void $this$channelRead0_u24lambda_u243_u24lambda_u242;
                    void $this$channelRead0_u24lambda_u243;
                    StringBuilder stringBuilder;
                    ITextComponent iTextComponent;
                    if (!((Boolean)this.module.serverLogValue.get()).booleanValue()) break;
                    ITextComponent iTextComponent5 = iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a("\u00a7f" + packet.getMessage());
                    MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
                    boolean bl4 = false;
                    StringBuilder bl2 = stringBuilder = new StringBuilder();
                    StringBuilderUtils stringBuilderUtils = StringBuilderUtils.INSTANCE;
                    HoverEvent.Action action = HoverEvent.Action.SHOW_TEXT;
                    Style style = $this$channelRead0_u24lambda_u243.func_150256_b();
                    void var15_54 = $this$channelRead0_u24lambda_u243;
                    boolean bl5 = false;
                    $this$channelRead0_u24lambda_u243_u24lambda_u242.append("\u00a7f\u6b64\u6d88\u606f\u7531 IRC \u670d\u52a1\u7aef\u81ea\u52a8\u53d1\u9001").append('\n');
                    $this$channelRead0_u24lambda_u243_u24lambda_u242.append("\u00a7f\u60a8\u53ef\u4ee5\u5728\u53c2\u6570\u8bbe\u7f6e\u4e2d\u53d6\u6d88\u52fe\u9009 ServerSay \u4ee5\u5173\u95ed").append('\n');
                    $this$channelRead0_u24lambda_u243_u24lambda_u242.append('\n');
                    $this$channelRead0_u24lambda_u243_u24lambda_u242.append("\u00a7f\u70b9\u51fb\u4ee5\u590d\u5236\u6574\u6761\u6d88\u606f").append('\n');
                    Unit unit = Unit.INSTANCE;
                    String string = stringBuilderUtils.toTrimString(stringBuilder);
                    ITextComponent iTextComponent6 = (ITextComponent)new TextComponentString(string);
                    HoverEvent.Action action3 = action;
                    var15_54.func_150255_a(style.func_150209_a(new HoverEvent(action3, iTextComponent6)));
                    $this$channelRead0_u24lambda_u243.func_150255_a($this$channelRead0_u24lambda_u243.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, packet.getMessage())));
                    ITextComponent iTextComponent7 = iTextComponent;
                    Intrinsics.checkNotNullExpressionValue(iTextComponent7, "apply(...)");
                    messageManager.displayChatMessage(iTextComponent7);
                    break;
                }
                case 4: {
                    void $this$channelRead0_u24lambda_u245_u24lambda_u244;
                    void $this$channelRead0_u24lambda_u245;
                    StringBuilder stringBuilder;
                    ITextComponent iTextComponent;
                    if (!((Boolean)this.module.serverSayValue.get()).booleanValue()) break;
                    ITextComponent $this$channelRead0_u24lambda_u243 = iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a("\u00a7f" + packet.getMessage());
                    MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
                    boolean bl6 = false;
                    StringBuilder $this$channelRead0_u24lambda_u243_u24lambda_u242 = stringBuilder = new StringBuilder();
                    StringBuilderUtils stringBuilderUtils = StringBuilderUtils.INSTANCE;
                    HoverEvent.Action action = HoverEvent.Action.SHOW_TEXT;
                    Style style = $this$channelRead0_u24lambda_u245.func_150256_b();
                    void var15_55 = $this$channelRead0_u24lambda_u245;
                    boolean bl7 = false;
                    $this$channelRead0_u24lambda_u245_u24lambda_u244.append("\u00a7f\u6b64\u6d88\u606f\u7531 IRC \u7ba1\u7406\u5458\u624b\u52a8\u53d1\u9001").append('\n');
                    $this$channelRead0_u24lambda_u245_u24lambda_u244.append("\u00a7f\u60a8\u53ef\u4ee5\u5728\u53c2\u6570\u8bbe\u7f6e\u4e2d\u53d6\u6d88\u52fe\u9009 ServerSay \u4ee5\u5173\u95ed").append('\n');
                    $this$channelRead0_u24lambda_u245_u24lambda_u244.append('\n');
                    $this$channelRead0_u24lambda_u245_u24lambda_u244.append("\u00a7f\u70b9\u51fb\u4ee5\u590d\u5236\u6574\u6761\u6d88\u606f").append('\n');
                    Unit unit = Unit.INSTANCE;
                    String string = stringBuilderUtils.toTrimString(stringBuilder);
                    ITextComponent iTextComponent8 = (ITextComponent)new TextComponentString(string);
                    HoverEvent.Action action4 = action;
                    var15_55.func_150255_a(style.func_150209_a(new HoverEvent(action4, iTextComponent8)));
                    $this$channelRead0_u24lambda_u245.func_150255_a($this$channelRead0_u24lambda_u245.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, packet.getMessage())));
                    ITextComponent iTextComponent9 = iTextComponent;
                    Intrinsics.checkNotNullExpressionValue(iTextComponent9, "apply(...)");
                    messageManager.displayChatMessage(iTextComponent9);
                    break;
                }
                case 5: {
                    void $this$channelRead0_u24lambda_u247_u24lambda_u246;
                    void $this$channelRead0_u24lambda_u247;
                    StringBuilder stringBuilder;
                    ITextComponent iTextComponent;
                    if (!((Boolean)this.module.broadCastValue.get()).booleanValue()) break;
                    ITextComponent $this$channelRead0_u24lambda_u245 = iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a("\u00a7f" + packet.getMessage());
                    MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
                    boolean bl8 = false;
                    StringBuilder $this$channelRead0_u24lambda_u245_u24lambda_u244 = stringBuilder = new StringBuilder();
                    StringBuilderUtils stringBuilderUtils = StringBuilderUtils.INSTANCE;
                    HoverEvent.Action action = HoverEvent.Action.SHOW_TEXT;
                    Style style = $this$channelRead0_u24lambda_u247.func_150256_b();
                    void var15_56 = $this$channelRead0_u24lambda_u247;
                    boolean bl9 = false;
                    $this$channelRead0_u24lambda_u247_u24lambda_u246.append("\u00a7f\u6b64\u6d88\u606f\u4e3a\u5e7f\u64ad\u516c\u544a\u6d88\u606f").append('\n');
                    $this$channelRead0_u24lambda_u247_u24lambda_u246.append("\u00a7f\u60a8\u53ef\u4ee5\u5728\u53c2\u6570\u8bbe\u7f6e\u4e2d\u53d6\u6d88\u52fe\u9009 BroadCast \u4ee5\u5173\u95ed").append('\n');
                    $this$channelRead0_u24lambda_u247_u24lambda_u246.append('\n');
                    $this$channelRead0_u24lambda_u247_u24lambda_u246.append("\u00a7f\u70b9\u51fb\u4ee5\u590d\u5236\u6574\u6761\u6d88\u606f").append('\n');
                    Unit unit = Unit.INSTANCE;
                    String string = stringBuilderUtils.toTrimString(stringBuilder);
                    ITextComponent iTextComponent10 = (ITextComponent)new TextComponentString(string);
                    HoverEvent.Action action5 = action;
                    var15_56.func_150255_a(style.func_150209_a(new HoverEvent(action5, iTextComponent10)));
                    $this$channelRead0_u24lambda_u247.func_150255_a($this$channelRead0_u24lambda_u247.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, packet.getMessage())));
                    ITextComponent iTextComponent11 = iTextComponent;
                    Intrinsics.checkNotNullExpressionValue(iTextComponent11, "apply(...)");
                    messageManager.displayChatMessage(iTextComponent11);
                }
            }
        }

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[SFS2CPacketMessage.Channel.values().length];
                try {
                    nArray[SFS2CPacketMessage.Channel.Public.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SFS2CPacketMessage.Channel.UserConnectionStatus.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SFS2CPacketMessage.Channel.ServerLog.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SFS2CPacketMessage.Channel.ServerSay.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SFS2CPacketMessage.Channel.Broadcast.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}

