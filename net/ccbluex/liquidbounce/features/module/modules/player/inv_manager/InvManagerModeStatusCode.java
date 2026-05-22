/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModeStatusCode;", "", "doAny", "", "isCancel", "<init>", "(Ljava/lang/String;IZZ)V", "getDoAny", "()Z", "CANCEL_IGNORED", "CANCEL_DONE", "IGNORED", "DONE", "Companion", "DarkMeow"})
public final class InvManagerModeStatusCode
extends Enum<InvManagerModeStatusCode> {
    @NotNull
    public static final Companion Companion;
    private final boolean doAny;
    private final boolean isCancel;
    public static final /* enum */ InvManagerModeStatusCode CANCEL_IGNORED;
    public static final /* enum */ InvManagerModeStatusCode CANCEL_DONE;
    public static final /* enum */ InvManagerModeStatusCode IGNORED;
    public static final /* enum */ InvManagerModeStatusCode DONE;
    private static final /* synthetic */ InvManagerModeStatusCode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private InvManagerModeStatusCode(boolean doAny, boolean isCancel) {
        this.doAny = doAny;
        this.isCancel = isCancel;
    }

    public final boolean getDoAny() {
        return this.doAny;
    }

    public final boolean isCancel() {
        return this.isCancel;
    }

    public static InvManagerModeStatusCode[] values() {
        return (InvManagerModeStatusCode[])$VALUES.clone();
    }

    public static InvManagerModeStatusCode valueOf(String value) {
        return Enum.valueOf(InvManagerModeStatusCode.class, value);
    }

    @NotNull
    public static EnumEntries<InvManagerModeStatusCode> getEntries() {
        return $ENTRIES;
    }

    static {
        CANCEL_IGNORED = new InvManagerModeStatusCode(false, true);
        CANCEL_DONE = new InvManagerModeStatusCode(true, true);
        IGNORED = new InvManagerModeStatusCode(false, false);
        DONE = new InvManagerModeStatusCode(true, false);
        $VALUES = invManagerModeStatusCodeArray = new InvManagerModeStatusCode[]{InvManagerModeStatusCode.CANCEL_IGNORED, InvManagerModeStatusCode.CANCEL_DONE, InvManagerModeStatusCode.IGNORED, InvManagerModeStatusCode.DONE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModeStatusCode$Companion;", "", "<init>", "()V", "fromBooleanNormal", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModeStatusCode;", "value", "", "fromBooleanCancel", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final InvManagerModeStatusCode fromBooleanNormal(boolean value) {
            return value ? DONE : IGNORED;
        }

        @NotNull
        public final InvManagerModeStatusCode fromBooleanCancel(boolean value) {
            return value ? CANCEL_DONE : CANCEL_IGNORED;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

