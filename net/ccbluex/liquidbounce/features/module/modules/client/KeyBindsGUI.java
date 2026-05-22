/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;

@ModuleInfo(name="KeyBindsGUI", category=ModuleCategory.CLIENT, canEnable=false)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/KeyBindsGUI;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onEnable", "", "DarkMeow"})
public final class KeyBindsGUI
extends Module {
    public KeyBindsGUI() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onEnable() {
        MinecraftInstance.mc.displayGuiScreen(DarkMeow.INSTANCE.getKeyBindManager());
    }
}

