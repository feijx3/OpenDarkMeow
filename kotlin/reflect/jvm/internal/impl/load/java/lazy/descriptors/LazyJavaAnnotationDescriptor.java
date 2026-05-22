/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyJavaAnnotationDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaAnnotationDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaAnnotationDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1563#2:125\n1634#2,3:126\n1617#2,9:130\n1869#2:139\n1870#2:141\n1626#2:142\n1#3:129\n1#3:140\n*S KotlinDebug\n*F\n+ 1 LazyJavaAnnotationDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaAnnotationDescriptor\n*L\n94#1:125\n94#1:126,3\n62#1:130,9\n62#1:139\n62#1:141\n62#1:142\n62#1:140\n*E\n"})
public final class LazyJavaAnnotationDescriptor
implements PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final JavaAnnotation javaAnnotation;
    @NotNull
    private final NullableLazyValue fqName$delegate;
    @NotNull
    private final NotNullLazyValue type$delegate;
    @NotNull
    private final JavaSourceElement source;
    @NotNull
    private final NotNullLazyValue allValueArguments$delegate;
    private final boolean isIdeExternalAnnotation;
    private final boolean isFreshlySupportedTypeUseAnnotation;

    public LazyJavaAnnotationDescriptor(@NotNull LazyJavaResolverContext c2, @NotNull JavaAnnotation javaAnnotation, boolean isFreshlySupportedAnnotation) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(javaAnnotation, "javaAnnotation");
        this.c = c2;
        this.javaAnnotation = javaAnnotation;
        LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this;
        this.fqName$delegate = this.c.getStorageManager().createNullableLazyValue(new LazyJavaAnnotationDescriptor$$Lambda$0(lazyJavaAnnotationDescriptor));
        lazyJavaAnnotationDescriptor = this;
        this.type$delegate = this.c.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$$Lambda$1(lazyJavaAnnotationDescriptor));
        this.source = this.c.getComponents().getSourceElementFactory().source(this.javaAnnotation);
        lazyJavaAnnotationDescriptor = this;
        this.allValueArguments$delegate = this.c.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$$Lambda$2(lazyJavaAnnotationDescriptor));
        this.isIdeExternalAnnotation = this.javaAnnotation.isIdeExternalAnnotation();
        this.isFreshlySupportedTypeUseAnnotation = this.javaAnnotation.isFreshlySupportedTypeUseAnnotation() || isFreshlySupportedAnnotation;
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        this(lazyJavaResolverContext, javaAnnotation, bl2);
    }

    @Override
    @Nullable
    public FqName getFqName() {
        return (FqName)StorageKt.getValue(this.fqName$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    public SimpleType getType() {
        return (SimpleType)StorageKt.getValue(this.type$delegate, (Object)this, $$delegatedProperties[1]);
    }

    @Override
    @NotNull
    public JavaSourceElement getSource() {
        return this.source;
    }

    @Override
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map)StorageKt.getValue(this.allValueArguments$delegate, (Object)this, $$delegatedProperties[2]);
    }

    private final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument argument) {
        ConstantValue<Object> constantValue;
        JavaAnnotationArgument javaAnnotationArgument = argument;
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            constantValue = ConstantValueFactory.createConstantValue$default(ConstantValueFactory.INSTANCE, ((JavaLiteralAnnotationArgument)argument).getValue(), null, 2, null);
        } else if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            constantValue = this.resolveFromEnumValue(((JavaEnumValueAnnotationArgument)argument).getEnumClassId(), ((JavaEnumValueAnnotationArgument)argument).getEntryName());
        } else if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            Name name = ((JavaArrayAnnotationArgument)argument).getName();
            if (name == null) {
                name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            Name name2 = name;
            Intrinsics.checkNotNull(name2);
            constantValue = this.resolveFromArray(name2, ((JavaArrayAnnotationArgument)argument).getElements());
        } else {
            constantValue = javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument ? this.resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument)argument).getAnnotation()) : (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument ? this.resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument)argument).getReferencedType()) : null);
        }
        return constantValue;
    }

    private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation javaAnnotation) {
        return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.c, javaAnnotation, false, 4, null));
    }

    /*
     * WARNING - void declaration
     */
    private final ConstantValue<?> resolveFromArray(Name argumentName, List<? extends JavaAnnotationArgument> elements) {
        void $this$mapTo$iv$iv;
        if (KotlinTypeKt.isError(this.getType())) {
            return null;
        }
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getAnnotationClass(this);
        Intrinsics.checkNotNull(classDescriptor);
        Annotated annotated = DescriptorResolverUtils.getAnnotationParameterByName(argumentName, classDescriptor);
        if (annotated == null || (annotated = annotated.getType()) == null) {
            SimpleType simpleType = this.c.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType(ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
            Intrinsics.checkNotNullExpressionValue(simpleType, "getArrayType(...)");
            annotated = simpleType;
        }
        Annotated arrayType = annotated;
        Iterable $this$map$iv = elements;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void argument;
            JavaAnnotationArgument javaAnnotationArgument = (JavaAnnotationArgument)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            ConstantValue constantValue = this.resolveAnnotationArgument((JavaAnnotationArgument)argument);
            if (constantValue == null) {
                constantValue = new NullValue();
            }
            collection.add(constantValue);
        }
        List values = (List)destination$iv$iv;
        return ConstantValueFactory.INSTANCE.createArrayValue(values, (KotlinType)arrayType);
    }

    private final ConstantValue<?> resolveFromEnumValue(ClassId enumClassId, Name entryName) {
        if (enumClassId == null || entryName == null) {
            return null;
        }
        return new EnumValue(enumClassId, entryName);
    }

    private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType javaType) {
        return KClassValue.Companion.create(this.c.getTypeResolver().transformJavaType(javaType, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null)));
    }

    @NotNull
    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    private final ClassDescriptor createTypeForMissingDependencies(FqName fqName) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.c.getModule(), ClassId.Companion.topLevel(fqName), this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    @Override
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.isFreshlySupportedTypeUseAnnotation;
    }

    private static final FqName fqName_delegate$lambda$0(LazyJavaAnnotationDescriptor this$0) {
        ClassId classId = this$0.javaAnnotation.getClassId();
        return classId != null ? classId.asSingleFqName() : null;
    }

    private static final SimpleType type_delegate$lambda$2(LazyJavaAnnotationDescriptor this$0) {
        FqName fqName = this$0.getFqName();
        if (fqName == null) {
            String[] stringArray = new String[]{this$0.javaAnnotation.toString()};
            return ErrorUtils.createErrorType(ErrorTypeKind.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, stringArray);
        }
        FqName fqName2 = fqName;
        ClassDescriptor classDescriptor = JavaToKotlinClassMapper.mapJavaToKotlin$default(JavaToKotlinClassMapper.INSTANCE, fqName2, this$0.c.getModule().getBuiltIns(), null, 4, null);
        if (classDescriptor == null) {
            ClassDescriptor classDescriptor2;
            JavaClass javaClass = this$0.javaAnnotation.resolve();
            if (javaClass != null) {
                JavaClass javaClass2 = javaClass;
                boolean bl2 = false;
                classDescriptor2 = this$0.c.getComponents().getModuleClassResolver().resolveClass(javaClass2);
            } else {
                classDescriptor2 = classDescriptor = null;
            }
            if (classDescriptor2 == null) {
                classDescriptor = this$0.createTypeForMissingDependencies(fqName2);
            }
        }
        ClassDescriptor annotationClass = classDescriptor;
        return annotationClass.getDefaultType();
    }

    /*
     * WARNING - void declaration
     */
    private static final Map allValueArguments_delegate$lambda$5(LazyJavaAnnotationDescriptor this$0) {
        void $this$mapNotNullTo$iv$iv;
        Iterable $this$mapNotNull$iv = this$0.javaAnnotation.getArguments();
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Pair<Name, ConstantValue<?>> pair;
            Name name;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            JavaAnnotationArgument arg = (JavaAnnotationArgument)element$iv$iv;
            boolean bl3 = false;
            Name name2 = arg.getName();
            if (name2 == null) {
                name2 = name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            if (this$0.resolveAnnotationArgument(arg) != null) {
                ConstantValue<?> value;
                boolean bl4 = false;
                pair = TuplesKt.to(name, value);
            } else {
                pair = null;
            }
            if (pair == null) continue;
            Pair<Name, ConstantValue<?>> it$iv$iv = pair;
            boolean bl5 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return MapsKt.toMap((List)destination$iv$iv);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LazyJavaAnnotationDescriptor.class, "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaAnnotationDescriptor.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaAnnotationDescriptor.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ FqName accessor$LazyJavaAnnotationDescriptor$lambda0(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        return LazyJavaAnnotationDescriptor.fqName_delegate$lambda$0(lazyJavaAnnotationDescriptor);
    }

    static /* synthetic */ SimpleType accessor$LazyJavaAnnotationDescriptor$lambda1(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        return LazyJavaAnnotationDescriptor.type_delegate$lambda$2(lazyJavaAnnotationDescriptor);
    }

    static /* synthetic */ Map accessor$LazyJavaAnnotationDescriptor$lambda2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        return LazyJavaAnnotationDescriptor.allValueArguments_delegate$lambda$5(lazyJavaAnnotationDescriptor);
    }
}

