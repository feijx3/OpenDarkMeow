/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.util.text.ITextComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFStatic;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelInboundHandlerAdapter;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendDisconnect;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "<init>", "()V", "actionValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "onConnected", "", "channel", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "Handle", "DarkMeow"})
public final class SFExtendDisconnect
extends SFExtend {
    @JvmField
    @NotNull
    public final ListValue actionValue;

    public SFExtendDisconnect() {
        super("Disconnect", false, true, 2, null);
        String[] stringArray = new String[]{"Disable", "Reconnect"};
        this.actionValue = new ListValue("Action", stringArray, "Reconnect");
    }

    @Override
    public void onConnected(@NotNull SFConnection channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        channel.addPipeLineToLast("plugin_" + this.getName(), new Handle(this));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendDisconnect$Handle;", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelInboundHandlerAdapter;", "module", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendDisconnect;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendDisconnect;)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendDisconnect;", "channelInactive", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "DarkMeow"})
    public static final class Handle
    extends ChannelInboundHandlerAdapter {
        @NotNull
        private final SFExtendDisconnect module;

        public Handle(@NotNull SFExtendDisconnect module) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.module = module;
        }

        @NotNull
        public final SFExtendDisconnect getModule() {
            return this.module;
        }

        @Override
        public void channelInactive(@NotNull ChannelHandlerContext ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            if (!this.module.handleEvents()) {
                return;
            }
            if (Intrinsics.areEqual(this.module.getInstance().getClient().getDisconnectReason(), "")) {
                this.module.getInstance().getClient().setDisconnectReason("\u672a\u77e5\u9519\u8bef");
            }
            MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
            ITextComponent iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a("\u00a7c\u8fde\u63a5\u4e22\u5931: " + this.module.getInstance().getClient().getDisconnectReason());
            Intrinsics.checkNotNullExpressionValue(iTextComponent, "appendText(...)");
            messageManager.displayChatMessage(iTextComponent);
            String string = (String)this.module.actionValue.get();
            if (Intrinsics.areEqual(string, "Disable")) {
                this.module.getInstance().setState(false);
            } else if (Intrinsics.areEqual(string, "Reconnect")) {
                this.module.getInstance().onEnable();
            }
        }
    }
}

