/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.command;

import baritone.api.IBaritone;
import baritone.api.command.ICommand;
import baritone.api.utils.IPlayerContext;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Command
implements ICommand {
    protected IBaritone baritone;
    protected IPlayerContext ctx;
    protected final List<String> names;

    protected Command(IBaritone iBaritone, String ... stringArray) {
        this.names = Collections.unmodifiableList(Stream.of(stringArray).map(string -> string.toLowerCase(Locale.US)).collect(Collectors.toList()));
        this.baritone = iBaritone;
        this.ctx = iBaritone.getPlayerContext();
    }

    @Override
    public final List<String> getNames() {
        return this.names;
    }
}

