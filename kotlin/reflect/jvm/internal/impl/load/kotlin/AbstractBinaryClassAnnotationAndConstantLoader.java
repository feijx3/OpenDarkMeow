/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C>
extends AbstractBinaryClassAnnotationLoader<A, AnnotationsContainerWithConstants<? extends A, ? extends C>>
implements AnnotationAndConstantLoader<A, C> {
    @NotNull
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<A, C>> storage;

    public AbstractBinaryClassAnnotationAndConstantLoader(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        super(kotlinClassFinder);
        AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader = this;
        this.storage = storageManager.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$0(abstractBinaryClassAnnotationAndConstantLoader));
    }

    @Override
    @NotNull
    protected AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(@NotNull KotlinJvmBinaryClass binaryClass) {
        Intrinsics.checkNotNullParameter(binaryClass, "binaryClass");
        return (AnnotationsContainerWithConstants)this.storage.invoke(binaryClass);
    }

    @Nullable
    protected abstract C loadConstant(@NotNull String var1, @NotNull Object var2);

    @Nullable
    protected abstract C transformToUnsignedConstant(@NotNull C var1);

    @Override
    @Nullable
    public C loadAnnotationDefaultValue(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto, @NotNull KotlinType expectedType) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        return this.loadConstantFromProperty(container, proto, AnnotatedCallableKind.PROPERTY_GETTER, expectedType, AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$1.INSTANCE);
    }

    @Override
    @Nullable
    public C loadPropertyConstant(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto, @NotNull KotlinType expectedType) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        return this.loadConstantFromProperty(container, proto, AnnotatedCallableKind.PROPERTY, expectedType, AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$2.INSTANCE);
    }

    private final C loadConstantFromProperty(ProtoContainer container, ProtoBuf.Property proto, AnnotatedCallableKind annotatedCallableKind, KotlinType expectedType, Function2<? super AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super MemberSignature, ? extends C> loader) {
        KotlinJvmBinaryClass specialCase = AbstractBinaryClassAnnotationLoader.Companion.getSpecialCaseContainerClass(container, true, true, Flags.IS_CONST.get(proto.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(proto), this.getKotlinClassFinder(), this.getMetadataVersion());
        KotlinJvmBinaryClass kotlinJvmBinaryClass = this.findClassWithAnnotationsAndInitializers(container, specialCase);
        if (kotlinJvmBinaryClass == null) {
            return null;
        }
        KotlinJvmBinaryClass kotlinClass = kotlinJvmBinaryClass;
        boolean requireHasFieldFlag = kotlinClass.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm());
        MemberSignature memberSignature = this.getCallableSignature(proto, container.getNameResolver(), container.getTypeTable(), annotatedCallableKind, requireHasFieldFlag);
        if (memberSignature == null) {
            return null;
        }
        MemberSignature signature = memberSignature;
        C c2 = loader.invoke((AnnotationsContainerWithConstants<A, C>)this.storage.invoke(kotlinClass), (MemberSignature)((MemberSignature)signature));
        if (c2 == null) {
            return null;
        }
        C result = c2;
        return UnsignedTypes.isUnsignedType(expectedType) ? this.transformToUnsignedConstant(result) : result;
    }

    private final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(KotlinJvmBinaryClass kotlinClass) {
        HashMap memberAnnotations = new HashMap();
        HashMap propertyConstants = new HashMap();
        HashMap annotationParametersDefaultValues = new HashMap();
        kotlinClass.visitMembers(new KotlinJvmBinaryClass.MemberVisitor(this, memberAnnotations, kotlinClass, annotationParametersDefaultValues, propertyConstants){
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;
            final /* synthetic */ HashMap<MemberSignature, List<A>> $memberAnnotations;
            final /* synthetic */ KotlinJvmBinaryClass $kotlinClass;
            final /* synthetic */ HashMap<MemberSignature, C> $annotationParametersDefaultValues;
            final /* synthetic */ HashMap<MemberSignature, C> $propertyConstants;
            {
                this.this$0 = $receiver;
                this.$memberAnnotations = $memberAnnotations;
                this.$kotlinClass = $kotlinClass;
                this.$annotationParametersDefaultValues = $annotationParametersDefaultValues;
                this.$propertyConstants = $propertyConstants;
            }

            public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(Name name, String desc) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(desc, "desc");
                String string = name.asString();
                Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
                return new loadAnnotationsAndInitializers.AnnotationVisitorForMethod(this, MemberSignature.Companion.fromMethodNameAndDesc(string, desc));
            }

            public KotlinJvmBinaryClass.AnnotationVisitor visitField(Name name, String desc, Object initializer) {
                C constant;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(desc, "desc");
                String string = name.asString();
                Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
                MemberSignature signature = MemberSignature.Companion.fromFieldNameAndDesc(string, desc);
                if (initializer != null && (constant = this.this$0.loadConstant(desc, initializer)) != null) {
                    ((Map)this.$propertyConstants).put(signature, constant);
                }
                return new loadAnnotationsAndInitializers.MemberAnnotationVisitor(this, signature);
            }
        }, this.getCachedFileContent(kotlinClass));
        return new AnnotationsContainerWithConstants(memberAnnotations, propertyConstants, annotationParametersDefaultValues);
    }

    protected final boolean isRepeatableWithImplicitContainer(@NotNull ClassId annotationClassId, @NotNull Map<Name, ? extends ConstantValue<?>> arguments) {
        Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (!Intrinsics.areEqual(annotationClassId, SpecialJvmAnnotations.INSTANCE.getJAVA_LANG_ANNOTATION_REPEATABLE())) {
            return false;
        }
        ConstantValue<?> constantValue = arguments.get(Name.identifier("value"));
        KClassValue kClassValue = constantValue instanceof KClassValue ? (KClassValue)constantValue : null;
        if (kClassValue == null) {
            return false;
        }
        KClassValue containerKClassValue = kClassValue;
        Object t2 = containerKClassValue.getValue();
        KClassValue.Value.NormalClass normalClass = t2 instanceof KClassValue.Value.NormalClass ? (KClassValue.Value.NormalClass)t2 : null;
        if (normalClass == null) {
            return false;
        }
        KClassValue.Value.NormalClass normalClass2 = normalClass;
        return this.isImplicitRepeatableContainer(normalClass2.getClassId());
    }

    private static final AnnotationsContainerWithConstants storage$lambda$0(AbstractBinaryClassAnnotationAndConstantLoader this$0, KotlinJvmBinaryClass kotlinClass) {
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        return this$0.loadAnnotationsAndInitializers(kotlinClass);
    }

    private static final Object loadAnnotationDefaultValue$lambda$1(AnnotationsContainerWithConstants $this$loadConstantFromProperty, MemberSignature it) {
        Intrinsics.checkNotNullParameter($this$loadConstantFromProperty, "$this$loadConstantFromProperty");
        Intrinsics.checkNotNullParameter(it, "it");
        return $this$loadConstantFromProperty.getAnnotationParametersDefaultValues().get(it);
    }

    private static final Object loadPropertyConstant$lambda$2(AnnotationsContainerWithConstants $this$loadConstantFromProperty, MemberSignature it) {
        Intrinsics.checkNotNullParameter($this$loadConstantFromProperty, "$this$loadConstantFromProperty");
        Intrinsics.checkNotNullParameter(it, "it");
        return $this$loadConstantFromProperty.getPropertyConstants().get(it);
    }

    static /* synthetic */ AnnotationsContainerWithConstants accessor$AbstractBinaryClassAnnotationAndConstantLoader$lambda0(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return AbstractBinaryClassAnnotationAndConstantLoader.storage$lambda$0(abstractBinaryClassAnnotationAndConstantLoader, kotlinJvmBinaryClass);
    }

    static /* synthetic */ Object accessor$AbstractBinaryClassAnnotationAndConstantLoader$lambda1(AnnotationsContainerWithConstants annotationsContainerWithConstants, MemberSignature memberSignature) {
        return AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationDefaultValue$lambda$1(annotationsContainerWithConstants, memberSignature);
    }

    static /* synthetic */ Object accessor$AbstractBinaryClassAnnotationAndConstantLoader$lambda2(AnnotationsContainerWithConstants annotationsContainerWithConstants, MemberSignature memberSignature) {
        return AbstractBinaryClassAnnotationAndConstantLoader.loadPropertyConstant$lambda$2(annotationsContainerWithConstants, memberSignature);
    }
}

