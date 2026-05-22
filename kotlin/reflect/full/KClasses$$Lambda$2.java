/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class KClasses$$Lambda$2
implements DFS.Neighbors {
    private final KProperty1 arg$0;

    public KClasses$$Lambda$2(KProperty1 kProperty1) {
        this.arg$0 = kProperty1;
    }

    public Iterable getNeighbors(Object object) {
        return KClasses.accessor$KClasses$lambda2(this.arg$0, (KClass)object);
    }
}

