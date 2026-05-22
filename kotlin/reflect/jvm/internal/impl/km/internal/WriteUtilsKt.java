/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.ClassNameKt;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable;
import org.jetbrains.annotations.NotNull;

public final class WriteUtilsKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final ProtoBuf.Annotation.Builder writeAnnotation(@NotNull KmAnnotation $this$writeAnnotation, @NotNull StringTable strings) {
        ProtoBuf.Annotation.Builder builder;
        Intrinsics.checkNotNullParameter($this$writeAnnotation, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ProtoBuf.Annotation.Builder $this$writeAnnotation_u24lambda_u241 = builder = ProtoBuf.Annotation.newBuilder();
        boolean bl2 = false;
        $this$writeAnnotation_u24lambda_u241.setId(WriteUtilsKt.getClassNameIndex(strings, $this$writeAnnotation.getClassName()));
        for (Map.Entry<String, KmAnnotationArgument> entry : $this$writeAnnotation.getArguments().entrySet()) {
            void $this$writeAnnotation_u24lambda_u241_u24lambda_u240;
            ProtoBuf.Annotation.Argument.Builder builder2;
            String name = entry.getKey();
            KmAnnotationArgument argument = entry.getValue();
            ProtoBuf.Annotation.Argument.Builder builder3 = builder2 = ProtoBuf.Annotation.Argument.newBuilder();
            ProtoBuf.Annotation.Builder builder4 = $this$writeAnnotation_u24lambda_u241;
            boolean bl3 = false;
            $this$writeAnnotation_u24lambda_u241_u24lambda_u240.setNameId(strings.getStringIndex(name));
            $this$writeAnnotation_u24lambda_u241_u24lambda_u240.setValue(WriteUtilsKt.writeAnnotationArgument(argument, strings).build());
            builder4.addArgument(builder2);
        }
        ProtoBuf.Annotation.Builder builder5 = builder;
        Intrinsics.checkNotNullExpressionValue(builder5, "apply(...)");
        return builder5;
    }

