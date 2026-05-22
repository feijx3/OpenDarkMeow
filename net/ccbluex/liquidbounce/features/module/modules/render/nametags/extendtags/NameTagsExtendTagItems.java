/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.nametags.extendtags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.render.nametags.NameTagsExtendTag;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/nametags/extendtags/NameTagsExtendTagItems;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/nametags/NameTagsExtendTag;", "<init>", "()V", "armorValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "mainHandValue", "offHandValue", "onRenderExtend", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNameTagsExtendTagItems.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NameTagsExtendTagItems.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/nametags/extendtags/NameTagsExtendTagItems\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n774#2:42\n865#2,2:43\n2767#2:46\n1878#2,3:48\n1#3:45\n1#3:47\n*S KotlinDebug\n*F\n+ 1 NameTagsExtendTagItems.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/nametags/extendtags/NameTagsExtendTagItems\n*L\n21#1:42\n21#1:43,2\n32#1:46\n32#1:48,3\n32#1:47\n*E\n"})
public final class NameTagsExtendTagItems
extends NameTagsExtendTag {
    @NotNull
    private final BoolValue armorValue = new BoolValue(this.getValuePrefix() + "Armor", true);
    @NotNull
    private final BoolValue mainHandValue = new BoolValue(this.getValuePrefix() + "MainHand", false);
    @NotNull
    private final BoolValue offHandValue = new BoolValue(this.getValuePrefix() + "OffHand", false);

    public NameTagsExtendTagItems() {
        super("Items");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean onRenderExtend(@NotNull EntityLivingBase entity) {
        boolean bl2;
        List list;
        void $this$filterTo$iv$iv;
        List list2;
        Intrinsics.checkNotNullParameter(entity, "entity");
        List $this$onRenderExtend_u24lambda_u240 = list2 = (List)new ArrayList();
        boolean $i$a$-apply-NameTagsExtendTagItems$onRenderExtend$22 = false;
        if (((Boolean)this.armorValue.get()).booleanValue()) {
            Iterable iterable = entity.func_184193_aE();
            Intrinsics.checkNotNullExpressionValue(iterable, "getArmorInventoryList(...)");
            $this$onRenderExtend_u24lambda_u240.addAll(CollectionsKt.reversed(iterable));
        }
        if (((Boolean)this.mainHandValue.get()).booleanValue()) {
            ItemStack itemStack = entity.func_184614_ca();
            Intrinsics.checkNotNullExpressionValue(itemStack, "getHeldItemMainhand(...)");
            $this$onRenderExtend_u24lambda_u240.add(itemStack);
        }
        if (((Boolean)this.offHandValue.get()).booleanValue()) {
            ItemStack itemStack = entity.func_184592_cb();
            Intrinsics.checkNotNullExpressionValue(itemStack, "getHeldItemOffhand(...)");
            $this$onRenderExtend_u24lambda_u240.add(itemStack);
        }
        Iterable $this$filter$iv = list2;
        boolean $i$f$filter = false;
        Iterable $i$a$-apply-NameTagsExtendTagItems$onRenderExtend$22 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            ItemStack it = (ItemStack)element$iv$iv;
            boolean bl3 = false;
            if (!(!it.func_190926_b())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List it = list2 = (List)destination$iv$iv;
        boolean bl4 = false;
        List list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            void $this$onEachIndexed$iv;
            List list4;
            Iterable it2 = list4 = list;
            boolean bl5 = false;
            RenderUtils.INSTANCE.drawRect(0, 0, 16, it2.size() * 16, ColorValue.getColor$default(this.getInstance().backgroundColorValue, null, 1, null));
            it2 = list4;
            boolean $i$f$onEachIndexed = false;
            void $this$onEachIndexed_u24lambda_u2419$iv = $i$f$filterTo = $this$onEachIndexed$iv;
            boolean bl6 = false;
            void $this$forEachIndexed$iv$iv = $this$onEachIndexed_u24lambda_u2419$iv;
            boolean $i$f$forEachIndexed = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$forEachIndexed$iv$iv) {
                void itemStack;
                int n2;
                if ((n2 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ItemStack itemStack2 = (ItemStack)item$iv$iv;
                int index = n2;
                boolean bl7 = false;
                RenderUtils.drawInGUIItem$default(0, index * 16, (ItemStack)itemStack, null, false, 0.0f, 56, null);
            }
            List it3 = (List)$i$f$filterTo;
            boolean bl8 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

