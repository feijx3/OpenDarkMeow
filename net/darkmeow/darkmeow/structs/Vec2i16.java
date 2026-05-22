/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.JvmStatic
 *  net.darkmeow.kmogus.struct.Field
 *  net.darkmeow.kmogus.struct.Struct
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.structs;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.Arr;
import net.darkmeow.kmogus.MutableArr;
import net.darkmeow.kmogus.Ptr;
import net.darkmeow.kmogus.struct.Struct;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Struct(sizeAlignment=4L, fieldAlignment=false, size=4L)
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u001e\u0010\u0005J\u0010\u0010\u001f\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b \u0010\u0005J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#H\u0086\u0002\u00a2\u0006\u0004\b$\u0010%J \u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b/\u0010-J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0000\u00a2\u0006\u0004\b2\u00103J\u001a\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020#H\u00d6\u0001\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020=H\u00d6\u0001\u00a2\u0006\u0004\b>\u0010?R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018\u0088\u0001\u0002\u00a8\u0006A"}, d2={"Lnet/darkmeow/darkmeow/structs/Vec2i16;", "", "address", "", "constructor-impl", "(J)J", "container", "Lnet/darkmeow/kmogus/Arr;", "(Lnet/darkmeow/kmogus/Arr;)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;)J", "getAddress", "()J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "getPtr-hthgLag", "value", "", "x", "getX$annotations", "()V", "getX-impl", "(J)S", "setX-impl", "(JS)V", "y", "getY$annotations", "getY-impl", "setY-impl", "inc", "inc-YOzqQ5Q", "dec", "dec-YOzqQ5Q", "get", "index", "", "get-_WrvGpQ", "(JI)J", "set", "", "set-3trjPk0", "(JIJ)V", "plus", "offset", "plus-_WrvGpQ", "(JJ)J", "minus", "minus-_WrvGpQ", "copyTo", "dest", "copyTo-Gx-1ZdA", "(JJ)V", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "structs"})
public final class Vec2i16 {
    @NotNull
    public static final Companion Companion;
    private final long address;
    public static final long size = 4L;
    @NotNull
    private static final Unsafe UNSAFE;

    public final long getAddress() {
        return this.address;
    }

    public static final long getPtr-hthgLag(long arg0) {
        return Ptr.constructor-impl(arg0);
    }

    public static final short getX-impl(long arg0) {
        return UNSAFE.getShort(arg0);
    }

    public static final void setX-impl(long arg0, short value) {
        UNSAFE.putShort(arg0, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=0L, size=2L)
    public static /* synthetic */ void getX$annotations() {
    }

    public static final short getY-impl(long arg0) {
        return UNSAFE.getShort(arg0 + 2L);
    }

    public static final void setY-impl(long arg0, short value) {
        UNSAFE.putShort(arg0 + 2L, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=2L, size=2L)
    public static /* synthetic */ void getY$annotations() {
    }

    public static long constructor-impl(@NotNull Arr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return Vec2i16.constructor-impl(container.getPtr-hthgLag());
    }

    public static long constructor-impl(@NotNull MutableArr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return Vec2i16.constructor-impl(container.getPtr-hthgLag());
    }

    public static final long inc-YOzqQ5Q(long arg0) {
        return Vec2i16.constructor-impl(arg0 + 4L);
    }

    public static final long dec-YOzqQ5Q(long arg0) {
        return Vec2i16.constructor-impl(arg0 - 4L);
    }

    public static final long get-_WrvGpQ(long arg0, int index) {
        return Vec2i16.constructor-impl(arg0 + (long)index * 4L);
    }

    public static final void set-3trjPk0(long arg0, int index, long value) {
        UNSAFE.copyMemory(value, arg0 + (long)index * 4L, 4L);
    }

    public static final long plus-_WrvGpQ(long arg0, long offset) {
        return Vec2i16.constructor-impl(arg0 + offset);
    }

    public static final long minus-_WrvGpQ(long arg0, long offset) {
        return Vec2i16.constructor-impl(arg0 - offset);
    }

    public static final void copyTo-Gx-1ZdA(long arg0, long dest) {
        UNSAFE.copyMemory(arg0, dest, 4L);
    }

    public static String toString-impl(long arg0) {
        return "Vec2i16(address=" + arg0 + ')';
    }

    public String toString() {
        return Vec2i16.toString-impl(this.address);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public int hashCode() {
        return Vec2i16.hashCode-impl(this.address);
    }

    public static boolean equals-impl(long arg0, Object other) {
        if (!(other instanceof Vec2i16)) {
            return false;
        }
        long l2 = ((Vec2i16)other).unbox-impl();
        return arg0 == l2;
    }

    public boolean equals(Object other) {
        return Vec2i16.equals-impl(this.address, other);
    }

    private /* synthetic */ Vec2i16(long address) {
        this.address = address;
    }

    public static long constructor-impl(long address) {
        return address;
    }

    public static final /* synthetic */ Vec2i16 box-impl(long v2) {
        return new Vec2i16(v2);
    }

    public final /* synthetic */ long unbox-impl() {
        return this.address;
    }

    public static final boolean equals-impl0(long p1, long p2) {
        return p1 == p2;
    }

    @JvmStatic
    public static final long invoke-5hcdBc8(@NotNull Arr container, short x2, short y2) {
        return Companion.invoke-5hcdBc8(container, x2, y2);
    }

    @JvmStatic
    public static final long invoke-5hcdBc8(@NotNull MutableArr container, short x2, short y2) {
        return Companion.invoke-5hcdBc8(container, x2, y2);
    }

    @JvmStatic
    public static final long invoke-Ukx1-nk(long ptr) {
        return Companion.invoke-Ukx1-nk(ptr);
    }

    static {
        Companion $this$UNSAFE_u24lambda_u240 = Companion = new Companion(null);
        boolean bl2 = false;
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Object object = field.get(null);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type sun.misc.Unsafe");
        UNSAFE = (Unsafe)object;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0013J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0087\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\u00a8\u0006\u0018"}, d2={"Lnet/darkmeow/darkmeow/structs/Vec2i16$Companion;", "", "<init>", "()V", "size", "", "UNSAFE", "Lsun/misc/Unsafe;", "getUNSAFE$annotations", "invoke", "Lnet/darkmeow/darkmeow/structs/Vec2i16;", "container", "Lnet/darkmeow/kmogus/Arr;", "x", "", "y", "invoke-5hcdBc8", "(Lnet/darkmeow/kmogus/Arr;SS)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;SS)J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "invoke-Ukx1-nk", "(J)J", "structs"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        private static /* synthetic */ void getUNSAFE$annotations() {
        }

        @JvmStatic
        public final long invoke-5hcdBc8(@NotNull Arr container, short x2, short y2) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = Vec2i16.constructor-impl(container);
            Vec2i16.setX-impl(v2, x2);
            Vec2i16.setY-impl(v2, y2);
            return v2;
        }

        @JvmStatic
        public final long invoke-5hcdBc8(@NotNull MutableArr container, short x2, short y2) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = Vec2i16.constructor-impl(container);
            Vec2i16.setX-impl(v2, x2);
            Vec2i16.setY-impl(v2, y2);
            return v2;
        }

        @JvmStatic
        public final long invoke-Ukx1-nk(long ptr) {
            return Vec2i16.constructor-impl(ptr);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

