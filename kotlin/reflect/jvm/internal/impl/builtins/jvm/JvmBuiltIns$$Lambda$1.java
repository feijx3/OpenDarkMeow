/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

class JvmBuiltIns$$Lambda$1
implements Function0 {
    private final ModuleDescriptor arg$0;
    private final boolean arg$1;

    public JvmBuiltIns$$Lambda$1(ModuleDescriptor moduleDescriptor, boolean bl2) {
        this.arg$0 = moduleDescriptor;
        this.arg$1 = bl2;
    }

    public Object invoke() {
        return JvmBuiltIns.accessor$JvmBuiltIns$lambda1(this.arg$0, this.arg$1);
    }
}

