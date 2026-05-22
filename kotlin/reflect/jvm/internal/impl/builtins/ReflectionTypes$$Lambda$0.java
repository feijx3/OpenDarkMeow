/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

class ReflectionTypes$$Lambda$0
implements Function0 {
    private final ModuleDescriptor arg$0;

    public ReflectionTypes$$Lambda$0(ModuleDescriptor moduleDescriptor) {
        this.arg$0 = moduleDescriptor;
    }

    public Object invoke() {
        return ReflectionTypes.accessor$ReflectionTypes$lambda0(this.arg$0);
    }
}

