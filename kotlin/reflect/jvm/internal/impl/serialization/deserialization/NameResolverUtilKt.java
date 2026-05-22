/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class NameResolverUtilKt {
    @NotNull
    public static final ClassId getClassId(@NotNull NameResolver $this$getClassId, int index) {
        Intrinsics.checkNotNullParameter($this$getClassId, "<this>");
        return ClassId.Companion.fromString($this$getClassId.getQualifiedClassName(index), $this$getClassId.isLocalClassName(index));
    }

    @NotNull
    public static final Name getName(@NotNull NameResolver $this$getName, int index) {
        Intrinsics.checkNotNullParameter($this$getName, "<this>");
        Name name = Name.guessByFirstCharacter($this$getName.getString(index));
        Intrinsics.checkNotNullExpressionValue(name, "guessByFirstCharacter(...)");
        return name;
    }
}

