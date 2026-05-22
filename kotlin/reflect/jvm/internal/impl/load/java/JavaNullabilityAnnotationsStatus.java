/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaNullabilityAnnotationsStatus {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ReportLevel reportLevelBefore;
    @Nullable
    private final KotlinVersion sinceVersion;
    @NotNull
    private final ReportLevel reportLevelAfter;
    @NotNull
    private static final JavaNullabilityAnnotationsStatus DEFAULT = new JavaNullabilityAnnotationsStatus(ReportLevel.STRICT, null, null, 6, null);

    public JavaNullabilityAnnotationsStatus(@NotNull ReportLevel reportLevelBefore, @Nullable KotlinVersion sinceVersion, @NotNull ReportLevel reportLevelAfter) {
        Intrinsics.checkNotNullParameter((Object)reportLevelBefore, "reportLevelBefore");
        Intrinsics.checkNotNullParameter((Object)reportLevelAfter, "reportLevelAfter");
        this.reportLevelBefore = reportLevelBefore;
        this.sinceVersion = sinceVersion;
        this.reportLevelAfter = reportLevelAfter;
    }

    public /* synthetic */ JavaNullabilityAnnotationsStatus(ReportLevel reportLevel, KotlinVersion kotlinVersion, ReportLevel reportLevel2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            kotlinVersion = new KotlinVersion(1, 0);
        }
        if ((n2 & 4) != 0) {
            reportLevel2 = reportLevel;
        }
        this(reportLevel, kotlinVersion, reportLevel2);
    }

    @NotNull
    public final ReportLevel getReportLevelBefore() {
        return this.reportLevelBefore;
    }

    @Nullable
    public final KotlinVersion getSinceVersion() {
        return this.sinceVersion;
    }

    @NotNull
    public final ReportLevel getReportLevelAfter() {
        return this.reportLevelAfter;
    }

    @NotNull
    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + (Object)((Object)this.reportLevelBefore) + ", sinceVersion=" + this.sinceVersion + ", reportLevelAfter=" + (Object)((Object)this.reportLevelAfter) + ')';
    }

    public int hashCode() {
        int result = this.reportLevelBefore.hashCode();
        result = result * 31 + (this.sinceVersion == null ? 0 : this.sinceVersion.hashCode());
        result = result * 31 + this.reportLevelAfter.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JavaNullabilityAnnotationsStatus)) {
            return false;
        }
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = (JavaNullabilityAnnotationsStatus)other;
        if (this.reportLevelBefore != javaNullabilityAnnotationsStatus.reportLevelBefore) {
            return false;
        }
        if (!Intrinsics.areEqual(this.sinceVersion, javaNullabilityAnnotationsStatus.sinceVersion)) {
            return false;
        }
        return this.reportLevelAfter == javaNullabilityAnnotationsStatus.reportLevelAfter;
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final JavaNullabilityAnnotationsStatus getDEFAULT() {
            return DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

