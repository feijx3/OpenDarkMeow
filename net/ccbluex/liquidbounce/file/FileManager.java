/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.file.FileConfig;
import net.ccbluex.liquidbounce.file.impl.AccountsConfig;
import net.ccbluex.liquidbounce.file.impl.ClickGuiConfig;
import net.ccbluex.liquidbounce.file.impl.FriendsConfig;
import net.ccbluex.liquidbounce.file.impl.SpecialConfig;
import net.ccbluex.liquidbounce.file.impl.XRayConfig;
import net.ccbluex.liquidbounce.file.misc.BackgroundManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020+J\u001f\u0010-\u001a\u00020+2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u0002000/\"\u000200\u00a2\u0006\u0002\u00101J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u00020+J\u001f\u00105\u001a\u00020+2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u0002000/\"\u000200\u00a2\u0006\u0002\u00101J\u000e\u00106\u001a\u00020+2\u0006\u00103\u001a\u000200J\u0018\u00106\u001a\u00020+2\u0006\u00103\u001a\u0002002\b\b\u0002\u00107\u001a\u000208R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000b\u00a8\u0006:"}, d2={"Lnet/ccbluex/liquidbounce/file/FileManager;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "resourceDir", "", "backgroundManager", "Lnet/ccbluex/liquidbounce/file/misc/BackgroundManager;", "dir", "Ljava/io/File;", "getDir", "()Ljava/io/File;", "fontsDir", "getFontsDir", "configsDir", "getConfigsDir", "soundsDir", "getSoundsDir", "languageDir", "getLanguageDir", "accountsConfig", "Lnet/ccbluex/liquidbounce/file/impl/AccountsConfig;", "getAccountsConfig", "()Lnet/ccbluex/liquidbounce/file/impl/AccountsConfig;", "friendsConfig", "Lnet/ccbluex/liquidbounce/file/impl/FriendsConfig;", "getFriendsConfig", "()Lnet/ccbluex/liquidbounce/file/impl/FriendsConfig;", "xrayConfig", "Lnet/ccbluex/liquidbounce/file/impl/XRayConfig;", "getXrayConfig", "()Lnet/ccbluex/liquidbounce/file/impl/XRayConfig;", "clickGuiConfig", "Lnet/ccbluex/liquidbounce/file/impl/ClickGuiConfig;", "getClickGuiConfig", "()Lnet/ccbluex/liquidbounce/file/impl/ClickGuiConfig;", "specialConfig", "Lnet/ccbluex/liquidbounce/file/impl/SpecialConfig;", "getSpecialConfig", "()Lnet/ccbluex/liquidbounce/file/impl/SpecialConfig;", "backgroundFile", "getBackgroundFile", "setupFolder", "", "loadAllConfigs", "loadConfigs", "configs", "", "Lnet/ccbluex/liquidbounce/file/FileConfig;", "([Lnet/ccbluex/liquidbounce/file/FileConfig;)V", "loadConfig", "config", "saveAllConfigs", "saveConfigs", "saveConfig", "ignoreStarting", "", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFileManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileManager.kt\nnet/ccbluex/liquidbounce/file/FileManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,156:1\n1869#2,2:157\n13472#3,2:159\n13472#3,2:161\n13472#3,2:163\n13472#3,2:165\n*S KotlinDebug\n*F\n+ 1 FileManager.kt\nnet/ccbluex/liquidbounce/file/FileManager\n*L\n49#1:157,2\n58#1:159,2\n76#1:161,2\n101#1:163,2\n119#1:165,2\n*E\n"})
public final class FileManager
extends MinecraftInstance {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final String resourceDir;
    @JvmField
    @NotNull
    public final BackgroundManager backgroundManager = new BackgroundManager(this);
    @NotNull
    private final File dir = new File(MinecraftInstance.mc.getGameDir(), "DarkMeow-1.12");
    @NotNull
    private final File fontsDir = new File(this.dir, "fonts");
    @NotNull
    private final File configsDir = new File(this.dir, "configs");
    @NotNull
    private final File soundsDir = new File(this.dir, "sounds");
    @NotNull
    private final File languageDir = new File(this.dir, "languages");
    @NotNull
    private final AccountsConfig accountsConfig = new AccountsConfig(new File(this.dir, "accounts.json"));
    @NotNull
    private final FriendsConfig friendsConfig = new FriendsConfig(new File(this.dir, "friends.json"));
    @NotNull
    private final XRayConfig xrayConfig = new XRayConfig(new File(this.dir, "xray-blocks.json"));
    @NotNull
    private final ClickGuiConfig clickGuiConfig = new ClickGuiConfig(new File(this.dir, "click-gui.json"));
    @NotNull
    private final SpecialConfig specialConfig = new SpecialConfig(new File(this.dir, "special.json"));
    @NotNull
    private final File backgroundFile = new File(this.dir, "background.png");
    @NotNull
    private static final Gson PRETTY_GSON;

    public FileManager() {
        this.resourceDir = "assets/minecraft/darkmeow";
        this.setupFolder();
        this.backgroundManager.reloadBackground();
    }

    @NotNull
    public final File getDir() {
        return this.dir;
    }

    @NotNull
    public final File getFontsDir() {
        return this.fontsDir;
    }

    @NotNull
    public final File getConfigsDir() {
        return this.configsDir;
    }

    @NotNull
    public final File getSoundsDir() {
        return this.soundsDir;
    }

    @NotNull
    public final File getLanguageDir() {
        return this.languageDir;
    }

    @NotNull
    public final AccountsConfig getAccountsConfig() {
        return this.accountsConfig;
    }

    @NotNull
    public final FriendsConfig getFriendsConfig() {
        return this.friendsConfig;
    }

    @NotNull
    public final XRayConfig getXrayConfig() {
        return this.xrayConfig;
    }

    @NotNull
    public final ClickGuiConfig getClickGuiConfig() {
        return this.clickGuiConfig;
    }

    @NotNull
    public final SpecialConfig getSpecialConfig() {
        return this.specialConfig;
    }

    @NotNull
    public final File getBackgroundFile() {
        return this.backgroundFile;
    }

    private final void setupFolder() {
        File[] fileArray = new File[]{this.dir, this.fontsDir, this.configsDir, this.soundsDir};
        Iterable $this$forEach$iv = CollectionsKt.listOf(fileArray);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            File folder = (File)element$iv;
            boolean bl2 = false;
            if (folder.exists()) continue;
            folder.mkdirs();
        }
    }

    public final void loadAllConfigs() {
        Field[] fieldArray = this.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
        Object[] $this$forEach$iv = fieldArray;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Field field = (Field)element$iv;
            boolean bl2 = false;
            if (!Intrinsics.areEqual(field.getType(), FileConfig.class)) continue;
            try {
                field.setAccessible(true);
                Object object = field.get(this);
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type net.ccbluex.liquidbounce.file.FileConfig");
                FileConfig config = (FileConfig)object;
                this.loadConfig(config);
            }
            catch (IllegalAccessException e2) {
                ClientUtils.INSTANCE.logError("Failed to load config file of field " + field.getName() + '.', e2);
            }
        }
    }

    public final void loadConfigs(FileConfig ... configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        FileConfig[] $this$forEach$iv = configs;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            FileConfig element$iv;
            FileConfig it = element$iv = $this$forEach$iv[i2];
            boolean bl2 = false;
            this.loadConfig(it);
        }
    }

    public final void loadConfig(@NotNull FileConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!config.hasConfig()) {
            ClientUtils.INSTANCE.logInfo("[FileManager] Skipped loading config: " + config.getFile().getName() + '.');
            this.saveConfig(config, true);
            return;
        }
        try {
            config.loadConfig(config.loadConfigFile());
            ClientUtils.INSTANCE.logInfo("[FileManager] Loaded config: " + config.getFile().getName() + '.');
        }
        catch (Throwable t2) {
            ClientUtils.INSTANCE.logError("[FileManager] Failed to load config file: " + config.getFile().getName() + '.', t2);
        }
    }

    public final void saveAllConfigs() {
        Field[] fieldArray = this.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
        Object[] $this$forEach$iv = fieldArray;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Field field = (Field)element$iv;
            boolean bl2 = false;
            try {
                FileConfig config;
                field.setAccessible(true);
                Object object = field.get(this);
                FileConfig fileConfig = config = object instanceof FileConfig ? (FileConfig)object : null;
                if (config == null) continue;
                this.saveConfig(config);
            }
            catch (IllegalAccessException e2) {
                ClientUtils.INSTANCE.logError("[FileManager] Failed to save config file of field " + field.getName() + '.', e2);
            }
        }
    }

    public final void saveConfigs(FileConfig ... configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        FileConfig[] $this$forEach$iv = configs;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            FileConfig element$iv;
            FileConfig it = element$iv = $this$forEach$iv[i2];
            boolean bl2 = false;
            this.saveConfig(it);
        }
    }

    public final void saveConfig(@NotNull FileConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.saveConfig(config, true);
    }

    public final void saveConfig(@NotNull FileConfig config, boolean ignoreStarting) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!ignoreStarting && DarkMeow.isStarting) {
            return;
        }
        try {
            if (!config.hasConfig()) {
                config.createConfig();
            }
            config.saveConfigFile(config.saveConfig());
            ClientUtils.INSTANCE.logInfo("[FileManager] Saved config: " + config.getFile().getName() + '.');
        }
        catch (Throwable t2) {
            ClientUtils.INSTANCE.logError("[FileManager] Failed to save config file: " + config.getFile().getName() + '.', t2);
        }
    }

    public static /* synthetic */ void saveConfig$default(FileManager fileManager, FileConfig fileConfig, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        fileManager.saveConfig(fileConfig, bl2);
    }

    static {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue(gson, "create(...)");
        PRETTY_GSON = gson;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/file/FileManager$Companion;", "", "<init>", "()V", "PRETTY_GSON", "Lcom/google/gson/Gson;", "getPRETTY_GSON", "()Lcom/google/gson/Gson;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Gson getPRETTY_GSON() {
            return PRETTY_GSON;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

