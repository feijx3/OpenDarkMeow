/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.RayTraceResult
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AutoBreak", description="Automatically breaks the block you are looking at.", category=ModuleCategory.WORLD)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/AutoBreak;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onDisable", "DarkMeow"})
public final class AutoBreak
extends Module {
    public AutoBreak() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (MinecraftInstance.mc.getObjectMouseOver() == null || MinecraftInstance.mc.getWorld() == null) {
            return;
        }
        KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74312_F;
        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindAttack");
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        Intrinsics.checkNotNull(worldClient);
        RayTraceResult rayTraceResult = MinecraftInstance.mc.getObjectMouseOver();
        Intrinsics.checkNotNull(rayTraceResult);
        ExtendKeyBinding.INSTANCE.setPressed(keyBinding, !Intrinsics.areEqual(worldClient.func_180495_p(rayTraceResult.func_178782_a()).func_177230_c(), Blocks.field_150350_a));
    }

    @Override
    public void onDisable() {
        if (!MinecraftInstance.mc.getGameSettings().field_74312_F.func_151470_d()) {
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74312_F;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindAttack");
            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, false);
        }
    }
}

