/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJsr305Settings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jsr305Settings.kt\norg/jetbrains/kotlin/load/java/Jsr305Settings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,26:1\n1#2:27\n216#3,2:28\n37#4:30\n36#4,3:31\n*S KotlinDebug\n*F\n+ 1 Jsr305Settings.kt\norg/jetbrains/kotlin/load/java/Jsr305Settings\n*L\n19#1:28,2\n20#1:30\n20#1:31,3\n*E\n"})
public final class Jsr305Settings {
    @NotNull
    private final ReportLevel globalLevel;
    @Nullable
    private final ReportLevel migrationLevel;
    @NotNull
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;
    @NotNull
    private final Lazy description$delegate;
    private final boolean isDisabled;

    public Jsr305Settings(@NotNull ReportLevel globalLevel, @Nullable ReportLevel migrationLevel, @NotNull Map<FqName, ? extends ReportLevel> userDefinedLevelForSpecificAnnotation) {
        Intrinsics.checkNotNullParameter((Object)globalLevel, "globalLevel");
        Intrinsics.checkNotNullParameter(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = globalLevel;
        this.migrationLevel = migrationLevel;
        this.userDefinedLevelForSpecificAnnotation = userDefinedLevelForSpecificAnnotation;
        Jsr305Settings jsr305Settings = this;
        this.description$delegate = LazyKt.lazy(new Jsr305Settings$$Lambda$0(jsr305Settings));
        this.isDisabled = this.globalLevel == ReportLevel.IGNORE && this.migrationLevel == ReportLevel.IGNORE && this.userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public /* synthetic */ Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            reportLevel2 = null;
        }
        if ((n2 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        this(reportLevel, reportLevel2, map);
    }

    @NotNull
    public final ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    @Nullable
    public final ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    @NotNull
    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    @NotNull
    public String toString() {
        return "Jsr305Settings(globalLevel=" + (Object)((Object)this.globalLevel) + ", migrationLevel=" + (Object)((Object)this.migrationLevel) + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    public int hashCode() {
        int result = this.globalLevel.hashCode();
        result = result * 31 + (this.migrationLevel == null ? 0 : this.migrationLevel.hashCode());
        result = result * 31 + ((Object)this.userDefinedLevelForSpecificAnnotation).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Jsr305Settings)) {
            return false;
        }
        Jsr305Settings jsr305Settings = (Jsr305Settings)other;
        if (this.globalLevel != jsr305Settings.globalLevel) {
            return false;
        }
        if (this.migrationLevel != jsr305Settings.migrationLevel) {
            return false;
        }
        return Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, jsr305Settings.userDefinedLevelForSpecificAnnotation);
    }

    private static final String[] description_delegate$lambda$3(Jsr305Settings this$0) {
        List<String> list;
        List<String> $this$description_delegate_u24lambda_u243_u24lambda_u242 = list = CollectionsKt.createListBuilder();
        boolean bl2 = false;
        $this$description_delegate_u24lambda_u243_u24lambda_u242.add(this$0.globalLevel.getDescription());
        ReportLevel reportLevel = this$0.migrationLevel;
        if (reportLevel != null) {
            ReportLevel it = reportLevel;
            boolean bl3 = false;
            $this$description_delegate_u24lambda_u243_u24lambda_u242.add("under-migration:" + it.getDescription());
        }
        Map<FqName, ReportLevel> $this$forEach$iv = this$0.userDefinedLevelForSpecificAnnotation;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<FqName, ReportLevel>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<FqName, ReportLevel> element$iv;
            Map.Entry<FqName, ReportLevel> it = element$iv = iterator2.next();
            boolean bl4 = false;
            $this$description_delegate_u24lambda_u243_u24lambda_u242.add("" + '@' + it.getKey() + ':' + it.getValue().getDescription());
        }
        Collection $this$toTypedArray$iv = CollectionsKt.build(list);
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        return thisCollection$iv.toArray(new String[0]);
    }

    static /* synthetic */ String[] accessor$Jsr305Settings$lambda0(Jsr305Settings jsr305Settings) {
        return Jsr305Settings.description_delegate$lambda$3(jsr305Settings);
    }
}

