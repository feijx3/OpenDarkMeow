/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets.impl;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets.VelocityModeGrimVerticalTargetMode;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeStuckAllows;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/VelocityModeGrimVerticalTargetMode;", "<init>", "()V", "onlyLastRayTraceValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "findTarget", "Lnet/minecraft/entity/Entity;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVelocityModeGrimVerticalTargetModeStuckAllows.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VelocityModeGrimVerticalTargetModeStuckAllows.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeStuckAllows\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,42:1\n1#2:43\n1761#3,3:44\n12434#4,2:47\n*S KotlinDebug\n*F\n+ 1 VelocityModeGrimVerticalTargetModeStuckAllows.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/impl/VelocityModeGrimVerticalTargetModeStuckAllows\n*L\n32#1:44,3\n36#1:47,2\n*E\n"})
public final class VelocityModeGrimVerticalTargetModeStuckAllows
extends VelocityModeGrimVerticalTargetMode {
    @JvmField
    @NotNull
    public final BoolValue onlyLastRayTraceValue = new BoolValue("OnlyLastRayTrace", true);

    public VelocityModeGrimVerticalTargetModeStuckAllows() {
        super("StuckAllows", 0);
    }

    @Override
    @Nullable
    public Entity findTarget(@NotNull EntityPlayerSP player) {
        Entity entity;
        EntityPlayerSP entityPlayerSP;
        EntityPlayerSP entityPlayerSP2;
        Intrinsics.checkNotNullParameter(player, "player");
        EntityPlayerSP it = entityPlayerSP2 = player;
        boolean bl2 = false;
        Object object = entityPlayerSP = DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() ? entityPlayerSP2 : null;
        if (entityPlayerSP != null) {
            Set<Entity> set;
            EntityPlayerSP player2 = entityPlayerSP;
            boolean bl3 = false;
            World world = player2.field_70170_p;
            entity = world != null && (set = WorldUtils.quickGetNearEntities(world, player2, 6.0f, arg_0 -> VelocityModeGrimVerticalTargetModeStuckAllows.findTarget$lambda$4$lambda$3(this, arg_0))) != null ? (Entity)CollectionsKt.firstOrNull((Iterable)set) : null;
        } else {
            entity = null;
        }
        return entity;
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean findTarget$lambda$4$lambda$3(VelocityModeGrimVerticalTargetModeStuckAllows this$0, Entity entity) {
        boolean bl2;
        block7: {
            boolean bl3;
            Intrinsics.checkNotNullParameter(entity, "entity");
            Boolean[] booleanArray = new Boolean[3];
            booleanArray[0] = entity.func_70089_S();
            booleanArray[1] = entity.field_70173_aa > 20;
            Boolean[] booleanArray2 = booleanArray;
            int n2 = 2;
            if (((Boolean)this$0.onlyLastRayTraceValue.get()).booleanValue()) {
                bl3 = DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().lastAllow == entity;
            } else {
                boolean bl4;
                Boolean[] booleanArray3;
                int n3;
                block6: {
                    void $this$any$iv;
                    Iterable iterable = DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows;
                    n3 = n2;
                    booleanArray3 = booleanArray2;
                    boolean $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl4 = false;
                    } else {
                        for (Object t2 : $this$any$iv) {
                            EntityLivingBase allowEntity = (EntityLivingBase)t2;
                            boolean bl5 = false;
                            if (!(allowEntity == entity)) continue;
                            bl4 = true;
                            break block6;
                        }
                        bl4 = false;
                    }
                }
                boolean bl5 = bl4;
                booleanArray2 = booleanArray3;
                n2 = n3;
                bl3 = bl5;
            }
            booleanArray2[n2] = bl3;
            Boolean[] $this$all$iv = booleanArray;
            boolean $i$f$all = false;
            for (Boolean bl6 : $this$all$iv) {
                boolean it = bl6;
                boolean bl7 = false;
                if (it) continue;
                bl2 = false;
                break block7;
            }
            bl2 = true;
        }
        return bl2;
    }
}

