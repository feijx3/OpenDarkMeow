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

public final class au
extends Command {
    public au(IBaritone iBaritone) {
        super(iBaritone, "gc");
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        iArgConsumer.requireMax(0);
        System.gc();
        this.logDirect("ok called System.gc()");
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Call System.gc()";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("Calls System.gc().", "", "Usage:", "> gc");
    }
}

