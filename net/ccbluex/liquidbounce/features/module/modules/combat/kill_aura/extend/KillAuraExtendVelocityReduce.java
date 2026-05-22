/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.KillAuraExtend;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendVelocityReduce;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraExtend;", "<init>", "()V", "onAttackPost", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
public final class KillAuraExtendVelocityReduce
extends KillAuraExtend {
    public KillAuraExtendVelocityReduce() {
        super("VelocityReduce", false);
    }

    @Override
    public void onAttackPost(@NotNull SafeListenerBase $this$onAttackPost, @NotNull EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter($this$onAttackPost, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        $this$onAttackPost.getPlayer().func_71059_n((Entity)entity);
    }
}

