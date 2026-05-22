/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.manager.visual.gl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import net.darkmeow.darkmeow.manager.visual.gl.state.BooleanState;
import net.darkmeow.darkmeow.manager.visual.gl.state.LineState;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0007J\b\u0010\u000f\u001a\u00020\u000bH\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/darkmeow/manager/visual/gl/SafeGlStateManager;", "", "<init>", "()V", "pushAttribId", "", "lineState", "Lnet/darkmeow/darkmeow/manager/visual/gl/state/LineState;", "depthClampState", "Lnet/darkmeow/darkmeow/manager/visual/gl/state/BooleanState;", "glLineWidth", "", "width", "", "enableLineSmooth", "disableLineSmooth", "enableDepthClamp", "disableDepthClamp", "DarkMeow"})
public final class SafeGlStateManager {
    @NotNull
    public static final SafeGlStateManager INSTANCE = new SafeGlStateManager();
    @JvmField
    public static int pushAttribId;
    @JvmField
    @NotNull
    public static final LineState lineState;
    @JvmField
    @NotNull
    public static final BooleanState depthClampState;

    private SafeGlStateManager() {
    }

    @JvmStatic
    public static final void glLineWidth(float width) {
        lineState.lineWidth(width);
    }

    @JvmStatic
    public static final void enableLineSmooth() {
        lineState.reset();
        lineState.getLineSmooth().setEnabled();
    }

    @JvmStatic
    public static final void disableLineSmooth() {
        lineState.getLineSmooth().setDisabled();
    }

    @JvmStatic
    public static final void enableDepthClamp() {
        depthClampState.setEnabled();
    }

    @JvmStatic
    public static final void disableDepthClamp() {
        depthClampState.setDisabled();
    }

    static {
        lineState = new LineState(INSTANCE);
        depthClampState = new BooleanState(INSTANCE, 34383);
    }
}

