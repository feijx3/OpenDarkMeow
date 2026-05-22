/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

class JvmBuiltInsCustomizer$$Lambda$4
implements Function1 {
    private final Name arg$0;

    public JvmBuiltInsCustomizer$$Lambda$4(Name name) {
        this.arg$0 = name;
    }

    public Object invoke(Object object) {
        return JvmBuiltInsCustomizer.accessor$JvmBuiltInsCustomizer$lambda4(this.arg$0, (MemberScope)object);
    }
}

