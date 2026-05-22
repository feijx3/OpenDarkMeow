/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.MovementInput
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.rotation.movements.mode;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.handler.rotation.RotationManagerApply;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MovementInput;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "apply", "", "base", "Lnet/ccbluex/liquidbounce/handler/rotation/RotationManagerApply;", "task", "Lnet/ccbluex/liquidbounce/handler/rotation/data/RotationTask;", "movementInput", "Lnet/minecraft/util/MovementInput;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
public abstract class MovementMode
implements Listenable {
    @NotNull
    private final String name;

    public MovementMode(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public abstract void apply(@NotNull RotationManagerApply var1, @NotNull RotationTask var2, @NotNull MovementInput var3, @NotNull EntityPlayerSP var4);
}

