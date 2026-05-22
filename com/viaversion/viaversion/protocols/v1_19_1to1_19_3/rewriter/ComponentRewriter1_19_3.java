/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter;

import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;

public final class ComponentRewriter1_19_3
extends JsonNBTComponentRewriter<ClientboundPackets1_19_1> {
    public ComponentRewriter1_19_3(Protocol<ClientboundPackets1_19_1, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    protected void handleTranslate(JsonObject object, String translate) {
        switch (translate) {
            case "commands.locate.poi.invalid": {
                object.addProperty("translate", "There is no point of interest with type \"%s\"");
                break;
            }
            case "commands.locate.biome.invalid": {
                object.addProperty("translate", "There is no biome with type \"%s\"");
                break;
            }
            case "multiplayer.disconnect.missing_public_key": {
                object.addProperty("translate", "Missing profile public key.\nThis server requires secure profiles.");
                break;
            }
            case "multiplayer.disconnect.invalid_public_key": {
                object.addProperty("translate", "Invalid signature for profile public key.\nTry restarting your game.");
            }
        }
    }
}

