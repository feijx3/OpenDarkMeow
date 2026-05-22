/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.io.CharStreams
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.util;

import com.google.common.io.CharStreams;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.ViaPlatform;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.dump.DumpTemplate;
import com.viaversion.viaversion.libs.gson.GsonBuilder;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.util.Config;
import com.viaversion.viaversion.util.GsonUtil;
import com.viaversion.viaversion.util.VersionInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={DumpErrorType.class, DumpException.class})
public final class DumpUtil {
    public static CompletableFuture<String> postDump(@Nullable UUID playerToSample) {
        ProtocolVersion protocolVersion = Via.getAPI().getServerVersion().lowestSupportedProtocolVersion();
        ViaPlatform platform = Via.getPlatform();
        com.viaversion.viaversion.dump.VersionInfo version = new com.viaversion.viaversion.dump.VersionInfo(System.getProperty("java.version"), System.getProperty("os.name"), protocolVersion.getVersion(), protocolVersion.getName(), Via.getManager().getProtocolManager().getSupportedVersions().stream().map(ProtocolVersion::toString).collect(Collectors.toCollection(LinkedHashSet::new)), platform.getPlatformName(), platform.getPlatformVersion(), platform.getPluginVersion(), VersionInfo.getImplementationVersion(), Via.getManager().getSubPlatforms());
        Map<String, Object> configuration = ((Config)((Object)Via.getConfig())).getValues();
        DumpTemplate template = new DumpTemplate(version, configuration, platform.getDump(), Via.getManager().getInjector().getDump(), DumpUtil.getPlayerSample(playerToSample));
        CompletableFuture<String> result = new CompletableFuture<String>();
        platform.runAsync(() -> {
            HttpURLConnection con;
            try {
                con = (HttpURLConnection)new URL("https://dump.viaversion.com/documents").openConnection();
            }
            catch (IOException e2) {
                platform.getLogger().log(Level.SEVERE, "Error when opening connection to ViaVersion dump service", e2);
                result.completeExceptionally(new DumpException(DumpErrorType.CONNECTION, (Throwable)e2));
                return;
            }
            try {
                String rawOutput;
                con.setRequestProperty("Content-Type", "application/json");
                con.addRequestProperty("User-Agent", DumpUtil.jvmdowngrader$concat$lambda$postDump$0$1(platform.getPlatformName(), version.pluginVersion()));
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                try (OutputStream out = con.getOutputStream();){
                    out.write(new GsonBuilder().setPrettyPrinting().create().toJson(template).getBytes(StandardCharsets.UTF_8));
                }
                if (con.getResponseCode() == 429) {
                    result.completeExceptionally(new DumpException(DumpErrorType.RATE_LIMITED));
                    return;
                }
                try (InputStream inputStream = con.getInputStream();){
                    rawOutput = CharStreams.toString((Readable)new InputStreamReader(inputStream));
                }
                JsonObject output = GsonUtil.getGson().fromJson(rawOutput, JsonObject.class);
                if (!output.has("key")) {
                    throw new InvalidObjectException("Key is not given in Hastebin output");
                }
                result.complete(DumpUtil.urlForId(output.get("key").getAsString()));
            }
            catch (Exception e3) {
                platform.getLogger().log(Level.SEVERE, "Error when posting ViaVersion dump", e3);
                result.completeExceptionally(new DumpException(DumpErrorType.POST, (Throwable)e3));
                DumpUtil.printFailureInfo(con);
            }
        });
        return result;
    }

    private static void printFailureInfo(HttpURLConnection connection) {
        block8: {
            try {
                if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 400) break block8;
                try (InputStream errorStream = connection.getErrorStream();){
                    String rawOutput = CharStreams.toString((Readable)new InputStreamReader(errorStream));
                    Via.getPlatform().getLogger().log(Level.SEVERE, DumpUtil.jvmdowngrader$concat$printFailureInfo$1(rawOutput));
                }
            }
            catch (IOException e2) {
                Via.getPlatform().getLogger().log(Level.SEVERE, "Failed to capture further info", e2);
            }
        }
    }

    public static String urlForId(String id) {
        return String.format("https://dump.viaversion.com/%s", id);
    }

    /*
     * WARNING - void declaration
     */
    private static JsonObject getPlayerSample(@Nullable UUID uuid) {
        UserConnection userConnection;
        JsonObject playerSample = new JsonObject();
        JsonObject versions = new JsonObject();
        playerSample.add("versions", versions);
        TreeMap<ProtocolVersion, Integer> playerVersions = new TreeMap<ProtocolVersion, Integer>(ProtocolVersion::compareTo);
        for (UserConnection userConnection2 : Via.getManager().getConnectionManager().getConnections()) {
            ProtocolVersion protocolVersion = userConnection2.getProtocolInfo().protocolVersion();
            playerVersions.compute(protocolVersion, (v2, num) -> num != null ? num + 1 : 1);
        }
        for (Map.Entry entry : playerVersions.entrySet()) {
            versions.addProperty(((ProtocolVersion)entry.getKey()).getName(), (Number)entry.getValue());
        }
        HashSet<List> pipelines = new HashSet<List>();
        if (uuid != null && (userConnection = Via.getAPI().getConnection(uuid)) != null && userConnection.getChannel() != null) {
            pipelines.add(userConnection.getChannel().pipeline().names());
        }
        for (UserConnection connection : Via.getManager().getConnectionManager().getConnections()) {
            List names;
            if (connection.getChannel() != null && pipelines.add(names = connection.getChannel().pipeline().names()) && pipelines.size() == 3) break;
        }
        boolean bl2 = false;
        for (List pipeline : pipelines) {
            void var5_12;
            JsonArray senderPipeline = new JsonArray(pipeline.size());
            for (String name : pipeline) {
                senderPipeline.add(name);
            }
            playerSample.add(DumpUtil.jvmdowngrader$concat$getPlayerSample$1((int)(++var5_12)), senderPipeline);
        }
        return playerSample;
    }

    private static String jvmdowngrader$concat$printFailureInfo$1(String string) {
        return "Page returned: " + string;
    }

    private static String jvmdowngrader$concat$getPlayerSample$1(int n2) {
        return "pipeline-" + n2;
    }

    private static String jvmdowngrader$concat$lambda$postDump$0$1(String string, String string2) {
        return "ViaVersion-" + string + "/" + string2;
    }

    @NestHost(value=DumpUtil.class)
    public static final class DumpException
    extends RuntimeException {
        private final DumpErrorType errorType;

        DumpException(DumpErrorType errorType, Throwable cause) {
            super(errorType.message(), cause);
            this.errorType = errorType;
        }

        DumpException(DumpErrorType errorType) {
            super(errorType.message());
            this.errorType = errorType;
        }

        public DumpErrorType errorType() {
            return this.errorType;
        }
    }

    @NestHost(value=DumpUtil.class)
    public static enum DumpErrorType {
        CONNECTION("Failed to dump, please check the console for more information"),
        RATE_LIMITED("Please wait before creating another dump"),
        POST("Failed to dump, please check the console for more information");

        private final String message;

        private DumpErrorType(String message) {
            this.message = message;
        }

        public String message() {
            return this.message;
        }
    }
}

