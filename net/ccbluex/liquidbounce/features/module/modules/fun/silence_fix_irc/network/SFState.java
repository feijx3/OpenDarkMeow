/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFState;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "HANDSHAKE", "LOGIN", "PLAY", "DarkMeow"})
public final class SFState
extends Enum<SFState> {
    public static final /* enum */ SFState CONNECTING = new SFState();
    public static final /* enum */ SFState HANDSHAKE = new SFState();
    public static final /* enum */ SFState LOGIN = new SFState();
    public static final /* enum */ SFState PLAY = new SFState();
    private static final /* synthetic */ SFState[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static SFState[] values() {
        return (SFState[])$VALUES.clone();
    }

    public static SFState valueOf(String value) {
        return Enum.valueOf(SFState.class, value);
    }

    @NotNull
    public static EnumEntries<SFState> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = sFStateArray = new SFState[]{SFState.CONNECTING, SFState.HANDSHAKE, SFState.LOGIN, SFState.PLAY};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

