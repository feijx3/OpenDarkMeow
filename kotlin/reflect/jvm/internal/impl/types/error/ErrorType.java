/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import org.jetbrains.annotations.NotNull;

public final class ErrorType
extends SimpleType {
    @NotNull
    private final TypeConstructor constructor;
    @NotNull
    private final MemberScope memberScope;
    @NotNull
    private final ErrorTypeKind kind;
    @NotNull
    private final List<TypeProjection> arguments;
    private final boolean isMarkedNullable;
    @NotNull
    private final String[] formatParams;
    @NotNull
    private final String debugMessage;

    @JvmOverloads
    public ErrorType(@NotNull TypeConstructor constructor, @NotNull MemberScope memberScope, @NotNull ErrorTypeKind kind2, @NotNull List<? extends TypeProjection> arguments, boolean isMarkedNullable, String ... formatParams) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        this.constructor = constructor;
        this.memberScope = memberScope;
        this.kind = kind2;
        this.arguments = arguments;
        this.isMarkedNullable = isMarkedNullable;
        this.formatParams = formatParams;
        String string = this.kind.getDebugMessage();
        String[] stringArray = this.formatParams;
        stringArray = Arrays.copyOf(stringArray, stringArray.length);
        String string2 = String.format(string, Arrays.copyOf(stringArray, stringArray.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(...)");
        this.debugMessage = string2;
    }

    public /* synthetic */ ErrorType(TypeConstructor typeConstructor2, MemberScope memberScope, ErrorTypeKind errorTypeKind, List list, boolean bl2, String[] stringArray, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        this(typeConstructor2, memberScope, errorTypeKind, list, bl2, stringArray);
    }

    @Override
    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @NotNull
    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    @Override
    @NotNull
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @NotNull
    public final String getDebugMessage() {
        return this.debugMessage;
    }

    @Override
    @NotNull
    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    @Override
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return this;
    }

    @NotNull
    public final ErrorType replaceArguments(@NotNull List<? extends TypeProjection> newArguments) {
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        String[] stringArray = this.formatParams;
        return new ErrorType(this.getConstructor(), this.getMemberScope(), this.kind, newArguments, this.isMarkedNullable(), Arrays.copyOf(stringArray, stringArray.length));
    }

    @Override
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean newNullability) {
        String[] stringArray = this.formatParams;
        return new ErrorType(this.getConstructor(), this.getMemberScope(), this.kind, this.getArguments(), newNullability, Arrays.copyOf(stringArray, stringArray.length));
    }

    @Override
    @NotNull
    public ErrorType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}

