/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.manager.visual.gl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/darkmeow/manager/visual/gl/StateBase;", "", "manager", "Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;", "<init>", "(Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;)V", "getManager", "()Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;", "lastAttribId", "", "getLastAttribId", "()I", "setLastAttribId", "(I)V", "equalLastAttribCount", "", "syncLastAttribCount", "", "DarkMeow"})
public class StateBase {
    @NotNull
    private final SafeGlStateManager manager;
    private int lastAttribId;

    public StateBase(@NotNull SafeGlStateManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    @NotNull
    public final SafeGlStateManager getManager() {
        return this.manager;
    }

    public int getLastAttribId() {
        return this.lastAttribId;
    }

    public void setLastAttribId(int n2) {
        this.lastAttribId = n2;
    }

    public final boolean equalLastAttribCount() {
        return this.getLastAttribId() == SafeGlStateManager.pushAttribId;
    }

    public final void syncLastAttribCount() {
        this.setLastAttribId(SafeGlStateManager.pushAttribId);
    }
}

