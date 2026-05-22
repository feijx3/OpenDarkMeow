/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.data.MappedItem;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.CustomModelData1_21_4;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsStructuredItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends StructuredItemRewriter<C, S, T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];

    public BackwardsStructuredItemRewriter(T protocol) {
        super(protocol);
    }

    @Override
    protected void backupInconvertibleData(UserConnection connection, Item item, StructuredDataContainer dataContainer, CompoundTag backupTag) {
        MappedItem mappedItem;
        super.backupInconvertibleData(connection, item, dataContainer, backupTag);
        BackwardsMappingData mappingData = ((BackwardsProtocol)this.protocol).getMappingData();
        MappedItem mappedItem2 = mappedItem = mappingData != null ? mappingData.getMappedItem(item.identifier()) : null;
        if (mappedItem == null) {
            return;
        }
        CompoundTag customTag = this.createCustomTag(item);
        customTag.putInt(this.nbtTagName("id"), item.identifier());
        if (mappedItem.customModelData() != null) {
            if (connection.getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_4)) {
                if (!dataContainer.has(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4)) {
                    dataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, new CustomModelData1_21_4(new float[]{mappedItem.customModelData().floatValue()}, new boolean[0], new String[0], EMPTY_INT_ARRAY));
                }
            } else if (!dataContainer.has(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5)) {
                dataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, mappedItem.customModelData());
            }
        }
        if (!dataContainer.has(StructuredDataKey.CUSTOM_NAME)) {
            dataContainer.set(StructuredDataKey.CUSTOM_NAME, mappedItem.tagName());
            customTag.putBoolean(this.nbtTagName("added_custom_name"), true);
        }
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer container, CompoundTag customData) {
        super.restoreBackupData(item, container, customData);
        Tag tag = this.removeBackupTag(customData, "id");
        if (tag instanceof IntTag) {
            IntTag originalTag = (IntTag)tag;
            item.setIdentifier(originalTag.asInt());
            this.removeCustomTag(container, customData);
        }
    }

    protected void saveListTag(CompoundTag tag, ListTag<?> original, String name) {
        String backupName = this.nbtTagName(name);
        if (!tag.contains(backupName)) {
            tag.put(backupName, original.copy());
        }
    }

    public <T extends Tag> @Nullable ListTag<T> removeListTag(CompoundTag tag, String tagName, Class<T> tagType) {
        String backupName = this.nbtTagName(tagName);
        ListTag<T> data = tag.getListTag(backupName, tagType);
        if (data == null) {
            return null;
        }
        tag.remove(backupName);
        return data;
    }

    protected void saveGenericTagList(CompoundTag tag, List<Tag> original, String name) {
        String backupName = this.nbtTagName(name);
        if (!tag.contains(backupName)) {
            CompoundTag output = new CompoundTag();
            for (int i2 = 0; i2 < original.size(); ++i2) {
                output.put(Integer.toString(i2), original.get(i2));
            }
            tag.put(backupName, output);
        }
    }

    protected List<Tag> removeGenericTagList(CompoundTag tag, String name) {
        String backupName = this.nbtTagName(name);
        CompoundTag data = tag.getCompoundTag(backupName);
        if (data == null) {
            return null;
        }
        tag.remove(backupName);
        return new ArrayList<Tag>(data.values());
    }

    protected Tag holderSetToTag(HolderSet set) {
        if (set.hasIds()) {
            return new IntArrayTag(set.ids());
        }
        return new StringTag(set.tagKey());
    }

    protected HolderSet restoreHolderSet(CompoundTag tag, String key) {
        Tag savedTag = tag.get(key);
        if (savedTag == null) {
            return HolderSet.of(EMPTY_INT_ARRAY);
        }
        if (savedTag instanceof StringTag) {
            StringTag tagKey = (StringTag)savedTag;
            return HolderSet.of(tagKey.getValue());
        }
        if (savedTag instanceof IntArrayTag) {
            IntArrayTag idsTag = (IntArrayTag)savedTag;
            return HolderSet.of(idsTag.getValue());
        }
        return HolderSet.of(EMPTY_INT_ARRAY);
    }

    protected <V> Tag holderToTag(Holder<V> holder, BiConsumer<V, CompoundTag> valueSaveFunction) {
        if (holder.hasId()) {
            return new IntTag(holder.id());
        }
        CompoundTag savedTag = new CompoundTag();
        valueSaveFunction.accept(holder.value(), savedTag);
        return savedTag;
    }

    protected <V> Tag eitherHolderToTag(EitherHolder<V> holder, BiConsumer<V, CompoundTag> valueSaveFunction) {
        if (holder.hasKey()) {
            return new StringTag(holder.key());
        }
        return this.holderToTag(holder.holder(), valueSaveFunction);
    }

    protected <V> void saveEitherHolderData(StructuredDataKey<EitherHolder<V>> key, StructuredDataContainer data, CompoundTag backupTag, BiConsumer<V, CompoundTag> valueSaveFunction) {
        EitherHolder<V> holder = data.get(key);
        if (holder != null) {
            backupTag.put(key.identifier(), this.eitherHolderToTag(holder, valueSaveFunction));
        }
    }

    protected <V> void saveHolderData(StructuredDataKey<Holder<V>> key, StructuredDataContainer data, CompoundTag backupTag, BiConsumer<V, CompoundTag> valueSaveFunction) {
        Holder<V> holder = data.get(key);
        if (holder != null) {
            backupTag.put(key.identifier(), this.holderToTag(holder, valueSaveFunction));
        }
    }

    protected <V> Holder<V> restoreHolder(CompoundTag tag, String key, Function<CompoundTag, V> valueRestoreFunction) {
        Tag savedTag = tag.get(key);
        if (savedTag == null) {
            return Holder.of(false);
        }
        if (savedTag instanceof IntTag) {
            IntTag idTag = (IntTag)savedTag;
            return Holder.of(idTag.asInt());
        }
        if (savedTag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)savedTag;
            return Holder.of(valueRestoreFunction.apply(compoundTag));
        }
        return Holder.of(false);
    }

    protected <V> EitherHolder<V> restoreEitherHolder(CompoundTag tag, String key, Function<CompoundTag, V> valueRestoreFunction) {
        Tag savedTag = tag.get(key);
        if (savedTag == null) {
            return EitherHolder.of(Holder.of(false));
        }
        if (savedTag instanceof StringTag) {
            StringTag keyTag = (StringTag)savedTag;
            return EitherHolder.of(keyTag.getValue());
        }
        return EitherHolder.of(this.restoreHolder(tag, key, valueRestoreFunction));
    }

    protected <V> void restoreHolderData(StructuredDataKey<Holder<V>> key, StructuredDataContainer data, CompoundTag backupTag, Function<CompoundTag, V> valueRestoreFunction) {
        if (backupTag.contains(key.identifier())) {
            data.set(key, this.restoreHolder(backupTag, key.identifier(), valueRestoreFunction));
        }
    }

    protected void saveStringData(StructuredDataKey<String> key, StructuredDataContainer data, CompoundTag backupTag) {
        String value = data.get(key);
        if (value != null) {
            backupTag.putString(key.identifier(), value);
        }
    }

    protected void restoreStringData(StructuredDataKey<String> key, StructuredDataContainer data, CompoundTag backupTag) {
        String value = backupTag.getString(key.identifier());
        if (value != null) {
            data.set(key, value);
        }
    }

    protected void saveKeyData(StructuredDataKey<Key> key, StructuredDataContainer data, CompoundTag backupTag) {
        Key value = data.get(key);
        if (value != null) {
            backupTag.putString(key.identifier(), value.original());
        }
    }

    protected void restoreKeyData(StructuredDataKey<Key> key, StructuredDataContainer data, CompoundTag backupTag) {
        String value = backupTag.getString(key.identifier());
        if (value != null) {
            data.set(key, Key.of(value));
        }
    }

    protected void saveIntData(StructuredDataKey<Integer> key, StructuredDataContainer data, CompoundTag backupTag) {
        Integer variant = data.get(key);
        if (variant != null) {
            backupTag.putInt(key.identifier(), variant);
        }
    }

    protected void restoreIntData(StructuredDataKey<Integer> key, StructuredDataContainer data, CompoundTag backupTag) {
        IntTag variant = backupTag.getIntTag(key.identifier());
        if (variant != null) {
            data.set(key, variant.asInt());
        }
    }

    protected void saveFloatData(StructuredDataKey<Float> key, StructuredDataContainer data, CompoundTag backupTag) {
        Float variant = data.get(key);
        if (variant != null) {
            backupTag.putFloat(key.identifier(), variant.floatValue());
        }
    }

    protected void restoreFloatData(StructuredDataKey<Float> key, StructuredDataContainer data, CompoundTag backupTag) {
        FloatTag variant = backupTag.getFloatTag(key.identifier());
        if (variant != null) {
            data.set(key, Float.valueOf(variant.asFloat()));
        }
    }

    protected void saveSoundEventHolder(CompoundTag tag, Holder<SoundEvent> holder) {
        tag.put("sound_event", this.holderToTag(holder, this::saveSoundEvent));
    }

    protected void saveSoundEvent(SoundEvent soundEvent, CompoundTag tag) {
        tag.putString("identifier", soundEvent.identifier());
        if (soundEvent.fixedRange() != null) {
            tag.putFloat("fixed_range", soundEvent.fixedRange().floatValue());
        }
    }

    protected Holder<SoundEvent> restoreSoundEventHolder(CompoundTag tag) {
        return this.restoreHolder(tag, "sound_event", soundEventTag -> {
            String identifier = soundEventTag.getString("identifier");
            FloatTag fixedRange = soundEventTag.getFloatTag("fixed_range");
            return new SoundEvent(identifier, fixedRange != null ? Float.valueOf(fixedRange.asFloat()) : null);
        });
    }

    @Override
    public String nbtTagName() {
        return BackwardsStructuredItemRewriter.jvmdowngrader$concat$nbtTagName$1(((BackwardsProtocol)this.protocol).getClass().getSimpleName());
    }

    private static String jvmdowngrader$concat$nbtTagName$1(String string) {
        return "VB|" + string;
    }
}

