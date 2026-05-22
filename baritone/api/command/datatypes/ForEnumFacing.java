/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  fa
 */
package baritone.api.command.datatypes;

import baritone.api.command.datatypes.IDatatypeContext;
import baritone.api.command.datatypes.IDatatypeFor;
import baritone.api.command.helpers.TabCompleteHelper;
import java.util.Locale;
import java.util.stream.Stream;

public enum ForEnumFacing implements IDatatypeFor<fa>
{
    INSTANCE;


    @Override
    public final fa get(IDatatypeContext iDatatypeContext) {
        return fa.valueOf((String)iDatatypeContext.getConsumer().getString().toUpperCase(Locale.US));
    }

    @Override
    public final Stream<String> tabComplete(IDatatypeContext iDatatypeContext) {
        return new TabCompleteHelper().append(Stream.of(fa.values()).map(fa::m).map(String::toLowerCase)).filterPrefix(iDatatypeContext.getConsumer().getString()).stream();
    }
}

