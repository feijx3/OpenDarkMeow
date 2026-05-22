/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$2;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B7\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u0013J\u0012\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u0006\u0012\u0002\b\u00030 2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00102\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0002J.\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000305042\n\u0010,\u001a\u0006\u0012\u0002\b\u0003052\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0017H\u0002J\u0013\u0010@\u001a\u00020\u00172\b\u0010A\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010B\u001a\u000208H\u0016J\b\u0010C\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001b\u0010\u0012\u001a\u00020\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R!\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b&\u0010\"R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u00107\u001a\u0002088VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010\u0018R\u0014\u0010=\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010\u0018R\u0014\u0010>\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u0018R\u0014\u0010?\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010\u0018\u00a8\u0006D"}, d2={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "", "()Z", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getName", "()Ljava/lang/String;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getFunctionWithDefaultParametersForValueClassOverride", "getBoundReceiver", "()Ljava/lang/Object;", "useBoxedBoundReceiver", "member", "Ljava/lang/reflect/Method;", "createStaticMethodCaller", "isCallByToValueClassMangledMethod", "createJvmStaticInObjectCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createInstanceMethodCaller", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "isDefault", "arity", "", "getArity", "()I", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "equals", "other", "hashCode", "toString", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKFunctionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KFunctionImpl.kt\nkotlin/reflect/jvm/internal/KFunctionImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,235:1\n2746#2,3:236\n1761#2,3:240\n1563#2:244\n1634#2,3:245\n1563#2:249\n1634#2,3:250\n1563#2:253\n1634#2,3:254\n1563#2:257\n1634#2,3:258\n183#3:239\n184#3:243\n1#4:248\n*S KotlinDebug\n*F\n+ 1 KFunctionImpl.kt\nkotlin/reflect/jvm/internal/KFunctionImpl\n*L\n157#1:236,3\n164#1:240,3\n72#1:244\n72#1:245,3\n87#1:249\n87#1:250,3\n123#1:253\n123#1:254,3\n128#1:257\n128#1:258,3\n164#1:239\n164#1:243\n*E\n"})
public final class KFunctionImpl
extends KCallableImpl<Object>
implements FunctionBase<Object>,
KFunction<Object>,
FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final KDeclarationContainerImpl container;
    @NotNull
    private final String signature;
    @Nullable
    private final Object rawBoundReceiver;
    @NotNull
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    @NotNull
    private final Lazy caller$delegate;
    @NotNull
    private final Lazy defaultCaller$delegate;

    private KFunctionImpl(KDeclarationContainerImpl container, String name, String signature, FunctionDescriptor descriptorInitialValue, Object rawBoundReceiver) {
        this.container = container;
        this.signature = signature;
        this.rawBoundReceiver = rawBoundReceiver;
        Object object = name;
        KFunctionImpl kFunctionImpl = this;
        this.descriptor$delegate = ReflectProperties.lazySoft(descriptorInitialValue, new KFunctionImpl$$Lambda$0(kFunctionImpl, (String)object));
        object = this;
        this.caller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KFunctionImpl$$Lambda$1((KFunctionImpl)object));
        object = this;
        this.defaultCaller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KFunctionImpl$$Lambda$2((KFunctionImpl)object));
    }

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String string, String string2, FunctionDescriptor functionDescriptor, Object object, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            object = CallableReference.NO_RECEIVER;
        }
        this(kDeclarationContainerImpl, string, string2, functionDescriptor, object);
    }

    @Override
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    public KFunctionImpl(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object boundReceiver) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this(container, name, signature, null, boundReceiver);
    }

    public KFunctionImpl(@NotNull KDeclarationContainerImpl container, @NotNull FunctionDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        String string = descriptor2.getName().asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        this(container, string, RuntimeTypeMapper.INSTANCE.mapSignature(descriptor2).asString(), descriptor2, null, 16, null);
    }

    @Override
    public boolean isBound() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    @Override
    @NotNull
    public FunctionDescriptor getDescriptor() {
        Object t2 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
        return (FunctionDescriptor)t2;
    }

    @Override
    @NotNull
    public String getName() {
        String string = this.getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        return string;
    }

    @Override
    @NotNull
    public Caller<?> getCaller() {
        Lazy lazy = this.caller$delegate;
        return (Caller)lazy.getValue();
    }

    @Override
    @Nullable
    public Caller<?> getDefaultCaller() {
        Lazy lazy = this.defaultCaller$delegate;
        return (Caller)lazy.getValue();
    }

    private final FunctionDescriptor getFunctionWithDefaultParametersForValueClassOverride(FunctionDescriptor descriptor2) {
        boolean bl2;
        block10: {
            List<ValueParameterDescriptor> list = descriptor2.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Iterable $this$none$iv = list;
            boolean $i$f$none = false;
            if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$none$iv) {
                    ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv;
                    boolean bl3 = false;
                    if (!it.declaresDefaultValue()) continue;
                    bl2 = false;
                    break block10;
                }
                bl2 = true;
            }
        }
        if (bl2) {
            DeclarationDescriptor declarationDescriptor = descriptor2.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isValueClass(declarationDescriptor)) {
                Object obj = this.getCaller().getMember();
                Intrinsics.checkNotNull(obj);
                if (Modifier.isStatic(obj.getModifiers())) {
                    CallableMemberDescriptor callableMemberDescriptor;
                    block12: {
                        Sequence<CallableMemberDescriptor> $this$firstOrNull$iv = DescriptorUtilsKt.overriddenTreeAsSequence(descriptor2, false);
                        boolean $i$f$firstOrNull = false;
                        Iterator<CallableMemberDescriptor> iterator2 = $this$firstOrNull$iv.iterator();
                        while (iterator2.hasNext()) {
                            boolean bl4;
                            CallableMemberDescriptor element$iv;
                            block11: {
                                CallableMemberDescriptor function = element$iv = iterator2.next();
                                boolean bl5 = false;
                                List<ValueParameterDescriptor> list = function.getValueParameters();
                                Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
                                Iterable $this$any$iv = list;
                                boolean $i$f$any = false;
                                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                    bl4 = false;
                                } else {
                                    for (Object element$iv2 : $this$any$iv) {
                                        ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv2;
                                        boolean bl6 = false;
                                        if (!it.declaresDefaultValue()) continue;
                                        bl4 = true;
                                        break block11;
                                    }
                                    bl4 = false;
                                }
                            }
                            if (!bl4) continue;
                            callableMemberDescriptor = element$iv;
                            break block12;
                        }
                        callableMemberDescriptor = null;
                    }
                    CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
                    return callableMemberDescriptor2 instanceof FunctionDescriptor ? (FunctionDescriptor)callableMemberDescriptor2 : null;
                }
            }
        }
        return null;
    }

    private final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, this.getDescriptor());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean useBoxedBoundReceiver(Method member) {
        ReceiverParameterDescriptor receiverParameterDescriptor = this.getDescriptor().getDispatchReceiverParameter();
        Annotated annotated = receiverParameterDescriptor;
        if (receiverParameterDescriptor == null) return false;
        KotlinType kotlinType = annotated.getType();
        annotated = kotlinType;
        if (kotlinType == null) return false;
        if (!InlineClassesUtilsKt.isInlineClassType((KotlinType)annotated)) return false;
        boolean bl2 = true;
        if (!bl2) return false;
        Class<?>[] classArray = member.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(classArray, "getParameterTypes(...)");
        Class clazz = (Class)ArraysKt.firstOrNull((Object[])classArray);
        if (clazz == null) return false;
        if (!clazz.isInterface()) return false;
        return true;
    }

    private final Caller<?> createStaticMethodCaller(Method member, boolean isCallByToValueClassMangledMethod) {
        return this.isBound() ? (Caller)new CallerImpl.Method.BoundStatic(member, isCallByToValueClassMangledMethod, this.useBoxedBoundReceiver(member) ? this.rawBoundReceiver : this.getBoundReceiver()) : (Caller)new CallerImpl.Method.Static(member);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method member) {
        return this.isBound() ? (CallerImpl.Method)new CallerImpl.Method.BoundJvmStaticInObject(member) : (CallerImpl.Method)new CallerImpl.Method.JvmStaticInObject(member);
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method member) {
        return this.isBound() ? (CallerImpl.Method)new CallerImpl.Method.BoundInstance(member, this.getBoundReceiver()) : (CallerImpl.Method)new CallerImpl.Method.Instance(member);
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> member, FunctionDescriptor descriptor2, boolean isDefault) {
        return !isDefault && InlineClassManglingRulesKt.shouldHideConstructorDueToValueClassTypeValueParameters(descriptor2) ? (this.isBound() ? (CallerImpl)new CallerImpl.AccessorForHiddenBoundConstructor(member, this.getBoundReceiver()) : (CallerImpl)new CallerImpl.AccessorForHiddenConstructor(member)) : (this.isBound() ? (CallerImpl)new CallerImpl.BoundConstructor(member, this.getBoundReceiver()) : (CallerImpl)new CallerImpl.Constructor(member));
    }

    @Override
    public int getArity() {
        return CallerKt.getArity(this.getCaller());
    }

    @Override
    public boolean isInline() {
        return this.getDescriptor().isInline();
    }

    @Override
    public boolean isExternal() {
        return this.getDescriptor().isExternal();
    }

    @Override
    public boolean isOperator() {
        return this.getDescriptor().isOperator();
    }

    @Override
    public boolean isInfix() {
        return this.getDescriptor().isInfix();
    }

    @Override
    public boolean isSuspend() {
        return this.getDescriptor().isSuspend();
    }

    public boolean equals(@Nullable Object other) {
        KFunctionImpl kFunctionImpl = UtilKt.asKFunctionImpl(other);
        if (kFunctionImpl == null) {
            return false;
        }
        KFunctionImpl that = kFunctionImpl;
        return Intrinsics.areEqual(this.getContainer(), that.getContainer()) && Intrinsics.areEqual(this.getName(), that.getName()) && Intrinsics.areEqual(this.signature, that.signature) && Intrinsics.areEqual(this.rawBoundReceiver, that.rawBoundReceiver);
    }

    public int hashCode() {
        return (this.getContainer().hashCode() * 31 + this.getName().hashCode()) * 31 + this.signature.hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(this.getDescriptor());
    }

    @Override
    @Nullable
    public Object invoke() {
        return this.default$invoke();
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1) {
        return this.default$invoke(p1);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2) {
        return this.default$invoke(p1, p2);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3) {
        return this.default$invoke(p1, p2, p3);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4) {
        return this.default$invoke(p1, p2, p3, p4);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5) {
        return this.default$invoke(p1, p2, p3, p4, p5);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19, @Nullable Object p20) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19, @Nullable Object p20, @Nullable Object p21) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19, @Nullable Object p20, @Nullable Object p21, @Nullable Object p22) {
        return this.default$invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22);
    }

    private static final FunctionDescriptor descriptor_delegate$lambda$0(KFunctionImpl this$0, String $name) {
        return this$0.getContainer().findFunctionDescriptor($name, this$0.signature);
    }

    /*
     * WARNING - void declaration
     */
    private static final Caller caller_delegate$lambda$4(KFunctionImpl this$0) {
        Caller<Object> caller;
        Member member;
        Member member2;
        JvmFunctionSignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this$0.getDescriptor());
        if (jvmSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this$0.isAnnotationConstructor()) {
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                Iterable iterable = this$0.getParameters();
                Class<?> clazz = this$0.getContainer().getJClass();
                boolean $i$f$map = false;
                void var5_9 = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    KParameter kParameter = (KParameter)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl2 = false;
                    String string = it.getName();
                    Intrinsics.checkNotNull(string);
                    collection.add(string);
                }
                DefaultConstructorMarker defaultConstructorMarker = null;
                int n2 = 16;
                List list = null;
                AnnotationConstructorCaller.Origin origin = AnnotationConstructorCaller.Origin.KOTLIN;
                AnnotationConstructorCaller.CallMode callMode = AnnotationConstructorCaller.CallMode.POSITIONAL_CALL;
                List list2 = (List)destination$iv$iv;
                Class<?> clazz2 = clazz;
                return new AnnotationConstructorCaller(clazz2, list2, callMode, origin, list, n2, defaultConstructorMarker);
            }
            member2 = this$0.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor)jvmSignature).getConstructorDesc());
        } else if (jvmSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor it = this$0.getDescriptor();
            boolean bl3 = false;
            DeclarationDescriptor declarationDescriptor = it.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
            boolean bl4 = InlineClassesUtilsKt.isMultiFieldValueClass(declarationDescriptor) && it instanceof ConstructorDescriptor && ((ConstructorDescriptor)it).isPrimary();
            if (bl4) {
                FunctionDescriptor functionDescriptor = this$0.getDescriptor();
                KDeclarationContainerImpl kDeclarationContainerImpl = this$0.getContainer();
                String string = ((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodDesc();
                List<ValueParameterDescriptor> list = this$0.getDescriptor().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
                return new ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller(functionDescriptor, kDeclarationContainerImpl, string, list);
            }
            member2 = this$0.getContainer().findMethodBySignature(((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodName(), ((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodDesc());
        } else if (jvmSignature instanceof JvmFunctionSignature.JavaMethod) {
            Method method = ((JvmFunctionSignature.JavaMethod)jvmSignature).getMethod();
            Intrinsics.checkNotNull(method, "null cannot be cast to non-null type java.lang.reflect.Member");
            member2 = method;
        } else if (jvmSignature instanceof JvmFunctionSignature.JavaConstructor) {
            Constructor<?> constructor = ((JvmFunctionSignature.JavaConstructor)jvmSignature).getConstructor();
            Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Member");
            member2 = constructor;
        } else {
            if (jvmSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                List<Method> methods2 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor)jvmSignature).getMethods();
                Iterable it = methods2;
                Class<?> clazz = this$0.getContainer().getJClass();
                boolean $i$f$map = false;
                void destination$iv$iv = $this$map$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it2;
                    Method bl2 = (Method)item$iv$iv;
                    Collection collection = destination$iv$iv2;
                    boolean bl5 = false;
                    collection.add(it2.getName());
                }
                List<Method> list = methods2;
                AnnotationConstructorCaller.Origin origin = AnnotationConstructorCaller.Origin.JAVA;
                AnnotationConstructorCaller.CallMode callMode = AnnotationConstructorCaller.CallMode.POSITIONAL_CALL;
                List list3 = (List)destination$iv$iv2;
                Class<?> clazz3 = clazz;
                return new AnnotationConstructorCaller(clazz3, list3, callMode, origin, list);
            }
            throw new NoWhenBranchMatchedException();
        }
        Member member3 = member = member2;
        if (member3 instanceof Constructor) {
            caller = (Caller<?>)this$0.createConstructorCaller((Constructor)member, this$0.getDescriptor(), false);
        } else if (member3 instanceof Method) {
            caller = !Modifier.isStatic(((Method)member).getModifiers()) ? (Caller)this$0.createInstanceMethodCaller((Method)member) : (this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null ? (Caller)this$0.createJvmStaticInObjectCaller((Method)member) : this$0.createStaticMethodCaller((Method)member, false));
        } else {
            throw new KotlinReflectionInternalError("Could not compute caller for function: " + this$0.getDescriptor() + " (member = " + member + ')');
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded$default(caller, this$0.getDescriptor(), false, 2, null);
    }

    /*
     * Unable to fully structure code
     */
    private static final Caller defaultCaller_delegate$lambda$10(KFunctionImpl this$0) {
        block14: {
            block15: {
                block13: {
                    jvmSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this$0.getDescriptor());
                    if (jvmSignature instanceof JvmFunctionSignature.KotlinFunction) {
                        $this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247 = this$0;
                        $i$a$-run-KFunctionImpl$defaultCaller$2$member$1 = false;
                        it = $this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247.getDescriptor();
                        $i$a$-let-KFunctionImpl$defaultCaller$2$member$1$1 = false;
                        v0 = it.getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(v0, "getContainingDeclaration(...)");
                        v1 = InlineClassesUtilsKt.isMultiFieldValueClass(v0) && it instanceof ConstructorDescriptor && ((ConstructorDescriptor)it).isPrimary();
                        if (v1) {
                            throw new KotlinReflectionInternalError($this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247.getDescriptor().getContainingDeclaration() + " cannot have default arguments");
                        }
                        v2 = $this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247.getFunctionWithDefaultParametersForValueClassOverride($this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247.getDescriptor());
                        if (v2 != null) {
                            defaultImplsFunction = v2;
                            $i$a$-let-KFunctionImpl$defaultCaller$2$member$1$2 = false;
                            v3 = RuntimeTypeMapper.INSTANCE.mapSignature(defaultImplsFunction);
                            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction");
                            replacingJvmSignature = (JvmFunctionSignature.KotlinFunction)v3;
                            v4 = $this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247.getContainer().findDefaultMethod(replacingJvmSignature.getMethodName(), replacingJvmSignature.getMethodDesc(), true);
                        } else {
                            v5 = $this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247.getContainer();
                            v6 = ((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodName();
                            v7 = ((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodDesc();
                            v8 = $this$defaultCaller_delegate_u24lambda_u2410_u24lambda_u247.getCaller().getMember();
                            Intrinsics.checkNotNull(v8);
                            v4 = v5.findDefaultMethod(v6, v7, Modifier.isStatic(v8.getModifiers()) == false);
                        }
                    } else if (jvmSignature instanceof JvmFunctionSignature.KotlinConstructor) {
                        if (this$0.isAnnotationConstructor()) {
                            var3_21 = this$0.getParameters();
                            var13_24 = this$0.getContainer().getJClass();
                            $i$f$map = false;
                            $i$a$-run-KFunctionImpl$defaultCaller$2$member$1 = $this$map$iv;
                            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            $i$f$mapTo = false;
                            for (T item$iv$iv : $this$mapTo$iv$iv) {
                                var10_26 = (KParameter)item$iv$iv;
                                var14_30 = destination$iv$iv;
                                $i$a$-map-KFunctionImpl$defaultCaller$2$member$2 = false;
                                v9 = it.getName();
                                Intrinsics.checkNotNull(v9);
                                var14_30.add(v9);
                            }
                            var15_32 = null;
                            var16_33 = 16;
                            var17_34 = null;
                            var18_35 = AnnotationConstructorCaller.Origin.KOTLIN;
                            var19_36 = AnnotationConstructorCaller.CallMode.CALL_BY_NAME;
                            var20_37 = (List)destination$iv$iv;
                            var21_38 = var13_24;
                            return new AnnotationConstructorCaller(var21_38, var20_37, var19_36, var18_35, var17_34, var16_33, var15_32);
                        }
                        v4 = this$0.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor)jvmSignature).getConstructorDesc());
                    } else {
                        if (jvmSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                            methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor)jvmSignature).getMethods();
                            $i$f$map = methods;
                            var13_25 = this$0.getContainer().getJClass();
                            $i$f$map = false;
                            destination$iv$iv = $this$map$iv;
                            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            $i$f$mapTo = false;
                            for (T item$iv$iv : $this$mapTo$iv$iv) {
                                $i$a$-map-KFunctionImpl$defaultCaller$2$member$2 = (Method)item$iv$iv;
                                var14_31 = destination$iv$iv;
                                $i$a$-map-KFunctionImpl$defaultCaller$2$member$3 = false;
                                var14_31.add(it.getName());
                            }
                            var22_40 = methods;
                            var23_41 = AnnotationConstructorCaller.Origin.JAVA;
                            var24_42 = AnnotationConstructorCaller.CallMode.CALL_BY_NAME;
                            var25_43 = (List)destination$iv$iv;
                            var26_44 = var13_25;
                            return new AnnotationConstructorCaller(var26_44, var25_43, var24_42, var23_41, var22_40);
                        }
                        v4 = null;
                    }
                    var3_23 = member = v4;
                    if (!(var3_23 instanceof Constructor)) break block13;
                    v10 = this$0.createConstructorCaller((Constructor)member, this$0.getDescriptor(), true);
                    break block14;
                }
                if (!(var3_23 instanceof Method)) break block15;
                if (this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) == null) ** GOTO lbl-1000
                v11 = this$0.getDescriptor().getContainingDeclaration();
                Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((ClassDescriptor)v11).isCompanionObject()) {
                    v10 = this$0.createJvmStaticInObjectCaller((Method)member);
                } else lbl-1000:
                // 2 sources

                {
                    v10 = this$0.createStaticMethodCaller((Method)member, this$0.getCaller().isBoundInstanceCallWithValueClasses());
                }
                break block14;
            }
            v10 = null;
        }
        var2_1 = v10;
        return var2_1 != null ? ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(var2_1, this$0.getDescriptor(), true) : null;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KFunctionImpl.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ FunctionDescriptor accessor$KFunctionImpl$lambda0(KFunctionImpl kFunctionImpl, String string) {
        return KFunctionImpl.descriptor_delegate$lambda$0(kFunctionImpl, string);
    }

    static /* synthetic */ Caller accessor$KFunctionImpl$lambda1(KFunctionImpl kFunctionImpl) {
        return KFunctionImpl.caller_delegate$lambda$4(kFunctionImpl);
    }

    static /* synthetic */ Caller accessor$KFunctionImpl$lambda2(KFunctionImpl kFunctionImpl) {
        return KFunctionImpl.defaultCaller_delegate$lambda$10(kFunctionImpl);
    }

    @Nullable
    public Object default$invoke() {
        return this.call(new Object[0]);
    }

    @Nullable
    public Object default$invoke(Object p1) {
        Object[] objectArray = new Object[]{p1};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2) {
        Object[] objectArray = new Object[]{p1, p2};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3) {
        Object[] objectArray = new Object[]{p1, p2, p3};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21};
        return this.call(objectArray);
    }

    @Nullable
    public Object default$invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9, Object p10, Object p11, Object p12, Object p13, Object p14, Object p15, Object p16, Object p17, Object p18, Object p19, Object p20, Object p21, Object p22) {
        Object[] objectArray = new Object[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22};
        return this.call(objectArray);
    }
}

