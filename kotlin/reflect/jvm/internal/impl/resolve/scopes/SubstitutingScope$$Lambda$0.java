/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

class SubstitutingScope$$Lambda$0
implements Function0 {
    private final TypeSubstitutor arg$0;

    public SubstitutingScope$$Lambda$0(TypeSubstitutor typeSubstitutor2) {
        this.arg$0 = typeSubstitutor2;
    }

    public Object invoke() {
        return SubstitutingScope.accessor$SubstitutingScope$lambda0(this.arg$0);
    }
}

