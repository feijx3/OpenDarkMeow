/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationSettingsKt;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState$Companion$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class JavaTypeEnhancementState {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Jsr305Settings jsr305;
    @NotNull
    private final Function1<FqName, ReportLevel> getReportLevelForAnnotation;
    private final boolean disabledDefaultAnnotations;

    public JavaTypeEnhancementState(@NotNull Jsr305Settings jsr305, @NotNull Function1<? super FqName, ? extends ReportLevel> getReportLevelForAnnotation) {
        Intrinsics.checkNotNullParameter(jsr305, "jsr305");
        Intrinsics.checkNotNullParameter(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.jsr305 = jsr305;
        this.getReportLevelForAnnotation = getReportLevelForAnnotation;
        this.disabledDefaultAnnotations = this.jsr305.isDisabled() || this.getReportLevelForAnnotation.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.IGNORE;
    }

    @NotNull
    public final Jsr305Settings getJsr305() {
        return this.jsr305;
    }

    @NotNull
    public final Function1<FqName, ReportLevel> getGetReportLevelForAnnotation() {
        return this.getReportLevelForAnnotation;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    @NotNull
    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.jsr305 + ", getReportLevelForAnnotation=" + this.getReportLevelForAnnotation + ')';
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final JavaTypeEnhancementState getDefault(@NotNull KotlinVersion kotlinVersion) {
            Intrinsics.checkNotNullParameter(kotlinVersion, "kotlinVersion");
            KotlinVersion kotlinVersion2 = kotlinVersion;
            return new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings(kotlinVersion), new JavaTypeEnhancementState$Companion$$Lambda$0(kotlinVersion2));
        }

        private static final ReportLevel getDefault$lambda$0(KotlinVersion $kotlinVersion, FqName it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return JavaNullabilityAnnotationSettingsKt.getDefaultReportLevelForAnnotation(it, $kotlinVersion);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        static /* synthetic */ ReportLevel accessor$JavaTypeEnhancementState$Companion$lambda0(KotlinVersion kotlinVersion, FqName fqName) {
            return kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState$Companion.getDefault$lambda$0(kotlinVersion, fqName);
        }
    }
}

