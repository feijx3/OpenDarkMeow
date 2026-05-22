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
@Struct(sizeAlignment=4L, fieldAlignment=false, size=12L)
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 D2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010!\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\"\u0010\u0005J\u0010\u0010#\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b$\u0010\u0005J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'H\u0086\u0002\u00a2\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b3\u00101J\u0015\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u0000\u00a2\u0006\u0004\b6\u00107J\u001a\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020'H\u00d6\u0001\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020AH\u00d6\u0001\u00a2\u0006\u0004\bB\u0010CR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R*\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018\u0088\u0001\u0002\u00a8\u0006E"}, d2={"Lnet/darkmeow/darkmeow/structs/Vec3f32;", "", "address", "", "constructor-impl", "(J)J", "container", "Lnet/darkmeow/kmogus/Arr;", "(Lnet/darkmeow/kmogus/Arr;)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;)J", "getAddress", "()J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "getPtr-hthgLag", "value", "", "x", "getX$annotations", "()V", "getX-impl", "(J)F", "setX-impl", "(JF)V", "y", "getY$annotations", "getY-impl", "setY-impl", "z", "getZ$annotations", "getZ-impl", "setZ-impl", "inc", "inc-tPMY5Fc", "dec", "dec-tPMY5Fc", "get", "index", "", "get-un8hUI4", "(JI)J", "set", "", "set-GWZUtcY", "(JIJ)V", "plus", "offset", "plus-un8hUI4", "(JJ)J", "minus", "minus-un8hUI4", "copyTo", "dest", "copyTo-9ficVUs", "(JJ)V", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "structs"})
public final class Vec3f32 {
    @NotNull
    public static final Companion Companion;
    private final long address;
    public static final long size = 12L;
    @NotNull
    private static final Unsafe UNSAFE;

    public final long getAddress() {
        return this.address;
    }

    public static final long getPtr-hthgLag(long arg0) {
        return Ptr.constructor-impl(arg0);
    }

    public static final float getX-impl(long arg0) {
        return UNSAFE.getFloat(arg0);
    }

    public static final void setX-impl(long arg0, float value) {
        UNSAFE.putFloat(arg0, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=0L, size=4L)
    public static /* synthetic */ void getX$annotations() {
    }

    public static final float getY-impl(long arg0) {
        return UNSAFE.getFloat(arg0 + 4L);
    }

    public static final void setY-impl(long arg0, float value) {
        UNSAFE.putFloat(arg0 + 4L, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=4L, size=4L)
    public static /* synthetic */ void getY$annotations() {
    }

    public static final float getZ-impl(long arg0) {
        return UNSAFE.getFloat(arg0 + 8L);
    }

    public static final void setZ-impl(long arg0, float value) {
        UNSAFE.putFloat(arg0 + 8L, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=8L, size=4L)
    public static /* synthetic */ void getZ$annotations() {
    }

    public static long constructor-impl(@NotNull Arr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return Vec3f32.constructor-impl(container.getPtr-hthgLag());
    }

    public static long constructor-impl(@NotNull MutableArr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return Vec3f32.constructor-impl(container.getPtr-hthgLag());
    }

    public static final long inc-tPMY5Fc(long arg0) {
        return Vec3f32.constructor-impl(arg0 + 12L);
    }

    public static final long dec-tPMY5Fc(long arg0) {
        return Vec3f32.constructor-impl(arg0 - 12L);
    }

    public static final long get-un8hUI4(long arg0, int index) {
        return Vec3f32.constructor-impl(arg0 + (long)index * 12L);
    }

    public static final void set-GWZUtcY(long arg0, int index, long value) {
        UNSAFE.copyMemory(value, arg0 + (long)index * 12L, 12L);
    }

    public static final long plus-un8hUI4(long arg0, long offset) {
        return Vec3f32.constructor-impl(arg0 + offset);
    }

    public static final long minus-un8hUI4(long arg0, long offset) {
        return Vec3f32.constructor-impl(arg0 - offset);
    }

    public static final void copyTo-9ficVUs(long arg0, long dest) {
        UNSAFE.copyMemory(arg0, dest, 12L);
    }

    public static String toString-impl(long arg0) {
        return "Vec3f32(address=" + arg0 + ')';
    }

    public String toString() {
        return Vec3f32.toString-impl(this.address);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public int hashCode() {
        return Vec3f32.hashCode-impl(this.address);
    }

    public static boolean equals-impl(long arg0, Object other) {
        if (!(other instanceof Vec3f32)) {
            return false;
        }
        long l2 = ((Vec3f32)other).unbox-impl();
        return arg0 == l2;
    }

    public boolean equals(Object other) {
        return Vec3f32.equals-impl(this.address, other);
    }

    private /* synthetic */ Vec3f32(long address) {
        this.address = address;
    }

    public static long constructor-impl(long address) {
        return address;
    }

    public static final /* synthetic */ Vec3f32 box-impl(long v2) {
        return new Vec3f32(v2);
    }

    public final /* synthetic */ long unbox-impl() {
        return this.address;
    }

    public static final boolean equals-impl0(long p1, long p2) {
        return p1 == p2;
    }

    @JvmStatic
    public static final long invoke-gnSc4YI(@NotNull Arr container, float x2, float y2, float z2) {
        return Companion.invoke-gnSc4YI(container, x2, y2, z2);
    }

    @JvmStatic
    public static final long invoke-gnSc4YI(@NotNull MutableArr container, float x2, float y2, float z2) {
        return Companion.invoke-gnSc4YI(container, x2, y2, z2);
    }

    @JvmStatic
    public static final long invoke-s9b83c4(long ptr) {
        return Companion.invoke-s9b83c4(ptr);
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
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\u00a8\u0006\u0019"}, d2={"Lnet/darkmeow/darkmeow/structs/Vec3f32$Companion;", "", "<init>", "()V", "size", "", "UNSAFE", "Lsun/misc/Unsafe;", "getUNSAFE$annotations", "invoke", "Lnet/darkmeow/darkmeow/structs/Vec3f32;", "container", "Lnet/darkmeow/kmogus/Arr;", "x", "", "y", "z", "invoke-gnSc4YI", "(Lnet/darkmeow/kmogus/Arr;FFF)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;FFF)J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "invoke-s9b83c4", "(J)J", "structs"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        private static /* synthetic */ void getUNSAFE$annotations() {
        }

        @JvmStatic
        public final long invoke-gnSc4YI(@NotNull Arr container, float x2, float y2, float z2) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = Vec3f32.constructor-impl(container);
            Vec3f32.setX-impl(v2, x2);
            Vec3f32.setY-impl(v2, y2);
            Vec3f32.setZ-impl(v2, z2);
            return v2;
        }

        @JvmStatic
        public final long invoke-gnSc4YI(@NotNull MutableArr container, float x2, float y2, float z2) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = Vec3f32.constructor-impl(container);
            Vec3f32.setX-impl(v2, x2);
            Vec3f32.setY-impl(v2, y2);
            Vec3f32.setZ-impl(v2, z2);
            return v2;
        }

        @JvmStatic
        public final long invoke-s9b83c4(long ptr) {
            return Vec3f32.constructor-impl(ptr);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

