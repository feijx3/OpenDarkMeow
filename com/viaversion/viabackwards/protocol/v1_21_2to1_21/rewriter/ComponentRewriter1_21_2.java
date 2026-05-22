/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;

public final class ComponentRewriter1_21_2
extends JsonNBTComponentRewriter<ClientboundPacket1_21_2> {
    public ComponentRewriter1_21_2(Protocol1_21_2To1_21 protocol) {
        super(protocol, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void handleShowItem(UserConnection connection, CompoundTag itemTag, CompoundTag componentsTag) {
        super.handleShowItem(connection, itemTag, componentsTag);
        if (componentsTag == null) {
            return;
        }
        com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.ComponentRewriter1_21_2.convertAttributes(componentsTag, this.protocol.getMappingData().getAttributeMappings());
        CompoundTag instrument = TagUtil.getNamespacedCompoundTag(componentsTag, "instrument");
        if (instrument != null) {
            instrument.remove("description");
        }
        CompoundTag useRemainder = TagUtil.getNamespacedCompoundTag(componentsTag, "use_remainder");
        CompoundTag food = TagUtil.getNamespacedCompoundTag(componentsTag, "food");
        if (food != null) {
            if (useRemainder != null) {
                food.put("using_converts_to", useRemainder);
            }
            food.putFloat("eat_seconds", 1.6f);
        }
        this.removeDataComponents(componentsTag, BlockItemPacketRewriter1_21_2.NEW_DATA_TO_REMOVE);
        this.removeDataComponents(componentsTag, StructuredDataKey.DAMAGE_RESISTANT, StructuredDataKey.LOCK);
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }
}

