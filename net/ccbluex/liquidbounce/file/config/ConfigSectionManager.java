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
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.ccbluex.liquidbounce.file.FileManager;
import net.ccbluex.liquidbounce.file.config.ConfigManager;
import net.ccbluex.liquidbounce.file.config.sections.ConfigSection;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0011J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/file/config/ConfigSectionManager;", "", "manager", "Lnet/ccbluex/liquidbounce/file/config/ConfigManager;", "<init>", "(Lnet/ccbluex/liquidbounce/file/config/ConfigManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/file/config/ConfigManager;", "sections", "", "Lnet/ccbluex/liquidbounce/file/config/sections/ConfigSection;", "registerAllSections", "", "registerSection", "", "section", "clazz", "Ljava/lang/Class;", "loadSectionsFromFile", "saveSectionsToFile", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nConfigSectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigSectionManager.kt\nnet/ccbluex/liquidbounce/file/config/ConfigSectionManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,130:1\n1869#2,2:131\n1869#2:133\n1870#2:135\n2756#2:136\n1#3:134\n1#3:137\n*S KotlinDebug\n*F\n+ 1 ConfigSectionManager.kt\nnet/ccbluex/liquidbounce/file/config/ConfigSectionManager\n*L\n28#1:131,2\n78#1:133\n78#1:135\n110#1:136\n110#1:137\n*E\n"})
public final class ConfigSectionManager {
    @NotNull
    private final ConfigManager manager;
    @JvmField
    @NotNull
    public final Set<ConfigSection> sections;

    public ConfigSectionManager(@NotNull ConfigManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.sections = new LinkedHashSet();
    }

