/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalAxis;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class ab
extends Command {
    public ab(IBaritone iBaritone) {
        super(iBaritone, "axis", "highway");
    }

    @Override
    public final void execute(String object, IArgConsumer iArgConsumer) {
        iArgConsumer.requireMax(0);
        object = new GoalAxis();
        this.baritone.getCustomGoalProcess().setGoal((Goal)object);
        this.logDirect(String.format("Goal: %s", object.toString()));
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Set a goal to the axes";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The axis command sets a goal that tells Baritone to head towards the nearest axis. That is, X=0 or Z=0.", "", "Usage:", "> axis");
    }
}

