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
import net.darkmeow.kmogus.ContainerDelegated;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0017"}, d2={"Lnet/darkmeow/kmogus/ArrImpl;", "Lnet/darkmeow/kmogus/Arr;", "address", "Lnet/darkmeow/kmogus/Ptr;", "length", "", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "delegated", "Lnet/darkmeow/kmogus/ContainerDelegated;", "getDelegated", "()Lnet/darkmeow/kmogus/ContainerDelegated;", "ptr", "getPtr-hthgLag", "()J", "len", "getLen", "realloc", "newLength", "init", "", "free", "", "kmogus-core"})
public final class ArrImpl
implements Arr {
    @NotNull
    private final ContainerDelegated delegated;

    private ArrImpl(long address, long length) {
        this.delegated = new ContainerDelegated(address, length, null);
    }

    @NotNull
    public final ContainerDelegated getDelegated() {
        return this.delegated;
    }

    @Override
    public long getPtr-hthgLag() {
        return this.delegated.getPtr-hthgLag();
    }

    @Override
    public long getLen() {
        return this.delegated.getLength();
    }

    @Override
    @NotNull
    public Arr realloc(long newLength, boolean init) {
        this.delegated.realloc(newLength, init);
        return this;
    }

    @Override
    public void free() {
        this.delegated.free();
    }

    @Override
    public void close() {
        Arr.super.close();
    }

    public /* synthetic */ ArrImpl(long address, long length, DefaultConstructorMarker $constructor_marker) {
        this(address, length);
    }
}

