/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nValueParameterDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueParameterDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ValueParameterDescriptorImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1563#2:135\n1634#2,3:136\n*S KotlinDebug\n*F\n+ 1 ValueParameterDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ValueParameterDescriptorImpl\n*L\n129#1:135\n129#1:136,3\n*E\n"})
public class ValueParameterDescriptorImpl
extends VariableDescriptorImpl
implements ValueParameterDescriptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int index;
    private final boolean declaresDefaultValue;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    @Nullable
    private final KotlinType varargElementType;
    @NotNull
    private final ValueParameterDescriptor original;

    public ValueParameterDescriptorImpl(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations, @NotNull Name name, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source) {
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(outType, "outType");
        Intrinsics.checkNotNullParameter(source, "source");
        super(containingDeclaration, annotations, name, outType, source);
        this.index = index;
        this.declaresDefaultValue = declaresDefaultValue;
        this.isCrossinline = isCrossinline;
        this.isNoinline = isNoinline;
        this.varargElementType = varargElementType;
        ValueParameterDescriptor valueParameterDescriptor = original;
        if (valueParameterDescriptor == null) {
            valueParameterDescriptor = this;
        }
        this.original = valueParameterDescriptor;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    @Override
    public boolean isNoinline() {
        return this.isNoinline;
    }

    @Override
    @Nullable
    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    @Override
    @NotNull
    public CallableDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = super.getContainingDeclaration();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (CallableDescriptor)declarationDescriptor;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean declaresDefaultValue() {
        if (!this.declaresDefaultValue) return false;
        CallableDescriptor callableDescriptor = this.getContainingDeclaration();
        Intrinsics.checkNotNull(callableDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        if (!((CallableMemberDescriptor)callableDescriptor).getKind().isReal()) return false;
        return true;
    }

    @Override
    @NotNull
    public ValueParameterDescriptor getOriginal() {
        return this.original == this ? (ValueParameterDescriptor)this : this.original.getOriginal();
    }

    @Override
    @NotNull
    public ValueParameterDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        if (substitutor.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        Intrinsics.checkNotNullParameter(visitor2, "visitor");
        return visitor2.visitValueParameterDescriptor(this, data);
    }

    @Override
    public boolean isVar() {
        return false;
    }

    @Nullable
    public Void getCompileTimeInitializer() {
        return null;
    }

    @Override
    @NotNull
    public ValueParameterDescriptor copy(@NotNull CallableDescriptor newOwner, @NotNull Name newName, int newIndex) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(newName, "newName");
        Annotations annotations = this.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
        KotlinType kotlinType = this.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        boolean bl2 = this.declaresDefaultValue();
        boolean bl3 = this.isCrossinline();
        boolean bl4 = this.isNoinline();
        KotlinType kotlinType2 = this.getVarargElementType();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(newOwner, null, newIndex, annotations, newName, kotlinType, bl2, bl3, bl4, kotlinType2, sourceElement);
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.LOCAL;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "LOCAL");
        return descriptorVisibility;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        void $this$mapTo$iv$iv;
        Collection<? extends CallableDescriptor> collection = this.getContainingDeclaration().getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
        Iterable $this$map$iv = collection;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            CallableDescriptor callableDescriptor = (CallableDescriptor)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl2 = false;
            collection2.add(it.getValueParameters().get(this.getIndex()));
        }
        return (List)destination$iv$iv;
    }

    @Override
    public boolean isLateInit() {
        return ValueParameterDescriptor.DefaultImpls.isLateInit(this);
    }

    @JvmStatic
    @NotNull
    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations, @NotNull Name name, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source, @Nullable Function0<? extends List<? extends VariableDescriptor>> destructuringVariables) {
        return Companion.createWithDestructuringDeclarations(containingDeclaration, original, index, annotations, name, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source, destructuringVariables);
    }

    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations, @NotNull Name name, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source, @Nullable Function0<? extends List<? extends VariableDescriptor>> destructuringVariables) {
            Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(outType, "outType");
            Intrinsics.checkNotNullParameter(source, "source");
            return destructuringVariables == null ? new ValueParameterDescriptorImpl(containingDeclaration, original, index, annotations, name, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source) : (ValueParameterDescriptorImpl)new WithDestructuringDeclaration(containingDeclaration, original, index, annotations, name, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source, destructuringVariables);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public static final class WithDestructuringDeclaration
    extends ValueParameterDescriptorImpl {
        @NotNull
        private final Lazy destructuringVariables$delegate;

        public WithDestructuringDeclaration(@NotNull CallableDescriptor containingDeclaration, @Nullable ValueParameterDescriptor original, int index, @NotNull Annotations annotations, @NotNull Name name, @NotNull KotlinType outType, boolean declaresDefaultValue, boolean isCrossinline, boolean isNoinline, @Nullable KotlinType varargElementType, @NotNull SourceElement source, @NotNull Function0<? extends List<? extends VariableDescriptor>> destructuringVariables) {
            Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(outType, "outType");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(destructuringVariables, "destructuringVariables");
            super(containingDeclaration, original, index, annotations, name, outType, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, source);
            this.destructuringVariables$delegate = LazyKt.lazy(destructuringVariables);
        }

        @NotNull
        public final List<VariableDescriptor> getDestructuringVariables() {
            Lazy lazy = this.destructuringVariables$delegate;
            return (List)lazy.getValue();
        }

        @Override
        @NotNull
        public ValueParameterDescriptor copy(@NotNull CallableDescriptor newOwner, @NotNull Name newName, int newIndex) {
            Intrinsics.checkNotNullParameter(newOwner, "newOwner");
            Intrinsics.checkNotNullParameter(newName, "newName");
            Annotations annotations = this.getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
            KotlinType kotlinType = this.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            boolean bl2 = this.declaresDefaultValue();
            boolean bl3 = this.isCrossinline();
            boolean bl4 = this.isNoinline();
            KotlinType kotlinType2 = this.getVarargElementType();
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            WithDestructuringDeclaration withDestructuringDeclaration = this;
            return new WithDestructuringDeclaration(newOwner, null, newIndex, annotations, newName, kotlinType, bl2, bl3, bl4, kotlinType2, sourceElement, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$$Lambda$0(withDestructuringDeclaration));
        }

        private static final List copy$lambda$0(WithDestructuringDeclaration this$0) {
            return this$0.getDestructuringVariables();
        }

        static /* synthetic */ List accessor$ValueParameterDescriptorImpl$WithDestructuringDeclaration$lambda0(WithDestructuringDeclaration withDestructuringDeclaration) {
            return WithDestructuringDeclaration.copy$lambda$0(withDestructuringDeclaration);
        }
    }
}

