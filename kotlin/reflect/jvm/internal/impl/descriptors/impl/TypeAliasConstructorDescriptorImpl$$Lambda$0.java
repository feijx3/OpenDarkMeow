/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl;

class TypeAliasConstructorDescriptorImpl$$Lambda$0
implements Function0 {
    private final TypeAliasConstructorDescriptorImpl arg$0;
    private final ClassConstructorDescriptor arg$1;

    public TypeAliasConstructorDescriptorImpl$$Lambda$0(TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, ClassConstructorDescriptor classConstructorDescriptor) {
        this.arg$0 = typeAliasConstructorDescriptorImpl;
        this.arg$1 = classConstructorDescriptor;
    }

    public Object invoke() {
        return TypeAliasConstructorDescriptorImpl.accessor$TypeAliasConstructorDescriptorImpl$lambda0(this.arg$0, this.arg$1);
    }
}

