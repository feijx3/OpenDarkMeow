/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ.games;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/games/GermGameCategory;", "", "displayName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "UNKNOWN", "BW", "SW", "FIGHT", "TEAM_FIGHT", "SURVIVE", "LEISURE", "DarkMeow"})
public final class GermGameCategory
extends Enum<GermGameCategory> {
    @NotNull
    private final String displayName;
    public static final /* enum */ GermGameCategory UNKNOWN = new GermGameCategory("\u672a\u77e5\u7c7b\u578b");
    public static final /* enum */ GermGameCategory BW = new GermGameCategory("\u8d77\u5e8a\u6218\u4e89");
    public static final /* enum */ GermGameCategory SW = new GermGameCategory("\u7a7a\u5c9b\u6218\u4e89");
    public static final /* enum */ GermGameCategory FIGHT = new GermGameCategory("\u4e2a\u4eba\u7ade\u6280");
    public static final /* enum */ GermGameCategory TEAM_FIGHT = new GermGameCategory("\u56e2\u961f\u7ade\u6280");
    public static final /* enum */ GermGameCategory SURVIVE = new GermGameCategory("\u751f\u5b58\u6e38\u620f");
    public static final /* enum */ GermGameCategory LEISURE = new GermGameCategory("\u4f11\u95f2\u6e38\u620f");
    private static final /* synthetic */ GermGameCategory[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private GermGameCategory(String displayName) {
        this.displayName = displayName;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    public static GermGameCategory[] values() {
        return (GermGameCategory[])$VALUES.clone();
    }

    public static GermGameCategory valueOf(String value) {
        return Enum.valueOf(GermGameCategory.class, value);
    }

    @NotNull
    public static EnumEntries<GermGameCategory> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = germGameCategoryArray = new GermGameCategory[]{GermGameCategory.UNKNOWN, GermGameCategory.BW, GermGameCategory.SW, GermGameCategory.FIGHT, GermGameCategory.TEAM_FIGHT, GermGameCategory.SURVIVE, GermGameCategory.LEISURE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

