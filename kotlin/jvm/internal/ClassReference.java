/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010I\u001a\u00020JH\u0002J\u0013\u0010K\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R \u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010\u001eR \u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010(\u001a\u0004\b-\u0010\u001eR(\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b/\u0010(\u001a\u0004\b0\u0010\u001eR\u001c\u00101\u001a\u0004\u0018\u0001028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b3\u0010(\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b7\u0010(\u001a\u0004\b6\u00108R\u001a\u00109\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b:\u0010(\u001a\u0004\b9\u00108R\u001a\u0010;\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b<\u0010(\u001a\u0004\b;\u00108R\u001a\u0010=\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b>\u0010(\u001a\u0004\b=\u00108R\u001a\u0010?\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b@\u0010(\u001a\u0004\b?\u00108R\u001a\u0010A\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bB\u0010(\u001a\u0004\bA\u00108R\u001a\u0010C\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bD\u0010(\u001a\u0004\bC\u00108R\u001a\u0010E\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bF\u0010(\u001a\u0004\bE\u00108R\u001a\u0010G\u001a\u00020#8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bH\u0010(\u001a\u0004\bG\u00108\u00a8\u0006Q"}, d2={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "error", "", "equals", "other", "hashCode", "", "toString", "Companion", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1573#2:291\n1604#2,4:292\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:291\n107#1:292,4\n*E\n"})
public final class ClassReference
implements KClass<Object>,
ClassBasedDeclarationContainer {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Class<?> jClass;
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;

    public ClassReference(@NotNull Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
    }

    @Override
    @NotNull
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override
    @Nullable
    public String getSimpleName() {
        return Companion.getClassSimpleName(this.getJClass());
    }

    @Override
    @Nullable
    public String getQualifiedName() {
        return Companion.getClassQualifiedName(this.getJClass());
    }

    @Override
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override
    @NotNull
    public Collection<KFunction<Object>> getConstructors() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override
    @Nullable
    public Object getObjectInstance() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @Override
    @SinceKotlin(version="1.1")
    public boolean isInstance(@Nullable Object value) {
        return Companion.isInstance(value, this.getJClass());
    }

    @Override
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    @Override
    @NotNull
    public List<KType> getSupertypes() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getSupertypes$annotations() {
    }

    @Override
    @NotNull
    public List<KClass<? extends Object>> getSealedSubclasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.3")
    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    @Override
    @Nullable
    public KVisibility getVisibility() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void getVisibility$annotations() {
    }

    @Override
    public boolean isFinal() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void isFinal$annotations() {
    }

    @Override
    public boolean isOpen() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void isOpen$annotations() {
    }

    @Override
    public boolean isAbstract() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void isAbstract$annotations() {
    }

    @Override
    public boolean isSealed() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void isSealed$annotations() {
    }

    @Override
    public boolean isData() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void isData$annotations() {
    }

    @Override
    public boolean isInner() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void isInner$annotations() {
    }

    @Override
    public boolean isCompanion() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.1")
    public static /* synthetic */ void isCompanion$annotations() {
    }

    @Override
    public boolean isFun() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.4")
    public static /* synthetic */ void isFun$annotations() {
    }

    @Override
    public boolean isValue() {
        this.error();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version="1.5")
    public static /* synthetic */ void isValue$annotations() {
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return other instanceof ClassReference && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass)other));
    }

    @Override
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @NotNull
    public String toString() {
        return this.getJClass() + " (Kotlin reflection is not available)";
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_3;
        void $this$mapIndexedTo$iv$iv;
        Companion = new Companion(null);
        Class[] classArray = new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class};
        Iterable $this$mapIndexed$iv = CollectionsKt.listOf(classArray);
        boolean $i$f$mapIndexed = false;
        Iterable iterable = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            void i2;
            void clazz;
            int n2;
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Class clazz2 = (Class)item$iv$iv;
            int n3 = n2;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(TuplesKt.to(clazz, (int)i2));
        }
        FUNCTION_CLASSES = MapsKt.toMap((List)var3_3);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006R&\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lkotlin/jvm/internal/ClassReference$Companion;", "", "<init>", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNameOf", "", "type", "simpleNameOf", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", "", "value", "kotlin-stdlib"})
    @SourceDebugExtension(value={"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        private final String classFqNameOf(String type) {
            String string;
            switch (type) {
                case "boolean": {
                    string = "kotlin.Boolean";
                    break;
                }
                case "byte": {
                    string = "kotlin.Byte";
                    break;
                }
                case "char": {
                    string = "kotlin.Char";
                    break;
                }
                case "double": {
                    string = "kotlin.Double";
                    break;
                }
                case "float": {
                    string = "kotlin.Float";
                    break;
                }
                case "int": {
                    string = "kotlin.Int";
                    break;
                }
                case "long": {
                    string = "kotlin.Long";
                    break;
                }
                case "short": {
                    string = "kotlin.Short";
                    break;
                }
                case "java.lang.annotation.Annotation": {
                    string = "kotlin.Annotation";
                    break;
                }
                case "java.lang.Boolean": {
                    string = "kotlin.Boolean";
                    break;
                }
                case "java.lang.Byte": {
                    string = "kotlin.Byte";
                    break;
                }
                case "java.lang.Character": {
                    string = "kotlin.Char";
                    break;
                }
                case "java.lang.CharSequence": {
                    string = "kotlin.CharSequence";
                    break;
                }
                case "java.lang.Cloneable": {
                    string = "kotlin.Cloneable";
                    break;
                }
                case "java.lang.Comparable": {
                    string = "kotlin.Comparable";
                    break;
                }
                case "java.lang.Double": {
                    string = "kotlin.Double";
                    break;
                }
                case "java.lang.Enum": {
                    string = "kotlin.Enum";
                    break;
                }
                case "java.lang.Float": {
                    string = "kotlin.Float";
                    break;
                }
                case "java.lang.Integer": {
                    string = "kotlin.Int";
                    break;
                }
                case "java.lang.Iterable": {
                    string = "kotlin.collections.Iterable";
                    break;
                }
                case "java.lang.Long": {
                    string = "kotlin.Long";
                    break;
                }
                case "java.lang.Number": {
                    string = "kotlin.Number";
                    break;
                }
                case "java.lang.Object": {
                    string = "kotlin.Any";
                    break;
                }
                case "java.lang.Short": {
                    string = "kotlin.Short";
                    break;
                }
                case "java.lang.String": {
                    string = "kotlin.String";
                    break;
                }
                case "java.lang.Throwable": {
                    string = "kotlin.Throwable";
                    break;
                }
                case "java.util.Collection": {
                    string = "kotlin.collections.Collection";
                    break;
                }
                case "java.util.Iterator": {
                    string = "kotlin.collections.Iterator";
                    break;
                }
                case "java.util.ListIterator": {
                    string = "kotlin.collections.ListIterator";
                    break;
                }
                case "java.util.List": {
                    string = "kotlin.collections.List";
                    break;
                }
                case "java.util.Map$Entry": {
                    string = "kotlin.collections.Map.Entry";
                    break;
                }
                case "java.util.Map": {
                    string = "kotlin.collections.Map";
                    break;
                }
                case "java.util.Set": {
                    string = "kotlin.collections.Set";
                    break;
                }
                case "kotlin.jvm.functions.Function0": {
                    string = "kotlin.Function0";
                    break;
                }
                case "kotlin.jvm.functions.Function1": {
                    string = "kotlin.Function1";
                    break;
                }
                case "kotlin.jvm.functions.Function2": {
                    string = "kotlin.Function2";
                    break;
                }
                case "kotlin.jvm.functions.Function3": {
                    string = "kotlin.Function3";
                    break;
                }
                case "kotlin.jvm.functions.Function4": {
                    string = "kotlin.Function4";
                    break;
                }
                case "kotlin.jvm.functions.Function5": {
                    string = "kotlin.Function5";
                    break;
                }
                case "kotlin.jvm.functions.Function6": {
                    string = "kotlin.Function6";
                    break;
                }
                case "kotlin.jvm.functions.Function7": {
                    string = "kotlin.Function7";
                    break;
                }
                case "kotlin.jvm.functions.Function8": {
                    string = "kotlin.Function8";
                    break;
                }
                case "kotlin.jvm.functions.Function9": {
                    string = "kotlin.Function9";
                    break;
                }
                case "kotlin.jvm.functions.Function10": {
                    string = "kotlin.Function10";
                    break;
                }
                case "kotlin.jvm.functions.Function11": {
                    string = "kotlin.Function11";
                    break;
                }
                case "kotlin.jvm.functions.Function12": {
                    string = "kotlin.Function12";
                    break;
                }
                case "kotlin.jvm.functions.Function13": {
                    string = "kotlin.Function13";
                    break;
                }
                case "kotlin.jvm.functions.Function14": {
                    string = "kotlin.Function14";
                    break;
                }
                case "kotlin.jvm.functions.Function15": {
                    string = "kotlin.Function15";
                    break;
                }
                case "kotlin.jvm.functions.Function16": {
                    string = "kotlin.Function16";
                    break;
                }
                case "kotlin.jvm.functions.Function17": {
                    string = "kotlin.Function17";
                    break;
                }
                case "kotlin.jvm.functions.Function18": {
                    string = "kotlin.Function18";
                    break;
                }
                case "kotlin.jvm.functions.Function19": {
                    string = "kotlin.Function19";
                    break;
                }
                case "kotlin.jvm.functions.Function20": {
                    string = "kotlin.Function20";
                    break;
                }
                case "kotlin.jvm.functions.Function21": {
                    string = "kotlin.Function21";
                    break;
                }
                case "kotlin.jvm.functions.Function22": {
                    string = "kotlin.Function22";
                    break;
                }
                case "kotlin.jvm.internal.BooleanCompanionObject": {
                    string = "kotlin.Boolean.Companion";
                    break;
                }
                case "kotlin.jvm.internal.ByteCompanionObject": {
                    string = "kotlin.Byte.Companion";
                    break;
                }
                case "kotlin.jvm.internal.CharCompanionObject": {
                    string = "kotlin.Char.Companion";
                    break;
                }
                case "kotlin.jvm.internal.DoubleCompanionObject": {
                    string = "kotlin.Double.Companion";
                    break;
                }
                case "kotlin.jvm.internal.EnumCompanionObject": {
                    string = "kotlin.Enum.Companion";
                    break;
                }
                case "kotlin.jvm.internal.FloatCompanionObject": {
                    string = "kotlin.Float.Companion";
                    break;
                }
                case "kotlin.jvm.internal.IntCompanionObject": {
                    string = "kotlin.Int.Companion";
                    break;
                }
                case "kotlin.jvm.internal.LongCompanionObject": {
                    string = "kotlin.Long.Companion";
                    break;
                }
                case "kotlin.jvm.internal.ShortCompanionObject": {
                    string = "kotlin.Short.Companion";
                    break;
                }
                case "kotlin.jvm.internal.StringCompanionObject": {
                    string = "kotlin.String.Companion";
                    break;
                }
                default: {
                    string = null;
                }
            }
            return string;
        }

        private final String simpleNameOf(String type) {
            String string;
            switch (type) {
                case "boolean": {
                    string = "Boolean";
                    break;
                }
                case "byte": {
                    string = "Byte";
                    break;
                }
                case "char": {
                    string = "Char";
                    break;
                }
                case "double": {
                    string = "Double";
                    break;
                }
                case "float": {
                    string = "Float";
                    break;
                }
                case "int": {
                    string = "Int";
                    break;
                }
                case "long": {
                    string = "Long";
                    break;
                }
                case "short": {
                    string = "Short";
                    break;
                }
                case "java.lang.annotation.Annotation": {
                    string = "Annotation";
                    break;
                }
                case "java.lang.Boolean": {
                    string = "Boolean";
                    break;
                }
                case "java.lang.Byte": {
                    string = "Byte";
                    break;
                }
                case "java.lang.Character": {
                    string = "Char";
                    break;
                }
                case "java.lang.CharSequence": {
                    string = "CharSequence";
                    break;
                }
                case "java.lang.Cloneable": {
                    string = "Cloneable";
                    break;
                }
                case "java.lang.Comparable": {
                    string = "Comparable";
                    break;
                }
                case "java.lang.Double": {
                    string = "Double";
                    break;
                }
                case "java.lang.Enum": {
                    string = "Enum";
                    break;
                }
                case "java.lang.Float": {
                    string = "Float";
                    break;
                }
                case "java.lang.Integer": {
                    string = "Int";
                    break;
                }
                case "java.lang.Iterable": {
                    string = "Iterable";
                    break;
                }
                case "java.lang.Long": {
                    string = "Long";
                    break;
                }
                case "java.lang.Number": {
                    string = "Number";
                    break;
                }
                case "java.lang.Object": {
                    string = "Any";
                    break;
                }
                case "java.lang.Short": {
                    string = "Short";
                    break;
                }
                case "java.lang.String": {
                    string = "String";
                    break;
                }
                case "java.lang.Throwable": {
                    string = "Throwable";
                    break;
                }
                case "java.util.Collection": {
                    string = "Collection";
                    break;
                }
                case "java.util.Iterator": {
                    string = "Iterator";
                    break;
                }
                case "java.util.ListIterator": {
                    string = "ListIterator";
                    break;
                }
                case "java.util.List": {
                    string = "List";
                    break;
                }
                case "java.util.Map$Entry": {
                    string = "Entry";
                    break;
                }
                case "java.util.Map": {
                    string = "Map";
                    break;
                }
                case "java.util.Set": {
                    string = "Set";
                    break;
                }
                case "kotlin.jvm.functions.Function0": {
                    string = "Function0";
                    break;
                }
                case "kotlin.jvm.functions.Function1": {
                    string = "Function1";
                    break;
                }
                case "kotlin.jvm.functions.Function2": {
                    string = "Function2";
                    break;
                }
                case "kotlin.jvm.functions.Function3": {
                    string = "Function3";
                    break;
                }
                case "kotlin.jvm.functions.Function4": {
                    string = "Function4";
                    break;
                }
                case "kotlin.jvm.functions.Function5": {
                    string = "Function5";
                    break;
                }
                case "kotlin.jvm.functions.Function6": {
                    string = "Function6";
                    break;
                }
                case "kotlin.jvm.functions.Function7": {
                    string = "Function7";
                    break;
                }
                case "kotlin.jvm.functions.Function8": {
                    string = "Function8";
                    break;
                }
                case "kotlin.jvm.functions.Function9": {
                    string = "Function9";
                    break;
                }
                case "kotlin.jvm.functions.Function10": {
                    string = "Function10";
                    break;
                }
                case "kotlin.jvm.functions.Function11": {
                    string = "Function11";
                    break;
                }
                case "kotlin.jvm.functions.Function12": {
                    string = "Function12";
                    break;
                }
                case "kotlin.jvm.functions.Function13": {
                    string = "Function13";
                    break;
                }
                case "kotlin.jvm.functions.Function14": {
                    string = "Function14";
                    break;
                }
                case "kotlin.jvm.functions.Function15": {
                    string = "Function15";
                    break;
                }
                case "kotlin.jvm.functions.Function16": {
                    string = "Function16";
                    break;
                }
                case "kotlin.jvm.functions.Function17": {
                    string = "Function17";
                    break;
                }
                case "kotlin.jvm.functions.Function18": {
                    string = "Function18";
                    break;
                }
                case "kotlin.jvm.functions.Function19": {
                    string = "Function19";
                    break;
                }
                case "kotlin.jvm.functions.Function20": {
                    string = "Function20";
                    break;
                }
                case "kotlin.jvm.functions.Function21": {
                    string = "Function21";
                    break;
                }
                case "kotlin.jvm.functions.Function22": {
                    string = "Function22";
                    break;
                }
                case "kotlin.jvm.internal.BooleanCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.ByteCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.CharCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.DoubleCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.EnumCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.FloatCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.IntCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.LongCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.ShortCompanionObject": {
                    string = "Companion";
                    break;
                }
                case "kotlin.jvm.internal.StringCompanionObject": {
                    string = "Companion";
                    break;
                }
                default: {
                    string = null;
                }
            }
            return string;
        }

        @Nullable
        public final String getClassSimpleName(@NotNull Class<?> jClass) {
            Object object;
            block11: {
                block12: {
                    String name;
                    block13: {
                        block10: {
                            Intrinsics.checkNotNullParameter(jClass, "jClass");
                            if (!jClass.isAnonymousClass()) break block10;
                            object = null;
                            break block11;
                        }
                        if (!jClass.isLocalClass()) break block12;
                        name = jClass.getSimpleName();
                        object = jClass.getEnclosingMethod();
                        if (object == null) break block13;
                        Method method = object;
                        boolean bl2 = false;
                        Intrinsics.checkNotNull(name);
                        String string = StringsKt.substringAfter$default(name, method.getName() + '$', null, 2, null);
                        object = string;
                        if (string != null) break block11;
                    }
                    Constructor<?> constructor = jClass.getEnclosingConstructor();
                    if (constructor != null) {
                        Constructor<?> constructor2 = constructor;
                        boolean bl3 = false;
                        Intrinsics.checkNotNull(name);
                        object = StringsKt.substringAfter$default(name, constructor2.getName() + '$', null, 2, null);
                    } else {
                        Intrinsics.checkNotNull(name);
                        object = StringsKt.substringAfter$default(name, '$', null, 2, null);
                    }
                    break block11;
                }
                if (jClass.isArray()) {
                    Object object2;
                    Class<?> componentType = jClass.getComponentType();
                    if (componentType.isPrimitive()) {
                        String string = componentType.getName();
                        Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                        String string2 = this.simpleNameOf(string);
                        object2 = string2 != null ? string2 + "Array" : null;
                    } else {
                        object2 = object = null;
                    }
                    if (object2 == null) {
                        object = "Array";
                    }
                } else {
                    String string = jClass.getName();
                    Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
                    object = this.simpleNameOf(string);
                    if (object == null) {
                        object = jClass.getSimpleName();
                    }
                }
            }
            return object;
        }

        @Nullable
        public final String getClassQualifiedName(@NotNull Class<?> jClass) {
            String string;
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            if (jClass.isAnonymousClass()) {
                string = null;
            } else if (jClass.isLocalClass()) {
                string = null;
            } else if (jClass.isArray()) {
                String string2;
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive()) {
                    String string3 = componentType.getName();
                    Intrinsics.checkNotNullExpressionValue(string3, "getName(...)");
                    String string4 = this.classFqNameOf(string3);
                    string2 = string4 != null ? string4 + "Array" : null;
                } else {
                    string2 = string = null;
                }
                if (string2 == null) {
                    string = "kotlin.Array";
                }
            } else {
                String string5 = jClass.getName();
                Intrinsics.checkNotNullExpressionValue(string5, "getName(...)");
                string = this.classFqNameOf(string5);
                if (string == null) {
                    string = jClass.getCanonicalName();
                }
            }
            return string;
        }

        public final boolean isInstance(@Nullable Object value, @NotNull Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            Map map = FUNCTION_CLASSES;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer n2 = (Integer)map.get(jClass);
            if (n2 != null) {
                int arity = ((Number)n2).intValue();
                boolean bl2 = false;
                return TypeIntrinsics.isFunctionOfArity(value, arity);
            }
            Class<?> objectType = jClass.isPrimitive() ? JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass)) : jClass;
            return objectType.isInstance(value);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

