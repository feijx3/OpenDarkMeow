/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c;

import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUser;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.s2c.SFS2CPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u0007\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00050\u0005J\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketMessage;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacket;", "channel", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketMessage$Channel;", "payload", "", "message", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketMessage$Channel;Ljava/lang/String;Ljava/lang/String;)V", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;)V", "getChannel", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketMessage$Channel;", "getPayload", "()Ljava/lang/String;", "getMessage", "getSender", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUser;", "getConnectionStatus", "", "getConnectionExecutor", "getPublicSenderMCName", "kotlin.jvm.PlatformType", "getAntiSpamCooldown", "", "Companion", "Channel", "DarkMeow"})
public final class SFS2CPacketMessage
extends SFS2CPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Channel channel;
    @NotNull
    private final String payload;
    @NotNull
    private final String message;
    private static final int ID = 6;

    public SFS2CPacketMessage(@NotNull Channel channel, @NotNull String payload, @NotNull String message) {
        Intrinsics.checkNotNullParameter((Object)channel, "channel");
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(message, "message");
        this.channel = channel;
        this.payload = payload;
        this.message = message;
    }

    @NotNull
    public final Channel getChannel() {
        return this.channel;
    }

    @NotNull
    public final String getPayload() {
        return this.payload;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public SFS2CPacketMessage(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        this(Channel.valueOf(buf.readString()), buf.readString(), buf.readString());
    }

    @NotNull
    public final SFUser getSender() {
        JsonObject it = JsonParser.parseString(this.payload).getAsJsonObject();
        boolean bl2 = false;
        String string = it.get("username").getAsString();
        Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
        String string2 = it.get("rank").getAsString();
        Intrinsics.checkNotNullExpressionValue(string2, "getAsString(...)");
        String string3 = it.get("clientName").getAsString();
        Intrinsics.checkNotNullExpressionValue(string3, "getAsString(...)");
        return new SFUser(string, string2, string3);
    }

    public final boolean getConnectionStatus() {
        return Intrinsics.areEqual(JsonParser.parseString(this.payload).getAsJsonObject().get("status").getAsString(), "online");
    }

    @NotNull
    public final SFUser getConnectionExecutor() {
        JsonObject base = JsonParser.parseString(this.payload).getAsJsonObject();
        JsonObject user = JsonParser.parseString(base.get("userPayload").getAsString()).getAsJsonObject();
        String string = user.get("username").getAsString();
        Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
        String string2 = user.get("rank").getAsString();
        Intrinsics.checkNotNullExpressionValue(string2, "getAsString(...)");
        String string3 = base.get("clientName").getAsString();
        Intrinsics.checkNotNullExpressionValue(string3, "getAsString(...)");
        return new SFUser(string, string2, string3);
    }

    public final String getPublicSenderMCName() {
        return JsonParser.parseString(this.payload).getAsJsonObject().get("mcName").getAsString();
    }

    public final int getAntiSpamCooldown() {
        long nextChatMillis = JsonParser.parseString(this.payload).getAsJsonObject().get("nextChatTime").getAsLong();
        long nowMillis = System.currentTimeMillis();
        return RangesKt.coerceAtLeast((int)((nextChatMillis - nowMillis) / (long)1000), 1);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketMessage$Channel;", "", "<init>", "(Ljava/lang/String;I)V", "Public", "UserConnectionStatus", "Broadcast", "ServerLog", "ServerSay", "AntiSpam", "DarkMeow"})
    public static final class Channel
    extends Enum<Channel> {
        public static final /* enum */ Channel Public = new Channel();
        public static final /* enum */ Channel UserConnectionStatus = new Channel();
        public static final /* enum */ Channel Broadcast = new Channel();
        public static final /* enum */ Channel ServerLog = new Channel();
        public static final /* enum */ Channel ServerSay = new Channel();
        public static final /* enum */ Channel AntiSpam = new Channel();
        private static final /* synthetic */ Channel[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Channel[] values() {
            return (Channel[])$VALUES.clone();
        }

        public static Channel valueOf(String value) {
            return Enum.valueOf(Channel.class, value);
        }

        @NotNull
        public static EnumEntries<Channel> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = channelArray = new Channel[]{Channel.Public, Channel.UserConnectionStatus, Channel.Broadcast, Channel.ServerLog, Channel.ServerSay, Channel.AntiSpam};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/s2c/SFS2CPacketMessage$Companion;", "", "<init>", "()V", "ID", "", "getID", "()I", "DarkMeow"})
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

