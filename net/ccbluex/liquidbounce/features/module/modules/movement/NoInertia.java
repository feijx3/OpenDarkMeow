/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPMoveRelativeEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="NoInertia", description="Remove Inertia", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoInertia;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onlyGroundValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "velocityCancelValue", "onStrafe", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPMoveRelativeEvent;", "DarkMeow"})
public final class NoInertia
extends Module {
    @NotNull
    private final BoolValue onlyGroundValue = new BoolValue("OnlyGround", true);
    @NotNull
    private final BoolValue velocityCancelValue = new BoolValue("VelocityCancel", true);

    public NoInertia() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onStrafe(@NotNull PlayerSPMoveRelativeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (!(!(player.field_71158_b.field_192832_b == 0.0f) || !(player.field_71158_b.field_78902_a == 0.0f) || ((Boolean)this.onlyGroundValue.get()).booleanValue() && !player.field_70122_E || ((Boolean)this.velocityCancelValue.get()).booleanValue() && player.field_70737_aN != 0)) {
            player.field_70159_w = 0.0;
            player.field_70179_y = 0.0;
        }
    }
}

