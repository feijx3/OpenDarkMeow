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

public final class Modality
extends Enum<Modality> {
    @NotNull
    private final FlagImpl flag;
    public static final /* enum */ Modality FINAL = new Modality(0);
    public static final /* enum */ Modality OPEN = new Modality(1);
    public static final /* enum */ Modality ABSTRACT = new Modality(2);
    public static final /* enum */ Modality SEALED = new Modality(3);
    private static final /* synthetic */ Modality[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Modality(int kind2) {
        Flags.FlagField<ProtoBuf.Modality> flagField = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(flagField, "MODALITY");
        this.flag = new FlagImpl(flagField, kind2);
    }

    @NotNull
    public final FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }

    public static Modality[] values() {
        return (Modality[])$VALUES.clone();
    }

    public static Modality valueOf(String value) {
        return Enum.valueOf(Modality.class, value);
    }

    @NotNull
    public static EnumEntries<Modality> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = modalityArray = new Modality[]{Modality.FINAL, Modality.OPEN, Modality.ABSTRACT, Modality.SEALED};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

