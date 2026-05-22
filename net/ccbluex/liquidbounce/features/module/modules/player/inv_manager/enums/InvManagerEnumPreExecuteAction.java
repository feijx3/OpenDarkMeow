/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/enums/InvManagerEnumPreExecuteAction;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL", "DarkMeow"})
public final class InvManagerEnumPreExecuteAction
extends Enum<InvManagerEnumPreExecuteAction> {
    public static final /* enum */ InvManagerEnumPreExecuteAction CANCEL = new InvManagerEnumPreExecuteAction();
    private static final /* synthetic */ InvManagerEnumPreExecuteAction[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static InvManagerEnumPreExecuteAction[] values() {
        return (InvManagerEnumPreExecuteAction[])$VALUES.clone();
    }

    public static InvManagerEnumPreExecuteAction valueOf(String value) {
        return Enum.valueOf(InvManagerEnumPreExecuteAction.class, value);
    }

    @NotNull
    public static EnumEntries<InvManagerEnumPreExecuteAction> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = invManagerEnumPreExecuteActionArray = new InvManagerEnumPreExecuteAction[]{InvManagerEnumPreExecuteAction.CANCEL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

