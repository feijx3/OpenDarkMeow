/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nFunctionInvokeDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n2746#2,3:162\n1563#2:165\n1634#2,3:166\n1740#2,3:169\n1563#2:172\n1634#2,3:173\n1761#2,3:176\n*S KotlinDebug\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor\n*L\n63#1:162,3\n64#1:165\n64#1:166,3\n88#1:169,3\n92#1:172\n92#1:173,3\n106#1:176,3\n*E\n"})
public final class FunctionInvokeDescriptor
extends SimpleFunctionDescriptorImpl {
    @NotNull
    public static final Factory Factory = new Factory(null);

    private FunctionInvokeDescriptor(DeclarationDescriptor container, FunctionInvokeDescriptor original, CallableMemberDescriptor.Kind callableKind, boolean isSuspend) {
        super(container, original, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, callableKind, SourceElement.NO_SOURCE);
        this.setOperator(true);
        this.setSuspend(isSuspend);
        this.setHasStableParameterNames(false);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    protected FunctionDescriptor doSubstitute(@NotNull FunctionDescriptorImpl.CopyConfiguration configuration) {
        void $this$mapTo$iv$iv;
        Object element$iv2;
        boolean bl2;
        FunctionInvokeDescriptor substituted;
        block6: {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor)super.doSubstitute(configuration);
            if (functionInvokeDescriptor == null) {
                return null;
            }
            substituted = functionInvokeDescriptor;
            List<ValueParameterDescriptor> list = substituted.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Iterable $this$none$iv = list;
            boolean $i$f$none = false;
            if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv2 : $this$none$iv) {
                    ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv2;
                    boolean bl3 = false;
                    KotlinType kotlinType = it.getType();
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                    if (!(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(kotlinType) != null)) continue;
                    bl2 = false;
                    break block6;
                }
                bl2 = true;
            }
        }
        if (bl2) {
            return substituted;
        }
        List<ValueParameterDescriptor> list = substituted.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        element$iv2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl4 = false;
            KotlinType kotlinType = it.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            collection.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(kotlinType));
        }
        List parameterNames = (List)destination$iv$iv;
        return substituted.replaceParameterNames(parameterNames);
    }

    @Override
    @NotNull
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind2, @Nullable Name newName, @NotNull Annotations annotations, @NotNull SourceElement source) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(source, "source");
        return new FunctionInvokeDescriptor(newOwner, (FunctionInvokeDescriptor)original, kind2, this.isSuspend());
    }

    @Override
    public boolean isExternal() {
        return false;
    }

    @Override
    public boolean isInline() {
        return false;
    }

    @Override
    public boolean isTailrec() {
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private final FunctionDescriptor replaceParameterNames(List<Name> parameterNames) {
        boolean bl2;
        List newValueParameters;
        Object object;
        block12: {
            void $this$any$iv;
            Iterable $this$mapTo$iv$iv;
            Iterable element$iv2;
            boolean bl3;
            int indexShift = this.getValueParameters().size() - parameterNames.size();
            boolean bl4 = bl3 = indexShift == 0 || indexShift == 1;
            if (_Assertions.ENABLED && !bl3) {
                String string = "Assertion failed";
                throw new AssertionError((Object)string);
            }
            if (indexShift == 0) {
                boolean bl5;
                block11: {
                    Iterable iterable = parameterNames;
                    List<ValueParameterDescriptor> list = this.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
                    Iterable $this$all$iv = CollectionsKt.zip(iterable, (Iterable)list);
                    boolean $i$f$all = false;
                    if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                        bl5 = true;
                    } else {
                        for (Iterable element$iv2 : $this$all$iv) {
                            ValueParameterDescriptor parameter;
                            Pair pair = (Pair)((Object)element$iv2);
                            boolean bl6 = false;
                            Name name = (Name)pair.component1();
                            if (Intrinsics.areEqual(name, (parameter = (ValueParameterDescriptor)pair.component2()).getName())) continue;
                            bl5 = false;
                            break block11;
                        }
                        bl5 = true;
                    }
                }
                if (bl5) {
                    return this;
                }
            }
            List<ValueParameterDescriptor> list = this.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            element$iv2 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Name newName;
                Name parameterName;
                void it;
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv$iv;
                object = destination$iv$iv;
                boolean bl7 = false;
                Intrinsics.checkNotNullExpressionValue(it.getName(), "getName(...)");
                int parameterIndex = it.getIndex();
                int nameIndex = parameterIndex - indexShift;
                if (nameIndex >= 0 && (parameterName = parameterNames.get(nameIndex)) != null) {
                    newName = parameterName;
                }
                object.add(it.copy(this, newName, parameterIndex));
            }
            newValueParameters = (List)destination$iv$iv;
            $this$mapTo$iv$iv = parameterNames;
            object = this.newCopyBuilder(TypeSubstitutor.EMPTY);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv3 : $this$any$iv) {
                    Name it = (Name)element$iv3;
                    boolean bl8 = false;
                    if (!(it == null)) continue;
                    bl2 = true;
                    break block12;
                }
                bl2 = false;
            }
        }
        boolean bl9 = bl2;
        FunctionDescriptorImpl.CopyConfiguration copyConfiguration = ((FunctionDescriptorImpl.CopyConfiguration)((FunctionDescriptorImpl.CopyConfiguration)object).setHasSynthesizedParameterNames(bl9).setValueParameters(newValueParameters)).setOriginal(this.getOriginal());
        Intrinsics.checkNotNullExpressionValue(copyConfiguration, "setOriginal(...)");
        FunctionDescriptorImpl.CopyConfiguration copyConfiguration2 = copyConfiguration;
        FunctionDescriptor functionDescriptor = super.doSubstitute(copyConfiguration2);
        Intrinsics.checkNotNull(functionDescriptor);
        return functionDescriptor;
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor container, FunctionInvokeDescriptor original, CallableMemberDescriptor.Kind callableKind, boolean isSuspend, DefaultConstructorMarker $constructor_marker) {
        this(container, original, callableKind, isSuspend);
    }

    @SourceDebugExtension(value={"SMAP\nFunctionInvokeDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor$Factory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n967#2,7:162\n1563#2:169\n1634#2,3:170\n*S KotlinDebug\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor$Factory\n*L\n122#1:162,7\n124#1:169\n124#1:170,3\n*E\n"})
    public static final class Factory {
        private Factory() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final FunctionInvokeDescriptor create(@NotNull FunctionClassDescriptor functionClass, boolean isSuspend) {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Iterable $this$takeWhile$iv;
            Intrinsics.checkNotNullParameter(functionClass, "functionClass");
            List<TypeParameterDescriptor> typeParameters = functionClass.getDeclaredTypeParameters();
            FunctionInvokeDescriptor result = new FunctionInvokeDescriptor(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, isSuspend, null);
            Iterable iterable = typeParameters;
            List list = CollectionsKt.emptyList();
            List list2 = CollectionsKt.emptyList();
            ReceiverParameterDescriptor receiverParameterDescriptor = functionClass.getThisAsReceiverParameter();
            ReceiverParameterDescriptor receiverParameterDescriptor2 = null;
            FunctionInvokeDescriptor functionInvokeDescriptor = result;
            boolean $i$f$takeWhile = false;
            ArrayList list$iv = new ArrayList();
            for (Object t2 : $this$takeWhile$iv) {
                TypeParameterDescriptor it = (TypeParameterDescriptor)t2;
                boolean bl2 = false;
                if (!(it.getVariance() == Variance.IN_VARIANCE)) break;
                list$iv.add(t2);
            }
            Collection<ValueParameterDescriptor> collection = list$iv;
            $this$takeWhile$iv = CollectionsKt.withIndex((Iterable)collection);
            boolean $i$f$map = false;
            list$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean bl2 = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                IndexedValue indexedValue = (IndexedValue)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add(Factory.createValueParameter(result, it.getIndex(), (TypeParameterDescriptor)it.getValue()));
            }
            collection = (List)destination$iv$iv;
            functionInvokeDescriptor.initialize(receiverParameterDescriptor2, receiverParameterDescriptor, list2, list, (List)collection, (KotlinType)CollectionsKt.last(typeParameters).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            result.setHasSynthesizedParameterNames(true);
            return result;
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor containingDeclaration, int index, TypeParameterDescriptor typeParameter) {
            String string;
            String string2 = typeParameter.getName().asString();
            Intrinsics.checkNotNullExpressionValue(string2, "asString(...)");
            String typeParameterName = string2;
            if (Intrinsics.areEqual(typeParameterName, "T")) {
                string = "instance";
            } else if (Intrinsics.areEqual(typeParameterName, "E")) {
                string = "receiver";
            } else {
                String string3 = typeParameterName.toLowerCase(Locale.ROOT);
                string = string3;
                Intrinsics.checkNotNullExpressionValue(string3, "toLowerCase(...)");
            }
            String name = string;
            CallableDescriptor callableDescriptor = containingDeclaration;
            Annotations annotations = Annotations.Companion.getEMPTY();
            Name name2 = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
            SimpleType simpleType = typeParameter.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
            KotlinType kotlinType = simpleType;
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(callableDescriptor, null, index, annotations, name2, kotlinType, false, false, false, null, sourceElement);
        }

        public /* synthetic */ Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

