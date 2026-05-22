/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class BuiltInAnnotationDescriptor
implements AnnotationDescriptor {
    @NotNull
    private final KotlinBuiltIns builtIns;
    @NotNull
    private final FqName fqName;
    @NotNull
    private final Map<Name, ConstantValue<?>> allValueArguments;
    private final boolean forcePropagationDeprecationToOverrides;
    @NotNull
    private final Lazy type$delegate;

    public BuiltInAnnotationDescriptor(@NotNull KotlinBuiltIns builtIns, @NotNull FqName fqName, @NotNull Map<Name, ? extends ConstantValue<?>> allValueArguments, boolean forcePropagationDeprecationToOverrides) {
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(allValueArguments, "allValueArguments");
        this.builtIns = builtIns;
        this.fqName = fqName;
        this.allValueArguments = allValueArguments;
        this.forcePropagationDeprecationToOverrides = forcePropagationDeprecationToOverrides;
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = this;
        this.type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BuiltInAnnotationDescriptor$$Lambda$0(builtInAnnotationDescriptor));
    }

    public /* synthetic */ BuiltInAnnotationDescriptor(KotlinBuiltIns kotlinBuiltIns, FqName fqName, Map map, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        this(kotlinBuiltIns, fqName, map, bl2);
    }

    @Override
    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    @Override
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return this.allValueArguments;
    }

    @Override
    @NotNull
    public KotlinType getType() {
        Lazy lazy = this.type$delegate;
        Object t2 = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
        return (KotlinType)t2;
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    private static final SimpleType type_delegate$lambda$0(BuiltInAnnotationDescriptor this$0) {
        return this$0.builtIns.getBuiltInClassByFqName(this$0.getFqName()).getDefaultType();
    }

    static /* synthetic */ SimpleType accessor$BuiltInAnnotationDescriptor$lambda0(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        return BuiltInAnnotationDescriptor.type_delegate$lambda$0(builtInAnnotationDescriptor);
    }
}

