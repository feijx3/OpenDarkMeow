/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.sound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/ui/sound/TipSoundPlayer;", "", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "asyncPlay", "", "playSound", "DarkMeow"})
public final class TipSoundPlayer {
    @NotNull
    private final File file;

    public TipSoundPlayer(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
    }

    public final void asyncPlay() {
        new Thread(() -> TipSoundPlayer.asyncPlay$lambda$0(this)).start();
    }

    public final void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (Exception ex2) {
            System.out.println((Object)"Error with playing sound.");
        }
    }

    private static final void asyncPlay$lambda$0(TipSoundPlayer this$0) {
        this$0.playSound();
    }
}

