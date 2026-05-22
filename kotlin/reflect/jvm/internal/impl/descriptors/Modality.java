/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class Modality
extends Enum<Modality> {
    @NotNull
    public static final Companion Companion;
    public static final /* enum */ Modality FINAL;
    public static final /* enum */ Modality SEALED;
    public static final /* enum */ Modality OPEN;
    public static final /* enum */ Modality ABSTRACT;
    private static final /* synthetic */ Modality[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static Modality[] values() {
        return (Modality[])$VALUES.clone();
    }

    public static Modality valueOf(String value) {
        return Enum.valueOf(Modality.class, value);
    }

    static {
        FINAL = new Modality();
        SEALED = new Modality();
        OPEN = new Modality();
        ABSTRACT = new Modality();
        $VALUES = modalityArray = new Modality[]{Modality.FINAL, Modality.SEALED, Modality.OPEN, Modality.ABSTRACT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Modality convertFromFlags(boolean sealed, boolean bl2, boolean open) {
            return sealed ? SEALED : (bl2 ? ABSTRACT : (open ? OPEN : FINAL));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

