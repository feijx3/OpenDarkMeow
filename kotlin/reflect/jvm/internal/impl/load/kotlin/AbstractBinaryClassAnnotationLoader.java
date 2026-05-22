/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoaderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAbstractBinaryClassAnnotationLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,338:1\n1563#2:339\n1634#2,3:340\n1563#2:343\n1634#2,3:344\n*S KotlinDebug\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader\n*L\n197#1:339\n197#1:340,3\n201#1:343\n201#1:344,3\n*E\n"})
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>>
implements AnnotationLoader<A> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final KotlinClassFinder kotlinClassFinder;

    public AbstractBinaryClassAnnotationLoader(@NotNull KotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.kotlinClassFinder = kotlinClassFinder;
    }

    @NotNull
    protected final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    @NotNull
    public abstract MetadataVersion getMetadataVersion();

    @NotNull
    protected abstract S getAnnotationsContainer(@NotNull KotlinJvmBinaryClass var1);

    @Nullable
    protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId var1, @NotNull SourceElement var2, @NotNull List<A> var3);

    @Override
    @NotNull
    public abstract A loadAnnotation(@NotNull ProtoBuf.Annotation var1, @NotNull NameResolver var2);

    @Nullable
    protected final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(@NotNull ClassId annotationClassId, @NotNull SourceElement source, @NotNull List<A> result) {
        Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(annotationClassId)) {
            return null;
        }
        return this.loadAnnotation(annotationClassId, source, result);
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class $this$toBinaryClass) {
        SourceElement sourceElement = $this$toBinaryClass.getSource();
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = sourceElement instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement)sourceElement : null;
        return kotlinJvmBinarySourceElement != null ? kotlinJvmBinarySourceElement.getBinaryClass() : null;
    }

    @Nullable
    protected byte[] getCachedFileContent(@NotNull KotlinJvmBinaryClass kotlinClass) {
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        return null;
    }

    @Override
    @NotNull
    public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class container) {
        Intrinsics.checkNotNullParameter(container, "container");
        KotlinJvmBinaryClass kotlinJvmBinaryClass = this.toBinaryClass(container);
        if (kotlinJvmBinaryClass == null) {
            throw new IllegalStateException(("Class for loading annotations is not found: " + container.debugFqName()).toString());
        }
        KotlinJvmBinaryClass kotlinClass = kotlinJvmBinaryClass;
        ArrayList result = new ArrayList(1);
        kotlinClass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor(this, result){
            final /* synthetic */ AbstractBinaryClassAnnotationLoader<A, S> this$0;
            final /* synthetic */ ArrayList<A> $result;
            {
                this.this$0 = $receiver;
                this.$result = $result;
            }

            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement source) {
                Intrinsics.checkNotNullParameter(classId, "classId");
                Intrinsics.checkNotNullParameter(source, "source");
                return this.this$0.loadAnnotationIfNotSpecial(classId, source, (List)this.$result);
            }

            public void visitEnd() {
            }
        }, this.getCachedFileContent(kotlinClass));
        return result;
    }

    @Override
    @NotNull
    public List<A> loadCallableAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind2) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        if (kind2 == AnnotatedCallableKind.PROPERTY) {
            return this.loadPropertyAnnotations(container, (ProtoBuf.Property)proto, PropertyRelatedElement.PROPERTY);
        }
        MemberSignature memberSignature = AbstractBinaryClassAnnotationLoader.getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind2, false, 16, null);
        if (memberSignature == null) {
            return CollectionsKt.emptyList();
        }
        MemberSignature signature = memberSignature;
        return AbstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations$default(this, container, signature, false, false, null, false, 60, null);
    }

    @Override
    @NotNull
    public List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        return this.loadPropertyAnnotations(container, proto, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override
    @NotNull
    public List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        return this.loadPropertyAnnotations(container, proto, PropertyRelatedElement.DELEGATE_FIELD);
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer container, ProtoBuf.Property proto, PropertyRelatedElement element) {
        Boolean bl2 = Flags.IS_CONST.get(proto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        boolean isConst = bl2;
        boolean isMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(proto);
        if (element == PropertyRelatedElement.PROPERTY) {
            MemberSignature memberSignature = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(proto, container.getNameResolver(), container.getTypeTable(), false, true, false, 40, null);
            if (memberSignature == null) {
                return CollectionsKt.emptyList();
            }
            MemberSignature syntheticFunctionSignature = memberSignature;
            return AbstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations$default(this, container, syntheticFunctionSignature, true, false, isConst, isMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature memberSignature = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(proto, container.getNameResolver(), container.getTypeTable(), true, false, false, 48, null);
        if (memberSignature == null) {
            return CollectionsKt.emptyList();
        }
        MemberSignature fieldSignature = memberSignature;
        boolean isDelegated = StringsKt.contains$default((CharSequence)fieldSignature.getSignature(), "$delegate", false, 2, null);
        if (isDelegated != (element == PropertyRelatedElement.DELEGATE_FIELD)) {
            return CollectionsKt.emptyList();
        }
        return this.findClassAndLoadMemberAnnotations(container, fieldSignature, true, true, isConst, isMovedFromInterfaceCompanion);
    }

    @Override
    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.EnumEntry proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        MemberSignature signature = MemberSignature.Companion.fromFieldNameAndDesc(container.getNameResolver().getString(proto.getName()), ClassMapperLite.mapClass(((ProtoContainer.Class)container).getClassId().asString()));
        return AbstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations$default(this, container, signature, false, false, null, false, 60, null);
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer container, MemberSignature signature, boolean property, boolean field, Boolean isConst, boolean isMovedFromInterfaceCompanion) {
        KotlinJvmBinaryClass kotlinJvmBinaryClass = this.findClassWithAnnotationsAndInitializers(container, Companion.getSpecialCaseContainerClass(container, property, field, isConst, isMovedFromInterfaceCompanion, this.kotlinClassFinder, this.getMetadataVersion()));
        if (kotlinJvmBinaryClass == null) {
            return CollectionsKt.emptyList();
        }
        KotlinJvmBinaryClass kotlinClass = kotlinJvmBinaryClass;
        List<Object> list = ((AnnotationsContainer)this.getAnnotationsContainer(kotlinClass)).getMemberAnnotations().get(signature);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean bl2, boolean bl3, Boolean bl4, boolean bl5, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            bl3 = false;
        }
        if ((n2 & 0x10) != 0) {
            bl4 = null;
        }
        if ((n2 & 0x20) != 0) {
            bl5 = false;
        }
        return abstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, bl2, bl3, bl4, bl5);
    }

    @Override
    @NotNull
    public List<A> loadValueParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite callableProto, @NotNull AnnotatedCallableKind kind2, int parameterIndex, @NotNull ProtoBuf.ValueParameter proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(callableProto, "callableProto");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(proto, "proto");
        MemberSignature methodSignature = AbstractBinaryClassAnnotationLoader.getCallableSignature$default(this, callableProto, container.getNameResolver(), container.getTypeTable(), kind2, false, 16, null);
        if (methodSignature != null) {
            int index = parameterIndex + this.computeJvmParameterIndexShift(container, callableProto);
            MemberSignature paramSignature = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(methodSignature, index);
            return AbstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations$default(this, container, paramSignature, false, false, null, false, 60, null);
        }
        return CollectionsKt.emptyList();
    }

    private final int computeJvmParameterIndexShift(ProtoContainer container, MessageLite message) {
        int n2;
        MessageLite messageLite = message;
        if (messageLite instanceof ProtoBuf.Function) {
            n2 = ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function)message) ? 1 : 0;
        } else if (messageLite instanceof ProtoBuf.Property) {
            n2 = ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property)message) ? 1 : 0;
        } else if (messageLite instanceof ProtoBuf.Constructor) {
            Intrinsics.checkNotNull(container, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            n2 = ((ProtoContainer.Class)container).getKind() == ProtoBuf.Class.Kind.ENUM_CLASS ? 2 : (((ProtoContainer.Class)container).isInner() ? 1 : 0);
        } else {
            throw new UnsupportedOperationException("Unsupported message: " + message.getClass());
        }
        return n2;
    }

    @Override
    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind2) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        MemberSignature methodSignature = AbstractBinaryClassAnnotationLoader.getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind2, false, 16, null);
        if (methodSignature != null) {
            MemberSignature paramSignature = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(methodSignature, 0);
            return AbstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations$default(this, container, paramSignature, false, false, null, false, 60, null);
        }
        return CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type proto, @NotNull NameResolver nameResolver) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = proto.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkNotNullExpressionValue(list, "getExtension(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)it, nameResolver));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter proto, @NotNull NameResolver nameResolver) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = proto.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkNotNullExpressionValue(list, "getExtension(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)it, nameResolver));
        }
        return (List)destination$iv$iv;
    }

    @Nullable
    protected final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(@NotNull ProtoContainer container, @Nullable KotlinJvmBinaryClass specialCase) {
        Intrinsics.checkNotNullParameter(container, "container");
        KotlinJvmBinaryClass kotlinJvmBinaryClass = specialCase;
        if (kotlinJvmBinaryClass == null) {
            kotlinJvmBinaryClass = container instanceof ProtoContainer.Class ? this.toBinaryClass((ProtoContainer.Class)container) : null;
        }
        return kotlinJvmBinaryClass;
    }

    @Nullable
    protected final MemberSignature getCallableSignature(@NotNull MessageLite proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull AnnotatedCallableKind kind2, boolean requireHasFieldFlagForField) {
        MemberSignature memberSignature;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        MessageLite messageLite = proto;
        if (messageLite instanceof ProtoBuf.Constructor) {
            JvmMemberSignature.Method method = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor)proto, nameResolver, typeTable);
            if (method == null) {
                return null;
            }
            memberSignature = MemberSignature.Companion.fromJvmMemberSignature(method);
        } else if (messageLite instanceof ProtoBuf.Function) {
            JvmMemberSignature.Method method = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function)proto, nameResolver, typeTable);
            if (method == null) {
                return null;
            }
            memberSignature = MemberSignature.Companion.fromJvmMemberSignature(method);
        } else if (messageLite instanceof ProtoBuf.Property) {
            GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage)proto;
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
            if (jvmPropertySignature == null) {
                return null;
            }
            JvmProtoBuf.JvmPropertySignature signature = jvmPropertySignature;
            switch (WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()]) {
                case 1: {
                    if (signature.hasGetter()) {
                        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = signature.getGetter();
                        Intrinsics.checkNotNullExpressionValue(jvmMethodSignature, "getGetter(...)");
                        memberSignature = MemberSignature.Companion.fromMethod(nameResolver, jvmMethodSignature);
                        break;
                    }
                    memberSignature = null;
                    break;
                }
                case 2: {
                    if (signature.hasSetter()) {
                        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = signature.getSetter();
                        Intrinsics.checkNotNullExpressionValue(jvmMethodSignature, "getSetter(...)");
                        memberSignature = MemberSignature.Companion.fromMethod(nameResolver, jvmMethodSignature);
                        break;
                    }
                    memberSignature = null;
                    break;
                }
                case 3: {
                    memberSignature = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf.Property)proto, nameResolver, typeTable, true, true, requireHasFieldFlagForField);
                    break;
                }
                default: {
                    memberSignature = null;
                    break;
                }
            }
        } else {
            memberSignature = null;
        }
        return memberSignature;
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean bl2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        return abstractBinaryClassAnnotationLoader.getCallableSignature(messageLite, nameResolver, typeTable, annotatedCallableKind, bl2);
    }

    protected final boolean isImplicitRepeatableContainer(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.getOuterClassId() == null || !Intrinsics.areEqual(classId.getShortClassName().asString(), "Container")) {
            return false;
        }
        KotlinJvmBinaryClass klass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId, this.getMetadataVersion());
        return klass != null && SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(klass);
    }

    public static abstract class AnnotationsContainer<A> {
        @NotNull
        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();
    }

    @SourceDebugExtension(value={"SMAP\nAbstractBinaryClassAnnotationLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,338:1\n1#2:339\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final KotlinJvmBinaryClass getSpecialCaseContainerClass(@NotNull ProtoContainer container, boolean property, boolean field, @Nullable Boolean isConst, boolean isMovedFromInterfaceCompanion, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull MetadataVersion metadataVersion) {
            ProtoContainer.Class outerClass;
            SourceElement sourceElement;
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            if (property) {
                if (isConst == null) {
                    boolean $i$a$-checkNotNull-AbstractBinaryClassAnnotationLoader$Companion$getSpecialCaseContainerClass$22 = false;
                    String $i$a$-checkNotNull-AbstractBinaryClassAnnotationLoader$Companion$getSpecialCaseContainerClass$22 = "isConst should not be null for property (container=" + container + ')';
                    throw new IllegalStateException($i$a$-checkNotNull-AbstractBinaryClassAnnotationLoader$Companion$getSpecialCaseContainerClass$22.toString());
                }
                if (container instanceof ProtoContainer.Class && ((ProtoContainer.Class)container).getKind() == ProtoBuf.Class.Kind.INTERFACE) {
                    ClassId classId = ((ProtoContainer.Class)container).getClassId();
                    Name name = Name.identifier("DefaultImpls");
                    Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
                    return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, classId.createNestedClassId(name), metadataVersion);
                }
                if (isConst.booleanValue() && container instanceof ProtoContainer.Package) {
                    JvmClassName facadeClassName;
                    sourceElement = container.getSource();
                    JvmPackagePartSource jvmPackagePartSource = sourceElement instanceof JvmPackagePartSource ? (JvmPackagePartSource)sourceElement : null;
                    JvmClassName jvmClassName = facadeClassName = jvmPackagePartSource != null ? jvmPackagePartSource.getFacadeClassName() : null;
                    if (facadeClassName != null) {
                        String string = facadeClassName.getInternalName();
                        Intrinsics.checkNotNullExpressionValue(string, "getInternalName(...)");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, ClassId.Companion.topLevel(new FqName(StringsKt.replace$default(string, '/', '.', false, 4, null))), metadataVersion);
                    }
                }
            }
            if (field && container instanceof ProtoContainer.Class && ((ProtoContainer.Class)container).getKind() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (outerClass = ((ProtoContainer.Class)container).getOuterClass()) != null && (outerClass.getKind() == ProtoBuf.Class.Kind.CLASS || outerClass.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS || isMovedFromInterfaceCompanion && (outerClass.getKind() == ProtoBuf.Class.Kind.INTERFACE || outerClass.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS))) {
                sourceElement = outerClass.getSource();
                KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = sourceElement instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement)sourceElement : null;
                return kotlinJvmBinarySourceElement != null ? kotlinJvmBinarySourceElement.getBinaryClass() : null;
            }
            if (container instanceof ProtoContainer.Package && container.getSource() instanceof JvmPackagePartSource) {
                SourceElement sourceElement2 = container.getSource();
                Intrinsics.checkNotNull(sourceElement2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
                JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource)sourceElement2;
                KotlinJvmBinaryClass kotlinJvmBinaryClass = jvmPackagePartSource.getKnownJvmBinaryClass();
                if (kotlinJvmBinaryClass == null) {
                    kotlinJvmBinaryClass = KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, jvmPackagePartSource.getClassId(), metadataVersion);
                }
                return kotlinJvmBinaryClass;
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    private static final class PropertyRelatedElement
    extends Enum<PropertyRelatedElement> {
        public static final /* enum */ PropertyRelatedElement PROPERTY = new PropertyRelatedElement();
        public static final /* enum */ PropertyRelatedElement BACKING_FIELD = new PropertyRelatedElement();
        public static final /* enum */ PropertyRelatedElement DELEGATE_FIELD = new PropertyRelatedElement();
        private static final /* synthetic */ PropertyRelatedElement[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static PropertyRelatedElement[] values() {
            return (PropertyRelatedElement[])$VALUES.clone();
        }

        public static PropertyRelatedElement valueOf(String value) {
            return Enum.valueOf(PropertyRelatedElement.class, value);
        }

        static {
            $VALUES = propertyRelatedElementArray = new PropertyRelatedElement[]{PropertyRelatedElement.PROPERTY, PropertyRelatedElement.BACKING_FIELD, PropertyRelatedElement.DELEGATE_FIELD};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[AnnotatedCallableKind.values().length];
            try {
                nArray[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

