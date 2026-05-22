/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.InvManagerModuleSortSlot;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotPlayerInventory;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.modules.sort_slot.InvManagerSortSlotResult;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotMode;", "", "modeName", "", "sort", "", "<init>", "(Ljava/lang/String;I)V", "getModeName", "()Ljava/lang/String;", "getSort", "()I", "valuePrefix", "getValuePrefix", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleSortSlot;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleSortSlot;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/InvManagerModuleSortSlot;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "keepAll", "", "getKeepAll", "()Z", "searchSlot", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotResult;", "inventory", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/modules/sort_slot/InvManagerSortSlotPlayerInventory;", "DarkMeow"})
public abstract class InvManagerSortSlotMode {
    @NotNull
    private final String modeName;
    private final int sort;
    @NotNull
    private final String valuePrefix;
    public InvManagerModuleSortSlot instance;
    private final boolean keepAll;

    public InvManagerSortSlotMode(@NotNull String modeName, int sort) {
        Intrinsics.checkNotNullParameter(modeName, "modeName");
        this.modeName = modeName;
        this.sort = sort;
        this.valuePrefix = "SortSlot" + this.modeName + '-';
    }

    public /* synthetic */ InvManagerSortSlotMode(String string, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            n2 = 10;
        }
        this(string, n2);
    }

    @NotNull
    public final String getModeName() {
        return this.modeName;
    }

    public final int getSort() {
        return this.sort;
    }

    @NotNull
    protected final String getValuePrefix() {
        return this.valuePrefix;
    }

    @NotNull
    public final InvManagerModuleSortSlot getInstance() {
        InvManagerModuleSortSlot invManagerModuleSortSlot = this.instance;
        if (invManagerModuleSortSlot != null) {
            return invManagerModuleSortSlot;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull InvManagerModuleSortSlot invManagerModuleSortSlot) {
        Intrinsics.checkNotNullParameter(invManagerModuleSortSlot, "<set-?>");
        this.instance = invManagerModuleSortSlot;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public boolean getKeepAll() {
        return this.keepAll;
    }

    @NotNull
    public abstract InvManagerSortSlotResult searchSlot(@NotNull InvManagerSortSlotPlayerInventory var1);
}

