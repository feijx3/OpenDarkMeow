/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.kmogus.Arr;
import net.darkmeow.kmogus.Ptr;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0000H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0096\u0002J\u0011\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0096\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0018\u0010\t\u001a\u00020\u0007X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\u0007X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005\u00a8\u0006\u001c\u00c0\u0006\u0003"}, d2={"Lnet/darkmeow/kmogus/MutableArr;", "Lnet/darkmeow/kmogus/Arr;", "basePtr", "Lnet/darkmeow/kmogus/Ptr;", "getBasePtr-hthgLag", "()J", "baseLen", "", "getBaseLen", "pos", "getPos", "setPos", "(J)V", "len", "getLen", "setLen", "ptr", "getPtr-hthgLag", "rem", "getRem", "pos-4d6bxmI", "(J)Lnet/darkmeow/kmogus/MutableArr;", "flip", "reset", "plusAssign", "", "offset", "minusAssign", "kmogus-core"})
@SourceDebugExtension(value={"SMAP\nMutableArr.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutableArr.kt\nnet/darkmeow/kmogus/MutableArr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
public interface MutableArr
extends Arr {
    public long getBasePtr-hthgLag();

    public long getBaseLen();

    public long getPos();

    public void setPos(long var1);

    @Override
    public long getLen();

    public void setLen(long var1);

    @Override
    default public long getPtr-hthgLag() {
        return Ptr.plus-XvKnLUk(this.getBasePtr-hthgLag(), this.getPos());
    }

    default public long getRem() {
        return this.getLen() - this.getPos();
    }

    @NotNull
    default public MutableArr pos-4d6bxmI(long ptr) {
        long l2 = this.getBasePtr-hthgLag();
        long l3 = this.getBasePtr-hthgLag() + this.getBaseLen();
        long l4 = ptr;
        if (!(l2 <= l4 ? l4 <= l3 : false)) {
            boolean bl2 = false;
            String string = "Ptr out of bounds";
            throw new IllegalArgumentException(string.toString());
        }
        this.setPos(ptr - this.getBasePtr-hthgLag());
        return this;
    }

    @NotNull
    default public MutableArr flip() {
        this.setLen(this.getPos());
        this.setPos(0L);
        return this;
    }

    @NotNull
    default public MutableArr reset() {
        this.setPos(0L);
        this.setLen(this.getBaseLen());
        return this;
    }

    default public void plusAssign(long offset) {
        this.setPos(this.getPos() + offset);
    }

    default public void minusAssign(long offset) {
        this.setPos(this.getPos() - offset);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        public static long getPtr-hthgLag(@NotNull MutableArr $this) {
            return $this.getPtr-hthgLag();
        }

        @Deprecated
        public static long getRem(@NotNull MutableArr $this) {
            return $this.getRem();
        }

        @Deprecated
        @NotNull
        public static MutableArr pos-4d6bxmI(@NotNull MutableArr $this, long ptr) {
            return $this.pos-4d6bxmI(ptr);
        }

        @Deprecated
        @NotNull
        public static MutableArr flip(@NotNull MutableArr $this) {
            return $this.flip();
        }

        @Deprecated
        @NotNull
        public static MutableArr reset(@NotNull MutableArr $this) {
            return $this.reset();
        }

        @Deprecated
        public static void plusAssign(@NotNull MutableArr $this, long offset) {
            $this.plusAssign(offset);
        }

        @Deprecated
        public static void minusAssign(@NotNull MutableArr $this, long offset) {
            $this.minusAssign(offset);
        }

        @Deprecated
        public static void close(@NotNull MutableArr $this) {
            $this.close();
        }
    }
}

