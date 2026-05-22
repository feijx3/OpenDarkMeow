/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nFlagDelegatesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDelegatesImpl.kt\nkotlin/metadata/internal/BooleanFlagDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
public final class BooleanFlagDelegate<Node> {
    @NotNull
    private final KMutableProperty1<Node, Integer> flags;
    @NotNull
    private final FlagImpl flag;
    private final int mask;

    public BooleanFlagDelegate(@NotNull KMutableProperty1<Node, Integer> flags, @NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.flags = flags;
        this.flag = flag;
        if (!(this.flag.getBitWidth$kotlin_metadata() == 1 && this.flag.getValue$kotlin_metadata() == 1)) {
            boolean bl2 = false;
            String string = "BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + this.flag + " was passed";
            throw new IllegalArgumentException(string.toString());
        }
        this.mask = 1 << this.flag.getOffset$kotlin_metadata();
    }

    public final boolean getValue(Node thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.flag.invoke(((Number)this.flags.get(thisRef)).intValue());
    }

    public final void setValue(Node thisRef, @NotNull KProperty<?> property, boolean value) {
        Intrinsics.checkNotNullParameter(property, "property");
        int newValue = value ? ((Number)this.flags.get(thisRef)).intValue() | this.mask : ((Number)this.flags.get(thisRef)).intValue() & ~this.mask;
        this.flags.set(thisRef, newValue);
    }
}

