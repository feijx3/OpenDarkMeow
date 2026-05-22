/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemAppleGold
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketEntityEquipment
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.features.module.modules.client.HUD;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityEquipment;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020$H\u0007J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R0\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementTargets;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "headPics", "Ljava/util/HashMap;", "Lnet/minecraft/entity/EntityLivingBase;", "Lnet/minecraft/util/ResourceLocation;", "Lkotlin/collections/HashMap;", "slotGoldenApples", "", "backgroundColorProgressValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "backgroundColorEmptyValue", "lengthValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "targetOnlyPlayerValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "targetRemoveMissTickValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "updateElement", "", "targets", "", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementTargets$TargetEntityInfo;", "getTargets", "()Ljava/util/List;", "onAttack", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "drawTarget", "target", "TargetEntityInfo", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElementTargets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementTargets.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementTargets\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,245:1\n1878#2,3:246\n1878#2,3:249\n295#2,2:252\n1#3:254\n382#4,7:255\n*S KotlinDebug\n*F\n+ 1 ElementTargets.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementTargets\n*L\n71#1:246,3\n99#1:249,3\n128#1:252,2\n211#1:255,7\n*E\n"})
public final class ElementTargets
extends Element {
    @JvmField
    @NotNull
    public final HashMap<EntityLivingBase, ResourceLocation> headPics = new HashMap();
    @JvmField
    @NotNull
    public final HashMap<EntityLivingBase, Integer> slotGoldenApples = new HashMap();
    @JvmField
    @NotNull
    public final ColorValue backgroundColorProgressValue = new ColorValue("BackgroundColorProgress", new ColorValueInfo(new Color(120, 120, 120, 120)), false, 4, null);
    @JvmField
    @NotNull
    public final ColorValue backgroundColorEmptyValue = new ColorValue("BackgroundColorEmpty", new ColorValueInfo(new Color(0, 0, 0, 120)), false, 4, null);
    @JvmField
    @NotNull
    public final IntegerValue lengthValue = new IntegerValue("Length", 160, new IntRange(120, 200));
    @JvmField
    @NotNull
    public final BoolValue targetOnlyPlayerValue = new BoolValue("TargetOnlyPlayer", true);
    @JvmField
    @NotNull
    public final IntegerValue targetRemoveMissTickValue = new IntegerValue("TargetRemoveMissTick", 40, new IntRange(20, 100));
    @NotNull
    private final List<TargetEntityInfo> targets;

    public ElementTargets() {
        super("Targets", -4.0, -4.0, 0.0f, new ElementSide(ElementSide.Horizontal.MIDDLE, ElementSide.Vertical.MIDDLE), 0, 40, null);
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), this, false, false, 6, null);
        this.targets = new ArrayList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        ElementTargets $this$drawElement_u24lambda_u241 = this;
        boolean bl2 = false;
        Iterable $this$forEachIndexed$iv = $this$drawElement_u24lambda_u241.targets;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            void info;
            int n2;
            if ((n2 = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TargetEntityInfo targetEntityInfo = (TargetEntityInfo)item$iv;
            int index = n2;
            boolean bl3 = false;
            GlStateManager.func_179094_E();
            $this$drawElement_u24lambda_u241.drawTarget((TargetEntityInfo)info, partialTicks);
            GlStateManager.func_179121_F();
        }
        ElementTargets $this$drawElement_u24lambda_u242 = this;
        boolean bl4 = false;
        if (MinecraftInstance.mc.getCurrentScreen() instanceof GuiHudDesigner && $this$drawElement_u24lambda_u242.targets.isEmpty()) {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                int n3 = 252;
                Color color = null;
                String string = null;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                long l2 = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
                EntityLivingBase entityLivingBase = (EntityLivingBase)entityPlayerSP;
                $this$drawElement_u24lambda_u242.drawTarget(new TargetEntityInfo(entityLivingBase, l2, f5, f4, f3, f2, string, color, n3, defaultConstructorMarker), partialTicks);
            }
        }
        return new ElementBorder(0.0f, 0.0f, ((Number)this.lengthValue.get()).intValue(), 40.0f);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void updateElement() {
        List<TargetEntityInfo> list;
        List<TargetEntityInfo> $this$updateElement_u24lambda_u245 = list = this.targets;
        boolean bl2 = false;
        $this$updateElement_u24lambda_u245.removeIf(arg_0 -> ElementTargets.updateElement$lambda$5$lambda$4(arg_0 -> ElementTargets.updateElement$lambda$5$lambda$3(this, arg_0), arg_0));
        Iterable $this$forEachIndexed$iv = list;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            void target;
            int n2;
            if ((n2 = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TargetEntityInfo targetEntityInfo = (TargetEntityInfo)item$iv;
            int index = n2;
            boolean bl3 = false;
            target.setPrevY(target.getY());
            target.setY((float)index * 45.0f);
            target.setPrevProgress(target.getProgress());
            target.setProgress(((Number)this.lengthValue.get()).floatValue() * ((Number)RangesKt.coerceIn((Comparable)Float.valueOf(target.getEntity().func_110143_aJ() / target.getEntity().func_110138_aP()), RangesKt.rangeTo(0.0f, 1.0f))).floatValue());
            target.setPrefix(target.getEntity().func_110143_aJ() <= 0.0f ? "\u00a74" : "");
            Color color = target.getEntity().field_70737_aN != target.getEntity().field_70738_aO && target.getEntity().field_70737_aN != 0 || target.getEntity().func_110143_aJ() <= 0.0f ? Color.RED : Color.WHITE;
            Intrinsics.checkNotNull(color);
            target.setHeadPicColor(color);
        }
    }

    @NotNull
    public final List<TargetEntityInfo> getTargets() {
        return this.targets;
    }

    @EventTarget
    public final void onAttack(@NotNull ControllerUseEntityAttackEvent event) {
        block4: {
            EntityLivingBase entityLivingBase;
            EntityLivingBase entityLivingBase2;
            block3: {
                TargetEntityInfo targetEntityInfo;
                TargetEntityInfo targetEntityInfo2;
                Object v0;
                block2: {
                    Intrinsics.checkNotNullParameter(event, "event");
                    Entity target = event.getTarget();
                    boolean bl2 = false;
                    Iterable $this$firstOrNull$iv = this.targets;
                    boolean $i$f$firstOrNull = false;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        TargetEntityInfo it = (TargetEntityInfo)element$iv;
                        boolean bl3 = false;
                        if (!Intrinsics.areEqual(it.getEntity(), target)) continue;
                        v0 = element$iv;
                        break block2;
                    }
                    v0 = null;
                }
                if ((targetEntityInfo2 = (TargetEntityInfo)v0) == null) break block3;
                TargetEntityInfo it = targetEntityInfo = targetEntityInfo2;
                boolean bl4 = false;
                it.setLastAttackUpdateId(DarkMeow.INSTANCE.getUpdateManager().getUpdateId());
                break block4;
            }
            ElementTargets $this$onAttack_u24lambda_u2413 = this;
            boolean bl5 = false;
            Entity it = event.getTarget();
            boolean bl6 = false;
            EntityLivingBase entityLivingBase3 = it instanceof EntityLivingBase ? (EntityLivingBase)it : null;
            if (entityLivingBase3 == null) break block4;
            EntityLivingBase it2 = entityLivingBase2 = entityLivingBase3;
            boolean bl7 = false;
            Object object = entityLivingBase = it2 instanceof EntityPlayer || (Boolean)$this$onAttack_u24lambda_u2413.targetOnlyPlayerValue.get() == false ? entityLivingBase2 : null;
            if (entityLivingBase != null) {
                EntityLivingBase target = entityLivingBase2 = entityLivingBase;
                boolean bl8 = false;
                long l2 = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
                float f2 = ((Number)$this$onAttack_u24lambda_u2413.lengthValue.get()).intValue();
                float f3 = ((Number)$this$onAttack_u24lambda_u2413.lengthValue.get()).intValue();
                $this$onAttack_u24lambda_u2413.targets.add(new TargetEntityInfo(target, l2, f3, f2, 0.0f, 0.0f, null, null, 240, null));
            }
        }
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        block3: {
            Entity entity;
            WorldClient worldClient;
            Packet<?> packet;
            block4: {
                Entity entity2;
                Intrinsics.checkNotNullParameter(event, "event");
                packet = event.getPacket();
                if (!(packet instanceof SPacketEntityEquipment)) break block3;
                if (!(((SPacketEntityEquipment)packet).func_149390_c().func_77973_b() instanceof ItemAppleGold) || ((SPacketEntityEquipment)packet).func_149390_c().func_77960_j() > 0) break block4;
                WorldClient worldClient2 = MinecraftInstance.mc.getWorld();
                if (worldClient2 == null || (entity2 = worldClient2.func_73045_a(((SPacketEntityEquipment)packet).func_149389_d())) == null) break block3;
                Entity it = entity2;
                boolean bl2 = false;
                EntityPlayer entityPlayer = it instanceof EntityPlayer ? (EntityPlayer)it : null;
                if (entityPlayer != null) {
                    EntityPlayer entityPlayer2;
                    EntityPlayer entity3 = entityPlayer2 = entityPlayer;
                    boolean bl3 = false;
                    ((Map)this.slotGoldenApples).put(entity3, ((SPacketEntityEquipment)packet).func_149390_c().func_190916_E());
                }
                break block3;
            }
            if (!((SPacketEntityEquipment)packet).func_149390_c().func_190926_b() || (worldClient = MinecraftInstance.mc.getWorld()) == null || (entity = worldClient.func_73045_a(((SPacketEntityEquipment)packet).func_149389_d())) == null) break block3;
            Entity it = entity;
            boolean bl4 = false;
            EntityPlayer entityPlayer = it instanceof EntityPlayer ? (EntityPlayer)it : null;
            if (entityPlayer != null) {
                EntityPlayer entityPlayer3;
                EntityPlayer entityPlayer4;
                EntityPlayer it2 = entityPlayer4 = entityPlayer;
                boolean bl5 = false;
                Integer n2 = this.slotGoldenApples.get(it2);
                Object object = entityPlayer3 = (n2 != null ? n2 : 0) <= 1 ? entityPlayer4 : null;
                if (entityPlayer3 != null) {
                    it2 = entityPlayer4 = entityPlayer3;
                    boolean bl6 = false;
                    this.slotGoldenApples.remove(it2);
                }
            }
        }
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.targets.clear();
        this.headPics.clear();
        this.slotGoldenApples.clear();
    }

    private final void drawTarget(TargetEntityInfo target, float partialTicks) {
        String string;
        String string2;
        Object[] resource;
        FontRenderer font = Fonts.minecraftFont;
        GlStateManager.func_179109_b((float)0.0f, (float)(target.getPrevY() + (target.getY() - target.getPrevY()) * partialTicks), (float)0.0f);
        ElementTargets $this$drawTarget_u24lambda_u2419 = this;
        boolean bl2 = false;
        float progress = target.getPrevProgress() + (target.getProgress() - target.getPrevProgress()) * partialTicks;
        HUD.drawBackground$default(HUD.INSTANCE, (Number)$this$drawTarget_u24lambda_u2419.lengthValue.get(), 40, null, 0.0f, 8, null);
        RenderUtils.INSTANCE.drawRect(0, 0, (Number)Float.valueOf(progress), 40, ColorValue.getColor$default($this$drawTarget_u24lambda_u2419.backgroundColorProgressValue, null, 1, null));
        RenderUtils.INSTANCE.drawRect((Number)Float.valueOf(progress), 0, (Number)$this$drawTarget_u24lambda_u2419.lengthValue.get(), 40, ColorValue.getColor$default($this$drawTarget_u24lambda_u2419.backgroundColorEmptyValue, null, 1, null));
        ElementTargets $this$drawTarget_u24lambda_u2426 = this;
        boolean bl3 = false;
        ElementTargets $this$drawTarget_u24lambda_u2426_u24lambda_u2422 = $this$drawTarget_u24lambda_u2426;
        boolean bl4 = false;
        ColorUtils.INSTANCE.setGlColor(target.getHeadPicColor());
        try {
            Object[] objectArray;
            Object[] objectArray2;
            Object object;
            Object[] $this$getOrPut$iv;
            Map map = $this$drawTarget_u24lambda_u2426_u24lambda_u2422.headPics;
            EntityLivingBase key$iv = target.getEntity();
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv == null) {
                boolean bl5 = false;
                EntityLivingBase entityLivingBase = target.getEntity();
                AbstractClientPlayer abstractClientPlayer = entityLivingBase instanceof AbstractClientPlayer ? (AbstractClientPlayer)entityLivingBase : null;
                ResourceLocation answer$iv = abstractClientPlayer != null ? abstractClientPlayer.func_110306_p() : null;
                $this$getOrPut$iv.put(key$iv, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            if ((objectArray2 = (Object[])object) != null) {
                resource = $this$getOrPut$iv = objectArray2;
                boolean bl6 = false;
                net.ccbluex.liquidbounce.utils.render.RenderUtils.quickDrawHead((ResourceLocation)resource, 6, 6, 28, 28);
                objectArray = $this$getOrPut$iv;
            } else {
                objectArray = null;
            }
            objectArray2 = objectArray;
        }
        catch (Throwable throwable) {
            Unit unit = Unit.INSTANCE;
        }
        ElementTargets $this$drawTarget_u24lambda_u2426_u24lambda_u2423 = $this$drawTarget_u24lambda_u2426;
        boolean bl7 = false;
        FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, font, target.getPrefix() + target.getEntity().func_70005_c_(), 40, 8, null, false, 24, null);
        StringBuilder stringBuilder = new StringBuilder().append(target.getPrefix()).append("Distance: ");
        String throwable = "%.2f";
        resource = new Object[1];
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        resource[0] = Float.valueOf(entityPlayerSP != null ? entityPlayerSP.func_70032_d((Entity)target.getEntity()) : 0.0f);
        String string3 = String.format(throwable, Arrays.copyOf(resource, resource.length));
        Intrinsics.checkNotNullExpressionValue(string3, "format(...)");
        FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, font, stringBuilder.append(string3).toString(), 40, 8 + font.field_78288_b + 4, null, false, 24, null);
        ElementTargets $this$drawTarget_u24lambda_u2426_u24lambda_u2425 = $this$drawTarget_u24lambda_u2426;
        boolean bl8 = false;
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder().append("\u00a7c");
        throwable = "%.1f";
        resource = new Object[]{Float.valueOf(target.getEntity().func_110143_aJ())};
        String string4 = String.format(throwable, Arrays.copyOf(resource, resource.length));
        Intrinsics.checkNotNullExpressionValue(string4, "format(...)");
        StringBuilder stringBuilder4 = stringBuilder2.append(stringBuilder3.append(string4).append('\u2764').toString());
        if (target.getEntity().func_110139_bj() > 0.0f) {
            StringBuilder stringBuilder5 = new StringBuilder().append(" \u00a7e");
            throwable = "%.1f";
            resource = new Object[]{Float.valueOf(target.getEntity().func_110139_bj())};
            String string5 = String.format(throwable, Arrays.copyOf(resource, resource.length));
            Intrinsics.checkNotNullExpressionValue(string5, "format(...)");
            string2 = stringBuilder5.append(string5).append('\u2764').toString();
        } else {
            string2 = "";
        }
        String render = string = stringBuilder4.append(string2).append($this$drawTarget_u24lambda_u2426_u24lambda_u2425.slotGoldenApples.containsKey(target.getEntity()) ? " \u00a7e(+" + $this$drawTarget_u24lambda_u2426_u24lambda_u2425.slotGoldenApples.get(target.getEntity()) + ')' : "").toString();
        boolean bl9 = false;
        Intrinsics.checkNotNull(render);
        FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, font, render, ((Number)$this$drawTarget_u24lambda_u2426_u24lambda_u2425.lengthValue.get()).intValue() - font.func_78256_a(render) - 4, 40 - font.field_78288_b - 2, null, false, 24, null);
    }

    private static final boolean updateElement$lambda$5$lambda$3(ElementTargets this$0, TargetEntityInfo target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return target.getLastAttackUpdateId() + ((Number)this$0.targetRemoveMissTickValue.get()).longValue() < DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
    }

    private static final boolean updateElement$lambda$5$lambda$4(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\t\u0010/\u001a\u00020\fH\u00c6\u0003J\t\u00100\u001a\u00020\u000eH\u00c6\u0003JY\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u000206H\u00d6\u0001J\t\u00107\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u00068"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementTargets$TargetEntityInfo;", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "lastAttackUpdateId", "", "progress", "", "prevProgress", "y", "prevY", "prefix", "", "headPicColor", "Ljava/awt/Color;", "<init>", "(Lnet/minecraft/entity/EntityLivingBase;JFFFFLjava/lang/String;Ljava/awt/Color;)V", "getEntity", "()Lnet/minecraft/entity/EntityLivingBase;", "getLastAttackUpdateId", "()J", "setLastAttackUpdateId", "(J)V", "getProgress", "()F", "setProgress", "(F)V", "getPrevProgress", "setPrevProgress", "getY", "setY", "getPrevY", "setPrevY", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "getHeadPicColor", "()Ljava/awt/Color;", "setHeadPicColor", "(Ljava/awt/Color;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "DarkMeow"})
    public static final class TargetEntityInfo {
        @NotNull
        private final EntityLivingBase entity;
        private long lastAttackUpdateId;
        private float progress;
        private float prevProgress;
        private float y;
        private float prevY;
        @NotNull
        private String prefix;
        @NotNull
        private Color headPicColor;

        public TargetEntityInfo(@NotNull EntityLivingBase entity, long lastAttackUpdateId, float progress, float prevProgress, float y2, float prevY, @NotNull String prefix, @NotNull Color headPicColor) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(headPicColor, "headPicColor");
            this.entity = entity;
            this.lastAttackUpdateId = lastAttackUpdateId;
            this.progress = progress;
            this.prevProgress = prevProgress;
            this.y = y2;
            this.prevY = prevY;
            this.prefix = prefix;
            this.headPicColor = headPicColor;
        }

        public /* synthetic */ TargetEntityInfo(EntityLivingBase entityLivingBase, long l2, float f2, float f3, float f4, float f5, String string, Color color, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                f2 = 1.0f;
            }
            if ((n2 & 8) != 0) {
                f3 = 1.0f;
            }
            if ((n2 & 0x10) != 0) {
                f4 = 0.0f;
            }
            if ((n2 & 0x20) != 0) {
                f5 = 0.0f;
            }
            if ((n2 & 0x40) != 0) {
                string = "";
            }
            if ((n2 & 0x80) != 0) {
                Color color2 = Color.WHITE;
                Intrinsics.checkNotNullExpressionValue(color2, "WHITE");
                color = color2;
            }
            this(entityLivingBase, l2, f2, f3, f4, f5, string, color);
        }

        @NotNull
        public final EntityLivingBase getEntity() {
            return this.entity;
        }

        public final long getLastAttackUpdateId() {
            return this.lastAttackUpdateId;
        }

        public final void setLastAttackUpdateId(long l2) {
            this.lastAttackUpdateId = l2;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final void setProgress(float f2) {
            this.progress = f2;
        }

        public final float getPrevProgress() {
            return this.prevProgress;
        }

        public final void setPrevProgress(float f2) {
            this.prevProgress = f2;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f2) {
            this.y = f2;
        }

        public final float getPrevY() {
            return this.prevY;
        }

        public final void setPrevY(float f2) {
            this.prevY = f2;
        }

        @NotNull
        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<set-?>");
            this.prefix = string;
        }

        @NotNull
        public final Color getHeadPicColor() {
            return this.headPicColor;
        }

        public final void setHeadPicColor(@NotNull Color color) {
            Intrinsics.checkNotNullParameter(color, "<set-?>");
            this.headPicColor = color;
        }

        @NotNull
        public final EntityLivingBase component1() {
            return this.entity;
        }

        public final long component2() {
            return this.lastAttackUpdateId;
        }

        public final float component3() {
            return this.progress;
        }

        public final float component4() {
            return this.prevProgress;
        }

        public final float component5() {
            return this.y;
        }

        public final float component6() {
            return this.prevY;
        }

        @NotNull
        public final String component7() {
            return this.prefix;
        }

        @NotNull
        public final Color component8() {
            return this.headPicColor;
        }

        @NotNull
        public final TargetEntityInfo copy(@NotNull EntityLivingBase entity, long lastAttackUpdateId, float progress, float prevProgress, float y2, float prevY, @NotNull String prefix, @NotNull Color headPicColor) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(headPicColor, "headPicColor");
            return new TargetEntityInfo(entity, lastAttackUpdateId, progress, prevProgress, y2, prevY, prefix, headPicColor);
        }

        public static /* synthetic */ TargetEntityInfo copy$default(TargetEntityInfo targetEntityInfo, EntityLivingBase entityLivingBase, long l2, float f2, float f3, float f4, float f5, String string, Color color, int n2, Object object) {
            if ((n2 & 1) != 0) {
                entityLivingBase = targetEntityInfo.entity;
            }
            if ((n2 & 2) != 0) {
                l2 = targetEntityInfo.lastAttackUpdateId;
            }
            if ((n2 & 4) != 0) {
                f2 = targetEntityInfo.progress;
            }
            if ((n2 & 8) != 0) {
                f3 = targetEntityInfo.prevProgress;
            }
            if ((n2 & 0x10) != 0) {
                f4 = targetEntityInfo.y;
            }
            if ((n2 & 0x20) != 0) {
                f5 = targetEntityInfo.prevY;
            }
            if ((n2 & 0x40) != 0) {
                string = targetEntityInfo.prefix;
            }
            if ((n2 & 0x80) != 0) {
                color = targetEntityInfo.headPicColor;
            }
            return targetEntityInfo.copy(entityLivingBase, l2, f2, f3, f4, f5, string, color);
        }

        @NotNull
        public String toString() {
            return "TargetEntityInfo(entity=" + this.entity + ", lastAttackUpdateId=" + this.lastAttackUpdateId + ", progress=" + this.progress + ", prevProgress=" + this.prevProgress + ", y=" + this.y + ", prevY=" + this.prevY + ", prefix=" + this.prefix + ", headPicColor=" + this.headPicColor + ')';
        }

        public int hashCode() {
            int result = this.entity.hashCode();
            result = result * 31 + Long.hashCode(this.lastAttackUpdateId);
            result = result * 31 + Float.hashCode(this.progress);
            result = result * 31 + Float.hashCode(this.prevProgress);
            result = result * 31 + Float.hashCode(this.y);
            result = result * 31 + Float.hashCode(this.prevY);
            result = result * 31 + this.prefix.hashCode();
            result = result * 31 + this.headPicColor.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TargetEntityInfo)) {
                return false;
            }
            TargetEntityInfo targetEntityInfo = (TargetEntityInfo)other;
            if (!Intrinsics.areEqual(this.entity, targetEntityInfo.entity)) {
                return false;
            }
            if (this.lastAttackUpdateId != targetEntityInfo.lastAttackUpdateId) {
                return false;
            }
            if (Float.compare(this.progress, targetEntityInfo.progress) != 0) {
                return false;
            }
            if (Float.compare(this.prevProgress, targetEntityInfo.prevProgress) != 0) {
                return false;
            }
            if (Float.compare(this.y, targetEntityInfo.y) != 0) {
                return false;
            }
            if (Float.compare(this.prevY, targetEntityInfo.prevY) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual(this.prefix, targetEntityInfo.prefix)) {
                return false;
            }
            return Intrinsics.areEqual(this.headPicColor, targetEntityInfo.headPicColor);
        }
    }
}

