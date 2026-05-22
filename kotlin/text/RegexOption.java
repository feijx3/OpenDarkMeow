/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.FlagEnum;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2={"Lkotlin/text/RegexOption;", "Lkotlin/text/FlagEnum;", "", "value", "", "mask", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getMask", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"})
public final class RegexOption
extends Enum<RegexOption>
implements FlagEnum {
    private final int value;
    private final int mask;
    public static final /* enum */ RegexOption IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
    public static final /* enum */ RegexOption MULTILINE = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
    public static final /* enum */ RegexOption LITERAL = new RegexOption("LITERAL", 2, 16, 0, 2, null);
    public static final /* enum */ RegexOption UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
    public static final /* enum */ RegexOption COMMENTS = new RegexOption("COMMENTS", 4, 4, 0, 2, null);
    public static final /* enum */ RegexOption DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
    public static final /* enum */ RegexOption CANON_EQ = new RegexOption("CANON_EQ", 6, 128, 0, 2, null);
    private static final /* synthetic */ RegexOption[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private RegexOption(int value, int mask) {
        this.value = value;
        this.mask = mask;
    }

    /* synthetic */ RegexOption(String string, int n2, int n3, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 2) != 0) {
            n4 = n3;
        }
        this(n3, n4);
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int getMask() {
        return this.mask;
    }

    public static RegexOption[] values() {
        return (RegexOption[])$VALUES.clone();
    }

    public static RegexOption valueOf(String value) {
        return Enum.valueOf(RegexOption.class, value);
    }

    @NotNull
    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = regexOptionArray = new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.MULTILINE, RegexOption.LITERAL, RegexOption.UNIX_LINES, RegexOption.COMMENTS, RegexOption.DOT_MATCHES_ALL, RegexOption.CANON_EQ};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

