/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nFqName.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FqName.kt\norg/jetbrains/kotlin/name/FqName\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
public final class FqName {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final FqNameUnsafe fqName;
    @Nullable
    private transient FqName parent;
    @JvmField
    @NotNull
    public static final FqName ROOT = new FqName("");

    public FqName(@NotNull String fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = new FqNameUnsafe(fqName, this);
    }

    public FqName(@NotNull FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqName(FqNameUnsafe fqName, FqName parent) {
        this.fqName = fqName;
        this.parent = parent;
    }

    @NotNull
    public final String asString() {
        return this.fqName.asString();
    }

    @NotNull
    public final FqNameUnsafe toUnsafe() {
        return this.fqName;
    }

    public final boolean isRoot() {
        return this.fqName.isRoot();
    }

    @NotNull
    public final FqName parent() {
        FqName fqName = this.parent;
        if (fqName != null) {
            FqName it = fqName;
            boolean bl2 = false;
            return it;
        }
        if (!(!this.isRoot())) {
            boolean $i$a$-check-FqName$parent$32 = false;
            String $i$a$-check-FqName$parent$32 = "root";
            throw new IllegalStateException($i$a$-check-FqName$parent$32.toString());
        }
        FqName it = fqName = new FqName(this.fqName.parent());
        boolean bl3 = false;
        this.parent = it;
        return fqName;
    }

    @NotNull
    public final FqName child(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new FqName(this.fqName.child(name), this);
    }

    @NotNull
    public final Name shortName() {
        return this.fqName.shortName();
    }

    @NotNull
    public final Name shortNameOrSpecial() {
        return this.fqName.shortNameOrSpecial();
    }

    @NotNull
    public final List<Name> pathSegments() {
        return this.fqName.pathSegments();
    }

    public final boolean startsWith(@NotNull Name segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        return this.fqName.startsWith(segment);
    }

    @NotNull
    public String toString() {
        return this.fqName.toString();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FqName)) {
            return false;
        }
        return Intrinsics.areEqual(this.fqName, ((FqName)other).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final FqName topLevel(@NotNull Name shortName) {
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            return new FqName(FqNameUnsafe.Companion.topLevel(shortName));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

