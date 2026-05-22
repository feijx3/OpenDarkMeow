/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VersionRequirementTable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<ProtoBuf.VersionRequirement> infos;
    @NotNull
    private static final VersionRequirementTable EMPTY = new VersionRequirementTable(CollectionsKt.<ProtoBuf.VersionRequirement>emptyList());

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> infos) {
        this.infos = infos;
    }

    @Nullable
    public final ProtoBuf.VersionRequirement get(int id) {
        return CollectionsKt.getOrNull(this.infos, id);
    }

    public /* synthetic */ VersionRequirementTable(List infos, DefaultConstructorMarker $constructor_marker) {
        this(infos);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final VersionRequirementTable getEMPTY() {
            return EMPTY;
        }

        @NotNull
        public final VersionRequirementTable create(@NotNull ProtoBuf.VersionRequirementTable table) {
            VersionRequirementTable versionRequirementTable;
            Intrinsics.checkNotNullParameter(table, "table");
            if (table.getRequirementCount() == 0) {
                versionRequirementTable = this.getEMPTY();
            } else {
                List<ProtoBuf.VersionRequirement> list = table.getRequirementList();
                Intrinsics.checkNotNullExpressionValue(list, "getRequirementList(...)");
                versionRequirementTable = new VersionRequirementTable(list, null);
            }
            return versionRequirementTable;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

