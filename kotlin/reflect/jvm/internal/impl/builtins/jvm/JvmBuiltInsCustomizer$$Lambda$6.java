/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class JvmBuiltInsCustomizer$$Lambda$6
implements DFS.Neighbors {
    public static final JvmBuiltInsCustomizer$$Lambda$6 INSTANCE = new JvmBuiltInsCustomizer$$Lambda$6();

    public Iterable getNeighbors(Object object) {
        return JvmBuiltInsCustomizer.accessor$JvmBuiltInsCustomizer$lambda6((CallableMemberDescriptor)object);
    }
}

