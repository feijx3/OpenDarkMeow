/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaEnumValueAnnotationArgument
extends ReflectJavaAnnotationArgument
implements JavaEnumValueAnnotationArgument {
    @NotNull
    private final Enum<?> value;

    public ReflectJavaEnumValueAnnotationArgument(@Nullable Name name, @NotNull Enum<?> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super(name, null);
        this.value = value;
    }

    @Override
    @Nullable
    public ClassId getEnumClassId() {
        Class<?> clazz = this.value.getClass();
        Class<?> enumClass = clazz.isEnum() ? clazz : clazz.getEnclosingClass();
        Intrinsics.checkNotNull(enumClass);
        return ReflectClassUtilKt.getClassId(enumClass);
    }

    @Override
    @Nullable
    public Name getEntryName() {
        return Name.identifier(this.value.name());
    }
}

