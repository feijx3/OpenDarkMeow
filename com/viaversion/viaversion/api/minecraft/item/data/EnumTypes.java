/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j9.stub.java_base.J_U_List;
import com.viaversion.viaversion.api.type.types.EnumType;
import com.viaversion.viaversion.api.type.types.FakeEnumType;
import com.viaversion.viaversion.api.type.types.RegistryValueType;

public final class EnumTypes {
    public static final EnumType DYE_COLOR = new EnumType("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black");
    public static final EnumType RARITY = new EnumType("common", "uncommon", "rare", "epic");
    public static final EnumType FOX_VARIANT = new EnumType("red", "snow");
    public static final EnumType SALMON_VARIANT = new EnumType(EnumType.Fallback.CLAMP, "small", "medium", "large");
    public static final EnumType PARROT_VARIANT = new EnumType(EnumType.Fallback.CLAMP, "red_blue", "blue", "green", "yellow_blue", "gray");
    public static final EnumType MUSHROOM_COW_VARIANT = new EnumType(EnumType.Fallback.CLAMP, "red", "brown");
    public static final EnumType HORSE_VARIANT = new EnumType(EnumType.Fallback.WRAP, "white", "creamy", "chestnut", "brown", "black", "gray", "dark_brown");
    public static final EnumType LLAMA_VARIANT = new EnumType(EnumType.Fallback.CLAMP, "creamy", "white", "brown", "gray");
    public static final EnumType AXOLOTL_VARIANT = new EnumType("lucy", "wild", "gold", "cyan", "blue");
    public static final FakeEnumType RABBIT_VARIANT = new FakeEnumType(J_U_List.of("brown", "white", "black", "white_splotched", "gold", "salt"), FakeEnumType.Entry.of(99, "evil"));
    public static final RegistryValueType VILLAGER_TYPE = new RegistryValueType("desert", "jungle", "plains", "savanna", "snow", "swamp", "taiga");
    public static final RegistryValueType POTION = new RegistryValueType("water", "mundane", "thick", "awkward", "night_vision", "long_night_vision", "invisibility", "long_invisibility", "leaping", "long_leaping", "strong_leaping", "fire_resistance", "long_fire_resistance", "swiftness", "long_swiftness", "strong_swiftness", "slowness", "long_slowness", "strong_slowness", "turtle_master", "long_turtle_master", "strong_turtle_master", "water_breathing", "long_water_breathing", "healing", "strong_healing", "harming", "strong_harming", "poison", "long_poison", "strong_poison", "regeneration", "long_regeneration", "strong_regeneration", "strength", "long_strength", "strong_strength", "weakness", "long_weakness", "luck", "slow_falling", "long_slow_falling", "wind_charged", "weaving", "oozing", "infested");
    public static final RegistryValueType MOB_EFFECT = new RegistryValueType("speed", "slowness", "haste", "mining_fatigue", "strength", "instant_health", "instant_damage", "jump_boost", "nausea", "regeneration", "resistance", "fire_resistance", "water_breathing", "invisibility", "blindness", "night_vision", "hunger", "weakness", "poison", "wither", "health_boost", "absorption", "saturation", "glowing", "levitation", "luck", "unluck", "slow_falling", "conduit_power", "dolphins_grace", "bad_omen", "hero_of_the_village", "darkness", "trial_omen", "raid_omen", "wind_charged", "weaving", "oozing", "infested");
}

