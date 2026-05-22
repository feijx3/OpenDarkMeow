/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketSpawnGlobalEntity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="LightningDetect", description="\u96f7\u58f0\u68c0\u6d4b", category=ModuleCategory.EXPLOIT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/LightningDetect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class LightningDetect
extends Module {
    @NotNull
    public static final LightningDetect INSTANCE = new LightningDetect();

    private LightningDetect() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketSpawnGlobalEntity && ((SPacketSpawnGlobalEntity)packet).func_149053_g() != 1) {
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u96f7\u58f0(" + (int)((SPacketSpawnGlobalEntity)packet).func_186888_b() + ',' + (int)((SPacketSpawnGlobalEntity)packet).func_186889_c() + ',' + (int)((SPacketSpawnGlobalEntity)packet).func_186887_d() + ')');
        }
    }
}

