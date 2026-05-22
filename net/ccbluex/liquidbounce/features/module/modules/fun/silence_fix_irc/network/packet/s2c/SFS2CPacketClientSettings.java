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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketClientSettings;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "latestVersionFree", "", "latestVersionPaid", "allowFreeAttackFree", "", "x19AuthFree", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;)V", "getLatestVersionFree", "()Ljava/lang/String;", "getLatestVersionPaid", "getAllowFreeAttackFree", "()Z", "getX19AuthFree", "Companion", "DarkMeow"})
public final class SFS2CPacketClientSettings
extends SFS2CPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String latestVersionFree;
    @NotNull
    private final String latestVersionPaid;
    private final boolean allowFreeAttackFree;
    private final boolean x19AuthFree;
    private static final int ID = 2;

    public SFS2CPacketClientSettings(@NotNull String latestVersionFree, @NotNull String latestVersionPaid, boolean allowFreeAttackFree, boolean x19AuthFree) {
        Intrinsics.checkNotNullParameter(latestVersionFree, "latestVersionFree");
        Intrinsics.checkNotNullParameter(latestVersionPaid, "latestVersionPaid");
        this.latestVersionFree = latestVersionFree;
        this.latestVersionPaid = latestVersionPaid;
        this.allowFreeAttackFree = allowFreeAttackFree;
        this.x19AuthFree = x19AuthFree;
    }

    @NotNull
    public final String getLatestVersionFree() {
        return this.latestVersionFree;
    }

    @NotNull
    public final String getLatestVersionPaid() {
        return this.latestVersionPaid;
    }

    public final boolean getAllowFreeAttackFree() {
        return this.allowFreeAttackFree;
    }

    public final boolean getX19AuthFree() {
        return this.x19AuthFree;
    }

    public SFS2CPacketClientSettings(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        this(buf.readString(), buf.readString(), buf.readBoolean(), buf.readBoolean());
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketClientSettings$Companion;", "", "<init>", "()V", "ID", "", "getID", "()I", "DarkMeow"})
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

