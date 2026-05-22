/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter;

import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import java.util.HashMap;
import java.util.Map;

public final class ComponentRewriter1_17
extends JsonNBTComponentRewriter<ClientboundPackets1_16_2> {
    private final Map<String, String> mappings = new HashMap<String, String>();

    public ComponentRewriter1_17(Protocol<ClientboundPackets1_16_2, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
        this.mappings.put("commands.worldborder.set.failed.small.", "commands.worldborder.set.failed.small");
        this.mappings.put("commands.worldborder.set.failed.big.", "commands.worldborder.set.failed.big");
        this.mappings.put("commands.replaceitem.slot.inapplicable", "commands.item.target.no_such_slot");
        this.mappings.put("commands.replaceitem.block.failed", "The target block is not a container");
        this.mappings.put("commands.replaceitem.entity.success.single", "commands.item.entity.set.success.single");
        this.mappings.put("commands.replaceitem.block.success", "commands.item.block.set.success");
        this.mappings.put("commands.debug.reportSaved", "Created debug report in %s");
        this.mappings.put("commands.debug.reportFailed", "Failed to create debug report");
    }

    @Override
    protected void handleTranslate(JsonObject object, String translate) {
        String mappedTranslation = this.mappings.get(translate);
        if (mappedTranslation != null) {
            object.addProperty("translate", mappedTranslation);
        }
    }
}

