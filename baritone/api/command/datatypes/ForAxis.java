/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  fa$a
 */
package baritone.api.command.datatypes;

import baritone.api.command.datatypes.IDatatypeContext;
import baritone.api.command.datatypes.IDatatypeFor;
import baritone.api.command.helpers.TabCompleteHelper;
import java.util.Locale;
import java.util.stream.Stream;

public enum ForAxis implements IDatatypeFor<fa.a>
{
    INSTANCE;


    @Override
    public final fa.a get(IDatatypeContext iDatatypeContext) {
        return fa.a.valueOf((String)iDatatypeContext.getConsumer().getString().toUpperCase(Locale.US));
    }

    @Override
    public final Stream<String> tabComplete(IDatatypeContext iDatatypeContext) {
        return new TabCompleteHelper().append(Stream.of(fa.a.values()).map(fa.a::m).map(String::toLowerCase)).filterPrefix(iDatatypeContext.getConsumer().getString()).stream();
    }
}

