/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class KClasses$$Lambda$1
implements DFS.Neighbors {
    public static final KClasses$$Lambda$1 INSTANCE = new KClasses$$Lambda$1();

    public Iterable getNeighbors(Object object) {
        return KClasses.accessor$KClasses$lambda1((KType)object);
    }
}

