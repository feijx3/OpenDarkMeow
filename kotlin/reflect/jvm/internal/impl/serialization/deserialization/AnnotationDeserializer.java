/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nAnnotationDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n121#1:147\n121#1:148\n121#1:149\n121#1:150\n1208#2,2:128\n1236#2,4:130\n1617#2,9:134\n1869#2:143\n1870#2:145\n1626#2:146\n1563#2:151\n1634#2,3:152\n1740#2,3:155\n1#3:144\n*S KotlinDebug\n*F\n+ 1 AnnotationDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationDeserializer\n*L\n74#1:147\n76#1:148\n77#1:149\n78#1:150\n47#1:128,2\n47#1:130,4\n48#1:134,9\n48#1:143\n48#1:145\n48#1:146\n87#1:151\n87#1:152,3\n112#1:155,3\n48#1:144\n*E\n"})
public final class AnnotationDeserializer {
    @NotNull
    private final ModuleDescriptor module;
    @NotNull
    private final NotFoundClasses notFoundClasses;

    public AnnotationDeserializer(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final AnnotationDescriptor deserializeAnnotation(@NotNull ProtoBuf.Annotation proto, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        ClassDescriptor annotationClass = this.resolveClass(NameResolverUtilKt.getClassId(nameResolver, proto.getId()));
        Map<Name, ConstantValue<Object>> arguments = MapsKt.emptyMap();
        if (proto.getArgumentCount() != 0 && !ErrorUtils.isError(annotationClass) && DescriptorUtils.isAnnotationClass(annotationClass)) {
            Collection<ClassConstructorDescriptor> collection = annotationClass.getConstructors();
            Intrinsics.checkNotNullExpressionValue(collection, "getConstructors(...)");
            ClassConstructorDescriptor constructor = (ClassConstructorDescriptor)CollectionsKt.singleOrNull((Iterable)collection);
            if (constructor != null) {
                void $this$mapNotNullTo$iv$iv;
                void $this$associateByTo$iv$iv;
                List<ValueParameterDescriptor> list = constructor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
                Iterable $this$associateBy$iv = list;
                boolean $i$f$associateBy = false;
                int capacity$iv22 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                Iterable iterable = $this$associateBy$iv;
                Map destination$iv$iv = new LinkedHashMap(capacity$iv22);
                boolean $i$f$associateByTo = false;
                for (Object element$iv$iv : $this$associateByTo$iv$iv) {
                    void it;
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)element$iv$iv;
                    Map map = destination$iv$iv;
                    boolean bl2 = false;
                    map.put(it.getName(), element$iv$iv);
                }
                Map parameterByName = destination$iv$iv;
                List<ProtoBuf.Annotation.Argument> list2 = proto.getArgumentList();
                Intrinsics.checkNotNullExpressionValue(list2, "getArgumentList(...)");
                Iterable $this$mapNotNull$iv = list2;
                boolean $i$f$mapNotNull = false;
                Iterable capacity$iv22 = $this$mapNotNull$iv;
                Collection destination$iv$iv2 = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    Pair<Name, ConstantValue<?>> it$iv$iv;
                    Object element$iv$iv$iv;
                    Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                    boolean bl3 = false;
                    ProtoBuf.Annotation.Argument it = (ProtoBuf.Annotation.Argument)element$iv$iv;
                    boolean bl4 = false;
                    Intrinsics.checkNotNull(it);
                    if (this.resolveArgument(it, parameterByName, nameResolver) == null) continue;
                    boolean bl5 = false;
                    destination$iv$iv2.add(it$iv$iv);
                }
                arguments = MapsKt.toMap((List)destination$iv$iv2);
            }
        }
        return new AnnotationDescriptorImpl(annotationClass.getDefaultType(), arguments, SourceElement.NO_SOURCE);
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument proto, Map<Name, ? extends ValueParameterDescriptor> parameterByName, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = parameterByName.get(NameResolverUtilKt.getName(nameResolver, proto.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        ValueParameterDescriptor parameter = valueParameterDescriptor;
        Name name = NameResolverUtilKt.getName(nameResolver, proto.getNameId());
        KotlinType kotlinType = parameter.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        ProtoBuf.Annotation.Argument.Value value = proto.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return new Pair(name, this.resolveValueAndCheckExpectedType(kotlinType, value, nameResolver));
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType expectedType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue constantValue;
        ConstantValue it = constantValue = this.resolveValue(expectedType, value, nameResolver);
        boolean bl2 = false;
        ConstantValue constantValue2 = this.doesValueConformToExpectedType(it, expectedType, value) ? constantValue : null;
        if (constantValue2 == null) {
            constantValue2 = ErrorValue.Companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + expectedType);
        }
        return constantValue2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final ConstantValue<?> resolveValue(@NotNull KotlinType expectedType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        ConstantValue constantValue;
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Boolean bl2 = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        boolean isUnsigned = bl2;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1: {
                ConstantValue constantValue2;
                AnnotationDeserializer annotationDeserializer = this;
                byte $this$letIf$iv = (byte)value.getIntValue();
                boolean $i$f$letIf = false;
                if (isUnsigned) {
                    byte p0 = $this$letIf$iv;
                    boolean bl3 = false;
                    constantValue2 = new UByteValue(p0);
                } else {
                    byte p0 = $this$letIf$iv;
                    boolean bl4 = false;
                    constantValue2 = new ByteValue(p0);
                }
                constantValue = constantValue2;
                break;
            }
            case 2: {
                constantValue = new CharValue((char)value.getIntValue());
                break;
            }
            case 3: {
                ConstantValue constantValue3;
                AnnotationDeserializer this_$iv = this;
                short $this$letIf$iv = (short)value.getIntValue();
                boolean $i$f$letIf = false;
                if (isUnsigned) {
                    short p0 = $this$letIf$iv;
                    boolean bl5 = false;
                    constantValue3 = new UShortValue(p0);
                } else {
                    short p0 = $this$letIf$iv;
                    boolean bl6 = false;
                    constantValue3 = new ShortValue(p0);
                }
                constantValue = constantValue3;
                break;
            }
            case 4: {
                ConstantValue constantValue4;
                AnnotationDeserializer this_$iv = this;
                int $this$letIf$iv = (int)value.getIntValue();
                boolean $i$f$letIf = false;
                if (isUnsigned) {
                    int p0 = $this$letIf$iv;
                    boolean bl7 = false;
                    constantValue4 = new UIntValue(p0);
                } else {
                    int p0 = $this$letIf$iv;
                    boolean bl8 = false;
                    constantValue4 = new IntValue(p0);
                }
                constantValue = constantValue4;
                break;
            }
            case 5: {
                ConstantValue constantValue5;
                AnnotationDeserializer this_$iv = this;
                long $this$letIf$iv = value.getIntValue();
                boolean $i$f$letIf = false;
                if (isUnsigned) {
                    long p0 = $this$letIf$iv;
                    boolean bl9 = false;
                    constantValue5 = new ULongValue(p0);
                } else {
                    long p0 = $this$letIf$iv;
                    boolean bl10 = false;
                    constantValue5 = new LongValue(p0);
                }
                constantValue = constantValue5;
                break;
            }
            case 6: {
                constantValue = new FloatValue(value.getFloatValue());
                break;
            }
            case 7: {
                constantValue = new DoubleValue(value.getDoubleValue());
                break;
            }
            case 8: {
                constantValue = new BooleanValue(value.getIntValue() != 0L);
                break;
            }
            case 9: {
                constantValue = new StringValue(nameResolver.getString(value.getStringValue()));
                break;
            }
            case 10: {
                constantValue = new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                break;
            }
            case 11: {
                constantValue = new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
                break;
            }
            case 12: {
                ProtoBuf.Annotation annotation = value.getAnnotation();
                Intrinsics.checkNotNullExpressionValue(annotation, "getAnnotation(...)");
                constantValue = new AnnotationValue(this.deserializeAnnotation(annotation, nameResolver));
                break;
            }
            case 13: {
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                List<ProtoBuf.Annotation.Argument.Value> list = value.getArrayElementList();
                Intrinsics.checkNotNullExpressionValue(list, "getArrayElementList(...)");
                Iterable this_$iv = list;
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                boolean $i$f$map = false;
                void $i$f$letIf = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    ProtoBuf.Annotation.Argument.Value value2 = (ProtoBuf.Annotation.Argument.Value)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl11 = false;
                    SimpleType simpleType = this.getBuiltIns().getAnyType();
                    Intrinsics.checkNotNullExpressionValue(simpleType, "getAnyType(...)");
                    KotlinType kotlinType = simpleType;
                    Intrinsics.checkNotNull(it);
                    collection.add(this.resolveValue(kotlinType, (ProtoBuf.Annotation.Argument.Value)it, nameResolver));
                }
                constantValue = constantValueFactory.createArrayValue((List)destination$iv$iv, expectedType);
                break;
            }
            default: {
                String string = "Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + ')';
                throw new IllegalStateException(string.toString());
            }
        }
        return constantValue;
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> result, KotlinType expectedType, ProtoBuf.Annotation.Argument.Value value) {
        boolean bl2;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        block0 : switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 10: {
                ClassDescriptor expectedClass;
                ClassifierDescriptor classifierDescriptor = expectedType.getConstructor().getDeclarationDescriptor();
                ClassDescriptor classDescriptor = expectedClass = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
                if (expectedClass == null || KotlinBuiltIns.isKClass(expectedClass)) {
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 13: {
                if (!(result instanceof ArrayValue && ((List)((ArrayValue)result).getValue()).size() == value.getArrayElementList().size())) {
                    boolean $i$a$-check-AnnotationDeserializer$doesValueConformToExpectedType$22 = false;
                    String $i$a$-check-AnnotationDeserializer$doesValueConformToExpectedType$22 = "Deserialized ArrayValue should have the same number of elements as the original array value: " + result;
                    throw new IllegalStateException($i$a$-check-AnnotationDeserializer$doesValueConformToExpectedType$22.toString());
                }
                KotlinType kotlinType = this.getBuiltIns().getArrayElementTypeOrNull(expectedType);
                if (kotlinType == null) {
                    return false;
                }
                KotlinType expectedElementType = kotlinType;
                Iterable $this$all$iv = CollectionsKt.getIndices((Collection)((ArrayValue)result).getValue());
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl2 = true;
                    break;
                }
                Iterator iterator2 = $this$all$iv.iterator();
                while (iterator2.hasNext()) {
                    int element$iv;
                    int i2 = element$iv = ((IntIterator)iterator2).nextInt();
                    boolean bl3 = false;
                    ConstantValue constantValue = (ConstantValue)((List)((ArrayValue)result).getValue()).get(i2);
                    ProtoBuf.Annotation.Argument.Value value2 = value.getArrayElement(i2);
                    Intrinsics.checkNotNullExpressionValue(value2, "getArrayElement(...)");
                    if (this.doesValueConformToExpectedType(constantValue, expectedElementType, value2)) continue;
                    bl2 = false;
                    break block0;
                }
                bl2 = true;
                break;
            }
            default: {
                bl2 = Intrinsics.areEqual(result.getType(this.module), expectedType);
            }
        }
        return bl2;
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
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
                nArray[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
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

