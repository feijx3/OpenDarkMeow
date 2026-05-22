/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;

public class RecipeDisplayRewriter1_21_5<C extends ClientboundPacketType>
extends RecipeDisplayRewriter<C> {
    public RecipeDisplayRewriter1_21_5(Protocol<C, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    protected void handleSmithingTrimSlotDisplay(PacketWrapper wrapper) {
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        wrapper.passthrough(ArmorTrimPattern.TYPE1_21_5);
    }
}

