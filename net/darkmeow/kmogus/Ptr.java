/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmInline
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.UtilsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 l2\u00020\u0001:\u0001lB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u001e\u00a2\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\"\u00a2\u0006\u0004\b#\u0010$J\u001d\u0010\u000f\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0014\u0010&J\u001d\u0010\u0016\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0018\u0010'J\u001d\u0010\u001a\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001b\u0010(J\u001d\u0010\u001d\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u001e\u00a2\u0006\u0004\b\u001f\u0010)J\u001d\u0010!\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\"\u00a2\u0006\u0004\b#\u0010*J\r\u0010+\u001a\u00020\f\u00a2\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0013\u00a2\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0017\u00a2\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0003\u00a2\u0006\u0004\b5\u0010\u0005J\r\u00106\u001a\u00020\u001e\u00a2\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\"\u00a2\u0006\u0004\b:\u0010;J\u0015\u0010+\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b,\u0010<J\u0015\u0010.\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b/\u0010=J\u0015\u00101\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b2\u0010>J\u0015\u00104\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b5\u0010?J\u0015\u00106\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b7\u0010@J\u0015\u00109\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b:\u0010AJ\u0015\u0010B\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0013\u00a2\u0006\u0004\bF\u0010GJ\u0015\u0010H\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0017\u00a2\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0004\bL\u0010?J\u0015\u0010M\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u001e\u00a2\u0006\u0004\bN\u0010OJ\u0015\u0010P\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\"\u00a2\u0006\u0004\bQ\u0010RJ\u0018\u0010S\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\bT\u0010?J\u0018\u0010U\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\bV\u0010?J\u0010\u0010W\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\bX\u0010\u0005J\u0010\u0010Y\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\bZ\u0010\u0005J\u0018\u0010[\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b\\\u0010?J \u0010]\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002\u00a2\u0006\u0004\b^\u0010\u000eJ \u0010]\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0013H\u0086\u0002\u00a2\u0006\u0004\b^\u0010&J \u0010]\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0017H\u0086\u0002\u00a2\u0006\u0004\b^\u0010'J \u0010]\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b^\u0010(J \u0010]\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u001eH\u0086\u0002\u00a2\u0006\u0004\b^\u0010)J \u0010]\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\"H\u0086\u0002\u00a2\u0006\u0004\b^\u0010*J\u0018\u0010_\u001a\u00020\u00172\u0006\u0010`\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\ba\u0010>J\u001a\u0010b\u001a\u00020c2\b\u0010`\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\bg\u00103J\u0010\u0010h\u001a\u00020iH\u00d6\u0001\u00a2\u0006\u0004\bj\u0010kR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u00a8\u0006m"}, d2={"Lnet/darkmeow/kmogus/Ptr;", "", "address", "", "constructor-impl", "(J)J", "getAddress", "()J", "setMemory", "", "length", "value", "", "setMemory-impl", "(JJB)V", "setByte", "setByte-impl", "(JB)V", "setShort", "", "setShort-impl", "(JS)V", "setInt", "", "setInt-impl", "(JI)V", "setLong", "setLong-impl", "(JJ)V", "setFloat", "", "setFloat-impl", "(JF)V", "setDouble", "", "setDouble-impl", "(JD)V", "offset", "(JJS)V", "(JJI)V", "(JJJ)V", "(JJF)V", "(JJD)V", "getByte", "getByte-impl", "(J)B", "getShort", "getShort-impl", "(J)S", "getInt", "getInt-impl", "(J)I", "getLong", "getLong-impl", "getFloat", "getFloat-impl", "(J)F", "getDouble", "getDouble-impl", "(J)D", "(JJ)B", "(JJ)S", "(JJ)I", "(JJ)J", "(JJ)F", "(JJ)D", "setByteInc", "setByteInc-XvKnLUk", "(JB)J", "setShortInc", "setShortInc-XvKnLUk", "(JS)J", "setIntInc", "setIntInc-XvKnLUk", "(JI)J", "setLongInc", "setLongInc-XvKnLUk", "setFloatInc", "setFloatInc-XvKnLUk", "(JF)J", "setDoubleInc", "setDoubleInc-XvKnLUk", "(JD)J", "plus", "plus-XvKnLUk", "minus", "minus-XvKnLUk", "inc", "inc-hthgLag", "dec", "dec-hthgLag", "get", "get-XvKnLUk", "set", "set-impl", "compareTo", "other", "compareTo-4d6bxmI", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "kmogus-core"})
public final class Ptr {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long address;
    private static final long NULL = Ptr.constructor-impl(0L);

