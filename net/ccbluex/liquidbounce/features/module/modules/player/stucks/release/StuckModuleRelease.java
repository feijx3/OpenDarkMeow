/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.stucks.release;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.StuckModule;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManagerExtend;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.KeyValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/release/StuckModuleRelease;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/StuckModule;", "<init>", "()V", "keyValue", "Lnet/ccbluex/liquidbounce/value/impl/KeyValue;", "limitValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "toggleOffValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onMovementInputPre", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
public final class StuckModuleRelease
extends StuckModule {
    @JvmField
    @NotNull
    public final KeyValue keyValue = new KeyValue("Key", "M");
    @JvmField
    @NotNull
    public final IntegerValue limitValue = new IntegerValue("Limit", 40, new IntRange(10, 40));
    @JvmField
    @NotNull
    public final BoolValue toggleOffValue = new BoolValue("ToggleOff", false);

    public StuckModuleRelease() {
        super("Release", false, false, 6, null);
    }

    @EventTarget
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (this.keyValue.isKeyDown()) {
            int n2 = RangesKt.coerceAtMost(MovementStuckManagerExtend.INSTANCE.getSafeReleaseCount(DarkMeow.INSTANCE.getMovementManager().getStuckManager()), ((Number)this.limitValue.get()).intValue());
            int n3 = 0;
            while (n3 < n2) {
                int it = n3++;
                boolean bl2 = false;
                MovementStuckManagerExtend.travelOnStuck$default(MovementStuckManagerExtend.INSTANCE, player, 0.0f, 0.0f, 0.0f, 7, null);
                MovementStuckManagerExtend.INSTANCE.syncPositionToServerOnStuck(player);
            }
            if (((Boolean)this.toggleOffValue.get()).booleanValue()) {
                this.getInstance().setState(false);
            }
        }
    }
}

