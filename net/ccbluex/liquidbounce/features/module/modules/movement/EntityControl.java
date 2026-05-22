/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.passive.EntityPig
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="EntityControl", description="Trash", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/EntityControl;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "gravitySpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "verticalSpeedValue", "transverseSpeedValue", "boostSpeedValue", "noGravity", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "perfectHorseJump", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "handleFly", "entity", "Lnet/minecraft/entity/Entity;", "handleBoost", "onDisable", "DarkMeow"})
public final class EntityControl
extends Module {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final FloatValue gravitySpeedValue;
    @NotNull
    private final FloatValue verticalSpeedValue;
    @NotNull
    private final FloatValue transverseSpeedValue;
    @NotNull
    private final FloatValue boostSpeedValue;
    @NotNull
    private final BoolValue noGravity;
    @NotNull
    private final BoolValue perfectHorseJump;

    public EntityControl() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Fly", "Boost"};
        this.modeValue = new ListValue("Mode", stringArray, "Fly");
        this.gravitySpeedValue = new FloatValue("GravitySpeed", 0.1f, 0.0f, 10.0f);
        this.verticalSpeedValue = new FloatValue("VerticalSpeed", 0.3f, 0.0f, 10.0f);
        this.transverseSpeedValue = new FloatValue("TransverseSpeed", 0.2f, 0.0f, 10.0f);
        this.boostSpeedValue = new FloatValue("BoostSpeed", 0.5f, 0.0f, 10.0f);
        this.noGravity = new BoolValue("NoGravity", true);
        this.perfectHorseJump = new BoolValue("PerfectHorseJump", false);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Entity entity = player.func_184187_bx();
        if (entity == null) {
            return;
        }
        Entity entity2 = entity;
        if (entity2 instanceof EntityBoat || entity2 instanceof EntityHorse || entity2 instanceof EntityPig || entity2 instanceof EntityDonkey) {
            String string = (String)this.modeValue.get();
            if (Intrinsics.areEqual(string, "Fly")) {
                this.handleFly(entity2);
            } else if (Intrinsics.areEqual(string, "Boost")) {
                this.handleBoost(entity2);
                if (((Boolean)this.perfectHorseJump.get()).booleanValue() && entity2 instanceof EntityHorse) {
                    ExtendEntityPlayerSP.INSTANCE.setHorseJumpPowerCounter(player, 9);
                    ExtendEntityPlayerSP.INSTANCE.setHorseJumpPowerI(player, 1.0f);
                }
            }
        }
    }

    private final void handleFly(Entity entity) {
        entity.func_189654_d(((Boolean)this.noGravity.get()).booleanValue());
        entity.field_70181_x = -((double)((Number)this.gravitySpeedValue.get()).floatValue());
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP);
        entity.field_70177_z = entityPlayerSP.field_70177_z;
        if (MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d()) {
            entity.field_70122_E = false;
            entity.field_70181_x = ((Number)this.verticalSpeedValue.get()).floatValue();
        }
        if (MinecraftInstance.mc.getGameSettings().field_151444_V.func_151470_d()) {
            entity.field_70122_E = false;
            entity.field_70181_x = -((double)((Number)this.verticalSpeedValue.get()).floatValue());
        }
        double yaw = Math.toRadians(entity.field_70177_z);
        double moveSpeed = ((Number)this.transverseSpeedValue.get()).floatValue();
        if (MinecraftInstance.mc.getGameSettings().field_74351_w.func_151470_d()) {
            entity.field_70159_w += -Math.sin(yaw) * moveSpeed;
            entity.field_70179_y += Math.cos(yaw) * moveSpeed;
        }
        if (MinecraftInstance.mc.getGameSettings().field_74368_y.func_151470_d()) {
            entity.field_70159_w += Math.sin(yaw) * moveSpeed;
            entity.field_70179_y += -Math.cos(yaw) * moveSpeed;
        }
        if (MinecraftInstance.mc.getGameSettings().field_74370_x.func_151470_d()) {
            entity.field_70159_w += Math.cos(yaw) * moveSpeed;
            entity.field_70179_y += Math.sin(yaw) * moveSpeed;
        }
        if (MinecraftInstance.mc.getGameSettings().field_74366_z.func_151470_d()) {
            entity.field_70159_w += -Math.cos(yaw) * moveSpeed;
            entity.field_70179_y += -Math.sin(yaw) * moveSpeed;
        }
    }

    private final void handleBoost(Entity entity) {
        entity.func_189654_d(false);
        entity.field_70181_x = 0.0;
        if (MinecraftInstance.mc.getGameSettings().field_74351_w.func_151470_d()) {
            entity.field_70159_w *= ((Number)this.boostSpeedValue.get()).doubleValue();
            entity.field_70179_y *= ((Number)this.boostSpeedValue.get()).doubleValue();
        }
        if (MinecraftInstance.mc.getGameSettings().field_74368_y.func_151470_d()) {
            entity.field_70159_w *= (double)(-((Number)this.boostSpeedValue.get()).floatValue());
            entity.field_70179_y *= (double)(-((Number)this.boostSpeedValue.get()).floatValue());
        }
        if (MinecraftInstance.mc.getGameSettings().field_74370_x.func_151470_d()) {
            entity.field_70159_w *= (double)(-((Number)this.boostSpeedValue.get()).floatValue());
            entity.field_70179_y *= ((Number)this.boostSpeedValue.get()).doubleValue();
        }
        if (MinecraftInstance.mc.getGameSettings().field_74366_z.func_151470_d()) {
            entity.field_70159_w *= ((Number)this.boostSpeedValue.get()).doubleValue();
            entity.field_70179_y *= (double)(-((Number)this.boostSpeedValue.get()).floatValue());
        }
    }

    @Override
    public void onDisable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Entity entity = player.func_184187_bx();
        if (entity == null) {
            return;
        }
        Entity entity2 = entity;
        if (entity2 instanceof EntityBoat || entity2 instanceof EntityHorse || entity2 instanceof EntityPig) {
            entity2.func_189654_d(false);
            entity2.field_70159_w = 0.0;
            entity2.field_70181_x = 0.0;
            entity2.field_70179_y = 0.0;
        }
    }
}

