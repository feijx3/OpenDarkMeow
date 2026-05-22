/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.criticals.grim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.criticals.CriticalsMode;
import net.ccbluex.liquidbounce.features.module.modules.player.GApple;
import net.ccbluex.liquidbounce.features.module.modules.player.Stuck;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u001bH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/grim/GrimStuckCriticals;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/criticals/CriticalsMode;", "<init>", "()V", "stuckTickValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "getStuckTickValue", "()Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "delayValue", "getDelayValue", "skipTicks", "", "getSkipTicks", "()I", "setSkipTicks", "(I)V", "delay", "getDelay", "setDelay", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onControllerUseEntityAttack", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "DarkMeow"})
public final class GrimStuckCriticals
extends CriticalsMode {
    @NotNull
    private final IntegerValue stuckTickValue = new IntegerValue(this.getValuePrefix() + "StuckTick", 10, 2, 20);
    @NotNull
    private final IntegerValue delayValue = new IntegerValue(this.getValuePrefix() + "Delay", 1, 0, 20);
    private int skipTicks;
    private int delay;

    public GrimStuckCriticals() {
        super("GrimStuck");
    }

    @NotNull
    public final IntegerValue getStuckTickValue() {
        return this.stuckTickValue;
    }

    @NotNull
    public final IntegerValue getDelayValue() {
        return this.delayValue;
    }

    public final int getSkipTicks() {
        return this.skipTicks;
    }

    public final void setSkipTicks(int n2) {
        this.skipTicks = n2;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final void setDelay(int n2) {
        this.delay = n2;
    }

    @Override
    public void onEnable() {
        this.skipTicks = 0;
        this.delay = 0;
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPacket() instanceof SPacketPlayerPosLook) {
            this.skipTicks = 0;
            this.delay = 0;
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        int n2;
        block8: {
            block7: {
                Intrinsics.checkNotNullParameter(event, "event");
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                if (entityPlayerSP == null) {
                    return;
                }
                EntityPlayerSP player = entityPlayerSP;
                if (player.func_70617_f_() || ExtendEntity.INSTANCE.isInWeb((Entity)player) || player.func_70090_H() || player.func_180799_ab() || player.func_184187_bx() != null) break block7;
                GApple gApple = DarkMeow.INSTANCE.getModuleManager().getModule(GApple.class);
                Boolean bl2 = gApple != null ? Boolean.valueOf(gApple.getState()) : null;
                Intrinsics.checkNotNull(bl2);
                if (bl2.booleanValue()) break block7;
                Stuck stuck = DarkMeow.INSTANCE.getModuleManager().getModule(Stuck.class);
                Boolean bl3 = stuck != null ? Boolean.valueOf(stuck.getState()) : null;
                Intrinsics.checkNotNull(bl3);
                if (!bl3.booleanValue()) break block8;
            }
            this.skipTicks = 0;
            this.delay = ((Number)this.delayValue.get()).intValue();
            return;
        }
        if (this.skipTicks > 0) {
            n2 = this.skipTicks;
            this.skipTicks = n2 + -1;
        }
        if (this.skipTicks == 0) {
            DarkMeow.INSTANCE.getMovementManager().getStuckManager().stop();
        }
        if (this.delay > 0) {
            n2 = this.delay;
            this.delay = n2 + -1;
        }
    }

    @EventTarget
    public final void onControllerUseEntityAttack(@NotNull ControllerUseEntityAttackEvent event) {
        block5: {
            EntityPlayerSP player;
            block7: {
                block6: {
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (!(event.getTarget() instanceof EntityLivingBase)) break block5;
                    EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                    if (entityPlayerSP == null) {
                        return;
                    }
                    player = entityPlayerSP;
                    Entity entity = event.getTarget();
                    if (player.func_70617_f_() || ExtendEntity.INSTANCE.isInWeb((Entity)player) || player.func_70090_H() || player.func_180799_ab() || player.func_184187_bx() != null || ((EntityLivingBase)entity).field_70737_aN > 10) break block6;
                    GApple gApple = DarkMeow.INSTANCE.getModuleManager().getModule(GApple.class);
                    Boolean bl2 = gApple != null ? Boolean.valueOf(gApple.getState()) : null;
                    Intrinsics.checkNotNull(bl2);
                    if (bl2.booleanValue()) break block6;
                    Stuck stuck = DarkMeow.INSTANCE.getModuleManager().getModule(Stuck.class);
                    Boolean bl3 = stuck != null ? Boolean.valueOf(stuck.getState()) : null;
                    Intrinsics.checkNotNull(bl3);
                    if (!bl3.booleanValue()) break block7;
                }
                this.skipTicks = 0;
                this.delay = ((Number)this.delayValue.get()).intValue();
                return;
            }
            if (player.field_70143_R > 0.0f && this.skipTicks == 0 && this.delay == 0 && DarkMeow.INSTANCE.getMovementManager().getStuckManager().start()) {
                this.skipTicks = ((Number)this.stuckTickValue.get()).intValue();
                this.delay = ((Number)this.delayValue.get()).intValue();
            }
        }
    }
}

