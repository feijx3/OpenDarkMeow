/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"})
public final class RuntimeTypeMapperKt {
    private static final String getSignature(Method $this$signature) {
        StringBuilder stringBuilder = new StringBuilder().append($this$signature.getName());
        Class<?>[] classArray = $this$signature.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(classArray, "getParameterTypes(...)");
        StringBuilder stringBuilder2 = stringBuilder.append(ArraysKt.joinToString$default(classArray, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (Function1)RuntimeTypeMapperKt$$Lambda$0.INSTANCE, 24, null));
        Class<?> clazz = $this$signature.getReturnType();
        Intrinsics.checkNotNullExpressionValue(clazz, "getReturnType(...)");
        return stringBuilder2.append(ReflectClassUtilKt.getDesc(clazz)).toString();
    }

    private static final CharSequence _get_signature_$lambda$0(Class it) {
        Intrinsics.checkNotNull(it);
        return ReflectClassUtilKt.getDesc(it);
    }

    public static final /* synthetic */ String access$getSignature(Method $receiver) {
        return RuntimeTypeMapperKt.getSignature($receiver);
    }

    static /* synthetic */ CharSequence accessor$RuntimeTypeMapperKt$lambda0(Class clazz) {
        return RuntimeTypeMapperKt._get_signature_$lambda$0(clazz);
    }
}

