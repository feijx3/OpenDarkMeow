/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScope;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ThrowingScope;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErrorUtils {
    @NotNull
    public static final ErrorUtils INSTANCE = new ErrorUtils();
    @NotNull
    private static final ModuleDescriptor errorModule = ErrorModuleDescriptor.INSTANCE;
    @NotNull
    private static final ErrorClassDescriptor errorClass;
    @NotNull
    private static final KotlinType errorTypeForLoopInSupertypes;
    @NotNull
    private static final KotlinType errorPropertyType;
    @NotNull
    private static final PropertyDescriptor errorProperty;
    @NotNull
    private static final Set<PropertyDescriptor> errorPropertyGroup;

    private ErrorUtils() {
    }

    @NotNull
    public final ModuleDescriptor getErrorModule() {
        return errorModule;
    }

    @NotNull
    public final ErrorClassDescriptor getErrorClass() {
        return errorClass;
    }

    @NotNull
    public final KotlinType getErrorTypeForLoopInSupertypes() {
        return errorTypeForLoopInSupertypes;
    }

    @NotNull
    public final KotlinType getErrorPropertyType() {
        return errorPropertyType;
    }

    @NotNull
    public final Set<PropertyDescriptor> getErrorPropertyGroup() {
        return errorPropertyGroup;
    }

    @JvmStatic
    @NotNull
    public static final ErrorScope createErrorScope(@NotNull ErrorScopeKind kind2, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return ErrorUtils.createErrorScope(kind2, false, Arrays.copyOf(formatParams, formatParams.length));
    }

    @JvmStatic
    @NotNull
    public static final ErrorScope createErrorScope(@NotNull ErrorScopeKind kind2, boolean throwExceptions, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return throwExceptions ? (ErrorScope)new ThrowingScope(kind2, Arrays.copyOf(formatParams, formatParams.length)) : new ErrorScope(kind2, Arrays.copyOf(formatParams, formatParams.length));
    }

    @JvmStatic
    @NotNull
    public static final ErrorType createErrorType(@NotNull ErrorTypeKind kind2, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(kind2, CollectionsKt.emptyList(), Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorType createErrorType(@NotNull ErrorTypeKind kind2, @NotNull TypeConstructor typeConstructor2, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(typeConstructor2, "typeConstructor");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return this.createErrorTypeWithArguments(kind2, CollectionsKt.emptyList(), typeConstructor2, Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorType createErrorTypeWithArguments(@NotNull ErrorTypeKind kind2, @NotNull List<? extends TypeProjection> arguments, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return this.createErrorTypeWithArguments(kind2, arguments, this.createErrorTypeConstructor(kind2, Arrays.copyOf(formatParams, formatParams.length)), Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorType createErrorTypeWithArguments(@NotNull ErrorTypeKind kind2, @NotNull List<? extends TypeProjection> arguments, @NotNull TypeConstructor typeConstructor2, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(typeConstructor2, "typeConstructor");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        String[] stringArray = new String[]{typeConstructor2.toString()};
        return new ErrorType(typeConstructor2, (MemberScope)ErrorUtils.createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, stringArray), kind2, arguments, false, Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorTypeConstructor createErrorTypeConstructor(@NotNull ErrorTypeKind kind2, String ... formatParams) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return new ErrorTypeConstructor(kind2, Arrays.copyOf(formatParams, formatParams.length));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static final boolean isError(@Nullable DeclarationDescriptor candidate) {
        if (candidate == null) return false;
        if (INSTANCE.isErrorClass(candidate)) return true;
        if (INSTANCE.isErrorClass(candidate.getContainingDeclaration())) return true;
        if (candidate != errorModule) return false;
        return true;
    }

    private final boolean isErrorClass(DeclarationDescriptor candidate) {
        return candidate instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(@Nullable KotlinType type) {
        if (type == null) {
            return false;
        }
        TypeConstructor constructor = type.getConstructor();
        return constructor instanceof ErrorTypeConstructor && ((ErrorTypeConstructor)constructor).getKind() == ErrorTypeKind.UNINFERRED_TYPE_VARIABLE;
    }

    @NotNull
    public final String unresolvedTypeAsItIs(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        boolean bl2 = TypeUtilsKt.isUnresolvedType(type);
        if (_Assertions.ENABLED && !bl2) {
            String string = "Assertion failed";
            throw new AssertionError((Object)string);
        }
        TypeConstructor typeConstructor2 = type.getConstructor();
        Intrinsics.checkNotNull(typeConstructor2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((ErrorTypeConstructor)typeConstructor2).getParam(0);
    }

    static {
        String string = ErrorEntity.ERROR_CLASS.getDebugText();
        Object[] objectArray = new Object[]{"unknown class"};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(...)");
        Name name = Name.special(string2);
        Intrinsics.checkNotNullExpressionValue(name, "special(...)");
        errorClass = new ErrorClassDescriptor(name);
        errorTypeForLoopInSupertypes = ErrorUtils.createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        errorPropertyType = ErrorUtils.createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        errorProperty = new ErrorPropertyDescriptor();
        errorPropertyGroup = SetsKt.setOf(errorProperty);
    }
}

