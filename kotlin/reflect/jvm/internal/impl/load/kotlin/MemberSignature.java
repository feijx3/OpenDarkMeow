/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MemberSignature {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String signature;

    private MemberSignature(String signature) {
        this.signature = signature;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    @NotNull
    public String toString() {
        return "MemberSignature(signature=" + this.signature + ')';
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberSignature)) {
            return false;
        }
        MemberSignature memberSignature = (MemberSignature)other;
        return Intrinsics.areEqual(this.signature, memberSignature.signature);
    }

    public /* synthetic */ MemberSignature(String signature, DefaultConstructorMarker $constructor_marker) {
        this(signature);
    }

    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromMethod(@NotNull NameResolver nameResolver, @NotNull JvmProtoBuf.JvmMethodSignature signature) {
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(signature, "signature");
            return this.fromMethodNameAndDesc(nameResolver.getString(signature.getName()), nameResolver.getString(signature.getDesc()));
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromMethodNameAndDesc(@NotNull String name, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(desc, "desc");
            return new MemberSignature(name + desc, null);
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromFieldNameAndDesc(@NotNull String name, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(desc, "desc");
            return new MemberSignature(name + '#' + desc, null);
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromJvmMemberSignature(@NotNull JvmMemberSignature signature) {
            MemberSignature memberSignature;
            Intrinsics.checkNotNullParameter(signature, "signature");
            JvmMemberSignature jvmMemberSignature = signature;
            if (jvmMemberSignature instanceof JvmMemberSignature.Method) {
                memberSignature = this.fromMethodNameAndDesc(((JvmMemberSignature.Method)signature).getName(), ((JvmMemberSignature.Method)signature).getDesc());
            } else if (jvmMemberSignature instanceof JvmMemberSignature.Field) {
                memberSignature = this.fromFieldNameAndDesc(((JvmMemberSignature.Field)signature).getName(), ((JvmMemberSignature.Field)signature).getDesc());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return memberSignature;
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromMethodSignatureAndParameterIndex(@NotNull MemberSignature signature, int index) {
            Intrinsics.checkNotNullParameter(signature, "signature");
            return new MemberSignature(signature.getSignature() + '@' + index, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

