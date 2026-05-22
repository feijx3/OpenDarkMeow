/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

class MemberScope$Companion$$Lambda$0
implements Function1 {
    public static final MemberScope$Companion$$Lambda$0 INSTANCE = new MemberScope$Companion$$Lambda$0();

    public Object invoke(Object object) {
        return MemberScope.Companion.accessor$MemberScope$Companion$lambda0((Name)object);
    }
}

