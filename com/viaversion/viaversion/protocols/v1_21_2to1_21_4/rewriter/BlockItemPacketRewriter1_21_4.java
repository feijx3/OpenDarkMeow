/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.CustomModelData1_21_4;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.provider.PickItemProvider;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import com.viaversion.viaversion.util.TagUtil;

public final class BlockItemPacketRewriter1_21_4
extends StructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_21_4, Protocol1_21_2To1_21_4> {
    public BlockItemPacketRewriter1_21_4(Protocol1_21_2To1_21_4 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_2> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_2.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_2.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_2.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_2.LEVEL_EVENT, 2001);
        blockRewriter.registerLevelChunk1_19(ClientboundPackets1_21_2.LEVEL_CHUNK_WITH_LIGHT, ChunkType1_20_2::new, (connection, blockEntity) -> this.handleBlockEntity(blockEntity.tag()));
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_2.BLOCK_ENTITY_DATA, blockEntity -> this.handleBlockEntity(blockEntity.tag()));
        ((Protocol1_21_2To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_HELD_SLOT, wrapper -> {
            byte slot = wrapper.read(Types.BYTE);
            wrapper.write(Types.VAR_INT, Integer.valueOf(slot));
        });
        ((Protocol1_21_2To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.PICK_ITEM_FROM_BLOCK, null, wrapper -> {
            BlockPosition blockPosition = wrapper.read(Types.BLOCK_POSITION1_14);
            boolean includeData = wrapper.read(Types.BOOLEAN);
            Via.getManager().getProviders().get(PickItemProvider.class).pickItemFromBlock(wrapper.user(), blockPosition, includeData);
            wrapper.cancel();
        });
        ((Protocol1_21_2To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.PICK_ITEM_FROM_ENTITY, null, wrapper -> {
            int entityId = wrapper.read(Types.VAR_INT);
            boolean includeData = wrapper.read(Types.BOOLEAN);
            Via.getManager().getProviders().get(PickItemProvider.class).pickItemFromEntity(wrapper.user(), entityId, includeData);
            wrapper.cancel();
        });
        ((Protocol1_21_2To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_CURSOR_ITEM, x$0 -> this.passthroughClientboundItem(x$0));
        this.registerSetPlayerInventory(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_2.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_SLOT);
        this.registerAdvancements1_20_3(ClientboundPackets1_21_2.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21_2.SET_EQUIPMENT);
        this.registerContainerClick1_21_2(ServerboundPackets1_21_4.CONTAINER_CLICK);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_2.MERCHANT_OFFERS);
        this.registerSetCreativeModeSlot(ServerboundPackets1_21_4.SET_CREATIVE_MODE_SLOT);
        RecipeDisplayRewriter<ClientboundPackets1_21_2> recipeRewriter = new RecipeDisplayRewriter<ClientboundPackets1_21_2>(this.protocol);
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_2.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_2.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_2.PLACE_GHOST_RECIPE);
    }

    private void handleBlockEntity(CompoundTag tag) {
        if (tag == null) {
            return;
        }
        CompoundTag item = tag.getCompoundTag("item");
        if (item == null) {
            return;
        }
        CompoundTag components = item.getCompoundTag("components");
        if (components == null) {
            return;
        }
        NumberTag customModelData = TagUtil.getNamespacedNumberTag(components, "custom_model_data");
        if (customModelData != null) {
            ListTag<FloatTag> floats = new ListTag<FloatTag>(FloatTag.class);
            floats.add(new FloatTag(customModelData.asFloat()));
            CompoundTag updatedCustomModelData = new CompoundTag();
            updatedCustomModelData.put("floats", floats);
            TagUtil.removeNamespaced(components, "custom_model_data");
            components.put("custom_model_data", updatedCustomModelData);
        }
    }

    @Override
    public Item handleItemToClient(UserConnection connection, Item item) {
        super.handleItemToClient(connection, item);
        StructuredDataContainer dataContainer = item.dataContainer();
        Integer modelData = dataContainer.get(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5);
        if (modelData != null) {
            dataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, new CustomModelData1_21_4(new float[]{modelData.floatValue()}, new boolean[0], new String[0], new int[0]));
            this.saveTag(this.createCustomTag(item), new IntTag(modelData), "custom_model_data");
        }
        BlockItemPacketRewriter1_21_4.updateItemData(item);
        this.appendItemDataFixComponents(connection, item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection connection, Item item) {
        Tag tag;
        super.handleItemToServer(connection, item);
        StructuredDataContainer dataContainer = item.dataContainer();
        CompoundTag customData = dataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (customData != null && (tag = customData.remove(this.nbtTagName("custom_model_data"))) instanceof IntTag) {
            IntTag customModelData = (IntTag)tag;
            dataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, customModelData.asInt());
            this.removeCustomTag(dataContainer, customData);
        }
        BlockItemPacketRewriter1_21_4.downgradeItemData(item);
        return item;
    }

    private void appendItemDataFixComponents(UserConnection connection, Item item) {
        ProtocolVersion serverVersion = connection.getProtocolInfo().serverProtocolVersion();
        if (serverVersion.olderThanOrEqualTo(ProtocolVersion.v1_8) && (item.identifier() == 849 || item.identifier() == 854 || item.identifier() == 859 || item.identifier() == 864 || item.identifier() == 869)) {
            item.dataContainer().set(StructuredDataKey.CONSUMABLE1_21_2, new Consumable1_21_2(3600.0f, 3, Holder.of(new SoundEvent("minecraft:intentionally_empty", null)), false, new Consumable1_21_2.ConsumeEffect[0]));
        }
    }

    public static void updateItemData(Item item) {
        StructuredDataContainer dataContainer = item.dataContainer();
        dataContainer.replaceKey(StructuredDataKey.TRIM1_21_2, StructuredDataKey.TRIM1_21_4);
        dataContainer.remove(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5);
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer dataContainer = item.dataContainer();
        dataContainer.replaceKey(StructuredDataKey.TRIM1_21_4, StructuredDataKey.TRIM1_21_2);
        dataContainer.remove(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4);
    }
}

