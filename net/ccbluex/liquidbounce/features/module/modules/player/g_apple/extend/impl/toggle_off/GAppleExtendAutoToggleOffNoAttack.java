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
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.ccbluex.liquidbounce.handler.combat.LastAttackInfo;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/toggle_off/GAppleExtendAutoToggleOffNoAttack;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "<init>", "()V", "launchUpdateId", "", "getLaunchUpdateId", "()J", "setLaunchUpdateId", "(J)V", "onEnable", "", "preExecute", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "DarkMeow"})
public final class GAppleExtendAutoToggleOffNoAttack
extends GAppleExtend {
    private long launchUpdateId;

    public GAppleExtendAutoToggleOffNoAttack() {
        super("AutoToggleOffNoAttack", false);
    }

    public final long getLaunchUpdateId() {
        return this.launchUpdateId;
    }

    public final void setLaunchUpdateId(long l2) {
        this.launchUpdateId = l2;
    }

    @Override
    public void onEnable() {
        this.launchUpdateId = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
    }

    @Override
    public boolean preExecute(@NotNull SafeListenerBase $this$preExecute) {
        Intrinsics.checkNotNullParameter($this$preExecute, "<this>");
        long currentUpdateId = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
        if (this.launchUpdateId + (long)20 > currentUpdateId) {
            return true;
        }
        LastAttackInfo lastAttackInfo = DarkMeow.INSTANCE.getCombatManager().getLastAttack();
        if ((lastAttackInfo != null ? lastAttackInfo.getUpdateId() : 0L) + (long)20 > currentUpdateId) {
            return true;
        }
        this.getInstance().setState(false);
        return false;
    }
}

