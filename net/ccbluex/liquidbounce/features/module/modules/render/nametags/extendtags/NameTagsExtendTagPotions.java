/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.nametags.extendtags;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.render.nametags.NameTagsExtendTag;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.darkmeow.darkmeow.utils.visual.GlStateManagerUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/nametags/extendtags/NameTagsExtendTagPotions;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/nametags/NameTagsExtendTag;", "<init>", "()V", "resource", "Lnet/minecraft/util/ResourceLocation;", "onRenderExtend", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNameTagsExtendTagPotions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NameTagsExtendTagPotions.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/nametags/extendtags/NameTagsExtendTagPotions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n774#2:56\n865#2,2:57\n2767#2:60\n1878#2,3:62\n1#3:59\n1#3:61\n*S KotlinDebug\n*F\n+ 1 NameTagsExtendTagPotions.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/nametags/extendtags/NameTagsExtendTagPotions\n*L\n17#1:56\n17#1:57,2\n33#1:60\n33#1:62,3\n33#1:61\n*E\n"})
public final class NameTagsExtendTagPotions
extends NameTagsExtendTag {
    @NotNull
    private final ResourceLocation resource = new ResourceLocation("textures/gui/container/inventory.png");

    public NameTagsExtendTagPotions() {
        super("Potions");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean onRenderExtend(@NotNull EntityLivingBase entity) {
        boolean bl2;
        List list;
        List list2;
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Collection collection = entity.func_70651_bq();
        Intrinsics.checkNotNullExpressionValue(collection, "getActivePotionEffects(...)");
        Iterable $this$filter$iv = collection;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            PotionEffect it = (PotionEffect)element$iv$iv;
            boolean bl3 = false;
            if (!it.func_188419_a().func_76400_d()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List it = list2 = (List)destination$iv$iv;
        boolean bl4 = false;
        List list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            List list4;
            void $this$onEachIndexed$iv;
            List list5;
            Iterable it2 = list5 = list;
            boolean bl5 = false;
            net.darkmeow.darkmeow.utils.visual.RenderUtils.INSTANCE.drawRect(0, 0, 16, it2.size() * 16, ColorValue.getColor$default(this.getInstance().backgroundColorValue, null, 1, null));
            GlStateManagerUtils.INSTANCE.applyBlend();
            GlStateManager.func_179098_w();
            GlStateManager.func_179091_B();
            it2 = list5;
            boolean $i$f$onEachIndexed = false;
            void $this$onEachIndexed_u24lambda_u2419$iv = $i$f$filterTo = $this$onEachIndexed$iv;
            boolean bl6 = false;
            void $this$forEachIndexed$iv$iv = $this$onEachIndexed_u24lambda_u2419$iv;
            boolean $i$f$forEachIndexed = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$forEachIndexed$iv$iv) {
                void potion;
                int n2;
                int n3;
                if ((n3 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PotionEffect potionEffect = (PotionEffect)item$iv$iv;
                int index = n3;
                boolean bl7 = false;
                MinecraftInstance.mc.getTextureManager().func_110577_a(this.resource);
                int iconIndex = n2 = potion.func_188419_a().func_76392_e();
                boolean bl8 = false;
                Color color = Color.WHITE;
                Intrinsics.checkNotNullExpressionValue(color, "WHITE");
                ColorUtils.INSTANCE.setGlColor(color);
                RenderUtils.drawTexturedModalRect(0, index * 16, 0 + iconIndex % 8 * 18, 198 + iconIndex / 8 * 18, 14, 14, 0.0f);
            }
            List it3 = list4 = (List)$i$f$filterTo;
            boolean bl9 = false;
            GlStateManager.func_179101_C();
            GlStateManagerUtils.INSTANCE.unapplyBlend();
            List it4 = list4;
            boolean bl10 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

