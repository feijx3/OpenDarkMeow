/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter;

import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import java.util.HashMap;
import java.util.Map;

public final class ComponentRewriter1_19
extends JsonNBTComponentRewriter<ClientboundPackets1_18> {
    private final Map<String, String> mappings = new HashMap<String, String>();

    public ComponentRewriter1_19(Protocol<ClientboundPackets1_18, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
        this.mappings.put("commands.locate.invalid", "commands.locate.structure.invalid");
        this.mappings.put("commands.locatebiome.success", "commands.locate.biome.success");
        this.mappings.put("command.placefeature.invalid", "commands.place.feature.failed");
        this.mappings.put("commands.locatebiome.invalid", "commands.locate.biome.invalid");
        this.mappings.put("commands.placefeature.invalid", "commands.place.feature.invalid");
        this.mappings.put("commands.locatebiome.notFound", "commands.locate.biome.not_found");
        this.mappings.put("commands.placefeature.success", "commands.place.feature.success");
        this.mappings.put("commands.locate.failed", "commands.locate.structure.not_found");
        this.mappings.put("commands.locate.success", "commands.locate.structure.success");
    }

    @Override
    protected void handleTranslate(JsonObject object, String translate) {
        String mappedTranslation = this.mappings.get(translate);
        if (mappedTranslation != null) {
            object.addProperty("translate", mappedTranslation);
        }
    }
}

