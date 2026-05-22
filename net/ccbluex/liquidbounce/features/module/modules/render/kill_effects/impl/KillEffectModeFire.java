/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.play.server.SPacketParticles
 *  net.minecraft.util.EnumParticleTypes
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.kill_effects.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.render.kill_effects.KillEffectMode;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.util.EnumParticleTypes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/impl/KillEffectModeFire;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/KillEffectMode;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "countValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "render", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
public final class KillEffectModeFire
extends KillEffectMode {
    @JvmField
    @NotNull
    public final FloatValue speedValue = new FloatValue("Speed", 0.5f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 1.0f));
    @JvmField
    @NotNull
    public final IntegerValue countValue = new IntegerValue("Count", 500, new IntRange(10, 1000));

    public KillEffectModeFire() {
        super("Fire");
    }

    @Override
    public void render(@NotNull EntityPlayerSP player, @NotNull WorldClient world, @NotNull EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(world, "world");
        Intrinsics.checkNotNullParameter(entity, "entity");
        player.field_71174_a.func_147289_a(new SPacketParticles(EnumParticleTypes.FLAME, false, (float)entity.field_70165_t, (float)entity.field_70163_u, (float)entity.field_70161_v, 0.0f, 0.0f, 0.0f, ((Number)this.speedValue.get()).floatValue(), ((Number)this.countValue.get()).intValue(), new int[0]));
    }
}

