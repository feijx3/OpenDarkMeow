/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaVisibilities {
    @NotNull
    public static final JavaVisibilities INSTANCE = new JavaVisibilities();

    private JavaVisibilities() {
    }

    public static final class PackageVisibility
    extends Visibility {
        @NotNull
        public static final PackageVisibility INSTANCE = new PackageVisibility();

        private PackageVisibility() {
            super("package", false);
        }

        @Override
        @Nullable
        public Integer compareTo(@NotNull Visibility visibility2) {
            Intrinsics.checkNotNullParameter(visibility2, "visibility");
            if (this == visibility2) {
                return 0;
            }
            if (Visibilities.INSTANCE.isPrivate(visibility2)) {
                return 1;
            }
            return -1;
        }

        @Override
        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }

        @Override
        @NotNull
        public String getInternalDisplayName() {
            return "public/*package*/";
        }
    }

    public static final class ProtectedAndPackage
    extends Visibility {
        @NotNull
        public static final ProtectedAndPackage INSTANCE = new ProtectedAndPackage();

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        @Override
        @Nullable
        public Integer compareTo(@NotNull Visibility visibility2) {
            Intrinsics.checkNotNullParameter(visibility2, "visibility");
            if (Intrinsics.areEqual(this, visibility2)) {
                return 0;
            }
            if (visibility2 == Visibilities.Internal.INSTANCE) {
                return null;
            }
            return Visibilities.INSTANCE.isPrivate(visibility2) ? Integer.valueOf(1) : Integer.valueOf(-1);
        }

        @Override
        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }

        @Override
        @NotNull
        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }
    }

    public static final class ProtectedStaticVisibility
    extends Visibility {
        @NotNull
        public static final ProtectedStaticVisibility INSTANCE = new ProtectedStaticVisibility();

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        @Override
        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }

        @Override
        @NotNull
        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }
    }
}

