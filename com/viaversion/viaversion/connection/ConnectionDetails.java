/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.nio.charset.StandardCharsets;

public final class ConnectionDetails {
    public static final String PROXY_CHANNEL = "vv:proxy_details";
    public static final String MOD_CHANNEL = "vv:mod_details";
    public static final String APP_CHANNEL = "vv:app_details";

    public static void sendConnectionDetails(UserConnection connection, String channel) {
        ProtocolInfo protocolInfo = connection.getProtocolInfo();
        ProtocolVersion nativeVersion = protocolInfo.protocolVersion();
        ProtocolVersion serverVersion = protocolInfo.serverProtocolVersion();
        if (serverVersion.equals(nativeVersion)) {
            return;
        }
        String platformName = Via.getPlatform().getPlatformName();
        String platformVersion = Via.getPlatform().getPlatformVersion();
        JsonObject payload = new JsonObject();
        payload.addProperty("platformName", platformName);
        payload.addProperty("platformVersion", platformVersion);
        payload.addProperty("version", nativeVersion.getOriginalVersion());
        payload.addProperty("versionName", nativeVersion.getName());
        Via.getPlatform().sendCustomPayload(connection, channel, payload.toString().getBytes(StandardCharsets.UTF_8));
    }
}

