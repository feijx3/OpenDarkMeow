/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class UnsignedArrayType
extends Enum<UnsignedArrayType> {
    @NotNull
    private final ClassId classId;
    @NotNull
    private final Name typeName;
    public static final /* enum */ UnsignedArrayType UBYTEARRAY = new UnsignedArrayType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UByteArray", false, 2, null));
    public static final /* enum */ UnsignedArrayType USHORTARRAY = new UnsignedArrayType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UShortArray", false, 2, null));
    public static final /* enum */ UnsignedArrayType UINTARRAY = new UnsignedArrayType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UIntArray", false, 2, null));
    public static final /* enum */ UnsignedArrayType ULONGARRAY = new UnsignedArrayType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/ULongArray", false, 2, null));
    private static final /* synthetic */ UnsignedArrayType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private UnsignedArrayType(ClassId classId) {
        this.classId = classId;
        this.typeName = this.classId.getShortClassName();
    }

    @NotNull
    public final Name getTypeName() {
        return this.typeName;
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[])$VALUES.clone();
    }

    public static UnsignedArrayType valueOf(String value) {
        return Enum.valueOf(UnsignedArrayType.class, value);
    }

    static {
        $VALUES = unsignedArrayTypeArray = new UnsignedArrayType[]{UnsignedArrayType.UBYTEARRAY, UnsignedArrayType.USHORTARRAY, UnsignedArrayType.UINTARRAY, UnsignedArrayType.ULONGARRAY};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

