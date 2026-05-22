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
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.HytPacket;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/client/CPacketHytGermOpenGUI;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket;", "<init>", "()V", "channel", "", "getChannel$annotations", "getChannel", "()Ljava/lang/String;", "byte", "Lnet/minecraft/network/PacketBuffer;", "getByte", "()Lnet/minecraft/network/PacketBuffer;", "setByte", "(Lnet/minecraft/network/PacketBuffer;)V", "Companion", "DarkMeow"})
public final class CPacketHytGermOpenGUI
extends HytPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String channel;
    @NotNull
    private PacketBuffer byte = new PacketBuffer(Unpooled.buffer().writeBytes(OPEN_GUI));
    @NotNull
    private static final byte[] OPEN_GUI;

    public CPacketHytGermOpenGUI() {
        this.channel = "germmod-netease";
    }

    @Override
    @NotNull
    public String getChannel() {
        return this.channel;
    }

    public static /* synthetic */ void getChannel$annotations() {
    }

    @Override
    @NotNull
    public PacketBuffer getByte() {
        return this.byte;
    }

    @Override
    public void setByte(@NotNull PacketBuffer packetBuffer) {
        Intrinsics.checkNotNullParameter(packetBuffer, "<set-?>");
        this.byte = packetBuffer;
    }

    static {
        byte[] byArray = new byte[]{0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 8, 109, 97, 105, 110, 109, 101, 110, 117, 8, 109, 97, 105, 110, 109, 101, 110, 117, 8, 109, 97, 105, 110, 109, 101, 110, 117};
        OPEN_GUI = byArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/client/CPacketHytGermOpenGUI$Companion;", "", "<init>", "()V", "OPEN_GUI", "", "getOPEN_GUI", "()[B", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final byte[] getOPEN_GUI() {
            return OPEN_GUI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

