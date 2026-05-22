/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="JumpReset", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/JumpReset;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class JumpReset
extends Module {
    public JumpReset() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        int n2;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (player.field_70737_aN >= 8) {
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74314_A;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, true);
        }
        boolean bl2 = 7 <= (n2 = player.field_70737_aN) ? n2 <= Integer.MAX_VALUE : false;
        if (bl2) {
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74351_w;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindForward");
            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, true);
        } else {
            boolean bl3 = 4 <= n2 ? n2 < 7 : false;
            if (bl3) {
                KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74314_A;
                Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
                ExtendKeyBinding.INSTANCE.setPressed(keyBinding, false);
                KeyBinding keyBinding2 = MinecraftInstance.mc.getGameSettings().field_74351_w;
                Intrinsics.checkNotNullExpressionValue(keyBinding2, "keyBindForward");
                ExtendKeyBinding.INSTANCE.setPressed(keyBinding2, false);
            } else {
                boolean bl4 = 1 <= n2 ? n2 < 4 : false;
                if (bl4) {
                    KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74351_w;
                    Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindForward");
                    KeyBinding keyBinding3 = MinecraftInstance.mc.getGameSettings().field_74351_w;
                    Intrinsics.checkNotNullExpressionValue(keyBinding3, "keyBindForward");
                    ExtendKeyBinding.INSTANCE.setPressed(keyBinding, KeyUtils.INSTANCE.isKeyDownSystem(keyBinding3));
                    KeyBinding keyBinding4 = MinecraftInstance.mc.getGameSettings().field_74314_A;
                    Intrinsics.checkNotNullExpressionValue(keyBinding4, "keyBindJump");
                    KeyBinding keyBinding5 = MinecraftInstance.mc.getGameSettings().field_74314_A;
                    Intrinsics.checkNotNullExpressionValue(keyBinding5, "keyBindJump");
                    ExtendKeyBinding.INSTANCE.setPressed(keyBinding4, KeyUtils.INSTANCE.isKeyDownSystem(keyBinding5));
                }
            }
        }
    }
}

