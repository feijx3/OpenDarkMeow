/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiGameOver
 *  net.minecraft.client.gui.GuiScreen
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.exploit.Ghost;
import net.ccbluex.liquidbounce.injection.access.gui.AccessorGuiGameOver;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AutoRespawn", description="Automatically respawns you after dying.", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoRespawn;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "instantValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class AutoRespawn
extends Module {
    @NotNull
    private final BoolValue instantValue = new BoolValue("Instant", true);

    public AutoRespawn() {
        super(null, null, null, null, 15, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP player = MinecraftInstance.mc.getPlayer();
        if (player == null) return;
        Ghost ghost = DarkMeow.INSTANCE.getModuleManager().get(Ghost.class);
        Intrinsics.checkNotNull(ghost);
        if (ghost.getState()) {
            return;
        }
        if (((Boolean)this.instantValue.get()).booleanValue()) {
            if (!(player.func_110143_aJ() == 0.0f)) {
                if (!player.field_70128_L) return;
            }
            bl2 = true;
        } else {
            if (!(MinecraftInstance.mc.getCurrentScreen() instanceof GuiGameOver)) return;
            GuiScreen guiScreen = MinecraftInstance.mc.getCurrentScreen();
            Intrinsics.checkNotNull(guiScreen);
            if (((AccessorGuiGameOver)guiScreen).getEnableButtonsTimer() < 20) return;
            bl2 = true;
        }
        if (!bl2) return;
        player.func_71004_bE();
        MinecraftInstance.mc.displayGuiScreen(null);
    }
}

