/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide;", "", "horizontal", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal;", "vertical", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical;", "<init>", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal;Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical;)V", "getHorizontal", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal;", "setHorizontal", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal;)V", "getVertical", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical;", "setVertical", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical;)V", "Companion", "Horizontal", "Vertical", "DarkMeow"})
public final class ElementSide {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Horizontal horizontal;
    @NotNull
    private Vertical vertical;
    @NotNull
    private static final ElementSide DEFAULT = new ElementSide(Horizontal.LEFT, Vertical.UP);

    public ElementSide(@NotNull Horizontal horizontal, @NotNull Vertical vertical) {
        Intrinsics.checkNotNullParameter((Object)horizontal, "horizontal");
        Intrinsics.checkNotNullParameter((Object)vertical, "vertical");
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @NotNull
    public final Horizontal getHorizontal() {
        return this.horizontal;
    }

    public final void setHorizontal(@NotNull Horizontal horizontal) {
        Intrinsics.checkNotNullParameter((Object)horizontal, "<set-?>");
        this.horizontal = horizontal;
    }

    @NotNull
    public final Vertical getVertical() {
        return this.vertical;
    }

    public final void setVertical(@NotNull Vertical vertical) {
        Intrinsics.checkNotNullParameter((Object)vertical, "<set-?>");
        this.vertical = vertical;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Companion;", "", "<init>", "()V", "DEFAULT", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide;", "getDEFAULT", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ElementSide getDEFAULT() {
            return DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal;", "", "sideName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSideName", "()Ljava/lang/String;", "LEFT", "MIDDLE", "RIGHT", "Companion", "DarkMeow"})
    public static final class Horizontal
    extends Enum<Horizontal> {
        @NotNull
        public static final Companion Companion;
        @NotNull
        private final String sideName;
        public static final /* enum */ Horizontal LEFT;
        public static final /* enum */ Horizontal MIDDLE;
        public static final /* enum */ Horizontal RIGHT;
        private static final /* synthetic */ Horizontal[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private Horizontal(String sideName) {
            this.sideName = sideName;
        }

        @NotNull
        public final String getSideName() {
            return this.sideName;
        }

        public static Horizontal[] values() {
            return (Horizontal[])$VALUES.clone();
        }

        public static Horizontal valueOf(String value) {
            return Enum.valueOf(Horizontal.class, value);
        }

        @NotNull
        public static EnumEntries<Horizontal> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        @Nullable
        public static final Horizontal getByName(@NotNull String name) {
            return Companion.getByName(name);
        }

        static {
            LEFT = new Horizontal("Left");
            MIDDLE = new Horizontal("Middle");
            RIGHT = new Horizontal("Right");
            $VALUES = horizontalArray = new Horizontal[]{Horizontal.LEFT, Horizontal.MIDDLE, Horizontal.RIGHT};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            Companion = new Companion(null);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal$Companion;", "", "<init>", "()V", "getByName", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal;", "name", "", "DarkMeow"})
        @SourceDebugExtension(value={"SMAP\nElementSide.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementSide.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Horizontal$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n1#2:56\n*E\n"})
        public static final class Companion {
            private Companion() {
            }

            @JvmStatic
            @Nullable
            public final Horizontal getByName(@NotNull String name) {
                Object v0;
                block1: {
                    Intrinsics.checkNotNullParameter(name, "name");
                    Iterable iterable = Horizontal.getEntries();
                    for (Object t2 : iterable) {
                        Horizontal it = (Horizontal)((Object)t2);
                        boolean bl2 = false;
                        if (!Intrinsics.areEqual(it.getSideName(), name)) continue;
                        v0 = t2;
                        break block1;
                    }
                    v0 = null;
                }
                return v0;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical;", "", "sideName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSideName", "()Ljava/lang/String;", "UP", "MIDDLE", "DOWN", "Companion", "DarkMeow"})
    public static final class Vertical
    extends Enum<Vertical> {
        @NotNull
        public static final Companion Companion;
        @NotNull
        private final String sideName;
        public static final /* enum */ Vertical UP;
        public static final /* enum */ Vertical MIDDLE;
        public static final /* enum */ Vertical DOWN;
        private static final /* synthetic */ Vertical[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private Vertical(String sideName) {
            this.sideName = sideName;
        }

        @NotNull
        public final String getSideName() {
            return this.sideName;
        }

        public static Vertical[] values() {
            return (Vertical[])$VALUES.clone();
        }

        public static Vertical valueOf(String value) {
            return Enum.valueOf(Vertical.class, value);
        }

        @NotNull
        public static EnumEntries<Vertical> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        @Nullable
        public static final Vertical getByName(@NotNull String name) {
            return Companion.getByName(name);
        }

        static {
            UP = new Vertical("Up");
            MIDDLE = new Vertical("Middle");
            DOWN = new Vertical("Down");
            $VALUES = verticalArray = new Vertical[]{Vertical.UP, Vertical.MIDDLE, Vertical.DOWN};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            Companion = new Companion(null);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical$Companion;", "", "<init>", "()V", "getByName", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical;", "name", "", "DarkMeow"})
        @SourceDebugExtension(value={"SMAP\nElementSide.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementSide.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/ElementSide$Vertical$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n1#2:56\n*E\n"})
        public static final class Companion {
            private Companion() {
            }

            @JvmStatic
            @Nullable
            public final Vertical getByName(@NotNull String name) {
                Object v0;
                block1: {
                    Intrinsics.checkNotNullParameter(name, "name");
                    Iterable iterable = Vertical.getEntries();
                    for (Object t2 : iterable) {
                        Vertical it = (Vertical)((Object)t2);
                        boolean bl2 = false;
                        if (!Intrinsics.areEqual(it.getSideName(), name)) continue;
                        v0 = t2;
                        break block1;
                    }
                    v0 = null;
                }
                return v0;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

