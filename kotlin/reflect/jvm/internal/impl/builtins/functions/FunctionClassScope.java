/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class FunctionClassScope
extends GivenFunctionsMemberScope {
    public FunctionClassScope(@NotNull StorageManager storageManager, @NotNull FunctionClassDescriptor containingClass) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        super(storageManager, containingClass);
    }

    @Override
    @NotNull
    protected List<FunctionDescriptor> computeDeclaredFunctions() {
        ClassDescriptor classDescriptor = this.getContainingClass();
        Intrinsics.checkNotNull(classDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        FunctionTypeKind functionTypeKind = ((FunctionClassDescriptor)classDescriptor).getFunctionTypeKind();
        return Intrinsics.areEqual(functionTypeKind, FunctionTypeKind.Function.INSTANCE) ? CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor)this.getContainingClass(), false)) : (Intrinsics.areEqual(functionTypeKind, FunctionTypeKind.SuspendFunction.INSTANCE) ? CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor)this.getContainingClass(), true)) : CollectionsKt.emptyList());
    }
}

