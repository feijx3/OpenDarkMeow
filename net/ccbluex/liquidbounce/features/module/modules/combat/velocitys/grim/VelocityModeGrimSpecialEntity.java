/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimSpecialEntity;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "onPlayerSPVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "canIgnoreVelocity", "", "DarkMeow"})
public final class VelocityModeGrimSpecialEntity
extends VelocityMode {
    public VelocityModeGrimSpecialEntity() {
        super("GrimSpecialEntityList");
    }

    @EventTarget(ignoreCanceled=true)
    public final void onPlayerSPVelocity(@NotNull PlayerSPVelocityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.canIgnoreVelocity()) {
            event.cancelEvent();
        }
    }

    private final boolean canIgnoreVelocity() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return false;
        }
        WorldClient world = worldClient;
        double boatSearchRange = 1.5;
        Vec3d playerPos = player.func_174791_d();
        AxisAlignedBB searchBox = new AxisAlignedBB(playerPos.field_72450_a - boatSearchRange, playerPos.field_72448_b - boatSearchRange, playerPos.field_72449_c - boatSearchRange, playerPos.field_72450_a + boatSearchRange, playerPos.field_72448_b + boatSearchRange, playerPos.field_72449_c + boatSearchRange);
        List list = world.func_72872_a(EntityBoat.class, searchBox);
        Intrinsics.checkNotNullExpressionValue(list, "getEntitiesWithinAABB(...)");
        return !((Collection)list).isEmpty();
    }
}

