/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.EnumAction
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.category;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowMode;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.EnumAction;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/category/NoSlowBowMode;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowMode;", "<init>", "()V", "isApplyNoSlow", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
public final class NoSlowBowMode
extends NoSlowMode {
    @NotNull
    public static final NoSlowBowMode INSTANCE = new NoSlowBowMode();

    private NoSlowBowMode() {
        super("Bow");
    }

    @Override
    public boolean isApplyNoSlow(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        EnumAction it = player.func_184614_ca().func_77973_b().func_77661_b(player.func_184614_ca());
        boolean bl2 = false;
        return it == EnumAction.BOW;
    }
}

