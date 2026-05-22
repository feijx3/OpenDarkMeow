/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.modes;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.render.gui.RenderUpdateScreenEvent;
import net.ccbluex.liquidbounce.event.events.tick.TickInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.AutoBlockMode;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/modes/AutoBlockModeNormal;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockMode;", "<init>", "()V", "lastBlocking", "", "onTickInputUpdateKeyboard", "", "event", "Lnet/ccbluex/liquidbounce/event/events/tick/TickInputEvent$UpdateKeyboard;", "onRenderUpdateScreen", "Lnet/ccbluex/liquidbounce/event/events/render/gui/RenderUpdateScreenEvent;", "onTickInputAllowUserInput", "Lnet/ccbluex/liquidbounce/event/events/tick/TickInputEvent$AllowUserInput;", "updateState", "gameSettings", "Lnet/minecraft/client/settings/GameSettings;", "DarkMeow"})
public final class AutoBlockModeNormal
extends AutoBlockMode {
    private boolean lastBlocking;

    public AutoBlockModeNormal() {
        super("Normal");
    }

    @EventTarget
    public final void onTickInputUpdateKeyboard(@NotNull TickInputEvent.UpdateKeyboard event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.updateState(event.getGameSettings());
    }

    @EventTarget
    public final void onRenderUpdateScreen(@NotNull RenderUpdateScreenEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.getPostTasks().add(() -> AutoBlockModeNormal.onRenderUpdateScreen$lambda$0(this, event));
    }

    @EventTarget
    public final void onTickInputAllowUserInput(@NotNull TickInputEvent.AllowUserInput event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!((Boolean)event.getReturnValue()).booleanValue()) {
            GameSettings gameSettings = event.getMc().field_71474_y;
            Intrinsics.checkNotNullExpressionValue(gameSettings, "gameSettings");
            this.updateState(gameSettings);
        }
    }

    private final void updateState(GameSettings gameSettings) {
        if (this.getInstance().canBlock()) {
            KeyBinding keyBinding = gameSettings.field_74313_G;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, true);
            KeyBinding keyBinding2 = gameSettings.field_74313_G;
            Intrinsics.checkNotNullExpressionValue(keyBinding2, "keyBindUseItem");
            ExtendKeyBinding.INSTANCE.setPressTime(keyBinding2, 0);
            this.lastBlocking = true;
        } else if (this.lastBlocking) {
            KeyBinding keyBinding = gameSettings.field_74313_G;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
            ExtendKeyBinding.INSTANCE.unPressKey(keyBinding);
            this.lastBlocking = false;
        }
    }

    private static final void onRenderUpdateScreen$lambda$0(AutoBlockModeNormal this$0, RenderUpdateScreenEvent $event) {
        this$0.updateState($event.getGameSettings());
    }
}

