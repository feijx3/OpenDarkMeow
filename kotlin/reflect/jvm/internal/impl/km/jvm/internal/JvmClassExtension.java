/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmClassExtension
implements KmClassExtension {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<KmProperty> localDelegatedProperties = new ArrayList(0);
    @Nullable
    private String moduleName;
    @Nullable
    private String anonymousObjectOriginName;
    private int jvmFlags;
    @NotNull
    private static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmClassExtension.class));

    @NotNull
    public final List<KmProperty> getLocalDelegatedProperties() {
        return this.localDelegatedProperties;
    }

    @Nullable
    public final String getModuleName() {
        return this.moduleName;
    }

    public final void setModuleName(@Nullable String string) {
        this.moduleName = string;
    }

    @Nullable
    public final String getAnonymousObjectOriginName() {
        return this.anonymousObjectOriginName;
    }

    public final void setAnonymousObjectOriginName(@Nullable String string) {
        this.anonymousObjectOriginName = string;
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int n2) {
        this.jvmFlags = n2;
    }

    @Override
    @NotNull
    public KmExtensionType getType() {
        return TYPE;
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KmExtensionType getTYPE() {
            return TYPE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

