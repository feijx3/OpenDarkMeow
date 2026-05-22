/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.extend;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.KillAuraExtend;
import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendStopSprint;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraExtend;", "<init>", "()V", "tickValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onAttackPre", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
public final class KillAuraExtendStopSprint
extends KillAuraExtend {
    @JvmField
    @NotNull
    public final IntegerValue tickValue = new IntegerValue("Tick", 4, new IntRange(1, 20));

    public KillAuraExtendStopSprint() {
        super("StopSprint", false);
    }

    @Override
    public boolean onAttackPre(@NotNull SafeListenerBase $this$onAttackPre, @NotNull EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter($this$onAttackPre, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Sprint.lockNoSprint(this.getInstance().getName() + '-' + this.getName(), (Integer)this.tickValue.get());
        return !$this$onAttackPre.getPlayer().func_70051_ag();
    }
}

