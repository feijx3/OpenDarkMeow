/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.kmogus;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.ArrImpl;
import net.darkmeow.kmogus.ContainerDelegated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/kmogus/MemoryCleaner;", "Ljava/lang/Runnable;", "<init>", "()V", "refQueue", "Ljava/lang/ref/ReferenceQueue;", "Lnet/darkmeow/kmogus/ArrImpl;", "refHead", "Lnet/darkmeow/kmogus/MemoryCleaner$Reference;", "register", "", "container", "run", "Reference", "kmogus-core"})
public final class MemoryCleaner
implements Runnable {
    @NotNull
    public static final MemoryCleaner INSTANCE = new MemoryCleaner();
    @NotNull
    private static final ReferenceQueue<ArrImpl> refQueue = new ReferenceQueue();
    @Nullable
    private static Reference refHead;

    private MemoryCleaner() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void register(@NotNull ArrImpl container) {
        Intrinsics.checkNotNullParameter(container, "container");
        Reference ref = new Reference(container);
        Object object = Reference.Companion.getLock();
        synchronized (object) {
            boolean bl2 = false;
            Reference head = refHead;
            if (head != null) {
                head.prev = ref;
                ref.next = head;
            }
            refHead = ref;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    public void run() {
        while (true) {
            java.lang.ref.Reference<ArrImpl> reference = refQueue.remove();
            Intrinsics.checkNotNull(reference, "null cannot be cast to non-null type net.darkmeow.kmogus.MemoryCleaner.Reference");
            ((Reference)reference).free();
        }
    }

    static {
        Thread thread2 = new Thread((Runnable)INSTANCE, "Memory Cleaner");
        thread2.setDaemon(true);
        thread2.start();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/kmogus/MemoryCleaner$Reference;", "Ljava/lang/ref/PhantomReference;", "Lnet/darkmeow/kmogus/ArrImpl;", "ref", "<init>", "(Lnet/darkmeow/kmogus/ArrImpl;)V", "container", "Lnet/darkmeow/kmogus/ContainerDelegated;", "prev", "next", "free", "", "tryRemove", "Companion", "kmogus-core"})
    private static final class Reference
    extends PhantomReference<ArrImpl> {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final ContainerDelegated container;
        @JvmField
        @Nullable
        public volatile Reference prev;
        @JvmField
        @Nullable
        public volatile Reference next;
        @NotNull
        private static final Object lock = new Object();

        public Reference(@NotNull ArrImpl ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            super(ref, refQueue);
            this.container = ref.getDelegated();
        }

        public final void free() {
            this.tryRemove();
            this.container.free();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private final void tryRemove() {
            Object object = lock;
            synchronized (object) {
                boolean bl2 = false;
                Reference thisNext = this.next;
                Reference thisPrev = this.prev;
                if (thisPrev == null && thisNext == null) {
                    return;
                }
                if (thisPrev != null) {
                    thisPrev.next = thisNext;
                }
                if (thisNext != null) {
                    thisNext.prev = thisPrev;
                }
                this.prev = null;
                this.next = null;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lnet/darkmeow/kmogus/MemoryCleaner$Reference$Companion;", "", "<init>", "()V", "lock", "getLock", "()Ljava/lang/Object;", "kmogus-core"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Object getLock() {
                return lock;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

