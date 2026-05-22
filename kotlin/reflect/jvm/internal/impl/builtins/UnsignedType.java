/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class UnsignedType
extends Enum<UnsignedType> {
    @NotNull
    private final ClassId classId;
    @NotNull
    private final Name typeName;
    @NotNull
    private final ClassId arrayClassId;
    public static final /* enum */ UnsignedType UBYTE = new UnsignedType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UByte", false, 2, null));
    public static final /* enum */ UnsignedType USHORT = new UnsignedType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UShort", false, 2, null));
    public static final /* enum */ UnsignedType UINT = new UnsignedType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/UInt", false, 2, null));
    public static final /* enum */ UnsignedType ULONG = new UnsignedType(ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/ULong", false, 2, null));
    private static final /* synthetic */ UnsignedType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private UnsignedType(ClassId classId) {
        this.classId = classId;
        this.typeName = this.classId.getShortClassName();
        FqName fqName = this.classId.getPackageFqName();
        Name name = Name.identifier(this.typeName.asString() + "Array");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        this.arrayClassId = new ClassId(fqName, name);
    }

    @NotNull
    public final ClassId getClassId() {
        return this.classId;
    }

    @NotNull
    public final Name getTypeName() {
        return this.typeName;
    }

    @NotNull
    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public static UnsignedType[] values() {
        return (UnsignedType[])$VALUES.clone();
    }

    public static UnsignedType valueOf(String value) {
        return Enum.valueOf(UnsignedType.class, value);
    }

    static {
        $VALUES = unsignedTypeArray = new UnsignedType[]{UnsignedType.UBYTE, UnsignedType.USHORT, UnsignedType.UINT, UnsignedType.ULONG};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

