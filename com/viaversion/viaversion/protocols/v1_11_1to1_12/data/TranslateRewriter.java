/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_11_1to1_12.data;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.data.AchievementTranslations1_12;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import java.util.logging.Level;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public class TranslateRewriter {
    private static final JsonNBTComponentRewriter<ClientboundPackets1_9_3> ACHIEVEMENT_TEXT_REWRITER = new JsonNBTComponentRewriter<ClientboundPackets1_9_3>(null, ComponentRewriterBase.ReadType.JSON){

        @Override
        protected void handleTranslate(JsonObject object, String translate) {
            String text = AchievementTranslations1_12.get(translate);
            if (text != null) {
                object.addProperty("translate", text);
            }
        }

        @Override
        protected void handleHoverEvent(UserConnection connection, JsonObject hoverEvent) {
            String action = hoverEvent.getAsJsonPrimitive("action").getAsString();
            if (!action.equals("show_achievement")) {
                super.handleHoverEvent(connection, hoverEvent);
                return;
            }
            String textValue = SerializerVersion.V1_9.toComponent(hoverEvent.get("value")).asUnformattedString();
            if (AchievementTranslations1_12.get(textValue) == null) {
                JsonObject invalidText = new JsonObject();
                invalidText.addProperty("text", "Invalid statistic/achievement!");
                invalidText.addProperty("color", "red");
                hoverEvent.addProperty("action", "show_text");
                hoverEvent.add("value", invalidText);
                super.handleHoverEvent(connection, hoverEvent);
                return;
            }
            try {
                JsonObject newLine = new JsonObject();
                newLine.addProperty("text", "\n");
                JsonArray baseArray = new JsonArray();
                baseArray.add("");
                JsonObject namePart = new JsonObject();
                JsonObject typePart = new JsonObject();
                baseArray.add(namePart);
                baseArray.add(newLine);
                baseArray.add(typePart);
                if (textValue.startsWith("achievement")) {
                    namePart.addProperty("translate", textValue);
                    namePart.addProperty("color", AchievementTranslations1_12.isSpecial(textValue) ? "dark_purple" : "green");
                    typePart.addProperty("translate", "stats.tooltip.type.achievement");
                    JsonObject description = new JsonObject();
                    typePart.addProperty("italic", true);
                    description.addProperty("translate", 1.jvmdowngrader$concat$handleHoverEvent$1(textValue));
                    baseArray.add(newLine);
                    baseArray.add(description);
                } else if (textValue.startsWith("stat")) {
                    namePart.addProperty("translate", textValue);
                    namePart.addProperty("color", "gray");
                    typePart.addProperty("translate", "stats.tooltip.type.statistic");
                    typePart.addProperty("italic", true);
                }
                hoverEvent.addProperty("action", "show_text");
                hoverEvent.add("value", baseArray);
            }
            catch (Exception e2) {
                if (!Via.getConfig().isSuppressConversionWarnings()) {
                    this.protocol.getLogger().log(Level.WARNING, 1.jvmdowngrader$concat$handleHoverEvent$2(StringUtil.forLogging(hoverEvent)), e2);
                }
                JsonObject invalidText = new JsonObject();
                invalidText.addProperty("text", "Invalid statistic/achievement!");
                invalidText.addProperty("color", "red");
                hoverEvent.addProperty("action", "show_text");
                hoverEvent.add("value", invalidText);
            }
            super.handleHoverEvent(connection, hoverEvent);
        }

        private static String jvmdowngrader$concat$handleHoverEvent$1(String string) {
            return string + ".desc";
        }

        private static String jvmdowngrader$concat$handleHoverEvent$2(String string) {
            return "Error rewriting show_achievement: " + string;
        }
    };

    public static void toClient(UserConnection connection, JsonElement element) {
        JsonObject obj;
        JsonElement translate;
        if (element instanceof JsonObject && (translate = (obj = (JsonObject)element).get("translate")) != null && translate.getAsString().startsWith("chat.type.achievement")) {
            ACHIEVEMENT_TEXT_REWRITER.processText(connection, obj);
        }
    }
}

