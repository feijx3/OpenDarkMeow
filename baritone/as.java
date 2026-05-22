/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  aow
 *  ey
 *  hg
 *  hg$a
 *  hh
 *  hj
 *  hj$a
 *  ho
 *  nf
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.IBaritoneChatControl;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.datatypes.BlockById;
import baritone.api.command.helpers.TabCompleteHelper;
import baritone.api.utils.BetterBlockPos;
import baritone.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class as
extends Command {
    public as(IBaritone iBaritone) {
        super(iBaritone, "find");
    }

    @Override
    public final void execute(String hhArray, IArgConsumer object) {
        object.requireMin(1);
        hhArray = new ArrayList();
        while (object.hasAny()) {
            hhArray.add(object.getDatatypeFor(BlockById.INSTANCE));
        }
        object = this.ctx.playerFeet();
        if ((hhArray = (hh[])hhArray.stream().flatMap(arg_0 -> this.a((BetterBlockPos)((Object)object), arg_0)).map(BetterBlockPos::new).map(this::a).toArray(hh[]::new)).length > 0) {
            Arrays.asList(hhArray).forEach(hh2 -> this.logDirect((hh)hh2));
            return;
        }
        this.logDirect("No positions known, are you sure the blocks are cached?");
    }

    private hh a(BetterBlockPos betterBlockPos) {
        String string = String.format("%s %s %s", betterBlockPos.a, betterBlockPos.b, betterBlockPos.c);
        String string2 = String.format("%sgoal %s", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string);
        betterBlockPos = new ho(betterBlockPos.toString());
        ho ho2 = new ho("Click to set goal to this position");
        betterBlockPos.b().a(a.h).a(string).a(new hg(hg.a.c, string2)).a(new hj(hj.a.a, (hh)ho2));
        return betterBlockPos;
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return new TabCompleteHelper().append(l.a.stream().map(arg_0 -> ((ey)aow.h).b(arg_0)).map(Object::toString)).filterPrefixNamespaced(iArgConsumer.getString()).sortAlphabetically().stream();
    }

    @Override
    public final String getShortDesc() {
        return "Find positions of a certain block";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The find command searches through Baritone's cache and attempts to find the location of the block.", "Tab completion will suggest only cached blocks and uncached blocks can not be found.", "", "Usage:", "> find <block> [...] - Try finding the listed blocks");
    }

    private /* synthetic */ Stream a(BetterBlockPos betterBlockPos, aow aow2) {
        return this.ctx.worldData().getCachedWorld().getLocationsOf(((nf)aow.h.b((Object)aow2)).a(), Integer.MAX_VALUE, betterBlockPos.a, betterBlockPos.b, 4).stream();
    }
}

