/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.file.config.ConfigSectionManager;
import net.ccbluex.liquidbounce.file.config.ConfigSetManager;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0016R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/file/config/ConfigManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "sectionManager", "Lnet/ccbluex/liquidbounce/file/config/ConfigSectionManager;", "setManager", "Lnet/ccbluex/liquidbounce/file/config/ConfigSetManager;", "value", "", "currentConfig", "getCurrentConfig", "()Ljava/lang/String;", "setCurrentConfig", "(Ljava/lang/String;)V", "needSave", "", "autoSaveThread", "Ljava/lang/Thread;", "initLoad", "", "load", "name", "save", "smart", "smartSave", "DarkMeow"})
public final class ConfigManager
extends ManagerBase {
    @JvmField
    @NotNull
    public final ConfigSectionManager sectionManager;
    @JvmField
    @NotNull
    public final ConfigSetManager setManager;
    @JvmField
    public boolean needSave;
    @JvmField
    @NotNull
    public final Thread autoSaveThread;

    public ConfigManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.sectionManager = new ConfigSectionManager(this);
        this.setManager = new ConfigSetManager(this);
        this.autoSaveThread = new Thread(() -> ConfigManager.autoSaveThread$lambda$0(this));
    }

    @NotNull
    public final String getCurrentConfig() {
        return this.setManager.currentConfig;
    }

    public final void setCurrentConfig(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.setManager.currentConfig = value;
        this.save(true);
    }

    public final void initLoad() {
        this.setManager.load();
        this.sectionManager.registerAllSections();
        this.sectionManager.loadSectionsFromFile();
        this.autoSaveThread.start();
    }

    public final void load(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.save(false);
        this.setCurrentConfig(name);
        this.sectionManager.loadSectionsFromFile();
    }

    public final void save(boolean smart) {
        if (smart) {
            this.needSave = true;
        } else {
            this.sectionManager.saveSectionsToFile();
            this.setManager.save();
            this.needSave = false;
        }
    }

    public static /* synthetic */ void save$default(ConfigManager configManager, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        configManager.save(bl2);
    }

    public final void smartSave() {
        this.needSave = true;
    }

    private static final void autoSaveThread$lambda$0(ConfigManager this$0) {
        while (!DarkMeow.isDestroy) {
            if (this$0.needSave) {
                this$0.save(false);
            }
            Thread.sleep(5000L);
        }
    }
}

