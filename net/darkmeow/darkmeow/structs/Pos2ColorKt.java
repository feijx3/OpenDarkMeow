/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.structs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import net.darkmeow.darkmeow.structs.Pos2Color;
import net.darkmeow.darkmeow.structs.Pos2ColorKt;
import net.darkmeow.kmogus.MemoryStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a2\u0006\u0002\u0010\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u0001\u0012\u0002\b\u00030\t\u001a\u0018\u0010\n\u001a\u00020\u00052\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u0001\u0012\u0002\b\u00030\t\u00a8\u0006\u000b"}, d2={"Pos2Color", "Lnet/darkmeow/darkmeow/structs/Pos2Color;", "Lnet/darkmeow/kmogus/MemoryStack;", "(Lnet/darkmeow/kmogus/MemoryStack;)J", "sizeof", "", "dummy", "Lnet/darkmeow/darkmeow/structs/Pos2Color$Companion;", "f", "Lkotlin/reflect/KMutableProperty1;", "offsetof", "structs"})
public final class Pos2ColorKt {
    public static final long Pos2Color(@NotNull MemoryStack $this$Pos2Color) {
        Intrinsics.checkNotNullParameter($this$Pos2Color, "<this>");
        return Pos2Color.constructor-impl($this$Pos2Color.calloc(12L));
    }

    public static final long sizeof(@NotNull Pos2Color.Companion dummy) {
        Intrinsics.checkNotNullParameter(dummy, "dummy");
        return 12L;
    }

    public static final long sizeof(@NotNull KMutableProperty1<Pos2Color, ?> f2) {
        long l2;
        Intrinsics.checkNotNullParameter(f2, "f");
        KMutableProperty1<Pos2Color, ?> kMutableProperty1 = f2;
        if (Intrinsics.areEqual(kMutableProperty1, sizeof.1.INSTANCE)) {
            l2 = 8L;
        } else if (Intrinsics.areEqual(kMutableProperty1, sizeof.2.INSTANCE)) {
            l2 = 4L;
        } else {
            throw new IllegalArgumentException("Unknown field " + f2);
        }
        return l2;
    }

    public static final long offsetof(@NotNull KMutableProperty1<Pos2Color, ?> f2) {
        long l2;
        Intrinsics.checkNotNullParameter(f2, "f");
        KMutableProperty1<Pos2Color, ?> kMutableProperty1 = f2;
        if (Intrinsics.areEqual(kMutableProperty1, offsetof.1.INSTANCE)) {
            l2 = 0L;
        } else if (Intrinsics.areEqual(kMutableProperty1, offsetof.2.INSTANCE)) {
            l2 = 8L;
        } else {
            throw new IllegalArgumentException("Unknown field " + f2);
        }
        return l2;
    }
}

