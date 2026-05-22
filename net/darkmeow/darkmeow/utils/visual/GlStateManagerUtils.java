/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.visual;

import kotlin.Metadata;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlStateManager;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005\u00a8\u0006\t"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/GlStateManagerUtils;", "", "<init>", "()V", "prepare", "", "release", "applyBlend", "unapplyBlend", "DarkMeow"})
public final class GlStateManagerUtils {
    @NotNull
    public static final GlStateManagerUtils INSTANCE = new GlStateManagerUtils();

    private GlStateManagerUtils() {
    }

    public final void prepare() {
        GlStateManager.func_179118_c();
        this.applyBlend();
        SafeGlStateManager.enableLineSmooth();
        GlStateManager.func_179129_p();
    }

    public final void release() {
        SafeGlStateManager.disableLineSmooth();
        GlStateManager.func_179089_o();
    }

    public final void applyBlend() {
        GlStateManager.func_179147_l();
        GlStateManager.func_187401_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }

    public final void unapplyBlend() {
        GlStateManager.func_179084_k();
        GlStateManager.func_187401_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
    }
}

