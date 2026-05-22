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
 */
package net.darkmeow.darkmeow.event.listenable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2={"Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "mc", "Lnet/minecraft/client/Minecraft;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "playerController", "Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "connection", "Lnet/minecraft/client/network/NetHandlerPlayClient;", "renderViewEntity", "Lnet/minecraft/entity/Entity;", "<init>", "(Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/PlayerControllerMP;Lnet/minecraft/client/network/NetHandlerPlayClient;Lnet/minecraft/entity/Entity;)V", "getWorld", "()Lnet/minecraft/client/multiplayer/WorldClient;", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "getPlayerController", "()Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "getConnection", "()Lnet/minecraft/client/network/NetHandlerPlayClient;", "getRenderViewEntity", "()Lnet/minecraft/entity/Entity;", "DarkMeow"})
public final class SafeListenerBase
extends ListenerBase {
    @NotNull
    private final WorldClient world;
    @NotNull
    private final EntityPlayerSP player;
    @NotNull
    private final PlayerControllerMP playerController;
    @NotNull
    private final NetHandlerPlayClient connection;
    @NotNull
    private final Entity renderViewEntity;

    public SafeListenerBase(@NotNull Minecraft mc, @NotNull WorldClient world, @NotNull EntityPlayerSP player, @NotNull PlayerControllerMP playerController, @NotNull NetHandlerPlayClient connection, @NotNull Entity renderViewEntity) {
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(world, "world");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(playerController, "playerController");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(renderViewEntity, "renderViewEntity");
        super(mc, world, player, playerController, connection, null, 32, null);
        this.world = world;
        this.player = player;
        this.playerController = playerController;
        this.connection = connection;
        this.renderViewEntity = renderViewEntity;
    }

    @Override
    @NotNull
    public WorldClient getWorld() {
        return this.world;
    }

    @Override
    @NotNull
    public EntityPlayerSP getPlayer() {
        return this.player;
    }

    @Override
    @NotNull
    public PlayerControllerMP getPlayerController() {
        return this.playerController;
    }

    @Override
    @NotNull
    public NetHandlerPlayClient getConnection() {
        return this.connection;
    }

    @Override
    @NotNull
    public Entity getRenderViewEntity() {
        return this.renderViewEntity;
    }
}

