/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event.events.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/SendMessageEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "message", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;Ljava/lang/String;)V", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "cancelEvent", "", "DarkMeow"})
public final class SendMessageEvent
extends ChangeValueEvent<String> {
    @NotNull
    private final EntityPlayerSP player;

    public SendMessageEvent(@NotNull EntityPlayerSP player, @Nullable String message) {
        Intrinsics.checkNotNullParameter(player, "player");
        super(message);
        this.player = player;
    }

    @NotNull
    public final EntityPlayerSP getPlayer() {
        return this.player;
    }

    public final void cancelEvent() {
        this.setReturnValue(null);
    }
}

