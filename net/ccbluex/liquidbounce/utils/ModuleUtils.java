/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0007J \u0010\t\u001a\u00020\n2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0018\u0010\f\u001a\u00020\n2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0007\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/utils/ModuleUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "getModuleState", "", "moduleClass", "Ljava/lang/Class;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "setModuleState", "", "state", "toggleModuleState", "DarkMeow"})
public final class ModuleUtils
extends MinecraftInstance {
    @NotNull
    public static final ModuleUtils INSTANCE = new ModuleUtils();

    private ModuleUtils() {
    }

    @JvmStatic
    public static final boolean getModuleState(@NotNull Class<? extends Module> moduleClass) {
        Intrinsics.checkNotNullParameter(moduleClass, "moduleClass");
        Module module = DarkMeow.INSTANCE.getModuleManager().get(moduleClass);
        return module != null ? module.getState() : false;
    }

    @JvmStatic
    public static final void setModuleState(@NotNull Class<? extends Module> moduleClass, boolean state) {
        block0: {
            Intrinsics.checkNotNullParameter(moduleClass, "moduleClass");
            Module module = DarkMeow.INSTANCE.getModuleManager().get(moduleClass);
            if (module == null) break block0;
            module.setState(state);
        }
    }

    @JvmStatic
    public static final void toggleModuleState(@NotNull Class<? extends Module> moduleClass) {
        block0: {
            Intrinsics.checkNotNullParameter(moduleClass, "moduleClass");
            Module module = DarkMeow.INSTANCE.getModuleManager().get(moduleClass);
            if (module == null) break block0;
            Module module2 = DarkMeow.INSTANCE.getModuleManager().get(moduleClass);
            module.setState(!(module2 != null ? module2.getState() : false));
        }
    }
}

