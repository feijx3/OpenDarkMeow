/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReadUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadUtils.kt\nkotlin/metadata/internal/ReadUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,64:1\n1617#2,9:65\n1869#2:74\n1870#2:76\n1626#2:77\n1617#2,9:78\n1869#2:87\n1870#2:89\n1626#2:90\n1#3:75\n1#3:88\n*S KotlinDebug\n*F\n+ 1 ReadUtils.kt\nkotlin/metadata/internal/ReadUtilsKt\n*L\n19#1:65,9\n19#1:74\n19#1:76\n19#1:77\n55#1:78,9\n55#1:87\n55#1:89\n55#1:90\n19#1:75\n55#1:88\n*E\n"})
public final class ReadUtilsKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final KmAnnotation readAnnotation(@NotNull ProtoBuf.Annotation $this$readAnnotation, @NotNull NameResolver strings) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter($this$readAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        String string = ReadUtilsKt.getClassName(strings, $this$readAnnotation.getId());
        List<ProtoBuf.Annotation.Argument> list = $this$readAnnotation.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(list, "getArgumentList(...)");
        Iterable iterable = list;
        String string2 = string;
        boolean $i$f$mapNotNull = false;
        void var4_5 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Pair<String, KmAnnotationArgument> pair;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            ProtoBuf.Annotation.Argument argument = (ProtoBuf.Annotation.Argument)element$iv$iv;
            boolean bl3 = false;
            ProtoBuf.Annotation.Argument.Value value = argument.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            if (ReadUtilsKt.readAnnotationArgument(value, strings) != null) {
                KmAnnotationArgument value2;
                boolean bl4 = false;
                pair = TuplesKt.to(strings.getString(argument.getNameId()), value2);
            } else {
                pair = null;
            }
            if (pair == null) continue;
            Pair<String, KmAnnotationArgument> it$iv$iv = pair;
            boolean bl5 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        Map map = MapsKt.toMap((List)destination$iv$iv);
        String string3 = string2;
        return new KmAnnotation(string3, map);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final KmAnnotationArgument readAnnotationArgument(@NotNull ProtoBuf.Annotation.Argument.Value $this$readAnnotationArgument, @NotNull NameResolver strings) {
        KmAnnotationArgument kmAnnotationArgument;
        Intrinsics.checkNotNullParameter($this$readAnnotationArgument, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        if (Flags.IS_UNSIGNED.get($this$readAnnotationArgument.getFlags()).booleanValue()) {
            KmAnnotationArgument kmAnnotationArgument2;
            ProtoBuf.Annotation.Argument.Value.Type type = $this$readAnnotationArgument.getType();
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1: {
                    kmAnnotationArgument2 = new KmAnnotationArgument.UByteValue(UByte.constructor-impl((byte)$this$readAnnotationArgument.getIntValue()), null);
                    break;
                }
                case 2: {
                    kmAnnotationArgument2 = new KmAnnotationArgument.UShortValue(UShort.constructor-impl((short)$this$readAnnotationArgument.getIntValue()), null);
                    break;
                }
                case 3: {
                    kmAnnotationArgument2 = new KmAnnotationArgument.UIntValue(UInt.constructor-impl((int)$this$readAnnotationArgument.getIntValue()), null);
                    break;
                }
                case 4: {
                    kmAnnotationArgument2 = new KmAnnotationArgument.ULongValue(ULong.constructor-impl($this$readAnnotationArgument.getIntValue()), null);
                    break;
                }
                default: {
                    throw new IllegalStateException(("Cannot read value of unsigned type: " + $this$readAnnotationArgument.getType()).toString());
                }
            }
            return kmAnnotationArgument2;
        }
        ProtoBuf.Annotation.Argument.Value.Type type = $this$readAnnotationArgument.getType();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1: {
                kmAnnotationArgument = new KmAnnotationArgument.ByteValue((byte)$this$readAnnotationArgument.getIntValue());
                break;
            }
            case 5: {
                kmAnnotationArgument = new KmAnnotationArgument.CharValue((char)$this$readAnnotationArgument.getIntValue());
                break;
            }
            case 2: {
                kmAnnotationArgument = new KmAnnotationArgument.ShortValue((short)$this$readAnnotationArgument.getIntValue());
                break;
            }
            case 3: {
                kmAnnotationArgument = new KmAnnotationArgument.IntValue((int)$this$readAnnotationArgument.getIntValue());
                break;
            }
            case 4: {
                kmAnnotationArgument = new KmAnnotationArgument.LongValue($this$readAnnotationArgument.getIntValue());
                break;
            }
            case 6: {
                kmAnnotationArgument = new KmAnnotationArgument.FloatValue($this$readAnnotationArgument.getFloatValue());
                break;
            }
            case 7: {
                kmAnnotationArgument = new KmAnnotationArgument.DoubleValue($this$readAnnotationArgument.getDoubleValue());
                break;
            }
            case 8: {
                kmAnnotationArgument = new KmAnnotationArgument.BooleanValue($this$readAnnotationArgument.getIntValue() != 0L);
                break;
            }
            case 9: {
                kmAnnotationArgument = new KmAnnotationArgument.StringValue(strings.getString($this$readAnnotationArgument.getStringValue()));
                break;
            }
            case 10: {
                String className = ReadUtilsKt.getClassName(strings, $this$readAnnotationArgument.getClassId());
                boolean bl2 = false;
                if ($this$readAnnotationArgument.getArrayDimensionCount() == 0) {
                    kmAnnotationArgument = new KmAnnotationArgument.KClassValue(className);
                    break;
                }
                kmAnnotationArgument = new KmAnnotationArgument.ArrayKClassValue(className, $this$readAnnotationArgument.getArrayDimensionCount());
                break;
            }
            case 11: {
                kmAnnotationArgument = new KmAnnotationArgument.EnumValue(ReadUtilsKt.getClassName(strings, $this$readAnnotationArgument.getClassId()), strings.getString($this$readAnnotationArgument.getEnumValueId()));
                break;
            }
            case 12: {
                ProtoBuf.Annotation annotation = $this$readAnnotationArgument.getAnnotation();
                Intrinsics.checkNotNullExpressionValue(annotation, "getAnnotation(...)");
                kmAnnotationArgument = new KmAnnotationArgument.AnnotationValue(ReadUtilsKt.readAnnotation(annotation, strings));
                break;
            }
            case 13: {
                void $this$mapNotNullTo$iv$iv;
                List<ProtoBuf.Annotation.Argument.Value> list = $this$readAnnotationArgument.getArrayElementList();
                Intrinsics.checkNotNullExpressionValue(list, "getArrayElementList(...)");
                Iterable $this$mapNotNull$iv = list;
                boolean $i$f$mapNotNull = false;
                Iterable bl2 = $this$mapNotNull$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    KmAnnotationArgument it$iv$iv;
                    Object element$iv$iv$iv;
                    Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                    boolean bl3 = false;
                    ProtoBuf.Annotation.Argument.Value it = (ProtoBuf.Annotation.Argument.Value)element$iv$iv;
                    boolean bl4 = false;
                    Intrinsics.checkNotNull(it);
                    if (ReadUtilsKt.readAnnotationArgument(it, strings) == null) continue;
                    boolean bl5 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                List list2 = (List)destination$iv$iv;
                kmAnnotationArgument = new KmAnnotationArgument.ArrayValue(list2);
                break;
            }
            case -1: {
                kmAnnotationArgument = null;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return kmAnnotationArgument;
    }

    @NotNull
    public static final String getClassName(@NotNull NameResolver $this$getClassName, int index) {
        Intrinsics.checkNotNullParameter($this$getClassName, "<this>");
        String name = $this$getClassName.getQualifiedClassName(index);
        return $this$getClassName.isLocalClassName(index) ? '.' + name : name;
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

