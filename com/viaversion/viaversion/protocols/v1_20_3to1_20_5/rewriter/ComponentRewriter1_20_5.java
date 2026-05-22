/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter;

import ViaVersion.xyz.wagyourtail.jvmdg.j11.stub.java_base.J_U_Collection;
import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrim;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPattern;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPatternLayer;
import com.viaversion.viaversion.api.minecraft.item.data.Bee;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.BlockStateProperties;
import com.viaversion.viaversion.api.minecraft.item.data.DyedColor;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.minecraft.item.data.Fireworks;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.LodestoneTracker;
import com.viaversion.viaversion.api.minecraft.item.data.PotDecorations;
import com.viaversion.viaversion.api.minecraft.item.data.PotionContents;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.minecraft.item.data.StatePropertyMatcher;
import com.viaversion.viaversion.api.minecraft.item.data.SuspiciousStewEffect;
import com.viaversion.viaversion.api.minecraft.item.data.ToolProperties;
import com.viaversion.viaversion.api.minecraft.item.data.ToolRule;
import com.viaversion.viaversion.api.minecraft.item.data.Unbreakable;
import com.viaversion.viaversion.api.minecraft.item.data.WritableBook;
import com.viaversion.viaversion.api.minecraft.item.data.WrittenBook;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.types.item.StructuredDataType;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.ArmorMaterials1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Attributes1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.BannerPatterns1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.DyeColors;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.EquipmentSlots1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Instruments1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.PotionEffects1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Potions1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.BlockItemPacketRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.Either;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import com.viaversion.viaversion.util.Unit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={ConverterPair.class, TagConverter.class, SimpleTagConverter.class, DataConverter.class, SimpleDataConverter.class})
public class ComponentRewriter1_20_5<C extends ClientboundPacketType>
extends JsonNBTComponentRewriter<C> {
    protected final Map<StructuredDataKey<?>, ConverterPair<?>> converters = new Reference2ObjectOpenHashMap();
    protected final StructuredDataType structuredDataType;

    public ComponentRewriter1_20_5(Protocol<C, ?, ?, ?> protocol, StructuredDataType structuredDataType) {
        super(protocol, ComponentRewriterBase.ReadType.NBT);
        this.structuredDataType = structuredDataType;
        this.register(StructuredDataKey.CUSTOM_DATA, this::customDataToTag, this::customDataFromTag);
        this.register(StructuredDataKey.MAX_STACK_SIZE, this::maxStackSizeToTag, this::maxStackSizeFromTag);
        this.register(StructuredDataKey.MAX_DAMAGE, this::maxDamageToTag, this::maxDamageFromTag);
        this.register(StructuredDataKey.DAMAGE, this::damageToTag, this::damageFromTag);
        this.register(StructuredDataKey.UNBREAKABLE1_20_5, this::unbreakableToTag, this::unbreakableFromTag);
        this.register(StructuredDataKey.CUSTOM_NAME, this::customNameToTag, this::customNameFromTag);
        this.register(StructuredDataKey.ITEM_NAME, this::itemNameToTag, this::itemNameFromTag);
        this.register(StructuredDataKey.LORE, this::loreToTag, this::loreFromTag);
        this.register(StructuredDataKey.RARITY, this::rarityToTag, this::rarityFromTag);
        this.register(StructuredDataKey.ENCHANTMENTS1_20_5, this::enchantmentsToTag, this::enchantmentsFromTag);
        this.register(StructuredDataKey.CAN_PLACE_ON1_20_5, this::canPlaceOnToTag, this::canPlaceOnFromTag);
        this.register(StructuredDataKey.CAN_BREAK1_20_5, this::canBreakToTag, this::canBreakFromTag);
        this.register(StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5, this::attributeModifiersToTag, this::attributeModifiersFromTag);
        this.register(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, this::customModelDataToTag, this::customModelDataFromTag);
        this.register(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP, this::hideAdditionalTooltipToTag, this::hideAdditionalTooltipFromTag);
        this.register(StructuredDataKey.HIDE_TOOLTIP, this::hideTooltipToTag, this::hideTooltipFromTag);
        this.register(StructuredDataKey.REPAIR_COST, this::repairCostToTag, this::repairCostFromTag);
        this.register(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, this::enchantmentGlintOverrideToTag, this::enchantmentGlintOverrideFromTag);
        this.registerEmpty(StructuredDataKey.CREATIVE_SLOT_LOCK);
        this.register(StructuredDataKey.INTANGIBLE_PROJECTILE, this::intangibleProjectileToTag, this::intangibleProjectileFromTag);
        this.register(StructuredDataKey.FOOD1_20_5, this::foodToTag, this::foodFromTag);
        this.register(StructuredDataKey.FIRE_RESISTANT, this::fireResistantToTag, this::fireResistantFromTag);
        this.register(StructuredDataKey.TOOL1_20_5, this::toolToTag, this::toolFromTag);
        this.register(StructuredDataKey.STORED_ENCHANTMENTS1_20_5, this::storedEnchantmentsToTag, this::storedEnchantmentsFromTag);
        this.register(StructuredDataKey.DYED_COLOR1_20_5, this::dyedColorToTag, this::dyedColorFromTag);
        this.register(StructuredDataKey.MAP_COLOR, this::mapColorToTag, this::mapColorFromTag);
        this.register(StructuredDataKey.MAP_ID, this::mapIdToTag, this::mapIdFromTag);
        this.register(StructuredDataKey.MAP_DECORATIONS, this::mapDecorationsToTag, this::mapDecorationsFromTag);
        this.registerEmpty(StructuredDataKey.MAP_POST_PROCESSING);
        this.register(StructuredDataKey.V1_20_5.chargedProjectiles, this::chargedProjectilesToTag, this::chargedProjectilesFromTag);
        this.register(StructuredDataKey.V1_20_5.bundleContents, this::bundleContentsToTag, this::bundleContentsFromTag);
        this.register(StructuredDataKey.POTION_CONTENTS1_20_5, this::potionContentsToTag, this::potionContentsFromTag);
        this.register(StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, this::suspiciousStewEffectsToTag, this::suspiciousStewEffectsFromTag);
        this.register(StructuredDataKey.WRITABLE_BOOK_CONTENT, this::writableBookContentToTag, this::writableBookContentFromTag);
        this.register(StructuredDataKey.WRITTEN_BOOK_CONTENT, this::writtenBookContentToTag, this::writtenBookContentFromTag);
        this.register(StructuredDataKey.TRIM1_20_5, this::trimToTag, this::trimFromTag);
        this.register(StructuredDataKey.DEBUG_STICK_STATE, this::debugStickRateToTag, this::debugStickRateFromTag);
        this.register(StructuredDataKey.ENTITY_DATA, this::entityDataToTag, this::entityDataFromTag);
        this.register(StructuredDataKey.BUCKET_ENTITY_DATA, this::bucketEntityDataToTag, this::bucketEntityDataFromTag);
        this.register(StructuredDataKey.BLOCK_ENTITY_DATA, this::blockEntityDataToTag, this::blockEntityDataFromTag);
        this.register(StructuredDataKey.INSTRUMENT1_20_5, this::instrumentToTag, this::instrumentFromTag);
        this.register(StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, this::ominousBottleAmplifierToTag, this::ominousBottleAmplifierFromTag);
        this.register(StructuredDataKey.RECIPES, this::recipesToTag, this::recipesFromTag);
        this.register(StructuredDataKey.LODESTONE_TRACKER, this::lodestoneTrackerToTag, this::lodestoneTrackerFromTag);
        this.register(StructuredDataKey.FIREWORK_EXPLOSION, this::fireworkExplosionToTag, this::fireworkExplosionFromTag);
        this.register(StructuredDataKey.FIREWORKS, this::fireworksToTag, this::fireworksFromTag);
        this.register(StructuredDataKey.PROFILE, this::profileToTag, this::profileFromTag);
        this.register(StructuredDataKey.NOTE_BLOCK_SOUND, this::noteBlockSoundToTag, this::noteBlockSoundFromTag);
        this.register(StructuredDataKey.BANNER_PATTERNS, this::bannerPatternsToTag, this::bannerPatternsFromTag);
        this.register(StructuredDataKey.BASE_COLOR, this::baseColorToTag, this::baseColorFromTag);
        this.register(StructuredDataKey.POT_DECORATIONS, this::potDecorationsToTag, this::potDecorationsFromTag);
        this.register(StructuredDataKey.V1_20_5.container, this::containerToTag, this::containerFromTag);
        this.register(StructuredDataKey.BLOCK_STATE, this::blockStateToTag, this::blockStateFromTag);
        this.register(StructuredDataKey.BEES, this::beesToTag, this::beesFromTag);
        this.register(StructuredDataKey.LOCK, this::lockToTag, this::lockFromTag);
        this.register(StructuredDataKey.CONTAINER_LOOT, this::containerLootToTag, this::containerLootFromTag);
    }

    @Override
    protected void handleHoverEvent(UserConnection connection, CompoundTag hoverEventTag) {
        super.handleHoverEvent(connection, hoverEventTag);
        StringTag actionTag = hoverEventTag.getStringTag("action");
        if (actionTag == null) {
            return;
        }
        if (actionTag.getValue().equals("show_entity")) {
            CompoundTag contentsTag = hoverEventTag.getCompoundTag("contents");
            if (contentsTag == null) {
                return;
            }
            if (this.protocol.getMappingData().getEntityMappings().mappedId(contentsTag.getString("type")) == -1) {
                contentsTag.put("type", new StringTag("pig"));
            }
        }
    }

    @Override
    protected void handleShowItem(UserConnection connection, CompoundTag itemTag, @Nullable CompoundTag componentsTag) {
        Item structuredItem;
        CompoundTag tagTag;
        super.handleShowItem(connection, itemTag, componentsTag);
        StringTag idTag = itemTag.getStringTag("id");
        if (idTag == null) {
            return;
        }
        int itemId = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().id(idTag.getValue());
        if (itemId == -1) {
            itemId = 1;
        }
        StringTag tag = (StringTag)itemTag.remove("tag");
        try {
            tagTag = tag != null ? (CompoundTag)this.inputSerializerVersion().toTag(tag.getValue()) : null;
        }
        catch (Exception e2) {
            if (!Via.getConfig().isSuppressTextComponentConversionWarnings()) {
                this.protocol.getLogger().log(Level.WARNING, ComponentRewriter1_20_5.jvmdowngrader$concat$handleShowItem$1(StringUtil.forLogging(itemTag)), e2);
            }
            return;
        }
        DataItem dataItem = new DataItem();
        dataItem.setIdentifier(itemId);
        if (tagTag != null) {
            dataItem.setTag(tagTag);
        }
        if ((structuredItem = this.protocol.getItemRewriter().handleItemToClient(connection, dataItem)).amount() < 1) {
            structuredItem.setAmount(1);
        }
        if (structuredItem.identifier() != 0) {
            String identifier = this.mappedIdentifier(structuredItem.identifier());
            if (identifier != null) {
                itemTag.putString("id", identifier);
            }
        } else {
            itemTag.putString("id", "minecraft:stone");
        }
        Map<StructuredDataKey<?>, StructuredData<?>> data = structuredItem.dataContainer().data();
        if (!data.isEmpty()) {
            CompoundTag components;
            try {
                components = this.toTag(connection, data);
            }
            catch (Exception e3) {
                if (!Via.getConfig().isSuppressTextComponentConversionWarnings()) {
                    this.protocol.getLogger().log(Level.WARNING, "Error writing components in show_item!", e3);
                }
                return;
            }
            itemTag.put("components", components);
        }
    }

    public CompoundTag toTag(UserConnection connection, Map<StructuredDataKey<?>, StructuredData<?>> data) {
        CompoundTag tag = new CompoundTag();
        for (Map.Entry<StructuredDataKey<?>, StructuredData<?>> entry : data.entrySet()) {
            StructuredDataKey<?> key = entry.getKey();
            String identifier = key.identifier();
            ConverterPair<?> converter = this.converters.get(key);
            if (converter == null) {
                Via.getPlatform().getLogger().severe(ComponentRewriter1_20_5.jvmdowngrader$concat$toTag$1(identifier));
                continue;
            }
            StructuredData<?> value = entry.getValue();
            if (value.isEmpty()) {
                tag.put(ComponentRewriter1_20_5.jvmdowngrader$concat$toTag$2(identifier), new CompoundTag());
                continue;
            }
            Tag valueTag = converter.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_3to1_20_5_rewriter_ComponentRewriter1_20_5$ConverterPair$get$dataConverter().convert(connection, value.value());
            if (valueTag == null) continue;
            tag.put(identifier, valueTag);
        }
        return tag;
    }

    public List<StructuredData<?>> toData(UserConnection connection, CompoundTag tag) {
        ArrayList list = new ArrayList();
        if (tag != null) {
            for (Map.Entry<String, Tag> entry : tag.entrySet()) {
                StructuredData<?> data = this.readFromTag(connection, entry.getKey(), entry.getValue());
                list.add(data);
            }
        }
        return list;
    }

    private StructuredData<?> readFromTag(UserConnection connection, String identifier, Tag tag) {
        int id;
        boolean removed = identifier.startsWith("!");
        if (removed) {
            identifier = identifier.substring(1);
        }
        Preconditions.checkArgument(((id = this.protocol.getMappingData().getDataComponentSerializerMappings().mappedId(identifier)) != -1 ? 1 : 0) != 0, (String)"Unknown data component: %s", (Object[])new Object[]{identifier});
        StructuredDataKey<?> key = this.structuredDataType.key(id);
        if (removed) {
            return StructuredData.empty(key, id);
        }
        return this.readFromTag(connection, key, id, tag);
    }

    protected <T> StructuredData<T> readFromTag(UserConnection connection, StructuredDataKey<T> key, int id, Tag tag) {
        TagConverter<T> converter = this.tagConverter(key);
        Preconditions.checkNotNull(converter, (String)"No converter found for: %s", (Object[])new Object[]{key});
        return StructuredData.of(key, converter.convert(connection, tag), id);
    }

    private String mappedIdentifier(int id) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedIdentifier(id);
    }

    private int mappedId(String identifier) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedId(identifier);
    }

    protected CompoundTag customDataToTag(CompoundTag value) {
        return value;
    }

    protected CompoundTag customDataFromTag(Tag value) {
        return (CompoundTag)value;
    }

    protected IntTag maxStackSizeToTag(Integer value) {
        return this.intRangeToTag(value, 1, 99);
    }

    protected Integer maxStackSizeFromTag(Tag value) {
        return this.checkIntRange(1, 99, this.asInt(value));
    }

    protected IntTag maxDamageToTag(Integer value) {
        return this.positiveIntToTag(value);
    }

    protected Integer maxDamageFromTag(Tag value) {
        return this.checkPositiveInt(this.asInt(value));
    }

    protected IntTag damageToTag(Integer value) {
        return this.nonNegativeIntToTag(value);
    }

    protected Integer damageFromTag(Tag value) {
        return this.checkNonNegativeInt(this.asInt(value));
    }

    protected CompoundTag unbreakableToTag(Unbreakable value) {
        CompoundTag tag = new CompoundTag();
        if (!value.showInTooltip()) {
            tag.putBoolean("show_in_tooltip", false);
        }
        return tag;
    }

    protected Unbreakable unbreakableFromTag(Tag tag) {
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            return new Unbreakable(compoundTag.getBoolean("show_in_tooltip", true));
        }
        return null;
    }

    protected StringTag customNameToTag(Tag value) {
        return this.componentToTag(value);
    }

    protected Tag customNameFromTag(Tag value) {
        return this.componentFromTag(value);
    }

    protected StringTag itemNameToTag(Tag value) {
        return this.componentToTag(value);
    }

    protected Tag itemNameFromTag(Tag value) {
        return this.componentFromTag(value);
    }

    protected ListTag<StringTag> loreToTag(Tag[] value) {
        return this.componentsToTag(value, 256);
    }

    protected Tag[] loreFromTag(Tag value) {
        return this.componentsFromTag(value, 256);
    }

    protected StringTag rarityToTag(Integer value) {
        return this.enumEntryToTag(value, "common", "uncommon", "rare", "epic");
    }

    protected Integer rarityFromTag(Tag value) {
        if (value instanceof StringTag) {
            StringTag stringTag = (StringTag)value;
            return this.enumEntryFromTag(stringTag, "common", "uncommon", "rare", "epic");
        }
        return null;
    }

    protected CompoundTag enchantmentsToTag(Enchantments value) {
        CompoundTag tag = new CompoundTag();
        CompoundTag levels = new CompoundTag();
        for (Int2IntMap.Entry entry : value.enchantments().int2IntEntrySet()) {
            int level = this.checkIntRange(0, 255, entry.getIntValue());
            levels.putInt(Enchantments1_20_5.idToKey(entry.getIntKey()), level);
        }
        tag.put("levels", levels);
        if (!value.showInTooltip()) {
            tag.putBoolean("show_in_tooltip", false);
        }
        return tag;
    }

    protected Enchantments enchantmentsFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        Int2IntOpenHashMap enchantments = new Int2IntOpenHashMap();
        CompoundTag levels = compoundTag.getCompoundTag("levels");
        if (levels == null) {
            return null;
        }
        for (Map.Entry<String, Tag> level : levels) {
            int id = Enchantments1_20_5.keyToId(level.getKey());
            if (id == -1) continue;
            enchantments.put(id, this.checkIntRange(0, 255, this.asInt(level.getValue())));
        }
        return new Enchantments(enchantments, compoundTag.getBoolean("show_in_tooltip", true));
    }

    protected CompoundTag canPlaceOnToTag(AdventureModePredicate value) {
        return this.blockPredicateToTag(value);
    }

    protected CompoundTag canBreakToTag(AdventureModePredicate value) {
        return this.blockPredicateToTag(value);
    }

    protected CompoundTag blockPredicateToTag(AdventureModePredicate value) {
        CompoundTag tag = new CompoundTag();
        ListTag<CompoundTag> predicates = new ListTag<CompoundTag>(CompoundTag.class);
        for (BlockPredicate predicate : value.predicates()) {
            CompoundTag predicateTag = new CompoundTag();
            if (predicate.holderSet() != null) {
                this.holderSetToTag(predicateTag, "blocks", predicate.holderSet());
            }
            if (predicate.propertyMatchers() != null) {
                predicateTag.put("state", this.createState(predicate));
            }
            if (predicate.tag() != null) {
                predicateTag.put("nbt", predicate.tag());
            }
            predicates.add(predicateTag);
        }
        tag.put("predicates", predicates);
        if (!value.showInTooltip()) {
            tag.putBoolean("show_in_tooltip", false);
        }
        return tag;
    }

    protected AdventureModePredicate canPlaceOnFromTag(Tag tag) {
        return this.blockPredicateFromTag(tag);
    }

    protected AdventureModePredicate canBreakFromTag(Tag tag) {
        return this.blockPredicateFromTag(tag);
    }

    protected AdventureModePredicate blockPredicateFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        boolean showInTooltip = value.getBoolean("show_in_tooltip", true);
        ListTag<CompoundTag> predicates = value.getListTag("predicates", CompoundTag.class);
        ArrayList<BlockPredicate> list = new ArrayList<BlockPredicate>();
        if (predicates != null) {
            for (CompoundTag predicateTag : predicates) {
                HolderSet holderSet = this.holderSetFromTag(predicateTag, "blocks");
                StatePropertyMatcher[] state = this.fromState(predicateTag.getCompoundTag("state"));
                list.add(new BlockPredicate(holderSet, state, predicateTag.getCompoundTag("nbt")));
            }
        }
        return new AdventureModePredicate((BlockPredicate[])J_U_Collection.toArray(list, BlockPredicate[]::new), showInTooltip);
    }

    protected CompoundTag createState(BlockPredicate predicate) {
        CompoundTag state = new CompoundTag();
        for (StatePropertyMatcher matcher : predicate.propertyMatchers()) {
            Either<String, StatePropertyMatcher.RangedMatcher> match = matcher.matcher();
            if (match.isLeft()) {
                state.putString(matcher.name(), match.left());
                continue;
            }
            StatePropertyMatcher.RangedMatcher range = match.right();
            CompoundTag rangeTag = new CompoundTag();
            if (range.minValue() != null) {
                rangeTag.putString("min", range.minValue());
            }
            if (range.maxValue() != null) {
                rangeTag.putString("max", range.maxValue());
            }
            state.put(matcher.name(), rangeTag);
        }
        return state;
    }

    protected StatePropertyMatcher @Nullable [] fromState(CompoundTag value) {
        if (value == null) {
            return null;
        }
        ArrayList<StatePropertyMatcher> list = new ArrayList<StatePropertyMatcher>();
        for (Map.Entry<String, Tag> entry : value.entrySet()) {
            String name = entry.getKey();
            Tag tag = entry.getValue();
            if (tag instanceof StringTag) {
                StringTag stringTag = (StringTag)tag;
                list.add(new StatePropertyMatcher(name, Either.left(stringTag.getValue())));
                continue;
            }
            if (!(tag instanceof CompoundTag)) continue;
            CompoundTag compoundTag = (CompoundTag)tag;
            String min = compoundTag.getString("min");
            String max = compoundTag.getString("max");
            list.add(new StatePropertyMatcher(name, Either.right(new StatePropertyMatcher.RangedMatcher(min, max))));
        }
        return (StatePropertyMatcher[])J_U_Collection.toArray(list, StatePropertyMatcher[]::new);
    }

    protected CompoundTag attributeModifiersToTag(AttributeModifiers1_20_5 value) {
        CompoundTag tag = new CompoundTag();
        ListTag<CompoundTag> modifiers = new ListTag<CompoundTag>(CompoundTag.class);
        for (AttributeModifiers1_20_5.AttributeModifier modifier : value.modifiers()) {
            CompoundTag modifierTag = new CompoundTag();
            String type = Attributes1_20_5.idToKey(modifier.attribute());
            if (type == null) {
                throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$attributeModifiersToTag$1(modifier.attribute()));
            }
            modifierTag.putString("type", type);
            this.modifierDataToTag(modifierTag, modifier.modifier());
            if (modifier.slotType() != 0) {
                String slotType = EquipmentSlots1_20_5.idToKey(modifier.slotType());
                Preconditions.checkNotNull((Object)slotType, (String)"Unknown slot type %s", (Object[])new Object[]{modifier.slotType()});
                modifierTag.putString("slot", slotType);
            }
            modifiers.add(modifierTag);
        }
        tag.put("modifiers", modifiers);
        if (!value.showInTooltip()) {
            tag.putBoolean("show_in_tooltip", false);
        }
        return tag;
    }

    protected AttributeModifiers1_20_5 attributeModifiersFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        boolean showInTooltip = value.getBoolean("show_in_tooltip", true);
        ListTag<CompoundTag> modifiers = value.getListTag("modifiers", CompoundTag.class);
        ArrayList<AttributeModifiers1_20_5.AttributeModifier> list = new ArrayList<AttributeModifiers1_20_5.AttributeModifier>();
        if (modifiers != null) {
            for (CompoundTag modifierTag : modifiers) {
                int type = Attributes1_20_5.keyToId(modifierTag.getString("type"));
                AttributeModifiers1_20_5.ModifierData modifier = this.modifierDataFromTag(modifierTag);
                int slotType = EquipmentSlots1_20_5.keyToId(modifierTag.getString("slot", "any"));
                list.add(new AttributeModifiers1_20_5.AttributeModifier(type, modifier, slotType));
            }
        }
        return new AttributeModifiers1_20_5((AttributeModifiers1_20_5.AttributeModifier[])J_U_Collection.toArray(list, AttributeModifiers1_20_5.AttributeModifier[]::new), showInTooltip);
    }

    protected IntTag customModelDataToTag(Integer value) {
        return new IntTag(value);
    }

    protected Integer customModelDataFromTag(Tag value) {
        return this.asInt(value);
    }

    protected CompoundTag hideAdditionalTooltipToTag(Unit value) {
        return this.unitToTag();
    }

    protected Unit hideAdditionalTooltipFromTag(Tag value) {
        return Unit.INSTANCE;
    }

    protected CompoundTag hideTooltipToTag(Unit value) {
        return this.unitToTag();
    }

    protected Unit hideTooltipFromTag(Tag value) {
        return Unit.INSTANCE;
    }

    protected IntTag repairCostToTag(Integer value) {
        return this.intRangeToTag(value, 0, Integer.MAX_VALUE);
    }

    protected Integer repairCostFromTag(Tag value) {
        return this.checkIntRange(0, Integer.MAX_VALUE, this.asInt(value));
    }

    protected ByteTag enchantmentGlintOverrideToTag(Boolean value) {
        return new ByteTag(value);
    }

    protected Boolean enchantmentGlintOverrideFromTag(Tag value) {
        return this.asBoolean(value);
    }

    protected CompoundTag intangibleProjectileToTag(Tag value) {
        return this.unitToTag();
    }

    protected Tag intangibleProjectileFromTag(Tag value) {
        return value;
    }

    protected CompoundTag foodToTag(FoodProperties1_20_5 value) {
        CompoundTag tag = new CompoundTag();
        tag.put("nutrition", this.nonNegativeIntToTag(value.nutrition()));
        tag.putFloat("saturation", value.saturationModifier());
        if (value.canAlwaysEat()) {
            tag.putBoolean("can_always_eat", true);
        }
        if (value.eatSeconds() != 1.6f) {
            tag.put("eat_seconds", this.positiveFloatToTag(Float.valueOf(value.eatSeconds())));
        }
        if (value.possibleEffects().length > 0) {
            ListTag<CompoundTag> effects = new ListTag<CompoundTag>(CompoundTag.class);
            for (FoodProperties1_20_5.FoodEffect foodEffect : value.possibleEffects()) {
                CompoundTag effectTag = new CompoundTag();
                CompoundTag potionEffectTag = new CompoundTag();
                this.potionEffectToTag(potionEffectTag, foodEffect.effect());
                effectTag.put("effect", potionEffectTag);
                if (foodEffect.probability() == 1.0f) continue;
                effectTag.putFloat("probability", foodEffect.probability());
            }
            tag.put("effects", effects);
        }
        return tag;
    }

    protected FoodProperties1_20_5 foodFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        int nutrition = this.checkNonNegativeInt(value.getInt("nutrition"));
        float saturation = value.getFloat("saturation");
        boolean canAlwaysEat = value.getBoolean("can_always_eat", false);
        float eatSeconds = this.checkPositiveFloat(Float.valueOf(value.getFloat("eat_seconds", 1.6f))).floatValue();
        ListTag<CompoundTag> effects = value.getListTag("effects", CompoundTag.class);
        ArrayList<FoodProperties1_20_5.FoodEffect> list = new ArrayList<FoodProperties1_20_5.FoodEffect>();
        if (effects != null) {
            for (CompoundTag effectTag : effects) {
                PotionEffect effect = this.potionEffectFromTag(effectTag.getCompoundTag("effect"));
                float probability = effectTag.getFloat("probability", 1.0f);
                list.add(new FoodProperties1_20_5.FoodEffect(effect, probability));
            }
        }
        return new FoodProperties1_20_5(nutrition, saturation, canAlwaysEat, eatSeconds, null, (FoodProperties1_20_5.FoodEffect[])J_U_Collection.toArray(list, FoodProperties1_20_5.FoodEffect[]::new));
    }

    protected CompoundTag fireResistantToTag(Unit value) {
        return this.unitToTag();
    }

    protected Unit fireResistantFromTag(Tag value) {
        return Unit.INSTANCE;
    }

    protected CompoundTag toolToTag(ToolProperties value) {
        CompoundTag tag = new CompoundTag();
        ListTag<CompoundTag> rules = new ListTag<CompoundTag>(CompoundTag.class);
        for (ToolRule rule : value.rules()) {
            CompoundTag ruleTag = new CompoundTag();
            this.holderSetToTag(ruleTag, "blocks", rule.blocks());
            if (rule.speed() != null) {
                ruleTag.putFloat("speed", rule.speed().floatValue());
            }
            if (rule.correctForDrops() != null) {
                ruleTag.putBoolean("correct_for_drops", rule.correctForDrops());
            }
            rules.add(ruleTag);
        }
        tag.put("rules", rules);
        if (value.defaultMiningSpeed() != 1.0f) {
            tag.putFloat("default_mining_speed", value.defaultMiningSpeed());
        }
        if (value.damagePerBlock() != 1) {
            tag.put("damage_per_block", this.nonNegativeIntToTag(value.damagePerBlock()));
        }
        return tag;
    }

    protected ToolProperties toolFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        ListTag<CompoundTag> rules = value.getListTag("rules", CompoundTag.class);
        ArrayList<ToolRule> list = new ArrayList<ToolRule>();
        if (rules != null) {
            for (CompoundTag ruleTag : rules) {
                HolderSet blocks = this.holderSetFromTag(ruleTag, "blocks");
                Float speed = Float.valueOf(ruleTag.getFloat("speed", 0.0f));
                Boolean correctForDrops = ruleTag.getBoolean("correct_for_drops", false);
                list.add(new ToolRule(blocks, speed, correctForDrops));
            }
        }
        float defaultMiningSpeed = value.getFloat("default_mining_speed", 1.0f);
        int damagePerBlock = this.checkNonNegativeInt(value.getInt("damage_per_block", 1));
        return new ToolProperties((ToolRule[])J_U_Collection.toArray(list, ToolRule[]::new), defaultMiningSpeed, damagePerBlock);
    }

    protected CompoundTag storedEnchantmentsToTag(Enchantments value) {
        return this.enchantmentsToTag(value);
    }

    protected Enchantments storedEnchantmentsFromTag(Tag tag) {
        return this.enchantmentsFromTag(tag);
    }

    protected CompoundTag dyedColorToTag(DyedColor value) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("rgb", value.rgb());
        if (!value.showInTooltip()) {
            tag.putBoolean("show_in_tooltip", false);
        }
        return tag;
    }

    protected DyedColor dyedColorFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        int rgb = value.getInt("rgb");
        boolean showInTooltip = value.getBoolean("show_in_tooltip", true);
        return new DyedColor(rgb, showInTooltip);
    }

    protected IntTag mapColorToTag(Integer value) {
        return new IntTag(value);
    }

    protected Integer mapColorFromTag(Tag tag) {
        return this.asInt(tag);
    }

    protected IntTag mapIdToTag(Integer value) {
        return new IntTag(value);
    }

    protected Integer mapIdFromTag(Tag tag) {
        return this.asInt(tag);
    }

    protected CompoundTag mapDecorationsToTag(CompoundTag value) {
        return value;
    }

    protected CompoundTag mapDecorationsFromTag(Tag tag) {
        return (CompoundTag)tag;
    }

    protected ListTag<CompoundTag> chargedProjectilesToTag(UserConnection connection, Item[] value) {
        return this.itemArrayToTag(connection, value);
    }

    protected Item[] chargedProjectilesFromTag(UserConnection connection, Tag tag) {
        ListTag value = (ListTag)tag;
        return this.itemArrayFromTag(connection, value);
    }

    protected ListTag<CompoundTag> bundleContentsToTag(UserConnection connection, Item[] value) {
        return this.itemArrayToTag(connection, value);
    }

    protected Item[] bundleContentsFromTag(UserConnection connection, Tag tag) {
        ListTag value = (ListTag)tag;
        return this.itemArrayFromTag(connection, value);
    }

    protected CompoundTag potionContentsToTag(PotionContents value) {
        String potion;
        CompoundTag tag = new CompoundTag();
        if (value.potion() != null && (potion = Potions1_20_5.idToKey(value.potion())) != null) {
            tag.putString("potion", potion);
        }
        if (value.customColor() != null) {
            tag.putInt("custom_color", value.customColor());
        }
        ListTag<CompoundTag> customEffects = new ListTag<CompoundTag>(CompoundTag.class);
        for (PotionEffect effect : value.customEffects()) {
            CompoundTag effectTag = new CompoundTag();
            this.potionEffectToTag(effectTag, effect);
            customEffects.add(effectTag);
        }
        tag.put("custom_effects", customEffects);
        if (value.customName() != null) {
            tag.putString("custom_name", value.customName());
        }
        tag.put("custom_effects", customEffects);
        return tag;
    }

    protected PotionContents potionContentsFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        int potion = Potions1_20_5.keyToId(value.getString("potion", ""));
        IntTag customColor = value.getIntTag("custom_color");
        ListTag<CompoundTag> customEffects = value.getListTag("custom_effects", CompoundTag.class);
        ArrayList<PotionEffect> list = new ArrayList<PotionEffect>();
        if (customEffects != null) {
            for (CompoundTag effectTag : customEffects) {
                list.add(this.potionEffectFromTag(effectTag));
            }
        }
        return new PotionContents(potion != -1 ? Integer.valueOf(potion) : null, customColor != null ? Integer.valueOf(customColor.asInt()) : null, (PotionEffect[])J_U_Collection.toArray(list, PotionEffect[]::new));
    }

    protected ListTag<CompoundTag> suspiciousStewEffectsToTag(SuspiciousStewEffect[] value) {
        ListTag<CompoundTag> tag = new ListTag<CompoundTag>(CompoundTag.class);
        for (SuspiciousStewEffect effect : value) {
            CompoundTag effectTag = new CompoundTag();
            String id = PotionEffects1_20_5.idToKey(effect.mobEffect());
            if (id != null) {
                effectTag.putString("id", id);
            }
            if (effect.duration() != 160) {
                effectTag.putInt("duration", effect.duration());
            }
            tag.add(effectTag);
        }
        return tag;
    }

    protected SuspiciousStewEffect[] suspiciousStewEffectsFromTag(Tag tag) {
        ListTag value = (ListTag)tag;
        ArrayList<SuspiciousStewEffect> list = new ArrayList<SuspiciousStewEffect>();
        for (CompoundTag effectTag : value) {
            int id = PotionEffects1_20_5.keyToId(effectTag.getString("id", ""));
            int duration = effectTag.getInt("duration", 160);
            list.add(new SuspiciousStewEffect(id, duration));
        }
        return (SuspiciousStewEffect[])J_U_Collection.toArray(list, SuspiciousStewEffect[]::new);
    }

    protected CompoundTag writableBookContentToTag(WritableBook value) {
        CompoundTag tag = new CompoundTag();
        if (value == null) {
            return tag;
        }
        if (value.pages().length > 100) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$writableBookContentToTag$1(value.pages().length));
        }
        ListTag<CompoundTag> pagesTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (FilterableString page : value.pages()) {
            CompoundTag pageTag = new CompoundTag();
            this.filterableStringToTag(pageTag, page, 1024);
            pagesTag.add(pageTag);
        }
        tag.put("pages", pagesTag);
        return tag;
    }

    protected WritableBook writableBookContentFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        ListTag<CompoundTag> pagesTag = value.getListTag("pages", CompoundTag.class);
        if (pagesTag == null) {
            return null;
        }
        FilterableString[] pages = new FilterableString[pagesTag.size()];
        for (int i2 = 0; i2 < pagesTag.size(); ++i2) {
            pages[i2] = this.filterableStringFromTag(pagesTag.get(i2));
        }
        return new WritableBook(pages);
    }

    protected CompoundTag writtenBookContentToTag(WrittenBook value) {
        CompoundTag tag = new CompoundTag();
        CompoundTag title = new CompoundTag();
        this.filterableStringToTag(title, value.title(), 32);
        tag.put("title", title);
        tag.putString("author", value.author());
        if (value.generation() != 0) {
            tag.put("generation", this.intRangeToTag(value.generation(), 0, 3));
        }
        ListTag<CompoundTag> pagesTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (FilterableComponent page : value.pages()) {
            CompoundTag pageTag = new CompoundTag();
            this.filterableComponentToTag(pageTag, page);
            pagesTag.add(pageTag);
        }
        if (!pagesTag.isEmpty()) {
            tag.put("pages", pagesTag);
        }
        if (value.resolved()) {
            tag.putBoolean("resolved", true);
        }
        return tag;
    }

    protected WrittenBook writtenBookContentFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        FilterableString title = this.filterableStringFromTag(value.getCompoundTag("title"));
        String author = value.getString("author");
        int generation = this.checkIntRange(0, 3, value.getInt("generation", 0));
        ListTag<CompoundTag> pagesTag = value.getListTag("pages", CompoundTag.class);
        ArrayList<FilterableComponent> pages = new ArrayList<FilterableComponent>();
        if (pagesTag != null) {
            for (CompoundTag pageTag : pagesTag) {
                pages.add(this.filterableComponentFromTag(pageTag));
            }
        }
        boolean resolved = value.getBoolean("resolved", false);
        return new WrittenBook(title, author, generation, (FilterableComponent[])J_U_Collection.toArray(pages, FilterableComponent[]::new), resolved);
    }

    protected CompoundTag trimToTag(UserConnection connection, ArmorTrim value) {
        CompoundTag tag = new CompoundTag();
        Holder<ArmorTrimMaterial> material = value.material();
        ArmorTrimStorage trimStorage = connection.get(ArmorTrimStorage.class);
        if (material.hasId()) {
            String trimMaterial = trimStorage.trimMaterials().idToKey(material.id());
            tag.putString("material", trimMaterial);
        } else {
            ArmorTrimMaterial armorTrimMaterial = material.value();
            CompoundTag materialTag = new CompoundTag();
            String ingredient = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().identifier(armorTrimMaterial.itemId());
            if (ingredient == null) {
                throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$trimToTag$1(armorTrimMaterial.itemId()));
            }
            CompoundTag overrideArmorMaterialsTag = new CompoundTag();
            for (Map.Entry<String, String> entry : armorTrimMaterial.overrideArmorMaterials().entrySet()) {
                String materialKey = ArmorMaterials1_20_5.idToKey(Integer.parseInt(entry.getKey()));
                if (materialKey == null) continue;
                overrideArmorMaterialsTag.putString(materialKey, entry.getValue());
            }
            materialTag.putString("asset_name", armorTrimMaterial.assetName());
            materialTag.putString("ingredient", ingredient);
            materialTag.putFloat("item_model_index", armorTrimMaterial.itemModelIndex());
            materialTag.put("override_armor_materials", overrideArmorMaterialsTag);
            materialTag.put("description", armorTrimMaterial.description());
            tag.put("material", materialTag);
        }
        Holder<ArmorTrimPattern> pattern = value.pattern();
        if (pattern.hasId()) {
            tag.putString("pattern", trimStorage.trimPatterns().idToKey(pattern.id()));
        } else {
            ArmorTrimPattern armorTrimPattern = pattern.value();
            CompoundTag patternTag = new CompoundTag();
            String templateItem = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().identifier(armorTrimPattern.itemId());
            if (templateItem == null) {
                throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$trimToTag$1(armorTrimPattern.itemId()));
            }
            patternTag.put("asset_id", this.identifierToTag(armorTrimPattern.assetName()));
            patternTag.putString("template_item", templateItem);
            patternTag.put("description", armorTrimPattern.description());
            if (armorTrimPattern.decal()) {
                patternTag.putBoolean("decal", true);
            }
            tag.put("pattern", patternTag);
        }
        if (!value.showInTooltip()) {
            tag.putBoolean("show_in_tooltip", false);
        }
        return tag;
    }

    protected ArmorTrim trimFromTag(UserConnection connection, Tag tag) {
        Holder<Object> pattern;
        Holder<Object> material;
        CompoundTag value = (CompoundTag)tag;
        Tag materialTag = value.get("material");
        ArmorTrimStorage trimStorage = connection.get(ArmorTrimStorage.class);
        if (materialTag instanceof StringTag) {
            StringTag stringTag = (StringTag)materialTag;
            material = Holder.of(trimStorage.trimMaterials().keyToId(stringTag.getValue()));
        } else {
            CompoundTag materialValue = (CompoundTag)materialTag;
            String assetName = this.identifierFromTag(materialValue.getStringTag("asset_name"));
            int ingredient = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedId(materialValue.getString("ingredient"));
            float itemModelIndex = materialValue.getFloat("item_model_index");
            HashMap<String, String> overrideArmorMaterials = new HashMap<String, String>();
            CompoundTag overrideArmorMaterialsTag = materialValue.getCompoundTag("override_armor_materials");
            if (overrideArmorMaterialsTag != null) {
                for (Map.Entry<String, Tag> entry : overrideArmorMaterialsTag.entrySet()) {
                    overrideArmorMaterials.put(entry.getKey(), ((StringTag)entry.getValue()).getValue());
                }
            }
            Tag description = materialValue.get("description");
            material = Holder.of(new ArmorTrimMaterial(assetName, ingredient, itemModelIndex, overrideArmorMaterials, description));
        }
        Tag patternTag = value.get("pattern");
        if (patternTag instanceof StringTag) {
            StringTag stringTag = (StringTag)patternTag;
            pattern = Holder.of(trimStorage.trimPatterns().keyToId(stringTag.getValue()));
        } else {
            CompoundTag patternValue = (CompoundTag)patternTag;
            String assetName = this.identifierFromTag(patternValue.getStringTag("asset_id"));
            int templateItem = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedId(patternValue.getString("template_item"));
            Tag description = patternValue.get("description");
            boolean decal = patternValue.getBoolean("decal", false);
            pattern = Holder.of(new ArmorTrimPattern(assetName, templateItem, description, decal));
        }
        boolean showInTooltip = value.getBoolean("show_in_tooltip", true);
        return new ArmorTrim(material, pattern, showInTooltip);
    }

    protected CompoundTag debugStickRateToTag(CompoundTag value) {
        return value;
    }

    protected CompoundTag debugStickRateFromTag(Tag value) {
        return (CompoundTag)value;
    }

    protected CompoundTag entityDataToTag(CompoundTag value) {
        return this.nbtWithIdToTag(value);
    }

    protected CompoundTag entityDataFromTag(Tag value) {
        return (CompoundTag)value;
    }

    protected CompoundTag bucketEntityDataToTag(CompoundTag value) {
        return this.nbtToTag(value);
    }

    protected CompoundTag bucketEntityDataFromTag(Tag value) {
        return (CompoundTag)value;
    }

    protected CompoundTag blockEntityDataToTag(CompoundTag value) {
        return this.nbtWithIdToTag(value);
    }

    protected CompoundTag blockEntityDataFromTag(Tag value) {
        return (CompoundTag)value;
    }

    protected Tag instrumentToTag(Holder<Instrument1_20_5> value) {
        if (value.hasId()) {
            return new StringTag(Instruments1_20_3.idToKey(value.id()));
        }
        Instrument1_20_5 instrument = value.value();
        CompoundTag tag = new CompoundTag();
        Holder<SoundEvent> sound = instrument.soundEvent();
        if (sound.hasId()) {
            tag.putString("sound_event", Protocol1_20_3To1_20_5.MAPPINGS.soundName(sound.id()));
        } else {
            SoundEvent soundEvent = sound.value();
            CompoundTag soundEventTag = new CompoundTag();
            soundEventTag.put("sound_id", this.identifierToTag(soundEvent.identifier()));
            if (soundEvent.fixedRange() != null) {
                soundEventTag.putFloat("range", soundEvent.fixedRange().floatValue());
            }
            tag.put("sound_event", soundEventTag);
        }
        tag.put("use_duration", this.positiveIntToTag(instrument.useDuration()));
        tag.put("range", this.positiveFloatToTag(Float.valueOf(instrument.range())));
        return tag;
    }

    protected Holder<Instrument1_20_5> instrumentFromTag(Tag tag) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return Holder.of(Instruments1_20_3.keyToId(stringTag.getValue()));
        }
        CompoundTag value = (CompoundTag)tag;
        Holder<Object> soundEvent = null;
        Tag soundEventTag = value.get("sound_event");
        if (soundEventTag instanceof StringTag) {
            StringTag stringTag = (StringTag)soundEventTag;
            soundEvent = Holder.of(Protocol1_20_3To1_20_5.MAPPINGS.soundId(stringTag.getValue()));
        } else if (soundEventTag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)soundEventTag;
            String soundId = this.identifierFromTag(compoundTag.getStringTag("sound_id"));
            Float range = Float.valueOf(compoundTag.getFloat("range", 0.0f));
            soundEvent = Holder.of(new SoundEvent(soundId, range));
        }
        int useDuration = this.checkPositiveInt(value.getInt("use_duration"));
        float range = this.checkPositiveFloat(Float.valueOf(value.getFloat("range"))).floatValue();
        return Holder.of(new Instrument1_20_5(soundEvent, useDuration, range));
    }

    protected IntTag ominousBottleAmplifierToTag(Integer value) {
        return this.intRangeToTag(value, 0, 4);
    }

    protected Integer ominousBottleAmplifierFromTag(Tag value) {
        return this.checkIntRange(0, 4, this.asInt(value));
    }

    protected Tag recipesToTag(Tag value) {
        return value;
    }

    protected Tag recipesFromTag(Tag value) {
        return value;
    }

    protected CompoundTag lodestoneTrackerToTag(LodestoneTracker value) {
        CompoundTag tag = new CompoundTag();
        if (value.position() != null) {
            this.globalPosToTag(tag, value.position());
        }
        if (!value.tracked()) {
            tag.putBoolean("tracked", false);
        }
        return tag;
    }

    protected LodestoneTracker lodestoneTrackerFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        GlobalBlockPosition position = this.globalPosFromTag(value);
        boolean tracked = value.getBoolean("tracked", true);
        return new LodestoneTracker(position, tracked);
    }

    protected CompoundTag fireworkExplosionToTag(FireworkExplosion value) {
        CompoundTag tag = new CompoundTag();
        tag.put("shape", this.enumEntryToTag(value.shape(), "small_ball", "large_ball", "star", "creeper", "burst"));
        if (value.colors().length > 0) {
            tag.put("colors", new IntArrayTag(value.colors()));
        }
        if (value.fadeColors().length > 0) {
            tag.put("fade_colors", new IntArrayTag(value.fadeColors()));
        }
        if (value.hasTrail()) {
            tag.putBoolean("trail", true);
        }
        if (value.hasTwinkle()) {
            tag.putBoolean("twinkle", true);
        }
        return tag;
    }

    protected FireworkExplosion fireworkExplosionFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        int shape = this.enumEntryFromTag(value.getStringTag("shape"), "small_ball", "large_ball", "star", "creeper", "burst");
        IntArrayTag colors = value.getIntArrayTag("colors");
        IntArrayTag fadeColors = value.getIntArrayTag("fade_colors");
        boolean trail = value.getBoolean("trail", false);
        boolean twinkle = value.getBoolean("twinkle", false);
        return new FireworkExplosion(shape, colors == null ? new int[]{} : colors.getValue(), fadeColors == null ? new int[]{} : fadeColors.getValue(), trail, twinkle);
    }

    protected CompoundTag fireworksToTag(Fireworks value) {
        CompoundTag tag = new CompoundTag();
        if (value.flightDuration() != 0) {
            tag.put("flight_duration", this.unsignedByteToTag((byte)value.flightDuration()));
        }
        ListTag<CompoundTag> explosions = new ListTag<CompoundTag>(CompoundTag.class);
        if (value.explosions().length > 256) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$fireworksToTag$1(value.explosions().length));
        }
        for (FireworkExplosion explosion : value.explosions()) {
            explosions.add(this.fireworkExplosionToTag(explosion));
        }
        tag.put("explosions", explosions);
        return tag;
    }

    protected Fireworks fireworksFromTag(Tag value) {
        CompoundTag tag = (CompoundTag)value;
        short flightDuration = tag.getShort("flight_duration");
        ListTag<CompoundTag> explosions = tag.getListTag("explosions", CompoundTag.class);
        FireworkExplosion[] list = new FireworkExplosion[explosions != null ? explosions.size() : 0];
        for (int i2 = 0; i2 < list.length; ++i2) {
            list[i2] = this.fireworkExplosionFromTag(explosions.get(i2));
        }
        return new Fireworks(flightDuration, list);
    }

    protected CompoundTag profileToTag(GameProfile value) {
        CompoundTag tag = new CompoundTag();
        if (value.name() != null) {
            tag.putString("name", value.name());
        }
        if (value.id() != null) {
            tag.put("id", new IntArrayTag(UUIDUtil.toIntArray(value.id())));
        }
        if (value.properties().length > 0) {
            this.propertiesToTag(tag, value.properties());
        }
        return tag;
    }

    protected GameProfile profileFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        String name = value.getString("name");
        IntArrayTag idTag = value.getIntArrayTag("id");
        UUID id = idTag == null ? null : UUIDUtil.fromIntArray(idTag.getValue());
        GameProfile.Property[] properties = this.propertiesFromTag(value);
        return new GameProfile(name, id, properties);
    }

    protected StringTag noteBlockSoundToTag(Key value) {
        return new StringTag(value.original());
    }

    protected Key noteBlockSoundFromTag(Tag value) {
        return Key.of(((StringTag)value).getValue());
    }

    protected ListTag<CompoundTag> bannerPatternsToTag(BannerPatternLayer[] value) {
        ListTag<CompoundTag> tag = new ListTag<CompoundTag>(CompoundTag.class);
        for (BannerPatternLayer layer : value) {
            CompoundTag layerTag = new CompoundTag();
            this.bannerPatternToTag(layerTag, layer.pattern());
            layerTag.put("color", this.dyeColorToTag(layer.dyeColor()));
            tag.add(layerTag);
        }
        return tag;
    }

    protected BannerPatternLayer[] bannerPatternsFromTag(Tag tag) {
        ListTag value = (ListTag)tag;
        BannerPatternLayer[] layers = new BannerPatternLayer[value.size()];
        for (int i2 = 0; i2 < value.size(); ++i2) {
            CompoundTag layerTag = (CompoundTag)value.get(i2);
            Holder<BannerPattern> pattern = this.bannerPatternFromTag(layerTag.get("pattern"));
            int color = this.dyeColorFromTag(layerTag.get("color"));
            layers[i2] = new BannerPatternLayer(pattern, color);
        }
        return layers;
    }

    protected StringTag baseColorToTag(Integer value) {
        return this.dyeColorToTag(value);
    }

    protected Integer baseColorFromTag(Tag tag) {
        return this.dyeColorFromTag(tag);
    }

    protected ListTag<StringTag> potDecorationsToTag(PotDecorations value) {
        ListTag<StringTag> tag = new ListTag<StringTag>(StringTag.class);
        for (int decoration : value.itemIds()) {
            String identifier = this.mappedIdentifier(decoration);
            if (identifier == null) {
                throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$trimToTag$1(decoration));
            }
            tag.add(new StringTag(identifier));
        }
        return tag;
    }

    protected PotDecorations potDecorationsFromTag(Tag tag) {
        ListTag value = (ListTag)tag;
        int[] itemIds = new int[value.size()];
        for (int i2 = 0; i2 < value.size(); ++i2) {
            String identifier = ((StringTag)value.get(i2)).getValue();
            int id = this.mappedId(identifier);
            if (id == -1) {
                throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$potDecorationsFromTag$1(identifier));
            }
            itemIds[i2] = id;
        }
        return new PotDecorations(itemIds);
    }

    protected ListTag<CompoundTag> containerToTag(UserConnection connection, Item[] value) {
        ListTag<CompoundTag> tag = new ListTag<CompoundTag>(CompoundTag.class);
        for (int i2 = 0; i2 < value.length; ++i2) {
            Item item = value[i2];
            if (item.isEmpty()) continue;
            CompoundTag slotTag = new CompoundTag();
            CompoundTag itemTag = new CompoundTag();
            this.itemToTag(connection, itemTag, item);
            slotTag.putInt("slot", i2);
            slotTag.put("item", itemTag);
            tag.add(slotTag);
        }
        return tag;
    }

    protected Item[] containerFromTag(UserConnection connection, Tag tag) {
        int slot;
        Item item;
        ListTag value = (ListTag)tag;
        int highestSlot = 0;
        int size = Math.min(value.size(), 256);
        for (int i2 = 0; i2 < size; ++i2) {
            CompoundTag itemTag = (CompoundTag)value.get(i2);
            item = this.itemFromTag(connection, itemTag);
            if (item.isEmpty()) continue;
            slot = itemTag.getInt("slot");
            highestSlot = MathUtil.clamp(slot, highestSlot, 255);
        }
        Item[] filteredItems = new Item[highestSlot + 1];
        for (CompoundTag itemTag : value) {
            item = this.itemFromTag(connection, itemTag.getCompoundTag("item"));
            if (item.isEmpty() || (slot = itemTag.getInt("slot")) < 0 || slot >= filteredItems.length) continue;
            filteredItems[slot] = item;
        }
        return filteredItems;
    }

    protected CompoundTag blockStateToTag(BlockStateProperties value) {
        CompoundTag tag = new CompoundTag();
        for (Map.Entry<String, String> entry : value.properties().entrySet()) {
            tag.putString(entry.getKey(), entry.getValue());
        }
        return tag;
    }

    protected BlockStateProperties blockStateFromTag(Tag tag) {
        CompoundTag value = (CompoundTag)tag;
        HashMap<String, String> properties = new HashMap<String, String>();
        for (Map.Entry<String, Tag> entry : value.entrySet()) {
            properties.put(entry.getKey(), ((StringTag)entry.getValue()).getValue());
        }
        return new BlockStateProperties(properties);
    }

    protected ListTag<CompoundTag> beesToTag(Bee[] value) {
        ListTag<CompoundTag> tag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Bee bee : value) {
            CompoundTag beeTag = new CompoundTag();
            if (!bee.entityData().isEmpty()) {
                beeTag.put("entity_data", this.nbtToTag(bee.entityData()));
            }
            beeTag.putInt("ticks_in_hive", bee.ticksInHive());
            beeTag.putInt("min_ticks_in_hive", bee.minTicksInHive());
        }
        return tag;
    }

    protected Bee[] beesFromTag(Tag tag) {
        ListTag value = (ListTag)tag;
        Bee[] bees = new Bee[value.size()];
        for (int i2 = 0; i2 < value.size(); ++i2) {
            CompoundTag beeTag = (CompoundTag)value.get(i2);
            CompoundTag entityData = beeTag.getCompoundTag("entity_data");
            int ticksInHive = beeTag.getInt("ticks_in_hive");
            int minTicksInHive = beeTag.getInt("min_ticks_in_hive");
            bees[i2] = new Bee(entityData != null ? entityData : new CompoundTag(), ticksInHive, minTicksInHive);
        }
        return bees;
    }

    protected StringTag lockToTag(Tag value) {
        return (StringTag)value;
    }

    protected Tag lockFromTag(Tag value) {
        return value;
    }

    protected CompoundTag containerLootToTag(CompoundTag value) {
        return value;
    }

    protected CompoundTag containerLootFromTag(Tag value) {
        return (CompoundTag)value;
    }

    protected void modifierDataToTag(CompoundTag tag, AttributeModifiers1_20_5.ModifierData data) {
        tag.put("uuid", new IntArrayTag(UUIDUtil.toIntArray(data.uuid())));
        tag.putString("name", data.name());
        tag.putDouble("amount", data.amount());
        tag.putString("operation", BlockItemPacketRewriter1_20_5.ATTRIBUTE_OPERATIONS[data.operation()]);
    }

    protected AttributeModifiers1_20_5.ModifierData modifierDataFromTag(CompoundTag tag) {
        int operation;
        UUID uuid = UUIDUtil.fromIntArray(tag.getIntArrayTag("uuid").getValue());
        String name = tag.getString("name");
        double amount = tag.getDouble("amount");
        String operationName = tag.getString("operation");
        for (operation = 0; operation < BlockItemPacketRewriter1_20_5.ATTRIBUTE_OPERATIONS.length && !BlockItemPacketRewriter1_20_5.ATTRIBUTE_OPERATIONS[operation].equals(operationName); ++operation) {
        }
        return new AttributeModifiers1_20_5.ModifierData(uuid, name, amount, operation);
    }

    protected void potionEffectToTag(CompoundTag tag, PotionEffect effect) {
        String id = PotionEffects1_20_5.idToKey(effect.effect());
        if (id == null) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$potionEffectToTag$1(effect.effect()));
        }
        tag.putString("id", id);
        this.potionEffectDataToTag(tag, effect.effectData());
    }

    protected PotionEffect potionEffectFromTag(CompoundTag tag) {
        int id = PotionEffects1_20_5.keyToId(tag.getString("id"));
        if (id == -1) {
            return null;
        }
        PotionEffectData data = this.potionEffectDataFromTag(tag);
        return new PotionEffect(id, data);
    }

    protected void potionEffectDataToTag(CompoundTag tag, PotionEffectData data) {
        if (data.amplifier() != 0) {
            tag.putInt("amplifier", data.amplifier());
        }
        if (data.duration() != 0) {
            tag.putInt("duration", data.duration());
        }
        if (data.ambient()) {
            tag.putBoolean("ambient", true);
        }
        if (!data.showParticles()) {
            tag.putBoolean("show_particles", false);
        }
        tag.putBoolean("show_icon", data.showIcon());
        if (data.hiddenEffect() != null) {
            CompoundTag hiddenEffect = new CompoundTag();
            this.potionEffectDataToTag(hiddenEffect, data.hiddenEffect());
            tag.put("hidden_effect", hiddenEffect);
        }
    }

    protected PotionEffectData potionEffectDataFromTag(CompoundTag tag) {
        int amplifier = tag.getInt("amplifier", 0);
        int duration = tag.getInt("duration", 0);
        boolean ambient = tag.getBoolean("ambient", false);
        boolean showParticles = tag.getBoolean("show_particles", true);
        boolean showIcon = tag.getBoolean("show_icon", true);
        CompoundTag hiddenEffectTag = tag.getCompoundTag("hidden_effect");
        PotionEffectData hiddenEffect = hiddenEffectTag != null ? this.potionEffectDataFromTag(hiddenEffectTag) : null;
        return new PotionEffectData(amplifier, duration, ambient, showParticles, showIcon, hiddenEffect);
    }

    protected void holderSetToTag(CompoundTag tag, String name, HolderSet set) {
        if (set.hasTagKey()) {
            tag.putString(name, set.tagKey());
        } else {
            ListTag<StringTag> identifiers = new ListTag<StringTag>(StringTag.class);
            for (int id : set.ids()) {
                String identifier = Protocol1_20_3To1_20_5.MAPPINGS.blockName(id);
                if (identifier == null) continue;
                identifiers.add(new StringTag(identifier));
            }
            tag.put(name, identifiers);
        }
    }

    protected HolderSet holderSetFromTag(CompoundTag tag, String name) {
        Tag value = tag.get(name);
        if (value instanceof StringTag) {
            StringTag stringTag = (StringTag)value;
            return HolderSet.of(stringTag.getValue());
        }
        if (value instanceof ListTag) {
            ListTag listTag;
            ListTag identifiers = listTag = (ListTag)value;
            int[] ids = new int[identifiers.size()];
            for (int i2 = 0; i2 < identifiers.size(); ++i2) {
                String identifier = ((StringTag)identifiers.get(i2)).getValue();
                int id = Protocol1_20_3To1_20_5.MAPPINGS.blockId(identifier);
                if (id == -1) continue;
                ids[i2] = id;
            }
            return HolderSet.of(ids);
        }
        return null;
    }

    protected ListTag<CompoundTag> itemArrayToTag(UserConnection connection, Item[] value) {
        ListTag<CompoundTag> tag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Item item : value) {
            CompoundTag itemTag = new CompoundTag();
            this.itemToTag(connection, itemTag, item);
            tag.add(itemTag);
        }
        return tag;
    }

    protected Item[] itemArrayFromTag(UserConnection connection, ListTag<CompoundTag> tag) {
        Item[] items = new Item[tag.size()];
        for (int i2 = 0; i2 < tag.size(); ++i2) {
            items[i2] = this.itemFromTag(connection, tag.get(i2));
        }
        return items;
    }

    protected void itemToTag(UserConnection connection, CompoundTag tag, Item item) {
        String identifier = this.mappedIdentifier(item.identifier());
        if (identifier == null) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$trimToTag$1(item.identifier()));
        }
        tag.putString("id", identifier);
        try {
            tag.put("count", this.positiveIntToTag(item.amount()));
        }
        catch (IllegalArgumentException ignored) {
            tag.putInt("count", 1);
        }
        Map<StructuredDataKey<?>, StructuredData<?>> components = item.dataContainer().data();
        CompoundTag componentsTag = this.toTag(connection, components);
        if (!componentsTag.isEmpty()) {
            tag.put("components", componentsTag);
        }
    }

    protected Item itemFromTag(UserConnection connection, CompoundTag tag) {
        int id = this.mappedId(tag.getString("id", ""));
        int amount = this.checkPositiveInt(tag.getInt("count", 1));
        List<StructuredData<?>> components = this.toData(connection, tag.getCompoundTag("components"));
        return new StructuredItem(id, amount, new StructuredDataContainer(J_U_Collection.toArray(components, StructuredData[]::new)));
    }

    protected void filterableStringToTag(CompoundTag tag, FilterableString string, int max) {
        tag.put("raw", this.stringToTag((String)string.raw(), 0, max));
        if (string.filtered() != null) {
            tag.put("filtered", this.stringToTag((String)string.filtered(), 0, max));
        }
    }

    protected FilterableString filterableStringFromTag(CompoundTag tag) {
        if (tag == null) {
            return null;
        }
        String raw = this.checkStringRange(0, 1024, tag.getString("raw"));
        StringTag filteredTag = tag.getStringTag("filtered");
        if (filteredTag == null) {
            return new FilterableString(raw, null);
        }
        return new FilterableString(raw, this.checkStringRange(0, 1024, filteredTag.getValue()));
    }

    protected void filterableComponentToTag(CompoundTag tag, FilterableComponent component) {
        tag.put("raw", this.componentToTag((Tag)component.raw()));
        if (component.filtered() != null) {
            tag.put("filtered", this.componentToTag((Tag)component.filtered()));
        }
    }

    protected FilterableComponent filterableComponentFromTag(CompoundTag tag) {
        if (tag == null) {
            return null;
        }
        Tag raw = this.componentFromTag(tag.get("raw"));
        Tag filtered = this.componentFromTag(tag.get("filtered"));
        return new FilterableComponent(raw, filtered);
    }

    protected void globalPosToTag(CompoundTag tag, GlobalBlockPosition position) {
        CompoundTag posTag = new CompoundTag();
        posTag.putString("dimension", position.dimension());
        posTag.put("pos", new IntArrayTag(new int[]{position.x(), position.y(), position.z()}));
        tag.put("target", posTag);
    }

    protected GlobalBlockPosition globalPosFromTag(CompoundTag tag) {
        CompoundTag posTag = tag.getCompoundTag("target");
        if (posTag == null) {
            return null;
        }
        String dimension = posTag.getString("dimension");
        int[] pos = posTag.getIntArrayTag("pos").getValue();
        return new GlobalBlockPosition(dimension, pos[0], pos[1], pos[2]);
    }

    protected void propertiesToTag(CompoundTag tag, GameProfile.Property[] properties) {
        ListTag<CompoundTag> propertiesTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (GameProfile.Property property : properties) {
            CompoundTag propertyTag = new CompoundTag();
            propertyTag.putString("name", property.name());
            propertyTag.putString("value", property.value());
            if (property.signature() != null) {
                propertyTag.putString("signature", property.signature());
            }
            propertiesTag.add(propertyTag);
        }
        tag.put("properties", propertiesTag);
    }

    protected GameProfile.Property[] propertiesFromTag(CompoundTag tag) {
        ListTag<CompoundTag> propertiesTag = tag.getListTag("properties", CompoundTag.class);
        if (propertiesTag == null) {
            return new GameProfile.Property[0];
        }
        GameProfile.Property[] properties = new GameProfile.Property[propertiesTag.size()];
        for (int i2 = 0; i2 < propertiesTag.size(); ++i2) {
            CompoundTag propertyTag = propertiesTag.get(i2);
            String name = propertyTag.getString("name");
            String value = propertyTag.getString("value");
            String signature = propertyTag.getString("signature", null);
            properties[i2] = new GameProfile.Property(name, value, signature);
        }
        return properties;
    }

    protected void bannerPatternToTag(CompoundTag tag, Holder<BannerPattern> pattern) {
        if (pattern.hasId()) {
            tag.putString("pattern", BannerPatterns1_20_5.idToKey(pattern.id()));
            return;
        }
        BannerPattern bannerPattern = pattern.value();
        CompoundTag patternTag = new CompoundTag();
        patternTag.put("asset_id", this.identifierToTag(bannerPattern.assetId()));
        patternTag.putString("translation_key", bannerPattern.translationKey());
        tag.put("pattern", patternTag);
    }

    protected Holder<BannerPattern> bannerPatternFromTag(Tag tag) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return Holder.of(BannerPatterns1_20_5.keyToId(stringTag.getValue()));
        }
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            String assetId = this.identifierFromTag(compoundTag.getStringTag("asset_id"));
            String translationKey = compoundTag.getString("translation_key");
            return Holder.of(new BannerPattern(assetId, translationKey));
        }
        return null;
    }

    protected Integer asInt(Tag tag) {
        return ((NumberTag)tag).asInt();
    }

    protected Boolean asBoolean(Tag tag) {
        return ((ByteTag)tag).asByte() != 0;
    }

    protected Short asUnsignedByte(Tag tag) {
        return ((ByteTag)tag).asShort();
    }

    protected IntTag positiveIntToTag(Integer value) {
        return this.intRangeToTag(value, 1, Integer.MAX_VALUE);
    }

    protected Integer checkPositiveInt(Integer value) {
        return this.checkIntRange(1, Integer.MAX_VALUE, value);
    }

    protected IntTag nonNegativeIntToTag(Integer value) {
        return this.intRangeToTag(value, 0, Integer.MAX_VALUE);
    }

    protected Integer checkNonNegativeInt(Integer value) {
        return this.checkIntRange(0, Integer.MAX_VALUE, value);
    }

    protected IntTag intRangeToTag(Integer value, int min, int max) {
        return new IntTag(this.checkIntRange(min, max, value));
    }

    protected FloatTag positiveFloatToTag(Float value) {
        return this.floatRangeToTag(value, 0.0f, Float.MAX_VALUE);
    }

    protected FloatTag floatRangeToTag(Float value, float min, float max) {
        return new FloatTag(this.checkFloatRange(min, max, value.floatValue()));
    }

    protected Float checkPositiveFloat(Float value) {
        return Float.valueOf(this.checkFloatRange(0.0f, Float.MAX_VALUE, value.floatValue()));
    }

    protected StringTag stringToTag(String value, int min, int max) {
        return new StringTag(this.checkStringRange(min, max, value));
    }

    protected ByteTag unsignedByteToTag(byte value) {
        if (value > 255) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$unsignedByteToTag$1(value));
        }
        return new ByteTag(value);
    }

    protected StringTag componentToTag(Tag value) {
        return this.componentToTag(value, Integer.MAX_VALUE);
    }

    protected Tag componentFromTag(Tag value) {
        return this.componentFromTag(value, Integer.MAX_VALUE);
    }

    protected StringTag componentToTag(Tag value, int max) {
        String json = this.outputSerializerVersion().toString(this.outputSerializerVersion().toComponent(value));
        return new StringTag(this.checkStringRange(0, max, json));
    }

    protected Tag componentFromTag(Tag value, int max) {
        if (value instanceof StringTag) {
            StringTag stringTag = (StringTag)value;
            String input = this.checkStringRange(0, max, stringTag.getValue());
            return this.inputSerializerVersion().toTag(this.inputSerializerVersion().toComponent(input));
        }
        return null;
    }

    protected ListTag<StringTag> componentsToTag(Tag[] value, int maxLength) {
        this.checkIntRange(0, maxLength, value.length);
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        for (Tag tag : value) {
            String json = this.outputSerializerVersion().toString(this.outputSerializerVersion().toComponent(tag));
            listTag.add(new StringTag(json));
        }
        return listTag;
    }

    protected Tag[] componentsFromTag(Tag value, int maxLength) {
        ListTag listTag = (ListTag)value;
        this.checkIntRange(0, maxLength, listTag.size());
        Tag[] components = new Tag[listTag.size()];
        for (int i2 = 0; i2 < listTag.size(); ++i2) {
            components[i2] = this.inputSerializerVersion().toTag(this.inputSerializerVersion().toComponent(((StringTag)listTag.get(i2)).getValue()));
        }
        return components;
    }

    protected StringTag enumEntryToTag(Integer value, String ... values) {
        Preconditions.checkArgument((value >= 0 && value < values.length ? 1 : 0) != 0, (Object)ComponentRewriter1_20_5.jvmdowngrader$concat$enumEntryToTag$1(value));
        return new StringTag(values[value]);
    }

    protected Integer enumEntryFromTag(StringTag value, String ... values) {
        String string = value.getValue();
        for (int i2 = 0; i2 < values.length; ++i2) {
            if (!values[i2].equals(string)) continue;
            return i2;
        }
        throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$enumEntryFromTag$1(string));
    }

    protected CompoundTag unitToTag() {
        return new CompoundTag();
    }

    protected CompoundTag nbtToTag(CompoundTag tag) {
        return tag;
    }

    protected CompoundTag nbtWithIdToTag(CompoundTag tag) {
        if (tag.getStringTag("id") == null) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$nbtWithIdToTag$1(String.valueOf(tag)));
        }
        return tag;
    }

    protected StringTag identifierToTag(String value) {
        if (!Key.isValid(value)) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$identifierToTag$1(value));
        }
        return new StringTag(value);
    }

    protected String identifierFromTag(StringTag tag) {
        String value = tag.getValue();
        if (!Key.isValid(value)) {
            throw new IllegalArgumentException(ComponentRewriter1_20_5.jvmdowngrader$concat$identifierToTag$1(value));
        }
        return value;
    }

    protected StringTag dyeColorToTag(Integer value) {
        return new StringTag(DyeColors.idToKey(value));
    }

    protected Integer dyeColorFromTag(Tag tag) {
        return DyeColors.keyToId(((StringTag)tag).getValue());
    }

    protected int checkIntRange(int min, int max, int value) {
        Preconditions.checkArgument((value >= min && value <= max ? 1 : 0) != 0, (Object)ComponentRewriter1_20_5.jvmdowngrader$concat$checkIntRange$1(value));
        return value;
    }

    protected float checkFloatRange(float min, float max, float value) {
        Preconditions.checkArgument((value >= min && value <= max ? 1 : 0) != 0, (Object)ComponentRewriter1_20_5.jvmdowngrader$concat$checkFloatRange$1(value));
        return value;
    }

    protected String checkStringRange(int min, int max, String value) {
        int length = value.length();
        Preconditions.checkArgument((length >= min && length <= max ? 1 : 0) != 0, (Object)ComponentRewriter1_20_5.jvmdowngrader$concat$checkStringRange$1(value));
        return value;
    }

    protected <T> void registerEmpty(StructuredDataKey<T> key) {
        this.converters.put(key, new ConverterPair(null, null));
    }

    protected <T> void register(StructuredDataKey<T> key, SimpleDataConverter<T> dataConverter, SimpleTagConverter<T> tagConverter) {
        DataConverter<Object> converter = ($, value) -> dataConverter.convert(value);
        this.converters.put(key, new ConverterPair<Object>(converter, (connection, tag) -> tagConverter.convert(tag)));
    }

    protected <T> void register(StructuredDataKey<T> key, DataConverter<T> dataConverter, TagConverter<T> tagConverter) {
        this.converters.put(key, new ConverterPair<T>(dataConverter, tagConverter));
    }

    protected <T> @Nullable DataConverter<T> dataConverter(StructuredDataKey<T> key) {
        ConverterPair<?> converters = this.converters.get(key);
        return converters != null ? converters.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_3to1_20_5_rewriter_ComponentRewriter1_20_5$ConverterPair$get$dataConverter() : null;
    }

    protected <T> @Nullable TagConverter<T> tagConverter(StructuredDataKey<T> key) {
        ConverterPair<?> converters = this.converters.get(key);
        return converters != null ? converters.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_3to1_20_5_rewriter_ComponentRewriter1_20_5$ConverterPair$get$tagConverter() : null;
    }

    @Override
    protected @Nullable SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_3;
    }

    @Override
    protected @Nullable SerializerVersion outputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }

    private static String jvmdowngrader$concat$handleShowItem$1(String string) {
        return "Error reading NBT in show_item: " + string;
    }

    private static String jvmdowngrader$concat$toTag$1(String string) {
        return "No converter found for data component: " + string;
    }

    private static String jvmdowngrader$concat$toTag$2(String string) {
        return "!" + string;
    }

    private static String jvmdowngrader$concat$attributeModifiersToTag$1(int n2) {
        return "Unknown attribute type: " + n2;
    }

    private static String jvmdowngrader$concat$writableBookContentToTag$1(int n2) {
        return "Too many pages: " + n2;
    }

    private static String jvmdowngrader$concat$trimToTag$1(int n2) {
        return "Unknown item: " + n2;
    }

    private static String jvmdowngrader$concat$fireworksToTag$1(int n2) {
        return "Too many explosions: " + n2;
    }

    private static String jvmdowngrader$concat$potDecorationsFromTag$1(String string) {
        return "Unknown item: " + string;
    }

    private static String jvmdowngrader$concat$potionEffectToTag$1(int n2) {
        return "Unknown potion effect: " + n2;
    }

    private static String jvmdowngrader$concat$unsignedByteToTag$1(byte by2) {
        return "Value out of range: " + by2;
    }

    private static String jvmdowngrader$concat$enumEntryToTag$1(Integer n2) {
        return "Enum value out of range: " + n2;
    }

    private static String jvmdowngrader$concat$enumEntryFromTag$1(String string) {
        return "Unknown enum value: " + string;
    }

    private static String jvmdowngrader$concat$nbtWithIdToTag$1(String string) {
        return "Missing id tag in nbt: " + string;
    }

    private static String jvmdowngrader$concat$identifierToTag$1(String string) {
        return "Invalid identifier: " + string;
    }

    private static String jvmdowngrader$concat$checkIntRange$1(int n2) {
        return "Value out of range: " + n2;
    }

    private static String jvmdowngrader$concat$checkFloatRange$1(float f2) {
        return "Value out of range: " + f2;
    }

    private static String jvmdowngrader$concat$checkStringRange$1(String string) {
        return "Value out of range: " + string;
    }

    @FunctionalInterface
    @NestHost(value=ComponentRewriter1_20_5.class)
    protected static interface SimpleDataConverter<T> {
        public Tag convert(T var1);
    }

    @FunctionalInterface
    @NestHost(value=ComponentRewriter1_20_5.class)
    protected static interface SimpleTagConverter<T> {
        public T convert(Tag var1);
    }

    @FunctionalInterface
    @NestHost(value=ComponentRewriter1_20_5.class)
    protected static interface DataConverter<T> {
        public Tag convert(UserConnection var1, T var2);
    }

    @FunctionalInterface
    @NestHost(value=ComponentRewriter1_20_5.class)
    protected static interface TagConverter<T> {
        public T convert(UserConnection var1, Tag var2);
    }

    @RecordComponents(value={@RecordComponents.Value(name="dataConverter", type=DataConverter.class), @RecordComponents.Value(name="tagConverter", type=TagConverter.class)})
    @NestHost(value=ComponentRewriter1_20_5.class)
    protected static final class ConverterPair<T>
    extends J_L_Record {
        private final DataConverter<T> dataConverter;
        private final TagConverter<T> tagConverter;

        protected ConverterPair(DataConverter<T> dataConverter, TagConverter<T> tagConverter) {
            this.dataConverter = dataConverter;
            this.tagConverter = tagConverter;
        }

        @Override
        public final String toString() {
            return ConverterPair.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ConverterPair.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ConverterPair.jvmdowngrader$equals$equals(this, o2);
        }

        public DataConverter<T> dataConverter() {
            return this.dataConverter;
        }

        public TagConverter<T> tagConverter() {
            return this.tagConverter;
        }

        private static String jvmdowngrader$toString$toString(ConverterPair converterPair) {
            ConverterPair converterPair2 = converterPair;
            return "ComponentRewriter1_20_5$ConverterPair[" + "dataConverter=" + converterPair.dataConverter + ", " + "tagConverter=" + converterPair.tagConverter + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ConverterPair converterPair) {
            Object[] objectArray = new Object[]{converterPair.dataConverter, converterPair.tagConverter};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ConverterPair converterPair, Object object) {
            if (converterPair == object) {
                return true;
            }
            if (object != null && object instanceof ConverterPair) {
                ConverterPair converterPair2 = (ConverterPair)object;
                if (Objects.equals(converterPair.dataConverter, converterPair2.dataConverter) && Objects.equals(converterPair.tagConverter, converterPair2.tagConverter)) {
                    return true;
                }
            }
            return false;
        }

        public DataConverter jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_3to1_20_5_rewriter_ComponentRewriter1_20_5$ConverterPair$get$dataConverter() {
            return this.dataConverter;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_3to1_20_5_rewriter_ComponentRewriter1_20_5$ConverterPair$set$dataConverter(DataConverter dataConverter) {
            this.dataConverter = dataConverter;
        }

        public TagConverter jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_3to1_20_5_rewriter_ComponentRewriter1_20_5$ConverterPair$get$tagConverter() {
            return this.tagConverter;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20_3to1_20_5_rewriter_ComponentRewriter1_20_5$ConverterPair$set$tagConverter(TagConverter tagConverter) {
            this.tagConverter = tagConverter;
        }
    }
}

