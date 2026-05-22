/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeSubstitution {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final TypeSubstitution EMPTY = new TypeSubstitution(){

        public Void get(KotlinType key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    };

    @Nullable
    public abstract TypeProjection get(@NotNull KotlinType var1);

    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType topLevelType, @NotNull Variance position) {
        Intrinsics.checkNotNullParameter(topLevelType, "topLevelType");
        Intrinsics.checkNotNullParameter((Object)position, "position");
        return topLevelType;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    @NotNull
    public Annotations filterAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return annotations;
    }

    @NotNull
    public final TypeSubstitutor buildSubstitutor() {
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(this);
        Intrinsics.checkNotNullExpressionValue(typeSubstitutor2, "create(...)");
        return typeSubstitutor2;
    }

    @NotNull
    public final TypeSubstitution replaceWithNonApproximating() {
        return new TypeSubstitution(this){
            final /* synthetic */ TypeSubstitution this$0;
            {
                this.this$0 = $receiver;
            }

            public TypeProjection get(KotlinType key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return this.this$0.get(key);
            }

            public boolean approximateCapturedTypes() {
                return false;
            }

            public boolean approximateContravariantCapturedTypes() {
                return false;
            }

            public Annotations filterAnnotations(Annotations annotations) {
                Intrinsics.checkNotNullParameter(annotations, "annotations");
                return this.this$0.filterAnnotations(annotations);
            }

            public KotlinType prepareTopLevelType(KotlinType topLevelType, Variance position) {
                Intrinsics.checkNotNullParameter(topLevelType, "topLevelType");
                Intrinsics.checkNotNullParameter((Object)((Object)position), "position");
                return this.this$0.prepareTopLevelType(topLevelType, position);
            }

            public boolean isEmpty() {
                return this.this$0.isEmpty();
            }
        };
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

