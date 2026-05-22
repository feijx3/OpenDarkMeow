/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.render.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityNameEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "displayName", "", "x", "", "y", "z", "<init>", "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDD)V", "(Lnet/minecraft/entity/EntityLivingBase;DDD)V", "getEntity", "()Lnet/minecraft/entity/EntityLivingBase;", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "getX", "()D", "getY", "getZ", "DarkMeow"})
public final class RenderEntityNameEvent
extends CancellableEvent {
    @NotNull
    private final EntityLivingBase entity;
    @NotNull
    private String displayName;
    private final double x;
    private final double y;
    private final double z;

    public RenderEntityNameEvent(@NotNull EntityLivingBase entity, @NotNull String displayName, double x2, double y2, double z2) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.entity = entity;
        this.displayName = displayName;
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    @NotNull
    public final EntityLivingBase getEntity() {
        return this.entity;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.displayName = string;
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

    public RenderEntityNameEvent(@NotNull EntityLivingBase entity, double x2, double y2, double z2) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        String string = entity.func_145748_c_().func_150254_d();
        Intrinsics.checkNotNullExpressionValue(string, "getFormattedText(...)");
        this(entity, string, x2, y2, z2);
    }
}

