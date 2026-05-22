/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.Arr;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"ensureCapacity", "", "Lnet/darkmeow/kmogus/Arr;", "capacity", "", "init", "", "kmogus-core"})
public final class ArrKt {
    public static final void ensureCapacity(@NotNull Arr $this$ensureCapacity, long capacity, boolean init) {
        Intrinsics.checkNotNullParameter($this$ensureCapacity, "<this>");
        if (capacity > $this$ensureCapacity.getLen()) {
            $this$ensureCapacity.realloc(Math.max(capacity, $this$ensureCapacity.getLen() * (long)2), init);
        }
    }
}

