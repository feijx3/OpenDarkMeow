/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$2;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$3;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$4;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$5;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$6;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$7;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$8;
import kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$9;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KParameterImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J%\u00108\u001a\u00028\u00002\u0016\u00109\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010;0:\"\u0004\u0018\u00010;H\u0016\u00a2\u0006\u0002\u0010<J#\u0010=\u001a\u00028\u00002\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010;0>H\u0016\u00a2\u0006\u0002\u0010?J\u0015\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0:H\u0002\u00a2\u0006\u0002\u0010BJ3\u0010C\u001a\u00028\u00002\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010;0>2\f\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010EH\u0000\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020!H\u0002J#\u0010M\u001a\u00028\u00002\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010;0>H\u0002\u00a2\u0006\u0002\u0010?J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020(H\u0002J\n\u0010P\u001a\u0004\u0018\u00010QH\u0002R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R(\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \u001b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR>\u0010\u001f\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020! \u001b*\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"0 j\b\u0012\u0004\u0012\u00020!`\"0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u001c\u0010%\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010&0&0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R(\u0010+\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020, \u001b*\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00190\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u001eR\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010\u0016R\u0014\u00105\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u0014\u00106\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0016R\u0014\u00107\u001a\u00020\u00158DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u0016R,\u0010@\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010; \u001b*\f\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:0:0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00150IX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006R"}, d2={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "<init>", "()V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "", "()Z", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "annotations", "getAnnotations", "()Ljava/util/List;", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "Lkotlin/collections/ArrayList;", "parameters", "getParameters", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isOpen", "isAbstract", "isAnnotationConstructor", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "_absentArguments", "getAbsentArguments", "()[Ljava/lang/Object;", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parametersNeedMFVCFlattening", "Lkotlin/Lazy;", "getParameterTypeSize", "", "parameter", "callAnnotationConstructor", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKCallableImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KCallableImpl.kt\nkotlin/reflect/jvm/internal/KCallableImpl\n+ 2 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,276:1\n230#2,5:277\n230#2,5:282\n230#2,5:287\n230#2,5:292\n230#2,2:302\n232#2,3:308\n1#3:297\n1563#4:298\n1634#4,3:299\n1011#4,2:311\n1563#4:313\n1634#4,3:314\n1788#4,4:317\n1869#4,2:321\n1761#4,3:323\n37#5:304\n36#5,3:305\n*S KotlinDebug\n*F\n+ 1 KCallableImpl.kt\nkotlin/reflect/jvm/internal/KCallableImpl\n*L\n107#1:277,5\n158#1:282,5\n206#1:287,5\n214#1:292,5\n248#1:302,2\n248#1:308,3\n234#1:298\n234#1:299,3\n65#1:311,2\n85#1:313\n85#1:314,3\n124#1:317,4\n132#1:321,2\n220#1:323,3\n249#1:304\n249#1:305,3\n*E\n"})
public abstract class KCallableImpl<R>
implements KCallable<R>,
KTypeParameterOwnerImpl {
    @NotNull
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    @NotNull
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    @NotNull
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    @NotNull
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;
    @NotNull
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;
    @NotNull
    private final Lazy<Boolean> parametersNeedMFVCFlattening;

    public KCallableImpl() {
        KCallableImpl kCallableImpl = this;
        ReflectProperties.LazySoftVal lazySoftVal = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$0(kCallableImpl));
        Intrinsics.checkNotNullExpressionValue(lazySoftVal, "lazySoft(...)");
        this._annotations = lazySoftVal;
        kCallableImpl = this;
        ReflectProperties.LazySoftVal lazySoftVal2 = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$1(kCallableImpl));
        Intrinsics.checkNotNullExpressionValue(lazySoftVal2, "lazySoft(...)");
        this._parameters = lazySoftVal2;
        kCallableImpl = this;
        ReflectProperties.LazySoftVal lazySoftVal3 = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$2(kCallableImpl));
        Intrinsics.checkNotNullExpressionValue(lazySoftVal3, "lazySoft(...)");
        this._returnType = lazySoftVal3;
        kCallableImpl = this;
        ReflectProperties.LazySoftVal lazySoftVal4 = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$3(kCallableImpl));
        Intrinsics.checkNotNullExpressionValue(lazySoftVal4, "lazySoft(...)");
        this._typeParameters = lazySoftVal4;
        kCallableImpl = this;
        ReflectProperties.LazySoftVal lazySoftVal5 = ReflectProperties.lazySoft(new KCallableImpl$$Lambda$4(kCallableImpl));
        Intrinsics.checkNotNullExpressionValue(lazySoftVal5, "lazySoft(...)");
        this._absentArguments = lazySoftVal5;
        kCallableImpl = this;
        this.parametersNeedMFVCFlattening = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KCallableImpl$$Lambda$5(kCallableImpl));
    }

    @NotNull
    public abstract CallableMemberDescriptor getDescriptor();

    @NotNull
    public abstract Caller<?> getCaller();

    @Nullable
    public abstract Caller<?> getDefaultCaller();

    @NotNull
    public abstract KDeclarationContainerImpl getContainer();

    public abstract boolean isBound();

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> list = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(list, "invoke(...)");
        return list;
    }

    @Override
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> arrayList = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(arrayList, "invoke(...)");
        return arrayList;
    }

    @Override
    @NotNull
    public KType getReturnType() {
        KTypeImpl kTypeImpl = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(kTypeImpl, "invoke(...)");
        return kTypeImpl;
    }

    @Override
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameter> list = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(list, "invoke(...)");
        return list;
    }

    @Override
    @Nullable
    public KVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
        return UtilKt.toKVisibility(descriptorVisibility);
    }

    @Override
    public boolean isFinal() {
        return this.getDescriptor().getModality() == Modality.FINAL;
    }

    @Override
    public boolean isOpen() {
        return this.getDescriptor().getModality() == Modality.OPEN;
    }

    @Override
    public boolean isAbstract() {
        return this.getDescriptor().getModality() == Modality.ABSTRACT;
    }

    protected final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual(this.getName(), "<init>") && this.getContainer().getJClass().isAnnotation();
    }

    @Override
    public R call(Object ... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        boolean $i$f$reflectionCall = false;
        try {
            boolean bl2 = false;
            return (R)this.getCaller().call(args);
        }
        catch (IllegalAccessException e$iv) {
            throw new IllegalCallableAccessException(e$iv);
        }
    }

    @Override
    public R callBy(@NotNull Map<KParameter, ? extends Object> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return this.isAnnotationConstructor() ? this.callAnnotationConstructor(args) : this.callDefaultMethod$kotlin_reflection(args, null);
    }

    private final Object[] getAbsentArguments() {
        return (Object[])this._absentArguments.invoke().clone();
    }

    public final R callDefaultMethod$kotlin_reflection(@NotNull Map<KParameter, ? extends Object> args, @Nullable Continuation<?> continuationArgument) {
        Object object;
        Object[] objectArray;
        Intrinsics.checkNotNullParameter(args, "args");
        List<KParameter> parameters = this.getParameters();
        if (parameters.isEmpty()) {
            Object object2;
            boolean $i$f$reflectionCall = false;
            try {
                Object[] objectArray2;
                boolean bl2 = false;
                Caller<?> caller = this.getCaller();
                if (this.isSuspend()) {
                    Continuation[] continuationArray = new Continuation[]{continuationArgument};
                    objectArray2 = continuationArray;
                } else {
                    objectArray2 = new Continuation[]{};
                }
                object2 = caller.call(objectArray2);
            }
            catch (IllegalAccessException e$iv) {
                throw new IllegalCallableAccessException(e$iv);
            }
            return (R)object2;
        }
        int parameterSize = parameters.size() + (this.isSuspend() ? 1 : 0);
        Object[] $this$callDefaultMethod_u24lambda_u2416 = objectArray = this.getAbsentArguments();
        boolean bl3 = false;
        if (this.isSuspend()) {
            $this$callDefaultMethod_u24lambda_u2416[parameters.size()] = continuationArgument;
        }
        Object[] arguments = objectArray;
        int valueParameterIndex = 0;
        boolean anyOptional = false;
        boolean hasMfvcParameters = this.parametersNeedMFVCFlattening.getValue();
        for (KParameter parameter : parameters) {
            int parameterTypeSize = hasMfvcParameters ? this.getParameterTypeSize(parameter) : 1;
            if (args.containsKey(parameter)) {
                arguments[parameter.getIndex()] = args.get(parameter);
            } else if (parameter.isOptional()) {
                if (hasMfvcParameters) {
                    int n2 = valueParameterIndex + parameterTypeSize;
                    for (int valueSubParameterIndex = valueParameterIndex; valueSubParameterIndex < n2; ++valueSubParameterIndex) {
                        int maskIndex = parameterSize + valueSubParameterIndex / 32;
                        Object object3 = arguments[maskIndex];
                        Intrinsics.checkNotNull(object3, "null cannot be cast to non-null type kotlin.Int");
                        arguments[maskIndex] = (Integer)object3 | 1 << valueSubParameterIndex % 32;
                    }
                } else {
                    int maskIndex = parameterSize + valueParameterIndex / 32;
                    Object object4 = arguments[maskIndex];
                    Intrinsics.checkNotNull(object4, "null cannot be cast to non-null type kotlin.Int");
                    arguments[maskIndex] = (Integer)object4 | 1 << valueParameterIndex % 32;
                }
                anyOptional = true;
            } else if (!parameter.isVararg()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + parameter);
            }
            if (parameter.getKind() != KParameter.Kind.VALUE) continue;
            valueParameterIndex += parameterTypeSize;
        }
        if (!anyOptional) {
            Object parameterTypeSize;
            boolean $i$f$reflectionCall = false;
            try {
                boolean bl4 = false;
                Caller<?> caller = this.getCaller();
                Object[] objectArray3 = Arrays.copyOf(arguments, parameterSize);
                Intrinsics.checkNotNullExpressionValue(objectArray3, "copyOf(...)");
                parameterTypeSize = caller.call(objectArray3);
            }
            catch (IllegalAccessException e$iv) {
                throw new IllegalCallableAccessException(e$iv);
            }
            return (R)parameterTypeSize;
        }
        Caller<?> caller = this.getDefaultCaller();
        if (caller == null) {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + this.getDescriptor());
        }
        Caller<?> caller2 = caller;
        boolean $i$f$reflectionCall = false;
        try {
            boolean bl5 = false;
            object = caller2.call(arguments);
        }
        catch (IllegalAccessException e$iv) {
            throw new IllegalCallableAccessException(e$iv);
        }
        return (R)object;
    }

    private final int getParameterTypeSize(KParameter parameter) {
        int n2;
        if (!this.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            boolean bl2 = false;
            String string = "Check if parametersNeedMFVCFlattening is true before";
            throw new IllegalArgumentException(string.toString());
        }
        if (UtilKt.getNeedsMultiFieldValueClassFlattening(parameter.getType())) {
            KType kType = parameter.getType();
            Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            SimpleType type = TypeSubstitutionKt.asSimpleType(((KTypeImpl)kType).getType());
            List<Method> list = ValueClassAwareCallerKt.getMfvcUnboxMethods(type);
            Intrinsics.checkNotNull(list);
            n2 = list.size();
        } else {
            n2 = 1;
        }
        return n2;
    }

    /*
     * WARNING - void declaration
     */
    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> args) {
        Object object;
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this.getParameters();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Object object2;
            void parameter;
            KParameter kParameter = (KParameter)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            if (args.containsKey(parameter)) {
                object2 = args.get(parameter);
                if (object2 == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + parameter + ')');
                }
            } else if (parameter.isOptional()) {
                object2 = null;
            } else if (parameter.isVararg()) {
                object2 = this.defaultEmptyArray(parameter.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + parameter);
            }
            collection.add(object2);
        }
        List arguments = (List)destination$iv$iv;
        Caller<?> caller = this.getDefaultCaller();
        if (caller == null) {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + this.getDescriptor());
        }
        Caller<?> caller2 = caller;
        boolean $i$f$reflectionCall = false;
        try {
            boolean bl3 = false;
            Collection $this$toTypedArray$iv = arguments;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            object = caller2.call(thisCollection$iv.toArray(new Object[0]));
        }
        catch (IllegalAccessException e$iv) {
            throw new IllegalCallableAccessException(e$iv);
        }
        return (R)object;
    }

    private final Object defaultEmptyArray(KType type) {
        Class<KClass<?>> $this$defaultEmptyArray_u24lambda_u2424 = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(type));
        boolean bl2 = false;
        if (!$this$defaultEmptyArray_u24lambda_u2424.isArray()) {
            throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + $this$defaultEmptyArray_u24lambda_u2424.getSimpleName() + ", because it is not an array type");
        }
        Object object = Array.newInstance($this$defaultEmptyArray_u24lambda_u2424.getComponentType(), 0);
        Intrinsics.checkNotNullExpressionValue(object, "run(...)");
        return object;
    }

    private final Type extractContinuationArgument() {
        if (this.isSuspend()) {
            ParameterizedType continuationType;
            Type type = CollectionsKt.lastOrNull(this.getCaller().getParameterTypes());
            ParameterizedType parameterizedType = continuationType = type instanceof ParameterizedType ? (ParameterizedType)type : null;
            if (Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
                Type[] wildcard;
                Type[] typeArray = continuationType.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(typeArray, "getActualTypeArguments(...)");
                Object object = ArraysKt.single((Object[])typeArray);
                Type[] typeArray2 = wildcard = object instanceof WildcardType ? (Type[])object : null;
                return wildcard != null && (typeArray2 = typeArray2.getLowerBounds()) != null ? ArraysKt.first(typeArray2) : null;
            }
        }
        return null;
    }

    private static final List _annotations$lambda$0(KCallableImpl this$0) {
        return UtilKt.computeAnnotations(this$0.getDescriptor());
    }

    private static final ParameterDescriptor _parameters$lambda$5$lambda$1(ReceiverParameterDescriptor $instanceReceiver) {
        return $instanceReceiver;
    }

    private static final ParameterDescriptor _parameters$lambda$5$lambda$2(ReceiverParameterDescriptor $extensionReceiver) {
        return $extensionReceiver;
    }

    private static final ParameterDescriptor _parameters$lambda$5$lambda$3(CallableMemberDescriptor $descriptor, int $i) {
        ValueParameterDescriptor valueParameterDescriptor = $descriptor.getValueParameters().get($i);
        Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "get(...)");
        return valueParameterDescriptor;
    }

    private static final ArrayList _parameters$lambda$5(KCallableImpl this$0) {
        CallableMemberDescriptor descriptor2 = this$0.getDescriptor();
        ArrayList<KParameterImpl> result = new ArrayList<KParameterImpl>();
        int index = 0;
        if (!this$0.isBound()) {
            ReceiverParameterDescriptor extensionReceiver;
            ReceiverParameterDescriptor receiverParameterDescriptor;
            ReceiverParameterDescriptor instanceReceiver = UtilKt.getInstanceReceiverParameter(descriptor2);
            if (instanceReceiver != null) {
                int n2 = index++;
                receiverParameterDescriptor = instanceReceiver;
                result.add(new KParameterImpl(this$0, n2, KParameter.Kind.INSTANCE, new KCallableImpl$$Lambda$6(receiverParameterDescriptor)));
            }
            if ((extensionReceiver = descriptor2.getExtensionReceiverParameter()) != null) {
                int n3 = index++;
                receiverParameterDescriptor = extensionReceiver;
                result.add(new KParameterImpl(this$0, n3, KParameter.Kind.EXTENSION_RECEIVER, new KCallableImpl$$Lambda$7(receiverParameterDescriptor)));
            }
        }
        int i2 = 0;
        int extensionReceiver = ((Collection)descriptor2.getValueParameters()).size();
        while (i2 < extensionReceiver) {
            int n4 = index++;
            int n5 = i2++;
            CallableMemberDescriptor callableMemberDescriptor = descriptor2;
            result.add(new KParameterImpl(this$0, n4, KParameter.Kind.VALUE, new KCallableImpl$$Lambda$8(callableMemberDescriptor, n5)));
        }
        if (this$0.isAnnotationConstructor() && descriptor2 instanceof JavaCallableMemberDescriptor) {
            List $this$sortBy$iv = result;
            boolean $i$f$sortBy = false;
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv, new Comparator(){

                    public final int compare(T a2, T b2) {
                        KParameter it = (KParameter)a2;
                        boolean bl2 = false;
                        Comparable comparable = (Comparable)((Object)it.getName());
                        it = (KParameter)b2;
                        Comparable comparable2 = comparable;
                        bl2 = false;
                        return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                    }
                });
            }
        }
        result.trimToSize();
        return result;
    }

    private static final Type _returnType$lambda$7$lambda$6(KCallableImpl this$0) {
        Type type = this$0.extractContinuationArgument();
        if (type == null) {
            type = this$0.getCaller().getReturnType();
        }
        return type;
    }

    private static final KTypeImpl _returnType$lambda$7(KCallableImpl this$0) {
        KotlinType kotlinType = this$0.getDescriptor().getReturnType();
        Intrinsics.checkNotNull(kotlinType);
        KCallableImpl kCallableImpl = this$0;
        return new KTypeImpl(kotlinType, new KCallableImpl$$Lambda$9(kCallableImpl));
    }

    /*
     * WARNING - void declaration
     */
    private static final List _typeParameters$lambda$9(KCallableImpl this$0) {
        void $this$mapTo$iv$iv;
        List<TypeParameterDescriptor> list = this$0.getDescriptor().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void descriptor2;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            KTypeParameterOwnerImpl kTypeParameterOwnerImpl = this$0;
            Intrinsics.checkNotNull(descriptor2);
            collection.add(new KTypeParameterImpl(kTypeParameterOwnerImpl, (TypeParameterDescriptor)descriptor2));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] _absentArguments$lambda$14(KCallableImpl this$0) {
        int n2;
        List<KParameter> parameters = this$0.getParameters();
        int parameterSize = parameters.size() + (this$0.isSuspend() ? 1 : 0);
        if (this$0.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            Iterable iterable = parameters;
            int n3 = 0;
            for (Iterator iterator2 : iterable) {
                void it;
                KParameter kParameter = (KParameter)((Object)iterator2);
                int n4 = n3;
                boolean bl2 = false;
                int n5 = it.getKind() == KParameter.Kind.VALUE ? this$0.getParameterTypeSize((KParameter)it) : 0;
                n3 = n4 + n5;
            }
            n2 = n3;
        } else {
            Iterable $this$count$iv = parameters;
            boolean $i$f$count = false;
            if ($this$count$iv instanceof Collection && ((Collection)$this$count$iv).isEmpty()) {
                n2 = 0;
            } else {
                int count$iv = 0;
                for (Object element$iv : $this$count$iv) {
                    KParameter it = (KParameter)element$iv;
                    boolean bl3 = false;
                    if (!(it.getKind() == KParameter.Kind.VALUE) || ++count$iv >= 0) continue;
                    CollectionsKt.throwCountOverflow();
                }
                n2 = count$iv;
            }
        }
        int flattenedParametersSize = n2;
        int maskSize = (flattenedParametersSize + 32 - 1) / 32;
        Object[] arguments = new Object[parameterSize + maskSize + 1];
        Iterable $this$forEach$iv = parameters;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KParameter parameter = (KParameter)element$iv;
            boolean bl4 = false;
            if (parameter.isOptional() && !UtilKt.isInlineClassType(parameter.getType())) {
                arguments[parameter.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(parameter.getType()));
                continue;
            }
            if (!parameter.isVararg()) continue;
            arguments[parameter.getIndex()] = this$0.defaultEmptyArray(parameter.getType());
        }
        for (int i2 = 0; i2 < maskSize; ++i2) {
            arguments[parameterSize + i2] = 0;
        }
        return arguments;
    }

    private static final boolean parametersNeedMFVCFlattening$lambda$20(KCallableImpl this$0) {
        boolean bl2;
        block3: {
            Iterable $this$any$iv = this$0.getParameters();
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    KParameter it = (KParameter)element$iv;
                    boolean bl3 = false;
                    if (!UtilKt.getNeedsMultiFieldValueClassFlattening(it.getType())) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    static /* synthetic */ List accessor$KCallableImpl$lambda0(KCallableImpl kCallableImpl) {
        return KCallableImpl._annotations$lambda$0(kCallableImpl);
    }

    static /* synthetic */ ArrayList accessor$KCallableImpl$lambda1(KCallableImpl kCallableImpl) {
        return KCallableImpl._parameters$lambda$5(kCallableImpl);
    }

    static /* synthetic */ KTypeImpl accessor$KCallableImpl$lambda2(KCallableImpl kCallableImpl) {
        return KCallableImpl._returnType$lambda$7(kCallableImpl);
    }

    static /* synthetic */ List accessor$KCallableImpl$lambda3(KCallableImpl kCallableImpl) {
        return KCallableImpl._typeParameters$lambda$9(kCallableImpl);
    }

    static /* synthetic */ Object[] accessor$KCallableImpl$lambda4(KCallableImpl kCallableImpl) {
        return KCallableImpl._absentArguments$lambda$14(kCallableImpl);
    }

    static /* synthetic */ boolean accessor$KCallableImpl$lambda5(KCallableImpl kCallableImpl) {
        return KCallableImpl.parametersNeedMFVCFlattening$lambda$20(kCallableImpl);
    }

    static /* synthetic */ ParameterDescriptor accessor$KCallableImpl$lambda6(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return KCallableImpl._parameters$lambda$5$lambda$1(receiverParameterDescriptor);
    }

    static /* synthetic */ ParameterDescriptor accessor$KCallableImpl$lambda7(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return KCallableImpl._parameters$lambda$5$lambda$2(receiverParameterDescriptor);
    }

    static /* synthetic */ ParameterDescriptor accessor$KCallableImpl$lambda8(CallableMemberDescriptor callableMemberDescriptor, int n2) {
        return KCallableImpl._parameters$lambda$5$lambda$3(callableMemberDescriptor, n2);
    }

    static /* synthetic */ Type accessor$KCallableImpl$lambda9(KCallableImpl kCallableImpl) {
        return KCallableImpl._returnType$lambda$7$lambda$6(kCallableImpl);
    }
}

