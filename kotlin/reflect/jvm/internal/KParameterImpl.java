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
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KParameterImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KParameterImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00014B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0%\"\u00020#H\u0002\u00a2\u0006\u0002\u0010&J\u0013\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u001fH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010-R\u0014\u0010.\u001a\u00020,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010-\u00a8\u00065"}, d2={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "<init>", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "getIndex", "()I", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "name", "", "getName", "()Ljava/lang/String;", "compoundType", "Ljava/lang/reflect/Type;", "types", "", "([Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "isOptional", "", "()Z", "isVararg", "equals", "other", "", "hashCode", "toString", "CompoundTypeImpl", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKParameterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KParameterImpl.kt\nkotlin/reflect/jvm/internal/KParameterImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,113:1\n1#2:114\n37#3:115\n36#3,3:116\n37#3:119\n36#3,3:120\n*S KotlinDebug\n*F\n+ 1 KParameterImpl.kt\nkotlin/reflect/jvm/internal/KParameterImpl\n*L\n89#1:115\n89#1:116,3\n92#1:119\n92#1:120,3\n*E\n"})
public final class KParameterImpl
implements KParameter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final KCallableImpl<?> callable;
    private final int index;
    @NotNull
    private final KParameter.Kind kind;
    @NotNull
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    @NotNull
    private final ReflectProperties.LazySoftVal annotations$delegate;

    public KParameterImpl(@NotNull KCallableImpl<?> callable, int index, @NotNull KParameter.Kind kind2, @NotNull Function0<? extends ParameterDescriptor> computeDescriptor) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = index;
        this.kind = kind2;
        this.descriptor$delegate = ReflectProperties.lazySoft(computeDescriptor);
        KParameterImpl kParameterImpl = this;
        this.annotations$delegate = ReflectProperties.lazySoft(new KParameterImpl$$Lambda$0(kParameterImpl));
    }

    @NotNull
    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    @NotNull
    public KParameter.Kind getKind() {
        return this.kind;
    }

    private final ParameterDescriptor getDescriptor() {
        Object t2 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
        return (ParameterDescriptor)t2;
    }

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        Object t2 = this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
        return (List)t2;
    }

    @Override
    @Nullable
    public String getName() {
        ParameterDescriptor parameterDescriptor = this.getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = parameterDescriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor)parameterDescriptor : null;
        if (valueParameterDescriptor == null) {
            return null;
        }
        ValueParameterDescriptor valueParameter = valueParameterDescriptor;
        if (valueParameter.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameter.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Name name2 = name;
        return name2.isSpecial() ? null : name2.asString();
    }

    private final Type compoundType(Type ... types) {
        Type type;
        switch (types.length) {
            case 0: {
                throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
            }
            case 1: {
                type = ArraysKt.single(types);
                break;
            }
            default: {
                type = new CompoundTypeImpl(types);
            }
        }
        return type;
    }

    @Override
    @NotNull
    public KType getType() {
        KotlinType kotlinType = this.getDescriptor().getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        KParameterImpl kParameterImpl = this;
        return new KTypeImpl(kotlinType, new KParameterImpl$$Lambda$1(kParameterImpl));
    }

    @Override
    public boolean isOptional() {
        ParameterDescriptor parameterDescriptor = this.getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = parameterDescriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor)parameterDescriptor : null;
        return valueParameterDescriptor != null ? DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) : false;
    }

    @Override
    public boolean isVararg() {
        ParameterDescriptor it = this.getDescriptor();
        boolean bl2 = false;
        return it instanceof ValueParameterDescriptor && ((ValueParameterDescriptor)it).getVarargElementType() != null;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KParameterImpl && Intrinsics.areEqual(this.callable, ((KParameterImpl)other).callable) && this.getIndex() == ((KParameterImpl)other).getIndex();
    }

    public int hashCode() {
        return this.callable.hashCode() * 31 + Integer.hashCode(this.getIndex());
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }

    private static final List annotations_delegate$lambda$0(KParameterImpl this$0) {
        return UtilKt.computeAnnotations(this$0.getDescriptor());
    }

    private static final Type _get_type_$lambda$1(KParameterImpl this$0) {
        Type type;
        ParameterDescriptor descriptor2 = this$0.getDescriptor();
        if (descriptor2 instanceof ReceiverParameterDescriptor && Intrinsics.areEqual(UtilKt.getInstanceReceiverParameter(this$0.callable.getDescriptor()), descriptor2) && this$0.callable.getDescriptor().getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            DeclarationDescriptor declarationDescriptor = this$0.callable.getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> clazz = UtilKt.toJavaClass((ClassDescriptor)declarationDescriptor);
            if (clazz == null) {
                throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + descriptor2);
            }
            type = clazz;
        } else {
            Caller<?> caller = this$0.callable.getCaller();
            if (caller instanceof ValueClassAwareCaller) {
                List<Type> list;
                Type[] slice;
                if (this$0.callable.isBound()) {
                    slice = ((ValueClassAwareCaller)caller).getRealSlicesOfParameters(this$0.getIndex() + 1);
                    int offset = ((ValueClassAwareCaller)caller).getRealSlicesOfParameters(0).getLast() + 1;
                    list = CollectionsKt.slice(((ValueClassAwareCaller)caller).getParameterTypes(), new IntRange(slice.getFirst() - offset, slice.getLast() - offset));
                } else {
                    slice = ((ValueClassAwareCaller)caller).getRealSlicesOfParameters(this$0.getIndex());
                    list = CollectionsKt.slice(((ValueClassAwareCaller)caller).getParameterTypes(), (IntRange)slice);
                }
                List<Type> parameterTypes = list;
                Collection $this$toTypedArray$iv = parameterTypes;
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                slice = thisCollection$iv.toArray(new Type[0]);
                type = this$0.compoundType(Arrays.copyOf(slice, slice.length));
            } else if (caller instanceof ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller) {
                Collection $this$toTypedArray$iv = ((ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller)caller).getOriginalParametersGroups().get(this$0.getIndex());
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                Class[] classArray = thisCollection$iv.toArray(new Class[0]);
                type = this$0.compoundType(Arrays.copyOf(classArray, classArray.length));
            } else {
                type = caller.getParameterTypes().get(this$0.getIndex());
            }
        }
        return type;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KParameterImpl.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(KParameterImpl.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ List accessor$KParameterImpl$lambda0(KParameterImpl kParameterImpl) {
        return KParameterImpl.annotations_delegate$lambda$0(kParameterImpl);
    }

    static /* synthetic */ Type accessor$KParameterImpl$lambda1(KParameterImpl kParameterImpl) {
        return KParameterImpl._get_type_$lambda$1(kParameterImpl);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lkotlin/reflect/jvm/internal/KParameterImpl$CompoundTypeImpl;", "Ljava/lang/reflect/Type;", "types", "", "<init>", "([Ljava/lang/reflect/Type;)V", "getTypes", "()[Ljava/lang/reflect/Type;", "[Ljava/lang/reflect/Type;", "hashCode", "", "getTypeName", "", "equals", "", "other", "", "toString", "kotlin-reflection"})
    private static final class CompoundTypeImpl
    implements Type {
        @NotNull
        private final Type[] types;
        private final int hashCode;

        public CompoundTypeImpl(@NotNull Type[] types) {
            Intrinsics.checkNotNullParameter(types, "types");
            this.types = types;
            this.hashCode = Arrays.hashCode(this.types);
        }

        @Override
        @NotNull
        public String getTypeName() {
            return ArraysKt.joinToString$default(this.types, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
        }

        public boolean equals(@Nullable Object other) {
            return other instanceof CompoundTypeImpl && Arrays.equals(this.types, ((CompoundTypeImpl)other).types);
        }

        public int hashCode() {
            return this.hashCode;
        }

        @NotNull
        public String toString() {
            return this.getTypeName();
        }
    }
}

