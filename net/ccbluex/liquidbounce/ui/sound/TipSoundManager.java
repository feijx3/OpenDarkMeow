/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.sound;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.ui.sound.TipSoundPlayer;
import net.ccbluex.liquidbounce.utils.file.FileUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/ui/sound/TipSoundManager;", "", "<init>", "()V", "enableSound", "Lnet/ccbluex/liquidbounce/ui/sound/TipSoundPlayer;", "getEnableSound", "()Lnet/ccbluex/liquidbounce/ui/sound/TipSoundPlayer;", "setEnableSound", "(Lnet/ccbluex/liquidbounce/ui/sound/TipSoundPlayer;)V", "disableSound", "getDisableSound", "setDisableSound", "DarkMeow"})
public final class TipSoundManager {
    @NotNull
    private TipSoundPlayer enableSound;
    @NotNull
    private TipSoundPlayer disableSound;

    public TipSoundManager() {
        File enableSoundFile = new File(DarkMeow.INSTANCE.getFileManager().getSoundsDir(), "enable.wav");
        File disableSoundFile = new File(DarkMeow.INSTANCE.getFileManager().getSoundsDir(), "disable.wav");
        if (!enableSoundFile.exists()) {
            FileUtils.INSTANCE.unpackResourceFile("assets/minecraft/darknya/sound/enable.wav", enableSoundFile);
        }
        if (!disableSoundFile.exists()) {
            FileUtils.INSTANCE.unpackResourceFile("assets/minecraft/darknya/sound/disable.wav", disableSoundFile);
        }
        this.enableSound = new TipSoundPlayer(enableSoundFile);
        this.disableSound = new TipSoundPlayer(disableSoundFile);
    }

    @NotNull
    public final TipSoundPlayer getEnableSound() {
        return this.enableSound;
    }

    public final void setEnableSound(@NotNull TipSoundPlayer tipSoundPlayer) {
        Intrinsics.checkNotNullParameter(tipSoundPlayer, "<set-?>");
        this.enableSound = tipSoundPlayer;
    }

    @NotNull
    public final TipSoundPlayer getDisableSound() {
        return this.disableSound;
    }

    public final void setDisableSound(@NotNull TipSoundPlayer tipSoundPlayer) {
        Intrinsics.checkNotNullParameter(tipSoundPlayer, "<set-?>");
        this.disableSound = tipSoundPlayer;
    }
}

