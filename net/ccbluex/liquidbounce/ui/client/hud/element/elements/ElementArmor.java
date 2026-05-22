/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementArmor;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "facingModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "removeEmptySlotValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElementArmor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementArmor.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementArmor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n774#2:45\n865#2,2:46\n2767#2:49\n1878#2,3:51\n1#3:48\n1#3:50\n*S KotlinDebug\n*F\n+ 1 ElementArmor.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementArmor\n*L\n24#1:45\n24#1:46,2\n26#1:49\n26#1:51,3\n26#1:50\n*E\n"})
public final class ElementArmor
extends Element {
    @NotNull
    private final ListValue facingModeValue;
    @NotNull
    private final BoolValue removeEmptySlotValue;

    public ElementArmor() {
        super("Armor", -96.0, 18.0, 0.0f, new ElementSide(ElementSide.Horizontal.MIDDLE, ElementSide.Vertical.DOWN), 0, 40, null);
        String[] stringArray = new String[]{"Horizontal", "Vertical"};
        this.facingModeValue = new ListValue("FacingMode", stringArray, "Horizontal");
        this.removeEmptySlotValue = new BoolValue("RemoveEmptySlot", true);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        ElementBorder elementBorder;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP != null) {
            Iterable iterable;
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            Iterable iterable2 = player.func_184193_aE();
            Intrinsics.checkNotNullExpressionValue(iterable2, "getArmorInventoryList(...)");
            Iterable iterable3 = CollectionsKt.reversed(iterable2);
            boolean $i$f$filter = false;
            void var6_7 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                ItemStack it = (ItemStack)element$iv$iv;
                boolean bl3 = false;
                if (!(!it.func_190926_b() && (Boolean)this.removeEmptySlotValue.get() != false)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable it = iterable3 = (List)destination$iv$iv;
            boolean bl4 = false;
            Iterable iterable4 = iterable = !((Collection)it).isEmpty() ? iterable3 : null;
            if (iterable != null) {
                void $this$onEachIndexed$iv;
                it = iterable;
                boolean $i$f$onEachIndexed = false;
                Collection $this$onEachIndexed_u24lambda_u2419$iv = destination$iv$iv = $this$onEachIndexed$iv;
                boolean bl5 = false;
                Collection $this$forEachIndexed$iv$iv = $this$onEachIndexed_u24lambda_u2419$iv;
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
                    boolean bl6 = false;
                    Number number = Intrinsics.areEqual(this.facingModeValue.get(), "Horizontal") ? index * 16 : 0;
                    Number number2 = Intrinsics.areEqual(this.facingModeValue.get(), "Vertical") ? index * 16 : 0;
                    Intrinsics.checkNotNull(itemStack);
                    RenderUtils.drawInGUIItem$default(number, number2, (ItemStack)itemStack, (EntityLivingBase)player, false, 0.0f, 48, null);
                }
                List it2 = (List)destination$iv$iv;
                boolean bl7 = false;
                elementBorder = new ElementBorder(0.0f, 0.0f, Intrinsics.areEqual(this.facingModeValue.get(), "Horizontal") ? (float)it2.size() * 16.0f : 16.0f, Intrinsics.areEqual(this.facingModeValue.get(), "Vertical") ? (float)it2.size() * 16.0f : 16.0f);
            } else {
                elementBorder = null;
            }
        } else {
            elementBorder = null;
        }
        return elementBorder;
    }
}

