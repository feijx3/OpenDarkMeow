/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.exception.CommandInvalidStateException;
import baritone.api.process.PathingCommand;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class bc
extends Command {
    public bc(IBaritone iBaritone) {
        super(iBaritone, "proc");
    }

    @Override
    public final void execute(String object, IArgConsumer object2) {
        object2.requireMax(0);
        object = this.baritone.getPathingControlManager();
        object2 = object.mostRecentInControl().orElse(null);
        if (object2 == null) {
            throw new CommandInvalidStateException("No process in control");
        }
        this.logDirect(String.format("Class: %s\nPriority: %f\nTemporary: %b\nDisplay name: %s\nLast command: %s", object2.getClass().getTypeName(), object2.priority(), object2.isTemporary(), object2.displayName(), object.mostRecentCommand().map(PathingCommand::toString).orElse("None")));
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "View process state information";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The proc command provides miscellaneous information about the process currently controlling Baritone.", "", "You are not expected to understand this if you aren't familiar with how Baritone works.", "", "Usage:", "> proc - View process information, if present");
    }
}

