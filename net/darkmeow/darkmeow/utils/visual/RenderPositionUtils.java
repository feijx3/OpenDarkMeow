/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec2f
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.util.glu.GLU
 */
package net.darkmeow.darkmeow.utils.visual;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec2f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.util.glu.GLU;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u0004\u001a\u0004\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007\"\b\b\u0002\u0010\t*\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\u00062\u0006\u0010\r\u001a\u0002H\b2\u0006\u0010\u000e\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u000fJS\u0010\u0010\u001a\u0004\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007\"\b\b\u0002\u0010\t*\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u0002H\u00062\u0006\u0010\r\u001a\u0002H\b2\u0006\u0010\u000e\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/RenderPositionUtils;", "", "<init>", "()V", "worldToScreenCamera", "Lnet/minecraft/util/math/Vec2f;", "X", "", "Y", "Z", "mc", "Lnet/minecraft/client/Minecraft;", "x", "y", "z", "(Lnet/minecraft/client/Minecraft;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Lnet/minecraft/util/math/Vec2f;", "worldToScreen", "partialTicks", "", "(Lnet/minecraft/client/Minecraft;FLjava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Lnet/minecraft/util/math/Vec2f;", "DarkMeow"})
public final class RenderPositionUtils {
    @NotNull
    public static final RenderPositionUtils INSTANCE = new RenderPositionUtils();

    private RenderPositionUtils() {
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public final <X extends Number, Y extends Number, Z extends Number> Vec2f worldToScreenCamera(@NotNull Minecraft mc, @NotNull X x2, @NotNull Y y2, @NotNull Z z2) {
        FloatBuffer floatBuffer;
        void intBuffer22;
        FloatBuffer floatBuffer2;
        Buffer floatBuffer3;
        FloatBuffer floatBuffer4;
        FloatBuffer floatBuffer5;
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(z2, "z");
        FloatBuffer buffer = floatBuffer5 = BufferUtils.createFloatBuffer((int)3);
        boolean bl2 = false;
        FloatBuffer floatBuffer6 = floatBuffer4 = BufferUtils.createFloatBuffer((int)16);
        float f2 = z2.floatValue();
        float f3 = y2.floatValue();
        float f4 = x2.floatValue();
        boolean bl3 = false;
        GlStateManager.func_179111_a((int)2982, (FloatBuffer)floatBuffer3);
        Object object = Unit.INSTANCE;
        floatBuffer3 = floatBuffer2 = BufferUtils.createFloatBuffer((int)16);
        object = floatBuffer4;
        boolean bl4 = false;
        GlStateManager.func_179111_a((int)2983, (FloatBuffer)floatBuffer3);
        Object object2 = Unit.INSTANCE;
        IntBuffer intBuffer = BufferUtils.createIntBuffer((int)16);
        floatBuffer3 = intBuffer;
        object2 = floatBuffer2;
        boolean bl5 = false;
        GlStateManager.func_187445_a((int)2978, (IntBuffer)intBuffer22);
        Unit unit = Unit.INSTANCE;
        if (!GLU.gluProject((float)f4, (float)f3, (float)f2, (FloatBuffer)object, (FloatBuffer)object2, (IntBuffer)intBuffer, (FloatBuffer)buffer)) return null;
        FloatBuffer floatBuffer7 = floatBuffer5;
        FloatBuffer floatBuffer8 = floatBuffer7;
        if (floatBuffer8 == null) return null;
        FloatBuffer buffer2 = floatBuffer = floatBuffer8;
        boolean bl6 = false;
        float intBuffer22 = buffer2.get(2);
        if (!(0.0f <= intBuffer22)) return null;
        if (!(intBuffer22 <= 1.0f)) return null;
        boolean bl7 = true;
        if (!bl7) return null;
        FloatBuffer floatBuffer9 = floatBuffer;
        floatBuffer5 = floatBuffer9;
        if (floatBuffer5 == null) return null;
        buffer2 = floatBuffer5;
        boolean bl8 = false;
        ScaledResolution sr = new ScaledResolution(mc);
        Vec2f vec2f = new Vec2f(buffer2.get(0) / (float)sr.func_78325_e(), ((float)mc.field_71440_d - buffer2.get(1)) / (float)sr.func_78325_e());
        return vec2f;
    }

    @Nullable
    public final <X extends Number, Y extends Number, Z extends Number> Vec2f worldToScreen(@NotNull Minecraft mc, float partialTicks, @NotNull X x2, @NotNull Y y2, @NotNull Z z2) {
        Vec2f vec2f;
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(x2, "x");
        Intrinsics.checkNotNullParameter(y2, "y");
        Intrinsics.checkNotNullParameter(z2, "z");
        Entity entity = mc.func_175606_aa();
        if (entity != null) {
            Entity renderEntity = entity;
            boolean bl2 = false;
            vec2f = INSTANCE.worldToScreenCamera(mc, (Number)Float.valueOf(x2.floatValue() - ((float)renderEntity.field_70142_S + (float)(renderEntity.field_70165_t - renderEntity.field_70142_S) * partialTicks)), (Number)Float.valueOf(y2.floatValue() - ((float)renderEntity.field_70137_T + (float)(renderEntity.field_70163_u - renderEntity.field_70137_T) * partialTicks)), (Number)Float.valueOf(z2.floatValue() - ((float)renderEntity.field_70136_U + (float)(renderEntity.field_70161_v - renderEntity.field_70136_U) * partialTicks)));
        } else {
            vec2f = null;
        }
        return vec2f;
    }
}

