/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.UUID;

public final class ComponentRewriter1_21
extends JsonNBTComponentRewriter<ClientboundPacket1_20_5> {
    public ComponentRewriter1_21(Protocol1_20_5To1_21 protocol) {
        super(protocol, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void handleShowItem(UserConnection connection, CompoundTag itemTag, CompoundTag componentsTag) {
        super.handleShowItem(connection, itemTag, componentsTag);
        String identifier = Key.stripMinecraftNamespace(itemTag.getString("id"));
        if (identifier.equals("trident") || identifier.equals("piglin_banner_pattern")) {
            if (componentsTag == null) {
                componentsTag = new CompoundTag();
                itemTag.put("components", componentsTag);
            }
            if (!TagUtil.containsNamespaced(componentsTag, "rarity")) {
                componentsTag.put("minecraft:rarity", new StringTag("common"));
            }
        }
        if (componentsTag == null) {
            return;
        }
        CompoundTag attributeModifiers = TagUtil.getNamespacedCompoundTag(componentsTag, "attribute_modifiers");
        if (attributeModifiers == null) {
            return;
        }
        ListTag<CompoundTag> modifiers = attributeModifiers.getListTag("modifiers", CompoundTag.class);
        for (CompoundTag modifier : modifiers) {
            String name = modifier.getString("name");
            UUID uuid = UUIDUtil.fromIntArray(modifier.getIntArrayTag("uuid").getValue());
            String id = Protocol1_20_5To1_21.mapAttributeUUID(uuid, name);
            modifier.putString("id", id);
        }
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }
}

