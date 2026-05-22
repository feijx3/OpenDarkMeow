/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;

class AnnotationUtilKt$$Lambda$0
implements Function1 {
    private final KotlinBuiltIns arg$0;

    public AnnotationUtilKt$$Lambda$0(KotlinBuiltIns kotlinBuiltIns) {
        this.arg$0 = kotlinBuiltIns;
    }

    public Object invoke(Object object) {
        return AnnotationUtilKt.accessor$AnnotationUtilKt$lambda0(this.arg$0, (ModuleDescriptor)object);
    }
}

