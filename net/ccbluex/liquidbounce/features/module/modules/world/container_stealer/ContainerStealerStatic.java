/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiHopper
 *  net.minecraft.client.gui.inventory.GuiBrewingStand
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiDispenser
 *  net.minecraft.client.gui.inventory.GuiFurnace
 *  net.minecraft.client.gui.inventory.GuiShulkerBox
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiShulkerBox;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000b*\u00020\u0007R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerStatic;", "", "<init>", "()V", "allowStorageClasses", "", "Ljava/lang/Class;", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "getAllowStorageClasses", "()Ljava/util/Set;", "allowStealer", "", "DarkMeow"})
public final class ContainerStealerStatic {
    @NotNull
    public static final ContainerStealerStatic INSTANCE = new ContainerStealerStatic();
    @NotNull
    private static final Set<Class<? extends GuiContainer>> allowStorageClasses;

    private ContainerStealerStatic() {
    }

    @NotNull
    public final Set<Class<? extends GuiContainer>> getAllowStorageClasses() {
        return allowStorageClasses;
    }

    public final boolean allowStealer(@NotNull GuiContainer $this$allowStealer) {
        Intrinsics.checkNotNullParameter($this$allowStealer, "<this>");
        return allowStorageClasses.contains($this$allowStealer.getClass());
    }

    static {
        Class[] classArray = new Class[]{GuiChest.class, GuiFurnace.class, GuiBrewingStand.class, GuiShulkerBox.class, GuiHopper.class, GuiDispenser.class};
        allowStorageClasses = SetsKt.setOf(classArray);
    }
}

