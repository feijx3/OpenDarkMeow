/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.papermc.paper.threadedregions.scheduler.ScheduledTask
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.bukkit.platform;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.platform.PlatformTask;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="task", type=ScheduledTask.class)})
public final class FoliaViaTask
extends J_L_Record
implements PlatformTask<ScheduledTask> {
    private final ScheduledTask task;

    public FoliaViaTask(ScheduledTask task) {
        this.task = task;
    }

    @Override
    public void cancel() {
        this.task.cancel();
    }

    @Override
    public final String toString() {
        return FoliaViaTask.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return FoliaViaTask.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return FoliaViaTask.jvmdowngrader$equals$equals(this, o2);
    }

    public ScheduledTask task() {
        return this.task;
    }

    private static String jvmdowngrader$toString$toString(FoliaViaTask foliaViaTask) {
        FoliaViaTask foliaViaTask2 = foliaViaTask;
        return "FoliaViaTask[" + "task=" + foliaViaTask.task + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(FoliaViaTask foliaViaTask) {
        Object[] objectArray = new Object[]{foliaViaTask.task};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(FoliaViaTask foliaViaTask, Object object) {
        if (foliaViaTask == object) {
            return true;
        }
        if (object != null && object instanceof FoliaViaTask) {
            FoliaViaTask foliaViaTask2 = (FoliaViaTask)object;
            if (Objects.equals(foliaViaTask.task, foliaViaTask2.task)) {
                return true;
            }
        }
        return false;
    }
}

