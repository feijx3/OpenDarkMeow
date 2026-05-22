/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.hit_box.impl;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.entity.EntityCollisionBorderSizeEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.hit_box.HitBoxMode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0011H\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/hit_box/impl/HitBoxModeGrimAC;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/hit_box/HitBoxMode;", "<init>", "()V", "lastNotWalking", "", "expandOnlyNotWalking", "expandRange", "", "onEnable", "", "onWorld", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onEntityCollisionBorderSize", "Lnet/ccbluex/liquidbounce/event/events/entity/EntityCollisionBorderSizeEvent;", "onPlayerSPUpdateWalkingPost", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$POST;", "DarkMeow"})
public final class HitBoxModeGrimAC
extends HitBoxMode {
    @JvmField
    public boolean lastNotWalking;
    @JvmField
    public boolean expandOnlyNotWalking = true;
    @JvmField
    public float expandRange = 0.03f;

    public HitBoxModeGrimAC() {
        super("GrimAC");
    }

    @Override
    public void onEnable() {
        if (ViaLoadingBase.getInstance().getTargetVersion().olderThanOrEqualTo(ProtocolVersion.v1_9)) {
            this.expandOnlyNotWalking = false;
            this.expandRange = 0.1f;
        } else {
            this.expandOnlyNotWalking = true;
            this.expandRange = ViaLoadingBase.getInstance().getTargetVersion().olderThan(ProtocolVersion.v1_18_2) ? 0.03f : 2.0E-4f;
        }
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.onEnable();
    }

    @EventTarget
    public final void onEntityCollisionBorderSize(@NotNull EntityCollisionBorderSizeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.lastNotWalking || !this.expandOnlyNotWalking) {
            event.setReturnValue(Float.valueOf(((Number)event.getReturnValue()).floatValue() + this.expandRange));
        }
    }

    @EventTarget
    public final void onPlayerSPUpdateWalkingPost(@NotNull PlayerSPUpdateWalkingEvent.POST event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.lastNotWalking = !event.lastSyncPositionType.getPosition();
    }
}

