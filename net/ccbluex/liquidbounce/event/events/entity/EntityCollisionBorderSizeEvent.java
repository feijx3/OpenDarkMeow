/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/event/events/entity/EntityCollisionBorderSizeEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "", "entity", "Lnet/minecraft/entity/Entity;", "value", "<init>", "(Lnet/minecraft/entity/Entity;F)V", "getEntity", "()Lnet/minecraft/entity/Entity;", "DarkMeow"})
public final class EntityCollisionBorderSizeEvent
extends ChangeValueEvent<Float> {
    @NotNull
    private final Entity entity;

    public EntityCollisionBorderSizeEvent(@NotNull Entity entity, float value) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        super(Float.valueOf(value));
        this.entity = entity;
    }

    @NotNull
    public final Entity getEntity() {
        return this.entity;
    }
}

