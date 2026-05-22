/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nSpecialNames.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialNames.kt\norg/jetbrains/kotlin/name/SpecialNames\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
public final class SpecialNames {
    @NotNull
    public static final SpecialNames INSTANCE = new SpecialNames();
    @JvmField
    @NotNull
    public static final Name NO_NAME_PROVIDED;
    @JvmField
    @NotNull
    public static final Name ROOT_PACKAGE;
    @JvmField
    @NotNull
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;
    @JvmField
    @NotNull
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;
    @JvmField
    @NotNull
    public static final Name ANONYMOUS;
    @JvmField
    @NotNull
    public static final FqName ANONYMOUS_FQ_NAME;
    @JvmField
    @NotNull
    public static final Name UNARY;
    @JvmField
    @NotNull
    public static final Name THIS;
    @JvmField
    @NotNull
    public static final Name INIT;
    @JvmField
    @NotNull
    public static final Name WHEN_SUBJECT;
    @JvmField
    @NotNull
    public static final Name ITERATOR;
    @JvmField
    @NotNull
    public static final Name DESTRUCT;
    @JvmField
    @NotNull
    public static final Name LOCAL;
    @JvmField
    @NotNull
    public static final Name UNDERSCORE_FOR_UNUSED_VAR;
    @JvmField
    @NotNull
    public static final Name IMPLICIT_SET_PARAMETER;
    @JvmField
    @NotNull
    public static final Name ARRAY;
    @JvmField
    @NotNull
    public static final Name RECEIVER;
    @JvmField
    @NotNull
    public static final Name ENUM_GET_ENTRIES;

    private SpecialNames() {
    }

    @JvmStatic
    @NotNull
    public static final Name safeIdentifier(@Nullable Name name) {
        return name != null && !name.isSpecial() ? name : SAFE_IDENTIFIER_FOR_NO_NAME;
    }

    public final boolean isSafeIdentifier(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String string = name.asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        return ((CharSequence)string).length() > 0 && !name.isSpecial();
    }

    static {
        Name name = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(name, "special(...)");
        NO_NAME_PROVIDED = name;
        Name name2 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(name2, "special(...)");
        ROOT_PACKAGE = name2;
        Name name3 = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = name3;
        Name name4 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(name4, "identifier(...)");
        SAFE_IDENTIFIER_FOR_NO_NAME = name4;
        Name name5 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(name5, "special(...)");
        ANONYMOUS = name5;
        Name name6 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(name6, "special(...)");
        ANONYMOUS_FQ_NAME = FqName.Companion.topLevel(name6);
        Name name7 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(name7, "special(...)");
        UNARY = name7;
        Name name8 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(name8, "special(...)");
        THIS = name8;
        Name name9 = Name.special("<init>");
        Intrinsics.checkNotNullExpressionValue(name9, "special(...)");
        INIT = name9;
        Name name10 = Name.special("<when-subject>");
        Intrinsics.checkNotNullExpressionValue(name10, "special(...)");
        WHEN_SUBJECT = name10;
        Name name11 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(name11, "special(...)");
        ITERATOR = name11;
        Name name12 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(name12, "special(...)");
        DESTRUCT = name12;
        Name name13 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(name13, "special(...)");
        LOCAL = name13;
        Name name14 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(name14, "special(...)");
        UNDERSCORE_FOR_UNUSED_VAR = name14;
        Name name15 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(name15, "special(...)");
        IMPLICIT_SET_PARAMETER = name15;
        Name name16 = Name.special("<array>");
        Intrinsics.checkNotNullExpressionValue(name16, "special(...)");
        ARRAY = name16;
        Name name17 = Name.special("<receiver>");
        Intrinsics.checkNotNullExpressionValue(name17, "special(...)");
        RECEIVER = name17;
        Name name18 = Name.special("<get-entries>");
        Intrinsics.checkNotNullExpressionValue(name18, "special(...)");
        ENUM_GET_ENTRIES = name18;
    }
}

