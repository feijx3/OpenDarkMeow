/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c;

import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParser;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUser;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0006\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketQueryGameProfileResponse;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "uniqueId", "Ljava/util/UUID;", "user", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUser;", "<init>", "(Ljava/util/UUID;Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUser;)V", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;)V", "packet", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketQueryGameProfileResponse;)V", "getUniqueId", "()Ljava/util/UUID;", "getUser", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUser;", "Companion", "DarkMeow"})
public final class SFS2CPacketQueryGameProfileResponse
extends SFS2CPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final UUID uniqueId;
    @NotNull
    private final SFUser user;
    private static final int ID = 7;

    public SFS2CPacketQueryGameProfileResponse(@NotNull UUID uniqueId, @NotNull SFUser user) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(user, "user");
        this.uniqueId = uniqueId;
        this.user = user;
    }

    @NotNull
    public final UUID getUniqueId() {
        return this.uniqueId;
    }

    @NotNull
    public final SFUser getUser() {
        return this.user;
    }

    public SFS2CPacketQueryGameProfileResponse(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        this(SFS2CPacketQueryGameProfileResponse.Companion.toPacket(buf));
    }

    public SFS2CPacketQueryGameProfileResponse(@NotNull SFS2CPacketQueryGameProfileResponse packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        this(packet.uniqueId, packet.user);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketQueryGameProfileResponse$Companion;", "", "<init>", "()V", "ID", "", "getID", "()I", "toPacket", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketQueryGameProfileResponse;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public final int getID() {
            return ID;
        }

        private final SFS2CPacketQueryGameProfileResponse toPacket(SilenceFixNettyBuffer $this$toPacket) {
            String client = $this$toPacket.readString();
            $this$toPacket.readInt();
            UUID id = $this$toPacket.readUUID();
            JsonObject payload = JsonParser.parseString($this$toPacket.readString()).getAsJsonObject();
            String string = payload.get("username").getAsString();
            Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
            String string2 = payload.get("rank").getAsString();
            Intrinsics.checkNotNullExpressionValue(string2, "getAsString(...)");
            return new SFS2CPacketQueryGameProfileResponse(id, new SFUser(string, string2, client));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

