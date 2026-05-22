/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;

class ConstantValueFactory$$Lambda$0
implements Function1 {
    private final PrimitiveType arg$0;

    public ConstantValueFactory$$Lambda$0(PrimitiveType primitiveType) {
        this.arg$0 = primitiveType;
    }

    public Object invoke(Object object) {
        return ConstantValueFactory.accessor$ConstantValueFactory$lambda0(this.arg$0, (ModuleDescriptor)object);
    }
}

