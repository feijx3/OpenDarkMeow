/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.toggle_off;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.player.GApple;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/toggle_off/GAppleExtendAutoToggleOffNoGApple;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "<init>", "()V", "preExecute", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "DarkMeow"})
public final class GAppleExtendAutoToggleOffNoGApple
extends GAppleExtend {
    public GAppleExtendAutoToggleOffNoGApple() {
        super("AutoToggleOffNoGApple", false);
    }

    @Override
    public boolean preExecute(@NotNull SafeListenerBase $this$preExecute) {
        Intrinsics.checkNotNullParameter($this$preExecute, "<this>");
        if (GApple.Companion.searchGAppleSlot($this$preExecute.getPlayer()) != null) {
            return true;
        }
        DarkMeow.INSTANCE.getMessageManager().display.displayWarn("\u6ca1\u82f9\u679c");
        this.getInstance().setState(false);
        return false;
    }
}

