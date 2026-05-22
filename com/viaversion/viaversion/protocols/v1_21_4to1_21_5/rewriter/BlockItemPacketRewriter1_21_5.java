/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import ViaVersion.xyz.wagyourtail.jvmdg.j9.stub.java_base.J_U_List;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_21_5;
import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentMatchers;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrim;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.BlocksAttacks;
import com.viaversion.viaversion.api.minecraft.item.data.DyedColor;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.JukeboxPlayable;
import com.viaversion.viaversion.api.minecraft.item.data.TooltipDisplay;
import com.viaversion.viaversion.api.minecraft.item.data.Unbreakable;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_19_4;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_21_5;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntLinkedOpenHashSet;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.ComponentRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.storage.ItemHashStorage1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.util.Unit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class BlockItemPacketRewriter1_21_5
extends StructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_21_5, Protocol1_21_4To1_21_5> {
    public static final List<StructuredDataKey<?>> HIDE_ADDITIONAL_KEYS = J_U_List.of(new StructuredDataKey[]{StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BEES, StructuredDataKey.BLOCK_ENTITY_DATA, StructuredDataKey.BLOCK_STATE, StructuredDataKey.V1_21_5.bundleContents, StructuredDataKey.V1_21_5.chargedProjectiles, StructuredDataKey.V1_21_5.container, StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS, StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.MAP_ID, StructuredDataKey.PAINTING_VARIANT, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.TROPICAL_FISH_PATTERN, StructuredDataKey.WRITTEN_BOOK_CONTENT});
    public static final List<StructuredDataKey<?>> NEW_DATA_TO_REMOVE = J_U_List.of(new StructuredDataKey[]{StructuredDataKey.TOOLTIP_DISPLAY, StructuredDataKey.POTION_DURATION_SCALE, StructuredDataKey.WEAPON, StructuredDataKey.VILLAGER_VARIANT, StructuredDataKey.WOLF_VARIANT, StructuredDataKey.WOLF_COLLAR, StructuredDataKey.FOX_VARIANT, StructuredDataKey.SALMON_SIZE, StructuredDataKey.PARROT_VARIANT, StructuredDataKey.TROPICAL_FISH_PATTERN, StructuredDataKey.TROPICAL_FISH_BASE_COLOR, StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, StructuredDataKey.MOOSHROOM_VARIANT, StructuredDataKey.RABBIT_VARIANT, StructuredDataKey.COW_VARIANT, StructuredDataKey.PIG_VARIANT, StructuredDataKey.CHICKEN_VARIANT, StructuredDataKey.FROG_VARIANT, StructuredDataKey.HORSE_VARIANT, StructuredDataKey.PAINTING_VARIANT, StructuredDataKey.LLAMA_VARIANT, StructuredDataKey.AXOLOTL_VARIANT, StructuredDataKey.CAT_VARIANT, StructuredDataKey.CAT_COLLAR, StructuredDataKey.SHEEP_COLOR, StructuredDataKey.SHULKER_COLOR, StructuredDataKey.BLOCKS_ATTACKS, StructuredDataKey.PROVIDES_TRIM_MATERIAL, StructuredDataKey.BREAK_SOUND, StructuredDataKey.WOLF_SOUND_VARIANT, StructuredDataKey.PROVIDES_BANNER_PATTERNS});
    private static final DataComponentMatchers EMPTY_DATA_MATCHERS = new DataComponentMatchers(new StructuredData[0], new DataComponentPredicate[0]);
    private static final Heightmap[] EMPTY_HEIGHTMAPS = new Heightmap[0];
    private static final int SIGN_BOCK_ENTITY_ID = 7;
    private static final int HANGING_SIGN_BOCK_ENTITY_ID = 8;

    public BlockItemPacketRewriter1_21_5(Protocol1_21_4To1_21_5 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_2> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_2.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_2.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_2.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_2.LEVEL_EVENT, 2001);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_2.BLOCK_ENTITY_DATA, this::handleBlockEntity);
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.LEVEL_CHUNK_WITH_LIGHT, wrapper -> {
            Object tracker = ((Protocol1_21_4To1_21_5)this.protocol).getEntityRewriter().tracker(wrapper.user());
            Mappings blockStateMappings = ((Protocol1_21_4To1_21_5)this.protocol).getMappingData().getBlockStateMappings();
            ChunkType1_20_2 chunkType = new ChunkType1_20_2(tracker.currentWorldSectionHeight(), MathUtil.ceilLog2(blockStateMappings.size()), MathUtil.ceilLog2(tracker.biomesSent()));
            Chunk chunk = wrapper.read(chunkType);
            blockRewriter.handleChunk(chunk);
            ChunkType1_21_5 newChunkType = new ChunkType1_21_5(tracker.currentWorldSectionHeight(), MathUtil.ceilLog2(blockStateMappings.mappedSize()), MathUtil.ceilLog2(tracker.biomesSent()));
            ArrayList<Heightmap> heightmaps = new ArrayList<Heightmap>();
            for (Map.Entry<String, Tag> entry : chunk.getHeightMap().entrySet()) {
                int type = this.heightmapType(entry.getKey());
                if (type == -1) {
                    ((Protocol1_21_4To1_21_5)this.protocol).getLogger().warning(BlockItemPacketRewriter1_21_5.jvmdowngrader$concat$lambda$registerPackets$0$1(entry.getKey()));
                    continue;
                }
                Tag patt9570$temp = entry.getValue();
                if (!(patt9570$temp instanceof LongArrayTag)) continue;
                LongArrayTag longArrayTag = (LongArrayTag)patt9570$temp;
                heightmaps.add(new Heightmap(type, longArrayTag.getValue()));
            }
            Chunk1_21_5 mappedChunk = new Chunk1_21_5(chunk.getX(), chunk.getZ(), chunk.getSections(), heightmaps.toArray(EMPTY_HEIGHTMAPS), chunk.blockEntities());
            blockRewriter.handleBlockEntities(this::handleBlockEntity, chunk, wrapper.user());
            wrapper.write(newChunkType, mappedChunk);
        });
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.CHUNKS_BIOMES, wrapper -> {
            Object tracker = ((Protocol1_21_4To1_21_5)this.protocol).getEntityRewriter().tracker(wrapper.user());
            int globalPaletteBiomeBits = MathUtil.ceilLog2(tracker.biomesSent());
            ChunkBiomesType1_19_4 biomesType = new ChunkBiomesType1_19_4(tracker.currentWorldSectionHeight(), globalPaletteBiomeBits);
            ChunkBiomesType1_21_5 newBiomesType = new ChunkBiomesType1_21_5(tracker.currentWorldSectionHeight(), globalPaletteBiomeBits);
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                wrapper.passthrough(Types.CHUNK_POSITION);
                wrapper.passthroughAndMap(biomesType, newBiomesType);
            }
        });
        this.registerSetCursorItem(ClientboundPackets1_21_2.SET_CURSOR_ITEM);
        this.registerSetPlayerInventory(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_2.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_2.CONTAINER_SET_SLOT);
        this.registerSetEquipment(ClientboundPackets1_21_2.SET_EQUIPMENT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_2.MERCHANT_OFFERS);
        ((Protocol1_21_4To1_21_5)this.protocol).registerServerbound(ServerboundPackets1_21_5.SET_CREATIVE_MODE_SLOT, wrapper -> {
            if (!((Protocol1_21_4To1_21_5)this.protocol).getEntityRewriter().tracker(wrapper.user()).canInstaBuild()) {
                wrapper.cancel();
                return;
            }
            wrapper.passthrough(Types.SHORT);
            Item item = this.handleItemToServer(wrapper.user(), wrapper.read(VersionedTypes.V1_21_5.lengthPrefixedItem()));
            wrapper.write(this.itemType(), item);
        });
        ((Protocol1_21_4To1_21_5)this.protocol).registerServerbound(ServerboundPackets1_21_5.CONTAINER_CLICK, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.SHORT);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.VAR_INT);
            int affectedItems = Limit.max(wrapper.passthrough(Types.VAR_INT), 128);
            for (int i2 = 0; i2 < affectedItems; ++i2) {
                wrapper.passthrough(Types.SHORT);
                HashedItem item = wrapper.read(Types.HASHED_ITEM);
                wrapper.write(VersionedTypes.V1_21_5.item, this.handleItemToServer(wrapper.user(), this.convertHashedItemToStructuredItem(wrapper.user(), item)));
            }
            HashedItem carriedItem = wrapper.read(Types.HASHED_ITEM);
            wrapper.write(VersionedTypes.V1_21_5.item, this.handleItemToServer(wrapper.user(), this.convertHashedItemToStructuredItem(wrapper.user(), carriedItem)));
        });
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.UPDATE_ADVANCEMENTS, wrapper -> {
            wrapper.passthrough(Types.BOOLEAN);
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                wrapper.passthrough(Types.STRING);
                wrapper.passthrough(Types.OPTIONAL_STRING);
                if (wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    Tag title = wrapper.passthrough(Types.TAG);
                    Tag description = wrapper.passthrough(Types.TAG);
                    ComponentRewriter1_21_5 componentRewriter = ((Protocol1_21_4To1_21_5)this.protocol).getComponentRewriter();
                    if (componentRewriter != null) {
                        componentRewriter.processTag(wrapper.user(), title);
                        componentRewriter.processTag(wrapper.user(), description);
                    }
                    this.passthroughClientboundItem(wrapper);
                    wrapper.passthrough(Types.VAR_INT);
                    int flags = wrapper.passthrough(Types.INT);
                    if ((flags & 1) != 0) {
                        this.convertClientAsset(wrapper);
                    }
                    wrapper.passthrough(Types.FLOAT);
                    wrapper.passthrough(Types.FLOAT);
                }
                int requirements = wrapper.passthrough(Types.VAR_INT);
                for (int array = 0; array < requirements; ++array) {
                    wrapper.passthrough(Types.STRING_ARRAY);
                }
                wrapper.passthrough(Types.BOOLEAN);
            }
            wrapper.passthrough(Types.STRING_ARRAY);
            int progressSize = wrapper.passthrough(Types.VAR_INT);
            for (int i3 = 0; i3 < progressSize; ++i3) {
                wrapper.passthrough(Types.STRING);
                int criterionSize = wrapper.passthrough(Types.VAR_INT);
                for (int j2 = 0; j2 < criterionSize; ++j2) {
                    wrapper.passthrough(Types.STRING);
                    wrapper.passthrough(Types.OPTIONAL_LONG);
                }
            }
            wrapper.write(Types.BOOLEAN, true);
        });
        RecipeDisplayRewriter<ClientboundPacket1_21_2> recipeRewriter = new RecipeDisplayRewriter<ClientboundPacket1_21_2>(this.protocol){

            @Override
            protected void handleSmithingTrimSlotDisplay(PacketWrapper wrapper) {
                this.handleSlotDisplay(wrapper);
                this.handleSlotDisplay(wrapper);
                ((PacketWrapperImpl)wrapper).setAllActionsRead(true);
                this.handleSlotDisplay(wrapper);
                ((PacketWrapperImpl)wrapper).setAllActionsRead(false);
                wrapper.write(ArmorTrimPattern.TYPE1_21_5, Holder.of(false));
            }
        };
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_2.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_2.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_2.PLACE_GHOST_RECIPE);
    }

    private void convertClientAsset(PacketWrapper wrapper) {
        String background = wrapper.read(Types.STRING);
        String namespace = Key.namespace(background);
        String path = Key.stripNamespace(background);
        if (path.startsWith("textures/") && path.endsWith(".png")) {
            String stripped = path.substring("textures/".length(), path.length() - ".png".length());
            wrapper.write(Types.STRING, BlockItemPacketRewriter1_21_5.jvmdowngrader$concat$convertClientAsset$1(namespace, stripped));
        } else {
            wrapper.write(Types.STRING, BlockItemPacketRewriter1_21_5.jvmdowngrader$concat$convertClientAsset$1(namespace, path));
        }
    }

    private void handleBlockEntity(UserConnection connection, BlockEntity blockEntity) {
        CompoundTag tag = blockEntity.tag();
        if (tag != null && (blockEntity.typeId() == 7 || blockEntity.typeId() == 8)) {
            this.updateSignMessages(connection, tag.getCompoundTag("front_text"));
            this.updateSignMessages(connection, tag.getCompoundTag("back_text"));
        }
    }

    private void updateSignMessages(UserConnection connection, CompoundTag tag) {
        if (tag == null) {
            return;
        }
        ListTag<StringTag> messages = tag.getListTag("messages", StringTag.class);
        tag.put("messages", ((Protocol1_21_4To1_21_5)this.protocol).getComponentRewriter().updateComponentList(connection, messages, true));
        ListTag<StringTag> filteredMessages = tag.getListTag("filtered_messages", StringTag.class);
        if (filteredMessages != null) {
            tag.put("filtered_messages", ((Protocol1_21_4To1_21_5)this.protocol).getComponentRewriter().updateComponentList(connection, filteredMessages, true));
        }
    }

    private int heightmapType(String id) {
        int n2;
        switch (id) {
            case "WORLD_SURFACE_WG": {
                n2 = 0;
                break;
            }
            case "WORLD_SURFACE": {
                n2 = 1;
                break;
            }
            case "OCEAN_FLOOR_WG": {
                n2 = 2;
                break;
            }
            case "OCEAN_FLOOR": {
                n2 = 3;
                break;
            }
            case "MOTION_BLOCKING": {
                n2 = 4;
                break;
            }
            case "MOTION_BLOCKING_NO_LEAVES": {
                n2 = 5;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    @Override
    public Item handleItemToClient(UserConnection connection, Item item) {
        if (item.isEmpty()) {
            return item;
        }
        MappingData mappingData = ((Protocol1_21_4To1_21_5)this.protocol).getMappingData();
        if (mappingData != null && mappingData.getItemMappings() != null) {
            item.setIdentifier(mappingData.getNewItemId(item.identifier()));
        }
        StructuredDataContainer dataContainer = item.dataContainer();
        this.updateItemDataComponentTypeIds(dataContainer, true);
        this.handleRewritablesToClient(connection, dataContainer, null);
        BlockItemPacketRewriter1_21_5.updateItemData(item);
        this.handleItemDataComponentsToClient(connection, item, dataContainer);
        if (dataContainer.hasValue(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP)) {
            CompoundTag backupTag = new CompoundTag();
            backupTag.putBoolean("hide_additional_tooltip", true);
            this.saveTag(this.createCustomTag(item), backupTag, "backup");
        }
        this.appendItemDataFixComponents(connection, item);
        ItemHashStorage1_21_5 itemHasher = (ItemHashStorage1_21_5)this.itemHasher(connection);
        if (itemHasher.isProcessingClientboundInventoryPacket()) {
            for (StructuredData<?> data : dataContainer.data().values()) {
                itemHasher.trackStructuredData(data);
            }
        }
        return item;
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection connection, Item item, StructuredDataContainer container) {
        BlockItemPacketRewriter1_21_5.downgradeItemData(item);
        super.handleItemDataComponentsToServer(connection, item, container);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer container, CompoundTag customData) {
        CompoundTag backupTag;
        super.restoreBackupData(item, container, customData);
        Tag tag = customData.remove(this.nbtTagName("backup"));
        if (tag instanceof CompoundTag && (backupTag = (CompoundTag)tag).getBoolean("hide_additional_tooltip")) {
            container.set(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP);
        }
    }

    public static void updateItemData(Item item) {
        StructuredData<JukeboxPlayable> jukeboxPlayable;
        StructuredData<Enchantments> storedEnchantmentsData;
        StructuredData<Enchantments> enchantmentsData;
        StructuredData<ArmorTrim> armorTrimData;
        StructuredData<AttributeModifiers1_21> attributeModifiersData;
        StructuredData<DyedColor> dyedColorData;
        StructuredData<AdventureModePredicate> canBreak;
        StructuredData<AdventureModePredicate> canPlaceOnData;
        StructuredData<Unbreakable> unbreakableData;
        StructuredDataContainer dataContainer = item.dataContainer();
        dataContainer.replaceKey(StructuredDataKey.TOOL1_20_5, StructuredDataKey.TOOL1_21_5);
        dataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.EQUIPPABLE1_21_5);
        dataContainer.replace(StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.INSTRUMENT1_21_5, EitherHolder::of);
        IntLinkedOpenHashSet hiddenComponents = new IntLinkedOpenHashSet(4);
        boolean hideTooltip = dataContainer.hasValue(StructuredDataKey.HIDE_TOOLTIP);
        if (dataContainer.hasValue(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP)) {
            FullMappings mappings = Protocol1_21_4To1_21_5.MAPPINGS.getDataComponentSerializerMappings();
            for (StructuredDataKey<?> key : HIDE_ADDITIONAL_KEYS) {
                hiddenComponents.add(mappings.mappedId(key.identifier()));
            }
        }
        if ((unbreakableData = dataContainer.getNonEmptyData(StructuredDataKey.UNBREAKABLE1_20_5)) != null && !unbreakableData.value().showInTooltip()) {
            hiddenComponents.add(unbreakableData.id());
        }
        if ((canPlaceOnData = dataContainer.getNonEmptyData(StructuredDataKey.CAN_PLACE_ON1_20_5)) != null && !canPlaceOnData.value().showInTooltip()) {
            hiddenComponents.add(canPlaceOnData.id());
        }
        if ((canBreak = dataContainer.getNonEmptyData(StructuredDataKey.CAN_BREAK1_20_5)) != null && !canBreak.value().showInTooltip()) {
            hiddenComponents.add(canBreak.id());
        }
        if ((dyedColorData = dataContainer.getNonEmptyData(StructuredDataKey.DYED_COLOR1_20_5)) != null && !dyedColorData.value().showInTooltip()) {
            hiddenComponents.add(dyedColorData.id());
        }
        if ((attributeModifiersData = dataContainer.getNonEmptyData(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21)) != null && !attributeModifiersData.value().showInTooltip()) {
            hiddenComponents.add(attributeModifiersData.id());
        }
        if ((armorTrimData = dataContainer.getNonEmptyData(StructuredDataKey.TRIM1_21_4)) != null && !armorTrimData.value().showInTooltip()) {
            hiddenComponents.add(armorTrimData.id());
        }
        if ((enchantmentsData = dataContainer.getNonEmptyData(StructuredDataKey.ENCHANTMENTS1_20_5)) != null && !enchantmentsData.value().showInTooltip()) {
            hiddenComponents.add(enchantmentsData.id());
        }
        if ((storedEnchantmentsData = dataContainer.getNonEmptyData(StructuredDataKey.STORED_ENCHANTMENTS1_20_5)) != null && !storedEnchantmentsData.value().showInTooltip()) {
            hiddenComponents.add(storedEnchantmentsData.id());
        }
        if ((jukeboxPlayable = dataContainer.getNonEmptyData(StructuredDataKey.JUKEBOX_PLAYABLE1_21)) != null && !jukeboxPlayable.value().showInTooltip()) {
            hiddenComponents.add(jukeboxPlayable.id());
        }
        if (!(!hideTooltip && hiddenComponents.isEmpty() || dataContainer.has(StructuredDataKey.TOOLTIP_DISPLAY))) {
            dataContainer.set(StructuredDataKey.TOOLTIP_DISPLAY, new TooltipDisplay(hideTooltip, hiddenComponents));
        }
        dataContainer.replace(StructuredDataKey.UNBREAKABLE1_20_5, StructuredDataKey.UNBREAKABLE1_21_5, unbreakable -> Unit.INSTANCE);
        dataContainer.replace(StructuredDataKey.CAN_PLACE_ON1_20_5, StructuredDataKey.V1_21_5.canPlaceOn, BlockItemPacketRewriter1_21_5::updateAdventureModePredicate);
        dataContainer.replace(StructuredDataKey.CAN_BREAK1_20_5, StructuredDataKey.V1_21_5.canBreak, BlockItemPacketRewriter1_21_5::updateAdventureModePredicate);
        dataContainer.replaceKey(StructuredDataKey.JUKEBOX_PLAYABLE1_21, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5);
        dataContainer.replaceKey(StructuredDataKey.DYED_COLOR1_20_5, StructuredDataKey.DYED_COLOR1_21_5);
        dataContainer.replaceKey(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5);
        dataContainer.replaceKey(StructuredDataKey.TRIM1_21_4, StructuredDataKey.TRIM1_21_5);
        dataContainer.replaceKey(StructuredDataKey.ENCHANTMENTS1_20_5, StructuredDataKey.ENCHANTMENTS1_21_5);
        dataContainer.replaceKey(StructuredDataKey.STORED_ENCHANTMENTS1_20_5, StructuredDataKey.STORED_ENCHANTMENTS1_21_5);
        dataContainer.remove(StructuredDataKey.HIDE_TOOLTIP);
        dataContainer.remove(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP);
    }

    private static AdventureModePredicate updateAdventureModePredicate(AdventureModePredicate predicate) {
        BlockPredicate[] blockPredicates = new BlockPredicate[predicate.predicates().length];
        for (int i2 = 0; i2 < predicate.predicates().length; ++i2) {
            BlockPredicate blockPredicate = predicate.predicates()[i2];
            blockPredicates[i2] = new BlockPredicate(blockPredicate.holderSet(), blockPredicate.propertyMatchers(), blockPredicate.tag(), EMPTY_DATA_MATCHERS);
        }
        return new AdventureModePredicate(blockPredicates);
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer dataContainer = item.dataContainer();
        dataContainer.replaceKey(StructuredDataKey.TOOL1_21_5, StructuredDataKey.TOOL1_20_5);
        dataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_5, StructuredDataKey.EQUIPPABLE1_21_2);
        dataContainer.replace(StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.INSTRUMENT1_21_2, instrument -> instrument.hasHolder() ? instrument.holder() : null);
        TooltipDisplay tooltipDisplay = dataContainer.get(StructuredDataKey.TOOLTIP_DISPLAY);
        if (tooltipDisplay != null && tooltipDisplay.hideTooltip()) {
            dataContainer.set(StructuredDataKey.HIDE_TOOLTIP);
        }
        dataContainer.replace(StructuredDataKey.UNBREAKABLE1_21_5, StructuredDataKey.UNBREAKABLE1_20_5, unbreakable -> new Unbreakable(BlockItemPacketRewriter1_21_5.shouldShowToServer(tooltipDisplay, StructuredDataKey.UNBREAKABLE1_20_5)));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.DYED_COLOR1_21_5, StructuredDataKey.DYED_COLOR1_20_5, dyedColor -> new DyedColor(dyedColor.rgb(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, attributeModifiers -> new AttributeModifiers1_21(attributeModifiers.modifiers(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.TRIM1_21_5, StructuredDataKey.TRIM1_21_4, trim -> new ArmorTrim(trim.material(), trim.pattern(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.ENCHANTMENTS1_21_5, StructuredDataKey.ENCHANTMENTS1_20_5, enchantments -> new Enchantments(enchantments.enchantments(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.STORED_ENCHANTMENTS1_21_5, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, enchantments -> new Enchantments(enchantments.enchantments(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.V1_21_5.canPlaceOn, StructuredDataKey.CAN_PLACE_ON1_20_5, canPlaceOn -> new AdventureModePredicate(canPlaceOn.predicates(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.V1_21_5.canBreak, StructuredDataKey.CAN_BREAK1_20_5, canBreak -> new AdventureModePredicate(canBreak.predicates(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(dataContainer, tooltipDisplay, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5, StructuredDataKey.JUKEBOX_PLAYABLE1_21, playable -> new JukeboxPlayable(playable.song(), false));
        dataContainer.remove(NEW_DATA_TO_REMOVE);
    }

    private StructuredItem convertHashedItemToStructuredItem(UserConnection connection, HashedItem hashedItem) {
        StructuredItem item = new StructuredItem(hashedItem.identifier(), hashedItem.amount());
        ItemHashStorage1_21_5 hasher = (ItemHashStorage1_21_5)this.itemHasher(connection);
        Map<StructuredDataKey<?>, StructuredData<?>> structuredDataMap = item.dataContainer().data();
        for (Int2IntMap.Entry hashEntry : hashedItem.dataHashesById().int2IntEntrySet()) {
            StructuredData<?> structuredData = hasher.dataFromHash(hashEntry.getIntKey(), hashEntry.getIntValue());
            if (structuredData == null) continue;
            structuredDataMap.put(structuredData.key(), structuredData);
        }
        Iterator iterator2 = hashedItem.removedDataIds().iterator();
        while (iterator2.hasNext()) {
            int dataId = (Integer)iterator2.next();
            StructuredDataKey<?> structuredDataKey = VersionedTypes.V1_21_5.structuredData.key(dataId);
            structuredDataMap.put(structuredDataKey, StructuredData.empty(structuredDataKey, dataId));
        }
        return item;
    }

    private void appendItemDataFixComponents(UserConnection connection, Item item) {
        ProtocolVersion serverVersion = connection.getProtocolInfo().serverProtocolVersion();
        if (serverVersion.olderThanOrEqualTo(ProtocolVersion.v1_8) && (item.identifier() == 858 || item.identifier() == 863 || item.identifier() == 873 || item.identifier() == 868 || item.identifier() == 878)) {
            item.dataContainer().remove(StructuredDataKey.CONSUMABLE1_21_2);
            item.dataContainer().set(StructuredDataKey.BLOCKS_ATTACKS, new BlocksAttacks(0.0f, 0.0f, new BlocksAttacks.DamageReduction[]{new BlocksAttacks.DamageReduction(90.0f, null, -0.5f, 0.5f)}, new BlocksAttacks.ItemDamageFunction(0.0f, 0.0f, 0.0f), null, null, null));
        }
    }

    private static <T> void updateShowInTooltip(StructuredDataContainer container, @Nullable TooltipDisplay display, StructuredDataKey<T> key, StructuredDataKey<T> mappedKey, Function<T, T> function) {
        if (BlockItemPacketRewriter1_21_5.shouldShowToServer(display, key)) {
            container.replaceKey(key, mappedKey);
        } else {
            container.replace(key, mappedKey, function);
        }
    }

    private static boolean shouldShowToServer(@Nullable TooltipDisplay display, StructuredDataKey<?> key) {
        if (display == null) {
            return true;
        }
        int unmappedId = Protocol1_21_4To1_21_5.MAPPINGS.getDataComponentSerializerMappings().id(key.identifier());
        return !display.hiddenComponents().contains(unmappedId);
    }

    private static String jvmdowngrader$concat$convertClientAsset$1(String string, String string2) {
        return string + ":" + string2;
    }

    private static String jvmdowngrader$concat$lambda$registerPackets$0$1(String string) {
        return "Unknown heightmap type: " + string;
    }
}

