/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KPropertyImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KPropertyImpl$Getter$$Lambda$0;
import kotlin.reflect.jvm.internal.KPropertyImpl$Getter$$Lambda$1;
import kotlin.reflect.jvm.internal.KPropertyImpl$Setter$$Lambda$0;
import kotlin.reflect.jvm.internal.KPropertyImpl$Setter$$Lambda$1;
import kotlin.reflect.jvm.internal.KPropertyImplKt;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 C*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004@ABCB5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u0012J\n\u0010#\u001a\u0004\u0018\u00010$H\u0004J(\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010\f2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0004J\u0013\u0010;\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010\u001f8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\n0\n0.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u0006\u0012\u0002\b\u0003038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u0001038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u00108\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u0010\u001cR\u0014\u00109\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u001cR\u0014\u0010:\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010\u001c\u00a8\u0006D"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "rawBoundReceiver", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getName", "()Ljava/lang/String;", "getSignature", "getBoundReceiver", "()Ljava/lang/Object;", "isBound", "", "()Z", "_javaField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "computeDelegateSource", "Ljava/lang/reflect/Member;", "getDelegateImpl", "fieldOrMethod", "receiver1", "receiver2", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getDefaultCaller", "isLateinit", "isConst", "isSuspend", "equals", "other", "hashCode", "", "toString", "Accessor", "Getter", "Setter", "Companion", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKPropertyImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KPropertyImpl.kt\nkotlin/reflect/jvm/internal/KPropertyImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,334:1\n1#2:335\n*E\n"})
public abstract class KPropertyImpl<V>
extends KCallableImpl<V>
implements KProperty<V> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final KDeclarationContainerImpl container;
    @NotNull
    private final String name;
    @NotNull
    private final String signature;
    @Nullable
    private final Object rawBoundReceiver;
    @NotNull
    private final Lazy<Field> _javaField;
    @NotNull
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;
    @NotNull
    private static final Object EXTENSION_PROPERTY_DELEGATE = new Object();

    private KPropertyImpl(KDeclarationContainerImpl container, String name, String signature, PropertyDescriptor descriptorInitialValue, Object rawBoundReceiver) {
        this.container = container;
        this.name = name;
        this.signature = signature;
        this.rawBoundReceiver = rawBoundReceiver;
        KPropertyImpl kPropertyImpl = this;
        this._javaField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPropertyImpl$$Lambda$0(kPropertyImpl));
        kPropertyImpl = this;
        ReflectProperties.LazySoftVal<PropertyDescriptor> lazySoftVal = ReflectProperties.lazySoft(descriptorInitialValue, new KPropertyImpl$$Lambda$1(kPropertyImpl));
        Intrinsics.checkNotNullExpressionValue(lazySoftVal, "lazySoft(...)");
        this._descriptor = lazySoftVal;
    }

    @Override
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    public KPropertyImpl(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object boundReceiver) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this(container, name, signature, null, boundReceiver);
    }

    public KPropertyImpl(@NotNull KDeclarationContainerImpl container, @NotNull PropertyDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        String string = descriptor2.getName().asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        this(container, string, RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor2).asString(), descriptor2, CallableReference.NO_RECEIVER);
    }

    @Nullable
    public final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, this.getDescriptor());
    }

    @Override
    public boolean isBound() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    @Nullable
    public final Field getJavaField() {
        return this._javaField.getValue();
    }

    @Nullable
    protected final Member computeDelegateSource() {
        if (!this.getDescriptor().isDelegated()) {
            return null;
        }
        JvmPropertySignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this.getDescriptor());
        if (jvmSignature instanceof JvmPropertySignature.KotlinProperty && ((JvmPropertySignature.KotlinProperty)jvmSignature).getSignature().hasDelegateMethod()) {
            JvmProtoBuf.JvmMethodSignature method = ((JvmPropertySignature.KotlinProperty)jvmSignature).getSignature().getDelegateMethod();
            if (!method.hasName() || !method.hasDesc()) {
                return null;
            }
            String name = ((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver().getString(method.getName());
            String desc = ((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver().getString(method.getDesc());
            return this.getContainer().findMethodBySignature(name, desc);
        }
        return this.getJavaField();
    }

    @Nullable
    protected final Object getDelegateImpl(@Nullable Member fieldOrMethod, @Nullable Object receiver1, @Nullable Object receiver2) {
        Object object;
        try {
            Object object2;
            block12: {
                block14: {
                    Object realReceiver2;
                    Object object3;
                    Object realReceiver1;
                    block13: {
                        block11: {
                            Object object4;
                            if ((receiver1 == EXTENSION_PROPERTY_DELEGATE || receiver2 == EXTENSION_PROPERTY_DELEGATE) && this.getDescriptor().getExtensionReceiverParameter() == null) {
                                throw new RuntimeException("" + '\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
                            }
                            Object it = object4 = this.isBound() ? this.getBoundReceiver() : receiver1;
                            boolean bl2 = false;
                            realReceiver1 = it != EXTENSION_PROPERTY_DELEGATE ? object4 : null;
                            Object it2 = object3 = this.isBound() ? receiver1 : receiver2;
                            boolean bl3 = false;
                            realReceiver2 = it2 != EXTENSION_PROPERTY_DELEGATE ? object3 : null;
                            AccessibleObject accessibleObject = fieldOrMethod instanceof AccessibleObject ? (AccessibleObject)((Object)fieldOrMethod) : null;
                            if (accessibleObject != null) {
                                accessibleObject.setAccessible(KCallablesJvm.isAccessible(this));
                            }
                            object3 = fieldOrMethod;
                            if (object3 != null) break block11;
                            object2 = null;
                            break block12;
                        }
                        if (!(object3 instanceof Field)) break block13;
                        object2 = ((Field)fieldOrMethod).get(realReceiver1);
                        break block12;
                    }
                    if (!(object3 instanceof Method)) break block14;
                    switch (((Method)fieldOrMethod).getParameterTypes().length) {
                        case 0: {
                            object2 = ((Method)fieldOrMethod).invoke(null, new Object[0]);
                            break block12;
                        }
                        case 1: {
                            Method method = (Method)fieldOrMethod;
                            Object[] objectArray = new Object[1];
                            Object object5 = realReceiver1;
                            if (object5 == null) {
                                Class<?> clazz = ((Method)fieldOrMethod).getParameterTypes()[0];
                                Intrinsics.checkNotNullExpressionValue(clazz, "get(...)");
                                object5 = UtilKt.defaultPrimitiveValue(clazz);
                            }
                            objectArray[0] = object5;
                            object2 = method.invoke(null, objectArray);
                            break block12;
                        }
                        case 2: {
                            Method method = (Method)fieldOrMethod;
                            Object[] objectArray = new Object[2];
                            objectArray[0] = realReceiver1;
                            Object object6 = realReceiver2;
                            if (object6 == null) {
                                Class<?> clazz = ((Method)fieldOrMethod).getParameterTypes()[1];
                                Intrinsics.checkNotNullExpressionValue(clazz, "get(...)");
                                object6 = UtilKt.defaultPrimitiveValue(clazz);
                            }
                            objectArray[1] = object6;
                            object2 = method.invoke(null, objectArray);
                            break block12;
                        }
                        default: {
                            throw new AssertionError((Object)("delegate method " + fieldOrMethod + " should take 0, 1, or 2 parameters"));
                        }
                    }
                }
                throw new AssertionError((Object)("delegate field/method " + fieldOrMethod + " neither field nor method"));
            }
            object = object2;
        }
        catch (IllegalAccessException e2) {
            throw new IllegalPropertyDelegateAccessException(e2);
        }
        return object;
    }

    @Override
    @NotNull
    public abstract Getter<V> getGetter();

    @Override
    @NotNull
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor propertyDescriptor = this._descriptor.invoke();
        Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "invoke(...)");
        return propertyDescriptor;
    }

    @Override
    @NotNull
    public Caller<?> getCaller() {
        return this.getGetter().getCaller();
    }

    @Override
    @Nullable
    public Caller<?> getDefaultCaller() {
        return this.getGetter().getDefaultCaller();
    }

    @Override
    public boolean isLateinit() {
        return this.getDescriptor().isLateInit();
    }

    @Override
    public boolean isConst() {
        return this.getDescriptor().isConst();
    }

    @Override
    public boolean isSuspend() {
        return false;
    }

    public boolean equals(@Nullable Object other) {
        KPropertyImpl<?> kPropertyImpl = UtilKt.asKPropertyImpl(other);
        if (kPropertyImpl == null) {
            return false;
        }
        KPropertyImpl<?> that = kPropertyImpl;
        return Intrinsics.areEqual(this.getContainer(), that.getContainer()) && Intrinsics.areEqual(this.getName(), that.getName()) && Intrinsics.areEqual(this.signature, that.signature) && Intrinsics.areEqual(this.rawBoundReceiver, that.rawBoundReceiver);
    }

    public int hashCode() {
        return (this.getContainer().hashCode() * 31 + this.getName().hashCode()) * 31 + this.signature.hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(this.getDescriptor());
    }

    private static final Field _javaField$lambda$2(KPropertyImpl this$0) {
        Field field;
        JvmPropertySignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this$0.getDescriptor());
        if (jvmSignature instanceof JvmPropertySignature.KotlinProperty) {
            PropertyDescriptor descriptor2 = ((JvmPropertySignature.KotlinProperty)jvmSignature).getDescriptor();
            JvmMemberSignature.Field field2 = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, ((JvmPropertySignature.KotlinProperty)jvmSignature).getProto(), ((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver(), ((JvmPropertySignature.KotlinProperty)jvmSignature).getTypeTable(), false, 8, null);
            if (field2 != null) {
                Field field3;
                Class<?> clazz;
                JvmMemberSignature.Field it = field2;
                boolean bl2 = false;
                if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor2) || JvmProtoBufUtil.isMovedFromInterfaceCompanion(((JvmPropertySignature.KotlinProperty)jvmSignature).getProto())) {
                    clazz = this$0.getContainer().getJClass().getEnclosingClass();
                } else {
                    DeclarationDescriptor containingDeclaration = descriptor2.getContainingDeclaration();
                    boolean bl3 = false;
                    clazz = containingDeclaration instanceof ClassDescriptor ? UtilKt.toJavaClass((ClassDescriptor)containingDeclaration) : this$0.getContainer().getJClass();
                }
                Class<?> owner = clazz;
                try {
                    Class<?> clazz2 = owner;
                    field3 = clazz2 != null ? clazz2.getDeclaredField(it.getName()) : null;
                }
                catch (NoSuchFieldException e2) {
                    field3 = null;
                }
                field = field3;
            } else {
                field = null;
            }
        } else if (jvmSignature instanceof JvmPropertySignature.JavaField) {
            field = ((JvmPropertySignature.JavaField)jvmSignature).getField();
        } else if (jvmSignature instanceof JvmPropertySignature.JavaMethodProperty) {
            field = null;
        } else if (jvmSignature instanceof JvmPropertySignature.MappedKotlinProperty) {
            field = null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return field;
    }

    private static final PropertyDescriptor _descriptor$lambda$5(KPropertyImpl this$0) {
        return this$0.getContainer().findPropertyDescriptor(this$0.getName(), this$0.signature);
    }

    static /* synthetic */ Field accessor$KPropertyImpl$lambda0(KPropertyImpl kPropertyImpl) {
        return KPropertyImpl._javaField$lambda$2(kPropertyImpl);
    }

    static /* synthetic */ PropertyDescriptor accessor$KPropertyImpl$lambda1(KPropertyImpl kPropertyImpl) {
        return KPropertyImpl._descriptor$lambda$5(kPropertyImpl);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001a\u00a8\u0006 "}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "<init>", "()V", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "isBound", "", "()Z", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "kotlin-reflection"})
    public static abstract class Accessor<PropertyType, ReturnType>
    extends KCallableImpl<ReturnType>
    implements KFunction<ReturnType>,
    KProperty.Accessor<PropertyType> {
        @Override
        @NotNull
        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override
        @NotNull
        public abstract PropertyAccessorDescriptor getDescriptor();

        @Override
        @NotNull
        public KDeclarationContainerImpl getContainer() {
            return this.getProperty().getContainer();
        }

        @Override
        @Nullable
        public Caller<?> getDefaultCaller() {
            return null;
        }

        @Override
        public boolean isBound() {
            return this.getProperty().isBound();
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
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "<init>", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return EXTENSION_PROPERTY_DELEGATE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00118VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", "", "other", "", "hashCode", "", "kotlin-reflection"})
    public static abstract class Getter<V>
    extends Accessor<V, V>
    implements KProperty.Getter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor$delegate;
        @NotNull
        private final Lazy caller$delegate;

        public Getter() {
            Getter getter = this;
            this.descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Getter$$Lambda$0(getter));
            getter = this;
            this.caller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPropertyImpl$Getter$$Lambda$1(getter));
        }

        @Override
        @NotNull
        public String getName() {
            return "<get-" + this.getProperty().getName() + '>';
        }

        @Override
        @NotNull
        public PropertyGetterDescriptor getDescriptor() {
            Object t2 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (PropertyGetterDescriptor)t2;
        }

        @Override
        @NotNull
        public Caller<?> getCaller() {
            Lazy lazy = this.caller$delegate;
            return (Caller)lazy.getValue();
        }

        @NotNull
        public String toString() {
            return "getter of " + this.getProperty();
        }

        public boolean equals(@Nullable Object other) {
            return other instanceof Getter && Intrinsics.areEqual(this.getProperty(), ((Getter)other).getProperty());
        }

        public int hashCode() {
            return this.getProperty().hashCode();
        }

        private static final PropertyGetterDescriptor descriptor_delegate$lambda$0(Getter this$0) {
            PropertyGetterDescriptor propertyGetterDescriptor = this$0.getProperty().getDescriptor().getGetter();
            if (propertyGetterDescriptor == null) {
                PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = DescriptorFactory.createDefaultGetter(this$0.getProperty().getDescriptor(), Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImpl, "createDefaultGetter(...)");
                propertyGetterDescriptor = propertyGetterDescriptorImpl;
            }
            return propertyGetterDescriptor;
        }

        private static final Caller caller_delegate$lambda$1(Getter this$0) {
            return KPropertyImplKt.access$computeCallerForAccessor(this$0, true);
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Getter.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0))};
            $$delegatedProperties = kPropertyArray;
        }

        static /* synthetic */ PropertyGetterDescriptor accessor$KPropertyImpl$Getter$lambda0(Getter getter) {
            return Getter.descriptor_delegate$lambda$0(getter);
        }

        static /* synthetic */ Caller accessor$KPropertyImpl$Getter$lambda1(Getter getter) {
            return Getter.caller_delegate$lambda$1(getter);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", "", "other", "", "hashCode", "", "kotlin-reflection"})
    public static abstract class Setter<V>
    extends Accessor<V, Unit>
    implements KMutableProperty.Setter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor$delegate;
        @NotNull
        private final Lazy caller$delegate;

        public Setter() {
            Setter setter = this;
            this.descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Setter$$Lambda$0(setter));
            setter = this;
            this.caller$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPropertyImpl$Setter$$Lambda$1(setter));
        }

        @Override
        @NotNull
        public String getName() {
            return "<set-" + this.getProperty().getName() + '>';
        }

        @Override
        @NotNull
        public PropertySetterDescriptor getDescriptor() {
            Object t2 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (PropertySetterDescriptor)t2;
        }

        @Override
        @NotNull
        public Caller<?> getCaller() {
            Lazy lazy = this.caller$delegate;
            return (Caller)lazy.getValue();
        }

        @NotNull
        public String toString() {
            return "setter of " + this.getProperty();
        }

        public boolean equals(@Nullable Object other) {
            return other instanceof Setter && Intrinsics.areEqual(this.getProperty(), ((Setter)other).getProperty());
        }

        public int hashCode() {
            return this.getProperty().hashCode();
        }

        private static final PropertySetterDescriptor descriptor_delegate$lambda$0(Setter this$0) {
            PropertySetterDescriptor propertySetterDescriptor = this$0.getProperty().getDescriptor().getSetter();
            if (propertySetterDescriptor == null) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(this$0.getProperty().getDescriptor(), Annotations.Companion.getEMPTY(), Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNullExpressionValue(propertySetterDescriptorImpl, "createDefaultSetter(...)");
                propertySetterDescriptor = propertySetterDescriptorImpl;
            }
            return propertySetterDescriptor;
        }

        private static final Caller caller_delegate$lambda$1(Setter this$0) {
            return KPropertyImplKt.access$computeCallerForAccessor(this$0, false);
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Setter.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0))};
            $$delegatedProperties = kPropertyArray;
        }

        static /* synthetic */ PropertySetterDescriptor accessor$KPropertyImpl$Setter$lambda0(Setter setter) {
            return Setter.descriptor_delegate$lambda$0(setter);
        }

        static /* synthetic */ Caller accessor$KPropertyImpl$Setter$lambda1(Setter setter) {
            return Setter.caller_delegate$lambda$1(setter);
        }
    }
}

