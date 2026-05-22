/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.render.AccessorRenderManager;
import net.minecraft.client.renderer.entity.RenderManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR(\u0010\u000f\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/ExtendRenderManager;", "", "<init>", "()V", "value", "", "renderPosX", "Lnet/minecraft/client/renderer/entity/RenderManager;", "getRenderPosX", "(Lnet/minecraft/client/renderer/entity/RenderManager;)D", "setRenderPosX", "(Lnet/minecraft/client/renderer/entity/RenderManager;D)V", "renderPosY", "getRenderPosY", "setRenderPosY", "renderPosZ", "getRenderPosZ", "setRenderPosZ", "DarkMeow"})
public final class ExtendRenderManager {
    @NotNull
    public static final ExtendRenderManager INSTANCE = new ExtendRenderManager();

    private ExtendRenderManager() {
    }

    public final double getRenderPosX(@NotNull RenderManager $this$renderPosX) {
        Intrinsics.checkNotNullParameter($this$renderPosX, "<this>");
        return ((AccessorRenderManager)$this$renderPosX).getRenderPosX();
    }

    public final void setRenderPosX(@NotNull RenderManager $this$renderPosX, double value) {
        Intrinsics.checkNotNullParameter($this$renderPosX, "<this>");
        ((AccessorRenderManager)$this$renderPosX).setRenderPosX(value);
    }

    public final double getRenderPosY(@NotNull RenderManager $this$renderPosY) {
        Intrinsics.checkNotNullParameter($this$renderPosY, "<this>");
        return ((AccessorRenderManager)$this$renderPosY).getRenderPosY();
    }

    public final void setRenderPosY(@NotNull RenderManager $this$renderPosY, double value) {
        Intrinsics.checkNotNullParameter($this$renderPosY, "<this>");
        ((AccessorRenderManager)$this$renderPosY).setRenderPosY(value);
    }

    public final double getRenderPosZ(@NotNull RenderManager $this$renderPosZ) {
        Intrinsics.checkNotNullParameter($this$renderPosZ, "<this>");
        return ((AccessorRenderManager)$this$renderPosZ).getRenderPosZ();
    }

    public final void setRenderPosZ(@NotNull RenderManager $this$renderPosZ, double value) {
        Intrinsics.checkNotNullParameter($this$renderPosZ, "<this>");
        ((AccessorRenderManager)$this$renderPosZ).setRenderPosZ(value);
    }
}

