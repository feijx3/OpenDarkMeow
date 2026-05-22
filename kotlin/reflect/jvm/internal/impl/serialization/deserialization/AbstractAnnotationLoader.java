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
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nAbstractAnnotationLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractAnnotationLoader.kt\norg/jetbrains/kotlin/serialization/deserialization/AbstractAnnotationLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1563#2:105\n1634#2,3:106\n1563#2:109\n1634#2,3:110\n1563#2:114\n1634#2,3:115\n1563#2:118\n1634#2,3:119\n1563#2:122\n1634#2,3:123\n1563#2:126\n1634#2,3:127\n1563#2:130\n1634#2,3:131\n1563#2:134\n1634#2,3:135\n1563#2:138\n1634#2,3:139\n1#3:113\n*S KotlinDebug\n*F\n+ 1 AbstractAnnotationLoader.kt\norg/jetbrains/kotlin/serialization/deserialization/AbstractAnnotationLoader\n*L\n18#1:105\n18#1:106,3\n37#1:109\n37#1:110,3\n44#1:114\n44#1:115,3\n51#1:118\n51#1:119,3\n58#1:122\n58#1:123,3\n71#1:126\n71#1:127,3\n91#1:130\n91#1:131,3\n97#1:134\n97#1:135,3\n101#1:138\n101#1:139,3\n*E\n"})
public abstract class AbstractAnnotationLoader<A>
implements AnnotationLoader<A> {
    @NotNull
    private final SerializerExtensionProtocol protocol;

    public AbstractAnnotationLoader(@NotNull SerializerExtensionProtocol protocol) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.protocol = protocol;
    }

    @NotNull
    protected final SerializerExtensionProtocol getProtocol() {
        return this.protocol;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class container) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(container, "container");
        List<ProtoBuf.Annotation> list = container.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> annotations = list;
        Iterable $this$map$iv = annotations;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void proto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)proto, container.getNameResolver()));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadCallableAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind2) {
        void $this$mapTo$iv$iv;
        List<ProtoBuf.Annotation> list;
        block8: {
            block10: {
                MessageLite messageLite;
                block9: {
                    block7: {
                        Intrinsics.checkNotNullParameter(container, "container");
                        Intrinsics.checkNotNullParameter(proto, "proto");
                        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
                        messageLite = proto;
                        if (!(messageLite instanceof ProtoBuf.Constructor)) break block7;
                        list = ((ProtoBuf.Constructor)proto).getExtension(this.protocol.getConstructorAnnotation());
                        break block8;
                    }
                    if (!(messageLite instanceof ProtoBuf.Function)) break block9;
                    list = ((ProtoBuf.Function)proto).getExtension(this.protocol.getFunctionAnnotation());
                    break block8;
                }
                if (!(messageLite instanceof ProtoBuf.Property)) break block10;
                switch (WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()]) {
                    case 1: {
                        list = ((ProtoBuf.Property)proto).getExtension(this.protocol.getPropertyAnnotation());
                        break block8;
                    }
                    case 2: {
                        list = ((ProtoBuf.Property)proto).getExtension(this.protocol.getPropertyGetterAnnotation());
                        break block8;
                    }
                    case 3: {
                        list = ((ProtoBuf.Property)proto).getExtension(this.protocol.getPropertySetterAnnotation());
                        break block8;
                    }
                    default: {
                        throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                    }
                }
            }
            throw new IllegalStateException(("Unknown message: " + proto).toString());
        }
        List<ProtoBuf.Annotation> list2 = list;
        if (list == null) {
            list2 = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> annotations = list2;
        Iterable $this$map$iv = annotations;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void annotationProto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)annotationProto, container.getNameResolver()));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto) {
        void $this$mapTo$iv$iv;
        List list;
        List<Object> list2;
        Object it;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension = this.protocol.getPropertyBackingFieldAnnotation();
        if (generatedExtension != null) {
            it = generatedExtension;
            boolean bl2 = false;
            list2 = proto.getExtension(it);
        } else {
            list2 = list = null;
        }
        if (list2 == null) {
            list = CollectionsKt.emptyList();
        }
        List annotations = list;
        Iterable $this$map$iv = annotations;
        boolean $i$f$map = false;
        it = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void annotationProto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)annotationProto, container.getNameResolver()));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto) {
        void $this$mapTo$iv$iv;
        List list;
        List<Object> list2;
        Object it;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension = this.protocol.getPropertyDelegatedFieldAnnotation();
        if (generatedExtension != null) {
            it = generatedExtension;
            boolean bl2 = false;
            list2 = proto.getExtension(it);
        } else {
            list2 = list = null;
        }
        if (list2 == null) {
            list = CollectionsKt.emptyList();
        }
        List annotations = list;
        Iterable $this$map$iv = annotations;
        boolean $i$f$map = false;
        it = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void annotationProto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)annotationProto, container.getNameResolver()));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.EnumEntry proto) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getEnumEntryAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> annotations = list;
        Iterable $this$map$iv = annotations;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void annotationProto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)annotationProto, container.getNameResolver()));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadValueParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite callableProto, @NotNull AnnotatedCallableKind kind2, int parameterIndex, @NotNull ProtoBuf.ValueParameter proto) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(callableProto, "callableProto");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(proto, "proto");
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> annotations = list;
        Iterable $this$map$iv = annotations;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void annotationProto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)annotationProto, container.getNameResolver()));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind2) {
        void $this$mapTo$iv$iv;
        List<Object> list;
        block10: {
            block11: {
                MessageLite messageLite;
                block9: {
                    Intrinsics.checkNotNullParameter(container, "container");
                    Intrinsics.checkNotNullParameter(proto, "proto");
                    Intrinsics.checkNotNullParameter((Object)kind2, "kind");
                    messageLite = proto;
                    if (!(messageLite instanceof ProtoBuf.Function)) break block9;
                    GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> generatedExtension = this.protocol.getFunctionExtensionReceiverAnnotation();
                    if (generatedExtension != null) {
                        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> it = generatedExtension;
                        boolean bl2 = false;
                        list = ((ProtoBuf.Function)proto).getExtension(it);
                    } else {
                        list = null;
                    }
                    break block10;
                }
                if (!(messageLite instanceof ProtoBuf.Property)) break block11;
                switch (WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()]) {
                    case 1: 
                    case 2: 
                    case 3: {
                        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension = this.protocol.getPropertyExtensionReceiverAnnotation();
                        if (generatedExtension != null) {
                            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> it = generatedExtension;
                            boolean bl3 = false;
                            list = ((ProtoBuf.Property)proto).getExtension(it);
                        } else {
                            list = null;
                        }
                        break block10;
                    }
                    default: {
                        throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + (Object)((Object)kind2)).toString());
                    }
                }
            }
            throw new IllegalStateException(("Unknown message: " + proto).toString());
        }
        List list2 = list;
        if (list == null) {
            list2 = CollectionsKt.emptyList();
        }
        List annotations = list2;
        Iterable $this$map$iv = annotations;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void annotationProto;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl4 = false;
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)annotationProto, container.getNameResolver()));
        }
        return (List)destination$iv$iv;
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
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getTypeAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
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
        List<ProtoBuf.Annotation> list = proto.getExtension(this.protocol.getTypeParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
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
            collection.add(this.loadAnnotation((ProtoBuf.Annotation)it, nameResolver));
        }
        return (List)destination$iv$iv;
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[AnnotatedCallableKind.values().length];
            try {
                nArray[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

