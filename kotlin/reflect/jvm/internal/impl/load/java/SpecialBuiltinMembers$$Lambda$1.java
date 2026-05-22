/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;

class SpecialBuiltinMembers$$Lambda$1
implements Function1 {
    public static final SpecialBuiltinMembers$$Lambda$1 INSTANCE = new SpecialBuiltinMembers$$Lambda$1();

    public Object invoke(Object object) {
        return SpecialBuiltinMembers.accessor$SpecialBuiltinMembers$lambda1((CallableMemberDescriptor)object);
    }
}

