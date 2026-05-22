/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class JvmAbi {
    @NotNull
    public static final JvmAbi INSTANCE = new JvmAbi();
    @JvmField
    @NotNull
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmField");
    @JvmField
    @NotNull
    public static final ClassId JVM_FIELD_ANNOTATION_CLASS_ID = ClassId.Companion.topLevel(JVM_FIELD_ANNOTATION_FQ_NAME);
    @NotNull
    private static final ClassId REFLECTION_FACTORY_IMPL = ClassId.Companion.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    @NotNull
    private static final ClassId REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);

    private JvmAbi() {
    }

    @NotNull
    public final ClassId getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION() {
        return REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;
    }

    @JvmStatic
    public static final boolean isGetterName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.startsWith$default(name, "get", false, 2, null) || StringsKt.startsWith$default(name, "is", false, 2, null);
    }

    @JvmStatic
    public static final boolean isSetterName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.startsWith$default(name, "set", false, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final String getterName(@NotNull String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        return JvmAbi.startsWithIsPrefix(propertyName) ? propertyName : "get" + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
    }

    @JvmStatic
    @NotNull
    public static final String setterName(@NotNull String propertyName) {
        String string;
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        StringBuilder stringBuilder = new StringBuilder().append("set");
        if (JvmAbi.startsWithIsPrefix(propertyName)) {
            String string2 = propertyName.substring(2);
            string = string2;
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
        } else {
            string = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
        }
        return stringBuilder.append(string).toString();
    }

    @JvmStatic
    public static final boolean startsWithIsPrefix(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!StringsKt.startsWith$default(name, "is", false, 2, null)) {
            return false;
        }
        if (name.length() == 2) {
            return false;
        }
        char c2 = name.charAt(2);
        return Intrinsics.compare(97, c2) > 0 || Intrinsics.compare(c2, 122) > 0;
    }
}

