/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n105#1,9:134\n105#1,9:143\n105#1,9:152\n774#2:161\n865#2,2:162\n*S KotlinDebug\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes\n*L\n74#1:134,9\n78#1:143,9\n82#1:152,9\n99#1:161\n99#1:162,2\n*E\n"})
public final class TypeAttributes
extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>>
implements Iterable<TypeAttribute<?>>,
KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final TypeAttributes Empty = new TypeAttributes(kotlin.collections.CollectionsKt.emptyList());

    private TypeAttributes(List<? extends TypeAttribute<?>> attributes) {
        for (TypeAttribute<?> attribute : attributes) {
            this.registerComponent(attribute.getKey(), attribute);
        }
    }

    private TypeAttributes(TypeAttribute<?> attribute) {
        this(kotlin.collections.CollectionsKt.listOf(attribute));
    }

    @NotNull
    public final TypeAttributes intersect(@NotNull TypeAttributes other) {
        TypeAttributes typeAttributes;
        Intrinsics.checkNotNullParameter(other, "other");
        TypeAttributes this_$iv = this;
        boolean $i$f$perform = false;
        if (this_$iv.isEmpty() && other.isEmpty()) {
            typeAttributes = this_$iv;
        } else {
            List attributes$iv = new ArrayList();
            Iterator iterator2 = TypeAttributes.Companion.getIndices().iterator();
            while (iterator2.hasNext()) {
                TypeAttribute typeAttribute;
                TypeAttribute it;
                TypeAttribute $this$intersect_u24lambda_u241;
                boolean bl2;
                int index$iv = ((Number)iterator2.next()).intValue();
                TypeAttribute a$iv = (TypeAttribute)this_$iv.getArrayMap().get(index$iv);
                TypeAttribute b$iv = (TypeAttribute)other.getArrayMap().get(index$iv);
                if (a$iv == null) {
                    if (b$iv != null) {
                        TypeAttribute typeAttribute2 = a$iv;
                        bl2 = false;
                        typeAttribute = $this$intersect_u24lambda_u241.intersect(it);
                    } else {
                        typeAttribute = null;
                    }
                } else {
                    it = b$iv;
                    bl2 = false;
                    typeAttribute = $this$intersect_u24lambda_u241.intersect(it);
                }
                TypeAttribute res$iv = typeAttribute;
                CollectionsKt.addIfNotNull(attributes$iv, res$iv);
            }
            typeAttributes = Companion.create(attributes$iv);
        }
        return typeAttributes;
    }

    @NotNull
    public final TypeAttributes add(@NotNull TypeAttributes other) {
        TypeAttributes typeAttributes;
        Intrinsics.checkNotNullParameter(other, "other");
        TypeAttributes this_$iv = this;
        boolean $i$f$perform = false;
        if (this_$iv.isEmpty() && other.isEmpty()) {
            typeAttributes = this_$iv;
        } else {
            List attributes$iv = new ArrayList();
            Iterator iterator2 = TypeAttributes.Companion.getIndices().iterator();
            while (iterator2.hasNext()) {
                TypeAttribute typeAttribute;
                TypeAttribute it;
                TypeAttribute $this$add_u24lambda_u242;
                boolean bl2;
                int index$iv = ((Number)iterator2.next()).intValue();
                TypeAttribute a$iv = (TypeAttribute)this_$iv.getArrayMap().get(index$iv);
                TypeAttribute b$iv = (TypeAttribute)other.getArrayMap().get(index$iv);
                if (a$iv == null) {
                    if (b$iv != null) {
                        TypeAttribute typeAttribute2 = a$iv;
                        bl2 = false;
                        typeAttribute = $this$add_u24lambda_u242.add(it);
                    } else {
                        typeAttribute = null;
                    }
                } else {
                    it = b$iv;
                    bl2 = false;
                    typeAttribute = $this$add_u24lambda_u242.add(it);
                }
                TypeAttribute res$iv = typeAttribute;
                CollectionsKt.addIfNotNull(attributes$iv, res$iv);
            }
            typeAttributes = Companion.create(attributes$iv);
        }
        return typeAttributes;
    }

    public final boolean contains(@NotNull TypeAttribute<?> attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        int index = Companion.getId(attribute.getKey());
        return this.getArrayMap().get(index) != null;
    }

    @NotNull
    public final TypeAttributes plus(@NotNull TypeAttribute<?> attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (this.contains(attribute)) {
            return this;
        }
        if (this.isEmpty()) {
            return new TypeAttributes(attribute);
        }
        List<TypeAttribute<?>> newAttributes = kotlin.collections.CollectionsKt.plus((Collection)kotlin.collections.CollectionsKt.toList(this), attribute);
        return Companion.create(newAttributes);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final TypeAttributes remove(@NotNull TypeAttribute<?> attribute) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (this.isEmpty()) {
            return this;
        }
        Iterable $this$filter$iv = this.getArrayMap();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            TypeAttribute it = (TypeAttribute)element$iv$iv;
            boolean bl2 = false;
            if (!(!Intrinsics.areEqual(it, attribute))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List attributes = (List)destination$iv$iv;
        if (attributes.size() == this.getArrayMap().getSize()) {
            return this;
        }
        return Companion.create(attributes);
    }

    @Override
    @NotNull
    protected TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    public /* synthetic */ TypeAttributes(List attributes, DefaultConstructorMarker $constructor_marker) {
        this(attributes);
    }

    @SourceDebugExtension(value={"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
    public static final class Companion
    extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        private Companion() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public int customComputeIfAbsent(@NotNull ConcurrentHashMap<String, Integer> $this$customComputeIfAbsent, @NotNull String key, @NotNull Function1<? super String, Integer> compute) {
            int n2;
            Intrinsics.checkNotNullParameter($this$customComputeIfAbsent, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(compute, "compute");
            Integer n3 = $this$customComputeIfAbsent.get(key);
            if (n3 != null) {
                n2 = n3;
            } else {
                ConcurrentHashMap<String, Integer> concurrentHashMap = $this$customComputeIfAbsent;
                synchronized (concurrentHashMap) {
                    int n4;
                    boolean bl2 = false;
                    Integer n5 = $this$customComputeIfAbsent.get(key);
                    if (n5 != null) {
                        n4 = n5;
                    } else {
                        Integer n6 = compute.invoke(key);
                        int it = ((Number)n6).intValue();
                        boolean bl3 = false;
                        $this$customComputeIfAbsent.putIfAbsent(key, it);
                        n4 = ((Number)n6).intValue();
                    }
                    int n7 = n4;
                    // MONITOREXIT @DISABLED, blocks:[0, 1, 5] lbl25 : MonitorExitStatement: MONITOREXIT : var4_4
                    n2 = n7;
                }
            }
            return n2;
        }

        @NotNull
        public final TypeAttributes getEmpty() {
            return Empty;
        }

        @NotNull
        public final TypeAttributes create(@NotNull List<? extends TypeAttribute<?>> attributes) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return attributes.isEmpty() ? this.getEmpty() : new TypeAttributes(attributes, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

