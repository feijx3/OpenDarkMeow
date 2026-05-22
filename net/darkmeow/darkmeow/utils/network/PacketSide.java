/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/darkmeow/darkmeow/utils/network/PacketSide;", "", "<init>", "(Ljava/lang/String;I)V", "CLIENT", "SERVER", "UNKNOWN", "DarkMeow"})
public final class PacketSide
extends Enum<PacketSide> {
    public static final /* enum */ PacketSide CLIENT = new PacketSide();
    public static final /* enum */ PacketSide SERVER = new PacketSide();
    public static final /* enum */ PacketSide UNKNOWN = new PacketSide();
    private static final /* synthetic */ PacketSide[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static PacketSide[] values() {
        return (PacketSide[])$VALUES.clone();
    }

    public static PacketSide valueOf(String value) {
        return Enum.valueOf(PacketSide.class, value);
    }

    @NotNull
    public static EnumEntries<PacketSide> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = packetSideArray = new PacketSide[]{PacketSide.CLIENT, PacketSide.SERVER, PacketSide.UNKNOWN};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

