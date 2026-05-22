/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.api.rewriters.EnchantmentRewriter;
import com.viaversion.viabackwards.api.rewriters.MapColorRewriter;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.storage.BiomeStorage;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.Protocol1_16To1_15_2;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.data.MapColorMappings1_15_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_15;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter.ItemPacketRewriter1_16;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.CompactArrayUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={EquipmentData.class, 3.class, 2.class, 1.class})
public class BlockItemPacketRewriter1_16
extends BackwardsItemRewriter<ClientboundPackets1_16, ServerboundPackets1_14, Protocol1_16To1_15_2> {
    private EnchantmentRewriter enchantmentRewriter;

    public BlockItemPacketRewriter1_16(Protocol1_16To1_15_2 protocol) {
        super(protocol, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    protected void registerPackets() {
        BlockRewriter<ClientboundPackets1_16> blockRewriter = BlockRewriter.for1_14(this.protocol);
        RecipeRewriter recipeRewriter = new RecipeRewriter(this.protocol);
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.UPDATE_RECIPES, wrapper -> {
            int size;
            int newSize = size = wrapper.passthrough(Types.VAR_INT).intValue();
            for (int i2 = 0; i2 < size; ++i2) {
                String originalType = wrapper.read(Types.STRING);
                String type = Key.stripMinecraftNamespace(originalType);
                if (type.equals("smithing")) {
                    --newSize;
                    wrapper.read(Types.STRING);
                    wrapper.read(Types.ITEM1_13_2_ARRAY);
                    wrapper.read(Types.ITEM1_13_2_ARRAY);
                    wrapper.read(Types.ITEM1_13_2);
                    continue;
                }
                wrapper.write(Types.STRING, originalType);
                wrapper.passthrough(Types.STRING);
                recipeRewriter.handleRecipeType(wrapper, type);
            }
            wrapper.set(Types.VAR_INT, 0, newSize);
        });
        this.registerCooldown(ClientboundPackets1_16.COOLDOWN);
        this.registerSetContent(ClientboundPackets1_16.CONTAINER_SET_CONTENT);
        this.registerSetSlot(ClientboundPackets1_16.CONTAINER_SET_SLOT);
        this.registerMerchantOffers(ClientboundPackets1_16.MERCHANT_OFFERS);
        this.registerAdvancements(ClientboundPackets1_16.UPDATE_ADVANCEMENTS);
        blockRewriter.registerBlockBreakAck(ClientboundPackets1_16.BLOCK_BREAK_ACK);
        blockRewriter.registerBlockEvent(ClientboundPackets1_16.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_16.BLOCK_UPDATE);
        blockRewriter.registerChunkBlocksUpdate(ClientboundPackets1_16.CHUNK_BLOCKS_UPDATE);
        blockRewriter.registerLevelChunk(ClientboundPackets1_16.LEVEL_CHUNK, ChunkType1_16.TYPE, ChunkType1_15.TYPE, (connection, chunk) -> {
            CompoundTag heightMaps = chunk.getHeightMap();
            for (Tag heightMapTag : heightMaps.values()) {
                if (!(heightMapTag instanceof LongArrayTag)) continue;
                LongArrayTag heightMap = (LongArrayTag)heightMapTag;
                int[] heightMapData = new int[256];
                CompactArrayUtil.iterateCompactArrayWithPadding(9, heightMapData.length, heightMap.getValue(), (i2, v2) -> {
                    heightMapData[i2] = v2;
                });
                heightMap.setValue(CompactArrayUtil.createCompactArray(9, heightMapData.length, i2 -> heightMapData[i2]));
            }
            if (chunk.isBiomeData()) {
                if (connection.getProtocolInfo().serverProtocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_16_2)) {
                    BiomeStorage biomeStorage = connection.get(BiomeStorage.class);
                    for (int i3 = 0; i3 < 1024; ++i3) {
                        int biome = chunk.getBiomeData()[i3];
                        int legacyBiome = biomeStorage.legacyBiome(biome);
                        if (legacyBiome == -1) {
                            ((Protocol1_16To1_15_2)this.protocol).getLogger().warning(BlockItemPacketRewriter1_16.jvmdowngrader$concat$lambda$registerPackets$3$1(biome));
                            legacyBiome = 1;
                        }
                        chunk.getBiomeData()[i3] = legacyBiome;
                    }
                } else {
                    for (int i4 = 0; i4 < 1024; ++i4) {
                        int biome = chunk.getBiomeData()[i4];
                        switch (biome) {
                            case 170: 
                            case 171: 
                            case 172: 
                            case 173: {
                                chunk.getBiomeData()[i4] = 8;
                            }
                        }
                    }
                }
            }
            if (chunk.getBlockEntities() == null) {
                return;
            }
            for (CompoundTag blockEntity : chunk.getBlockEntities()) {
                this.handleBlockEntity(blockEntity);
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.SET_EQUIPMENT, ClientboundPackets1_15.SET_EQUIPPED_ITEM, wrapper -> {
            byte slot;
            int entityId = wrapper.passthrough(Types.VAR_INT);
            ArrayList<EquipmentData> equipmentData = new ArrayList<EquipmentData>();
            do {
                slot = wrapper.read(Types.BYTE);
                Item item = this.handleItemToClient(wrapper.user(), wrapper.read(Types.ITEM1_13_2));
                int rawSlot = slot & 0x7F;
                equipmentData.add(new EquipmentData(rawSlot, item));
            } while ((slot & 0xFFFFFF80) != 0);
            EquipmentData firstData = (EquipmentData)equipmentData.get(0);
            wrapper.write(Types.VAR_INT, firstData.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$get$slot());
            wrapper.write(Types.ITEM1_13_2, firstData.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$get$item());
            for (int i2 = 1; i2 < equipmentData.size(); ++i2) {
                PacketWrapper equipmentPacket = wrapper.create(ClientboundPackets1_15.SET_EQUIPPED_ITEM);
                EquipmentData data = (EquipmentData)equipmentData.get(i2);
                equipmentPacket.write(Types.VAR_INT, entityId);
                equipmentPacket.write(Types.VAR_INT, data.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$get$slot());
                equipmentPacket.write(Types.ITEM1_13_2, data.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$get$item());
                equipmentPacket.send(Protocol1_16To1_15_2.class);
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.LIGHT_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.read(Types.BOOLEAN);
            }
        });
        blockRewriter.registerLevelEvent(ClientboundPackets1_16.LEVEL_EVENT, 1010, 2001);
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.CONTAINER_SET_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(wrapper -> {
                    short property = wrapper.get(Types.SHORT, 0);
                    if (property >= 4 && property <= 6) {
                        short enchantmentId = wrapper.get(Types.SHORT, 1);
                        if (enchantmentId > 11) {
                            enchantmentId = (short)(enchantmentId - 1);
                            wrapper.set(Types.SHORT, 1, enchantmentId);
                        } else if (enchantmentId == 11) {
                            wrapper.set(Types.SHORT, 1, (short)9);
                        }
                    }
                });
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(MapColorRewriter.getRewriteHandler(MapColorMappings1_15_2::getMappedColor));
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.BLOCK_ENTITY_DATA, wrapper -> {
            wrapper.passthrough(Types.BLOCK_POSITION1_14);
            wrapper.passthrough(Types.UNSIGNED_BYTE);
            CompoundTag tag = wrapper.passthrough(Types.NAMED_COMPOUND_TAG);
            this.handleBlockEntity(tag);
        });
        this.registerContainerClick(ServerboundPackets1_14.CONTAINER_CLICK);
        this.registerSetCreativeModeSlot(ServerboundPackets1_14.SET_CREATIVE_MODE_SLOT);
        ((Protocol1_16To1_15_2)this.protocol).registerServerbound(ServerboundPackets1_14.EDIT_BOOK, wrapper -> this.handleItemToServer(wrapper.user(), wrapper.passthrough(Types.ITEM1_13_2)));
    }

    private void handleBlockEntity(CompoundTag tag) {
        String id = tag.getString("id");
        if (id == null) {
            return;
        }
        if ((id = Key.namespaced(id)).equals("minecraft:conduit")) {
            Tag targetUuidTag = tag.remove("Target");
            if (!(targetUuidTag instanceof IntArrayTag)) {
                return;
            }
            UUID targetUuid = UUIDUtil.fromIntArray((int[])targetUuidTag.getValue());
            tag.putString("target_uuid", targetUuid.toString());
        } else if (id.equals("minecraft:skull")) {
            Tag targetUuid = tag.remove("SkullOwner");
            if (!(targetUuid instanceof CompoundTag)) {
                return;
            }
            CompoundTag skullOwnerTag = (CompoundTag)targetUuid;
            Tag tag2 = skullOwnerTag.remove("Id");
            if (tag2 instanceof IntArrayTag) {
                IntArrayTag ownerUuidTag = (IntArrayTag)tag2;
                UUID ownerUuid = UUIDUtil.fromIntArray(ownerUuidTag.getValue());
                skullOwnerTag.putString("Id", ownerUuid.toString());
            }
            CompoundTag ownerTag = new CompoundTag();
            for (Map.Entry entry : skullOwnerTag) {
                ownerTag.put((String)entry.getKey(), (Tag)entry.getValue());
            }
            tag.put("Owner", ownerTag);
        }
    }

    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new EnchantmentRewriter(this);
        this.enchantmentRewriter.registerEnchantment("minecraft:soul_speed", "\u00a77Soul Speed");
    }

    @Override
    public Item handleItemToClient(UserConnection connection, Item item) {
        ListTag<StringTag> pagesTag;
        IntArrayTag idTag;
        CompoundTag ownerTag;
        if (item == null) {
            return null;
        }
        super.handleItemToClient(connection, item);
        CompoundTag tag = item.tag();
        if (item.identifier() == 771 && tag != null && (ownerTag = tag.getCompoundTag("SkullOwner")) != null && (idTag = ownerTag.getIntArrayTag("Id")) != null) {
            UUID ownerUuid = UUIDUtil.fromIntArray(idTag.getValue());
            ownerTag.putString("Id", ownerUuid.toString());
        }
        if (item.identifier() == 759 && tag != null && (pagesTag = tag.getListTag("pages", StringTag.class)) != null) {
            for (StringTag page : pagesTag) {
                JsonElement jsonElement = ((Protocol1_16To1_15_2)this.protocol).getComponentRewriter().processText(connection, page.getValue());
                page.setValue(jsonElement.toString());
            }
        }
        ItemPacketRewriter1_16.newToOldAttributes(item);
        this.enchantmentRewriter.handleToClient(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection connection, Item item) {
        StringTag idTag;
        CompoundTag ownerTag;
        if (item == null) {
            return null;
        }
        int identifier = item.identifier();
        super.handleItemToServer(connection, item);
        CompoundTag tag = item.tag();
        if (identifier == 771 && tag != null && (ownerTag = tag.getCompoundTag("SkullOwner")) != null && (idTag = ownerTag.getStringTag("Id")) != null) {
            UUID ownerUuid = UUID.fromString(idTag.getValue());
            ownerTag.put("Id", new IntArrayTag(UUIDUtil.toIntArray(ownerUuid)));
        }
        ItemPacketRewriter1_16.oldToNewAttributes(item);
        this.enchantmentRewriter.handleToServer(item);
        return item;
    }

    private static String jvmdowngrader$concat$lambda$registerPackets$3$1(int n2) {
        return "Biome sent that does not exist in the biome registry: " + n2;
    }

    @RecordComponents(value={@RecordComponents.Value(name="slot", type=int.class), @RecordComponents.Value(name="item", type=Item.class)})
    @NestHost(value=BlockItemPacketRewriter1_16.class)
    private static final class EquipmentData
    extends J_L_Record {
        private final int slot;
        private final Item item;

        EquipmentData(int slot, Item item) {
            this.slot = slot;
            this.item = item;
        }

        @Override
        public final String toString() {
            return EquipmentData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return EquipmentData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return EquipmentData.jvmdowngrader$equals$equals(this, o2);
        }

        public int slot() {
            return this.slot;
        }

        public Item item() {
            return this.item;
        }

        private static String jvmdowngrader$toString$toString(EquipmentData equipmentData) {
            EquipmentData equipmentData2 = equipmentData;
            return "BlockItemPacketRewriter1_16$EquipmentData[" + "slot=" + equipmentData.slot + ", " + "item=" + equipmentData.item + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(EquipmentData equipmentData) {
            Object[] objectArray = new Object[]{equipmentData.slot, equipmentData.item};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(EquipmentData equipmentData, Object object) {
            if (equipmentData == object) {
                return true;
            }
            if (object != null && object instanceof EquipmentData) {
                EquipmentData equipmentData2 = (EquipmentData)object;
                if (equipmentData.slot == equipmentData2.slot && Objects.equals(equipmentData.item, equipmentData2.item)) {
                    return true;
                }
            }
            return false;
        }

        public Item jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$get$item() {
            return this.item;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$set$item(Item item) {
            this.item = item;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$get$slot() {
            return this.slot;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_BlockItemPacketRewriter1_16$EquipmentData$set$slot(int n2) {
            this.slot = n2;
        }
    }
}

