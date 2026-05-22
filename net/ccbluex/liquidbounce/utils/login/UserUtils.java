/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  org.apache.http.Header
 *  org.apache.http.HttpEntity
 *  org.apache.http.client.methods.CloseableHttpResponse
 *  org.apache.http.client.methods.HttpGet
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.entity.StringEntity
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.message.BasicHeader
 *  org.apache.http.util.EntityUtils
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils.login;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/utils/login/UserUtils;", "", "<init>", "()V", "isValidTokenOffline", "", "token", "", "isValidToken", "getUsername", "uuid", "getUUID", "username", "DarkMeow"})
public final class UserUtils {
    @NotNull
    public static final UserUtils INSTANCE = new UserUtils();

    private UserUtils() {
    }

    public final boolean isValidTokenOffline(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return token.length() >= 32;
    }

    public final boolean isValidToken(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        CloseableHttpClient client = HttpClients.createDefault();
        BasicHeader[] basicHeaderArray = new BasicHeader[]{new BasicHeader("Content-Type", "application/json")};
        BasicHeader[] headers = basicHeaderArray;
        HttpPost request = new HttpPost("https://authserver.mojang.com/validate");
        request.setHeaders((Header[])headers);
        JsonObject body = new JsonObject();
        body.addProperty("accessToken", token);
        request.setEntity((HttpEntity)new StringEntity(new Gson().toJson((JsonElement)body)));
        CloseableHttpResponse response = client.execute((HttpUriRequest)request);
        return response.getStatusLine().getStatusCode() == 204;
    }

    @Nullable
    public final String getUsername(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://api.mojang.com/user/profiles/" + uuid + "/names");
        CloseableHttpResponse response = client.execute((HttpUriRequest)request);
        if (response.getStatusLine().getStatusCode() != 200) {
            return null;
        }
        JsonArray names = new JsonParser().parse(EntityUtils.toString((HttpEntity)response.getEntity())).getAsJsonArray();
        return names.get(names.size() - 1).getAsJsonObject().get("name").getAsString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final String getUUID(@NotNull String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        try {
            URLConnection uRLConnection = new URL("https://api.mojang.com/users/profiles/minecraft/" + username).openConnection();
            Intrinsics.checkNotNull(uRLConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            HttpsURLConnection httpConnection = (HttpsURLConnection)uRLConnection;
            httpConnection.setConnectTimeout(2000);
            httpConnection.setReadTimeout(2000);
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            HttpURLConnection.setFollowRedirects(true);
            httpConnection.setDoOutput(true);
            if (httpConnection.getResponseCode() != 200) {
                return "";
            }
            Closeable closeable = new InputStreamReader(httpConnection.getInputStream());
            Throwable throwable = null;
            try {
                InputStreamReader it = (InputStreamReader)closeable;
                boolean bl2 = false;
                JsonElement jsonElement = new JsonParser().parse((Reader)it);
                if (jsonElement.isJsonObject()) {
                    String string = jsonElement.getAsJsonObject().get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
                    String string2 = string;
                    return string2;
                }
                Unit unit = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally(closeable, throwable);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return "";
    }
}

