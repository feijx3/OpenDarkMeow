/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.settings.GameSettings
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event.events.render.gui;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/gui/RenderUpdateScreenEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "screen", "Lnet/minecraft/client/gui/GuiScreen;", "gameSettings", "Lnet/minecraft/client/settings/GameSettings;", "postTasks", "", "Ljava/lang/Runnable;", "<init>", "(Lnet/minecraft/client/gui/GuiScreen;Lnet/minecraft/client/settings/GameSettings;Ljava/util/List;)V", "(Lnet/minecraft/client/gui/GuiScreen;Lnet/minecraft/client/settings/GameSettings;)V", "getScreen", "()Lnet/minecraft/client/gui/GuiScreen;", "getGameSettings", "()Lnet/minecraft/client/settings/GameSettings;", "getPostTasks", "()Ljava/util/List;", "DarkMeow"})
public final class RenderUpdateScreenEvent
extends CancellableEvent {
    @Nullable
    private final GuiScreen screen;
    @NotNull
    private final GameSettings gameSettings;
    @NotNull
    private final List<Runnable> postTasks;

    public RenderUpdateScreenEvent(@Nullable GuiScreen screen, @NotNull GameSettings gameSettings, @NotNull List<Runnable> postTasks) {
        Intrinsics.checkNotNullParameter(gameSettings, "gameSettings");
        Intrinsics.checkNotNullParameter(postTasks, "postTasks");
        this.screen = screen;
        this.gameSettings = gameSettings;
        this.postTasks = postTasks;
    }

    @Nullable
    public final GuiScreen getScreen() {
        return this.screen;
    }

    @NotNull
    public final GameSettings getGameSettings() {
        return this.gameSettings;
    }

    @NotNull
    public final List<Runnable> getPostTasks() {
        return this.postTasks;
    }

    public RenderUpdateScreenEvent(@Nullable GuiScreen screen, @NotNull GameSettings gameSettings) {
        Intrinsics.checkNotNullParameter(gameSettings, "gameSettings");
        this(screen, gameSettings, new ArrayList());
    }
}

