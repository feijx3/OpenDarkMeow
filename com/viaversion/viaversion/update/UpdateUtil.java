/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.update;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.update.Version;
import com.viaversion.viaversion.util.GsonUtil;
import com.viaversion.viaversion.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class UpdateUtil {
    private static final String PREFIX = "\u00a7a\u00a7l[ViaVersion] \u00a7a";
    private static final String URL = "https://update.viaversion.com/";
    private static final String PLUGIN = "ViaVersion/";

    public static void sendUpdateMessage(UserConnection connection) {
        Via.getPlatform().runAsync(() -> {
            Pair<Level, String> message = UpdateUtil.getUpdateMessage(false);
            if (message != null) {
                Via.getPlatform().runSync(() -> Via.getPlatform().sendMessage(connection, UpdateUtil.jvmdowngrader$concat$lambda$sendUpdateMessage$0$1((String)message.value())));
            }
        });
    }

    public static void sendUpdateMessage() {
        Via.getPlatform().runAsync(() -> {
            Pair<Level, String> message = UpdateUtil.getUpdateMessage(true);
            if (message != null) {
                Via.getPlatform().runSync(() -> Via.getPlatform().getLogger().log((Level)message.key(), (String)message.value()));
            }
        });
    }

    private static @Nullable Pair<Level, String> getUpdateMessage(boolean console) {
        Version current;
        String newestString;
        if (Via.getPlatform().getPluginVersion().equals("${version}")) {
            return new Pair<Level, String>(Level.WARNING, "You are using a debug/custom version, consider updating.");
        }
        try {
            newestString = UpdateUtil.getNewestVersion();
        }
        catch (JsonParseException | IOException ignored) {
            return console ? new Pair<Level, String>(Level.WARNING, "Could not check for updates, check your connection.") : null;
        }
        try {
            current = new Version(Via.getPlatform().getPluginVersion());
        }
        catch (IllegalArgumentException e2) {
            return new Pair<Level, String>(Level.INFO, "You are using a custom version, consider updating.");
        }
        Version newest = new Version(newestString);
        if (current.compareTo(newest) < 0) {
            return new Pair<Level, String>(Level.WARNING, UpdateUtil.jvmdowngrader$concat$getUpdateMessage$1(String.valueOf(newest), String.valueOf(current)));
        }
        if (console && current.compareTo(newest) != 0) {
            String tag = current.getTag().toLowerCase(Locale.ROOT);
            if (tag.endsWith("dev") || tag.endsWith("snapshot")) {
                return new Pair<Level, String>(Level.INFO, "You are running a development version of the plugin, please report any bugs to GitHub.");
            }
            return new Pair<Level, String>(Level.WARNING, "You are running a newer version of the plugin than is released!");
        }
        return null;
    }

    private static String getNewestVersion() throws IOException {
        URL url = new URL("https://update.viaversion.com/ViaVersion/");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setUseCaches(false);
        connection.addRequestProperty("User-Agent", UpdateUtil.jvmdowngrader$concat$getNewestVersion$1(Via.getPlatform().getPluginVersion(), Via.getPlatform().getPlatformName()));
        connection.addRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));){
            String input;
            while ((input = reader.readLine()) != null) {
                builder.append(input);
            }
        }
        JsonObject statistics = GsonUtil.getGson().fromJson(builder.toString(), JsonObject.class);
        return statistics.get("name").getAsString();
    }

    private static String jvmdowngrader$concat$getUpdateMessage$1(String string, String string2) {
        return "There is a newer plugin version available: " + string + ", you're on: " + string2;
    }

    private static String jvmdowngrader$concat$getNewestVersion$1(String string, String string2) {
        return "ViaVersion " + string + " " + string2;
    }

    private static String jvmdowngrader$concat$lambda$sendUpdateMessage$0$1(String string) {
        return PREFIX + string;
    }
}

