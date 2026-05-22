/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import org.jetbrains.annotations.NotNull;

public final class ClassKind
extends Enum<ClassKind> {
    @NotNull
    private final FlagImpl flag;
    public static final /* enum */ ClassKind CLASS = new ClassKind(0);
    public static final /* enum */ ClassKind INTERFACE = new ClassKind(1);
    public static final /* enum */ ClassKind ENUM_CLASS = new ClassKind(2);
    public static final /* enum */ ClassKind ENUM_ENTRY = new ClassKind(3);
    public static final /* enum */ ClassKind ANNOTATION_CLASS = new ClassKind(4);
    public static final /* enum */ ClassKind OBJECT = new ClassKind(5);
    public static final /* enum */ ClassKind COMPANION_OBJECT = new ClassKind(6);
    private static final /* synthetic */ ClassKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ClassKind(int kind2) {
        Flags.FlagField<ProtoBuf.Class.Kind> flagField = Flags.CLASS_KIND;
        Intrinsics.checkNotNullExpressionValue(flagField, "CLASS_KIND");
        this.flag = new FlagImpl(flagField, kind2);
    }

    @NotNull
    public final FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }

    public static ClassKind[] values() {
        return (ClassKind[])$VALUES.clone();
    }

    public static ClassKind valueOf(String value) {
        return Enum.valueOf(ClassKind.class, value);
    }

    @NotNull
    public static EnumEntries<ClassKind> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = classKindArray = new ClassKind[]{ClassKind.CLASS, ClassKind.INTERFACE, ClassKind.ENUM_CLASS, ClassKind.ENUM_ENTRY, ClassKind.ANNOTATION_CLASS, ClassKind.OBJECT, ClassKind.COMPANION_OBJECT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

