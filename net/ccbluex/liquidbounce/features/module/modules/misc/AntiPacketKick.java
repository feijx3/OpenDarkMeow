/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.network.NetworkExceptionCaughtEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AntiPacketKick", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AntiPacketKick;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onNetworkExceptionCaught", "", "event", "Lnet/ccbluex/liquidbounce/event/events/network/NetworkExceptionCaughtEvent;", "DarkMeow"})
public final class AntiPacketKick
extends Module {
    @NotNull
    public static final AntiPacketKick INSTANCE = new AntiPacketKick();

    private AntiPacketKick() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onNetworkExceptionCaught(@NotNull NetworkExceptionCaughtEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.cancelEvent();
    }
}

