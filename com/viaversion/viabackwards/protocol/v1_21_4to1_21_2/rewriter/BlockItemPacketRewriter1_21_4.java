/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.Protocol1_21_4To1_21_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.CustomModelData1_21_4;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;

public final class BlockItemPacketRewriter1_21_4
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_21_2, Protocol1_21_4To1_21_2> {
    public BlockItemPacketRewriter1_21_4(Protocol1_21_4To1_21_2 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_2> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_2.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_2.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_2.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_2.LEVEL_EVENT, 2001);
        blockRewriter.registerLevelChunk1_19(ClientboundPackets1_21_2.LEVEL_CHUNK_WITH_LIGHT, ChunkType1_20_2::new);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_2.BLOCK_ENTITY_DATA);
        ((Protocol1_21_4To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_HELD_SLOT, wrapper -> {
            int slot = wrapper.read(Types.VAR_INT);
            wrapper.write(Types.BYTE, (byte)slot);
        });
        ((Protocol1_21_4To1_21_2)this.protocol).cancelServerbound(ServerboundPackets1_21_2.PICK_ITEM);
        ((Protocol1_21_4To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_CURSOR_ITEM, x$0 -> this.passthroughClientboundItem(x$0));
        this.registerSetPlayerInventory(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_2.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_SLOT);
        this.registerAdvancements1_20_3(ClientboundPackets1_21_2.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21_2.SET_EQUIPMENT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_2.MERCHANT_OFFERS);
        this.registerContainerClick1_21_2(ServerboundPackets1_21_2.CONTAINER_CLICK);
        this.registerSetCreativeModeSlot(ServerboundPackets1_21_2.SET_CREATIVE_MODE_SLOT);
        RecipeDisplayRewriter<ClientboundPackets1_21_2> recipeRewriter = new RecipeDisplayRewriter<ClientboundPackets1_21_2>(this.protocol);
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_2.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_2.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_2.PLACE_GHOST_RECIPE);
    }

    @Override
    public Item handleItemToClient(UserConnection connection, Item item) {
        super.handleItemToClient(connection, item);
        StructuredDataContainer dataContainer = item.dataContainer();
        CustomModelData1_21_4 modelData = dataContainer.get(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4);
        if (modelData != null) {
            this.saveTag(this.createCustomTag(item), this.customModelDataToTag(modelData), "custom_model_data");
            if (ViaBackwards.getConfig().mapCustomModelData() && modelData.floats().length > 0) {
                int data = (int)modelData.floats()[0];
                dataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, data);
            }
        }
        com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.BlockItemPacketRewriter1_21_4.downgradeItemData(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection connection, Item item) {
        Tag tag;
        super.handleItemToServer(connection, item);
        StructuredDataContainer dataContainer = item.dataContainer();
        CompoundTag customData = dataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (customData != null && (tag = customData.remove(this.nbtTagName("custom_model_data"))) instanceof CompoundTag) {
            CompoundTag customModelData = (CompoundTag)tag;
            dataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, this.customModelDataFromTag(customModelData));
            this.removeCustomTag(dataContainer, customData);
        }
        com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.BlockItemPacketRewriter1_21_4.updateItemData(item);
        return item;
    }

    private CustomModelData1_21_4 customModelDataFromTag(CompoundTag tag) {
        IntArrayTag floatsTag = tag.getIntArrayTag("floats");
        float[] floats = new float[floatsTag.getValue().length];
        for (int i2 = 0; i2 < floats.length; ++i2) {
            floats[i2] = Float.intBitsToFloat(floatsTag.get(i2));
        }
        ByteArrayTag booleansTag = tag.getByteArrayTag("booleans");
        boolean[] booleans = new boolean[booleansTag.getValue().length];
        for (int i3 = 0; i3 < booleans.length; ++i3) {
            booleans[i3] = booleansTag.get(i3) != 0;
        }
        ListTag<StringTag> stringsTag = tag.getListTag("strings", StringTag.class);
        String[] strings = new String[stringsTag.size()];
        for (int i4 = 0; i4 < strings.length; ++i4) {
            strings[i4] = stringsTag.get(i4).getValue();
        }
        IntArrayTag colorsTag = tag.getIntArrayTag("colors");
        return new CustomModelData1_21_4(floats, booleans, strings, colorsTag.getValue());
    }

    private CompoundTag customModelDataToTag(CustomModelData1_21_4 customModelData) {
        CompoundTag tag = new CompoundTag();
        int[] floats = new int[customModelData.floats().length];
        for (int i2 = 0; i2 < floats.length; ++i2) {
            floats[i2] = Float.floatToIntBits(customModelData.floats()[i2]);
        }
        tag.put("floats", new IntArrayTag(floats));
        byte[] booleans = new byte[customModelData.booleans().length];
        for (int i3 = 0; i3 < booleans.length; ++i3) {
            booleans[i3] = (byte)(customModelData.booleans()[i3] ? 1 : 0);
        }
        tag.put("booleans", new ByteArrayTag(booleans));
        ListTag<StringTag> strings = new ListTag<StringTag>(StringTag.class);
        for (String string : customModelData.strings()) {
            strings.add(new StringTag(string));
        }
        tag.put("strings", strings);
        tag.put("colors", new IntArrayTag(customModelData.colors()));
        return tag;
    }
}

