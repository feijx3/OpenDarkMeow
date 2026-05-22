/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  net.minecraft.network.PacketBuffer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.client;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.HytPacket;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0096D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/client/CPacketHytGermJoinGame;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket;", "entry", "", "sid", "", "<init>", "(ILjava/lang/String;)V", "getEntry", "()I", "getSid", "()Ljava/lang/String;", "channel", "getChannel$annotations", "()V", "getChannel", "Companion", "DarkMeow"})
public final class CPacketHytGermJoinGame
extends HytPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int entry;
    @NotNull
    private final String sid;
    @NotNull
    private final String channel;
    @NotNull
    private static final byte[] PREFIX_JOIN_GAME;

    public CPacketHytGermJoinGame(int entry, @NotNull String sid) {
        Intrinsics.checkNotNullParameter(sid, "sid");
        this.entry = entry;
        this.sid = sid;
        this.channel = "germmod-netease";
        String json = "{\"entry\":" + this.entry + ",\"sid\":\"" + this.sid + "\"}";
        int n2 = PREFIX_JOIN_GAME.length;
        String string = json;
        byte[] byArray = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(byArray, "getBytes(...)");
        byte[] bytes = new byte[n2 + byArray.length + 2];
        System.arraycopy(PREFIX_JOIN_GAME, 0, bytes, 0, PREFIX_JOIN_GAME.length);
        bytes[CPacketHytGermJoinGame.PREFIX_JOIN_GAME.length] = (byte)(48 + this.entry);
        bytes[CPacketHytGermJoinGame.PREFIX_JOIN_GAME.length + 1] = (byte)json.length();
        string = json;
        byte[] byArray2 = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(byArray2, "getBytes(...)");
        int n3 = PREFIX_JOIN_GAME.length + 2;
        string = json;
        byte[] byArray3 = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(byArray3, "getBytes(...)");
        System.arraycopy(byArray2, 0, bytes, n3, byArray3.length);
        super.setByte(new PacketBuffer(Unpooled.buffer().writeBytes(bytes)));
    }

    public final int getEntry() {
        return this.entry;
    }

    @NotNull
    public final String getSid() {
        return this.sid;
    }

    @Override
    @NotNull
    public String getChannel() {
        return this.channel;
    }

    public static /* synthetic */ void getChannel$annotations() {
    }

    static {
        byte[] byArray = new byte[]{0, 0, 0, 26, 20, 71, 85, 73, 36, 109, 97, 105, 110, 109, 101, 110, 117, 64, 101, 110, 116, 114, 121, 47};
        PREFIX_JOIN_GAME = byArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/client/CPacketHytGermJoinGame$Companion;", "", "<init>", "()V", "PREFIX_JOIN_GAME", "", "getPREFIX_JOIN_GAME", "()[B", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final byte[] getPREFIX_JOIN_GAME() {
            return PREFIX_JOIN_GAME;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

