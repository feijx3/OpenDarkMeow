/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package net.darkmeow.darkmeow.manager.visual.gl.state;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlState;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlStateManager;
import net.darkmeow.darkmeow.manager.visual.gl.StateBase;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2={"Lnet/darkmeow/darkmeow/manager/visual/gl/state/BooleanState;", "Lnet/darkmeow/darkmeow/manager/visual/gl/StateBase;", "manager", "Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;", "capability", "", "<init>", "(Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;I)V", "lastState", "", "getLastState$annotations", "()V", "getLastState", "()Z", "setLastState", "(Z)V", "setDisabled", "", "setEnabled", "setState", "state", "DarkMeow"})
public final class BooleanState
extends StateBase {
    private final int capability;
    private boolean lastState;

    public BooleanState(@NotNull SafeGlStateManager manager, int capability) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super(manager);
        this.capability = capability;
    }

    public final boolean getLastState() {
        return this.lastState;
    }

    public final void setLastState(boolean bl2) {
        this.lastState = bl2;
    }

    @SafeGlState
    public static /* synthetic */ void getLastState$annotations() {
    }

    public final void setDisabled() {
        this.setState(false);
    }

    public final void setEnabled() {
        this.setState(true);
    }

    public final void setState(boolean state) {
        if (state != this.lastState || !this.equalLastAttribCount()) {
            this.lastState = state;
            this.syncLastAttribCount();
            boolean bl2 = state;
            if (bl2) {
                GL11.glEnable((int)this.capability);
            } else if (!bl2) {
                GL11.glDisable((int)this.capability);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}

