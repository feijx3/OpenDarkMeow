/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.render;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J \u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0007\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/utils/render/AnimationUtils;", "", "<init>", "()V", "lstransition", "", "now", "desired", "speed", "", "easeOut", "t", "d", "animate", "target", "current", "changer", "add", "min", "max", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAnimationUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationUtils.kt\nnet/ccbluex/liquidbounce/utils/render/AnimationUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
public final class AnimationUtils {
    @NotNull
    public static final AnimationUtils INSTANCE = new AnimationUtils();

    private AnimationUtils() {
    }

    @JvmStatic
    public static final float lstransition(float now, float desired, double speed) {
        double dif = Math.abs((double)(desired - now));
        float a2 = (float)Math.abs(((double)desired - ((double)desired - Math.abs((double)(desired - now)))) / ((double)100 - speed * (double)10));
        float x2 = now;
        if (dif > 0.0) {
            if (now < desired) {
                x2 += a2 * (float)RenderUtils.deltaTime;
            } else if (now > desired) {
                x2 -= a2 * (float)RenderUtils.deltaTime;
            }
        } else {
            x2 = desired;
        }
        if (Math.abs((double)(desired - x2)) < 0.01 && !(x2 == desired)) {
            x2 = desired;
        }
        return x2;
    }

    public final float easeOut(float t2, float d2) {
        float f2;
        float t3 = 0.0f;
        t3 = t2;
        float it = f2 = t3 / d2 - 1.0f;
        boolean bl2 = false;
        t3 = it;
        return f2 * t3 * t3 + 1.0f;
    }

    @JvmStatic
    public static final double animate(double target, double current, double speed) {
        boolean larger;
        double current2 = current;
        double speed2 = speed;
        if (current2 == target) {
            return current2;
        }
        boolean bl2 = larger = target > current2;
        if (speed2 < 0.0) {
            speed2 = 0.0;
        } else if (speed2 > 1.0) {
            speed2 = 1.0;
        }
        double dif = Math.max(target, current2) - Math.min(target, current2);
        double factor = dif * speed2;
        if (factor < 0.1) {
            factor = 0.1;
        }
        if (larger) {
            if ((current2 += factor) >= target) {
                current2 = target;
            }
        } else if (target < current2 && (current2 -= factor) <= target) {
            current2 = target;
        }
        return current2;
    }

    @JvmStatic
    public static final float animate(float target, float current, float speed) {
        boolean larger;
        float current2 = current;
        float speed2 = speed;
        if (current2 == target) {
            return current2;
        }
        boolean bl2 = larger = target > current2;
        if (speed2 < 0.0f) {
            speed2 = 0.0f;
        } else if (speed2 > 1.0f) {
            speed2 = 1.0f;
        }
        double dif = Math.max((double)target, (double)current2) - Math.min((double)target, (double)current2);
        double factor = dif * (double)speed2;
        if (factor < 0.1) {
            factor = 0.1;
        }
        if (larger) {
            if ((current2 += (float)factor) >= target) {
                current2 = target;
            }
        } else if (target < current2 && (current2 -= (float)factor) <= target) {
            current2 = target;
        }
        return current2;
    }

    @JvmStatic
    public static final float changer(float current, float add, float min, float max) {
        float current2 = current;
        if ((current2 += add) > max) {
            current2 = max;
        }
        if (current2 < min) {
            current2 = min;
        }
        return current2;
    }

    @JvmStatic
    public static final double changer(double current, double add, double min, double max) {
        double current2 = current;
        if ((current2 += add) > max) {
            current2 = max;
        }
        if (current2 < min) {
            current2 = min;
        }
        return current2;
    }
}

