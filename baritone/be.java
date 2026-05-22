/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.utils.BetterBlockPos;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class be
extends Command {
    public be(IBaritone iBaritone) {
        super(iBaritone, "render");
    }

    @Override
    public final void execute(String object, IArgConsumer iArgConsumer) {
        iArgConsumer.requireMax(0);
        object = this.ctx.playerFeet();
        int n2 = this.ctx.minecraft().t.e + 1 << 4;
        this.ctx.minecraft().g.a(((BetterBlockPos)((Object)object)).a - n2, 0, ((BetterBlockPos)((Object)object)).c - n2, ((BetterBlockPos)((Object)object)).a + n2, 255, ((BetterBlockPos)((Object)object)).c + n2);
        this.logDirect("Done");
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Fix glitched chunks";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The render command fixes glitched chunk rendering without having to reload all of them.", "", "Usage:", "> render");
    }
}

