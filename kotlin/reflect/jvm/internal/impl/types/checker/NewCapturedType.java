/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
public final class NewCapturedType
extends SimpleType
implements CapturedTypeMarker {
    @NotNull
    private final CaptureStatus captureStatus;
    @NotNull
    private final NewCapturedTypeConstructor constructor;
    @Nullable
    private final UnwrappedType lowerType;
    @NotNull
    private final TypeAttributes attributes;
    private final boolean isMarkedNullable;
    private final boolean isProjectionNotNull;

    public NewCapturedType(@NotNull CaptureStatus captureStatus, @NotNull NewCapturedTypeConstructor constructor, @Nullable UnwrappedType lowerType, @NotNull TypeAttributes attributes, boolean isMarkedNullable, boolean isProjectionNotNull) {
        Intrinsics.checkNotNullParameter((Object)captureStatus, "captureStatus");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.captureStatus = captureStatus;
        this.constructor = constructor;
        this.lowerType = lowerType;
        this.attributes = attributes;
        this.isMarkedNullable = isMarkedNullable;
        this.isProjectionNotNull = isProjectionNotNull;
    }

    public /* synthetic */ NewCapturedType(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, TypeAttributes typeAttributes, boolean bl2, boolean bl3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            typeAttributes = TypeAttributes.Companion.getEmpty();
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        if ((n2 & 0x20) != 0) {
            bl3 = false;
        }
        this(captureStatus, newCapturedTypeConstructor, unwrappedType, typeAttributes, bl2, bl3);
    }

    @NotNull
    public final CaptureStatus getCaptureStatus() {
        return this.captureStatus;
    }

    @Override
    @NotNull
    public NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Nullable
    public final UnwrappedType getLowerType() {
        return this.lowerType;
    }

    @Override
    @NotNull
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public final boolean isProjectionNotNull() {
        return this.isProjectionNotNull;
    }

    public NewCapturedType(@NotNull CaptureStatus captureStatus, @Nullable UnwrappedType lowerType, @NotNull TypeProjection projection, @NotNull TypeParameterDescriptor typeParameter) {
        Intrinsics.checkNotNullParameter((Object)captureStatus, "captureStatus");
        Intrinsics.checkNotNullParameter(projection, "projection");
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this(captureStatus, new NewCapturedTypeConstructor(projection, null, null, typeParameter, 6, null), lowerType, null, false, false, 56, null);
    }

    @Override
    @NotNull
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new NewCapturedType(this.captureStatus, this.getConstructor(), this.lowerType, newAttributes, this.isMarkedNullable(), this.isProjectionNotNull);
    }

    @Override
    @NotNull
    public NewCapturedType makeNullableAsSpecified(boolean newNullability) {
        return new NewCapturedType(this.captureStatus, this.getConstructor(), this.lowerType, this.getAttributes(), newNullability, false, 32, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public NewCapturedType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus = this.captureStatus;
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.getConstructor().refine(kotlinTypeRefiner);
        UnwrappedType unwrappedType2 = this.lowerType;
        if (unwrappedType2 != null) {
            void it;
            UnwrappedType unwrappedType3 = unwrappedType2;
            NewCapturedTypeConstructor newCapturedTypeConstructor2 = newCapturedTypeConstructor;
            CaptureStatus captureStatus2 = captureStatus;
            boolean bl2 = false;
            UnwrappedType unwrappedType4 = kotlinTypeRefiner.refineType((KotlinTypeMarker)it).unwrap();
            captureStatus = captureStatus2;
            newCapturedTypeConstructor = newCapturedTypeConstructor2;
            unwrappedType = unwrappedType4;
        } else {
            unwrappedType = null;
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        int n2 = 32;
        boolean bl3 = false;
        boolean bl4 = this.isMarkedNullable();
        TypeAttributes typeAttributes = this.getAttributes();
        UnwrappedType unwrappedType5 = unwrappedType;
        NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor;
        CaptureStatus captureStatus3 = captureStatus;
        return new NewCapturedType(captureStatus3, newCapturedTypeConstructor3, unwrappedType5, typeAttributes, bl4, bl3, n2, defaultConstructorMarker);
    }
}

