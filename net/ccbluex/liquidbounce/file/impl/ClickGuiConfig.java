/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.file.FileConfig;
import net.ccbluex.liquidbounce.file.FileManager;
import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/file/impl/ClickGuiConfig;", "Lnet/ccbluex/liquidbounce/file/FileConfig;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "loadConfig", "", "config", "", "saveConfig", "DarkMeow"})
public final class ClickGuiConfig
extends FileConfig {
    public ClickGuiConfig(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        super(file);
    }

    @Override
    public void loadConfig(@NotNull String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        JsonElement jsonElement = new JsonParser().parse(config);
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject)jsonElement : null;
        if (jsonObject == null) {
            return;
        }
        JsonObject rootObject = jsonObject;
        JsonObject categoryObject = rootObject.getAsJsonObject("category");
        for (Panel panel : DarkMeow.INSTANCE.getClickGuiManager().getCui().getPanels()) {
            String string = panel.name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            if (!categoryObject.has(string)) continue;
            try {
                String string2 = panel.name.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
                JsonObject panelObject = categoryObject.getAsJsonObject(string2);
                panel.setOpen(panelObject.get("open").getAsBoolean());
                panel.setVisible(panelObject.get("visible").getAsBoolean());
                panel.x = panelObject.get("posX").getAsInt();
                panel.y = panelObject.get("posY").getAsInt();
            }
            catch (Exception e2) {
                ClientUtils.logger.error("Error while loading clickgui panel with the name '" + panel.name + "'.", (Throwable)e2);
            }
        }
    }

    @Override
    @NotNull
    public String saveConfig() {
        JsonObject rootObject = new JsonObject();
        JsonObject categoryObject = new JsonObject();
        for (Panel panel : DarkMeow.INSTANCE.getClickGuiManager().getCui().getPanels()) {
            JsonObject panelObject = new JsonObject();
            panelObject.addProperty("open", Boolean.valueOf(panel.getOpen()));
            panelObject.addProperty("visible", Boolean.valueOf(panel.isVisible()));
            panelObject.addProperty("posX", (Number)panel.x);
            panelObject.addProperty("posY", (Number)panel.y);
            String string = panel.name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            categoryObject.add(string, (JsonElement)panelObject);
        }
        rootObject.add("category", (JsonElement)categoryObject);
        String string = FileManager.Companion.getPRETTY_GSON().toJson((JsonElement)rootObject);
        Intrinsics.checkNotNullExpressionValue(string, "toJson(...)");
        return string;
    }
}

