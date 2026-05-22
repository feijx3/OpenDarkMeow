/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VersionRequirement {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Version version;
    @NotNull
    private final ProtoBuf.VersionRequirement.VersionKind kind;
    @NotNull
    private final DeprecationLevel level;
    @Nullable
    private final Integer errorCode;
    @Nullable
    private final String message;

    public VersionRequirement(@NotNull Version version, @NotNull ProtoBuf.VersionRequirement.VersionKind kind2, @NotNull DeprecationLevel level, @Nullable Integer errorCode, @Nullable String message) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(kind2, "kind");
        Intrinsics.checkNotNullParameter((Object)level, "level");
        this.version = version;
        this.kind = kind2;
        this.level = level;
        this.errorCode = errorCode;
        this.message = message;
    }

    @NotNull
    public final Version getVersion() {
        return this.version;
    }

    @NotNull
    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    @NotNull
    public final DeprecationLevel getLevel() {
        return this.level;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public String toString() {
        return "since " + this.version + ' ' + (Object)((Object)this.level) + (this.errorCode != null ? " error " + this.errorCode : "") + (this.message != null ? ": " + this.message : "");
    }

    @SourceDebugExtension(value={"SMAP\nVersionRequirement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionRequirement.kt\norg/jetbrains/kotlin/metadata/deserialization/VersionRequirement$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1617#2,9:120\n1869#2:129\n1870#2:131\n1626#2:132\n1#3:130\n*S KotlinDebug\n*F\n+ 1 VersionRequirement.kt\norg/jetbrains/kotlin/metadata/deserialization/VersionRequirement$Companion\n*L\n94#1:120,9\n94#1:129\n94#1:131\n94#1:132\n94#1:130\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final VersionRequirement create(int id, @NotNull NameResolver nameResolver, @NotNull VersionRequirementTable table) {
            DeprecationLevel deprecationLevel;
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(table, "table");
            ProtoBuf.VersionRequirement versionRequirement = table.get(id);
            if (versionRequirement == null) {
                return null;
            }
            ProtoBuf.VersionRequirement info = versionRequirement;
            Version version = Version.Companion.decode(info.hasVersion() ? Integer.valueOf(info.getVersion()) : null, info.hasVersionFull() ? Integer.valueOf(info.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level = info.getLevel();
            Intrinsics.checkNotNull(level);
            switch (WhenMappings.$EnumSwitchMapping$0[level.ordinal()]) {
                case 1: {
                    deprecationLevel = DeprecationLevel.WARNING;
                    break;
                }
                case 2: {
                    deprecationLevel = DeprecationLevel.ERROR;
                    break;
                }
                case 3: {
                    deprecationLevel = DeprecationLevel.HIDDEN;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            DeprecationLevel level2 = deprecationLevel;
            Integer errorCode = info.hasErrorCode() ? Integer.valueOf(info.getErrorCode()) : null;
            String message = info.hasMessage() ? nameResolver.getString(info.getMessage()) : null;
            ProtoBuf.VersionRequirement.VersionKind versionKind = info.getVersionKind();
            Intrinsics.checkNotNullExpressionValue(versionKind, "getVersionKind(...)");
            return new VersionRequirement(version, versionKind, level2, errorCode, message);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[ProtoBuf.VersionRequirement.Level.values().length];
                try {
                    nArray[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }

    public static final class Version {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final int major;
        private final int minor;
        private final int patch;
        @JvmField
        @NotNull
        public static final Version INFINITY = new Version(256, 256, 256);

        public Version(int major, int minor, int patch) {
            this.major = major;
            this.minor = minor;
            this.patch = patch;
        }

        @NotNull
        public final String asString() {
            return this.patch == 0 ? "" + this.major + '.' + this.minor : "" + this.major + '.' + this.minor + '.' + this.patch;
        }

        public final void encode(@NotNull Function1<? super Integer, Unit> writeVersion, @NotNull Function1<? super Integer, Unit> writeVersionFull) {
            Intrinsics.checkNotNullParameter(writeVersion, "writeVersion");
            Intrinsics.checkNotNullParameter(writeVersionFull, "writeVersionFull");
            if (!Intrinsics.areEqual(this, INFINITY)) {
                if (this.major > 7 || this.minor > 15 || this.patch > 127) {
                    writeVersionFull.invoke((Integer)(this.major | this.minor << 8 | this.patch << 16));
                } else {
                    writeVersion.invoke((Integer)(this.major | this.minor << 3 | this.patch << 7));
                }
            }
        }

        @NotNull
        public String toString() {
            return this.asString();
        }

        public final int component1() {
            return this.major;
        }

        public final int component2() {
            return this.minor;
        }

        public final int component3() {
            return this.patch;
        }

        public int hashCode() {
            int result = Integer.hashCode(this.major);
            result = result * 31 + Integer.hashCode(this.minor);
            result = result * 31 + Integer.hashCode(this.patch);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Version)) {
                return false;
            }
            Version version = (Version)other;
            if (this.major != version.major) {
                return false;
            }
            if (this.minor != version.minor) {
                return false;
            }
            return this.patch == version.patch;
        }

        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Version decode(@Nullable Integer version, @Nullable Integer versionFull) {
                return versionFull != null ? new Version((int)(versionFull & 0xFF), versionFull >> 8 & 0xFF, versionFull >> 16 & 0xFF) : (version != null ? new Version(version & 7, version >> 3 & 0xF, version >> 7 & 0x7F) : INFINITY);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

