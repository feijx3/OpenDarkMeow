/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event.events.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/CompleteMessageEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "", "", "message", "pos", "Lnet/minecraft/util/math/BlockPos;", "<init>", "(Ljava/lang/String;Lnet/minecraft/util/math/BlockPos;)V", "getMessage", "()Ljava/lang/String;", "getPos", "()Lnet/minecraft/util/math/BlockPos;", "DarkMeow"})
public final class CompleteMessageEvent
extends ChangeValueEvent<String[]> {
    @NotNull
    private final String message;
    @Nullable
    private final BlockPos pos;

    public CompleteMessageEvent(@NotNull String message, @Nullable BlockPos pos) {
        Intrinsics.checkNotNullParameter(message, "message");
        super(null);
        this.message = message;
        this.pos = pos;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final BlockPos getPos() {
        return this.pos;
    }
}

