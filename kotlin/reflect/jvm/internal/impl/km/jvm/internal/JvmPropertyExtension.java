/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmPropertyExtension
implements KmPropertyExtension {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int jvmFlags;
    @Nullable
    private JvmFieldSignature fieldSignature;
    @Nullable
    private JvmMethodSignature getterSignature;
    @Nullable
    private JvmMethodSignature setterSignature;
    @Nullable
    private JvmMethodSignature syntheticMethodForAnnotations;
    @Nullable
    private JvmMethodSignature syntheticMethodForDelegate;
    @JvmField
    @NotNull
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmPropertyExtension.class));

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int n2) {
        this.jvmFlags = n2;
    }

    @Nullable
    public final JvmFieldSignature getFieldSignature() {
        return this.fieldSignature;
    }

    public final void setFieldSignature(@Nullable JvmFieldSignature jvmFieldSignature) {
        this.fieldSignature = jvmFieldSignature;
    }

    @Nullable
    public final JvmMethodSignature getGetterSignature() {
        return this.getterSignature;
    }

    public final void setGetterSignature(@Nullable JvmMethodSignature jvmMethodSignature) {
        this.getterSignature = jvmMethodSignature;
    }

    @Nullable
    public final JvmMethodSignature getSetterSignature() {
        return this.setterSignature;
    }

    public final void setSetterSignature(@Nullable JvmMethodSignature jvmMethodSignature) {
        this.setterSignature = jvmMethodSignature;
    }

    @Nullable
    public final JvmMethodSignature getSyntheticMethodForAnnotations() {
        return this.syntheticMethodForAnnotations;
    }

    public final void setSyntheticMethodForAnnotations(@Nullable JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForAnnotations = jvmMethodSignature;
    }

    @Nullable
    public final JvmMethodSignature getSyntheticMethodForDelegate() {
        return this.syntheticMethodForDelegate;
    }

    public final void setSyntheticMethodForDelegate(@Nullable JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForDelegate = jvmMethodSignature;
    }

    @Override
    @NotNull
    public KmExtensionType getType() {
        return TYPE;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

