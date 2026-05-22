/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.rotations;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.KillAuraRotation;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.value.impl.FloatRangeValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.darkmeow.darkmeow.utils.movement.RotationUtils;
import net.darkmeow.darkmeow.utils.movement.rotation.aabb_to_vec.AABBToVecModeClosest;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/rotations/KillAuraRotationCloset;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraRotation;", "<init>", "()V", "turnSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue;", "shirkValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "apply", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "entity", "Lnet/minecraft/entity/Entity;", "DarkMeow"})
public final class KillAuraRotationCloset
extends KillAuraRotation {
    @JvmField
    @NotNull
    public final FloatRangeValue turnSpeedValue = new FloatRangeValue("TurnSpeed", (ClosedRange<Float>)RangesKt.rangeTo(180.0f, 180.0f), (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 180.0f));
    @JvmField
    @NotNull
    public final FloatValue shirkValue = new FloatValue("Shirk", 0.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 1.0f));

    public KillAuraRotationCloset() {
        super("Closet");
    }

    @Override
    @Nullable
    public Rotation apply(@NotNull EntityPlayerSP player, @NotNull Entity entity) {
        Rotation rotation;
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Rotation rotation2 = RotationUtils.getRotationEntity$default(RotationUtils.INSTANCE, (Entity)player, entity, new AABBToVecModeClosest(((Number)this.shirkValue.get()).floatValue()), null, 4, null);
        if (rotation2 != null) {
            Rotation rotation3 = rotation2;
            boolean bl2 = false;
            rotation = net.ccbluex.liquidbounce.handler.rotation.utils.RotationUtils.INSTANCE.limitAngleChange(DarkMeow.INSTANCE.getRotationManager().serverRotation, rotation3, this.turnSpeedValue.random());
        } else {
            rotation = null;
        }
        return rotation;
    }
}

