/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/event/RenderEntityEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "entity", "Lnet/minecraft/entity/Entity;", "x", "", "y", "z", "entityYaw", "", "partialTicks", "<init>", "(Lnet/minecraft/entity/Entity;DDDFF)V", "getEntity", "()Lnet/minecraft/entity/Entity;", "getX", "()D", "getY", "getZ", "getEntityYaw", "()F", "getPartialTicks", "DarkMeow"})
public final class RenderEntityEvent
extends Event {
    @NotNull
    private final Entity entity;
    private final double x;
    private final double y;
    private final double z;
    private final float entityYaw;
    private final float partialTicks;

    public RenderEntityEvent(@NotNull Entity entity, double x2, double y2, double z2, float entityYaw, float partialTicks) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.entity = entity;
        this.x = x2;
        this.y = y2;
        this.z = z2;
        this.entityYaw = entityYaw;
        this.partialTicks = partialTicks;
    }

    @NotNull
    public final Entity getEntity() {
        return this.entity;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getZ() {
        return this.z;
    }

    public final float getEntityYaw() {
        return this.entityYaw;
    }

    public final float getPartialTicks() {
        return this.partialTicks;
    }
}

