/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public class ErrorScope
implements MemberScope {
    @NotNull
    private final ErrorScopeKind kind;
    @NotNull
    private final String debugMessage;

    public ErrorScope(@NotNull ErrorScopeKind kind2, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        this.kind = kind2;
        String[] stringArray = Arrays.copyOf(formatParams, formatParams.length);
        String string = String.format(this.kind.getDebugMessage(), Arrays.copyOf(stringArray, stringArray.length));
        Intrinsics.checkNotNullExpressionValue(string, "format(...)");
        this.debugMessage = string;
    }

    @NotNull
    protected final String getDebugMessage() {
        return this.debugMessage;
    }

    @Override
    @NotNull
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        String string = ErrorEntity.ERROR_CLASS.getDebugText();
        Object[] objectArray = new Object[]{name};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(...)");
        Name name2 = Name.special(string2);
        Intrinsics.checkNotNullExpressionValue(name2, "special(...)");
        return new ErrorClassDescriptor(name2);
    }

    @NotNull
    public Set<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return ErrorUtils.INSTANCE.getErrorPropertyGroup();
    }

    @NotNull
    public Set<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return SetsKt.setOf(new ErrorFunctionDescriptor(ErrorUtils.INSTANCE.getErrorClass()));
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return SetsKt.emptySet();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return SetsKt.emptySet();
    }

    @Override
    @NotNull
    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    @Override
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
    }

    @NotNull
    public String toString() {
        return "ErrorScope{" + this.debugMessage + '}';
    }
}

