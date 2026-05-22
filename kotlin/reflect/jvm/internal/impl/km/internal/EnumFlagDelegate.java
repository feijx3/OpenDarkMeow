/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import org.jetbrains.annotations.NotNull;

public final class EnumFlagDelegate<Node, E extends Enum<E>> {
    @NotNull
    private final KMutableProperty1<Node, Integer> flags;
    @NotNull
    private final Flags.FlagField<? extends Internal.EnumLite> protoSet;
    @NotNull
    private final EnumEntries<E> entries;
    @NotNull
    private final List<FlagImpl> flagValues;

    public EnumFlagDelegate(@NotNull KMutableProperty1<Node, Integer> flags, @NotNull Flags.FlagField<? extends Internal.EnumLite> protoSet, @NotNull EnumEntries<E> entries, @NotNull List<FlagImpl> flagValues) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(protoSet, "protoSet");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(flagValues, "flagValues");
        this.flags = flags;
        this.protoSet = protoSet;
        this.entries = entries;
        this.flagValues = flagValues;
    }

    @NotNull
    public final E getValue(Node thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return (E)((Enum)this.entries.get(this.protoSet.get(((Number)this.flags.get(thisRef)).intValue()).getNumber()));
    }
}

