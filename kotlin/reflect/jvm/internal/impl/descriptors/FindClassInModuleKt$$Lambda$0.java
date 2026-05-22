/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

class FindClassInModuleKt$$Lambda$0
implements Function1 {
    public static final FindClassInModuleKt$$Lambda$0 INSTANCE = new FindClassInModuleKt$$Lambda$0();

    public Object invoke(Object object) {
        return FindClassInModuleKt.accessor$FindClassInModuleKt$lambda0((ClassId)object);
    }
}

