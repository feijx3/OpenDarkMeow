/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nKotlinClassHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public final class KotlinClassHeader {
    @NotNull
    private final Kind kind;
    @NotNull
    private final MetadataVersion metadataVersion;
    @Nullable
    private final String[] data;
    @Nullable
    private final String[] incompatibleData;
    @Nullable
    private final String[] strings;
    @Nullable
    private final String extraString;
    private final int extraInt;
    @Nullable
    private final String packageName;
    @Nullable
    private final byte[] serializedIr;

    public KotlinClassHeader(@NotNull Kind kind2, @NotNull MetadataVersion metadataVersion, @Nullable String[] data, @Nullable String[] incompatibleData, @Nullable String[] strings, @Nullable String extraString, int extraInt, @Nullable String packageName, @Nullable byte[] serializedIr) {
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        this.kind = kind2;
        this.metadataVersion = metadataVersion;
        this.data = data;
        this.incompatibleData = incompatibleData;
        this.strings = strings;
        this.extraString = extraString;
        this.extraInt = extraInt;
        this.packageName = packageName;
        this.serializedIr = serializedIr;
    }

    @NotNull
    public final Kind getKind() {
        return this.kind;
    }

    @NotNull
    public final MetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @Nullable
    public final String[] getData() {
        return this.data;
    }

    @Nullable
    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    @Nullable
    public final String[] getStrings() {
        return this.strings;
    }

    @Nullable
    public final String getMultifileClassName() {
        String string;
        String it = string = this.extraString;
        boolean bl2 = false;
        return this.kind == Kind.MULTIFILE_CLASS_PART ? string : null;
    }

    @NotNull
    public final List<String> getMultifilePartNames() {
        String[] stringArray;
        String[] it = stringArray = this.data;
        boolean bl2 = false;
        Object object = this.kind == Kind.MULTIFILE_CLASS ? stringArray : null;
        List<String> list = object != null ? ArraysKt.asList(object) : null;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public final boolean isUnstableJvmIrBinary() {
        return this.has(this.extraInt, 16) && !this.has(this.extraInt, 32);
    }

    public final boolean isPreRelease() {
        return this.has(this.extraInt, 2);
    }

    @NotNull
    public String toString() {
        return (Object)((Object)this.kind) + " version=" + this.metadataVersion;
    }

    private final boolean has(int $this$has, int flag) {
        return ($this$has & flag) != 0;
    }

    @SourceDebugExtension(value={"SMAP\nKotlinClassHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader$Kind\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,75:1\n8704#2,2:76\n8964#2,4:78\n*S KotlinDebug\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader$Kind\n*L\n34#1:76,2\n34#1:78,4\n*E\n"})
    public static final class Kind
    extends Enum<Kind> {
        @NotNull
        public static final Companion Companion;
        private final int id;
        @NotNull
        private static final Map<Integer, Kind> entryById;
        public static final /* enum */ Kind UNKNOWN;
        public static final /* enum */ Kind CLASS;
        public static final /* enum */ Kind FILE_FACADE;
        public static final /* enum */ Kind SYNTHETIC_CLASS;
        public static final /* enum */ Kind MULTIFILE_CLASS;
        public static final /* enum */ Kind MULTIFILE_CLASS_PART;
        private static final /* synthetic */ Kind[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private Kind(int id) {
            this.id = id;
        }

        public static Kind[] values() {
            return (Kind[])$VALUES.clone();
        }

        public static Kind valueOf(String value) {
            return Enum.valueOf(Kind.class, value);
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int id) {
            return Companion.getById(id);
        }

        /*
         * WARNING - void declaration
         */
        static {
            void $this$associateByTo$iv$iv;
            UNKNOWN = new Kind(0);
            CLASS = new Kind(1);
            FILE_FACADE = new Kind(2);
            SYNTHETIC_CLASS = new Kind(3);
            MULTIFILE_CLASS = new Kind(4);
            MULTIFILE_CLASS_PART = new Kind(5);
            $VALUES = kindArray = new Kind[]{Kind.UNKNOWN, Kind.CLASS, Kind.FILE_FACADE, Kind.SYNTHETIC_CLASS, Kind.MULTIFILE_CLASS, Kind.MULTIFILE_CLASS_PART};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            Companion = new Companion(null);
            Kind[] $this$associateBy$iv = Kind.values();
            boolean $i$f$associateBy = false;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity($this$associateBy$iv.length), 16);
            Kind[] kindArray = $this$associateBy$iv;
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateByTo = false;
            int n2 = ((void)$this$associateByTo$iv$iv).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                void p0;
                void element$iv$iv;
                void var9_9 = element$iv$iv = $this$associateByTo$iv$iv[i2];
                Map map = destination$iv$iv;
                boolean bl2 = false;
                map.put(p0.id, element$iv$iv);
            }
            entryById = destination$iv$iv;
        }

        public static final class Companion {
            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Kind getById(int id) {
                Kind kind2 = (Kind)((Object)entryById.get(id));
                if (kind2 == null) {
                    kind2 = UNKNOWN;
                }
                return kind2;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

