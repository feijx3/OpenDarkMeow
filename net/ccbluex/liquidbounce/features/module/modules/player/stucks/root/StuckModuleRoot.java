/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.features.module.modules.player.stucks.root;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.StuckModule;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/root/StuckModuleRoot;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/StuckModule;", "<init>", "()V", "isExtendMode", "", "onEnable", "", "onDisable", "DarkMeow"})
public final class StuckModuleRoot
extends StuckModule {
    private boolean isExtendMode;

    public StuckModuleRoot() {
        super("Root", true, false, 4, null);
    }

    @Override
    public void onEnable() {
        this.isExtendMode = !DarkMeow.INSTANCE.getMovementManager().getStuckManager().start();
    }

    @Override
    public void onDisable() {
        if (!this.isExtendMode) {
            DarkMeow.INSTANCE.getMovementManager().getStuckManager().stop();
        }
    }
}

