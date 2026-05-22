/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nFqNameUnsafe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FqNameUnsafe.kt\norg/jetbrains/kotlin/name/FqNameUnsafe\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1#2:190\n*E\n"})
public final class FqNameUnsafe {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String fqName;
    @Nullable
    private transient FqName safe;
    @Nullable
    private transient FqNameUnsafe parent;
    @Nullable
    private transient Name shortName;
    @NotNull
    private static final Name ROOT_NAME;
    @NotNull
    private static final Pattern SPLIT_BY_DOTS;

    public FqNameUnsafe(@NotNull String fqName, @NotNull FqName safe) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(safe, "safe");
        this.fqName = fqName;
        this.safe = safe;
    }

    public FqNameUnsafe(@NotNull String fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqNameUnsafe(String fqName, FqNameUnsafe parent, Name shortName) {
        this.fqName = fqName;
        this.parent = parent;
        this.shortName = shortName;
    }

    private final void compute() {
        int lastDot = this.indexOfLastDotWithBackticksSupport(this.fqName);
        if (lastDot >= 0) {
            String string = this.fqName.substring(lastDot + 1);
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
            this.shortName = Name.guessByFirstCharacter(string);
            String string2 = this.fqName.substring(0, lastDot);
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
            this.parent = new FqNameUnsafe(string2);
        } else {
            this.shortName = Name.guessByFirstCharacter(this.fqName);
            this.parent = FqName.ROOT.toUnsafe();
        }
    }

    private final int indexOfLastDotWithBackticksSupport(String fqName) {
        boolean isBacktick = false;
        for (int index = fqName.length() - 1; index >= 0; --index) {
            char c2 = fqName.charAt(index);
            if (c2 == '.' && !isBacktick) {
                return index;
            }
            if (c2 == '`') {
                isBacktick = !isBacktick;
                continue;
            }
            if (c2 != '\\') continue;
            --index;
        }
        return -1;
    }

    @NotNull
    public final String asString() {
        return this.fqName;
    }

    public final boolean isSafe() {
        return this.safe != null || StringsKt.indexOf$default((CharSequence)this.asString(), '<', 0, false, 6, null) < 0;
    }

    @NotNull
    public final FqName toSafe() {
        FqName fqName = this.safe;
        if (fqName == null) {
            FqName fqName2;
            FqName it = fqName2 = new FqName(this);
            boolean bl2 = false;
            this.safe = it;
            fqName = fqName2;
        }
        return fqName;
    }

    public final boolean isRoot() {
        return ((CharSequence)this.fqName).length() == 0;
    }

    @NotNull
    public final FqNameUnsafe parent() {
        FqNameUnsafe fqNameUnsafe = this.parent;
        if (fqNameUnsafe != null) {
            FqNameUnsafe it = fqNameUnsafe;
            boolean bl2 = false;
            return it;
        }
        if (!(!this.isRoot())) {
            boolean bl3 = false;
            String string = "root";
            throw new IllegalStateException(string.toString());
        }
        this.compute();
        FqNameUnsafe fqNameUnsafe2 = this.parent;
        Intrinsics.checkNotNull(fqNameUnsafe2);
        return fqNameUnsafe2;
    }

    @NotNull
    public final FqNameUnsafe child(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String string = this.isRoot() ? name.asString() : this.fqName + '.' + name.asString();
        Intrinsics.checkNotNull(string);
        String childFqName = string;
        return new FqNameUnsafe(childFqName, this, name);
    }

    @NotNull
    public final Name shortName() {
        Name name = this.shortName;
        if (name != null) {
            Name it = name;
            boolean bl2 = false;
            return it;
        }
        if (!(!this.isRoot())) {
            boolean bl3 = false;
            String string = "root";
            throw new IllegalStateException(string.toString());
        }
        this.compute();
        Name name2 = this.shortName;
        Intrinsics.checkNotNull(name2);
        return name2;
    }

    @NotNull
    public final Name shortNameOrSpecial() {
        return this.isRoot() ? ROOT_NAME : this.shortName();
    }

    @NotNull
    public final List<Name> pathSegments() {
        return FqNameUnsafe.pathSegments$collectSegmentsOf(this);
    }

    public final boolean startsWith(@NotNull Name segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (this.isRoot()) {
            return false;
        }
        int firstDot = StringsKt.indexOf$default((CharSequence)this.fqName, '.', 0, false, 6, null);
        int fqNameFirstSegmentLength = firstDot == -1 ? this.fqName.length() : firstDot;
        String string = segment.asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        String segmentAsString = string;
        return fqNameFirstSegmentLength == segmentAsString.length() && StringsKt.regionMatches$default(this.fqName, 0, segmentAsString, 0, fqNameFirstSegmentLength, false, 16, null);
    }

    @NotNull
    public String toString() {
        String string;
        if (this.isRoot()) {
            String string2 = ROOT_NAME.asString();
            string = string2;
            Intrinsics.checkNotNullExpressionValue(string2, "asString(...)");
        } else {
            string = this.fqName;
        }
        return string;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FqNameUnsafe)) {
            return false;
        }
        return Intrinsics.areEqual(this.fqName, ((FqNameUnsafe)other).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    private static final List<Name> pathSegments$collectSegmentsOf(FqNameUnsafe fqName) {
        if (fqName.isRoot()) {
            return new ArrayList();
        }
        List<Name> parentSegments = FqNameUnsafe.pathSegments$collectSegmentsOf(fqName.parent());
        parentSegments.add(fqName.shortName());
        return parentSegments;
    }

    public /* synthetic */ FqNameUnsafe(String fqName, FqNameUnsafe parent, Name shortName, DefaultConstructorMarker $constructor_marker) {
        this(fqName, parent, shortName);
    }

    static {
        Name name = Name.special("<root>");
        Intrinsics.checkNotNullExpressionValue(name, "special(...)");
        ROOT_NAME = name;
        Pattern pattern = Pattern.compile("\\.");
        Intrinsics.checkNotNullExpressionValue(pattern, "compile(...)");
        SPLIT_BY_DOTS = pattern;
    }

    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final FqNameUnsafe topLevel(@NotNull Name shortName) {
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            String string = shortName.asString();
            Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
            return new FqNameUnsafe(string, FqName.ROOT.toUnsafe(), shortName, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

