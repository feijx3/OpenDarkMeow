/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\njavaTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 javaTypes.kt\norg/jetbrains/kotlin/load/java/structure/JavaTypesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(@Nullable JavaType $this$isSuperWildcard) {
        boolean bl2;
        JavaWildcardType javaWildcardType = $this$isSuperWildcard instanceof JavaWildcardType ? (JavaWildcardType)$this$isSuperWildcard : null;
        if (javaWildcardType != null) {
            JavaWildcardType it = javaWildcardType;
            boolean bl3 = false;
            bl2 = it.getBound() != null && !it.isExtends();
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

