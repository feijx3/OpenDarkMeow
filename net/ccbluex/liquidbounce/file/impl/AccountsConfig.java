/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.google.gson.JsonSyntaxException
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import me.liuli.elixir.account.MinecraftAccount;
import me.liuli.elixir.manage.AccountSerializer;
import net.ccbluex.liquidbounce.file.FileConfig;
import net.ccbluex.liquidbounce.file.FileManager;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/file/impl/AccountsConfig;", "Lnet/ccbluex/liquidbounce/file/FileConfig;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "altManagerMinecraftAccounts", "", "Lme/liuli/elixir/account/MinecraftAccount;", "getAltManagerMinecraftAccounts", "()Ljava/util/List;", "loadConfig", "", "config", "", "saveConfig", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAccountsConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountsConfig.kt\nnet/ccbluex/liquidbounce/file/impl/AccountsConfig\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1869#2,2:47\n1869#2,2:49\n1869#2,2:51\n*S KotlinDebug\n*F\n+ 1 AccountsConfig.kt\nnet/ccbluex/liquidbounce/file/impl/AccountsConfig\n*L\n23#1:47,2\n30#1:49,2\n40#1:51,2\n*E\n"})
public final class AccountsConfig
extends FileConfig {
    @NotNull
    private final List<MinecraftAccount> altManagerMinecraftAccounts;

    public AccountsConfig(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        super(file);
        this.altManagerMinecraftAccounts = new ArrayList();
    }

    @NotNull
    public final List<MinecraftAccount> getAltManagerMinecraftAccounts() {
        return this.altManagerMinecraftAccounts;
    }

    @Override
    public void loadConfig(@NotNull String config) {
        Object object;
        Intrinsics.checkNotNullParameter(config, "config");
        this.altManagerMinecraftAccounts.clear();
        try {
            object = new JsonParser().parse(config).getAsJsonArray();
        }
        catch (JsonSyntaxException e2) {
            JsonArray jsonArray = new JsonArray();
            JsonArray it = jsonArray;
            boolean bl2 = false;
            String[] stringArray = new String[]{"\n"};
            Iterable $this$forEach$iv = StringsKt.split$default((CharSequence)config, stringArray, false, 0, 6, null);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String str = (String)element$iv;
                boolean bl3 = false;
                String[] stringArray2 = new String[]{":"};
                List information = StringsKt.split$default((CharSequence)str, stringArray2, false, 0, 6, null);
                it.add((JsonElement)AccountSerializer.INSTANCE.toJson(AccountSerializer.INSTANCE.accountInstance((String)information.get(0), (String)information.get(1))));
            }
            object = jsonArray;
        }
        JsonArray json = object;
        Intrinsics.checkNotNull(json);
        Iterable $this$forEach$iv = (Iterable)json;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MinecraftAccount minecraftAccount;
            JsonElement jsonElement = (JsonElement)element$iv;
            boolean bl4 = false;
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject, "getAsJsonObject(...)");
            MinecraftAccount it = minecraftAccount = AccountSerializer.INSTANCE.fromJson(jsonObject);
            boolean bl5 = false;
            this.altManagerMinecraftAccounts.add(it);
        }
    }

    @Override
    @NotNull
    public String saveConfig() {
        JsonArray json = new JsonArray();
        Iterable $this$forEach$iv = this.altManagerMinecraftAccounts;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MinecraftAccount it = (MinecraftAccount)element$iv;
            boolean bl2 = false;
            json.add((JsonElement)AccountSerializer.INSTANCE.toJson(it));
        }
        String string = FileManager.Companion.getPRETTY_GSON().toJson((JsonElement)json);
        Intrinsics.checkNotNullExpressionValue(string, "toJson(...)");
        return string;
    }
}

