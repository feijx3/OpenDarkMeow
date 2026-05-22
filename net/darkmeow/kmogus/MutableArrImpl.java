/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.Arr;
import net.darkmeow.kmogus.MutableArr;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0012\u00a8\u0006\u001c"}, d2={"Lnet/darkmeow/kmogus/MutableArrImpl;", "Lnet/darkmeow/kmogus/MutableArr;", "base", "Lnet/darkmeow/kmogus/Arr;", "<init>", "(Lnet/darkmeow/kmogus/Arr;)V", "getBase", "()Lnet/darkmeow/kmogus/Arr;", "basePtr", "Lnet/darkmeow/kmogus/Ptr;", "getBasePtr-hthgLag", "()J", "baseLen", "", "getBaseLen", "pos", "getPos", "setPos", "(J)V", "len", "getLen", "setLen", "realloc", "newLength", "init", "", "free", "", "kmogus-core"})
final class MutableArrImpl
implements MutableArr {
    @NotNull
    private final Arr base;
    private long pos;
    private long len;

    public MutableArrImpl(@NotNull Arr base) {
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        this.len = this.getBaseLen();
    }

    @NotNull
    public final Arr getBase() {
        return this.base;
    }

    @Override
    public long getBasePtr-hthgLag() {
        return this.base.getPtr-hthgLag();
    }

    @Override
    public long getBaseLen() {
        return this.base.getLen();
    }

    @Override
    public long getPos() {
        return this.pos;
    }

    @Override
    public void setPos(long l2) {
        this.pos = l2;
    }

    @Override
    public long getLen() {
        return this.len;
    }

    @Override
    public void setLen(long l2) {
        this.len = l2;
    }

    @Override
    @NotNull
    public Arr realloc(long newLength, boolean init) {
        long oldLen = this.getBaseLen();
        this.base.realloc(newLength, init);
        if (this.getLen() == oldLen) {
            this.setLen(newLength);
        }
        return this;
    }

    @Override
    public void free() {
        this.base.free();
    }

    @Override
    @NotNull
    public MutableArr pos-4d6bxmI(long ptr) {
        return MutableArr.super.pos-4d6bxmI(ptr);
    }

    @Override
    public long getPtr-hthgLag() {
        return MutableArr.super.getPtr-hthgLag();
    }

    @Override
    public long getRem() {
        return MutableArr.super.getRem();
    }

    @Override
    @NotNull
    public MutableArr flip() {
        return MutableArr.super.flip();
    }

    @Override
    @NotNull
    public MutableArr reset() {
        return MutableArr.super.reset();
    }

    @Override
    public void plusAssign(long offset) {
        MutableArr.super.plusAssign(offset);
    }

    @Override
    public void minusAssign(long offset) {
        MutableArr.super.minusAssign(offset);
    }

    @Override
    public void close() {
        MutableArr.super.close();
    }
}

