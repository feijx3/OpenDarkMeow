/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;

class ModuleDescriptorImpl$$Lambda$0
implements Function1 {
    private final ModuleDescriptorImpl arg$0;

    public ModuleDescriptorImpl$$Lambda$0(ModuleDescriptorImpl moduleDescriptorImpl) {
        this.arg$0 = moduleDescriptorImpl;
    }

    public Object invoke(Object object) {
        return ModuleDescriptorImpl.accessor$ModuleDescriptorImpl$lambda0(this.arg$0, (FqName)object);
    }
}

