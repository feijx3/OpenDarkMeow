/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H'J\u0013\u0010B\u001a\u00020\u001a2\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u00a6\u0002J\b\u0010D\u001a\u00020EH&R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u0004\u0018\u00018\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001d8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R(\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000\u001d8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b(\u0010 \u001a\u0004\b)\u0010\"R\u001c\u0010*\u001a\u0004\u0018\u00010+8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010 \u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b0\u0010 \u001a\u0004\b/\u00101R\u001a\u00102\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b3\u0010 \u001a\u0004\b2\u00101R\u001a\u00104\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b5\u0010 \u001a\u0004\b4\u00101R\u001a\u00106\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b7\u0010 \u001a\u0004\b6\u00101R\u001a\u00108\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b9\u0010 \u001a\u0004\b8\u00101R\u001a\u0010:\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010 \u001a\u0004\b:\u00101R\u001a\u0010<\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b=\u0010 \u001a\u0004\b<\u00101R\u001a\u0010>\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b?\u0010 \u001a\u0004\b>\u00101R\u001a\u0010@\u001a\u00020\u001a8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010 \u001a\u0004\b@\u00101\u00a8\u0006F"}, d2={"Lkotlin/reflect/KClass;", "T", "", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "()Ljava/util/List;", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "equals", "other", "hashCode", "", "kotlin-stdlib"})
public interface KClass<T>
extends KDeclarationContainer,
KAnnotatedElement,
KClassifier {
    @Nullable
    public String getSimpleName();

    @Nullable
    public String getQualifiedName();

    @Override
    @NotNull
    public Collection<KCallable<?>> getMembers();

    @NotNull
    public Collection<KFunction<T>> getConstructors();

    @NotNull
    public Collection<KClass<?>> getNestedClasses();

    @Nullable
    public T getObjectInstance();

    @SinceKotlin(version="1.1")
    public boolean isInstance(@Nullable Object var1);

    @NotNull
    public List<KTypeParameter> getTypeParameters();

    @NotNull
    public List<KType> getSupertypes();

    @NotNull
    public List<KClass<? extends T>> getSealedSubclasses();

    @Nullable
    public KVisibility getVisibility();

    public boolean isFinal();

    public boolean isOpen();

    public boolean isAbstract();

    public boolean isSealed();

    public boolean isData();

    public boolean isInner();

    public boolean isCompanion();

    public boolean isFun();

    public boolean isValue();

    public boolean equals(@Nullable Object var1);

    public int hashCode();

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @SinceKotlin(version="1.1")
        public static /* synthetic */ void getTypeParameters$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void getSupertypes$annotations() {
        }

        @SinceKotlin(version="1.3")
        public static /* synthetic */ void getSealedSubclasses$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void getVisibility$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void isFinal$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void isOpen$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void isAbstract$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void isSealed$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void isData$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void isInner$annotations() {
        }

        @SinceKotlin(version="1.1")
        public static /* synthetic */ void isCompanion$annotations() {
        }

        @SinceKotlin(version="1.4")
        public static /* synthetic */ void isFun$annotations() {
        }

        @SinceKotlin(version="1.5")
        public static /* synthetic */ void isValue$annotations() {
        }
    }
}

