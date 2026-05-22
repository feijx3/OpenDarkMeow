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
import net.darkmeow.darkmeow.structs.Vec2i16;
import net.darkmeow.kmogus.Arr;
import net.darkmeow.kmogus.MutableArr;
import net.darkmeow.kmogus.Ptr;
import net.darkmeow.kmogus.struct.Struct;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Struct(sizeAlignment=4L, fieldAlignment=false, size=16L)
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 N2\u00020\u0001:\u0001NB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010,\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b-\u0010\u0005J\u0010\u0010.\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b/\u0010\u0005J\u0018\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u000202H\u0086\u0002\u00a2\u0006\u0004\b3\u00104J \u00105\u001a\u0002062\u0006\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b>\u0010<J\u0015\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020\u0000\u00a2\u0006\u0004\bA\u0010\u0017J\u001a\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u000202H\u00d6\u0001\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020KH\u00d6\u0001\u00a2\u0006\u0004\bL\u0010MR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00188F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0017R*\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001d8F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010$\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001d8F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R*\u0010(\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001d8F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#\u0088\u0001\u0002\u00a8\u0006O"}, d2={"Lnet/darkmeow/darkmeow/structs/FontVertex;", "", "address", "", "constructor-impl", "(J)J", "container", "Lnet/darkmeow/kmogus/Arr;", "(Lnet/darkmeow/kmogus/Arr;)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;)J", "getAddress", "()J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "getPtr-hthgLag", "value", "Lnet/darkmeow/darkmeow/structs/Vec2f32;", "position", "getPosition-jky1oZU$annotations", "()V", "getPosition-jky1oZU", "setPosition-uc71As0", "(JJ)V", "Lnet/darkmeow/darkmeow/structs/Vec2i16;", "vertUV", "getVertUV-YOzqQ5Q$annotations", "getVertUV-YOzqQ5Q", "setVertUV-Gx-1ZdA", "", "colorIndex", "getColorIndex$annotations", "getColorIndex-impl", "(J)B", "setColorIndex-impl", "(JB)V", "overrideColor", "getOverrideColor$annotations", "getOverrideColor-impl", "setOverrideColor-impl", "shadow", "getShadow$annotations", "getShadow-impl", "setShadow-impl", "inc", "inc-lHnnRcY", "dec", "dec-lHnnRcY", "get", "index", "", "get-ciTUaBI", "(JI)J", "set", "", "set-2xdXAoA", "(JIJ)V", "plus", "offset", "plus-ciTUaBI", "(JJ)J", "minus", "minus-ciTUaBI", "copyTo", "dest", "copyTo-pq1BvvM", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "structs"})
public final class FontVertex {
    @NotNull
    public static final Companion Companion;
    private final long address;
    public static final long size = 16L;
    @NotNull
    private static final Unsafe UNSAFE;

    public final long getAddress() {
        return this.address;
    }

    public static final long getPtr-hthgLag(long arg0) {
        return Ptr.constructor-impl(arg0);
    }

    public static final long getPosition-jky1oZU(long arg0) {
        return Vec2f32.constructor-impl(arg0);
    }

    public static final void setPosition-uc71As0(long arg0, long value) {
        UNSAFE.copyMemory(value, arg0, 8L);
    }

    @net.darkmeow.kmogus.struct.Field(offset=0L, size=8L)
    public static /* synthetic */ void getPosition-jky1oZU$annotations() {
    }

    public static final long getVertUV-YOzqQ5Q(long arg0) {
        return Vec2i16.constructor-impl(arg0 + 8L);
    }

    public static final void setVertUV-Gx-1ZdA(long arg0, long value) {
        UNSAFE.copyMemory(value, arg0 + 8L, 4L);
    }

    @net.darkmeow.kmogus.struct.Field(offset=8L, size=4L)
    public static /* synthetic */ void getVertUV-YOzqQ5Q$annotations() {
    }

    public static final byte getColorIndex-impl(long arg0) {
        return UNSAFE.getByte(arg0 + 12L);
    }

    public static final void setColorIndex-impl(long arg0, byte value) {
        UNSAFE.putByte(arg0 + 12L, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=12L, size=1L)
    public static /* synthetic */ void getColorIndex$annotations() {
    }

    public static final byte getOverrideColor-impl(long arg0) {
        return UNSAFE.getByte(arg0 + 13L);
    }

    public static final void setOverrideColor-impl(long arg0, byte value) {
        UNSAFE.putByte(arg0 + 13L, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=13L, size=1L)
    public static /* synthetic */ void getOverrideColor$annotations() {
    }

    public static final byte getShadow-impl(long arg0) {
        return UNSAFE.getByte(arg0 + 14L);
    }

    public static final void setShadow-impl(long arg0, byte value) {
        UNSAFE.putByte(arg0 + 14L, value);
    }

    @net.darkmeow.kmogus.struct.Field(offset=14L, size=1L)
    public static /* synthetic */ void getShadow$annotations() {
    }

    public static long constructor-impl(@NotNull Arr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return FontVertex.constructor-impl(container.getPtr-hthgLag());
    }

    public static long constructor-impl(@NotNull MutableArr container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return FontVertex.constructor-impl(container.getPtr-hthgLag());
    }

    public static final long inc-lHnnRcY(long arg0) {
        return FontVertex.constructor-impl(arg0 + 16L);
    }

    public static final long dec-lHnnRcY(long arg0) {
        return FontVertex.constructor-impl(arg0 - 16L);
    }

    public static final long get-ciTUaBI(long arg0, int index) {
        return FontVertex.constructor-impl(arg0 + (long)index * 16L);
    }

    public static final void set-2xdXAoA(long arg0, int index, long value) {
        UNSAFE.copyMemory(value, arg0 + (long)index * 16L, 16L);
    }

    public static final long plus-ciTUaBI(long arg0, long offset) {
        return FontVertex.constructor-impl(arg0 + offset);
    }

    public static final long minus-ciTUaBI(long arg0, long offset) {
        return FontVertex.constructor-impl(arg0 - offset);
    }

    public static final void copyTo-pq1BvvM(long arg0, long dest) {
        UNSAFE.copyMemory(arg0, dest, 16L);
    }

    public static String toString-impl(long arg0) {
        return "FontVertex(address=" + arg0 + ')';
    }

    public String toString() {
        return FontVertex.toString-impl(this.address);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public int hashCode() {
        return FontVertex.hashCode-impl(this.address);
    }

    public static boolean equals-impl(long arg0, Object other) {
        if (!(other instanceof FontVertex)) {
            return false;
        }
        long l2 = ((FontVertex)other).unbox-impl();
        return arg0 == l2;
    }

    public boolean equals(Object other) {
        return FontVertex.equals-impl(this.address, other);
    }

    private /* synthetic */ FontVertex(long address) {
        this.address = address;
    }

    public static long constructor-impl(long address) {
        return address;
    }

    public static final /* synthetic */ FontVertex box-impl(long v2) {
        return new FontVertex(v2);
    }

    public final /* synthetic */ long unbox-impl() {
        return this.address;
    }

    public static final boolean equals-impl0(long p1, long p2) {
        return p1 == p2;
    }

    @JvmStatic
    public static final long invoke-Qz-mxFA(@NotNull Arr container, long position, long vertUV, byte colorIndex, byte overrideColor, byte shadow) {
        return Companion.invoke-Qz-mxFA(container, position, vertUV, colorIndex, overrideColor, shadow);
    }

    @JvmStatic
    public static final long invoke-Qz-mxFA(@NotNull MutableArr container, long position, long vertUV, byte colorIndex, byte overrideColor, byte shadow) {
        return Companion.invoke-Qz-mxFA(container, position, vertUV, colorIndex, overrideColor, shadow);
    }

    @JvmStatic
    public static final long invoke-fbpcyMo(long ptr) {
        return Companion.invoke-fbpcyMo(ptr);
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
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0087\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0087\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0018J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0087\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\u00a8\u0006\u001d"}, d2={"Lnet/darkmeow/darkmeow/structs/FontVertex$Companion;", "", "<init>", "()V", "size", "", "UNSAFE", "Lsun/misc/Unsafe;", "getUNSAFE$annotations", "invoke", "Lnet/darkmeow/darkmeow/structs/FontVertex;", "container", "Lnet/darkmeow/kmogus/Arr;", "position", "Lnet/darkmeow/darkmeow/structs/Vec2f32;", "vertUV", "Lnet/darkmeow/darkmeow/structs/Vec2i16;", "colorIndex", "", "overrideColor", "shadow", "invoke-Qz-mxFA", "(Lnet/darkmeow/kmogus/Arr;JJBBB)J", "Lnet/darkmeow/kmogus/MutableArr;", "(Lnet/darkmeow/kmogus/MutableArr;JJBBB)J", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "invoke-fbpcyMo", "(J)J", "structs"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        private static /* synthetic */ void getUNSAFE$annotations() {
        }

        @JvmStatic
        public final long invoke-Qz-mxFA(@NotNull Arr container, long position, long vertUV, byte colorIndex, byte overrideColor, byte shadow) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = FontVertex.constructor-impl(container);
            FontVertex.setPosition-uc71As0(v2, position);
            FontVertex.setVertUV-Gx-1ZdA(v2, vertUV);
            FontVertex.setColorIndex-impl(v2, colorIndex);
            FontVertex.setOverrideColor-impl(v2, overrideColor);
            FontVertex.setShadow-impl(v2, shadow);
            return v2;
        }

        @JvmStatic
        public final long invoke-Qz-mxFA(@NotNull MutableArr container, long position, long vertUV, byte colorIndex, byte overrideColor, byte shadow) {
            Intrinsics.checkNotNullParameter(container, "container");
            long v2 = FontVertex.constructor-impl(container);
            FontVertex.setPosition-uc71As0(v2, position);
            FontVertex.setVertUV-Gx-1ZdA(v2, vertUV);
            FontVertex.setColorIndex-impl(v2, colorIndex);
            FontVertex.setOverrideColor-impl(v2, overrideColor);
            FontVertex.setShadow-impl(v2, shadow);
            return v2;
        }

        @JvmStatic
        public final long invoke-fbpcyMo(long ptr) {
            return FontVertex.constructor-impl(ptr);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

