/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.name.FqName;

class JavaTypeEnhancementState$Companion$$Lambda$0
implements Function1 {
    private final KotlinVersion arg$0;

    public JavaTypeEnhancementState$Companion$$Lambda$0(KotlinVersion kotlinVersion) {
        this.arg$0 = kotlinVersion;
    }

    public Object invoke(Object object) {
        return JavaTypeEnhancementState.Companion.accessor$JavaTypeEnhancementState$Companion$lambda0(this.arg$0, (FqName)object);
    }
}

