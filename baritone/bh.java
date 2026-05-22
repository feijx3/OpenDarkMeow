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

public final class bh
extends Command {
    public bh(IBaritone iBaritone) {
        super(iBaritone, "schematica");
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        iArgConsumer.requireMax(0);
        this.baritone.getBuilderProcess().buildOpenSchematic();
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Builds the loaded schematic";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("Builds the schematic currently open in Schematica.", "", "Usage:", "> schematica");
    }
}

