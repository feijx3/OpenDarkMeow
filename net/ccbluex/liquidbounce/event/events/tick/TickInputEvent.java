/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.settings.GameSettings
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event.events.tick;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/tick/TickInputEvent;", "", "<init>", "()V", "AllowUserInput", "UpdateKeyboard", "DarkMeow"})
public final class TickInputEvent {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/event/events/tick/TickInputEvent$AllowUserInput;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "", "mc", "Lnet/minecraft/client/Minecraft;", "currentScreen", "Lnet/minecraft/client/gui/GuiScreen;", "state", "<init>", "(Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/gui/GuiScreen;Z)V", "getMc", "()Lnet/minecraft/client/Minecraft;", "getCurrentScreen", "()Lnet/minecraft/client/gui/GuiScreen;", "DarkMeow"})
    public static final class AllowUserInput
    extends ChangeValueEvent<Boolean> {
        @NotNull
        private final Minecraft mc;
        @Nullable
        private final GuiScreen currentScreen;

        public AllowUserInput(@NotNull Minecraft mc, @Nullable GuiScreen currentScreen, boolean state) {
            Intrinsics.checkNotNullParameter(mc, "mc");
            super(state);
            this.mc = mc;
            this.currentScreen = currentScreen;
        }

        @NotNull
        public final Minecraft getMc() {
            return this.mc;
        }

        @Nullable
        public final GuiScreen getCurrentScreen() {
            return this.currentScreen;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/tick/TickInputEvent$UpdateKeyboard;", "Lnet/ccbluex/liquidbounce/event/Event;", "gameSettings", "Lnet/minecraft/client/settings/GameSettings;", "<init>", "(Lnet/minecraft/client/settings/GameSettings;)V", "getGameSettings", "()Lnet/minecraft/client/settings/GameSettings;", "DarkMeow"})
    public static final class UpdateKeyboard
    extends Event {
        @NotNull
        private final GameSettings gameSettings;

        public UpdateKeyboard(@NotNull GameSettings gameSettings) {
            Intrinsics.checkNotNullParameter(gameSettings, "gameSettings");
            this.gameSettings = gameSettings;
        }

        @NotNull
        public final GameSettings getGameSettings() {
            return this.gameSettings;
        }
    }
}

