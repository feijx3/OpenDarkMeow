/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.math;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0005J\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0007J\n\u0010\b\u001a\u00020\u0005*\u00020\u0005J\n\u0010\b\u001a\u00020\u0007*\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/darkmeow/darkmeow/utils/math/MathUtils;", "", "<init>", "()V", "PI_FLOAT", "", "toRadians", "", "toDegree", "calculateGaussianValue", "x", "sigma", "DarkMeow"})
public final class MathUtils {
    @NotNull
    public static final MathUtils INSTANCE = new MathUtils();
    private static final float PI_FLOAT = (float)Math.PI;

    private MathUtils() {
    }

    public final float toRadians(float $this$toRadians) {
        return $this$toRadians / 180.0f * (float)Math.PI;
    }

    public final double toRadians(double $this$toRadians) {
        return $this$toRadians / 180.0 * Math.PI;
    }

    public final float toDegree(float $this$toDegree) {
        return $this$toDegree * 180.0f / (float)Math.PI;
    }

    public final double toDegree(double $this$toDegree) {
        return $this$toDegree * 180.0 / Math.PI;
    }

    public final float calculateGaussianValue(float x2, float sigma) {
        double p2 = 3.141592653;
        double output = 1.0 / Math.sqrt(2.0 * p2 * (double)(sigma * sigma));
        return (float)(output * Math.exp((double)(-(x2 * x2)) / (2.0 * (double)(sigma * sigma))));
    }
}

