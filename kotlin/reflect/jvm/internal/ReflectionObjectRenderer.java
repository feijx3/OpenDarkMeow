/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KParameterImpl;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$0;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$1;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u0007*\u00060\bj\u0002`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u0007*\u00060\bj\u0002`\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "<init>", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderCallable", "", "descriptor", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "kotlin-reflection"})
public final class ReflectionObjectRenderer {
    @NotNull
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    @NotNull
    private static final DescriptorRenderer renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    private ReflectionObjectRenderer() {
    }

    private final void appendReceiverType(StringBuilder $this$appendReceiverType, ReceiverParameterDescriptor receiver) {
        if (receiver != null) {
            KotlinType kotlinType = receiver.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            $this$appendReceiverType.append(this.renderType(kotlinType));
            $this$appendReceiverType.append(".");
        }
    }

    private final void appendReceivers(StringBuilder $this$appendReceivers, CallableDescriptor callable) {
        boolean addParentheses;
        ReceiverParameterDescriptor dispatchReceiver = UtilKt.getInstanceReceiverParameter(callable);
        ReceiverParameterDescriptor extensionReceiver = callable.getExtensionReceiverParameter();
        this.appendReceiverType($this$appendReceivers, dispatchReceiver);
        boolean bl2 = addParentheses = dispatchReceiver != null && extensionReceiver != null;
        if (addParentheses) {
            $this$appendReceivers.append("(");
        }
        this.appendReceiverType($this$appendReceivers, extensionReceiver);
        if (addParentheses) {
            $this$appendReceivers.append(")");
        }
    }

    private final String renderCallable(CallableDescriptor descriptor2) {
        String string;
        CallableDescriptor callableDescriptor = descriptor2;
        if (callableDescriptor instanceof PropertyDescriptor) {
            string = this.renderProperty((PropertyDescriptor)descriptor2);
        } else if (callableDescriptor instanceof FunctionDescriptor) {
            string = this.renderFunction((FunctionDescriptor)descriptor2);
        } else {
            throw new IllegalStateException(("Illegal callable: " + descriptor2).toString());
        }
        return string;
    }

    @NotNull
    public final String renderProperty(@NotNull PropertyDescriptor descriptor2) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        StringBuilder $this$renderProperty_u24lambda_u240 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        $this$renderProperty_u24lambda_u240.append(descriptor2.isVar() ? "var " : "val ");
        INSTANCE.appendReceivers($this$renderProperty_u24lambda_u240, descriptor2);
        Name name = descriptor2.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        $this$renderProperty_u24lambda_u240.append(renderer.renderName(name, true));
        $this$renderProperty_u24lambda_u240.append(": ");
        KotlinType kotlinType = descriptor2.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        $this$renderProperty_u24lambda_u240.append(INSTANCE.renderType(kotlinType));
        return stringBuilder.toString();
    }

    @NotNull
    public final String renderFunction(@NotNull FunctionDescriptor descriptor2) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        StringBuilder $this$renderFunction_u24lambda_u242 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        $this$renderFunction_u24lambda_u242.append("fun ");
        INSTANCE.appendReceivers($this$renderFunction_u24lambda_u242, descriptor2);
        Name name = descriptor2.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        $this$renderFunction_u24lambda_u242.append(renderer.renderName(name, true));
        List<ValueParameterDescriptor> list = descriptor2.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        CollectionsKt.joinTo$default(list, $this$renderFunction_u24lambda_u242, ", ", "(", ")", 0, null, ReflectionObjectRenderer$$Lambda$0.INSTANCE, 48, null);
        $this$renderFunction_u24lambda_u242.append(": ");
        KotlinType kotlinType = descriptor2.getReturnType();
        Intrinsics.checkNotNull(kotlinType);
        $this$renderFunction_u24lambda_u242.append(INSTANCE.renderType(kotlinType));
        return stringBuilder.toString();
    }

    @NotNull
    public final String renderLambda(@NotNull FunctionDescriptor invoke) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        StringBuilder $this$renderLambda_u24lambda_u244 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        INSTANCE.appendReceivers($this$renderLambda_u24lambda_u244, invoke);
        List<ValueParameterDescriptor> list = invoke.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        CollectionsKt.joinTo$default(list, $this$renderLambda_u24lambda_u244, ", ", "(", ")", 0, null, ReflectionObjectRenderer$$Lambda$1.INSTANCE, 48, null);
        $this$renderLambda_u24lambda_u244.append(" -> ");
        KotlinType kotlinType = invoke.getReturnType();
        Intrinsics.checkNotNull(kotlinType);
        $this$renderLambda_u24lambda_u244.append(INSTANCE.renderType(kotlinType));
        return stringBuilder.toString();
    }

    @NotNull
    public final String renderParameter(@NotNull KParameterImpl parameter) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        StringBuilder $this$renderParameter_u24lambda_u245 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        switch (WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()]) {
            case 1: {
                StringBuilder stringBuilder2 = $this$renderParameter_u24lambda_u245.append("extension receiver parameter");
                break;
            }
            case 2: {
                StringBuilder stringBuilder2 = $this$renderParameter_u24lambda_u245.append("instance parameter");
                break;
            }
            case 3: {
                StringBuilder stringBuilder2 = $this$renderParameter_u24lambda_u245.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        $this$renderParameter_u24lambda_u245.append(" of ");
        $this$renderParameter_u24lambda_u245.append(INSTANCE.renderCallable(parameter.getCallable().getDescriptor()));
        return stringBuilder.toString();
    }

    @NotNull
    public final String renderType(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return renderer.renderType(type);
    }

    private static final CharSequence renderFunction$lambda$2$lambda$1(ValueParameterDescriptor it) {
        KotlinType kotlinType = it.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return INSTANCE.renderType(kotlinType);
    }

    private static final CharSequence renderLambda$lambda$4$lambda$3(ValueParameterDescriptor it) {
        KotlinType kotlinType = it.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return INSTANCE.renderType(kotlinType);
    }

    static /* synthetic */ CharSequence accessor$ReflectionObjectRenderer$lambda0(ValueParameterDescriptor valueParameterDescriptor) {
        return ReflectionObjectRenderer.renderFunction$lambda$2$lambda$1(valueParameterDescriptor);
    }

    static /* synthetic */ CharSequence accessor$ReflectionObjectRenderer$lambda1(ValueParameterDescriptor valueParameterDescriptor) {
        return ReflectionObjectRenderer.renderLambda$lambda$4$lambda$3(valueParameterDescriptor);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[KParameter.Kind.values().length];
            try {
                nArray[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KParameter.Kind.INSTANCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[KParameter.Kind.VALUE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

