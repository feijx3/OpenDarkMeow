/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.Protocol1_21_5To1_21_4;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.ComponentRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage.HashedItemConverterStorage;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage.HorseDataStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.PaintingVariant;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_18;
import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.minecraft.item.data.BlocksAttacks;
import com.viaversion.viaversion.api.minecraft.item.data.Equippable;
import com.viaversion.viaversion.api.minecraft.item.data.ProvidesTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ToolProperties;
import com.viaversion.viaversion.api.minecraft.item.data.TooltipDisplay;
import com.viaversion.viaversion.api.minecraft.item.data.TropicalFishPattern;
import com.viaversion.viaversion.api.minecraft.item.data.Weapon;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_19_4;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_21_5;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.libs.fastutil.ints.IntLinkedOpenHashSet;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.util.Either;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.HashMap;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public final class BlockItemPacketRewriter1_21_5
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_5, ServerboundPacket1_21_4, Protocol1_21_5To1_21_4> {
    private static final int SIGN_BOCK_ENTITY_ID = 7;
    private static final int HANGING_SIGN_BOCK_ENTITY_ID = 8;
    private static final int SADDLE_EQUIPMENT_SLOT = 7;
    static final byte SADDLED_FLAG = 4;

    public BlockItemPacketRewriter1_21_5(Protocol1_21_5To1_21_4 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_5> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_5.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_5.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_5.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_5.LEVEL_EVENT, 2001);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_5.BLOCK_ENTITY_DATA, this::handleBlockEntity);
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.LEVEL_CHUNK_WITH_LIGHT, wrapper -> {
            Object tracker = ((Protocol1_21_5To1_21_4)this.protocol).getEntityRewriter().tracker(wrapper.user());
            Mappings blockStateMappings = ((Protocol1_21_5To1_21_4)this.protocol).getMappingData().getBlockStateMappings();
            ChunkType1_21_5 chunkType = new ChunkType1_21_5(tracker.currentWorldSectionHeight(), MathUtil.ceilLog2(blockStateMappings.size()), MathUtil.ceilLog2(tracker.biomesSent()));
            Chunk chunk = wrapper.read(chunkType);
            blockRewriter.handleChunk(chunk);
            blockRewriter.handleBlockEntities(null, chunk, wrapper.user());
            ChunkType1_20_2 newChunkType = new ChunkType1_20_2(tracker.currentWorldSectionHeight(), MathUtil.ceilLog2(blockStateMappings.mappedSize()), MathUtil.ceilLog2(tracker.biomesSent()));
            CompoundTag heightmapTag = new CompoundTag();
            for (Heightmap heightmap : chunk.heightmaps()) {
                String typeKey = this.heightmapType(heightmap.type());
                if (typeKey == null) {
                    ((Protocol1_21_5To1_21_4)this.protocol).getLogger().warning(BlockItemPacketRewriter1_21_5.jvmdowngrader$concat$lambda$registerPackets$0$1(heightmap.type()));
                    continue;
                }
                heightmapTag.put(typeKey, new LongArrayTag(heightmap.data()));
            }
            Chunk1_18 mappedChunk = new Chunk1_18(chunk.getX(), chunk.getZ(), chunk.getSections(), heightmapTag, chunk.blockEntities());
            blockRewriter.handleBlockEntities(this::handleBlockEntity, chunk, wrapper.user());
            wrapper.write(newChunkType, mappedChunk);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.CHUNKS_BIOMES, wrapper -> {
            Object tracker = ((Protocol1_21_5To1_21_4)this.protocol).getEntityRewriter().tracker(wrapper.user());
            int globalPaletteBiomeBits = MathUtil.ceilLog2(tracker.biomesSent());
            ChunkBiomesType1_21_5 biomesType = new ChunkBiomesType1_21_5(tracker.currentWorldSectionHeight(), globalPaletteBiomeBits);
            ChunkBiomesType1_19_4 newBiomesType = new ChunkBiomesType1_19_4(tracker.currentWorldSectionHeight(), globalPaletteBiomeBits);
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                wrapper.passthrough(Types.CHUNK_POSITION);
                wrapper.passthroughAndMap(biomesType, newBiomesType);
            }
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.SET_CURSOR_ITEM, x$0 -> this.passthroughClientboundItem(x$0));
        this.registerSetPlayerInventory(ClientboundPackets1_21_5.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_5.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_5.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_5.CONTAINER_SET_SLOT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_5.MERCHANT_OFFERS);
        ((Protocol1_21_5To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.SET_CREATIVE_MODE_SLOT, wrapper -> {
            wrapper.passthrough(Types.SHORT);
            Item item = this.handleItemToServer(wrapper.user(), wrapper.read(this.mappedItemType()));
            wrapper.write(VersionedTypes.V1_21_5.lengthPrefixedItem(), item);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.CONTAINER_CLICK, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.SHORT);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.VAR_INT);
            HashedItemConverterStorage hashedItemConverter = wrapper.user().get(HashedItemConverterStorage.class);
            int affectedItems = Limit.max(wrapper.passthrough(Types.VAR_INT), 128);
            for (int i2 = 0; i2 < affectedItems; ++i2) {
                wrapper.passthrough(Types.SHORT);
                Item item = this.handleItemToServer(wrapper.user(), wrapper.read(this.mappedItemType()));
                wrapper.write(Types.HASHED_ITEM, ItemHasherBase.toHashedItem(hashedItemConverter.hasher(), item));
            }
            Item carriedItem = this.handleItemToServer(wrapper.user(), wrapper.read(this.mappedItemType()));
            wrapper.write(Types.HASHED_ITEM, ItemHasherBase.toHashedItem(hashedItemConverter.hasher(), carriedItem));
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.SET_EQUIPMENT, wrapper -> {
            byte value;
            int entityId = wrapper.passthrough(Types.VAR_INT);
            TrackedEntity trackedEntity = ((Protocol1_21_5To1_21_4)this.protocol).getEntityRewriter().tracker(wrapper.user()).entity(entityId);
            do {
                int equipmentSlot;
                if ((equipmentSlot = (value = wrapper.passthrough(Types.BYTE).byteValue()) & 0x7F) == 7) {
                    if (trackedEntity != null && trackedEntity.entityType().isOrHasParent(EntityTypes1_21_5.ABSTRACT_HORSE)) {
                        Item item = wrapper.read(this.itemType());
                        this.sendSaddledEntityData(wrapper.user(), trackedEntity, entityId, item.identifier() == 800);
                    }
                    wrapper.cancel();
                    return;
                }
                this.passthroughClientboundItem(wrapper);
            } while (value < 0);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.UPDATE_ADVANCEMENTS, wrapper -> {
            wrapper.passthrough(Types.BOOLEAN);
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                wrapper.passthrough(Types.STRING);
                wrapper.passthrough(Types.OPTIONAL_STRING);
                if (wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    Tag title = wrapper.passthrough(Types.TAG);
                    Tag description = wrapper.passthrough(Types.TAG);
                    ComponentRewriter1_21_5 componentRewriter = ((Protocol1_21_5To1_21_4)this.protocol).getComponentRewriter();
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
            wrapper.read(Types.BOOLEAN);
        });
        RecipeDisplayRewriter<ClientboundPacket1_21_5> recipeRewriter = new RecipeDisplayRewriter<ClientboundPacket1_21_5>(this.protocol){

            @Override
            protected void handleSmithingTrimSlotDisplay(PacketWrapper wrapper) {
                this.handleSlotDisplay(wrapper);
                this.handleSlotDisplay(wrapper);
                wrapper.read(ArmorTrimPattern.TYPE1_21_5);
                wrapper.write(Types.VAR_INT, 0);
            }
        };
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_5.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_5.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_5.PLACE_GHOST_RECIPE);
    }

    private void convertClientAsset(PacketWrapper wrapper) {
        String background = wrapper.read(Types.STRING);
        String namespace = Key.namespace(background);
        String path = Key.stripNamespace(background);
        wrapper.write(Types.STRING, BlockItemPacketRewriter1_21_5.jvmdowngrader$concat$convertClientAsset$1(namespace, path));
    }

    private void sendSaddledEntityData(UserConnection connection, TrackedEntity trackedEntity, int entityId, boolean saddled) {
        HorseDataStorage horseDataStorage;
        byte data = 0;
        if (trackedEntity.hasData() && (horseDataStorage = trackedEntity.data().get(HorseDataStorage.class)) != null) {
            if (horseDataStorage.saddled() == saddled) {
                return;
            }
            data = horseDataStorage.data();
        }
        trackedEntity.data().put(new HorseDataStorage(data, saddled));
        if (saddled) {
            data = (byte)(data | 4);
        }
        PacketWrapper entityDataPacket = PacketWrapper.create(ClientboundPackets1_21_2.SET_ENTITY_DATA, connection);
        ArrayList<EntityData> entityDataList = new ArrayList<EntityData>();
        entityDataList.add(new EntityData(17, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).byteType, data));
        entityDataPacket.write(Types.VAR_INT, entityId);
        entityDataPacket.write(VersionedTypes.V1_21_4.entityDataList, entityDataList);
        entityDataPacket.send(Protocol1_21_5To1_21_4.class);
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
        ListTag<?> messages = tag.getListTag("messages");
        tag.put("messages", ((Protocol1_21_5To1_21_4)this.protocol).getComponentRewriter().updateComponentList(connection, messages));
        ListTag<?> filteredMessages = tag.getListTag("filtered_messages");
        if (filteredMessages != null) {
            tag.put("filtered_messages", ((Protocol1_21_5To1_21_4)this.protocol).getComponentRewriter().updateComponentList(connection, filteredMessages));
        }
    }

    private String heightmapType(int id) {
        String string;
        switch (id) {
            case 0: {
                string = "WORLD_SURFACE_WG";
                break;
            }
            case 1: {
                string = "WORLD_SURFACE";
                break;
            }
            case 2: {
                string = "OCEAN_FLOOR_WG";
                break;
            }
            case 3: {
                string = "OCEAN_FLOOR";
                break;
            }
            case 4: {
                string = "MOTION_BLOCKING";
                break;
            }
            case 5: {
                string = "MOTION_BLOCKING_NO_LEAVES";
                break;
            }
            default: {
                string = null;
            }
        }
        return string;
    }

    @Override
    protected void backupInconvertibleData(UserConnection connection, Item item, StructuredDataContainer dataContainer, CompoundTag backupTag) {
        TropicalFishPattern tropicalFishPattern;
        TooltipDisplay tooltipDisplay;
        BlocksAttacks blocksAttacks;
        ProvidesTrimMaterial providesTrimMaterial;
        Weapon weapon;
        Equippable equippable;
        super.backupInconvertibleData(connection, item, dataContainer, backupTag);
        ToolProperties toolProperties = dataContainer.get(StructuredDataKey.TOOL1_21_5);
        if (toolProperties != null && toolProperties.canDestroyBlocksInCreative()) {
            backupTag.putBoolean("tool", true);
        }
        if ((equippable = dataContainer.get(StructuredDataKey.EQUIPPABLE1_21_5)) != null && equippable.equipOnInteract()) {
            backupTag.putBoolean("equippable", true);
        }
        if ((weapon = dataContainer.get(StructuredDataKey.WEAPON)) != null) {
            CompoundTag weaponTag = new CompoundTag();
            backupTag.put("weapon", weaponTag);
            weaponTag.putInt("item_damage_per_attack", weapon.itemDamagePerAttack());
            weaponTag.putFloat("disable_blocking_for_seconds", weapon.disableBlockingForSeconds());
        }
        if ((providesTrimMaterial = dataContainer.get(StructuredDataKey.PROVIDES_TRIM_MATERIAL)) != null) {
            Tag materialTag = this.eitherHolderToTag(providesTrimMaterial.material(), (material, tag) -> {
                tag.putString("asset_name", material.assetName());
                tag.putInt("item_id", material.itemId());
                tag.putFloat("item_model_index", material.itemModelIndex());
                CompoundTag overrideArmorMaterials = new CompoundTag();
                material.overrideArmorMaterials().forEach(overrideArmorMaterials::putString);
                tag.put("override_armor_materials", overrideArmorMaterials);
                tag.put("description", material.description());
            });
            backupTag.put("provides_trim_material", materialTag);
        }
        if ((blocksAttacks = dataContainer.get(StructuredDataKey.BLOCKS_ATTACKS)) != null) {
            CompoundTag blocksAttackTag = new CompoundTag();
            backupTag.put("blocks_attack", blocksAttackTag);
            blocksAttackTag.putFloat("block_delay_seconds", blocksAttacks.blockDelaySeconds());
            blocksAttackTag.putFloat("disable_cooldown_scale", blocksAttacks.disableCooldownScale());
            ListTag<CompoundTag> damageReductions = new ListTag<CompoundTag>(CompoundTag.class);
            blocksAttackTag.put("damage_reductions", damageReductions);
            for (BlocksAttacks.DamageReduction damageReduction : blocksAttacks.damageReductions()) {
                CompoundTag damageReductionTag = new CompoundTag();
                damageReductionTag.putFloat("horizontal_blocking_angle", damageReduction.horizontalBlockingAngle());
                if (damageReduction.type() != null) {
                    damageReductionTag.put("type", this.holderSetToTag(damageReduction.type()));
                }
                damageReductionTag.putFloat("base", damageReduction.base());
                damageReductionTag.putFloat("factor", damageReduction.factor());
                damageReductions.add(damageReductionTag);
            }
            CompoundTag itemDamageTag = new CompoundTag();
            blocksAttackTag.put("item_damage", itemDamageTag);
            itemDamageTag.putFloat("threshold", blocksAttacks.itemDamage().threshold());
            itemDamageTag.putFloat("base", blocksAttacks.itemDamage().base());
            itemDamageTag.putFloat("factor", blocksAttacks.itemDamage().factor());
            if (blocksAttacks.bypassedByTag() != null) {
                itemDamageTag.putString("bypassed_by", blocksAttacks.bypassedByTag());
            }
            if (blocksAttacks.blockSound() != null) {
                blocksAttackTag.put("block_sound", this.holderToTag(blocksAttacks.blockSound(), (x$0, x$1) -> this.saveSoundEvent((SoundEvent)x$0, (CompoundTag)x$1)));
            }
            if (blocksAttacks.disableSound() != null) {
                blocksAttackTag.put("disable_sound", this.holderToTag(blocksAttacks.disableSound(), (x$0, x$1) -> this.saveSoundEvent((SoundEvent)x$0, (CompoundTag)x$1)));
            }
        }
        if ((tooltipDisplay = dataContainer.get(StructuredDataKey.TOOLTIP_DISPLAY)) != null) {
            backupTag.put("hidden_components", new IntArrayTag(tooltipDisplay.hiddenComponents().toIntArray()));
        }
        if ((tropicalFishPattern = dataContainer.get(StructuredDataKey.TROPICAL_FISH_PATTERN)) != null) {
            backupTag.putInt("tropical_fish_pattern", tropicalFishPattern.packedId());
        }
        this.saveKeyData(StructuredDataKey.PROVIDES_BANNER_PATTERNS, dataContainer, backupTag);
        this.saveFloatData(StructuredDataKey.POTION_DURATION_SCALE, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.VILLAGER_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.FOX_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.SALMON_SIZE, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.PARROT_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.TROPICAL_FISH_BASE_COLOR, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.MOOSHROOM_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.RABBIT_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.FROG_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.HORSE_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.LLAMA_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.AXOLOTL_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.CAT_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.CAT_COLLAR, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.SHEEP_COLOR, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.SHULKER_COLOR, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.WOLF_SOUND_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.COW_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.PIG_VARIANT, dataContainer, backupTag);
        this.saveIntData(StructuredDataKey.WOLF_VARIANT, dataContainer, backupTag);
        Either<Integer, String> chickenVariant = dataContainer.get(StructuredDataKey.CHICKEN_VARIANT);
        if (chickenVariant != null) {
            if (chickenVariant.isLeft()) {
                backupTag.putInt("chicken_variant", chickenVariant.left());
            } else {
                backupTag.putString("chicken_variant", chickenVariant.right());
            }
        }
        this.saveHolderData(StructuredDataKey.PAINTING_VARIANT, dataContainer, backupTag, (paintingVariant, tag) -> {
            tag.putInt("width", paintingVariant.width());
            tag.putInt("height", paintingVariant.height());
            tag.putString("asset_id", paintingVariant.assetId());
            if (paintingVariant.title() != null) {
                tag.put("title", paintingVariant.title());
            }
            if (paintingVariant.author() != null) {
                tag.put("author", paintingVariant.author());
            }
        });
        this.saveHolderData(StructuredDataKey.BREAK_SOUND, dataContainer, backupTag, (x$0, x$1) -> this.saveSoundEvent((SoundEvent)x$0, (CompoundTag)x$1));
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection connection, Item item, StructuredDataContainer dataContainer) {
        super.handleItemDataComponentsToClient(connection, item, dataContainer);
        com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.BlockItemPacketRewriter1_21_5.downgradeItemData(item);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection connection, Item item, StructuredDataContainer container) {
        super.handleItemDataComponentsToServer(connection, item, container);
        com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.BlockItemPacketRewriter1_21_5.updateItemData(item);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer data, CompoundTag customData) {
        IntTag chickenVariant;
        CompoundTag blocksAttackTag;
        Tag materialTag;
        CompoundTag weaponTag;
        super.restoreBackupData(item, data, customData);
        Tag tag2 = customData.remove(this.nbtTagName("backup"));
        if (!(tag2 instanceof CompoundTag)) {
            return;
        }
        CompoundTag backupTag = (CompoundTag)tag2;
        IntArrayTag hiddenComponentsTag = backupTag.getIntArrayTag("hidden_components");
        if (hiddenComponentsTag != null) {
            data.set(StructuredDataKey.TOOLTIP_DISPLAY, new TooltipDisplay(data.has(StructuredDataKey.HIDE_TOOLTIP), new IntLinkedOpenHashSet(hiddenComponentsTag.getValue())));
        }
        if (backupTag.getBoolean("tool")) {
            data.replace(StructuredDataKey.TOOL1_20_5, StructuredDataKey.TOOL1_21_5, t2 -> new ToolProperties(t2.rules(), t2.defaultMiningSpeed(), t2.damagePerBlock(), true));
        }
        if (backupTag.getBoolean("equippable")) {
            data.replace(StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.EQUIPPABLE1_21_5, e2 -> new Equippable(e2.equipmentSlot(), e2.soundEvent(), e2.model(), e2.cameraOverlay(), e2.allowedEntities(), e2.dispensable(), e2.swappable(), e2.damageOnHurt(), true));
        }
        if ((weaponTag = backupTag.getCompoundTag("weapon")) != null) {
            data.set(StructuredDataKey.WEAPON, new Weapon(weaponTag.getInt("item_damage_per_attack"), weaponTag.getFloat("disable_blocking_for_seconds")));
        }
        if ((materialTag = backupTag.get("provides_trim_material")) != null) {
            data.set(StructuredDataKey.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(this.restoreEitherHolder(backupTag, "provides_trim_material", tag -> {
                String assetName = tag.getString("asset_name");
                int itemId = tag.getInt("item_id");
                float itemModelIndex = tag.getFloat("item_model_index");
                CompoundTag overrideArmorMaterialsTag = tag.getCompoundTag("override_armor_materials");
                HashMap<String, String> overrideArmorMaterials = new HashMap<String, String>();
                for (String key : overrideArmorMaterialsTag.keySet()) {
                    overrideArmorMaterials.put(key, overrideArmorMaterialsTag.getString(key));
                }
                Tag description = tag.get("description");
                return new ArmorTrimMaterial(assetName, itemId, itemModelIndex, overrideArmorMaterials, description);
            })));
        }
        if ((blocksAttackTag = backupTag.getCompoundTag("blocks_attack")) != null) {
            float blockDelaySeconds = blocksAttackTag.getFloat("block_delay_seconds");
            float disableCooldownScale = blocksAttackTag.getFloat("disable_cooldown_scale");
            CompoundTag itemDamageTag = blocksAttackTag.getCompoundTag("item_damage");
            BlocksAttacks.ItemDamageFunction itemDamage = new BlocksAttacks.ItemDamageFunction(itemDamageTag.getFloat("threshold"), itemDamageTag.getFloat("base"), itemDamageTag.getFloat("factor"));
            String bypassedBy = blocksAttackTag.getString("bypassed_by");
            Holder<SoundEvent> blockSound = blocksAttackTag.contains("block_sound") ? this.restoreHolder(blocksAttackTag, "block_sound", this::tagToSound) : null;
            Holder<SoundEvent> disableSound = blocksAttackTag.contains("disable_sound") ? this.restoreHolder(blocksAttackTag, "disable_sound", this::tagToSound) : null;
            ArrayList<BlocksAttacks.DamageReduction> damageReductions = new ArrayList<BlocksAttacks.DamageReduction>();
            for (CompoundTag damageReductionTag : blocksAttackTag.getListTag("damage_reductions", CompoundTag.class)) {
                float horizontalBlockingAngle = damageReductionTag.getFloat("horizontal_blocking_angle");
                HolderSet type = damageReductionTag.contains("type") ? this.restoreHolderSet(damageReductionTag, "type") : null;
                float base = damageReductionTag.getFloat("base");
                float factor = damageReductionTag.getFloat("factor");
                damageReductions.add(new BlocksAttacks.DamageReduction(horizontalBlockingAngle, type, base, factor));
            }
            data.set(StructuredDataKey.BLOCKS_ATTACKS, new BlocksAttacks(blockDelaySeconds, disableCooldownScale, damageReductions.toArray(new BlocksAttacks.DamageReduction[0]), itemDamage, bypassedBy, blockSound, disableSound));
        }
        if ((chickenVariant = backupTag.getIntTag("chicken_variant")) != null) {
            data.set(StructuredDataKey.CHICKEN_VARIANT, Either.left(chickenVariant.asInt()));
        } else {
            String chickenVariantKey = backupTag.getString("chicken_variant");
            if (chickenVariantKey != null) {
                data.set(StructuredDataKey.CHICKEN_VARIANT, Either.right(chickenVariantKey));
            }
        }
        IntTag tropicalFishPattern = backupTag.getIntTag("tropical_fish_pattern");
        if (tropicalFishPattern != null) {
            data.set(StructuredDataKey.TROPICAL_FISH_PATTERN, new TropicalFishPattern(tropicalFishPattern.asInt()));
        }
        this.restoreKeyData(StructuredDataKey.PROVIDES_BANNER_PATTERNS, data, backupTag);
        this.restoreFloatData(StructuredDataKey.POTION_DURATION_SCALE, data, backupTag);
        this.restoreIntData(StructuredDataKey.VILLAGER_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.FOX_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.SALMON_SIZE, data, backupTag);
        this.restoreIntData(StructuredDataKey.PARROT_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.TROPICAL_FISH_BASE_COLOR, data, backupTag);
        this.restoreIntData(StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, data, backupTag);
        this.restoreIntData(StructuredDataKey.MOOSHROOM_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.RABBIT_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.FROG_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.HORSE_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.LLAMA_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.AXOLOTL_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.CAT_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.CAT_COLLAR, data, backupTag);
        this.restoreIntData(StructuredDataKey.SHEEP_COLOR, data, backupTag);
        this.restoreIntData(StructuredDataKey.SHULKER_COLOR, data, backupTag);
        this.restoreIntData(StructuredDataKey.WOLF_SOUND_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.COW_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.PIG_VARIANT, data, backupTag);
        this.restoreIntData(StructuredDataKey.WOLF_VARIANT, data, backupTag);
        this.restoreHolderData(StructuredDataKey.BREAK_SOUND, data, backupTag, this::tagToSound);
        this.restoreHolderData(StructuredDataKey.PAINTING_VARIANT, data, backupTag, tag -> {
            int width = tag.getInt("width");
            int height = tag.getInt("height");
            String assetId = tag.getString("asset_id");
            Tag title = tag.get("title");
            Tag author = tag.get("author");
            return new PaintingVariant(width, height, assetId, title, author);
        });
        this.removeCustomTag(data, customData);
    }

    private SoundEvent tagToSound(CompoundTag tag) {
        String identifier = tag.getString("identifier");
        FloatTag fixedRangeTag = tag.getFloatTag("fixed_range");
        return new SoundEvent(identifier, fixedRangeTag != null ? Float.valueOf(fixedRangeTag.asFloat()) : null);
    }

    private static String jvmdowngrader$concat$convertClientAsset$1(String string, String string2) {
        return string + ":textures/" + string2 + ".png";
    }

    private static String jvmdowngrader$concat$lambda$registerPackets$0$1(int n2) {
        return "Unknown heightmap type id: " + n2;
    }
}

