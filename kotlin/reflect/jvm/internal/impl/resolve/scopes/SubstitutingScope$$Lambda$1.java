/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;

class SubstitutingScope$$Lambda$1
implements Function0 {
    private final SubstitutingScope arg$0;

    public SubstitutingScope$$Lambda$1(SubstitutingScope substitutingScope) {
        this.arg$0 = substitutingScope;
    }

    public Object invoke() {
        return SubstitutingScope.accessor$SubstitutingScope$lambda1(this.arg$0);
    }
}

