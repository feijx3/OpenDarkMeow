/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Sphere
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.EntityUtils;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

@ModuleInfo(name="Trail", description="Leaves a trail behind you", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Trail;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "typeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "colorRedValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "colorGreenValue", "colorBlueValue", "colorAlphaValue", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "fade", "drawplayer", "drawTargets", "fadeTime", "precision", "lineWidth", "sphereScale", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "points", "", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/Trail$BreadcrumbPoint;", "color", "Ljava/awt/Color;", "getColor", "()Ljava/awt/Color;", "sphereList", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "updatePoints", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onDisable", "BreadcrumbPoint", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nTrail.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Trail.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Trail\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,194:1\n216#2,2:195\n216#2,2:197\n1869#3,2:199\n1#4:201\n*S KotlinDebug\n*F\n+ 1 Trail.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Trail\n*L\n76#1:195,2\n150#1:197,2\n160#1:199,2\n*E\n"})
public final class Trail
extends Module {
    @NotNull
    private final ListValue typeValue;
    @NotNull
    private final IntegerValue colorRedValue;
    @NotNull
    private final IntegerValue colorGreenValue;
    @NotNull
    private final IntegerValue colorBlueValue;
    @NotNull
    private final IntegerValue colorAlphaValue;
    @NotNull
    private final BoolValue colorRainbow;
    @NotNull
    private final BoolValue fade;
    @NotNull
    private final BoolValue drawplayer;
    @NotNull
    private final BoolValue drawTargets;
    @NotNull
    private final IntegerValue fadeTime;
    @NotNull
    private final IntegerValue precision;
    @NotNull
    private final IntegerValue lineWidth;
    @NotNull
    private final FloatValue sphereScale;
    @NotNull
    private final Map<Integer, List<BreadcrumbPoint>> points;
    private final int sphereList;

    public Trail() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Line", "Rect", "Sphere"};
        this.typeValue = new ListValue("Type", stringArray, "Line");
        this.colorRedValue = new IntegerValue("R", 255, 0, 255);
        this.colorGreenValue = new IntegerValue("G", 255, 0, 255);
        this.colorBlueValue = new IntegerValue("B", 255, 0, 255);
        this.colorAlphaValue = new IntegerValue("Alpha", 255, 0, 255);
        this.colorRainbow = new BoolValue("Rainbow", false);
        this.fade = new BoolValue("Fade", true);
        this.drawplayer = new BoolValue("Drawplayer", true);
        this.drawTargets = new BoolValue("DrawTargets", true);
        this.fadeTime = new IntegerValue("FadeTime", 5, 1, 20);
        this.precision = new IntegerValue("Precision", 1, 1, 20);
        this.lineWidth = new IntegerValue("LineWidth", 1, 1, 10);
        this.sphereScale = new FloatValue("SphereScale", 1.0f, 0.1f, 2.0f);
        this.points = new LinkedHashMap();
        this.sphereList = GL11.glGenLists((int)1);
        GL11.glNewList((int)this.sphereList, (int)4864);
        Sphere shaft = new Sphere();
        shaft.setDrawStyle(100012);
        shaft.draw(0.3f, 25, 10);
        GL11.glEndList();
    }

    @NotNull
    public final Color getColor() {
        return (Boolean)this.colorRainbow.get() != false ? ColorUtils.rainbow() : new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue());
    }

    /*
     * Enabled aggressive block sorting
     */
    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int fTime = ((Number)this.fadeTime.get()).intValue() * 1000;
        long fadeSec = System.currentTimeMillis() - (long)fTime;
        float colorAlpha = ((Number)this.colorAlphaValue.get()).floatValue() / 255.0f;
        GL11.glPushMatrix();
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2929);
        MinecraftInstance.mc.getEntityRenderer().func_175072_h();
        double renderPosX = MinecraftInstance.mc.getRenderManager().field_78730_l;
        double renderPosY = MinecraftInstance.mc.getRenderManager().field_78731_m;
        double renderPosZ = MinecraftInstance.mc.getRenderManager().field_78728_n;
        Map<Integer, List<BreadcrumbPoint>> $this$forEach$iv = this.points;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<Integer, List<BreadcrumbPoint>>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (true) {
            Map.Entry<Integer, List<BreadcrumbPoint>> element$iv;
            if (!iterator2.hasNext()) {
                GL11.glColor4d((double)1.0, (double)1.0, (double)1.0, (double)1.0);
                GL11.glEnable((int)2929);
                GL11.glDisable((int)3042);
                GL11.glEnable((int)3553);
                GL11.glPopMatrix();
                return;
            }
            Map.Entry<Integer, List<BreadcrumbPoint>> entry = element$iv = iterator2.next();
            boolean bl2 = false;
            List<BreadcrumbPoint> mutableList = entry.getValue();
            double lastPosX = 114514.0;
            double lastPosY = 114514.0;
            double lastPosZ = 114514.0;
            String string = ((String)this.typeValue.get()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            Object object = string;
            if (Intrinsics.areEqual(object, "line")) {
                GL11.glLineWidth((float)((Number)this.lineWidth.get()).intValue());
                GL11.glEnable((int)2848);
                GL11.glBegin((int)3);
            } else if (Intrinsics.areEqual(object, "rect")) {
                GL11.glDisable((int)2884);
            }
            for (BreadcrumbPoint point : CollectionsKt.reversed((Iterable)mutableList)) {
                block17: {
                    block18: {
                        String string2;
                        float f2;
                        if (((Boolean)this.fade.get()).booleanValue()) {
                            float pct = (float)(point.getTime() - fadeSec) / (float)fTime;
                            if (pct < 0.0f || pct > 1.0f) {
                                mutableList.remove(point);
                                continue;
                            }
                            f2 = pct;
                        } else {
                            f2 = 1.0f;
                        }
                        float alpha = f2 * colorAlpha;
                        RenderUtils.glColor2(point.getColor(), alpha);
                        Intrinsics.checkNotNullExpressionValue(((String)this.typeValue.get()).toLowerCase(Locale.ROOT), "toLowerCase(...)");
                        switch (string2.hashCode()) {
                            case 3496420: {
                                if (string2.equals("rect")) break;
                                break block17;
                            }
                            case -895981619: {
                                if (string2.equals("sphere")) break block18;
                                break block17;
                            }
                            case 3321844: {
                                if (string2.equals("line")) {
                                    GL11.glVertex3d((double)(point.getX() - renderPosX), (double)(point.getY() - renderPosY), (double)(point.getZ() - renderPosZ));
                                }
                                break block17;
                            }
                        }
                        if (!(lastPosX == 114514.0 && lastPosY == 114514.0 && lastPosZ == 114514.0)) {
                            GL11.glBegin((int)7);
                            GL11.glVertex3d((double)(point.getX() - renderPosX), (double)(point.getY() - renderPosY), (double)(point.getZ() - renderPosZ));
                            GL11.glVertex3d((double)lastPosX, (double)lastPosY, (double)lastPosZ);
                            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                            Intrinsics.checkNotNull(entityPlayerSP);
                            GL11.glVertex3d((double)lastPosX, (double)(lastPosY + (double)entityPlayerSP.field_70131_O), (double)lastPosZ);
                            double d2 = point.getX() - renderPosX;
                            double d3 = point.getY() - renderPosY;
                            EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
                            Intrinsics.checkNotNull(entityPlayerSP2);
                            GL11.glVertex3d((double)d2, (double)(d3 + (double)entityPlayerSP2.field_70131_O), (double)(point.getZ() - renderPosZ));
                            GL11.glEnd();
                        }
                        lastPosX = point.getX() - renderPosX;
                        lastPosY = point.getY() - renderPosY;
                        lastPosZ = point.getZ() - renderPosZ;
                        continue;
                    }
                    GL11.glPushMatrix();
                    GL11.glTranslated((double)(point.getX() - renderPosX), (double)(point.getY() - renderPosY), (double)(point.getZ() - renderPosZ));
                    GL11.glScalef((float)((Number)this.sphereScale.get()).floatValue(), (float)((Number)this.sphereScale.get()).floatValue(), (float)((Number)this.sphereScale.get()).floatValue());
                    GL11.glCallList((int)this.sphereList);
                    GL11.glPopMatrix();
                }
            }
            String string3 = ((String)this.typeValue.get()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string3, "toLowerCase(...)");
            object = string3;
            if (Intrinsics.areEqual(object, "line")) {
                GL11.glEnd();
                GL11.glDisable((int)2848);
                continue;
            }
            if (!Intrinsics.areEqual(object, "rect")) continue;
            GL11.glEnable((int)2884);
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Map.Entry<Integer, List<BreadcrumbPoint>> element$iv;
        Intrinsics.checkNotNullParameter(event, "event");
        Object $this$forEach$iv = this.points;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<Integer, List<BreadcrumbPoint>>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, List<BreadcrumbPoint>> entry = element$iv = iterator2.next();
            boolean bl2 = false;
            int id = ((Number)entry.getKey()).intValue();
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            Intrinsics.checkNotNull(worldClient);
            if (worldClient.func_73045_a(id) != null) continue;
            this.points.remove(id);
        }
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        Intrinsics.checkNotNull(entityPlayerSP);
        if (entityPlayerSP.field_70173_aa % ((Number)this.precision.get()).intValue() != 0) {
            return;
        }
        if (((Boolean)this.drawTargets.get()).booleanValue()) {
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            Intrinsics.checkNotNull(worldClient);
            List list = worldClient.field_72996_f;
            Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
            $this$forEach$iv = list;
            $i$f$forEach = false;
            iterator2 = $this$forEach$iv.iterator();
            while (iterator2.hasNext()) {
                element$iv = iterator2.next();
                Entity it = (Entity)element$iv;
                boolean bl3 = false;
                if (!EntityUtils.isSelected(it, true)) continue;
                Intrinsics.checkNotNull(it, "null cannot be cast to non-null type net.minecraft.entity.EntityLivingBase");
                this.updatePoints((EntityLivingBase)it);
            }
        }
        if (((Boolean)this.drawplayer.get()).booleanValue()) {
            EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP2);
            this.updatePoints((EntityLivingBase)entityPlayerSP2);
        }
    }

    private final void updatePoints(EntityLivingBase entity) {
        List list = this.points.get(entity.func_145782_y());
        if (list == null) {
            List list2;
            List it = list2 = (List)new ArrayList();
            boolean bl2 = false;
            this.points.put(entity.func_145782_y(), it);
            list = list2;
        }
        list.add((BreadcrumbPoint)new BreadcrumbPoint(entity.field_70165_t, entity.func_174813_aQ().field_72338_b, entity.field_70161_v, System.currentTimeMillis(), this.getColor().getRGB()));
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.points.clear();
    }

    @Override
    public void onDisable() {
        this.points.clear();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Trail$BreadcrumbPoint;", "", "x", "", "y", "z", "time", "", "color", "", "<init>", "(DDDJI)V", "getX", "()D", "getY", "getZ", "getTime", "()J", "getColor", "()I", "DarkMeow"})
    public static final class BreadcrumbPoint {
        private final double x;
        private final double y;
        private final double z;
        private final long time;
        private final int color;

        public BreadcrumbPoint(double x2, double y2, double z2, long time, int color) {
            this.x = x2;
            this.y = y2;
            this.z = z2;
            this.time = time;
            this.color = color;
        }

        public final double getX() {
            return this.x;
        }

        public final double getY() {
            return this.y;
        }

        public final double getZ() {
            return this.z;
        }

        public final long getTime() {
            return this.time;
        }

        public final int getColor() {
            return this.color;
        }
    }
}

