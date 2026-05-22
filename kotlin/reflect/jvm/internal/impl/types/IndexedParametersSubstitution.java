/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nTypeSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/IndexedParametersSubstitution\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,207:1\n37#2:208\n36#2,3:209\n*S KotlinDebug\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/IndexedParametersSubstitution\n*L\n127#1:208\n127#1:209,3\n*E\n"})
public final class IndexedParametersSubstitution
extends TypeSubstitution {
    @NotNull
    private final TypeParameterDescriptor[] parameters;
    @NotNull
    private final TypeProjection[] arguments;
    private final boolean approximateContravariantCapturedTypes;

    public IndexedParametersSubstitution(@NotNull TypeParameterDescriptor[] parameters, @NotNull TypeProjection[] arguments, boolean approximateContravariantCapturedTypes) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.parameters = parameters;
        this.arguments = arguments;
        this.approximateContravariantCapturedTypes = approximateContravariantCapturedTypes;
        boolean bl3 = bl2 = this.parameters.length <= this.arguments.length;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Number of arguments should not be less than number of parameters, but: parameters=" + this.parameters.length + ", args=" + this.arguments.length;
            throw new AssertionError((Object)string);
        }
    }

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArray, TypeProjection[] typeProjectionArray, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        this(typeParameterDescriptorArray, typeProjectionArray, bl2);
    }

    @NotNull
    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @NotNull
    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public IndexedParametersSubstitution(@NotNull List<? extends TypeParameterDescriptor> parameters, @NotNull List<? extends TypeProjection> argumentsList) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(argumentsList, "argumentsList");
        Collection $this$toTypedArray$iv = parameters;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        $this$toTypedArray$iv = argumentsList;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        this(thisCollection$iv.toArray(new TypeParameterDescriptor[0]), thisCollection$iv.toArray(new TypeProjection[0]), false, 4, null);
    }

    @Override
    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    @Override
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Override
    @Nullable
    public TypeProjection get(@NotNull KotlinType key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ClassifierDescriptor classifierDescriptor = key.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = classifierDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor)classifierDescriptor : null;
        if (typeParameterDescriptor == null) {
            return null;
        }
        TypeParameterDescriptor parameter = typeParameterDescriptor;
        int index = parameter.getIndex();
        if (index < this.parameters.length && Intrinsics.areEqual(this.parameters[index].getTypeConstructor(), parameter.getTypeConstructor())) {
            return this.arguments[index];
        }
        return null;
    }
}

