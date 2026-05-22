/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.MobEffects
 *  net.minecraft.potion.PotionEffect
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityNameEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.misc.AntiBot;
import net.ccbluex.liquidbounce.features.module.modules.render.nametags.NameTagsExtendTag;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.EntityUtils;
import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.color.ColorValueManager;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u001dH\u0007J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "extendTags", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/nametags/NameTagsExtendTag;", "renderSelfValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "renderNoClipValue", "renderHeightValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "renderDynamicScaleValue", "renderScaleValue", "backgroundColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "healthValue", "pingValue", "distanceValue", "rectValue", "rectLineFirstColorNormalValue", "rectLineFirstColorStrengthValue", "rectLineSecondColorNormalValue", "onRenderEntityName", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityNameEvent;", "event", "onRender3D", "", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "renders", "", "renderNameTage", "currentEntity", "Lnet/minecraft/entity/Entity;", "getNameTagText", "getNameTagRect", "Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags$NameTagRect;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "NameTagRect", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNameTags.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NameTags.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/NameTags\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,255:1\n1#2:256\n1#2:269\n1563#3:257\n1634#3,3:258\n1056#3:261\n1869#3:262\n1869#3,2:263\n1870#3:265\n2756#3:268\n1761#3,3:279\n12434#4,2:266\n536#5:270\n521#5,6:271\n216#6,2:277\n*S KotlinDebug\n*F\n+ 1 NameTags.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/NameTags\n*L\n141#1:269\n91#1:257\n91#1:258,3\n92#1:261\n93#1:262\n101#1:263,2\n93#1:265\n141#1:268\n241#1:279,3\n126#1:266,2\n201#1:270\n201#1:271,6\n202#1:277,2\n*E\n"})
public final class NameTags
extends Module {
    @NotNull
    private final Map<String, NameTagsExtendTag> extendTags = new LinkedHashMap();
    @JvmField
    @NotNull
    public final BoolValue renderSelfValue = new BoolValue("RenderSelf", true);
    @JvmField
    @NotNull
    public final BoolValue renderNoClipValue = new BoolValue("RenderNoClip", true);
    @JvmField
    @NotNull
    public final FloatValue renderHeightValue = new FloatValue("RenderHeight", 0.5f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 2.0f));
    @JvmField
    @NotNull
    public final BoolValue renderDynamicScaleValue = new BoolValue("RenderDynamicScale", true);
    @JvmField
    @NotNull
    public final FloatValue renderScaleValue = new FloatValue("RenderScale", 1.0f, 1.0f, 4.0f);
    @JvmField
    @NotNull
    public final ColorValue backgroundColorValue = new ColorValue("BackgroundColor", ColorValueManager.Companion.getDEFAULT_BACKGROUND(), false, 4, null);
    @JvmField
    @NotNull
    public final BoolValue healthValue = new BoolValue("Health", true);
    @JvmField
    @NotNull
    public final BoolValue pingValue = new BoolValue("Ping", true);
    @JvmField
    @NotNull
    public final BoolValue distanceValue = new BoolValue("Distance", false);
    @JvmField
    @NotNull
    public final BoolValue rectValue = new BoolValue("Rect", true);
    @JvmField
    @NotNull
    public final ColorValue rectLineFirstColorNormalValue;
    @JvmField
    @NotNull
    public final ColorValue rectLineFirstColorStrengthValue;
    @JvmField
    @NotNull
    public final ColorValue rectLineSecondColorNormalValue;
    @NotNull
    private final List<RenderEntityNameEvent> renders;

    /*
     * WARNING - void declaration
     */
    public NameTags() {
        super("NameTags", ModuleCategory.RENDER, null, null, 12, null);
        void $this$rectLineSecondColorNormalValue_u24lambda_u242;
        Value[] $this$rectLineFirstColorStrengthValue_u24lambda_u241;
        Value[] $this$rectLineFirstColorNormalValue_u24lambda_u240;
        Value[] valueArray;
        Object object = valueArray = new ColorValue("RectLineFirstColorNormal", ColorValueManager.Companion.getDEFAULT_NORMAL(), false, 4, null);
        Object object2 = this;
        boolean bl2 = false;
        $this$rectLineFirstColorNormalValue_u24lambda_u240.setSuperValue(this.rectValue);
        ((NameTags)object2).rectLineFirstColorNormalValue = valueArray;
        $this$rectLineFirstColorNormalValue_u24lambda_u240 = valueArray = new ColorValue("RectLineFirstColorStrength", new ColorValueInfo(new Color(255, 0, 0)), false, 4, null);
        object2 = this;
        boolean bl3 = false;
        $this$rectLineFirstColorStrengthValue_u24lambda_u241.setSuperValue(this.rectValue);
        ((NameTags)object2).rectLineFirstColorStrengthValue = valueArray;
        $this$rectLineFirstColorStrengthValue_u24lambda_u241 = valueArray = new ColorValue("RectLineSecondColorNormal", new ColorValueInfo(new Color(255, 255, 0)), false, 4, null);
        object2 = this;
        boolean bl4 = false;
        $this$rectLineSecondColorNormalValue_u24lambda_u242.setSuperValue(this.rectValue);
        ((NameTags)object2).rectLineSecondColorNormalValue = valueArray;
        valueArray = new Value[]{this.renderSelfValue, this.renderHeightValue, this.renderNoClipValue, this.renderDynamicScaleValue, this.renderScaleValue, this.backgroundColorValue, this.healthValue, this.pingValue, this.distanceValue, this.rectValue, this.rectLineFirstColorNormalValue, this.rectLineFirstColorStrengthValue, this.rectLineSecondColorNormalValue};
        CollectionsKt.addAll((Collection)this.getValues(), valueArray);
        Object it = object = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".nametags.extendtags", NameTagsExtendTag.class);
        boolean bl5 = false;
        Object object3 = valueArray = !((Collection)it).isEmpty() ? object : null;
        if (valueArray != null) {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = (Iterable)valueArray;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                object2 = destination$iv$iv;
                boolean bl6 = false;
                object2.add((NameTagsExtendTag)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    NameTagsExtendTag it = (NameTagsExtendTag)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeName());
                    it = (NameTagsExtendTag)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
                }
            });
            if (list != null) {
                void $this$forEach$iv;
                $this$sortedBy$iv = list;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    NameTagsExtendTag it3 = (NameTagsExtendTag)element$iv;
                    boolean bl7 = false;
                    BoolValue modulesValue2 = new BoolValue(it3.getModeName(), false);
                    it3.setInstance(this);
                    it3.setLinkedStatValue(modulesValue2);
                    this.getValues().add(modulesValue2);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl8 = false;
                        value.setSuperValue(modulesValue2);
                        this.getValues().add(value);
                    }
                    this.extendTags.put(it3.getModeName(), it3);
                }
            }
        }
        this.renders = new ArrayList();
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    @Nullable
    public final RenderEntityNameEvent onRenderEntityName(@NotNull RenderEntityNameEvent event) {
        RenderEntityNameEvent renderEntityNameEvent;
        RenderEntityNameEvent renderEntityNameEvent2;
        boolean bl2;
        RenderEntityNameEvent renderEntityNameEvent3;
        block11: {
            Intrinsics.checkNotNullParameter(event, "event");
            RenderEntityNameEvent it = renderEntityNameEvent3 = event;
            boolean bl3 = false;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                bl2 = false;
            } else {
                EntityPlayerSP player = entityPlayerSP;
                WorldClient worldClient = MinecraftInstance.mc.getWorld();
                if (worldClient == null) {
                    bl2 = false;
                } else {
                    boolean bl4;
                    WorldClient world = worldClient;
                    boolean bl5 = bl4 = event.getEntity() == MinecraftInstance.mc.getPlayer();
                    if (bl4) {
                        bl2 = ((Boolean)this.renderSelfValue.get()).booleanValue() && !DarkMeow.INSTANCE.getRotationManager().pauseRotationVisualFix;
                    } else if (!bl4) {
                        void $this$all$iv;
                        Boolean[] booleanArray = new Boolean[]{EntityUtils.isSelected((Entity)event.getEntity(), false), world.func_191503_g((Entity)event.getEntity()), player.func_70032_d((Entity)event.getEntity()) < 200.0f};
                        boolean $i$f$all = false;
                        for (void element$iv : $this$all$iv) {
                            boolean it2 = element$iv.booleanValue();
                            boolean bl6 = false;
                            if (it2) continue;
                            bl2 = false;
                            break block11;
                        }
                        bl2 = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
        RenderEntityNameEvent renderEntityNameEvent4 = renderEntityNameEvent2 = bl2 ? renderEntityNameEvent3 : null;
        if (renderEntityNameEvent2 != null) {
            RenderEntityNameEvent renderEntityNameEvent5;
            RenderEntityNameEvent it = renderEntityNameEvent5 = renderEntityNameEvent2;
            boolean bl7 = false;
            this.renders.add(it);
            RenderEntityNameEvent $this$onRenderEntityName_u24lambda_u2411 = renderEntityNameEvent5;
            boolean bl8 = false;
            $this$onRenderEntityName_u24lambda_u2411.cancelEvent();
            renderEntityNameEvent = renderEntityNameEvent5;
        } else {
            renderEntityNameEvent = null;
        }
        return renderEntityNameEvent;
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        Iterable iterable;
        Intrinsics.checkNotNullParameter(event, "event");
        Entity entity = MinecraftInstance.mc.getRenderViewEntity();
        if (entity == null) {
            return;
        }
        Entity currentEntity = entity;
        Iterable $this$onEach$iv = this.renders;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl2 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            RenderEntityNameEvent it = (RenderEntityNameEvent)element$iv;
            boolean bl3 = false;
            this.renderNameTage(it, currentEntity);
        }
        ((List)iterable).clear();
    }

    /*
     * WARNING - void declaration
     */
    private final void renderNameTage(RenderEntityNameEvent event, Entity currentEntity) {
        void $this$forEach$iv;
        void $this$filterTo$iv$iv;
        Map $this$filter$iv;
        Object it;
        float f2;
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)event.getX(), (double)(event.getY() + (double)event.getEntity().field_70131_O + ((Number)this.renderHeightValue.get()).doubleValue()), (double)event.getZ());
        GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)(-MinecraftInstance.mc.getRenderManager().field_78735_i), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)((float)(MinecraftInstance.mc.getRenderManager().field_78733_k.field_74320_O == 2 ? -1 : 1) * MinecraftInstance.mc.getRenderManager().field_78732_j), (float)1.0f, (float)0.0f, (float)0.0f);
        float it2 = ((Number)this.renderScaleValue.get()).floatValue();
        boolean bl2 = false;
        float base = it2 * -0.025f;
        boolean bl3 = false;
        it2 = f2 = ((Boolean)this.renderDynamicScaleValue.get()).booleanValue() ? RangesKt.coerceAtLeast(currentEntity.func_70032_d((Entity)event.getEntity()) / 6.0f, 1.0f) * base : base;
        boolean bl4 = false;
        GlStateManager.func_179152_a((float)it2, (float)it2, (float)it2);
        if (((Boolean)this.renderNoClipValue.get()).booleanValue()) {
            GlStateManager.func_179097_i();
        }
        NameTags $this$renderNameTage_u24lambda_u2419 = this;
        boolean bl5 = false;
        FontRenderer font = Fonts.minecraftFont;
        String text = $this$renderNameTage_u24lambda_u2419.getNameTagText(event);
        int widthPair = font.func_78256_a(text) / 2;
        RenderUtils.INSTANCE.drawRect(-widthPair - 2, -2, widthPair + 3, font.field_78288_b + 3, ColorValue.getColor$default($this$renderNameTage_u24lambda_u2419.backgroundColorValue, null, 1, null));
        if (((Boolean)$this$renderNameTage_u24lambda_u2419.rectValue.get()).booleanValue()) {
            NameTagRect nameTagRect = $this$renderNameTage_u24lambda_u2419.getNameTagRect(event.getEntity());
            it = nameTagRect;
            boolean bl6 = false;
            int x2 = -widthPair - 2;
            int length = widthPair + 3 - (-widthPair - 2);
            if (!(((NameTagRect)it).getFirstProgress() == 0.0f)) {
                RenderUtils.INSTANCE.drawRect(x2, font.field_78288_b + 2, x2 + (int)((float)length * ((NameTagRect)it).getFirstProgress()), font.field_78288_b + 3, ColorValue.getColor$default(((NameTagRect)it).getFirstColor(), null, 1, null));
            }
            if (!(((NameTagRect)it).getSecondProgress() == 0.0f)) {
                RenderUtils.INSTANCE.drawRect(x2, font.field_78288_b + 1, x2 + (int)((float)length * ((NameTagRect)it).getSecondProgress()), font.field_78288_b + 2, ColorValue.getColor$default(((NameTagRect)it).getSecondColor(), null, 1, null));
            }
        }
        float x3 = 0.0f;
        x3 = (float)(-widthPair) - 2.0f;
        it = $this$renderNameTage_u24lambda_u2419.extendTags;
        boolean $i$f$filter = false;
        void x2 = $this$filter$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv$iv;
            Map.Entry entry = element$iv$iv = iterator2.next();
            boolean bl7 = false;
            NameTagsExtendTag extendTag = (NameTagsExtendTag)entry.getValue();
            if (!((Boolean)extendTag.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
        }
        $this$filter$iv = destination$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator3 = $this$forEach$iv.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator3.next();
            boolean bl8 = false;
            NameTagsExtendTag extendTag = (NameTagsExtendTag)entry.getValue();
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b((float)x3, (float)((float)font.field_78288_b + 5.0f), (float)0.0f);
            if (extendTag.onRenderExtend(event.getEntity())) {
                x3 += 18.0f;
            }
            GlStateManager.func_179121_F();
        }
        FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, font, text, Float.valueOf(-((float)widthPair)), Float.valueOf(0.0f), null, false, 24, null);
        if (((Boolean)this.renderNoClipValue.get()).booleanValue()) {
            GlStateManager.func_179126_j();
        }
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        ColorUtils.INSTANCE.setGlColor(color);
        GlStateManager.func_179121_F();
    }

    private final String getNameTagText(RenderEntityNameEvent event) {
        String distanceText;
        EntityLivingBase entity = event.getEntity();
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return "";
        }
        EntityPlayerSP player = entityPlayerSP;
        boolean bot = AntiBot.isBot(entity);
        String nameColor = bot ? "\u00a73" : (entity.func_82150_aj() ? "\u00a76" : (entity.func_70093_af() ? "\u00a74" : "\u00a77"));
        int ping = entity instanceof EntityPlayer ? PlayerExtensionKt.getPing((EntityPlayer)entity) : 0;
        String string = distanceText = (Boolean)this.distanceValue.get() != false ? "\u00a77" + MathKt.roundToInt(PlayerExtensionKt.getDistanceToEntityBox((Entity)player, (Entity)entity)) + "m " : "";
        String pingText = (Boolean)this.pingValue.get() != false && entity instanceof EntityPlayer ? (ping > 200 ? "\u00a7c" : (ping > 100 ? "\u00a7e" : "\u00a7a")) + ping + "ms \u00a77" : "";
        String tagText = event.getDisplayName();
        String healthText = (Boolean)this.healthValue.get() != false ? "\u00a77\u00a7c " + (int)entity.func_110143_aJ() + ' ' : "";
        String botText = bot ? " \u00a7c\u00a7lBot" : "";
        return distanceText + pingText + nameColor + tagText + healthText + botText;
    }

    /*
     * WARNING - void declaration
     */
    private final NameTagRect getNameTagRect(EntityLivingBase entity) {
        boolean bl2;
        float f2;
        block3: {
            void $this$any$iv;
            float f3 = ((Number)RangesKt.coerceIn((Comparable)Float.valueOf(entity.func_110143_aJ() / entity.func_110138_aP()), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
            Collection collection = entity.func_70651_bq();
            Intrinsics.checkNotNullExpressionValue(collection, "getActivePotionEffects(...)");
            Iterable iterable = collection;
            f2 = f3;
            boolean $i$f$any = false;
            if (((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    PotionEffect it = (PotionEffect)element$iv;
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(it.func_188419_a(), MobEffects.field_76420_g)) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        boolean bl4 = bl2;
        ColorValue colorValue = this.rectLineSecondColorNormalValue;
        float f4 = ((Number)RangesKt.coerceIn((Comparable)Float.valueOf(entity.func_110139_bj() / entity.func_110138_aP()), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
        ColorValue colorValue2 = bl4 ? this.rectLineFirstColorStrengthValue : this.rectLineFirstColorNormalValue;
        float f5 = f2;
        return new NameTagRect(f5, colorValue2, f4, colorValue);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags$NameTagRect;", "", "firstProgress", "", "firstColor", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "secondProgress", "secondColor", "<init>", "(FLnet/ccbluex/liquidbounce/value/impl/ColorValue;FLnet/ccbluex/liquidbounce/value/impl/ColorValue;)V", "getFirstProgress", "()F", "getFirstColor", "()Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "getSecondProgress", "getSecondColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DarkMeow"})
    public static final class NameTagRect {
        private final float firstProgress;
        @NotNull
        private final ColorValue firstColor;
        private final float secondProgress;
        @NotNull
        private final ColorValue secondColor;

        public NameTagRect(float firstProgress, @NotNull ColorValue firstColor, float secondProgress, @NotNull ColorValue secondColor) {
            Intrinsics.checkNotNullParameter(firstColor, "firstColor");
            Intrinsics.checkNotNullParameter(secondColor, "secondColor");
            this.firstProgress = firstProgress;
            this.firstColor = firstColor;
            this.secondProgress = secondProgress;
            this.secondColor = secondColor;
        }

        public final float getFirstProgress() {
            return this.firstProgress;
        }

        @NotNull
        public final ColorValue getFirstColor() {
            return this.firstColor;
        }

        public final float getSecondProgress() {
            return this.secondProgress;
        }

        @NotNull
        public final ColorValue getSecondColor() {
            return this.secondColor;
        }

        public final float component1() {
            return this.firstProgress;
        }

        @NotNull
        public final ColorValue component2() {
            return this.firstColor;
        }

        public final float component3() {
            return this.secondProgress;
        }

        @NotNull
        public final ColorValue component4() {
            return this.secondColor;
        }

        @NotNull
        public final NameTagRect copy(float firstProgress, @NotNull ColorValue firstColor, float secondProgress, @NotNull ColorValue secondColor) {
            Intrinsics.checkNotNullParameter(firstColor, "firstColor");
            Intrinsics.checkNotNullParameter(secondColor, "secondColor");
            return new NameTagRect(firstProgress, firstColor, secondProgress, secondColor);
        }

        public static /* synthetic */ NameTagRect copy$default(NameTagRect nameTagRect, float f2, ColorValue colorValue, float f3, ColorValue colorValue2, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = nameTagRect.firstProgress;
            }
            if ((n2 & 2) != 0) {
                colorValue = nameTagRect.firstColor;
            }
            if ((n2 & 4) != 0) {
                f3 = nameTagRect.secondProgress;
            }
            if ((n2 & 8) != 0) {
                colorValue2 = nameTagRect.secondColor;
            }
            return nameTagRect.copy(f2, colorValue, f3, colorValue2);
        }

        @NotNull
        public String toString() {
            return "NameTagRect(firstProgress=" + this.firstProgress + ", firstColor=" + this.firstColor + ", secondProgress=" + this.secondProgress + ", secondColor=" + this.secondColor + ')';
        }

        public int hashCode() {
            int result = Float.hashCode(this.firstProgress);
            result = result * 31 + this.firstColor.hashCode();
            result = result * 31 + Float.hashCode(this.secondProgress);
            result = result * 31 + this.secondColor.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NameTagRect)) {
                return false;
            }
            NameTagRect nameTagRect = (NameTagRect)other;
            if (Float.compare(this.firstProgress, nameTagRect.firstProgress) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual(this.firstColor, nameTagRect.firstColor)) {
                return false;
            }
            if (Float.compare(this.secondProgress, nameTagRect.secondProgress) != 0) {
                return false;
            }
            return Intrinsics.areEqual(this.secondColor, nameTagRect.secondColor);
        }
    }
}

