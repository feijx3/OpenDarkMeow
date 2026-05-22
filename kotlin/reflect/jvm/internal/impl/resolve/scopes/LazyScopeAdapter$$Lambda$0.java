/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;

class LazyScopeAdapter$$Lambda$0
implements Function0 {
    private final Function0 arg$0;

    public LazyScopeAdapter$$Lambda$0(Function0 function0) {
        this.arg$0 = function0;
    }

    public Object invoke() {
        return LazyScopeAdapter.accessor$LazyScopeAdapter$lambda0(this.arg$0);
    }
}

