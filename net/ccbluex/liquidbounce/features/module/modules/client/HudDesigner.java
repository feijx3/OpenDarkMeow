/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseState;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/HudDesigner;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onEnable", "", "DarkMeow"})
public final class HudDesigner
extends Module {
    @NotNull
    public static final HudDesigner INSTANCE = new HudDesigner();

    private HudDesigner() {
        super("HudDesigner", ModuleCategory.CLIENT, null, new ModuleBaseState(false, true), 4, null);
    }

    @Override
    public void onEnable() {
        MinecraftInstance.mc.displayGuiScreen(new GuiHudDesigner());
    }
}

