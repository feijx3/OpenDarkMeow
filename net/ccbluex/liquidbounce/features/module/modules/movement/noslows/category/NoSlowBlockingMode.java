/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.category;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowMode;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/category/NoSlowBlockingMode;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowMode;", "<init>", "()V", "shouldApply", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "isApplyItem", "item", "Lnet/minecraft/item/ItemStack;", "isApplyNoSlow", "DarkMeow"})
public final class NoSlowBlockingMode
extends NoSlowMode {
    @NotNull
    public static final NoSlowBlockingMode INSTANCE = new NoSlowBlockingMode();

    private NoSlowBlockingMode() {
        super("Blocking");
    }

    public final boolean shouldApply(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        ItemStack itemStack = player.func_184614_ca();
        Intrinsics.checkNotNullExpressionValue(itemStack, "getHeldItemMainhand(...)");
        return this.isApplyItem(itemStack);
    }

    public final boolean isApplyItem(@NotNull ItemStack item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.func_77973_b() instanceof ItemSword || item.func_77973_b() instanceof ItemShield;
    }

    @Override
    public boolean isApplyNoSlow(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return player.func_184614_ca().func_77973_b() instanceof ItemSword || player.func_184614_ca().func_77973_b() instanceof ItemShield;
    }
}

