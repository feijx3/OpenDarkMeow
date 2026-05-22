/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.SFPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketClientSettings;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketHandShakeSuccess;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketKeepAlive;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketLoginResult;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketMessage;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketPingTime;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketQueryGameProfileResponse;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacketUserInformation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/SFPacket;", "<init>", "()V", "Companion", "DarkMeow"})
public abstract class SFS2CPacket
implements SFPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final HashMap<Integer, Class<? extends SFS2CPacket>> PACKETS;

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to(SFS2CPacketKeepAlive.Companion.getID(), SFS2CPacketKeepAlive.class), TuplesKt.to(SFS2CPacketClientSettings.Companion.getID(), SFS2CPacketClientSettings.class), TuplesKt.to(SFS2CPacketHandShakeSuccess.Companion.getID(), SFS2CPacketHandShakeSuccess.class), TuplesKt.to(SFS2CPacketLoginResult.Companion.getID(), SFS2CPacketLoginResult.class), TuplesKt.to(SFS2CPacketUserInformation.Companion.getID(), SFS2CPacketUserInformation.class), TuplesKt.to(SFS2CPacketMessage.Companion.getID(), SFS2CPacketMessage.class), TuplesKt.to(SFS2CPacketQueryGameProfileResponse.Companion.getID(), SFS2CPacketQueryGameProfileResponse.class), TuplesKt.to(SFS2CPacketPingTime.Companion.getID(), SFS2CPacketPingTime.class)};
        PACKETS = MapsKt.hashMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R=\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket$Companion;", "", "<init>", "()V", "PACKETS", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "Lkotlin/collections/HashMap;", "getPACKETS", "()Ljava/util/HashMap;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashMap<Integer, Class<? extends SFS2CPacket>> getPACKETS() {
            return PACKETS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

