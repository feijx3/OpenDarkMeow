/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nf
 *  vg
 *  vi
 */
package baritone.api.command.datatypes;

import baritone.api.command.datatypes.IDatatypeContext;
import baritone.api.command.datatypes.IDatatypeFor;
import baritone.api.command.helpers.TabCompleteHelper;
import java.util.stream.Stream;

public enum EntityClassById implements IDatatypeFor<Class<? extends vg>>
{
    INSTANCE;


    @Override
    public final Class<? extends vg> get(IDatatypeContext iDatatypeContext) {
        Class clazz;
        iDatatypeContext = new nf(iDatatypeContext.getConsumer().getString());
        try {
            clazz = (Class)vi.b.c((Object)iDatatypeContext);
        }
        catch (NoSuchFieldError noSuchFieldError) {
            try {
                clazz = (Class)vi.class.getMethod("getClass", nf.class).invoke(null, iDatatypeContext);
            }
            catch (Exception exception) {
                throw new RuntimeException("EntityList.REGISTRY does not exist and failed to call the Forge-replacement method", exception);
            }
        }
        if (clazz == null) {
            throw new IllegalArgumentException("no entity found by that id");
        }
        return clazz;
    }

    @Override
    public final Stream<String> tabComplete(IDatatypeContext iDatatypeContext) {
        return new TabCompleteHelper().append(vi.a().stream().map(Object::toString)).filterPrefixNamespaced(iDatatypeContext.getConsumer().getString()).sortAlphabetically().stream();
    }
}

