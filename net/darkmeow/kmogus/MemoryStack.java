/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import java.util.ArrayDeque;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.kmogus.Arr;
import net.darkmeow.kmogus.ArrKt;
import net.darkmeow.kmogus.MemcpyKt;
import net.darkmeow.kmogus.Ptr;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u0002:\u0004\u001c\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0011\u001a\u00060\fR\u00020\u0000H\u0002J\u0014\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\fR\u00020\u0000H\u0002J\u0006\u0010\u0015\u001a\u00020\u0000J\u0014\u0010\u0016\u001a\u00060\fR\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00000\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/darkmeow/kmogus/MemoryStack;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "initCapacity", "", "<init>", "(J)V", "base", "Lnet/darkmeow/kmogus/Arr;", "baseOffset", "containerPool", "Ljava/util/ArrayDeque;", "Lnet/darkmeow/kmogus/MemoryStack$Container;", "containerStack", "Lnet/darkmeow/kmogus/MemoryStack$ContainerStack;", "counterStack", "Lnet/darkmeow/kmogus/MemoryStack$CounterStack;", "newContainer", "freeContainer", "", "frame", "push", "malloc0", "size", "malloc", "calloc", "checkEmpty", "close", "ContainerStack", "CounterStack", "Container", "Companion", "kmogus-core"})
@SourceDebugExtension(value={"SMAP\nMemoryStack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryStack.kt\nnet/darkmeow/kmogus/MemoryStack\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
public final class MemoryStack
implements AutoCloseable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Arr base;
    private long baseOffset;
    @NotNull
    private final ArrayDeque<Container> containerPool;
    @NotNull
    private final ContainerStack containerStack;
    @NotNull
    private final CounterStack counterStack;
    private static final ThreadLocal<MemoryStack> threadLocal = ThreadLocal.withInitial(MemoryStack::threadLocal$lambda$7);

    public MemoryStack(long initCapacity) {
        this.base = Arr.Companion.malloc(initCapacity);
        this.containerPool = new ArrayDeque();
        this.containerStack = new ContainerStack();
        this.counterStack = new CounterStack();
    }

    private final Container newContainer() {
        Container container = this.containerPool.pollLast();
        if (container == null) {
            container = new Container();
        }
        return container;
    }

    private final void freeContainer(Container frame) {
        this.containerPool.offerLast(frame);
    }

    @NotNull
    public final MemoryStack push() {
        if (!(this.counterStack.getIndex() >= -1)) {
            boolean bl2 = false;
            String string = "Memory stack is corrupted: frameCounter=" + this.counterStack.getIndex();
            throw new IllegalStateException(string.toString());
        }
        this.counterStack.push();
        return this;
    }

    private final Container malloc0(long size) {
        if (!(this.baseOffset >= 0L)) {
            boolean $i$a$-check-MemoryStack$malloc0$22 = false;
            String $i$a$-check-MemoryStack$malloc0$22 = "Memory stack is corrupted: baseOffset=" + this.baseOffset;
            throw new IllegalStateException($i$a$-check-MemoryStack$malloc0$22.toString());
        }
        Container container = this.newContainer();
        long alignedSize = size + 7L & 0xFFFFFFF8L;
        long offset = this.baseOffset;
        this.baseOffset += alignedSize;
        ArrKt.ensureCapacity(this.base, this.baseOffset, false);
        this.counterStack.inc();
        container.setFrameIndex(this.counterStack.getIndex());
        container.setStackIndex(this.containerStack.push(container));
        container.setOffset(offset);
        container.setLen(size);
        container.setPadding(alignedSize - size);
        return container;
    }

    @NotNull
    public final Arr malloc(long size) {
        return this.malloc0(size);
    }

    @NotNull
    public final Arr calloc(long size) {
        Container container = this.malloc0(size);
        Ptr.setMemory-impl(container.getPtr-hthgLag(), size, (byte)0);
        return container;
    }

    public final void checkEmpty() {
        if (!(this.counterStack.getIndex() == -1)) {
            boolean $i$a$-check-MemoryStack$checkEmpty$32 = false;
            String $i$a$-check-MemoryStack$checkEmpty$32 = "Memory stack is not empty: frameCounter=" + this.counterStack.getIndex();
            throw new IllegalStateException($i$a$-check-MemoryStack$checkEmpty$32.toString());
        }
        if (!(this.containerStack.getSize() == 0)) {
            boolean bl2 = false;
            String string = "Memory stack is not empty: containerStack.size=" + this.containerStack.getSize();
            throw new IllegalStateException(string.toString());
        }
    }

    @Override
    public void close() {
        if (!(this.counterStack.getIndex() >= -1)) {
            boolean $i$a$-check-MemoryStack$close$32 = false;
            String $i$a$-check-MemoryStack$close$32 = "Memory stack is corrupted: frameCounter=" + this.counterStack.getIndex();
            throw new IllegalStateException($i$a$-check-MemoryStack$close$32.toString());
        }
        if (!(this.counterStack.getIndex() != -1)) {
            boolean bl2 = false;
            String string = "Memory stack is empty: frameCounter=" + this.counterStack.getIndex();
            throw new IllegalStateException(string.toString());
        }
        int n2 = this.counterStack.pop();
        int n3 = 0;
        while (n3 < n2) {
            int it = n3++;
            boolean bl3 = false;
            this.containerStack.peek().release();
        }
    }

    private static final MemoryStack threadLocal$lambda$7() {
        return new MemoryStack(0x100000L);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0006J0\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\n0\f\u00a2\u0006\u0002\b\rH\u0086\n\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000f"}, d2={"Lnet/darkmeow/kmogus/MemoryStack$Companion;", "", "<init>", "()V", "threadLocal", "Ljava/lang/ThreadLocal;", "Lnet/darkmeow/kmogus/MemoryStack;", "kotlin.jvm.PlatformType", "get", "invoke", "T", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kmogus-core"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MemoryStack get() {
            Object t2 = threadLocal.get();
            Intrinsics.checkNotNullExpressionValue(t2, "get(...)");
            return (MemoryStack)t2;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final <T> T invoke(@NotNull Function1<? super MemoryStack, ? extends T> block) {
            T t2;
            Intrinsics.checkNotNullParameter(block, "block");
            boolean $i$f$invoke = false;
            AutoCloseable autoCloseable = this.get().push();
            Throwable throwable = null;
            try {
                t2 = block.invoke((MemoryStack)autoCloseable);
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                InlineMarker.finallyStart(1);
                AutoCloseableKt.closeFinally(autoCloseable, throwable);
                InlineMarker.finallyEnd(1);
            }
            return t2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012\u00a8\u0006#"}, d2={"Lnet/darkmeow/kmogus/MemoryStack$Container;", "Lnet/darkmeow/kmogus/Arr;", "<init>", "(Lnet/darkmeow/kmogus/MemoryStack;)V", "stackIndex", "", "getStackIndex", "()I", "setStackIndex", "(I)V", "frameIndex", "getFrameIndex", "setFrameIndex", "offset", "", "getOffset", "()J", "setOffset", "(J)V", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "getPtr-hthgLag", "len", "getLen", "setLen", "padding", "getPadding", "setPadding", "realloc", "newLength", "init", "", "free", "", "release", "kmogus-core"})
    @SourceDebugExtension(value={"SMAP\nMemoryStack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryStack.kt\nnet/darkmeow/kmogus/MemoryStack$Container\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
    private final class Container
    implements Arr {
        private int stackIndex;
        private int frameIndex;
        private long offset;
        private long len;
        private long padding;

        public final int getStackIndex() {
            return this.stackIndex;
        }

        public final void setStackIndex(int n2) {
            this.stackIndex = n2;
        }

        public final int getFrameIndex() {
            return this.frameIndex;
        }

        public final void setFrameIndex(int n2) {
            this.frameIndex = n2;
        }

        public final long getOffset() {
            return this.offset;
        }

        public final void setOffset(long l2) {
            this.offset = l2;
        }

        @Override
        public long getPtr-hthgLag() {
            return Ptr.plus-XvKnLUk(MemoryStack.this.base.getPtr-hthgLag(), this.offset);
        }

        @Override
        public long getLen() {
            return this.len;
        }

        public void setLen(long l2) {
            this.len = l2;
        }

        public final long getPadding() {
            return this.padding;
        }

        public final void setPadding(long l2) {
            this.padding = l2;
        }

        @Override
        @NotNull
        public Arr realloc(long newLength, boolean init) {
            if (!(this.frameIndex == MemoryStack.this.counterStack.getIndex())) {
                boolean bl2 = false;
                String string = "Cannot reallocate ptr from previous stack frame";
                throw new IllegalStateException(string.toString());
            }
            long prevOffset = this.offset;
            long prevLength = this.getLen();
            long prevPadding = this.padding;
            if (newLength == prevLength) {
                return this;
            }
            long alignedLen = newLength + 7L & 0xFFFFFFF8L;
            if (alignedLen == prevLength) {
                this.setLen(newLength);
                this.padding = alignedLen - newLength;
                return this;
            }
            if (newLength > prevLength) {
                if (MemoryStack.this.containerStack.peek() != this) {
                    Container otherPointer = MemoryStack.this.malloc0(newLength);
                    this.offset = otherPointer.offset;
                    this.padding = otherPointer.padding;
                    otherPointer.offset = prevOffset;
                    otherPointer.setLen(prevLength);
                    otherPointer.padding = prevPadding;
                    MemoryStack.this.containerStack.set(this.stackIndex, otherPointer);
                    MemoryStack.this.containerStack.set(otherPointer.stackIndex, this);
                    MemcpyKt.memcpy-ZK01Fg0(otherPointer.getPtr-hthgLag(), 0L, this.getPtr-hthgLag(), 0L, prevLength);
                } else {
                    ArrKt.ensureCapacity(MemoryStack.this.base, this.getPtr-hthgLag() - MemoryStack.this.base.getPtr-hthgLag() + newLength, false);
                    MemoryStack.this.baseOffset = MemoryStack.this.baseOffset + (newLength + this.padding - (prevLength + prevPadding));
                }
                this.setLen(newLength);
                if (init) {
                    Ptr.setMemory-impl(Ptr.plus-XvKnLUk(this.getPtr-hthgLag(), prevLength), newLength - prevLength, (byte)0);
                }
            } else {
                this.setLen(newLength);
                if (MemoryStack.this.containerStack.peek() != this) {
                    this.padding += prevLength - newLength;
                } else {
                    MemoryStack.this.baseOffset = MemoryStack.this.baseOffset - (prevLength + this.padding - alignedLen);
                    this.padding = alignedLen - newLength;
                }
            }
            return this;
        }

        @Override
        public void free() {
            throw new UnsupportedOperationException("Cannot free stack frame");
        }

        public final void release() {
            int stackTop = MemoryStack.this.counterStack.getIndex() + 1;
            if (!(this.frameIndex == stackTop)) {
                boolean bl2 = false;
                String string = "Frame stack is corrupted while releasing top pointers, expected current frame: " + this.frameIndex + ", actual: " + stackTop;
                throw new IllegalStateException(string.toString());
            }
            Container last = MemoryStack.this.containerStack.pop();
            if (!(last == this)) {
                boolean bl3 = false;
                String string = "Frame stack is corrupted while releasing top pointers, expected ptr: " + this + ", actual: " + last;
                throw new IllegalStateException(string.toString());
            }
            MemoryStack.this.baseOffset = MemoryStack.this.baseOffset - this.getLen();
            boolean bl4 = MemoryStack.this.baseOffset >= 0L;
            MemoryStack memoryStack = MemoryStack.this;
            if (!bl4) {
                boolean bl5 = false;
                String string = "Frame stack is corrupted while releasing top pointers, baseOffset: " + memoryStack.baseOffset;
                throw new IllegalStateException(string.toString());
            }
            MemoryStack.this.freeContainer(this);
        }

        @Override
        public void close() {
            Arr.super.close();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u00052\n\u0010\u000f\u001a\u00060\u000bR\u00020\fJ\n\u0010\u0010\u001a\u00060\u000bR\u00020\fJ\n\u0010\u0011\u001a\u00060\u000bR\u00020\fJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\n\u0010\u000f\u001a\u00060\u000bR\u00020\fH\u0086\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0018\u00010\u000bR\u00020\f0\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0015"}, d2={"Lnet/darkmeow/kmogus/MemoryStack$ContainerStack;", "", "<init>", "()V", "value", "", "size", "getSize", "()I", "array", "", "Lnet/darkmeow/kmogus/MemoryStack$Container;", "Lnet/darkmeow/kmogus/MemoryStack;", "[Lnet/darkmeow/kmogus/MemoryStack$Container;", "push", "container", "pop", "peek", "set", "", "index", "kmogus-core"})
    private static final class ContainerStack {
        private int size;
        @NotNull
        private Container[] array = new Container[16];

        public final int getSize() {
            return this.size;
        }

        public final int push(@NotNull Container container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (this.size == this.array.length) {
                Container[] containerArray = Arrays.copyOf(this.array, this.size * 2);
                Intrinsics.checkNotNullExpressionValue(containerArray, "copyOf(...)");
                this.array = containerArray;
            }
            this.array[this.size] = container;
            int n2 = this.size;
            this.size = n2 + 1;
            return n2;
        }

        @NotNull
        public final Container pop() {
            this.size += -1;
            Container container = this.array[this.size];
            Intrinsics.checkNotNull(container);
            return container;
        }

        @NotNull
        public final Container peek() {
            Container container = this.array[this.size - 1];
            Intrinsics.checkNotNull(container);
            return container;
        }

        public final void set(int index, @NotNull Container container) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.array[index] = container;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000eR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/darkmeow/kmogus/MemoryStack$CounterStack;", "", "<init>", "()V", "value", "", "index", "getIndex", "()I", "array", "", "push", "pop", "inc", "", "kmogus-core"})
    private static final class CounterStack {
        private int index = -1;
        @NotNull
        private int[] array = new int[16];

        public final int getIndex() {
            return this.index;
        }

        public final int push() {
            ++this.index;
            if (this.index == this.array.length) {
                int[] nArray = Arrays.copyOf(this.array, this.array.length * 2);
                Intrinsics.checkNotNullExpressionValue(nArray, "copyOf(...)");
                this.array = nArray;
            }
            this.array[this.index] = 0;
            return this.index;
        }

        public final int pop() {
            int n2 = this.index;
            this.index = n2 + -1;
            return this.array[n2];
        }

        public final void inc() {
            int[] nArray = this.array;
            int n2 = this.index;
            int n3 = nArray[n2];
            nArray[n2] = n3 + 1;
        }
    }
}

