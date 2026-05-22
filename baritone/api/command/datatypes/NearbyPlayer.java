/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aed
 */
package baritone.api.command.datatypes;

import baritone.api.command.datatypes.IDatatypeContext;
import baritone.api.command.datatypes.IDatatypeFor;
import baritone.api.command.helpers.TabCompleteHelper;
import java.util.List;
import java.util.stream.Stream;

public enum NearbyPlayer implements IDatatypeFor<aed>
{
    INSTANCE;


    @Override
    public final aed get(IDatatypeContext iDatatypeContext) {
        String string = iDatatypeContext.getConsumer().getString();
        return NearbyPlayer.getPlayers(iDatatypeContext).stream().filter(aed2 -> aed2.h_().equalsIgnoreCase(string)).findFirst().orElse(null);
    }

    @Override
    public final Stream<String> tabComplete(IDatatypeContext iDatatypeContext) {
        return new TabCompleteHelper().append(NearbyPlayer.getPlayers(iDatatypeContext).stream().map(aed::h_)).filterPrefix(iDatatypeContext.getConsumer().getString()).sortAlphabetically().stream();
    }

    private static List<aed> getPlayers(IDatatypeContext iDatatypeContext) {
        return iDatatypeContext.getBaritone().getPlayerContext().world().i;
    }
}

