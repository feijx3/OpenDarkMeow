/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class JvmMemberSignature {
    private JvmMemberSignature() {
    }

    @NotNull
    public final String toString() {
        return this.asString();
    }

    @NotNull
    public abstract String asString();

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final class Field
    extends JvmMemberSignature {
        @NotNull
        private final String name;
        @NotNull
        private final String desc;

        public Field(@NotNull String name, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(desc, "desc");
            super(null);
            this.name = name;
            this.desc = desc;
        }

        @NotNull
        public String getName() {
            return this.name;
        }

        @NotNull
        public String getDesc() {
            return this.desc;
        }

        @Override
        @NotNull
        public String asString() {
            return this.getName() + ':' + this.getDesc();
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.desc;
        }

        public int hashCode() {
            int result = this.name.hashCode();
            result = result * 31 + this.desc.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Field)) {
                return false;
            }
            Field field = (Field)other;
            if (!Intrinsics.areEqual(this.name, field.name)) {
                return false;
            }
            return Intrinsics.areEqual(this.desc, field.desc);
        }
    }

    public static final class Method
    extends JvmMemberSignature {
        @NotNull
        private final String name;
        @NotNull
        private final String desc;

        public Method(@NotNull String name, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(desc, "desc");
            super(null);
            this.name = name;
            this.desc = desc;
        }

        @NotNull
        public String getName() {
            return this.name;
        }

        @NotNull
        public String getDesc() {
            return this.desc;
        }

        @Override
        @NotNull
        public String asString() {
            return this.getName() + this.getDesc();
        }

        @NotNull
        public final Method copy(@NotNull String name, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(desc, "desc");
            return new Method(name, desc);
        }

        public static /* synthetic */ Method copy$default(Method method, String string, String string2, int n2, Object object) {
            if ((n2 & 1) != 0) {
                string = method.name;
            }
            if ((n2 & 2) != 0) {
                string2 = method.desc;
            }
            return method.copy(string, string2);
        }

        public int hashCode() {
            int result = this.name.hashCode();
            result = result * 31 + this.desc.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Method)) {
                return false;
            }
            Method method = (Method)other;
            if (!Intrinsics.areEqual(this.name, method.name)) {
                return false;
            }
            return Intrinsics.areEqual(this.desc, method.desc);
        }
    }
}

