/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

public final class ReflectKotlinClassFinderKt {
    private static final String toRuntimeFqName(ClassId $this$toRuntimeFqName) {
        String className = StringsKt.replace$default($this$toRuntimeFqName.getRelativeClassName().asString(), '.', '$', false, 4, null);
        return $this$toRuntimeFqName.getPackageFqName().isRoot() ? className : $this$toRuntimeFqName.getPackageFqName() + '.' + className;
    }

    public static final /* synthetic */ String access$toRuntimeFqName(ClassId $receiver) {
        return ReflectKotlinClassFinderKt.toRuntimeFqName($receiver);
    }
}

