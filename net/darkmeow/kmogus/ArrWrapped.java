/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.darkmeow.kmogus.Arr;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/kmogus/ArrWrapped;", "Lnet/darkmeow/kmogus/Arr;", "ptr", "Lnet/darkmeow/kmogus/Ptr;", "len", "", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPtr-hthgLag", "()J", "J", "getLen", "realloc", "newLength", "init", "", "free", "", "kmogus-core"})
public final class ArrWrapped
implements Arr {
    private final long ptr;
    private final long len;

    private ArrWrapped(long ptr, long len) {
        this.ptr = ptr;
        this.len = len;
    }

    @Override
    public long getPtr-hthgLag() {
        return this.ptr;
    }

    @Override
    public long getLen() {
        return this.len;
    }

    @Override
    @NotNull
    public Arr realloc(long newLength, boolean init) {
        throw new UnsupportedOperationException("Cannot reallocate wrapped ptr");
    }

    @Override
    public void free() {
        throw new UnsupportedOperationException("Cannot free wrapped ptr");
    }

    @Override
    public void close() {
        Arr.super.close();
    }

    public /* synthetic */ ArrWrapped(long ptr, long len, DefaultConstructorMarker $constructor_marker) {
        this(ptr, len);
    }
}

