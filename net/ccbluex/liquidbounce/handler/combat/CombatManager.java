/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.combat;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import net.ccbluex.liquidbounce.handler.combat.CombatManagerListener;
import net.ccbluex.liquidbounce.handler.combat.LastAttackInfo;
import net.ccbluex.liquidbounce.handler.combat.allows.AllowAttackManager;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAnimationMode;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAttackEntityMode;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J4\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "targetsManager", "Lnet/ccbluex/liquidbounce/handler/combat/targets/TargetsManager;", "getTargetsManager", "()Lnet/ccbluex/liquidbounce/handler/combat/targets/TargetsManager;", "allowAttackManager", "Lnet/ccbluex/liquidbounce/handler/combat/allows/AllowAttackManager;", "getAllowAttackManager", "()Lnet/ccbluex/liquidbounce/handler/combat/allows/AllowAttackManager;", "listener", "Lnet/ccbluex/liquidbounce/handler/combat/CombatManagerListener;", "onReload", "", "lastAttack", "Lnet/ccbluex/liquidbounce/handler/combat/LastAttackInfo;", "getLastAttack", "()Lnet/ccbluex/liquidbounce/handler/combat/LastAttackInfo;", "setLastAttack", "(Lnet/ccbluex/liquidbounce/handler/combat/LastAttackInfo;)V", "attackEntity", "", "entity", "Lnet/minecraft/entity/Entity;", "animationMode", "Lnet/ccbluex/liquidbounce/utils/minecraft/enums/EnumAnimationMode;", "animationHand", "Lnet/minecraft/util/EnumHand;", "attackMode", "Lnet/ccbluex/liquidbounce/utils/minecraft/enums/EnumAttackEntityMode;", "noEvent", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCombatManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombatManager.kt\nnet/ccbluex/liquidbounce/handler/combat/CombatManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
public final class CombatManager
extends ManagerBase {
    @NotNull
    private final TargetsManager targetsManager;
    @NotNull
    private final AllowAttackManager allowAttackManager;
    @NotNull
    private final CombatManagerListener listener;
    @Nullable
    private LastAttackInfo lastAttack;

    public CombatManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.targetsManager = new TargetsManager(this);
        this.allowAttackManager = new AllowAttackManager(this);
        this.listener = new CombatManagerListener(this);
        EventManager.registerListener$default(system.getEventManager(), this.listener, false, false, 6, null);
        EventManager.registerListener$default(system.getEventManager(), this.allowAttackManager, false, false, 6, null);
    }

    @NotNull
    public final TargetsManager getTargetsManager() {
        return this.targetsManager;
    }

    @NotNull
    public final AllowAttackManager getAllowAttackManager() {
        return this.allowAttackManager;
    }

    @Override
    public void onReload() {
    }

    @Nullable
    public final LastAttackInfo getLastAttack() {
        return this.lastAttack;
    }

    public final void setLastAttack(@Nullable LastAttackInfo lastAttackInfo) {
        this.lastAttack = lastAttackInfo;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmOverloads
    public final boolean attackEntity(@NotNull Entity entity, @NotNull EnumAnimationMode animationMode, @NotNull EnumHand animationHand, @NotNull EnumAttackEntityMode attackMode, boolean noEvent) {
        boolean bl2;
        Entity entity2;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter((Object)animationMode, "animationMode");
        Intrinsics.checkNotNullParameter(animationHand, "animationHand");
        Intrinsics.checkNotNullParameter((Object)attackMode, "attackMode");
        Entity it = entity2 = entity;
        boolean bl3 = false;
        boolean bl4 = noEvent;
        if (bl4) {
            bl2 = true;
        } else {
            ControllerUseEntityAttackEvent controllerUseEntityAttackEvent;
            if (bl4) throw new NoWhenBranchMatchedException();
            EntityPlayerSP entityPlayerSP = this.mc.field_71439_g;
            if (entityPlayerSP == null) {
                return false;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            int n2 = 12;
            List list = null;
            boolean bl5 = false;
            Entity entity3 = entity;
            EntityPlayer entityPlayer = (EntityPlayer)entityPlayerSP;
            ControllerUseEntityAttackEvent it2 = controllerUseEntityAttackEvent = new ControllerUseEntityAttackEvent(entityPlayer, entity3, bl5, list, n2, defaultConstructorMarker);
            boolean bl6 = false;
            EventManager.callEvent$default(this.getSystem().getEventManager(), it2, null, 2, null);
            it2 = controllerUseEntityAttackEvent;
            boolean bl7 = false;
            if (it2.isCancelled()) return false;
            bl2 = true;
        }
        if (!bl2) return false;
        Entity entity4 = entity2;
        Entity entity5 = entity4;
        if (entity5 == null) return false;
        Entity it3 = entity5;
        boolean bl8 = false;
        boolean bl9 = ViaLoadingBase.getInstance().getTargetVersion().olderThanOrEqualTo(ProtocolVersion.v1_8);
        if (bl9) {
            if (!animationMode.sendAnimation(this.mc, animationHand)) return false;
            if (!attackMode.sendAttack(this.mc, entity)) return false;
            return true;
        }
        if (bl9) throw new NoWhenBranchMatchedException();
        if (!attackMode.sendAttack(this.mc, entity)) return false;
        if (!animationMode.sendAnimation(this.mc, animationHand)) return false;
        return true;
    }

    public static /* synthetic */ boolean attackEntity$default(CombatManager combatManager, Entity entity, EnumAnimationMode enumAnimationMode, EnumHand enumHand, EnumAttackEntityMode enumAttackEntityMode, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            enumHand = EnumHand.MAIN_HAND;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        return combatManager.attackEntity(entity, enumAnimationMode, enumHand, enumAttackEntityMode, bl2);
    }

    @JvmOverloads
    public final boolean attackEntity(@NotNull Entity entity, @NotNull EnumAnimationMode animationMode, @NotNull EnumHand animationHand, @NotNull EnumAttackEntityMode attackMode) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter((Object)animationMode, "animationMode");
        Intrinsics.checkNotNullParameter(animationHand, "animationHand");
        Intrinsics.checkNotNullParameter((Object)attackMode, "attackMode");
        return CombatManager.attackEntity$default(this, entity, animationMode, animationHand, attackMode, false, 16, null);
    }

    @JvmOverloads
    public final boolean attackEntity(@NotNull Entity entity, @NotNull EnumAnimationMode animationMode, @NotNull EnumAttackEntityMode attackMode) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter((Object)animationMode, "animationMode");
        Intrinsics.checkNotNullParameter((Object)attackMode, "attackMode");
        return CombatManager.attackEntity$default(this, entity, animationMode, null, attackMode, false, 20, null);
    }
}

