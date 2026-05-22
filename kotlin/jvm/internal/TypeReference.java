/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\n\u0010\u000eJ\u0013\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\rH\u0002J\f\u0010$\u001a\u00020#*\u00020\u0006H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u001dR\u001c\u0010&\u001a\u00020#*\u0006\u0012\u0002\b\u00030'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006+"}, d2={"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "platformTypeUpperBound", "flags", "", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getArguments", "()Ljava/util/List;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getFlags$kotlin_stdlib$annotations", "getFlags$kotlin_stdlib", "()I", "annotations", "", "getAnnotations", "()Z", "equals", "other", "", "hashCode", "toString", "", "asString", "convertPrimitiveToWrapper", "arrayClassName", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.4")
public final class TypeReference
implements KType {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final KClassifier classifier;
    @NotNull
    private final List<KTypeProjection> arguments;
    @Nullable
    private final KType platformTypeUpperBound;
    private final int flags;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;

    @SinceKotlin(version="1.6")
    public TypeReference(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> arguments, @Nullable KType platformTypeUpperBound, int flags) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = platformTypeUpperBound;
        this.flags = flags;
    }

    @Override
    @NotNull
    public KClassifier getClassifier() {
        return this.classifier;
    }

    @Override
    @NotNull
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Nullable
    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    @SinceKotlin(version="1.6")
    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }

    @SinceKotlin(version="1.6")
    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    public TypeReference(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> arguments, boolean isMarkedNullable) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this(classifier, arguments, null, isMarkedNullable ? 1 : 0);
    }

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override
    public boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof TypeReference && Intrinsics.areEqual(this.getClassifier(), ((TypeReference)other).getClassifier()) && Intrinsics.areEqual(this.getArguments(), ((TypeReference)other).getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, ((TypeReference)other).platformTypeUpperBound) && this.flags == ((TypeReference)other).flags;
    }

    public int hashCode() {
        return (this.getClassifier().hashCode() * 31 + ((Object)this.getArguments()).hashCode()) * 31 + Integer.hashCode(this.flags);
    }

    @NotNull
    public String toString() {
        return this.asString(false) + " (Kotlin reflection is not available)";
    }

    private final String asString(boolean convertPrimitiveToWrapper) {
        String renderedUpper;
        String string;
        KClassifier kClassifier = this.getClassifier();
        KClass kClass = kClassifier instanceof KClass ? (KClass)kClassifier : null;
        Class<KClass> javaClass = kClass != null ? JvmClassMappingKt.getJavaClass(kClass) : null;
        if (javaClass == null) {
            string = this.getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            string = "kotlin.Nothing";
        } else if (javaClass.isArray()) {
            string = this.getArrayClassName(javaClass);
        } else if (convertPrimitiveToWrapper && javaClass.isPrimitive()) {
            KClassifier kClassifier2 = this.getClassifier();
            Intrinsics.checkNotNull(kClassifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            string = JvmClassMappingKt.getJavaObjectType((KClass)kClassifier2).getName();
        } else {
            string = javaClass.getName();
        }
        String klass = string;
        String args = this.getArguments().isEmpty() ? "" : CollectionsKt.joinToString$default(this.getArguments(), ", ", "<", ">", 0, null, arg_0 -> TypeReference.asString$lambda$0(this, arg_0), 24, null);
        String nullable = this.isMarkedNullable() ? "?" : "";
        String result = klass + args + nullable;
        KType upper = this.platformTypeUpperBound;
        return upper instanceof TypeReference ? (Intrinsics.areEqual(renderedUpper = ((TypeReference)upper).asString(true), result) ? result : (Intrinsics.areEqual(renderedUpper, result + '?') ? result + '!' : '(' + result + ".." + renderedUpper + ')')) : result;
    }

    private final String getArrayClassName(Class<?> $this$arrayClassName) {
        Class<?> clazz = $this$arrayClassName;
        return Intrinsics.areEqual(clazz, boolean[].class) ? "kotlin.BooleanArray" : (Intrinsics.areEqual(clazz, char[].class) ? "kotlin.CharArray" : (Intrinsics.areEqual(clazz, byte[].class) ? "kotlin.ByteArray" : (Intrinsics.areEqual(clazz, short[].class) ? "kotlin.ShortArray" : (Intrinsics.areEqual(clazz, int[].class) ? "kotlin.IntArray" : (Intrinsics.areEqual(clazz, float[].class) ? "kotlin.FloatArray" : (Intrinsics.areEqual(clazz, long[].class) ? "kotlin.LongArray" : (Intrinsics.areEqual(clazz, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array")))))));
    }

    private final String asString(KTypeProjection $this$asString) {
        Object object;
        if ($this$asString.getVariance() == null) {
            return "*";
        }
        KType kType = $this$asString.getType();
        Object object2 = kType instanceof TypeReference ? (TypeReference)kType : null;
        if (object2 == null || (object2 = ((TypeReference)object2).asString(true)) == null) {
            object2 = String.valueOf($this$asString.getType());
        }
        Object typeString = object2;
        KVariance kVariance = $this$asString.getVariance();
        switch (kVariance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()]) {
            case 1: {
                object = typeString;
                break;
            }
            case 2: {
                object = "in " + (String)typeString;
                break;
            }
            case 3: {
                object = "out " + (String)typeString;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return object;
    }

    private static final CharSequence asString$lambda$0(TypeReference this$0, KTypeProjection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.asString(it);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lkotlin/jvm/internal/TypeReference$Companion;", "", "<init>", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[KVariance.values().length];
            try {
                nArray[KVariance.INVARIANT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KVariance.IN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KVariance.OUT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

