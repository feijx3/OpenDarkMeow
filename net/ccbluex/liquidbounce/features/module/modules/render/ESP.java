/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.ITextComponent
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.handler.combat.IFakeEntity;
import net.ccbluex.liquidbounce.injection.extend.ExtendRenderManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
import net.ccbluex.liquidbounce.utils.EntityUtils;
import net.ccbluex.liquidbounce.utils.file.FileUtils;
import net.ccbluex.liquidbounce.utils.file.ResourceLocationUtils;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020!H\u0007J\u0010\u0010%\u001a\u00020&2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006'"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "imageModeValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "image", "Lnet/minecraft/util/ResourceLocation;", "customImage", "entityImages", "Ljava/util/HashMap;", "Lnet/minecraft/entity/Entity;", "Lkotlin/collections/HashMap;", "colorRedValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "colorGreenValue", "colorBlueValue", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "colorTeam", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "translateEntity", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "rotateEntity", "scaleEntity", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "tag", "getTag", "()Ljava/lang/String;", "getColor", "Ljava/awt/Color;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nESP.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ESP.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/ESP\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,169:1\n382#2,7:170\n*S KotlinDebug\n*F\n+ 1 ESP.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/ESP\n*L\n91#1:170,7\n*E\n"})
public final class ESP
extends Module {
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @NotNull
    private final Value<String> imageModeValue;
    @Nullable
    private ResourceLocation image;
    @Nullable
    private ResourceLocation customImage;
    @NotNull
    private final HashMap<Entity, ResourceLocation> entityImages;
    @NotNull
    private final IntegerValue colorRedValue;
    @NotNull
    private final IntegerValue colorGreenValue;
    @NotNull
    private final IntegerValue colorBlueValue;
    @NotNull
    private final BoolValue colorRainbow;
    @NotNull
    private final BoolValue colorTeam;

    public ESP() {
        super("ESP", ModuleCategory.RENDER, null, null, 12, null);
        Object object = new String[]{"Box", "OtherBox", "Image"};
        this.modeValue = new ListValue("Mode", (String[])object, "Box");
        object = new String[]{"XuJinLiang", "XuBingCai", "XuLiHong", "XinXinFamily", "SunZheng", "ChengJunDa", "LiJiaJin", "FengZhiYuan", "Custom"};
        this.imageModeValue = new ListValue("ImageMode", (String[])object, "XuJinLiang").displayable(() -> ESP.imageModeValue$lambda$0(this));
        this.entityImages = new HashMap();
        if (this.customImage == null) {
            Object file = object = new File(DarkMeow.INSTANCE.getFileManager().getDir(), "head.png");
            boolean bl2 = false;
            if (!((File)file).exists()) {
                FileUtils.INSTANCE.unpackResourceFile("assets/minecraft/darkmeow/head/head.png", (File)file);
            }
            ResourceLocation resourceLocation = ResourceLocationUtils.toResourceLocation$default(ResourceLocationUtils.INSTANCE, (File)file, null, 1, null);
            if (resourceLocation != null) {
                this.customImage = resourceLocation;
            }
        }
        this.colorRedValue = new IntegerValue("R", 255, 0, 255);
        this.colorGreenValue = new IntegerValue("G", 255, 0, 255);
        this.colorBlueValue = new IntegerValue("B", 255, 0, 255);
        this.colorRainbow = new BoolValue("Rainbow", false);
        this.colorTeam = new BoolValue("Team", false);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @EventTarget
    public final void onRender3D(@Nullable Render3DEvent event) {
        v0 = MinecraftInstance.mc.getWorld();
        if (v0 == null) {
            return;
        }
        world = v0;
        mode = (String)this.modeValue.get();
        for (Entity entity : world.field_72996_f) {
            if (Intrinsics.areEqual(entity, MinecraftInstance.mc.getPlayer()) || entity instanceof IFakeEntity || !EntityUtils.isSelected(entity, false)) continue;
            Intrinsics.checkNotNull(entity, "null cannot be cast to non-null type net.minecraft.entity.EntityLivingBase");
            entityLiving = (EntityLivingBase)entity;
            color = this.getColor((Entity)entityLiving);
            Intrinsics.checkNotNullExpressionValue(mode.toLowerCase(Locale.ROOT), "toLowerCase(...)");
            switch (var8_8.hashCode()) {
                case 100313435: {
                    if (var8_8.equals("image")) break;
                    ** break;
                }
                case 97739: {
                    if (!var8_8.equals("box")) {
                        ** break;
                    }
                    ** GOTO lbl22
                }
                case -1171135301: {
                    if (!var8_8.equals("otherbox")) ** break;
lbl22:
                    // 2 sources

                    RenderUtils.drawEntityBox(entity, color, StringsKt.equals(mode, "otherbox", true) == false);
                    ** break;
                }
            }
            var9_9 = this.imageModeValue.get();
            tmp = -1;
            switch (var9_9.hashCode()) {
                case 1782242714: {
                    if (var9_9.equals("XuLiHong")) {
                        tmp = 1;
                    }
                    break;
                }
                case -1676359644: {
                    if (var9_9.equals("SunZheng")) {
                        tmp = 2;
                    }
                    break;
                }
                case -1781095001: {
                    if (var9_9.equals("ChengJunDa")) {
                        tmp = 3;
                    }
                    break;
                }
                case -388107284: {
                    if (var9_9.equals("FengZhiYuan")) {
                        tmp = 4;
                    }
                    break;
                }
                case 226696362: {
                    if (var9_9.equals("LiJiaJin")) {
                        tmp = 5;
                    }
                    break;
                }
                case 2029746065: {
                    if (var9_9.equals("Custom")) {
                        tmp = 6;
                    }
                    break;
                }
                case 908076971: {
                    if (var9_9.equals("XuJinLiang")) {
                        tmp = 7;
                    }
                    break;
                }
                case -835338866: {
                    if (var9_9.equals("XuBingCai")) {
                        tmp = 8;
                    }
                    break;
                }
                case 2033783396: {
                    if (var9_9.equals("XinXinFamily")) {
                        tmp = 9;
                    }
                    break;
                }
            }
            switch (tmp) {
                case 7: {
                    this.image = new ResourceLocation("darkmeow/head/xinxin.png");
                    break;
                }
                case 8: {
                    this.image = ((EntityLivingBase)entity).func_110143_aJ() >= ((EntityLivingBase)entity).func_110138_aP() ? new ResourceLocation("darkmeow/head/xubingcolor_happy.png") : (((EntityLivingBase)entity).func_110143_aJ() >= ((EntityLivingBase)entity).func_110138_aP() / (float)2 ? new ResourceLocation("darkmeow/head/xubingcolor.png") : (((EntityLivingBase)entity).func_110143_aJ() >= ((EntityLivingBase)entity).func_110138_aP() / (float)4 ? new ResourceLocation("darkmeow/head/xubingcolor_sadness.png") : (((EntityLivingBase)entity).func_110143_aJ() < ((EntityLivingBase)entity).func_110138_aP() / (float)4 || ((EntityLivingBase)entity).field_70128_L != false ? new ResourceLocation("darkmeow/head/xubingcolor_sad.png") : null)));
                    break;
                }
                case 1: {
                    this.image = new ResourceLocation("darkmeow/head/xulired.png");
                    break;
                }
                case 2: {
                    this.image = new ResourceLocation("darkmeow/head/sunzhengyo.png");
                    break;
                }
                case 3: {
                    this.image = new ResourceLocation("darkmeow/head/zunda.png");
                    break;
                }
                case 5: {
                    this.image = new ResourceLocation("darkmeow/head/hot_neko.png");
                    break;
                }
                case 4: {
                    this.image = new ResourceLocation("darkmeow/head/fengzhiyuan.png");
                    break;
                }
                case 6: {
                    this.image = this.customImage;
                    break;
                }
                case 9: {
                    v1 = this;
                    var10_10 = this.entityImages;
                    key$iv = entity;
                    $i$f$getOrPut = false;
                    value$iv = $this$getOrPut$iv.get(key$iv);
                    if (value$iv == null) {
                        var17_18 = v1;
                        $i$a$-getOrPut-ESP$onRender3D$1 = false;
                        var15_16 = new String[]{"darkmeow/head/xinxin.png", "darkmeow/head/xubingcolor.png", "darkmeow/head/xulired.png", "darkmeow/head/xuhualu.png", "darkmeow/head/xuhuazhi.png", "darkmeow/head/xunewred.png", "darkmeow/head/xuxiaoyu.png"};
                        images = CollectionsKt.listOf(var15_16);
                        v1 = var17_18;
                        answer$iv = new ResourceLocation((String)CollectionsKt.random((Collection)images, Random.Default));
                        $this$getOrPut$iv.put(key$iv, answer$iv);
                        v2 /* !! */  = answer$iv;
                    } else {
                        v2 /* !! */  = value$iv;
                    }
                    v1.image = (ResourceLocation)v2 /* !! */ ;
                }
            }
            if (this.image == null) continue;
            GlStateManager.func_179094_E();
            this.translateEntity((EntityLivingBase)entity);
            this.rotateEntity();
            this.scaleEntity();
            RenderUtils.drawImage(this.image, -8, -14, 16, 16);
            GlStateManager.func_179121_F();
lbl126:
            // 6 sources

        }
    }

    private final void translateEntity(EntityLivingBase entity) {
        GlStateManager.func_179109_b((float)((float)(entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * (double)MinecraftInstance.mc.getTimer().field_194147_b - ExtendRenderManager.INSTANCE.getRenderPosX(MinecraftInstance.mc.getRenderManager()))), (float)((float)(entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * (double)MinecraftInstance.mc.getTimer().field_194147_b - ExtendRenderManager.INSTANCE.getRenderPosY(MinecraftInstance.mc.getRenderManager()) + (double)(entity.func_70093_af() ? 0.8f : 1.3f))), (float)((float)(entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * (double)MinecraftInstance.mc.getTimer().field_194147_b - ExtendRenderManager.INSTANCE.getRenderPosZ(MinecraftInstance.mc.getRenderManager()))));
    }

    private final void rotateEntity() {
        GlStateManager.func_179114_b((float)(-MinecraftInstance.mc.getRenderManager().field_78735_i), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)MinecraftInstance.mc.getRenderManager().field_78732_j, (float)1.0f, (float)0.0f, (float)0.0f);
    }

    private final void scaleEntity() {
        float scale = 0.06f;
        GlStateManager.func_179152_a((float)(-scale), (float)(-scale), (float)scale);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.entityImages.keySet().removeIf(arg_0 -> ESP.onUpdate$lambda$4(ESP::onUpdate$lambda$3, arg_0));
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)this.modeValue.get();
    }

    @NotNull
    public final Color getColor(@Nullable Entity entity) {
        ESP $this$getColor_u24lambda_u245 = this;
        boolean bl2 = false;
        if (entity != null && entity instanceof EntityLivingBase) {
            if (((EntityLivingBase)entity).field_70737_aN > 0) {
                Color color = Color.RED;
                Intrinsics.checkNotNullExpressionValue(color, "RED");
                return color;
            }
            if (EntityUtils.INSTANCE.isFriend(entity)) {
                Color color = Color.BLUE;
                Intrinsics.checkNotNullExpressionValue(color, "BLUE");
                return color;
            }
            if (((Boolean)$this$getColor_u24lambda_u245.colorTeam.get()).booleanValue()) {
                ITextComponent iTextComponent = ((EntityLivingBase)entity).func_145748_c_();
                if (iTextComponent != null) {
                    String string = iTextComponent.func_150254_d();
                    Intrinsics.checkNotNullExpressionValue(string, "getFormattedText(...)");
                    char[] cArray = string.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(cArray, "toCharArray(...)");
                    char[] chars = cArray;
                    int color = Integer.MAX_VALUE;
                    int n2 = chars.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        int index;
                        if (chars[i2] != '\u00a7' || i2 + 1 >= chars.length || (index = GameFontRenderer.Companion.getColorIndex(chars[i2 + 1])) < 0 || index > 15) continue;
                        color = ColorUtils.hexColors[index];
                        break;
                    }
                    return new Color(color);
                }
            }
        }
        return (Boolean)this.colorRainbow.get() != false ? ColorUtils.rainbow() : new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue());
    }

    private static final boolean imageModeValue$lambda$0(ESP this$0) {
        return Intrinsics.areEqual(this$0.modeValue.get(), "Image");
    }

    private static final boolean onUpdate$lambda$3(Entity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        Intrinsics.checkNotNull(worldClient);
        return !worldClient.field_72996_f.contains(it);
    }

    private static final boolean onUpdate$lambda$4(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

