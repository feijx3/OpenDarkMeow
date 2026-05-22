/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render.projectiles;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011\u00a8\u0006$"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/ProjectilesInfo;", "", "isBow", "", "motionFactor", "", "motionSlowdown", "gravity", "size", "<init>", "(ZFFFF)V", "()Z", "setBow", "(Z)V", "getMotionFactor", "()F", "setMotionFactor", "(F)V", "getMotionSlowdown", "setMotionSlowdown", "getGravity", "setGravity", "getSize", "setSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class ProjectilesInfo {
    private boolean isBow;
    private float motionFactor;
    private float motionSlowdown;
    private float gravity;
    private float size;

    public ProjectilesInfo(boolean isBow, float motionFactor, float motionSlowdown, float gravity, float size) {
        this.isBow = isBow;
        this.motionFactor = motionFactor;
        this.motionSlowdown = motionSlowdown;
        this.gravity = gravity;
        this.size = size;
    }

    public /* synthetic */ ProjectilesInfo(boolean bl2, float f2, float f3, float f4, float f5, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        if ((n2 & 2) != 0) {
            f2 = 1.5f;
        }
        if ((n2 & 4) != 0) {
            f3 = 0.99f;
        }
        if ((n2 & 8) != 0) {
            f4 = 0.0f;
        }
        if ((n2 & 0x10) != 0) {
            f5 = 0.0f;
        }
        this(bl2, f2, f3, f4, f5);
    }

    public final boolean isBow() {
        return this.isBow;
    }

    public final void setBow(boolean bl2) {
        this.isBow = bl2;
    }

    public final float getMotionFactor() {
        return this.motionFactor;
    }

    public final void setMotionFactor(float f2) {
        this.motionFactor = f2;
    }

    public final float getMotionSlowdown() {
        return this.motionSlowdown;
    }

    public final void setMotionSlowdown(float f2) {
        this.motionSlowdown = f2;
    }

    public final float getGravity() {
        return this.gravity;
    }

    public final void setGravity(float f2) {
        this.gravity = f2;
    }

    public final float getSize() {
        return this.size;
    }

    public final void setSize(float f2) {
        this.size = f2;
    }

    public final boolean component1() {
        return this.isBow;
    }

    public final float component2() {
        return this.motionFactor;
    }

    public final float component3() {
        return this.motionSlowdown;
    }

    public final float component4() {
        return this.gravity;
    }

    public final float component5() {
        return this.size;
    }

    @NotNull
    public final ProjectilesInfo copy(boolean isBow, float motionFactor, float motionSlowdown, float gravity, float size) {
        return new ProjectilesInfo(isBow, motionFactor, motionSlowdown, gravity, size);
    }

    public static /* synthetic */ ProjectilesInfo copy$default(ProjectilesInfo projectilesInfo, boolean bl2, float f2, float f3, float f4, float f5, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = projectilesInfo.isBow;
        }
        if ((n2 & 2) != 0) {
            f2 = projectilesInfo.motionFactor;
        }
        if ((n2 & 4) != 0) {
            f3 = projectilesInfo.motionSlowdown;
        }
        if ((n2 & 8) != 0) {
            f4 = projectilesInfo.gravity;
        }
        if ((n2 & 0x10) != 0) {
            f5 = projectilesInfo.size;
        }
        return projectilesInfo.copy(bl2, f2, f3, f4, f5);
    }

    @NotNull
    public String toString() {
        return "ProjectilesInfo(isBow=" + this.isBow + ", motionFactor=" + this.motionFactor + ", motionSlowdown=" + this.motionSlowdown + ", gravity=" + this.gravity + ", size=" + this.size + ')';
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.isBow);
        result = result * 31 + Float.hashCode(this.motionFactor);
        result = result * 31 + Float.hashCode(this.motionSlowdown);
        result = result * 31 + Float.hashCode(this.gravity);
        result = result * 31 + Float.hashCode(this.size);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectilesInfo)) {
            return false;
        }
        ProjectilesInfo projectilesInfo = (ProjectilesInfo)other;
        if (this.isBow != projectilesInfo.isBow) {
            return false;
        }
        if (Float.compare(this.motionFactor, projectilesInfo.motionFactor) != 0) {
            return false;
        }
        if (Float.compare(this.motionSlowdown, projectilesInfo.motionSlowdown) != 0) {
            return false;
        }
        if (Float.compare(this.gravity, projectilesInfo.gravity) != 0) {
            return false;
        }
        return Float.compare(this.size, projectilesInfo.size) == 0;
    }

    public ProjectilesInfo() {
        this(false, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }
}

