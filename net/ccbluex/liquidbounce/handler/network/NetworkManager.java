/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ServerData
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.network;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.handler.network.proxy.ProxyManager;
import net.ccbluex.liquidbounce.handler.network.server.ServerManager;
import net.ccbluex.liquidbounce.utils.ServerDataUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "proxyManager", "Lnet/ccbluex/liquidbounce/handler/network/proxy/ProxyManager;", "packetManager", "Lnet/ccbluex/liquidbounce/handler/network/packet/PacketManager;", "serverManager", "Lnet/ccbluex/liquidbounce/handler/network/server/ServerManager;", "latestServer", "Lnet/minecraft/client/multiplayer/ServerData;", "connectLatestServer", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNetworkManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkManager.kt\nnet/ccbluex/liquidbounce/handler/network/NetworkManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class NetworkManager
extends ManagerBase {
    @JvmField
    @NotNull
    public final ProxyManager proxyManager;
    @JvmField
    @NotNull
    public final PacketManager packetManager;
    @JvmField
    @NotNull
    public final ServerManager serverManager;
    @JvmField
    @Nullable
    public ServerData latestServer;

    public NetworkManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.proxyManager = new ProxyManager();
        this.packetManager = new PacketManager(this);
        this.serverManager = new ServerManager(this);
        EventManager.registerListener$default(system.getEventManager(), this.serverManager, false, false, 6, null);
    }

    public final boolean connectLatestServer() {
        boolean bl2;
        Minecraft minecraft;
        ServerData serverData = this.latestServer;
        if (serverData != null && (minecraft = ServerDataUtils.INSTANCE.connect(serverData, this.mc)) != null) {
            Minecraft it = minecraft;
            boolean bl3 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

