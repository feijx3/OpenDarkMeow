/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.manager.inventory;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.manager.inventory.ContainerManager;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2={"Lnet/darkmeow/darkmeow/manager/inventory/InventoryManager;", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "getSystem", "()Lnet/ccbluex/liquidbounce/DarkMeow;", "containerManager", "Lnet/darkmeow/darkmeow/manager/inventory/ContainerManager;", "getContainerManager", "()Lnet/darkmeow/darkmeow/manager/inventory/ContainerManager;", "currentSpoofSlot", "", "Ljava/lang/Integer;", "heldItemMainHand", "Lnet/minecraft/item/ItemStack;", "getHeldItemMainHand", "()Lnet/minecraft/item/ItemStack;", "heldItemOffHand", "getHeldItemOffHand", "containerIsOpen", "", "Companion", "DarkMeow"})
public final class InventoryManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final DarkMeow system;
    @NotNull
    private final ContainerManager containerManager;
    @JvmField
    @Nullable
    public Integer currentSpoofSlot;
    public static final int FAKE_CONTAINER = -999;

    public InventoryManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        this.system = system;
        this.containerManager = new ContainerManager();
    }

    @NotNull
    public final DarkMeow getSystem() {
        return this.system;
    }

    @NotNull
    public final ContainerManager getContainerManager() {
        return this.containerManager;
    }

    @NotNull
    public final ItemStack getHeldItemMainHand() {
        EntityPlayerSP entityPlayerSP = DarkMeow.mc.field_71439_g;
        if (entityPlayerSP == null || (entityPlayerSP = entityPlayerSP.func_184586_b(EnumHand.MAIN_HAND)) == null) {
            ItemStack itemStack = ItemStack.field_190927_a;
            entityPlayerSP = itemStack;
            Intrinsics.checkNotNullExpressionValue(itemStack, "EMPTY");
        }
        return entityPlayerSP;
    }

    @NotNull
    public final ItemStack getHeldItemOffHand() {
        EntityPlayerSP entityPlayerSP = DarkMeow.mc.field_71439_g;
        if (entityPlayerSP == null || (entityPlayerSP = entityPlayerSP.func_184586_b(EnumHand.OFF_HAND)) == null) {
            ItemStack itemStack = ItemStack.field_190927_a;
            entityPlayerSP = itemStack;
            Intrinsics.checkNotNullExpressionValue(itemStack, "EMPTY");
        }
        return entityPlayerSP;
    }

    @Deprecated(message="L")
    public final boolean containerIsOpen() {
        return this.containerManager.getScreen() != null;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/darkmeow/darkmeow/manager/inventory/InventoryManager$Companion;", "", "<init>", "()V", "FAKE_CONTAINER", "", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

