/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter;

import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import java.util.HashMap;
import java.util.Map;

public final class ComponentRewriter1_18
extends JsonNBTComponentRewriter<ClientboundPackets1_17_1> {
    private final Map<String, String> mappings = new HashMap<String, String>();

    public ComponentRewriter1_18(Protocol<ClientboundPackets1_17_1, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
        this.mappings.put("commands.scoreboard.objectives.add.longName", "Objective names cannot be longer than %s characters");
        this.mappings.put("commands.team.add.longName", "Team names cannot be longer than %s characters");
        this.mappings.put("biome.minecraft.snowy_mountains", "Snowy Mountains");
        this.mappings.put("biome.minecraft.wooded_mountains", "Wooded Mountains");
        this.mappings.put("biome.minecraft.jungle_edge", "Jungle Edge");
        this.mappings.put("biome.minecraft.dark_forest_hills", "Dark Forest Hills");
        this.mappings.put("biome.minecraft.modified_wooded_badlands_plateau", "Modified Wooded Badlands Plateau");
        this.mappings.put("biome.minecraft.snowy_tundra", "Snowy Tundra");
        this.mappings.put("biome.minecraft.mountain_edge", "Mountain Edge");
        this.mappings.put("biome.minecraft.modified_badlands_plateau", "Modified Badlands Plateau");
        this.mappings.put("biome.minecraft.mushroom_field_shore", "Mushroom Field Shore");
        this.mappings.put("biome.minecraft.tall_birch_forest", "Tall Birch Forest");
        this.mappings.put("biome.minecraft.wooded_hills", "Wooded Hills");
        this.mappings.put("biome.minecraft.taiga_hills", "Taiga Hills");
        this.mappings.put("biome.minecraft.snowy_taiga_mountains", "Snowy Taiga Mountains");
        this.mappings.put("biome.minecraft.deep_warm_ocean", "Deep Warm Ocean");
        this.mappings.put("biome.minecraft.swamp_hills", "Swamp Hills");
        this.mappings.put("biome.minecraft.giant_tree_taiga_hills", "Giant Tree Taiga Hills");
        this.mappings.put("biome.minecraft.tall_birch_hills", "Tall Birch Hills");
        this.mappings.put("biome.minecraft.bamboo_jungle_hills", "Bamboo Jungle Hills");
        this.mappings.put("biome.minecraft.jungle_hills", "Jungle Hills");
        this.mappings.put("biome.minecraft.gravelly_mountains", "Gravelly Mountains");
        this.mappings.put("biome.minecraft.wooded_badlands_plateau", "Wooded Badlands Plateau");
        this.mappings.put("biome.minecraft.shattered_savanna", "Shattered Savanna");
        this.mappings.put("biome.minecraft.desert_hills", "Desert Hills");
        this.mappings.put("biome.minecraft.badlands_plateau", "Badlands Plateau");
        this.mappings.put("biome.minecraft.modified_jungle_edge", "Modified Jungle Edge");
        this.mappings.put("biome.minecraft.giant_spruce_taiga", "Giant Spruce Taiga");
        this.mappings.put("biome.minecraft.stone_shore", "Stone Shore");
        this.mappings.put("biome.minecraft.mountains", "Mountains");
        this.mappings.put("biome.minecraft.giant_tree_taiga", "Giant Tree Taiga");
        this.mappings.put("biome.minecraft.snowy_taiga_hills", "Snowy Taiga Hills");
        this.mappings.put("biome.minecraft.modified_gravelly_mountains", "Gravelly Mountains+");
        this.mappings.put("biome.minecraft.taiga_mountains", "Taiga Mountains");
        this.mappings.put("biome.minecraft.desert_lakes", "Desert Lakes");
        this.mappings.put("biome.minecraft.shattered_savanna_plateau", "Shattered Savanna Plateau");
        this.mappings.put("biome.minecraft.modified_jungle", "Modified Jungle");
        this.mappings.put("biome.minecraft.birch_forest_hills", "Birch Forest Hills");
        this.mappings.put("biome.minecraft.giant_spruce_taiga_hills", "Giant Spruce Taiga Hills");
    }

    @Override
    protected void handleTranslate(JsonObject object, String translate) {
        String mappedTranslation = this.mappings.get(translate);
        if (mappedTranslation != null) {
            object.addProperty("translate", mappedTranslation);
        }
    }
}

