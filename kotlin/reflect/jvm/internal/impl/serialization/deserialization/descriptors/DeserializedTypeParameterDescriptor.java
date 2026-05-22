/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nDeserializedTypeParameterDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedTypeParameterDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedTypeParameterDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1563#2:59\n1634#2,3:60\n*S KotlinDebug\n*F\n+ 1 DeserializedTypeParameterDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedTypeParameterDescriptor\n*L\n51#1:59\n51#1:60,3\n*E\n"})
public final class DeserializedTypeParameterDescriptor
extends AbstractLazyTypeParameterDescriptor {
    @NotNull
    private final DeserializationContext c;
    @NotNull
    private final ProtoBuf.TypeParameter proto;
    @NotNull
    private final DeserializedAnnotations annotations;

    public DeserializedTypeParameterDescriptor(@NotNull DeserializationContext c2, @NotNull ProtoBuf.TypeParameter proto, int index) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(proto, "proto");
        StorageManager storageManager = c2.getStorageManager();
        DeclarationDescriptor declarationDescriptor = c2.getContainingDeclaration();
        Annotations annotations = Annotations.Companion.getEMPTY();
        Name name = NameResolverUtilKt.getName(c2.getNameResolver(), proto.getName());
        ProtoBuf.TypeParameter.Variance variance = proto.getVariance();
        Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
        super(storageManager, declarationDescriptor, annotations, name, ProtoEnumFlags.INSTANCE.variance(variance), proto.getReified(), index, SourceElement.NO_SOURCE, SupertypeLoopChecker.EMPTY.INSTANCE);
        this.c = c2;
        this.proto = proto;
        DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor = this;
        this.annotations = new DeserializedAnnotations(this.c.getStorageManager(), new DeserializedTypeParameterDescriptor$$Lambda$0(deserializedTypeParameterDescriptor));
    }

    @Override
    @NotNull
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected List<KotlinType> resolveUpperBounds() {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        List<ProtoBuf.Type> upperBounds = ProtoTypeTableUtilKt.upperBounds(this.proto, this.c.getTypeTable());
        if (upperBounds.isEmpty()) {
            return CollectionsKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
        }
        Iterable iterable = upperBounds;
        TypeDeserializer typeDeserializer = this.c.getTypeDeserializer();
        boolean $i$f$map = false;
        void var5_5 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            ProtoBuf.Type type = (ProtoBuf.Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(typeDeserializer.type((ProtoBuf.Type)p0));
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    protected Void reportSupertypeLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }

    private static final List annotations$lambda$0(DeserializedTypeParameterDescriptor this$0) {
        return CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(this$0.proto, this$0.c.getNameResolver()));
    }

    static /* synthetic */ List accessor$DeserializedTypeParameterDescriptor$lambda0(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        return DeserializedTypeParameterDescriptor.annotations$lambda$0(deserializedTypeParameterDescriptor);
    }
}

