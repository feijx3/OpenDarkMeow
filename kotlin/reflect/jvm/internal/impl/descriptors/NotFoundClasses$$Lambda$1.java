/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;

class NotFoundClasses$$Lambda$1
implements Function1 {
    private final NotFoundClasses arg$0;

    public NotFoundClasses$$Lambda$1(NotFoundClasses notFoundClasses) {
        this.arg$0 = notFoundClasses;
    }

    public Object invoke(Object object) {
        return NotFoundClasses.accessor$NotFoundClasses$lambda1(this.arg$0, (NotFoundClasses.ClassRequest)object);
    }
}

