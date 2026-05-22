/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package net.darkmeow.darkmeow.manager.visual.gl.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlState;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlStateManager;
import net.darkmeow.darkmeow.manager.visual.gl.StateBase;
import net.darkmeow.darkmeow.manager.visual.gl.state.BooleanState;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fR$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2={"Lnet/darkmeow/darkmeow/manager/visual/gl/state/LineState;", "Lnet/darkmeow/darkmeow/manager/visual/gl/StateBase;", "manager", "Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;", "<init>", "(Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;)V", "lineSmooth", "Lnet/darkmeow/darkmeow/manager/visual/gl/state/BooleanState;", "getLineSmooth$annotations", "()V", "getLineSmooth", "()Lnet/darkmeow/darkmeow/manager/visual/gl/state/BooleanState;", "setLineSmooth", "(Lnet/darkmeow/darkmeow/manager/visual/gl/state/BooleanState;)V", "lastLineWidth", "", "getLastLineWidth$annotations", "getLastLineWidth", "()F", "setLastLineWidth", "(F)V", "reset", "", "lineWidth", "width", "DarkMeow"})
public final class LineState
extends StateBase {
    @NotNull
    private BooleanState lineSmooth;
    private float lastLineWidth;

    public LineState(@NotNull SafeGlStateManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super(manager);
        this.lineSmooth = new BooleanState(manager, 2848);
        this.lastLineWidth = -999.0f;
    }

    @NotNull
    public final BooleanState getLineSmooth() {
        return this.lineSmooth;
    }

    public final void setLineSmooth(@NotNull BooleanState booleanState) {
        Intrinsics.checkNotNullParameter(booleanState, "<set-?>");
        this.lineSmooth = booleanState;
    }

    @SafeGlState
    public static /* synthetic */ void getLineSmooth$annotations() {
    }

    public final float getLastLineWidth() {
        return this.lastLineWidth;
    }

    public final void setLastLineWidth(float f2) {
        this.lastLineWidth = f2;
    }

    @SafeGlState
    public static /* synthetic */ void getLastLineWidth$annotations() {
    }

    public final void reset() {
        this.lastLineWidth = -999.0f;
    }

    public final void lineWidth(float width) {
        if (!(width == this.lastLineWidth) || !this.equalLastAttribCount()) {
            this.lastLineWidth = width;
            this.syncLastAttribCount();
            GL11.glLineWidth((float)width);
        }
    }
}

