/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.rotation.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.MovementMode;
import net.darkmeow.darkmeow.utils.movement.RotationUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\tH\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/data/RotationTask;", "", "name", "", "rotation", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "mode", "Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;", "keepTicks", "", "<init>", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;I)V", "getName", "()Ljava/lang/String;", "getRotation", "()Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "getMode", "()Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;", "getKeepTicks", "()I", "setKeepTicks", "(I)V", "getSmoothRotation", "lastRotation", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "DarkMeow"})
public final class RotationTask {
    @NotNull
    private final String name;
    @NotNull
    private final Rotation rotation;
    @Nullable
    private final MovementMode mode;
    private int keepTicks;

    public RotationTask(@NotNull String name, @NotNull Rotation rotation, @Nullable MovementMode mode, int keepTicks) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        this.name = name;
        this.rotation = rotation;
        this.mode = mode;
        this.keepTicks = keepTicks;
    }

    public /* synthetic */ RotationTask(String string, Rotation rotation, MovementMode movementMode, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 8) != 0) {
            n2 = 1;
        }
        this(string, rotation, movementMode, n2);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Rotation getRotation() {
        return this.rotation;
    }

    @Nullable
    public final MovementMode getMode() {
        return this.mode;
    }

    public final int getKeepTicks() {
        return this.keepTicks;
    }

    public final void setKeepTicks(int n2) {
        this.keepTicks = n2;
    }

    @NotNull
    public final Rotation getSmoothRotation(@NotNull Rotation lastRotation) {
        Intrinsics.checkNotNullParameter(lastRotation, "lastRotation");
        return RotationUtils.INSTANCE.limitAngleChange(lastRotation, this.rotation, 180.0f);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final Rotation component2() {
        return this.rotation;
    }

    @Nullable
    public final MovementMode component3() {
        return this.mode;
    }

    public final int component4() {
        return this.keepTicks;
    }

    @NotNull
    public final RotationTask copy(@NotNull String name, @NotNull Rotation rotation, @Nullable MovementMode mode, int keepTicks) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        return new RotationTask(name, rotation, mode, keepTicks);
    }

    public static /* synthetic */ RotationTask copy$default(RotationTask rotationTask, String string, Rotation rotation, MovementMode movementMode, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string = rotationTask.name;
        }
        if ((n3 & 2) != 0) {
            rotation = rotationTask.rotation;
        }
        if ((n3 & 4) != 0) {
            movementMode = rotationTask.mode;
        }
        if ((n3 & 8) != 0) {
            n2 = rotationTask.keepTicks;
        }
        return rotationTask.copy(string, rotation, movementMode, n2);
    }

    @NotNull
    public String toString() {
        return "RotationTask(name=" + this.name + ", rotation=" + this.rotation + ", mode=" + this.mode + ", keepTicks=" + this.keepTicks + ')';
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.rotation.hashCode();
        result = result * 31 + (this.mode == null ? 0 : this.mode.hashCode());
        result = result * 31 + Integer.hashCode(this.keepTicks);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RotationTask)) {
            return false;
        }
        RotationTask rotationTask = (RotationTask)other;
        if (!Intrinsics.areEqual(this.name, rotationTask.name)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.rotation, rotationTask.rotation)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.mode, rotationTask.mode)) {
            return false;
        }
        return this.keepTicks == rotationTask.keepTicks;
    }
}

