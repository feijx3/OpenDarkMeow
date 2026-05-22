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
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUserLevel;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUserSelf;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketUserInformation;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "user", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;)V", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;)V", "getUser", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;", "Companion", "DarkMeow"})
public final class SFS2CPacketUserInformation
extends SFS2CPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SFUserSelf user;
    private static final int ID = 5;

    public SFS2CPacketUserInformation(@NotNull SFUserSelf user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.user = user;
    }

    @NotNull
    public final SFUserSelf getUser() {
        return this.user;
    }

    public SFS2CPacketUserInformation(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        String string = buf.readString();
        String string2 = buf.readString();
        SFUserLevel sFUserLevel = SFUserLevel.valueOf(buf.readString());
        String string3 = buf.readString();
        this(new SFUserSelf(string, string2, "SilenceFix", sFUserLevel, string3));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketUserInformation$Companion;", "", "<init>", "()V", "ID", "", "getID", "()I", "DarkMeow"})
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

