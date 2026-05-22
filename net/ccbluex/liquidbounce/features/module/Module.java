/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.events.client.ClientModuleToggleEvent;
import net.ccbluex.liquidbounce.event.events.client.SetModuleKeyBindEvent;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseConfig;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseState;
import net.ccbluex.liquidbounce.handler.message.notification.Notification;
import net.ccbluex.liquidbounce.handler.message.notification.NotificationManager;
import net.ccbluex.liquidbounce.handler.message.notification.NotificationType;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u00020E2\u0006\u00109\u001a\u00020,H\u0017J\b\u0010G\u001a\u00020EH\u0016J\b\u0010H\u001a\u00020EH\u0016J\u0016\u0010I\u001a\b\u0012\u0002\b\u0003\u0018\u00010J2\u0006\u0010K\u001a\u00020\u0004H\u0016J\b\u0010P\u001a\u00020,H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R*\u0010#\u001a\u00020$2\u0006\u0010#\u001a\u00020$8F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,8F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b.\u0010&\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R&\u00109\u001a\u00020,2\u0006\u0010+\u001a\u00020,8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\u001a\u0010<\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001a\u0010?\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\u0016\u0010B\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010\u000eR \u0010L\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030J0M8VX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010O\u00a8\u0006Q"}, d2={"Lnet/ccbluex/liquidbounce/features/module/Module;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "name", "", "category", "Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "baseConfig", "Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig;", "baseState", "Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseState;", "<init>", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig;Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseState;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCategory", "()Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "setCategory", "(Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;)V", "getBaseConfig", "()Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig;", "setBaseConfig", "(Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig;)V", "getBaseState", "()Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseState;", "displayName", "getDisplayName", "setDisplayName", "description", "getDescription", "setDescription", "getModuleDisplayName", "getModuleDescription", "keyBind", "", "getKeyBind$annotations", "()V", "getKeyBind", "()I", "setKeyBind", "(I)V", "value", "", "array", "getArray$annotations", "getArray", "()Z", "setArray", "(Z)V", "slideStep", "", "getSlideStep", "()F", "setSlideStep", "(F)V", "state", "getState", "setState", "slide", "getSlide", "setSlide", "higt", "getHigt", "setHigt", "tag", "getTag", "toggle", "", "onToggle", "onEnable", "onDisable", "getValue", "Lnet/ccbluex/liquidbounce/value/Value;", "valueName", "values", "", "getValues", "()Ljava/util/List;", "handleEvents", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Module.kt\nnet/ccbluex/liquidbounce/features/module/Module\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,175:1\n1#2:176\n*E\n"})
public class Module
extends MinecraftInstance
implements Listenable {
    @NotNull
    private String name;
    @NotNull
    private ModuleCategory category;
    @NotNull
    private ModuleBaseConfig baseConfig;
    @NotNull
    private final ModuleBaseState baseState;
    @Nullable
    private String displayName;
    @Nullable
    private String description;
    private float slideStep;
    private boolean state;
    private float slide;
    private float higt;
    @NotNull
    private final List<Value<?>> values;

    public Module(@NotNull String name, @NotNull ModuleCategory category, @NotNull ModuleBaseConfig baseConfig, @NotNull ModuleBaseState baseState) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter((Object)category, "category");
        Intrinsics.checkNotNullParameter(baseConfig, "baseConfig");
        Intrinsics.checkNotNullParameter(baseState, "baseState");
        this.name = name;
        this.category = category;
        this.baseConfig = baseConfig;
        this.baseState = baseState;
        ModuleInfo moduleInfo = this.getClass().getAnnotation(ModuleInfo.class);
        if (moduleInfo != null) {
            ModuleInfo moduleInfo2;
            ModuleInfo moduleInfo3 = moduleInfo2 = moduleInfo;
            boolean bl2 = false;
            this.name = moduleInfo3.name();
            this.category = moduleInfo3.category();
            this.setKeyBind(moduleInfo3.keyBind());
            this.setArray(moduleInfo3.array());
        }
        this.displayName = DarkMeow.INSTANCE.getLanguageManager().getOrNull("module." + this.name + ".name", new String[0]);
        this.description = DarkMeow.INSTANCE.getLanguageManager().getOrNull("module." + this.name + ".description", new String[0]);
        this.state = this.baseState.getDefaultState();
        this.values = new ArrayList();
    }

    public /* synthetic */ Module(String string, ModuleCategory moduleCategory, ModuleBaseConfig moduleBaseConfig, ModuleBaseState moduleBaseState, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            string = "";
        }
        if ((n2 & 2) != 0) {
            moduleCategory = ModuleCategory.MISC;
        }
        if ((n2 & 4) != 0) {
            moduleBaseConfig = new ModuleBaseConfig(0, null, false, false, 15, null);
        }
        if ((n2 & 8) != 0) {
            moduleBaseState = new ModuleBaseState(false, false, 3, null);
        }
        this(string, moduleCategory, moduleBaseConfig, moduleBaseState);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.name = string;
    }

    @NotNull
    public final ModuleCategory getCategory() {
        return this.category;
    }

    public final void setCategory(@NotNull ModuleCategory moduleCategory) {
        Intrinsics.checkNotNullParameter((Object)moduleCategory, "<set-?>");
        this.category = moduleCategory;
    }

    @NotNull
    public final ModuleBaseConfig getBaseConfig() {
        return this.baseConfig;
    }

    public final void setBaseConfig(@NotNull ModuleBaseConfig moduleBaseConfig) {
        Intrinsics.checkNotNullParameter(moduleBaseConfig, "<set-?>");
        this.baseConfig = moduleBaseConfig;
    }

    @NotNull
    public final ModuleBaseState getBaseState() {
        return this.baseState;
    }

    @Nullable
    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(@Nullable String string) {
        this.displayName = string;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(@Nullable String string) {
        this.description = string;
    }

    @NotNull
    public final String getModuleDisplayName() {
        String string = this.displayName;
        if (string == null) {
            string = this.name;
        }
        return string;
    }

    @NotNull
    public final String getModuleDescription() {
        String string = this.description;
        if (string == null) {
            string = "";
        }
        return string;
    }

    public final int getKeyBind() {
        return this.baseConfig.getKeyBindId();
    }

    public final void setKeyBind(int keyBind) {
        SetModuleKeyBindEvent event = new SetModuleKeyBindEvent(this, keyBind);
        EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), event, null, 2, null);
        if (event.isCancelled()) {
            return;
        }
        this.baseConfig.setKeyBindId(keyBind);
        if (!DarkMeow.isStarting) {
            DarkMeow.INSTANCE.getConfigManager().smartSave();
        }
    }

    @Deprecated(message="baseConfig")
    public static /* synthetic */ void getKeyBind$annotations() {
    }

    public final boolean getArray() {
        return !this.baseConfig.getHide();
    }

    public final void setArray(boolean value) {
        this.baseConfig.setHide(value);
        if (!DarkMeow.isStarting) {
            DarkMeow.INSTANCE.getConfigManager().smartSave();
        }
    }

    @Deprecated(message="baseConfig")
    public static /* synthetic */ void getArray$annotations() {
    }

    public final float getSlideStep() {
        return this.slideStep;
    }

    public final void setSlideStep(float f2) {
        this.slideStep = f2;
    }

    public final boolean getState() {
        return this.state && !DarkMeow.isDestroy;
    }

    public final void setState(boolean value) {
        ClientModuleToggleEvent clientModuleToggleEvent;
        if (this.state == value) {
            return;
        }
        ClientModuleToggleEvent event = clientModuleToggleEvent = new ClientModuleToggleEvent(this, value);
        boolean bl2 = false;
        EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), event, null, 2, null);
        if (event.isCancelled()) {
            return;
        }
        this.onToggle(value);
        if (!DarkMeow.isStarting && this.baseConfig.getNotifyToggle()) {
            NotificationManager.push$default(DarkMeow.INSTANCE.getMessageManager().notificationManager, new Notification("Module", (value ? "Enabled " : "Disabled ") + this.name, value ? NotificationType.SUCCESS : NotificationType.ERROR, 0L, 8, null), false, 2, null);
        }
        if (value) {
            DarkMeow.INSTANCE.getTipSoundManager().getEnableSound().asyncPlay();
            this.onEnable();
            if (!this.baseState.getLockToDefaultState()) {
                this.state = true;
            }
        } else {
            DarkMeow.INSTANCE.getTipSoundManager().getDisableSound().asyncPlay();
            this.onDisable();
            if (!this.baseState.getLockToDefaultState()) {
                this.state = false;
            }
        }
        DarkMeow.INSTANCE.getConfigManager().smartSave();
    }

    public final float getSlide() {
        return this.slide;
    }

    public final void setSlide(float f2) {
        this.slide = f2;
    }

    public final float getHigt() {
        return this.higt;
    }

    public final void setHigt(float f2) {
        this.higt = f2;
    }

    @Nullable
    public String getTag() {
        return null;
    }

    public final void toggle() {
        this.setState(!this.getState());
    }

    @Deprecated(message="\u8ba1\u5212\u5220\u9664")
    public void onToggle(boolean state) {
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    @Nullable
    public Value<?> getValue(@NotNull String valueName) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter(valueName, "valueName");
            Iterable iterable = this.getValues();
            for (Object t2 : iterable) {
                Value it = (Value)t2;
                boolean bl2 = false;
                if (!StringsKt.equals(it.getName(), valueName, true)) continue;
                v0 = t2;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    /*
     * Enabled aggressive block sorting
     */
    @NotNull
    public List<Value<?>> getValues() {
        List list;
        List list2;
        List list3;
        List it = list3 = this.values;
        boolean bl2 = false;
        List list4 = list2 = !DarkMeow.INSTANCE.getModuleManager().isLoadingModules ? list3 : null;
        if (list2 != null) {
            List list5;
            List list6 = list2;
            if (list6.isEmpty()) {
                boolean bl3 = false;
                list5 = CollectionsKt.toMutableList((Collection)ClassUtils.INSTANCE.getValues(this.getClass(), this));
            } else {
                list5 = list6;
            }
            list3 = list5;
            if (list3 != null) {
                list = list3;
                return list;
            }
        }
        list = this.values;
        return list;
    }

    @Override
    public boolean handleEvents() {
        return this.getState();
    }

    public Module() {
        this(null, null, null, null, 15, null);
    }
}

