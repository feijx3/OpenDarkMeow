/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

public final class BuiltinSpecialPropertiesKt {
    private static final FqName child(FqName $this$child, String name) {
        Name name2 = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        return $this$child.child(name2);
    }

    private static final FqName childSafe(FqNameUnsafe $this$childSafe, String name) {
        Name name2 = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        return $this$childSafe.child(name2).toSafe();
    }

    public static final /* synthetic */ FqName access$childSafe(FqNameUnsafe $receiver, String name) {
        return BuiltinSpecialPropertiesKt.childSafe($receiver, name);
    }

    public static final /* synthetic */ FqName access$child(FqName $receiver, String name) {
        return BuiltinSpecialPropertiesKt.child($receiver, name);
    }
}

