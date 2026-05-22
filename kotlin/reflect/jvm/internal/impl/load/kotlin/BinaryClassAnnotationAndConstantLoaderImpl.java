/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl
extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    @NotNull
    private final ModuleDescriptor module;
    @NotNull
    private final NotFoundClasses notFoundClasses;
    @NotNull
    private final AnnotationDeserializer annotationDeserializer;
    @NotNull
    private MetadataVersion metadataVersion;

    public BinaryClassAnnotationAndConstantLoaderImpl(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses, @NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        super(storageManager, kotlinClassFinder);
        this.module = module;
        this.notFoundClasses = notFoundClasses;
        this.annotationDeserializer = new AnnotationDeserializer(this.module, this.notFoundClasses);
        this.metadataVersion = MetadataVersion.INSTANCE;
    }

    @Override
    @NotNull
    public MetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public void setMetadataVersion(@NotNull MetadataVersion metadataVersion) {
        Intrinsics.checkNotNullParameter(metadataVersion, "<set-?>");
        this.metadataVersion = metadataVersion;
    }

    @Override
    @NotNull
    public AnnotationDescriptor loadAnnotation(@NotNull ProtoBuf.Annotation proto, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(proto, nameResolver);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    @Nullable
    protected ConstantValue<?> loadConstant(@NotNull String desc, @NotNull Object initializer) {
        Object object;
        block11: {
            block8: {
                int intValue;
                block10: {
                    block9: {
                        Intrinsics.checkNotNullParameter(desc, "desc");
                        Intrinsics.checkNotNullParameter(initializer, "initializer");
                        if (!StringsKt.contains$default((CharSequence)"ZBCS", desc, false, 2, null)) break block8;
                        intValue = (Integer)initializer;
                        String string = desc;
                        switch (string.hashCode()) {
                            case 66: {
                                if (string.equals("B")) break;
                                throw new AssertionError((Object)desc);
                            }
                            case 67: {
                                if (!string.equals("C")) {
                                    throw new AssertionError((Object)desc);
                                }
                                break block9;
                            }
                            case 83: {
                                if (!string.equals("S")) {
                                    throw new AssertionError((Object)desc);
                                }
                                break block10;
                            }
                            case 90: {
                                if (!string.equals("Z")) throw new AssertionError((Object)desc);
                                object = intValue != 0;
                                break block11;
                            }
                        }
                        object = (byte)intValue;
                        break block11;
                    }
                    object = Character.valueOf((char)intValue);
                    break block11;
                }
                object = (short)intValue;
                break block11;
                throw new AssertionError((Object)desc);
            }
            object = initializer;
        }
        Object normalizedValue = object;
        return ConstantValueFactory.INSTANCE.createConstantValue(normalizedValue, this.module);
    }

    @Override
    @Nullable
    protected ConstantValue<?> transformToUnsignedConstant(@NotNull ConstantValue<?> constant) {
        Intrinsics.checkNotNullParameter(constant, "constant");
        ConstantValue constantValue = constant;
        return constantValue instanceof ByteValue ? (ConstantValue)new UByteValue(((Number)((ByteValue)constant).getValue()).byteValue()) : (constantValue instanceof ShortValue ? (ConstantValue)new UShortValue(((Number)((ShortValue)constant).getValue()).shortValue()) : (constantValue instanceof IntValue ? (ConstantValue)new UIntValue(((Number)((IntValue)constant).getValue()).intValue()) : (constantValue instanceof LongValue ? (ConstantValue)new ULongValue(((Number)((LongValue)constant).getValue()).longValue()) : constant)));
    }

    @Override
    @Nullable
    protected KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId annotationClassId, @NotNull SourceElement source, @NotNull List<AnnotationDescriptor> result) {
        Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        ClassDescriptor annotationClass = this.resolveClass(annotationClassId);
        return new AbstractAnnotationArgumentVisitor(this, annotationClass, annotationClassId, result, source){
            private final HashMap<Name, ConstantValue<?>> arguments;
            final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;
            final /* synthetic */ ClassDescriptor $annotationClass;
            final /* synthetic */ ClassId $annotationClassId;
            final /* synthetic */ List<AnnotationDescriptor> $result;
            final /* synthetic */ SourceElement $source;
            {
                this.this$0 = $receiver;
                this.$annotationClass = $annotationClass;
                this.$annotationClassId = $annotationClassId;
                this.$result = $result;
                this.$source = $source;
                this.arguments = new HashMap<K, V>();
            }

            public void visitConstantValue(Name name, ConstantValue<?> value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (name != null) {
                    ((Map)this.arguments).put(name, value);
                }
            }

            /*
             * WARNING - void declaration
             */
            public void visitArrayValue(Name name, ArrayList<ConstantValue<?>> elements) {
                Intrinsics.checkNotNullParameter(elements, "elements");
                if (name == null) {
                    return;
                }
                ValueParameterDescriptor parameter = DescriptorResolverUtils.getAnnotationParameterByName(name, this.$annotationClass);
                if (parameter != null) {
                    Map map = this.arguments;
                    List<ConstantValue<?>> list = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(elements);
                    KotlinType kotlinType = parameter.getType();
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                    ArrayValue arrayValue = ConstantValueFactory.INSTANCE.createArrayValue(list, kotlinType);
                    map.put(name, arrayValue);
                } else if (this.this$0.isImplicitRepeatableContainer(this.$annotationClassId) && Intrinsics.areEqual(name.asString(), "value")) {
                    void $this$mapTo$iv;
                    void $this$filterIsInstanceTo$iv$iv;
                    Iterable $this$filterIsInstance$iv = elements;
                    boolean $i$f$filterIsInstance = false;
                    Iterable iterable = $this$filterIsInstance$iv;
                    Collection destination$iv$iv = new ArrayList<E>();
                    boolean $i$f$filterIsInstanceTo = false;
                    for (T element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                        if (!(element$iv$iv instanceof AnnotationValue)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filterIsInstance$iv = (List)destination$iv$iv;
                    Collection destination$iv = this.$result;
                    boolean $i$f$mapTo = false;
                    for (T item$iv : $this$mapTo$iv) {
                        void p0;
                        AnnotationValue annotationValue = (AnnotationValue)item$iv;
                        Collection collection = destination$iv;
                        boolean bl2 = false;
                        collection.add((AnnotationDescriptor)p0.getValue());
                    }
                }
            }

            public void visitEnd() {
                if (this.this$0.isRepeatableWithImplicitContainer(this.$annotationClassId, (Map)this.arguments)) {
                    return;
                }
                if (this.this$0.isImplicitRepeatableContainer(this.$annotationClassId)) {
                    return;
                }
                this.$result.add(new AnnotationDescriptorImpl(this.$annotationClass.getDefaultType(), (Map)this.arguments, this.$source));
            }
        };
    }

    private final ConstantValue<?> createConstant(Name name, Object value) {
        ConstantValue constantValue = ConstantValueFactory.INSTANCE.createConstantValue(value, this.module);
        if (constantValue == null) {
            constantValue = ErrorValue.Companion.create("Unsupported annotation argument: " + name);
        }
        return constantValue;
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    private abstract class AbstractAnnotationArgumentVisitor
    implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        public abstract void visitConstantValue(@Nullable Name var1, @NotNull ConstantValue<?> var2);

        public abstract void visitArrayValue(@Nullable Name var1, @NotNull ArrayList<ConstantValue<?>> var2);

        @Override
        public void visit(@Nullable Name name, @Nullable Object value) {
            this.visitConstantValue(name, BinaryClassAnnotationAndConstantLoaderImpl.this.createConstant(name, value));
        }

        @Override
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.visitConstantValue(name, new KClassValue(value));
        }

        @Override
        public void visitEnum(@Nullable Name name, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
            Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            this.visitConstantValue(name, new EnumValue(enumClassId, enumEntryName));
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            return new KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor(BinaryClassAnnotationAndConstantLoaderImpl.this, name, this){
                private final ArrayList<ConstantValue<?>> elements;
                final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;
                final /* synthetic */ Name $name;
                final /* synthetic */ AbstractAnnotationArgumentVisitor this$1;
                {
                    this.this$0 = $receiver;
                    this.$name = $name;
                    this.this$1 = $receiver2;
                    this.elements = new ArrayList<E>();
                }

                public void visit(Object value) {
                    this.elements.add(BinaryClassAnnotationAndConstantLoaderImpl.access$createConstant(this.this$0, this.$name, value));
                }

                public void visitEnum(ClassId enumClassId, Name enumEntryName) {
                    Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
                    Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
                    this.elements.add(new EnumValue(enumClassId, enumEntryName));
                }

                public void visitClassLiteral(ClassLiteralValue value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this.elements.add(new KClassValue(value));
                }

                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId) {
                    Intrinsics.checkNotNullParameter(classId, "classId");
                    ArrayList<AnnotationDescriptor> list = new ArrayList<AnnotationDescriptor>();
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor = this.this$0.loadAnnotation(classId, sourceElement, (List<AnnotationDescriptor>)list);
                    Intrinsics.checkNotNull(annotationArgumentVisitor);
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor2 = annotationArgumentVisitor;
                    return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(visitor2, this, list){
                        private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
                        final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $visitor;
                        final /* synthetic */ visitArray.1 this$0;
                        final /* synthetic */ ArrayList<AnnotationDescriptor> $list;
                        {
                            this.$visitor = $visitor;
                            this.this$0 = $receiver;
                            this.$list = $list;
                            this.$$delegate_0 = $visitor;
                        }

                        public void visitEnd() {
                            this.$visitor.visitEnd();
                            visitArray.1.access$getElements$p(this.this$0).add(new AnnotationValue((AnnotationDescriptor)CollectionsKt.single((List)this.$list)));
                        }

                        public void visit(Name name, Object value) {
                            this.$$delegate_0.visit(name, value);
                        }

                        public void visitClassLiteral(Name name, ClassLiteralValue value) {
                            Intrinsics.checkNotNullParameter(value, "value");
                            this.$$delegate_0.visitClassLiteral(name, value);
                        }

                        public void visitEnum(Name name, ClassId enumClassId, Name enumEntryName) {
                            Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
                            Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
                            this.$$delegate_0.visitEnum(name, enumClassId, enumEntryName);
                        }

                        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
                            Intrinsics.checkNotNullParameter(classId, "classId");
                            return this.$$delegate_0.visitAnnotation(name, classId);
                        }

                        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name) {
                            return this.$$delegate_0.visitArray(name);
                        }
                    };
                }

                public void visitEnd() {
                    this.this$1.visitArrayValue(this.$name, this.elements);
                }

                public static final /* synthetic */ ArrayList access$getElements$p(visitArray.1 $this) {
                    return $this.elements;
                }
            };
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            ArrayList<AnnotationDescriptor> list = new ArrayList<AnnotationDescriptor>();
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor = BinaryClassAnnotationAndConstantLoaderImpl.this.loadAnnotation(classId, sourceElement, (List<AnnotationDescriptor>)list);
            Intrinsics.checkNotNull(annotationArgumentVisitor);
            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor2 = annotationArgumentVisitor;
            return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(visitor2, this, name, list){
                private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
                final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $visitor;
                final /* synthetic */ AbstractAnnotationArgumentVisitor this$0;
                final /* synthetic */ Name $name;
                final /* synthetic */ ArrayList<AnnotationDescriptor> $list;
                {
                    this.$visitor = $visitor;
                    this.this$0 = $receiver;
                    this.$name = $name;
                    this.$list = $list;
                    this.$$delegate_0 = $visitor;
                }

                public void visitEnd() {
                    this.$visitor.visitEnd();
                    this.this$0.visitConstantValue(this.$name, new AnnotationValue((AnnotationDescriptor)CollectionsKt.single((List)this.$list)));
                }

                public void visit(Name name, Object value) {
                    this.$$delegate_0.visit(name, value);
                }

                public void visitClassLiteral(Name name, ClassLiteralValue value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this.$$delegate_0.visitClassLiteral(name, value);
                }

                public void visitEnum(Name name, ClassId enumClassId, Name enumEntryName) {
                    Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
                    Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
                    this.$$delegate_0.visitEnum(name, enumClassId, enumEntryName);
                }

                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
                    Intrinsics.checkNotNullParameter(classId, "classId");
                    return this.$$delegate_0.visitAnnotation(name, classId);
                }

                public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name) {
                    return this.$$delegate_0.visitArray(name);
                }
            };
        }
    }
}

