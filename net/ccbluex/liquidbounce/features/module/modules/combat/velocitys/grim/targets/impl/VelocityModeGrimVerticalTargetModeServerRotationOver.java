/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets.VelocityModeGrimVerticalTargetMode;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeServerRotationOver;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/VelocityModeGrimVerticalTargetMode;", "<init>", "()V", "findTarget", "Lnet/minecraft/entity/Entity;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVelocityModeGrimVerticalTargetModeServerRotationOver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VelocityModeGrimVerticalTargetModeServerRotationOver.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeServerRotationOver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class VelocityModeGrimVerticalTargetModeServerRotationOver
extends VelocityModeGrimVerticalTargetMode {
    public VelocityModeGrimVerticalTargetModeServerRotationOver() {
        super("ServerRotationOver", 1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    @Nullable
    public Entity findTarget(@NotNull EntityPlayerSP player) {
        RayTraceResult rayTraceResult;
        RayTraceResult rayTraceResult2;
        RayTraceResult rayTraceResult3;
        Intrinsics.checkNotNullParameter(player, "player");
        RayTraceResult it = rayTraceResult3 = ExtendEntityPlayerSP.INSTANCE.getMc((EntityPlayerSP)player).field_71476_x;
        boolean bl2 = false;
        if (DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck()) return null;
        boolean bl3 = true;
        if (!bl3) return null;
        RayTraceResult rayTraceResult4 = rayTraceResult3;
        RayTraceResult rayTraceResult5 = rayTraceResult4;
        if (rayTraceResult5 == null) return null;
        RayTraceResult it2 = rayTraceResult2 = rayTraceResult5;
        boolean bl4 = false;
        if (it2.field_72313_a != RayTraceResult.Type.ENTITY) return null;
        boolean bl5 = true;
        if (!bl5) return null;
        RayTraceResult rayTraceResult6 = rayTraceResult2;
        rayTraceResult3 = rayTraceResult6;
        if (rayTraceResult3 == null) return null;
        rayTraceResult2 = rayTraceResult3.field_72308_g;
        if (rayTraceResult2 == null) return null;
        RayTraceResult it3 = rayTraceResult = rayTraceResult2;
        boolean bl6 = false;
        if (!(it3 instanceof EntityPlayer)) return null;
        RayTraceResult rayTraceResult7 = rayTraceResult;
        RayTraceResult rayTraceResult8 = rayTraceResult7;
        if (rayTraceResult8 == null) return null;
        it3 = rayTraceResult = rayTraceResult8;
        boolean bl7 = false;
        if (!it3.func_70089_S()) return null;
        RayTraceResult rayTraceResult9 = rayTraceResult;
        return rayTraceResult9;
    }
}

