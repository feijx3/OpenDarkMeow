/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasExpansion {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final TypeAliasExpansion parent;
    @NotNull
    private final TypeAliasDescriptor descriptor;
    @NotNull
    private final List<TypeProjection> arguments;
    @NotNull
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;

    private TypeAliasExpansion(TypeAliasExpansion parent, TypeAliasDescriptor descriptor2, List<? extends TypeProjection> arguments, Map<TypeParameterDescriptor, ? extends TypeProjection> mapping) {
        this.parent = parent;
        this.descriptor = descriptor2;
        this.arguments = arguments;
        this.mapping = mapping;
    }

    @NotNull
    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Nullable
    public final TypeProjection getReplacement(@NotNull TypeConstructor constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        ClassifierDescriptor descriptor2 = constructor.getDeclarationDescriptor();
        return descriptor2 instanceof TypeParameterDescriptor ? this.mapping.get(descriptor2) : null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isRecursion(@NotNull TypeAliasDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        if (Intrinsics.areEqual(this.descriptor, descriptor2)) return true;
        TypeAliasExpansion typeAliasExpansion = this.parent;
        if (typeAliasExpansion == null) return false;
        boolean bl2 = typeAliasExpansion.isRecursion(descriptor2);
        if (!bl2) return false;
        return true;
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion parent, TypeAliasDescriptor descriptor2, List arguments, Map mapping, DefaultConstructorMarker $constructor_marker) {
        this(parent, descriptor2, arguments, mapping);
    }

    @SourceDebugExtension(value={"SMAP\nTypeAliasExpansion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasExpansion.kt\norg/jetbrains/kotlin/types/TypeAliasExpansion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1563#2:44\n1634#2,3:45\n*S KotlinDebug\n*F\n+ 1 TypeAliasExpansion.kt\norg/jetbrains/kotlin/types/TypeAliasExpansion$Companion\n*L\n34#1:44\n34#1:45,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final TypeAliasExpansion create(@Nullable TypeAliasExpansion parent, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> arguments) {
            void $this$mapTo$iv$iv;
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            List<TypeParameterDescriptor> list = typeAliasDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(it.getOriginal());
            }
            List typeParameters = (List)destination$iv$iv;
            Map mappedArguments = MapsKt.toMap(CollectionsKt.zip((Iterable)typeParameters, (Iterable)arguments));
            return new TypeAliasExpansion(parent, typeAliasDescriptor, arguments, mappedArguments, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

