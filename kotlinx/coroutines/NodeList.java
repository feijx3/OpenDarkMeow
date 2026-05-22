/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "<init>", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1583:1\n273#2,6:1584\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n*L\n1510#1:1584,6\n*E\n"})
public final class NodeList
extends LockFreeLinkedListHead
implements Incomplete {
    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    @NotNull
    public NodeList getList() {
        return this;
    }

    @NotNull
    public final String getString(@NotNull String state) {
        StringBuilder stringBuilder;
        StringBuilder $this$getString_u24lambda_u241 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        $this$getString_u24lambda_u241.append("List{");
        $this$getString_u24lambda_u241.append(state);
        $this$getString_u24lambda_u241.append("}[");
        boolean first = false;
        first = true;
        LockFreeLinkedListHead this_$iv = this;
        boolean $i$f$forEach = false;
        Object object = this_$iv.getNext();
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual(cur$iv, this_$iv)) {
            LockFreeLinkedListNode node = cur$iv;
            boolean bl3 = false;
            if (node instanceof JobNode) {
                if (first) {
                    first = false;
                } else {
                    $this$getString_u24lambda_u241.append(", ");
                }
                $this$getString_u24lambda_u241.append(node);
            }
            cur$iv = cur$iv.getNextNode();
        }
        $this$getString_u24lambda_u241.append("]");
        return stringBuilder.toString();
    }

    @Override
    @NotNull
    public String toString() {
        return DebugKt.getDEBUG() ? this.getString("Active") : super.toString();
    }
}

