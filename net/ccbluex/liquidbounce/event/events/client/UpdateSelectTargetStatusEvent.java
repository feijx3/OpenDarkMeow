/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.ccbluex.liquidbounce.handler.combat.targets.EnumTargetAllowStatus;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/client/UpdateSelectTargetStatusEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "Lnet/ccbluex/liquidbounce/handler/combat/targets/EnumTargetAllowStatus;", "target", "Lnet/minecraft/entity/EntityLivingBase;", "<init>", "(Lnet/minecraft/entity/EntityLivingBase;)V", "getTarget", "()Lnet/minecraft/entity/EntityLivingBase;", "isFriendEntity", "", "setFriendEntity", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nUpdateSelectTargetStatusEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateSelectTargetStatusEvent.kt\nnet/ccbluex/liquidbounce/event/events/client/UpdateSelectTargetStatusEvent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class UpdateSelectTargetStatusEvent
extends ChangeValueEvent<EnumTargetAllowStatus> {
    @NotNull
    private final EntityLivingBase target;

    public UpdateSelectTargetStatusEvent(@NotNull EntityLivingBase target) {
        Intrinsics.checkNotNullParameter(target, "target");
        super(EnumTargetAllowStatus.NONE);
        this.target = target;
    }

    @NotNull
    public final EntityLivingBase getTarget() {
        return this.target;
    }

    public final boolean isFriendEntity() {
        return this.getReturnValue() != EnumTargetAllowStatus.COMBAT;
    }

    public final boolean setFriendEntity() {
        boolean bl2;
        UpdateSelectTargetStatusEvent updateSelectTargetStatusEvent;
        UpdateSelectTargetStatusEvent updateSelectTargetStatusEvent2;
        UpdateSelectTargetStatusEvent it = updateSelectTargetStatusEvent2 = this;
        boolean bl3 = false;
        UpdateSelectTargetStatusEvent updateSelectTargetStatusEvent3 = updateSelectTargetStatusEvent = it.getReturnValue() == EnumTargetAllowStatus.COMBAT ? updateSelectTargetStatusEvent2 : null;
        if (updateSelectTargetStatusEvent != null) {
            UpdateSelectTargetStatusEvent updateSelectTargetStatusEvent4;
            UpdateSelectTargetStatusEvent it2 = updateSelectTargetStatusEvent4 = updateSelectTargetStatusEvent;
            boolean bl4 = false;
            it2.setReturnValue(EnumTargetAllowStatus.ONLY_RENDER);
            UpdateSelectTargetStatusEvent it3 = updateSelectTargetStatusEvent4;
            boolean bl5 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

