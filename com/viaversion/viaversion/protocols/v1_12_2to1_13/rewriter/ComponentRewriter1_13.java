/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import java.util.logging.Level;

public class ComponentRewriter1_13<C extends ClientboundPacketType>
extends JsonNBTComponentRewriter<C> {
    public ComponentRewriter1_13(Protocol<C, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    protected void handleHoverEvent(UserConnection connection, JsonObject hoverEvent) {
        block9: {
            CompoundTag tag;
            super.handleHoverEvent(connection, hoverEvent);
            String action = hoverEvent.getAsJsonPrimitive("action").getAsString();
            if (!action.equals("show_item")) {
                return;
            }
            JsonElement value = hoverEvent.get("value");
            if (value == null) {
                return;
            }
            try {
                tag = ComponentUtil.deserializeLegacyShowItem(value, SerializerVersion.V1_12);
            }
            catch (Exception e2) {
                if (!Via.getConfig().isSuppressTextComponentConversionWarnings()) {
                    Protocol1_12_2To1_13.LOGGER.log(Level.WARNING, ComponentRewriter1_13.jvmdowngrader$concat$handleHoverEvent$1(StringUtil.forLogging(value)), e2);
                }
                return;
            }
            CompoundTag itemTag = tag.getCompoundTag("tag");
            NumberTag damageTag = tag.getNumberTag("Damage");
            short damage = damageTag != null ? damageTag.asShort() : (short)0;
            DataItem item = new DataItem();
            item.setData(damage);
            item.setTag(itemTag);
            this.protocol.getItemRewriter().handleItemToClient(null, item);
            if (damage != item.data()) {
                tag.put("Damage", new ShortTag(item.data()));
            }
            if (itemTag != null) {
                tag.put("tag", itemTag);
            }
            JsonArray newValue = new JsonArray();
            JsonObject showItem = new JsonObject();
            newValue.add(showItem);
            try {
                showItem.addProperty("text", SerializerVersion.V1_13.toSNBT(tag));
                hoverEvent.add("value", newValue);
            }
            catch (Exception e3) {
                if (Via.getConfig().isSuppressTextComponentConversionWarnings()) break block9;
                Protocol1_12_2To1_13.LOGGER.log(Level.WARNING, ComponentRewriter1_13.jvmdowngrader$concat$handleHoverEvent$2(StringUtil.forLogging(value)), e3);
            }
        }
    }

    @Override
    protected void handleTranslate(JsonObject object, String translate) {
        super.handleTranslate(object, translate);
        String newTranslate = Protocol1_12_2To1_13.MAPPINGS.getTranslateMapping().get(translate);
        if (newTranslate == null) {
            newTranslate = Protocol1_12_2To1_13.MAPPINGS.getMojangTranslation().get(translate);
        }
        if (newTranslate != null) {
            object.addProperty("translate", newTranslate);
        }
    }

    private static String jvmdowngrader$concat$handleHoverEvent$1(String string) {
        return "Error reading NBT in show_item: " + string;
    }

    private static String jvmdowngrader$concat$handleHoverEvent$2(String string) {
        return "Error writing NBT in show_item: " + string;
    }
}

