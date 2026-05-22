/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.network.play.server.SPacketChat
 *  org.apache.http.HttpEntity
 *  org.apache.http.client.methods.CloseableHttpResponse
 *  org.apache.http.client.methods.HttpGet
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.util.EntityUtils
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.network.play.server.SPacketChat;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="ChatTranslator", description="ChatTranslator", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/ChatTranslator;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "languageValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "apiValue", "client", "Lorg/apache/http/impl/client/CloseableHttpClient;", "kotlin.jvm.PlatformType", "cache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "getLink", "msg", "getResult", "data", "doTranslate", "DarkMeow"})
public final class ChatTranslator
extends Module {
    @NotNull
    public static final ChatTranslator INSTANCE = new ChatTranslator();
    @NotNull
    private static final ListValue languageValue;
    @NotNull
    private static final ListValue apiValue;
    private static final CloseableHttpClient client;
    @NotNull
    private static final HashMap<String, String> cache;

    private ChatTranslator() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPacket() instanceof SPacketChat) {
            String msg = ((SPacketChat)event.getPacket()).func_148915_c().func_150254_d();
            if (!((Map)cache).containsKey(msg)) {
                Intrinsics.checkNotNull(msg);
                this.doTranslate(msg);
            } else {
                String string;
                if (cache.containsKey(msg)) {
                    string = msg;
                } else {
                    String string2 = cache.get(msg);
                    Intrinsics.checkNotNull(string2);
                    string = string2;
                }
                String string3 = string;
                Intrinsics.checkNotNull(string3);
                ClientUtils.displayChatMessage(string3);
            }
            event.cancelEvent();
        }
    }

    private final String getLink(String msg) {
        String string;
        String message = StringsKt.replace$default(msg, " ", "%20", false, 4, null);
        String string2 = ((String)apiValue.get()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
        switch (string2) {
            case "google": {
                string = "http://translate.google.cn/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=" + (languageValue.equals("chinese") ? "zh_cn" : "en_us") + "&q=" + message;
                break;
            }
            case "bing": {
                string = "http://api.microsofttranslator.com/v2/Http.svc/Translate?appId=A4D660A48A6A97CCA791C34935E4C02BBB1BEC1C&from=&to=" + (languageValue.equals("chinese") ? "zh" : "en") + "&text=" + message;
                break;
            }
            case "youdao": {
                string = "http://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i=" + message;
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    private final String getResult(String data) {
        String string = ((String)apiValue.get()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        switch (string) {
            case "google": {
                JsonObject json = new JsonParser().parse(data).getAsJsonObject();
                String string2 = json.get("sentences").getAsJsonArray().get(0).getAsJsonObject().get("trans").getAsString();
                Intrinsics.checkNotNullExpressionValue(string2, "getAsString(...)");
                return string2;
            }
            case "bing": {
                return StringsKt.replace$default(StringsKt.replace$default(data, "<string xmlns=\"http://schemas.microsoft.com/2003/10/Serialization/\">", "", false, 4, null), "</string>", "", false, 4, null);
            }
            case "youdao": {
                JsonObject json = new JsonParser().parse(data).getAsJsonObject();
                String string3 = json.get("translateResult").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsJsonObject().get("tgt").getAsString();
                Intrinsics.checkNotNullExpressionValue(string3, "getAsString(...)");
                return string3;
            }
        }
        return "WRONG VALUE";
    }

    private final void doTranslate(String msg) {
        new Thread(() -> ChatTranslator.doTranslate$lambda$0(msg)).start();
    }

    private static final void doTranslate$lambda$0(String $msg) {
        try {
            HttpGet request = new HttpGet(INSTANCE.getLink($msg));
            CloseableHttpResponse response = client.execute((HttpUriRequest)request);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new IllegalStateException("resp code: " + response.getStatusLine().getStatusCode() + " != 200");
            }
            String string = EntityUtils.toString((HttpEntity)response.getEntity());
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String result = INSTANCE.getResult(string);
            ((Map)cache).put($msg, result);
            ClientUtils.displayChatMessage(result);
        }
        catch (Exception e2) {
            e2.printStackTrace();
            ClientUtils.displayChatMessage($msg);
        }
    }

    static {
        String[] stringArray = new String[]{"Chinese", "English"};
        languageValue = new ListValue("Language", stringArray, "Chinese");
        stringArray = new String[]{"Google", "Bing", "YouDao"};
        apiValue = new ListValue("API", stringArray, "Bing");
        client = HttpClients.createDefault();
        cache = new HashMap();
    }
}

