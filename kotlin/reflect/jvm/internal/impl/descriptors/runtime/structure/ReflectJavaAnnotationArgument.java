/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaAnnotationArgument
implements JavaAnnotationArgument {
    @NotNull
    public static final Factory Factory = new Factory(null);
    @Nullable
    private final Name name;

    private ReflectJavaAnnotationArgument(Name name) {
        this.name = name;
    }

    @Override
    @Nullable
    public Name getName() {
        return this.name;
    }

    public /* synthetic */ ReflectJavaAnnotationArgument(Name name, DefaultConstructorMarker $constructor_marker) {
        this(name);
    }

    public static final class Factory {
        private Factory() {
        }

        @NotNull
        public final ReflectJavaAnnotationArgument create(@NotNull Object value, @Nullable Name name) {
            Intrinsics.checkNotNullParameter(value, "value");
            return ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(value.getClass()) ? (ReflectJavaAnnotationArgument)new ReflectJavaEnumValueAnnotationArgument(name, (Enum)value) : (value instanceof Annotation ? (ReflectJavaAnnotationArgument)new ReflectJavaAnnotationAsAnnotationArgument(name, (Annotation)value) : (value instanceof Object[] ? (ReflectJavaAnnotationArgument)new ReflectJavaArrayAnnotationArgument(name, (Object[])value) : (value instanceof Class ? (ReflectJavaAnnotationArgument)new ReflectJavaClassObjectAnnotationArgument(name, (Class)value) : (ReflectJavaAnnotationArgument)new ReflectJavaLiteralAnnotationArgument(name, value))));
        }

        public /* synthetic */ Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

