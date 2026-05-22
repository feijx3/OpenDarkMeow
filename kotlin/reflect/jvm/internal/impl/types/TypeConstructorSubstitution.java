/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
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
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeConstructorSubstitution
extends TypeSubstitution {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Override
    @Nullable
    public TypeProjection get(@NotNull KotlinType key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.get(key.getConstructor());
    }

    @Nullable
    public abstract TypeProjection get(@NotNull TypeConstructor var1);

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull TypeConstructor typeConstructor2, @NotNull List<? extends TypeProjection> arguments) {
        return Companion.create(typeConstructor2, arguments);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.createByConstructorsMap(map);
    }

    @SourceDebugExtension(value={"SMAP\nTypeSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/TypeConstructorSubstitution$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,207:1\n1563#2:208\n1634#2,3:209\n*S KotlinDebug\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/TypeConstructorSubstitution$Companion\n*L\n96#1:208\n96#1:209,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map, boolean approximateCapturedTypes) {
            Intrinsics.checkNotNullParameter(map, "map");
            return new TypeConstructorSubstitution(map, approximateCapturedTypes){
                final /* synthetic */ Map<TypeConstructor, TypeProjection> $map;
                final /* synthetic */ boolean $approximateCapturedTypes;
                {
                    this.$map = $map;
                    this.$approximateCapturedTypes = $approximateCapturedTypes;
                }

                public TypeProjection get(TypeConstructor key) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    return this.$map.get(key);
                }

                public boolean isEmpty() {
                    return this.$map.isEmpty();
                }

                public boolean approximateCapturedTypes() {
                    return this.$approximateCapturedTypes;
                }
            };
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map, boolean bl2, int n2, Object object) {
            if ((n2 & 2) != 0) {
                bl2 = false;
            }
            return companion.createByConstructorsMap(map, bl2);
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
            return this.create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        /*
         * WARNING - void declaration
         */
        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull TypeConstructor typeConstructor2, @NotNull List<? extends TypeProjection> arguments) {
            Intrinsics.checkNotNullParameter(typeConstructor2, "typeConstructor");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            List<TypeParameterDescriptor> list = typeConstructor2.getParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
            List<TypeParameterDescriptor> parameters = list;
            TypeParameterDescriptor typeParameterDescriptor = CollectionsKt.lastOrNull(parameters);
            boolean bl2 = typeParameterDescriptor != null ? typeParameterDescriptor.isCapturedFromOuterDeclaration() : false;
            if (bl2) {
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                List<TypeParameterDescriptor> list2 = typeConstructor2.getParameters();
                Intrinsics.checkNotNullExpressionValue(list2, "getParameters(...)");
                Iterable iterable = list2;
                Companion companion = this;
                boolean $i$f$map = false;
                void var6_7 = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl3 = false;
                    collection.add(it.getTypeConstructor());
                }
                return kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion.createByConstructorsMap$default(companion, MapsKt.toMap(CollectionsKt.zip((Iterable)((List)destination$iv$iv), (Iterable)arguments)), false, 2, null);
            }
            return new IndexedParametersSubstitution(parameters, arguments);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion.createByConstructorsMap$default(this, map, false, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

