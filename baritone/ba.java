/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.datatypes.ForBlockOptionalMeta;
import baritone.api.utils.BlockOptionalMeta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class ba
extends Command {
    public ba(IBaritone iBaritone) {
        super(iBaritone, "mine");
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        int n2 = iArgConsumer.getAsOrDefault(Integer.class, 0);
        iArgConsumer.requireMin(1);
        ArrayList arrayList = new ArrayList();
        while (iArgConsumer.hasAny()) {
            arrayList.add(iArgConsumer.getDatatypeFor(ForBlockOptionalMeta.INSTANCE));
        }
        BaritoneAPI.getProvider().getWorldScanner().repack(this.ctx);
        this.logDirect(String.format("Mining %s", ((Object)arrayList).toString()));
        this.baritone.getMineProcess().mine(n2, arrayList.toArray(new BlockOptionalMeta[0]));
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        iArgConsumer.getAsOrDefault(Integer.class, 0);
        while (iArgConsumer.has(2)) {
            iArgConsumer.getDatatypeFor(ForBlockOptionalMeta.INSTANCE);
        }
        return iArgConsumer.tabCompleteDatatype(ForBlockOptionalMeta.INSTANCE);
    }

    @Override
    public final String getShortDesc() {
        return "Mine some blocks";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The mine command allows you to tell Baritone to search for and mine individual blocks.", "", "The specified blocks can be ores (which are commonly cached), or any other block.", "", "Also see the legitMine settings (see #set l legitMine).", "", "Usage:", "> mine diamond_ore - Mines all diamonds it can find.", "> mine redstone_ore lit_redstone_ore - Mines redstone ore.", "> mine log:0 - Mines only oak logs.");
    }
}

