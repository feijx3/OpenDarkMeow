/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.Nullable;

public final class ClassKind
extends Enum<ClassKind> {
    @Nullable
    private final String codeRepresentation;
    public static final /* enum */ ClassKind CLASS = new ClassKind("class");
    public static final /* enum */ ClassKind INTERFACE = new ClassKind("interface");
    public static final /* enum */ ClassKind ENUM_CLASS = new ClassKind("enum class");
    public static final /* enum */ ClassKind ENUM_ENTRY = new ClassKind(null);
    public static final /* enum */ ClassKind ANNOTATION_CLASS = new ClassKind("annotation class");
    public static final /* enum */ ClassKind OBJECT = new ClassKind("object");
    private static final /* synthetic */ ClassKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ClassKind(String codeRepresentation) {
        this.codeRepresentation = codeRepresentation;
    }

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }

    public static ClassKind[] values() {
        return (ClassKind[])$VALUES.clone();
    }

    public static ClassKind valueOf(String value) {
        return Enum.valueOf(ClassKind.class, value);
    }

    static {
        $VALUES = classKindArray = new ClassKind[]{ClassKind.CLASS, ClassKind.INTERFACE, ClassKind.ENUM_CLASS, ClassKind.ENUM_ENTRY, ClassKind.ANNOTATION_CLASS, ClassKind.OBJECT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

