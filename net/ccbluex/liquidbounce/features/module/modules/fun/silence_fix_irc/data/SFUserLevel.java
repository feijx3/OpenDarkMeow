/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserLevel;", "", "color", "", "defaultRank", "priority", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getColor", "()Ljava/lang/String;", "getDefaultRank", "getPriority", "()I", "Free", "LittleFans", "SuperFans", "FreeKiller", "Paid", "Administrator", "DarkMeow"})
public final class SFUserLevel
extends Enum<SFUserLevel> {
    @NotNull
    private final String color;
    @NotNull
    private final String defaultRank;
    private final int priority;
    public static final /* enum */ SFUserLevel Free = new SFUserLevel("\u00a7a", "\u00a7a\u516c\u76ca", 0);
    public static final /* enum */ SFUserLevel LittleFans = new SFUserLevel("\u00a7d", "\u00a7d\u5c0f\u7c89\u4e1d", 0);
    public static final /* enum */ SFUserLevel SuperFans = new SFUserLevel("\u00a7d", "\u00a7d\u5927\u7c89\u4e1d", 0);
    public static final /* enum */ SFUserLevel FreeKiller = new SFUserLevel("\u00a74\u00a7l", "\u00a74\u00a7l\u516c\u76ca\u7c89\u4e1d\u6740\u624b", 1);
    public static final /* enum */ SFUserLevel Paid = new SFUserLevel("\u00a7e", "\u00a7e\u5185\u90e8", 2);
    public static final /* enum */ SFUserLevel Administrator = new SFUserLevel("\u00a7c", "\u00a7c\u7ba1\u7406\u5458", 999);
    private static final /* synthetic */ SFUserLevel[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private SFUserLevel(String color, String defaultRank, int priority) {
        this.color = color;
        this.defaultRank = defaultRank;
        this.priority = priority;
    }

    @NotNull
    public final String getColor() {
        return this.color;
    }

    @NotNull
    public final String getDefaultRank() {
        return this.defaultRank;
    }

    public final int getPriority() {
        return this.priority;
    }

    public static SFUserLevel[] values() {
        return (SFUserLevel[])$VALUES.clone();
    }

    public static SFUserLevel valueOf(String value) {
        return Enum.valueOf(SFUserLevel.class, value);
    }

    @NotNull
    public static EnumEntries<SFUserLevel> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = sFUserLevelArray = new SFUserLevel[]{SFUserLevel.Free, SFUserLevel.LittleFans, SFUserLevel.SuperFans, SFUserLevel.FreeKiller, SFUserLevel.Paid, SFUserLevel.Administrator};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

