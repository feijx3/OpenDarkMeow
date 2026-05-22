/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.pathing.goals.Goal;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.bz;

public final class fd
extends PathingCommand {
    public final bz a;

    public fd(Goal goal, PathingCommandType pathingCommandType, bz bz2) {
        super(goal, pathingCommandType);
        this.a = bz2;
    }
}

