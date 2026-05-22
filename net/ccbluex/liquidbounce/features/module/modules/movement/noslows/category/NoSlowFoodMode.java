/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.category;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowMode;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/category/NoSlowFoodMode;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowMode;", "<init>", "()V", "shouldApply", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "isApplyNoSlow", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowFoodMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowFoodMode.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/category/NoSlowFoodMode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n1#2:19\n*E\n"})
public final class NoSlowFoodMode
extends NoSlowMode {
    @NotNull
    public static final NoSlowFoodMode INSTANCE = new NoSlowFoodMode();

    private NoSlowFoodMode() {
        super("Food");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean shouldApply(@NotNull EntityPlayerSP player) {
        EntityPlayerSP entityPlayerSP;
        Intrinsics.checkNotNullParameter(player, "player");
        EntityPlayerSP it = entityPlayerSP = player;
        boolean bl2 = false;
        if (!it.func_184587_cr()) return false;
        EntityPlayerSP entityPlayerSP2 = entityPlayerSP;
        EntityPlayerSP entityPlayerSP3 = entityPlayerSP2;
        if (entityPlayerSP3 == null) return false;
        EntityPlayerSP it2 = entityPlayerSP3;
        boolean bl3 = false;
        entityPlayerSP = player.func_184586_b(it2.func_184600_cs());
        if (entityPlayerSP == null) return false;
        EntityPlayerSP it3 = entityPlayerSP;
        boolean bl4 = false;
        EnumAction enumAction = it3.func_77973_b().func_77661_b((ItemStack)it3);
        if (enumAction == null) return false;
        EnumAction it4 = enumAction;
        boolean bl5 = false;
        if (it4 == EnumAction.EAT) return true;
        if (it4 != EnumAction.DRINK) return false;
        return true;
    }

    @Override
    public boolean isApplyNoSlow(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return this.shouldApply(player);
    }
}

