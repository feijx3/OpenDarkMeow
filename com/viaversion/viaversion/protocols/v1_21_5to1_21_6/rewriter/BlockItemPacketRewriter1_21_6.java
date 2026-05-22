/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;

public final class BlockItemPacketRewriter1_21_6
extends StructuredItemRewriter<ClientboundPacket1_21_5, ServerboundPacket1_21_6, Protocol1_21_5To1_21_6> {
    public BlockItemPacketRewriter1_21_6(Protocol1_21_5To1_21_6 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_5> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_5.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_5.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_5.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_5.LEVEL_EVENT, 2001);
        blockRewriter.registerLevelChunk1_19(ClientboundPackets1_21_5.LEVEL_CHUNK_WITH_LIGHT, ChunkType1_21_5::new);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_5.BLOCK_ENTITY_DATA);
        ((Protocol1_21_5To1_21_6)this.protocol).registerClientbound(ClientboundPackets1_21_5.SET_CURSOR_ITEM, x$0 -> this.passthroughClientboundItem(x$0));
        this.registerSetPlayerInventory(ClientboundPackets1_21_5.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_5.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_5.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_5.CONTAINER_SET_SLOT);
        this.registerAdvancements1_20_3(ClientboundPackets1_21_5.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21_5.SET_EQUIPMENT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_5.MERCHANT_OFFERS);
        this.registerContainerClick1_21_5(ServerboundPackets1_21_6.CONTAINER_CLICK);
        this.registerSetCreativeModeSlot1_21_5(ServerboundPackets1_21_6.SET_CREATIVE_MODE_SLOT);
        RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_5> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_5>(this.protocol);
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_5.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_5.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_5.PLACE_GHOST_RECIPE);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection connection, Item item, StructuredDataContainer container) {
        BlockItemPacketRewriter1_21_6.upgradeItemData(item);
        super.handleItemDataComponentsToClient(connection, item, container);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection connection, Item item, StructuredDataContainer container) {
        BlockItemPacketRewriter1_21_6.downgradeItemData(item);
        super.handleItemDataComponentsToServer(connection, item, container);
    }

    public static void upgradeItemData(Item item) {
        StructuredDataContainer dataContainer = item.dataContainer();
        dataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_5, StructuredDataKey.EQUIPPABLE1_21_6);
        dataContainer.replaceKey(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6);
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer dataContainer = item.dataContainer();
        dataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_6, StructuredDataKey.EQUIPPABLE1_21_5);
        dataContainer.replaceKey(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5);
    }
}

