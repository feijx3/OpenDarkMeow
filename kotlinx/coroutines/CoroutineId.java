/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.ThreadContextElement;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "<init>", "(J)V", "getId", "()J", "toString", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "", "oldState", "component1", "copy", "equals", "", "other", "", "hashCode", "", "Key", "kotlinx-coroutines-core"})
@IgnoreJRERequirement
@PublishedApi
public final class CoroutineId
extends AbstractCoroutineContextElement
implements ThreadContextElement<String> {
    @NotNull
    public static final Key Key = new Key(null);
    private final long id;

    public CoroutineId(long id) {
        super(Key);
        this.id = id;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.id + ')';
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public String updateThreadContext(@NotNull CoroutineContext context) {
        void $this$updateThreadContext_u24lambda_u240;
        StringBuilder stringBuilder;
        Object object = (CoroutineName)context.get(CoroutineName.Key);
        if (object == null || (object = ((CoroutineName)object).getName()) == null) {
            object = "coroutine";
        }
        Object coroutineName = object;
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        int lastIndex = 0;
        lastIndex = StringsKt.lastIndexOf$default((CharSequence)oldName, " @", 0, false, 6, null);
        if (lastIndex < 0) {
            lastIndex = oldName.length();
        }
        int n2 = lastIndex + ((String)coroutineName).length() + 10;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder(n2);
        Thread thread2 = currentThread;
        boolean bl2 = false;
        String string = oldName.substring(0, lastIndex);
        Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        $this$updateThreadContext_u24lambda_u240.append(string);
        $this$updateThreadContext_u24lambda_u240.append(" @");
        $this$updateThreadContext_u24lambda_u240.append((String)coroutineName);
        $this$updateThreadContext_u24lambda_u240.append('#');
        $this$updateThreadContext_u24lambda_u240.append(this.id);
        thread2.setName(stringBuilder.toString());
        return oldName;
    }

    @Override
    public void restoreThreadContext(@NotNull CoroutineContext context, @NotNull String oldState) {
        Thread.currentThread().setName(oldState);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final CoroutineId copy(long id) {
        return new CoroutineId(id);
    }

    public static /* synthetic */ CoroutineId copy$default(CoroutineId coroutineId, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = coroutineId.id;
        }
        return coroutineId.copy(l2);
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoroutineId)) {
            return false;
        }
        CoroutineId coroutineId = (CoroutineId)other;
        return this.id == coroutineId.id;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Key
    implements CoroutineContext.Key<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

