/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManagerExtend;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendCancelRelease;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "onDisable", "", "DarkMeow"})
public final class GAppleExtendCancelRelease
extends GAppleExtend {
    @JvmField
    @NotNull
    public final ListValue modeValue;

    public GAppleExtendCancelRelease() {
        super("CancelRelease", true);
        String[] stringArray = new String[]{"NoTravel", "LessTravel", "FullTravel"};
        this.modeValue = new ListValue("Mode", stringArray, "NoTravel");
    }

    @Override
    public void onDisable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        int n2 = MovementStuckManagerExtend.INSTANCE.getSafeReleaseCount(DarkMeow.INSTANCE.getMovementManager().getStuckManager());
        for (int i2 = 0; i2 < n2; ++i2) {
            int it = i2;
            boolean bl2 = false;
            switch ((String)this.modeValue.get()) {
                case "NoTravel": {
                    if (ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(player) >= 19) {
                        return;
                    }
                    player.field_71174_a.func_147297_a((Packet)new CPacketPlayer(player.field_70122_E));
                    int n3 = ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(player);
                    ExtendEntityPlayerSP.INSTANCE.setPositionUpdateTicks(player, n3 + 1);
                    break;
                }
                case "LessTravel": {
                    if (ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(player) >= 19) {
                        MovementStuckManagerExtend.travelOnStuck$default(MovementStuckManagerExtend.INSTANCE, player, 0.0f, 0.0f, 0.0f, 7, null);
                        MovementStuckManagerExtend.INSTANCE.syncPositionToServerOnStuck(player);
                        break;
                    }
                    player.field_71174_a.func_147297_a((Packet)new CPacketPlayer(player.field_70122_E));
                    int n3 = ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(player);
                    ExtendEntityPlayerSP.INSTANCE.setPositionUpdateTicks(player, n3 + 1);
                    break;
                }
                case "FullTravel": {
                    MovementStuckManagerExtend.travelOnStuck$default(MovementStuckManagerExtend.INSTANCE, player, 0.0f, 0.0f, 0.0f, 7, null);
                    MovementStuckManagerExtend.INSTANCE.syncPositionToServerOnStuck(player);
                }
            }
        }
    }
}

