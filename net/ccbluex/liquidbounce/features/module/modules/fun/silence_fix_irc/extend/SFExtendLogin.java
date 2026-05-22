/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFStatic;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketUserInformation;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.darkmeow.darkmeow.utils.kotlin.StringBuilderUtils;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendLogin;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "<init>", "()V", "onConnected", "", "channel", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "Handle", "DarkMeow"})
public final class SFExtendLogin
extends SFExtend {
    public SFExtendLogin() {
        super("Login", false, true, 2, null);
    }

    @Override
    public void onConnected(@NotNull SFConnection channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        channel.addPipeLineToLast("plugin_" + this.getName(), new Handle(this));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendLogin$Handle;", "Lnet/darkmeow/irc/lib/io/netty/channel/SimpleChannelInboundHandler;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketUserInformation;", "module", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendLogin;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendLogin;)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendLogin;", "channelRead0", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "packet", "DarkMeow"})
    public static final class Handle
    extends SimpleChannelInboundHandler<SFS2CPacketUserInformation> {
        @NotNull
        private final SFExtendLogin module;

        public Handle(@NotNull SFExtendLogin module) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.module = module;
        }

        @NotNull
        public final SFExtendLogin getModule() {
            return this.module;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull SFS2CPacketUserInformation packet) {
            void $this$channelRead0_u24lambda_u241_u24lambda_u240;
            void $this$channelRead0_u24lambda_u241;
            StringBuilder stringBuilder;
            ITextComponent iTextComponent;
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(packet, "packet");
            ITextComponent iTextComponent2 = iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a("\u00a7a\u767b\u5f55\u6210\u529f");
            MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
            boolean bl2 = false;
            StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
            StringBuilderUtils stringBuilderUtils = StringBuilderUtils.INSTANCE;
            HoverEvent.Action action = HoverEvent.Action.SHOW_TEXT;
            Style style = $this$channelRead0_u24lambda_u241.func_150256_b();
            void var11_12 = $this$channelRead0_u24lambda_u241;
            boolean bl3 = false;
            $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7f\u7528\u6237\u540d: " + packet.getUser().getName()).append('\n');
            $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7f\u7b49\u7ea7: " + packet.getUser().getRank()).append('\n');
            $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7fQQ: " + packet.getUser().getQq()).append('\n');
            $this$channelRead0_u24lambda_u241_u24lambda_u240.append('\n');
            $this$channelRead0_u24lambda_u241_u24lambda_u240.append("\u00a7f\u70b9\u51fb\u4ee5\u590d\u5236\u7528\u6237\u540d").append('\n');
            Unit unit = Unit.INSTANCE;
            String string = stringBuilderUtils.toTrimString(stringBuilder);
            ITextComponent iTextComponent3 = (ITextComponent)new TextComponentString(string);
            HoverEvent.Action action2 = action;
            var11_12.func_150255_a(style.func_150209_a(new HoverEvent(action2, iTextComponent3)));
            $this$channelRead0_u24lambda_u241.func_150255_a($this$channelRead0_u24lambda_u241.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, packet.getUser().getName())));
            ITextComponent iTextComponent4 = iTextComponent;
            Intrinsics.checkNotNullExpressionValue(iTextComponent4, "apply(...)");
            messageManager.displayChatMessage(iTextComponent4);
        }
    }
}

