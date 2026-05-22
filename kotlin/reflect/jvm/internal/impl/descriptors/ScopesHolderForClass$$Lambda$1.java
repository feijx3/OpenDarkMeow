/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class ScopesHolderForClass$$Lambda$1
implements Function0 {
    private final ScopesHolderForClass arg$0;
    private final KotlinTypeRefiner arg$1;

    public ScopesHolderForClass$$Lambda$1(ScopesHolderForClass scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
        this.arg$0 = scopesHolderForClass;
        this.arg$1 = kotlinTypeRefiner;
    }

    public Object invoke() {
        return ScopesHolderForClass.accessor$ScopesHolderForClass$lambda1(this.arg$0, this.arg$1);
    }
}

