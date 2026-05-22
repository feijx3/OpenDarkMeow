/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class OperatorNameConventions {
    @NotNull
    public static final OperatorNameConventions INSTANCE = new OperatorNameConventions();
    @JvmField
    @NotNull
    public static final Name GET_VALUE;
    @JvmField
    @NotNull
    public static final Name SET_VALUE;
    @JvmField
    @NotNull
    public static final Name PROVIDE_DELEGATE;
    @JvmField
    @NotNull
    public static final Name EQUALS;
    @JvmField
    @NotNull
    public static final Name HASH_CODE;
    @JvmField
    @NotNull
    public static final Name COMPARE_TO;
    @JvmField
    @NotNull
    public static final Name CONTAINS;
    @JvmField
    @NotNull
    public static final Name INVOKE;
    @JvmField
    @NotNull
    public static final Name ITERATOR;
    @JvmField
    @NotNull
    public static final Name GET;
    @JvmField
    @NotNull
    public static final Name SET;
    @JvmField
    @NotNull
    public static final Name NEXT;
    @JvmField
    @NotNull
    public static final Name HAS_NEXT;
    @JvmField
    @NotNull
    public static final Name TO_STRING;
    @JvmField
    @NotNull
    public static final Regex COMPONENT_REGEX;
    @JvmField
    @NotNull
    public static final Name AND;
    @JvmField
    @NotNull
    public static final Name OR;
    @JvmField
    @NotNull
    public static final Name XOR;
    @JvmField
    @NotNull
    public static final Name INV;
    @JvmField
    @NotNull
    public static final Name SHL;
    @JvmField
    @NotNull
    public static final Name SHR;
    @JvmField
    @NotNull
    public static final Name USHR;
    @JvmField
    @NotNull
    public static final Name INC;
    @JvmField
    @NotNull
    public static final Name DEC;
    @JvmField
    @NotNull
    public static final Name PLUS;
    @JvmField
    @NotNull
    public static final Name MINUS;
    @JvmField
    @NotNull
    public static final Name NOT;
    @JvmField
    @NotNull
    public static final Name UNARY_MINUS;
    @JvmField
    @NotNull
    public static final Name UNARY_PLUS;
    @JvmField
    @NotNull
    public static final Name TIMES;
    @JvmField
    @NotNull
    public static final Name DIV;
    @JvmField
    @NotNull
    public static final Name REM;
    @JvmField
    @NotNull
    public static final Name RANGE_TO;
    @JvmField
    @NotNull
    public static final Name RANGE_UNTIL;
    @JvmField
    @NotNull
    public static final Name TIMES_ASSIGN;
    @JvmField
    @NotNull
    public static final Name DIV_ASSIGN;
    @JvmField
    @NotNull
    public static final Name REM_ASSIGN;
    @JvmField
    @NotNull
    public static final Name PLUS_ASSIGN;
    @JvmField
    @NotNull
    public static final Name MINUS_ASSIGN;
    @JvmField
    @NotNull
    public static final Name TO_DOUBLE;
    @JvmField
    @NotNull
    public static final Name TO_FLOAT;
    @JvmField
    @NotNull
    public static final Name TO_LONG;
    @JvmField
    @NotNull
    public static final Name TO_INT;
    @JvmField
    @NotNull
    public static final Name TO_CHAR;
    @JvmField
    @NotNull
    public static final Name TO_SHORT;
    @JvmField
    @NotNull
    public static final Name TO_BYTE;
    @JvmField
    @NotNull
    public static final Set<Name> UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> BINARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> SIMPLE_BINARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> BITWISE_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> SIMPLE_BITWISE_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> ALL_BINARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> ASSIGNMENT_OPERATIONS;
    @JvmField
    @NotNull
    public static final Set<Name> DELEGATED_PROPERTY_OPERATORS;
    @JvmField
    @NotNull
    public static final Set<Name> STATEMENT_LIKE_OPERATORS;
    @JvmField
    @NotNull
    public static final Set<Name> NUMBER_CONVERSIONS;
    @NotNull
    private static final Map<Name, String> TOKENS_BY_OPERATOR_NAME;

    private OperatorNameConventions() {
    }

    static {
        Name name = Name.identifier("getValue");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        GET_VALUE = name;
        Name name2 = Name.identifier("setValue");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        SET_VALUE = name2;
        Name name3 = Name.identifier("provideDelegate");
        Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
        PROVIDE_DELEGATE = name3;
        Name name4 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(name4, "identifier(...)");
        EQUALS = name4;
        Name name5 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(name5, "identifier(...)");
        HASH_CODE = name5;
        Name name6 = Name.identifier("compareTo");
        Intrinsics.checkNotNullExpressionValue(name6, "identifier(...)");
        COMPARE_TO = name6;
        Name name7 = Name.identifier("contains");
        Intrinsics.checkNotNullExpressionValue(name7, "identifier(...)");
        CONTAINS = name7;
        Name name8 = Name.identifier("invoke");
        Intrinsics.checkNotNullExpressionValue(name8, "identifier(...)");
        INVOKE = name8;
        Name name9 = Name.identifier("iterator");
        Intrinsics.checkNotNullExpressionValue(name9, "identifier(...)");
        ITERATOR = name9;
        Name name10 = Name.identifier("get");
        Intrinsics.checkNotNullExpressionValue(name10, "identifier(...)");
        GET = name10;
        Name name11 = Name.identifier("set");
        Intrinsics.checkNotNullExpressionValue(name11, "identifier(...)");
        SET = name11;
        Name name12 = Name.identifier("next");
        Intrinsics.checkNotNullExpressionValue(name12, "identifier(...)");
        NEXT = name12;
        Name name13 = Name.identifier("hasNext");
        Intrinsics.checkNotNullExpressionValue(name13, "identifier(...)");
        HAS_NEXT = name13;
        Name name14 = Name.identifier("toString");
        Intrinsics.checkNotNullExpressionValue(name14, "identifier(...)");
        TO_STRING = name14;
        COMPONENT_REGEX = new Regex("component\\d+");
        Name name15 = Name.identifier("and");
        Intrinsics.checkNotNullExpressionValue(name15, "identifier(...)");
        AND = name15;
        Name name16 = Name.identifier("or");
        Intrinsics.checkNotNullExpressionValue(name16, "identifier(...)");
        OR = name16;
        Name name17 = Name.identifier("xor");
        Intrinsics.checkNotNullExpressionValue(name17, "identifier(...)");
        XOR = name17;
        Name name18 = Name.identifier("inv");
        Intrinsics.checkNotNullExpressionValue(name18, "identifier(...)");
        INV = name18;
        Name name19 = Name.identifier("shl");
        Intrinsics.checkNotNullExpressionValue(name19, "identifier(...)");
        SHL = name19;
        Name name20 = Name.identifier("shr");
        Intrinsics.checkNotNullExpressionValue(name20, "identifier(...)");
        SHR = name20;
        Name name21 = Name.identifier("ushr");
        Intrinsics.checkNotNullExpressionValue(name21, "identifier(...)");
        USHR = name21;
        Name name22 = Name.identifier("inc");
        Intrinsics.checkNotNullExpressionValue(name22, "identifier(...)");
        INC = name22;
        Name name23 = Name.identifier("dec");
        Intrinsics.checkNotNullExpressionValue(name23, "identifier(...)");
        DEC = name23;
        Name name24 = Name.identifier("plus");
        Intrinsics.checkNotNullExpressionValue(name24, "identifier(...)");
        PLUS = name24;
        Name name25 = Name.identifier("minus");
        Intrinsics.checkNotNullExpressionValue(name25, "identifier(...)");
        MINUS = name25;
        Name name26 = Name.identifier("not");
        Intrinsics.checkNotNullExpressionValue(name26, "identifier(...)");
        NOT = name26;
        Name name27 = Name.identifier("unaryMinus");
        Intrinsics.checkNotNullExpressionValue(name27, "identifier(...)");
        UNARY_MINUS = name27;
        Name name28 = Name.identifier("unaryPlus");
        Intrinsics.checkNotNullExpressionValue(name28, "identifier(...)");
        UNARY_PLUS = name28;
        Name name29 = Name.identifier("times");
        Intrinsics.checkNotNullExpressionValue(name29, "identifier(...)");
        TIMES = name29;
        Name name30 = Name.identifier("div");
        Intrinsics.checkNotNullExpressionValue(name30, "identifier(...)");
        DIV = name30;
        Name name31 = Name.identifier("rem");
        Intrinsics.checkNotNullExpressionValue(name31, "identifier(...)");
        REM = name31;
        Name name32 = Name.identifier("rangeTo");
        Intrinsics.checkNotNullExpressionValue(name32, "identifier(...)");
        RANGE_TO = name32;
        Name name33 = Name.identifier("rangeUntil");
        Intrinsics.checkNotNullExpressionValue(name33, "identifier(...)");
        RANGE_UNTIL = name33;
        Name name34 = Name.identifier("timesAssign");
        Intrinsics.checkNotNullExpressionValue(name34, "identifier(...)");
        TIMES_ASSIGN = name34;
        Name name35 = Name.identifier("divAssign");
        Intrinsics.checkNotNullExpressionValue(name35, "identifier(...)");
        DIV_ASSIGN = name35;
        Name name36 = Name.identifier("remAssign");
        Intrinsics.checkNotNullExpressionValue(name36, "identifier(...)");
        REM_ASSIGN = name36;
        Name name37 = Name.identifier("plusAssign");
        Intrinsics.checkNotNullExpressionValue(name37, "identifier(...)");
        PLUS_ASSIGN = name37;
        Name name38 = Name.identifier("minusAssign");
        Intrinsics.checkNotNullExpressionValue(name38, "identifier(...)");
        MINUS_ASSIGN = name38;
        Name name39 = Name.identifier("toDouble");
        Intrinsics.checkNotNullExpressionValue(name39, "identifier(...)");
        TO_DOUBLE = name39;
        Name name40 = Name.identifier("toFloat");
        Intrinsics.checkNotNullExpressionValue(name40, "identifier(...)");
        TO_FLOAT = name40;
        Name name41 = Name.identifier("toLong");
        Intrinsics.checkNotNullExpressionValue(name41, "identifier(...)");
        TO_LONG = name41;
        Name name42 = Name.identifier("toInt");
        Intrinsics.checkNotNullExpressionValue(name42, "identifier(...)");
        TO_INT = name42;
        Name name43 = Name.identifier("toChar");
        Intrinsics.checkNotNullExpressionValue(name43, "identifier(...)");
        TO_CHAR = name43;
        Name name44 = Name.identifier("toShort");
        Intrinsics.checkNotNullExpressionValue(name44, "identifier(...)");
        TO_SHORT = name44;
        Name name45 = Name.identifier("toByte");
        Intrinsics.checkNotNullExpressionValue(name45, "identifier(...)");
        TO_BYTE = name45;
        Object[] objectArray = new Name[]{INC, DEC, UNARY_PLUS, UNARY_MINUS, NOT, INV};
        UNARY_OPERATION_NAMES = SetsKt.setOf(objectArray);
        objectArray = new Name[]{UNARY_PLUS, UNARY_MINUS, NOT, INV};
        SIMPLE_UNARY_OPERATION_NAMES = SetsKt.setOf(objectArray);
        objectArray = new Name[]{TIMES, PLUS, MINUS, DIV, REM, RANGE_TO, RANGE_UNTIL};
        BINARY_OPERATION_NAMES = SetsKt.setOf(objectArray);
        objectArray = new Name[]{TIMES, PLUS, MINUS, DIV, REM};
        SIMPLE_BINARY_OPERATION_NAMES = SetsKt.setOf(objectArray);
        objectArray = new Name[]{AND, OR, XOR, INV, SHL, SHR, USHR};
        BITWISE_OPERATION_NAMES = SetsKt.setOf(objectArray);
        objectArray = new Name[]{AND, OR, XOR, SHL, SHR, USHR};
        SIMPLE_BITWISE_OPERATION_NAMES = SetsKt.setOf(objectArray);
        objectArray = new Name[]{EQUALS, CONTAINS, COMPARE_TO};
        ALL_BINARY_OPERATION_NAMES = SetsKt.plus(SetsKt.plus(BINARY_OPERATION_NAMES, (Iterable)BITWISE_OPERATION_NAMES), (Iterable)SetsKt.setOf(objectArray));
        objectArray = new Name[]{TIMES_ASSIGN, DIV_ASSIGN, REM_ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN};
        ASSIGNMENT_OPERATIONS = SetsKt.setOf(objectArray);
        objectArray = new Name[]{GET_VALUE, SET_VALUE, PROVIDE_DELEGATE};
        DELEGATED_PROPERTY_OPERATORS = SetsKt.setOf(objectArray);
        STATEMENT_LIKE_OPERATORS = SetsKt.plus(SetsKt.setOf(SET), (Iterable)ASSIGNMENT_OPERATIONS);
        objectArray = new Name[]{TO_DOUBLE, TO_FLOAT, TO_LONG, TO_INT, TO_SHORT, TO_BYTE, TO_CHAR};
        NUMBER_CONVERSIONS = SetsKt.setOf(objectArray);
        objectArray = new Pair[]{TuplesKt.to(INC, "++"), TuplesKt.to(DEC, "--"), TuplesKt.to(UNARY_PLUS, "+"), TuplesKt.to(UNARY_MINUS, "-"), TuplesKt.to(NOT, "!"), TuplesKt.to(TIMES, "*"), TuplesKt.to(PLUS, "+"), TuplesKt.to(MINUS, "-"), TuplesKt.to(DIV, "/"), TuplesKt.to(REM, "%"), TuplesKt.to(RANGE_TO, ".."), TuplesKt.to(RANGE_UNTIL, "..<")};
        TOKENS_BY_OPERATOR_NAME = MapsKt.mapOf(objectArray);
    }
}

