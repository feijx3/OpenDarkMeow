/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.network.PacketBuffer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.server;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.HytPacket;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.utils.HytPacketUtils;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R-\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0014j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u0014\u0010\u001b\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007\u00a8\u0006\""}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/server/SPacketHytVexView;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket;", "<init>", "()V", "sutType", "", "getSutType", "()Ljava/lang/String;", "setSutType", "(Ljava/lang/String;)V", "type", "getType", "setType", "json", "Lcom/google/gson/JsonElement;", "getJson", "()Lcom/google/gson/JsonElement;", "setJson", "(Lcom/google/gson/JsonElement;)V", "buttonList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getButtonList", "()Ljava/util/HashMap;", "buttonMode", "getButtonMode", "setButtonMode", "channel", "getChannel", "process", "", "byteBuf", "Lnet/minecraft/network/PacketBuffer;", "Companion", "DarkMeow"})
public final class SPacketHytVexView
extends HytPacket {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private String sutType = "";
    @NotNull
    private String type = "";
    @Nullable
    private JsonElement json;
    @NotNull
    private final HashMap<String, String> buttonList = new HashMap();
    @NotNull
    private String buttonMode = "normal";
    @NotNull
    private final String channel;
    @NotNull
    public static final String CHANNEL = "VexView";

    public SPacketHytVexView() {
        this.channel = CHANNEL;
    }

    @NotNull
    public final String getSutType() {
        return this.sutType;
    }

    public final void setSutType(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.sutType = string;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final void setType(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.type = string;
    }

    @Nullable
    public final JsonElement getJson() {
        return this.json;
    }

    public final void setJson(@Nullable JsonElement jsonElement) {
        this.json = jsonElement;
    }

    @NotNull
    public final HashMap<String, String> getButtonList() {
        return this.buttonList;
    }

    @NotNull
    public final String getButtonMode() {
        return this.buttonMode;
    }

    public final void setButtonMode(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.buttonMode = string;
    }

    @Override
    @NotNull
    public String getChannel() {
        return this.channel;
    }

    @Override
    public void process(@NotNull PacketBuffer byteBuf) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(byteBuf, "byteBuf");
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(HytPacketUtils.INSTANCE.decodePacketByte(byteBuf)).getAsJsonObject();
        String string = jsonObject.get("packet_sub_type").getAsString();
        Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
        this.sutType = string;
        String string2 = jsonObject.get("packet_type").getAsString();
        Intrinsics.checkNotNullExpressionValue(string2, "getAsString(...)");
        this.type = string2;
        SPacketHytVexView sPacketHytVexView = this;
        SPacketHytVexView sPacketHytVexView2 = this;
        boolean bl2 = false;
        JsonElement data = jsonObject.get("packet_data");
        try {
            jsonElement = (JsonElement)jsonParser.parse(data.getAsString()).getAsJsonObject();
        }
        catch (Exception e2) {
            jsonElement = data;
        }
        sPacketHytVexView2.json = jsonElement;
        if (this.json instanceof JsonObject) {
            JsonElement jsonElement2 = this.json;
            Intrinsics.checkNotNull(jsonElement2, "null cannot be cast to non-null type com.google.gson.JsonObject");
            Set data2 = ((JsonObject)jsonElement2).entrySet();
            for (Map.Entry it : data2) {
                List sub;
                String[] stringArray;
                int index2;
                List elements;
                String string3 = (String)it.getKey();
                if (Intrinsics.areEqual(string3, "base")) {
                    this.buttonMode = "normal";
                    String string4 = ((JsonElement)it.getValue()).getAsString();
                    Intrinsics.checkNotNullExpressionValue(string4, "getAsString(...)");
                    String[] stringArray2 = new String[]{"<#>"};
                    elements = StringsKt.split$default((CharSequence)string4, stringArray2, false, 0, 6, null);
                    for (index2 = 0; index2 < elements.size(); ++index2) {
                        if (!StringsKt.contains$default((CharSequence)elements.get(index2), "[but]", false, 2, null)) continue;
                        stringArray = new String[]{"<&>"};
                        sub = StringsKt.split$default((CharSequence)elements.get(index2), stringArray, false, 0, 6, null);
                        ((Map)this.buttonList).put(StringsKt.drop((String)sub.get(0), 5), sub.get(6));
                    }
                    continue;
                }
                if (!Intrinsics.areEqual(string3, "scrollinglist")) continue;
                this.buttonMode = "switcher";
                String string5 = ((JsonElement)it.getValue()).getAsString();
                Intrinsics.checkNotNullExpressionValue(string5, "getAsString(...)");
                String[] index2 = new String[]{"<#>"};
                elements = StringsKt.split$default((CharSequence)string5, index2, false, 0, 6, null);
                for (index2 = 0; index2 < elements.size(); ++index2) {
                    if (!StringsKt.contains$default((CharSequence)elements.get(index2), "[but]", false, 2, null)) continue;
                    stringArray = new String[]{"<&>"};
                    sub = StringsKt.split$default((CharSequence)elements.get(index2), stringArray, false, 0, 6, null);
                    ((Map)this.buttonList).put(StringsKt.drop((String)sub.get(0), 5), sub.get(6));
                }
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/server/SPacketHytVexView$Companion;", "", "<init>", "()V", "CHANNEL", "", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

