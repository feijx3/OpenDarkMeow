/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketQueryGameProfile;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacket;", "type", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketQueryGameProfile$Type;", "uniqueId", "Ljava/util/UUID;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketQueryGameProfile$Type;Ljava/util/UUID;)V", "getType", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketQueryGameProfile$Type;", "getUniqueId", "()Ljava/util/UUID;", "write", "", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "Type", "DarkMeow"})
public final class SFC2SPacketQueryGameProfile
extends SFC2SPacket {
    @NotNull
    private final Type type;
    @NotNull
    private final UUID uniqueId;

    public SFC2SPacketQueryGameProfile(@NotNull Type type, @NotNull UUID uniqueId) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        super(8);
        this.type = type;
        this.uniqueId = uniqueId;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @NotNull
    public final UUID getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public void write(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeInt(this.type.ordinal());
        buf.writeUUID(this.uniqueId);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketQueryGameProfile$Type;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "TAB", "DarkMeow"})
    public static final class Type
    extends Enum<Type> {
        public static final /* enum */ Type NORMAL = new Type();
        public static final /* enum */ Type TAB = new Type();
        private static final /* synthetic */ Type[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        public static Type valueOf(String value) {
            return Enum.valueOf(Type.class, value);
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = typeArray = new Type[]{Type.NORMAL, Type.TAB};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

