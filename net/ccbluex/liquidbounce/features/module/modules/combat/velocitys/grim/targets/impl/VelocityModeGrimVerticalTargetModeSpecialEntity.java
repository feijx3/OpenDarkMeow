/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.entity.projectile.EntitySnowball
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets.impl;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets.VelocityModeGrimVerticalTargetMode;
import net.ccbluex.liquidbounce.injection.access.entity.AccessorEntityArrow;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntitySnowball;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeSpecialEntity;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/VelocityModeGrimVerticalTargetMode;", "<init>", "()V", "findTarget", "Lnet/minecraft/entity/Entity;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVelocityModeGrimVerticalTargetModeSpecialEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VelocityModeGrimVerticalTargetModeSpecialEntity.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeSpecialEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,37:1\n295#2:38\n296#2:41\n12637#3,2:39\n*S KotlinDebug\n*F\n+ 1 VelocityModeGrimVerticalTargetModeSpecialEntity.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeSpecialEntity\n*L\n19#1:38\n19#1:41\n34#1:39,2\n*E\n"})
public final class VelocityModeGrimVerticalTargetModeSpecialEntity
extends VelocityModeGrimVerticalTargetMode {
    public VelocityModeGrimVerticalTargetModeSpecialEntity() {
        super("SpecialEntity", 2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Entity findTarget(@NotNull EntityPlayerSP player) {
        Object v2;
        block3: {
            Intrinsics.checkNotNullParameter(player, "player");
            List list = player.field_70170_p.field_72996_f;
            Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
            Iterable $this$firstOrNull$iv = list;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                boolean bl2;
                block2: {
                    void $this$any$iv;
                    Entity entity = (Entity)element$iv;
                    boolean bl3 = false;
                    Boolean[] booleanArray = new Boolean[]{entity instanceof AccessorEntityArrow && player.func_70032_d(entity) > 6.0f, entity instanceof EntityItemFrame, entity instanceof EntityMinecart, entity instanceof EntityBoat, entity instanceof EntityTNTPrimed, entity instanceof EntitySnowball, entity instanceof EntityEgg, entity instanceof EntityFishHook, entity instanceof EntityExpBottle, entity instanceof EntityFireball};
                    boolean $i$f$any = false;
                    for (void element$iv2 : $this$any$iv) {
                        boolean it = element$iv2.booleanValue();
                        boolean bl4 = false;
                        if (!it) continue;
                        bl2 = true;
                        break block2;
                    }
                    bl2 = false;
                }
                if (!bl2) continue;
                v2 = element$iv;
                break block3;
            }
            v2 = null;
        }
        return v2;
    }
}

