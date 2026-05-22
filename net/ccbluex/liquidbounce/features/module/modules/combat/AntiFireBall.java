/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.EntityLargeFireball
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AntiFireBall", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AntiFireBall;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "noHandActiveValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "noSprintingValue", "swingValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "coolDownTickValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "debugValue", "coolDown", "", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class AntiFireBall
extends Module {
    @NotNull
    private final FloatValue rangeValue = new FloatValue("Range", 5.5f, 0.0f, 8.0f);
    @NotNull
    private final BoolValue noHandActiveValue = new BoolValue("NoHandActive", false);
    @NotNull
    private final BoolValue noSprintingValue = new BoolValue("NoSprinting", false);
    @NotNull
    private final ListValue swingValue;
    @NotNull
    private final IntegerValue coolDownTickValue;
    @NotNull
    private final BoolValue debugValue;
    private int coolDown;

    public AntiFireBall() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Normal", "Packet", "None"};
        this.swingValue = new ListValue("Swing", stringArray, "Normal");
        this.coolDownTickValue = new IntegerValue("CoolDownTick", 0, 0, 20);
        this.debugValue = new BoolValue("Debug", true);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        if (netHandlerPlayClient == null) {
            return;
        }
        NetHandlerPlayClient connection = netHandlerPlayClient;
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return;
        }
        WorldClient world = worldClient;
        if (this.coolDown > 0) {
            int n2 = this.coolDown;
            this.coolDown = n2 + -1;
            return;
        }
        if (((Boolean)this.noHandActiveValue.get()).booleanValue() && player.func_184587_cr()) {
            return;
        }
        if (((Boolean)this.noSprintingValue.get()).booleanValue() && player.func_70051_ag()) {
            return;
        }
        float range = ((Number)this.rangeValue.get()).floatValue();
        for (Entity entity : world.field_72996_f) {
            if (!(entity instanceof EntityLargeFireball) || !(PlayerExtensionKt.getDistanceToEntityBox((Entity)player, entity) < (double)range)) continue;
            if (((Boolean)this.debugValue.get()).booleanValue()) {
                DarkMeow.INSTANCE.getMessageManager().display.displayInfo("Attack Fireball(id: " + ((EntityLargeFireball)entity).func_145782_y() + ')');
            }
            connection.func_147297_a((Packet)new CPacketUseEntity(entity));
            String string = (String)this.swingValue.get();
            if (Intrinsics.areEqual(string, "Normal")) {
                player.func_184609_a(EnumHand.MAIN_HAND);
            } else if (Intrinsics.areEqual(string, "Packet")) {
                connection.func_147297_a((Packet)new CPacketAnimation());
            }
            if (((Number)this.coolDownTickValue.get()).intValue() <= 0) continue;
            this.coolDown = ((Number)this.coolDownTickValue.get()).intValue();
            return;
        }
    }
}

