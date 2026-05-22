/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.extend;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerExtend;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.enums.EnumPreTakenAction;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendDelay;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerExtend;", "<init>", "()V", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "delay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getDelay", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "preTaken", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/enums/EnumPreTakenAction;", "screen", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
public final class ContainerStealerExtendDelay
extends ContainerStealerExtend {
    @JvmField
    @NotNull
    public final IntegerRangeValue delayValue = new IntegerRangeValue("Delay", new IntRange(200, 200), new IntRange(0, 1000));
    @NotNull
    private final MSDelay delay = new MSDelay();

    public ContainerStealerExtendDelay() {
        super("Delay", true);
    }

    @NotNull
    public final MSDelay getDelay() {
        return this.delay;
    }

    @Override
    @Nullable
    public EnumPreTakenAction preTaken(@NotNull GuiContainer screen, @NotNull ItemStack stack) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(stack, "stack");
        if (MSDelay.hasPassed$default(this.delay, 0L, 1, null)) {
            this.delay.reset(this.delayValue);
            return null;
        }
        return EnumPreTakenAction.CANCEL_CURRENT_TASK;
    }
}

