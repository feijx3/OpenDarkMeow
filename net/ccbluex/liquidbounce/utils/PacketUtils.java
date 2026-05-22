/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketClientSettings
 *  net.minecraft.network.play.client.CPacketClientStatus
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.client.CPacketConfirmTeleport
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 *  net.minecraft.network.play.client.CPacketCreativeInventoryAction
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.client.CPacketEnchantItem
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketInput
 *  net.minecraft.network.play.client.CPacketKeepAlive
 *  net.minecraft.network.play.client.CPacketPlaceRecipe
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerAbilities
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketRecipeInfo
 *  net.minecraft.network.play.client.CPacketResourcePackStatus
 *  net.minecraft.network.play.client.CPacketSeenAdvancements
 *  net.minecraft.network.play.client.CPacketSpectate
 *  net.minecraft.network.play.client.CPacketSteerBoat
 *  net.minecraft.network.play.client.CPacketTabComplete
 *  net.minecraft.network.play.client.CPacketUpdateSign
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.network.play.server.SPacketAdvancementInfo
 *  net.minecraft.network.play.server.SPacketAnimation
 *  net.minecraft.network.play.server.SPacketBlockAction
 *  net.minecraft.network.play.server.SPacketBlockBreakAnim
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.network.play.server.SPacketCamera
 *  net.minecraft.network.play.server.SPacketChangeGameState
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.network.play.server.SPacketChunkData
 *  net.minecraft.network.play.server.SPacketCloseWindow
 *  net.minecraft.network.play.server.SPacketCollectItem
 *  net.minecraft.network.play.server.SPacketCombatEvent
 *  net.minecraft.network.play.server.SPacketConfirmTransaction
 *  net.minecraft.network.play.server.SPacketCooldown
 *  net.minecraft.network.play.server.SPacketCustomPayload
 *  net.minecraft.network.play.server.SPacketCustomSound
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  net.minecraft.network.play.server.SPacketDisconnect
 *  net.minecraft.network.play.server.SPacketDisplayObjective
 *  net.minecraft.network.play.server.SPacketEffect
 *  net.minecraft.network.play.server.SPacketEntity
 *  net.minecraft.network.play.server.SPacketEntity$S15PacketEntityRelMove
 *  net.minecraft.network.play.server.SPacketEntity$S16PacketEntityLook
 *  net.minecraft.network.play.server.SPacketEntity$S17PacketEntityLookMove
 *  net.minecraft.network.play.server.SPacketEntityAttach
 *  net.minecraft.network.play.server.SPacketEntityEffect
 *  net.minecraft.network.play.server.SPacketEntityEquipment
 *  net.minecraft.network.play.server.SPacketEntityHeadLook
 *  net.minecraft.network.play.server.SPacketEntityMetadata
 *  net.minecraft.network.play.server.SPacketEntityProperties
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.network.play.server.SPacketEntityTeleport
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraft.network.play.server.SPacketHeldItemChange
 *  net.minecraft.network.play.server.SPacketJoinGame
 *  net.minecraft.network.play.server.SPacketKeepAlive
 *  net.minecraft.network.play.server.SPacketMaps
 *  net.minecraft.network.play.server.SPacketMoveVehicle
 *  net.minecraft.network.play.server.SPacketMultiBlockChange
 *  net.minecraft.network.play.server.SPacketOpenWindow
 *  net.minecraft.network.play.server.SPacketParticles
 *  net.minecraft.network.play.server.SPacketPlaceGhostRecipe
 *  net.minecraft.network.play.server.SPacketPlayerAbilities
 *  net.minecraft.network.play.server.SPacketPlayerListHeaderFooter
 *  net.minecraft.network.play.server.SPacketPlayerListItem
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketRecipeBook
 *  net.minecraft.network.play.server.SPacketRemoveEntityEffect
 *  net.minecraft.network.play.server.SPacketResourcePackSend
 *  net.minecraft.network.play.server.SPacketRespawn
 *  net.minecraft.network.play.server.SPacketScoreboardObjective
 *  net.minecraft.network.play.server.SPacketSelectAdvancementsTab
 *  net.minecraft.network.play.server.SPacketServerDifficulty
 *  net.minecraft.network.play.server.SPacketSetExperience
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraft.network.play.server.SPacketSetSlot
 *  net.minecraft.network.play.server.SPacketSignEditorOpen
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.network.play.server.SPacketSpawnExperienceOrb
 *  net.minecraft.network.play.server.SPacketSpawnGlobalEntity
 *  net.minecraft.network.play.server.SPacketSpawnMob
 *  net.minecraft.network.play.server.SPacketSpawnObject
 *  net.minecraft.network.play.server.SPacketSpawnPainting
 *  net.minecraft.network.play.server.SPacketSpawnPlayer
 *  net.minecraft.network.play.server.SPacketSpawnPosition
 *  net.minecraft.network.play.server.SPacketStatistics
 *  net.minecraft.network.play.server.SPacketTabComplete
 *  net.minecraft.network.play.server.SPacketTeams
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.network.play.server.SPacketTitle
 *  net.minecraft.network.play.server.SPacketUnloadChunk
 *  net.minecraft.network.play.server.SPacketUpdateBossInfo
 *  net.minecraft.network.play.server.SPacketUpdateHealth
 *  net.minecraft.network.play.server.SPacketUpdateScore
 *  net.minecraft.network.play.server.SPacketUpdateTileEntity
 *  net.minecraft.network.play.server.SPacketUseBed
 *  net.minecraft.network.play.server.SPacketWindowItems
 *  net.minecraft.network.play.server.SPacketWindowProperty
 *  net.minecraft.network.play.server.SPacketWorldBorder
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketClientSettings;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketEnchantItem;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketPlaceRecipe;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketRecipeInfo;
import net.minecraft.network.play.client.CPacketResourcePackStatus;
import net.minecraft.network.play.client.CPacketSeenAdvancements;
import net.minecraft.network.play.client.CPacketSpectate;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.network.play.client.CPacketUpdateSign;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketCamera;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.network.play.server.SPacketCollectItem;
import net.minecraft.network.play.server.SPacketCombatEvent;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import net.minecraft.network.play.server.SPacketCooldown;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketDisplayObjective;
import net.minecraft.network.play.server.SPacketEffect;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketEntityAttach;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.network.play.server.SPacketEntityEquipment;
import net.minecraft.network.play.server.SPacketEntityHeadLook;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraft.network.play.server.SPacketEntityProperties;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.network.play.server.SPacketKeepAlive;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.network.play.server.SPacketPlaceGhostRecipe;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketPlayerListHeaderFooter;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketRecipeBook;
import net.minecraft.network.play.server.SPacketRemoveEntityEffect;
import net.minecraft.network.play.server.SPacketResourcePackSend;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.network.play.server.SPacketScoreboardObjective;
import net.minecraft.network.play.server.SPacketSelectAdvancementsTab;
import net.minecraft.network.play.server.SPacketServerDifficulty;
import net.minecraft.network.play.server.SPacketSetExperience;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketSignEditorOpen;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.network.play.server.SPacketSpawnPosition;
import net.minecraft.network.play.server.SPacketStatistics;
import net.minecraft.network.play.server.SPacketTabComplete;
import net.minecraft.network.play.server.SPacketTeams;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.network.play.server.SPacketUnloadChunk;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.network.play.server.SPacketUpdateHealth;
import net.minecraft.network.play.server.SPacketUpdateScore;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraft.network.play.server.SPacketWindowProperty;
import net.minecraft.network.play.server.SPacketWorldBorder;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/utils/PacketUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "CLIENT_PACKETS", "", "Ljava/lang/Class;", "Lnet/minecraft/network/Packet;", "getCLIENT_PACKETS", "()Ljava/util/List;", "SERVER_PACKETS", "getSERVER_PACKETS", "DarkMeow"})
public final class PacketUtils
extends MinecraftInstance {
    @NotNull
    public static final PacketUtils INSTANCE = new PacketUtils();
    @NotNull
    private static final List<Class<? extends Packet<?>>> CLIENT_PACKETS = new ArrayList();
    @NotNull
    private static final List<Class<? extends Packet<?>>> SERVER_PACKETS = new ArrayList();

    private PacketUtils() {
    }

    @NotNull
    public final List<Class<? extends Packet<?>>> getCLIENT_PACKETS() {
        return CLIENT_PACKETS;
    }

    @NotNull
    public final List<Class<? extends Packet<?>>> getSERVER_PACKETS() {
        return SERVER_PACKETS;
    }

    static {
        Class[] classArray = new Class[]{CPacketAnimation.class, CPacketChatMessage.class, CPacketClickWindow.class, CPacketClientSettings.class, CPacketClientStatus.class, CPacketCloseWindow.class, CPacketConfirmTeleport.class, CPacketConfirmTransaction.class, CPacketCreativeInventoryAction.class, CPacketCustomPayload.class, CPacketEnchantItem.class, CPacketEntityAction.class, CPacketHeldItemChange.class, CPacketInput.class, CPacketKeepAlive.class, CPacketPlaceRecipe.class, CPacketPlayer.class, CPacketPlayer.Position.class, CPacketPlayer.PositionRotation.class, CPacketPlayer.Rotation.class, CPacketPlayerAbilities.class, CPacketPlayerDigging.class, CPacketPlayerTryUseItem.class, CPacketPlayerTryUseItemOnBlock.class, CPacketRecipeInfo.class, CPacketResourcePackStatus.class, CPacketSeenAdvancements.class, CPacketSpectate.class, CPacketSteerBoat.class, CPacketTabComplete.class, CPacketUpdateSign.class, CPacketUseEntity.class, CPacketVehicleMove.class};
        CollectionsKt.addAll((Collection)CLIENT_PACKETS, classArray);
        classArray = new Class[]{SPacketAdvancementInfo.class, SPacketAnimation.class, SPacketBlockAction.class, SPacketBlockBreakAnim.class, SPacketBlockChange.class, SPacketCamera.class, SPacketChangeGameState.class, SPacketChat.class, SPacketChunkData.class, SPacketCloseWindow.class, SPacketCollectItem.class, SPacketCombatEvent.class, SPacketConfirmTransaction.class, SPacketCooldown.class, SPacketCustomPayload.class, SPacketCustomSound.class, SPacketDestroyEntities.class, SPacketDisconnect.class, SPacketDisplayObjective.class, SPacketEffect.class, SPacketEntity.class, SPacketEntity.S15PacketEntityRelMove.class, SPacketEntity.S16PacketEntityLook.class, SPacketEntity.S17PacketEntityLookMove.class, SPacketEntityAttach.class, SPacketEntityEffect.class, SPacketEntityEquipment.class, SPacketEntityHeadLook.class, SPacketEntityMetadata.class, SPacketEntityProperties.class, SPacketEntityStatus.class, SPacketEntityTeleport.class, SPacketEntityVelocity.class, SPacketExplosion.class, SPacketHeldItemChange.class, SPacketJoinGame.class, SPacketKeepAlive.class, SPacketMaps.class, SPacketMoveVehicle.class, SPacketMultiBlockChange.class, SPacketOpenWindow.class, SPacketParticles.class, SPacketPlaceGhostRecipe.class, SPacketPlayerAbilities.class, SPacketPlayerListHeaderFooter.class, SPacketPlayerListItem.class, SPacketPlayerPosLook.class, SPacketRecipeBook.class, SPacketRemoveEntityEffect.class, SPacketResourcePackSend.class, SPacketRespawn.class, SPacketScoreboardObjective.class, SPacketSelectAdvancementsTab.class, SPacketServerDifficulty.class, SPacketSetExperience.class, SPacketSetPassengers.class, SPacketSetSlot.class, SPacketSignEditorOpen.class, SPacketSoundEffect.class, SPacketSpawnExperienceOrb.class, SPacketSpawnGlobalEntity.class, SPacketSpawnMob.class, SPacketSpawnObject.class, SPacketSpawnPainting.class, SPacketSpawnPlayer.class, SPacketSpawnPosition.class, SPacketStatistics.class, SPacketTabComplete.class, SPacketTeams.class, SPacketTimeUpdate.class, SPacketTitle.class, SPacketUnloadChunk.class, SPacketUpdateBossInfo.class, SPacketUpdateHealth.class, SPacketUpdateScore.class, SPacketUpdateTileEntity.class, SPacketUseBed.class, SPacketWindowItems.class, SPacketWindowProperty.class, SPacketWorldBorder.class};
        CollectionsKt.addAll((Collection)SERVER_PACKETS, classArray);
    }
}

