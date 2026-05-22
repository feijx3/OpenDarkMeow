/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/UnfocusedCPU;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "unActiveFPSValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "unVisibleFPSValue", "unVisibleStopRenderRender", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "status", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/UnfocusedCPU$Status;", "Status", "DarkMeow"})
public final class UnfocusedCPU
extends Module {
    @NotNull
    public static final UnfocusedCPU INSTANCE = new UnfocusedCPU();
    @JvmField
    @NotNull
    public static final IntegerValue unActiveFPSValue = new IntegerValue("UnActiveFPS", 24, new IntRange(1, 60));
    @JvmField
    @NotNull
    public static final IntegerValue unVisibleFPSValue = new IntegerValue("UnVisibleFPS", 20, new IntRange(1, 60));
    @JvmField
    @NotNull
    public static final BoolValue unVisibleStopRenderRender = new BoolValue("UnVisibleStopRender", false);
    @JvmField
    @NotNull
    public static Status status = Status.NORMAL;

    private UnfocusedCPU() {
        super("UnfocusedCPU", ModuleCategory.MISC, null, null, 12, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/UnfocusedCPU$Status;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "UN_ACTIVE", "UN_VISIBLE", "DarkMeow"})
    public static final class Status
    extends Enum<Status> {
        public static final /* enum */ Status NORMAL = new Status();
        public static final /* enum */ Status UN_ACTIVE = new Status();
        public static final /* enum */ Status UN_VISIBLE = new Status();
        private static final /* synthetic */ Status[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Status[] values() {
            return (Status[])$VALUES.clone();
        }

        public static Status valueOf(String value) {
            return Enum.valueOf(Status.class, value);
        }

        @NotNull
        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = statusArray = new Status[]{Status.NORMAL, Status.UN_ACTIVE, Status.UN_VISIBLE};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

