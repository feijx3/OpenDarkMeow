/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_7to1_21_6.rewriter;

import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_7to1_21_6.Protocol1_21_7To1_21_6;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.rewriter.BlockRewriter;

public final class BlockItemPacketRewriter1_21_7
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_6, ServerboundPacket1_21_6, Protocol1_21_7To1_21_6> {
    public BlockItemPacketRewriter1_21_7(Protocol1_21_7To1_21_6 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_6> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_6.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_6.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_6.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_6.LEVEL_EVENT, 2001);
        blockRewriter.registerLevelChunk1_19(ClientboundPackets1_21_6.LEVEL_CHUNK_WITH_LIGHT, ChunkType1_21_5::new);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_6.BLOCK_ENTITY_DATA);
        this.registerSetCursorItem(ClientboundPackets1_21_6.SET_CURSOR_ITEM);
        this.registerSetPlayerInventory(ClientboundPackets1_21_6.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_6.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_6.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_6.CONTAINER_SET_SLOT);
        this.registerAdvancements1_20_3(ClientboundPackets1_21_6.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21_6.SET_EQUIPMENT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_6.MERCHANT_OFFERS);
        this.registerContainerClick1_21_5(ServerboundPackets1_21_6.CONTAINER_CLICK);
        this.registerSetCreativeModeSlot1_21_5(ServerboundPackets1_21_6.SET_CREATIVE_MODE_SLOT);
        RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_6> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_6>(this.protocol);
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_6.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_6.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_6.PLACE_GHOST_RECIPE);
    }
}

