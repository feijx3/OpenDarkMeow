/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class bd
extends Command {
    public bd(IBaritone iBaritone) {
        super(iBaritone, "reloadall");
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        iArgConsumer.requireMax(0);
        this.ctx.worldData().getCachedWorld().reloadAllFromDisk();
        this.logDirect("Reloaded");
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Reloads Baritone's cache for this world";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The reloadall command reloads Baritone's world cache.", "", "Usage:", "> reloadall");
    }
}

