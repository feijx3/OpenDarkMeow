/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter;

import ViaBackwards.xyz.wagyourtail.jvmdg.j15.stub.java_base.J_L_String;
import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.api.rewriters.StructuredEnchantmentRewriter;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.Protocol1_21To1_20_5;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.EnchantmentsPaintingsStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.OpenScreenStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.PlayerRotationStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.JukeboxPlayable;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.ArrayList;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={PendingIdChange.class})
public final class BlockItemPacketRewriter1_21
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21, ServerboundPacket1_20_5, Protocol1_21To1_20_5> {
    private final StructuredEnchantmentRewriter enchantmentRewriter = new StructuredEnchantmentRewriter(this);

    public BlockItemPacketRewriter1_21(Protocol1_21To1_20_5 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelChunk1_19(ClientboundPackets1_21.LEVEL_CHUNK_WITH_LIGHT, ChunkType1_20_2::new);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21.BLOCK_ENTITY_DATA);
        this.registerCooldown(ClientboundPackets1_21.COOLDOWN);
        this.registerSetContent1_17_1(ClientboundPackets1_21.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_17_1(ClientboundPackets1_21.CONTAINER_SET_SLOT);
        this.registerAdvancements1_20_3(ClientboundPackets1_21.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21.SET_EQUIPMENT);
        this.registerContainerClick1_17_1(ServerboundPackets1_20_5.CONTAINER_CLICK);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21.MERCHANT_OFFERS);
        this.registerSetCreativeModeSlot(ServerboundPackets1_20_5.SET_CREATIVE_MODE_SLOT);
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.OPEN_SCREEN, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            int menuType = wrapper.passthrough(Types.VAR_INT);
            wrapper.user().get(OpenScreenStorage.class).setMenuType(menuType);
            ((ComponentRewriterBase)((Object)((Protocol1_21To1_20_5)this.protocol).getComponentRewriter())).passthroughAndProcess(wrapper);
        });
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.CONTAINER_SET_DATA, wrapper -> {
            wrapper.passthrough(Types.UNSIGNED_BYTE);
            short property = wrapper.passthrough(Types.SHORT);
            if (property >= 4 && property <= 6) {
                OpenScreenStorage openScreenStorage = wrapper.user().get(OpenScreenStorage.class);
                if (openScreenStorage.menuType() != 13) {
                    return;
                }
                short enchantmentId = wrapper.read(Types.SHORT);
                EnchantmentsPaintingsStorage storage = wrapper.user().get(EnchantmentsPaintingsStorage.class);
                String key = storage.enchantments().idToKey(enchantmentId);
                int mappedId = key != null ? Enchantments1_20_5.keyToId(key) : -1;
                wrapper.write(Types.SHORT, (short)mappedId);
            }
        });
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.HORSE_SCREEN_OPEN, wrapper -> {
            wrapper.passthrough(Types.UNSIGNED_BYTE);
            int columns = wrapper.read(Types.VAR_INT);
            wrapper.write(Types.VAR_INT, columns * 3 + 1);
        });
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.LEVEL_EVENT, wrapper -> {
            int event = wrapper.passthrough(Types.INT);
            wrapper.passthrough(Types.BLOCK_POSITION1_14);
            int data = wrapper.read(Types.INT);
            if (event == 1010) {
                int itemId = wrapper.user().get(EnchantmentsPaintingsStorage.class).jubeboxSongToItem(data);
                if (itemId == -1) {
                    wrapper.cancel();
                    return;
                }
                wrapper.write(Types.INT, itemId);
            } else if (event == 2001) {
                wrapper.write(Types.INT, ((Protocol1_21To1_20_5)this.protocol).getMappingData().getNewBlockStateId(data));
            } else {
                wrapper.write(Types.INT, data);
            }
        });
        ((Protocol1_21To1_20_5)this.protocol).registerServerbound(ServerboundPackets1_20_5.USE_ITEM, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.VAR_INT);
            PlayerRotationStorage rotation = wrapper.user().get(PlayerRotationStorage.class);
            wrapper.write(Types.FLOAT, Float.valueOf(rotation.yaw()));
            wrapper.write(Types.FLOAT, Float.valueOf(rotation.pitch()));
        });
        new RecipeRewriter1_20_3<ClientboundPackets1_21>(this.protocol).register1_20_5(ClientboundPackets1_21.UPDATE_RECIPES);
    }

    @Override
    public Item handleItemToClient(UserConnection connection, Item item) {
        boolean trident;
        if (item.isEmpty()) {
            return item;
        }
        StructuredDataContainer data = item.dataContainer();
        data.setIdLookup(this.protocol, true);
        EnchantmentsPaintingsStorage storage = connection.get(EnchantmentsPaintingsStorage.class);
        IdRewriteFunction idRewriteFunction = id -> {
            String key = storage.enchantments().idToKey(id);
            return key != null ? Enchantments1_20_5.keyToId(key) : -1;
        };
        StructuredEnchantmentRewriter.DescriptionSupplier descriptionSupplier = (id, level) -> {
            Tag description = storage.enchantmentDescription(id);
            if (description == null) {
                return new StringTag("Unknown enchantment");
            }
            TextComponent component = SerializerVersion.V1_20_5.toComponent(description);
            component.getStyle().setItalic(false);
            component.getStyle().setFormatting(TextFormatting.GRAY);
            if (level != 1 || storage.enchantmentMaxLevel(id) != 1) {
                component.getSiblings().add(new StringComponent(" "));
                component.getSiblings().add(new TranslationComponent(J_L_String.formatted("enchantment.level.%s", level), new Object[0]));
            }
            return SerializerVersion.V1_20_5.toTag(component);
        };
        this.enchantmentRewriter.rewriteEnchantmentsToClient(data, StructuredDataKey.ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, false);
        this.enchantmentRewriter.rewriteEnchantmentsToClient(data, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, true);
        int identifier = item.identifier();
        this.backupInconvertibleData(item);
        super.handleItemToClient(connection, item);
        com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.BlockItemPacketRewriter1_21.downgradeItemData(item);
        if (data.has(StructuredDataKey.RARITY)) {
            return item;
        }
        boolean bl2 = trident = identifier == 1188;
        if (trident || identifier == 1200) {
            data.set(StructuredDataKey.RARITY, trident ? 3 : 1);
            this.saveTag(this.createCustomTag(item), new ByteTag(true), "rarity");
        }
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection connection, Item item) {
        if (item.isEmpty()) {
            return item;
        }
        StructuredDataContainer data = item.dataContainer();
        data.setIdLookup(this.protocol, false);
        EnchantmentsPaintingsStorage storage = connection.get(EnchantmentsPaintingsStorage.class);
        this.rewriteEnchantmentToServer(storage, item, StructuredDataKey.ENCHANTMENTS1_20_5);
        this.rewriteEnchantmentToServer(storage, item, StructuredDataKey.STORED_ENCHANTMENTS1_20_5);
        this.enchantmentRewriter.handleToServer(item);
        super.handleItemToServer(connection, item);
        com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.BlockItemPacketRewriter1_21.updateItemData(item);
        this.restoreInconvertibleData(item);
        CompoundTag customData = data.get(StructuredDataKey.CUSTOM_DATA);
        if (customData == null) {
            return item;
        }
        if (customData.remove(this.nbtTagName("rarity")) != null) {
            data.remove(StructuredDataKey.RARITY);
            this.removeCustomTag(data, customData);
        }
        return item;
    }

    private void rewriteEnchantmentToServer(EnchantmentsPaintingsStorage storage, Item item, StructuredDataKey<Enchantments> key) {
        Enchantments enchantments = item.dataContainer().get(key);
        if (enchantments == null) {
            return;
        }
        ArrayList<PendingIdChange> updatedIds = new ArrayList<PendingIdChange>();
        for (Int2IntMap.Entry entry : enchantments.enchantments().int2IntEntrySet()) {
            int mappedId;
            int id = entry.getIntKey();
            String enchantmentKey = Enchantments1_20_5.idToKey(id);
            if (enchantmentKey == null || id == (mappedId = storage.enchantments().keyToId(enchantmentKey))) continue;
            int level = entry.getIntValue();
            updatedIds.add(new PendingIdChange(id, mappedId, level));
        }
        for (PendingIdChange change : updatedIds) {
            enchantments.remove(change.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$get$id());
        }
        for (PendingIdChange change : updatedIds) {
            enchantments.add(change.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$get$mappedId(), change.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$get$level());
        }
    }

    private void backupInconvertibleData(Item item) {
        AttributeModifiers1_21 attributeModifiers;
        StructuredDataContainer data = item.dataContainer();
        data.setIdLookup(this.protocol, true);
        CompoundTag backupTag = new CompoundTag();
        JukeboxPlayable jukeboxPlayable = data.get(StructuredDataKey.JUKEBOX_PLAYABLE1_21);
        if (jukeboxPlayable != null) {
            CompoundTag tag = new CompoundTag();
            if (jukeboxPlayable.song().hasHolder()) {
                Holder<JukeboxPlayable.JukeboxSong> songHolder = jukeboxPlayable.song().holder();
                tag.put("song", this.holderToTag(songHolder, (song, songTag) -> {
                    this.saveSoundEventHolder((CompoundTag)songTag, song.soundEvent());
                    songTag.put("description", song.description());
                    songTag.putFloat("length_in_seconds", song.lengthInSeconds());
                    songTag.putInt("comparator_output", song.comparatorOutput());
                }));
            } else {
                tag.putString("song_identifier", jukeboxPlayable.song().key());
            }
            tag.putBoolean("show_in_tooltip", jukeboxPlayable.showInTooltip());
            backupTag.put("jukebox_playable", tag);
        }
        if ((attributeModifiers = data.get(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21)) != null) {
            ListTag<StringTag> attributeIds = new ListTag<StringTag>(StringTag.class);
            for (AttributeModifiers1_21.AttributeModifier modifier : attributeModifiers.modifiers()) {
                attributeIds.add(new StringTag(modifier.modifier().id()));
            }
            backupTag.put("attribute_modifiers", attributeIds);
        }
        if (!backupTag.isEmpty()) {
            this.saveTag(this.createCustomTag(item), backupTag, "inconvertible_data");
        }
    }

    private void restoreInconvertibleData(Item item) {
        Tag tag;
        StructuredDataContainer data = item.dataContainer();
        CompoundTag customData = data.get(StructuredDataKey.CUSTOM_DATA);
        if (customData == null || !((tag = customData.remove(this.nbtTagName("inconvertible_data"))) instanceof CompoundTag)) {
            return;
        }
        CompoundTag tag2 = (CompoundTag)tag;
        CompoundTag jukeboxPlayableTag = tag2.getCompoundTag("jukebox_playable");
        if (jukeboxPlayableTag != null) {
            String songIdentifier = tag2.getString("song_identifier");
            EitherHolder<JukeboxPlayable.JukeboxSong> song = songIdentifier != null ? EitherHolder.of(songIdentifier) : EitherHolder.of(this.restoreHolder(tag2, "song", songTag -> {
                Holder<SoundEvent> soundEvent = this.restoreSoundEventHolder((CompoundTag)songTag);
                Tag description = songTag.get("description");
                float lengthInSeconds = songTag.getFloat("length_in_seconds");
                int comparatorOutput = songTag.getInt("comparator_output");
                return new JukeboxPlayable.JukeboxSong(soundEvent, description, lengthInSeconds, comparatorOutput);
            }));
            JukeboxPlayable jukeboxPlayable = new JukeboxPlayable(song, tag2.getBoolean("show_in_tooltip"));
            data.set(StructuredDataKey.JUKEBOX_PLAYABLE1_21, jukeboxPlayable);
        }
        ListTag<StringTag> attributeIds = tag2.getListTag("attribute_modifiers", StringTag.class);
        AttributeModifiers1_21 attributeModifiers = data.get(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21);
        if (attributeIds != null && attributeModifiers != null && attributeIds.size() == attributeModifiers.modifiers().length) {
            for (int i2 = 0; i2 < attributeIds.size(); ++i2) {
                String id = attributeIds.get(i2).getValue();
                AttributeModifiers1_21.AttributeModifier modifier = attributeModifiers.modifiers()[i2];
                AttributeModifiers1_21.ModifierData updatedModifierData = new AttributeModifiers1_21.ModifierData(id, modifier.modifier().amount(), modifier.modifier().operation());
                attributeModifiers.modifiers()[i2] = new AttributeModifiers1_21.AttributeModifier(modifier.attribute(), updatedModifierData, modifier.slotType());
            }
        }
        this.removeCustomTag(data, customData);
    }

    @RecordComponents(value={@RecordComponents.Value(name="id", type=int.class), @RecordComponents.Value(name="mappedId", type=int.class), @RecordComponents.Value(name="level", type=int.class)})
    @NestHost(value=BlockItemPacketRewriter1_21.class)
    private static final class PendingIdChange
    extends J_L_Record {
        private final int id;
        private final int mappedId;
        private final int level;

        PendingIdChange(int id, int mappedId, int level) {
            this.id = id;
            this.mappedId = mappedId;
            this.level = level;
        }

        @Override
        public final String toString() {
            return PendingIdChange.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return PendingIdChange.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return PendingIdChange.jvmdowngrader$equals$equals(this, o2);
        }

        public int id() {
            return this.id;
        }

        public int mappedId() {
            return this.mappedId;
        }

        public int level() {
            return this.level;
        }

        private static String jvmdowngrader$toString$toString(PendingIdChange pendingIdChange) {
            PendingIdChange pendingIdChange2 = pendingIdChange;
            return "BlockItemPacketRewriter1_21$PendingIdChange[" + "id=" + pendingIdChange.id + ", " + "mappedId=" + pendingIdChange.mappedId + ", " + "level=" + pendingIdChange.level + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(PendingIdChange pendingIdChange) {
            Object[] objectArray = new Object[]{pendingIdChange.id, pendingIdChange.mappedId, pendingIdChange.level};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(PendingIdChange pendingIdChange, Object object) {
            if (pendingIdChange == object) {
                return true;
            }
            if (object != null && object instanceof PendingIdChange) {
                PendingIdChange pendingIdChange2 = (PendingIdChange)object;
                if (pendingIdChange.id == pendingIdChange2.id && pendingIdChange.mappedId == pendingIdChange2.mappedId && pendingIdChange.level == pendingIdChange2.level) {
                    return true;
                }
            }
            return false;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$get$id() {
            return this.id;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$set$id(int n2) {
            this.id = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$get$mappedId() {
            return this.mappedId;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$set$mappedId(int n2) {
            this.mappedId = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$get$level() {
            return this.level;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21to1_20_5_rewriter_BlockItemPacketRewriter1_21$PendingIdChange$set$level(int n2) {
            this.level = n2;
        }
    }
}

