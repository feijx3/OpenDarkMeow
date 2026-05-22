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

public final class Visibility
extends Enum<Visibility> {
    @NotNull
    private final FlagImpl flag;
    public static final /* enum */ Visibility INTERNAL = new Visibility(0);
    public static final /* enum */ Visibility PRIVATE = new Visibility(1);
    public static final /* enum */ Visibility PROTECTED = new Visibility(2);
    public static final /* enum */ Visibility PUBLIC = new Visibility(3);
    public static final /* enum */ Visibility PRIVATE_TO_THIS = new Visibility(4);
    public static final /* enum */ Visibility LOCAL = new Visibility(5);
    private static final /* synthetic */ Visibility[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Visibility(int kind2) {
        Flags.FlagField<ProtoBuf.Visibility> flagField = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(flagField, "VISIBILITY");
        this.flag = new FlagImpl(flagField, kind2);
    }

    @NotNull
    public final FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }

    public static Visibility[] values() {
        return (Visibility[])$VALUES.clone();
    }

    public static Visibility valueOf(String value) {
        return Enum.valueOf(Visibility.class, value);
    }

    @NotNull
    public static EnumEntries<Visibility> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = visibilityArray = new Visibility[]{Visibility.INTERNAL, Visibility.PRIVATE, Visibility.PROTECTED, Visibility.PUBLIC, Visibility.PRIVATE_TO_THIS, Visibility.LOCAL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

