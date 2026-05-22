/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class PrimitiveType
extends Enum<PrimitiveType> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Name typeName;
    @NotNull
    private final Name arrayTypeName;
    @NotNull
    private final Lazy typeFqName$delegate;
    @NotNull
    private final Lazy arrayTypeFqName$delegate;
    @JvmField
    @NotNull
    public static final Set<PrimitiveType> NUMBER_TYPES;
    public static final /* enum */ PrimitiveType BOOLEAN;
    public static final /* enum */ PrimitiveType CHAR;
    public static final /* enum */ PrimitiveType BYTE;
    public static final /* enum */ PrimitiveType SHORT;
    public static final /* enum */ PrimitiveType INT;
    public static final /* enum */ PrimitiveType FLOAT;
    public static final /* enum */ PrimitiveType LONG;
    public static final /* enum */ PrimitiveType DOUBLE;
    private static final /* synthetic */ PrimitiveType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private PrimitiveType(String typeName) {
        Name name = Name.identifier(typeName);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        this.typeName = name;
        Name name2 = Name.identifier(typeName + "Array");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        this.arrayTypeName = name2;
        PrimitiveType primitiveType = this;
        this.typeFqName$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PrimitiveType$$Lambda$0(primitiveType));
        primitiveType = this;
        this.arrayTypeFqName$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PrimitiveType$$Lambda$1(primitiveType));
    }

    @NotNull
    public final Name getTypeName() {
        return this.typeName;
    }

    @NotNull
    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    @NotNull
    public final FqName getTypeFqName() {
        Lazy lazy = this.typeFqName$delegate;
        return (FqName)lazy.getValue();
    }

    @NotNull
    public final FqName getArrayTypeFqName() {
        Lazy lazy = this.arrayTypeFqName$delegate;
        return (FqName)lazy.getValue();
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[])$VALUES.clone();
    }

    public static PrimitiveType valueOf(String value) {
        return Enum.valueOf(PrimitiveType.class, value);
    }

    private static final FqName typeFqName_delegate$lambda$0(PrimitiveType this$0) {
        return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this$0.typeName);
    }

    private static final FqName arrayTypeFqName_delegate$lambda$1(PrimitiveType this$0) {
        return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this$0.arrayTypeName);
    }

    static {
        BOOLEAN = new PrimitiveType("Boolean");
        CHAR = new PrimitiveType("Char");
        BYTE = new PrimitiveType("Byte");
        SHORT = new PrimitiveType("Short");
        INT = new PrimitiveType("Int");
        FLOAT = new PrimitiveType("Float");
        LONG = new PrimitiveType("Long");
        DOUBLE = new PrimitiveType("Double");
        $VALUES = primitiveTypeArray = new PrimitiveType[]{PrimitiveType.BOOLEAN, PrimitiveType.CHAR, PrimitiveType.BYTE, PrimitiveType.SHORT, PrimitiveType.INT, PrimitiveType.FLOAT, PrimitiveType.LONG, PrimitiveType.DOUBLE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
        PrimitiveType[] primitiveTypeArray = new PrimitiveType[]{CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE};
        NUMBER_TYPES = SetsKt.setOf(primitiveTypeArray);
    }

    static /* synthetic */ FqName accessor$PrimitiveType$lambda0(PrimitiveType primitiveType) {
        return PrimitiveType.typeFqName_delegate$lambda$0(primitiveType);
    }

    static /* synthetic */ FqName accessor$PrimitiveType$lambda1(PrimitiveType primitiveType) {
        return PrimitiveType.arrayTypeFqName_delegate$lambda$1(primitiveType);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

