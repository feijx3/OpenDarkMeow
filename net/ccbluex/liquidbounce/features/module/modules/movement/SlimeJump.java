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
import net.ccbluex.liquidbounce.event.events.player.move.BlockSlimeBounceEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="SlimeJump", description="Allows you low hop on slime blocks.", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/SlimeJump;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "motionValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "onBlockSlimeBounce", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/BlockSlimeBounceEvent;", "DarkMeow"})
public final class SlimeJump
extends Module {
    @NotNull
    private final FloatValue motionValue = new FloatValue("Motion", 0.2f, 0.05f, 0.5f);

    public SlimeJump() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onBlockSlimeBounce(@NotNull BlockSlimeBounceEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        event.cancelEvent();
        player.field_70181_x = ((Number)this.motionValue.get()).floatValue();
    }
}

