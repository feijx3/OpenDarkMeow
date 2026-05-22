/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;

class SpecialBuiltinMembers$$Lambda$0
implements Function1 {
    public static final SpecialBuiltinMembers$$Lambda$0 INSTANCE = new SpecialBuiltinMembers$$Lambda$0();

    public Object invoke(Object object) {
        return SpecialBuiltinMembers.accessor$SpecialBuiltinMembers$lambda0((CallableMemberDescriptor)object);
    }
}

