/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/enums/EnumPreTakenAction;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL_CURRENT_SLOT", "CANCEL_CURRENT_TASK", "CANCEL_CURRENT_TASK_AND_CLOSE", "DarkMeow"})
public final class EnumPreTakenAction
extends Enum<EnumPreTakenAction> {
    public static final /* enum */ EnumPreTakenAction CANCEL_CURRENT_SLOT = new EnumPreTakenAction();
    public static final /* enum */ EnumPreTakenAction CANCEL_CURRENT_TASK = new EnumPreTakenAction();
    public static final /* enum */ EnumPreTakenAction CANCEL_CURRENT_TASK_AND_CLOSE = new EnumPreTakenAction();
    private static final /* synthetic */ EnumPreTakenAction[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static EnumPreTakenAction[] values() {
        return (EnumPreTakenAction[])$VALUES.clone();
    }

    public static EnumPreTakenAction valueOf(String value) {
        return Enum.valueOf(EnumPreTakenAction.class, value);
    }

    @NotNull
    public static EnumEntries<EnumPreTakenAction> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = enumPreTakenActionArray = new EnumPreTakenAction[]{EnumPreTakenAction.CANCEL_CURRENT_SLOT, EnumPreTakenAction.CANCEL_CURRENT_TASK, EnumPreTakenAction.CANCEL_CURRENT_TASK_AND_CLOSE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

