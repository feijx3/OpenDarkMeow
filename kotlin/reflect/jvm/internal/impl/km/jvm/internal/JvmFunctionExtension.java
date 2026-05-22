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
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmFunctionExtension
implements KmFunctionExtension {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private JvmMethodSignature signature;
    @Nullable
    private String lambdaClassOriginName;
    @JvmField
    @NotNull
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmFunctionExtension.class));

    @Nullable
    public final JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setSignature(@Nullable JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
    }

    @Nullable
    public final String getLambdaClassOriginName() {
        return this.lambdaClassOriginName;
    }

    public final void setLambdaClassOriginName(@Nullable String string) {
        this.lambdaClassOriginName = string;
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

