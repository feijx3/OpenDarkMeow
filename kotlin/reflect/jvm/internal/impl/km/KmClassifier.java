/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class KmClassifier {
    private KmClassifier() {
    }

    public /* synthetic */ KmClassifier(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final class Class
    extends KmClassifier {
        @NotNull
        private final String name;

        public Class(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            super(null);
            this.name = name;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public String toString() {
            return "Class(name=" + this.name + ')';
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Class)) {
                return false;
            }
            Class clazz = (Class)other;
            return Intrinsics.areEqual(this.name, clazz.name);
        }
    }

    public static final class TypeAlias
    extends KmClassifier {
        @NotNull
        private final String name;

        public TypeAlias(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            super(null);
            this.name = name;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public String toString() {
            return "TypeAlias(name=" + this.name + ')';
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TypeAlias)) {
                return false;
            }
            TypeAlias typeAlias = (TypeAlias)other;
            return Intrinsics.areEqual(this.name, typeAlias.name);
        }
    }

    public static final class TypeParameter
    extends KmClassifier {
        private final int id;

        public TypeParameter(int id) {
            super(null);
            this.id = id;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public String toString() {
            return "TypeParameter(id=" + this.id + ')';
        }

        public int hashCode() {
            return Integer.hashCode(this.id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TypeParameter)) {
                return false;
            }
            TypeParameter typeParameter = (TypeParameter)other;
            return this.id == typeParameter.id;
        }
    }
}

