/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "", "displayName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "COMBAT", "PLAYER", "MOVEMENT", "RENDER", "WORLD", "MISC", "NETWORK", "EXPLOIT", "CLIENT", "FUN", "namee", "getNamee", "DarkMeow"})
public final class ModuleCategory
extends Enum<ModuleCategory> {
    @NotNull
    private final String displayName;
    @Nullable
    private final String namee;
    public static final /* enum */ ModuleCategory COMBAT = new ModuleCategory("Combat");
    public static final /* enum */ ModuleCategory PLAYER = new ModuleCategory("Player");
    public static final /* enum */ ModuleCategory MOVEMENT = new ModuleCategory("Movement");
    public static final /* enum */ ModuleCategory RENDER = new ModuleCategory("Render");
    public static final /* enum */ ModuleCategory WORLD = new ModuleCategory("World");
    public static final /* enum */ ModuleCategory MISC = new ModuleCategory("Misc");
    public static final /* enum */ ModuleCategory NETWORK = new ModuleCategory("Network");
    public static final /* enum */ ModuleCategory EXPLOIT = new ModuleCategory("Exploit");
    public static final /* enum */ ModuleCategory CLIENT = new ModuleCategory("Client");
    public static final /* enum */ ModuleCategory FUN = new ModuleCategory("Fun");
    private static final /* synthetic */ ModuleCategory[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ModuleCategory(String displayName) {
        this.displayName = displayName;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final String getNamee() {
        return this.namee;
    }

    public static ModuleCategory[] values() {
        return (ModuleCategory[])$VALUES.clone();
    }

    public static ModuleCategory valueOf(String value) {
        return Enum.valueOf(ModuleCategory.class, value);
    }

    @NotNull
    public static EnumEntries<ModuleCategory> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = moduleCategoryArray = new ModuleCategory[]{ModuleCategory.COMBAT, ModuleCategory.PLAYER, ModuleCategory.MOVEMENT, ModuleCategory.RENDER, ModuleCategory.WORLD, ModuleCategory.MISC, ModuleCategory.NETWORK, ModuleCategory.EXPLOIT, ModuleCategory.CLIENT, ModuleCategory.FUN};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

