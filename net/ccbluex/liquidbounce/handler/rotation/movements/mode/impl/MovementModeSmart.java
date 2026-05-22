/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.handler.rotation.RotationManagerApply;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.MovementMode;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeSilent;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeStrict;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\u00020\u000f*\u00020\rH\u0002\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/impl/MovementModeSmart;", "Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;", "<init>", "()V", "apply", "", "base", "Lnet/ccbluex/liquidbounce/handler/rotation/RotationManagerApply;", "task", "Lnet/ccbluex/liquidbounce/handler/rotation/data/RotationTask;", "movementInput", "Lnet/minecraft/util/MovementInput;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "shouldForceUseSilent", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMovementModeSmart.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovementModeSmart.kt\nnet/ccbluex/liquidbounce/handler/rotation/movements/mode/impl/MovementModeSmart\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1761#2,3:46\n*S KotlinDebug\n*F\n+ 1 MovementModeSmart.kt\nnet/ccbluex/liquidbounce/handler/rotation/movements/mode/impl/MovementModeSmart\n*L\n40#1:46,3\n*E\n"})
public final class MovementModeSmart
extends MovementMode {
    @NotNull
    public static final MovementModeSmart INSTANCE = new MovementModeSmart();

    private MovementModeSmart() {
        super("Smart");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void apply(@NotNull RotationManagerApply base, @NotNull RotationTask task, @NotNull MovementInput movementInput, @NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(movementInput, "movementInput");
        Intrinsics.checkNotNullParameter(player, "player");
        if (this.shouldForceUseSilent(player)) ** GOTO lbl-1000
        v0 = base.getManager().mc.field_71474_y.field_74314_A;
        Intrinsics.checkNotNullExpressionValue(v0, "keyBindJump");
        if (!KeyUtils.INSTANCE.isKeyDownSystem(v0)) lbl-1000:
        // 2 sources

        {
            v1 = true;
        } else {
            v1 = var5_5 = false;
        }
        if (var5_5) {
            MovementModeSilent.INSTANCE.apply(base, task, movementInput, player);
        } else if (!var5_5) {
            MovementModeStrict.INSTANCE.apply(base, task, movementInput, player);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean shouldForceUseSilent(EntityPlayerSP $this$shouldForceUseSilent) {
        boolean bl2;
        block5: {
            List list;
            List $this$shouldForceUseSilent_u24lambda_u240 = list = (List)new ArrayList();
            boolean bl3 = false;
            for (int x2 = -3; x2 < 4; ++x2) {
                for (int z2 = -3; z2 < 4; ++z2) {
                    BlockPos blockPos = new BlockPos((Entity)$this$shouldForceUseSilent).func_177982_a(x2, -1, z2);
                    Intrinsics.checkNotNullExpressionValue(blockPos, "add(...)");
                    $this$shouldForceUseSilent_u24lambda_u240.add(blockPos);
                }
            }
            Iterable $this$any$iv = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    BlockPos pos = (BlockPos)element$iv;
                    boolean bl4 = false;
                    if (!$this$shouldForceUseSilent.field_70170_p.func_180495_p(pos).func_185904_a().func_76222_j()) continue;
                    bl2 = true;
                    break block5;
                }
                bl2 = false;
            }
        }
        return bl2;
    }
}

