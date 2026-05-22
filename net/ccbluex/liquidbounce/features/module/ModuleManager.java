/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.exclusive.ModuleExclusiveManager;
import net.ccbluex.liquidbounce.features.module.manager.ModuleKeyBindUpdateManager;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eJ\u0018\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0013H\u0002J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eJ%\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0013\u00a2\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0013H\u0086\u0002\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\u0006\u0010$\u001a\u00020%R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R2\u0010\u0011\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u000e0\u0012j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u000e`\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "isLoadingModules", "", "exclusiveManager", "Lnet/ccbluex/liquidbounce/features/module/exclusive/ModuleExclusiveManager;", "keyBindUpdateManager", "Lnet/ccbluex/liquidbounce/features/module/manager/ModuleKeyBindUpdateManager;", "modules", "Ljava/util/TreeSet;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "getModules", "()Ljava/util/TreeSet;", "moduleClassMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "registerModules", "", "registerModule", "module", "moduleClass", "unregisterModule", "getModule", "T", "(Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;", "get", "clazz", "moduleName", "", "getKeyBind", "", "key", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nModuleManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleManager.kt\nnet/ccbluex/liquidbounce/features/module/ModuleManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1056#2:111\n1869#2,2:112\n774#2:115\n865#2,2:116\n1#3:114\n*S KotlinDebug\n*F\n+ 1 ModuleManager.kt\nnet/ccbluex/liquidbounce/features/module/ModuleManager\n*L\n44#1:111\n45#1:112,2\n108#1:115\n108#1:116,2\n*E\n"})
public final class ModuleManager
extends ManagerBase {
    @JvmField
    public boolean isLoadingModules;
    @JvmField
    @NotNull
    public final ModuleExclusiveManager exclusiveManager;
    @JvmField
    @NotNull
    public final ModuleKeyBindUpdateManager keyBindUpdateManager;
    @NotNull
    private final TreeSet<Module> modules;
    @NotNull
    private final HashMap<Class<?>, Module> moduleClassMap;

    public ModuleManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.exclusiveManager = new ModuleExclusiveManager(this);
        this.keyBindUpdateManager = new ModuleKeyBindUpdateManager(this);
        this.modules = new TreeSet((arg_0, arg_1) -> ModuleManager.modules$lambda$1(ModuleManager::modules$lambda$0, arg_0, arg_1));
        this.moduleClassMap = new HashMap();
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), this.keyBindUpdateManager, false, false, 6, null);
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), this.exclusiveManager, false, false, 6, null);
    }

    @NotNull
    public final TreeSet<Module> getModules() {
        return this.modules;
    }

    public final void registerModules() {
        ClientUtils.logger.info("[ModuleManager] Loading modules...");
        this.exclusiveManager.clearExclusives();
        this.isLoadingModules = true;
        Iterable $this$sortedBy$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".modules", Module.class);
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                Class it = (Class)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getName());
                it = (Class)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Class p0 = (Class)element$iv;
            boolean bl2 = false;
            this.registerModule(p0);
        }
        this.isLoadingModules = false;
        DarkMeow.INSTANCE.getEventManager().sortListener();
        ClientUtils.logger.info("[ModuleManager] Loaded " + this.modules.size() + " modules.");
    }

    public final void registerModule(@NotNull Module module) {
        boolean setLoadingState;
        Intrinsics.checkNotNullParameter(module, "module");
        boolean bl2 = setLoadingState = !this.isLoadingModules;
        if (setLoadingState) {
            this.isLoadingModules = true;
        }
        ((Collection)this.modules).add(module);
        ((Map)this.moduleClassMap).put(module.getClass(), module);
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), module, true, false, 4, null);
        if (setLoadingState) {
            this.isLoadingModules = false;
        }
    }

    private final void registerModule(Class<? extends Module> moduleClass) {
        try {
            Module module = moduleClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNullExpressionValue(module, "newInstance(...)");
            this.registerModule(module);
        }
        catch (IllegalAccessException e2) {
            this.registerModule(ClassUtils.INSTANCE.getObjectInstance(moduleClass));
        }
        catch (Throwable e3) {
            ClientUtils.logger.error("Failed to load module: " + moduleClass.getName() + " (" + e3.getClass().getName() + ": " + e3.getMessage() + ')', e3);
        }
    }

    public final void unregisterModule(@NotNull Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.modules.remove(module);
        this.moduleClassMap.remove(module.getClass());
        DarkMeow.INSTANCE.getEventManager().unregisterListener(module);
    }

    @Nullable
    public final <T extends Module> T getModule(@NotNull Class<T> moduleClass) {
        Intrinsics.checkNotNullParameter(moduleClass, "moduleClass");
        Module module = this.moduleClassMap.get(moduleClass);
        return (T)(module instanceof Module ? module : null);
    }

    @Nullable
    public final <T extends Module> T get(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.getModule(clazz);
    }

    @Nullable
    public final Module getModule(@NotNull String moduleName) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Iterable iterable = this.modules;
            for (Object t2 : iterable) {
                Module it = (Module)t2;
                boolean bl2 = false;
                if (!StringsKt.equals(it.getName(), moduleName, true)) continue;
                v0 = t2;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<Module> getKeyBind(int key) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.modules;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Module it = (Module)element$iv$iv;
            boolean bl2 = false;
            if (!(it.getKeyBind() == key)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final int modules$lambda$0(Module module1, Module module2) {
        return module1.getName().compareTo(module2.getName());
    }

    private static final int modules$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        return ((Number)$tmp0.invoke(p0, p1)).intValue();
    }
}

