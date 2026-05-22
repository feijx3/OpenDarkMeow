/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketLoginResult;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "isSuccess", "", "Companion", "DarkMeow"})
public final class SFS2CPacketLoginResult
extends SFS2CPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int code;
    @NotNull
    private final String message;
    private static final int ID = 4;

    public SFS2CPacketLoginResult(int code, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = code;
        this.message = message;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final boolean isSuccess() {
        return this.code == 2;
    }

    public SFS2CPacketLoginResult(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        this(buf.readInt(), buf.readString());
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketLoginResult$Companion;", "", "<init>", "()V", "ID", "", "getID", "()I", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public final int getID() {
            return ID;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

