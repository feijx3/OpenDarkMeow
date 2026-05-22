/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.rotation.data;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\u0005\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0000J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "", "yaw", "", "pitch", "<init>", "(FF)V", "entity", "Lnet/minecraft/entity/Entity;", "(Lnet/minecraft/entity/Entity;)V", "fromEntity", "", "fromRotation", "rotation", "toString", "", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "DarkMeow"})
public final class Rotation {
    @JvmField
    public float yaw;
    @JvmField
    public float pitch;

    public Rotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public /* synthetic */ Rotation(float f2, float f3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((n2 & 2) != 0) {
            f3 = 0.0f;
        }
        this(f2, f3);
    }

    public Rotation(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this(entity.field_70177_z, entity.field_70125_A);
    }

    public final void fromEntity(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.yaw = entity.field_70177_z;
        this.pitch = entity.field_70125_A;
    }

    public final void fromRotation(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        this.yaw = rotation.yaw;
        this.pitch = rotation.pitch;
    }

    @NotNull
    public String toString() {
        return "Rotation[yaw=" + this.yaw + ", pitch=" + this.pitch + ']';
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof Rotation ? MathHelper.func_188209_b((int)MathKt.roundToInt(((Rotation)other).yaw)) == MathHelper.func_188209_b((int)MathKt.roundToInt(this.yaw)) && MathKt.roundToInt(((Rotation)other).pitch) == MathKt.roundToInt(this.pitch) : false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[]{Float.valueOf(this.yaw), Float.valueOf(this.pitch)};
        return Objects.hash(objectArray);
    }

    public final float component1() {
        return this.yaw;
    }

    public final float component2() {
        return this.pitch;
    }

    @NotNull
    public final Rotation copy(float yaw, float pitch) {
        return new Rotation(yaw, pitch);
    }

    public static /* synthetic */ Rotation copy$default(Rotation rotation, float f2, float f3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            f2 = rotation.yaw;
        }
        if ((n2 & 2) != 0) {
            f3 = rotation.pitch;
        }
        return rotation.copy(f2, f3);
    }

    public Rotation() {
        this(0.0f, 0.0f, 3, null);
    }
}