    @NotNull
    public static final ProtoBuf.Annotation.Argument.Value.Builder writeAnnotationArgument(@NotNull KmAnnotationArgument $this$writeAnnotationArgument, @NotNull StringTable strings) {
        ProtoBuf.Annotation.Argument.Value.Builder builder;
        Intrinsics.checkNotNullParameter($this$writeAnnotationArgument, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ProtoBuf.Annotation.Argument.Value.Builder $this$writeAnnotationArgument_u24lambda_u242 = builder = ProtoBuf.Annotation.Argument.Value.newBuilder();
        boolean bl2 = false;
        KmAnnotationArgument kmAnnotationArgument = $this$writeAnnotationArgument;
        if (kmAnnotationArgument instanceof KmAnnotationArgument.ByteValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue(((KmAnnotationArgument.ByteValue)$this$writeAnnotationArgument).getValue().byteValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.CharValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.CHAR);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue(((KmAnnotationArgument.CharValue)$this$writeAnnotationArgument).getValue().charValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ShortValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue(((KmAnnotationArgument.ShortValue)$this$writeAnnotationArgument).getValue().shortValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.IntValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue(((KmAnnotationArgument.IntValue)$this$writeAnnotationArgument).getValue().intValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.LongValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue(((KmAnnotationArgument.LongValue)$this$writeAnnotationArgument).getValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.FloatValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.FLOAT);
            $this$writeAnnotationArgument_u24lambda_u242.setFloatValue(((KmAnnotationArgument.FloatValue)$this$writeAnnotationArgument).getValue().floatValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.DoubleValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.DOUBLE);
            $this$writeAnnotationArgument_u24lambda_u242.setDoubleValue(((KmAnnotationArgument.DoubleValue)$this$writeAnnotationArgument).getValue());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.BooleanValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue(((KmAnnotationArgument.BooleanValue)$this$writeAnnotationArgument).getValue() != false ? 1L : 0L);
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.UByteValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue((long)((KmAnnotationArgument.UByteValue)$this$writeAnnotationArgument).getValue-w2LRezQ() & 0xFFL);
            $this$writeAnnotationArgument_u24lambda_u242.setFlags(Flags.IS_UNSIGNED.toFlags(true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.UShortValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue((long)((KmAnnotationArgument.UShortValue)$this$writeAnnotationArgument).getValue-Mh2AYeg() & 0xFFFFL);
            $this$writeAnnotationArgument_u24lambda_u242.setFlags(Flags.IS_UNSIGNED.toFlags(true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.UIntValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.INT);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue((long)((KmAnnotationArgument.UIntValue)$this$writeAnnotationArgument).getValue-pVg5ArA() & 0xFFFFFFFFL);
            $this$writeAnnotationArgument_u24lambda_u242.setFlags(Flags.IS_UNSIGNED.toFlags(true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ULongValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            $this$writeAnnotationArgument_u24lambda_u242.setIntValue(((KmAnnotationArgument.ULongValue)$this$writeAnnotationArgument).getValue-s-VKNKU());
            $this$writeAnnotationArgument_u24lambda_u242.setFlags(Flags.IS_UNSIGNED.toFlags(true));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.StringValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.STRING);
            $this$writeAnnotationArgument_u24lambda_u242.setStringValue(strings.getStringIndex(((KmAnnotationArgument.StringValue)$this$writeAnnotationArgument).getValue()));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.KClassValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            $this$writeAnnotationArgument_u24lambda_u242.setClassId(WriteUtilsKt.getClassNameIndex(strings, ((KmAnnotationArgument.KClassValue)$this$writeAnnotationArgument).getClassName()));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayKClassValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            $this$writeAnnotationArgument_u24lambda_u242.setClassId(WriteUtilsKt.getClassNameIndex(strings, ((KmAnnotationArgument.ArrayKClassValue)$this$writeAnnotationArgument).getClassName()));
            $this$writeAnnotationArgument_u24lambda_u242.setArrayDimensionCount(((KmAnnotationArgument.ArrayKClassValue)$this$writeAnnotationArgument).getArrayDimensionCount());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.EnumValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.ENUM);
            $this$writeAnnotationArgument_u24lambda_u242.setClassId(WriteUtilsKt.getClassNameIndex(strings, ((KmAnnotationArgument.EnumValue)$this$writeAnnotationArgument).getEnumClassName()));
            $this$writeAnnotationArgument_u24lambda_u242.setEnumValueId(strings.getStringIndex(((KmAnnotationArgument.EnumValue)$this$writeAnnotationArgument).getEnumEntryName()));
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.AnnotationValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION);
            $this$writeAnnotationArgument_u24lambda_u242.setAnnotation(WriteUtilsKt.writeAnnotation(((KmAnnotationArgument.AnnotationValue)$this$writeAnnotationArgument).getAnnotation(), strings).build());
        } else if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayValue) {
            $this$writeAnnotationArgument_u24lambda_u242.setType(ProtoBuf.Annotation.Argument.Value.Type.ARRAY);
            for (KmAnnotationArgument element : ((KmAnnotationArgument.ArrayValue)$this$writeAnnotationArgument).getElements()) {
                $this$writeAnnotationArgument_u24lambda_u242.addArrayElement(WriteUtilsKt.writeAnnotationArgument(element, strings));
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ProtoBuf.Annotation.Argument.Value.Builder builder2 = builder;
        Intrinsics.checkNotNullExpressionValue(builder2, "apply(...)");
        return builder2;
    }

    public static final int getClassNameIndex(@NotNull StringTable $this$getClassNameIndex, @NotNull String name) {
        int n2;
        Intrinsics.checkNotNullParameter($this$getClassNameIndex, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (ClassNameKt.isLocalClassName(name)) {
            String string = name.substring(1);
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
            n2 = $this$getClassNameIndex.getQualifiedClassNameIndex(string, true);
        } else {
            n2 = $this$getClassNameIndex.getQualifiedClassNameIndex(name, false);
        }
        return n2;
    }
}

