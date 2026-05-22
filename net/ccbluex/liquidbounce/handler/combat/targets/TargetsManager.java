/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.combat.targets;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.client.UpdateSelectTargetStatusEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.handler.combat.CombatManager;
import net.ccbluex.liquidbounce.handler.combat.targets.CacheTargetInfo;
import net.ccbluex.liquidbounce.handler.combat.targets.EnumTargetAllowStatus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0007J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R,\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/handler/combat/targets/TargetsManager;", "", "manager", "Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "cacheTargets", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/handler/combat/targets/CacheTargetInfo;", "Lkotlin/collections/HashMap;", "clearCache", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "lastUpdateId", "", "isSelected", "", "target", "Lnet/minecraft/entity/Entity;", "checkAttack", "noCache", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nTargetsManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TargetsManager.kt\nnet/ccbluex/liquidbounce/handler/combat/targets/TargetsManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,91:1\n1#2:92\n382#3,7:93\n*S KotlinDebug\n*F\n+ 1 TargetsManager.kt\nnet/ccbluex/liquidbounce/handler/combat/targets/TargetsManager\n*L\n75#1:93,7\n*E\n"})
public final class TargetsManager {
    @NotNull
    private final CombatManager manager;
    @JvmField
    @NotNull
    public final HashMap<Integer, CacheTargetInfo> cacheTargets;
    @JvmField
    public long lastUpdateId;

    public TargetsManager(@NotNull CombatManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.cacheTargets = new HashMap();
    }

    @NotNull
    public final CombatManager getManager() {
        return this.manager;
    }

    public final void clearCache() {
        this.cacheTargets.clear();
    }

    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getUpdateId() > this.lastUpdateId + (long)10) {
            this.lastUpdateId = event.getUpdateId();
            this.clearCache();
        }
    }

    @JvmOverloads
    public final boolean isSelected(@NotNull Entity target, boolean checkAttack, boolean noCache) {
        Intrinsics.checkNotNullParameter(target, "target");
        EntityLivingBase entityLivingBase = target instanceof EntityLivingBase ? (EntityLivingBase)target : null;
        if (entityLivingBase == null) {
            return false;
        }
        return this.isSelected(entityLivingBase, checkAttack, noCache);
    }

    public static /* synthetic */ boolean isSelected$default(TargetsManager targetsManager, Entity entity, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            bl3 = false;
        }
        return targetsManager.isSelected(entity, bl2, bl3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmOverloads
    public final boolean isSelected(@NotNull EntityLivingBase target, boolean checkAttack, boolean noCache) {
        HashMap<Integer, CacheTargetInfo> hashMap;
        Intrinsics.checkNotNullParameter(target, "target");
        Object object = this.cacheTargets;
        HashMap<Integer, CacheTargetInfo> it = object;
        boolean bl2 = false;
        HashMap<Integer, CacheTargetInfo> hashMap2 = hashMap = !noCache ? object : null;
        if (hashMap != null && (object = hashMap.get(target.func_145782_y())) != null) {
            boolean bl3;
            Object it2 = object;
            boolean bl4 = false;
            boolean bl5 = checkAttack;
            if (bl5) {
                bl3 = ((CacheTargetInfo)it2).getAllowAttack();
                return bl3;
            } else {
                if (bl5) throw new NoWhenBranchMatchedException();
                bl3 = ((CacheTargetInfo)it2).getAllowNormal();
            }
            return bl3;
        } else {
            Object object2;
            UpdateSelectTargetStatusEvent updateSelectTargetStatusEvent;
            UpdateSelectTargetStatusEvent it3 = updateSelectTargetStatusEvent = new UpdateSelectTargetStatusEvent(target);
            boolean bl6 = false;
            EventManager.callEvent$default(this.manager.getSystem().getEventManager(), it3, null, 2, null);
            it3 = updateSelectTargetStatusEvent;
            boolean bl7 = false;
            Map map = this.cacheTargets;
            Integer key$iv = it3.getTarget().func_145782_y();
            boolean $i$f$getOrPut = false;
            Object value$iv = map.get(key$iv);
            if (value$iv == null) {
                boolean bl8 = false;
                CacheTargetInfo answer$iv = new CacheTargetInfo(false, false, 3, null);
                map.put(key$iv, answer$iv);
                object2 = answer$iv;
            } else {
                object2 = value$iv;
            }
            Object v2 = object2;
            CacheTargetInfo $this$isSelected_u24lambda_u245_u24lambda_u244 = (CacheTargetInfo)v2;
            boolean bl9 = false;
            EnumTargetAllowStatus state = (EnumTargetAllowStatus)((Object)it3.getReturnValue());
            $this$isSelected_u24lambda_u245_u24lambda_u244.setAllowAttack(state == EnumTargetAllowStatus.COMBAT);
            $this$isSelected_u24lambda_u245_u24lambda_u244.setAllowNormal(state != EnumTargetAllowStatus.NONE);
            it3 = updateSelectTargetStatusEvent;
            boolean bl10 = false;
            boolean bl11 = checkAttack;
            if (bl11) {
                if (it3.getReturnValue() != EnumTargetAllowStatus.COMBAT) return false;
                return true;
            }
            if (bl11) throw new NoWhenBranchMatchedException();
            if (it3.getReturnValue() == EnumTargetAllowStatus.NONE) return false;
            return true;
        }
    }

    public static /* synthetic */ boolean isSelected$default(TargetsManager targetsManager, EntityLivingBase entityLivingBase, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            bl3 = false;
        }
        return targetsManager.isSelected(entityLivingBase, bl2, bl3);
    }

    @JvmOverloads
    public final boolean isSelected(@NotNull Entity target, boolean checkAttack) {
        Intrinsics.checkNotNullParameter(target, "target");
        return TargetsManager.isSelected$default(this, target, checkAttack, false, 4, null);
    }

    @JvmOverloads
    public final boolean isSelected(@NotNull Entity target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return TargetsManager.isSelected$default(this, target, false, false, 6, null);
    }

    @JvmOverloads
    public final boolean isSelected(@NotNull EntityLivingBase target, boolean checkAttack) {
        Intrinsics.checkNotNullParameter(target, "target");
        return TargetsManager.isSelected$default(this, target, checkAttack, false, 4, null);
    }

    @JvmOverloads
    public final boolean isSelected(@NotNull EntityLivingBase target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return TargetsManager.isSelected$default(this, target, false, false, 6, null);
    }
}

