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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/enums/EnumPreStealerAction;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL_CURRENT_TASK", "CANCEL_CURRENT_TASK_AND_CLOSE", "DarkMeow"})
public final class EnumPreStealerAction
extends Enum<EnumPreStealerAction> {
    public static final /* enum */ EnumPreStealerAction CANCEL_CURRENT_TASK = new EnumPreStealerAction();
    public static final /* enum */ EnumPreStealerAction CANCEL_CURRENT_TASK_AND_CLOSE = new EnumPreStealerAction();
    private static final /* synthetic */ EnumPreStealerAction[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static EnumPreStealerAction[] values() {
        return (EnumPreStealerAction[])$VALUES.clone();
    }

    public static EnumPreStealerAction valueOf(String value) {
        return Enum.valueOf(EnumPreStealerAction.class, value);
    }

    @NotNull
    public static EnumEntries<EnumPreStealerAction> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = enumPreStealerActionArray = new EnumPreStealerAction[]{EnumPreStealerAction.CANCEL_CURRENT_TASK, EnumPreStealerAction.CANCEL_CURRENT_TASK_AND_CLOSE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

