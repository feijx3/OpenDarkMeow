/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerExtend;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.enums.InvManagerEnumPreExecuteAction;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/extend/InvManagerExtendNoSpectator;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerExtend;", "<init>", "()V", "preExecute", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/enums/InvManagerEnumPreExecuteAction;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
public final class InvManagerExtendNoSpectator
extends InvManagerExtend {
    public InvManagerExtendNoSpectator() {
        super("NoSpectator", false);
    }

    @Override
    @Nullable
    public InvManagerEnumPreExecuteAction preExecute(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (player.func_175149_v()) {
            return InvManagerEnumPreExecuteAction.CANCEL;
        }
        return null;
    }
}

