/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class LazyJavaStaticClassScope$$Lambda$3
implements DFS.Neighbors {
    public static final LazyJavaStaticClassScope$$Lambda$3 INSTANCE = new LazyJavaStaticClassScope$$Lambda$3();

    public Iterable getNeighbors(Object object) {
        return LazyJavaStaticClassScope.accessor$LazyJavaStaticClassScope$lambda3((ClassDescriptor)object);
    }
}

