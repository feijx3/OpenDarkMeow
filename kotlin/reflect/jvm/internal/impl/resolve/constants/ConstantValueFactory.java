/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nConstantValueFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstantValueFactory.kt\norg/jetbrains/kotlin/resolve/constants/ConstantValueFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1617#2,9:104\n1869#2:113\n1870#2:115\n1626#2:116\n1#3:114\n*S KotlinDebug\n*F\n+ 1 ConstantValueFactory.kt\norg/jetbrains/kotlin/resolve/constants/ConstantValueFactory\n*L\n64#1:104,9\n64#1:113\n64#1:115\n64#1:116\n64#1:114\n*E\n"})
public final class ConstantValueFactory {
    @NotNull
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    private ConstantValueFactory() {
    }

    @NotNull
    public final ArrayValue createArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return new TypedArrayValue(value, type);
    }

    @Nullable
    public final ConstantValue<?> createConstantValue(@Nullable Object value, @Nullable ModuleDescriptor module) {
        Object object = value;
        return object instanceof Byte ? (ConstantValue)new ByteValue(((Number)value).byteValue()) : (object instanceof Short ? (ConstantValue)new ShortValue(((Number)value).shortValue()) : (object instanceof Integer ? (ConstantValue)new IntValue(((Number)value).intValue()) : (object instanceof Long ? (ConstantValue)new LongValue(((Number)value).longValue()) : (object instanceof Character ? (ConstantValue)new CharValue(((Character)value).charValue()) : (object instanceof Float ? (ConstantValue)new FloatValue(((Number)value).floatValue()) : (object instanceof Double ? (ConstantValue)new DoubleValue(((Number)value).doubleValue()) : (object instanceof Boolean ? (ConstantValue)new BooleanValue((Boolean)value) : (object instanceof String ? (ConstantValue)new StringValue((String)value) : (object instanceof byte[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((byte[])value), module, PrimitiveType.BYTE) : (object instanceof short[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((short[])value), module, PrimitiveType.SHORT) : (object instanceof int[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((int[])value), module, PrimitiveType.INT) : (object instanceof long[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((long[])value), module, PrimitiveType.LONG) : (object instanceof char[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((char[])value), module, PrimitiveType.CHAR) : (object instanceof float[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((float[])value), module, PrimitiveType.FLOAT) : (object instanceof double[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((double[])value), module, PrimitiveType.DOUBLE) : (object instanceof boolean[] ? (ConstantValue)this.createArrayValue(ArraysKt.toList((boolean[])value), module, PrimitiveType.BOOLEAN) : (object == null ? (ConstantValue)new NullValue() : null)))))))))))))))));
    }

    public static /* synthetic */ ConstantValue createConstantValue$default(ConstantValueFactory constantValueFactory, Object object, ModuleDescriptor moduleDescriptor, int n2, Object object2) {
        if ((n2 & 2) != 0) {
            moduleDescriptor = null;
        }
        return constantValueFactory.createConstantValue(object, moduleDescriptor);
    }

    /*
     * WARNING - void declaration
     */
    private final ArrayValue createArrayValue(List<?> value, ModuleDescriptor module, PrimitiveType componentType) {
        ArrayValue arrayValue;
        void $this$mapNotNullTo$iv$iv;
        Iterable $this$mapNotNull$iv = CollectionsKt.toList((Iterable)value);
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            ConstantValue it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            Object p0 = element$iv$iv;
            boolean bl3 = false;
            if (ConstantValueFactory.createConstantValue$default(this, p0, null, 2, null) == null) continue;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        List elements = (List)destination$iv$iv;
        if (module != null) {
            SimpleType simpleType = module.getBuiltIns().getPrimitiveArrayKotlinType(componentType);
            Intrinsics.checkNotNullExpressionValue(simpleType, "getPrimitiveArrayKotlinType(...)");
            arrayValue = new TypedArrayValue(elements, simpleType);
        } else {
            PrimitiveType primitiveType = componentType;
            ArrayValue arrayValue2 = new ArrayValue(elements, new ConstantValueFactory$$Lambda$0(primitiveType));
            arrayValue = arrayValue2;
        }
        return arrayValue;
    }

    private static final KotlinType createArrayValue$lambda$0(PrimitiveType $componentType, ModuleDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SimpleType simpleType = it.getBuiltIns().getPrimitiveArrayKotlinType($componentType);
        Intrinsics.checkNotNullExpressionValue(simpleType, "getPrimitiveArrayKotlinType(...)");
        return simpleType;
    }

    static /* synthetic */ KotlinType accessor$ConstantValueFactory$lambda0(PrimitiveType primitiveType, ModuleDescriptor moduleDescriptor) {
        return ConstantValueFactory.createArrayValue$lambda$0(primitiveType, moduleDescriptor);
    }
}

