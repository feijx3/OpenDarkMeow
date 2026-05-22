/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import org.jetbrains.annotations.NotNull;

public final class MemberKind
extends Enum<MemberKind> {
    @NotNull
    private final FlagImpl flag;
    public static final /* enum */ MemberKind DECLARATION = new MemberKind(0);
    public static final /* enum */ MemberKind FAKE_OVERRIDE = new MemberKind(1);
    public static final /* enum */ MemberKind DELEGATION = new MemberKind(2);
    public static final /* enum */ MemberKind SYNTHESIZED = new MemberKind(3);
    private static final /* synthetic */ MemberKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private MemberKind(int kind2) {
        Flags.FlagField<ProtoBuf.MemberKind> flagField = Flags.MEMBER_KIND;
        Intrinsics.checkNotNullExpressionValue(flagField, "MEMBER_KIND");
        this.flag = new FlagImpl(flagField, kind2);
    }

    @NotNull
    public final FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }

    public static MemberKind[] values() {
        return (MemberKind[])$VALUES.clone();
    }

    public static MemberKind valueOf(String value) {
        return Enum.valueOf(MemberKind.class, value);
    }

    @NotNull
    public static EnumEntries<MemberKind> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = memberKindArray = new MemberKind[]{MemberKind.DECLARATION, MemberKind.FAKE_OVERRIDE, MemberKind.DELEGATION, MemberKind.SYNTHESIZED};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

