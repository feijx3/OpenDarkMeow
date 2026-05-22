/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="NoScoreboard", description="Disables the scoreboard.", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/NoScoreboard;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "DarkMeow"})
public final class NoScoreboard
extends Module {
    @NotNull
    public static final NoScoreboard INSTANCE = new NoScoreboard();

    private NoScoreboard() {
        super(null, null, null, null, 15, null);
    }
}

