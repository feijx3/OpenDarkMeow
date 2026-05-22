/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.template;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.template.Protocol1_99To1_98;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;

final class BlockItemPacketRewriter1_99
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_21_4, Protocol1_99To1_98> {
    public BlockItemPacketRewriter1_99(Protocol1_99To1_98 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_2> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_2.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_2.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_2.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_2.LEVEL_EVENT, 2001);
        blockRewriter.registerLevelChunk1_19(ClientboundPackets1_21_2.LEVEL_CHUNK_WITH_LIGHT, ChunkType1_21_5::new);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_2.BLOCK_ENTITY_DATA);
        this.registerSetCursorItem(ClientboundPackets1_21_2.SET_CURSOR_ITEM);
        this.registerSetPlayerInventory(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_2.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_SLOT);
        this.registerAdvancements1_20_3(ClientboundPackets1_21_2.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21_2.SET_EQUIPMENT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_2.MERCHANT_OFFERS);
        this.registerContainerClick1_21_5(ServerboundPackets1_21_4.CONTAINER_CLICK);
        this.registerSetCreativeModeSlot1_21_5(ServerboundPackets1_21_4.SET_CREATIVE_MODE_SLOT);
        RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_2> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_2>(this.protocol);
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_2.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_2.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_2.PLACE_GHOST_RECIPE);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection connection, Item item, StructuredDataContainer container) {
        super.handleItemDataComponentsToClient(connection, item, container);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection connection, Item item, StructuredDataContainer container) {
        super.handleItemDataComponentsToServer(connection, item, container);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer container, CompoundTag customData) {
        super.restoreBackupData(item, container, customData);
    }

    @Override
    protected void backupInconvertibleData(UserConnection connection, Item item, StructuredDataContainer dataContainer, CompoundTag backupTag) {
        super.backupInconvertibleData(connection, item, dataContainer, backupTag);
    }
}

