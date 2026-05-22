/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.util.MovementInputFromOptions
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.utils.AccessorMovementInputFromOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MovementInputFromOptions;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/ExtendMovementInputFromOptions;", "", "<init>", "()V", "gameSettings", "Lnet/minecraft/client/settings/GameSettings;", "Lnet/minecraft/util/MovementInputFromOptions;", "getGameSettings", "(Lnet/minecraft/util/MovementInputFromOptions;)Lnet/minecraft/client/settings/GameSettings;", "DarkMeow"})
public final class ExtendMovementInputFromOptions {
    @NotNull
    public static final ExtendMovementInputFromOptions INSTANCE = new ExtendMovementInputFromOptions();

    private ExtendMovementInputFromOptions() {
    }

    @NotNull
    public final GameSettings getGameSettings(@NotNull MovementInputFromOptions $this$gameSettings) {
        Intrinsics.checkNotNullParameter($this$gameSettings, "<this>");
        GameSettings gameSettings = ((AccessorMovementInputFromOptions)$this$gameSettings).getGameSettings();
        Intrinsics.checkNotNullExpressionValue(gameSettings, "getGameSettings(...)");
        return gameSettings;
    }
}

