/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class KotlinTypeFactory$$Lambda$1
implements Function1 {
    private final TypeConstructor arg$0;
    private final List arg$1;
    private final TypeAttributes arg$2;
    private final boolean arg$3;
    private final MemberScope arg$4;

    public KotlinTypeFactory$$Lambda$1(TypeConstructor typeConstructor2, List list, TypeAttributes typeAttributes, boolean bl2, MemberScope memberScope) {
        this.arg$0 = typeConstructor2;
        this.arg$1 = list;
        this.arg$2 = typeAttributes;
        this.arg$3 = bl2;
        this.arg$4 = memberScope;
    }

    public Object invoke(Object object) {
        return KotlinTypeFactory.accessor$KotlinTypeFactory$lambda1(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, (KotlinTypeRefiner)object);
    }
}

