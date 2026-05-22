/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public abstract class ModuleAwareClassDescriptor
implements ClassDescriptor {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    protected abstract MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner var1);

    @NotNull
    protected abstract MemberScope getMemberScope(@NotNull TypeSubstitution var1, @NotNull KotlinTypeRefiner var2);

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(@NotNull ClassDescriptor $this$getRefinedUnsubstitutedMemberScopeIfPossible, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter($this$getRefinedUnsubstitutedMemberScopeIfPossible, "<this>");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            Object object = $this$getRefinedUnsubstitutedMemberScopeIfPossible instanceof ModuleAwareClassDescriptor ? (ModuleAwareClassDescriptor)$this$getRefinedUnsubstitutedMemberScopeIfPossible : null;
            if (object == null || (object = ((ModuleAwareClassDescriptor)object).getUnsubstitutedMemberScope(kotlinTypeRefiner)) == null) {
                MemberScope memberScope = $this$getRefinedUnsubstitutedMemberScopeIfPossible.getUnsubstitutedMemberScope();
                object = memberScope;
                Intrinsics.checkNotNullExpressionValue(memberScope, "getUnsubstitutedMemberScope(...)");
            }
            return object;
        }

        @NotNull
        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(@NotNull ClassDescriptor $this$getRefinedMemberScopeIfPossible, @NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter($this$getRefinedMemberScopeIfPossible, "<this>");
            Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            Object object = $this$getRefinedMemberScopeIfPossible instanceof ModuleAwareClassDescriptor ? (ModuleAwareClassDescriptor)$this$getRefinedMemberScopeIfPossible : null;
            if (object == null || (object = ((ModuleAwareClassDescriptor)object).getMemberScope(typeSubstitution, kotlinTypeRefiner)) == null) {
                MemberScope memberScope = $this$getRefinedMemberScopeIfPossible.getMemberScope(typeSubstitution);
                object = memberScope;
                Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
            }
            return object;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

