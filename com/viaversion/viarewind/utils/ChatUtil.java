/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viarewind.utils;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.logging.Level;
import java.util.regex.Pattern;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@Deprecated
@NestMembers(value={1.class})
public class ChatUtil {
    private static final Pattern UNUSED_COLOR_PATTERN = Pattern.compile("(?>(?>\u00a7[0-fk-or])*(\u00a7r|\\Z))|(?>(?>\u00a7[0-f])*(\u00a7[0-f]))");
    private static final JsonNBTComponentRewriter<ClientboundPacketType> LEGACY_REWRITER = new JsonNBTComponentRewriter<ClientboundPacketType>(null, ComponentRewriterBase.ReadType.JSON){

        @Override
        protected void handleTranslate(JsonObject object, String translate) {
            String text = Protocol1_12_2To1_13.MAPPINGS.getMojangTranslation().get(translate);
            if (text != null) {
                object.addProperty("translate", text);
            }
        }
    };

    public static String jsonToLegacy(String json) {
        if (json == null || json.equals("null") || json.isEmpty()) {
            return "";
        }
        try {
            return ChatUtil.jsonToLegacy(JsonParser.parseString(json));
        }
        catch (Exception e2) {
            if (!Via.getConfig().isSuppressConversionWarnings()) {
                ViaRewind.getPlatform().getLogger().log(Level.WARNING, ChatUtil.jvmdowngrader$concat$jsonToLegacy$1(json), e2);
            }
            return "";
        }
    }

    public static String jsonToLegacy(JsonElement component) {
        if (component.isJsonNull() || component.isJsonArray() && component.getAsJsonArray().isEmpty() || component.isJsonObject() && component.getAsJsonObject().isEmpty()) {
            return "";
        }
        if (component.isJsonPrimitive()) {
            return component.getAsString();
        }
        try {
            LEGACY_REWRITER.processText(null, component);
            String legacy = ComponentUtil.jsonToLegacy(component);
            while (legacy.startsWith("\u00a7f")) {
                legacy = legacy.substring(2);
            }
            return legacy;
        }
        catch (Exception ex2) {
            if (!Via.getConfig().isSuppressConversionWarnings()) {
                ViaRewind.getPlatform().getLogger().log(Level.WARNING, ChatUtil.jvmdowngrader$concat$jsonToLegacy$1(String.valueOf(component)), ex2);
            }
            return "";
        }
    }

    public static String removeUnusedColor(String legacy, char last) {
        if (legacy == null) {
            return null;
        }
        legacy = UNUSED_COLOR_PATTERN.matcher(legacy).replaceAll("$1$2");
        StringBuilder builder = new StringBuilder();
        for (int i2 = 0; i2 < legacy.length(); ++i2) {
            char current = legacy.charAt(i2);
            if (current != '\u00a7' || i2 == legacy.length() - 1) {
                builder.append(current);
                continue;
            }
            if ((current = legacy.charAt(++i2)) == last) continue;
            builder.append('\u00a7').append(current);
            last = current;
        }
        return builder.toString();
    }

    private static /* synthetic */ String jvmdowngrader$concat$jsonToLegacy$1(String string) {
        return "Could not convert component to legacy text: " + string;
    }
}

