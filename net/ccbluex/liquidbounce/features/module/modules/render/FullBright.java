/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/FullBright;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "reloadWorldValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onEnable", "", "onDisable", "DarkMeow"})
public final class FullBright
extends Module {
    @NotNull
    public static final FullBright INSTANCE = new FullBright();
    @JvmField
    @NotNull
    public static final BoolValue reloadWorldValue = new BoolValue("ReloadWorld", false);

    private FullBright() {
        super("FullBright", ModuleCategory.RENDER, null, null, 12, null);
    }

    @Override
    public void onEnable() {
        if (((Boolean)reloadWorldValue.get()).booleanValue()) {
            MinecraftInstance.mc.getRenderGlobal().func_72712_a();
        }
    }

    @Override
    public void onDisable() {
        if (((Boolean)reloadWorldValue.get()).booleanValue()) {
            MinecraftInstance.mc.getRenderGlobal().func_72712_a();
        }
    }
}

