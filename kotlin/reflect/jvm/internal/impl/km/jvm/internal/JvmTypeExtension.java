/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmTypeExtension
implements KmTypeExtension {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean isRaw;
    @NotNull
    private final List<KmAnnotation> annotations = new ArrayList();
    @JvmField
    @NotNull
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmTypeExtension.class));

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final void setRaw(boolean bl2) {
        this.isRaw = bl2;
    }

    @NotNull
    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    @NotNull
    public KmExtensionType getType() {
        return TYPE;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
        JvmTypeExtension cfr_ignored_0 = (JvmTypeExtension)other;
        if (this.isRaw != ((JvmTypeExtension)other).isRaw) {
            return false;
        }
        return Intrinsics.areEqual(this.annotations, ((JvmTypeExtension)other).annotations);
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.isRaw);
        result = 31 * result + ((Object)this.annotations).hashCode();
        return result;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

