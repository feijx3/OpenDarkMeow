/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketJoinGame
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.network.server;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.handler.network.NetworkManager;
import net.darkmeow.darkmeow.utils.kotlin.BoundedArrayDeque;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/handler/network/server/ServerManager;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "manager", "Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;", "tpsPacketSystemTime", "", "tpsLogs", "Lnet/darkmeow/darkmeow/utils/kotlin/BoundedArrayDeque;", "", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "getCurrentTps", "", "handleEvents", "", "DarkMeow"})
public final class ServerManager
implements Listenable {
    @NotNull
    private final NetworkManager manager;
    private long tpsPacketSystemTime;
    @NotNull
    private final BoundedArrayDeque<Float> tpsLogs;

    public ServerManager(@NotNull NetworkManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.tpsLogs = new BoundedArrayDeque(20);
    }

    @NotNull
    public final NetworkManager getManager() {
        return this.manager;
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketJoinGame) {
            this.tpsLogs.clear();
        } else if (packet instanceof SPacketTimeUpdate) {
            long l2;
            long now = l2 = System.currentTimeMillis();
            boolean bl2 = false;
            this.tpsLogs.add(Float.valueOf(Math.min(20.0f / ((float)(now - this.tpsPacketSystemTime) / 1000.0f), 20.0f)));
            this.tpsPacketSystemTime = now;
        }
    }

    public final double getCurrentTps() {
        return Math.min(CollectionsKt.averageOfFloat((Iterable<Float>)this.tpsLogs) + 0.1, 20.0);
    }

    @Override
    public boolean handleEvents() {
        return true;
    }
}

