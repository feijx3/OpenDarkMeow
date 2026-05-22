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

public final class az
extends Command {
    public az(IBaritone iBaritone) {
        super(iBaritone, "litematica");
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        int n2 = 0;
        if (iArgConsumer.hasAny()) {
            iArgConsumer.requireMax(1);
            if (iArgConsumer.is(Integer.class)) {
                n2 = iArgConsumer.getAs(Integer.class) - 1;
            }
        }
        try {
            this.baritone.getBuilderProcess().buildOpenLitematic(n2);
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.logDirect("Pleas provide a valid index.");
            return;
        }
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
        return Arrays.asList("Build a schematic currently open in Litematica.", "", "Usage:", "> litematica", "> litematica <#>");
    }
}