    public final long getAddress() {
        return this.address;
    }

    public static final void setMemory-impl(long arg0, long length, byte value) {
        UtilsKt.getUNSAFE().setMemory(arg0, length, value);
    }

    public static final void setByte-impl(long arg0, byte value) {
        UtilsKt.getUNSAFE().putByte(arg0, value);
    }

    public static final void setShort-impl(long arg0, short value) {
        UtilsKt.getUNSAFE().putShort(arg0, value);
    }

    public static final void setInt-impl(long arg0, int value) {
        UtilsKt.getUNSAFE().putInt(arg0, value);
    }

    public static final void setLong-impl(long arg0, long value) {
        UtilsKt.getUNSAFE().putLong(arg0, value);
    }

    public static final void setFloat-impl(long arg0, float value) {
        UtilsKt.getUNSAFE().putFloat(arg0, value);
    }

    public static final void setDouble-impl(long arg0, double value) {
        UtilsKt.getUNSAFE().putDouble(arg0, value);
    }

    public static final void setByte-impl(long arg0, long offset, byte value) {
        UtilsKt.getUNSAFE().putByte(arg0 + offset, value);
    }

    public static final void setShort-impl(long arg0, long offset, short value) {
        UtilsKt.getUNSAFE().putShort(arg0 + offset, value);
    }

    public static final void setInt-impl(long arg0, long offset, int value) {
        UtilsKt.getUNSAFE().putInt(arg0 + offset, value);
    }

    public static final void setLong-impl(long arg0, long offset, long value) {
        UtilsKt.getUNSAFE().putLong(arg0 + offset, value);
    }

    public static final void setFloat-impl(long arg0, long offset, float value) {
        UtilsKt.getUNSAFE().putFloat(arg0 + offset, value);
    }

    public static final void setDouble-impl(long arg0, long offset, double value) {
        UtilsKt.getUNSAFE().putDouble(arg0 + offset, value);
    }

    public static final byte getByte-impl(long arg0) {
        return UtilsKt.getUNSAFE().getByte(arg0);
    }

    public static final short getShort-impl(long arg0) {
        return UtilsKt.getUNSAFE().getShort(arg0);
    }

    public static final int getInt-impl(long arg0) {
        return UtilsKt.getUNSAFE().getInt(arg0);
    }

    public static final long getLong-impl(long arg0) {
        return UtilsKt.getUNSAFE().getLong(arg0);
    }

    public static final float getFloat-impl(long arg0) {
        return UtilsKt.getUNSAFE().getFloat(arg0);
    }

    public static final double getDouble-impl(long arg0) {
        return UtilsKt.getUNSAFE().getDouble(arg0);
    }

    public static final byte getByte-impl(long arg0, long offset) {
        return UtilsKt.getUNSAFE().getByte(arg0 + offset);
    }

    public static final short getShort-impl(long arg0, long offset) {
        return UtilsKt.getUNSAFE().getShort(arg0 + offset);
    }

    public static final int getInt-impl(long arg0, long offset) {
        return UtilsKt.getUNSAFE().getInt(arg0 + offset);
    }

    public static final long getLong-impl(long arg0, long offset) {
        return UtilsKt.getUNSAFE().getLong(arg0 + offset);
    }

    public static final float getFloat-impl(long arg0, long offset) {
        return UtilsKt.getUNSAFE().getFloat(arg0 + offset);
    }

    public static final double getDouble-impl(long arg0, long offset) {
        return UtilsKt.getUNSAFE().getDouble(arg0 + offset);
    }

    public static final long setByteInc-XvKnLUk(long arg0, byte value) {
        UtilsKt.getUNSAFE().putByte(arg0, value);
        return Ptr.constructor-impl(arg0 + 1L);
    }

