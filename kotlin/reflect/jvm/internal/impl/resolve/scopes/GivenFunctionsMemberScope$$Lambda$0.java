/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;

class GivenFunctionsMemberScope$$Lambda$0
implements Function0 {
    private final GivenFunctionsMemberScope arg$0;

    public GivenFunctionsMemberScope$$Lambda$0(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        this.arg$0 = givenFunctionsMemberScope;
    }

    public Object invoke() {
        return GivenFunctionsMemberScope.accessor$GivenFunctionsMemberScope$lambda0(this.arg$0);
    }
}

