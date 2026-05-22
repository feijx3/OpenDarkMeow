/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;

class BuiltInAnnotationDescriptor$$Lambda$0
implements Function0 {
    private final BuiltInAnnotationDescriptor arg$0;

    public BuiltInAnnotationDescriptor$$Lambda$0(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        this.arg$0 = builtInAnnotationDescriptor;
    }

    public Object invoke() {
        return BuiltInAnnotationDescriptor.accessor$BuiltInAnnotationDescriptor$lambda0(this.arg$0);
    }
}