    public static final long setShortInc-XvKnLUk(long arg0, short value) {
        UtilsKt.getUNSAFE().putShort(arg0, value);
        return Ptr.constructor-impl(arg0 + (long)2);
    }

    public static final long setIntInc-XvKnLUk(long arg0, int value) {
        UtilsKt.getUNSAFE().putInt(arg0, value);
        return Ptr.constructor-impl(arg0 + (long)4);
    }

    public static final long setLongInc-XvKnLUk(long arg0, long value) {
        UtilsKt.getUNSAFE().putLong(arg0, value);
        return Ptr.constructor-impl(arg0 + (long)8);
    }

    public static final long setFloatInc-XvKnLUk(long arg0, float value) {
        UtilsKt.getUNSAFE().putFloat(arg0, value);
        return Ptr.constructor-impl(arg0 + (long)4);
    }

    public static final long setDoubleInc-XvKnLUk(long arg0, double value) {
        UtilsKt.getUNSAFE().putDouble(arg0, value);
        return Ptr.constructor-impl(arg0 + (long)8);
    }

    public static final long plus-XvKnLUk(long arg0, long offset) {
        return Ptr.constructor-impl(arg0 + offset);
    }

    public static final long minus-XvKnLUk(long arg0, long offset) {
        return Ptr.constructor-impl(arg0 - offset);
    }

    public static final long inc-hthgLag(long arg0) {
        return Ptr.constructor-impl(arg0 + 1L);
    }

    public static final long dec-hthgLag(long arg0) {
        return Ptr.constructor-impl(arg0 - 1L);
    }

    public static final long get-XvKnLUk(long arg0, long offset) {
        return Ptr.constructor-impl(arg0 + offset);
    }

    public static final void set-impl(long arg0, long offset, byte value) {
        UtilsKt.getUNSAFE().putByte(arg0 + offset, value);
    }

    public static final void set-impl(long arg0, long offset, short value) {
        UtilsKt.getUNSAFE().putShort(arg0 + offset, value);
    }

    public static final void set-impl(long arg0, long offset, int value) {
        UtilsKt.getUNSAFE().putInt(arg0 + offset, value);
    }

    public static final void set-impl(long arg0, long offset, long value) {
        UtilsKt.getUNSAFE().putLong(arg0 + offset, value);
    }

    public static final void set-impl(long arg0, long offset, float value) {
        UtilsKt.getUNSAFE().putFloat(arg0 + offset, value);
    }

    public static final void set-impl(long arg0, long offset, double value) {
        UtilsKt.getUNSAFE().putDouble(arg0 + offset, value);
    }

    public static final int compareTo-4d6bxmI(long arg0, long other) {
        return Intrinsics.compare(arg0, other);
    }

    public static String toString-impl(long arg0) {
        return "Ptr(address=" + arg0 + ')';
    }

    public String toString() {
        return Ptr.toString-impl(this.address);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public int hashCode() {
        return Ptr.hashCode-impl(this.address);
    }

    public static boolean equals-impl(long arg0, Object other) {
        if (!(other instanceof Ptr)) {
            return false;
        }
        long l2 = ((Ptr)other).unbox-impl();
        return arg0 == l2;
    }

    public boolean equals(Object other) {
        return Ptr.equals-impl(this.address, other);
    }

    private /* synthetic */ Ptr(long address) {
        this.address = address;
    }

    public static long constructor-impl(long address) {
        return address;
    }

    public static final /* synthetic */ Ptr box-impl(long v2) {
        return new Ptr(v2);
    }

    public final /* synthetic */ long unbox-impl() {
        return this.address;
    }

    public static final boolean equals-impl0(long p1, long p2) {
        return p1 == p2;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2={"Lnet/darkmeow/kmogus/Ptr$Companion;", "", "<init>", "()V", "NULL", "Lnet/darkmeow/kmogus/Ptr;", "getNULL-hthgLag", "()J", "J", "kmogus-core"})
    public static final class Companion {
        private Companion() {
        }

        public final long getNULL-hthgLag() {
            return NULL;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

