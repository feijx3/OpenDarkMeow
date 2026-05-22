/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.event.listenable;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "", "mc", "Lnet/minecraft/client/Minecraft;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "playerController", "Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "connection", "Lnet/minecraft/client/network/NetHandlerPlayClient;", "renderViewEntity", "Lnet/minecraft/entity/Entity;", "<init>", "(Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/PlayerControllerMP;Lnet/minecraft/client/network/NetHandlerPlayClient;Lnet/minecraft/entity/Entity;)V", "getMc", "()Lnet/minecraft/client/Minecraft;", "getWorld", "()Lnet/minecraft/client/multiplayer/WorldClient;", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "getPlayerController", "()Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "getConnection", "()Lnet/minecraft/client/network/NetHandlerPlayClient;", "getRenderViewEntity", "()Lnet/minecraft/entity/Entity;", "DarkMeow"})
public class ListenerBase {
    @NotNull
    private final Minecraft mc;
    @Nullable
    private final WorldClient world;
    @Nullable
    private final EntityPlayerSP player;
    @Nullable
    private final PlayerControllerMP playerController;
    @Nullable
    private final NetHandlerPlayClient connection;
    @Nullable
    private final Entity renderViewEntity;

    public ListenerBase(@NotNull Minecraft mc, @Nullable WorldClient world, @Nullable EntityPlayerSP player, @Nullable PlayerControllerMP playerController, @Nullable NetHandlerPlayClient connection, @Nullable Entity renderViewEntity) {
        Intrinsics.checkNotNullParameter(mc, "mc");
        this.mc = mc;
        this.world = world;
        this.player = player;
        this.playerController = playerController;
        this.connection = connection;
        this.renderViewEntity = renderViewEntity;
    }

    public /* synthetic */ ListenerBase(Minecraft minecraft, WorldClient worldClient, EntityPlayerSP entityPlayerSP, PlayerControllerMP playerControllerMP, NetHandlerPlayClient netHandlerPlayClient, Entity entity, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            worldClient = null;
        }
        if ((n2 & 4) != 0) {
            entityPlayerSP = null;
        }
        if ((n2 & 8) != 0) {
            playerControllerMP = null;
        }
        if ((n2 & 0x10) != 0) {
            netHandlerPlayClient = null;
        }
        if ((n2 & 0x20) != 0) {
            entity = null;
        }
        this(minecraft, worldClient, entityPlayerSP, playerControllerMP, netHandlerPlayClient, entity);
    }

    @NotNull
    public final Minecraft getMc() {
        return this.mc;
    }

    @Nullable
    public WorldClient getWorld() {
        return this.world;
    }

    @Nullable
    public EntityPlayerSP getPlayer() {
        return this.player;
    }

    @Nullable
    public PlayerControllerMP getPlayerController() {
        return this.playerController;
    }

    @Nullable
    public NetHandlerPlayClient getConnection() {
        return this.connection;
    }

    @Nullable
    public Entity getRenderViewEntity() {
        return this.renderViewEntity;
    }
}

