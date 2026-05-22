/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Deprecated;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="L")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/utils/Rotation;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "yaw", "", "pitch", "<init>", "(FF)V", "getYaw", "()F", "setYaw", "(F)V", "getPitch", "setPitch", "toNewRotation", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "DarkMeow"})
public final class Rotation
extends MinecraftInstance {
    private float yaw;
    private float pitch;

    public Rotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public final float getYaw() {
        return this.yaw;
    }

    public final void setYaw(float f2) {
        this.yaw = f2;
    }

    public final float getPitch() {
        return this.pitch;
    }

    public final void setPitch(float f2) {
        this.pitch = f2;
    }

    @NotNull
    public final net.ccbluex.liquidbounce.handler.rotation.data.Rotation toNewRotation() {
        return new net.ccbluex.liquidbounce.handler.rotation.data.Rotation(this.yaw, this.pitch);
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

    @NotNull
    public String toString() {
        return "Rotation(yaw=" + this.yaw + ", pitch=" + this.pitch + ')';
    }

    public int hashCode() {
        int result = Float.hashCode(this.yaw);
        result = result * 31 + Float.hashCode(this.pitch);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rotation)) {
            return false;
        }
        Rotation rotation = (Rotation)other;
        if (Float.compare(this.yaw, rotation.yaw) != 0) {
            return false;
        }
        return Float.compare(this.pitch, rotation.pitch) == 0;
    }
}

