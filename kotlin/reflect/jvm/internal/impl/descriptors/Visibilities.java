/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Visibilities {
    @NotNull
    public static final Visibilities INSTANCE;
    @NotNull
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES;
    @NotNull
    private static final Public DEFAULT_VISIBILITY;

    private Visibilities() {
    }

    @Nullable
    public final Integer compareLocal$compiler_common(@NotNull Visibility first, @NotNull Visibility second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (first == second) {
            return 0;
        }
        Integer firstIndex = ORDERED_VISIBILITIES.get(first);
        Integer secondIndex = ORDERED_VISIBILITIES.get(second);
        return firstIndex == null || secondIndex == null || Intrinsics.areEqual(firstIndex, secondIndex) ? null : Integer.valueOf(firstIndex - secondIndex);
    }

    public final boolean isPrivate(@NotNull Visibility visibility2) {
        Intrinsics.checkNotNullParameter(visibility2, "visibility");
        return visibility2 == Private.INSTANCE || visibility2 == PrivateToThis.INSTANCE;
    }

    static {
        Map<Visibility, Integer> map;
        INSTANCE = new Visibilities();
        Map<Visibility, Integer> $this$ORDERED_VISIBILITIES_u24lambda_u240 = map = MapsKt.createMapBuilder();
        boolean bl2 = false;
        $this$ORDERED_VISIBILITIES_u24lambda_u240.put(PrivateToThis.INSTANCE, 0);
        $this$ORDERED_VISIBILITIES_u24lambda_u240.put(Private.INSTANCE, 0);
        $this$ORDERED_VISIBILITIES_u24lambda_u240.put(Internal.INSTANCE, 1);
        $this$ORDERED_VISIBILITIES_u24lambda_u240.put(Protected.INSTANCE, 1);
        $this$ORDERED_VISIBILITIES_u24lambda_u240.put(Public.INSTANCE, 2);
        ORDERED_VISIBILITIES = MapsKt.build(map);
        DEFAULT_VISIBILITY = Public.INSTANCE;
    }

    public static final class Inherited
    extends Visibility {
        @NotNull
        public static final Inherited INSTANCE = new Inherited();

        private Inherited() {
            super("inherited", false);
        }
    }

    public static final class Internal
    extends Visibility {
        @NotNull
        public static final Internal INSTANCE = new Internal();

        private Internal() {
            super("internal", false);
        }
    }

    public static final class InvisibleFake
    extends Visibility {
        @NotNull
        public static final InvisibleFake INSTANCE = new InvisibleFake();

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    public static final class Local
    extends Visibility {
        @NotNull
        public static final Local INSTANCE = new Local();

        private Local() {
            super("local", false);
        }
    }

    public static final class Private
    extends Visibility {
        @NotNull
        public static final Private INSTANCE = new Private();

        private Private() {
            super("private", false);
        }
    }

    public static final class PrivateToThis
    extends Visibility {
        @NotNull
        public static final PrivateToThis INSTANCE = new PrivateToThis();

        private PrivateToThis() {
            super("private_to_this", false);
        }

        @Override
        @NotNull
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    public static final class Protected
    extends Visibility {
        @NotNull
        public static final Protected INSTANCE = new Protected();

        private Protected() {
            super("protected", true);
        }
    }

    public static final class Public
    extends Visibility {
        @NotNull
        public static final Public INSTANCE = new Public();

        private Public() {
            super("public", true);
        }
    }

    public static final class Unknown
    extends Visibility {
        @NotNull
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super("unknown", false);
        }
    }
}