    @NotNull
    public final ConfigManager getManager() {
        return this.manager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void registerAllSections() {
        Set<ConfigSection> set = this.sections;
        synchronized (set) {
            boolean bl2 = false;
            this.sections.clear();
            Iterable $this$forEach$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".sections", ConfigSection.class);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Class p0 = (Class)element$iv;
                boolean bl3 = false;
                this.registerSection(p0);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean registerSection(@NotNull ConfigSection section) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(section, "section");
        Set<ConfigSection> set = this.sections;
        synchronized (set) {
            boolean bl3 = false;
            bl2 = this.sections.add(section);
        }
        return bl2;
    }

    public final boolean registerSection(@NotNull Class<? extends ConfigSection> clazz) {
        Object object;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object object2 = this;
        try {
            ConfigSectionManager $this$registerSection_u24lambda_u242 = object2;
            boolean bl2 = false;
            ConfigSection configSection = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNullExpressionValue(configSection, "newInstance(...)");
            object = Result.constructor-impl($this$registerSection_u24lambda_u242.registerSection(configSection));
        }
        catch (Throwable bl2) {
            object = Result.constructor-impl(ResultKt.createFailure(bl2));
        }
        object2 = object;
        Throwable throwable = Result.exceptionOrNull-impl(object2);
        if (throwable != null) {
            Object t2 = object = throwable;
            boolean bl3 = false;
            ClientUtils.INSTANCE.logError("Failed to load config section: " + clazz.getName(), (Throwable)t2);
        }
        object = false;
        return (Boolean)(Result.isFailure-impl(object2) ? object : object2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean loadSectionsFromFile() {
        Object object;
        Object $this$loadSectionsFromFile_u24lambda_u2415_u24lambda_u244;
        File file = new File(this.manager.getSystem().getFileManager().getConfigsDir(), this.manager.getCurrentConfig() + ".json");
        boolean bl2 = false;
        Object object2 = this;
        try {
            JsonObject jsonObject;
            $this$loadSectionsFromFile_u24lambda_u2415_u24lambda_u244 = object2;
            boolean bl3 = false;
            if (file.exists()) {
                File file2 = file;
                Charset charset = Charsets.UTF_8;
                jsonObject = new JsonParser().parse((Reader)new InputStreamReader((InputStream)new FileInputStream(file2), charset)).getAsJsonObject();
            } else {
                jsonObject = new JsonObject();
            }
            $this$loadSectionsFromFile_u24lambda_u2415_u24lambda_u244 = Result.constructor-impl(jsonObject);
        }
        catch (Throwable bl3) {
            $this$loadSectionsFromFile_u24lambda_u2415_u24lambda_u244 = Result.constructor-impl(ResultKt.createFailure(bl3));
        }
        object2 = $this$loadSectionsFromFile_u24lambda_u2415_u24lambda_u244;
        Throwable throwable = Result.exceptionOrNull-impl(object2);
        if (throwable != null) {
            Object t2 = $this$loadSectionsFromFile_u24lambda_u2415_u24lambda_u244 = throwable;
            boolean bl4 = false;
            ClientUtils.INSTANCE.logError("Config " + FilesKt.getNameWithoutExtension(file) + ".json load failed.", (Throwable)t2);
        }
        Object it = object2;
        boolean bl5 = false;
        Object object3 = it;
        Throwable throwable2 = Result.exceptionOrNull-impl(object3);
        if (throwable2 == null) {
            object = object3;
        } else {
            Throwable it2 = throwable2;
            boolean bl6 = false;
            object = new JsonObject();
        }
        object3 = object;
        JsonObject json = (JsonObject)object3;
        boolean bl7 = false;
        Set<ConfigSection> set = this.sections;
        synchronized (set) {
            boolean bl8 = false;
            Iterable $this$forEach$iv = this.sections;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Object object4;
                JsonObject jsonObject;
                ConfigSection section = (ConfigSection)element$iv;
                boolean bl9 = false;
                JsonObject it3 = jsonObject = json;
                boolean bl10 = false;
                Object object5 = json.has(section.getSectionName()) ? jsonObject : null;
                if (object5 == null) continue;
                it3 = jsonObject = object5;
                boolean bl11 = false;
                Object object6 = this;
                try {
                    ConfigSectionManager $this$loadSectionsFromFile_u24lambda_u2415_u24lambda_u2414_u24lambda_u2413_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410_u24lambda_u248 = object6;
                    boolean bl12 = false;
                    JsonElement jsonElement = json.get(section.getSectionName());
                    Intrinsics.checkNotNullExpressionValue(jsonElement, "get(...)");
                    object4 = Result.constructor-impl(section.load(jsonElement));
                }
                catch (Throwable bl12) {
                    object4 = Result.constructor-impl(ResultKt.createFailure(bl12));
                }
                object6 = object4;
                Throwable throwable3 = Result.exceptionOrNull-impl(object6);
                if (throwable3 == null) continue;
                Object t3 = object4 = throwable3;
                boolean bl13 = false;
                ClientUtils.INSTANCE.logError("Config " + FilesKt.getNameWithoutExtension(file) + ".json / " + section.getSectionName() + " load failed.", (Throwable)t3);
            }
            Unit unit = Unit.INSTANCE;
        }
        return Result.isSuccess-impl(object2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean saveSectionsToFile() {
        Object object;
        File file = new File(this.manager.getSystem().getFileManager().getConfigsDir(), this.manager.getCurrentConfig() + ".json");
        boolean bl2 = false;
        Object object2 = this;
        try {
            JsonObject jsonObject;
            ConfigSectionManager $this$saveSectionsToFile_u24lambda_u2423_u24lambda_u2420 = object2;
            boolean bl3 = false;
            JsonObject $this$saveSectionsToFile_u24lambda_u2423_u24lambda_u2420_u24lambda_u2418 = jsonObject = new JsonObject();
            boolean bl4 = false;
            Set<ConfigSection> set = $this$saveSectionsToFile_u24lambda_u2423_u24lambda_u2420.sections;
            synchronized (set) {
                Iterable iterable;
                boolean bl5 = false;
                Iterable $this$onEach$iv = $this$saveSectionsToFile_u24lambda_u2423_u24lambda_u2420.sections;
                boolean $i$f$onEach = false;
                Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
                boolean bl6 = false;
                for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                    ConfigSection it = (ConfigSection)element$iv;
                    boolean bl7 = false;
                    $this$saveSectionsToFile_u24lambda_u2423_u24lambda_u2420_u24lambda_u2418.add(it.getSectionName(), it.save());
                }
                Unit unit = Unit.INSTANCE;
            }
            JsonObject it = jsonObject;
            boolean bl8 = false;
            String string = FileManager.Companion.getPRETTY_GSON().toJson((JsonElement)it);
            Intrinsics.checkNotNullExpressionValue(string, "toJson(...)");
            FilesKt.writeText(file, string, Charsets.UTF_8);
            object = Result.constructor-impl(jsonObject);
        }
        catch (Throwable bl3) {
            object = Result.constructor-impl(ResultKt.createFailure(bl3));
        }
        object2 = object;
        Throwable throwable = Result.exceptionOrNull-impl(object2);
        if (throwable != null) {
            Object t2 = object = throwable;
            boolean bl9 = false;
            ClientUtils.INSTANCE.logError("Config " + FilesKt.getNameWithoutExtension(file) + ".json save failed.", (Throwable)t2);
        }
        if (Result.isSuccess-impl(object2)) {
            JsonObject cfr_ignored_0 = (JsonObject)object2;
            boolean bl10 = false;
            ClientUtils.INSTANCE.logInfo("Config " + FilesKt.getNameWithoutExtension(file) + ".json saved.");
        }
        return Result.isSuccess-impl(object2);
    }
}

