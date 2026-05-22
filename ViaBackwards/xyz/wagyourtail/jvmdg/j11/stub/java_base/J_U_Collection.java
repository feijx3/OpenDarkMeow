/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package ViaBackwards.xyz.wagyourtail.jvmdg.j11.stub.java_base;

import java.util.Collection;
import java.util.function.IntFunction;
import xyz.wagyourtail.jvmdg.version.Stub;

public class J_U_Collection {
    @Stub
    public static <T> T[] toArray(Collection<T> collection, IntFunction<T[]> generator) {
        return collection.toArray(generator.apply(0));
    }
}

