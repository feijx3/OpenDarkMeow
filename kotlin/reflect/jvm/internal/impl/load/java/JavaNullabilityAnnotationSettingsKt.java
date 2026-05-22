/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus;
import kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJavaNullabilityAnnotationSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaNullabilityAnnotationSettings.kt\norg/jetbrains/kotlin/load/java/JavaNullabilityAnnotationSettingsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public final class JavaNullabilityAnnotationSettingsKt {
    @NotNull
    private static final FqName JSPECIFY_OLD_ANNOTATIONS_PACKAGE = new FqName("org.jspecify.nullness");
    @NotNull
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE = new FqName("org.jspecify.annotations");
    @NotNull
    private static final FqName RXJAVA3_ANNOTATIONS_PACKAGE = new FqName("io.reactivex.rxjava3.annotations");
    @NotNull
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = new FqName("org.checkerframework.checker.nullness.compatqual");
    @NotNull
    private static final String RXJAVA3_ANNOTATIONS_PACKAGE_NAME = RXJAVA3_ANNOTATIONS_PACKAGE.asString();
    @NotNull
    private static final FqName[] RXJAVA3_ANNOTATIONS;
    @NotNull
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS;
    @NotNull
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS;

    @NotNull
    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    @NotNull
    public static final FqName[] getRXJAVA3_ANNOTATIONS() {
        return RXJAVA3_ANNOTATIONS;
    }

    @NotNull
    public static final Jsr305Settings getDefaultJsr305Settings(@NotNull KotlinVersion configuredKotlinVersion) {
        Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        ReportLevel globalReportLevel = JSR_305_DEFAULT_SETTINGS.getSinceVersion() != null && JSR_305_DEFAULT_SETTINGS.getSinceVersion().compareTo(configuredKotlinVersion) <= 0 ? JSR_305_DEFAULT_SETTINGS.getReportLevelAfter() : JSR_305_DEFAULT_SETTINGS.getReportLevelBefore();
        ReportLevel migrationLevel = JavaNullabilityAnnotationSettingsKt.getDefaultMigrationJsr305ReportLevelForGivenGlobal(globalReportLevel);
        return new Jsr305Settings(globalReportLevel, migrationLevel, null, 4, null);
    }

    @Nullable
    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(@NotNull ReportLevel globalReportLevel) {
        Intrinsics.checkNotNullParameter((Object)globalReportLevel, "globalReportLevel");
        return globalReportLevel == ReportLevel.WARN ? null : globalReportLevel;
    }

    @NotNull
    public static final ReportLevel getDefaultReportLevelForAnnotation(@NotNull FqName annotationFqName, @NotNull KotlinVersion configuredKotlinVersion) {
        Intrinsics.checkNotNullParameter(annotationFqName, "annotationFqName");
        Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        return JavaNullabilityAnnotationSettingsKt.getReportLevelForAnnotation(annotationFqName, NullabilityAnnotationStates.Companion.getEMPTY(), configuredKotlinVersion);
    }

    @NotNull
    public static final ReportLevel getReportLevelForAnnotation(@NotNull FqName annotation, @NotNull NullabilityAnnotationStates<? extends ReportLevel> configuredReportLevels, @NotNull KotlinVersion configuredKotlinVersion) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(configuredReportLevels, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        ReportLevel reportLevel = configuredReportLevels.get(annotation);
        if (reportLevel != null) {
            ReportLevel it = reportLevel;
            boolean bl2 = false;
            return it;
        }
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = NULLABILITY_ANNOTATION_SETTINGS.get(annotation);
        if (javaNullabilityAnnotationsStatus == null) {
            return ReportLevel.IGNORE;
        }
        JavaNullabilityAnnotationsStatus defaultStatus = javaNullabilityAnnotationsStatus;
        return defaultStatus.getSinceVersion() != null && defaultStatus.getSinceVersion().compareTo(configuredKotlinVersion) <= 0 ? defaultStatus.getReportLevelAfter() : defaultStatus.getReportLevelBefore();
    }

    static {
        Object[] objectArray = new FqName[]{new FqName(RXJAVA3_ANNOTATIONS_PACKAGE_NAME + ".Nullable"), new FqName(RXJAVA3_ANNOTATIONS_PACKAGE_NAME + ".NonNull")};
        RXJAVA3_ANNOTATIONS = objectArray;
        objectArray = new Pair[]{TuplesKt.to(new FqName("org.jetbrains.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.support.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("com.android.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE, JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("javax.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("io.reactivex.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation.RecentlyNullable"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null)), TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null)), TuplesKt.to(new FqName("lombok"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(JSPECIFY_OLD_ANNOTATIONS_PACKAGE, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(2, 1), ReportLevel.STRICT)), TuplesKt.to(JSPECIFY_ANNOTATIONS_PACKAGE, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(2, 1), ReportLevel.STRICT)), TuplesKt.to(RXJAVA3_ANNOTATIONS_PACKAGE, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 8), ReportLevel.STRICT)), TuplesKt.to(new FqName("jakarta.annotation"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(2, 4), ReportLevel.STRICT))};
        NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(objectArray));
        JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null);
    }
}

