/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.List;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class KmAnnotationArgument {
    private KmAnnotationArgument() {
    }

    @NotNull
    public abstract String toString();

    public /* synthetic */ KmAnnotationArgument(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final class AnnotationValue
    extends KmAnnotationArgument {
        @NotNull
        private final KmAnnotation annotation;

        public AnnotationValue(@NotNull KmAnnotation annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            super(null);
            this.annotation = annotation;
        }

        @NotNull
        public final KmAnnotation getAnnotation() {
            return this.annotation;
        }

        @Override
        @NotNull
        public String toString() {
            return "AnnotationValue(" + this.annotation + ')';
        }

        public int hashCode() {
            return this.annotation.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnnotationValue)) {
                return false;
            }
            AnnotationValue annotationValue = (AnnotationValue)other;
            return Intrinsics.areEqual(this.annotation, annotationValue.annotation);
        }
    }

    @SourceDebugExtension(value={"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\nkotlin/metadata/KmAnnotationArgument$ArrayKClassValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
    public static final class ArrayKClassValue
    extends KmAnnotationArgument {
        @NotNull
        private final String className;
        private final int arrayDimensionCount;
        @NotNull
        private final String stringRepresentation;

        /*
         * WARNING - void declaration
         */
        public ArrayKClassValue(@NotNull String className, int arrayDimensionCount) {
            int it;
            void $this$stringRepresentation_u24lambda_u243;
            StringBuilder stringBuilder;
            Intrinsics.checkNotNullParameter(className, "className");
            super(null);
            this.className = className;
            this.arrayDimensionCount = arrayDimensionCount;
            if (!(this.arrayDimensionCount > 0)) {
                boolean $i$a$-require-KmAnnotationArgument$ArrayKClassValue$22 = false;
                String $i$a$-require-KmAnnotationArgument$ArrayKClassValue$22 = "ArrayKClassValue must have at least one dimension. For regular X::class argument, use KClassValue.";
                throw new IllegalArgumentException($i$a$-require-KmAnnotationArgument$ArrayKClassValue$22.toString());
            }
            StringBuilder $i$a$-require-KmAnnotationArgument$ArrayKClassValue$22 = stringBuilder = new StringBuilder();
            ArrayKClassValue arrayKClassValue = this;
            boolean bl2 = false;
            $this$stringRepresentation_u24lambda_u243.append("ArrayKClassValue(");
            int n2 = this.arrayDimensionCount;
            int n3 = 0;
            while (n3 < n2) {
                it = n3++;
                boolean bl3 = false;
                $this$stringRepresentation_u24lambda_u243.append("kotlin/Array<");
            }
            $this$stringRepresentation_u24lambda_u243.append(this.className);
            n2 = this.arrayDimensionCount;
            n3 = 0;
            while (n3 < n2) {
                it = n3++;
                boolean bl4 = false;
                $this$stringRepresentation_u24lambda_u243.append(">");
            }
            $this$stringRepresentation_u24lambda_u243.append(")");
            arrayKClassValue.stringRepresentation = stringBuilder.toString();
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        public final int getArrayDimensionCount() {
            return this.arrayDimensionCount;
        }

        @Override
        @NotNull
        public String toString() {
            return this.stringRepresentation;
        }

        public int hashCode() {
            int result = this.className.hashCode();
            result = result * 31 + Integer.hashCode(this.arrayDimensionCount);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArrayKClassValue)) {
                return false;
            }
            ArrayKClassValue arrayKClassValue = (ArrayKClassValue)other;
            if (!Intrinsics.areEqual(this.className, arrayKClassValue.className)) {
                return false;
            }
            return this.arrayDimensionCount == arrayKClassValue.arrayDimensionCount;
        }
    }

    public static final class ArrayValue
    extends KmAnnotationArgument {
        @NotNull
        private final List<KmAnnotationArgument> elements;

        public ArrayValue(@NotNull List<? extends KmAnnotationArgument> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            super(null);
            this.elements = elements;
        }

        @NotNull
        public final List<KmAnnotationArgument> getElements() {
            return this.elements;
        }

        @Override
        @NotNull
        public String toString() {
            return "ArrayValue(" + this.elements + ')';
        }

        public int hashCode() {
            return ((Object)this.elements).hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArrayValue)) {
                return false;
            }
            ArrayValue arrayValue = (ArrayValue)other;
            return Intrinsics.areEqual(this.elements, arrayValue.elements);
        }
    }

    public static final class BooleanValue
    extends LiteralValue<Boolean> {
        private final boolean value;

        public BooleanValue(boolean value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BooleanValue)) {
                return false;
            }
            BooleanValue booleanValue = (BooleanValue)other;
            return this.value == booleanValue.value;
        }
    }

    public static final class ByteValue
    extends LiteralValue<Byte> {
        private final byte value;

        public ByteValue(byte value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Byte getValue() {
            return this.value;
        }

        public int hashCode() {
            return Byte.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ByteValue)) {
                return false;
            }
            ByteValue byteValue = (ByteValue)other;
            return this.value == byteValue.value;
        }
    }

    public static final class CharValue
    extends LiteralValue<Character> {
        private final char value;

        public CharValue(char value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Character getValue() {
            return Character.valueOf(this.value);
        }

        public int hashCode() {
            return Character.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CharValue)) {
                return false;
            }
            CharValue charValue = (CharValue)other;
            return this.value == charValue.value;
        }
    }

    public static final class DoubleValue
    extends LiteralValue<Double> {
        private final double value;

        public DoubleValue(double value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Double getValue() {
            return this.value;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DoubleValue)) {
                return false;
            }
            DoubleValue doubleValue = (DoubleValue)other;
            return Double.compare(this.value, doubleValue.value) == 0;
        }
    }

    public static final class EnumValue
    extends KmAnnotationArgument {
        @NotNull
        private final String enumClassName;
        @NotNull
        private final String enumEntryName;

        public EnumValue(@NotNull String enumClassName, @NotNull String enumEntryName) {
            Intrinsics.checkNotNullParameter(enumClassName, "enumClassName");
            Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            super(null);
            this.enumClassName = enumClassName;
            this.enumEntryName = enumEntryName;
        }

        @NotNull
        public final String getEnumClassName() {
            return this.enumClassName;
        }

        @NotNull
        public final String getEnumEntryName() {
            return this.enumEntryName;
        }

        @Override
        @NotNull
        public String toString() {
            return "EnumValue(" + this.enumClassName + '.' + this.enumEntryName + ')';
        }

        public int hashCode() {
            int result = this.enumClassName.hashCode();
            result = result * 31 + this.enumEntryName.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EnumValue)) {
                return false;
            }
            EnumValue enumValue = (EnumValue)other;
            if (!Intrinsics.areEqual(this.enumClassName, enumValue.enumClassName)) {
                return false;
            }
            return Intrinsics.areEqual(this.enumEntryName, enumValue.enumEntryName);
        }
    }

    public static final class FloatValue
    extends LiteralValue<Float> {
        private final float value;

        public FloatValue(float value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Float getValue() {
            return Float.valueOf(this.value);
        }

        public int hashCode() {
            return Float.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FloatValue)) {
                return false;
            }
            FloatValue floatValue = (FloatValue)other;
            return Float.compare(this.value, floatValue.value) == 0;
        }
    }

    public static final class IntValue
    extends LiteralValue<Integer> {
        private final int value;

        public IntValue(int value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Integer getValue() {
            return this.value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IntValue)) {
                return false;
            }
            IntValue intValue = (IntValue)other;
            return this.value == intValue.value;
        }
    }

    public static final class KClassValue
    extends KmAnnotationArgument {
        @NotNull
        private final String className;

        public KClassValue(@NotNull String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            super(null);
            this.className = className;
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        @Override
        @NotNull
        public String toString() {
            return "KClassValue(" + this.className + ')';
        }

        public int hashCode() {
            return this.className.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KClassValue)) {
                return false;
            }
            KClassValue kClassValue = (KClassValue)other;
            return Intrinsics.areEqual(this.className, kClassValue.className);
        }
    }

    public static abstract class LiteralValue<T>
    extends KmAnnotationArgument {
        private LiteralValue() {
            super(null);
        }

        @NotNull
        public abstract T getValue();

        @Override
        @NotNull
        public final String toString() {
            return this.getClass().getSimpleName() + '(' + (this instanceof StringValue ? '\"' + ((StringValue)this).getValue() + '\"' : this.getValue().toString()) + ')';
        }

        public /* synthetic */ LiteralValue(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public static final class LongValue
    extends LiteralValue<Long> {
        private final long value;

        public LongValue(long value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Long getValue() {
            return this.value;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongValue)) {
                return false;
            }
            LongValue longValue = (LongValue)other;
            return this.value == longValue.value;
        }
    }

    public static final class ShortValue
    extends LiteralValue<Short> {
        private final short value;

        public ShortValue(short value) {
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public Short getValue() {
            return this.value;
        }

        public int hashCode() {
            return Short.hashCode(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShortValue)) {
                return false;
            }
            ShortValue shortValue = (ShortValue)other;
            return this.value == shortValue.value;
        }
    }

    public static final class StringValue
    extends LiteralValue<String> {
        @NotNull
        private final String value;

        public StringValue(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            super(null);
            this.value = value;
        }

        @Override
        @NotNull
        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StringValue)) {
                return false;
            }
            StringValue stringValue = (StringValue)other;
            return Intrinsics.areEqual(this.value, stringValue.value);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static final class UByteValue
    extends LiteralValue<UByte> {
        private final byte value;

        private UByteValue(byte value) {
            super(null);
            this.value = value;
        }

        public byte getValue-w2LRezQ() {
            return this.value;
        }

        public int hashCode() {
            return UByte.hashCode-impl(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UByteValue)) {
                return false;
            }
            UByteValue uByteValue = (UByteValue)other;
            return this.value == uByteValue.value;
        }

        public /* synthetic */ UByteValue(byte value, DefaultConstructorMarker $constructor_marker) {
            this(value);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static final class UIntValue
    extends LiteralValue<UInt> {
        private final int value;

        private UIntValue(int value) {
            super(null);
            this.value = value;
        }

        public int getValue-pVg5ArA() {
            return this.value;
        }

        public int hashCode() {
            return UInt.hashCode-impl(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UIntValue)) {
                return false;
            }
            UIntValue uIntValue = (UIntValue)other;
            return this.value == uIntValue.value;
        }

        public /* synthetic */ UIntValue(int value, DefaultConstructorMarker $constructor_marker) {
            this(value);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static final class ULongValue
    extends LiteralValue<ULong> {
        private final long value;

        private ULongValue(long value) {
            super(null);
            this.value = value;
        }

        public long getValue-s-VKNKU() {
            return this.value;
        }

        public int hashCode() {
            return ULong.hashCode-impl(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ULongValue)) {
                return false;
            }
            ULongValue uLongValue = (ULongValue)other;
            return this.value == uLongValue.value;
        }

        public /* synthetic */ ULongValue(long value, DefaultConstructorMarker $constructor_marker) {
            this(value);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static final class UShortValue
    extends LiteralValue<UShort> {
        private final short value;

        private UShortValue(short value) {
            super(null);
            this.value = value;
        }

        public short getValue-Mh2AYeg() {
            return this.value;
        }

        public int hashCode() {
            return UShort.hashCode-impl(this.value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UShortValue)) {
                return false;
            }
            UShortValue uShortValue = (UShortValue)other;
            return this.value == uShortValue.value;
        }

        public /* synthetic */ UShortValue(short value, DefaultConstructorMarker $constructor_marker) {
            this(value);
        }
    }
}

