/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  aox
 *  nf
 */
package baritone.api.command.datatypes;

import baritone.api.command.datatypes.IDatatypeContext;
import baritone.api.command.datatypes.IDatatypeFor;
import baritone.api.command.helpers.TabCompleteHelper;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public enum BlockById implements IDatatypeFor<aow>
{
    INSTANCE;

    private static Pattern PATTERN;

    @Override
    public final aow get(IDatatypeContext iDatatypeContext) {
        iDatatypeContext = new nf(iDatatypeContext.getConsumer().getString());
        if ((iDatatypeContext = (aow)aow.h.c((Object)iDatatypeContext)) == aox.a) {
            throw new IllegalArgumentException("no block found by that id");
        }
        return iDatatypeContext;
    }

    @Override
    public final Stream<String> tabComplete(IDatatypeContext object) {
        if (!PATTERN.matcher((CharSequence)(object = object.getConsumer().getString())).matches()) {
            return Stream.empty();
        }
        return new TabCompleteHelper().append(aow.h.c().stream().map(Object::toString)).filterPrefixNamespaced((String)object).sortAlphabetically().stream();
    }

    static {
        PATTERN = Pattern.compile("(?:[a-z0-9_.-]+:)?[a-z0-9/_.-]*");
    }
}

