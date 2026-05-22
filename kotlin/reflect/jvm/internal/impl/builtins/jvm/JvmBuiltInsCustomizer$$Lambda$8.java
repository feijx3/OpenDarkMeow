/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class JvmBuiltInsCustomizer$$Lambda$8
implements DFS.Neighbors {
    private final JvmBuiltInsCustomizer arg$0;

    public JvmBuiltInsCustomizer$$Lambda$8(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.arg$0 = jvmBuiltInsCustomizer;
    }

    public Iterable getNeighbors(Object object) {
        return JvmBuiltInsCustomizer.accessor$JvmBuiltInsCustomizer$lambda8(this.arg$0, (ClassDescriptor)object);
    }
}

