/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.kill_effects.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.render.kill_effects.KillEffectMode;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/impl/KillEffectModeLighting;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/KillEffectMode;", "<init>", "()V", "soundValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "render", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
public final class KillEffectModeLighting
extends KillEffectMode {
    @JvmField
    @NotNull
    public final BoolValue soundValue = new BoolValue("Sound", true);

    public KillEffectModeLighting() {
        super("Lighting");
    }

    @Override
    public void render(@NotNull EntityPlayerSP player, @NotNull WorldClient world, @NotNull EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(world, "world");
        Intrinsics.checkNotNullParameter(entity, "entity");
        world.func_72942_c((Entity)new EntityLightningBolt((World)world, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, true));
        if (((Boolean)this.soundValue.get()).booleanValue()) {
            world.func_184148_a((EntityPlayer)player, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, SoundEvents.field_187752_dd, SoundCategory.WEATHER, 2.0f, 0.5f);
        }
    }
}

