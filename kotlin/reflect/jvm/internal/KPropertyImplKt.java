/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u000b"}, d2={"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKPropertyImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KPropertyImpl.kt\nkotlin/reflect/jvm/internal/KPropertyImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,334:1\n1#2:335\n*E\n"})
public final class KPropertyImplKt {
    @Nullable
    public static final Object getBoundReceiver(@NotNull KPropertyImpl.Accessor<?, ?> $this$boundReceiver) {
        Intrinsics.checkNotNullParameter($this$boundReceiver, "<this>");
        return $this$boundReceiver.getProperty().getBoundReceiver();
    }

    private static final Caller<?> computeCallerForAccessor(KPropertyImpl.Accessor<?, ?> $this$computeCallerForAccessor, boolean isGetter) {
        Caller caller;
        if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches($this$computeCallerForAccessor.getProperty().getSignature())) {
            return ThrowingCaller.INSTANCE;
        }
        JvmPropertySignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature($this$computeCallerForAccessor.getProperty().getDescriptor());
        JvmPropertySignature jvmPropertySignature = jvmSignature;
        if (jvmPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            Method method;
            JvmProtoBuf.JvmMethodSignature accessorSignature;
            JvmProtoBuf.JvmPropertySignature $this$computeCallerForAccessor_u24lambda_u240 = ((JvmPropertySignature.KotlinProperty)jvmSignature).getSignature();
            boolean bl2 = false;
            JvmProtoBuf.JvmMethodSignature jvmMethodSignature = accessorSignature = isGetter ? ($this$computeCallerForAccessor_u24lambda_u240.hasGetter() ? $this$computeCallerForAccessor_u24lambda_u240.getGetter() : null) : ($this$computeCallerForAccessor_u24lambda_u240.hasSetter() ? $this$computeCallerForAccessor_u24lambda_u240.getSetter() : null);
            if (jvmMethodSignature != null) {
                JvmProtoBuf.JvmMethodSignature signature = jvmMethodSignature;
                boolean bl3 = false;
                method = $this$computeCallerForAccessor.getProperty().getContainer().findMethodBySignature(((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver().getString(signature.getName()), ((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver().getString(signature.getDesc()));
            } else {
                method = null;
            }
            Method accessor = method;
            if (accessor == null) {
                if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass($this$computeCallerForAccessor.getProperty().getDescriptor()) && Intrinsics.areEqual($this$computeCallerForAccessor.getProperty().getDescriptor().getVisibility(), DescriptorVisibilities.INTERNAL)) {
                    GenericDeclaration genericDeclaration = ValueClassAwareCallerKt.toInlineClass($this$computeCallerForAccessor.getProperty().getDescriptor().getContainingDeclaration());
                    if (genericDeclaration == null || (genericDeclaration = ValueClassAwareCallerKt.getInlineClassUnboxMethod(genericDeclaration, $this$computeCallerForAccessor.getProperty().getDescriptor())) == null) {
                        throw new KotlinReflectionInternalError("Underlying property of inline class " + $this$computeCallerForAccessor.getProperty() + " should have a field");
                    }
                    GenericDeclaration unboxMethod = genericDeclaration;
                    caller = $this$computeCallerForAccessor.isBound() ? (InternalUnderlyingValOfInlineClass)new InternalUnderlyingValOfInlineClass.Bound((Method)unboxMethod, KPropertyImplKt.getBoundReceiver($this$computeCallerForAccessor)) : (InternalUnderlyingValOfInlineClass)new InternalUnderlyingValOfInlineClass.Unbound((Method)unboxMethod);
                } else {
                    Field field = $this$computeCallerForAccessor.getProperty().getJavaField();
                    if (field == null) {
                        throw new KotlinReflectionInternalError("No accessors or field is found for property " + $this$computeCallerForAccessor.getProperty());
                    }
                    Field javaField = field;
                    caller = KPropertyImplKt.computeCallerForAccessor$computeFieldCaller($this$computeCallerForAccessor, isGetter, javaField);
                }
            } else {
                caller = !Modifier.isStatic(accessor.getModifiers()) ? (Caller)($this$computeCallerForAccessor.isBound() ? (CallerImpl.Method)new CallerImpl.Method.BoundInstance(accessor, KPropertyImplKt.getBoundReceiver($this$computeCallerForAccessor)) : (CallerImpl.Method)new CallerImpl.Method.Instance(accessor)) : (KPropertyImplKt.computeCallerForAccessor$isJvmStaticProperty($this$computeCallerForAccessor) ? (Caller)($this$computeCallerForAccessor.isBound() ? (CallerImpl.Method)new CallerImpl.Method.BoundJvmStaticInObject(accessor) : (CallerImpl.Method)new CallerImpl.Method.JvmStaticInObject(accessor)) : (Caller)($this$computeCallerForAccessor.isBound() ? (CallerImpl.Method)new CallerImpl.Method.BoundStatic(accessor, false, KPropertyImplKt.getBoundReceiver($this$computeCallerForAccessor)) : (CallerImpl.Method)new CallerImpl.Method.Static(accessor)));
            }
        } else if (jvmPropertySignature instanceof JvmPropertySignature.JavaField) {
            caller = KPropertyImplKt.computeCallerForAccessor$computeFieldCaller($this$computeCallerForAccessor, isGetter, ((JvmPropertySignature.JavaField)jvmSignature).getField());
        } else if (jvmPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) {
            Method method;
            if (isGetter) {
                method = ((JvmPropertySignature.JavaMethodProperty)jvmSignature).getGetterMethod();
            } else {
                method = ((JvmPropertySignature.JavaMethodProperty)jvmSignature).getSetterMethod();
                if (method == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + ((JvmPropertySignature.JavaMethodProperty)jvmSignature).getGetterMethod());
                }
            }
            Method method2 = method;
            caller = $this$computeCallerForAccessor.isBound() ? (CallerImpl.Method)new CallerImpl.Method.BoundInstance(method2, KPropertyImplKt.getBoundReceiver($this$computeCallerForAccessor)) : (CallerImpl.Method)new CallerImpl.Method.Instance(method2);
        } else {
            if (jvmPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty) {
                boolean bl4;
                JvmFunctionSignature.KotlinFunction kotlinFunction;
                if (isGetter) {
                    kotlinFunction = ((JvmPropertySignature.MappedKotlinProperty)jvmSignature).getGetterSignature();
                } else {
                    kotlinFunction = ((JvmPropertySignature.MappedKotlinProperty)jvmSignature).getSetterSignature();
                    if (kotlinFunction == null) {
                        throw new KotlinReflectionInternalError("No setter found for property " + $this$computeCallerForAccessor.getProperty());
                    }
                }
                JvmFunctionSignature.KotlinFunction signature = kotlinFunction;
                Method method = $this$computeCallerForAccessor.getProperty().getContainer().findMethodBySignature(signature.getMethodName(), signature.getMethodDesc());
                if (method == null) {
                    throw new KotlinReflectionInternalError("No accessor found for property " + $this$computeCallerForAccessor.getProperty());
                }
                Method accessor = method;
                boolean bl5 = bl4 = !Modifier.isStatic(accessor.getModifiers());
                if (_Assertions.ENABLED && !bl4) {
                    boolean bl6 = false;
                    String string = "Mapped property cannot have a static accessor: " + $this$computeCallerForAccessor.getProperty();
                    throw new AssertionError((Object)string);
                }
                return $this$computeCallerForAccessor.isBound() ? (Caller)new CallerImpl.Method.BoundInstance(accessor, KPropertyImplKt.getBoundReceiver($this$computeCallerForAccessor)) : (Caller)new CallerImpl.Method.Instance(accessor);
            }
            throw new NoWhenBranchMatchedException();
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded$default(caller, $this$computeCallerForAccessor.getDescriptor(), false, 2, null);
    }

    private static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor $this$isJvmFieldPropertyInCompanionObject) {
        DeclarationDescriptor declarationDescriptor = $this$isJvmFieldPropertyInCompanionObject.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
        DeclarationDescriptor container = declarationDescriptor;
        if (!DescriptorUtils.isCompanionObject(container)) {
            return false;
        }
        DeclarationDescriptor outerClass = container.getContainingDeclaration();
        return DescriptorUtils.isInterface(outerClass) || DescriptorUtils.isAnnotationClass(outerClass) ? $this$isJvmFieldPropertyInCompanionObject instanceof DeserializedPropertyDescriptor && JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor)$this$isJvmFieldPropertyInCompanionObject).getProto()) : true;
    }

    private static final boolean computeCallerForAccessor$isJvmStaticProperty(KPropertyImpl.Accessor<?, ?> $this_computeCallerForAccessor) {
        return $this_computeCallerForAccessor.getProperty().getDescriptor().getAnnotations().hasAnnotation(UtilKt.getJVM_STATIC());
    }

    private static final boolean computeCallerForAccessor$isNotNullProperty(KPropertyImpl.Accessor<?, ?> $this_computeCallerForAccessor) {
        return !TypeUtils.isNullableType($this_computeCallerForAccessor.getProperty().getDescriptor().getType());
    }

    private static final CallerImpl<Field> computeCallerForAccessor$computeFieldCaller(KPropertyImpl.Accessor<?, ?> $this_computeCallerForAccessor, boolean $isGetter, Field field) {
        return KPropertyImplKt.isJvmFieldPropertyInCompanionObject($this_computeCallerForAccessor.getProperty().getDescriptor()) || !Modifier.isStatic(field.getModifiers()) ? ($isGetter ? (CallerImpl)($this_computeCallerForAccessor.isBound() ? (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.BoundInstance(field, KPropertyImplKt.getBoundReceiver($this_computeCallerForAccessor)) : (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.Instance(field)) : ($this_computeCallerForAccessor.isBound() ? (CallerImpl)new CallerImpl.FieldSetter.BoundInstance(field, KPropertyImplKt.computeCallerForAccessor$isNotNullProperty($this_computeCallerForAccessor), KPropertyImplKt.getBoundReceiver($this_computeCallerForAccessor)) : (CallerImpl)new CallerImpl.FieldSetter.Instance(field, KPropertyImplKt.computeCallerForAccessor$isNotNullProperty($this_computeCallerForAccessor)))) : (KPropertyImplKt.computeCallerForAccessor$isJvmStaticProperty($this_computeCallerForAccessor) ? ($isGetter ? (CallerImpl)($this_computeCallerForAccessor.isBound() ? (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.BoundJvmStaticInObject(field) : (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.JvmStaticInObject(field)) : ($this_computeCallerForAccessor.isBound() ? (CallerImpl)new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, KPropertyImplKt.computeCallerForAccessor$isNotNullProperty($this_computeCallerForAccessor)) : (CallerImpl)new CallerImpl.FieldSetter.JvmStaticInObject(field, KPropertyImplKt.computeCallerForAccessor$isNotNullProperty($this_computeCallerForAccessor)))) : ($isGetter ? (CallerImpl)new CallerImpl.FieldGetter.Static(field) : (CallerImpl)new CallerImpl.FieldSetter.Static(field, KPropertyImplKt.computeCallerForAccessor$isNotNullProperty($this_computeCallerForAccessor))));
    }

    public static final /* synthetic */ Caller access$computeCallerForAccessor(KPropertyImpl.Accessor $receiver, boolean isGetter) {
        return KPropertyImplKt.computeCallerForAccessor($receiver, isGetter);
    }
}

