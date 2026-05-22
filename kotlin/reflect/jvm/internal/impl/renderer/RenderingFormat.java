/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public abstract class RenderingFormat
extends Enum<RenderingFormat> {
    public static final /* enum */ RenderingFormat PLAIN = new PLAIN("PLAIN", 0);
    public static final /* enum */ RenderingFormat HTML = new HTML("HTML", 1);
    private static final /* synthetic */ RenderingFormat[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private RenderingFormat() {
    }

    @NotNull
    public abstract String escape(@NotNull String var1);

    public static RenderingFormat[] values() {
        return (RenderingFormat[])$VALUES.clone();
    }

    public static RenderingFormat valueOf(String value) {
        return Enum.valueOf(RenderingFormat.class, value);
    }

    public /* synthetic */ RenderingFormat(String $enum$name, int $enum$ordinal, DefaultConstructorMarker $constructor_marker) {
        this();
    }

    static {
        $VALUES = renderingFormatArray = new RenderingFormat[]{RenderingFormat.PLAIN, RenderingFormat.HTML};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }

    static final class HTML
    extends RenderingFormat {
        /*
         * WARNING - void declaration
         */
        HTML() {
            void var1_1;
        }

        @Override
        @NotNull
        public String escape(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return StringsKt.replace$default(StringsKt.replace$default(string, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    }

    static final class PLAIN
    extends RenderingFormat {
        /*
         * WARNING - void declaration
         */
        PLAIN() {
            void var1_1;
        }

        @Override
        @NotNull
        public String escape(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return string;
        }
    }
}

