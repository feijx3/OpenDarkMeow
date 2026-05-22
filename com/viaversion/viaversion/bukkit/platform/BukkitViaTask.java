/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  org.bukkit.scheduler.BukkitTask
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.bukkit.platform;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.platform.PlatformTask;
import java.util.Arrays;
import java.util.Objects;
import org.bukkit.scheduler.BukkitTask;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="task", type=BukkitTask.class)})
public final class BukkitViaTask
extends J_L_Record
implements PlatformTask<BukkitTask> {
    private final BukkitTask task;

    public BukkitViaTask(BukkitTask task) {
        this.task = task;
    }

    @Override
    public void cancel() {
        Preconditions.checkArgument((this.task != null ? 1 : 0) != 0, (Object)"Task cannot be cancelled");
        this.task.cancel();
    }

    @Override
    public final String toString() {
        return BukkitViaTask.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BukkitViaTask.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BukkitViaTask.jvmdowngrader$equals$equals(this, o2);
    }

    public BukkitTask task() {
        return this.task;
    }

    private static String jvmdowngrader$toString$toString(BukkitViaTask bukkitViaTask) {
        BukkitViaTask bukkitViaTask2 = bukkitViaTask;
        return "BukkitViaTask[" + "task=" + bukkitViaTask.task + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BukkitViaTask bukkitViaTask) {
        Object[] objectArray = new Object[]{bukkitViaTask.task};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BukkitViaTask bukkitViaTask, Object object) {
        if (bukkitViaTask == object) {
            return true;
        }
        if (object != null && object instanceof BukkitViaTask) {
            BukkitViaTask bukkitViaTask2 = (BukkitViaTask)object;
            if (Objects.equals(bukkitViaTask.task, bukkitViaTask2.task)) {
                return true;
            }
        }
        return false;
    }
}

