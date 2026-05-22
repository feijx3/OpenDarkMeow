/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.eagles.checks;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.movement.eagles.EagleCheck;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/eagles/checks/EagleCheckPitch;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/eagles/EagleCheck;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "allowEagle", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
public final class EagleCheckPitch
extends EagleCheck {
    @JvmField
    @NotNull
    public final IntegerRangeValue rangeValue = new IntegerRangeValue("Range", new IntRange(60, 90), new IntRange(-90, 90));

    public EagleCheckPitch() {
        super("Pitch");
    }

    @Override
    public boolean allowEagle(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return ((ClosedRange)this.rangeValue.get()).contains((int)player.field_70125_A);
    }
}

