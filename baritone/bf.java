/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class bf
extends Command {
    public bf(IBaritone iBaritone) {
        super(iBaritone, "repack", "rescan");
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        iArgConsumer.requireMax(0);
        this.logDirect(String.format("Queued %d chunks for repacking", BaritoneAPI.getProvider().getWorldScanner().repack(this.ctx)));
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Re-cache chunks";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("Repack chunks around you. This basically re-caches them.", "", "Usage:", "> repack - Repack chunks.");
    }
}

