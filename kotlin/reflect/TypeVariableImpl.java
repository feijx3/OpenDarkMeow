/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExperimentalStdlibApi
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.TypeImpl;
import kotlin.reflect.TypesJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\tH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J%\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b\u00a2\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\f\u00a2\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\f\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "<init>", "(Lkotlin/reflect/KTypeParameter;)V", "getName", "", "getGenericDeclaration", "getBounds", "", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getTypeName", "equals", "", "other", "", "hashCode", "", "toString", "getAnnotation", "T", "", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "()[Ljava/lang/annotation/Annotation;", "getDeclaredAnnotations", "kotlin-stdlib"})
@ExperimentalStdlibApi
@SourceDebugExtension(value={"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n1563#2:231\n1634#2,3:232\n37#3:235\n36#3,3:236\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n*L\n116#1:231\n116#1:232,3\n116#1:235\n116#1:236,3\n*E\n"})
final class TypeVariableImpl
implements TypeVariable<GenericDeclaration>,
TypeImpl {
    @NotNull
    private final KTypeParameter typeParameter;

    public TypeVariableImpl(@NotNull KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
    }

    @Override
    @NotNull
    public String getName() {
        return this.typeParameter.getName();
    }

    @Override
    @NotNull
    public GenericDeclaration getGenericDeclaration() {
        String string = "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.typeParameter;
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Type[] getBounds() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this.typeParameter.getUpperBounds();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            KType kType = (KType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(TypesJVMKt.access$computeJavaType((KType)it, true));
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        return thisCollection$iv.toArray(new Type[0]);
    }

    @Override
    @NotNull
    public String getTypeName() {
        return this.getName();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof TypeVariable && Intrinsics.areEqual(this.getName(), ((TypeVariable)other).getName()) && Intrinsics.areEqual(this.getGenericDeclaration(), ((TypeVariable)other).getGenericDeclaration());
    }

    public int hashCode() {
        return this.getName().hashCode() ^ this.getGenericDeclaration().hashCode();
    }

    @NotNull
    public String toString() {
        return this.getTypeName();
    }

    @Override
    @Nullable
    public final <T extends Annotation> T getAnnotation(@NotNull Class<T> annotationClass) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        return null;
    }

    @Override
    @NotNull
    public final Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    @Override
    @NotNull
    public final Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }
}

