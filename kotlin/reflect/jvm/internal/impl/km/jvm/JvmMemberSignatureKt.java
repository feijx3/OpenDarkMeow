/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import org.jetbrains.annotations.NotNull;

public final class JvmMemberSignatureKt {
    @NotNull
    public static final JvmMethodSignature wrapAsPublic(@NotNull JvmMemberSignature.Method $this$wrapAsPublic) {
        Intrinsics.checkNotNullParameter($this$wrapAsPublic, "<this>");
        return new JvmMethodSignature($this$wrapAsPublic.getName(), $this$wrapAsPublic.getDesc());
    }

    @NotNull
    public static final JvmFieldSignature wrapAsPublic(@NotNull JvmMemberSignature.Field $this$wrapAsPublic) {
        Intrinsics.checkNotNullParameter($this$wrapAsPublic, "<this>");
        return new JvmFieldSignature($this$wrapAsPublic.getName(), $this$wrapAsPublic.getDesc());
    }
}

