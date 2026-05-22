/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.entity.AccessorEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005J\"\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/entity/ExtendEntity;", "", "<init>", "()V", "value", "", "isInWeb", "Lnet/minecraft/entity/Entity;", "(Lnet/minecraft/entity/Entity;)Z", "setInWeb", "(Lnet/minecraft/entity/Entity;Z)V", "getFlag", "flag", "", "setFlag", "", "set", "getVectorForRotation", "Lnet/minecraft/util/math/Vec3d;", "kotlin.jvm.PlatformType", "pitch", "", "yaw", "DarkMeow"})
public final class ExtendEntity {
    @NotNull
    public static final ExtendEntity INSTANCE = new ExtendEntity();

    private ExtendEntity() {
    }

    public final boolean isInWeb(@NotNull Entity $this$isInWeb) {
        Intrinsics.checkNotNullParameter($this$isInWeb, "<this>");
        return ((AccessorEntity)$this$isInWeb).getIsInWeb();
    }

    public final void setInWeb(@NotNull Entity $this$isInWeb, boolean value) {
        Intrinsics.checkNotNullParameter($this$isInWeb, "<this>");
        ((AccessorEntity)$this$isInWeb).setIsInWeb(value);
    }

    public final boolean getFlag(@NotNull Entity $this$getFlag, int flag) {
        Intrinsics.checkNotNullParameter($this$getFlag, "<this>");
        return ((AccessorEntity)$this$getFlag).darkMeow_getFlag(flag);
    }

    public final void setFlag(@NotNull Entity $this$setFlag, int flag, boolean set) {
        Intrinsics.checkNotNullParameter($this$setFlag, "<this>");
        ((AccessorEntity)$this$setFlag).darkMeow_setFlag(flag, set);
    }

    public final Vec3d getVectorForRotation(@NotNull Entity $this$getVectorForRotation, float pitch, float yaw) {
        Intrinsics.checkNotNullParameter($this$getVectorForRotation, "<this>");
        return ((AccessorEntity)$this$getVectorForRotation).darkMeow_getVectorForRotation(pitch, yaw);
    }
}

