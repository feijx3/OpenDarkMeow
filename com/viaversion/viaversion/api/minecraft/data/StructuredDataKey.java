/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.PaintingVariant;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_20_5;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_2;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_5;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrim;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPatternLayer;
import com.viaversion.viaversion.api.minecraft.item.data.Bee;
import com.viaversion.viaversion.api.minecraft.item.data.BlockStateProperties;
import com.viaversion.viaversion.api.minecraft.item.data.BlocksAttacks;
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.CustomModelData1_21_4;
import com.viaversion.viaversion.api.minecraft.item.data.DamageResistant;
import com.viaversion.viaversion.api.minecraft.item.data.DeathProtection;
import com.viaversion.viaversion.api.minecraft.item.data.DyedColor;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantable;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.minecraft.item.data.Equippable;
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.minecraft.item.data.Fireworks;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.JukeboxPlayable;
import com.viaversion.viaversion.api.minecraft.item.data.LodestoneTracker;
import com.viaversion.viaversion.api.minecraft.item.data.PotDecorations;
import com.viaversion.viaversion.api.minecraft.item.data.PotionContents;
import com.viaversion.viaversion.api.minecraft.item.data.ProvidesTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.SuspiciousStewEffect;
import com.viaversion.viaversion.api.minecraft.item.data.ToolProperties;
import com.viaversion.viaversion.api.minecraft.item.data.TooltipDisplay;
import com.viaversion.viaversion.api.minecraft.item.data.TropicalFishPattern;
import com.viaversion.viaversion.api.minecraft.item.data.Unbreakable;
import com.viaversion.viaversion.api.minecraft.item.data.UseCooldown;
import com.viaversion.viaversion.api.minecraft.item.data.Weapon;
import com.viaversion.viaversion.api.minecraft.item.data.WritableBook;
import com.viaversion.viaversion.api.minecraft.item.data.WrittenBook;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.EitherType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.util.Either;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Unit;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="identifier", type=String.class), @RecordComponents.Value(name="type", type=Type.class)})
public final class StructuredDataKey<T>
extends J_L_Record {
    private final String identifier;
    private final Type<T> type;
    public static final StructuredDataKey<CompoundTag> CUSTOM_DATA = new StructuredDataKey<CompoundTag>("custom_data", Types.COMPOUND_TAG);
    public static final StructuredDataKey<Integer> MAX_STACK_SIZE = new StructuredDataKey<Integer>("max_stack_size", Types.VAR_INT);
    public static final StructuredDataKey<Integer> MAX_DAMAGE = new StructuredDataKey<Integer>("max_damage", Types.VAR_INT);
    public static final StructuredDataKey<Integer> DAMAGE = new StructuredDataKey<Integer>("damage", Types.VAR_INT);
    public static final StructuredDataKey<Unbreakable> UNBREAKABLE1_20_5 = new StructuredDataKey<Unbreakable>("unbreakable", Unbreakable.TYPE);
    public static final StructuredDataKey<Unit> UNBREAKABLE1_21_5 = new StructuredDataKey<Unit>("unbreakable", Types.EMPTY);
    public static final StructuredDataKey<Tag> CUSTOM_NAME = new StructuredDataKey<Tag>("custom_name", Types.TEXT_COMPONENT_TAG);
    public static final StructuredDataKey<Tag> ITEM_NAME = new StructuredDataKey<Tag>("item_name", Types.TEXT_COMPONENT_TAG);
    public static final StructuredDataKey<Key> ITEM_MODEL = new StructuredDataKey<Key>("item_model", Types.RESOURCE_LOCATION);
    public static final StructuredDataKey<Tag[]> LORE = new StructuredDataKey<T[]>("lore", new ArrayType<Tag>(Types.TEXT_COMPONENT_TAG, 256));
    public static final StructuredDataKey<Integer> RARITY = new StructuredDataKey<Integer>("rarity", EnumTypes.RARITY);
    public static final StructuredDataKey<Enchantments> ENCHANTMENTS1_20_5 = new StructuredDataKey<Enchantments>("enchantments", Enchantments.TYPE1_20_5);
    public static final StructuredDataKey<Enchantments> ENCHANTMENTS1_21_5 = new StructuredDataKey<Enchantments>("enchantments", Enchantments.TYPE1_21_5);
    public static final StructuredDataKey<AdventureModePredicate> CAN_PLACE_ON1_20_5 = new StructuredDataKey<AdventureModePredicate>("can_place_on", AdventureModePredicate.TYPE1_20_5);
    public static final StructuredDataKey<AdventureModePredicate> CAN_BREAK1_20_5 = new StructuredDataKey<AdventureModePredicate>("can_break", AdventureModePredicate.TYPE1_20_5);
    public static final StructuredDataKey<AttributeModifiers1_20_5> ATTRIBUTE_MODIFIERS1_20_5 = new StructuredDataKey<AttributeModifiers1_20_5>("attribute_modifiers", AttributeModifiers1_20_5.TYPE);
    public static final StructuredDataKey<AttributeModifiers1_21> ATTRIBUTE_MODIFIERS1_21 = new StructuredDataKey<AttributeModifiers1_21>("attribute_modifiers", AttributeModifiers1_21.TYPE1_21);
    public static final StructuredDataKey<AttributeModifiers1_21> ATTRIBUTE_MODIFIERS1_21_5 = new StructuredDataKey<AttributeModifiers1_21>("attribute_modifiers", AttributeModifiers1_21.TYPE1_21_5);
    public static final StructuredDataKey<AttributeModifiers1_21> ATTRIBUTE_MODIFIERS1_21_6 = new StructuredDataKey<AttributeModifiers1_21>("attribute_modifiers", AttributeModifiers1_21.TYPE1_21_6);
    public static final StructuredDataKey<Integer> CUSTOM_MODEL_DATA1_20_5 = new StructuredDataKey<Integer>("custom_model_data", Types.VAR_INT);
    public static final StructuredDataKey<CustomModelData1_21_4> CUSTOM_MODEL_DATA1_21_4 = new StructuredDataKey<CustomModelData1_21_4>("custom_model_data", CustomModelData1_21_4.TYPE);
    public static final StructuredDataKey<Unit> HIDE_ADDITIONAL_TOOLTIP = new StructuredDataKey<Unit>("hide_additional_tooltip", Types.EMPTY);
    public static final StructuredDataKey<Unit> HIDE_TOOLTIP = new StructuredDataKey<Unit>("hide_tooltip", Types.EMPTY);
    public static final StructuredDataKey<TooltipDisplay> TOOLTIP_DISPLAY = new StructuredDataKey<TooltipDisplay>("tooltip_display", TooltipDisplay.TYPE);
    public static final StructuredDataKey<Integer> REPAIR_COST = new StructuredDataKey<Integer>("repair_cost", Types.VAR_INT);
    public static final StructuredDataKey<Unit> CREATIVE_SLOT_LOCK = new StructuredDataKey<Unit>("creative_slot_lock", Types.EMPTY);
    public static final StructuredDataKey<Boolean> ENCHANTMENT_GLINT_OVERRIDE = new StructuredDataKey<Boolean>("enchantment_glint_override", Types.BOOLEAN);
    public static final StructuredDataKey<Tag> INTANGIBLE_PROJECTILE = new StructuredDataKey<Tag>("intangible_projectile", Types.TAG);
    public static final StructuredDataKey<FoodProperties1_20_5> FOOD1_20_5 = new StructuredDataKey<FoodProperties1_20_5>("food", FoodProperties1_20_5.TYPE1_20_5);
    public static final StructuredDataKey<FoodProperties1_20_5> FOOD1_21 = new StructuredDataKey<FoodProperties1_20_5>("food", FoodProperties1_20_5.TYPE1_21);
    public static final StructuredDataKey<FoodProperties1_21_2> FOOD1_21_2 = new StructuredDataKey<FoodProperties1_21_2>("food", FoodProperties1_21_2.TYPE);
    public static final StructuredDataKey<Consumable1_21_2> CONSUMABLE1_21_2 = new StructuredDataKey<Consumable1_21_2>("consumable", Consumable1_21_2.TYPE);
    public static final StructuredDataKey<UseCooldown> USE_COOLDOWN = new StructuredDataKey<UseCooldown>("use_cooldown", UseCooldown.TYPE);
    public static final StructuredDataKey<Unit> FIRE_RESISTANT = new StructuredDataKey<Unit>("fire_resistant", Types.EMPTY);
    public static final StructuredDataKey<DamageResistant> DAMAGE_RESISTANT = new StructuredDataKey<DamageResistant>("damage_resistant", DamageResistant.TYPE);
    public static final StructuredDataKey<ToolProperties> TOOL1_20_5 = new StructuredDataKey<ToolProperties>("tool", ToolProperties.TYPE1_20_5);
    public static final StructuredDataKey<ToolProperties> TOOL1_21_5 = new StructuredDataKey<ToolProperties>("tool", ToolProperties.TYPE1_21_5);
    public static final StructuredDataKey<Weapon> WEAPON = new StructuredDataKey<Weapon>("weapon", Weapon.TYPE);
    public static final StructuredDataKey<Enchantable> ENCHANTABLE = new StructuredDataKey<Enchantable>("enchantable", Enchantable.TYPE);
    public static final StructuredDataKey<Equippable> EQUIPPABLE1_21_2 = new StructuredDataKey<Equippable>("equippable", Equippable.TYPE1_21_2);
    public static final StructuredDataKey<Equippable> EQUIPPABLE1_21_5 = new StructuredDataKey<Equippable>("equippable", Equippable.TYPE1_21_5);
    public static final StructuredDataKey<Equippable> EQUIPPABLE1_21_6 = new StructuredDataKey<Equippable>("equippable", Equippable.TYPE1_21_6);
    public static final StructuredDataKey<HolderSet> REPAIRABLE = new StructuredDataKey<HolderSet>("repairable", Types.HOLDER_SET);
    public static final StructuredDataKey<Unit> GLIDER = new StructuredDataKey<Unit>("glider", Types.EMPTY);
    public static final StructuredDataKey<Key> TOOLTIP_STYLE = new StructuredDataKey<Key>("tooltip_style", Types.RESOURCE_LOCATION);
    public static final StructuredDataKey<DeathProtection> DEATH_PROTECTION = new StructuredDataKey<DeathProtection>("death_protection", DeathProtection.TYPE);
    public static final StructuredDataKey<BlocksAttacks> BLOCKS_ATTACKS = new StructuredDataKey<BlocksAttacks>("blocks_attacks", BlocksAttacks.TYPE);
    public static final StructuredDataKey<Enchantments> STORED_ENCHANTMENTS1_20_5 = new StructuredDataKey<Enchantments>("stored_enchantments", Enchantments.TYPE1_20_5);
    public static final StructuredDataKey<Enchantments> STORED_ENCHANTMENTS1_21_5 = new StructuredDataKey<Enchantments>("stored_enchantments", Enchantments.TYPE1_21_5);
    public static final StructuredDataKey<DyedColor> DYED_COLOR1_20_5 = new StructuredDataKey<DyedColor>("dyed_color", DyedColor.TYPE1_20_5);
    public static final StructuredDataKey<DyedColor> DYED_COLOR1_21_5 = new StructuredDataKey<DyedColor>("dyed_color", DyedColor.TYPE1_21_5);
    public static final StructuredDataKey<Integer> MAP_COLOR = new StructuredDataKey<Integer>("map_color", Types.INT);
    public static final StructuredDataKey<Integer> MAP_ID = new StructuredDataKey<Integer>("map_id", Types.VAR_INT);
    public static final StructuredDataKey<CompoundTag> MAP_DECORATIONS = new StructuredDataKey<CompoundTag>("map_decorations", Types.COMPOUND_TAG);
    public static final StructuredDataKey<Integer> MAP_POST_PROCESSING = new StructuredDataKey<Integer>("map_post_processing", Types.VAR_INT);
    public static final StructuredDataKey<PotionContents> POTION_CONTENTS1_20_5 = new StructuredDataKey<PotionContents>("potion_contents", PotionContents.TYPE1_20_5);
    public static final StructuredDataKey<PotionContents> POTION_CONTENTS1_21_2 = new StructuredDataKey<PotionContents>("potion_contents", PotionContents.TYPE1_21_2);
    public static final StructuredDataKey<Float> POTION_DURATION_SCALE = new StructuredDataKey<Float>("potion_duration_scale", Types.FLOAT);
    public static final StructuredDataKey<SuspiciousStewEffect[]> SUSPICIOUS_STEW_EFFECTS = new StructuredDataKey<SuspiciousStewEffect[]>("suspicious_stew_effects", SuspiciousStewEffect.ARRAY_TYPE);
    public static final StructuredDataKey<WritableBook> WRITABLE_BOOK_CONTENT = new StructuredDataKey<WritableBook>("writable_book_content", WritableBook.TYPE);
    public static final StructuredDataKey<WrittenBook> WRITTEN_BOOK_CONTENT = new StructuredDataKey<WrittenBook>("written_book_content", WrittenBook.TYPE);
    public static final StructuredDataKey<ArmorTrim> TRIM1_20_5 = new StructuredDataKey<ArmorTrim>("trim", ArmorTrim.TYPE1_20_5);
    public static final StructuredDataKey<ArmorTrim> TRIM1_21_2 = new StructuredDataKey<ArmorTrim>("trim", ArmorTrim.TYPE1_21_2);
    public static final StructuredDataKey<ArmorTrim> TRIM1_21_4 = new StructuredDataKey<ArmorTrim>("trim", ArmorTrim.TYPE1_21_4);
    public static final StructuredDataKey<ArmorTrim> TRIM1_21_5 = new StructuredDataKey<ArmorTrim>("trim", ArmorTrim.TYPE1_21_5);
    public static final StructuredDataKey<CompoundTag> DEBUG_STICK_STATE = new StructuredDataKey<CompoundTag>("debug_stick_state", Types.COMPOUND_TAG);
    public static final StructuredDataKey<CompoundTag> ENTITY_DATA = new StructuredDataKey<CompoundTag>("entity_data", Types.COMPOUND_TAG);
    public static final StructuredDataKey<CompoundTag> BUCKET_ENTITY_DATA = new StructuredDataKey<CompoundTag>("bucket_entity_data", Types.COMPOUND_TAG);
    public static final StructuredDataKey<CompoundTag> BLOCK_ENTITY_DATA = new StructuredDataKey<CompoundTag>("block_entity_data", Types.COMPOUND_TAG);
    public static final StructuredDataKey<Holder<Instrument1_20_5>> INSTRUMENT1_20_5 = new StructuredDataKey<Instrument1_20_5>("instrument", Instrument1_20_5.TYPE);
    public static final StructuredDataKey<Holder<Instrument1_21_2>> INSTRUMENT1_21_2 = new StructuredDataKey<Instrument1_21_2>("instrument", Instrument1_21_2.TYPE);
    public static final StructuredDataKey<EitherHolder<Instrument1_21_2>> INSTRUMENT1_21_5 = new StructuredDataKey<Instrument1_21_2>("instrument", Instrument1_21_2.EITHER_HOLDER_TYPE);
    public static final StructuredDataKey<ProvidesTrimMaterial> PROVIDES_TRIM_MATERIAL = new StructuredDataKey<ProvidesTrimMaterial>("provides_trim_material", ProvidesTrimMaterial.TYPE);
    public static final StructuredDataKey<Integer> OMINOUS_BOTTLE_AMPLIFIER = new StructuredDataKey<Integer>("ominous_bottle_amplifier", Types.VAR_INT);
    public static final StructuredDataKey<JukeboxPlayable> JUKEBOX_PLAYABLE1_21 = new StructuredDataKey<JukeboxPlayable>("jukebox_playable", JukeboxPlayable.TYPE1_21);
    public static final StructuredDataKey<JukeboxPlayable> JUKEBOX_PLAYABLE1_21_5 = new StructuredDataKey<JukeboxPlayable>("jukebox_playable", JukeboxPlayable.TYPE1_21_5);
    public static final StructuredDataKey<Key> PROVIDES_BANNER_PATTERNS = new StructuredDataKey<Key>("provides_banner_patterns", Types.TAG_KEY);
    public static final StructuredDataKey<Tag> RECIPES = new StructuredDataKey<Tag>("recipes", Types.TAG);
    public static final StructuredDataKey<LodestoneTracker> LODESTONE_TRACKER = new StructuredDataKey<LodestoneTracker>("lodestone_tracker", LodestoneTracker.TYPE);
    public static final StructuredDataKey<FireworkExplosion> FIREWORK_EXPLOSION = new StructuredDataKey<FireworkExplosion>("firework_explosion", FireworkExplosion.TYPE);
    public static final StructuredDataKey<Fireworks> FIREWORKS = new StructuredDataKey<Fireworks>("fireworks", Fireworks.TYPE);
    public static final StructuredDataKey<GameProfile> PROFILE = new StructuredDataKey<GameProfile>("profile", Types.GAME_PROFILE);
    public static final StructuredDataKey<Key> NOTE_BLOCK_SOUND = new StructuredDataKey<Key>("note_block_sound", Types.RESOURCE_LOCATION);
    public static final StructuredDataKey<BannerPatternLayer[]> BANNER_PATTERNS = new StructuredDataKey<BannerPatternLayer[]>("banner_patterns", BannerPatternLayer.ARRAY_TYPE);
    public static final StructuredDataKey<Integer> BASE_COLOR = new StructuredDataKey<Integer>("base_color", EnumTypes.DYE_COLOR);
    public static final StructuredDataKey<PotDecorations> POT_DECORATIONS = new StructuredDataKey<PotDecorations>("pot_decorations", PotDecorations.TYPE);
    public static final StructuredDataKey<BlockStateProperties> BLOCK_STATE = new StructuredDataKey<BlockStateProperties>("block_state", BlockStateProperties.TYPE);
    public static final StructuredDataKey<Bee[]> BEES = new StructuredDataKey<Bee[]>("bees", Bee.ARRAY_TYPE);
    public static final StructuredDataKey<Tag> LOCK = new StructuredDataKey<Tag>("lock", Types.TAG);
    public static final StructuredDataKey<CompoundTag> CONTAINER_LOOT = new StructuredDataKey<CompoundTag>("container_loot", Types.COMPOUND_TAG);
    public static final StructuredDataKey<Holder<SoundEvent>> BREAK_SOUND = new StructuredDataKey<SoundEvent>("break_sound", Types.SOUND_EVENT);
    public static final StructuredDataKey<Integer> VILLAGER_VARIANT = new StructuredDataKey<Integer>("villager/variant", EnumTypes.VILLAGER_TYPE);
    public static final StructuredDataKey<Integer> WOLF_VARIANT = new StructuredDataKey<Integer>("wolf/variant", Types.VAR_INT);
    public static final StructuredDataKey<Integer> WOLF_SOUND_VARIANT = new StructuredDataKey<Integer>("wolf/sound_variant", Types.VAR_INT);
    public static final StructuredDataKey<Integer> WOLF_COLLAR = new StructuredDataKey<Integer>("wolf/collar", EnumTypes.DYE_COLOR);
    public static final StructuredDataKey<Integer> FOX_VARIANT = new StructuredDataKey<Integer>("fox/variant", EnumTypes.FOX_VARIANT);
    public static final StructuredDataKey<Integer> SALMON_SIZE = new StructuredDataKey<Integer>("salmon/size", EnumTypes.SALMON_VARIANT);
    public static final StructuredDataKey<Integer> PARROT_VARIANT = new StructuredDataKey<Integer>("parrot/variant", EnumTypes.PARROT_VARIANT);
    public static final StructuredDataKey<TropicalFishPattern> TROPICAL_FISH_PATTERN = new StructuredDataKey<TropicalFishPattern>("tropical_fish/pattern", TropicalFishPattern.TYPE);
    public static final StructuredDataKey<Integer> TROPICAL_FISH_BASE_COLOR = new StructuredDataKey<Integer>("tropical_fish/base_color", EnumTypes.DYE_COLOR);
    public static final StructuredDataKey<Integer> TROPICAL_FISH_PATTERN_COLOR = new StructuredDataKey<Integer>("tropical_fish/pattern_color", EnumTypes.DYE_COLOR);
    public static final StructuredDataKey<Integer> MOOSHROOM_VARIANT = new StructuredDataKey<Integer>("mooshroom/variant", EnumTypes.MUSHROOM_COW_VARIANT);
    public static final StructuredDataKey<Integer> RABBIT_VARIANT = new StructuredDataKey<Integer>("rabbit/variant", EnumTypes.RABBIT_VARIANT);
    public static final StructuredDataKey<Integer> PIG_VARIANT = new StructuredDataKey<Integer>("pig/variant", Types.VAR_INT);
    public static final StructuredDataKey<Integer> COW_VARIANT = new StructuredDataKey<Integer>("cow/variant", Types.VAR_INT);
    public static final StructuredDataKey<Either<Integer, String>> CHICKEN_VARIANT = new StructuredDataKey("chicken/variant", new EitherType<Integer, String>(Types.VAR_INT, Types.STRING));
    public static final StructuredDataKey<Integer> FROG_VARIANT = new StructuredDataKey<Integer>("frog/variant", Types.VAR_INT);
    public static final StructuredDataKey<Integer> HORSE_VARIANT = new StructuredDataKey<Integer>("horse/variant", EnumTypes.HORSE_VARIANT);
    public static final StructuredDataKey<Holder<PaintingVariant>> PAINTING_VARIANT = new StructuredDataKey<PaintingVariant>("painting/variant", PaintingVariant.TYPE1_21_2);
    public static final StructuredDataKey<Integer> LLAMA_VARIANT = new StructuredDataKey<Integer>("llama/variant", EnumTypes.LLAMA_VARIANT);
    public static final StructuredDataKey<Integer> AXOLOTL_VARIANT = new StructuredDataKey<Integer>("axolotl/variant", EnumTypes.AXOLOTL_VARIANT);
    public static final StructuredDataKey<Integer> CAT_VARIANT = new StructuredDataKey<Integer>("cat/variant", Types.VAR_INT);
    public static final StructuredDataKey<Integer> CAT_COLLAR = new StructuredDataKey<Integer>("cat/collar", EnumTypes.DYE_COLOR);
    public static final StructuredDataKey<Integer> SHEEP_COLOR = new StructuredDataKey<Integer>("sheep/color", EnumTypes.DYE_COLOR);
    public static final StructuredDataKey<Integer> SHULKER_COLOR = new StructuredDataKey<Integer>("shulker/color", EnumTypes.DYE_COLOR);
    public static final StructuredDataKeys1_20_5 V1_20_5 = VersionedTypes.V1_20_5.structuredDataKeys();
    public static final StructuredDataKeys1_20_5 V1_21 = (StructuredDataKeys1_20_5)VersionedTypes.V1_21.structuredDataKeys();
    public static final StructuredDataKeys1_21_2 V1_21_2 = VersionedTypes.V1_21_2.structuredDataKeys();
    public static final StructuredDataKeys1_21_2 V1_21_4 = VersionedTypes.V1_21_4.structuredDataKeys();
    public static final StructuredDataKeys1_21_5 V1_21_5 = VersionedTypes.V1_21_5.structuredDataKeys();
    public static final StructuredDataKeys1_21_5 V1_21_6 = VersionedTypes.V1_21_6.structuredDataKeys();

    public StructuredDataKey(String identifier, Type<T> type) {
        this.identifier = identifier;
        this.type = type;
    }

    @Override
    public String toString() {
        return StructuredDataKey.jvmdowngrader$concat$toString$1(this.identifier, String.valueOf(this.type));
    }

    @Override
    public final int hashCode() {
        return StructuredDataKey.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return StructuredDataKey.jvmdowngrader$equals$equals(this, o2);
    }

    public String identifier() {
        return this.identifier;
    }

    public Type<T> type() {
        return this.type;
    }

    private static int jvmdowngrader$hashCode$hashCode(StructuredDataKey structuredDataKey) {
        Object[] objectArray = new Object[]{structuredDataKey.identifier, structuredDataKey.type};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(StructuredDataKey structuredDataKey, Object object) {
        if (structuredDataKey == object) {
            return true;
        }
        if (object != null && object instanceof StructuredDataKey) {
            StructuredDataKey structuredDataKey2 = (StructuredDataKey)object;
            if (Objects.equals(structuredDataKey.identifier, structuredDataKey2.identifier) && Objects.equals(structuredDataKey.type, structuredDataKey2.type)) {
                return true;
            }
        }
        return false;
    }

    private static String jvmdowngrader$concat$toString$1(String string, String string2) {
        return "StructuredDataKey{identifier='" + string + "', type=" + string2 + "}";
    }
}

