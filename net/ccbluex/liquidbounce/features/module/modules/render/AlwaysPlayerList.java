/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AlwaysPlayerList", description="Always display player list", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/AlwaysPlayerList;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onDisable", "DarkMeow"})
public final class AlwaysPlayerList
extends Module {
    public AlwaysPlayerList() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74321_H;
        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindPlayerList");
        ExtendKeyBinding.INSTANCE.setPressed(keyBinding, true);
    }

    @Override
    public void onDisable() {
        KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74321_H;
        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindPlayerList");
        ExtendKeyBinding.INSTANCE.setPressed(keyBinding, MinecraftInstance.mc.getGameSettings().field_74321_H.func_151470_d());
    }
}

