/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.rotation;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import net.ccbluex.liquidbounce.handler.rotation.RotationManagerApply;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.MovementModeManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/RotationManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "movementModeManager", "Lnet/ccbluex/liquidbounce/handler/rotation/movements/MovementModeManager;", "rotationApply", "Lnet/ccbluex/liquidbounce/handler/rotation/RotationManagerApply;", "pauseRotationVisualFix", "", "serverRotation", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "task", "Lnet/ccbluex/liquidbounce/handler/rotation/data/RotationTask;", "getTask", "()Lnet/ccbluex/liquidbounce/handler/rotation/data/RotationTask;", "setTask", "(Lnet/ccbluex/liquidbounce/handler/rotation/data/RotationTask;)V", "addTask", "delTask", "name", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nRotationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RotationManager.kt\nnet/ccbluex/liquidbounce/handler/rotation/RotationManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
public final class RotationManager
extends ManagerBase {
    @JvmField
    @NotNull
    public final MovementModeManager movementModeManager;
    @JvmField
    @NotNull
    public final RotationManagerApply rotationApply;
    @JvmField
    public boolean pauseRotationVisualFix;
    @JvmField
    @NotNull
    public final Rotation serverRotation;
    @Nullable
    private RotationTask task;

    public RotationManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.movementModeManager = new MovementModeManager();
        this.rotationApply = new RotationManagerApply(this);
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), this.rotationApply, false, false, 6, null);
        this.serverRotation = new Rotation(0.0f, 0.0f, 3, null);
    }

    @Nullable
    public final RotationTask getTask() {
        return this.task;
    }

    public final void setTask(@Nullable RotationTask rotationTask) {
        this.task = rotationTask;
    }

    public final boolean addTask(@NotNull RotationTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
        return true;
    }

    public final boolean delTask(@NotNull String name) {
        boolean bl2;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(name, "name");
        String it = string2 = name;
        boolean bl3 = false;
        RotationTask rotationTask = this.task;
        String string3 = string = Intrinsics.areEqual(rotationTask != null ? rotationTask.getName() : null, it) ? string2 : null;
        if (string != null) {
            String string4;
            String it2 = string4 = string;
            boolean bl4 = false;
            this.task = null;
            String it3 = string4;
            boolean bl5 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

