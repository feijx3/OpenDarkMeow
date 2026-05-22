/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.MovementInput
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.handler.rotation.RotationManagerApply;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.MovementMode;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeStrict;
import net.darkmeow.darkmeow.utils.movement.MovementUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MovementInput;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/impl/MovementModeSilent;", "Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;", "<init>", "()V", "apply", "", "base", "Lnet/ccbluex/liquidbounce/handler/rotation/RotationManagerApply;", "task", "Lnet/ccbluex/liquidbounce/handler/rotation/data/RotationTask;", "movementInput", "Lnet/minecraft/util/MovementInput;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
public final class MovementModeSilent
extends MovementMode {
    @NotNull
    public static final MovementModeSilent INSTANCE = new MovementModeSilent();

    private MovementModeSilent() {
        super("Silent");
    }

    @Override
    public void apply(@NotNull RotationManagerApply base, @NotNull RotationTask task, @NotNull MovementInput movementInput, @NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(movementInput, "movementInput");
        Intrinsics.checkNotNullParameter(player, "player");
        MovementModeStrict.INSTANCE.apply(base, task, movementInput, player);
        MovementUtils.INSTANCE.applySilentRotationFix(movementInput, player.field_70177_z, task.getRotation().yaw);
    }
}

