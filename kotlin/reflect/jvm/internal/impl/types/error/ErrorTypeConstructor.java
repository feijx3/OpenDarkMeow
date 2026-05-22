/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class ErrorTypeConstructor
implements TypeConstructor {
    @NotNull
    private final ErrorTypeKind kind;
    @NotNull
    private final String[] formatParams;
    @NotNull
    private final String debugText;

    public ErrorTypeConstructor(@NotNull ErrorTypeKind kind2, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        this.kind = kind2;
        this.formatParams = formatParams;
        String string = ErrorEntity.ERROR_TYPE.getDebugText();
        Object[] objectArray = new Object[1];
        String string2 = this.kind.getDebugMessage();
        String[] stringArray = this.formatParams;
        stringArray = Arrays.copyOf(stringArray, stringArray.length);
        Intrinsics.checkNotNullExpressionValue(String.format(string2, Arrays.copyOf(stringArray, stringArray.length)), "format(...)");
        String string3 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string3, "format(...)");
        this.debugText = string3;
    }

    @NotNull
    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    @NotNull
    public final String getParam(int i2) {
        return this.formatParams[i2];
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        return CollectionsKt.emptyList();
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Override
    @NotNull
    public ClassifierDescriptor getDeclarationDescriptor() {
        return ErrorUtils.INSTANCE.getErrorClass();
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return DefaultBuiltIns.Companion.getInstance();
    }

    @NotNull
    public String toString() {
        return this.debugText;
    }

    @Override
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}

