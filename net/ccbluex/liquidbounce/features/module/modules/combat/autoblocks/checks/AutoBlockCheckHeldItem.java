/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemSword
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.checks;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.AutoBlockCheck;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSword;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/checks/AutoBlockCheckHeldItem;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockCheck;", "<init>", "()V", "swordWoodValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "swordStoneValue", "swordIronValue", "swordDiamondValue", "swordGoldValue", "shieldMainHandValue", "shieldOffHandValue", "canBlock", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "checkItemSword", "checkItemShield", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoBlockCheckHeldItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBlockCheckHeldItem.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/checks/AutoBlockCheckHeldItem\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,48:1\n12637#2,2:49\n*S KotlinDebug\n*F\n+ 1 AutoBlockCheckHeldItem.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/checks/AutoBlockCheckHeldItem\n*L\n46#1:49,2\n*E\n"})
public final class AutoBlockCheckHeldItem
extends AutoBlockCheck {
    @NotNull
    private final BoolValue swordWoodValue = new BoolValue(this.getValuePrefix() + "SwordWood", true);
    @NotNull
    private final BoolValue swordStoneValue = new BoolValue(this.getValuePrefix() + "SwordStone", true);
    @NotNull
    private final BoolValue swordIronValue = new BoolValue(this.getValuePrefix() + "SwordIron", true);
    @NotNull
    private final BoolValue swordDiamondValue = new BoolValue(this.getValuePrefix() + "SwordDiamond", true);
    @NotNull
    private final BoolValue swordGoldValue = new BoolValue(this.getValuePrefix() + "SwordGold", true);
    @NotNull
    private final BoolValue shieldMainHandValue = new BoolValue(this.getValuePrefix() + "ShieldMainHand", true);
    @NotNull
    private final BoolValue shieldOffHandValue = new BoolValue(this.getValuePrefix() + "ShieldOffHand", true);

    public AutoBlockCheckHeldItem() {
        super("HeldItem", true);
    }

    @Override
    public boolean canBlock(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return this.checkItemSword(player) || this.checkItemShield(player);
    }

    private final boolean checkItemSword(EntityPlayerSP player) {
        String string;
        Item item = player.func_184614_ca().func_77973_b();
        return item instanceof ItemSword ? (Intrinsics.areEqual(string = ((ItemSword)item).func_150932_j(), Item.ToolMaterial.WOOD.toString()) ? (Boolean)this.swordWoodValue.get() : (Intrinsics.areEqual(string, Item.ToolMaterial.STONE.toString()) ? (Boolean)this.swordStoneValue.get() : (Intrinsics.areEqual(string, Item.ToolMaterial.IRON.toString()) ? (Boolean)this.swordIronValue.get() : (Intrinsics.areEqual(string, Item.ToolMaterial.DIAMOND.toString()) ? (Boolean)this.swordDiamondValue.get() : (Intrinsics.areEqual(string, Item.ToolMaterial.GOLD.toString()) ? (Boolean)this.swordGoldValue.get() : false))))) : false;
    }

    private final boolean checkItemShield(EntityPlayerSP player) {
        boolean bl2;
        block1: {
            Boolean[] booleanArray = new Boolean[]{player.func_184614_ca().func_77973_b() instanceof ItemShield && (Boolean)this.shieldMainHandValue.get() != false, player.func_184592_cb().func_77973_b() instanceof ItemShield && (Boolean)this.shieldOffHandValue.get() != false};
            Boolean[] $this$any$iv = booleanArray;
            boolean $i$f$any = false;
            for (Boolean element$iv : $this$any$iv) {
                boolean it = element$iv;
                boolean bl3 = false;
                if (!it) continue;
                bl2 = true;
                break block1;
            }
            bl2 = false;
        }
        return bl2;
    }
}

