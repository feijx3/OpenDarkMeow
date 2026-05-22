/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.Arr;
import net.darkmeow.kmogus.MutableArr;
import net.darkmeow.kmogus.MutableArrImpl;
import net.darkmeow.kmogus.Ptr;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a)\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\b\bH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\t"}, d2={"asMutable", "Lnet/darkmeow/kmogus/MutableArr;", "Lnet/darkmeow/kmogus/Arr;", "usePtr", "", "block", "Lkotlin/Function1;", "Lnet/darkmeow/kmogus/Ptr;", "Lkotlin/ExtensionFunctionType;", "kmogus-core"})
public final class MutableArrKt {
    @NotNull
    public static final MutableArr asMutable(@NotNull Arr $this$asMutable) {
        Intrinsics.checkNotNullParameter($this$asMutable, "<this>");
        return new MutableArrImpl($this$asMutable);
    }

    public static final void usePtr(@NotNull MutableArr $this$usePtr, @NotNull Function1<? super Ptr, Ptr> block) {
        Intrinsics.checkNotNullParameter($this$usePtr, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        boolean $i$f$usePtr = false;
        long ptr = block.invoke(Ptr.box-impl($this$usePtr.getPtr-hthgLag())).unbox-impl();
        $this$usePtr.pos-4d6bxmI(ptr);
    }
}

