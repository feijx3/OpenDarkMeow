/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

public final class ReportLevel
extends Enum<ReportLevel> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String description;
    public static final /* enum */ ReportLevel IGNORE;
    public static final /* enum */ ReportLevel WARN;
    public static final /* enum */ ReportLevel STRICT;
    private static final /* synthetic */ ReportLevel[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ReportLevel(String description) {
        this.description = description;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean isWarning() {
        return this == WARN;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public static ReportLevel[] values() {
        return (ReportLevel[])$VALUES.clone();
    }

    public static ReportLevel valueOf(String value) {
        return Enum.valueOf(ReportLevel.class, value);
    }

    static {
        IGNORE = new ReportLevel("ignore");
        WARN = new ReportLevel("warn");
        STRICT = new ReportLevel("strict");
        $VALUES = reportLevelArray = new ReportLevel[]{ReportLevel.IGNORE, ReportLevel.WARN, ReportLevel.STRICT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @SourceDebugExtension(value={"SMAP\nReportLevel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportLevel.kt\norg/jetbrains/kotlin/load/java/ReportLevel$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,20:1\n1310#2,2:21\n*S KotlinDebug\n*F\n+ 1 ReportLevel.kt\norg/jetbrains/kotlin/load/java/ReportLevel$Companion\n*L\n15#1:21,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

