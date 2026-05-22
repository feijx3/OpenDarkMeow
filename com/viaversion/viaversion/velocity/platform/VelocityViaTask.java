/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.velocitypowered.api.scheduler.ScheduledTask
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.velocity.platform;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.velocitypowered.api.scheduler.ScheduledTask;
import com.viaversion.viaversion.api.platform.PlatformTask;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="task", type=ScheduledTask.class)})
public final class VelocityViaTask
extends J_L_Record
implements PlatformTask<ScheduledTask> {
    private final ScheduledTask task;

    public VelocityViaTask(ScheduledTask task) {
        this.task = task;
    }

    @Override
    public void cancel() {
        this.task.cancel();
    }

    @Override
    public final String toString() {
        return VelocityViaTask.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return VelocityViaTask.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return VelocityViaTask.jvmdowngrader$equals$equals(this, o2);
    }

    public ScheduledTask task() {
        return this.task;
    }

    private static String jvmdowngrader$toString$toString(VelocityViaTask velocityViaTask) {
        VelocityViaTask velocityViaTask2 = velocityViaTask;
        return "VelocityViaTask[" + "task=" + velocityViaTask.task + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(VelocityViaTask velocityViaTask) {
        Object[] objectArray = new Object[]{velocityViaTask.task};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(VelocityViaTask velocityViaTask, Object object) {
        if (velocityViaTask == object) {
            return true;
        }
        if (object != null && object instanceof VelocityViaTask) {
            VelocityViaTask velocityViaTask2 = (VelocityViaTask)object;
            if (Objects.equals(velocityViaTask.task, velocityViaTask2.task)) {
                return true;
            }
        }
        return false;
    }
}

