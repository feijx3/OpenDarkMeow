/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.InventoryStateIdStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.RecipeStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.DeathProtection;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantable;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.Equippable;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.minecraft.item.data.UseCooldown;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.Unit;

public final class BlockItemPacketRewriter1_21_2
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_20_5, Protocol1_21_2To1_21> {
    public BlockItemPacketRewriter1_21_2(Protocol1_21_2To1_21 protocol) {
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
        this.registerAdvancements1_20_3(ClientboundPackets1_21_2.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21_2.SET_EQUIPMENT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_2.MERCHANT_OFFERS);
        this.registerSetCreativeModeSlot(ServerboundPackets1_20_5.SET_CREATIVE_MODE_SLOT);
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.COOLDOWN, wrapper -> {
            BackwardsMappingData mappingData = ((Protocol1_21_2To1_21)this.protocol).getMappingData();
            String itemIdentifier = wrapper.read(Types.STRING);
            int id = mappingData.getFullItemMappings().id(itemIdentifier);
            if (id != -1) {
                int mappedId = mappingData.getFullItemMappings().getNewId(id);
                wrapper.write(Types.VAR_INT, mappedId);
            } else {
                wrapper.cancel();
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_CURSOR_ITEM, ClientboundPackets1_21.CONTAINER_SET_SLOT, wrapper -> {
            wrapper.write(Types.BYTE, (byte)-1);
            wrapper.write(Types.VAR_INT, wrapper.user().get(InventoryStateIdStorage.class).stateId());
            wrapper.write(Types.SHORT, (short)-1);
            this.passthroughClientboundItem(wrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.OPEN_SCREEN, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            int containerType = wrapper.passthrough(Types.VAR_INT);
            if (containerType == 21) {
                wrapper.user().get(InventoryStateIdStorage.class).setSmithingTableOpen(true);
            }
            ((ComponentRewriterBase)((Object)((Protocol1_21_2To1_21)this.protocol).getComponentRewriter())).passthroughAndProcess(wrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.CONTAINER_SET_CONTENT, wrapper -> {
            this.varIntToUnsignedByte(wrapper);
            int stateId = wrapper.passthrough(Types.VAR_INT);
            wrapper.user().get(InventoryStateIdStorage.class).setStateId(stateId);
            Item[] items = wrapper.read(this.itemArrayType());
            wrapper.write(this.mappedItemArrayType(), items);
            for (int i2 = 0; i2 < items.length; ++i2) {
                items[i2] = this.handleItemToClient(wrapper.user(), items[i2]);
            }
            this.passthroughClientboundItem(wrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.CONTAINER_SET_SLOT, wrapper -> {
            this.varIntToByte(wrapper);
            int stateId = wrapper.passthrough(Types.VAR_INT);
            wrapper.user().get(InventoryStateIdStorage.class).setStateId(stateId);
            wrapper.passthrough(Types.SHORT);
            this.passthroughClientboundItem(wrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.CONTAINER_SET_DATA, wrapper -> {
            this.varIntToUnsignedByte(wrapper);
            if (wrapper.user().get(InventoryStateIdStorage.class).smithingTableOpen()) {
                wrapper.cancel();
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.CONTAINER_CLOSE, wrapper -> {
            this.varIntToUnsignedByte(wrapper);
            wrapper.user().get(InventoryStateIdStorage.class).setSmithingTableOpen(false);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_HELD_SLOT, ClientboundPackets1_21.SET_CARRIED_ITEM);
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.HORSE_SCREEN_OPEN, this::varIntToUnsignedByte);
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.CONTAINER_CLOSE, wrapper -> {
            this.byteToVarInt(wrapper);
            wrapper.user().get(InventoryStateIdStorage.class).setSmithingTableOpen(false);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.CONTAINER_CLICK, wrapper -> {
            this.byteToVarInt(wrapper);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.SHORT);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.VAR_INT);
            int length = Limit.max(wrapper.passthrough(Types.VAR_INT), 128);
            for (int i2 = 0; i2 < length; ++i2) {
                wrapper.passthrough(Types.SHORT);
                wrapper.write(this.itemType(), this.handleItemToServer(wrapper.user(), wrapper.read(this.mappedItemType())));
            }
            wrapper.write(this.itemType(), this.handleItemToServer(wrapper.user(), wrapper.read(this.mappedItemType())));
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.USE_ITEM_ON, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.BLOCK_POSITION1_14);
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.write(Types.BOOLEAN, false);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY, ClientboundPackets1_21.CONTAINER_SET_SLOT, wrapper -> {
            wrapper.write(Types.BYTE, (byte)-2);
            wrapper.write(Types.VAR_INT, 0);
            int slot = wrapper.read(Types.VAR_INT);
            wrapper.write(Types.SHORT, (short)slot);
            this.passthroughClientboundItem(wrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.EXPLODE, wrapper -> {
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.write(Types.FLOAT, Float.valueOf(0.0f));
            wrapper.write(Types.VAR_INT, 0);
            double knockbackX = 0.0;
            double knockbackY = 0.0;
            double knockbackZ = 0.0;
            if (wrapper.read(Types.BOOLEAN).booleanValue()) {
                knockbackX = wrapper.read(Types.DOUBLE);
                knockbackY = wrapper.read(Types.DOUBLE);
                knockbackZ = wrapper.read(Types.DOUBLE);
            }
            wrapper.write(Types.FLOAT, Float.valueOf((float)knockbackX));
            wrapper.write(Types.FLOAT, Float.valueOf((float)knockbackY));
            wrapper.write(Types.FLOAT, Float.valueOf((float)knockbackZ));
            wrapper.write(Types.VAR_INT, 0);
            Particle explosionParticle = wrapper.read(VersionedTypes.V1_21.particle());
            ((Protocol1_21_2To1_21)this.protocol).getParticleRewriter().rewriteParticle(wrapper.user(), explosionParticle);
            wrapper.write(VersionedTypes.V1_21_2.particle(), explosionParticle);
            wrapper.write(VersionedTypes.V1_21_2.particle(), explosionParticle);
            new SoundRewriter(this.protocol).soundHolderHandler().handle(wrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.RECIPE_BOOK_ADD, null, wrapper -> {
            RecipeStorage recipeStorage = wrapper.user().get(RecipeStorage.class);
            int size = wrapper.read(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                recipeStorage.readRecipe(wrapper);
            }
            boolean replace = wrapper.read(Types.BOOLEAN);
            if (replace) {
                recipeStorage.clearRecipes();
            }
            recipeStorage.sendRecipes(wrapper.user());
            wrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.RECIPE_BOOK_REMOVE, ClientboundPackets1_21.RECIPE, wrapper -> {
            RecipeStorage recipeStorage = wrapper.user().get(RecipeStorage.class);
            int[] ids = wrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            recipeStorage.lockRecipes(wrapper, ids);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.RECIPE_BOOK_SETTINGS, null, wrapper -> {
            RecipeStorage recipeStorage = wrapper.user().get(RecipeStorage.class);
            boolean[] settings = new boolean[8];
            for (int i2 = 0; i2 < 8; ++i2) {
                settings[i2] = wrapper.read(Types.BOOLEAN);
            }
            recipeStorage.setRecipeBookSettings(settings);
            wrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.UPDATE_RECIPES, wrapper -> {
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                wrapper.read(Types.STRING);
                wrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            }
            RecipeStorage recipeStorage = wrapper.user().get(RecipeStorage.class);
            recipeStorage.readStoneCutterRecipes(wrapper);
            wrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.PLACE_GHOST_RECIPE, wrapper -> {
            this.varIntToByte(wrapper);
            wrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.PLACE_RECIPE, wrapper -> {
            this.byteToVarInt(wrapper);
            String recipe = Key.stripMinecraftNamespace(wrapper.read(Types.STRING));
            wrapper.write(Types.VAR_INT, Integer.parseInt(recipe));
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.RECIPE_BOOK_SEEN_RECIPE, wrapper -> {
            String recipe = Key.stripMinecraftNamespace(wrapper.read(Types.STRING));
            wrapper.write(Types.VAR_INT, Integer.parseInt(recipe));
        });
    }

    private void varIntToUnsignedByte(PacketWrapper wrapper) {
        int containerId = wrapper.read(Types.VAR_INT);
        wrapper.write(Types.UNSIGNED_BYTE, (short)containerId);
    }

    private void varIntToByte(PacketWrapper wrapper) {
        int containerId = wrapper.read(Types.VAR_INT);
        wrapper.write(Types.BYTE, (byte)containerId);
    }

    private void byteToVarInt(PacketWrapper wrapper) {
        byte containerId = wrapper.read(Types.BYTE);
        wrapper.write(Types.VAR_INT, Integer.valueOf(containerId));
    }

    @Override
    public Item handleItemToClient(UserConnection connection, Item item) {
        this.backupInconvertibleData(item);
        super.handleItemToClient(connection, item);
        com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2.downgradeItemData(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection connection, Item item) {
        Enchantments storedEnchantments;
        boolean removed;
        super.handleItemToServer(connection, item);
        StructuredDataContainer data = item.dataContainer();
        FoodProperties1_20_5 food = data.get(StructuredDataKey.FOOD1_21);
        if (food != null && food.usingConvertsTo() != null) {
            this.handleItemToServer(connection, food.usingConvertsTo());
        }
        com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2.updateItemData(item);
        this.restoreInconvertibleData(item);
        Enchantments enchantments = data.get(StructuredDataKey.ENCHANTMENTS1_20_5);
        if (enchantments != null && (removed = enchantments.enchantments().values().removeIf(level -> level == 0)) && enchantments.size() == 0) {
            data.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, true);
        }
        if ((storedEnchantments = data.get(StructuredDataKey.STORED_ENCHANTMENTS1_20_5)) != null) {
            storedEnchantments.enchantments().values().removeIf(level -> level == 0);
        }
        return item;
    }

    private void backupInconvertibleData(Item item) {
        DeathProtection deathProtection;
        Key tooltipStyle;
        Unit glider;
        Equippable equippable;
        Key itemModel;
        UseCooldown useCooldown;
        Enchantable enchantable;
        HolderSet repairable;
        StructuredDataContainer data = item.dataContainer();
        data.setIdLookup(this.protocol, true);
        CompoundTag backupTag = new CompoundTag();
        Holder<Instrument1_21_2> instrument = data.get(StructuredDataKey.INSTRUMENT1_21_2);
        if (instrument != null && instrument.isDirect()) {
            backupTag.put("instrument_description", instrument.value().description());
        }
        if ((repairable = data.get(StructuredDataKey.REPAIRABLE)) != null) {
            backupTag.put("repairable", this.holderSetToTag(repairable));
        }
        if ((enchantable = data.get(StructuredDataKey.ENCHANTABLE)) != null) {
            backupTag.putInt("enchantable", enchantable.value());
        }
        if ((useCooldown = data.get(StructuredDataKey.USE_COOLDOWN)) != null) {
            CompoundTag tag = new CompoundTag();
            tag.putFloat("seconds", useCooldown.seconds());
            if (useCooldown.cooldownGroup() != null) {
                tag.putString("cooldown_group", useCooldown.cooldownGroup());
            }
            backupTag.put("use_cooldown", tag);
        }
        if ((itemModel = data.get(StructuredDataKey.ITEM_MODEL)) != null) {
            backupTag.putString("item_model", itemModel.original());
        }
        if ((equippable = data.get(StructuredDataKey.EQUIPPABLE1_21_2)) != null) {
            String cameraOverlay;
            CompoundTag tag = new CompoundTag();
            tag.putInt("equipment_slot", equippable.equipmentSlot());
            this.saveSoundEventHolder(tag, equippable.soundEvent());
            String model = equippable.model();
            if (model != null) {
                tag.putString("model", model);
            }
            if ((cameraOverlay = equippable.cameraOverlay()) != null) {
                tag.putString("camera_overlay", cameraOverlay);
            }
            if (equippable.allowedEntities() != null) {
                tag.put("allowed_entities", this.holderSetToTag(equippable.allowedEntities()));
            }
            tag.putBoolean("dispensable", equippable.dispensable());
            tag.putBoolean("swappable", equippable.swappable());
            tag.putBoolean("damage_on_hurt", equippable.damageOnHurt());
            backupTag.put("equippable", tag);
        }
        if ((glider = data.get(StructuredDataKey.GLIDER)) != null) {
            backupTag.putBoolean("glider", true);
        }
        if ((tooltipStyle = data.get(StructuredDataKey.TOOLTIP_STYLE)) != null) {
            backupTag.putString("tooltip_style", tooltipStyle.original());
        }
        if ((deathProtection = data.get(StructuredDataKey.DEATH_PROTECTION)) != null) {
            ListTag<CompoundTag> tag = new ListTag<CompoundTag>(CompoundTag.class);
            for (Consumable1_21_2.ConsumeEffect<?> effect : deathProtection.deathEffects()) {
                CompoundTag effectTag = new CompoundTag();
                this.convertConsumableEffect(effectTag, effect);
                tag.add(effectTag);
            }
            backupTag.put("death_protection", tag);
        }
        if (!backupTag.isEmpty()) {
            this.saveTag(this.createCustomTag(item), backupTag, "inconvertible_data");
        }
    }

    private void convertConsumableEffect(CompoundTag tag, Consumable1_21_2.ConsumeEffect<?> effect) {
        Object obj;
        tag.putInt("id", effect.id());
        if (effect.type() == Consumable1_21_2.ApplyStatusEffects.TYPE && (obj = effect.value()) instanceof Consumable1_21_2.ApplyStatusEffects) {
            Consumable1_21_2.ApplyStatusEffects value = (Consumable1_21_2.ApplyStatusEffects)obj;
            tag.putString("type", "apply_effects");
            ListTag<CompoundTag> effects = new ListTag<CompoundTag>(CompoundTag.class);
            for (PotionEffect potionEffect : value.effects()) {
                CompoundTag effectTag = new CompoundTag();
                effectTag.putInt("effect", potionEffect.effect());
                this.convertPotionEffectData(effectTag, potionEffect.effectData());
                effects.add(effectTag);
            }
            tag.put("effects", effects);
            tag.putFloat("probability", value.probability());
        } else if (effect.type() == Types.HOLDER_SET && (obj = effect.value()) instanceof HolderSet) {
            HolderSet set = (HolderSet)obj;
            tag.putString("type", "remove_effects");
            tag.put("remove_effects", this.holderSetToTag(set));
        } else if (effect.type() == Types.EMPTY) {
            tag.putString("type", "clear_all_effects");
        } else if (effect.type() == Types.FLOAT) {
            tag.putString("type", "teleport_randomly");
            tag.putFloat("probability", ((Float)effect.value()).floatValue());
        } else if (effect.type() == Types.SOUND_EVENT && (obj = effect.value()) instanceof Holder) {
            Holder sound = (Holder)obj;
            tag.putString("type", "play_sound");
            this.saveSoundEventHolder(tag, sound);
        }
    }

    private void convertPotionEffectData(CompoundTag tag, PotionEffectData data) {
        tag.putInt("amplifier", data.amplifier());
        tag.putInt("duration", data.duration());
        tag.putBoolean("ambient", data.ambient());
        tag.putBoolean("show_particles", data.showParticles());
        tag.putBoolean("show_icon", data.showIcon());
        if (data.hiddenEffect() != null) {
            CompoundTag hiddenEffect = new CompoundTag();
            this.convertPotionEffectData(hiddenEffect, data.hiddenEffect());
            tag.put("hidden_effect", hiddenEffect);
        }
    }

    private Consumable1_21_2.ConsumeEffect<?> convertConsumableEffect(CompoundTag tag) {
        int id = tag.getInt("id");
        String type = tag.getString("type");
        if ("apply_effects".equals(type)) {
            ListTag<CompoundTag> effects = tag.getListTag("effects", CompoundTag.class);
            PotionEffect[] potionEffects = new PotionEffect[effects.size()];
            for (int i2 = 0; i2 < effects.size(); ++i2) {
                CompoundTag effectTag = effects.get(i2);
                int effect = effectTag.getInt("effect");
                PotionEffectData data = this.convertPotionEffectData(effectTag);
                potionEffects[i2] = new PotionEffect(effect, data);
            }
            float probability = tag.getFloat("probability");
            return new Consumable1_21_2.ConsumeEffect<Consumable1_21_2.ApplyStatusEffects>(id, Consumable1_21_2.ApplyStatusEffects.TYPE, new Consumable1_21_2.ApplyStatusEffects(potionEffects, probability));
        }
        if ("remove_effects".equals(type)) {
            HolderSet set = this.restoreHolderSet(tag, "remove_effects");
            return new Consumable1_21_2.ConsumeEffect<HolderSet>(id, Types.HOLDER_SET, set);
        }
        if ("clear_all_effects".equals(type)) {
            return new Consumable1_21_2.ConsumeEffect<Unit>(id, Types.EMPTY, Unit.INSTANCE);
        }
        if ("teleport_randomly".equals(type)) {
            float probability = tag.getFloat("probability");
            return new Consumable1_21_2.ConsumeEffect<Float>(id, Types.FLOAT, Float.valueOf(probability));
        }
        if ("play_sound".equals(type)) {
            Holder<SoundEvent> sound = this.restoreSoundEventHolder(tag);
            return new Consumable1_21_2.ConsumeEffect<Holder<SoundEvent>>(id, Types.SOUND_EVENT, sound);
        }
        return null;
    }

    private PotionEffectData convertPotionEffectData(CompoundTag tag) {
        int amplifier = tag.getInt("amplifier");
        int duration = tag.getInt("duration");
        boolean ambient = tag.getBoolean("ambient");
        boolean showParticles = tag.getBoolean("show_particles");
        boolean showIcon = tag.getBoolean("show_icon");
        CompoundTag hiddenEffect = tag.getCompoundTag("hidden_effect");
        return new PotionEffectData(amplifier, duration, ambient, showParticles, showIcon, hiddenEffect != null ? this.convertPotionEffectData(hiddenEffect) : null);
    }

    private void restoreInconvertibleData(Item item) {
        ListTag<CompoundTag> deathProtection;
        String tooltipStyle;
        ByteTag glider;
        CompoundTag equippable;
        String itemModel;
        CompoundTag useCooldown;
        IntTag enchantable;
        Tag description;
        Tag tag;
        StructuredDataContainer data = item.dataContainer();
        CompoundTag customData = data.get(StructuredDataKey.CUSTOM_DATA);
        if (customData == null || !((tag = customData.remove(this.nbtTagName("inconvertible_data"))) instanceof CompoundTag)) {
            return;
        }
        CompoundTag backupTag = (CompoundTag)tag;
        Holder<Instrument1_21_2> instrument = data.get(StructuredDataKey.INSTRUMENT1_21_2);
        if (instrument != null && instrument.isDirect() && (description = backupTag.get("instrument_description")) != null) {
            Instrument1_21_2 delegate = instrument.value();
            data.set(StructuredDataKey.INSTRUMENT1_21_2, Holder.of(new Instrument1_21_2(delegate.soundEvent(), delegate.useDuration(), delegate.range(), description)));
        }
        if (backupTag.contains("repairable")) {
            data.set(StructuredDataKey.REPAIRABLE, this.restoreHolderSet(backupTag, "repairable"));
        }
        if ((enchantable = backupTag.getIntTag("enchantable")) != null) {
            data.set(StructuredDataKey.ENCHANTABLE, new Enchantable(enchantable.asInt()));
        }
        if ((useCooldown = backupTag.getCompoundTag("use_cooldown")) != null) {
            float seconds = useCooldown.getFloat("seconds");
            String cooldownGroup = useCooldown.getString("cooldown_group");
            data.set(StructuredDataKey.USE_COOLDOWN, new UseCooldown(seconds, cooldownGroup));
        }
        if ((itemModel = backupTag.getString("item_model")) != null) {
            data.set(StructuredDataKey.ITEM_MODEL, Key.of(itemModel));
        }
        if ((equippable = backupTag.getCompoundTag("equippable")) != null) {
            int equipmentSlot = equippable.getInt("equipment_slot");
            Holder<SoundEvent> soundEvent = this.restoreSoundEventHolder(equippable);
            String model = equippable.getString("model");
            String cameraOverlay = equippable.getString("camera_overlay");
            HolderSet allowedEntities = equippable.contains("allowed_entities") ? this.restoreHolderSet(equippable, "allowed_entities") : null;
            boolean dispensable = equippable.getBoolean("dispensable");
            boolean swappable = equippable.getBoolean("swappable");
            boolean damageOnHurt = equippable.getBoolean("damage_on_hurt");
            data.set(StructuredDataKey.EQUIPPABLE1_21_2, new Equippable(equipmentSlot, soundEvent, model, cameraOverlay, allowedEntities, dispensable, swappable, damageOnHurt));
        }
        if ((glider = backupTag.getByteTag("glider")) != null) {
            data.set(StructuredDataKey.GLIDER, Unit.INSTANCE);
        }
        if ((tooltipStyle = backupTag.getString("tooltip_style")) != null) {
            data.set(StructuredDataKey.TOOLTIP_STYLE, Key.of(tooltipStyle));
        }
        if ((deathProtection = backupTag.getListTag("death_protection", CompoundTag.class)) != null) {
            Consumable1_21_2.ConsumeEffect[] effects = new Consumable1_21_2.ConsumeEffect[deathProtection.size()];
            for (int i2 = 0; i2 < deathProtection.size(); ++i2) {
                effects[i2] = this.convertConsumableEffect(deathProtection.get(i2));
            }
            data.set(StructuredDataKey.DEATH_PROTECTION, new DeathProtection(effects));
        }
        this.removeCustomTag(data, customData);
    }
}

