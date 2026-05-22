/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.network.blink.data;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickBreadcrumbsData;", "", "position", "Lnet/minecraft/util/math/Vec3d;", "color", "Ljava/awt/Color;", "<init>", "(Lnet/minecraft/util/math/Vec3d;Ljava/awt/Color;)V", "getPosition", "()Lnet/minecraft/util/math/Vec3d;", "getColor", "()Ljava/awt/Color;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class BlinkTickBreadcrumbsData {
    @NotNull
    private final Vec3d position;
    @NotNull
    private final Color color;

    public BlinkTickBreadcrumbsData(@NotNull Vec3d position, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(color, "color");
        this.position = position;
        this.color = color;
    }

    @NotNull
    public final Vec3d getPosition() {
        return this.position;
    }

    @NotNull
    public final Color getColor() {
        return this.color;
    }

    @NotNull
    public final Vec3d component1() {
        return this.position;
    }

    @NotNull
    public final Color component2() {
        return this.color;
    }

    @NotNull
    public final BlinkTickBreadcrumbsData copy(@NotNull Vec3d position, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(color, "color");
        return new BlinkTickBreadcrumbsData(position, color);
    }

    public static /* synthetic */ BlinkTickBreadcrumbsData copy$default(BlinkTickBreadcrumbsData blinkTickBreadcrumbsData, Vec3d vec3d, Color color, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vec3d = blinkTickBreadcrumbsData.position;
        }
        if ((n2 & 2) != 0) {
            color = blinkTickBreadcrumbsData.color;
        }
        return blinkTickBreadcrumbsData.copy(vec3d, color);
    }

    @NotNull
    public String toString() {
        return "BlinkTickBreadcrumbsData(position=" + this.position + ", color=" + this.color + ')';
    }

    public int hashCode() {
        int result = this.position.hashCode();
        result = result * 31 + this.color.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlinkTickBreadcrumbsData)) {
            return false;
        }
        BlinkTickBreadcrumbsData blinkTickBreadcrumbsData = (BlinkTickBreadcrumbsData)other;
        if (!Intrinsics.areEqual(this.position, blinkTickBreadcrumbsData.position)) {
            return false;
        }
        return Intrinsics.areEqual(this.color, blinkTickBreadcrumbsData.color);
    }
}

