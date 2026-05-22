/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmName
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"jvmName", "", "Lkotlin/reflect/KClass;", "getJvmName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "kotlin-reflection"})
@JvmName(name="KClassesJvm")
public final class KClassesJvm {
    @NotNull
    public static final String getJvmName(@NotNull KClass<?> $this$jvmName) {
        Intrinsics.checkNotNullParameter($this$jvmName, "<this>");
        String string = ((KClassImpl)$this$jvmName).getJClass().getName();
        Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
        return string;
    }
}

