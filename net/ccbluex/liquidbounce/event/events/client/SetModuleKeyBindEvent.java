/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/client/SetModuleKeyBindEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "module", "Lnet/ccbluex/liquidbounce/features/module/Module;", "key", "", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/Module;I)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/Module;", "getKey", "()I", "DarkMeow"})
public final class SetModuleKeyBindEvent
extends CancellableEvent {
    @NotNull
    private final Module module;
    private final int key;

    public SetModuleKeyBindEvent(@NotNull Module module, int key) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.module = module;
        this.key = key;
    }

    @NotNull
    public final Module getModule() {
        return this.module;
    }

    public final int getKey() {
        return this.key;
    }
}

