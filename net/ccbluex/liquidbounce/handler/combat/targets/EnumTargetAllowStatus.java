/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.combat.targets;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/handler/combat/targets/EnumTargetAllowStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ONLY_RENDER", "COMBAT", "DarkMeow"})
public final class EnumTargetAllowStatus
extends Enum<EnumTargetAllowStatus> {
    public static final /* enum */ EnumTargetAllowStatus NONE = new EnumTargetAllowStatus();
    public static final /* enum */ EnumTargetAllowStatus ONLY_RENDER = new EnumTargetAllowStatus();
    public static final /* enum */ EnumTargetAllowStatus COMBAT = new EnumTargetAllowStatus();
    private static final /* synthetic */ EnumTargetAllowStatus[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static EnumTargetAllowStatus[] values() {
        return (EnumTargetAllowStatus[])$VALUES.clone();
    }

    public static EnumTargetAllowStatus valueOf(String value) {
        return Enum.valueOf(EnumTargetAllowStatus.class, value);
    }

    @NotNull
    public static EnumEntries<EnumTargetAllowStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = enumTargetAllowStatusArray = new EnumTargetAllowStatus[]{EnumTargetAllowStatus.NONE, EnumTargetAllowStatus.ONLY_RENDER, EnumTargetAllowStatus.COMBAT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

