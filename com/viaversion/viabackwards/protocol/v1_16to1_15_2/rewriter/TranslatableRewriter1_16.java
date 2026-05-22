/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter;

import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.Protocol1_16To1_15_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ChatColor.class})
public class TranslatableRewriter1_16
extends JsonNBTComponentRewriter<ClientboundPackets1_16> {
    private static final ChatColor[] COLORS = new ChatColor[]{new ChatColor("black", 0), new ChatColor("dark_blue", 170), new ChatColor("dark_green", 43520), new ChatColor("dark_aqua", 43690), new ChatColor("dark_red", 0xAA0000), new ChatColor("dark_purple", 0xAA00AA), new ChatColor("gold", 0xFFAA00), new ChatColor("gray", 0xAAAAAA), new ChatColor("dark_gray", 0x555555), new ChatColor("blue", 0x5555FF), new ChatColor("green", 0x55FF55), new ChatColor("aqua", 0x55FFFF), new ChatColor("red", 0xFF5555), new ChatColor("light_purple", 0xFF55FF), new ChatColor("yellow", 0xFFFF55), new ChatColor("white", 0xFFFFFF)};

    public TranslatableRewriter1_16(Protocol1_16To1_15_2 protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    public void processText(UserConnection connection, JsonElement value) {
        JsonObject hoverEvent;
        String action;
        JsonObject clickEvent;
        String colorName;
        super.processText(connection, value);
        if (value == null || !value.isJsonObject()) {
            return;
        }
        JsonObject object = value.getAsJsonObject();
        JsonPrimitive color = object.getAsJsonPrimitive("color");
        if (color != null && !(colorName = color.getAsString()).isEmpty() && colorName.charAt(0) == '#') {
            int rgb = Integer.parseInt(colorName.substring(1), 16);
            String closestChatColor = this.getClosestChatColor(rgb);
            object.addProperty("color", closestChatColor);
        }
        if ((clickEvent = object.getAsJsonObject("clickEvent")) != null && clickEvent.has("action") && (action = clickEvent.get("action").getAsString()).equals("copy_to_clipboard")) {
            clickEvent.addProperty("action", "suggest_command");
        }
        if ((hoverEvent = object.getAsJsonObject("hoverEvent")) == null || !hoverEvent.has("contents")) {
            return;
        }
        JsonObject convertedObject = (JsonObject)ComponentUtil.convertJson(object, SerializerVersion.V1_16, SerializerVersion.V1_15);
        object.add("hoverEvent", convertedObject.getAsJsonObject("hoverEvent"));
    }

    private String getClosestChatColor(int rgb) {
        int r2 = rgb >> 16 & 0xFF;
        int g2 = rgb >> 8 & 0xFF;
        int b2 = rgb & 0xFF;
        ChatColor closest = null;
        int smallestDiff = 0;
        for (ChatColor color : COLORS) {
            if (color.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$rgb() == rgb) {
                return color.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$colorName();
            }
            int rAverage = (color.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$r() + r2) / 2;
            int rDiff = color.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$r() - r2;
            int gDiff = color.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$g() - g2;
            int bDiff = color.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$b() - b2;
            int diff = (2 + (rAverage >> 8)) * rDiff * rDiff + 4 * gDiff * gDiff + (2 + (255 - rAverage >> 8)) * bDiff * bDiff;
            if (closest != null && diff >= smallestDiff) continue;
            closest = color;
            smallestDiff = diff;
        }
        return closest.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$colorName();
    }

    @NestHost(value=TranslatableRewriter1_16.class)
    private static final class ChatColor {
        private final String colorName;
        private final int rgb;
        private final int r;
        private final int g;
        private final int b;

        ChatColor(String colorName, int rgb) {
            this.colorName = colorName;
            this.rgb = rgb;
            this.r = rgb >> 16 & 0xFF;
            this.g = rgb >> 8 & 0xFF;
            this.b = rgb & 0xFF;
        }

        public String jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$colorName() {
            return this.colorName;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$set$colorName(String string) {
            this.colorName = string;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$r() {
            return this.r;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$set$r(int n2) {
            this.r = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$b() {
            return this.b;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$set$b(int n2) {
            this.b = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$rgb() {
            return this.rgb;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$set$rgb(int n2) {
            this.rgb = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$get$g() {
            return this.g;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_16to1_15_2_rewriter_TranslatableRewriter1_16$ChatColor$set$g(int n2) {
            this.g = n2;
        }
    }
}

