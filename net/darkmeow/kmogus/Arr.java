/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import java.nio.Buffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.kmogus.ArrImpl;
import net.darkmeow.kmogus.ArrWrapped;
import net.darkmeow.kmogus.MemoryCleaner;
import net.darkmeow.kmogus.MemoryTracker;
import net.darkmeow.kmogus.Ptr;
import net.darkmeow.kmogus.UtilsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00060\u0001j\u0002`\u0002:\u0001\u0011J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\u0012\u00c0\u0006\u0003"}, d2={"Lnet/darkmeow/kmogus/Arr;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "getPtr-hthgLag", "()J", "len", "", "getLen", "realloc", "newLength", "init", "", "free", "", "close", "Companion", "kmogus-core"})
public interface Arr
extends AutoCloseable {
    @NotNull
    public static final Companion Companion = net.darkmeow.kmogus.Arr$Companion.$$INSTANCE;

    public long getPtr-hthgLag();

    public long getLen();

    @NotNull
    public Arr realloc(long var1, boolean var3);

    public void free();

    @Override
    default public void close() {
        this.free();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/kmogus/Arr$Companion;", "", "<init>", "()V", "wrap", "Lnet/darkmeow/kmogus/Arr;", "buffer", "Ljava/nio/Buffer;", "offset", "", "address", "length", "malloc", "calloc", "kmogus-core"})
    @SourceDebugExtension(value={"SMAP\nArr.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arr.kt\nnet/darkmeow/kmogus/Arr$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        @NotNull
        public final Arr wrap(@NotNull Buffer buffer, long offset) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (!buffer.isDirect()) {
                boolean $i$a$-require-Arr$Companion$wrap$42 = false;
                String $i$a$-require-Arr$Companion$wrap$42 = "ByteBuffer must be direct";
                throw new IllegalArgumentException($i$a$-require-Arr$Companion$wrap$42.toString());
            }
            if (!(offset >= 0L)) {
                boolean $i$a$-require-Arr$Companion$wrap$52 = false;
                String $i$a$-require-Arr$Companion$wrap$52 = "Invalid offset";
                throw new IllegalArgumentException($i$a$-require-Arr$Companion$wrap$52.toString());
            }
            if (!(offset <= UtilsKt.getByteCapacity(buffer))) {
                boolean bl2 = false;
                String string = "Offset is greater than buffer capacity";
                throw new IllegalArgumentException(string.toString());
            }
            return this.wrap(UtilsKt.getAddress(buffer) + offset, UtilsKt.getByteCapacity(buffer) - offset);
        }

        @NotNull
        public final Arr wrap(@NotNull Buffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (!buffer.isDirect()) {
                boolean bl2 = false;
                String string = "ByteBuffer must be direct";
                throw new IllegalArgumentException(string.toString());
            }
            return this.wrap(UtilsKt.getAddress(buffer), UtilsKt.getByteCapacity(buffer));
        }

        @NotNull
        public final Arr wrap(long address, long length) {
            if (!(address >= 0L)) {
                boolean $i$a$-require-Arr$Companion$wrap$72 = false;
                String $i$a$-require-Arr$Companion$wrap$72 = "Invalid address";
                throw new IllegalArgumentException($i$a$-require-Arr$Companion$wrap$72.toString());
            }
            if (!(length >= 0L)) {
                boolean bl2 = false;
                String string = "Invalid length";
                throw new IllegalArgumentException(string.toString());
            }
            long ptr = Ptr.constructor-impl(address);
            if (length == 0L) {
                return new ArrImpl(ptr, 0L, null);
            }
            return new ArrWrapped(ptr, length, null);
        }

        @NotNull
        public final Arr malloc(long length) {
            if (!(length >= 0L)) {
                boolean bl2 = false;
                String string = "Invalid length";
                throw new IllegalArgumentException(string.toString());
            }
            if (length == 0L) {
                return new ArrImpl(Ptr.Companion.getNULL-hthgLag(), 0L, null);
            }
            ArrImpl pointer = new ArrImpl(MemoryTracker.INSTANCE.allocate-XvKnLUk$kmogus_core(length), length, null);
            MemoryCleaner.INSTANCE.register(pointer);
            return pointer;
        }

        @NotNull
        public final Arr calloc(long length) {
            Arr container = this.malloc(length);
            Ptr.setMemory-impl(container.getPtr-hthgLag(), length, (byte)0);
            return container;
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        public static void close(@NotNull Arr $this) {
            $this.close();
        }
    }
}

