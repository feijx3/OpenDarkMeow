/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.netty.packet;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacketHandShake;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.ByteToMessageDecoder;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/netty/packet/SFHandlePacketDecoder;", "Lnet/darkmeow/irc/lib/io/netty/handler/codec/ByteToMessageDecoder;", "connection", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;)V", "getConnection", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "checkedProtocolVersion", "", "getCheckedProtocolVersion", "()Z", "setCheckedProtocolVersion", "(Z)V", "decode", "", "ctx", "Lnet/darkmeow/irc/lib/io/netty/channel/ChannelHandlerContext;", "buf", "Lnet/darkmeow/irc/lib/io/netty/buffer/ByteBuf;", "out", "", "", "DarkMeow"})
public final class SFHandlePacketDecoder
extends ByteToMessageDecoder {
    @NotNull
    private final SFConnection connection;
    private boolean checkedProtocolVersion;

    public SFHandlePacketDecoder(@NotNull SFConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
    }

    @NotNull
    public final SFConnection getConnection() {
        return this.connection;
    }

    public final boolean getCheckedProtocolVersion() {
        return this.checkedProtocolVersion;
    }

    public final void setCheckedProtocolVersion(boolean bl2) {
        this.checkedProtocolVersion = bl2;
    }

    @Override
    protected void decode(@NotNull ChannelHandlerContext ctx, @NotNull ByteBuf buf, @NotNull List<Object> out) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(out, "out");
        if (this.checkedProtocolVersion) {
            if (buf.readableBytes() < 4) {
                return;
            }
            SilenceFixNettyBuffer wrappedBuffer = new SilenceFixNettyBuffer(buf);
            int packetId = wrappedBuffer.readInt();
            Class<? extends SFS2CPacket> clazz = SFS2CPacket.Companion.getPACKETS().get(packetId);
            if (clazz != null) {
                Object object = new Class[]{SilenceFixNettyBuffer.class};
                Constructor<? extends SFS2CPacket> constructor = clazz.getConstructor((Class<?>)object);
                if (constructor != null) {
                    Object[] objectArray = new Object[]{wrappedBuffer};
                    object = constructor.newInstance(objectArray);
                    if (object != null) {
                        Object[] packet = objectArray = object;
                        boolean bl2 = false;
                        ctx.fireChannelRead(packet);
                    }
                }
            }
        } else {
            this.checkedProtocolVersion = true;
            int serverProtocolVersion = buf.readInt();
            if (serverProtocolVersion == 14) {
                char[] verifyMessage = new char[24];
                int insertPosition = ThreadLocalRandom.current().nextInt(0, 18);
                int i2 = 0;
                while (i2 < 24) {
                    if (i2 == insertPosition) {
                        int n2 = ((CharSequence)"genshin").length();
                        for (int j2 = 0; j2 < n2; ++j2) {
                            verifyMessage[i2 + j2] = "genshin".charAt(j2);
                        }
                        i2 += 7;
                        continue;
                    }
                    verifyMessage[i2] = (char)ThreadLocalRandom.current().nextInt(97, 123);
                    ++i2;
                }
                this.connection.sendPacket(new SFC2SPacketHandShake(new String(verifyMessage), this.connection.getKey()));
            } else {
                this.connection.close("SFHandlePacketDecoder: \u534f\u8bae\u7248\u672c\u4e0d\u5339\u914d (remote=" + serverProtocolVersion + ", local=14)");
            }
        }
    }
}

