/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendRenderManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.EntityUtils;
import net.ccbluex.liquidbounce.utils.LegacyRotationUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@ModuleInfo(name="Tracers", description="Draws a line to targets around you.", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Tracers;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "colorMode", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "playerHeightValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "thicknessValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "colorAlphaValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "colorRedValue", "colorGreenValue", "colorBlueValue", "directLineValue", "fovModeValue", "fovValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "drawTraces", "entity", "Lnet/minecraft/entity/Entity;", "color", "Ljava/awt/Color;", "drawHeight", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nTracers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tracers.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Tracers\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,110:1\n774#2:111\n865#2,2:112\n*S KotlinDebug\n*F\n+ 1 Tracers.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Tracers\n*L\n56#1:111\n56#1:112,2\n*E\n"})
public final class Tracers
extends Module {
    @NotNull
    private final ListValue colorMode;
    @NotNull
    private final BoolValue playerHeightValue;
    @NotNull
    private final FloatValue thicknessValue;
    @NotNull
    private final IntegerValue colorAlphaValue;
    @NotNull
    private final IntegerValue colorRedValue;
    @NotNull
    private final IntegerValue colorGreenValue;
    @NotNull
    private final IntegerValue colorBlueValue;
    @NotNull
    private final BoolValue directLineValue;
    @NotNull
    private final ListValue fovModeValue;
    @NotNull
    private final Value<Float> fovValue;

    public Tracers() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Custom", "DistanceColor"};
        this.colorMode = new ListValue("Color", stringArray, "Theme");
        this.playerHeightValue = new BoolValue("PlayerHeight", true);
        this.thicknessValue = new FloatValue("Thickness", 2.0f, 1.0f, 5.0f);
        this.colorAlphaValue = new IntegerValue("Alpha", 150, 1, 255);
        this.colorRedValue = new IntegerValue("R", 0, 0, 255);
        this.colorGreenValue = new IntegerValue("G", 160, 0, 255);
        this.colorBlueValue = new IntegerValue("B", 255, 0, 255);
        this.directLineValue = new BoolValue("Directline", false);
        stringArray = new String[]{"All", "Back", "Front"};
        this.fovModeValue = new ListValue("FOV-Mode", stringArray, "All");
        this.fovValue = new FloatValue("FOV", 180.0f, 0.0f, 180.0f).displayable(() -> Tracers.fovValue$lambda$0(this));
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        Object destination$iv$iv;
        List list;
        Intrinsics.checkNotNullParameter(event, "event");
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return;
        }
        WorldClient world = worldClient;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)((Number)this.thicknessValue.get()).floatValue());
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        if (StringsKt.equals((String)this.fovModeValue.get(), "all", true)) {
            list = world.field_72996_f;
        } else {
            void $this$filterTo$iv$iv;
            List list2 = world.field_72996_f;
            Intrinsics.checkNotNullExpressionValue(list2, "loadedEntityList");
            Iterable $this$filter$iv = list2;
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                boolean bl2;
                Entity it = (Entity)element$iv$iv;
                boolean bl3 = false;
                if (StringsKt.equals((String)this.fovModeValue.get(), "back", true)) {
                    Intrinsics.checkNotNull(it);
                    bl2 = LegacyRotationUtils.Companion.getRotationBackDifference(it) <= (double)((Number)this.fovValue.get()).floatValue();
                } else {
                    Intrinsics.checkNotNull(it);
                    bl2 = LegacyRotationUtils.Companion.getRotationDifference(it) <= (double)((Number)this.fovValue.get()).floatValue();
                }
                if (!bl2) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list = (List)destination$iv$iv;
        }
        for (Entity entity : list) {
            String colorMode;
            if (entity == null || Intrinsics.areEqual(entity, player) || !EntityUtils.isSelected(entity, false)) continue;
            int dist = (int)(player.func_70032_d(entity) * (float)2);
            if (dist > 255) {
                dist = 255;
            }
            destination$iv$iv = (String)this.colorMode.get();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            Intrinsics.checkNotNullExpressionValue(((String)destination$iv$iv).toLowerCase(locale), "toLowerCase(...)");
            Color color = EntityUtils.INSTANCE.isFriend(entity) ? new Color(0, 255, 0, 200) : (Intrinsics.areEqual(colorMode, "custom") ? new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue(), 150) : (Intrinsics.areEqual(colorMode, "distancecolor") ? new Color(255 - dist, dist, 0, 150) : new Color(255, 255, 255, 150)));
            this.drawTraces(entity, color, (Boolean)this.directLineValue.get() == false);
        }
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GlStateManager.func_179117_G();
    }

    public final void drawTraces(@NotNull Entity entity, @NotNull Color color, boolean drawHeight) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(color, "color");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        double x2 = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * (double)MinecraftInstance.mc.getTimer().field_194147_b - ExtendRenderManager.INSTANCE.getRenderPosX(MinecraftInstance.mc.getRenderManager());
        double y2 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * (double)MinecraftInstance.mc.getTimer().field_194147_b - ExtendRenderManager.INSTANCE.getRenderPosY(MinecraftInstance.mc.getRenderManager());
        double z2 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * (double)MinecraftInstance.mc.getTimer().field_194147_b - ExtendRenderManager.INSTANCE.getRenderPosZ(MinecraftInstance.mc.getRenderManager());
        Vec3d eyeVector = new Vec3d(0.0, 0.0, 1.0).func_178789_a((float)(-Math.toRadians(player.field_70125_A))).func_178785_b((float)(-Math.toRadians(player.field_70177_z)));
        RenderUtils.glColor(color, ((Number)this.colorAlphaValue.get()).intValue());
        GL11.glBegin((int)3);
        GL11.glLineWidth((float)((Number)this.thicknessValue.get()).floatValue());
        GL11.glVertex3d((double)eyeVector.field_72450_a, (double)(((Boolean)this.playerHeightValue.get() != false ? (double)MinecraftInstance.mc_nowarp.field_71439_g.func_70047_e() : 0.0) + eyeVector.field_72448_b), (double)eyeVector.field_72449_c);
        if (drawHeight) {
            GL11.glVertex3d((double)x2, (double)(y2 + (double)entity.field_70131_O), (double)z2);
        } else {
            GL11.glVertex3d((double)x2, (double)y2, (double)z2);
        }
        GL11.glEnd();
    }

    private static final boolean fovValue$lambda$0(Tracers this$0) {
        return !StringsKt.equals((String)this$0.fovModeValue.get(), "all", true);
    }
}

