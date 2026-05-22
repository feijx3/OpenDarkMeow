/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import org.jetbrains.annotations.NotNull;

public interface DeserializationConfiguration {
    @NotNull
    public MetadataVersion getMetadataVersion();

    public boolean getSkipMetadataVersionCheck();

    public boolean getSkipPrereleaseCheck();

    public boolean getReportErrorsOnPreReleaseDependencies();

    public boolean getAllowUnstableDependencies();

    public boolean getTypeAliasesAllowed();

    public boolean getPreserveDeclarationsOrdering();

    public static final class Default
    implements DeserializationConfiguration {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override
        @NotNull
        public MetadataVersion getMetadataVersion() {
            return MetadataVersion.INSTANCE;
        }

        @Override
        public boolean getSkipMetadataVersionCheck() {
            return false;
        }

        @Override
        public boolean getSkipPrereleaseCheck() {
            return false;
        }

        @Override
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return false;
        }

        @Override
        public boolean getAllowUnstableDependencies() {
            return false;
        }

        @Override
        public boolean getTypeAliasesAllowed() {
            return true;
        }

        @Override
        public boolean getPreserveDeclarationsOrdering() {
            return false;
        }
    }
}

