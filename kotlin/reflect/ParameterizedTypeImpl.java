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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.ParameterizedTypeImpl;
import kotlin.reflect.TypeImpl;
import kotlin.reflect.TypesJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\u001a"}, d2={"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "getRawType", "getOwnerType", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"})
@ExperimentalStdlibApi
@SourceDebugExtension(value={"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n37#2:231\n36#2,3:232\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n*L\n190#1:231\n190#1:232,3\n*E\n"})
final class ParameterizedTypeImpl
implements ParameterizedType,
TypeImpl {
    @NotNull
    private final Class<?> rawType;
    @Nullable
    private final Type ownerType;
    @NotNull
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(@NotNull Class<?> rawType, @Nullable Type ownerType, @NotNull List<? extends Type> typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.rawType = rawType;
        this.ownerType = ownerType;
        Collection $this$toTypedArray$iv = typeArguments;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        this.typeArguments = thisCollection$iv.toArray(new Type[0]);
    }

    @Override
    @NotNull
    public Type getRawType() {
        return this.rawType;
    }

    @Override
    @Nullable
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override
    @NotNull
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override
    @NotNull
    public String getTypeName() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        StringBuilder $this$getTypeName_u24lambda_u240 = stringBuilder2 = new StringBuilder();
        boolean bl2 = false;
        if (this.ownerType != null) {
            $this$getTypeName_u24lambda_u240.append(TypesJVMKt.access$typeToString(this.ownerType));
            $this$getTypeName_u24lambda_u240.append("$");
            stringBuilder = $this$getTypeName_u24lambda_u240.append(this.rawType.getSimpleName());
        } else {
            stringBuilder = $this$getTypeName_u24lambda_u240.append(TypesJVMKt.access$typeToString(this.rawType));
        }
        if (!(this.typeArguments.length == 0)) {
            ArraysKt.joinTo$default(this.typeArguments, (Appendable)$this$getTypeName_u24lambda_u240, null, (CharSequence)"<", (CharSequence)">", 0, null, (Function1)getTypeName.1.1.INSTANCE, 50, null);
        }
        return stringBuilder2.toString();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ParameterizedType && Intrinsics.areEqual(this.rawType, ((ParameterizedType)other).getRawType()) && Intrinsics.areEqual(this.ownerType, ((ParameterizedType)other).getOwnerType()) && Arrays.equals(this.getActualTypeArguments(), ((ParameterizedType)other).getActualTypeArguments());
    }

    public int hashCode() {
        Type type = this.ownerType;
        return this.rawType.hashCode() ^ (type != null ? type.hashCode() : 0) ^ Arrays.hashCode(this.getActualTypeArguments());
    }

    @NotNull
    public String toString() {
        return this.getTypeName();
    }
}

