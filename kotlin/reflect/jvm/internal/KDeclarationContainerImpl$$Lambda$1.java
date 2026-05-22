/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;

class KDeclarationContainerImpl$$Lambda$1
implements Comparator {
    private final Function2 arg$0;

    public KDeclarationContainerImpl$$Lambda$1(Function2 function2) {
        this.arg$0 = function2;
    }

    public int compare(Object object, Object object2) {
        return KDeclarationContainerImpl.accessor$KDeclarationContainerImpl$lambda1(this.arg$0, object, object2);
    }
}

