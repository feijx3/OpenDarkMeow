/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class MetadataVersion
extends BinaryVersion {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean isStrictSemantics;
    @JvmField
    @NotNull
    public static final MetadataVersion INSTANCE;
    @JvmField
    @NotNull
    public static final MetadataVersion INSTANCE_NEXT;
    @JvmField
    @NotNull
    public static final MetadataVersion INVALID_VERSION;

    public MetadataVersion(@NotNull int[] versionArray, boolean isStrictSemantics) {
        Intrinsics.checkNotNullParameter(versionArray, "versionArray");
        super(Arrays.copyOf(versionArray, versionArray.length));
        this.isStrictSemantics = isStrictSemantics;
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    public MetadataVersion(int ... numbers) {
        Intrinsics.checkNotNullParameter(numbers, "numbers");
        this(numbers, false);
    }

    @NotNull
    public final MetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean isStrictSemantics) {
        MetadataVersion forwardCompatibility = isStrictSemantics ? INSTANCE : INSTANCE_NEXT;
        return forwardCompatibility.newerThan(this) ? forwardCompatibility : this;
    }

    public final boolean isCompatible(@NotNull MetadataVersion metadataVersionFromLanguageVersion) {
        Intrinsics.checkNotNullParameter(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        MetadataVersion limitVersion = metadataVersionFromLanguageVersion.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics);
        return this.isCompatibleInternal(limitVersion);
    }

    private final boolean isCompatibleInternal(MetadataVersion limitVersion) {
        if (this.getMajor() == 1 && this.getMinor() == 0) {
            return false;
        }
        if (this.getMajor() == 0) {
            return false;
        }
        return !this.newerThan(limitVersion);
    }

    @NotNull
    public final MetadataVersion next() {
        MetadataVersion metadataVersion;
        if (this.getMajor() == 1 && this.getMinor() == 9) {
            int[] nArray = new int[]{2, 0, 0};
            MetadataVersion metadataVersion2 = new MetadataVersion(nArray);
            metadataVersion = metadataVersion2;
        } else {
            int[] nArray = new int[]{this.getMajor(), this.getMinor() + 1, 0};
            MetadataVersion metadataVersion3 = new MetadataVersion(nArray);
            metadataVersion = metadataVersion3;
        }
        return metadataVersion;
    }

    private final boolean newerThan(MetadataVersion other) {
        return this.getMajor() > other.getMajor() ? true : (this.getMajor() < other.getMajor() ? false : this.getMinor() > other.getMinor());
    }

    static {
        int[] nArray = new int[]{2, 2, 0};
        INSTANCE = new MetadataVersion(nArray);
        INSTANCE_NEXT = INSTANCE.next();
        INVALID_VERSION = new MetadataVersion(new int[0]);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

