/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u0002*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u001e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006*\u00020\u00072\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0000\u00a8\u0006\t"}, d2={"toClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "", "Lkotlin/reflect/jvm/internal/impl/km/ClassName;", "toNonLocalSimpleName", "loadKClass", "Lkotlin/reflect/KClass;", "Ljava/lang/ClassLoader;", "name", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nMetadataUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MetadataUtil.kt\nkotlin/reflect/jvm/internal/MetadataUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,30:1\n1#2:31\n*E\n"})
public final class MetadataUtilKt {
    @NotNull
    public static final ClassId toClassId(@NotNull String $this$toClassId) {
        String string;
        Intrinsics.checkNotNullParameter($this$toClassId, "<this>");
        boolean isLocal = StringsKt.startsWith$default($this$toClassId, ".", false, 2, null);
        if (isLocal) {
            String string2 = $this$toClassId.substring(1);
            string = string2;
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
        } else {
            string = $this$toClassId;
        }
        String fullName = string;
        return new ClassId(new FqName(StringsKt.replace$default(StringsKt.substringBeforeLast(fullName, '/', ""), '/', '.', false, 4, null)), new FqName(StringsKt.substringAfterLast$default(fullName, '/', null, 2, null)), isLocal);
    }

    @NotNull
    public static final String toNonLocalSimpleName(@NotNull String $this$toNonLocalSimpleName) {
        Intrinsics.checkNotNullParameter($this$toNonLocalSimpleName, "<this>");
        if (!(!StringsKt.startsWith$default($this$toNonLocalSimpleName, ".", false, 2, null))) {
            boolean bl2 = false;
            String string = "Local class is not supported: " + $this$toNonLocalSimpleName;
            throw new IllegalArgumentException(string.toString());
        }
        return StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default($this$toNonLocalSimpleName, '/', null, 2, null), '.', null, 2, null);
    }

    @Nullable
    public static final KClass<?> loadKClass(@NotNull ClassLoader $this$loadKClass, @NotNull String name) {
        Intrinsics.checkNotNullParameter($this$loadKClass, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Class clazz = UtilKt.loadClass$default($this$loadKClass, MetadataUtilKt.toClassId(name), 0, 2, null);
        return clazz != null ? JvmClassMappingKt.getKotlinClass(clazz) : null;
    }
}

