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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.file.FileConfig;
import net.ccbluex.liquidbounce.file.FileManager;
import net.darkmeow.darkmeow.commands.CommandManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/file/impl/SpecialConfig;", "Lnet/ccbluex/liquidbounce/file/FileConfig;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "loadConfig", "", "config", "", "saveConfig", "DarkMeow"})
public final class SpecialConfig
extends FileConfig {
    public SpecialConfig(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        super(file);
    }

    @Override
    public void loadConfig(@NotNull String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        JsonObject json = new JsonParser().parse(config).getAsJsonObject();
        DarkMeow.INSTANCE.getCommandManager().setPrefix(".");
        if (json.has("prefix")) {
            CommandManager commandManager = DarkMeow.INSTANCE.getCommandManager();
            String string = json.get("prefix").getAsString();
            Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
            commandManager.setPrefix(string);
        }
    }

    @Override
    @NotNull
    public String saveConfig() {
        JsonObject json = new JsonObject();
        json.addProperty("prefix", DarkMeow.INSTANCE.getCommandManager().getPrefix());
        String string = FileManager.Companion.getPRETTY_GSON().toJson((JsonElement)json);
        Intrinsics.checkNotNullExpressionValue(string, "toJson(...)");
        return string;
    }
}

