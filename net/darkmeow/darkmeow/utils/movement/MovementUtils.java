/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.movement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.utils.math.MathUtils;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/utils/movement/MovementUtils;", "", "<init>", "()V", "applySilentRotationFix", "", "Lnet/minecraft/util/MovementInput;", "playerYaw", "", "serverYaw", "direction", "yaw", "forward", "strafe", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMovementUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovementUtils.kt\nnet/darkmeow/darkmeow/utils/movement/MovementUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n2393#2,14:82\n*S KotlinDebug\n*F\n+ 1 MovementUtils.kt\nnet/darkmeow/darkmeow/utils/movement/MovementUtils\n*L\n56#1:82,14\n*E\n"})
public final class MovementUtils {
    @NotNull
    public static final MovementUtils INSTANCE = new MovementUtils();

    private MovementUtils() {
    }

    /*
     * WARNING - void declaration
     */
    public final void applySilentRotationFix(@NotNull MovementInput $this$applySilentRotationFix, float playerYaw, float serverYaw) {
        Object t2;
        void $this$minBy$iv;
        Iterable<Object> iterable;
        Intrinsics.checkNotNullParameter($this$applySilentRotationFix, "<this>");
        if ($this$applySilentRotationFix.field_192832_b == 0.0f && $this$applySilentRotationFix.field_78902_a == 0.0f) {
            return;
        }
        float base = Math.max(Math.abs($this$applySilentRotationFix.field_192832_b), Math.abs($this$applySilentRotationFix.field_78902_a));
        float degreesPlayerYaw = MathHelper.func_76142_g((float)playerYaw);
        float degreesServerYaw = MathHelper.func_76142_g((float)serverYaw);
        float bestYaw = this.direction(degreesPlayerYaw, $this$applySilentRotationFix.field_192832_b, $this$applySilentRotationFix.field_78902_a);
        List $this$applySilentRotationFix_u24lambda_u240 = iterable = (List)new ArrayList();
        boolean bl2 = false;
        for (int forward = -1; forward < 2; ++forward) {
            for (int strafe = -1; strafe < 2; ++strafe) {
                if (forward == 0 && strafe == 0) continue;
                $this$applySilentRotationFix_u24lambda_u240.add(new Pair<Pair<Integer, Integer>, Float>(new Pair<Integer, Integer>(forward, strafe), Float.valueOf(INSTANCE.direction(degreesServerYaw, forward, strafe))));
            }
        }
        iterable = iterable;
        boolean $i$f$minByOrThrow = false;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (!iterator$iv.hasNext()) {
            t2 = minElem$iv;
        } else {
            Pair it = (Pair)minElem$iv;
            boolean bl3 = false;
            float minValue$iv = Math.min(Math.abs(((Number)it.getSecond()).floatValue() - bestYaw), Math.abs(((Number)it.getSecond()).floatValue() - bestYaw + (float)360));
            do {
                Object e$iv = iterator$iv.next();
                Pair it2 = (Pair)e$iv;
                $i$a$-minByOrThrow-MovementUtils$applySilentRotationFix$2 = false;
                float v$iv = Math.min(Math.abs(((Number)it2.getSecond()).floatValue() - bestYaw), Math.abs(((Number)it2.getSecond()).floatValue() - bestYaw + (float)360));
                if (Float.compare(minValue$iv, v$iv) <= 0) continue;
                minElem$iv = e$iv;
                minValue$iv = v$iv;
            } while (iterator$iv.hasNext());
            t2 = minElem$iv;
        }
        iterable = t2;
        Pair it = (Pair)((Object)iterable);
        boolean bl4 = false;
        $this$applySilentRotationFix.field_192832_b = (float)((Number)((Pair)it.getFirst()).getFirst()).intValue() * base;
        $this$applySilentRotationFix.field_78902_a = (float)((Number)((Pair)it.getFirst()).getSecond()).intValue() * base;
    }

    @JvmOverloads
    public final float direction(float yaw, float forward, float strafe) {
        return MathHelper.func_76142_g((float)(MathUtils.INSTANCE.toDegree((float)Math.atan2(-strafe, forward)) + yaw));
    }

    public static /* synthetic */ float direction$default(MovementUtils movementUtils, float f2, float f3, float f4, int n2, Object object) {
        if ((n2 & 1) != 0) {
            f2 = 0.0f;
        }
        return movementUtils.direction(f2, f3, f4);
    }

    @JvmOverloads
    public final float direction(float forward, float strafe) {
        return MovementUtils.direction$default(this, 0.0f, forward, strafe, 1, null);
    }
}

