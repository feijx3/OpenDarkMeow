/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.darkmeow.ui.component.event;

import kotlin.Metadata;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/darkmeow/ui/component/event/ComponentKeyTypedEvent;", "", "char", "", "code", "", "<init>", "(CI)V", "getChar", "()C", "getCode", "()I", "value", "", "isCancelledNext", "()Z", "cancelNext", "", "DarkMeow"})
public final class ComponentKeyTypedEvent {
    private final char char;
    private final int code;
    private boolean isCancelledNext;

    public ComponentKeyTypedEvent(char c2, int code) {
        this.char = c2;
        this.code = code;
    }

    public final char getChar() {
        return this.char;
    }

    public final int getCode() {
        return this.code;
    }

    public final boolean isCancelledNext() {
        return this.isCancelledNext;
    }

    public final void cancelNext() {
        this.isCancelledNext = true;
    }
}

