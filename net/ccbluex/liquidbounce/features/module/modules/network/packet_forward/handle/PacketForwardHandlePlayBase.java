/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.SimpleChannelInboundHandler
 *  io.netty.util.concurrent.GenericFutureListener
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.ChunkProviderClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.Packet
 *  net.minecraft.network.login.client.CPacketLoginStart
 *  net.minecraft.network.login.server.SPacketLoginSuccess
 *  net.minecraft.network.play.server.SPacketChunkData
 *  net.minecraft.network.play.server.SPacketDisconnect
 *  net.minecraft.network.play.server.SPacketEntityAttach
 *  net.minecraft.network.play.server.SPacketHeldItemChange
 *  net.minecraft.network.play.server.SPacketJoinGame
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.world.GameType
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.IChunkProvider
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.network.PacketForward;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardChannel;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.utils.PacketForwardEntityUtils;
import net.ccbluex.liquidbounce.injection.extend.world.ExtendChunkProviderClient;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.Packet;
import net.minecraft.network.login.client.CPacketLoginStart;
import net.minecraft.network.login.server.SPacketLoginSuccess;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketEntityAttach;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/handle/PacketForwardHandlePlayBase;", "Lio/netty/channel/SimpleChannelInboundHandler;", "Lnet/minecraft/network/Packet;", "module", "Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "client", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "getClient", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "channelRead0", "", "ctx", "Lio/netty/channel/ChannelHandlerContext;", "packet", "channelInactive", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketForwardHandlePlayBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketForwardHandlePlayBase.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/handle/PacketForwardHandlePlayBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n1869#2,2:74\n1869#2,2:76\n1869#2:78\n1870#2:80\n1#3:79\n*S KotlinDebug\n*F\n+ 1 PacketForwardHandlePlayBase.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/handle/PacketForwardHandlePlayBase\n*L\n35#1:74,2\n38#1:76,2\n43#1:78\n43#1:80\n*E\n"})
public final class PacketForwardHandlePlayBase
extends SimpleChannelInboundHandler<Packet<?>> {
    @NotNull
    private final PacketForward module;
    @NotNull
    private final PacketForwardChannel client;

    public PacketForwardHandlePlayBase(@NotNull PacketForward module, @NotNull PacketForwardChannel client) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(client, "client");
        this.module = module;
        this.client = client;
    }

    @NotNull
    public final PacketForward getModule() {
        return this.module;
    }

    @NotNull
    public final PacketForwardChannel getClient() {
        return this.client;
    }

    protected void channelRead0(@NotNull ChannelHandlerContext ctx, @NotNull Packet<?> packet) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet instanceof CPacketLoginStart) {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                Entity entity;
                EntityPlayerSP entityPlayerSP2;
                EntityPlayerSP player = entityPlayerSP2 = entityPlayerSP;
                boolean bl2 = false;
                this.client.sendPacket((Packet)new SPacketLoginSuccess(player.func_146103_bH()), new GenericFutureListener[0]);
                this.client.setConnectionState(EnumConnectionState.PLAY);
                this.client.sendPacket((Packet)new SPacketJoinGame(player.func_145782_y(), GameType.SURVIVAL, false, 0, player.field_70170_p.func_175659_aa(), 20, player.field_70170_p.func_175624_G(), false), new GenericFutureListener[0]);
                this.client.sendPacket((Packet)new SPacketHeldItemChange(player.field_71071_by.field_70461_c), new GenericFutureListener[0]);
                this.client.sendPacket((Packet)new SPacketTimeUpdate(player.field_70170_p.func_82737_E(), player.field_70170_p.func_72820_D(), false), new GenericFutureListener[0]);
                this.client.sendPacket((Packet)new SPacketPlayerPosLook(player.field_70165_t, player.field_70163_u, player.field_70161_v, player.field_70177_z, player.field_70125_A, SetsKt.emptySet(), -1), new GenericFutureListener[0]);
                IChunkProvider iChunkProvider = player.field_70170_p.func_72863_F();
                Intrinsics.checkNotNull(iChunkProvider, "null cannot be cast to non-null type net.minecraft.client.multiplayer.ChunkProviderClient");
                Collection collection = ExtendChunkProviderClient.INSTANCE.getLoadedChunks((ChunkProviderClient)iChunkProvider).values();
                Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
                Iterable $this$forEach$iv = collection;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Chunk chunk = (Chunk)element$iv;
                    boolean bl3 = false;
                    this.client.sendPacket((Packet)new SPacketChunkData(chunk, 65535), new GenericFutureListener[0]);
                }
                List list = player.field_70170_p.field_72996_f;
                Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
                $this$forEach$iv = list;
                $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Object $this$channelRead0_u24lambda_u249_u24lambda_u242_u24lambda_u241;
                    entity = (Entity)element$iv;
                    boolean bl4 = false;
                    PacketForwardHandlePlayBase packetForwardHandlePlayBase = this;
                    try {
                        $this$channelRead0_u24lambda_u249_u24lambda_u242_u24lambda_u241 = packetForwardHandlePlayBase;
                        boolean bl5 = false;
                        PacketForwardChannel packetForwardChannel = $this$channelRead0_u24lambda_u249_u24lambda_u242_u24lambda_u241.client;
                        Intrinsics.checkNotNull(entity);
                        packetForwardChannel.sendPacket(PacketForwardEntityUtils.INSTANCE.createSpawnPacket(entity), new GenericFutureListener[0]);
                        $this$channelRead0_u24lambda_u249_u24lambda_u242_u24lambda_u241 = Result.constructor-impl(Unit.INSTANCE);
                    }
                    catch (Throwable throwable) {
                        $this$channelRead0_u24lambda_u249_u24lambda_u242_u24lambda_u241 = Result.constructor-impl(ResultKt.createFailure(throwable));
                    }
                }
                List list2 = player.field_70170_p.field_72996_f;
                Intrinsics.checkNotNullExpressionValue(list2, "loadedEntityList");
                $this$forEach$iv = list2;
                $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Entity entity2;
                    entity = (Entity)element$iv;
                    boolean bl6 = false;
                    Entity it = entity;
                    boolean bl7 = false;
                    Object object = it instanceof EntityLiving ? (EntityLiving)it : null;
                    if (object != null) {
                        Entity it2 = it = object;
                        boolean bl8 = false;
                        Object object2 = entity2 = it2.func_110166_bE() != null ? it : null;
                        if (entity2 != null) {
                            Entity entity3 = it = entity2;
                            boolean bl9 = false;
                            this.client.sendPacket((Packet)new SPacketEntityAttach(entity3, entity3.func_110166_bE()), new GenericFutureListener[0]);
                        }
                    }
                    it = entity2 = entity;
                    boolean bl10 = false;
                    object = it.func_184188_bt() != null ? entity2 : null;
                    if (object == null) continue;
                    Entity entity4 = entity2 = object;
                    boolean bl11 = false;
                    this.client.sendPacket((Packet)new SPacketSetPassengers(entity4), new GenericFutureListener[0]);
                }
                this.module.getClients().add(this.client);
            } else {
                PacketForwardHandlePlayBase $this$channelRead0_u24lambda_u2410 = this;
                boolean bl12 = false;
                $this$channelRead0_u24lambda_u2410.client.sendPacket((Packet)new SPacketLoginSuccess(((CPacketLoginStart)packet).func_149304_c()), new GenericFutureListener[0]);
                $this$channelRead0_u24lambda_u2410.client.setConnectionState(EnumConnectionState.PLAY);
                $this$channelRead0_u24lambda_u2410.client.sendPacket((Packet)new SPacketDisconnect((ITextComponent)new TextComponentString("\u8bf7\u5148\u5728\u53d1\u9001\u7aef\u8fde\u63a5\u4efb\u610f\u670d\u52a1\u5668")), new GenericFutureListener[0]);
            }
        }
        ctx.fireChannelRead(packet);
    }

    public void channelInactive(@NotNull ChannelHandlerContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.module.getClients().remove(this.client);
    }
}

