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
import net.darkmeow.darkmeow.structs.Vec2f32;
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
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010\u001f\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b \u0010\u0005J\u0010\u0010!\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\"\u0010\u0005J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0018H\u0086\u0002\u00a2\u0006\u0004\b%\u0010&J \u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b0\u0010.J\u0015\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0000\u00a2\u0006\u0004\b3\u0010\u0017J\u001a\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0018H\u00d6\u0001\u00a2\u0006\u0004\b:\u0010\u001cJ\u0010\u0010;\u001a\u00020<H\u00d6\u0001\u00a2\u0006\u0004\b=\u0010>R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00188F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u0088\u0001\u0002\u00a8\u0006@"}, d2={"Lnet/darkmeow/darkmeow/structs/Pos2Color;", "", "address", "", "constructor-impl", "(J)J", "container", "Lnet/darkmeow/kmogus/Arr;", "(Lnet/darkmeow/kmogus/Arr;)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;)J", "getAddress", "()J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "getPtr-hthgLag", "value", "Lnet/darkmeow/darkmeow/structs/Vec2f32;", "pos", "getPos-jky1oZU$annotations", "()V", "getPos-jky1oZU", "setPos-uc71As0", "(JJ)V", "", "color", "getColor$annotations", "getColor-impl", "(J)I", "setColor-impl", "(JI)V", "inc", "inc-PBHcseE", "dec", "dec-PBHcseE", "get", "index", "get-v0whih4", "(JI)J", "set", "", "set-Ql_RSyw", "(JIJ)V", "plus", "offset", "plus-v0whih4", "(JJ)J", "minus", "minus-v0whih4", "copyTo", "dest", "copyTo-QV5nzNY", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "structs"})
public final class Pos2Color {
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

    public static final long getPos-jky1oZU(long arg0) {
        return Vec2f32.constructor-impl(arg0);
    }

    public static final void setPos-uc71As0(long arg0, long value) {
        UNSAFE.copyMemory(value, arg0, 8L);
    }

    @net.darkmeow.kmogus.struct.Field(offset=0L, size=8L)
    public static /* synthetic */ void getPos-jky1oZU$annotations() {
    }

    public static final int getColor-impl(long arg0) {
        return UNSAFE.getInt(arg0 + 8L);
    }

    public static final void setColor-impl(long arg0, int value) {
        UNSAFE.putInt(arg0 + 8L, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=8L, size=4L)
    public static /* synthetic */ void getColor$annotations() {
    }

    public static long constructor-impl(@NotNull Arr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return Pos2Color.constructor-impl(container.getPtr-hthgLag());
    }

    public static long constructor-impl(@NotNull MutableArr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return Pos2Color.constructor-impl(container.getPtr-hthgLag());
    }

    public static final long inc-PBHcseE(long arg0) {
        return Pos2Color.constructor-impl(arg0 + 12L);
    }

    public static final long dec-PBHcseE(long arg0) {
        return Pos2Color.constructor-impl(arg0 - 12L);
    }

    public static final long get-v0whih4(long arg0, int index) {
        return Pos2Color.constructor-impl(arg0 + (long)index * 12L);
    }

    public static final void set-Ql_RSyw(long arg0, int index, long value) {
        UNSAFE.copyMemory(value, arg0 + (long)index * 12L, 12L);
    }

    public static final long plus-v0whih4(long arg0, long offset) {
        return Pos2Color.constructor-impl(arg0 + offset);
    }

    public static final long minus-v0whih4(long arg0, long offset) {
        return Pos2Color.constructor-impl(arg0 - offset);
    }

    public static final void copyTo-QV5nzNY(long arg0, long dest) {
        UNSAFE.copyMemory(arg0, dest, 12L);
    }

    public static String toString-impl(long arg0) {
        return "Pos2Color(address=" + arg0 + ')';
    }

    public String toString() {
        return Pos2Color.toString-impl(this.address);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public int hashCode() {
        return Pos2Color.hashCode-impl(this.address);
    }

    public static boolean equals-impl(long arg0, Object other) {
        if (!(other instanceof Pos2Color)) {
            return false;
        }
        long l2 = ((Pos2Color)other).unbox-impl();
        return arg0 == l2;
    }

    public boolean equals(Object other) {
        return Pos2Color.equals-impl(this.address, other);
    }

    private /* synthetic */ Pos2Color(long address) {
        this.address = address;
    }

    public static long constructor-impl(long address) {
        return address;
    }

    public static final /* synthetic */ Pos2Color box-impl(long v2) {
        return new Pos2Color(v2);
    }

    public final /* synthetic */ long unbox-impl() {
        return this.address;
    }

    public static final boolean equals-impl0(long p1, long p2) {
        return p1 == p2;
    }

    @JvmStatic
    public static final long invoke-rwVKKTQ(@NotNull Arr container, long pos, int color) {
        return Companion.invoke-rwVKKTQ(container, pos, color);
    }

    @JvmStatic
    public static final long invoke-rwVKKTQ(@NotNull MutableArr container, long pos, int color) {
        return Companion.invoke-rwVKKTQ(container, pos, color);
    }

    @JvmStatic
    public static final long invoke-lEfvHJo(long ptr) {
        return Companion.invoke-lEfvHJo(ptr);
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
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\u00a8\u0006\u0019"}, d2={"Lnet/darkmeow/darkmeow/structs/Pos2Color$Companion;", "", "<init>", "()V", "size", "", "UNSAFE", "Lsun/misc/Unsafe;", "getUNSAFE$annotations", "invoke", "Lnet/darkmeow/darkmeow/structs/Pos2Color;", "container", "Lnet/darkmeow/kmogus/Arr;", "pos", "Lnet/darkmeow/darkmeow/structs/Vec2f32;", "color", "", "invoke-rwVKKTQ", "(Lnet/darkmeow/kmogus/Arr;JI)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;JI)J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "invoke-lEfvHJo", "(J)J", "structs"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        private static /* synthetic */ void getUNSAFE$annotations() {
        }

        @JvmStatic
        public final long invoke-rwVKKTQ(@NotNull Arr container, long pos, int color) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = Pos2Color.constructor-impl(container);
            Pos2Color.setPos-uc71As0(v2, pos);
            Pos2Color.setColor-impl(v2, color);
            return v2;
        }

        @JvmStatic
        public final long invoke-rwVKKTQ(@NotNull MutableArr container, long pos, int color) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = Pos2Color.constructor-impl(container);
            Pos2Color.setPos-uc71As0(v2, pos);
            Pos2Color.setColor-impl(v2, color);
            return v2;
        }

        @JvmStatic
        public final long invoke-lEfvHJo(long ptr) {
            return Pos2Color.constructor-impl(ptr);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

