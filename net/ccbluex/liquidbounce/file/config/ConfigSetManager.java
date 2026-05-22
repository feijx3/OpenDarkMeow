/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.file.FileManager;
import net.ccbluex.liquidbounce.file.config.ConfigManager;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/file/config/ConfigSetManager;", "", "manager", "Lnet/ccbluex/liquidbounce/file/config/ConfigManager;", "<init>", "(Lnet/ccbluex/liquidbounce/file/config/ConfigManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/file/config/ConfigManager;", "configSetFile", "Ljava/io/File;", "currentConfig", "", "load", "save", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nConfigSetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigSetManager.kt\nnet/ccbluex/liquidbounce/file/config/ConfigSetManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class ConfigSetManager {
    @NotNull
    private final ConfigManager manager;
    @JvmField
    @NotNull
    public final File configSetFile;
    @JvmField
    @NotNull
    public String currentConfig;

    public ConfigSetManager(@NotNull ConfigManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.configSetFile = new File(DarkMeow.INSTANCE.getFileManager().getDir(), "config-settings.json");
        this.currentConfig = "default";
    }

    @NotNull
    public final ConfigManager getManager() {
        return this.manager;
    }

    @NotNull
    public final String load() {
        Object $this$load_u24lambda_u240;
        Object object = this;
        try {
            $this$load_u24lambda_u240 = object;
            boolean bl2 = false;
            File file = ((ConfigSetManager)$this$load_u24lambda_u240).configSetFile;
            Charset charset = Charsets.UTF_8;
            $this$load_u24lambda_u240 = Result.constructor-impl(new JsonParser().parse((Reader)new InputStreamReader((InputStream)new FileInputStream(file), charset)).getAsJsonObject().get("config").getAsString());
        }
        catch (Throwable bl2) {
            $this$load_u24lambda_u240 = Result.constructor-impl(ResultKt.createFailure(bl2));
        }
        object = $this$load_u24lambda_u240;
        $this$load_u24lambda_u240 = "default";
        object = Result.isFailure-impl(object) ? $this$load_u24lambda_u240 : object;
        String it = (String)object;
        boolean bl3 = false;
        Intrinsics.checkNotNull(it);
        this.currentConfig = it;
        Object object2 = object;
        Intrinsics.checkNotNullExpressionValue(object2, "also(...)");
        return (String)object2;
    }

    public final boolean save() {
        Object object;
        block2: {
            Object object2;
            JsonObject jsonObject;
            JsonObject $this$save_u24lambda_u242 = jsonObject = new JsonObject();
            boolean bl2 = false;
            $this$save_u24lambda_u242.addProperty("config", this.currentConfig);
            JsonObject json = jsonObject;
            boolean bl3 = false;
            object = this;
            try {
                ConfigSetManager $this$save_u24lambda_u245_u24lambda_u243 = object;
                boolean bl4 = false;
                File file = $this$save_u24lambda_u245_u24lambda_u243.configSetFile;
                String string = FileManager.Companion.getPRETTY_GSON().toJson((JsonElement)json);
                Intrinsics.checkNotNullExpressionValue(string, "toJson(...)");
                FilesKt.writeText(file, string, Charsets.UTF_8);
                object2 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch (Throwable bl4) {
                object2 = Result.constructor-impl(ResultKt.createFailure(bl4));
            }
            object = object2;
            Throwable throwable = Result.exceptionOrNull-impl(object);
            if (throwable == null) break block2;
            Object t2 = object2 = throwable;
            boolean bl5 = false;
            ClientUtils.INSTANCE.logError("Config Set save failed.", (Throwable)t2);
        }
        return Result.isSuccess-impl(object);
    }
}

